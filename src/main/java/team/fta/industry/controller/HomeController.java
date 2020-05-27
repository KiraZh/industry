package team.fta.industry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.service.TestService;


@RestController
public class HomeController {
    @Autowired
    private TestService testService;

    @GetMapping ("/home")
    public String home (){
        return "welcome";
    }
}