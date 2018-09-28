package Assignment3;

public class SadObject extends MoodyObject {
    @Override
    protected String getMood() {
        return "I feel sad today.";
    }

    @Override
    protected void expressMood() {
        System.out.println("\'wah\' \'boo hoo\' \'weep\' \'sob\' \'weep\'.");
    }

    @Override
    public String toString() {
        return "Subject cries a lot.";
    }
}
