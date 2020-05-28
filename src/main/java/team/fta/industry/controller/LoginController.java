package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Account;
import team.fta.industry.service.AccountService;
import team.fta.industry.JSONObject.*;
import team.fta.industry.utils.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;

    public final String TOKEN = "FOLLOW_THE_ARMY";

    @PostMapping("/login")
    public String login(HttpServletRequest request){
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        LoginReturn j = new LoginReturn();

        if (!TOKEN.equals(token)){
            j.setCode(404);
            j.setMessage("wrong token");
        } else {
            Account other = accountService.selectAccountById(username);
            if(other!=null) {
                if(other.getPassword().equals(password)) {
                    j.setCode(0);
                    j.setMessage("success");
                    j.setSessionKey(GetSessionKey.getSessionKey());
                }
                else {
                    j.setCode(1);
                    j.setMessage("Can't match username with the password");
                }
            }
            else {
                j.setCode(2);
                j.setMessage("no such user");
            }
        }

        return JSONObject.toJSONString(j);
    }
}
