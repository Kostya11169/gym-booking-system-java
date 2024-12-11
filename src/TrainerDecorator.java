public class TrainerDecorator implements Booking{
    private Booking booking;
    private String trainerName;

    public TrainerDecorator(Booking booking, String trainerName) {
        this.booking = booking;
        this.trainerName = trainerName;
    }

    @Override
    public void confirm() {
        booking.confirm();
        System.out.println("Trainer " + trainerName + " added to the booking."); // Выводим имя тренера
    }

    public String getTrainerName() {
        return trainerName;
    }
}
