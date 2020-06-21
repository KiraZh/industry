package team.fta.industry.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Warning;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.WarningService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@CrossOrigin
public class WarningController {
    @Autowired
    WarningService warningService;
    @Autowired
    SessionService sessionService;

    /**
     * 获取最近两小时的报警信息
     * @param request http请求（session）
     * @return json（提示信息，报警内容，时间）
     */
    @PostMapping("/get_warnings")
    public JSONArray getWarnings(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONArray jsonArray = new JSONArray();
        if (sessionService.verifySession(session)) {
            List<Warning> warnings = warningService.selectRecent();

            JSONObject jsonObject1 = new JSONObject(true);
            jsonObject1.put("code", 0);
            jsonObject1.put("message", "success");
            jsonArray.add(jsonObject1);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));

            for (int i = 0; i < warnings.size(); i++) {
                JSONObject jsonObject = new JSONObject(true);
                jsonObject.put("content", warnings.get(i).getContent());
                Date date = warnings.get(i).getTime();
                System.out.println(timeFormat.format(new Date()).toString());
                System.out.println(timeFormat.format(date).toString());
                jsonObject.put("time", timeFormat.format(date));
                jsonObject.put("date", dateFormat.format(date));
                jsonArray.add(jsonObject);
                System.out.println(jsonArray);
            }
        } else {
            JSONObject jsonObject1 = new JSONObject(true);
            jsonObject1.put("code", 404);
            jsonObject1.put("message", "wrong session");
            jsonArray.add(jsonObject1);
        }
        return jsonArray;
    }

    /**
     * 获取指定日期的历史报警信息
     * @param request http请求（session，日期）
     * @return json（提示信息，报警信息）
     */
    @PostMapping("/get_history_warnings")
    public JSONObject getHistoryWarnings(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        String dateString = request.getParameter("date");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Date date = dateFormat.parse(dateString);
                List<Warning> warnings = warningService.selectByDate(date);
                jsonObject.put("code", 0);
                jsonObject.put("message", "success");
                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < warnings.size(); i++) {
                    JSONObject temp = new JSONObject(true);
                    temp.put("content", warnings.get(i).getContent());
                    temp.put("date", dateFormat.format(warnings.get(i).getTime()));
                    temp.put("time", timeFormat.format(warnings.get(i).getTime()));
                    jsonArray.add(temp);
                }
                jsonObject.put("info", jsonArray);

            } catch (Exception e) {
                JSONObject jsonObject1 = new JSONObject(true);
                jsonObject1.put("code", 1);
                jsonObject1.put("message", e.toString());
            }
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
