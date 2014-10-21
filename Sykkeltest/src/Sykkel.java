import java.text.DateFormat;
import java.util.*;

/**
 * Created by yuanxin huang 21.10.14 s184519.this is goood
 */
public class Sykkel {
    public static void getDate(){
    Date datenow = new Date();
    DateFormat df = DateFormat.getInstance();
    String utskrift = df.format(datenow);
        System.out.printf(utskrift);
    }
}

