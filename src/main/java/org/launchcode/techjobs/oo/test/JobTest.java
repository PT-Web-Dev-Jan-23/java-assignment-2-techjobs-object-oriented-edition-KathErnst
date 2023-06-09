package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());
        assertTrue(testJob1 instanceof Job);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Rollercoaster Monitor", new Employer("Six Flags"), new Location("Eureka"), new PositionType("Safety"), new CoreCompetency("Friendly"));
        Job testJob2 = new Job("Rollercoaster Monitor", new Employer("Six Flags"), new Location("Eureka"), new PositionType("Safety"), new CoreCompetency("Friendly"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob1 = new Job("Rollercoaster Monitor", new Employer("Six Flags"), new Location("Eureka"), new PositionType("Safety"), new CoreCompetency("Friendly"));
        char expected = '\n';
        char actual1 = testJob1.toString().charAt(0);
        char actual2 = testJob1.toString().charAt(testJob1.toString().length() -1);
        assertEquals(expected, actual1);
        assertEquals(expected,actual2);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJobA = new Job("Rollercoaster Monitor", new Employer("Six Flags"), new Location("Eureka"), new PositionType("Safety"), new CoreCompetency("Friendly"));
        String expected = "\nID: " + testJobA.getId() + "\nName: " + testJobA.getName() +"\nEmployer: " +
                testJobA.getEmployer() + "\nLocation: " + testJobA.getLocation() + "\nPosition Type: " +
                testJobA.getPositionType() + "\nCore Competency: " + testJobA.getCoreCompetency() + "\n";
        String actual = testJobA.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob5 = new Job("Rollercoaster Monitor",
                new Employer("Six Flags"),
                new Location("Eureka"),
                new PositionType(""),
                new CoreCompetency(""));
        String expected = "\nID: " + testJob5.getId() + "\n" + "Name: Rollercoaster Monitor\n" + "Employer: Six Flags\n" + "Location: Eureka\n" +
                "Position Type: Data not available\n" + "Core Competency: Data not available\n";
        String actual = testJob5.toString();
        assertEquals(expected, actual);
    }

}
