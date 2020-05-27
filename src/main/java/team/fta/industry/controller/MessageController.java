package team.fta.industry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.fta.industry.domain.Message;
import team.fta.industry.service.MessageService;

import java.util.List;

@RestController
//@RequestMapping("/message")
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/info")
    public JSONObject selectAllMessage(@RequestHeader("session")String session){
        List<Message> messages = messageService.selectAll();
        String info = JSON.toJSONStringWithDateFormat(messages,"yyyy-MM-dd HH:mm:ss");
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("message","success");
        jsonObject.put("info",info);
        return jsonObject;
    }

}
