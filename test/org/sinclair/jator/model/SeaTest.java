/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

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
public class SeaTest {
    
    private static Random random;
    private static Color color;
    
    public SeaTest() {
        SeaTest.random = new Random();
        SeaTest.random.setSeed(42);
        SeaTest.color = Color.WHITESMOKE;
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
     * Test of getMaxX method, of class Sea.
     */
    @Test
    public void testGetMaxX() {
        System.out.println("getMaxX");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        int expResult = 7;
        int result = instance.getMaxX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxY method, of class Sea.
     */
    @Test
    public void testGetMaxY() {
        System.out.println("getMaxY");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        int expResult = 11;
        int result = instance.getMaxY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCell method, of class Sea.
     */
    @Test
    public void testSetCell() {
        System.out.println("setCell");
        Sea instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c = new SeaCreature(instance, position, 3, 5, SeaTest.random, 0, SeaTest.color, ".");

        boolean expResult = true;
        boolean result = instance.setCell(position, c);
        assertEquals(expResult, result);
    }

    /**
     * Test of emptyCell method, of class Sea.
     */
    @Test
    public void testEmptyCell() {
        System.out.println("emptyCell");
        Sea instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c;
        c = new SeaCreature(instance, position, 3, 5, SeaTest.random, 0, SeaTest.color, ".");

        SeaCreature expResult = null;
        instance.emptyCell(position);
        assertEquals(expResult, instance.getCell(position));
    }

    /**
     * Test of isCellEmpty method, of class Sea.
     */
    @Test
    public void testIsCellEmpty() {
        System.out.println("isCellEmpty");
        int spawn = 3;
        int parent = 9;
        int starve = 5;
        String newCreature = "Shark";
        
        Sea instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c;
        c = instance.addCreature(position, newCreature, spawn, parent, starve);

        boolean expResult = false;
        boolean result = instance.isCellEmpty(position);
        assertEquals(expResult, result);

        position = new SeaPosition(5, 3, instance);
        expResult = true;
        result = instance.isCellEmpty(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCreature method, of class Sea.
     */
    @Test
    public void testAddCreature() {
        System.out.println("addCreature");
        int spawn = 3;
        int parent = 9;
        int starve = 5;
        String newCreature = "Shark";
        
        Sea instance = new Sea(11, 13, SeaTest.random);
        SeaPosition position = new SeaPosition(7,11, instance);
        SeaCreature c = instance.addCreature(position, newCreature, spawn, parent, starve);
        SeaCreature expResult = c;
        SeaCreature result = instance.getCell(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of cleanCreatures method, of class Sea.
     */
//    @Test
//    public void testCleanCreatures() {
//        System.out.println("cleanCreatures");
//        Sea instance = null;
//        instance.cleanCreatures();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Sea.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int spawn = 3;
        int starve = 5;
        int parent = 0;
        int x = 13;
        int y = 17;
        int nCells = x * y;
              
        Sea instance = new Sea(13, 17, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c = instance.addCreature(position, "Shark", spawn, parent, starve);

        position = new SeaPosition(5,3, instance);
        c = instance.addCreature(position, "Fish", spawn, parent, starve);

        int empty = nCells - 2;
        String expResult = String.format("Sharks: 1 Fishes: 1 Empty: %d", empty);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCell method, of class Sea.
     */
    @Test
    public void testGetCell_SeaPosition() {
        System.out.println("getCell");
        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature addCreature = instance.addCreature(position, "Shark", 3, 0, 5);
        SeaCreature expResult = addCreature;
        SeaCreature result = instance.getCell(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCell method, of class Sea.
     */
    @Test
    public void testGetCell_int_int() {
        System.out.println("getCell");
        int x = 5;
        int y = 3;

        Sea instance;
        instance = new Sea(7, 11, SeaTest.random);
        SeaPosition position = new SeaPosition(5,3, instance);
        SeaCreature addCreature = instance.addCreature(position, "Fish", 3, 0, 5);
        SeaCreature expResult = addCreature;
        SeaCreature result = instance.getCell(x,y);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveCreature method, of class Sea.
     */
    @Test
    public void testMoveCreature() {
        System.out.println("moveCreature");
        int spawn = 5;
        int starve = 3;
        int parent = 42;
        
        Sea instance = new Sea(13, 17, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c;
        c = instance.addCreature(position, "Shark", spawn, parent, starve);

        SeaPosition newPos = new SeaPosition(5,3, instance);
        instance.moveCreature(c, newPos);
        String expResult = "(5,3)";
        String result = String.format("%s", c.getPosition());
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCreature method, of class Sea.
     */
    @Test
    public void testRemoveCreature() {
        System.out.println("removeCreature");
        int spawn = 5;
        int starve = 3;
        int parent = 42;
        
        Sea instance = new Sea(13, 17, SeaTest.random);
        SeaPosition position = new SeaPosition(3,5, instance);
        SeaCreature c;
        c = instance.addCreature(position, "Shark", spawn, parent, starve);
        instance.removeCreature(c);

        SeaCreature expResult = null;
        SeaCreature result = instance.getCell(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of takeTurns method, of class Sea.
     */
//    @Test
//    public void testTakeTurns() {
//        System.out.println("takeTurns");
//        Sea instance = null;
//        instance.takeTurns();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
