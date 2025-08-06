package okhttp3.internal.http2;

import kotlin.Unit;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$pushResetLater$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ ErrorCode $errorCode$inlined;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushResetLater$$inlined$execute$default$1(String str, boolean z11, Http2Connection http2Connection, int i11, ErrorCode errorCode) {
        super(str, z11);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i11;
        this.$errorCode$inlined = errorCode;
    }

    public long runOnce() {
        this.this$0.pushObserver.onReset(this.$streamId$inlined, this.$errorCode$inlined);
        synchronized (this.this$0) {
            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            Unit unit = Unit.f56620a;
        }
        return -1;
    }
}
