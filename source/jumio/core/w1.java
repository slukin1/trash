package jumio.core;

public class w1 extends Exception {
    public w1(Exception exc) {
        super(exc);
    }

    public w1() {
        super("keyupdate - re-execute call!");
    }
}
