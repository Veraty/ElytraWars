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

import java.util.function.Consumer;

/**
 *
 * @author merlin
 */
public class UniversalDocuments {

    private UniversalDocument first;

    /**
     * Constructs an UniversalDocuments from the given root.
     *
     * @param document root
     */
    public UniversalDocuments(UniversalDocument document) {
        this.first = document;
    }

    /**
     * Gives every value to the consumer.
     *
     * @param documentConsumer consumer
     */
    public void forEach(Consumer<UniversalDocument> documentConsumer) {
        UniversalDocument next = first;
        while (next != null) {
            documentConsumer.accept(next);
            next = next.getNext();
        }
    }
    
    public void write(UniversalFilter filter,Database database){}

}
