package qe;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.hbg.module.libkt.custom.indicator.view.option.IndicatorOptions;
import re.a;

public final class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public final RectF f25611h = new RectF();

    public b(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    public void a(Canvas canvas) {
        int h11 = c().h();
        if (h11 > 1 || (c().i() && h11 == 1)) {
            n(canvas);
            p(canvas);
        }
    }

    public int i() {
        return ((int) f()) + 6;
    }

    public final void k(Canvas canvas, float f11, float f12, float f13) {
        canvas.drawCircle(f11, f12, f13, e());
    }

    public final void l(Canvas canvas) {
        int c11 = c().c();
        a aVar = a.f25625a;
        float b11 = aVar.b(c(), f(), c11);
        k(canvas, b11 + ((aVar.b(c(), f(), (c11 + 1) % c().h()) - b11) * c().k()), aVar.c(f()), c().b() / ((float) 2));
    }

    public final void m(Canvas canvas) {
        float f11;
        int c11 = c().c();
        float k11 = c().k();
        a aVar = a.f25625a;
        float b11 = aVar.b(c(), f(), c11);
        float c12 = aVar.c(f());
        ArgbEvaluator b12 = b();
        Object obj = null;
        e().setColor(((Integer) (b12 != null ? b12.evaluate(k11, Integer.valueOf(c().a()), Integer.valueOf(c().e())) : null)).intValue());
        float f12 = (float) 2;
        k(canvas, b11, c12, c().f() / f12);
        ArgbEvaluator b13 = b();
        if (b13 != null) {
            obj = b13.evaluate(((float) 1) - k11, Integer.valueOf(c().a()), Integer.valueOf(c().e()));
        }
        e().setColor(((Integer) obj).intValue());
        if (c11 == c().h() - 1) {
            f11 = aVar.b(c(), f(), 0);
        } else {
            f11 = c().f() + b11 + c().l();
        }
        k(canvas, f11, c12, c().b() / f12);
    }

    public final void n(Canvas canvas) {
        float f11 = c().f();
        e().setColor(c().e());
        int h11 = c().h();
        for (int i11 = 0; i11 < h11; i11++) {
            a aVar = a.f25625a;
            k(canvas, aVar.b(c(), f(), i11), aVar.c(f()), f11 / ((float) 2));
        }
    }

    public final void o(Canvas canvas) {
        int c11 = c().c();
        float k11 = c().k();
        a aVar = a.f25625a;
        float b11 = aVar.b(c(), f(), c11);
        float c12 = aVar.c(f());
        Object obj = null;
        if (k11 < 1.0f) {
            ArgbEvaluator b12 = b();
            e().setColor(((Integer) (b12 != null ? b12.evaluate(k11, Integer.valueOf(c().a()), Integer.valueOf(c().e())) : null)).intValue());
            float f11 = (float) 2;
            k(canvas, b11, c12, (c().b() / f11) - (((c().b() / f11) - (c().f() / f11)) * k11));
        }
        if (c11 == c().h() - 1) {
            ArgbEvaluator b13 = b();
            if (b13 != null) {
                obj = b13.evaluate(k11, Integer.valueOf(c().e()), Integer.valueOf(c().a()));
            }
            e().setColor(((Integer) obj).intValue());
            float f12 = (float) 2;
            k(canvas, f() / f12, c12, (g() / f12) + (((f() / f12) - (g() / f12)) * k11));
        } else if (k11 > 0.0f) {
            ArgbEvaluator b14 = b();
            if (b14 != null) {
                obj = b14.evaluate(k11, Integer.valueOf(c().e()), Integer.valueOf(c().a()));
            }
            e().setColor(((Integer) obj).intValue());
            float f13 = (float) 2;
            k(canvas, b11 + c().l() + c().f(), c12, (c().f() / f13) + (((c().b() / f13) - (c().f() / f13)) * k11));
        }
    }

    public final void p(Canvas canvas) {
        e().setColor(c().a());
        int j11 = c().j();
        if (j11 == 0 || j11 == 2) {
            l(canvas);
        } else if (j11 == 3) {
            q(canvas);
        } else if (j11 == 4) {
            o(canvas);
        } else if (j11 == 5) {
            m(canvas);
        }
    }

    public final void q(Canvas canvas) {
        float f11 = c().f();
        float k11 = c().k();
        int c11 = c().c();
        float l11 = c().l() + c().f();
        float b11 = a.f25625a.b(c(), f(), c11);
        float f12 = (float) 2;
        float min = b11 + Math.min(k11 * l11 * 2.0f, l11) + (c().f() / f12);
        this.f25611h.set((Math.max(((k11 - 0.5f) * l11) * 2.0f, 0.0f) + b11) - (c().f() / f12), 0.0f, min, f11);
        canvas.drawRoundRect(this.f25611h, f11, f11, e());
    }
}
