package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.resources.MaterialAttributes;
import t0.c;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    public static int compositeARGBWithAlpha(int i11, int i12) {
        return c.j(i11, (Color.alpha(i11) * i12) / 255);
    }

    public static int getColor(View view, int i11) {
        return MaterialAttributes.resolveOrThrow(view, i11);
    }

    public static boolean isColorLight(int i11) {
        return i11 != 0 && c.c(i11) > 0.5d;
    }

    public static int layer(View view, int i11, int i12) {
        return layer(view, i11, i12, 1.0f);
    }

    public static int getColor(Context context, int i11, String str) {
        return MaterialAttributes.resolveOrThrow(context, i11, str);
    }

    public static int layer(View view, int i11, int i12, float f11) {
        return layer(getColor(view, i11), getColor(view, i12), f11);
    }

    public static int getColor(View view, int i11, int i12) {
        return getColor(view.getContext(), i11, i12);
    }

    public static int getColor(Context context, int i11, int i12) {
        TypedValue resolve = MaterialAttributes.resolve(context, i11);
        return resolve != null ? resolve.data : i12;
    }

    public static int layer(int i11, int i12, float f11) {
        return layer(i11, c.j(i12, Math.round(((float) Color.alpha(i12)) * f11)));
    }

    public static int layer(int i11, int i12) {
        return c.f(i12, i11);
    }
}
