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
import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.UniversalDocument;
import de.veraty.elytrawars.database.UniversalDocuments;
import de.veraty.elytrawars.database.UniversalFilter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.function.Consumer;
import lombok.Getter;

/**
 * Sql implementation of the database.
 *
 * @author merlin
 */
@Getter
public class SqlDatabase implements Database {

    private final SqlConnection connection;

    /**
     * Constructs a SqlDatabase.
     *
     * @param connection connection
     */
    public SqlDatabase(SqlConnection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(UniversalFilter filter, UniversalDocuments documents) {
        try {
            StringBuilder keyBuilder = new StringBuilder();
            StringBuilder valueBuilder = new StringBuilder();

            documents.forEach(new Consumer<UniversalDocument>() {

                private boolean first;

                @Override
                public void accept(UniversalDocument doc) {
                    if (first) {
                        keyBuilder.append(doc.getKey());
                        valueBuilder.append(doc.getValue().toString());
                    } else {
                        keyBuilder.append(",".concat(doc.getKey()));
                        valueBuilder.append(",".concat(doc.getValue().toString()));
                    }
                    first = true;
                }

            });

            PreparedStatement statement = connection.getConnection()
                    .prepareStatement("INSERT INTO `?` (?) VALUES (?)");

            statement.setString(0, filter.getKey());
            statement.setString(1, keyBuilder.toString());
            statement.setString(2, valueBuilder.toString());
            
            try {
                statement.executeUpdate();
            } catch (SQLException exception) {
                ElytraWarsPlugin.getInstance().handle(exception);
            }
            statement.close();
        } catch (SQLException exception) {
            ElytraWarsPlugin.getInstance().handle(exception);
        }
    }

    @Override
    public void write(UniversalFilter filter, UniversalDocuments documents) {
        String sql = String.format("IN");
    }

    @Override
    public Collection<UniversalDocuments> read(UniversalFilter filter) {
        return null;
    }

}
