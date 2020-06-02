package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class WaterQuality implements Serializable {
    private Date time;

    private Double oxygen;

    private Double ph;

    private Double turbidity;

    private Integer air;

    private Integer secure;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getOxygen() {
        return oxygen;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(Double turbidity) {
        this.turbidity = turbidity;
    }

    public Integer getAir() {
        return air;
    }

    public void setAir(Integer air) {
        this.air = air;
    }

    public Integer getSecure() {
        return secure;
    }

    public void setSecure(Integer secure) {
        this.secure = secure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", oxygen=").append(oxygen);
        sb.append(", ph=").append(ph);
        sb.append(", turbidity=").append(turbidity);
        sb.append(", air=").append(air);
        sb.append(", secure=").append(secure);
        sb.append("]");
        return sb.toString();
    }

    public double[] status(){
        double[] status = new double[5];
        status[0] = getOxygen();
        status[1] = getPh();
        status[2] = getTurbidity();
        status[3] = getAir();
        status[4] = getSecure();
        return status;
    }

}