public abstract class Service{
    protected String serviceName;
    protected double price;

    public Service(String serviceName,  double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDescription();

}
