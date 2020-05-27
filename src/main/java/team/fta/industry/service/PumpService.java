package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import team.fta.industry.mapper.PumpMapper;
import team.fta.industry.domain.Pump;
@Service
public class PumpService{

    @Resource
    private PumpMapper pumpMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return pumpMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(Pump record) {
        return pumpMapper.insert(record);
    }

    
    public int insertSelective(Pump record) {
        return pumpMapper.insertSelective(record);
    }

    
    public Pump selectByPrimaryKey(Date time) {
        return pumpMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(Pump record) {
        return pumpMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Pump record) {
        return pumpMapper.updateByPrimaryKey(record);
    }

    public Pump selectRecent(){
        return pumpMapper.selectRecent();
    }
}
