package com.info;

import java.util.Calendar;

public class Dog extends Pet implements Boardable {
    private String size;
    private Calendar start = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();
    public Dog(String petName, String ownerName, String color, String size) {
        super(petName, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        String body = super.toString();
        return "DOG:\n" + body + "\nSize: " + getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        start.set(year, month, day);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        end.set(year, month, day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        Calendar cur = Calendar.getInstance();
        cur.set(year, month, day);
        return start.before(cur) && end.after(cur) || cur.equals(start) || cur.equals(end);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("dandan", "Dylan", "Gray", "Medium");
        dog.setBoardStart(9,20,2018);
        dog.setBoardEnd(11,21,2018);
        System.out.println(dog);
        System.out.println(dog.boarding(8,21,2018) + "\n");

        Cat cat = new Cat("dandan", "Dylan", "Gray", "short");
        cat.setBoardStart(9,20,2018);
        cat.setBoardEnd(11,21,2018);
        System.out.println(cat);
        System.out.println(cat.boarding(11,21,2018));
    }
}
