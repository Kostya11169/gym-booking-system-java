public class TennisCourt extends  Service{
    public TennisCourt(double price) {
        super("Tennis", price);
    }

    @Override
    public String getDescription() {
        return "Play tennis on our premium courts.";
    }
}
