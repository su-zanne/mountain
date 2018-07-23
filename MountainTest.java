import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MountainTest.
 *
 * @author  Susanne Christensen
 * @version 08/11/2017
 */
public class MountainTest
{
    /**
     * Nothing to do here.
     */
    public MountainTest()
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
     * Test that the name of mountain can be changed.
     */
    @Test
    public void testSetName()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setName("MagicMountain");
        assertEquals("MagicMountain", mountain1.getName());
    }

     /**
     * Test that the height of mountain can be changed.
     */
    @Test
    public void testSetValidHeight()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setHeight(2000);
        assertEquals(2000, mountain1.getHeight());
    }

     /**
     * Test that mountain height will not be changed if entering negative
     * integer.
     */
    @Test
    public void testHeightLowInvalid()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setHeight(-100);
        assertEquals(1000, mountain1.getHeight());
    }

     /**
     * Test that mountain height will not be changed if entering 0.
     */
    @Test
    public void testZeroHeight()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setHeight(0);
        assertEquals(1000, mountain1.getHeight());
    }

     /**
     * Test that mountain height will not be changed if more than maximum
     * allowed height (8850 meters).
     */
    @Test
    public void testHeightHighInvalid()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setHeight(9000);
        assertEquals(1000, mountain1.getHeight());
    }

     /**
     * Test that mountain height will be changed if entering max allowed 
     * height (8850 meters).
     */
    @Test
    public void testMaxHeight()
    {
        Mountain mountain1 = new Mountain("testMountain", 1000);
        mountain1.setHeight(8850);
        assertEquals(8850, mountain1.getHeight());
    }
}







