package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.Threshold;

public interface ThresholdMapper {
    int deleteByPrimaryKey(Date changeTime);

    int insert(Threshold record);

    int insertSelective(Threshold record);

    Threshold selectByPrimaryKey(Date changeTime);

    int updateByPrimaryKeySelective(Threshold record);

    int updateByPrimaryKey(Threshold record);

    Threshold selectRecent();

//    int insertByName(String);
}