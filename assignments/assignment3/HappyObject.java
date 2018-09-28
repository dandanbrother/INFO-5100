package Assignment3;

public class HappyObject extends MoodyObject {
    @Override
    protected String getMood() {
        return "I feel happy today.";
    }
    @Override
    protected void expressMood() {
        System.out.println("hehehe...hahaha...HAHAHAHAHAHA.");
    }
    @Override
    public String toString() {
        return "Subject laughs a lot.";
    }
}
