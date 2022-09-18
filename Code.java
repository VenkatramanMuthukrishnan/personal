import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import okhttp3.*;

import java.io.IOException;

public class Finder {
    public static void main(String[] args) throws IOException, UnirestException {
        String PrefixString="7010,7092";
        String[] prefixs=PrefixString.split(",");
        String last2Digit="01";
        for (String phonePrefix:
             prefixs) {
            System.out.println("====VENKAT=== prefix"+phonePrefix);
            for (int i = 60; i <= 120; i++) {
                String middlePart=String.format("%04d", i);
                String finalPhoneNumber=new StringBuilder(phonePrefix).append(middlePart).append(last2Digit).toString();
                System.out.println("====VENKAT=== now in "+finalPhoneNumber);
                Unirest.setTimeouts(0, 0);
                HttpResponse<String> response = Unirest.get("https://search5-noneu.truecaller.com/v2/search?countryCode=in&q="+
                        finalPhoneNumber+"&type=4")
                                .header("Connection", "keep-alive")
                                .header("Accept", "*/*")
                                .header("Accept-Encoding", "br;q=1.0, gzip;q=0.9, deflate;q=0.8")
                                .header("Host", "search5-noneu.truecaller.com")
                                .header("User-Agent", "Truecaller/12.2.6 (com.truesoftware.TrueCallerOther; build:12.2.6; iOS 16.0.0) Alamofire/5.5.0")
                                .header("Accept-Language", "en-IN;q=1.0, ta-IN;q=0.9")
                                .header("Authorization", "Bearer a2i0K--aePrO3FUF28pQ7jnFP7RZcr94qqIMLm6wViynQ3Wb-D3a8LXKk6VnCuGU")
                                .asString();
                System.out.println(response.getBody());
            }

        }
        
    }
}
