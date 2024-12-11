public class TennisCourtDecorator implements Booking{
    private Booking booking;
    private String courtName;

    public TennisCourtDecorator(Booking booking, String courtName) {
        this.booking = booking;
        this.courtName = courtName;
    }

    @Override
    public void confirm() {
        booking.confirm();
        System.out.println("Court " + courtName + " added to the booking."); // Выводим название корта
    }

    public String getCourtName() {
        return courtName;
    }
}

