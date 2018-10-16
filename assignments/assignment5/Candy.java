package INFO5100;

public class Candy extends DessertItem {
    double weight;
    int price;

    public Candy(String name, double weight, int price) {
        super(name);
        this.weight = weight;
        this.price = price;
    }

    public int getCost() {
        return Math.round((float)weight*price);
    }

    public String toString() {
        StringBuilder res = new StringBuilder(weight + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(price) + " /lb."
                + "\n" + getName());
        String price = DessertShoppe.cents2dollarsAndCents(getCost());
        for (int i = 0; i < DessertShoppe.displayWidth-getName().length()-price.length(); i++)
            res.append(" ");
        return res.toString() + price;
    }
}
