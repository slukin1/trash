package com.example.flutterimagecompress.handle.heif;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.heifwriter.a;
import java.io.File;
import java.io.OutputStream;
import s4.a;

public final class HeifHandler implements a {
    public void a(Context context, byte[] bArr, OutputStream outputStream, int i11, int i12, int i13, int i14, boolean z11, int i15) {
        Context context2 = context;
        File a11 = v4.a.f66657a.a(context);
        d(bArr, i11, i12, i13, i14, i15, a11.getAbsolutePath());
        OutputStream outputStream2 = outputStream;
        outputStream.write(FilesKt__FileReadWriteKt.a(a11));
    }

    public void b(Context context, String str, OutputStream outputStream, int i11, int i12, int i13, int i14, boolean z11, int i15, int i16) {
        Context context2 = context;
        File a11 = v4.a.f66657a.a(context);
        c(str, i11, i12, i13, i14, i15, a11.getAbsolutePath());
        OutputStream outputStream2 = outputStream;
        outputStream.write(FilesKt__FileReadWriteKt.a(a11));
    }

    public final void c(String str, int i11, int i12, int i13, int i14, int i15, String str2) {
        e(BitmapFactory.decodeFile(str, f(i15)), i11, i12, i14, str2, i13);
    }

    public final void d(byte[] bArr, int i11, int i12, int i13, int i14, int i15, String str) {
        e(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, f(i15)), i11, i12, i14, str, i13);
    }

    public final void e(Bitmap bitmap, int i11, int i12, int i13, String str, int i14) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        u4.a.a(this, "src width = " + width);
        u4.a.a(this, "src height = " + height);
        float a11 = q4.a.a(bitmap, i11, i12);
        u4.a.a(this, "scale = " + a11);
        float f11 = width / a11;
        float f12 = height / a11;
        u4.a.a(this, "dst width = " + f11);
        u4.a.a(this, "dst height = " + f12);
        Bitmap f13 = q4.a.f(Bitmap.createScaledBitmap(bitmap, (int) f11, (int) f12, true), i13);
        androidx.heifwriter.a a12 = new a.b(str, f13.getWidth(), f13.getHeight(), 2).c(i14).b(1).a();
        a12.k();
        a12.a(f13);
        a12.l(5000);
        a12.close();
    }

    public final BitmapFactory.Options f(int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i11;
        if (Build.VERSION.SDK_INT < 23) {
            options.inDither = true;
        }
        return options;
    }

    public int getType() {
        return 2;
    }
}
