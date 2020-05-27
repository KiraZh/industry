package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Generator;
import team.fta.industry.mapper.GeneratorMapper;
import java.util.Date;
@Service
public class GeneratorService{

    @Resource
    private GeneratorMapper generatorMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return generatorMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(Generator record) {
        return generatorMapper.insert(record);
    }

    
    public int insertSelective(Generator record) {
        return generatorMapper.insertSelective(record);
    }

    
    public Generator selectByPrimaryKey(Date time) {
        return generatorMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(Generator record) {
        return generatorMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Generator record) {
        return generatorMapper.updateByPrimaryKey(record);
    }

}
