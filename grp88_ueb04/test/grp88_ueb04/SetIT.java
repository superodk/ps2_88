/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ODK
 */
public class SetIT {
    
    public SetIT() {
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
     * Test of isEmpty method, of class Set.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Set instance = new Set();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSame method, of class Set.
     */
    @Test
    public void testIsSame() {
        System.out.println("isSame");
        Set other = null;
        Set instance = new Set();
        boolean expResult = false;
        boolean result = instance.isSame(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addValue method, of class Set.
     */
    @Test
    public void testAddValue() {
        System.out.println("addValue");
        char value = ' ';
        Set instance = new Set();
        instance.addValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
