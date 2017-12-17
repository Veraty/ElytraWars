/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.database.async;

import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.UniversalDocuments;
import de.veraty.elytrawars.database.UniversalFilter;
import java.util.Collection;
import java.util.concurrent.Callable;
import lombok.AllArgsConstructor;

/**
 * Callable that reads the value from the database.
 *
 * @author merlin
 */
@AllArgsConstructor
public class ReadingCallback implements Callable<Collection<UniversalDocuments>> {

    private final Database database;
    private final UniversalFilter filter;

    @Override
    public Collection<UniversalDocuments> call() throws Exception {
        return database.read(filter);
    }

}
