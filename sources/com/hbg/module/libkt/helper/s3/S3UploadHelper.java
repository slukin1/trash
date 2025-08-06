package com.hbg.module.libkt.helper.s3;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import v7.b;

public final class S3UploadHelper {
    public static final S3UploadHelper INSTANCE = new S3UploadHelper();

    private S3UploadHelper() {
    }

    public static final void upLoad(Context context, Uri uri, String str, S3UploadInterface s3UploadInterface) {
        RequestExtKt.d(b.a().getS3Token(), new S3UploadHelper$upLoad$1(uri, context, s3UploadInterface, str), new S3UploadHelper$upLoad$2(s3UploadInterface), (MutableLiveData) null, 4, (Object) null);
    }

    public static /* synthetic */ void upLoad$default(Context context, Uri uri, String str, S3UploadInterface s3UploadInterface, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            s3UploadInterface = null;
        }
        upLoad(context, uri, str, s3UploadInterface);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.net.Uri bitmapToUri(android.graphics.Bitmap r6) {
        /*
            r5 = this;
            boolean r0 = r6.hasAlpha()
            r1 = 1
            if (r0 != r1) goto L_0x000a
            java.lang.String r0 = "png"
            goto L_0x000e
        L_0x000a:
            if (r0 != 0) goto L_0x00a2
            java.lang.String r0 = "jpeg"
        L_0x000e:
            boolean r2 = r6.hasAlpha()
            if (r2 != r1) goto L_0x0017
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x001b
        L_0x0017:
            if (r2 != 0) goto L_0x009c
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            long r3 = java.lang.System.currentTimeMillis()
            r2.append(r3)
            r3 = 46
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r4 = "title"
            r3.put(r4, r2)
            java.lang.String r4 = "_display_name"
            r3.put(r4, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "image/"
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "mime_type"
            r3.put(r2, r0)
            android.app.Application r0 = com.hbg.lib.common.BaseApplication.b()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r0 = r0.insert(r2, r3)
            r2 = 0
            android.app.Application r3 = com.hbg.lib.common.BaseApplication.b()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            java.io.OutputStream r3 = r3.openOutputStream(r0)     // Catch:{ Exception -> 0x0083, all -> 0x0081 }
            r4 = 100
            r6.compress(r1, r4, r3)     // Catch:{ Exception -> 0x007f }
            r3.flush()
            r3.close()
            return r0
        L_0x007f:
            r6 = move-exception
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            goto L_0x0093
        L_0x0083:
            r6 = move-exception
            r3 = r2
        L_0x0085:
            r6.printStackTrace()     // Catch:{ all -> 0x0091 }
            if (r3 == 0) goto L_0x0090
            r3.flush()
            r3.close()
        L_0x0090:
            return r2
        L_0x0091:
            r6 = move-exception
            r2 = r3
        L_0x0093:
            if (r2 == 0) goto L_0x009b
            r2.flush()
            r2.close()
        L_0x009b:
            throw r6
        L_0x009c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00a2:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.helper.s3.S3UploadHelper.bitmapToUri(android.graphics.Bitmap):android.net.Uri");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047 A[SYNTHETIC, Splitter:B:27:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] imageSizeCompress(android.net.Uri r7) {
        /*
            r6 = this;
            r0 = 2
            if (r7 == 0) goto L_0x005c
            r1 = 0
            r2 = 1
            r3 = 0
            android.app.Application r4 = com.hbg.lib.common.BaseApplication.b()     // Catch:{ all -> 0x0038 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x0038 }
            java.io.InputStream r7 = r4.openInputStream(r7)     // Catch:{ all -> 0x0038 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ all -> 0x0036 }
            r4.<init>()     // Catch:{ all -> 0x0036 }
            r4.inJustDecodeBounds = r2     // Catch:{ all -> 0x0036 }
            android.graphics.BitmapFactory.decodeStream(r7, r1, r4)     // Catch:{ all -> 0x0036 }
            int r1 = r4.outWidth     // Catch:{ all -> 0x0036 }
            int r4 = r4.outHeight     // Catch:{ all -> 0x0033 }
            int[] r5 = new int[r0]     // Catch:{ all -> 0x0031 }
            r5[r3] = r1     // Catch:{ all -> 0x0031 }
            r5[r2] = r4     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x0030
            r7.close()     // Catch:{ all -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0030:
            return r5
        L_0x0031:
            r5 = move-exception
            goto L_0x003c
        L_0x0033:
            r5 = move-exception
            r4 = r3
            goto L_0x003c
        L_0x0036:
            r5 = move-exception
            goto L_0x003a
        L_0x0038:
            r5 = move-exception
            r7 = r1
        L_0x003a:
            r1 = r3
            r4 = r1
        L_0x003c:
            r5.printStackTrace()     // Catch:{ all -> 0x0050 }
            int[] r0 = new int[r0]     // Catch:{ all -> 0x0050 }
            r0[r3] = r1     // Catch:{ all -> 0x0050 }
            r0[r2] = r4     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x004f
            r7.close()     // Catch:{ all -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
            if (r7 == 0) goto L_0x005b
            r7.close()     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005b:
            throw r0
        L_0x005c:
            int[] r7 = new int[r0]
            r7 = {0, 0} // fill-array
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.helper.s3.S3UploadHelper.imageSizeCompress(android.net.Uri):int[]");
    }
}
