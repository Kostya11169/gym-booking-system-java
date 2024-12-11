import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class SportsCenterApp{
    private SportsCenter sportsCenter;
    private Scanner scanner;

    public SportsCenterApp(){
        sportsCenter = new SportsCenter();
        scanner = new Scanner(System.in);
    }

    public void start(){
        int choice;
        do {
            printMenu();
            choice = readIntInput("Enter your choice: ");
            switch (choice){
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    addNewService();
                    break;
                case 3:
                    createBooking();
                    break;
                case 4:
                    viewAvailableServices();
                    break;
                case 5:
                    viewCustomerReservations();
                    break;
                case 6:
                    viewBookingsByService();
                    break;
                case 7:
                    viewAllClients();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. New customer registration");
        System.out.println("2. Adding new service");
        System.out.println("3. Creating a new booking");
        System.out.println("4. View available services");
        System.out.println("5. View customer reservations");
        System.out.println("6. View bookings by service");
        System.out.println("7. View all clients");
        System.out.println("0. Exit the program");
    }

    private int readIntInput(String prompt){
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    private String readStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    private double readDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid double value.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    private void registerCustomer() {
        int id = readIntInput("Enter id of customer: ");
        String name = readStringInput("Enter customer name: ");
        String lastName = readStringInput("Enter customer surname: ");
        String phoneNumber = readStringInput("Enter customer phone number: ");
        sportsCenter.registerClient(id, name, lastName, phoneNumber);
        System.out.println("Customer registered successfully!");
    }

    private void addNewService() {
        try {
            String serviceName = readStringInput("Enter service name(Gym, Tennis, Wellness): ");
            double price = readDoubleInput("Enter service price: ");
            sportsCenter.addService(serviceName, price);
            System.out.println("New service added successfully!");
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    private void createBooking() {
        int clientId = readIntInput("Enter client ID: ");
        String serviceName = readStringInput("Enter service name: ");
        LocalDate date = LocalDate.now();

        Booking booking = new BaseBooking();
        if ("Gym".equalsIgnoreCase(serviceName)) {
            String trainerName = readStringInput("Enter trainer's name: ");
            booking = new TrainerDecorator(booking, trainerName);
        } else if ("Tennis".equalsIgnoreCase(serviceName)) {
            String courtName = readStringInput("Enter court's name: ");
            booking = new TennisCourtDecorator(booking, courtName);
        }
        sportsCenter.createReservation(clientId, serviceName, date, booking);
        System.out.println("Booking created successfully!");
    }



    private void viewAvailableServices() {
        System.out.println("Available services:");
        sportsCenter.getServices().forEach(service -> System.out.println(service.getServiceName() + " - $" + service.getPrice()));
    }

    private void viewCustomerReservations() {
        int clientId = readIntInput("Enter client ID: ");
        System.out.println("Reservations for client:");
        List<Reservation> clientReservations = sportsCenter.getClientReservations(clientId);
        for (Reservation reservation : clientReservations) {
            System.out.println(reservation);
            Booking booking = reservation.getBooking();
            if (booking instanceof TrainerDecorator) {
                String trainerName = ((TrainerDecorator) booking).getTrainerName();
                System.out.println("Trainer: " + trainerName);
            } else if (booking instanceof TennisCourtDecorator) {
                String courtName = ((TennisCourtDecorator) booking).getCourtName();
                System.out.println("Court: " + courtName);
            }
        }
    }

    private void viewBookingsByService() {
        String serviceName = readStringInput("Enter service name: ");
        List<Reservation> serviceReservations = sportsCenter.getServiceReservations(serviceName);
        System.out.println("Bookings for service: " + serviceName);
        for (Reservation reservation : serviceReservations) {
            System.out.println(reservation);
            Booking booking = reservation.getBooking();
            if (booking instanceof TrainerDecorator) {
                String trainerName = ((TrainerDecorator) booking).getTrainerName();
                System.out.println("Trainer: " + trainerName);
            } else if (booking instanceof TennisCourtDecorator) {
                String courtName = ((TennisCourtDecorator) booking).getCourtName();
                System.out.println("Court: " + courtName);
            }
        }
    }

    private void viewAllClients() {
        List<Client> clients = sportsCenter.getAllClients();
        Collections.sort(clients, Comparator.comparingInt(Client::getId));
        System.out.println("All clients:");
        for (Client client : clients) {
            System.out.println(client);
        }
    }
}
