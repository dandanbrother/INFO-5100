package INFO5100;

public class Sundae extends IceCream {
    String toppingName;
    int toppingPrice;

    public Sundae(String name, int price, String toppingName, int toppingPrice) {
        super(name, price);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public int getCost() {
        return price + toppingPrice;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(toppingName).append("Sudae With\n").append(getName());
        String price = DessertShoppe.cents2dollarsAndCents(getCost());
        for (int i = 0; i < DessertShoppe.displayWidth-getName().length()-price.length(); i++)
            res.append(" ");
        return res.toString() + price;
    }
}
