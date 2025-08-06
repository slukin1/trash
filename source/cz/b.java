package cz;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public class b extends Drawable implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    public final c f52795b;

    /* renamed from: c  reason: collision with root package name */
    public final Drawable.Callback f52796c;

    public class a implements Drawable.Callback {
        public a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            b.this.scheduleSelf(runnable, j11);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    public b(c cVar) {
        a aVar = new a();
        this.f52796c = aVar;
        this.f52795b = cVar;
        cVar.j(aVar);
    }

    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty()) {
            this.f52795b.d(canvas);
        }
    }

    public int getIntrinsicHeight() {
        return (int) this.f52795b.f52804g;
    }

    public int getIntrinsicWidth() {
        return (int) this.f52795b.f52803f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f52795b.f();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f52795b.i(rect);
    }

    public void setAlpha(int i11) {
        this.f52795b.h(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f52795b.k(colorFilter);
    }

    public void start() {
        this.f52795b.m();
    }

    public void stop() {
        this.f52795b.n();
    }
}
