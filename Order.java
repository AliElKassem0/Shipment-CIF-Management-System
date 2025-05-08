package project;
public class Order {
    private static int nextId = 1;

    private int id;
    private Shipment shipment;
    private Customer customer;

    public Order(Shipment shipment, Customer customer) {
        this.id = nextId++;
        this.shipment = shipment;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        StringBuilder invoiceText = new StringBuilder();
        invoiceText.append("Invoice\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Order ID: ").append(id).append("\n");
        invoiceText.append("Customer Name: ").append(customer.getFirstName()).append("\n");
        invoiceText.append("Shipment Type: ").append(shipment.getClass().getSimpleName()).append("\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Shipment                           Price\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append(String.format("%-30s $%.2f\n", "Total Cost:", shipment.calculateCost()));
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Shipment Informations: \n");
        invoiceText.append("Origin Country: ").append(shipment.getOriginCountry()).append("\n");
        invoiceText.append("Destination Country: ").append(shipment.getDestinationCountry()).append("\n");
        invoiceText.append("Origin Port: ").append(shipment.getOriginPort()).append("\n");
        invoiceText.append("Destination Port: ").append(shipment.getDestinationPort()).append("\n");
        invoiceText.append("Number Of Parcels:  ").append(shipment.getNumberOfParcel()).append("\n");
        return invoiceText.toString();
    }
}
