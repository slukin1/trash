package com.sumsub.sns.prooface.domain;

import android.graphics.Bitmap;
import android.graphics.Color;
import kotlin.Pair;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f40230a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final int f40231b = 200;

    public final Pair<Integer, Float> a(Bitmap bitmap) {
        try {
            int pixel = Bitmap.createScaledBitmap(bitmap, 1, 1, false).getPixel(0, 0);
            return new Pair<>(Integer.valueOf(pixel), Float.valueOf(((float) 200) * ((float) (((((double) Color.red(pixel)) / 255.0d) * 0.2126d) + ((((double) Color.green(pixel)) / 255.0d) * 0.7152d) + ((((double) Color.blue(pixel)) / 255.0d) * 0.0722d)))));
        } catch (Exception unused) {
            return new Pair<>(0, Float.valueOf(0.0f));
        }
    }
}
