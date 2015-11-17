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

import org.catrobat.catroid.pocketmusic.note.NoteName;

import java.util.List;
import java.util.Map;

public class GridRow {

	private final NoteName noteName;
	private final Map<Integer, List<GridRowPosition>> gridRowPositions;

	public GridRow(NoteName noteName, Map<Integer, List<GridRowPosition>> gridRowPositions) {
		this.noteName = noteName;
		this.gridRowPositions = gridRowPositions;
	}

	public NoteName getNoteName() {
		return noteName;
	}

	public Map<Integer, List<GridRowPosition>> getGridRowPositions() {
		return gridRowPositions;
	}

	@Override
	public boolean equals(Object o) {
		GridRow reference = (GridRow) o;
		if (!reference.getGridRowPositions().keySet().containsAll(getGridRowPositions().keySet()) ||
				!getGridRowPositions().keySet().containsAll(reference.getGridRowPositions().keySet())) {
			return false;
		}
		for (Integer i : reference.getGridRowPositions().keySet()) {
			if (!reference.getGridRowPositions().get(i).containsAll(getGridRowPositions().get(i))) {
				return false;
			}
			if (!getGridRowPositions().get(i).containsAll(reference.getGridRowPositions().get(i))) {
				return false;
			}
		}
		return reference.noteName.equals(noteName);
	}
}
