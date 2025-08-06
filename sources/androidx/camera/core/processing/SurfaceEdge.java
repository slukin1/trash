package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SurfaceEdge {
    private SurfaceOutputImpl mConsumerToNotify;
    private final Rect mCropRect;
    private final int mFormat;
    private final boolean mHasCameraTransform;
    private boolean mHasConsumer = false;
    private boolean mIsClosed = false;
    private final boolean mMirroring;
    private final Set<Runnable> mOnInvalidatedListeners = new HashSet();
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private SettableSurface mSettableSurface;
    private final StreamSpec mStreamSpec;
    private int mTargetRotation;
    private final int mTargets;

    public static class SettableSurface extends DeferrableSurface {
        public CallbackToFutureAdapter.a<Surface> mCompleter;
        private DeferrableSurface mProvider;
        public final ListenableFuture<Surface> mSurfaceFuture = CallbackToFutureAdapter.a(new z(this));

        public SettableSurface(Size size, int i11) {
            super(size, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.a aVar) throws Exception {
            this.mCompleter = aVar;
            return "SettableFuture hashCode: " + hashCode();
        }

        public boolean canSetProvider() {
            Threads.checkMainThread();
            return this.mProvider == null && !isClosed();
        }

        public boolean hasProvider() {
            return this.mProvider != null;
        }

        public ListenableFuture<Surface> provideSurface() {
            return this.mSurfaceFuture;
        }

        public boolean setProvider(DeferrableSurface deferrableSurface, Runnable runnable) throws DeferrableSurface.SurfaceClosedException {
            Threads.checkMainThread();
            h.g(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.mProvider;
            boolean z11 = false;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            h.j(deferrableSurface2 == null, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            h.b(getPrescribedSize().equals(deferrableSurface.getPrescribedSize()), "The provider's size must match the parent");
            if (getPrescribedStreamFormat() == deferrableSurface.getPrescribedStreamFormat()) {
                z11 = true;
            }
            h.b(z11, "The provider's format must match the parent");
            h.j(!isClosed(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.mProvider = deferrableSurface;
            Futures.propagate(deferrableSurface.getSurface(), this.mCompleter);
            deferrableSurface.incrementUseCount();
            getTerminationFuture().addListener(new a0(deferrableSurface), CameraXExecutors.directExecutor());
            deferrableSurface.getCloseFuture().addListener(runnable, CameraXExecutors.mainThreadExecutor());
            return true;
        }
    }

    public SurfaceEdge(int i11, int i12, StreamSpec streamSpec, Matrix matrix, boolean z11, Rect rect, int i13, int i14, boolean z12) {
        this.mTargets = i11;
        this.mFormat = i12;
        this.mStreamSpec = streamSpec;
        this.mSensorToBufferTransform = matrix;
        this.mHasCameraTransform = z11;
        this.mCropRect = rect;
        this.mRotationDegrees = i13;
        this.mTargetRotation = i14;
        this.mMirroring = z12;
        this.mSettableSurface = new SettableSurface(streamSpec.getResolution(), i12);
    }

    private void checkAndSetHasConsumer() {
        h.j(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
    }

    private void checkNotClosed() {
        h.j(!this.mIsClosed, "Edge is already closed.");
    }

    /* access modifiers changed from: private */
    public void disconnectWithoutCheckingClosed() {
        Threads.checkMainThread();
        this.mSettableSurface.close();
        SurfaceOutputImpl surfaceOutputImpl = this.mConsumerToNotify;
        if (surfaceOutputImpl != null) {
            surfaceOutputImpl.requestClose();
            this.mConsumerToNotify = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$createSurfaceOutputFuture$2(SettableSurface settableSurface, int i11, Size size, Rect rect, int i12, boolean z11, CameraInternal cameraInternal, Surface surface) throws Exception {
        h.g(surface);
        try {
            settableSurface.incrementUseCount();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, getTargets(), i11, this.mStreamSpec.getResolution(), size, rect, i12, z11, cameraInternal, this.mSensorToBufferTransform);
            SettableSurface settableSurface2 = settableSurface;
            surfaceOutputImpl.getCloseFuture().addListener(new u(settableSurface), CameraXExecutors.directExecutor());
            this.mConsumerToNotify = surfaceOutputImpl;
            return Futures.immediateFuture(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e11) {
            return Futures.immediateFailedFuture(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createSurfaceRequest$0() {
        if (!this.mIsClosed) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createSurfaceRequest$1() {
        CameraXExecutors.mainThreadExecutor().execute(new x(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTransformation$3(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (this.mRotationDegrees != i11) {
            this.mRotationDegrees = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mTargetRotation != i12) {
            this.mTargetRotation = i12;
        } else {
            z12 = z11;
        }
        if (z12) {
            notifyTransformationInfoUpdate();
        }
    }

    private void notifyTransformationInfoUpdate() {
        Threads.checkMainThread();
        SurfaceRequest surfaceRequest = this.mProviderSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.updateTransformationInfo(SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, hasCameraTransform(), this.mSensorToBufferTransform, this.mMirroring));
        }
    }

    public void addOnInvalidatedListener(Runnable runnable) {
        Threads.checkMainThread();
        checkNotClosed();
        this.mOnInvalidatedListeners.add(runnable);
    }

    public final void close() {
        Threads.checkMainThread();
        disconnectWithoutCheckingClosed();
        this.mIsClosed = true;
    }

    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(Size size, int i11, Rect rect, int i12, boolean z11, CameraInternal cameraInternal) {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        SettableSurface settableSurface = this.mSettableSurface;
        return Futures.transformAsync(settableSurface.getSurface(), new s(this, settableSurface, i11, size, rect, i12, z11, cameraInternal), CameraXExecutors.mainThreadExecutor());
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal cameraInternal) {
        Threads.checkMainThread();
        checkNotClosed();
        SurfaceRequest surfaceRequest = new SurfaceRequest(this.mStreamSpec.getResolution(), cameraInternal, this.mStreamSpec.getDynamicRange(), this.mStreamSpec.getExpectedFrameRateRange(), new v(this));
        try {
            DeferrableSurface deferrableSurface = surfaceRequest.getDeferrableSurface();
            if (this.mSettableSurface.setProvider(deferrableSurface, new w(this))) {
                ListenableFuture<Void> terminationFuture = this.mSettableSurface.getTerminationFuture();
                Objects.requireNonNull(deferrableSurface);
                terminationFuture.addListener(new t(deferrableSurface), CameraXExecutors.directExecutor());
            }
            this.mProviderSurfaceRequest = surfaceRequest;
            notifyTransformationInfoUpdate();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e11) {
            throw new AssertionError("Surface is somehow already closed", e11);
        } catch (RuntimeException e12) {
            surfaceRequest.willNotProvideSurface();
            throw e12;
        }
    }

    public final void disconnect() {
        Threads.checkMainThread();
        checkNotClosed();
        disconnectWithoutCheckingClosed();
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public DeferrableSurface getDeferrableSurface() {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        return this.mSettableSurface;
    }

    public DeferrableSurface getDeferrableSurfaceForTesting() {
        return this.mSettableSurface;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public boolean getMirroring() {
        return this.mMirroring;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public StreamSpec getStreamSpec() {
        return this.mStreamSpec;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean hasCameraTransform() {
        return this.mHasCameraTransform;
    }

    public boolean hasProvider() {
        return this.mSettableSurface.hasProvider();
    }

    public void invalidate() {
        Threads.checkMainThread();
        checkNotClosed();
        if (!this.mSettableSurface.canSetProvider()) {
            disconnectWithoutCheckingClosed();
            this.mHasConsumer = false;
            this.mSettableSurface = new SettableSurface(this.mStreamSpec.getResolution(), this.mFormat);
            for (Runnable run : this.mOnInvalidatedListeners) {
                run.run();
            }
        }
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    public void setProvider(DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        checkNotClosed();
        this.mSettableSurface.setProvider(deferrableSurface, new w(this));
    }

    public void updateTransformation(int i11) {
        updateTransformation(i11, -1);
    }

    public void updateTransformation(int i11, int i12) {
        Threads.runOnMain(new y(this, i11, i12));
    }
}
