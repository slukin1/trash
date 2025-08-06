package c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

@SuppressLint({"RestrictedAPI"})
public final class a {
    public static ColorStateList a(Context context, int i11) {
        return ContextCompat.getColorStateList(context, i11);
    }

    public static Drawable b(Context context, int i11) {
        return ResourceManagerInternal.h().j(context, i11);
    }
}
