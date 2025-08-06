package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final EdgeEffect f8730a;

    public static class a {
        public static void a(EdgeEffect edgeEffect, float f11, float f12) {
            edgeEffect.onPull(f11, f12);
        }
    }

    public static class b {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f11, float f12) {
            try {
                return edgeEffect.onPullDistance(f11, f12);
            } catch (Throwable unused) {
                edgeEffect.onPull(f11, f12);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public g(Context context) {
        this.f8730a = new EdgeEffect(context);
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.a(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float d(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void f(EdgeEffect edgeEffect, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(edgeEffect, f11, f12);
        } else {
            edgeEffect.onPull(f11);
        }
    }

    public static float h(EdgeEffect edgeEffect, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, f11, f12);
        }
        f(edgeEffect, f11, f12);
        return f11;
    }

    @Deprecated
    public boolean b(Canvas canvas) {
        return this.f8730a.draw(canvas);
    }

    @Deprecated
    public void c() {
        this.f8730a.finish();
    }

    @Deprecated
    public boolean e() {
        return this.f8730a.isFinished();
    }

    @Deprecated
    public boolean g(float f11) {
        this.f8730a.onPull(f11);
        return true;
    }

    @Deprecated
    public boolean i() {
        this.f8730a.onRelease();
        return this.f8730a.isFinished();
    }

    @Deprecated
    public void j(int i11, int i12) {
        this.f8730a.setSize(i11, i12);
    }
}
