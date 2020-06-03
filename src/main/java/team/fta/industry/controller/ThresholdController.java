package team.fta.industry.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import team.fta.industry.domain.Threshold;
import team.fta.industry.service.SessionService;
import team.fta.industry.service.ThresholdService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

@CrossOrigin
@RestController
public class ThresholdController {
    @Autowired
    ThresholdService thresholdService;
    @Autowired
    private SessionService sessionService;


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
        System.out.println(methodName);
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    System.out.println("success");
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
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            int[] gf = new int[2];
            gf[1] = threshold.getGeneratorFrequencyHigh();
            gf[0] = threshold.getGeneratorFrequencyLow();
            jsonObject.put("frequency", gf);
            int[] gv = new int[2];
            gv[1] = threshold.getGeneratorVoltageHigh();
            gv[0] = threshold.getGeneratorVoltageLow();
            jsonObject.put("voltage", gv);
            int[] gc = new int[2];
            gc[1] = threshold.getGeneratorCurrentHigh();
            gc[0] = threshold.getGeneratorCurrentLow();
            jsonObject.put("current", gc);
            double[] doubles = new double[2];
            doubles[1] = threshold.getGeneratorLoadRateHigh();
            doubles[0] = threshold.getGeneratorLoadRateLow();
            jsonObject.put("load_rate", doubles);
            int[] gp = new int[2];
            gp[1] = threshold.getGeneratorPowerHigh();
            gp[0] = threshold.getGeneratorPowerLow();
            jsonObject.put("power", gp);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/threshold_pump")
    public JSONObject pumpThInfo(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject(true);
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
        JSONObject jsonObject = new JSONObject(true);
        String session = request.getParameter("sessionKey");
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            int[] vf = new int[2];
            vf[1] = threshold.getValveFrequencyHigh();
            vf[0] = threshold.getValveFrequencyLow();
            jsonObject.put("frequency", vf);
            int[] vfl = new int[2];
            vfl[1] = threshold.getValveFlowHigh();
            vfl[0] = threshold.getValveFlowLow();
            jsonObject.put("flow", vfl);
            int[] vl = new int[2];
            vl[1] = threshold.getValveLevelHigh();
            vl[0] = threshold.getValveLevelLow();
            jsonObject.put("level", vl);
            int[] vp = new int[2];
            vp[1] = threshold.getValvePressureHigh();
            vp[0] = threshold.getValvePressureLow();
            jsonObject.put("pressure", vp);
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

    @PostMapping("/threshold_water")
    public JSONObject waterThInfo(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
            double[] wo = new double[2];
            wo[1] = threshold.getWaterqualityOxygenHigh();
            wo[0] = threshold.getWaterqualityOxygenLow();
            jsonObject.put("oxygen", wo);
            double[] wp = new double[2];
            wp[1] = threshold.getWaterquailtyPhHigh();
            wp[0] = threshold.getWaterquailtyPhLow();
            jsonObject.put("ph", wp);
            double[] wa = new double[2];
            wa[1] = threshold.getWaterquailtyAirHigh();
            wa[0] = threshold.getWaterquailtyAirLow();
            jsonObject.put("air", wa);
            double[] wt = new double[2];
            wt[1] = threshold.getWaterquailtyTurbidityHigh();
            wt[0] = threshold.getWaterquailtyTurbidityLow();
            jsonObject.put("turbidity", wt);
            double[] ws = new double[2];
            ws[1] = threshold.getWaterqualitySecureHigh();
            ws[0] = threshold.getWaterqualitySecureLow();
            jsonObject.put("secure", ws);
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
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
            System.out.println(threshold.toString());

            Object object = setter(threshold, name, value);
            Threshold record = (Threshold) object;
            System.out.println("record is " + record.toString());

//            if (record == threshold) {
//                System.out.println("xiangdeng");
//                jsonObject.put("code", 1);
//                jsonObject.put("message", "wrong name");
//            } else {
            record.setChangeTime(new Date());
            thresholdService.insert(record);
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
//            }
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
