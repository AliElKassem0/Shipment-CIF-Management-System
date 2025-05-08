/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
/**
 *
 * @author User
 */
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String countryCode;

    private static final List<String> countryNames = new ArrayList<>();
    private static final List<String> countryCodes = new ArrayList<>();

    static {

        countryNames.add("Lebanon");
        countryCodes.add("+961");

        countryNames.add("France");
        countryCodes.add("+33");

        countryNames.add("Germany");
        countryCodes.add("+49");

        countryNames.add("Japan");
        countryCodes.add("+81");

        countryNames.add("China");
        countryCodes.add("+86");

        countryNames.add("Korea");
        countryCodes.add("+82");

        countryNames.add("India");
        countryCodes.add("+91");

        countryNames.add("Russia");
        countryCodes.add("+7");

        countryNames.add("Turkmenistan");
        countryCodes.add("+993");

        countryNames.add("Spain");
        countryCodes.add("+34");

        countryNames.add("Greenland");
        countryCodes.add("+299");
    }

    public Customer(String id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void readDetails(Scanner sc) {
        boolean validId = false;
        boolean validFirstName = false;
        boolean validLastName = false;
        boolean validPhoneNumber = false;
        String phoneNumberRegex = "\\d{6,10}";

        while (!(validId && validFirstName && validLastName && validPhoneNumber)) {
            try {
                if (!validId) {
                    System.out.print("Enter the Customer's ID (in format X000X): ");
                    String id = sc.next();
                    if (id.matches("[A-Za-z]\\d{3}[A-Za-z]")) {
                        this.id = id;
                        validId = true;
                    } else {
                        System.out.println("Invalid ID format. Please enter an ID in the format X000X (1 letter followed by 3 digits and another letter).");
                        continue;
                    }
                }
                System.out.println();
                if (!validFirstName) {
                    System.out.print("Enter the Customer's First Name: ");
                    String firstName = sc.next();
                    if (firstName.matches("[A-Za-z]+")) {
                        this.firstName = firstName;
                        validFirstName = true;
                    } else {
                        System.out.println("Invalid first name format. Please enter only letters.");
                        continue;
                    }
                }
                System.out.println();
                if (!validLastName) {
                    System.out.print("Enter the Customer's Last Name: ");
                    String lastName = sc.next();
                    if (lastName.matches("[A-Za-z]+")) {
                        this.lastName = lastName;
                        validLastName = true;
                    } else {
                        System.out.println("Invalid last name format. Please enter only letters.");
                        continue;
                    }
                }
                System.out.println();
                if (!validPhoneNumber) {
                    System.out.println("Select the Country Calling Code:");
                    displayCountryCodes();
                    String countryCode = selectCountryCode(sc);
                    if (countryCode != null) {
                        this.countryCode = countryCode;
                        System.out.print("Enter the rest of the Customer's Phone Number: ");
                        String phoneNumber = sc.next();
                        if (phoneNumber.matches(phoneNumberRegex)) {
                            this.phoneNumber = countryCode + phoneNumber;
                            validPhoneNumber = true;
                        } else {
                            System.out.println("Invalid phone number format. Please enter only numbers (6 to 10 digits).");
                            sc.nextLine();
                            continue;
                        }
                    } else {
                        System.out.println("Invalid choice. Please select a valid country calling code.");
                        sc.nextLine();
                        continue;
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
    }

    private void displayCountryCodes() {
        for (int i = 0; i < countryNames.size(); i++) {
            System.out.println((i + 1) + ". " + countryNames.get(i) + " " + countryCodes.get(i));
        }
    }

    private String selectCountryCode(Scanner sc) {
        int selectedCodeIndex = -1;
        while (selectedCodeIndex == -1) {
            System.out.print("Enter the number corresponding to the country code: ");
            int choice = sc.nextInt();
            System.out.println();
            if (choice >= 1 && choice <= countryCodes.size()) {
                selectedCodeIndex = choice - 1;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and " + countryCodes.size() + ".");
                sc.nextLine();
            }
        }
        return countryCodes.get(selectedCodeIndex);
    }

    @Override
    public String toString() {
        return "The Customer's id: " + id
                + "\n" + "Customer's First Name: " + firstName
                + "\n" + "Customer's Last Name: " + lastName
                + "\n" + "Customer's Phone Number: " + phoneNumber
                + "\n" + "----------------------------------------------------";
    }

}
