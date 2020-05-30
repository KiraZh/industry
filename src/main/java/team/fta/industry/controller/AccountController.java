package team.fta.industry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.JSONObject.LoginReturn;
import team.fta.industry.JSONObject.SignupReturn;
import team.fta.industry.domain.Account;
import team.fta.industry.domain.Session;
import team.fta.industry.service.AccountService;
import team.fta.industry.service.SessionService;
import team.fta.industry.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;
    public final String TOKEN = "FOLLOW_THE_ARMY";

    @PostMapping("/login")
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

    @PostMapping("/sign_up")
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

    @PostMapping("/release")
    public String release(HttpServletRequest request) {
        String sessionKey = request.getParameter("sessionKey");
        String token = request.getParameter("token");
        JSONObject jsonObject = new JSONObject(true);
        if (TOKEN.equals(token)) {
            if (sessionService.verifySession(sessionKey)) {
                Session session = sessionService.selectBySession(sessionKey);
                session.setSessionkey("");
                session.setLastTime(new Date());
                sessionService.updateByUserName(session);
                jsonObject.put("code", 0);
                jsonObject.put("message", "success");
            } else {
                jsonObject.put("code", 1);
                jsonObject.put("message", "wrong session");
            }
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong token");
        }
        return jsonObject.toString();
    }
}
