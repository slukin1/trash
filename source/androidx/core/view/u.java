package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public int f8682a;

    /* renamed from: b  reason: collision with root package name */
    public int f8683b;

    public u(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f8682a | this.f8683b;
    }

    public void b(View view, View view2, int i11) {
        c(view, view2, i11, 0);
    }

    public void c(View view, View view2, int i11, int i12) {
        if (i12 == 1) {
            this.f8683b = i11;
        } else {
            this.f8682a = i11;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i11) {
        if (i11 == 1) {
            this.f8683b = 0;
        } else {
            this.f8682a = 0;
        }
    }
}
