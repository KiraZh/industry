package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Generator;
import team.fta.industry.service.GeneratorService;
import team.fta.industry.service.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@CrossOrigin
@RestController
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;
    @Autowired
    private SessionService sessionService;

    /**
     * 获取发电机当前的状态
     * @param request http请求（session）
     * @return json（提示信息，发电机的各项参数）
     */
    @PostMapping("/get_generator")
    public JSONObject generatorInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Generator generator = generatorService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("frequency", generator.getFrequency());
            jsonObject.put("voltage", generator.getVoltage());
            jsonObject.put("current", generator.getCurrent());
            jsonObject.put("switch", generator.getgeneratorSwitch());
            jsonObject.put("load_rate", generator.getLoadRate());
            jsonObject.put("control", generator.getControl());
            jsonObject.put("power", generator.getPower());
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    /**
     * 设置发电机开关
     * @param request http请求（session，开关状态）
     * @return json（提示信息）
     */
    @PostMapping("/gen_switch")
    public JSONObject setGeneratorSwitch(HttpServletRequest request) {
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
            Generator record = generatorService.selectRecent();
            record.setTime(new Date());
            record.setgeneratorSwitch(genSwitch);
            generatorService.insert(record);
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
