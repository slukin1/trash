package com.google.zxing.client.android;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import pro.huobi.R;

final class DecodeHandler extends Handler {
    private static final String TAG = DecodeHandler.class.getSimpleName();
    private final CaptureActivity activity;
    private final MultiFormatReader multiFormatReader;
    private boolean running = true;

    public DecodeHandler(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        MultiFormatReader multiFormatReader2 = new MultiFormatReader();
        this.multiFormatReader = multiFormatReader2;
        multiFormatReader2.setHints(map);
        this.activity = captureActivity;
    }

    private static void bundleThumbnail(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(DecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
        bundle.putFloat(DecodeThread.BARCODE_SCALED_FACTOR, ((float) thumbnailWidth) / ((float) planarYUVLuminanceSource.getWidth()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decode(byte[] r9, int r10, int r11) {
        /*
            r8 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = r9.length
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = r3
        L_0x0009:
            if (r4 >= r11) goto L_0x0021
            r5 = r3
        L_0x000c:
            if (r5 >= r10) goto L_0x001e
            int r6 = r5 * r11
            int r6 = r6 + r11
            int r6 = r6 - r4
            int r6 = r6 + -1
            int r7 = r4 * r10
            int r7 = r7 + r5
            byte r7 = r9[r7]
            r2[r6] = r7
            int r5 = r5 + 1
            goto L_0x000c
        L_0x001e:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0021:
            com.google.zxing.client.android.CaptureActivity r9 = r8.activity
            com.google.zxing.client.android.camera.CameraManager r9 = r9.getCameraManager()
            com.google.zxing.PlanarYUVLuminanceSource r9 = r9.buildLuminanceSource(r2, r11, r10)
            if (r9 == 0) goto L_0x004f
            com.google.zxing.BinaryBitmap r10 = new com.google.zxing.BinaryBitmap
            com.google.zxing.common.HybridBinarizer r11 = new com.google.zxing.common.HybridBinarizer
            r11.<init>(r9)
            r10.<init>(r11)
            com.google.zxing.MultiFormatReader r11 = r8.multiFormatReader     // Catch:{ ReaderException -> 0x004a, all -> 0x0043 }
            com.google.zxing.Result r10 = r11.decodeWithState(r10)     // Catch:{ ReaderException -> 0x004a, all -> 0x0043 }
            com.google.zxing.MultiFormatReader r11 = r8.multiFormatReader
            r11.reset()
            goto L_0x0050
        L_0x0043:
            r9 = move-exception
            com.google.zxing.MultiFormatReader r10 = r8.multiFormatReader
            r10.reset()
            throw r9
        L_0x004a:
            com.google.zxing.MultiFormatReader r10 = r8.multiFormatReader
            r10.reset()
        L_0x004f:
            r10 = 0
        L_0x0050:
            com.google.zxing.client.android.CaptureActivity r11 = r8.activity
            android.os.Handler r11 = r11.getHandler()
            if (r10 == 0) goto L_0x0090
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Found barcode in "
            r5.append(r6)
            long r2 = r2 - r0
            r5.append(r2)
            java.lang.String r0 = " ms"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.util.Log.d(r4, r0)
            if (r11 == 0) goto L_0x009c
            r0 = 2131429043(0x7f0b06b3, float:1.8479748E38)
            android.os.Message r10 = android.os.Message.obtain(r11, r0, r10)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            bundleThumbnail(r9, r11)
            r10.setData(r11)
            r10.sendToTarget()
            goto L_0x009c
        L_0x0090:
            if (r11 == 0) goto L_0x009c
            r9 = 2131429042(0x7f0b06b2, float:1.8479746E38)
            android.os.Message r9 = android.os.Message.obtain(r11, r9)
            r9.sendToTarget()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.DecodeHandler.decode(byte[], int, int):void");
    }

    public void handleMessage(Message message) {
        if (message != null && this.running) {
            int i11 = message.what;
            if (i11 == R.id.decode) {
                decode((byte[]) message.obj, message.arg1, message.arg2);
            } else if (i11 == R.id.quit) {
                this.running = false;
                Looper.myLooper().quit();
            }
        }
    }
}
