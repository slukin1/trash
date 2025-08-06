package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.core.view.n0;

public interface q {
    void A(int i11);

    Menu B();

    n0 C(int i11, long j11);

    boolean D();

    ViewGroup E();

    void F(boolean z11);

    void G(ScrollingTabContainerView scrollingTabContainerView);

    void H(int i11);

    void I(int i11);

    void J(i.a aVar, e.a aVar2);

    void K(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    boolean L();

    CharSequence M();

    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    void e(Menu menu, i.a aVar);

    void f();

    boolean g();

    Context getContext();

    int getHeight();

    CharSequence getTitle();

    int getVisibility();

    boolean h();

    boolean i();

    void j(int i11);

    void k(CharSequence charSequence);

    int l();

    void m(int i11);

    int n();

    void o(int i11);

    void p();

    int q();

    void r(boolean z11);

    void s();

    void setBackgroundDrawable(Drawable drawable);

    void setIcon(int i11);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i11);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    View t();

    void u(Drawable drawable);

    int v();

    void w(View view);

    void x();

    void y(Drawable drawable);

    void z(CharSequence charSequence);
}
