package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f4537a;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    public static class C0003a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public a(ActionBarContainer actionBarContainer) {
        this.f4537a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f4537a;
        if (actionBarContainer.f4222i) {
            Drawable drawable = actionBarContainer.f4221h;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f4219f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f4537a;
        Drawable drawable3 = actionBarContainer2.f4220g;
        if (drawable3 != null && actionBarContainer2.f4223j) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f4537a;
        if (!actionBarContainer.f4222i) {
            Drawable drawable = actionBarContainer.f4219f;
            if (drawable != null) {
                C0003a.a(drawable, outline);
            }
        } else if (actionBarContainer.f4221h != null) {
            C0003a.a(actionBarContainer.f4219f, outline);
        }
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
