package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Pump;
import team.fta.industry.service.PumpService;

@RestController
public class PumpController {
    @Autowired
    private PumpService pumpService;

    @PostMapping("/get_pump")
    public JSONObject pumpInfo(@RequestHeader("session")String session){
        Pump pump = pumpService.selectRecent();
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("message","success");
        jsonObject.put("flow",pump.getFlow());
        jsonObject.put("valve_switch",pump.getValveSwitch());
        return jsonObject;
    }
}
