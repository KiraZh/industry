package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.JSONObject.LoginReturn;
import team.fta.industry.domain.Account;
import team.fta.industry.domain.Session;
import team.fta.industry.service.AccountService;
import team.fta.industry.service.SessionService;
import team.fta.industry.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;


    public final String TOKEN = "FOLLOW_THE_ARMY";


    //    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        LoginReturn j = new LoginReturn();

        if (!TOKEN.equals(token)) {
            j.setCode(404);
            j.setMessage("wrong token");
        } else {
            Account other = accountService.selectAccountById(username);
            if (other != null) {
                if (other.getPassword().equals(password)) {
                    j.setCode(0);
                    j.setMessage("success");
                    String session = SessionUtil.getSessionKey();
                    Session record = new Session();
                    record.setUserName(username);
                    record.setSessionkey(session);
                    record.setLastTime(new Date());
                    record.setEmail(email);
                    j.setSessionKey(session);
                    try {
                        sessionService.updateByUserName(record);
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                    ;
                } else {
                    j.setCode(1);
                    j.setMessage("Can't match username with the password");
                }
            } else {
                j.setCode(2);
                j.setMessage("no such user");
            }
        }

        return JSONObject.toJSONString(j);
    }
}
