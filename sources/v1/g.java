package v1;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

public class g {
    public static <T> ObjectAnimator a(T t11, Property<T, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t11, property, (TypeConverter) null, path);
        }
        return ObjectAnimator.ofFloat(t11, new h(property, path), new float[]{0.0f, 1.0f});
    }
}
