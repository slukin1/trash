package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import java.util.HashMap;
import java.util.List;

class StillCaptureProcessor {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "StillCaptureProcessor";
    public final CaptureProcessorImpl mCaptureProcessorImpl;
    public final a mCaptureResultImageMatcher;
    public HashMap<Integer, Pair<b, TotalCaptureResult>> mCaptureResults;
    public boolean mIsClosed;
    public final Object mLock;
    public OnCaptureResultCallback mOnCaptureResultCallback;
    public final ImageReaderProxy mProcessedYuvImageReader;
    public TotalCaptureResult mSourceCaptureResult;
    public YuvToJpegConverter mYuvToJpegConverter;

    public interface OnCaptureResultCallback {
        void onCaptureResult(long j11, List<Pair<CaptureResult.Key, Object>> list);

        void onCompleted();

        void onError(Exception exc);
    }

    public StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size) {
        this.mCaptureResultImageMatcher = new a();
        this.mLock = new Object();
        this.mCaptureResults = new HashMap<>();
        this.mOnCaptureResultCallback = null;
        this.mSourceCaptureResult = null;
        this.mIsClosed = false;
        this.mCaptureProcessorImpl = captureProcessorImpl;
        ImageReaderProxy createIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), 35, 2);
        this.mProcessedYuvImageReader = createIsolatedReader;
        this.mYuvToJpegConverter = new YuvToJpegConverter(100, surface);
        createIsolatedReader.setOnImageAvailableListener(new e(this), CameraXExecutors.ioExecutor());
        captureProcessorImpl.onOutputSurface(createIsolatedReader.getSurface(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        captureProcessorImpl.onResolutionUpdate(size);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (r7 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        r2.onError(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        r2.onCompleted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$new$0(androidx.camera.core.impl.ImageReaderProxy r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mIsClosed     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0010
            java.lang.String r7 = "StillCaptureProcessor"
            java.lang.String r1 = "Ignore JPEG processing in closed state"
            androidx.camera.core.Logger.d(r7, r1)     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0010:
            androidx.camera.core.ImageProxy r7 = r7.acquireNextImage()     // Catch:{ all -> 0x004b }
            android.hardware.camera2.TotalCaptureResult r1 = r6.mSourceCaptureResult     // Catch:{ all -> 0x004b }
            r2 = 0
            if (r1 == 0) goto L_0x002b
            androidx.camera.core.SettableImageProxy r3 = new androidx.camera.core.SettableImageProxy     // Catch:{ all -> 0x004b }
            androidx.camera.core.internal.CameraCaptureResultImageInfo r4 = new androidx.camera.core.internal.CameraCaptureResultImageInfo     // Catch:{ all -> 0x004b }
            androidx.camera.camera2.internal.f r5 = new androidx.camera.camera2.internal.f     // Catch:{ all -> 0x004b }
            r5.<init>(r1)     // Catch:{ all -> 0x004b }
            r4.<init>(r5)     // Catch:{ all -> 0x004b }
            r3.<init>(r7, r2, r4)     // Catch:{ all -> 0x004b }
            r6.mSourceCaptureResult = r2     // Catch:{ all -> 0x004b }
            r7 = r3
        L_0x002b:
            if (r7 == 0) goto L_0x003d
            androidx.camera.extensions.internal.sessionprocessor.YuvToJpegConverter r1 = r6.mYuvToJpegConverter     // Catch:{ ConversionFailedException -> 0x0034 }
            r1.c(r7)     // Catch:{ ConversionFailedException -> 0x0034 }
            r7 = r2
            goto L_0x0035
        L_0x0034:
            r7 = move-exception
        L_0x0035:
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r1 = r6.mOnCaptureResultCallback     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x003e
            r6.mOnCaptureResultCallback = r2     // Catch:{ all -> 0x004b }
            r2 = r1
            goto L_0x003e
        L_0x003d:
            r7 = r2
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x004a
            if (r7 == 0) goto L_0x0047
            r2.onError(r7)
            goto L_0x004a
        L_0x0047:
            r2.onCompleted()
        L_0x004a:
            return
        L_0x004b:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.lambda$new$0(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ca, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cc, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ce, code lost:
        r6.onError(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$startCapture$1(java.util.List r5, final androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback r6, androidx.camera.extensions.internal.sessionprocessor.b r7, android.hardware.camera2.TotalCaptureResult r8, int r9) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r4.mIsClosed     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x0013
            r7.a()     // Catch:{ all -> 0x00d2 }
            java.lang.String r5 = "StillCaptureProcessor"
            java.lang.String r6 = "Ignore image in closed state"
            androidx.camera.core.Logger.d(r5, r6)     // Catch:{ all -> 0x00d2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
            return
        L_0x0013:
            java.lang.String r1 = "StillCaptureProcessor"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r2.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "onImageReferenceIncoming  captureStageId="
            r2.append(r3)     // Catch:{ all -> 0x00d2 }
            r2.append(r9)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d2 }
            androidx.camera.core.Logger.d(r1, r2)     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult>> r1 = r4.mCaptureResults     // Catch:{ all -> 0x00d2 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00d2 }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x00d2 }
            r2.<init>(r7, r8)     // Catch:{ all -> 0x00d2 }
            r1.put(r9, r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r7 = "StillCaptureProcessor"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r8.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = "mCaptureResult has capture stage Id: "
            r8.append(r9)     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult>> r9 = r4.mCaptureResults     // Catch:{ all -> 0x00d2 }
            java.util.Set r9 = r9.keySet()     // Catch:{ all -> 0x00d2 }
            r8.append(r9)     // Catch:{ all -> 0x00d2 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00d2 }
            androidx.camera.core.Logger.d(r7, r8)     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult>> r7 = r4.mCaptureResults     // Catch:{ all -> 0x00d2 }
            java.util.Set r7 = r7.keySet()     // Catch:{ all -> 0x00d2 }
            boolean r5 = r7.containsAll(r5)     // Catch:{ all -> 0x00d2 }
            r7 = 0
            if (r5 == 0) goto L_0x00c9
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x00d2 }
            r5.<init>()     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult>> r8 = r4.mCaptureResults     // Catch:{ all -> 0x00d2 }
            java.util.Set r8 = r8.keySet()     // Catch:{ all -> 0x00d2 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00d2 }
        L_0x006f:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x00d2 }
            if (r9 == 0) goto L_0x0098
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x00d2 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x00d2 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult>> r1 = r4.mCaptureResults     // Catch:{ all -> 0x00d2 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x00d2 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ all -> 0x00d2 }
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x00d2 }
            java.lang.Object r3 = r1.first     // Catch:{ all -> 0x00d2 }
            androidx.camera.extensions.internal.sessionprocessor.b r3 = (androidx.camera.extensions.internal.sessionprocessor.b) r3     // Catch:{ all -> 0x00d2 }
            android.media.Image r3 = r3.get()     // Catch:{ all -> 0x00d2 }
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x00d2 }
            android.hardware.camera2.TotalCaptureResult r1 = (android.hardware.camera2.TotalCaptureResult) r1     // Catch:{ all -> 0x00d2 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x00d2 }
            r5.put(r9, r2)     // Catch:{ all -> 0x00d2 }
            goto L_0x006f
        L_0x0098:
            java.lang.String r8 = "StillCaptureProcessor"
            java.lang.String r9 = "CaptureProcessorImpl.process()"
            androidx.camera.core.Logger.d(r8, r9)     // Catch:{ all -> 0x00d2 }
            u.c r8 = u.c.f16569e     // Catch:{ Exception -> 0x00c2 }
            boolean r9 = androidx.camera.extensions.internal.ExtensionVersion.d(r8)     // Catch:{ Exception -> 0x00c2 }
            if (r9 == 0) goto L_0x00bc
            boolean r8 = u.b.c(r8)     // Catch:{ Exception -> 0x00c2 }
            if (r8 == 0) goto L_0x00bc
            androidx.camera.extensions.impl.CaptureProcessorImpl r8 = r4.mCaptureProcessorImpl     // Catch:{ Exception -> 0x00c2 }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$1 r9 = new androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$1     // Catch:{ Exception -> 0x00c2 }
            r9.<init>(r6)     // Catch:{ Exception -> 0x00c2 }
            java.util.concurrent.Executor r1 = androidx.camera.core.impl.utils.executor.CameraXExecutors.ioExecutor()     // Catch:{ Exception -> 0x00c2 }
            r8.process(r5, r9, r1)     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c6
        L_0x00bc:
            androidx.camera.extensions.impl.CaptureProcessorImpl r8 = r4.mCaptureProcessorImpl     // Catch:{ Exception -> 0x00c2 }
            r8.process(r5)     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r5 = move-exception
            r4.mOnCaptureResultCallback = r7     // Catch:{ all -> 0x00d2 }
            r7 = r5
        L_0x00c6:
            r4.clearCaptureResults()     // Catch:{ all -> 0x00d2 }
        L_0x00c9:
            monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
            if (r7 == 0) goto L_0x00d1
            if (r6 == 0) goto L_0x00d1
            r6.onError(r7)
        L_0x00d1:
            return
        L_0x00d2:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.lambda$startCapture$1(java.util.List, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback, androidx.camera.extensions.internal.sessionprocessor.b, android.hardware.camera2.TotalCaptureResult, int):void");
    }

    public void clearCaptureResults() {
        synchronized (this.mLock) {
            for (Pair<b, TotalCaptureResult> pair : this.mCaptureResults.values()) {
                ((b) pair.first).a();
            }
            this.mCaptureResults.clear();
        }
    }

    public void close() {
        Logger.d(TAG, "Close the processor");
        synchronized (this.mLock) {
            this.mIsClosed = true;
            clearCaptureResults();
            this.mProcessedYuvImageReader.clearOnImageAvailableListener();
            this.mCaptureResultImageMatcher.d();
            this.mCaptureResultImageMatcher.c();
            this.mProcessedYuvImageReader.close();
        }
    }

    public void notifyCaptureResult(TotalCaptureResult totalCaptureResult, int i11) {
        this.mCaptureResultImageMatcher.b(totalCaptureResult, i11);
        synchronized (this.mLock) {
            if (this.mSourceCaptureResult == null) {
                this.mSourceCaptureResult = totalCaptureResult;
            }
        }
    }

    public void notifyImage(b bVar) {
        this.mCaptureResultImageMatcher.f(bVar);
    }

    public void setJpegQuality(int i11) {
        this.mYuvToJpegConverter.a(i11);
    }

    public void setRotationDegrees(int i11) {
        this.mYuvToJpegConverter.b(i11);
    }

    public void startCapture(List<Integer> list, OnCaptureResultCallback onCaptureResultCallback) {
        Logger.d(TAG, "Start the processor");
        synchronized (this.mLock) {
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.c();
        this.mCaptureResultImageMatcher.j(new f(this, list, onCaptureResultCallback));
    }

    public StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, YuvToJpegConverter yuvToJpegConverter) {
        this(captureProcessorImpl, surface, size);
        this.mYuvToJpegConverter = yuvToJpegConverter;
    }
}
