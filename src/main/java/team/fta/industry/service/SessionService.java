package team.fta.industry.service;

import org.apache.shiro.dao.DataAccessException;
import org.springframework.stereotype.Service;
import team.fta.industry.domain.Session;
import team.fta.industry.mapper.SessionMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SessionService {
    @Resource
    private SessionMapper sessionMapper;

    public int insert(Session record) throws DataAccessException {
        return sessionMapper.insert(record);
    }
    public int insertSelective(Session record){
        return sessionMapper.insertSelective(record);
    }
    public List<Session> selectRecent(int n){
        return sessionMapper.selectRecent(n);
    }
    public int updateByUserName(Session record){
        return sessionMapper.updateByUserName(record);
    }
    public Session selectBySession(String session){
        return sessionMapper.selectBySession(session);
    }
    public int updateBySession(Session record){
        return sessionMapper.updateBySession(record);
    }
    public boolean verifySession(String sessionKey) {
        System.out.println(sessionKey);
        Session session = selectBySession(sessionKey);
        if(session!=null){
            session.setLastTime(new Date());
            updateBySession(session);
            return true;
        }
        else {
            return false;
        }
    }

}
