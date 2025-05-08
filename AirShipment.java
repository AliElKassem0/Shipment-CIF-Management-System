/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.*;

/**
 *
 * @author PC
 */
public class AirShipment extends Shipment implements Payment {

    private double netWeight;
    private double grossWeight;
    private double pricePerKg;

    public AirShipment(double netWeight, double grossWeight, double pricePerKg, String id, int numberOfParcel, String originCountry, String destinationCountry, String originPort, String destinationPort) {
        super(id, numberOfParcel, originCountry, destinationCountry, originPort, destinationPort);
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.pricePerKg = pricePerKg;
    }

    public AirShipment() {
        super();
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
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
        validCountryPorts.put("lebanon", Arrays.asList("Beirut-Rafik Al Hariri Airport(BEY)", "Qlayaat-Rene Mouawad Airport(KYE)"));
        validCountryPorts.put("germany", Arrays.asList("Munich Airport(MUC)", "Berlin Brandenburg Airport(BER)"));
        validCountryPorts.put("france", Arrays.asList("Paris-Charles de Gaulle Airport(CDG)", "Lille Airport(LIL)"));
        validCountryPorts.put("japan", Arrays.asList("Tokyo-Haneda Airport(HND)", "Osaka-Itami Airport(ITM)"));
        validCountryPorts.put("spain", Arrays.asList("Adolfo Suárez Madrid–Barajas Airport(MAD)", "Palma de Mallorca Airport(PMI)"));
        validCountryPorts.put("greenland", Arrays.asList("Nuuk Airport(BGGH)", "Kangerlussuaq Airport(SFJ)"));

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
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter a valid integer.");
                sc.nextLine();
            }
        }

        boolean validNetWeight = false;
        boolean validGrossWeight = false;
        boolean validPricePerKg = false;

        while (!(validNetWeight && validGrossWeight && validPricePerKg)) {
            try {
                if (!validNetWeight) {
                    System.out.print("Enter the net weight (in Kg): ");
                    netWeight = sc.nextDouble();
                    validNetWeight = true;
                }
                System.out.println();
                if (!validGrossWeight) {
                    System.out.print("Enter the gross weight (in Kg): ");
                    grossWeight = sc.nextDouble();
                    validGrossWeight = true;
                }
                System.out.println();
                if (!validPricePerKg) {
                    System.out.print("Enter the price per kg (in dollars): ");
                    pricePerKg = sc.nextDouble();
                    validPricePerKg = true;
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
        return grossWeight * pricePerKg;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------"
                + "\n" + "Displaying Informations About The Air Shipment"
                + "\n" + "----------------------------------------------------"
                + "\n" + super.toString()
                + "\n" + "The Net Weight: " + netWeight + " Kg"
                + "\n" + "The Gross Weight: " + grossWeight + "Kg"
                + "\n" + "The Price Per Kg You've Chosen: " + pricePerKg + " $"
                + "\n" + "Total Cost Of The Air Shipment: " + calculateCost() + " $";
                
                
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
