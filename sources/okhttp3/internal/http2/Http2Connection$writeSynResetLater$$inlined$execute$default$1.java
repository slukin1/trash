package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$writeSynResetLater$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ ErrorCode $errorCode$inlined;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$writeSynResetLater$$inlined$execute$default$1(String str, boolean z11, Http2Connection http2Connection, int i11, ErrorCode errorCode) {
        super(str, z11);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i11;
        this.$errorCode$inlined = errorCode;
    }

    public long runOnce() {
        try {
            this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
            return -1;
        } catch (IOException e11) {
            this.this$0.failConnection(e11);
            return -1;
        }
    }
}
