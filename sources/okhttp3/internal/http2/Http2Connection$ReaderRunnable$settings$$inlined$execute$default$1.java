package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

public final class Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ boolean $clearPrevious$inlined;
    public final /* synthetic */ Settings $settings$inlined;
    public final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(String str, boolean z11, Http2Connection.ReaderRunnable readerRunnable, boolean z12, Settings settings) {
        super(str, z11);
        this.this$0 = readerRunnable;
        this.$clearPrevious$inlined = z12;
        this.$settings$inlined = settings;
    }

    public long runOnce() {
        this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
        return -1;
    }
}
