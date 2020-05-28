package team.fta.industry.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class GetSessionKey {
    public static String getSessionKey(){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String time = Long.toString(System.currentTimeMillis());
            Random rand = new Random();
            String random = Integer.toString(rand.nextInt(1000));
            String res = "FOLLOW_THE_ARMY" + time + random;
            md5.update(res.getBytes());
            return new BigInteger(1, md5.digest()).toString(16).substring(0, 10);
        } catch (NoSuchAlgorithmException e){
            // 这玩意几乎不可能发生，所以就随便写个东西来catch

            return "Not such md5";
        }
    }
}
