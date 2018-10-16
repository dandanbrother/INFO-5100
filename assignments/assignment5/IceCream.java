package INFO5100;

public class IceCream extends DessertItem {
    public int price;

    public IceCream(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getCost() {
        return price;
    }

    public String toString() {
        StringBuilder res = new StringBuilder(getName());
        String price = DessertShoppe.cents2dollarsAndCents(getCost());
        for (int i = 0; i < DessertShoppe.displayWidth-getName().length()-price.length(); i++)
            res.append(" ");
        return res.toString() + price;
    }
}
