package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.fta.industry.domain.Generator;
import team.fta.industry.domain.Pump;
import team.fta.industry.service.GeneratorService;

import javax.servlet.http.HttpSession;


@RestController
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @PostMapping("/get_generator")
    public JSONObject generatorInfo(@RequestHeader("session")String session){
        Generator generator = generatorService.selectRecent();
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("message","success");
        jsonObject.put("frequency",generator.getFrequency());
        jsonObject.put("voltage",generator.getVoltage());
        jsonObject.put("current",generator.getCurrent());
        jsonObject.put("switch",generator.getgeneratorSwitch());
        jsonObject.put("load_rate",generator.getLoadRate());
        jsonObject.put("control",generator.getControl());
        jsonObject.put("power",generator.getPower());
        return jsonObject;
    }
}
