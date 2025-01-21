package parkinglot;

public class Slot {

    private Integer slotNumber;
    private String slotType;
    private Vehicle vehicle;
    private Boolean isAvailable;

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Slot(Integer slotNumber, String slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.vehicle = null;
        this.isAvailable = true;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (getIsAvailable() && vehicle.getVehicleType().getType().equals(slotType)) {
            this.isAvailable = false;
            this.vehicle = vehicle;
        } else {
            System.out.println("Slot not available for vehicle type: " + vehicle.getVehicleType());
        }
    }


    public Integer getSlotNumber() {
        return slotNumber;
    }

    public String getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }
}
