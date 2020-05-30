package team.fta.industry.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.JSONObject.SignupReturn;
import team.fta.industry.domain.Account;
import team.fta.industry.domain.Session;
import team.fta.industry.service.AccountService;
import team.fta.industry.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class SignUpController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;

    public final String TOKEN = "FOLLOW_THE_ARMY";

    //    @PostMapping("/sign_up")
    public String signUp(HttpServletRequest request) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        SignupReturn j = new SignupReturn();

        if (TOKEN.equals(token)) {
            Account other = accountService.selectAccountById(username);
            if (other != null) {
                j.setCode(1);
                j.setMessage("User already exists");
            } else {
                Account newAccount = new Account();
                Session newSession = new Session();
                newAccount.setId(username);
                newAccount.setEmail(email);
                newAccount.setPassword(password);
                newSession.setUserName(username);
                newSession.setEmail(email);
                newSession.setLastTime(new Date());
                sessionService.insertSelective(newSession);
                accountService.insert(newAccount);
                j.setCode(0);
                j.setMessage("success");
            }
        } else {
            j.setCode(404);
            j.setMessage("wrong token");
        }
        return JSON.toJSONString(j);
    }
}
