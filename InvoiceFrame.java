package project;

import javax.swing.*;
import java.awt.*;

public class InvoiceFrame extends JFrame {

    private Order order;
    private Shipment shipment;

    public InvoiceFrame(Order order) {
        this.order = order;
        this.shipment = order.getShipment();
        setTitle("Invoice");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);    

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);
        invoiceArea.setFont(new Font("Arial", Font.PLAIN, 14));

        StringBuilder invoiceText = new StringBuilder();
        invoiceText.append("Invoice\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Order ID: ").append(order.getId()).append("\n");
        invoiceText.append("Customer Name: ").append(order.getCustomer().getFirstName()).append("\n");
        invoiceText.append("Shipment Type: ").append(order.getShipment().getClass().getSimpleName()).append("\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Shipment                           Price\n");
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append(String.format("%-30s $%.2f\n", "Total Cost:", order.getShipment().calculateCost()));
        invoiceText.append("-------------------------------------------\n");
        invoiceText.append("Shipment's Informations: \n");
        invoiceText.append("Origin Country: ").append(shipment.getOriginCountry()).append("\n");
        invoiceText.append("Destination Country: ").append(shipment.getDestinationCountry()).append("\n");
        invoiceText.append("Origin Port: ").append(shipment.getOriginPort()).append("\n");
        invoiceText.append("Destination Port: ").append(shipment.getDestinationPort()).append("\n");
        invoiceText.append("Number Of Parcels:  ").append(shipment.getNumberOfParcel()).append("\n");

        invoiceArea.setText(invoiceText.toString());
        mainPanel.add(new JScrollPane(invoiceArea), BorderLayout.CENTER);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(e -> {
            
            JOptionPane.showMessageDialog(this, "Invoice printed successfully!");
        });
        mainPanel.add(printButton, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
