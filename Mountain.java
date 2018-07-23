/**
 * The objects of the Mountain class store and return mountain details, 
 * namely the name and height (in metres) of a mountain.
 * 
 * @author Susanne Christensen
 * @version 17/10/2017
 */
public class Mountain
{
    private String name;
    private int height;

    /**
     * Create a new mountain object.
     * 
     * @param   mountainName    The name of the mountain.
     * @param   mountainHeight  The height of the mountain (in metres).
     */
    public Mountain(String mountainName, int mountainHeight)
    {
        name = mountainName;
        height = mountainHeight;
    }

    /**
     * Return the name of the mountain.
     *
     * @return    The name of the mountain.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the name of the mountain.
     *
     * @param   nameMountain     The name of the mountain.
     */
    public void setName(String nameMountain)
    {
        name = nameMountain;
    }

    /**
     * Return the height of the mountain.
     *
     * @return The height of the mountain (in metres).
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Set the height of the mountain. The method will only be excecuted 
     * if the user enters a reasonable height (the maximum height was chosen
     * based on the height of the world's highest mountain).
     *
     * @param    heightMountain     The height of the mountain (in metres).
     */
    public void setHeight(int heightMountain)
    {
        if(heightMountain > 0 && heightMountain <= 8850){ 
            height = heightMountain;  
        }
    }
}