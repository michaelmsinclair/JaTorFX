/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sinclair.jator.model;

import java.util.ArrayList;
import java.util.Collections;
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
public class SeaPositionTest {

    static Random random = new Random(42);
    private final Sea aSea;

    public SeaPositionTest() {
        this.aSea = new Sea(10, 10, random);
    }

    @BeforeClass
    public static void setUpClass() {
        Sea aSea = new Sea(10, 10, random);
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
     * Test of getX method, of class SeaPosition.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        SeaPosition instance = new SeaPosition(1, 2, this.aSea);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class SeaPosition.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        SeaPosition instance = new SeaPosition(1, 2, this.aSea);
        int expResult = 2;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjacentCreatures method, of class SeaPosition.
     */
    @Test
    public void testGetAdjacentCreatures() {
        System.out.println("getAdjacentCreatures");
        SeaPosition instance = new SeaPosition(3, 5, this.aSea);
        List<SeaCreature> expResult;
        expResult = new ArrayList<>();
        List<SeaCreature> result = instance.getAdjacentCreatures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjacentFree method, of class SeaPosition.
     */
    @Test
    public void testGetAdjacentFree() {
        System.out.println("getAdjacentFree");
        SeaPosition instance = new SeaPosition(3, 5, this.aSea);
        List<SeaPosition> expResult = new ArrayList<>();
        for (int x = 2; x < 5; x++) {
            for (int y = 4; y < 7; y++) {
                if (!(x == 3 && y == 5)) {
                    SeaPosition sp;
                    sp = new SeaPosition(x, y, this.aSea);
                    expResult.add(sp);
                }
            }
        }
        List<SeaPosition> result = instance.getAdjacentFree();
        Collections.sort(expResult);
        Collections.sort(result);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SeaPosition.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SeaPosition instance = new SeaPosition(5, 7, this.aSea);
        String expResult = "(5,7)";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class SeaPosition.
     */
    @Test
    public void testCompareToEqual() {
        //Equal
        System.out.println("compareTo");
        Object t = new SeaPosition(5, 7, this.aSea);
        SeaPosition instance = new SeaPosition(5, 7, this.aSea);
        int expResult = 0;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToLess() {
        Object t = new SeaPosition(8, 7, this.aSea);
        SeaPosition instance = new SeaPosition(5, 7, this.aSea);
        int expResult = -3;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testCompareToGreater() {
        Object t = new SeaPosition(5, 7, this.aSea);
        SeaPosition instance = new SeaPosition(7, 13, this.aSea);
        int expResult = 2;
        int result = instance.compareTo(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
