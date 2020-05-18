package team.fta.industry.service;


import team.fta.industry.entity.Account;
import team.fta.industry.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    public List<Account> findAll(){
        return accountMapper.findAll();
    };
    public Account selectAccountById(String id) {
        return accountMapper.selectAccountById(id);
    };
}
