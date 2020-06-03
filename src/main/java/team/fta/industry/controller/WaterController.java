package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.WaterQuality;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.WaterQualityService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class WaterController {
    @Autowired
    private WaterQualityService waterQualityService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/get_water_quality")
    public JSONObject waterQuality(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            WaterQuality waterQuality = waterQualityService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("oxygen", waterQuality.getOxygen());
            jsonObject.put("ph", waterQuality.getPh());
            jsonObject.put("secure",waterQuality.getSecure());
            jsonObject.put("turbidity", waterQuality.getTurbidity());
            jsonObject.put("air", waterQuality.getAir());
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }
}
