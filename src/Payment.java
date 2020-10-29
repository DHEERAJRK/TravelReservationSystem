public class Payment {
    public static Boolean validate(Long cardNumber)
    {
        if(String.valueOf(cardNumber+"").length() == 16)
        {
            return true;
        }
        else
            return false;
    }
}
