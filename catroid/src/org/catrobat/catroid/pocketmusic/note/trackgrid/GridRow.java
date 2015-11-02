package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.NoteName;

import java.util.List;

/**
 * Created by Elli on 26.10.15.
 */
public class GridRow {

	private final NoteName noteName;
	private final List<GridRowPosition> gridRowPositions;

	public GridRow(NoteName noteName, List<GridRowPosition> gridRowPositions) {
		this.noteName = noteName;
		this.gridRowPositions = gridRowPositions;
	}

	public NoteName getNoteName() {
		return noteName;
	}

	public List<GridRowPosition> getGridRowPositions() {
		return gridRowPositions;
	}

	@Override
	public boolean equals(Object o) {
		GridRow reference = (GridRow)o;
		return reference.noteName.equals(noteName) &&
				reference.gridRowPositions.containsAll(gridRowPositions) &&
				gridRowPositions.containsAll(reference.gridRowPositions);
	}
}
