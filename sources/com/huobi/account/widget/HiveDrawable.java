package com.huobi.account.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class HiveDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Rect f41968a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f41969b;

    /* renamed from: c  reason: collision with root package name */
    public Path f41970c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapShader f41971d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f41972e;

    public HiveDrawable() {
        this((Bitmap) null);
    }

    public final void a() {
        if (this.f41969b == null) {
            this.f41969b = new Paint();
        }
    }

    public final void b() {
        if (this.f41970c == null) {
            this.f41970c = new Path();
        }
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        a();
        this.f41969b.setAntiAlias(true);
        this.f41969b.setStyle(Paint.Style.FILL);
        this.f41969b.setStrokeWidth(3.0f);
    }

    public void draw(Canvas canvas) {
        canvas.drawPath(this.f41970c, this.f41969b);
    }

    public final void e() {
        b();
        float width = (float) (this.f41968a.width() / 2);
        double d11 = (double) width;
        float sqrt = (float) (Math.sqrt(3.0d) * d11);
        float height = (((float) this.f41968a.height()) - sqrt) / 2.0f;
        this.f41970c.reset();
        float f11 = width / 2.0f;
        this.f41970c.moveTo(f11, height);
        float f12 = (sqrt / 2.0f) + height;
        this.f41970c.lineTo(0.0f, f12);
        float f13 = sqrt + height;
        this.f41970c.lineTo(f11, f13);
        float f14 = (float) (d11 * 1.5d);
        this.f41970c.lineTo(f14, f13);
        this.f41970c.lineTo(width * 2.0f, f12);
        this.f41970c.lineTo(f14, height);
        this.f41970c.lineTo(f11, height);
        this.f41970c.close();
    }

    public void f(Bitmap bitmap) {
        this.f41972e = bitmap;
        if (bitmap == null) {
            this.f41971d = null;
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f41971d = bitmapShader;
        this.f41969b.setShader(bitmapShader);
    }

    public int getIntrinsicHeight() {
        Bitmap bitmap = this.f41972e;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return super.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Bitmap bitmap = this.f41972e;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return super.getIntrinsicWidth();
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i11) {
        Paint paint = this.f41969b;
        if (paint != null) {
            paint.setAlpha(i11);
        }
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        this.f41968a.set(i11, i12, i13, i14);
        e();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.f41969b;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public HiveDrawable(Bitmap bitmap) {
        this.f41968a = new Rect();
        c();
        f(bitmap);
    }
}
