/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
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
public class SeaCreatureTest {

    private final Sea sea;
    private final Random random;
    private final int spawnAge;
    private final int parent;
    private final int starveAge;
    private final Color color;
    private final String shape;

    public SeaCreatureTest() {
        Random aRandom;
        aRandom = new Random();
        aRandom.setSeed(42);
        this.random = aRandom;
        Sea aSea = new Sea(10, 10, aRandom);
        this.sea = aSea;
        this.spawnAge = 5;
        this.parent = 7;
        this.starveAge = 99;
        this.color = Color.WHITE;
        this.shape = ".";

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
     * Test of getPosition method, of class SeaCreature.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        SeaPosition newPos = new SeaPosition(0, 0, this.sea);
        System.out.println("SeaPosition: " + newPos);
        SeaCreature instance = new SeaCreature(this.sea, newPos, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        System.out.println(instance);
        SeaPosition expResult = newPos;
        SeaPosition result = instance.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class SeaCreature.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        SeaPosition originalPosition = new SeaPosition(0, 1, this.sea);
        SeaPosition newPosition = new SeaPosition(0, 2, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, originalPosition, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setPosition(newPosition);
        assertEquals(newPosition.toString(), instance.getPosition().toString());
    }

    /**
     * Test of getCreatureID method, of class SeaCreature.
     */
    @Test
    public void testGetCreatureID() {
        System.out.println("getCreatureID");
        SeaPosition position = new SeaPosition(9, 9, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        int expResult = 48;
        instance.setCreatureID(expResult);
        int result = instance.getCreatureID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreatureID method, of class SeaCreature.
     */
    @Test
    public void testSetCreatureID() {
        System.out.println("setCreatureID");
        int creatureID = 42;
        SeaPosition originalPosition = new SeaPosition(0, 3, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, originalPosition, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setCreatureID(creatureID);
        assertEquals(creatureID, instance.getCreatureID());
    }

    /**
     * Test of setNextID method, of class SeaCreature.
     */
    @Test
    public void testSetNextID() {
        System.out.println("setNextID");
        int nextID = 23;
        SeaPosition position = new SeaPosition(1, 1, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setNextID(nextID);
        assertEquals(23, instance.getNextID());
    }

    /**
     * Test of getNextID method, of class SeaCreature.
     */
    @Test
    public void testGetNextID() {
        System.out.println("getNextID");
        SeaPosition position = new SeaPosition(2, 5, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        int expResult = 32;
        instance.setNextID(32);
        int result = instance.getNextID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class SeaCreature.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        SeaPosition position = new SeaPosition(2, 6, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        Color expResult = this.color;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAlive method, of class SeaCreature.
     */
    @Test
    public void testIsAlive() {
        System.out.println("isAlive");
        SeaPosition position = new SeaPosition(2, 7, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        boolean expResult = true;
        boolean result = instance.isAlive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class SeaCreature.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        SeaPosition position = new SeaPosition(3, 1, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class SeaCreature.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 37;
        SeaPosition position = new SeaPosition(3, 2, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setAge(37);
        assertEquals(age, instance.getAge());
    }

    /**
     * Test of getTotalAge method, of class SeaCreature.
     */
    @Test
    public void testGetTotalAge() {
        System.out.println("getTotalAge");
        SeaPosition position = new SeaPosition(3, 3, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        // birth age = 0
        int expResult = 0;
        int result = instance.getTotalAge();
        assertEquals(expResult, result);
        // set to a new age
        expResult = 31;
        instance.setTotalAge(expResult);
        result = instance.getTotalAge();
        assertEquals(expResult, result);

    }

    /**
     * Test of setTotalAge method, of class SeaCreature.
     */
    @Test
    public void testSetTotalAge() {
        System.out.println("setTotalAge");
        int totalAge = 41;
        SeaPosition position = new SeaPosition(3, 4, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setTotalAge(totalAge);
        assertEquals(totalAge, instance.getTotalAge());

    }

    /**
     * Test of getStarve method, of class SeaCreature.
     */
    @Test
    public void testGetStarve() {
        System.out.println("getStarve");
        int expResult = 73;
        SeaPosition position = new SeaPosition(4, 3, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setStarve(expResult);
        int result = instance.getStarve();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStarve method, of class SeaCreature.
     */
    @Test
    public void testSetStarve() {
        System.out.println("setStarve");
        int starve = 23;
        SeaPosition position = new SeaPosition(4, 5, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setStarve(starve);
        assertEquals(starve, instance.getStarve());
    }

    /**
     * Test of toString method, of class SeaCreature.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SeaPosition position = new SeaPosition(7, 7, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setCreatureID(5151);
        String expResult = "0000005151 Parent: 0000000007 (7,7) Alive: true Age: 0 Spawn in: 5 Starve in: 99";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of turn method, of class SeaCreature.
     */
    @Test
    public void testTurn() {
        System.out.println("turn");
        SeaPosition position = new SeaPosition(7, 8, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setCreatureID(4242);
        for (int i = 0; i < 10; i++) {
            System.out.println(instance);
            instance.turn();
        }
        System.out.println(instance);
    }

    /**
     * Test of getSpawnAge method, of class SeaCreature.
     */
    @Test
    public void testGetSpawnAge() {
        System.out.println("getSpawnAge");
        SeaPosition position = new SeaPosition(8, 3, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        int expResult = this.spawnAge;
        int result = instance.getSpawnAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpawnAge method, of class SeaCreature.
     */
    @Test
    public void testSetSpawnAge() {
        System.out.println("setSpawnAge");
        int spawnAge = 57;
        SeaPosition position = new SeaPosition(8, 3, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.setSpawnAge(spawnAge);
        int result = instance.getSpawnAge();
        assertEquals(spawnAge, result);
    }

    /**
     * Test of getShape method, of class SeaCreature.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        SeaPosition position = new SeaPosition(8, 4, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        String expResult = ".";
        String result = instance.getShape();
        assertEquals(expResult, result);
    }

    /**
     * Test of died method, of class SeaCreature.
     */
    @Test
    public void testDied() {
        System.out.println("died");
        SeaPosition position = new SeaPosition(8, 4, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, this.spawnAge, this.starveAge, this.random, this.parent, this.color, this.shape);
        instance.died();
        boolean expResult = false;
        assertEquals(expResult, instance.isAlive());
    }

    /**
     * Test of spawn method, of class SeaCreature.
     */
    @Test
    public void testSpawn() {
        System.out.println("spawn");
        int spawn = 1;
        int starve = - 99;
        int parent = 0;
        SeaPosition position = new SeaPosition(8, 4, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, spawn, starve, this.random, parent, this.color, this.shape);
        instance.setAge(5); // must be equal or older than spawn age.
        List<SeaPosition> free = instance.getPosition().getAdjacentFree();
        System.out.println("spawn free: " + free);
        boolean expResult = true;
        int limit = 10;
        int i = 0;
        boolean result = instance.spawn(free); // because spawing is random with
        while (!result && i < limit) {         // p=0.30, must try a few spawns
            result = instance.spawn(free);     // to get one to occur.
            i++;
        }
        System.out.println("spawn tried " + i + " times");
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class SeaCreature.
     */
    @Test
    public void testMove() {
        System.out.println("move");

        int spawn = 1;
        int starve = 99;
        int parent = 0;
        SeaPosition position = new SeaPosition(8, 7, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, spawn, starve, this.random, parent, this.color, this.shape);
        List<SeaPosition> empty = instance.getPosition().getAdjacentFree();
        System.out.println("move free: " + empty);
        position = new SeaPosition(8, 8, this.sea);
        String expResult = "(8,8)";
        int limit = 40;
        int i = 0;
        instance.move(empty);
        String result = String.format("%s", instance.getPosition());  // because choosing a random position
        System.out.println("move expResult " + expResult + " result " + result);
        while (!expResult.equals(result) && i < limit) {                     // is random, we must make more than
            instance.move(empty);
            result = String.format("%s", instance.getPosition());     // one try.
            System.out.println("move expResult " + expResult + " result " + result);
            i++;
        }
        System.out.println("move tried " + i + " times");
        assertEquals(expResult, result);
    }

    /**
     * Test of randomPosition method, of class SeaCreature.
     */
    @Test
    public void testRandomPosition() {
        System.out.println("randomPosition");

        int spawn = 1;
        int starve = 99;
        int parent = 0;
        SeaPosition position = new SeaPosition(8, 6, this.sea);
        SeaCreature instance = new SeaCreature(this.sea, position, spawn, starve, this.random, parent, this.color, this.shape);
        List<SeaPosition> free = instance.getPosition().getAdjacentFree();
        System.out.println("randomPosition free: " + free);
        String expResult = "(8,5)";
        int limit = 20;
        int i = 0;
        String result;  // because choosing a random position
        result = String.format("%s", instance.randomPosition(free));
        System.out.println("randomPosition expResult " + expResult + " result " + result);
        while (!expResult.equals(result) && i < limit) {                     // is random, we must make more than
            result = String.format("%s", instance.randomPosition(free));     // one try.
            System.out.println("randomPosition expResult " + expResult + " result " + result);
            i++;
        }
        System.out.println("randomPosition tried " + i + " times");
        assertEquals(expResult, result);
    }

}
