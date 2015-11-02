package org.catrobat.catroid.test.pocketmusic.note.trackgrid;

import android.test.AndroidTestCase;

import org.catrobat.catroid.pocketmusic.note.Project;
import org.catrobat.catroid.pocketmusic.note.Track;
import org.catrobat.catroid.pocketmusic.note.trackgrid.TrackGrid;
import org.catrobat.catroid.pocketmusic.note.trackgrid.TrackToTrackGridConverter;
import org.catrobat.catroid.test.pocketmusic.note.TrackTestDataFactory;

/**
 * Created by Elli on 26.10.15.
 */
public class TrackToTrackGridConverterTest extends AndroidTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testConvertTrack1() {
		TrackToTrackGridConverter converter = new TrackToTrackGridConverter();
		Track track = TrackTestDataFactory.createSimpleTrack();
		TrackGrid simpleTrackGrid = TrackGridTestDataFactory.createSimpleTrackGrid();

		TrackGrid convertedTrackGrid = converter.convertTrackToTrackGrid(track, Project.DEFAULT_BEATS_PER_MINUTE);

		assertTrue(convertedTrackGrid.equals(simpleTrackGrid));
	}

	public void testConvertTrack2() {
		TrackToTrackGridConverter converter = new TrackToTrackGridConverter();
		Track track = TrackTestDataFactory.createTrackWithSeveralBreaks();
		TrackGrid trackWithSeveralBreaks = TrackGridTestDataFactory.createTrackGridWithSeveralBreaks();


		TrackGrid convertedTrackGrid = converter.convertTrackToTrackGrid(track, Project.DEFAULT_BEATS_PER_MINUTE);

		assertTrue(convertedTrackGrid.equals(trackWithSeveralBreaks));
	}
//
//	public void testConvertTrackAccord() {
//		TrackToSymbolContainerConverter converter = new TrackToSymbolContainerConverter();
//		Track track = TrackTestDataFactory.createTrackWithAccords();
//		SymbolContainer symbolContainer = SymbolContainerTestDataFactory.createSymbolsWithAccords();
//
//		assertEquals(symbolContainer, converter.convertTrack(track, Project.DEFAULT_BEATS_PER_MINUTE));
//	}


}
