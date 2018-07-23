import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClimberTest.
 *
 * @author  Susanne Christensen
 * @version 11/11/2017
 */
public class ClimberTest
{
    private Climber climber1;
    /**
     * Nothing to do here.
     */
    public ClimberTest()
    {
    }

    /**
     * Sets up a new climber as the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        climber1 = new Climber("testClimber", 22, "female");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that the name of climber can be changed.
     */
    @Test
    public void testSetName()
    {
        climber1.setName("Bob");
        assertEquals("Bob", climber1.getName());
    }

    /**
     * Test that the age of climber can be changed.
     */
    @Test
    public void testSetValidAge()
    {
        climber1.setAge(25);
        assertEquals(25, climber1.getAge());
    }

    /**
     * Test that the age of climber is not changed in case of invalid age (low
     * value).
     */
    @Test
    public void testSetInvalidAgeLow()
    {
        climber1.setAge(-100);
        assertEquals(22, climber1.getAge());
    }

    /**
     * Test that the age of climber is not changed in case of invalid age
     * (high value).
     */
    @Test
    public void testSetAgeInvalidHigh()
    {
        climber1.setAge(200);
        assertEquals(22, climber1.getAge());
    }

    /**
     * Test that the highest mountain is returned.
     */
    @Test
    public void testGetHighestMountain()
    {
        Mountain mountain1 = new Mountain("testMountain1", 1000);
        Mountain mountain2 = new Mountain("testMountain2", 800);
        Mountain mountain3 = new Mountain("testMountain3", 2000);
        Mountain mountain4 = new Mountain("testMountain4", 100);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        Mountain mountain5 = climber1.getHighestMountain();
        assertNotNull(mountain5);
        assertEquals("testMountain3", mountain5.getName());
    }

    /**
     * Test that mountains can be added to the collection.
     */
    @Test
    public void testAddMountain()
    {
        Mountain mountain1 = new Mountain("testMountain1", 800);
        Mountain mountain2 = new Mountain("testMountain2", 1000);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        java.util.ArrayList<Mountain> arrayLis1 = climber1.listAllMountains();
        assertNotNull(arrayLis1);
        Mountain mountain3 = (Mountain)arrayLis1.get(0);
        Mountain mountain4 = (Mountain)arrayLis1.get(1);
        assertNotNull(mountain3);
        assertNotNull(mountain4);
        assertEquals("testMountain1", mountain3.getName());
        assertEquals("testMountain2", mountain4.getName());
    }

    /**
     * Test that the listAllMountains method returns all mountains from
     * the collection.
     */
    @Test
    public void testListAllMountains()
    {
        Mountain mountain1 = new Mountain("testMountain1", 800);
        Mountain mountain2 = new Mountain("testMountain2", 1000);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        java.util.ArrayList<Mountain> arrayLis1 = climber1.listAllMountains();
        assertNotNull(arrayLis1);
        assertEquals(2, arrayLis1.size());
    }

    /**
     * Test that the average height of all mountains is returned.
     */
    @Test
    public void testAverageHeight()
    {
        Mountain mountain1 = new Mountain("testMountain1", 800);
        Mountain mountain2 = new Mountain("testMountain2", 1000);
        Mountain mountain3 = new Mountain("testMountain3", 99);
        Mountain mountain4 = new Mountain("testMountain4", 1089);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        assertEquals(747.0, climber1.averageAllMountains(), 0.1);
    }

    /**
     * Test that the average height of all mountains is correctly returned
     * when expected result includes decimals.
     */
    @Test
    public void testAverageHeightDecimals()
    {
        Mountain mountain1 = new Mountain("testMountain1", 82);
        Mountain mountain2 = new Mountain("testMountain2", 11);
        Mountain mountain3 = new Mountain("testMountain3", 877);
        Mountain mountain4 = new Mountain("testMountain4", 1089);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        assertEquals(514.75, climber1.averageAllMountains(), 0.1);
    }

    /**
     * Test that only mountains higher than a given level is returned.
     */
    @Test
    public void testSearchMountains()
    {
        Mountain mountain1 = new Mountain("testMountain1", 800);
        Mountain mountain2 = new Mountain("testMountain2", 1000);
        Mountain mountain3 = new Mountain("testMountain3", 99);
        Mountain mountain4 = new Mountain("testMountain4", 1089);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        java.util.ArrayList<Mountain> arrayLis1 = climber1.searchMountains(900);
        assertNotNull(arrayLis1);
        assertEquals(2, arrayLis1.size());
    }

    /**
     * Test that only mountains higher than a given level is returned when 
     * doing a boundary search (searching for the same height as one of the 
     * mountains).
     */
    @Test
    public void testSearchMountainsBoundary()
    {
        Mountain mountain1 = new Mountain("testMountain1", 800);
        Mountain mountain2 = new Mountain("testMountain2", 1000);
        Mountain mountain3 = new Mountain("testMountain3", 99);
        Mountain mountain4 = new Mountain("testMountain4", 1089);
        climber1.addMountain(mountain1);
        climber1.addMountain(mountain2);
        climber1.addMountain(mountain3);
        climber1.addMountain(mountain4);
        java.util.ArrayList<Mountain> arrayLis1 = climber1.searchMountains(800);
        assertNotNull(arrayLis1);
        assertEquals(2, arrayLis1.size());
    }
}