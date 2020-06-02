package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Valve implements Serializable {
    private Date time;

    private Integer flow;

    private Integer pressure;

    private Integer level;

    private Integer frequency;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", flow=").append(flow);
        sb.append(", pressure=").append(pressure);
        sb.append(", level=").append(level);
        sb.append(", frequency=").append(frequency);
        sb.append("]");
        return sb.toString();
    }
    public double[] status(){
        double[] status = new double[4];
        status[0] = getFlow();
        status[1] = getPressure();
        status[2] = getLevel();
        status[3] = getFrequency();
        return status;
    }
}