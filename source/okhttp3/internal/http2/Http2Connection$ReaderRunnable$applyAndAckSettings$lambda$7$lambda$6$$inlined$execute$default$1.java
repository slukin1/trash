package okhttp3.internal.http2;

import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.concurrent.Task;

public final class Http2Connection$ReaderRunnable$applyAndAckSettings$lambda$7$lambda$6$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ Ref$ObjectRef $newPeerSettings$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$applyAndAckSettings$lambda$7$lambda$6$$inlined$execute$default$1(String str, boolean z11, Http2Connection http2Connection, Ref$ObjectRef ref$ObjectRef) {
        super(str, z11);
        this.this$0 = http2Connection;
        this.$newPeerSettings$inlined = ref$ObjectRef;
    }

    public long runOnce() {
        this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) this.$newPeerSettings$inlined.element);
        return -1;
    }
}
