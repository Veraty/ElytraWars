/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.game.state;

import de.veraty.elytrawars.game.GameState;
import de.veraty.elytrawars.game.countdown.WaitingCountdown;
import de.veraty.elytrawars.util.message.Message;

/**
 *
 * @author merlin
 */
public final class WaitingState extends GameState {

    public WaitingState() {
        super(Message.STATE_WAITING.get(), new WaitingCountdown());
    }

    @Override
    protected void onInitiate() {
    }

}
