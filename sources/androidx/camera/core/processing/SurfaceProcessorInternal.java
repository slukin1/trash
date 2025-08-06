package androidx.camera.core.processing;

import androidx.camera.core.SurfaceProcessor;
import com.google.common.util.concurrent.ListenableFuture;

public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    ListenableFuture<Void> snapshot(int i11, int i12);
}
