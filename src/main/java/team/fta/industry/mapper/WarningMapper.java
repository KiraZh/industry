package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.Warning;

public interface WarningMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}