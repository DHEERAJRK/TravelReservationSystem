import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reservation {
    public static int getTotalFare(String tripDetails, int passengers)
    {
        try
        {
            File myObj = new File("newTrips.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                if(data.indexOf(tripDetails)!=-1)
                {
                    myReader.close();
                     String price = data.split("\\$")[1].trim();
                     int totalPrice = Integer.parseInt(price) * passengers;
                     return totalPrice;
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }
    public static String reserveTrip(String tripDetails, int passengers, Long cardNumber, String email)
    {
        Boolean validate = Payment.validate(cardNumber);
        if(validate)
        {
            return generatePNR(tripDetails,passengers);
        }
        else
        {
            System.out.println("Sorry Invalid card Number, Enter a valid CreditCard number");
            TORS.PayAndReserve(tripDetails,passengers, email);
        }
        return "";
    }

    private static String generatePNR(String tripDetails, int passengers) {

        String PNR = tripDetails.substring(0,1).toUpperCase()+tripDetails.substring(4,5).toUpperCase()+passengers*10+ (int)((Math.random() * (10000 - 1000)) + 1000);
        TripDB.updateMyTrips(PNR, tripDetails, passengers);
        return PNR;
    }
}
