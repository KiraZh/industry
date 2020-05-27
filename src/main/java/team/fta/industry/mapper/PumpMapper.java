package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.Pump;

public interface PumpMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Pump record);

    int insertSelective(Pump record);

    Pump selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Pump record);

    int updateByPrimaryKey(Pump record);

    Pump selectRecent();
}