/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michael
 */
public class FishTest {

    private final Sea sea;
    private final Random random;
    private final int spawnAge;
    private final int parent;
    private final int starveAge;

    public FishTest() {
        Random aRandom;
        aRandom = new Random();
        aRandom.setSeed(42);
        this.random = aRandom;
        Sea aSea = new Sea(10, 10, aRandom);
        this.sea = aSea;
        this.spawnAge = 47;
        this.parent = 81;
        this.starveAge = 97;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Fish.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SeaPosition position = new SeaPosition(5, 5, this.sea);
        Fish instance = new Fish(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent);
        instance.setCreatureID(4545);
        System.out.println(instance);
        String expResult = "Fish 0000004545 Parent: 0000000081 (5,5) Alive: true Age: 0 Spawn in: 47 Starve in: 97";
        System.out.println(expResult);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Fish.
     */
    @Test
    public void testTurn() {
        System.out.println("toString");
        SeaPosition position;
        Fish instance;
        List<SeaCreature> creatures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            position = new SeaPosition(9, i, this.sea);
            instance = new Fish(this.sea, position, 3, this.starveAge, this.random, 0);
            creatures.add(instance);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < creatures.size(); j++) {
                System.out.println(String.format("%3d %s", i, creatures.get(j)));
                creatures.get(j).turn();
            }
        }
    }

}
