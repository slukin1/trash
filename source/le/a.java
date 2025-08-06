package le;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface a {
    Bitmap.Config a();

    boolean b();

    float c();

    void d(Canvas canvas, Bitmap bitmap);

    void destroy();

    Bitmap e(Bitmap bitmap, float f11);
}
