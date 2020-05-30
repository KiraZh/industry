package com.serivce;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Threshold;
import java.util.Date;
import team.fta.industry.mapper.ThresholdMapper;
@Service
public class ThresholdService{

    @Resource
    private ThresholdMapper thresholdMapper;

    
    public int deleteByPrimaryKey(Date changeTime) {
        return thresholdMapper.deleteByPrimaryKey(changeTime);
    }

    
    public int insert(Threshold record) {
        return thresholdMapper.insert(record);
    }

    
    public int insertSelective(Threshold record) {
        return thresholdMapper.insertSelective(record);
    }

    
    public Threshold selectByPrimaryKey(Date changeTime) {
        return thresholdMapper.selectByPrimaryKey(changeTime);
    }

    
    public int updateByPrimaryKeySelective(Threshold record) {
        return thresholdMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Threshold record) {
        return thresholdMapper.updateByPrimaryKey(record);
    }

}
