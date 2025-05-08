package project;

import java.util.*;

public abstract class Shipment {

    protected String id;
    protected int numberOfParcel;
    protected String originCountry;
    protected String destinationCountry;
    protected String originPort;
    protected String destinationPort;

    public Shipment(String id, int numberOfParcel, String originCountry, String destinationCountry, String originPort, String destinationPort) {
        this.id = id;
        this.numberOfParcel = numberOfParcel;
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfParcel() {
        return numberOfParcel;
    }

    public void setNumberOfParcel(int numberOfParcel) {
        this.numberOfParcel = numberOfParcel;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getOriginPort() {
        return originPort;
    }

    public void setOriginPort(String originPort) {
        this.originPort = originPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    

    public Shipment() {
    }

    public abstract void readDetails(Scanner sc);

    public abstract double calculateCost();

    @Override
    public String toString() {
        return "Shipment id: " + id
                + "\n" + "Number Of Parcel: " + numberOfParcel
                + "\n" + "Origin Country: " + originCountry
                + "\n" + "Destination Country: " + destinationCountry
                + "\n" + "Origin Port: " + originPort
                + "\n" + "Destination Port: " + destinationPort;
    }
}
