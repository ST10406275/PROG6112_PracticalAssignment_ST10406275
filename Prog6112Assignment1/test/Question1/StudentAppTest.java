/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Question1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author musankosi
 */
public class StudentAppTest {

    private StudentApp studentApp;

    public void setUp() {
        studentApp = new StudentApp();
    }

    @Test
    public void testSaveStudent() {
        String input = "123\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    public void testSearchStudent() {

        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    public void testSearchStudent_StudentNotFound(Object result) {
        String input = "999\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertNull(result);
    }

    @Test
    public void testDeleteStudent() {
        

        String input = "123\ny\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

       

       
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        

        String input = "999\ny\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

       

        
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        String input = "20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        String input = "15\n20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        String input = "abc\n20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }
}
