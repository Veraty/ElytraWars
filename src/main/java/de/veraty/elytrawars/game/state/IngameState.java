/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.game.state;

import de.veraty.elytrawars.game.GameState;
import de.veraty.elytrawars.game.countdown.IngameCountdown;
import de.veraty.elytrawars.user.User;
import de.veraty.elytrawars.util.PrioritizedAllocation;
import de.veraty.elytrawars.util.PrioritizedAllocation.Entry;
import de.veraty.elytrawars.util.message.Message;
import java.util.LinkedList;
import java.util.Queue;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author merlin
 */
public class IngameState extends GameState {

    public IngameState() {
        super(Message.STATE_INGAME.get(), new IngameCountdown());
    }

    @Override
    protected void onInitiate() {

        Queue<Entry<User>> entries = new LinkedList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            User user = User.getUser(player);
            entries.add(new Entry<>(user, user.getTeamChoice()));
        }

        PrioritizedAllocation<User> allocation = new PrioritizedAllocation<>(
                5, 5, entries);
        
      
    }

}
