/*
* Catroid: An on-device visual programming system for Android devices
* Copyright (C) 2010-2015 The Catrobat Team
* (<http://developer.catrobat.org/credits>)
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* An additional term exception under section 7 of the GNU Affero
* General Public License, version 3, is available at
* http://developer.catrobat.org/license_additional_term
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
package org.catrobat.catroid.uitest.ui.activity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build;

import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.R;
import org.catrobat.catroid.common.Constants;
import org.catrobat.catroid.common.SoundInfo;
import org.catrobat.catroid.pocketmusic.PocketMusicActivity;
import org.catrobat.catroid.soundrecorder.RecordButton;
import org.catrobat.catroid.soundrecorder.SoundRecorder;
import org.catrobat.catroid.soundrecorder.SoundRecorderActivity;
import org.catrobat.catroid.ui.MainMenuActivity;
import org.catrobat.catroid.ui.ScriptActivity;
import org.catrobat.catroid.uitest.util.BaseActivityInstrumentationTestCase;
import org.catrobat.catroid.uitest.util.UiTestUtils;
import org.catrobat.catroid.utils.Utils;

import java.io.File;
import java.util.ArrayList;

public class PocketMusicTest extends BaseActivityInstrumentationTestCase<MainMenuActivity> {


	public PocketMusicTest() {
		super(MainMenuActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		UiTestUtils.createTestProject();

		UiTestUtils.getIntoSoundsFromMainMenu(solo);
	}

	public void testOrientation() throws NameNotFoundException {
		prepareTest();
		solo.waitForActivity(PocketMusicActivity.class.getSimpleName());
		/// Method 1: Assert it is currently in portrait mode.
		assertEquals("PocketcodeActivity not in Portrait mode!", Configuration.ORIENTATION_PORTRAIT, solo
				.getCurrentActivity().getResources().getConfiguration().orientation);

		/// Method 2: Retreive info about Activity as collected from AndroidManifest.xml
		// https://developer.android.com/reference/android/content/pm/ActivityInfo.html
		PackageManager packageManager = solo.getCurrentActivity().getPackageManager();
		ActivityInfo activityInfo = packageManager.getActivityInfo(solo.getCurrentActivity().getComponentName(),
				PackageManager.GET_ACTIVITIES);

		// Note that the activity is _indeed_ rotated on your device/emulator!
		// Robotium can _force_ the activity to be in landscape mode (and so could we, programmatically)
		solo.setActivityOrientation(Solo.LANDSCAPE);
		solo.sleep(200);

		assertEquals(SoundRecorderActivity.class.getSimpleName()
						+ " not set to be in portrait mode in AndroidManifest.xml!", ActivityInfo.SCREEN_ORIENTATION_PORTRAIT,
				activityInfo.screenOrientation
		);
	}

	private void prepareTest() {
		UiTestUtils.waitForFragment(solo, R.id.fragment_sound);

		UiTestUtils.clickOnBottomBar(solo, R.id.button_add);
		String pocketRecorderText = solo.getString(R.string.add_sound_pocketmusic);

		solo.waitForText(pocketRecorderText);
		assertTrue("Pocketmusic is not present", solo.searchText(pocketRecorderText));
		solo.clickOnText(pocketRecorderText);
	}
}