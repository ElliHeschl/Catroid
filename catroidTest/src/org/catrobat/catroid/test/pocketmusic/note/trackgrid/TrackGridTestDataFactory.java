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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
