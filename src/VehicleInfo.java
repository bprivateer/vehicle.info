public class VehicleInfo {
    int VIN;
    double odmeter;
    double consumption;
    double odomReader;
    double liters;

    public void vehicleInfo() {
        this.VIN = VIN;
        this.odmeter = odmeter;
        this.consumption = consumption;
        this.odomReader = odomReader;
        this.liters = liters;
    }

    public int getVIN() {
        return VIN;
    }

    public double getOdmeter() {
        return odmeter;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getOdomReader() {
        return odomReader;
    }

    public double getLiters() {
        return liters;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public void setOdmeter(double odmeter) {
        this.odmeter = odmeter;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setOdomReader(double odomReader) {
        this.odomReader = odomReader;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

}