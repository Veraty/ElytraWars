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
package de.veraty.elytrawars.database.sql;

import de.veraty.elytrawars.ElytraWarsPlugin;
import de.veraty.elytrawars.database.Credential;
import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.Getter;

/**
 *
 * @author merlin
 */
@Getter
public class SqlConnection implements DatabaseConnection {

    private static final String URL = "jdbc://%s:%s/%s";

    private Connection connection;
    private Database database;

    @Override
    public void open(Credential credential) {
        try {
            this.connection = DriverManager.getConnection(
                    String.format(URL,
                            credential.getHostname(),
                            String.valueOf(credential.getPort()),
                            credential.getDatabase()),
                    credential.getUser(),
                    credential.getPassword());

        } catch (SQLException exception) {
            ElytraWarsPlugin.getInstance().handle(exception);
        }
    }

    @Override
    public void close() {
        if (isOpen()) {
            try {
                this.connection.close();
            } catch (SQLException exception) {
                ElytraWarsPlugin.getInstance().handle(exception);
            }
        }
    }

    @Override
    public boolean isOpen() {
        try {
            return this.connection != null && !this.connection.isClosed();
        } catch (SQLException exception) {
            ElytraWarsPlugin.getInstance().handle(exception);
        }
        return false;
    }

    @Override
    public Database database() {
        if (database == null) {
            database = new SqlDatabase(this);
        }

        return database;
    }

}
