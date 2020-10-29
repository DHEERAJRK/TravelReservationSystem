import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripDB
{
    public static ArrayList<String> getNewTrips()
    {
        ArrayList<String> newTrips = new ArrayList<>();
        try
        {
            newTrips = new ArrayList<>();
            File myObj = new File("C:\\Users\\dheer\\IdeaProjects\\TORS\\newTrips.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                newTrips.add(data.split(":")[0]);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newTrips;
    }

    public static String getSelectedTripDetails(String tripName)
    {
        try
        {
            File myObj = new File("C:\\Users\\dheer\\IdeaProjects\\TORS\\newTrips.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                if(data.indexOf(tripName)!=-1)
                {
                    myReader.close();
                    return data;
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }

    public static ArrayList<String> getMyTrips()
    {
        ArrayList<String> myTrips = new ArrayList<>();
        try
        {
            myTrips = new ArrayList<>();
            File myObj = new File("C:\\Users\\dheer\\IdeaProjects\\TORS\\myTrips.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                myTrips.add(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myTrips;
    }

    public static void updateMyTrips(String PNR, String tripDetails, int passengers)
    {
        try {
            File file = new File("C:\\Users\\dheer\\IdeaProjects\\TORS\\myTrips.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n \n");
            fr.write("PNR: "+ PNR+ "\n" +"Itinerary :"+ tripDetails + "\n" + "Number of Passengers: "+passengers);
            fr.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
