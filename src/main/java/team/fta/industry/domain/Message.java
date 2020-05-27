package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private String pushMsg;

    private Date time;

    private String href;

    private static final long serialVersionUID = 1L;

    public String getPushMsg() {
        return pushMsg;
    }

    public void setPushMsg(String pushMsg) {
        this.pushMsg = pushMsg;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pushMsg=").append(pushMsg);
        sb.append(", time=").append(time);
        sb.append(", href=").append(href);
        sb.append("]");
        return sb.toString();
    }
}