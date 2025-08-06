package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewBindingAdapter {
    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
