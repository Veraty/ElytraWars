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

import com.google.common.util.concurrent.FutureCallback;
import de.veraty.elytrawars.ElytraWarsPlugin;
import de.veraty.elytrawars.database.UniversalDocuments;
import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;

/**
 *
 * @author merlin
 */
@AllArgsConstructor
public class ReadingFutureCallback
        implements FutureCallback<Collection<UniversalDocuments>> {

    private final Consumer<Collection<UniversalDocuments>> consumer;

    @Override
    public void onSuccess(Collection<UniversalDocuments> docs) {
        consumer.accept(docs);
    }

    @Override
    public void onFailure(Throwable throwable) {
        ElytraWarsPlugin.getInstance().handle(throwable);
        consumer.accept(new LinkedList<>());
    }

}
