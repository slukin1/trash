package u0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public class h extends Drawable implements Drawable.Callback, g, f {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f16589h = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public int f16590b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f16591c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16592d;

    /* renamed from: e  reason: collision with root package name */
    public j f16593e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16594f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f16595g;

    public h(j jVar, Resources resources) {
        this.f16593e = jVar;
        e(resources);
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f16595g;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f16595g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            j jVar = this.f16593e;
            if (jVar != null) {
                jVar.f16598b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final Drawable b() {
        return this.f16595g;
    }

    public boolean c() {
        return true;
    }

    public final j d() {
        return new j(this.f16593e);
    }

    public void draw(Canvas canvas) {
        this.f16595g.draw(canvas);
    }

    public final void e(Resources resources) {
        Drawable.ConstantState constantState;
        j jVar = this.f16593e;
        if (jVar != null && (constantState = jVar.f16598b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        j jVar = this.f16593e;
        ColorStateList colorStateList = jVar.f16599c;
        PorterDuff.Mode mode = jVar.f16600d;
        if (colorStateList == null || mode == null) {
            this.f16592d = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f16592d && colorForState == this.f16590b && mode == this.f16591c)) {
                setColorFilter(colorForState, mode);
                this.f16590b = colorForState;
                this.f16591c = mode;
                this.f16592d = true;
                return true;
            }
        }
        return false;
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        j jVar = this.f16593e;
        return changingConfigurations | (jVar != null ? jVar.getChangingConfigurations() : 0) | this.f16595g.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        j jVar = this.f16593e;
        if (jVar == null || !jVar.a()) {
            return null;
        }
        this.f16593e.f16597a = getChangingConfigurations();
        return this.f16593e;
    }

    public Drawable getCurrent() {
        return this.f16595g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f16595g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f16595g.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return a.f(this.f16595g);
    }

    public int getMinimumHeight() {
        return this.f16595g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f16595g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f16595g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f16595g.getPadding(rect);
    }

    public int[] getState() {
        return this.f16595g.getState();
    }

    public Region getTransparentRegion() {
        return this.f16595g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h(this.f16595g);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f16593e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x000d
            u0.j r0 = r1.f16593e
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f16599c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f16595g
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.h.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f16595g.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f16594f && super.mutate() == this) {
            this.f16593e = d();
            Drawable drawable = this.f16595g;
            if (drawable != null) {
                drawable.mutate();
            }
            j jVar = this.f16593e;
            if (jVar != null) {
                Drawable drawable2 = this.f16595g;
                jVar.f16598b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f16594f = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f16595g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i11) {
        return a.m(this.f16595g, i11);
    }

    public boolean onLevelChange(int i11) {
        return this.f16595g.setLevel(i11);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        this.f16595g.setAlpha(i11);
    }

    public void setAutoMirrored(boolean z11) {
        a.j(this.f16595g, z11);
    }

    public void setChangingConfigurations(int i11) {
        this.f16595g.setChangingConfigurations(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16595g.setColorFilter(colorFilter);
    }

    public void setDither(boolean z11) {
        this.f16595g.setDither(z11);
    }

    public void setFilterBitmap(boolean z11) {
        this.f16595g.setFilterBitmap(z11);
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.f16595g.setState(iArr);
    }

    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f16593e.f16599c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f16593e.f16600d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z11, boolean z12) {
        return super.setVisible(z11, z12) || this.f16595g.setVisible(z11, z12);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public h(Drawable drawable) {
        this.f16593e = d();
        a(drawable);
    }
}
