/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.*;

public class LandShipment extends Shipment implements Payment {

    private int numberOfTrucks;
    private double costOfTruck;

    public LandShipment() {
        super();
        numberOfTrucks = 0;
        costOfTruck = 0;
    }

    public LandShipment(String id, int numberOfParcel, String originCountry, String destinationCountry, String originPort, String destinationPort, int numberOfTrucks, double costOfTruck) {
        super(id, numberOfParcel, originCountry, destinationCountry, originPort, destinationPort);
        this.numberOfTrucks = numberOfTrucks;
        this.costOfTruck = costOfTruck;

    }

    public int getNumberOfTrucks() {
        return numberOfTrucks;
    }

    public void setNumberOfTrucks(int numberOfTrucks) {
        this.numberOfTrucks = numberOfTrucks;
    }

    public double getCostOfTruck() {
        return costOfTruck;
    }

    public void setCostOfTruck(double costOfTruck) {
        this.costOfTruck = costOfTruck;
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
        validCountryPorts.put("china", Arrays.asList("Haikou Port(CN HAK)", "Rizhao Port(CN RIZ)"));
        validCountryPorts.put("india", Arrays.asList("Mumbai Port(IN BOM)", "Cochin Port(IN COK)"));
        validCountryPorts.put("korea", Arrays.asList("Busan Port(KR PUS)", "Incheon Port(KR INC)"));
        validCountryPorts.put("russia", Arrays.asList("Vladivostok Port(RU VVO)", "Novorossiysk Port(RU NVY)"));
        validCountryPorts.put("turkmmenistan", Arrays.asList("Turkmenbashi Port(TM KRW)", "Garabogaz Port(TM GBN)"));

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

        boolean validNumberOfTruck = false;
        boolean validCostOfTruck = false;

        while (!(validNumberOfTruck && validCostOfTruck)) {
            try {
                if (!validNumberOfTruck) {
                    System.out.print("Enter the number of Trucks: ");
                    numberOfTrucks = sc.nextInt();
                    validNumberOfTruck = true;
                }
                System.out.println();
                if (!validCostOfTruck) {
                    System.out.print("Enter the cost per Truck(in dollar): ");
                    costOfTruck = sc.nextDouble();
                    validCostOfTruck = true;
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
        return numberOfTrucks * costOfTruck;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------"
                + "\n" + "Displaying Informations About The Land Shipment"
                + "\n" + "----------------------------------------------------"
                + "\n" + super.toString()
                + "\n" + "The number of Trucks: " + numberOfTrucks
                + "\n" + "The cost per Truck you've chosen: " + costOfTruck + "$"
                + "\n" + "Total Cost Of The Land Shipment: " + calculateCost() + " $";
                
               
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
