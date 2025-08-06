package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import f4.h;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Paint f64119a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    public static final Paint f64120b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    public static final Paint f64121c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f64122d;

    /* renamed from: e  reason: collision with root package name */
    public static final Lock f64123e;

    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f64124a;

        public a(int i11) {
            this.f64124a = i11;
        }

        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i11 = this.f64124a;
            canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
        }
    }

    public interface b {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    public static final class c implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j11, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f64122d = hashSet;
        f64123e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new c();
        Paint paint = new Paint(7);
        f64121c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f64123e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f64119a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th2) {
            f64123e.unlock();
            throw th2;
        }
    }

    public static Bitmap b(e eVar, Bitmap bitmap, int i11, int i12) {
        float f11;
        float f12;
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f13 = 0.0f;
        if (bitmap.getWidth() * i12 > bitmap.getHeight() * i11) {
            f12 = ((float) i12) / ((float) bitmap.getHeight());
            f13 = (((float) i11) - (((float) bitmap.getWidth()) * f12)) * 0.5f;
            f11 = 0.0f;
        } else {
            f12 = ((float) i11) / ((float) bitmap.getWidth());
            f11 = (((float) i12) - (((float) bitmap.getHeight()) * f12)) * 0.5f;
        }
        matrix.setScale(f12, f12);
        matrix.postTranslate((float) ((int) (f13 + 0.5f)), (float) ((int) (f11 + 0.5f)));
        Bitmap d11 = eVar.d(i11, i12, k(bitmap));
        q(bitmap, d11);
        a(bitmap, d11, matrix);
        return d11;
    }

    public static Bitmap c(e eVar, Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() > i11 || bitmap.getHeight() > i12) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return f(eVar, bitmap, i11, i12);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap d(e eVar, Bitmap bitmap, int i11, int i12) {
        int min = Math.min(i11, i12);
        float f11 = (float) min;
        float f12 = f11 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f11 / width, f11 / height);
        float f13 = width * max;
        float f14 = max * height;
        float f15 = (f11 - f13) / 2.0f;
        float f16 = (f11 - f14) / 2.0f;
        RectF rectF = new RectF(f15, f16, f13 + f15, f14 + f16);
        Bitmap g11 = g(eVar, bitmap);
        Bitmap d11 = eVar.d(min, min, h(bitmap));
        d11.setHasAlpha(true);
        Lock lock = f64123e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(d11);
            canvas.drawCircle(f12, f12, f12, f64120b);
            canvas.drawBitmap(g11, (Rect) null, rectF, f64121c);
            e(canvas);
            lock.unlock();
            if (!g11.equals(bitmap)) {
                eVar.c(g11);
            }
            return d11;
        } catch (Throwable th2) {
            f64123e.unlock();
            throw th2;
        }
    }

    public static void e(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    public static Bitmap f(e eVar, Bitmap bitmap, int i11, int i12) {
        if (bitmap.getWidth() == i11 && bitmap.getHeight() == i12) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i11) / ((float) bitmap.getWidth()), ((float) i12) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap d11 = eVar.d((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), k(bitmap));
        q(bitmap, d11);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i11 + "x" + i12);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + d11.getWidth() + "x" + d11.getHeight());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("minPct:   ");
            sb2.append(min);
            Log.v("TransformationUtils", sb2.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, d11, matrix);
        return d11;
    }

    public static Bitmap g(e eVar, Bitmap bitmap) {
        Bitmap.Config h11 = h(bitmap);
        if (h11.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap d11 = eVar.d(bitmap.getWidth(), bitmap.getHeight(), h11);
        new Canvas(d11).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return d11;
    }

    public static Bitmap.Config h(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGBA_F16;
    }

    public static Lock i() {
        return f64123e;
    }

    public static int j(int i11) {
        switch (i11) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Bitmap.Config k(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void l(int i11, Matrix matrix) {
        switch (i11) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean m(int i11) {
        switch (i11) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(e eVar, Bitmap bitmap, int i11) {
        if (!m(i11)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i11, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap d11 = eVar.d(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        d11.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, d11, matrix);
        return d11;
    }

    public static Bitmap o(e eVar, Bitmap bitmap, int i11) {
        h.a(i11 > 0, "roundingRadius must be greater than 0.");
        return p(eVar, bitmap, new a(i11));
    }

    public static Bitmap p(e eVar, Bitmap bitmap, b bVar) {
        Bitmap.Config h11 = h(bitmap);
        Bitmap g11 = g(eVar, bitmap);
        Bitmap d11 = eVar.d(g11.getWidth(), g11.getHeight(), h11);
        d11.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(g11, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) d11.getWidth(), (float) d11.getHeight());
        Lock lock = f64123e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(d11);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            bVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!g11.equals(bitmap)) {
                eVar.c(g11);
            }
            return d11;
        } catch (Throwable th2) {
            f64123e.unlock();
            throw th2;
        }
    }

    public static void q(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
