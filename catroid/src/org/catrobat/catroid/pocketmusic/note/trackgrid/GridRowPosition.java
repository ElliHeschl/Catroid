package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.NoteLength;

/**
 * Created by Elli on 26.10.15.
 */
public class GridRowPosition {

	private int columnStartIndex;
	private final long startTicksInTrack;
	private final NoteLength noteLength;

	public GridRowPosition(int columnStartIndex, long startTicksInTrack, NoteLength noteLength) {
		this.columnStartIndex = columnStartIndex;
		this.startTicksInTrack = startTicksInTrack;
		this.noteLength = noteLength;
	}

	public int getColumnStartIndex() {
		return columnStartIndex;
	}

	public NoteLength getNoteLength() {
		return noteLength;
	}

	public void setColumnStartIndex(int columnStartIndex) {
		this.columnStartIndex = columnStartIndex;
	}

	public long getStartTicksInTrack() {
		return startTicksInTrack;
	}

	@Override
	public boolean equals(Object o) {
		GridRowPosition reference = (GridRowPosition)o;
		return reference.columnStartIndex == columnStartIndex &&
				reference.startTicksInTrack == startTicksInTrack &&
				reference.noteLength.equals(noteLength);
	}
}
