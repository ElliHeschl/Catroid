package org.catrobat.catroid.pocketmusic.note.trackgrid;

import org.catrobat.catroid.pocketmusic.note.MusicalBeat;
import org.catrobat.catroid.pocketmusic.note.MusicalInstrument;
import org.catrobat.catroid.pocketmusic.note.MusicalKey;

import java.util.List;

/**
 * Created by Elli on 26.10.15.
 */
public class TrackGrid {

	private final MusicalKey key;
	private final MusicalInstrument instrument;
	private final MusicalBeat beat;
	private final List<GridRow> gridRows;

	public TrackGrid(MusicalKey key, MusicalInstrument instrument, MusicalBeat beat, List<GridRow> gridRows) {
		this.key = key;
		this.instrument = instrument;
		this.beat = beat;
		this.gridRows = gridRows;
	}

	public MusicalKey getKey() {
		return key;
	}

	public MusicalInstrument getInstrument() {
		return instrument;
	}

	public MusicalBeat getBeat() {
		return beat;
	}

	public List<GridRow> getGridRows() {
		return gridRows;
	}

	@Override
	public boolean equals(Object o) {
		TrackGrid reference = (TrackGrid)o;
		return reference.gridRows.containsAll(gridRows) &&
				gridRows.containsAll(reference.gridRows) &&
				reference.beat.equals(beat) &&
				reference.instrument.equals(instrument) &&
				reference.key.equals(key);
	}
}
