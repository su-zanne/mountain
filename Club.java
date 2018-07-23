import java.util.ArrayList;

/**
 * The Club class holds information about all climbers.
 * 
 * It includes methods to return the climber who has recorded the highest 
 * average mountain height; the highest mountain climbed by a member of 
 * the club; and a list of all mountains that have been climbed that are higher
 * than a given level.
 *
 * @author Susannce Christensen
 * @version 26/10/2017
 */
public class Club
{
    private ArrayList<Climber> climbers;

    /**
     * Create a new Club object.
     */
    public Club()
    {
        climbers = new ArrayList<Climber>();
    }

    /**
     * Add a climber to the club.
     * 
     * @param   newClimber      The newer climber to be added to the club.
     */
    public void addClimber(Climber newClimber)
    {

        Climber climber = searchClimber(newClimber.getName());
        if(climber == null){
            climbers.add(newClimber);
        }
    }

    /**
     * Return list of all climbers in the club.
     * 
     * @return      Return list of all climbers in the club. 
     */
    public ArrayList<Climber> listAllClimbers()
    {
        return climbers;
    }

    /**
     * Return climber who has climbed the highest average height.
     * 
     * @return      Return climber who has climbed the highest average height. 
     */
    public Climber highestAverage()
    {
        double average = 0;
        Climber climberRecordAverage = new Climber("default", 99, "default");
        for(Climber climber : climbers) {
            if(climber.averageAllMountains() > average) {
                average = climber.averageAllMountains();
                climberRecordAverage = climber;
            }
        }
        return climberRecordAverage;
    }

    /**
     * Return the highest mountain recorded by a member of the club.
     *
     * @return  The highest mountain recorded by a member of the club.
     */
    public Mountain highestMountain()
    {
        int height = 0;
        Mountain highest = new Mountain("default",0);
        for(Climber climber : climbers) {
            if(climber.getHighestMountain().getHeight() > height)
            {
                height = climber.getHighestMountain().getHeight();
                highest = climber.getHighestMountain(); 
            }    
        }
        return highest;
    }

    /**
     * List of all mountains that have been climbed by club members that are 
     * higher than a given level.
     * 
     * @param heigherThan   Search for mountains higher than this value.
     * @return   List of mountains higher than the given level.
     */
    public ArrayList searchMountains(int heigherThan)
    {
        ArrayList<Mountain> allMountains = new ArrayList<Mountain>();
        ArrayList<Mountain> heighestMountains = new ArrayList<Mountain>();
        for(Climber climber : climbers) {
            heighestMountains = climber.searchMountains(heigherThan);     
            for(Mountain m : heighestMountains) {
                allMountains.add(m); 
            }
        }
        return allMountains;
    } 

    /**
     * This method takes a String as a parameter. It then searches through 
     * all the climbers of the club to check for a match. If no match is found
     * it will return null.
     * 
     * @param    searchClimber  The search String.
     * @return    The climber match. Or null if no match.
     */
    public Climber searchClimber(String searchClimber)
    {
        String name = "default";
        Climber searchedClimber = null;

        for(Climber climber : climbers) {
            name = climber.getName();
            if(name.equals(searchClimber)) {
                searchedClimber = climber;    

            }    

        }
        return searchedClimber;
    }
}