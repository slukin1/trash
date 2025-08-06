package androidx.camera.core;

import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Consumer;
import androidx.core.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    public static final int PREVIEW = 1;
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = Arrays.asList(new Integer[]{1, 2, 3, 7});
    public static final int VIDEO_CAPTURE = 2;
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Formats {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Targets {
    }

    public CameraEffect(int i11, Executor executor, ImageProcessor imageProcessor, Consumer<Throwable> consumer) {
        h.b(i11 == 4, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = i11;
        this.mExecutor = executor;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = imageProcessor;
        this.mErrorListener = consumer;
    }

    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }

    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public CameraEffect(int i11, Executor executor, SurfaceProcessor surfaceProcessor, Consumer<Throwable> consumer) {
        TargetUtils.checkSupportedTargets(SURFACE_PROCESSOR_TARGETS, i11);
        this.mTargets = i11;
        this.mExecutor = executor;
        this.mSurfaceProcessor = surfaceProcessor;
        this.mImageProcessor = null;
        this.mErrorListener = consumer;
    }
}
