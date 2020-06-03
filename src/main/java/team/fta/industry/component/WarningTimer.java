package team.fta.industry.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import team.fta.industry.domain.*;
import team.fta.industry.service.*;
import team.fta.industry.utils.SpringMail;

import java.text.SimpleDateFormat;
import java.util.Date;

//TODO 报警信息时间排列
@Component
public class WarningTimer {
    @Autowired
    GeneratorService generatorService;
    @Autowired
    PumpService pumpService;
    @Autowired
    ValveService valveService;
    @Autowired
    WaterQualityService waterQualityService;
    @Autowired
    ThresholdService thresholdService;
    @Autowired
    WarningService warningService;

    private static String email = "damaoooo@163.com";
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
    private String[] parameters = {"generator frequency", "generator voltage",
            "generator current", "generator load rate",
            "generator power", "pump flow",
            "valve flow", "valve pressure",
            "valve level", "valve frequency",
            "water quality oxygen", "water quality ph",
            "water quality turbidity", "water quality air", "water quality secure"};
    private String[] parametersCN = {"发动机的频率", "发动机的电压",
            "发电机的电流", "发电机的负载率",
            "发电机的功率", "潜水泵的流量",
            "供水阀门的流量", "供水阀门的水压",
            "供水阀门的水位", "供水阀门的电机转动速度",
            "水质的余氧", "水质的酸碱度",
            "水质的浊度", "水质的空气质量", "水质的安防在线"};

    private String[] models = {"generator", "pump", "valve", "water_quality"};

    @Scheduled(fixedRate = 1000000000) //180s
    public void checkDevices() {
        Date date = new Date();
        System.out.println("当前时间：" + dataFormat.format(date));
        String report = "这是" + dataFormat.format(date) + "的检测报告：\n";
        String copy = report;

        Generator generator = generatorService.selectRecent();
        Pump pump = pumpService.selectRecent();
        Valve valve = valveService.selectRecent();
        WaterQuality water = waterQualityService.selectRecent();
        Threshold threshold = thresholdService.selectRecent();

        double[] th = threshold.status();   //high,low
        double[] data = arrayJoin(generator.status(), pump.status());
        data = arrayJoin(data, valve.status());
        data = arrayJoin(data, water.status());

        for (int i = 0; i < data.length; i++) {
            if (data[i] > th[2 * i]) {
                String content = parametersCN[i] + "超出阈值上限，请及时检修";
                warningService.insert(date, content, paraToModel(i));
                report = report + content + "\n";
            } else if (data[i] < th[2 * i + 1]) {
                String content = parametersCN[i] + "低于阈值下限，请及时检修";
                warningService.insert(date, content, paraToModel(i));
                report = report + content + "\n";
            }
        }
        if (report.equals(copy)) {
            report = report + "各设备参数正常\n";
        }
        SpringMail.sendMail("工业预警系统报警记录", report, email);
        System.out.println(report);

    }

    public String paraToModel(int i) {
        String s = "";
        if (i >= 0 && i < 5) {
            s = models[0];
        } else if (i < 6) {
            s = models[1];
        } else if (i < 10) {
            s = models[2];
        } else {
            s = models[3];
        }
        return s;
    }

    public double[] arrayJoin(double[] a, double[] b) {
        double[] arr = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        for (int j = 0; j < b.length; j++) {
            arr[a.length + j] = b[j];
        }
        return arr;
    }


}
