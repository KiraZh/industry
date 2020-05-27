package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Account;
import team.fta.industry.service.AccountService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/login")
    public String login(@RequestBody Account account, HttpServletRequest request){
        Account other = accountService.selectAccountById(account.getId());
        JSONObject jsonObject = new JSONObject(true);
//        request.getSession().setAttribute("username",account.getId());
        if(other!=null) {
            if(other.getPassword().equals(account.getPassword())) {
                jsonObject.put("sessionKey", request.getSession().getId());
                jsonObject.put("code", 0);
                jsonObject.put("message", "success");
            }
            else {
                jsonObject.put("sessionKey", "");
                jsonObject.put("code", 1);
                jsonObject.put("message", "ID and password don't match");
            }
        }
        else {
            jsonObject.put("sessionKey", "");
            jsonObject.put("code", 2);
            jsonObject.put("message", "No such user");
        }
        return jsonObject.toString();
    }
}
