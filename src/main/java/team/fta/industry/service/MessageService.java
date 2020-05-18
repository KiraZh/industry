package team.fta.industry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.fta.industry.entity.Message;
import team.fta.industry.mapper.MessageMapper;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;
    public List<Message> selectAllMessage(){
        return messageMapper.selectAllMessage();
    }
}
