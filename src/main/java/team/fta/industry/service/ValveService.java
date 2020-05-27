package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import team.fta.industry.domain.Valve;
import team.fta.industry.mapper.ValveMapper;
@Service
public class ValveService{

    @Resource
    private ValveMapper valveMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return valveMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(Valve record) {
        return valveMapper.insert(record);
    }

    
    public int insertSelective(Valve record) {
        return valveMapper.insertSelective(record);
    }

    
    public Valve selectByPrimaryKey(Date time) {
        return valveMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(Valve record) {
        return valveMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Valve record) {
        return valveMapper.updateByPrimaryKey(record);
    }

}
