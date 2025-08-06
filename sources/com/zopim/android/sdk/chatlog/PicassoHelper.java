package com.zopim.android.sdk.chatlog;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.widget.ImageView;
import com.sebchlan.picassocompat.CallbackCompat;
import com.sebchlan.picassocompat.PicassoBridge;
import com.sebchlan.picassocompat.PicassoCompat;
import com.sebchlan.picassocompat.RequestCreatorCompat;
import com.sebchlan.picassocompat.TransformationCompat;
import com.zopim.android.sdk.R;
import java.io.File;
import mz.f;

final class PicassoHelper {

    public static class CircleTransform implements TransformationCompat {
        private CircleTransform() {
        }

        public String key() {
            return TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
        }

        public Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f11 = ((float) min) / 2.0f;
            canvas.drawCircle(f11, f11, f11, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    public static class CropSquareTransform implements TransformationCompat {
        private int radius = -1;

        public CropSquareTransform(int i11) {
            this.radius = i11;
        }

        public String key() {
            return "crop-square-radius(" + this.radius + ")";
        }

        public Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            if (this.radius <= 0) {
                return createBitmap;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            float f11 = (float) min;
            RectF rectF = new RectF(0.0f, 0.0f, f11, f11);
            int i11 = this.radius;
            canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
            if (createBitmap2 != createBitmap) {
                createBitmap.recycle();
            }
            return createBitmap2;
        }
    }

    public static class ResizeTransformation implements TransformationCompat {
        private final int width;

        public ResizeTransformation(int i11) {
            this.width = i11;
        }

        public String key() {
            return "resize_transformation_" + this.width;
        }

        public Bitmap transform(Bitmap bitmap) {
            if (this.width <= 0) {
                return bitmap;
            }
            double height = ((double) bitmap.getHeight()) / ((double) bitmap.getWidth());
            int i11 = this.width;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i11, (int) (((double) i11) * height), false);
            if (createScaledBitmap != bitmap) {
                bitmap.recycle();
            }
            return createScaledBitmap;
        }
    }

    public static void loadAvatarImage(ImageView imageView, String str) {
        RequestCreatorCompat requestCreatorCompat;
        PicassoCompat init = PicassoBridge.init(imageView.getContext());
        if (f.c(str)) {
            RequestCreatorCompat load = init.load(str);
            int i11 = R.drawable.ic_chat_default_avatar;
            requestCreatorCompat = load.error(i11).error(i11).placeholder(i11);
        } else {
            requestCreatorCompat = init.load(R.drawable.ic_chat_default_avatar);
        }
        requestCreatorCompat.transform(new CircleTransform()).into(imageView);
    }

    public static void loadImage(ImageView imageView, File file, CallbackCompat callbackCompat) {
        loadImage(imageView, PicassoBridge.init(imageView.getContext()).load(file), callbackCompat);
    }

    public static void loadImage(ImageView imageView, Uri uri, CallbackCompat callbackCompat) {
        loadImage(imageView, PicassoBridge.init(imageView.getContext()).load(uri), callbackCompat);
    }

    private static void loadImage(final ImageView imageView, final RequestCreatorCompat requestCreatorCompat, final CallbackCompat callbackCompat) {
        imageView.post(new Runnable() {
            public void run() {
                RequestCreatorCompat requestCreatorCompat;
                int width = imageView.getWidth();
                RequestCreatorCompat error = requestCreatorCompat.transform(new ResizeTransformation(width)).placeholder(R.drawable.bg_picasso_placeholder).error(R.drawable.ic_chat_default_avatar);
                if (width > 0) {
                    error = error.resize(width, 0);
                }
                if (Build.VERSION.SDK_INT <= 10) {
                    requestCreatorCompat = error.transform(new CropSquareTransform(0));
                } else {
                    requestCreatorCompat = error.transform(new CropSquareTransform(imageView.getContext().getResources().getDimensionPixelSize(R.dimen.attachment_preview_radius)));
                }
                requestCreatorCompat.into(imageView, callbackCompat);
            }
        });
    }
}
