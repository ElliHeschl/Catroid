package org.catrobat.catroid.test.pocketmusic.note;

import android.test.AndroidTestCase;

import org.catrobat.catroid.pocketmusic.note.MusicalBeat;

/**
 * Created by Elli on 06.11.15.
 */
public class MusicalBeatTest extends AndroidTestCase {

	public void testConvertToMusicalBeat1() {
		MusicalBeat musicalBeat = MusicalBeat.convertToMusicalBeat(16, 16);

		assertTrue(MusicalBeat.BEAT_16_16.equals(musicalBeat));
	}

	public void testConvertToMusicalBeat2() {
		MusicalBeat musicalBeat = MusicalBeat.convertToMusicalBeat(7, 7);

		assertTrue(MusicalBeat.BEAT_4_4.equals(musicalBeat));
	}
}
