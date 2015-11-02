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
		TrackGrid simpleTrackGrid = TrackGridTestDataFactory.createSimpleTracKGrid();

		TrackGrid convertedTrackGrid = converter.converTrackToTrackGrid(track, Project.DEFAULT_BEATS_PER_MINUTE);

		assertTrue(convertedTrackGrid.equals(simpleTrackGrid));
	}

//	public void testConvertTrack2() {
//		TrackToSymbolContainerConverter converter = new TrackToSymbolContainerConverter();
//		Track track = TrackTestDataFactory.createTrackWithSeveralBreaks();
//		SymbolContainer symbolContainer = SymbolContainerTestDataFactory.createSymbolsWithSeveralBreaks();
//
//		assertEquals(symbolContainer, converter.convertTrack(track, Project.DEFAULT_BEATS_PER_MINUTE));
//	}
//
//	public void testConvertTrackAccord() {
//		TrackToSymbolContainerConverter converter = new TrackToSymbolContainerConverter();
//		Track track = TrackTestDataFactory.createTrackWithAccords();
//		SymbolContainer symbolContainer = SymbolContainerTestDataFactory.createSymbolsWithAccords();
//
//		assertEquals(symbolContainer, converter.convertTrack(track, Project.DEFAULT_BEATS_PER_MINUTE));
//	}


}
