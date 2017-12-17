/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.database.local;

import de.veraty.elytrawars.database.Credential;
import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.DatabaseConnection;

/**
 *
 * @author merlin
 */
public class LocalConnection implements DatabaseConnection {

    private LocalDatabase database;

    @Override
    public void open(Credential credential) {
    }

    @Override
    public void close() {
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public Database database() {
        if (database == null) {
            database = new LocalDatabase(this);
        }
        return database;
    }

}
