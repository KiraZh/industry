package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable {
    private String userName;

    private Date lastTime;

    private String email;

    private String sessionkey;

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userName=").append(userName);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", email=").append(email);
        sb.append(", sessionkey=").append(sessionkey);
        sb.append("]");
        return sb.toString();
    }
}