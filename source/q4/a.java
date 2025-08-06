package q4;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.example.flutterimagecompress.FlutterImageCompressPlugin;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class a {
    public static final float a(Bitmap bitmap, int i11, int i12) {
        float width = ((float) bitmap.getWidth()) / ((float) i11);
        float height = ((float) bitmap.getHeight()) / ((float) i12);
        e("width scale = " + width);
        e("height scale = " + height);
        return Math.max(1.0f, Math.min(width, height));
    }

    public static final void b(Bitmap bitmap, int i11, int i12, int i13, int i14, OutputStream outputStream, int i15) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        e("src width = " + width);
        e("src height = " + height);
        float a11 = a(bitmap, i11, i12);
        e("scale = " + a11);
        float f11 = width / a11;
        float f12 = height / a11;
        e("dst width = " + f11);
        e("dst height = " + f12);
        f(Bitmap.createScaledBitmap(bitmap, (int) f11, (int) f12, true), i14).compress(d(i15), i13, outputStream);
    }

    public static final byte[] c(Bitmap bitmap, int i11, int i12, int i13, int i14, int i15) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(bitmap, i11, i12, i13, i14, byteArrayOutputStream, i15);
        return byteArrayOutputStream.toByteArray();
    }

    public static final Bitmap.CompressFormat d(int i11) {
        if (i11 != 1) {
            return i11 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.PNG;
    }

    public static final void e(Object obj) {
        if (FlutterImageCompressPlugin.f64984d.a()) {
            if (obj == null) {
                obj = OptionsBridge.NULL_VALUE;
            }
            System.out.println(obj);
        }
    }

    public static final Bitmap f(Bitmap bitmap, int i11) {
        if (i11 % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }
}
