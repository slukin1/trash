package com.tencent.liteav.base.datareport;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
public class Event4XReporter {
    private static final int INVALID_INSTANCE = 0;
    public static final int REPORT_EVENT = 1;
    public static final int REPORT_STATUS = 2;
    private static final String TAG = "Event4XReporter";
    private long mNativeEvent4XReporterAndroid = 0;

    public Event4XReporter(int i11, int i12, String str, boolean z11, int i13) {
        this.mNativeEvent4XReporterAndroid = nativeCreate(i11, i12, str, z11, i13);
    }

    private static native long nativeCreate(int i11, int i12, String str, boolean z11, int i13);

    private static native void nativeDestroy(long j11);

    private static native int nativeGetColdDownTime(long j11);

    private static native void nativeSendReport(long j11);

    private static native void nativeSetCommonIntValue(long j11, String str, long j12);

    private static native void nativeSetCommonStringValue(long j11, String str, String str2);

    private static native void nativeSetEventIntValue(long j11, String str, long j12);

    private static native void nativeSetEventStringValue(long j11, String str, String str2);

    public synchronized void destroy() {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeEvent4XReporterAndroid = 0;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public int getColdDownTime() {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 == 0) {
            return 10000;
        }
        return nativeGetColdDownTime(j11);
    }

    public synchronized void reportDau(int i11, int i12, String str) {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 != 0) {
            nativeSetEventStringValue(j11, "event_id", String.valueOf(i11));
            nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_code", String.valueOf(i12));
            nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_info", str);
            nativeSendReport(this.mNativeEvent4XReporterAndroid);
        }
    }

    public synchronized void sendReport() {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 != 0) {
            nativeSendReport(j11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setCommonIntValue(java.lang.String r5, long r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mNativeEvent4XReporterAndroid     // Catch:{ all -> 0x0013 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0011
            if (r5 != 0) goto L_0x000c
            goto L_0x0011
        L_0x000c:
            nativeSetCommonIntValue(r0, r5, r6)     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)
            return
        L_0x0011:
            monitor-exit(r4)
            return
        L_0x0013:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.datareport.Event4XReporter.setCommonIntValue(java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setCommonStringValue(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mNativeEvent4XReporterAndroid     // Catch:{ all -> 0x0015 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0013
            if (r5 == 0) goto L_0x0013
            if (r6 != 0) goto L_0x000e
            goto L_0x0013
        L_0x000e:
            nativeSetCommonStringValue(r0, r5, r6)     // Catch:{ all -> 0x0015 }
            monitor-exit(r4)
            return
        L_0x0013:
            monitor-exit(r4)
            return
        L_0x0015:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.datareport.Event4XReporter.setCommonStringValue(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setEventIntValue(java.lang.String r5, long r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mNativeEvent4XReporterAndroid     // Catch:{ all -> 0x0013 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0011
            if (r5 != 0) goto L_0x000c
            goto L_0x0011
        L_0x000c:
            nativeSetEventIntValue(r0, r5, r6)     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)
            return
        L_0x0011:
            monitor-exit(r4)
            return
        L_0x0013:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.datareport.Event4XReporter.setEventIntValue(java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setEventStringValue(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.mNativeEvent4XReporterAndroid     // Catch:{ all -> 0x0015 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0013
            if (r5 == 0) goto L_0x0013
            if (r6 != 0) goto L_0x000e
            goto L_0x0013
        L_0x000e:
            nativeSetEventStringValue(r0, r5, r6)     // Catch:{ all -> 0x0015 }
            monitor-exit(r4)
            return
        L_0x0013:
            monitor-exit(r4)
            return
        L_0x0015:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.datareport.Event4XReporter.setEventStringValue(java.lang.String, java.lang.String):void");
    }
}
