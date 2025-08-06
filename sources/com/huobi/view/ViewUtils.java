package com.huobi.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

public class ViewUtils {
    private ViewUtils() {
    }

    public static Bitmap obtainCaptureBitmap(View view) {
        if (view == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap obtainRadiusBitmap(View view, int i11) {
        if (view == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap drawingCache = view.getDrawingCache();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        float f11 = (float) i11;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }
}
