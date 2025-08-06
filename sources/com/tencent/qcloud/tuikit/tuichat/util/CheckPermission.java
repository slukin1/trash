package com.tencent.qcloud.tuikit.tuichat.util;

import android.media.AudioRecord;
import android.util.Log;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;

public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;
    private static final String TAG = "CheckPermission";

    public static int getRecordState() {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, ServiceInitializer.getAppContext().getString(R.string.record_occupied));
                return -1;
            } else if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                Log.i(TAG, ServiceInitializer.getAppContext().getString(R.string.record_null));
                return -2;
            } else {
                audioRecord.stop();
                audioRecord.release();
                return 1;
            }
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000f, B:10:0x0017] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean isCameraUseable(int r2) {
        /*
            java.lang.Class<com.tencent.qcloud.tuikit.tuichat.util.CheckPermission> r0 = com.tencent.qcloud.tuikit.tuichat.util.CheckPermission.class
            monitor-enter(r0)
            r1 = 0
            android.hardware.Camera r1 = android.hardware.Camera.open(r2)     // Catch:{ Exception -> 0x0016 }
            android.hardware.Camera$Parameters r2 = r1.getParameters()     // Catch:{ Exception -> 0x0016 }
            r1.setParameters(r2)     // Catch:{ Exception -> 0x0016 }
            r1.release()     // Catch:{ all -> 0x0028 }
            r2 = 1
            goto L_0x0020
        L_0x0014:
            r2 = move-exception
            goto L_0x0022
        L_0x0016:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x001f
            r1.release()     // Catch:{ all -> 0x0028 }
        L_0x001f:
            r2 = 0
        L_0x0020:
            monitor-exit(r0)
            return r2
        L_0x0022:
            if (r1 == 0) goto L_0x002a
            r1.release()     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r2 = move-exception
            goto L_0x002b
        L_0x002a:
            throw r2     // Catch:{ all -> 0x0028 }
        L_0x002b:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.util.CheckPermission.isCameraUseable(int):boolean");
    }
}
