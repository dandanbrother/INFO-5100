package com.info;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Mreview implements Comparable<Mreview>
{
    // instance variables
    private String title;   // title of the movie
    private ArrayList<Integer> ratings; // list of ratings stored in a Store object

    // 3 constructor
    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this(ttl);
        this.ratings.add(firstRating);
    }


    // methods
    public void addRating(int r) {
        this.ratings.add(r);
    }

    public double aveRating() {
        int res = 0;
        for (int r : ratings) {
            res += r;
        }
        return Double.parseDouble(String.format("%.2f",((double) res / ratings.size())));
    }

    public String getTitle() {
        return title;
    }

    public int numRatings() {
        return ratings.size();
    }

    public String toString() {
        return getTitle() + ", average " + aveRating() + " out of " + numRatings() + " ratings.";
    }

    public int compareTo(Mreview o) {
        return title.compareTo(o.title);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Mreview) {
            return title.equals(((Mreview) obj).title);
        }
        return false;
    }

    public static void main(String[] args) {
        Mreview mreview = new Mreview("Kill Bill");
        mreview.addRating(3);
        mreview.addRating(4);
        mreview.addRating(3);
        System.out.println(mreview);
    }

}
