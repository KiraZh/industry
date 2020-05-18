package team.fta.industry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.entity.Account;
import team.fta.industry.service.AccountService;

@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;
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
