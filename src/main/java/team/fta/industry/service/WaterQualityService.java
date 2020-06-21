package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.WaterQuality;
import team.fta.industry.mapper.WaterQualityMapper;

import javax.annotation.Resource;

@Service
public class WaterQualityService {

    @Resource
    private WaterQualityMapper waterQualityMapper;


    public WaterQuality selectRecent() {
        return waterQualityMapper.selectRecent();
    }
}
