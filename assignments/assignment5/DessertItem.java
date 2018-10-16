package INFO5100;

public abstract class DessertItem {
    protected String name;

    public DessertItem() {}

    public DessertItem(String name) {
        if (name.length() < DessertShoppe.maxNameSize)
            this.name = name;
        else
            this.name = name.substring(0, DessertShoppe.maxNameSize);
    }

    public final String getName() {
        return name;
    }

    public abstract int getCost();
}

class DessertShoppe {
    public static final float taxRate = 0.065f;

    // when creating an object with longer name, the name will be the substring of the first 20 chars
    public static final int maxNameSize = 20;

    // max chars number of one line in the receipt
    public static final int displayWidth = 30;
    public static final String shopName = "Dylan Dessert Shoppe";

    public static String cents2dollarsAndCents(int cents) {
        double total = cents/ 100.0;
        String res = String.format("%.2f", total);

        // 0.77 -> .77
        return res.charAt(0) == '0'? res.substring(1): res;
    }

}
