package parkinglot;

public class Vehicle {

    private VehicleType vehicleType;
    private String registrationNumber;
    private String color;

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Vehicle(VehicleType vehicleType, String registrationNumber, String color) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
