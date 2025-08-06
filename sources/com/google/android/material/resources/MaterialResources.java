package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.d0;
import c.a;

public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i11) {
        int color;
        int resourceId;
        ColorStateList a11;
        if (typedArray.hasValue(i11) && (resourceId = typedArray.getResourceId(i11, 0)) != 0 && (a11 = a.a(context, resourceId)) != null) {
            return a11;
        }
        if (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i11, -1)) == -1) {
            return typedArray.getColorStateList(i11);
        }
        return ColorStateList.valueOf(color);
    }

    public static int getDimensionPixelSize(Context context, TypedArray typedArray, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i11, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i11, i12);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i12);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i11) {
        int resourceId;
        Drawable b11;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0 || (b11 = a.b(context, resourceId)) == null) {
            return typedArray.getDrawable(i11);
        }
        return b11;
    }

    public static int getIndexWithValue(TypedArray typedArray, int i11, int i12) {
        return typedArray.hasValue(i11) ? i11 : i12;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int i11) {
        int resourceId;
        if (!typedArray.hasValue(i11) || (resourceId = typedArray.getResourceId(i11, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3;
    }

    public static boolean isFontScaleAtLeast2_0(Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_2_0;
    }

    public static ColorStateList getColorStateList(Context context, d0 d0Var, int i11) {
        int b11;
        int n11;
        ColorStateList a11;
        if (d0Var.s(i11) && (n11 = d0Var.n(i11, 0)) != 0 && (a11 = a.a(context, n11)) != null) {
            return a11;
        }
        if (Build.VERSION.SDK_INT > 15 || (b11 = d0Var.b(i11, -1)) == -1) {
            return d0Var.c(i11);
        }
        return ColorStateList.valueOf(b11);
    }
}
