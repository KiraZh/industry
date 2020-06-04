package team.fta.industry.mapper;

import team.fta.industry.domain.Warning;

import java.util.Date;
import java.util.List;

public interface WarningMapper {

    int insert(Warning record);

    List<Warning> selectRecent();

    List<Warning> selectByDate(Date date);
}