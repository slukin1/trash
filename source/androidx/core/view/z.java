package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final PointerIcon f8687a;

    public static class a {
        public static PointerIcon a(Bitmap bitmap, float f11, float f12) {
            return PointerIcon.create(bitmap, f11, f12);
        }

        public static PointerIcon b(Context context, int i11) {
            return PointerIcon.getSystemIcon(context, i11);
        }

        public static PointerIcon c(Resources resources, int i11) {
            return PointerIcon.load(resources, i11);
        }
    }

    public z(PointerIcon pointerIcon) {
        this.f8687a = pointerIcon;
    }

    public static z b(Context context, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new z(a.b(context, i11));
        }
        return new z((PointerIcon) null);
    }

    public Object a() {
        return this.f8687a;
    }
}
