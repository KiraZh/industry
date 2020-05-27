package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Account;
import team.fta.industry.mapper.AccountMapper;
@Service
public class AccountService{

    @Resource
    private AccountMapper accountMapper;

    
    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    
    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }

//    public Account login(String id,String password) {
//        return accountMapper.login(id,password);
//    }

    public Account selectAccountById(String id){
        return accountMapper.selectAccountById(id);
    }
}
