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
package de.veraty.elytrawars.database;

import java.util.Collection;

/**
 * You can read and write to a database.
 *
 * @author merlin
 */
public interface Database {

    /**
     * Inserts the documents to the database. Possibly returns if the database
     * allready has those documents.
     *
     * @param filter filter
     * @param documents documents
     */
    void insert(UniversalFilter filter, UniversalDocuments documents);

    /**
     * Writes an UniversalDocument to a database.
     *
     * @param filter filter
     * @param documents documents
     */
    void write(UniversalFilter filter, UniversalDocuments documents);

    /**
     * Reads from a database.
     *
     * @param filter filter
     * @return collection of results.
     */
    Collection<UniversalDocuments> read(UniversalFilter filter);

}
