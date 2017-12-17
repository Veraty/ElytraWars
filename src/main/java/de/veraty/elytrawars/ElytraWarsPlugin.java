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
package de.veraty.elytrawars;

import com.google.common.base.Optional;
import de.veraty.elytrawars.database.Databases;
import de.veraty.elytrawars.database.async.AsyncDatabase;
import de.veraty.elytrawars.database.sql.SqlDatabase;
import de.veraty.elytrawars.util.ExceptionConsumer;
import java.util.function.Consumer;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Elytra Wars is a MiniGame Plugin.
 *
 * Made with Netbeans IDE 8.2
 *
 * @author merlin
 */
@Getter
public class ElytraWarsPlugin extends JavaPlugin {

    @Getter
    private static ElytraWarsPlugin instance;

    private final Consumer<Throwable> exceptionHandler;
    private AsyncDatabase database;

    public ElytraWarsPlugin() {
        instance = this;

        this.exceptionHandler = new ExceptionConsumer();
    }

    @Override
    public void onEnable() {

        Optional<AsyncDatabase> optional = Databases.async(
                Databases.connect(null, SqlDatabase.class));

        if (optional.isPresent()) {
            this.database = optional.get();
        }
    }

    public void handle(Throwable exception) {
        this.exceptionHandler.accept(exception);
    }

}
