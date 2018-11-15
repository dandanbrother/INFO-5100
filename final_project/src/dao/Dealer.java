package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Dealer implements Serializable {
    private String id;
    private String name;
    private Address address;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Special> specials;

    public Dealer(String id, String name, Address address, ArrayList<Vehicle> vehicles, ArrayList<Special> specials) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vehicles = vehicles;
        this.specials = specials;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Special> getSpecials() {
        return specials;
    }

    public void setSpecials(ArrayList<Special> specials) {
        this.specials = specials;
    }


    // ------------- Address Class -------------------
    public static class Address {
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String zipCode;

        public Address(String address1, String address2, String city, String state, String zipCode) {
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
