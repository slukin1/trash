package t4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import p4.b;

public final class a implements s4.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f66653a;

    public a(int i11) {
        this.f66653a = i11;
    }

    public void a(Context context, byte[] bArr, OutputStream outputStream, int i11, int i12, int i13, int i14, boolean z11, int i15) {
        OutputStream outputStream2 = outputStream;
        byte[] c11 = c(bArr, i11, i12, i13, i14, i15);
        if (!z11 || d() != Bitmap.CompressFormat.JPEG) {
            outputStream.write(c11);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(c11);
        byte[] bArr2 = bArr;
        Context context2 = context;
        outputStream.write(new b(bArr).c(context, byteArrayOutputStream).toByteArray());
    }

    public void b(Context context, String str, OutputStream outputStream, int i11, int i12, int i13, int i14, boolean z11, int i15, int i16) {
        String str2 = str;
        OutputStream outputStream2 = outputStream;
        int i17 = i15;
        if (i16 > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inSampleSize = i17;
                if (Build.VERSION.SDK_INT < 23) {
                    options.inDither = true;
                }
                byte[] c11 = q4.a.c(BitmapFactory.decodeFile(str, options), i11, i12, i13, i14, getType());
                if (!z11 || d() != Bitmap.CompressFormat.JPEG) {
                    Context context2 = context;
                    outputStream2.write(c11);
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(c11);
                Context context3 = context;
                try {
                    outputStream2.write(new b(str).c(context, byteArrayOutputStream).toByteArray());
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    b(context, str, outputStream, i11, i12, i13, i14, z11, i17 * 2, i16 - 1);
                }
            } catch (OutOfMemoryError unused2) {
                Context context4 = context;
                System.gc();
                b(context, str, outputStream, i11, i12, i13, i14, z11, i17 * 2, i16 - 1);
            }
        }
    }

    public final byte[] c(byte[] bArr, int i11, int i12, int i13, int i14, int i15) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i15;
        if (Build.VERSION.SDK_INT < 23) {
            options.inDither = true;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        float width = (float) decodeByteArray.getWidth();
        float height = (float) decodeByteArray.getHeight();
        u4.a.a(this, "src width = " + width);
        u4.a.a(this, "src height = " + height);
        float a11 = q4.a.a(decodeByteArray, i11, i12);
        u4.a.a(this, "scale = " + a11);
        float f11 = width / a11;
        float f12 = height / a11;
        u4.a.a(this, "dst width = " + f11);
        u4.a.a(this, "dst height = " + f12);
        q4.a.f(Bitmap.createScaledBitmap(decodeByteArray, (int) f11, (int) f12, true), i14).compress(d(), i13, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final Bitmap.CompressFormat d() {
        int type = getType();
        if (type == 1) {
            return Bitmap.CompressFormat.PNG;
        }
        if (type != 3) {
            return Bitmap.CompressFormat.JPEG;
        }
        return Bitmap.CompressFormat.WEBP;
    }

    public int getType() {
        return this.f66653a;
    }
}
