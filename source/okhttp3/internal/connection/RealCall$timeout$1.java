package okhttp3.internal.connection;

import okio.AsyncTimeout;

public final class RealCall$timeout$1 extends AsyncTimeout {
    public final /* synthetic */ RealCall this$0;

    public RealCall$timeout$1(RealCall realCall) {
        this.this$0 = realCall;
    }

    public void timedOut() {
        this.this$0.cancel();
    }
}
