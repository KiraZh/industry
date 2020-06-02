package team.fta.industry.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import team.fta.industry.domain.*;
import team.fta.industry.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
    private String[] parameters = {"generator frequency", "generator voltage",
            "generator current", "generator load rate",
            "generator power", "pump flow",
            "valve flow", "valve pressure",
            "valve level", "valve frequency",
            "water quality oxygen", "water quality ph",
            "water quality turbidity", "water quality air", "water quality secure"};
    private String[] models = {"generator", "pump", "valve", "water_quality"};
    @Scheduled(fixedRate = 10000) //6000s
    public void checkDevices() {
        Date date = new Date();
        System.out.println("当前时间：" + dataFormat.format(date));
        Generator generator = generatorService.selectRecent();
        Pump pump = pumpService.selectRecent();
        Valve valve = valveService.selectRecent();
        WaterQuality water = waterQualityService.selectRecent();
        Threshold threshold = thresholdService.selectRecent();
        double[] th = threshold.status();
        double[] data = arrayJoin(generator.status(), pump.status());
        data = arrayJoin(data, valve.status());
        data = arrayJoin(data, water.status());
        System.out.println(data.length);
        for (int i = 0; i < data.length; i++) {
            if (data[i] < th[2 * i]) {
                System.out.println(parameters[i] + " to high");
                //TODO database insert
//                warningService.insert(parameters[i] + " to high",)
            } else if (data[i] > th[2 * i + 1]) {
                System.out.println(parameters[i] + " to low");
            }
            System.out.println(i);
        }

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
