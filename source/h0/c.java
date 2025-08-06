package h0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import h0.g;

public class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f15868a = new RectF();

    public class a implements g.a {
        public a() {
        }

        public void a(Canvas canvas, RectF rectF, float f11, Paint paint) {
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            float f12 = 2.0f * f11;
            float width = (rectF.width() - f12) - 1.0f;
            float height = (rectF.height() - f12) - 1.0f;
            if (f11 >= 1.0f) {
                float f13 = f11 + 0.5f;
                float f14 = -f13;
                c.this.f15868a.set(f14, f14, f13, f13);
                int save = canvas.save();
                canvas2.translate(rectF2.left + f13, rectF2.top + f13);
                Paint paint2 = paint;
                canvas.drawArc(c.this.f15868a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(c.this.f15868a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(height, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(c.this.f15868a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(c.this.f15868a, 180.0f, 90.0f, true, paint2);
                canvas2.restoreToCount(save);
                float f15 = rectF2.top;
                canvas.drawRect((rectF2.left + f13) - 1.0f, f15, (rectF2.right - f13) + 1.0f, f15 + f13, paint2);
                float f16 = rectF2.bottom;
                Canvas canvas3 = canvas;
                canvas3.drawRect((rectF2.left + f13) - 1.0f, f16 - f13, (rectF2.right - f13) + 1.0f, f16, paint2);
            }
            canvas.drawRect(rectF2.left, rectF2.top + f11, rectF2.right, rectF2.bottom - f11, paint);
        }
    }

    public void a(d dVar, float f11) {
        q(dVar).p(f11);
        h(dVar);
    }

    public void b(d dVar, float f11) {
        q(dVar).r(f11);
    }

    public void c(d dVar, ColorStateList colorStateList) {
        q(dVar).o(colorStateList);
    }

    public float d(d dVar) {
        return q(dVar).j();
    }

    public float e(d dVar) {
        return q(dVar).k();
    }

    public void f(d dVar, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        g p11 = p(context, colorStateList, f11, f12, f13);
        p11.m(dVar.e());
        dVar.c(p11);
        h(dVar);
    }

    public void g(d dVar) {
    }

    public void h(d dVar) {
        Rect rect = new Rect();
        q(dVar).h(rect);
        dVar.b((int) Math.ceil((double) e(dVar)), (int) Math.ceil((double) d(dVar)));
        dVar.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float i(d dVar) {
        return q(dVar).g();
    }

    public void j(d dVar, float f11) {
        q(dVar).q(f11);
        h(dVar);
    }

    public void k() {
        g.f15882r = new a();
    }

    public float l(d dVar) {
        return q(dVar).i();
    }

    public void m(d dVar) {
        q(dVar).m(dVar.e());
        h(dVar);
    }

    public ColorStateList n(d dVar) {
        return q(dVar).f();
    }

    public float o(d dVar) {
        return q(dVar).l();
    }

    public final g p(Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        return new g(context.getResources(), colorStateList, f11, f12, f13);
    }

    public final g q(d dVar) {
        return (g) dVar.d();
    }
}
