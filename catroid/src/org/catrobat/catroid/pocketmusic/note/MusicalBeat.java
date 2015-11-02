package org.catrobat.catroid.pocketmusic.note;

/**
 * Created by Elli on 26.10.15.
 */
public enum MusicalBeat {
	BEAT_3_4(3, NoteLength.QUARTER), BEAT_4_4(4, NoteLength.QUARTER), BEAT_16_16(16,NoteLength.SIXTEENTH);

	private final int innerBeatCount;
	private final NoteLength noteLength;

	private MusicalBeat(int innerBeatCount, NoteLength noteLength) {
		this.innerBeatCount = innerBeatCount;
		this.noteLength = noteLength;
	}

	public int getInnerBeatCount() {
		return innerBeatCount;
	}

	public NoteLength getNoteLength() {
		return noteLength;
	}
}
