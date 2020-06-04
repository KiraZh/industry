package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Warning;
import team.fta.industry.mapper.WarningMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WarningService {

    @Resource
    private WarningMapper warningMapper;

    public int insert(Date date, String content, String model) {
        Warning record = new Warning();
        record.setTime(date);
        record.setContent(content);
        record.setModel(model);
        return warningMapper.insert(record);
    }


    public List<Warning> selectRecent() {
        return warningMapper.selectRecent();
    }

    public List<Warning> selectByDate(Date date) {
        return warningMapper.selectByDate(date);
    }


}
