package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Pump implements Serializable {
    private Date time;

    private Integer flow;

    private Boolean valveSwitch;

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

    public Boolean getValveSwitch() {
        return valveSwitch;
    }

    public void setValveSwitch(Boolean valveSwitch) {
        this.valveSwitch = valveSwitch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", flow=").append(flow);
        sb.append(", valveSwitch=").append(valveSwitch);
        sb.append("]");
        return sb.toString();
    }
    public double[] status(){
        double[] status = new double[1];
        status[0] = getFlow();
        return status;
    }
}