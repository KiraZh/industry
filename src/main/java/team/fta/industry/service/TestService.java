package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Account;
import team.fta.industry.mapper.AccountMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    AccountMapper accountMapper;

    public List<Account> findAll(){
        return accountMapper.findAll();
    };
    public Account selectAccountById(String id) {
        return accountMapper.selectAccountById(id);
    };

}

//@Service
//public class AccountService {
//    @Autowired
//    AccountMapper accountMapper;
//    public List<Account> findAll(){
//        return accountMapper.findAll();
//    };
//    public Account selectAccountById(String id) {
//        return accountMapper.selectAccountById(id);
//    };
//}