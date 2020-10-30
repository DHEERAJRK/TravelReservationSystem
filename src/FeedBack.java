import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FeedBack {
    public String getFeedBack(String email)
    {
        System.out.println("\n Please share your valuable feedback with us");
        Scanner sn = new Scanner(System.in);
        String feedBack = sn.nextLine();
        String storeFeedBack = storeFeedBack(feedBack, email);
        return storeFeedBack;
    }
    private String storeFeedBack(String feedBack, String email)
    {
        try {
            File file = new File("feedBack.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n");
            fr.write(email);
            fr.write("\n");
            fr.write(feedBack);
            fr.close();
            String thanksForFeedBack =  email+ " \nThanks for your valuable time, we will store and analyse your feedback : " + feedBack;
            System.out.println(thanksForFeedBack);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
