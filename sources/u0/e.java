package u0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.view.f;

public final class e {

    public static class a extends d {
        public a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public void c(int i11, int i12, int i13, Rect rect, Rect rect2) {
            f.a(i11, i12, i13, rect, rect2, 0);
        }
    }

    public static d a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
