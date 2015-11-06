/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2015 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.pocketmusic.note.trackgrid;

import com.google.common.collect.Lists;

import org.catrobat.catroid.pocketmusic.note.MusicalBeat;
import org.catrobat.catroid.pocketmusic.note.NoteEvent;
import org.catrobat.catroid.pocketmusic.note.NoteLength;
import org.catrobat.catroid.pocketmusic.note.NoteName;
import org.catrobat.catroid.pocketmusic.note.Track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrackToTrackGridConverter {


	public TrackToTrackGridConverter() {
	}

	public TrackGrid convertTrackToTrackGrid(Track track, MusicalBeat beat, int beatsPerMinute) {

		Map<NoteName, Long> openNotes_ = new HashMap<NoteName, Long>();
		Map<NoteName, GridRow> gridRows_ = new HashMap<NoteName, GridRow>();

		NoteLength minNoteLength = beat.getNoteLength();

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

		return new TrackGrid(track.getKey(), track.getInstrument(), beat, new ArrayList(gridRows_.values()));
	}

}
