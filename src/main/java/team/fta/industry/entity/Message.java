package team.fta.industry.entity;

import java.util.Date;

public class Message {
    private String pushMsg;
    private Date time;
    private String href;

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
        return "Message{" +
                "pushMsg='" + pushMsg + '\'' +
                ", time=" + time +
                ", href='" + href + '\'' +
                '}';
    }
}
