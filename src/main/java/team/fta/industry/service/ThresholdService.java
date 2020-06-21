package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Threshold;
import team.fta.industry.mapper.ThresholdMapper;

import javax.annotation.Resource;

@Service
public class ThresholdService {

    @Resource
    private ThresholdMapper thresholdMapper;


    public int insert(Threshold record) {
        return thresholdMapper.insert(record);
    }


    public Threshold selectRecent() {
        return thresholdMapper.selectRecent();
    }
}
