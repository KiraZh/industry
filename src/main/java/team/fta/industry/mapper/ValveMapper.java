package team.fta.industry.mapper;

import java.util.Date;
import java.util.List;

import team.fta.industry.domain.Valve;

public interface ValveMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Valve record);

    int insertSelective(Valve record);

    Valve selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Valve record);

    int updateByPrimaryKey(Valve record);

    List<Valve> selectRecent();

}