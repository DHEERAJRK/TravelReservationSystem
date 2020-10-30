import java.util.ArrayList;
import java.util.Scanner;

public class TORS {
    static Scanner sn = new Scanner(System.in);
    public static void main(String []args)
    {
        welcomeUser();
        int path = sn.nextInt();
        if(path == 1)
        {
            getTrips();
        }
        else if(path == 2)
        {
            ArrayList<String> myTrips = TripDB.getMyTrips();
            if(myTrips.isEmpty())
            {
                System.out.println("Sorry!! No Reservation found");
            }
            else {
                for (String trip : myTrips) {
                    System.out.println(trip);
                }
            }
        }
        else
        {
            System.out.println("Please enter a valid input");
            System.exit(0);
        }
    }

    public static void getTrips()
    {
        ArrayList<String> newTrips = TripDB.getNewTrips();
        for (String trip : newTrips)
        {
            System.out.println(trip.split(":")[0]);
        }
        String tripDetails = getTripDetails(sn);
        if(tripDetails.isEmpty()) {
            System.out.println("Sorry no such trip found, Please select a valid Trip");
            getTrips();
        }
        else {
            System.out.println(tripDetails);
            System.out.println("Enter 1 to proceed with this trip");
            System.out.println("Enter 2 to get all the trips");
            int proceedOrNot = sn.nextInt();
            if (proceedOrNot == 1) {
                System.out.println("Enter number of passengers");
                int passengers = sn.nextInt();
                if(passengers > 0) {
                    int totalFare = Reservation.getTotalFare(tripDetails, passengers);
                    System.out.println("Total Fare for selected trip is " + totalFare);
                    PayAndReserve(tripDetails, passengers);
                }
                else{
                    System.out.println("Not a valid input - Passengers should be more than 0");
                }
            } else {
                getTrips();
            }
        }
    }

    public static void PayAndReserve(String tripDetails, int passengers) {
        System.out.println("Please enter your Credit card Number");
        Long cardNumber = sn.nextLong();
        String PNR = Reservation.reserveTrip(tripDetails, passengers,cardNumber);
        System.out.println("Congratulations your reservation is completed, Below are the trip details");
        System.out.println("PNR: "+ PNR+ "\n" +"Itinerary :"+ tripDetails + "\n" + "Number of Passengers: "+passengers);
        FeedBack fb = new FeedBack();
        fb.getFeedBack();
        System.exit(0);
    }

    private static String getTripDetails(Scanner sn) {
        System.out.println("Please choose a trip(Enter the trip Name) to get the details");
        String tripName = sn.next();
        String tripDetails = TripDB.getSelectedTripDetails(tripName);
        if(tripDetails.isEmpty())
        {
            return "";
        }
        else
        {
            return tripDetails;
        }
    }

    private static void welcomeUser()
    {
        System.out.println("Welcome Vikas");
        System.out.println("Please choose from the below list");
        System.out.println("Select 1 --> Show available trips");
        System.out.println("Select 2 --> Show reserved trips");
    }
}
