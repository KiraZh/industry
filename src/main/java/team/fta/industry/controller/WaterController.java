package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.WaterQuality;
import team.fta.industry.service.WaterQualityService;

@RestController
public class WaterController {
    @Autowired
    private WaterQualityService waterQualityService;

    @PostMapping("/get_water_quality")
    public JSONObject waterQuality(@RequestHeader("session")String session){
        WaterQuality waterQuality = waterQualityService.selectRecent();
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("message","success");
        jsonObject.put("oxygen",waterQuality.getOxygen());
        jsonObject.put("ph",waterQuality.getPh());
        jsonObject.put("turbidity",waterQuality.getTurbidity());
        jsonObject.put("air",waterQuality.getAir());
        return jsonObject;
    }
}
