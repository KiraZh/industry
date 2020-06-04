package team.fta.industry.mapper;

import team.fta.industry.domain.WarningDayaverage;

import java.util.List;

public interface WarningDayaverageMapper {
    List<WarningDayaverage> select7Days();

    List<WarningDayaverage> selectAll();

}