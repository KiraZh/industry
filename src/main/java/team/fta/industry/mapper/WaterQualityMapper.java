package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.WaterQuality;

public interface WaterQualityMapper {
    int deleteByPrimaryKey(Date time);

    int insert(WaterQuality record);

    int insertSelective(WaterQuality record);

    WaterQuality selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(WaterQuality record);

    int updateByPrimaryKey(WaterQuality record);

    WaterQuality selectRecent();
}