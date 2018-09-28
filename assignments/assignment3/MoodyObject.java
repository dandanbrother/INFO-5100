package Assignment3;

public abstract class MoodyObject {
    protected abstract String getMood();

    protected abstract void expressMood();

    public void queryMood() {
        System.out.println(this.getMood());
    }
}
