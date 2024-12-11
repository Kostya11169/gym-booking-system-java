import java.util.*;
import java.time.LocalDate;

public class SportsCenter {
    private List<Service> services = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private ServiceFactory serviceFactory = new ConcreteServiceFactory();

    public void registerClient(int id, String name, String lastName, String phoneNumber) {
        clients.add(new Client(id, name, lastName, phoneNumber));
    }

        public void addService(String serviceName, double price) {
        Service service = serviceFactory.createService(serviceName, price);
        services.add(service);
    }

    public void createReservation(int clientId, String serviceName, LocalDate date, Booking booking) {
        Client client = null;
        for (Client c : clients) {
            if (c.getId() == clientId) {
                client = c;
                break;
            }
        }
        if (client == null) {
            throw new IllegalArgumentException("Client not found");
        }

        Service service = null;
        for (Service s : services) {
            if (s.getServiceName().equals(serviceName)) {
                service = s;
                break;
            }
        }
        if (service == null) {
            throw new IllegalArgumentException("Service not found");
        }


        reservations.add(new Reservation(client, service, date, booking));
    }




    public List<Service> getServices() {
        return Collections.unmodifiableList(services);
    }

    public List<Reservation> getClientReservations(int clientId) {
        List<Reservation> clientReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getClient().getId() == clientId) {
                clientReservations.add(reservation);
            }
        }
        return clientReservations;
    }

    public List<Reservation> getServiceReservations(String serviceName) {
        List<Reservation> serviceReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getService().getServiceName().equals(serviceName)) {
                serviceReservations.add(reservation);
            }
        }
        return serviceReservations;
    }

    public List<Client> getAllClients() {
        return clients;
    }

}
