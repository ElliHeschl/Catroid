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

	public TrackGrid converTrackToTrackGrid(Track track, int beatsPerMinute) {

		Map<NoteName, Long> openNotes_ = new HashMap<NoteName, Long>();
		Map<NoteName, GridRow> gridRows_ = new HashMap<NoteName, GridRow>();
		long lastTick_ = 0;
		NoteLength minNoteLength = NoteLength.WHOLE_DOT;

		for (Long tick : track.getSortedTicks()) {
			for (NoteEvent noteEvent : track.getNoteEventsForTick(tick)) {
				NoteName noteName = noteEvent.getNoteName();

				if (noteEvent.isNoteOn()) {
					lastTick_ = tick;
					openNotes_.put(noteName, tick);
				} else {
					long openTick = openNotes_.get(noteName);
					NoteLength length = NoteLength.getNoteLengthFromTickDuration(tick - openTick, beatsPerMinute);

					if(length.toMilliseconds(beatsPerMinute) < minNoteLength.toMilliseconds(beatsPerMinute)) {
						minNoteLength = length;
					}


					GridRowPosition gridRowPosition = new GridRowPosition(openTick, length);

					if(!gridRows_.containsKey(noteName)) {
						gridRows_.put(noteName, new GridRow(noteName, new ArrayList<GridRowPosition>()));
					}

					gridRows_.get(noteName).getGridRowPositions().add(gridRowPosition);
				}
			}
		}

		for(GridRow gridRow : gridRows_.values()) {
			for(GridRowPosition gridRowPosition : gridRow.getGridRowPositions()) {
				gridRowPosition.setColumnStartIndex((int) (gridRowPosition.getStartTicksInTrack() /
						minNoteLength.toTicks(beatsPerMinute)));
			}
		}

		return new TrackGrid(track.getKey(), track.getInstrument(), track.getBeat(), new ArrayList(gridRows_.values()));
	}

}
