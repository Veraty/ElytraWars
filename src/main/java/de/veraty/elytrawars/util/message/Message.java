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
package de.veraty.elytrawars.util.message;

import de.veraty.elytrawars.user.User;
import static de.veraty.elytrawars.util.message.Prefix.*;
import java.util.Collection;
import java.util.logging.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;

/**
 *
 * @author merlin
 */
@Getter
@AllArgsConstructor
public enum Message {

    CONSOLE(ERROR, "error.console", "The Console can't execute this command."),
    STATE_WAITING(NONE, "state.waiting", "§aWaiting"),
    STATE_INGAME(NONE, "state.ingame", "§aIngame");
    private final Prefix prefix;
    private final String key, fallback;

    /**
     * Logs the message to the console.
     *
     * @param args arguments
     */
    public void toConsole(Object... args) {
        Bukkit.getLogger().log(Level.INFO, get(args));
    }

    /**
     * Sends the message to a single user.
     *
     * @param user user
     * @param args arguments
     */
    public void toUser(User user, Object... args) {
        user.sendMessage(get(args));
    }

    /**
     * Sends the message to a collection of users.
     *
     * @param users users
     * @param args arguments
     */
    public void toUsers(Collection<User> users, Object... args) {
        String message = get(args);
        for (User user : users) {
            user.sendMessage(message);
        }
    }

    /**
     * Gets the formatted message.
     *
     * @param args arguments
     * @return formatted message
     */
    public String get(Object... args) {
        String message = prefix.getText().concat(fallback);//TODO: Get message from a file.
        if (args.length == 0) {
            return message;
        }

        boolean op = false;
        StringBuilder builder = new StringBuilder().append(prefix.getText());

        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (op) {
                builder.append(args['1' - character]);
                op = false;
                continue;

            }
            if (character == '$') {
                op = true;
                continue;
            }

            builder.append(character);
        }

        return builder.toString();
    }

}
