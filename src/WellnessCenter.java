public class WellnessCenter extends Service{
    public WellnessCenter(double price) {
        super("Wellness", price);
    }

    @Override
    public String getDescription() {
        return "Enjoy our wellness treatments.";
    }
}
