/*
 * Copyright (C) 2017 merlin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.veraty.elytrawars.database.async;

import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.UniversalDocuments;
import de.veraty.elytrawars.database.UniversalFilter;
import lombok.AllArgsConstructor;

/**
 * Runnable that writes the given data to the database.
 *
 * @author merlin merlin
 */
@AllArgsConstructor
public class WritingRunnable implements Runnable {

    private final Database database;
    private final boolean insert;
    private final UniversalFilter filter;
    private final UniversalDocuments documents;

    @Override
    public void run() {
        if (insert) {
            database.insert(filter, documents);
        } else {
            database.write(filter,documents);
        }
    }

}
