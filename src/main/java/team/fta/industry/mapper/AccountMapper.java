package team.fta.industry.mapper;

import team.fta.industry.domain.Account;

import java.util.List;

public interface AccountMapper {
    int insert(Account record);

    int insertSelective(Account record);

    List<Account> findAll();
    /**
     * 根据用户ID查询用户数据
     * @param id 用户ID
     * @return 用户数据集合
     */
    Account selectAccountById(String id);
}