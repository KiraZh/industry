package team.fta.industry.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Warning;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.WarningService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class WarningController {
    @Autowired
    WarningService warningService;
    @Autowired
    SessionService sessionService;

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping("/get_warnings")
    public JSONArray getWarnings(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject1 = new JSONObject(true);
        JSONArray jsonArray = new JSONArray();
        if(sessionService.verifySession(session)) {
            List<Warning> warnings = warningService.selectAll();
            jsonObject1.put("code", 0);
            jsonObject1.put("message", "success");
            jsonArray.add(jsonObject1);
            for (int i = 0; i < warnings.size(); i++) {
                JSONObject jsonObject = new JSONObject(true);
                jsonObject.put("content",warnings.get(i).getContent());
                Date date = warnings.get(i).getTime();
                jsonObject.put("time",timeFormat.format(date));
                jsonObject.put("date",dateFormat.format(date));
                jsonArray.add(jsonObject);
                System.out.println(jsonArray);

            }
        } else {
            jsonObject1.put("code", 404);
            jsonObject1.put("message", "wrong session");
            jsonArray.add(jsonObject1);
        }
        return jsonArray;
    }
}
