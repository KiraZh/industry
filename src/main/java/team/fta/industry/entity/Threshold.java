package team.fta.industry.entity;

public class Threshold {
    private int generator_frequency_high;
    private int generator_frequency_low;
    private int generator_voltage_high;
    private int generator_voltage_low;
    private int generator_current_high;
    private int generator_current_low;
    private double generator_load_rate_high;
    private double generator_load_rate_low;
    private int generator_power_high;
    private int generator_power_low;
    private int pump_flow_high;
    private int pump_flow_low;
    private int valve_flow_high;
    private int valve_flow_low;
    private int valve_pressure_high;
    private int valve_pressure_low;
    private int valve_level_high;
    private int valve_level_low;
    private int valve_frequency_high;
    private int valve_frequency_low;

    public int getGenerator_frequency_high() {
        return generator_frequency_high;
    }

    public void setGenerator_frequency_high(int generator_frequency_high) {
        this.generator_frequency_high = generator_frequency_high;
    }

    public int getGenerator_frequency_low() {
        return generator_frequency_low;
    }

    public void setGenerator_frequency_low(int generator_frequency_low) {
        this.generator_frequency_low = generator_frequency_low;
    }

    public int getGenerator_voltage_high() {
        return generator_voltage_high;
    }

    public void setGenerator_voltage_high(int generator_voltage_high) {
        this.generator_voltage_high = generator_voltage_high;
    }

    public int getGenerator_voltage_low() {
        return generator_voltage_low;
    }

    public void setGenerator_voltage_low(int generator_voltage_low) {
        this.generator_voltage_low = generator_voltage_low;
    }

    public int getGenerator_current_high() {
        return generator_current_high;
    }

    public void setGenerator_current_high(int generator_current_high) {
        this.generator_current_high = generator_current_high;
    }

    public int getGenerator_current_low() {
        return generator_current_low;
    }

    public void setGenerator_current_low(int generator_current_low) {
        this.generator_current_low = generator_current_low;
    }

    public double getGenerator_load_rate_high() {
        return generator_load_rate_high;
    }

    public void setGenerator_load_rate_high(double generator_load_rate_high) {
        this.generator_load_rate_high = generator_load_rate_high;
    }

    public double getGenerator_load_rate_low() {
        return generator_load_rate_low;
    }

    public void setGenerator_load_rate_low(double generator_load_rate_low) {
        this.generator_load_rate_low = generator_load_rate_low;
    }

    public int getGenerator_power_high() {
        return generator_power_high;
    }

    public void setGenerator_power_high(int generator_power_high) {
        this.generator_power_high = generator_power_high;
    }

    public int getGenerator_power_low() {
        return generator_power_low;
    }

    public void setGenerator_power_low(int generator_power_low) {
        this.generator_power_low = generator_power_low;
    }

    public int getPump_flow_high() {
        return pump_flow_high;
    }

    public void setPump_flow_high(int pump_flow_high) {
        this.pump_flow_high = pump_flow_high;
    }

    public int getPump_flow_low() {
        return pump_flow_low;
    }

    public void setPump_flow_low(int pump_flow_low) {
        this.pump_flow_low = pump_flow_low;
    }

    public int getValve_flow_high() {
        return valve_flow_high;
    }

    public void setValve_flow_high(int valve_flow_high) {
        this.valve_flow_high = valve_flow_high;
    }

    public int getValve_flow_low() {
        return valve_flow_low;
    }

    public void setValve_flow_low(int valve_flow_low) {
        this.valve_flow_low = valve_flow_low;
    }

    public int getValve_pressure_high() {
        return valve_pressure_high;
    }

    public void setValve_pressure_high(int valve_pressure_high) {
        this.valve_pressure_high = valve_pressure_high;
    }

    public int getValve_pressure_low() {
        return valve_pressure_low;
    }

    public void setValve_pressure_low(int valve_pressure_low) {
        this.valve_pressure_low = valve_pressure_low;
    }

    public int getValve_level_high() {
        return valve_level_high;
    }

    public void setValve_level_high(int valve_level_high) {
        this.valve_level_high = valve_level_high;
    }

    public int getValve_level_low() {
        return valve_level_low;
    }

    public void setValve_level_low(int valve_level_low) {
        this.valve_level_low = valve_level_low;
    }

    public int getValve_frequency_high() {
        return valve_frequency_high;
    }

    public void setValve_frequency_high(int valve_frequency_high) {
        this.valve_frequency_high = valve_frequency_high;
    }

    public int getValve_frequency_low() {
        return valve_frequency_low;
    }

    public void setValve_frequency_low(int valve_frequency_low) {
        this.valve_frequency_low = valve_frequency_low;
    }

    @Override
    public String toString() {
        return "Threshold{" +
                "generator_frequency_high=" + generator_frequency_high +
                ", generator_frequency_low=" + generator_frequency_low +
                ", generator_voltage_high=" + generator_voltage_high +
                ", generator_voltage_low=" + generator_voltage_low +
                ", generator_current_high=" + generator_current_high +
                ", generator_current_low=" + generator_current_low +
                ", generator_load_rate_high=" + generator_load_rate_high +
                ", generator_load_rate_low=" + generator_load_rate_low +
                ", generator_power_high=" + generator_power_high +
                ", generator_power_low=" + generator_power_low +
                ", pump_flow_high=" + pump_flow_high +
                ", pump_flow_low=" + pump_flow_low +
                ", valve_flow_high=" + valve_flow_high +
                ", valve_flow_low=" + valve_flow_low +
                ", valve_pressure_high=" + valve_pressure_high +
                ", valve_pressure_low=" + valve_pressure_low +
                ", valve_level_high=" + valve_level_high +
                ", valve_level_low=" + valve_level_low +
                ", valve_frequency_high=" + valve_frequency_high +
                ", valve_frequency_low=" + valve_frequency_low +
                '}';
    }
}
