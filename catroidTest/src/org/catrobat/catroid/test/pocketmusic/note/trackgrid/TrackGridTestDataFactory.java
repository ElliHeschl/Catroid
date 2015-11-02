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

	public static TrackGrid createSimpleTracKGrid() {

		List<GridRow> gridRows = new ArrayList<GridRow>();
		List<GridRowPosition> gridRowPositionsC4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPosition = new GridRowPosition(0, NoteLength.QUARTER);
		gridRowPosition.setColumnStartIndex(0);
		gridRowPositionsC4.add(gridRowPosition);
		GridRowPosition gridRowPosition1 = new GridRowPosition(NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*3, NoteLength.QUARTER);
		gridRowPosition1.setColumnStartIndex(3);
		gridRowPositionsC4.add(gridRowPosition1);


		List<GridRowPosition> gridRowPositionF4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionF4_1 = new GridRowPosition(NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*2, NoteLength.QUARTER);
		gridRowPositionF4_1.setColumnStartIndex(2);
		gridRowPositionF4.add(gridRowPositionF4_1);

		List<GridRowPosition> gridRowPositionE4 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionE4_1 = new GridRowPosition(NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE), NoteLength.QUARTER);
		gridRowPositionE4_1.setColumnStartIndex(1);
		gridRowPositionE4.add(gridRowPositionE4_1);

		List<GridRowPosition> gridRowPositionC5 = new ArrayList<GridRowPosition>();
		GridRowPosition gridRowPositionC5_1 = new GridRowPosition(NoteLength.QUARTER.toTicks(Project
				.DEFAULT_BEATS_PER_MINUTE)*4, NoteLength.QUARTER);
		gridRowPositionC5_1.setColumnStartIndex(4);
		gridRowPositionC5.add(gridRowPositionC5_1);

		gridRows.add(new GridRow(NoteName.C4, gridRowPositionsC4));
		gridRows.add(new GridRow(NoteName.E4, gridRowPositionE4));
		gridRows.add(new GridRow(NoteName.F4, gridRowPositionF4));
		gridRows.add(new GridRow(NoteName.C5, gridRowPositionC5));

		TrackGrid trackGrid = new TrackGrid(MusicalKey.VIOLIN, MusicalInstrument.ACOUSTIC_GRAND_PIANO, MusicalBeat
				.BEAT_4_4, gridRows);

		return trackGrid;
	}

}
