package com.info;

public class Pet {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;
    private String petName;
    private String ownerName;
    private String color;
    protected int sex;

    public Pet(String petName, String ownerName, String color) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getSex() {
        switch (sex) {
            case MALE: return "MALE";
            case FEMALE: return "FEMALE";
            case SPAYED: return "SPAYED";
            case NEUTERED: return "NEUTERED";
            default: return "";
        }
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return getPetName() + " owned by "+ getOwnerName() +"\n"
                + "Color: " + getColor() + "\n"
                + "Sex: " + getSex();

    }

    public static void main(String[] args) {
        Pet p = new Pet("Spot", "Dylan", "Grey");
        p.setSex(1);
        System.out.println(p);
    }
}
