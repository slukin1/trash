package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final b f10845a;

    /* renamed from: b  reason: collision with root package name */
    public final a f10846b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f10847c = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f10848a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f10849b;

        public void a(int i11) {
            if (i11 >= 64) {
                a aVar = this.f10849b;
                if (aVar != null) {
                    aVar.a(i11 - 64);
                    return;
                }
                return;
            }
            this.f10848a &= ~(1 << i11);
        }

        public int b(int i11) {
            a aVar = this.f10849b;
            if (aVar == null) {
                if (i11 >= 64) {
                    return Long.bitCount(this.f10848a);
                }
                return Long.bitCount(this.f10848a & ((1 << i11) - 1));
            } else if (i11 < 64) {
                return Long.bitCount(this.f10848a & ((1 << i11) - 1));
            } else {
                return aVar.b(i11 - 64) + Long.bitCount(this.f10848a);
            }
        }

        public final void c() {
            if (this.f10849b == null) {
                this.f10849b = new a();
            }
        }

        public boolean d(int i11) {
            if (i11 < 64) {
                return (this.f10848a & (1 << i11)) != 0;
            }
            c();
            return this.f10849b.d(i11 - 64);
        }

        public void e(int i11, boolean z11) {
            if (i11 >= 64) {
                c();
                this.f10849b.e(i11 - 64, z11);
                return;
            }
            long j11 = this.f10848a;
            boolean z12 = (Long.MIN_VALUE & j11) != 0;
            long j12 = (1 << i11) - 1;
            this.f10848a = ((j11 & (~j12)) << 1) | (j11 & j12);
            if (z11) {
                h(i11);
            } else {
                a(i11);
            }
            if (z12 || this.f10849b != null) {
                c();
                this.f10849b.e(0, z12);
            }
        }

        public boolean f(int i11) {
            if (i11 >= 64) {
                c();
                return this.f10849b.f(i11 - 64);
            }
            long j11 = 1 << i11;
            long j12 = this.f10848a;
            boolean z11 = (j12 & j11) != 0;
            long j13 = j12 & (~j11);
            this.f10848a = j13;
            long j14 = j11 - 1;
            this.f10848a = (j13 & j14) | Long.rotateRight((~j14) & j13, 1);
            a aVar = this.f10849b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f10849b.f(0);
            }
            return z11;
        }

        public void g() {
            this.f10848a = 0;
            a aVar = this.f10849b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i11) {
            if (i11 >= 64) {
                c();
                this.f10849b.h(i11 - 64);
                return;
            }
            this.f10848a |= 1 << i11;
        }

        public String toString() {
            if (this.f10849b == null) {
                return Long.toBinaryString(this.f10848a);
            }
            return this.f10849b.toString() + "xx" + Long.toBinaryString(this.f10848a);
        }
    }

    public interface b {
        View a(int i11);

        void addView(View view, int i11);

        void b(View view);

        int c();

        RecyclerView.ViewHolder d(View view);

        void e(View view, int i11, ViewGroup.LayoutParams layoutParams);

        void f(int i11);

        int g(View view);

        void h(View view);

        void removeAllViews();

        void removeViewAt(int i11);
    }

    public f(b bVar) {
        this.f10845a = bVar;
    }

    public void a(View view, int i11, boolean z11) {
        int i12;
        if (i11 < 0) {
            i12 = this.f10845a.c();
        } else {
            i12 = h(i11);
        }
        this.f10846b.e(i12, z11);
        if (z11) {
            l(view);
        }
        this.f10845a.addView(view, i12);
    }

    public void b(View view, boolean z11) {
        a(view, -1, z11);
    }

    public void c(View view, int i11, ViewGroup.LayoutParams layoutParams, boolean z11) {
        int i12;
        if (i11 < 0) {
            i12 = this.f10845a.c();
        } else {
            i12 = h(i11);
        }
        this.f10846b.e(i12, z11);
        if (z11) {
            l(view);
        }
        this.f10845a.e(view, i12, layoutParams);
    }

    public void d(int i11) {
        int h11 = h(i11);
        this.f10846b.f(h11);
        this.f10845a.f(h11);
    }

    public View e(int i11) {
        int size = this.f10847c.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = this.f10847c.get(i12);
            RecyclerView.ViewHolder d11 = this.f10845a.d(view);
            if (d11.getLayoutPosition() == i11 && !d11.isInvalid() && !d11.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i11) {
        return this.f10845a.a(h(i11));
    }

    public int g() {
        return this.f10845a.c() - this.f10847c.size();
    }

    public final int h(int i11) {
        if (i11 < 0) {
            return -1;
        }
        int c11 = this.f10845a.c();
        int i12 = i11;
        while (i12 < c11) {
            int b11 = i11 - (i12 - this.f10846b.b(i12));
            if (b11 == 0) {
                while (this.f10846b.d(i12)) {
                    i12++;
                }
                return i12;
            }
            i12 += b11;
        }
        return -1;
    }

    public View i(int i11) {
        return this.f10845a.a(i11);
    }

    public int j() {
        return this.f10845a.c();
    }

    public void k(View view) {
        int g11 = this.f10845a.g(view);
        if (g11 >= 0) {
            this.f10846b.h(g11);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final void l(View view) {
        this.f10847c.add(view);
        this.f10845a.b(view);
    }

    public int m(View view) {
        int g11 = this.f10845a.g(view);
        if (g11 != -1 && !this.f10846b.d(g11)) {
            return g11 - this.f10846b.b(g11);
        }
        return -1;
    }

    public boolean n(View view) {
        return this.f10847c.contains(view);
    }

    public void o() {
        this.f10846b.g();
        for (int size = this.f10847c.size() - 1; size >= 0; size--) {
            this.f10845a.h(this.f10847c.get(size));
            this.f10847c.remove(size);
        }
        this.f10845a.removeAllViews();
    }

    public void p(View view) {
        int g11 = this.f10845a.g(view);
        if (g11 >= 0) {
            if (this.f10846b.f(g11)) {
                t(view);
            }
            this.f10845a.removeViewAt(g11);
        }
    }

    public void q(int i11) {
        int h11 = h(i11);
        View a11 = this.f10845a.a(h11);
        if (a11 != null) {
            if (this.f10846b.f(h11)) {
                t(a11);
            }
            this.f10845a.removeViewAt(h11);
        }
    }

    public boolean r(View view) {
        int g11 = this.f10845a.g(view);
        if (g11 == -1) {
            t(view);
            return true;
        } else if (!this.f10846b.d(g11)) {
            return false;
        } else {
            this.f10846b.f(g11);
            t(view);
            this.f10845a.removeViewAt(g11);
            return true;
        }
    }

    public void s(View view) {
        int g11 = this.f10845a.g(view);
        if (g11 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f10846b.d(g11)) {
            this.f10846b.a(g11);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f10847c.remove(view)) {
            return false;
        }
        this.f10845a.h(view);
        return true;
    }

    public String toString() {
        return this.f10846b.toString() + ", hidden list:" + this.f10847c.size();
    }
}
