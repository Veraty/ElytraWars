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

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.UniversalDocuments;
import de.veraty.elytrawars.database.UniversalFilter;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * The AsyncDatabase handles all Database functions async.
 *
 * @author merlin
 */
public class AsyncDatabase {

    private final Database dedicated;
    private final ListeningExecutorService executorService;

    /**
     * Constructs an AsyncDatabase.
     *
     * @param dedicated dedicated database
     */
    public AsyncDatabase(Database dedicated) {
        this.dedicated = dedicated;
        this.executorService = MoreExecutors.
                listeningDecorator(Executors.newCachedThreadPool());
    }

    /**
     * Inserts the document async.
     *
     * @param filter filter
     * @param docs docs
     */
    public void insert(UniversalFilter filter, UniversalDocuments docs) {
        executorService.execute(new WritingRunnable(dedicated, true, filter, docs));
    }

    /**
     * Writes the document async.
     *
     * @param filter filter
     * @param docs docs
     */
    public void write(UniversalFilter filter, UniversalDocuments docs) {
        executorService.execute(new WritingRunnable(dedicated, false, filter, docs));
    }

    /**
     * Reads the documents async.
     *
     * @param filter filter
     * @param consumer consumer
     */
    public void read(UniversalFilter filter, Consumer<Collection<UniversalDocuments>> consumer) {
        ListenableFuture<Collection<UniversalDocuments>> future = executorService.
                submit(new ReadingCallback(dedicated, filter));

        Futures.addCallback(future, new ReadingFutureCallback(consumer));
    }

}
