package cg;

import com.huawei.face.antispoofing.meta.DetectResult;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;

public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37418b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f37419c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FaceAntispoofingSdk f37420d;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37421b;

        public a(String str) {
            this.f37421b = str;
        }

        public void run() {
            c.this.f37420d.f37575c.onDetectLocalFinish(DetectResult.success(this.f37421b));
        }
    }

    public c(FaceAntispoofingSdk faceAntispoofingSdk, int i11, int i12) {
        this.f37420d = faceAntispoofingSdk;
        this.f37418b = i11;
        this.f37419c = i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            r0 = 0
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r1 = r9.f37420d     // Catch:{ Exception -> 0x0068 }
            com.huawei.face.antispoofing.jni.FaceAntispoofingWrapper r2 = r1.f37578f     // Catch:{ Exception -> 0x0068 }
            org.opencv.core.Mat r2 = r2.getFaceImageResult()     // Catch:{ Exception -> 0x0068 }
            org.opencv.core.Mat unused = r1.f37579g = r2     // Catch:{ Exception -> 0x0068 }
            org.opencv.core.Mat r1 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x0068 }
            r1.<init>()     // Catch:{ Exception -> 0x0068 }
            int r2 = r9.f37418b     // Catch:{ Exception -> 0x0068 }
            int r3 = r9.f37419c     // Catch:{ Exception -> 0x0068 }
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0068 }
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r4)     // Catch:{ Exception -> 0x0068 }
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r3 = r9.f37420d     // Catch:{ Exception -> 0x0068 }
            org.opencv.core.Mat r3 = r3.f37579g     // Catch:{ Exception -> 0x0068 }
            org.opencv.core.Size r4 = new org.opencv.core.Size     // Catch:{ Exception -> 0x0068 }
            int r5 = r9.f37418b     // Catch:{ Exception -> 0x0068 }
            double r5 = (double) r5     // Catch:{ Exception -> 0x0068 }
            int r7 = r9.f37419c     // Catch:{ Exception -> 0x0068 }
            double r7 = (double) r7     // Catch:{ Exception -> 0x0068 }
            r4.<init>(r5, r7)     // Catch:{ Exception -> 0x0068 }
            org.opencv.imgproc.Imgproc.resize(r3, r1, r4)     // Catch:{ Exception -> 0x0068 }
            r3 = 4
            org.opencv.imgproc.Imgproc.cvtColor(r1, r1, r3)     // Catch:{ Exception -> 0x0068 }
            org.opencv.android.Utils.matToBitmap(r1, r2)     // Catch:{ Exception -> 0x0068 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0068 }
            r3.<init>()     // Catch:{ Exception -> 0x0068 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0068 }
            r5 = 100
            r2.compress(r4, r5, r3)     // Catch:{ Exception -> 0x0068 }
            byte[] r2 = r3.toByteArray()     // Catch:{ Exception -> 0x0068 }
            r4 = 0
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r4)     // Catch:{ Exception -> 0x0068 }
            com.huawei.face.antispoofing.utils.ThreadUtils r4 = com.huawei.face.antispoofing.utils.ThreadUtils.getInstance()     // Catch:{ Exception -> 0x0068 }
            cg.c$a r5 = new cg.c$a     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0068 }
            r4.runOnUiThread(r5)     // Catch:{ Exception -> 0x0068 }
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r4 = r9.f37420d     // Catch:{ Exception -> 0x0068 }
            com.huawei.face.antispoofing.meta.DetectResult r2 = com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk.a((com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk) r4, (java.lang.String) r2)     // Catch:{ Exception -> 0x0068 }
            r1.release()     // Catch:{ Exception -> 0x0066 }
            r3.close()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0074
        L_0x0066:
            r1 = move-exception
            goto L_0x006a
        L_0x0068:
            r1 = move-exception
            r2 = r0
        L_0x006a:
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk.a()
            java.lang.String r3 = "FaceAntispoofingSdk"
            java.lang.String r4 = "[doOnLocalDetectSucceed] remote process image failed"
            com.huawei.face.antispoofing.utils.LogFace.e(r3, r4, r1)
        L_0x0074:
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r1 = r9.f37420d
            com.huawei.face.antispoofing.listener.FaceAntispoofingResultListener r1 = r1.f37575c
            r1.onDetectFinish(r2)
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r1 = r9.f37420d
            org.opencv.core.Mat r1 = r1.f37579g
            if (r1 == 0) goto L_0x008c
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r1 = r9.f37420d
            org.opencv.core.Mat r1 = r1.f37579g
            r1.release()
        L_0x008c:
            com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk r1 = r9.f37420d
            org.opencv.core.Mat unused = r1.f37579g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cg.c.run():void");
    }
}
