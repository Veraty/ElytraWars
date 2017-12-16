/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lombok.Getter;

/**
 * Utility that allocates entries to groups fairly.
 *
 * @author merlin
 * @param <E> type
 */
@Getter
public final class PrioritizedAllocation<E> {

    private final int groupsize, groupAmount;

    private final E[][] groups;

    private final Queue<Entry<E>> entries;

    /**
     * Utility class that allocates groups.
     * <p>
     * It takes a List of Entries and allocates them based on their priority
     * group
     *
     * @param groups groups
     * @param groupsize size of a group
     * @param entries entry list
     */
    @SuppressWarnings("unchecked")
    public PrioritizedAllocation(int groups, int groupsize, Queue<Entry<E>> entries) {
        this.groupsize = groupsize;
        this.groupAmount = groups;
        this.groups = (E[][]) new Object[groups][groupsize];
        this.entries = entries;
        allocate(entries, 0);
    }

    /**
     * Allocates the entries.
     *
     * @param entries entries
     * @param level level ( recursion )
     */
    public void allocate(Queue<Entry<E>> entries, int level) {
        Queue<Entry<E>> next = new LinkedList<>();
        while (!entries.isEmpty()) {
            Entry<E> entry = entries.remove();
            if (level == 0) {
                if (entry.getPriority() >= 0 && !isGroupFull(entry.getPriority())) {
                    add(entry.getPriority(), entry.getEntry());
                } else {
                    next.add(entry);
                }
            } else {
                for (int i = 0; i < groupAmount; i++) {
                    if (!isGroupFull(i)) {
                        add(i, entry.getEntry());
                        break;
                    }
                }
            }
        }
        if (!next.isEmpty()) {
            allocate(next, level + 1);
        }
    }

    //Adds an entry to a group
    private void add(int index, E e) {
        if (index < groupAmount) {
            E[] group = groups[index];
            for (int i = 0; i < group.length; i++) {
                if (group[i] == null) {
                    group[i] = e;
                    return;
                }
            }
        }
    }

    /**
     * Gets a group.
     *
     * @param index
     * @return
     */
    public E[] getGroup(int index) {
        if (index < groupAmount) {
            return groups[index];
        }
        return null;
    }

    /**
     * Gets the GroupList.
     *
     * @param index index
     * @return list
     */
    public List<E> getGroupList(int index) {
        if (index < groupAmount) {
            E[] groupArray = groups[index];
            List<E> list = new ArrayList<>();
            for (E element : groupArray) {
                if (element != null) {
                    list.add(element);
                }
            }
            return list;
        }
        return null;
    }

    private boolean isGroupFull(int index) {
        return getGroupList(index).size() == groupsize;
    }

    /**
     * Prints the groups
     */
    public void print() {
        for (int i = 0; i < groupAmount; i++) {
            List<E> group = getGroupList(i);
            for (E e : group) {
                System.out.println(i + " : " + e);
            }
            System.out.println();
        }
    }

    /**
     * Allocation Entry
     *
     * @param <E> type
     */
    @Getter
    public static class Entry<E> {

        private final E entry;
        private final int priority;

        /**
         * Constructs an Entry.
         *
         * @param entry entry
         * @param priority priority
         */
        public Entry(E entry, int priority) {
            this.entry = entry;
            this.priority = priority;
        }

    }

}
