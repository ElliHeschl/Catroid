package org.catrobat.catroid.pocketmusic.note;

/**
 * Created by Elli on 26.10.15.
 */
public enum MusicalBeat {
	BEAT_3_4(3,4), BEAT_4_4(4,4);

	private final int innerBeatCount_;
	private final int noteLength_;

	private MusicalBeat(int innerBeatCount, int noteLength) {
		this.innerBeatCount_ = innerBeatCount;
		this.noteLength_ = noteLength;
	}

	public int getInnerBeatCount() {
		return innerBeatCount_;
	}

	public int getNoteLength() {
		return noteLength_;
	}
}
