package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.NoteLength;

/**
 * Created by Elli on 26.10.15.
 */
public class GridRowPosition {

	private int columnStartIndex_;
	private final long startTicksInTrack_;
	private final NoteLength noteLength_;

	public GridRowPosition(long startTicksInTrack, NoteLength noteLength) {
		this.startTicksInTrack_ = startTicksInTrack;
		this.noteLength_ = noteLength;
	}

	public int getColumnStartIndex() {
		return columnStartIndex_;
	}

	public NoteLength getNoteLength() {
		return noteLength_;
	}

	public void setColumnStartIndex(int columnStartIndex) {
		this.columnStartIndex_ = columnStartIndex;
	}

	public long getStartTicksInTrack() {
		return startTicksInTrack_;
	}

	@Override
	public boolean equals(Object o) {
		GridRowPosition reference = (GridRowPosition)o;
		return reference.columnStartIndex_ == columnStartIndex_ &&
				reference.startTicksInTrack_ == startTicksInTrack_ &&
				reference.noteLength_.equals(noteLength_);
	}
}
