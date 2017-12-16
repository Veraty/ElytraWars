/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.util;

/**
 * Can be send.
 *
 * @author merlin
 */
public interface Sendable {

    /**
     * Sends the object via the given playerconnection.
     *
     * @param playerConnection connection
     */
    void send(Object playerConnection);

}
