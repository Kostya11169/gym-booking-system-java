public class Client {
    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;

    public Client(int id, String name, String lastName, String phoneNumber){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Client: " + '\n' +
                "Name: " + name + '\n' +
                "Surname: " + lastName + '\n' +
                "Phone Number: " + phoneNumber + '\n' +
                "id: " + id
                ;
    }
}
