package team.fta.industry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Account;
import team.fta.industry.service.TestService;

@RestController
public class LoginController {
    @Autowired
    private TestService accountService;
    @PostMapping("/login")

    public String login(@RequestBody Account account){
        Account account1 = accountService.selectAccountById(account.getId());
        if(account1!=null) {
            if (account1.getPassword().equals(account.getPassword())) {
                return "success";
            } else
                return "wrong password";
        }
        else
            return "no such user";
    }

}
