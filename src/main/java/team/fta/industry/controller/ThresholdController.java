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
import java.lang.reflect.Method;
import java.util.Date;

@CrossOrigin
@RestController
public class ThresholdController {
    @Autowired
    ThresholdService thresholdService;
    @Autowired
    private SessionService sessionService;

    /**
     * 将下划线命名转为驼峰命名
     *
     * @param s 需要转换的字符串
     * @return 转换后的字符串
     */
    private static String under2camel(String s) {
        String separator = "_";
        String under = "";
        s = s.toLowerCase().replace(separator, " ");
        String[] sarr = s.split(" ");
        for (int i = 0; i < sarr.length; i++) {
            String w = sarr[i].substring(0, 1).toUpperCase() + sarr[i].substring(1);
            under += w;
        }
        return under;
    }

    /**
     * 根据变量名称获取并调用对应的set方法
     *
     * @param obj   对象
     * @param name  变量名
     * @param value 设置的值
     * @return 原对象
     */
    public static Object setter(Object obj, String name, Object value) {
        String methodName = "set" + under2camel(name);  //set方法名
        System.out.println(methodName);
        try {
            Method[] methods = obj.getClass().getMethods(); //获取对象的所有方法
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    Class<?>[] cla = method.getParameterTypes();   //获取参数类型
                    String type = cla[0].getName();
                    if (type.equals("java.lang.Integer")) {     //将double转换为int
                        double d = new Double(value.toString());
                        int i = new Double(d).intValue();
                        method.invoke(obj, i);  //调用方法
                    } else {
                        method.invoke(obj, new Double(value.toString()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 获取发电机阈值的参数
     *
     * @param request http请求（session）
     * @return json（提示信息，发电机阈值参数）
     */
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

    /**
     * 获取水泵阈值的参数
     *
     * @param request http请求（session）
     * @return json（提示信息，水泵阈值参数）
     */
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

    /**
     * 获取阀门阈值的参数
     *
     * @param request http请求（session）
     * @return json（提示信息，阀门阈值参数）
     */
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

    /**
     * 获取水质阈值的参数
     *
     * @param request http请求（session）
     * @return json（提示信息，水质阈值参数）
     */
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

    /**
     * 设置阈值
     *
     * @param request http请求（session，参数名，阈值）
     * @return json（提示信息）
     */
    @PostMapping("/set_threshold")
    public JSONObject setTh(HttpServletRequest request) {
        String session = request.getParameter("sessionKey");
        String name = request.getParameter("name");
        Double value = new Double(request.getParameter("value"));
        JSONObject jsonObject = new JSONObject(true);
        if (sessionService.verifySession(session)) {
            Threshold threshold = thresholdService.selectRecent();
//            System.out.println(threshold.toString());

            Object object = setter(threshold, name, value);
            Threshold record = (Threshold) object;
//            System.out.println("record is " + record.toString());

            record.setChangeTime(new Date());
            thresholdService.insert(record);
            jsonObject.put("code", 0);
            jsonObject.put("message", "success");
        } else {
            jsonObject.put("code", 404);
            jsonObject.put("message", "wrong session");
        }
        return jsonObject;
    }

}
