package team.fta.industry.controller;

import org.springframework.web.bind.annotation.PathVariable;
import team.fta.industry.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.service.TestService;

import java.util.List;


@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    private TestService testService;

    @RequestMapping("/findAll")
    public List<Account> findAll(){
        return testService.findAll();
    };
    @RequestMapping(value = "/{id}")
    public Account selectAccountById(@PathVariable String id){
        return testService.selectAccountById(id);
    }
}