package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Threshold;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.ThresholdService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

@RestController
public class ThresholdController {
    @Autowired
    ThresholdService thresholdService;
    @Autowired
    private SessionService sessionService;

    private JSONObject jsonObject = new JSONObject(true);

    private static String under2camel(String s) {
        String separator = "_";
        String under = "";
        s = s.toLowerCase().replace(separator, " ");
        String sarr[] = s.split(" ");
        for (int i = 0; i < sarr.length; i++) {
            String w = sarr[i].substring(0, 1).toUpperCase() + sarr[i].substring(1);
            under += w;
        }
        return under;
    }

    public static Object setter(Object obj, String name, Object value) {
        String methodName = "set" + under2camel(name);
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    Class<?>[] cla = method.getParameterTypes();
                    String type = cla[0].getName();
                    if (type.equals("java.lang.Integer")) {
                        double d = new Double(value.toString());
                        int i = new Double(d).intValue();
                        method.invoke(obj, i);
                    } else {
                        method.invoke(obj, new Double(value.toString()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @PostMapping("/threshold_generator")
    public JSONObject generatorThInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            int[] number = new int[2];
            double[] doubles = new double[2];
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            number[1] = threshold.getGeneratorFrequencyHigh();
            number[0] = threshold.getGeneratorFrequencyLow();
            jsonObject.put("frequency", number);
            number[1] = threshold.getGeneratorVoltageHigh();
            number[0] = threshold.getGeneratorVoltageLow();
            jsonObject.put("voltage", number);
            number[1] = threshold.getGeneratorCurrentHigh();
            number[0] = threshold.getGeneratorCurrentLow();
            jsonObject.put("current", number);
            doubles[1] = threshold.getGeneratorLoadRateHigh();
            doubles[0] = threshold.getGeneratorLoadRateLow();
            jsonObject.put("load_rate", doubles);
            number[1] = threshold.getGeneratorPowerHigh();
            number[0] = threshold.getGeneratorPowerLow();
            jsonObject.put("power", doubles);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/threshold_pump")
    public JSONObject pumpThInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            int[] number = new int[2];
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            number[1] = threshold.getPumpFlowHigh();
            number[0] = threshold.getPumpFlowLow();
            jsonObject.put("flow", number);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/threshold_valve")
    public JSONObject valveThInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            int[] number = new int[2];
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            number[1] = threshold.getValveFrequencyHigh();
            number[0] = threshold.getValveFrequencyLow();
            jsonObject.put("frequency", number);
            number[1] = threshold.getValveFlowHigh();
            number[0] = threshold.getValveFlowLow();
            jsonObject.put("flow", number);
            number[1] = threshold.getValveLevelHigh();
            number[0] = threshold.getValveLevelLow();
            jsonObject.put("level", number);
            number[1] = threshold.getValvePressureHigh();
            number[0] = threshold.getValvePressureLow();
            jsonObject.put("pressure", number);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/threshold_water")
    public JSONObject waterThInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            double[] doubles = new double[2];
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            doubles[1] = threshold.getWaterqualityOxygenHigh();
            doubles[0] = threshold.getWaterqualityOxygenLow();
            jsonObject.put("oxygen", doubles);
            doubles[1] = threshold.getWaterquailtyPhHigh();
            doubles[0] = threshold.getWaterquailtyPhLow();
            jsonObject.put("ph", doubles);
            doubles[1] = threshold.getWaterquailtyAirHigh();
            doubles[0] = threshold.getWaterquailtyAirLow();
            jsonObject.put("air", doubles);
            doubles[1] = threshold.getWaterquailtyTurbidityHigh();
            doubles[0] = threshold.getWaterquailtyTurbidityLow();
            jsonObject.put("turbidity", doubles);
            doubles[1] = threshold.getWaterqualitySecureHigh();
            doubles[0] = threshold.getWaterqualitySecureLow();
            jsonObject.put("secure", doubles);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/set_threshold")
    public JSONObject setTh(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        String name = request.getParameter("name");
        Double value = new Double(request.getParameter("value"));
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            Object object = setter(threshold, name, value);
            Threshold record = (Threshold) object;
            if (record == threshold) {
                jsonObject.put("code", 1);
                jsonObject.put("message", "wrong name");
            } else {
                record.setChangeTime(new Date());
                thresholdService.insert(record);
                jsonObject.put("code", 0);
                jsonObject.put("message", "success");
            }
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
