/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author michael
 */
public class Shark extends SeaCreature {
        static Color color = Color.RED; // can't be arsed to make this better. 
        static String shape = "S";   // putting color and shape here for now.

    /**
     *
     * @param sea
     * @param pos
     * @param spawnAge
     * @param starveAge
     * @param random
     * @param parent
     */
    public Shark(Sea sea, SeaPosition pos, int spawnAge, int starveAge, Random random, int parent) {
        super(sea, pos, spawnAge, starveAge, random, parent, Shark.color, Shark.shape);
    }

    protected boolean eat(List<SeaCreature> occupied) {
        /*
        Either find something to eat, or move (randomly) to a free adjacent spot.
         */
        boolean result = false;
        List<SeaCreature> fishes = new ArrayList<>();
        SeaCreature candidate;
        for (int i = 0; i < occupied.size(); i++) {
            candidate = occupied.get(i);
            if ("Fish".equals(candidate.getClass().getSimpleName())) {
                fishes.add(candidate);
            }
        }
        if (fishes.size() > 0) {
            SeaCreature sharkFood;
            sharkFood = fishes.get(this.getRandom().nextInt(fishes.size()));
            this.getSea().removeCreature(sharkFood);
            this.getSea().moveCreature(this, sharkFood.getPosition());
                this.setStarve(0);
                result = true;
        }
        return result;
    }

    @Override
    public void turn() {
        /*
        Sharks can die of starvation. If it has not starved try to eat
        after eating spawn (if possible). If there are no fish nearby, and
        spawning is possible, spawn, otherwise move.
         */
        if (this.isAlive()) {
            this.ageCreature();
            if (this.getStarve() > this.getStarveAge()) {
                this.getSea().removeCreature(this);
            } else {
                List<SeaCreature> occupied = this.getPosition().getAdjacentCreatures();
                List<SeaPosition> empty = this.getPosition().getAdjacentFree();
                if (occupied.size() > 0) {
                    List<SeaPosition> wasHere;
                    wasHere = new ArrayList<>();
                    wasHere.add(this.getPosition()); // save in case spawning
                    if (this.eat(occupied)) {
                        this.spawn(wasHere);
                    } else if (empty.size() > 0) {
                        if (!this.spawn(empty)) {
                            this.move(empty);
                        }
                    }
                } else if (empty.size() > 0) {
                    if (!this.spawn(empty)) {
                        this.move(empty);
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        return String.format("%s %s", "Shark", super.toString());
    }

}
