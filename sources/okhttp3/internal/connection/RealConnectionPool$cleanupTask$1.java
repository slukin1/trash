package okhttp3.internal.connection;

import kotlin.jvm.internal.r;
import okhttp3.internal.concurrent.Task;

public final class RealConnectionPool$cleanupTask$1 extends Task {
    public final /* synthetic */ RealConnectionPool this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConnectionPool$cleanupTask$1(RealConnectionPool realConnectionPool, String str) {
        super(str, false, 2, (r) null);
        this.this$0 = realConnectionPool;
    }

    public long runOnce() {
        return this.this$0.cleanup(System.nanoTime());
    }
}
