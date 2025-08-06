package qe;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import re.a;

public class g extends a {

    /* renamed from: h  reason: collision with root package name */
    public RectF f25614h = new RectF();

    public g(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    public void a(Canvas canvas) {
        int h11 = c().h();
        if (h11 <= 1) {
            return;
        }
        if (!h() || c().j() == 0) {
            for (int i11 = 0; i11 < h11; i11++) {
                if (c().j() == 4) {
                    p(canvas, i11);
                } else {
                    n(canvas, i11);
                }
            }
            return;
        }
        r(canvas, h11);
        k(canvas);
    }

    public final void k(Canvas canvas) {
        e().setColor(c().a());
        int j11 = c().j();
        if (j11 == 2) {
            q(canvas);
        } else if (j11 == 3) {
            s(canvas);
        } else if (j11 == 5) {
            l(canvas);
        }
    }

    public final void l(Canvas canvas) {
        int c11 = c().c();
        float k11 = c().k();
        float f11 = (float) c11;
        float g11 = (g() * f11) + (f11 * c().l());
        Object obj = null;
        if (((double) k11) < 0.99d) {
            ArgbEvaluator b11 = b();
            e().setColor(((Integer) (b11 != null ? b11.evaluate(k11, Integer.valueOf(c().a()), Integer.valueOf(c().e())) : null)).intValue());
            this.f25614h.set(g11, 0.0f, g() + g11, c().m());
            o(canvas, c().m(), c().m());
        }
        float l11 = g11 + c().l() + c().f();
        if (c11 == c().h() - 1) {
            l11 = 0.0f;
        }
        ArgbEvaluator b12 = b();
        if (b12 != null) {
            obj = b12.evaluate(((float) 1) - k11, Integer.valueOf(c().a()), Integer.valueOf(c().e()));
        }
        e().setColor(((Integer) obj).intValue());
        this.f25614h.set(l11, 0.0f, g() + l11, c().m());
        o(canvas, c().m(), c().m());
    }

    public void m(Canvas canvas) {
    }

    public final void n(Canvas canvas, int i11) {
        int e11 = c().e();
        float l11 = c().l();
        float m11 = c().m();
        int c11 = c().c();
        if (i11 < c11) {
            e().setColor(e11);
            float f11 = (float) i11;
            float g11 = (g() * f11) + (f11 * l11);
            this.f25614h.set(g11, 0.0f, g() + g11, m11);
            o(canvas, m11, m11);
        } else if (i11 == c11) {
            e().setColor(c().a());
            float f12 = (float) i11;
            float g12 = (g() * f12) + (f12 * l11);
            this.f25614h.set(g12, 0.0f, g() + g12 + (f() - g()), m11);
            o(canvas, m11, m11);
        } else {
            e().setColor(e11);
            float f13 = (float) i11;
            float g13 = (g() * f13) + (f13 * l11) + (f() - g());
            this.f25614h.set(g13, 0.0f, g() + g13, m11);
            o(canvas, m11, m11);
        }
    }

    public void o(Canvas canvas, float f11, float f12) {
        m(canvas);
    }

    public final void p(Canvas canvas, int i11) {
        float f11;
        Canvas canvas2 = canvas;
        int i12 = i11;
        int a11 = c().a();
        float l11 = c().l();
        float m11 = c().m();
        int c11 = c().c();
        float f12 = c().f();
        float b11 = c().b();
        boolean z11 = true;
        if (i12 < c11) {
            e().setColor(c().e());
            if (c11 == c().h() - 1) {
                float f13 = (float) i12;
                f11 = (f13 * f12) + (f13 * l11) + ((b11 - f12) * c().k());
            } else {
                float f14 = (float) i12;
                f11 = (f14 * f12) + (f14 * l11);
            }
            this.f25614h.set(f11, 0.0f, f12 + f11, m11);
            o(canvas2, m11, m11);
        } else if (i12 == c11) {
            e().setColor(a11);
            float k11 = c().k();
            if (c11 == c().h() - 1) {
                ArgbEvaluator b12 = b();
                e().setColor(((Integer) (b12 != null ? b12.evaluate(k11, Integer.valueOf(a11), Integer.valueOf(c().e())) : null)).intValue());
                float h11 = (((float) (c().h() - 1)) * (c().l() + f12)) + b11;
                this.f25614h.set((h11 - b11) + ((b11 - f12) * k11), 0.0f, h11, m11);
                o(canvas2, m11, m11);
            } else if (k11 < 1.0f) {
                ArgbEvaluator b13 = b();
                e().setColor(((Integer) (b13 != null ? b13.evaluate(k11, Integer.valueOf(a11), Integer.valueOf(c().e())) : null)).intValue());
                float f15 = (float) i12;
                float f16 = (f15 * f12) + (f15 * l11);
                this.f25614h.set(f16, 0.0f, f16 + f12 + ((b11 - f12) * (((float) 1) - k11)), m11);
                o(canvas2, m11, m11);
            }
            if (c11 == c().h() - 1) {
                if (k11 > 0.0f) {
                    ArgbEvaluator b14 = b();
                    e().setColor(((Integer) (b14 != null ? b14.evaluate(((float) 1) - k11, Integer.valueOf(a11), Integer.valueOf(c().e())) : null)).intValue());
                    this.f25614h.set(0.0f, 0.0f, f12 + 0.0f + ((b11 - f12) * k11), m11);
                    o(canvas2, m11, m11);
                }
            } else if (k11 > 0.0f) {
                ArgbEvaluator b15 = b();
                e().setColor(((Integer) (b15 != null ? b15.evaluate(((float) 1) - k11, Integer.valueOf(a11), Integer.valueOf(c().e())) : null)).intValue());
                float f17 = (float) i12;
                float f18 = (f17 * f12) + (f17 * l11) + f12 + l11 + b11;
                this.f25614h.set((f18 - f12) - ((b11 - f12) * k11), 0.0f, f18, m11);
                o(canvas2, m11, m11);
            }
        } else {
            if (c11 + 1 == i12) {
                if (c().k() != 0.0f) {
                    z11 = false;
                }
                if (!z11) {
                    return;
                }
            }
            e().setColor(c().e());
            float f19 = (float) i12;
            float g11 = (g() * f19) + (f19 * l11) + (b11 - g());
            this.f25614h.set(g11, 0.0f, g() + g11, m11);
            o(canvas2, m11, m11);
        }
    }

    public final void q(Canvas canvas) {
        int c11 = c().c();
        float l11 = c().l();
        float m11 = c().m();
        float f11 = (float) c11;
        float f12 = (f() * f11) + (f11 * l11) + ((f() + l11) * c().k());
        this.f25614h.set(f12, 0.0f, f() + f12, m11);
        o(canvas, m11, m11);
    }

    public final void r(Canvas canvas, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            e().setColor(c().e());
            float m11 = c().m();
            float f11 = (float) i12;
            float f12 = (f() * f11) + (f11 * c().l()) + (f() - g());
            this.f25614h.set(f12, 0.0f, g() + f12, m11);
            o(canvas, m11, m11);
        }
    }

    public final void s(Canvas canvas) {
        float m11 = c().m();
        float k11 = c().k();
        int c11 = c().c();
        float l11 = c().l() + c().f();
        float b11 = a.f25625a.b(c(), f(), c11);
        float f11 = (float) 2;
        float min = b11 + Math.min(k11 * l11 * 2.0f, l11) + (c().f() / f11);
        this.f25614h.set((Math.max(((k11 - 0.5f) * l11) * 2.0f, 0.0f) + b11) - (c().f() / f11), 0.0f, min, m11);
        o(canvas, m11, m11);
    }

    public final RectF t() {
        return this.f25614h;
    }
}
