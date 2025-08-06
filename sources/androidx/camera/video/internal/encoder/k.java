package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.camera.video.internal.BufferProvider;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public interface k {

    public interface a extends b, BufferProvider<d1> {
    }

    public interface b {
    }

    public interface c extends b {

        public interface a {
            void a(Surface surface);
        }

        void a(Executor executor, a aVar);
    }

    void a(m mVar, Executor executor);

    void b(long j11);

    b1 c();

    b d();

    ListenableFuture<Void> e();

    void f();

    int g();

    void pause();

    void release();

    void start();
}
