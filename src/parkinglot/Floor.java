package parkinglot;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Floor {

    private final Integer floorNumber;
    private final Integer capacity;
    private final List<Slot> slots;

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public Floor(Integer floorNumber, Integer capacity) {
        slots = new ArrayList<>();
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        for (int i = 1; i <= capacity; i++) {
            slots.add(i == 1 ? new Slot(i, "truck") : (i == 2 || i == 3) ?
                    new Slot(i, "bike") : new Slot(i, "car"));
        }
    }

    public Integer getFreeSlotCountBasisSlotType(String slotType) {
        System.out.println("Free slots on floor " + floorNumber + " for " + slotType + ":");
        return (int) slots.stream().filter(slot -> slotType.equalsIgnoreCase(slot.getSlotType())).count();
    }

    public Optional<Slot> getFirstAvailableSlot(Vehicle veh) {
        return slots.stream()
                .filter(slot -> veh.getVehicleType().getType().equals(slot.getSlotType()) && slot.getIsAvailable().equals(Boolean.TRUE))
                .findFirst();

    }

    public void displayFreeSpaceBasisSlotType(String slotType) {
        slots.stream().filter(slotList -> slotType.equalsIgnoreCase(slotList.getSlotType()))
                .forEach(slot -> System.out.println("Slot No. : " + slot.getSlotNumber()));
    }


}
