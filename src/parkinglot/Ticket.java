package parkinglot;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicleNumber=" + vehicle.getRegistrationNumber() +
                '}';
    }

    public Ticket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
    }
}
