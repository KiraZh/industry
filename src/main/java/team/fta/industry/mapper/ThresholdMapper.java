package team.fta.industry.mapper;

import team.fta.industry.domain.Threshold;

public interface ThresholdMapper {
    int insert(Threshold record);

    int insertSelective(Threshold record);
}