package org.catrobat.catroid.pocketmusic.note.trackgrid;

import com.google.common.collect.Lists;

import org.catrobat.catroid.pocketmusic.note.NoteEvent;
import org.catrobat.catroid.pocketmusic.note.NoteLength;
import org.catrobat.catroid.pocketmusic.note.NoteName;
import org.catrobat.catroid.pocketmusic.note.Track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elli on 26.10.15.
 */
public class TrackToTrackGridConverter {


	public TrackToTrackGridConverter() {
	}

	public TrackGrid convertTrackToTrackGrid(Track track, int beatsPerMinute) {

		Map<NoteName, Long> openNotes_ = new HashMap<NoteName, Long>();
		Map<NoteName, GridRow> gridRows_ = new HashMap<NoteName, GridRow>();

		NoteLength minNoteLength = track.getBeat().getNoteLength();

		for (Long tick : track.getSortedTicks()) {
			for (NoteEvent noteEvent : track.getNoteEventsForTick(tick)) {
				NoteName noteName = noteEvent.getNoteName();

				if (noteEvent.isNoteOn()) {
					openNotes_.put(noteName, tick);
				} else {
					long openTick = openNotes_.get(noteName);
					NoteLength length = NoteLength.getNoteLengthFromTickDuration(tick - openTick, beatsPerMinute);

					GridRowPosition gridRowPosition = new GridRowPosition((int) (openTick /
							minNoteLength.toTicks(beatsPerMinute)), openTick, length);

					if(!gridRows_.containsKey(noteName)) {
						gridRows_.put(noteName, new GridRow(noteName, new ArrayList<GridRowPosition>()));
					}

					gridRows_.get(noteName).getGridRowPositions().add(gridRowPosition);
				}
			}
		}

		return new TrackGrid(track.getKey(), track.getInstrument(), track.getBeat(), new ArrayList(gridRows_.values()));
	}

}
