package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Generator implements Serializable {
    private Date time;

    private Integer frequency;

    private Integer voltage;

    private Integer current;

    private Boolean generatorSwitch;

    private Double loadRate;

    private Integer control;

    private Integer power;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Boolean getgeneratorSwitch() {
        return generatorSwitch;
    }

    public void setgeneratorSwitch(Boolean generatorSwitch) {
        this.generatorSwitch = generatorSwitch;
    }

    public Double getLoadRate() {
        return loadRate;
    }

    public void setLoadRate(Double loadRate) {
        this.loadRate = loadRate;
    }

    public Integer getControl() {
        return control;
    }

    public void setControl(Integer control) {
        this.control = control;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", frequency=").append(frequency);
        sb.append(", voltage=").append(voltage);
        sb.append(", current=").append(current);
        sb.append(", generatorSwitch=").append(generatorSwitch);
        sb.append(", loadRate=").append(loadRate);
        sb.append(", control=").append(control);
        sb.append(", power=").append(power);
        sb.append("]");
        return sb.toString();
    }
}