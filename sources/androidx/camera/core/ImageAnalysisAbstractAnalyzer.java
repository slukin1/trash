package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import android.os.Build;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock = new Object();
    public boolean mIsAttached = true;
    private volatile boolean mOnePixelShiftEnabled;
    private Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();
    private Rect mOriginalViewPortCropRect = new Rect();
    private volatile int mOutputImageFormat = 1;
    private volatile boolean mOutputImageRotationEnabled;
    private volatile int mPrevBufferRotationDegrees;
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;
    private ImageWriter mProcessedImageWriter;
    public ByteBuffer mRGBConvertedBuffer;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    public ByteBuffer mURotatedBuffer;
    private Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    private Rect mUpdatedViewPortCropRect = new Rect();
    private Executor mUserExecutor;
    public ByteBuffer mVRotatedBuffer;
    public ByteBuffer mYRotatedBuffer;

    private void createHelperBuffer(ImageProxy imageProxy) {
        if (this.mOutputImageFormat == 1) {
            if (this.mYRotatedBuffer == null) {
                this.mYRotatedBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight());
            }
            this.mYRotatedBuffer.position(0);
            if (this.mURotatedBuffer == null) {
                this.mURotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
            }
            this.mURotatedBuffer.position(0);
            if (this.mVRotatedBuffer == null) {
                this.mVRotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
            }
            this.mVRotatedBuffer.position(0);
        } else if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
            this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight() * 4);
        }
    }

    private static SafeCloseImageReaderProxy createImageReaderProxy(int i11, int i12, int i13, int i14, int i15) {
        boolean z11 = i13 == 90 || i13 == 270;
        int i16 = z11 ? i12 : i11;
        if (!z11) {
            i11 = i12;
        }
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(i16, i11, i14, i15));
    }

    public static Matrix getAdditionalTransformMatrixAppliedByProcessor(int i11, int i12, int i13, int i14, int i15) {
        Matrix matrix = new Matrix();
        if (i15 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) i11, (float) i12), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            matrix.postRotate((float) i15);
            matrix.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, (float) i13, (float) i14)));
        }
        return matrix;
    }

    public static Rect getUpdatedCropRect(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$analyzeImage$0(ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.a aVar) {
        int i11;
        if (this.mIsAttached) {
            TagBundle tagBundle = imageProxy.getImageInfo().getTagBundle();
            long timestamp = imageProxy.getImageInfo().getTimestamp();
            if (this.mOutputImageRotationEnabled) {
                i11 = 0;
            } else {
                i11 = this.mRelativeRotation;
            }
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy2, ImmutableImageInfo.create(tagBundle, timestamp, i11, matrix));
            if (!rect.isEmpty()) {
                settableImageProxy.setCropRect(rect);
            }
            analyzer.analyze(settableImageProxy);
            aVar.c(null);
            return;
        }
        aVar.f(new OperationCanceledException("ImageAnalysis is detached"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$analyzeImage$1(Executor executor, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.a aVar) throws Exception {
        Executor executor2 = executor;
        executor.execute(new q(this, imageProxy, matrix, imageProxy2, rect, analyzer, aVar));
        return "analyzeImage";
    }

    private void recalculateTransformMatrixAndCropRect(int i11, int i12, int i13, int i14) {
        Matrix additionalTransformMatrixAppliedByProcessor = getAdditionalTransformMatrixAppliedByProcessor(i11, i12, i13, i14, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, additionalTransformMatrixAppliedByProcessor);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, additionalTransformMatrixAppliedByProcessor);
    }

    private void recreateImageReaderProxy(ImageProxy imageProxy, int i11) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
            this.mProcessedImageReaderProxy = createImageReaderProxy(imageProxy.getWidth(), imageProxy.getHeight(), i11, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
            if (Build.VERSION.SDK_INT >= 23 && this.mOutputImageFormat == 1) {
                ImageWriter imageWriter = this.mProcessedImageWriter;
                if (imageWriter != null) {
                    ImageWriterCompat.close(imageWriter);
                }
                this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
            }
        }
    }

    public abstract ImageProxy acquireImage(ImageReaderProxy imageReaderProxy);

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0076  */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> analyzeImage(androidx.camera.core.ImageProxy r17) {
        /*
            r16 = this;
            r9 = r16
            r0 = r17
            boolean r1 = r9.mOutputImageRotationEnabled
            r8 = 0
            if (r1 == 0) goto L_0x000d
            int r1 = r9.mRelativeRotation
            r10 = r1
            goto L_0x000e
        L_0x000d:
            r10 = r8
        L_0x000e:
            java.lang.Object r1 = r9.mAnalyzerLock
            monitor-enter(r1)
            java.util.concurrent.Executor r11 = r9.mUserExecutor     // Catch:{ all -> 0x00c8 }
            androidx.camera.core.ImageAnalysis$Analyzer r12 = r9.mSubscribedAnalyzer     // Catch:{ all -> 0x00c8 }
            boolean r2 = r9.mOutputImageRotationEnabled     // Catch:{ all -> 0x00c8 }
            r13 = 1
            if (r2 == 0) goto L_0x0020
            int r2 = r9.mPrevBufferRotationDegrees     // Catch:{ all -> 0x00c8 }
            if (r10 == r2) goto L_0x0020
            r14 = r13
            goto L_0x0021
        L_0x0020:
            r14 = r8
        L_0x0021:
            if (r14 == 0) goto L_0x0026
            r9.recreateImageReaderProxy(r0, r10)     // Catch:{ all -> 0x00c8 }
        L_0x0026:
            boolean r2 = r9.mOutputImageRotationEnabled     // Catch:{ all -> 0x00c8 }
            if (r2 == 0) goto L_0x002d
            r16.createHelperBuffer(r17)     // Catch:{ all -> 0x00c8 }
        L_0x002d:
            androidx.camera.core.SafeCloseImageReaderProxy r2 = r9.mProcessedImageReaderProxy     // Catch:{ all -> 0x00c8 }
            android.media.ImageWriter r3 = r9.mProcessedImageWriter     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r4 = r9.mRGBConvertedBuffer     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r5 = r9.mYRotatedBuffer     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r6 = r9.mURotatedBuffer     // Catch:{ all -> 0x00c8 }
            java.nio.ByteBuffer r7 = r9.mVRotatedBuffer     // Catch:{ all -> 0x00c8 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
            if (r12 == 0) goto L_0x00bc
            if (r11 == 0) goto L_0x00bc
            boolean r1 = r9.mIsAttached
            if (r1 == 0) goto L_0x00bc
            if (r2 == 0) goto L_0x006e
            int r15 = r9.mOutputImageFormat
            r1 = 2
            if (r15 != r1) goto L_0x0050
            boolean r1 = r9.mOnePixelShiftEnabled
            androidx.camera.core.ImageProxy r1 = androidx.camera.core.ImageProcessingUtil.convertYUVToRGB(r0, r2, r4, r10, r1)
            goto L_0x006f
        L_0x0050:
            int r1 = r9.mOutputImageFormat
            if (r1 != r13) goto L_0x006e
            boolean r1 = r9.mOnePixelShiftEnabled
            if (r1 == 0) goto L_0x005b
            androidx.camera.core.ImageProcessingUtil.applyPixelShiftForYUV(r17)
        L_0x005b:
            if (r3 == 0) goto L_0x006e
            if (r5 == 0) goto L_0x006e
            if (r6 == 0) goto L_0x006e
            if (r7 == 0) goto L_0x006e
            r1 = r17
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            androidx.camera.core.ImageProxy r1 = androidx.camera.core.ImageProcessingUtil.rotateYUV(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r1 != 0) goto L_0x0072
            r8 = r13
        L_0x0072:
            if (r8 == 0) goto L_0x0076
            r6 = r0
            goto L_0x0077
        L_0x0076:
            r6 = r1
        L_0x0077:
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            java.lang.Object r1 = r9.mAnalyzerLock
            monitor-enter(r1)
            if (r14 == 0) goto L_0x009b
            if (r8 != 0) goto L_0x009b
            int r2 = r17.getWidth()     // Catch:{ all -> 0x00b9 }
            int r3 = r17.getHeight()     // Catch:{ all -> 0x00b9 }
            int r4 = r6.getWidth()     // Catch:{ all -> 0x00b9 }
            int r8 = r6.getHeight()     // Catch:{ all -> 0x00b9 }
            r9.recalculateTransformMatrixAndCropRect(r2, r3, r4, r8)     // Catch:{ all -> 0x00b9 }
        L_0x009b:
            r9.mPrevBufferRotationDegrees = r10     // Catch:{ all -> 0x00b9 }
            android.graphics.Rect r2 = r9.mUpdatedViewPortCropRect     // Catch:{ all -> 0x00b9 }
            r7.set(r2)     // Catch:{ all -> 0x00b9 }
            android.graphics.Matrix r2 = r9.mUpdatedSensorToBufferTransformMatrix     // Catch:{ all -> 0x00b9 }
            r5.set(r2)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            androidx.camera.core.p r10 = new androidx.camera.core.p
            r1 = r10
            r2 = r16
            r3 = r11
            r4 = r17
            r8 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            com.google.common.util.concurrent.ListenableFuture r0 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r10)
            goto L_0x00c7
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            throw r0
        L_0x00bc:
            androidx.core.os.OperationCanceledException r0 = new androidx.core.os.OperationCanceledException
            java.lang.String r1 = "No analyzer or executor currently set."
            r0.<init>(r1)
            com.google.common.util.concurrent.ListenableFuture r0 = androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r0)
        L_0x00c7:
            return r0
        L_0x00c8:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageAnalysisAbstractAnalyzer.analyzeImage(androidx.camera.core.ImageProxy):com.google.common.util.concurrent.ListenableFuture");
    }

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireImage = acquireImage(imageReaderProxy);
            if (acquireImage != null) {
                onValidImageAvailable(acquireImage);
            }
        } catch (IllegalStateException e11) {
            Logger.e(TAG, "Failed to acquire image.", e11);
        }
    }

    public abstract void onValidImageAvailable(ImageProxy imageProxy);

    public void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        if (analyzer == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    public void setOnePixelShiftEnabled(boolean z11) {
        this.mOnePixelShiftEnabled = z11;
    }

    public void setOutputImageFormat(int i11) {
        this.mOutputImageFormat = i11;
    }

    public void setOutputImageRotationEnabled(boolean z11) {
        this.mOutputImageRotationEnabled = z11;
    }

    public void setProcessedImageReaderProxy(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.mAnalyzerLock) {
            this.mProcessedImageReaderProxy = safeCloseImageReaderProxy;
        }
    }

    public void setRelativeRotation(int i11) {
        this.mRelativeRotation = i11;
    }

    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalSensorToBufferTransformMatrix = matrix;
            this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);
        }
    }

    public void setViewPortCropRect(Rect rect) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalViewPortCropRect = rect;
            this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);
        }
    }
}
