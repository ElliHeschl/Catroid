package org.catrobat.catroid.pocketmusic.note;

/**
 * Created by Elli on 26.10.15.
 */
public enum MusicalBeat {
	BEAT_3_4(3, 4, NoteLength.QUARTER), BEAT_4_4(4, 4, NoteLength.QUARTER), BEAT_16_16(16, 16, NoteLength.SIXTEENTH);

	// TODO find good names for inner- and outerBeatCount
	private final int topNumber;
	private final int bottomNumber;
	private final NoteLength noteLength;

	private MusicalBeat(int topNumnber, int bottomNumber, NoteLength noteLength) {
		this.topNumber = topNumnber;
		this.bottomNumber = bottomNumber;
		this.noteLength = noteLength;
	}

	public int getTopNumber() {
		return topNumber;
	}

	public int getBottomNumber() {
		return bottomNumber;
	}

	public NoteLength getNoteLength() {
		return noteLength;
	}

	// TODO midi to project converter (and other way around) tests
	// TODO Project tests for musicalBeat (equals, copy, ...)
	// TODO test me
	public static MusicalBeat convertToMusicalBeat(int topNumber, int bottomNumber) {
		for (MusicalBeat beat : MusicalBeat.values()) {
			if (beat.getTopNumber() == topNumber && beat.getBottomNumber() == bottomNumber) {
				return beat;
			}
		}

		return MusicalBeat.BEAT_4_4;
	}
}
