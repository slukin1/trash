package okhttp3.internal.ws;

import okhttp3.internal.concurrent.Task;

public final class RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1(String str, boolean z11, RealWebSocket realWebSocket) {
        super(str, z11);
        this.this$0 = realWebSocket;
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1;
    }
}
