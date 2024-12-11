public class Gym extends Service{

    public Gym(double price) {
        super("Gym", price);
    }

    @Override
    public String getDescription() {
        return "Access to all gym facilities.";
    }
}
