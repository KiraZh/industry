package team.fta.industry.entity;

public class WaterQuality {
    private double oxygen;
    private double ph;
    private double turbidity;
    private float air;

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public float getAir() {
        return air;
    }

    public void setAir(float air) {
        this.air = air;
    }

    @Override
    public String toString() {
        return "WaterQuality{" +
                "oxygen=" + oxygen +
                ", ph=" + ph +
                ", turbidity=" + turbidity +
                ", air=" + air +
                '}';
    }
}
