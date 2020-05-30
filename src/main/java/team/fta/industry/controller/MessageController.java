package team.fta.industry.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Message;
import team.fta.industry.service.MessageService;
import team.fta.industry.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@RequestMapping("/message")
@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/info")
    public JSONObject selectAllMessage(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            List<Message> messages = messageService.selectAll();
            String info = JSON.toJSONStringWithDateFormat(messages, "yyyy-MM-dd HH:mm:ss");
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("info", info);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
