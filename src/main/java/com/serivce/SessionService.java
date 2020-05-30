package com.serivce;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Session;
import team.fta.industry.mapper.SessionMapper;
@Service
public class SessionService{

    @Resource
    private SessionMapper sessionMapper;

    
    public int insert(Session record) {
        return sessionMapper.insert(record);
    }

    
    public int insertSelective(Session record) {
        return sessionMapper.insertSelective(record);
    }

}
