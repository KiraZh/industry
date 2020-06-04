package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.WarningDayaverage;
import team.fta.industry.mapper.WarningDayaverageMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WarningDayaverageService {

    @Resource
    private WarningDayaverageMapper warningDayaverageMapper;

    public List<WarningDayaverage> select7Days() {
        return warningDayaverageMapper.select7Days();
    }

    public List<WarningDayaverage> selectAll() {
        return warningDayaverageMapper.selectAll();
    }

}
