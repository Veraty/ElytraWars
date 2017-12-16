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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Documents that can be used in every database.
 *
 * @author merlin
 */
@Getter
@Setter
@Data
public class UniversalDocument {

    private String key;
    private Object value;
    private UniversalDocument before, next;

    /**
     * Constructs an UniversalDocument.
     *
     * @param key document key
     * @param value document value
     */
    public UniversalDocument(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Constructs an UniversalDocument with a parent.
     *
     * @param before document before
     * @param key document key
     * @param value document value
     */
    public UniversalDocument(UniversalDocument before, String key, Object value) {
        this.before = before;
        this.key = key;
        this.value = value;
    }

    /**
     * Creates a new document and appends it.
     *
     * @param key document key
     * @param value document value
     * @return document
     */
    public UniversalDocument append(String key, Object value) {
        this.next = new UniversalDocument(this, key, value);
        return next;
    }

    /**
     * Appends the document.
     *
     * @param document document
     * @return document
     */
    public UniversalDocument append(UniversalDocument document) {
        this.next = document;
        document.setBefore(this);
        return document;
    }

    /**
     * Gets the first document.
     *
     * @return first document.
     */
    public UniversalDocument getFirst() {
        UniversalDocument first = before;
        while (first != null) {
            first = first.getBefore();
        }
        return first;
    }

    /**
     * Collects the documents to an UniversalDocuments Object.
     *
     * @return universaldocuments
     */
    public UniversalDocuments collect() {
        return new UniversalDocuments(getFirst());
    }

}
