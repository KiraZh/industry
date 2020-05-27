package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Threshold;
import team.fta.industry.mapper.ThresholdMapper;
@Service
public class ThresholdService{

    @Resource
    private ThresholdMapper thresholdMapper;

    
    public int insert(Threshold record) {
        return thresholdMapper.insert(record);
    }

    
    public int insertSelective(Threshold record) {
        return thresholdMapper.insertSelective(record);
    }

}
