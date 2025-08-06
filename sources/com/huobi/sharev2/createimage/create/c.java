package com.huobi.sharev2.createimage.create;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.huobi.utils.GsonHelper;
import java.io.File;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f81058a = new c();

    public final a a(String str) {
        try {
            return (a) GsonHelper.a().fromJson(str, a.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (kotlin.text.StringsKt__StringsKt.R(r11, ";base64", false, 2, (java.lang.Object) null) == true) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        if (r11 != null) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.lang.String r11, android.content.Context r12, int r13, int r14) {
        /*
            r10 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 0
            if (r11 == 0) goto L_0x0010
            java.lang.String r4 = "http"
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.M(r11, r4, r3, r0, r2)
            if (r4 != r1) goto L_0x0010
            r4 = r1
            goto L_0x0011
        L_0x0010:
            r4 = r3
        L_0x0011:
            java.lang.String r5 = "content://"
            if (r4 != 0) goto L_0x0066
            if (r11 == 0) goto L_0x001f
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.M(r11, r5, r3, r0, r2)
            if (r4 != r1) goto L_0x001f
            r4 = r1
            goto L_0x0020
        L_0x001f:
            r4 = r3
        L_0x0020:
            if (r4 == 0) goto L_0x0023
            goto L_0x0066
        L_0x0023:
            if (r11 == 0) goto L_0x002e
            java.lang.String r12 = ";base64"
            boolean r12 = kotlin.text.StringsKt__StringsKt.R(r11, r12, r3, r0, r2)     // Catch:{ Exception -> 0x0064 }
            if (r12 != r1) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r3
        L_0x002f:
            java.lang.String r12 = ""
            if (r1 == 0) goto L_0x004f
            if (r11 == 0) goto L_0x0041
            java.lang.String r5 = ","
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r11
            int r0 = kotlin.text.StringsKt__StringsKt.g0(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            if (r11 == 0) goto L_0x0051
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.F0(r11, r3, r0, r12)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0064 }
            if (r11 != 0) goto L_0x0052
            goto L_0x0051
        L_0x004f:
            if (r11 != 0) goto L_0x0052
        L_0x0051:
            r11 = r12
        L_0x0052:
            android.graphics.Bitmap r11 = r10.d(r11)     // Catch:{ Exception -> 0x0064 }
            if (r13 <= 0) goto L_0x00a7
            if (r14 <= 0) goto L_0x00a7
            if (r11 == 0) goto L_0x0064
            com.huobi.sharev2.createimage.create.c r12 = f81058a     // Catch:{ Exception -> 0x0063 }
            android.graphics.Bitmap r2 = r12.c(r11, r13, r14)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0064
        L_0x0063:
            r2 = r11
        L_0x0064:
            r11 = r2
            goto L_0x00a7
        L_0x0066:
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.M(r11, r5, r3, r0, r2)
            if (r13 <= 0) goto L_0x008b
            if (r14 <= 0) goto L_0x008b
            com.bumptech.glide.d r12 = com.bumptech.glide.a.v(r12)
            com.bumptech.glide.c r12 = r12.b()
            if (r0 == 0) goto L_0x007c
            android.net.Uri r11 = android.net.Uri.parse(r11)
        L_0x007c:
            com.bumptech.glide.c r11 = r12.L0(r11)
            com.bumptech.glide.request.b r11 = r11.E0(r13, r14)
            java.lang.Object r11 = r11.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
            goto L_0x00a7
        L_0x008b:
            com.bumptech.glide.d r12 = com.bumptech.glide.a.v(r12)
            com.bumptech.glide.c r12 = r12.b()
            if (r0 == 0) goto L_0x0099
            android.net.Uri r11 = android.net.Uri.parse(r11)
        L_0x0099:
            com.bumptech.glide.c r11 = r12.L0(r11)
            com.bumptech.glide.request.b r11 = r11.R0()
            java.lang.Object r11 = r11.get()
            android.graphics.Bitmap r11 = (android.graphics.Bitmap) r11
        L_0x00a7:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.sharev2.createimage.create.c.b(java.lang.String, android.content.Context, int, int):android.graphics.Bitmap");
    }

    public final Bitmap c(Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = Math.max(((float) i11) / ((float) width), ((float) i12) / ((float) height));
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public final Bitmap d(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final Uri e(Context context, String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(new File(str));
        }
        return FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileprovider", new File(str));
    }
}
