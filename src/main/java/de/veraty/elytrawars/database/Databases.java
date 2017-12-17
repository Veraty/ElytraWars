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

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import de.veraty.elytrawars.database.async.AsyncDatabase;
import de.veraty.elytrawars.database.sql.SqlConnection;
import de.veraty.elytrawars.database.sql.SqlDatabase;

/**
 *
 * @author merlin
 */
public class Databases {

    /**
     * Creates an AsyncDatabase from the given database.
     *
     * @param optionalDatabase optional database
     * @return optional async database
     */
    public static Optional<AsyncDatabase> async(Optional<Database> optionalDatabase) {
        if (!optionalDatabase.isPresent()) {
            return Optional.absent();
        }

        return Optional.of(new AsyncDatabase(optionalDatabase.get()));
    }

    /**
     * Connects to the a database.
     *
     * @param credential credentials
     * @param clazz database class
     * @return database
     */
    public static Optional<Database> connect(Credential credential, Class<? extends Database> clazz) {
        Preconditions.checkNotNull(clazz);
        DatabaseConnection connection = null;

        /* Get the database type */
        if (clazz.equals(SqlDatabase.class)) {
            connection = new SqlConnection();
        }

        // Invalid arguments were given
        if (connection == null) {
            return Optional.absent();
        }

        // Connect and return
        connection.open(credential);
        return Optional.of(connection.database());
    }

}
