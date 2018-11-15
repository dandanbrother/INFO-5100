
// 10/10

package com.info;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 * 1. MyIndexOutOfBoundException
 */
public class MyIndexOutOfBoundException extends ArrayIndexOutOfBoundsException {

    private int lowerBound;
    private int upperBound;
    private int index;

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Error Message: Index: " + index +
                ", but Lower bound: " + lowerBound +
                ", Upper bound: " + upperBound;
    }

    public static void main(String[] args) throws MyIndexOutOfBoundException {
        // 1
        int[] t = {1,2,3,4};
        try {
            for (int i = 0; i < 10; i++) {
                if (i >= t.length)
                    throw new MyIndexOutOfBoundException(0, t.length-1, i);
                System.out.println(t[i]);
            }
        } catch (MyIndexOutOfBoundException e) {
            System.out.println("Catch e" + e);
        }

        // 4
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,4));
        list.add(new Interval(5,7));
        list.add(new Interval(6,8));
        int[] a = {1,2,3};
        int[] b = {0};
        System.out.println(findMedianSortedArrays(a,b));
        merge(list);
    }


    /**
     * 2.Modify the following parse() method so that it will compile
     */
    public static void parse(File file) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    /**
     * 3. merger interval
     */
    public static class Interval{
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        // add your code here
        if (intervals == null || intervals.size() == 0) return new ArrayList<>();
        Collections.sort(intervals, Comparator.comparingInt(t -> t.start));
        List<Interval> res = new LinkedList<>();
        if (intervals.size() == 0) return res;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals) {
            if (interval.start <= end)
                end = interval.end;
            else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    /**
     * 5. There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // add your code here
        int m = nums1.length, n = nums2.length;
        if (m == 0) return median(nums2);
        if (n == 0) return median(nums1);
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            m = nums1.length;
            n = nums2.length;
        }
        int start = 0, end = m;
        int i, j, half = (m + n + 1)/2;
        int left_max = nums1[0], right_min = nums1[m-1];
        while (start <= end) {
            i = (start + end) / 2;
            j = half - i;
            if (i < m && nums1[i] < nums2[j-1])
                start = i+1;     // i too small
            else if (i > 0 && nums1[i-1] > nums2[j])
                end = i-1;       // i too big
            else {
                if (i == 0)      // nums1[0] > nums2[j]
                    left_max = nums2[j-1];
                else if (j == 0) // nums1[i] < nums2[0]
                    left_max = nums1[i-1];
                else
                    left_max = Math.max(nums1[i-1], nums2[j-1]);

                if ((m + n) % 2 == 1)  //odd
                    return left_max;
                if (i == m)
                    right_min = nums2[j];
                else if (j == n)
                    right_min = nums1[i];
                else
                    right_min = Math.min(nums1[i], nums2[j]);
                return (double)(left_max + right_min)/2;
            }
        }
        return 0;
    }
    public static double median(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length % 2 == 1)
            return nums[nums.length / 2];
        else
            return (double) (nums[nums.length/2] + nums[nums.length/2+1])/2;
    }
}


