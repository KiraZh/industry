package team.fta.industry.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.entity.Message;
import team.fta.industry.service.MessageService;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/all")
    public String selectAllMessage(){
        List<Message> messages = messageService.selectAllMessage();
        String jsonObject = JSON.toJSONStringWithDateFormat(messages,"yyyy-MM-dd HH:mm:ss");
        return jsonObject;
    }

}
