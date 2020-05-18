package team.fta.industry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import team.fta.industry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
    @Autowired
    private AccountService accountService;

    @GetMapping ("/home")
    public String home (){
        return "welcome";
    }
}