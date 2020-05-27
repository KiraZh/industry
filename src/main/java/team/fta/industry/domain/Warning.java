package team.fta.industry.domain;

import java.io.Serializable;
import java.util.Date;

public class Warning implements Serializable {
    private Date time;

    private String content;

    private String model;

    private static final long serialVersionUID = 1L;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(time);
        sb.append(", content=").append(content);
        sb.append(", model=").append(model);
        sb.append("]");
        return sb.toString();
    }
}