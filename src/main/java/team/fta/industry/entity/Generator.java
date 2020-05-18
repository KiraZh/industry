package team.fta.industry.entity;

import java.util.Date;

/**
 * 发动机
 * 数据库中的switch变量名不能使用，这里改为generatorSwitch
 */
public class Generator {
    private Date time;
    private int frequency;
    private int voltage;
    private int current;
    private int generatorSwitch;
    private double loadRate;
    private int control;
    private int power;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getGeneratorSwitch() {
        return generatorSwitch;
    }

    public void setGeneratorSwitch(int generatorSwitch) {
        this.generatorSwitch = generatorSwitch;
    }

    public double getLoadRate() {
        return loadRate;
    }

    public void setLoadRate(double loadRate) {
        this.loadRate = loadRate;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Generator{" +
                "time=" + time +
                ", frequency=" + frequency +
                ", voltage=" + voltage +
                ", current=" + current +
                ", generatorSwitch=" + generatorSwitch +
                ", loadRate=" + loadRate +
                ", control=" + control +
                ", power=" + power +
                '}';
    }
}
