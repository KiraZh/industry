package team.fta.industry.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import team.fta.industry.mapper.MessageMapper;
import team.fta.industry.domain.Message;
@Service
public class MessageService{

    @Resource
    private MessageMapper messageMapper;

    
    public int insert(Message record) {
        return messageMapper.insert(record);
    }

    
    public int insertSelective(Message record) {
        return messageMapper.insertSelective(record);
    }

}
