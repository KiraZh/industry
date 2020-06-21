package team.fta.industry.mapper;

import team.fta.industry.domain.Account;

import java.util.List;

public interface AccountMapper {
    int insert(Account record);

    int insertSelective(Account record);

    List<Account> findAll();

    Account selectAccountById(String id);

    Account selectAccountByIdOrEmail(String id,String email);
}