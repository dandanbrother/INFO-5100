package INFO5100;

import java.util.LinkedList;
import java.util.List;

public class Checkout {
    List<DessertItem> list;

    public Checkout() {
        this.list = new LinkedList<>();
    }

    public int numberOfItems() {
        return list.size();
    }

    public void enterItem(DessertItem item) {
        list.add(item);
    }

    public void clear() {
        list.clear();
    }

    public int totalCost() {
        int res = 0;
        for (DessertItem item : list) {
            res += item.getCost();
        }
        return res;
    }

    public int totalTax() {
        return Math.round(totalCost()*DessertShoppe.taxRate);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (DessertShoppe.displayWidth - DessertShoppe.shopName.length())/2; i++)
            stringBuilder.append(" ");
        stringBuilder.append(DessertShoppe.shopName).append("\n");
        for (int i = 0; i < (DessertShoppe.displayWidth - DessertShoppe.shopName.length())/2; i++)
            stringBuilder.append(" ");
        for (int i = 0; i < DessertShoppe.shopName.length(); i++)
            stringBuilder.append("-");
        stringBuilder.append("\n");
        for (DessertItem item: list) {
            stringBuilder.append(item).append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("Tax");
        String tax = DessertShoppe.cents2dollarsAndCents(totalTax());
        String total = DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax());
        for (int i = 0; i < DessertShoppe.displayWidth - tax.length() - 3; i++)
            stringBuilder.append(" ");
        stringBuilder.append(tax).append("\n").append("Total Cost");
        for (int i = 0; i < DessertShoppe.displayWidth - total.length() - 10; i++)
            stringBuilder.append(" ");
        stringBuilder.append(total);
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);

        checkout.clear();

        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel", 50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));

        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
        System.out.println(checkout);
    }

    
	/**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int rowBegin = 0, colBegin = 0, rowEnd = n-1, colEnd = m-1;  //width of row and column
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            //left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            //up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;
            }

        }
        return res;
    }
}
