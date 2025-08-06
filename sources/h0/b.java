package h0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

public class b implements e {
    public void a(d dVar, float f11) {
        p(dVar).h(f11);
    }

    public void b(d dVar, float f11) {
        dVar.f().setElevation(f11);
    }

    public void c(d dVar, ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    public float d(d dVar) {
        return i(dVar) * 2.0f;
    }

    public float e(d dVar) {
        return i(dVar) * 2.0f;
    }

    public void f(d dVar, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        dVar.c(new f(colorStateList, f11));
        View f14 = dVar.f();
        f14.setClipToOutline(true);
        f14.setElevation(f12);
        j(dVar, f13);
    }

    public void g(d dVar) {
        j(dVar, l(dVar));
    }

    public void h(d dVar) {
        if (!dVar.a()) {
            dVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float l11 = l(dVar);
        float i11 = i(dVar);
        int ceil = (int) Math.ceil((double) g.c(l11, i11, dVar.e()));
        int ceil2 = (int) Math.ceil((double) g.d(l11, i11, dVar.e()));
        dVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public float i(d dVar) {
        return p(dVar).d();
    }

    public void j(d dVar, float f11) {
        p(dVar).g(f11, dVar.a(), dVar.e());
        h(dVar);
    }

    public void k() {
    }

    public float l(d dVar) {
        return p(dVar).c();
    }

    public void m(d dVar) {
        j(dVar, l(dVar));
    }

    public ColorStateList n(d dVar) {
        return p(dVar).b();
    }

    public float o(d dVar) {
        return dVar.f().getElevation();
    }

    public final f p(d dVar) {
        return (f) dVar.d();
    }
}
