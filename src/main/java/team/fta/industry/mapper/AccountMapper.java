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
//    Account login(String id,String password);

//    /**
//     * 根据用户名和密码查询数据库
//     * @param id 用户id
//     * @param password 用户密码
//     * @return 返回Account，若错误，则返回为空
//     */
//    public Account login(String id,String password);
}