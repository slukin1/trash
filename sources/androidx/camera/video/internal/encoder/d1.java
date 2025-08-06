package androidx.camera.video.internal.encoder;

import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

public interface d1 {
    void a(boolean z11);

    boolean b();

    ListenableFuture<Void> c();

    boolean cancel();

    ByteBuffer d();

    void e(long j11);
}
