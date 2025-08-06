package com.tencent.qcloud.tuikit.tuicallkit.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import java.security.MessageDigest;
import java.util.concurrent.ExecutionException;

public class ImageLoader {
    private static int radius;

    public static class GlideRoundTransform extends BitmapTransformation {
        private static float radius;

        public GlideRoundTransform(Context context, int i11) {
            radius = Resources.getSystem().getDisplayMetrics().density * ((float) i11);
        }

        private static Bitmap roundCrop(e eVar, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Bitmap d11 = eVar.d(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            if (d11 == null) {
                d11 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(d11);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            float f11 = radius;
            canvas.drawRoundRect(rectF, f11, f11, paint);
            return d11;
        }

        public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
            return roundCrop(eVar, bitmap);
        }

        public void updateDiskCacheKey(MessageDigest messageDigest) {
        }
    }

    public static void clear(Context context, ImageView imageView) {
        a.v(context).f(imageView);
    }

    public static Bitmap loadBitmap(Context context, Object obj, int i11) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return (Bitmap) a.v(context).b().L0(obj).b(loadTransform(context, R.drawable.tuicalling_ic_avatar, radius)).E0(i11, i11).get();
    }

    public static void loadGifImage(Context context, ImageView imageView, int i11) {
        a.v(context).e().K0(Integer.valueOf(i11)).D0(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, Object obj) {
        loadImage(context, imageView, obj, R.drawable.tuicalling_ic_avatar);
    }

    private static c<Drawable> loadTransform(Context context, int i11, int i12) {
        return a.v(context).o(Integer.valueOf(i11)).b(((RequestOptions) new RequestOptions().d()).n0(new GlideRoundTransform(context, i12)));
    }

    public static void loadImage(Context context, ImageView imageView, Object obj, int i11) {
        if (obj != null && obj != "") {
            a.v(context).p(obj).x0(loadTransform(context, i11, radius)).D0(imageView);
        } else if (imageView != null && i11 != 0) {
            imageView.setImageResource(i11);
        }
    }

    public static void loadImage(Context context, ImageView imageView, Integer num) {
        a.v(context).o(num).D0(imageView);
    }
}
