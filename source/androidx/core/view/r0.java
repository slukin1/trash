package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    public final e f8674a;

    public static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Window f8675a;

        /* renamed from: b  reason: collision with root package name */
        public final c0 f8676b;

        public a(Window window, c0 c0Var) {
            this.f8675a = window;
            this.f8676b = c0Var;
        }

        public void a(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    f(i12);
                }
            }
        }

        public void d(int i11) {
            if (i11 == 0) {
                j(6144);
            } else if (i11 == 1) {
                j(4096);
                g(2048);
            } else if (i11 == 2) {
                j(2048);
                g(4096);
            }
        }

        public void e(int i11) {
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    i(i12);
                }
            }
        }

        public final void f(int i11) {
            if (i11 == 1) {
                g(4);
            } else if (i11 == 2) {
                g(2);
            } else if (i11 == 8) {
                this.f8676b.a();
            }
        }

        public void g(int i11) {
            View decorView = this.f8675a.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public void h(int i11) {
            this.f8675a.addFlags(i11);
        }

        public final void i(int i11) {
            if (i11 == 1) {
                j(4);
                k(1024);
            } else if (i11 == 2) {
                j(2);
            } else if (i11 == 8) {
                this.f8676b.b();
            }
        }

        public void j(int i11) {
            View decorView = this.f8675a.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        public void k(int i11) {
            this.f8675a.clearFlags(i11);
        }
    }

    public static class b extends a {
        public b(Window window, c0 c0Var) {
            super(window, c0Var);
        }

        public void c(boolean z11) {
            if (z11) {
                k(67108864);
                h(Integer.MIN_VALUE);
                g(8192);
                return;
            }
            j(8192);
        }
    }

    public static class c extends b {
        public c(Window window, c0 c0Var) {
            super(window, c0Var);
        }

        public void b(boolean z11) {
            if (z11) {
                k(134217728);
                h(Integer.MIN_VALUE);
                g(16);
                return;
            }
            j(16);
        }
    }

    public static class e {
        public void a(int i11) {
        }

        public void b(boolean z11) {
        }

        public void c(boolean z11) {
        }

        public void d(int i11) {
        }

        public void e(int i11) {
        }
    }

    public r0(Window window, View view) {
        c0 c0Var = new c0(view);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.f8674a = new d(window, this, c0Var);
        } else if (i11 >= 26) {
            this.f8674a = new c(window, c0Var);
        } else if (i11 >= 23) {
            this.f8674a = new b(window, c0Var);
        } else if (i11 >= 20) {
            this.f8674a = new a(window, c0Var);
        } else {
            this.f8674a = new e();
        }
    }

    public void a(int i11) {
        this.f8674a.a(i11);
    }

    public void b(boolean z11) {
        this.f8674a.b(z11);
    }

    public void c(boolean z11) {
        this.f8674a.c(z11);
    }

    public void d(int i11) {
        this.f8674a.d(i11);
    }

    public void e(int i11) {
        this.f8674a.e(i11);
    }

    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public final r0 f8677a;

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsetsController f8678b;

        /* renamed from: c  reason: collision with root package name */
        public final c0 f8679c;

        /* renamed from: d  reason: collision with root package name */
        public final SimpleArrayMap<Object, WindowInsetsController.OnControllableInsetsChangedListener> f8680d;

        /* renamed from: e  reason: collision with root package name */
        public Window f8681e;

        public d(Window window, r0 r0Var, c0 c0Var) {
            this(window.getInsetsController(), r0Var, c0Var);
            this.f8681e = window;
        }

        public void a(int i11) {
            if ((i11 & 8) != 0) {
                this.f8679c.a();
            }
            this.f8678b.hide(i11 & -9);
        }

        public void b(boolean z11) {
            if (z11) {
                if (this.f8681e != null) {
                    f(16);
                }
                this.f8678b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f8681e != null) {
                g(16);
            }
            this.f8678b.setSystemBarsAppearance(0, 16);
        }

        public void c(boolean z11) {
            if (z11) {
                if (this.f8681e != null) {
                    f(8192);
                }
                this.f8678b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f8681e != null) {
                g(8192);
            }
            this.f8678b.setSystemBarsAppearance(0, 8);
        }

        public void d(int i11) {
            this.f8678b.setSystemBarsBehavior(i11);
        }

        public void e(int i11) {
            if ((i11 & 8) != 0) {
                this.f8679c.b();
            }
            this.f8678b.show(i11 & -9);
        }

        public void f(int i11) {
            View decorView = this.f8681e.getDecorView();
            decorView.setSystemUiVisibility(i11 | decorView.getSystemUiVisibility());
        }

        public void g(int i11) {
            View decorView = this.f8681e.getDecorView();
            decorView.setSystemUiVisibility((~i11) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, r0 r0Var, c0 c0Var) {
            this.f8680d = new SimpleArrayMap<>();
            this.f8678b = windowInsetsController;
            this.f8677a = r0Var;
            this.f8679c = c0Var;
        }
    }
}
