package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Valve;
import team.fta.industry.service.ValveService;

import java.util.List;

@RestController
public class ValveController {
    @Autowired
    private ValveService valveService;

    @PostMapping("/get_valve")
    public JSONObject valveInfo(@RequestHeader("session")String session){
        List<Valve> valves = valveService.selectRecent();
        int recents[] = new int[10];
        for(int i=0;i<10;i++){
            recents[i] = valves.get(i).getFlow();
        }
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("message","success");
        jsonObject.put("recent",recents);
        jsonObject.put("flow",valves.get(0).getFlow());
        jsonObject.put("pressure",valves.get(0).getPressure());
        jsonObject.put("level",valves.get(0).getLevel());
        jsonObject.put("frequency",valves.get(0).getFrequency());
        return jsonObject;
    }
}
