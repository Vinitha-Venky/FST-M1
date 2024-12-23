package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    // Private variables
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOff;
    private Date lastTimeLanded;

    // Constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // Method to onboard passengers
    public void onboard(String passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
            System.out.println(passenger + " has boarded the plane.");
        } else {
            System.out.println("Cannot onboard " + passenger + ". Plane is full.");
        }
    }

    // Method to simulate takeoff and return the current date and time
    public Date takeOff() {
        lastTimeTookOff = new Date();
        System.out.println("Plane has taken off at: " + lastTimeTookOff);
        return lastTimeTookOff;
    }

    // Method to simulate landing and clear the list of passengers
    public void land() {
        lastTimeLanded = new Date();
        passengers.clear();
        System.out.println("Plane has landed at: " + lastTimeLanded);
    }

    // Method to get the last time the plane landed
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    // Method to get the current list of passengers
    public List<String> getPassengers() {
        return new ArrayList<>(passengers); // Return a copy to preserve encapsulation
    }
}

public class Activity6 {
    public static void main(String[] args) {
        // Create a Plane object with a max capacity of 100 passengers
        Plane plane = new Plane(100);

        // Onboard passengers
        plane.onboard("Alice");
        plane.onboard("Bob");

        // Take off
        plane.takeOff();

        // Get the list of passengers
        System.out.println("Current passengers: " + plane.getPassengers());

        // Land the plane
        plane.land();

        // Get the last time the plane landed
        System.out.println("Last time landed: " + plane.getLastTimeLanded());
    }
}