/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Question1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author musankosi
 */
public class SectionATest {
    
    public SectionATest() {
    }
    
    
    /**
     * Test of main method, of class SectionA.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SectionA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStudent method, of class SectionA.
     */
    @Test
    public void testSearchStudent() {
        System.out.println("searchStudent");
        String s124 = "";
        SectionA instance = new SectionA();
        Student expResult = null;
        Student result = instance.searchStudent(s124);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
