package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.domain.Warning;
import team.fta.industry.mapper.WarningMapper;
import java.util.Date;
import java.util.List;

@Service
public class WarningService{

    @Resource
    private WarningMapper warningMapper;

    
    public int deleteByPrimaryKey(Date time) {
        return warningMapper.deleteByPrimaryKey(time);
    }

    
    public int insert(Date date,String content,String model) {
        Warning record = new Warning();
        record.setTime(date);
        record.setContent(content);
        record.setModel(model);
        return warningMapper.insert(record);
    }

    
    public int insertSelective(Warning record) {
        return warningMapper.insertSelective(record);
    }

    public List<Warning> selectAll(){
        return warningMapper.selectAll();
    }
    

    

    

}
