import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 *
 * @author  Susanne Christensen
 * @version 11/11/2017
 */
public class ClubTest
{
    private Club club1;
    private Climber climber1;
    private Climber climber2;
    private Climber climber3;
    private Mountain mountain1;
    private Mountain mountain2;
    private Mountain mountain3;
    private Mountain mountain4;
    private Mountain mountain5;

    /**
     * Nothing to do here.
     */
    public ClubTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        club1 = new Club();
        climber1 = new Climber("testClimber1", 10, "male");
        climber2 = new Climber("testClimber2", 88, "female");
        climber3 = new Climber("testClimber3", 39, "other");
        club1.addClimber(climber1);
        club1.addClimber(climber2);
        club1.addClimber(climber3);
        mountain1 = new Mountain("testMountain1", 900);
        mountain2 = new Mountain("testMountain2", 1089);
        mountain3 = new Mountain("testMountain3", 2071);
        mountain4 = new Mountain("testMountain4", 7011);
        mountain5 = new Mountain("testMountain5", 30);
        climber1.addMountain(mountain1);
        climber2.addMountain(mountain2);
        climber2.addMountain(mountain3);
        climber3.addMountain(mountain4);
        climber3.addMountain(mountain5);
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
     * Test that climbers can be added to the club.
     */
    @Test
    public void testAddClimbers()
    {
        java.util.ArrayList<Climber> arrayLis1 = club1.listAllClimbers();
        assertNotNull(arrayLis1);
        assertEquals(3, arrayLis1.size());
    }
    
    /**
     * Test that a climber is not added to the club if a climber by the same
     * name already is recorded by the club.
     */
    @Test
    public void testAddDuplicateClimber()
    {
        Climber climber4 = new Climber("testClimber1", 51, "other");
        club1.addClimber(climber4);
        java.util.ArrayList<Climber> arrayLis1 = club1.listAllClimbers();
        assertNotNull(arrayLis1);
        assertEquals(3, arrayLis1.size());
    }
    
    /**
     * Test that the climber who has climbed the highest average height is
     * returned (with an average height of 3520.5 metres this would be
     * testClimber3)
     */
    @Test
    public void testRecordAverageClimber()
    {
        Climber climber4 = club1.highestAverage();
        assertNotNull(climber4);
        assertEquals("testClimber3", climber4.getName());
    }

     /**
     * Test that the highest recorded mountain is returned.
     */
    @Test
    public void testHighestMountain()
    {
        Mountain mountain6 = club1.highestMountain();
        assertNotNull(mountain6);
        assertEquals("testMountain4", mountain6.getName());
    }

     /**
     * Test that a list of all mountains higher than a given level is returned.
     */
    @Test
    public void testHighestMountainList()
    {
        java.util.ArrayList arrayLis1 = club1.searchMountains(2000);
        assertNotNull(arrayLis1);
        assertEquals(2, arrayLis1.size());
    }
    
     /**
     * Test that the searchClimber method returns null if the climber is
     * not recorded in the club.
     */
    @Test
    public void testSearchClimberNull()
    {
        assertNull(club1.searchClimber("test"));
    }
    
     /**
     * Test that the searchClimber method returns not null if the climber is
     * recorded in the club.
     */
    @Test
    public void testSearchClimberNotNull()
    {
        assertNotNull(club1.searchClimber("testClimber1"));
    }
}

