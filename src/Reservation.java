import java.time.LocalDate;

public class Reservation {
    private Client client;
    private Service service;
    private LocalDate date;
    private Booking booking;

    public Reservation(Client client, Service service, LocalDate date, Booking booking) {
        this.client = client;
        this.service = service;
        this.date = date;
        this.booking = booking;
    }

    public Client getClient() {
        return client;
    }

    public Service getService() {
        return service;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Reservation: " + '\n' +
                "Client: " + client.getName() + " " + client.getLastName() + '\n' +
                "Service: " + service.getServiceName() + '\n' +
                "Date: " + date + '\n';
    }

    public void confirm() {
        booking.confirm();
    }

    public Booking getBooking() {
        return booking;
    }
}
