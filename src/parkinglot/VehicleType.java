package parkinglot;

public enum VehicleType {
    CAR("car"), TRUCK("truck"), BIKE("bike");
    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
