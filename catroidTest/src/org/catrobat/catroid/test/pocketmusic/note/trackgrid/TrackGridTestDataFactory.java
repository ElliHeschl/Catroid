package org.catrobat.catroid.test.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.MusicalBeat;
import org.catrobat.catroid.pocketmusic.note.MusicalInstrument;
import org.catrobat.catroid.pocketmusic.note.MusicalKey;
import org.catrobat.catroid.pocketmusic.note.NoteLength;
import org.catrobat.catroid.pocketmusic.note.NoteName;
import org.catrobat.catroid.pocketmusic.note.Project;
import org.catrobat.catroid.pocketmusic.note.trackgrid.GridRow;
import org.catrobat.catroid.pocketmusic.note.trackgrid.GridRowPosition;
import org.catrobat.catroid.pocketmusic.note.trackgrid.TrackGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elli on 26.10.15.
 */
public class TrackGridTestDataFactory {

	public static TrackGrid createSimpleTrackGrid() {

		List<GridRow> gridRows = new ArrayList<GridRow>();
		List<GridRowPosition> gridRowPositionsC4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPosition = new GridRowPosition(0, 0, NoteLength.QUARTER);
		gridRowPositionsC4.add(gridRowPosition);
		GridRowPosition gridRowPosition1 = new GridRowPosition(3, NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*3, NoteLength.QUARTER);
		gridRowPositionsC4.add(gridRowPosition1);


		List<GridRowPosition> gridRowPositionF4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionF4_1 = new GridRowPosition(2, NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*2, NoteLength.QUARTER);
		gridRowPositionF4.add(gridRowPositionF4_1);

		List<GridRowPosition> gridRowPositionE4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionE4_1 = new GridRowPosition(1, NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE), NoteLength.QUARTER);
		gridRowPositionE4.add(gridRowPositionE4_1);

		List<GridRowPosition> gridRowPositionC5 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionC5_1 = new GridRowPosition(4, NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*4, NoteLength.QUARTER);
		gridRowPositionC5.add(gridRowPositionC5_1);

		gridRows.add(new GridRow(NoteName.C4, gridRowPositionsC4));
		gridRows.add(new GridRow(NoteName.E4, gridRowPositionE4));
		gridRows.add(new GridRow(NoteName.F4, gridRowPositionF4));
		gridRows.add(new GridRow(NoteName.C5, gridRowPositionC5));

		TrackGrid trackGrid = new TrackGrid(MusicalKey.VIOLIN, MusicalInstrument.ACOUSTIC_GRAND_PIANO, MusicalBeat
				.BEAT_4_4, gridRows);

		return trackGrid;
	}

	public static TrackGrid createTrackGridWithSeveralBreaks() {

		List<GridRow> gridRows = new ArrayList<GridRow>();
		List<GridRowPosition> gridRowPositionsC4 = new ArrayList<GridRowPosition>();

		GridRowPosition gridRowPosition1 = new GridRowPosition(9, NoteLength.SIXTEENTH.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)+ NoteLength.HALF.toTicks(Project.DEFAULT_BEATS_PER_MINUTE),
				NoteLength.QUARTER);
		gridRowPosition1.setColumnStartIndex(9);
		gridRowPositionsC4.add(gridRowPosition1);

		gridRows.add(new GridRow(NoteName.C4, gridRowPositionsC4));


		TrackGrid trackGrid = new TrackGrid(MusicalKey.VIOLIN, MusicalInstrument.ACOUSTIC_GRAND_PIANO, MusicalBeat
				.BEAT_16_16, gridRows);

		return trackGrid;
	}


}
