/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author michael
 */
public class SeaCreature {

    /**
     *
     */
    private static int nextID = 1;

//    private final int color;
    private final Color color;
    private final String shape;
    private final Sea sea;
    private SeaPosition pos;
    private int age;
    private int totalAge;
    private int spawnAge;
    private int starve;
    private final int starveAge; // set but not used by basic creature
    private boolean alive;
    private final Random random;
    private int creatureID;
    private final int parent;

    /**
     *
     * @param sea
     * @param pos
     * @param spawnAge
     * @param starveAge
     * @param random
     * @param parent
     * @param color
     * @param shape
     */
    public SeaCreature(Sea sea, SeaPosition pos, int spawnAge, int starveAge, Random random, int parent, Color color, String shape) {
        this.sea = sea;
        this.pos = pos;
        this.age = 0;
        this.totalAge = this.age;
        this.spawnAge = spawnAge;
        this.starve = 0;
        this.starveAge = starveAge;
        this.alive = true;
        this.random = random;
        this.parent = parent;
        this.color = color;
        this.shape = shape;
        this.creatureID = SeaCreature.nextID++;
    }

    public Sea getSea() {
        return this.sea;
    }

    /**
     *
     * @return SeaPosition the creatures position.
     */
    public SeaPosition getPosition() {
        return this.pos;
    }

    protected void ageCreature() {
        this.age++;
        this.totalAge++;
        this.starve++;
    }

    /**
     *
     * @param position a SeaPosition within the Cartesian plane of Ja-Tor.
     */
    protected void setPosition(SeaPosition position) {
        this.pos = position;
    }

    public String getShape() {
        return this.shape;
    }

    public int getCreatureID() {
        return this.creatureID;
    }

    protected void setCreatureID(int creatureID) {
        this.creatureID = creatureID;
    }

    protected void setNextID(int nextID) {
        SeaCreature.nextID = nextID;
    }

    public int getNextID() {
        return SeaCreature.nextID;
    }

    /**
     *
     * @return Color the creature's color.
     */
    public Color getColor() {
        return this.color;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public int getAge() {
        return this.age;
    }

    /**
     *
     * @param age Set the creature's age.
     */
    protected void setAge(int age) {
        this.age = age;
    }

    /**
     *
     */
    protected void died() {
        this.sea.emptyCell(this.pos);
        this.alive = false;
    }

    protected boolean spawn(List<SeaPosition> free) {
        /*
        If old enough, and there is free space, spawn.
         */
        if (this.age >= this.spawnAge) {
            SeaPosition newPos = randomPosition(free);
            if (newPos != null && this.random.nextFloat() > 0.7) {
                this.sea.addCreature(newPos, this.getClass().getSimpleName(), this.spawnAge, this.creatureID, this.starveAge);
                this.age = 0;
                return true;
            } else {
                return false;
            }
        } else {
            return false;

        }
    }

    protected void move(List<SeaPosition> empty) {
        /*
        Move to a new position if it is empty.
        Sea.setCe11() returns true if a creature is placed there,
        meaning that the cell was empty.
         */
        SeaPosition newPos;
        newPos = this.randomPosition(empty);
        this.sea.moveCreature(this, newPos);
    }

    /**
     *
     */
    protected void turn() {
        /*
        The basic creature spawns, or moves if it cannot spawn.
         */
        if (this.alive) {
            this.age++;
            this.totalAge++;
            List<SeaPosition> empty = this.pos.getAdjacentFree();
            if (empty.size() > 0) {
                if (!this.spawn(empty)) {
                    this.move(empty);
                }
            }
        }
    }

    protected SeaPosition randomPosition(List<SeaPosition> positions) {
        int numberOfPositions = positions.size();
        if (numberOfPositions > 0) {
            return positions.get(this.random.nextInt(numberOfPositions));
        } else {
            return null;
        }

    }

    public int getTotalAge() {
        return this.totalAge;
    }

    protected void setTotalAge(int totalAge) {
        this.totalAge = totalAge;
    }

    /**
     *
     * @return spawnAge age a creature spawns at.
     */
    public int getSpawnAge() {
        return this.spawnAge;
    }

    protected void setSpawnAge(int spawnAge) {
        this.spawnAge = spawnAge;
    }

    /**
     *
     * @return starve chronons it takes for a creature to starve.
     */
    public int getStarve() {
        return this.starve;
    }

    protected void setStarve(int starve) {
        this.starve = starve;
    }

    public int getStarveAge() {
        return this.starveAge;
    }
    
    public Random getRandom() {
        return this.random;
    }

    @Override
    public String toString() {
        return String.format("%010d Parent: %010d (%d,%d) Alive: %s Age: %d Spawn in: %d Starve in: %d", this.creatureID, this.parent, this.pos.getX(), this.pos.getY(), this.alive, this.totalAge, this.spawnAge - this.age, this.starveAge - this.starve);
    }

}
