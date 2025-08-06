package v1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public Context f16656a;

    /* renamed from: b  reason: collision with root package name */
    public int f16657b = -1;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f16658c;

    /* renamed from: d  reason: collision with root package name */
    public View f16659d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f16660e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f16661f;

    public k(ViewGroup viewGroup, View view) {
        this.f16658c = viewGroup;
        this.f16659d = view;
    }

    public static k c(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(R$id.transition_current_scene);
    }

    public static void f(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(R$id.transition_current_scene, kVar);
    }

    public void a() {
        if (this.f16657b > 0 || this.f16659d != null) {
            d().removeAllViews();
            if (this.f16657b > 0) {
                LayoutInflater.from(this.f16656a).inflate(this.f16657b, this.f16658c);
            } else {
                this.f16658c.addView(this.f16659d);
            }
        }
        Runnable runnable = this.f16660e;
        if (runnable != null) {
            runnable.run();
        }
        f(this.f16658c, this);
    }

    public void b() {
        Runnable runnable;
        if (c(this.f16658c) == this && (runnable = this.f16661f) != null) {
            runnable.run();
        }
    }

    public ViewGroup d() {
        return this.f16658c;
    }

    public boolean e() {
        return this.f16657b > 0;
    }
}
