package team.fta.industry.utils;

import org.springframework.beans.factory.annotation.Autowired;
import team.fta.industry.service.SessionService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class SessionUtil {
    @Autowired
    private static SessionService sessionService;

    /**
     * 生成session
     *
     * @return session
     */
    public static String getSessionKey() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String time = Long.toString(System.currentTimeMillis());
            Random rand = new Random();
            String random = Integer.toString(rand.nextInt(1000));
            String res = "FOLLOW_THE_ARMY" + time + random;
            md5.update(res.getBytes());
            return new BigInteger(1, md5.digest()).toString(16).substring(0, 10);
        } catch (NoSuchAlgorithmException e) {
            return "Not such md5";
        }
    }

}
