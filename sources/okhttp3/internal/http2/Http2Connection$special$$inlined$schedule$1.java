package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.jvm.internal.r;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$special$$inlined$schedule$1 extends Task {
    public final /* synthetic */ long $pingIntervalNanos$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$special$$inlined$schedule$1(String str, Http2Connection http2Connection, long j11) {
        super(str, false, 2, (r) null);
        this.this$0 = http2Connection;
        this.$pingIntervalNanos$inlined = j11;
    }

    public long runOnce() {
        boolean z11;
        synchronized (this.this$0) {
            if (this.this$0.intervalPongsReceived < this.this$0.intervalPingsSent) {
                z11 = true;
            } else {
                this.this$0.intervalPingsSent = this.this$0.intervalPingsSent + 1;
                z11 = false;
            }
        }
        if (z11) {
            this.this$0.failConnection((IOException) null);
            return -1;
        }
        this.this$0.writePing(false, 1, 0);
        return this.$pingIntervalNanos$inlined;
    }
}
