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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Filters can be used to put documents into the database. eg: ... WHERE '{key}'
 * = '{value}' ...
 *
 * @author merlin
 */
@Getter
@AllArgsConstructor
public final class UniversalFilter {

    private final String key, value;

    /**
     * Gets a UniversalFilter from a document.
     *
     * @param document document
     * @return filter
     */
    public static UniversalFilter from(UniversalDocument document) {
        return as(document.getKey(), document.getValue().toString());
    }

    /**
     * Gets a UniversalFilter from the given key and value.
     *
     * @param key key
     * @param value value
     * @return filter
     */
    public static UniversalFilter as(String key, String value) {
        return new UniversalFilter(key, value);
    }

}
