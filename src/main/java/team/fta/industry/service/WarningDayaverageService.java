package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import team.fta.industry.domain.WarningDayaverage;
import team.fta.industry.mapper.WarningDayaverageMapper;
@Service
public class WarningDayaverageService{

    @Resource
    private WarningDayaverageMapper warningDayaverageMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return warningDayaverageMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(WarningDayaverage record) {
        return warningDayaverageMapper.insert(record);
    }

    
    public int insertSelective(WarningDayaverage record) {
        return warningDayaverageMapper.insertSelective(record);
    }

    
    public WarningDayaverage selectByPrimaryKey(Date time) {
        return warningDayaverageMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(WarningDayaverage record) {
        return warningDayaverageMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(WarningDayaverage record) {
        return warningDayaverageMapper.updateByPrimaryKey(record);
    }

}
