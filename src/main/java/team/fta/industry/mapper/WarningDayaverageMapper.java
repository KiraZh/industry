package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.WarningDayaverage;

public interface WarningDayaverageMapper {
    int deleteByPrimaryKey(Date time);

    int insert(WarningDayaverage record);

    int insertSelective(WarningDayaverage record);

    WarningDayaverage selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(WarningDayaverage record);

    int updateByPrimaryKey(WarningDayaverage record);
}