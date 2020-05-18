package team.fta.industry.entity;

public class Valve {
    private int flow;
    private int pressure;
    private int level;
    private int frequency;

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Valve{" +
                "flow=" + flow +
                ", pressure=" + pressure +
                ", level=" + level +
                ", frequency=" + frequency +
                '}';
    }
}
