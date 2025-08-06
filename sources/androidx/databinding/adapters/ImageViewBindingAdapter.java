package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageViewBindingAdapter {
    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }
}
