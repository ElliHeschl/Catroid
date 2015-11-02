package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.MusicalBeat;
import org.catrobat.catroid.pocketmusic.note.MusicalInstrument;
import org.catrobat.catroid.pocketmusic.note.MusicalKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elli on 26.10.15.
 */
public class TrackGrid {

	private final MusicalKey key_;
	private final MusicalInstrument instrument_;
	private final MusicalBeat beat_;
	private final List<GridRow> gridRows_;

	public TrackGrid(MusicalKey key, MusicalInstrument instrument, MusicalBeat beat, List<GridRow> gridRows) {
		this.key_ = key;
		this.instrument_ = instrument;
		this.beat_ = beat;
		this.gridRows_ = gridRows;
	}

	public MusicalKey getKey() {
		return key_;
	}

	public MusicalInstrument getInstrument() {
		return instrument_;
	}

	public MusicalBeat getBeat() {
		return beat_;
	}

	public List<GridRow> getGridRows() {
		return gridRows_;
	}

	@Override
	public boolean equals(Object o) {
		TrackGrid reference = (TrackGrid)o;
		return reference.gridRows_.containsAll(gridRows_) &&
				gridRows_.containsAll(reference.gridRows_) &&
				reference.beat_.equals(beat_) &&
				reference.instrument_.equals(instrument_) &&
				reference.key_.equals(key_);
	}
}
