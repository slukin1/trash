package okhttp3.internal.ws;

import kotlin.jvm.internal.r;
import okhttp3.internal.concurrent.Task;

public final class RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1 extends Task {
    public final /* synthetic */ long $pingIntervalNanos$inlined;
    public final /* synthetic */ RealWebSocket this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1(String str, RealWebSocket realWebSocket, long j11) {
        super(str, false, 2, (r) null);
        this.this$0 = realWebSocket;
        this.$pingIntervalNanos$inlined = j11;
    }

    public long runOnce() {
        this.this$0.writePingFrame$okhttp();
        return this.$pingIntervalNanos$inlined;
    }
}
