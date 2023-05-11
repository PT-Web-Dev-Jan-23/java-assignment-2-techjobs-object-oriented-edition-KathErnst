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
        assertNotEquals(testJob1, testJob2);
    }

}
