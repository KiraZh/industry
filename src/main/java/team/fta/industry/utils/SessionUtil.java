package team.fta.industry.utils;

import org.springframework.beans.factory.annotation.Autowired;
import team.fta.industry.domain.Session;
import team.fta.industry.service.SessionService;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class SessionUtil {
    @Autowired
    private static SessionService sessionService;

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
            // 这玩意几乎不可能发生，所以就随便写个东西来catch
            return "Not such md5";
        }
    }

//    /**
//     * @param sessionKey 需要验证的session
//     * @return
//     */
//    public static boolean verifySession(String sessionKey) {
//        System.out.println(sessionKey);
//        Session session = sessionService.selectBySession(sessionKey);
//        if(session!=null){
//            session.setLastTime(new Date());
//            sessionService.updateBySession(session);
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
}
