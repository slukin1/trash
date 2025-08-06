package u0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

public class i extends h {

    /* renamed from: i  reason: collision with root package name */
    public static Method f16596i;

    public i(Drawable drawable) {
        super(drawable);
        g();
    }

    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f16595g;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public final void g() {
        if (f16596i == null) {
            try {
                f16596i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e11) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e11);
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.f16595g.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f16595g.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f16595g;
        if (!(drawable == null || (method = f16596i) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e11) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e11);
            }
        }
        return false;
    }

    public void setHotspot(float f11, float f12) {
        this.f16595g.setHotspot(f11, f12);
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        this.f16595g.setHotspotBounds(i11, i12, i13, i14);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i11) {
        if (c()) {
            super.setTint(i11);
        } else {
            this.f16595g.setTint(i11);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f16595g.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f16595g.setTintMode(mode);
        }
    }

    public i(j jVar, Resources resources) {
        super(jVar, resources);
        g();
    }
}
