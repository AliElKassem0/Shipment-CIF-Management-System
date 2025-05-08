package project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Shipment> shipments = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        System.out.println();
        System.out.println("----Welcome to Shipment CIF Management System----");
        System.out.println();
        boolean exit = false;
        boolean validChoice = false;
        boolean validDelete = false;
        boolean validShipment = false;
        boolean validCustomer = false;
        int choice = 0;
        while (!exit) {
            System.out.println("How can we assist you ?");
            System.out.println("1) Add customer information.");
            System.out.println("2) Add Shipment.");
            System.out.println("3) Print All Customers.");
            System.out.println("4) Print All Shipments.");
            System.out.println("5) Add Order.");
            System.out.println("6) Delete Order.");
            System.out.println("7) Print All Orders.");
            System.out.println("8) Print Invoice.");
            System.out.println("9) Exit.");
            System.out.println("----------------------------");

            validChoice = false;

            while (!validChoice) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    validChoice = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer between 1 and 9.");
                    System.out.println();
                    sc.nextLine();
                }
            }
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("Adding Customer Information...");
                    Customer customer = new Customer();
                    customer.readDetails(sc);
                    customers.add(customer);
                    System.out.println("Customer Added !");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Choose The Type Of Shipment:");
                    System.out.println("1. Air Shipment");
                    System.out.println("2. Land Shipment");
                    System.out.println("3. Sea Shipment");
                    boolean validShipmentType = false;
                    while (!validShipmentType) {
                        System.out.print("Type Of Shipment (Choose the integer corresponding to the type you want): ");
                        try {
                            int chosenType = sc.nextInt();
                            switch (chosenType) {
                                case 1:
                                    Shipment airShipment = new AirShipment();
                                    System.out.println("Creating Air Shipment..");
                                    airShipment.readDetails(sc);
                                    shipments.add(airShipment);
                                    System.out.println("--Air Shipment Created !--");
                                    System.out.println();
                                    validShipmentType = true;
                                    break;

                                case 2:
                                    Shipment landShipment = new LandShipment();
                                    System.out.println("Creating Land Shipment..");
                                    landShipment.readDetails(sc);
                                    shipments.add(landShipment);
                                    System.out.println("--Land Shipment Created !--");
                                    System.out.println();
                                    validShipmentType = true;
                                    break;

                                case 3:
                                    Shipment seaShipment = new SeaShipment();
                                    System.out.println("Creating Sea Shipment..");
                                    seaShipment.readDetails(sc);
                                    shipments.add(seaShipment);
                                    System.out.println("--Sea Shipment Created !--");
                                    System.out.println();
                                    validShipmentType = true;
                                    break;

                                default:
                                    System.out.println("Invalid input. Please choose a valid type of shipment (1, 2, or 3).");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            sc.nextLine();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Printing Customers..");
                    if (customers.isEmpty()) {
                        System.out.println("--No customers to print--");
                        System.out.println();
                    } else {
                        for (Customer c : customers) {
                            System.out.println(c.toString());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Printing Shipments..");
                    if (shipments.isEmpty()) {
                        System.out.println("--No shipments to print--");
                        System.out.println();
                    } else {
                        for (Shipment shipment : shipments) {
                            System.out.println(shipment.toString());
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    validCustomer = false;
                    validShipment = false;
                    while (!validCustomer || !validShipment) {
                        if (shipments.isEmpty() || customers.isEmpty()) {
                            System.out.println("Please create a shipment and add customer information first.");
                            break; 
                        }
                        if (!shipments.isEmpty() && !customers.isEmpty()) {
                            System.out.println("Creating Order...");
                            try {
                                System.out.println("Select Shipment (index next to each shipment):");
                                for (int i = 0; i < shipments.size(); i++) {
                                    System.out.println((i + 1) + ". \n" + shipments.get(i).toString());
                                }
                                System.out.print("shipment choice: ");
                                int shipmentChoice = sc.nextInt();
                                if (shipmentChoice >= 1 && shipmentChoice <= shipments.size()) {
                                    Shipment selectedShipment = shipments.get(shipmentChoice - 1);
                                    validShipment = true;
                                    sc.nextLine();

                                    System.out.println("Select Customer (index next to each customer):");
                                    for (int i = 0; i < customers.size(); i++) {
                                        System.out.println((i + 1) + ". \n" + customers.get(i).toString());
                                    }
                                    System.out.print("customer choice: ");
                                    int customerChoice = sc.nextInt();
                                    if (customerChoice >= 1 && customerChoice <= customers.size()) {
                                        Customer selectedCustomer = customers.get(customerChoice - 1);

                                        Order order = new Order(selectedShipment, selectedCustomer);
                                        orders.add(order);
                                        validCustomer = true;
                                        sc.nextLine();
                                        System.out.println("--Order created!--");
                                        System.out.println();

                                    } else {
                                        System.out.println("Invalid customer choice.");
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Invalid shipment choice.");
                                    System.out.println();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                System.out.println();
                                sc.nextLine();
                            }
                        } else {
                            System.out.println("Please create a shipment and add customer information first.");
                            System.out.println();
                            sc.nextLine();
                        }
                    }
                    break;

                case 6:
                    validDelete = false;
                    while (!validDelete) {
                        if (!orders.isEmpty()) {
                            System.out.println("Deleting Order...");
                            System.out.println("Select Order to Delete:");
                            for (int i = 0; i < orders.size(); i++) {
                                System.out.println((i + 1) + ". \n" + orders.get(i).toString());
                            }
                            System.out.print("Order index to delete: ");
                            try {
                                int orderIndex = sc.nextInt();
                                if (orderIndex >= 1 && orderIndex <= orders.size()) {
                                    orders.remove(orderIndex - 1);
                                    System.out.println("--Order deleted!--");
                                    System.out.println();
                                } else {
                                    System.out.println("Invalid order index.");
                                    System.out.println();
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                System.out.println();
                                sc.nextLine();
                                continue;
                            }
                        } else {
                            System.out.println("No orders available to delete.");
                            System.out.println();
                            break;
                        }
                        validDelete = true;
                    }
                    break;

                case 7:
                    System.out.println("Printing Orders..");
                    if (orders.isEmpty()) {
                        System.out.println("--No orders to print--");
                        System.out.println();
                    } else {
                        for (Order order : orders) {
                            System.out.println(order.toString());
                        }
                    }
                    break;

                case 8:
                    System.out.println("Printing Invoice..");
                    while (true) {
                        if (!orders.isEmpty()) {
                            System.out.println("Select Order to Print Invoice:");
                            for (int i = 0; i < orders.size(); i++) {
                                System.out.println((i + 1) + ". \n" + orders.get(i).toString());
                            }
                            System.out.print("Order index to print invoice: ");
                            try {
                                int orderIndex = sc.nextInt();
                                if (orderIndex >= 1 && orderIndex <= orders.size()) {
                                    Order selectedOrder = orders.get(orderIndex - 1);
                                    InvoiceFrame invoiceFrame = new InvoiceFrame(selectedOrder);
                                    invoiceFrame.setVisible(true);
                                    break;
                                } else {
                                    System.out.println("Invalid order index.");
                                    System.out.println();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer.");
                                System.out.println();
                                sc.nextLine();
                            }
                        } else {
                            System.out.println("No orders available to print invoice.");
                            System.out.println();
                            break;
                        }
                    }
                    break;

                case 9:
                    exit = true;
                    System.out.println("Exiting the program... Have a great day from ali and lama!");
                    break;

                default:
                    System.out.println("Invalid input. Please enter an integer between 1 and 9.");
                    System.out.println();
                    break;

            }
        }
        sc.close();
    }
}
