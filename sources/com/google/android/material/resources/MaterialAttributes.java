package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;

public class MaterialAttributes {
    public static TypedValue resolve(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i11, boolean z11) {
        TypedValue resolve = resolve(context, i11);
        if (resolve == null || resolve.type != 18) {
            return z11;
        }
        return resolve.data != 0;
    }

    public static boolean resolveBooleanOrThrow(Context context, int i11, String str) {
        return resolveOrThrow(context, i11, str) != 0;
    }

    public static int resolveDimension(Context context, int i11, int i12) {
        float dimension;
        TypedValue resolve = resolve(context, i11);
        if (resolve == null || resolve.type != 5) {
            dimension = context.getResources().getDimension(i12);
        } else {
            dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
        }
        return (int) dimension;
    }

    public static int resolveInteger(Context context, int i11, int i12) {
        TypedValue resolve = resolve(context, i11);
        return (resolve == null || resolve.type != 16) ? i12 : resolve.data;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(Context context, int i11, String str) {
        TypedValue resolve = resolve(context, i11);
        if (resolve != null) {
            return resolve.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i11)}));
    }

    public static int resolveOrThrow(View view, int i11) {
        return resolveOrThrow(view.getContext(), i11, view.getClass().getCanonicalName());
    }
}
