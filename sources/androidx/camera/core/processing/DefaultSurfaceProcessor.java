package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;
    public final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;
    public final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    public final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier = o.f5680a;

        private Factory() {
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange dynamicRange) {
            return sSupplier.apply(dynamicRange);
        }

        public static void setSupplier(Function<DynamicRange, SurfaceProcessorInternal> function) {
            sSupplier = function;
        }
    }

    @AutoValue
    public static abstract class PendingSnapshot {
        public static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(int i11, int i12, CallbackToFutureAdapter.a<Void> aVar) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(i11, i12, aVar);
        }

        public abstract CallbackToFutureAdapter.a<Void> getCompleter();

        public abstract int getJpegQuality();

        public abstract int getRotationDegrees();
    }

    public DefaultSurfaceProcessor(DynamicRange dynamicRange) {
        this(dynamicRange, ShaderProvider.DEFAULT);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            for (SurfaceOutput close : this.mOutputSurfaces.keySet()) {
                close.close();
            }
            for (PendingSnapshot completer : this.mPendingSnapshots) {
                completer.getCompleter().f(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.mOutputSurfaces.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    private void executeSafely(Runnable runnable) {
        executeSafely(runnable, e.f5651b);
    }

    private void failAllPendingSnapshots(Throwable th2) {
        for (PendingSnapshot completer : this.mPendingSnapshots) {
            completer.getCompleter().f(th2);
        }
        this.mPendingSnapshots.clear();
    }

    private Bitmap getBitmap(Size size, float[] fArr, int i11) {
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        MatrixExt.preVerticalFlip(fArr2, 0.5f);
        MatrixExt.preRotate(fArr2, (float) i11, 0.5f, 0.5f);
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(size, i11), fArr2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.RuntimeException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.RuntimeException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initGlRenderer(androidx.camera.core.DynamicRange r2, androidx.camera.core.processing.ShaderProvider r3) {
        /*
            r1 = this;
            androidx.camera.core.processing.f r0 = new androidx.camera.core.processing.f
            r0.<init>(r1, r2, r3)
            com.google.common.util.concurrent.ListenableFuture r2 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r0)
            r2.get()     // Catch:{ ExecutionException -> 0x000f, InterruptedException -> 0x000d }
            return
        L_0x000d:
            r2 = move-exception
            goto L_0x0010
        L_0x000f:
            r2 = move-exception
        L_0x0010:
            boolean r3 = r2 instanceof java.util.concurrent.ExecutionException
            if (r3 == 0) goto L_0x0018
            java.lang.Throwable r2 = r2.getCause()
        L_0x0018:
            boolean r3 = r2 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x001f
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L_0x001f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "Failed to create DefaultSurfaceProcessor"
            r3.<init>(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.DefaultSurfaceProcessor.initGlRenderer(androidx.camera.core.DynamicRange, androidx.camera.core.processing.ShaderProvider):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeSafely$10() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSafely$11(Runnable runnable, Runnable runnable2) {
        if (this.mIsReleased) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initGlRenderer$8(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.a aVar) {
        try {
            this.mGlRenderer.init(dynamicRange, shaderProvider);
            aVar.c(null);
        } catch (RuntimeException e11) {
            aVar.f(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$initGlRenderer$9(DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.a aVar) throws Exception {
        executeSafely(new l(this, dynamicRange, shaderProvider, aVar));
        return "Init GlRenderer";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$0(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.Result result) {
        surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
        surfaceTexture.release();
        surface.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputSurface$1(SurfaceRequest surfaceRequest) {
        this.mInputSurfaceCount++;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mGlRenderer.getTextureName());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, this.mGlExecutor, new g(this, surfaceTexture, surface));
        surfaceTexture.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$2(SurfaceOutput surfaceOutput, SurfaceOutput.Event event) {
        surfaceOutput.close();
        Surface remove = this.mOutputSurfaces.remove(surfaceOutput);
        if (remove != null) {
            this.mGlRenderer.unregisterOutputSurface(remove);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onOutputSurface$3(SurfaceOutput surfaceOutput) {
        Surface surface = surfaceOutput.getSurface(this.mGlExecutor, new h(this, surfaceOutput));
        this.mGlRenderer.registerOutputSurface(surface);
        this.mOutputSurfaces.put(surfaceOutput, surface);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$snapshot$5(PendingSnapshot pendingSnapshot) {
        this.mPendingSnapshots.add(pendingSnapshot);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$snapshot$7(int i11, int i12, CallbackToFutureAdapter.a aVar) throws Exception {
        executeSafely(new b(this, PendingSnapshot.of(i11, i12, aVar)), new d(aVar));
        return "DefaultSurfaceProcessor#snapshot";
    }

    private void takeSnapshotAndDrawJpeg(Triple<Surface, Size, float[]> triple) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!this.mPendingSnapshots.isEmpty()) {
            if (triple == null) {
                failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
                return;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                Iterator<PendingSnapshot> it2 = this.mPendingSnapshots.iterator();
                int i11 = -1;
                int i12 = -1;
                Bitmap bitmap = null;
                byte[] bArr = null;
                while (it2.hasNext()) {
                    PendingSnapshot next = it2.next();
                    if (i11 != next.getRotationDegrees() || bitmap == null) {
                        i11 = next.getRotationDegrees();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        bitmap = getBitmap(triple.getSecond(), triple.getThird(), i11);
                        i12 = -1;
                    }
                    if (i12 != next.getJpegQuality()) {
                        byteArrayOutputStream.reset();
                        i12 = next.getJpegQuality();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    Objects.requireNonNull(bArr);
                    ImageProcessingUtil.writeJpegBytesToSurface(triple.getFirst(), bArr);
                    next.getCompleter().c(null);
                    it2.remove();
                }
                byteArrayOutputStream.close();
                return;
            } catch (IOException e11) {
                failAllPendingSnapshots(e11);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            return;
        }
        throw th;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.mIsReleaseRequested.get()) {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.mTextureMatrix);
            Triple triple = null;
            for (Map.Entry next : this.mOutputSurfaces.entrySet()) {
                Surface surface = (Surface) next.getValue();
                SurfaceOutput surfaceOutput = (SurfaceOutput) next.getKey();
                surfaceOutput.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
                if (surfaceOutput.getFormat() == 34) {
                    try {
                        this.mGlRenderer.render(surfaceTexture.getTimestamp(), this.mSurfaceOutputMatrix, surface);
                    } catch (RuntimeException e11) {
                        Logger.e(TAG, "Failed to render with OpenGL.", e11);
                    }
                } else {
                    boolean z11 = true;
                    h.j(surfaceOutput.getFormat() == 256, "Unsupported format: " + surfaceOutput.getFormat());
                    if (triple != null) {
                        z11 = false;
                    }
                    h.j(z11, "Only one JPEG output is supported.");
                    triple = new Triple(surface, surfaceOutput.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
                }
            }
            try {
                takeSnapshotAndDrawJpeg(triple);
            } catch (RuntimeException e12) {
                failAllPendingSnapshots(e12);
            }
        }
    }

    public void onInputSurface(SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
            return;
        }
        n nVar = new n(this, surfaceRequest);
        Objects.requireNonNull(surfaceRequest);
        executeSafely(nVar, new j(surfaceRequest));
    }

    public void onOutputSurface(SurfaceOutput surfaceOutput) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutput.close();
            return;
        }
        m mVar = new m(this, surfaceOutput);
        Objects.requireNonNull(surfaceOutput);
        executeSafely(mVar, new i(surfaceOutput));
    }

    public void release() {
        if (!this.mIsReleaseRequested.getAndSet(true)) {
            executeSafely(new k(this));
        }
    }

    public ListenableFuture<Void> snapshot(int i11, int i12) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new a(this, i11, i12)));
    }

    public DefaultSurfaceProcessor(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            initGlRenderer(dynamicRange, shaderProvider);
        } catch (RuntimeException e11) {
            release();
            throw e11;
        }
    }

    private void executeSafely(Runnable runnable, Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new c(this, runnable2, runnable));
        } catch (RejectedExecutionException e11) {
            Logger.w(TAG, "Unable to executor runnable", e11);
            runnable2.run();
        }
    }
}
