package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";
    private final float[] mAdditionalTransform = new float[16];
    private CameraInternal mCameraInternal;
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.a<Void> mCloseFutureCompleter;
    private Consumer<SurfaceOutput.Event> mEventListener;
    private Executor mExecutor;
    private final int mFormat;
    private boolean mHasPendingCloseRequest = false;
    private final Rect mInputCropRect;
    private final Size mInputSize;
    private final float[] mInvertedTextureTransform = new float[16];
    private boolean mIsClosed = false;
    private final Object mLock = new Object();
    private final boolean mMirroring;
    private final int mRotationDegrees;
    private Matrix mSensorToBufferTransform;
    private final Size mSize;
    private final Surface mSurface;
    private final int mTargets;

    public SurfaceOutputImpl(Surface surface, int i11, int i12, Size size, Size size2, Rect rect, int i13, boolean z11, CameraInternal cameraInternal, Matrix matrix) {
        this.mSurface = surface;
        this.mTargets = i11;
        this.mFormat = i12;
        this.mSize = size;
        this.mInputSize = size2;
        this.mInputCropRect = new Rect(rect);
        this.mMirroring = z11;
        this.mRotationDegrees = i13;
        this.mCameraInternal = cameraInternal;
        this.mSensorToBufferTransform = matrix;
        calculateAdditionalTransform();
        this.mCloseFuture = CallbackToFutureAdapter.a(new b0(this));
    }

    private void calculateAdditionalTransform() {
        android.opengl.Matrix.setIdentityM(this.mAdditionalTransform, 0);
        MatrixExt.preVerticalFlip(this.mAdditionalTransform, 0.5f);
        MatrixExt.preRotate(this.mAdditionalTransform, (float) this.mRotationDegrees, 0.5f, 0.5f);
        if (this.mMirroring) {
            android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, -1.0f, 1.0f, 1.0f);
        }
        Size rotateSize = TransformUtils.rotateSize(this.mInputSize, this.mRotationDegrees);
        Matrix rectToRect = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(this.mInputSize), TransformUtils.sizeToRectF(rotateSize), this.mRotationDegrees, this.mMirroring);
        RectF rectF = new RectF(this.mInputCropRect);
        rectToRect.mapRect(rectF);
        float width = rectF.left / ((float) rotateSize.getWidth());
        float height = ((((float) rotateSize.getHeight()) - rectF.height()) - rectF.top) / ((float) rotateSize.getHeight());
        float height2 = rectF.height() / ((float) rotateSize.getHeight());
        android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, rectF.width() / ((float) rotateSize.getWidth()), height2, 1.0f);
        calculateInvertedTextureTransform();
        float[] fArr = this.mAdditionalTransform;
        android.opengl.Matrix.multiplyMM(fArr, 0, this.mInvertedTextureTransform, 0, fArr, 0);
    }

    private void calculateInvertedTextureTransform() {
        android.opengl.Matrix.setIdentityM(this.mInvertedTextureTransform, 0);
        MatrixExt.preVerticalFlip(this.mInvertedTextureTransform, 0.5f);
        CameraInternal cameraInternal = this.mCameraInternal;
        if (cameraInternal != null) {
            h.j(cameraInternal.getHasTransform(), "Camera has no transform.");
            MatrixExt.preRotate(this.mInvertedTextureTransform, (float) this.mCameraInternal.getCameraInfo().getSensorRotationDegrees(), 0.5f, 0.5f);
            if (this.mCameraInternal.isFrontFacing()) {
                android.opengl.Matrix.translateM(this.mInvertedTextureTransform, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(this.mInvertedTextureTransform, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        float[] fArr = this.mInvertedTextureTransform;
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.a aVar) throws Exception {
        this.mCloseFutureCompleter = aVar;
        return "SurfaceOutputImpl close future complete";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestClose$1(AtomicReference atomicReference) {
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.of(0, this));
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
            }
        }
        this.mCloseFutureCompleter.c(null);
    }

    public CameraInternal getCamera() {
        return this.mCameraInternal;
    }

    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public Rect getInputCropRect() {
        return this.mInputCropRect;
    }

    public Size getInputSize() {
        return this.mInputSize;
    }

    public boolean getMirroring() {
        return this.mMirroring;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return new Matrix(this.mSensorToBufferTransform);
    }

    public Size getSize() {
        return this.mSize;
    }

    public Surface getSurface(Executor executor, Consumer<SurfaceOutput.Event> consumer) {
        boolean z11;
        synchronized (this.mLock) {
            this.mExecutor = executor;
            this.mEventListener = consumer;
            z11 = this.mHasPendingCloseRequest;
        }
        if (z11) {
            requestClose();
        }
        return this.mSurface;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean isClosed() {
        boolean z11;
        synchronized (this.mLock) {
            z11 = this.mIsClosed;
        }
        return z11;
    }

    public void requestClose() {
        Executor executor;
        AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            if (this.mExecutor != null) {
                Consumer<SurfaceOutput.Event> consumer = this.mEventListener;
                if (consumer != null) {
                    if (!this.mIsClosed) {
                        atomicReference.set(consumer);
                        executor = this.mExecutor;
                        this.mHasPendingCloseRequest = false;
                    }
                    executor = null;
                }
            }
            this.mHasPendingCloseRequest = true;
            executor = null;
        }
        if (executor != null) {
            try {
                executor.execute(new c0(this, atomicReference));
            } catch (RejectedExecutionException e11) {
                Logger.d(TAG, "Processor executor closed. Close request not posted.", e11);
            }
        }
    }

    public void updateTransformMatrix(float[] fArr, float[] fArr2) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, this.mAdditionalTransform, 0);
    }
}
