package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public final class o extends BitmapDrawable {

    /* renamed from: h  reason: collision with root package name */
    public static final Paint f30072h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f30073a;

    /* renamed from: b  reason: collision with root package name */
    public final float f30074b;

    /* renamed from: c  reason: collision with root package name */
    public final Picasso.LoadedFrom f30075c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f30076d;

    /* renamed from: e  reason: collision with root package name */
    public long f30077e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30078f;

    /* renamed from: g  reason: collision with root package name */
    public int f30079g = 255;

    public o(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z11, boolean z12) {
        super(context.getResources(), bitmap);
        this.f30073a = z12;
        this.f30074b = context.getResources().getDisplayMetrics().density;
        this.f30075c = loadedFrom;
        if (loadedFrom != Picasso.LoadedFrom.MEMORY && !z11) {
            this.f30076d = drawable;
            this.f30078f = true;
            this.f30077e = SystemClock.uptimeMillis();
        }
    }

    public static Path b(int i11, int i12, int i13) {
        Path path = new Path();
        float f11 = (float) i11;
        float f12 = (float) i12;
        path.moveTo(f11, f12);
        path.lineTo((float) (i11 + i13), f12);
        path.lineTo(f11, (float) (i12 + i13));
        return path;
    }

    public static void c(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z11, boolean z12) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new o(context, bitmap, drawable, loadedFrom, z11, z12));
    }

    public static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public final void a(Canvas canvas) {
        Paint paint = f30072h;
        paint.setColor(-1);
        canvas.drawPath(b(0, 0, (int) (this.f30074b * 16.0f)), paint);
        paint.setColor(this.f30075c.debugColor);
        canvas.drawPath(b(0, 0, (int) (this.f30074b * 15.0f)), paint);
    }

    public void draw(Canvas canvas) {
        if (!this.f30078f) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f30077e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f30078f = false;
                this.f30076d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f30076d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f30079g) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f30079g);
            }
        }
        if (this.f30073a) {
            a(canvas);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f30076d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i11) {
        this.f30079g = i11;
        Drawable drawable = this.f30076d;
        if (drawable != null) {
            drawable.setAlpha(i11);
        }
        super.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f30076d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
