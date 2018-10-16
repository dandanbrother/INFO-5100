package INFO5100;

public class Cookie extends DessertItem{
    public int number;
    public int price;   // cents price per dozen

    public Cookie(String name, int number, int price) {
        super(name);
        this.number = number;
        this.price = price;
    }

    public int getCost() {
        return Math.round(number * price / 12.0f);
    }

    public String toString() {
        StringBuilder res = new StringBuilder(number + " @ " + DessertShoppe.cents2dollarsAndCents(price) + " /dz."
                + "\n" + getName());
        String price = DessertShoppe.cents2dollarsAndCents(getCost());
        for (int i = 0; i < DessertShoppe.displayWidth-getName().length()-price.length(); i++)
            res.append(" ");
        return res.toString() + price;
    }
}
