/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author michael
 */
public class Fish extends SeaCreature {
    
    static Color color = Color.GREEN;
    static String shape = "f";

    public Fish(Sea sea, SeaPosition pos, int spawnAge, int starveAge, Random random, int parent) {
        super(sea, pos, spawnAge, starveAge, random, parent, Fish.color, Fish.shape);
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Fish", super.toString());
    }

}
