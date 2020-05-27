package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class WarningDayaverage implements Serializable {
    private Date time;

    private String model;

    private Integer warningTimes;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWarningTimes() {
        return warningTimes;
    }

    public void setWarningTimes(Integer warningTimes) {
        this.warningTimes = warningTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", model=").append(model);
        sb.append(", warningTimes=").append(warningTimes);
        sb.append("]");
        return sb.toString();
    }
}