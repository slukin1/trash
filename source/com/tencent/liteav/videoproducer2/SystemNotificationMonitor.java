package com.tencent.liteav.videoproducer2;

import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.videobase.SystemDisplayInfo;

@JNINamespace("liteav::video")
public class SystemNotificationMonitor extends OrientationEventListener implements w.a {
    private static final int SENSOR_ROTATION_DETECTION_THRESHOLD = 30;
    private k mDisplayRotation = null;
    private int mLastOrientation = -1;
    private volatile long mListenerPtr = 0;
    private k mSensorRotation = null;
    private volatile w mTimer = null;

    /* renamed from: com.tencent.liteav.videoproducer2.SystemNotificationMonitor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22699a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.base.util.k[] r0 = com.tencent.liteav.base.util.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22699a = r0
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22699a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22699a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22699a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer2.SystemNotificationMonitor.AnonymousClass1.<clinit>():void");
        }
    }

    public SystemNotificationMonitor() {
        super(ContextUtils.getApplicationContext());
    }

    private k getSensorRotationByDisplayRotation(k kVar) {
        if (kVar == null) {
            return k.NORMAL;
        }
        int i11 = AnonymousClass1.f22699a[kVar.ordinal()];
        if (i11 == 1) {
            return k.ROTATION_270;
        }
        if (i11 == 2) {
            return k.ROTATION_180;
        }
        if (i11 != 3) {
            return k.NORMAL;
        }
        return k.ROTATION_90;
    }

    private k getSensorRotationCorrection() {
        if (this.mListenerPtr == 0) {
            return null;
        }
        int nativeGetGravitySensorRotationCorrection = nativeGetGravitySensorRotationCorrection(this.mListenerPtr);
        if (k.b(nativeGetGravitySensorRotationCorrection)) {
            return k.a(nativeGetGravitySensorRotationCorrection);
        }
        return null;
    }

    private static native synchronized int nativeGetGravitySensorRotationCorrection(long j11);

    private static native void nativeSensorChanged(long j11, int i11, int i12);

    private synchronized void notifyOrientationChanged() {
        int i11;
        if (this.mListenerPtr != 0) {
            int i12 = 0;
            if (getSensorRotationCorrection() != null) {
                i11 = getSensorRotationCorrection().mValue;
            } else {
                k kVar = this.mSensorRotation;
                i11 = kVar != null ? kVar.mValue : 0;
            }
            k kVar2 = this.mDisplayRotation;
            if (kVar2 != null) {
                i12 = kVar2.mValue;
            }
            nativeSensorChanged(this.mListenerPtr, i11, i12);
        }
    }

    public synchronized void initialize(long j11) {
        this.mListenerPtr = j11;
        if (this.mTimer == null) {
            super.enable();
            this.mTimer = new w(Looper.getMainLooper(), this);
            this.mTimer.a(1000);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOrientationChanged(int r3) {
        /*
            r2 = this;
            r0 = -1
            if (r3 != r0) goto L_0x0004
            return
        L_0x0004:
            int r1 = r2.mLastOrientation
            if (r1 == r0) goto L_0x0013
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            r1 = 30
            if (r0 > r1) goto L_0x0013
            return
        L_0x0013:
            r2.mLastOrientation = r3
            r0 = 45
            if (r3 <= r0) goto L_0x002e
            r0 = 135(0x87, float:1.89E-43)
            if (r3 > r0) goto L_0x0020
            com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.ROTATION_90
            goto L_0x0030
        L_0x0020:
            r0 = 225(0xe1, float:3.15E-43)
            if (r3 > r0) goto L_0x0027
            com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.ROTATION_180
            goto L_0x0030
        L_0x0027:
            r0 = 315(0x13b, float:4.41E-43)
            if (r3 > r0) goto L_0x002e
            com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.ROTATION_270
            goto L_0x0030
        L_0x002e:
            com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.NORMAL
        L_0x0030:
            com.tencent.liteav.base.util.k r0 = r2.mSensorRotation
            if (r0 == r3) goto L_0x0043
            r2.mSensorRotation = r3
            int r3 = com.tencent.liteav.videobase.videobase.SystemDisplayInfo.getDisplayRotationDegree()
            com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.a((int) r3)
            r2.mDisplayRotation = r3
            r2.notifyOrientationChanged()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer2.SystemNotificationMonitor.onOrientationChanged(int):void");
    }

    public void onTimeout() {
        k a11 = k.a(SystemDisplayInfo.getDisplayRotationDegree());
        if (this.mDisplayRotation != a11) {
            this.mDisplayRotation = a11;
            if (this.mSensorRotation == null) {
                this.mSensorRotation = getSensorRotationByDisplayRotation(a11);
            }
            notifyOrientationChanged();
        }
    }

    public synchronized void uninitialize() {
        super.disable();
        this.mListenerPtr = 0;
        if (this.mTimer != null) {
            this.mTimer.a();
            this.mTimer = null;
        }
    }
}
