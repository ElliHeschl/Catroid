package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.NoteName;

import java.util.List;

/**
 * Created by Elli on 26.10.15.
 */
public class GridRow {

	private final NoteName noteName_;
	private final List<GridRowPosition> gridRowPositions_;

	public GridRow(NoteName noteName, List<GridRowPosition> gridRowPositions) {
		this.noteName_ = noteName;
		this.gridRowPositions_ = gridRowPositions;
	}

	public NoteName getNoteName() {
		return noteName_;
	}

	public List<GridRowPosition> getGridRowPositions() {
		return gridRowPositions_;
	}

	@Override
	public boolean equals(Object o) {
		GridRow reference = (GridRow)o;
		return reference.noteName_.equals(noteName_) &&
				reference.gridRowPositions_.containsAll(gridRowPositions_) &&
				gridRowPositions_.containsAll(reference.gridRowPositions_);
	}
}
