/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.database.local;

import de.veraty.elytrawars.database.Database;
import de.veraty.elytrawars.database.UniversalDocuments;
import de.veraty.elytrawars.database.UniversalFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 *
 * @author merlin
 */
@Getter
public class LocalDatabase implements Database {

    private final LocalConnection connection;
    private final Map<String, UniversalDocuments> dedicated;

    public LocalDatabase(LocalConnection connection) {
        this.connection = connection;
        this.dedicated = new HashMap<>();
    }

    @Override
    public void insert(UniversalFilter filter, UniversalDocuments documents) {
        this.dedicated.put(new StringBuilder()
                .append(filter.getKey())
                .append("-")
                .append(filter.getValue()).toString(), documents);
    }

    @Override
    public void write(UniversalFilter filter, UniversalDocuments documents) {
        this.dedicated.put(new StringBuilder()
                .append(filter.getKey())
                .append("-")
                .append(filter.getValue()).toString(), documents);
    }

    @Override
    public Collection<UniversalDocuments> read(UniversalFilter filter) {
        return Arrays.asList(dedicated.get(new StringBuilder()
                .append(filter.getKey())
                .append("-")
                .append(filter.getValue()).toString()));
    }

}
