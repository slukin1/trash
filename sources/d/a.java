package d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class a extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    public Drawable f15602b;

    public a(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.f15602b;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f15602b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f15602b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f15602b.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f15602b.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f15602b.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f15602b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f15602b.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f15602b.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f15602b.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f15602b.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f15602b.getPadding(rect);
    }

    public int[] getState() {
        return this.f15602b.getState();
    }

    public Region getTransparentRegion() {
        return this.f15602b.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return u0.a.h(this.f15602b);
    }

    public boolean isStateful() {
        return this.f15602b.isStateful();
    }

    public void jumpToCurrentState() {
        this.f15602b.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.f15602b.setBounds(rect);
    }

    public boolean onLevelChange(int i11) {
        return this.f15602b.setLevel(i11);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        this.f15602b.setAlpha(i11);
    }

    public void setAutoMirrored(boolean z11) {
        u0.a.j(this.f15602b, z11);
    }

    public void setChangingConfigurations(int i11) {
        this.f15602b.setChangingConfigurations(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f15602b.setColorFilter(colorFilter);
    }

    public void setDither(boolean z11) {
        this.f15602b.setDither(z11);
    }

    public void setFilterBitmap(boolean z11) {
        this.f15602b.setFilterBitmap(z11);
    }

    public void setHotspot(float f11, float f12) {
        u0.a.k(this.f15602b, f11, f12);
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        u0.a.l(this.f15602b, i11, i12, i13, i14);
    }

    public boolean setState(int[] iArr) {
        return this.f15602b.setState(iArr);
    }

    public void setTint(int i11) {
        u0.a.n(this.f15602b, i11);
    }

    public void setTintList(ColorStateList colorStateList) {
        u0.a.o(this.f15602b, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        u0.a.p(this.f15602b, mode);
    }

    public boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12) || this.f15602b.setVisible(z11, z12);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
