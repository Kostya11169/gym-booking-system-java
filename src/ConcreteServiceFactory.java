public class ConcreteServiceFactory implements ServiceFactory{
    @Override
    public Service createService(String serviceName, double price) {
        switch (serviceName){
            case "Tennis":
                return new TennisCourt(price);
            case "Gym":
                return new Gym(price);
            case "Wellness":
                return new WellnessCenter(price);
            default:
                throw new IllegalArgumentException("Try again");
        }
    }
}

