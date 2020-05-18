package team.fta.industry.controller;

import org.springframework.web.bind.annotation.PathVariable;
import team.fta.industry.entity.Account;
import team.fta.industry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public List<Account> findAll(){
        return accountService.findAll();
    };
    @RequestMapping(value = "/{id}")
    public Account selectAccountById(@PathVariable String id){
        return accountService.selectAccountById(id);
    }
}