package ic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f19136a = new e();

    public final Bitmap a(Context context, int i11) {
        return BitmapFactory.decodeResource(context.getResources(), i11);
    }

    public final String b(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
