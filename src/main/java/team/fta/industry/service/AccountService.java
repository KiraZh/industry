package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Account;
import team.fta.industry.mapper.AccountMapper;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;
    
    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }

    public Account selectAccountByIdOrEmail(String id, String email) {
        return accountMapper.selectAccountByIdOrEmail(id, email);
    }
}
