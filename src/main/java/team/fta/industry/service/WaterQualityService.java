package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.mapper.WaterQualityMapper;
import java.util.Date;
import team.fta.industry.domain.WaterQuality;
@Service
public class WaterQualityService{

    @Resource
    private WaterQualityMapper waterQualityMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return waterQualityMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(WaterQuality record) {
        return waterQualityMapper.insert(record);
    }

    
    public int insertSelective(WaterQuality record) {
        return waterQualityMapper.insertSelective(record);
    }

    
    public WaterQuality selectByPrimaryKey(Date time) {
        return waterQualityMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(WaterQuality record) {
        return waterQualityMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(WaterQuality record) {
        return waterQualityMapper.updateByPrimaryKey(record);
    }

}
