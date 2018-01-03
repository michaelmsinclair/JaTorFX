/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michael
 */
public class SeaPosition implements Comparable {

    int x;
    int y;
    Sea sea;

    public SeaPosition(int x, int y, Sea sea) {
        this.x = x;
        this.y = y;
        this.sea = sea;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public List<SeaCreature> getAdjacentCreatures() {
        /*
        Returns an array of positions adjacent to this position.
        Adjacent positions are the surounding eight positions:
            n, ne, e, se, s, sw, w, ne.
        As cartiesian coordinates they are:
            (-1,+1) (0,+1) (+1,+1)
            (-1, 0)  Pos.  (+1, 0)
            (-1,-1) (0,-1) (+1,-1)
         */
        List<SeaCreature> adjacent = new ArrayList<>();
        int maxX = this.sea.getMaxX();
        int maxY = this.sea.getMaxY();

        for (int deltaX = -1; deltaX <= +1; deltaX++) {
            for (int deltaY = -1; deltaY <= +1; deltaY++) {
                int newX = (this.x + deltaX + maxX) % maxX;
                int newY = (this.y + deltaY + maxY) % maxY;
                if (!(newX == x && newY == y)) {
                    SeaPosition sp = new SeaPosition(newX, newY, this.sea);
                    SeaCreature sc = this.sea.getCell(sp);
                    if (sc != null) {
                        adjacent.add(sc);
                    }
                }
            }
        }
        return adjacent;
    }

    public List<SeaPosition> getAdjacentFree() {
        /*
        Returns an array of positions adjacent to this position.
        Adjacent positions are the surounding eight positions:
            n, ne, e, se, s, sw, w, ne.
        As cartiesian coordinates they are:
            (-1,+1) (0,+1) (+1,+1)
            (-1, 0)  Pos.  (+1, 0)
            (-1,-1) (0,-1) (+1,-1)
         */
        List<SeaPosition> adjacent = new ArrayList<>();
        int maxX = this.sea.getMaxX();
        int maxY = this.sea.getMaxY();

        SeaPosition sp;
        for (int deltaX = -1; deltaX <= +1; deltaX++) {
            for (int deltaY = -1; deltaY <= +1; deltaY++) {
                int newX = (this.x + deltaX + maxX) % maxX;
                int newY = (this.y + deltaY + maxY) % maxY;
                if (!(newX == x && newY == y)) {
                    sp = new SeaPosition(newX, newY, this.sea);
                    SeaCreature sc = this.sea.getCell(sp);
                    if (sc == null) {
                        adjacent.add(sp);
                    }
                }
            }
        }
        return adjacent;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    @Override
    public int compareTo(Object t) {
        String here = this.toString();
        String there = t.toString();

        return here.compareTo(there);
    }

}
