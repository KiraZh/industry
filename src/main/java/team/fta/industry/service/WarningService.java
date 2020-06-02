package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Warning;
import team.fta.industry.mapper.WarningMapper;
import java.util.Date;
@Service
public class WarningService{

    @Resource
    private WarningMapper warningMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return warningMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(String content,String model) {
        Warning record = new Warning();
        record.setTime(new Date());
        record.setContent(content);
        record.setModel(model);
        return warningMapper.insert(record);
    }

    
    public int insertSelective(Warning record) {
        return warningMapper.insertSelective(record);
    }

    
    public Warning selectByPrimaryKey(Date time) {
        return warningMapper.selectByPrimaryKey(time);
    }

    
    public int updateByPrimaryKeySelective(Warning record) {
        return warningMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Warning record) {
        return warningMapper.updateByPrimaryKey(record);
    }

}
