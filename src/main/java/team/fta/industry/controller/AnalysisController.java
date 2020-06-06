package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.WarningDayaverage;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.WarningDayaverageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
public class AnalysisController {
    @Autowired
    WarningDayaverageService warningDayaverageService;
    @Autowired
    private SessionService sessionService;

    /**
     * 返回7天的设备报警记录
     *
     * @param request
     * @return json
     */
    @PostMapping("/advanced_analyze")
    public JSONObject getAdvanceAnalysis(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);

        JSONObject errorInfo = new JSONObject(true);
        errorInfo.put("code", 1);
        errorInfo.put("message", "can't get data,check database");

        if (sessionService.verifySession(session)) {
            List<WarningDayaverage> list = warningDayaverageService.select7Days();
            int[][] warningTimes = new int[7][4];
            for (int i = 6; i > -1; i--) {
                for (int j = 0; j < 4; j++) {
                    try {
                        warningTimes[i][j] = list.get((6 - i) * 4 + j).getWarningTimes();
                    } catch (Exception e) {
//                        return errorInfo;
                    }
                }
            }
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("analyze_data", warningTimes);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/advanced_analyze_more")
    public JSONObject getMoreAdvanceAnalysis(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);

        JSONObject errorInfo = new JSONObject(true);
        errorInfo.put("code", 1);
        errorInfo.put("message", "can't get data,check database");

        if (sessionService.verifySession(session)) {
            List<WarningDayaverage> list = warningDayaverageService.selectAll();
            int length = list.size();
            int rowNum = length / 4;
            System.out.printf("length : %d\n", length);
            System.out.printf("row : %d\n", rowNum);

            int[][] warningTimes = new int[rowNum][4];
            for (int i = rowNum - 1; i > -1; i--) {
                for (int j = 0; j < 4; j++) {
                    try {
                        warningTimes[i][j] = list.get((rowNum - 1 - i) * 4 + j).getWarningTimes();
                    } catch (Exception e) {
//                        return errorInfo;
                    }
                }
            }
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            jsonObject.put("analyze_data", warningTimes);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}

