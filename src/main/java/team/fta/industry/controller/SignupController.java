package team.fta.industry.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.JSONObject.SignupReturn;
import team.fta.industry.domain.Account;
import team.fta.industry.service.AccountService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SignupController {
    @Autowired
    private AccountService accountService;

    public final String TOKEN = "FOLLOW_THE_ARMY";
    @PostMapping("/sign_up")
    public String signUp(HttpServletRequest request){
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        SignupReturn j = new SignupReturn();

        if(TOKEN.equals(token)){
            Account other = accountService.selectAccountById(username);
            if(other != null){
                j.setCode(1);
                j.setMessage("User already exists");
            } else {
                Account newAccount = new Account();
                newAccount.setId(username);
                newAccount.setEmail(email);
                newAccount.setPassword(password);
                int res = accountService.insert(newAccount);
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
