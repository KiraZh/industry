package team.fta.industry.entity;

public class Pump {
    private int flow;
    private int valveSwitch;

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getValveSwitch() {
        return valveSwitch;
    }

    public void setValveSwitch(int valveSwitch) {
        this.valveSwitch = valveSwitch;
    }

    @Override
    public String toString() {
        return "Pump{" +
                "flow=" + flow +
                ", valveSwitch=" + valveSwitch +
                '}';
    }

}
