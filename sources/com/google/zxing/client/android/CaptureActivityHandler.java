package com.google.zxing.client.android;

import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.client.android.camera.CameraManager;
import java.util.Collection;
import java.util.Map;
import pro.huobi.R;

public final class CaptureActivityHandler extends Handler {
    private static final String TAG = CaptureActivityHandler.class.getSimpleName();
    private final CaptureActivity activity;
    private final CameraManager cameraManager;
    private final DecodeThread decodeThread;
    private State state = State.SUCCESS;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, CameraManager cameraManager2) {
        this.activity = captureActivity;
        DecodeThread decodeThread2 = new DecodeThread(captureActivity, collection, map, str, new ViewfinderResultPointCallback(captureActivity.getViewfinderView()));
        this.decodeThread = decodeThread2;
        decodeThread2.start();
        this.cameraManager = cameraManager2;
        cameraManager2.startPreview();
        restartPreviewAndDecode();
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            this.cameraManager.requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
            this.activity.drawViewfinder();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r6) {
        /*
            r5 = this;
            int r0 = r6.what
            r1 = 2131434032(0x7f0b1a30, float:1.8489866E38)
            if (r0 != r1) goto L_0x000c
            r5.restartPreviewAndDecode()
            goto L_0x00f7
        L_0x000c:
            r1 = 2131429043(0x7f0b06b3, float:1.8479748E38)
            r2 = 0
            if (r0 != r1) goto L_0x0045
            com.google.zxing.client.android.CaptureActivityHandler$State r0 = com.google.zxing.client.android.CaptureActivityHandler.State.SUCCESS
            r5.state = r0
            android.os.Bundle r0 = r6.getData()
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x003a
            java.lang.String r1 = "barcode_bitmap"
            byte[] r1 = r0.getByteArray(r1)
            if (r1 == 0) goto L_0x0034
            r3 = 0
            int r4 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r3, r4, r2)
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            r3 = 1
            android.graphics.Bitmap r1 = r1.copy(r2, r3)
            r2 = r1
        L_0x0034:
            java.lang.String r1 = "barcode_scaled_factor"
            float r1 = r0.getFloat(r1)
        L_0x003a:
            com.google.zxing.client.android.CaptureActivity r0 = r5.activity
            java.lang.Object r6 = r6.obj
            com.google.zxing.Result r6 = (com.google.zxing.Result) r6
            r0.handleDecode(r6, r2, r1)
            goto L_0x00f7
        L_0x0045:
            r1 = 2131429042(0x7f0b06b2, float:1.8479746E38)
            if (r0 != r1) goto L_0x005e
            com.google.zxing.client.android.CaptureActivityHandler$State r6 = com.google.zxing.client.android.CaptureActivityHandler.State.PREVIEW
            r5.state = r6
            com.google.zxing.client.android.camera.CameraManager r6 = r5.cameraManager
            com.google.zxing.client.android.DecodeThread r0 = r5.decodeThread
            android.os.Handler r0 = r0.getHandler()
            r1 = 2131429041(0x7f0b06b1, float:1.8479744E38)
            r6.requestPreviewFrame(r0, r1)
            goto L_0x00f7
        L_0x005e:
            r1 = 2131434034(0x7f0b1a32, float:1.848987E38)
            if (r0 != r1) goto L_0x0074
            com.google.zxing.client.android.CaptureActivity r0 = r5.activity
            r1 = -1
            java.lang.Object r6 = r6.obj
            android.content.Intent r6 = (android.content.Intent) r6
            r0.setResult(r1, r6)
            com.google.zxing.client.android.CaptureActivity r6 = r5.activity
            r6.finish()
            goto L_0x00f7
        L_0x0074:
            r1 = 2131431887(0x7f0b11cf, float:1.8485516E38)
            if (r0 != r1) goto L_0x00f7
            java.lang.Object r6 = r6.obj
            java.lang.String r6 = (java.lang.String) r6
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            r1 = 524288(0x80000, float:7.34684E-40)
            r0.addFlags(r1)
            android.net.Uri r1 = android.net.Uri.parse(r6)
            r0.setData(r1)
            com.google.zxing.client.android.CaptureActivity r1 = r5.activity
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r3 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r1 = r1.resolveActivity(r0, r3)
            if (r1 == 0) goto L_0x00ba
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            if (r1 == 0) goto L_0x00ba
            java.lang.String r2 = r1.packageName
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Using browser in package "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r1, r3)
        L_0x00ba:
            r2.hashCode()
            java.lang.String r1 = "com.android.browser"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00ce
            java.lang.String r1 = "com.android.chrome"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00ce
            goto L_0x00db
        L_0x00ce:
            r0.setPackage(r2)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)
            java.lang.String r1 = "com.android.browser.application_id"
            r0.putExtra(r1, r2)
        L_0x00db:
            com.google.zxing.client.android.CaptureActivity r1 = r5.activity     // Catch:{ ActivityNotFoundException -> 0x00e1 }
            r1.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00e1 }
            goto L_0x00f7
        L_0x00e1:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Can't find anything to handle VIEW of URI "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            android.util.Log.w(r0, r6)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.CaptureActivityHandler.handleMessage(android.os.Message):void");
    }

    public void quitSynchronously() {
        this.state = State.DONE;
        this.cameraManager.stopPreview();
        Message.obtain(this.decodeThread.getHandler(), R.id.quit).sendToTarget();
        try {
            this.decodeThread.join(500);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }
}
