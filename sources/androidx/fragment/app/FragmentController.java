package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.core.util.h;

public class FragmentController {

    /* renamed from: a  reason: collision with root package name */
    public final FragmentHostCallback<?> f9553a;

    public FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f9553a = fragmentHostCallback;
    }

    public static FragmentController b(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) h.h(fragmentHostCallback, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f9553a;
        fragmentHostCallback.f9559f.o(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void c() {
        this.f9553a.f9559f.B();
    }

    public boolean d(MenuItem menuItem) {
        return this.f9553a.f9559f.E(menuItem);
    }

    public void e() {
        this.f9553a.f9559f.F();
    }

    public void f() {
        this.f9553a.f9559f.H();
    }

    public void g() {
        this.f9553a.f9559f.Q();
    }

    public void h() {
        this.f9553a.f9559f.U();
    }

    public void i() {
        this.f9553a.f9559f.V();
    }

    public void j() {
        this.f9553a.f9559f.X();
    }

    public boolean k() {
        return this.f9553a.f9559f.e0(true);
    }

    public FragmentManager l() {
        return this.f9553a.f9559f;
    }

    public void m() {
        this.f9553a.f9559f.g1();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f9553a.f9559f.D0().onCreateView(view, str, context, attributeSet);
    }
}
