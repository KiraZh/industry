package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.fta.industry.domain.Generator;
import team.fta.industry.domain.Pump;
import team.fta.industry.service.GeneratorService;
import team.fta.industry.service.SessionService;
import team.fta.industry.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private SessionService sessionService;

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

}
