package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotMain {
    private String parkingLotId;
    Integer floorCount;
    Integer numberOfParkingSlotPerFloor;
    List<Floor> floors;

    public ParkingLotMain(String parkingLotId, Integer floorCount, Integer numberOfParkingSlotPerFloor) {
        this.floors = new ArrayList<>();
        this.floorCount = floorCount;
        this.numberOfParkingSlotPerFloor = numberOfParkingSlotPerFloor;
        this.parkingLotId = parkingLotId;
        for (int i = 1; i <= this.floorCount; i++) {
            floors.add(new Floor(i, numberOfParkingSlotPerFloor));
        }
    }

    public Ticket bookSlotBasisSlotType(Vehicle veh) {
        Optional<Slot> firstFreeSlotOptional = null;
        int firstFreeFloorNumber = -1;
        for (int i = 0; i < floorCount; i++) {
            firstFreeSlotOptional = floors.get(i).getFirstAvailableSlot(veh);
            if (firstFreeSlotOptional.isPresent()) {
                System.out.println("Free slot is available at slotNo. :" + firstFreeSlotOptional.get().getSlotNumber() +
                        " at floor no. " + floors.get(i).getFloorNumber());
                firstFreeFloorNumber = floors.get(i).getFloorNumber();
                break;
            }
            // System.out.println("No free slot on floor no. :" + floors.get(i).getFloorNumber());
        }
        if (firstFreeSlotOptional.isPresent()) {
            Slot firstFreeSlot = firstFreeSlotOptional.get();
            firstFreeSlot.parkVehicle(veh);
            String ticketId = parkingLotId + "_" + firstFreeFloorNumber + "_" + firstFreeSlot.getSlotNumber();
            return new Ticket(ticketId, veh);

        } else {
            System.out.println("We can not park the vehicle number: " + veh.getRegistrationNumber() + " with type as " + veh.getVehicleType() + " now. Please try after sometime.");
            return null;
        }

    }

    public static void main(String args[]) {
        ParkingLotMain parkingLotMain = new ParkingLotMain("PR1234", 3, 10);
        parkingLotMain.floors.forEach(floor -> System.out.println("Total Car Slot : " + floor.getFreeSlotCountBasisSlotType("car")
                + " on Floor no. : " + floor.getFloorNumber()));
        parkingLotMain.floors.forEach(floor -> System.out.println("Total Truck Slot : " + floor.getFreeSlotCountBasisSlotType("truck")
                + " on Floor no. : " + floor.getFloorNumber()));

        parkingLotMain.floors.forEach(floor -> floor.displayFreeSpaceBasisSlotType("bike"));
        parkingLotMain.floors.forEach(floor -> floor.displayFreeSpaceBasisSlotType("car"));
        parkingLotMain.floors.forEach(floor -> floor.displayFreeSpaceBasisSlotType("truck"));

        Ticket tic = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.BIKE, "MP091213", "WHITE"));
        Ticket tic1 = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.BIKE, "MP091214", "BLACK"));
        Ticket tic2 = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.TRUCK, "MP091213", "RED_BLACK"));
        Ticket tic3 = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.TRUCK, "MP091214", "RED_BLACK"));
        Ticket tic4 = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.TRUCK, "MP091215", "RED_BLACK"));
        Ticket tic5 = parkingLotMain.bookSlotBasisSlotType(new Vehicle(VehicleType.TRUCK, "MP091216", "RED_BLACK"));

        System.out.println(tic.toString());
        System.out.println(tic1.toString());
        System.out.println(tic2.toString());
        System.out.println(tic3.toString());
    }

}
