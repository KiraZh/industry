package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Pump;
import team.fta.industry.service.PumpService;
import team.fta.industry.service.SessionService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PumpController {
    @Autowired
    private PumpService pumpService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/get_pump")
    public JSONObject pumpInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {

            Pump pump = pumpService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("flow", pump.getFlow());
            jsonObject.put("valve_switch", pump.getValveSwitch());
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }
}
