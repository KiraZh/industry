package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Pump;
import team.fta.industry.service.PumpService;
import team.fta.industry.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin
@RestController
public class PumpController {
    @Autowired
    private PumpService pumpService;
    @Autowired
    private SessionService sessionService;

    /**
     * 获取获取水泵当前的状态
     *
     * @param request http请求（session）
     * @return json（提示信息，水泵的各项参数）
     */
    @PostMapping("/get_pump")
    public JSONObject getPumpInfo(HttpServletRequest request) {
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

    /**
     * 设置水泵的流量
     *
     * @param request http请求（session，流量）
     * @return json（提示信息）
     */
    @PostMapping("/pump_flow")
    public JSONObject setPumpFlow(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        Integer value = new Integer(request.getParameter("value"));
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Pump record = new Pump();
            Pump recent = pumpService.selectRecent();
            record.setFlow(value);
            record.setTime(new Date());
            record.setValveSwitch(recent.getValveSwitch());
            pumpService.insert(record);
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    /**
     * 设置水泵开关
     *
     * @param request http请求（session，开关状态）
     * @return json（提示信息）
     */
    @PostMapping("/pump_switch")
    public JSONObject setPumpSwitch(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        Integer s = new Integer(request.getParameter("switch"));
        JSONObject jsonObject = new JSONObject(true);
        Boolean genSwitch;
        if (s == 0) {
            genSwitch = false;
        } else if (s == 1) {
            genSwitch = true;
        } else {
            jsonObject.put("code", 1);
            jsonObject.put("message", "error");
            return jsonObject;
        }
        if (sessionService.verifySession(session)) {
            Pump record = pumpService.selectRecent();
            record.setTime(new Date());
            record.setValveSwitch(genSwitch);
            pumpService.insert(record);
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
