import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 * This class contains the main method of the project. It presents the user 
 * with a printed menu. From the menu the user can add new climbers to the club,
 * and add details of climbed mountains to the record for a given climber.
 * 
 * Furthermode the user will be able to view the following club statistics: the 
 * climber who has recorded the highest average mountain height; the highest
 * mountain recorded by a club member; and all mountains recorded with a height
 * greater than a given level.
 *
 * @author Susanne Christensen
 * @version 02/11/2017
 */
public class ClubStats
{
    private boolean exit;
    private Club club;

    /**
     * The main method of the project, which creates an ClubStats object and
     * runs the menu.
     */
    public static void main(String[] args)
    {
        ClubStats clubStats = new ClubStats();
        clubStats.startMenu();
    }

    /**
     * The constructor will create a Club object and assign it to the club 
     * instance variable. It will also set the boolean instance varible "exit"
     * to false.
     */

    public ClubStats()
    {
        club = new Club();
        exit = false;
    }
    
    /**
     * This method will run the menu until the user exits, or in other words: 
     * as long as the the boolean instance variable exit is false.
     * 
     * It lets the user input a number from 1-6. If the user
     * enters a character outside the valid range, they will be prompted 
     * to enter a number again.
     */
    public void startMenu()
    {
        printHeader();
        while(!exit){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int input = 0;
            while(input < 1 || input > 6){
                try{
                    System.out.println("");
                    System.out.print("Please enter a number from 1-6: ");
                    input = Integer.parseInt(scanner.nextLine()); 
                }
                catch(NumberFormatException e) {
                }
            }
            menuSelection(input);
        }
    }

    /**
     * This method executes a path depending on which number from 1-6 
     * is selected.
     *
     * @param    number     The selected integer.
     */

    private void menuSelection(int number)
    {
        Scanner mainMenuReturn = new Scanner(System.in);
        String userSelection = "default";
        switch(number) {
            case 1:
            addClimber();
            System.out.println("");
            System.out.print("Press any key to return to main menu: ");
            userSelection = mainMenuReturn.nextLine();
            System.out.println("");
            printHeader();
            break;

            case 2: 
            addMountain();
            System.out.println("");
            System.out.print("Press any key to return to the main menu: ");
            userSelection = mainMenuReturn.nextLine();
            System.out.println("");
            printHeader();
            break;

            case 3:
            highestAverage();
            System.out.println("");
            System.out.print("Press any key to return to the main menu: ");
            userSelection = mainMenuReturn.nextLine();
            System.out.println("");
            printHeader();
            break;

            case 4:
            highestMountain();
            System.out.println("");
            System.out.print("Press any key to return to the main menu: ");
            userSelection = mainMenuReturn.nextLine();
            System.out.println("");
            printHeader();
            break;

            case 5:
            listMountains();
            System.out.println("");
            System.out.print("Press any key to return to the main menu: ");
            userSelection = mainMenuReturn.nextLine();
            System.out.println("");
            printHeader();
            break;

            case 6:
            exit = true;
            System.out.println("");
            System.out.println("Goodbye.");
            System.out.println("Thank you for using the Misty Mountains programme.");
            System.out.println("");
            break;

            default:
            System.out.println("Error");
        }
    }

    /**
     * This method prompts the user to enter the name, age and gender of
     * a new climber.
     * 
     * If a climber by the same name already exists, or if the user enters an
     * invalid age range they will be prompted to enter the details for 
     * the climber again.
     * 
     * In the case of valid user input a new climber will be created and
     * added to the club
     */
    private void addClimber()
    {
        printClimberHeader();
        boolean test = false;
        Scanner userInput = new Scanner(System.in);
        while(test == false){
            try{
                //Name of climber.
                System.out.print("Please enter name of climber: ");
                String climberName = userInput.nextLine();
                Climber climber = club.searchClimber(climberName); // Uses the searchClimber method to check if climber already exists
                //Age of climber
                System.out.print("Please enter age of climber: ");
                int climberAge = Integer.parseInt(userInput.nextLine());   
                //Gender of climber
                System.out.print("Please enter gender of climber: ");
                String climberGender = userInput.nextLine();
                if(climber != null){
                    System.out.println("");
                    System.out.println("A climber by that name already exists. Please try again.");
                    System.out.println("");
                }

                else if(climberAge < 0 || climberAge > 150) {
                    System.out.println("");
                    System.out.println("Invalid age range. You must enter an age between 0-150");
                    System.out.println("");
                }

                else {
                    Climber newClimber = new Climber("default", 0, "default");
                    newClimber.setName(climberName);
                    newClimber.setAge(climberAge);
                    newClimber.setGender(climberGender);
                    club.addClimber(newClimber);
                    System.out.println("");
                    System.out.println("You have successfully added the"); 
                    System.out.println("following climber to the club:");
                    System.out.println("");
                    System.out.println("=====================================");
                    System.out.println("Name: " + climberName);
                    System.out.println("Age: " + climberAge);
                    System.out.println("Gender: " + climberGender);
                    System.out.println("=====================================");
                    test = true;  
                }
            }
            catch(NumberFormatException e) {
                System.out.println("");
                System.out.println("Invalid age range. You must enter an age between 0-150");
                System.out.println("");
            }
        }
    }

    /**
     * This method prompts the user to enter the name of the climber they
     * wish to record a mountain for.
     * 
     * If the climber exists the user will be promted to enter the name and
     * height of the mountain they wish to record. The details of the mountain
     * will be added to the climber's record.
     */
    private void addMountain()
    {
        boolean userInput = false;
        while(userInput == false){
            try{
                Scanner searchString = new Scanner(System.in);
                System.out.println("");
                System.out.println("Search for the climber you wish to add a mountain for.");
                System.out.println("Note: the climber must be a member of the club");
                System.out.println("");
                System.out.print("Please enter exact name of climber (case-sensitve): ");
                String climberName = searchString.nextLine();
                Climber climber = club.searchClimber(climberName);
                if(climber == null){
                    System.out.println("");
                    //In case of no match user is returned to menu to prevent them being stuck in loop if no climbers exist yet.
                    System.out.println("No match. Next time enter exact name of climber.");
                    userInput = true;
                }
                else{
                    printMountainHeader();
                    Scanner mountainName = new Scanner(System.in);
                    Scanner mountainHeight = new Scanner(System.in);
                    System.out.print("Please enter name of mountain: ");
                    String selectName = mountainName.nextLine();
                    System.out.print("Please enter height of mountain: ");
                    int selectHeight = Integer.parseInt(mountainHeight.nextLine());
                    if(selectHeight <= 0 || selectHeight > 8850) {
                        System.out.println("");
                        System.out.println("Not valid height. Please enter a number between 1-8850"); 
                    }
                    else {
                        Mountain mountain = new Mountain("default", 0);
                        climber.addMountain(mountain);
                        mountain.setName(selectName);
                        mountain.setHeight(selectHeight);
                        System.out.println("");
                        System.out.println("You have successfully added the"); 
                        System.out.println("following mountain:");
                        System.out.println("");
                        System.out.println("=====================================");
                        System.out.println("Name: " + selectName);
                        System.out.println("Height: " + selectHeight);
                        System.out.println("Climbed by: " + climber.getName());
                        System.out.println("=====================================");
                        userInput = true;
                    }
                }
            }
            catch(NumberFormatException e) {
                System.out.println("");
                System.out.println("Not valid height. Please enter a number between 1-8850");
            }
        }
    }

    /**
     * This method prints the name of the climber who has recorded the
     * highest average mountain height.
     */
    private void highestAverage()
    {
        printStatisticsHeader();
        Climber climber = club.highestAverage();
        String highestAverageClimber = climber.getName();
        System.out.println("The climber who has recorded the highest ");
        System.out.println("average mountain height.");
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("Name of climber: " + highestAverageClimber);
        System.out.println("=====================================");
        System.out.println("");
    }

    /**
     * This method prints the name of the highest mountain recorded by
     * a club climber.
     */
    private void highestMountain()
    {
        printStatisticsHeader();
        Mountain mountainHighest = club.highestMountain();
        String nameHighestMountain = mountainHighest.getName(); 
        System.out.println("The the highest mountain climbed");
        System.out.println("by any member of the club.");
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("Name of mountain: " + nameHighestMountain);
        System.out.println("=====================================");
        System.out.println("");
    }

    /**
     * This method prints a list of all recorded mountains higher than a 
     * given level.
     */
    private void listMountains()
    {
        try{printStatisticsHeader();
            Scanner searchHeight = new Scanner(System.in);
            System.out.println("All mountains recorded with a height");
            System.out.println("greater than a given level. ");
            System.out.println("");
            System.out.print("Please enter a height: ");
            int selectHeight = Integer.parseInt(searchHeight.nextLine());
            ArrayList<Mountain> mountainList = club.searchMountains(selectHeight);
            System.out.println("");
            System.out.println("=====================================");
            System.out.println("");
            System.out.println("All mountains higher than " + selectHeight + " metres:");
            System.out.println("");
            for(Mountain mountain : mountainList) {
                System.out.println(mountain.getName());      
            }
            System.out.println("=====================================");
            System.out.println("");
        }
        catch(NumberFormatException e) {
            System.out.println("Not valid input");
        }
    }

    /**
     * The printed menu.
     */
    private void printMenu()
    {
        System.out.println("");
        System.out.println("  Menu options:                      ");
        System.out.println("                                     ");
        System.out.println(" [1] Add a new climber to the club   ");
        System.out.println(" [2] Add a new mountain              ");
        System.out.println(" [3] Statistics: Highest average     ");
        System.out.println(" [4] Statistics: Highest mountain    "); 
        System.out.println(" [5] Statistics: List of mountains   ");
        System.out.println(" [6] Exit                            ");
        System.out.println("");
    }

    /**
     * The printed header.
     */
    private void printHeader()
    {
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("      THE MISTY MOUNTAINS CLUB       ");
        System.out.println("=====================================");
    }

    /**
     * The printed climber details header.
     */
    private void printClimberHeader()
    {
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("         CLIMBER DETAILS:            ");
        System.out.println("=====================================");
        System.out.println("");
    }

    /**
     * The printed statistics header.
     */
    private void printStatisticsHeader()
    {
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("         STATISTICS:                 ");
        System.out.println("=====================================");
        System.out.println("");
    }

    /**
     * The printed mountains details header.
     */
    private void printMountainHeader()
    {
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("         MOUNTAIN DETAILS:           ");
        System.out.println("=====================================");
        System.out.println("");
    }
}