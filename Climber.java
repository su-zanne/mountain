import java.util.ArrayList;

/**
 * The objects of the Climber class store and return details about 
 * climbers, namely their name, age and gender.
 * 
 * Each climber object will also store a list of mountains that have been 
 * climbed by the climber.
 *
 * @author Susanne Christensen
 * @version 17/10/2017
 */
public class Climber
{
    private String name;
    private int age;
    private String gender;
    private ArrayList<Mountain> mountains;

    /**
     * Create a new climber object.
     * 
     * @param   climberName     The name of the climber.
     * @param   climberAge      The age of the climber.
     * @param   climberGender   The gender of the climber.
     */
    public Climber(String climberName, int climberAge, String climberGender)
    {
        name = climberName;
        age = climberAge;
        gender = climberGender;
        mountains = new ArrayList<Mountain>();
    }

    /**
     * Return the name of the climber.
     *
     * @return    The name of the climber.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the climber.
     *
     * @param    climberName    The name of the climber.
     */
    public void setName(String climberName)
    {
        name = climberName;
    }

    /**
     * Return the age of the climber.
     *
     * @return    The age of the climber.
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Set the age of the climber.
     *
     * @param    climberAge     The age of the climber.
     */
    public void setAge(int climberAge)
    {
        if(climberAge >= 0 && climberAge <= 150) {
            age = climberAge;
        }
    }

    /**
     * Return the gender of the climber.
     *
     * @return    The gender of the climber.
     */
    public String getGender()
    {
        return gender;
    }

    /**
     * Set the gender of the climber.
     *
     * @param    climberGender The gender of the climber.
     */
    public void setGender(String climberGender)
    {
        gender = climberGender;
    }

    /**
     * Add a mountain to the collection.
     * 
     * @param   newMountain     The mountain to be added to the collection.
     *
     */
    public void addMountain(Mountain newMountain)
    {
        mountains.add(newMountain);
    }

    /**
     * Return all the mountains in the collection.
     * 
     * @return      A list of all the mountains in the collection. 
     */
    public ArrayList<Mountain> listAllMountains()
    {
        return mountains;
    }

    /**
     * Return the highest mountain climbed by the climber.
     * 
     * @return      The highest mountain climbed.
     */
    public Mountain getHighestMountain()
    {
        int highestMountain = 0;
        Mountain nameHighestMountain = new Mountain("default", 0);
        for(Mountain mountain : mountains) {
            if(mountain.getHeight() > highestMountain) {  
                highestMountain = mountain.getHeight();
                nameHighestMountain = mountain;
            }

        }
        return nameHighestMountain;
    }

    /**
     * Return the average (in metres) of all the mountains climbed by
     * the climber.
     *
     * @return   The average (in metres) of all the mountains climbed by the climber. 
     */
    public double averageAllMountains()
    {
        double height = 0;
        double average = 0;
        for(Mountain mountain : mountains) {
            height = height + mountain.getHeight();
        }
        if(mountains.size() > 0){
            average = height/mountains.size();

        }
        return average;
    }

    /**
     * List of all mountains that have been climbed that are higher
     * than a given level.
     * 
     * @param heigherThan   Search for mountains higher than this value.
     * 
     * @return heighestMountains  List of mountains higher than the given level.
     */

    public ArrayList searchMountains(int heigherThan)
    {
        ArrayList<Mountain> heighestMountains = new ArrayList<Mountain>();
        for(Mountain mountain : mountains) {
            if(mountain.getHeight() > heigherThan) {    
                heighestMountains.add(mountain);
            }
        }
        return heighestMountains;
    }
}
