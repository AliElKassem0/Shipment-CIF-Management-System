package project;

import java.util.*;

public class SeaShipment extends Shipment implements Payment {

    private int numberOfCargo;
    private double pricePerCargo;

    public SeaShipment() {
        super();
        numberOfCargo = 0;
        pricePerCargo = 0;
    }

    public SeaShipment(int numberOfCargo, double pricePerCargo, String id, int numberOfParcel, String originCountry, String destinationCountry, String originPort, String destinationPort) {
        super(id, numberOfParcel, originCountry, destinationCountry, originPort, destinationPort);
        this.numberOfCargo = numberOfCargo;
        this.pricePerCargo = pricePerCargo;
    }

    public int getNumberOfCargo() {
        return numberOfCargo;
    }

    public void setNumberOfCargo(int numberOfCargo) {
        this.numberOfCargo = numberOfCargo;
    }

    public double getPricePerCargo() {
        return pricePerCargo;
    }

    public void setPricePerCargo(double pricePerCargo) {
        this.pricePerCargo = pricePerCargo;
    }
    
    

    @Override
    public void readDetails(Scanner sc) {

        boolean validId = false;
        boolean validNumberOfParcel = false;
        boolean validOriginCountry = false;
        boolean validDestinationCountry = false;
        boolean validOriginPort = false;
        boolean validDestinationPort = false;

        Map<String, List<String>> validCountryPorts = new HashMap<>();
        validCountryPorts.put("lebanon", Arrays.asList("Beirut Port(LB BEY)", "Tripoli Port(LB TRP)"));
        validCountryPorts.put("germany", Arrays.asList("Hamburg Port(DE HAM)", "Bremerhaven Port(DE BRV)"));
        validCountryPorts.put("france", Arrays.asList("Marseille Port(FR MRS)", "Le Havre Port(FR LEH)"));
        validCountryPorts.put("japan", Arrays.asList("Yokohama Port(JP YOK)", "Tokyo Port(JP TYO)"));
        validCountryPorts.put("spain", Arrays.asList("Barcelona Port(ES BCN)", "Algeciras Port(ES ALG)"));
        validCountryPorts.put("greenland", Arrays.asList("Nuuk Port(GL GOH)", "Sisimiut Port(GL JJU)"));

        while (!(validId && validNumberOfParcel && validOriginCountry && validDestinationCountry && validOriginPort && validDestinationPort)) {
            try {
                if (!validId) {
                    System.out.print("Enter The Shipment's id (in format XX000): ");
                    id = sc.next();
                    if (id.matches("[A-Za-z]{2}\\d{3}")) {
                        validId = true;
                    } else {
                        System.out.println("Invalid ID format. Please enter an ID in the format XX000 (2 letters followed by 3 digits).");
                        continue;
                    }
                }
                System.out.println();
                if (!validNumberOfParcel) {
                    System.out.print("Enter The Number Of Parcel: ");
                    numberOfParcel = Integer.parseInt(sc.next());
                    validNumberOfParcel = true;
                }
                System.out.println();
                if (!validOriginCountry) {
                    System.out.println("Enter The Origin Country:");
                    displayValidCountries(validCountryPorts.keySet());
                    System.out.print("Origin Country(Write the full name): ");
                    originCountry = sc.next().toLowerCase();
                    if (validCountryPorts.containsKey(originCountry)) {
                        validOriginCountry = true;
                    } else {
                        System.out.println("Invalid country name. Please choose from the list of valid countries.");
                        continue;
                    }
                }
                System.out.println();
                if (!validDestinationCountry) {
                    System.out.println("Enter The Destination Country:");
                    displayValidCountries(validCountryPorts.keySet());
                    System.out.print("Destination Country(write the full name): ");
                    destinationCountry = sc.next().toLowerCase();
                    if (validCountryPorts.containsKey(destinationCountry)) {
                        validDestinationCountry = true;
                    } else {
                        System.out.println("Invalid country name. Please choose from the list of valid countries.");
                        continue;
                    }
                }
                System.out.println();
                if (!validOriginPort) {
                    System.out.println("Enter The Origin Port:");
                    displayValidPorts(validCountryPorts.get(originCountry));
                    System.out.print("Origin Port(Only the integer): ");
                    int portChoice = sc.nextInt();
                    if (portChoice >= 1 && portChoice <= validCountryPorts.get(originCountry).size()) {
                        originPort = validCountryPorts.get(originCountry).get(portChoice - 1);
                        validOriginPort = true;
                    } else {
                        System.out.println("Invalid port number. Please choose a number from the list.");
                        continue;
                    }
                }
                System.out.println();
                if (!validDestinationPort) {
                    System.out.println("Enter The Destination Port:");
                    displayValidPorts(validCountryPorts.get(destinationCountry));
                    System.out.print("Destination Port(Only the integer): ");
                    int portChoice = sc.nextInt();
                    if (portChoice >= 1 && portChoice <= validCountryPorts.get(destinationCountry).size()) {
                        destinationPort = validCountryPorts.get(destinationCountry).get(portChoice - 1);
                        validDestinationPort = true;
                    } else {
                        System.out.println("Invalid port number. Please choose a number from the list.");
                        continue;
                    }
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for the number of parcels.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter a valid integer.");
                sc.nextLine();
            }
        }

        HashMap<String, Integer> container = new HashMap<>();

        container.put("40ft", 100);
        container.put("20ft", 50);

        int choice = 0;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            try {
                System.out.println("Available container sizes and prices:");
                System.out.println("1. 40ft ($100)");
                System.out.println("2. 20ft ($50)");
                System.out.print("Enter your choice (1 or 2): ");
                int ans = sc.nextInt();

                if (ans == 1 || ans == 2) {
                    choice = ans;
                    System.out.println();
                    isValidChoice = true;
                } else {
                    System.out.println("Invalid input. Please enter 1 or 2.");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer (1 or 2).");
                System.out.println();
                sc.nextLine(); // Consume the invalid input to clear the scanner buffer
            }
        }

        if (choice == 1) {
            pricePerCargo = 100;
        } else {
            pricePerCargo = 50;
        }

        boolean validNumberOfCargo = false;

        while (!(validNumberOfCargo)) {
            try {
                if (!validNumberOfCargo) {
                    System.out.print("Enter the number of Cargos: ");
                    numberOfCargo = sc.nextInt();
                    validNumberOfCargo = true;
                }

                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                sc.nextLine();
            }
        }
    }

    @Override
    public double calculateCost() {
        return numberOfCargo * pricePerCargo;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------"
                + "\n" + "Displaying Informations About The Sea Shipment"
                + "\n" + "----------------------------------------------------"
                + "\n" + super.toString()
                + "\n" + "The number of cargos: " + numberOfCargo
                + "\n" + "The cost per cargo you've chosen: " + pricePerCargo + "$"
                + "\n" + "Total Cost Of The Sea Shipment: " + calculateCost() + " $";
                
                
    }

    public String TrackStatus() {
        return "The Status Of The Sea Shipment: In the Ship";
    }

    public String getLocation() {
        return "The Location Of The Sea Shipment: At The Port";
    }

    private static void displayValidCountries(Set<String> countries) {
        System.out.println("Valid countries:");
        for (String country : countries) {
            System.out.println("- " + country);
        }
    }

    private static void displayValidPorts(List<String> ports) {
        int i = 1;
        System.out.println("Valid ports:");
        for (String port : ports) {
            System.out.println(i + ". " + port);
            i++;
        }
    }
}
