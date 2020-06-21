package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Pump;
import team.fta.industry.mapper.PumpMapper;

import javax.annotation.Resource;

@Service
public class PumpService {

    @Resource
    private PumpMapper pumpMapper;


    public int insert(Pump record) {
        return pumpMapper.insert(record);
    }


    public Pump selectRecent() {
        return pumpMapper.selectRecent();
    }
}
