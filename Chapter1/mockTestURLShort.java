package Chapter1;

import java.util.*;

public class mockTestURLShort {

    Map<String, String> shortToLong = new HashMap<>();
    Map<String, String> longToShort = new HashMap<>();
    String baseUrl = "http://mahfooz.com/";

    int counter = 1;
    
    public String encode(String longUrl){
       if (longToShort.containsKey(longUrl)) {
           return baseUrl + longToShort.get(longUrl);
       }

       String shortKey = getBase62(counter++);
       shortToLong.put(shortKey, longUrl);
       longToShort.put(longUrl, shortKey);

       return baseUrl + shortKey;
    }

    public String decode(String shortUrl){
       String key = shortUrl.replace(baseUrl, "");
       return shortToLong.get(key);
    }

    public String getBase62(int counter){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        while (counter > 0) {

            sb.append(chars.charAt(counter % 62));
            counter /= 62;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        mockTestURLShort result = new mockTestURLShort();
        String result1 = result.encode("https://www.google.com/search?q=java");
        String result2 = result.decode("http://mahfooz.com/b");
        System.out.println(" Answer encoded string :"+ result1);
        System.out.println(" Answer decoded url " + result2);

    }
}
