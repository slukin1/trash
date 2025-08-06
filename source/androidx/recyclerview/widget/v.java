package androidx.recyclerview.widget;

import android.view.View;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final b f10919a;

    /* renamed from: b  reason: collision with root package name */
    public a f10920b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f10921a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f10922b;

        /* renamed from: c  reason: collision with root package name */
        public int f10923c;

        /* renamed from: d  reason: collision with root package name */
        public int f10924d;

        /* renamed from: e  reason: collision with root package name */
        public int f10925e;

        public void a(int i11) {
            this.f10921a = i11 | this.f10921a;
        }

        public boolean b() {
            int i11 = this.f10921a;
            if ((i11 & 7) != 0 && (i11 & (c(this.f10924d, this.f10922b) << 0)) == 0) {
                return false;
            }
            int i12 = this.f10921a;
            if ((i12 & 112) != 0 && (i12 & (c(this.f10924d, this.f10923c) << 4)) == 0) {
                return false;
            }
            int i13 = this.f10921a;
            if ((i13 & Params.POLY_BYTES) != 0 && (i13 & (c(this.f10925e, this.f10922b) << 8)) == 0) {
                return false;
            }
            int i14 = this.f10921a;
            if ((i14 & 28672) == 0 || (i14 & (c(this.f10925e, this.f10923c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int c(int i11, int i12) {
            if (i11 > i12) {
                return 1;
            }
            return i11 == i12 ? 2 : 4;
        }

        public void d() {
            this.f10921a = 0;
        }

        public void e(int i11, int i12, int i13, int i14) {
            this.f10922b = i11;
            this.f10923c = i12;
            this.f10924d = i13;
            this.f10925e = i14;
        }
    }

    public interface b {
        View a(int i11);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    public v(b bVar) {
        this.f10919a = bVar;
    }

    public View a(int i11, int i12, int i13, int i14) {
        int b11 = this.f10919a.b();
        int c11 = this.f10919a.c();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        while (i11 != i12) {
            View a11 = this.f10919a.a(i11);
            this.f10920b.e(b11, c11, this.f10919a.d(a11), this.f10919a.e(a11));
            if (i13 != 0) {
                this.f10920b.d();
                this.f10920b.a(i13);
                if (this.f10920b.b()) {
                    return a11;
                }
            }
            if (i14 != 0) {
                this.f10920b.d();
                this.f10920b.a(i14);
                if (this.f10920b.b()) {
                    view = a11;
                }
            }
            i11 += i15;
        }
        return view;
    }

    public boolean b(View view, int i11) {
        this.f10920b.e(this.f10919a.b(), this.f10919a.c(), this.f10919a.d(view), this.f10919a.e(view));
        if (i11 == 0) {
            return false;
        }
        this.f10920b.d();
        this.f10920b.a(i11);
        return this.f10920b.b();
    }
}
