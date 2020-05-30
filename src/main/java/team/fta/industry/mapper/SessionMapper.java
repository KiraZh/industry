package team.fta.industry.mapper;

import org.apache.shiro.dao.DataAccessException;
import team.fta.industry.domain.Session;

import java.util.List;
import java.util.zip.DataFormatException;

public interface SessionMapper {
    int insert(Session record) throws DataAccessException;

    int insertSelective(Session record);

    List<Session> selectRecent(int n);

    int updateByUserName(Session record);

    Session selectBySession(String session);

    int updateBySession(Session record);

}