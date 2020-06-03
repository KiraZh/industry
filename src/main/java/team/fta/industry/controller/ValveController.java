package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Valve;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.ValveService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class ValveController {
    @Autowired
    private ValveService valveService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/get_valve")
    public JSONObject valveInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            List<Valve> valves = valveService.selectRecents();
            int[] recent = new int[10];
            for (int i = 0; i < 10; i++) {
                recent[i] = valves.get(i).getFlow();
            }
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("recent", recent);
            jsonObject.put("flow", valves.get(0).getFlow());
            jsonObject.put("pressure", valves.get(0).getPressure());
            jsonObject.put("level", valves.get(0).getLevel());
            jsonObject.put("frequency", valves.get(0).getFrequency());
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }
}
