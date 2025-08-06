package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ long $unacknowledgedBytesRead$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1(String str, boolean z11, Http2Connection http2Connection, int i11, long j11) {
        super(str, z11);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i11;
        this.$unacknowledgedBytesRead$inlined = j11;
    }

    public long runOnce() {
        try {
            this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
            return -1;
        } catch (IOException e11) {
            this.this$0.failConnection(e11);
            return -1;
        }
    }
}
