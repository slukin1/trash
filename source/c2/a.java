package c2;

import java.util.concurrent.CountDownLatch;

public class a extends CountDownLatch {
    public a(int i11) {
        super(i11);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
