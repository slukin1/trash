package androidx.recyclerview.widget;

import androidx.core.util.e;
import androidx.core.util.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import java.util.ArrayList;
import java.util.List;

public final class a implements q.a {

    /* renamed from: a  reason: collision with root package name */
    public e<b> f10802a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f10803b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<b> f10804c;

    /* renamed from: d  reason: collision with root package name */
    public final C0054a f10805d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f10806e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f10807f;

    /* renamed from: g  reason: collision with root package name */
    public final q f10808g;

    /* renamed from: h  reason: collision with root package name */
    public int f10809h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    public interface C0054a {
        void a(int i11, int i12);

        void b(b bVar);

        void c(b bVar);

        RecyclerView.ViewHolder d(int i11);

        void e(int i11, int i12);

        void f(int i11, int i12);

        void g(int i11, int i12);

        void h(int i11, int i12, Object obj);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f10810a;

        /* renamed from: b  reason: collision with root package name */
        public int f10811b;

        /* renamed from: c  reason: collision with root package name */
        public Object f10812c;

        /* renamed from: d  reason: collision with root package name */
        public int f10813d;

        public b(int i11, int i12, int i13, Object obj) {
            this.f10810a = i11;
            this.f10811b = i12;
            this.f10813d = i13;
            this.f10812c = obj;
        }

        public String a() {
            int i11 = this.f10810a;
            if (i11 == 1) {
                return "add";
            }
            if (i11 == 2) {
                return "rm";
            }
            if (i11 != 4) {
                return i11 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i11 = this.f10810a;
            if (i11 != bVar.f10810a) {
                return false;
            }
            if (i11 == 8 && Math.abs(this.f10813d - this.f10811b) == 1 && this.f10813d == bVar.f10811b && this.f10811b == bVar.f10813d) {
                return true;
            }
            if (this.f10813d != bVar.f10813d || this.f10811b != bVar.f10811b) {
                return false;
            }
            Object obj2 = this.f10812c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f10812c)) {
                    return false;
                }
            } else if (bVar.f10812c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f10810a * 31) + this.f10811b) * 31) + this.f10813d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f10811b + "c:" + this.f10813d + ",p:" + this.f10812c + "]";
        }
    }

    public a(C0054a aVar) {
        this(aVar, false);
    }

    public b a(int i11, int i12, int i13, Object obj) {
        b acquire = this.f10802a.acquire();
        if (acquire == null) {
            return new b(i11, i12, i13, obj);
        }
        acquire.f10810a = i11;
        acquire.f10811b = i12;
        acquire.f10813d = i13;
        acquire.f10812c = obj;
        return acquire;
    }

    public void b(b bVar) {
        if (!this.f10807f) {
            bVar.f10812c = null;
            this.f10802a.release(bVar);
        }
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i11) {
        int size = this.f10803b.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f10803b.get(i12);
            int i13 = bVar.f10810a;
            if (i13 != 1) {
                if (i13 == 2) {
                    int i14 = bVar.f10811b;
                    if (i14 <= i11) {
                        int i15 = bVar.f10813d;
                        if (i14 + i15 > i11) {
                            return -1;
                        }
                        i11 -= i15;
                    } else {
                        continue;
                    }
                } else if (i13 == 8) {
                    int i16 = bVar.f10811b;
                    if (i16 == i11) {
                        i11 = bVar.f10813d;
                    } else {
                        if (i16 < i11) {
                            i11--;
                        }
                        if (bVar.f10813d <= i11) {
                            i11++;
                        }
                    }
                }
            } else if (bVar.f10811b <= i11) {
                i11 += bVar.f10813d;
            }
        }
        return i11;
    }

    public final void f(b bVar) {
        char c11;
        boolean z11;
        boolean z12;
        int i11 = bVar.f10811b;
        int i12 = bVar.f10813d + i11;
        char c12 = 65535;
        int i13 = i11;
        int i14 = 0;
        while (i13 < i12) {
            if (this.f10805d.d(i13) != null || h(i13)) {
                if (c12 == 0) {
                    k(a(2, i11, i14, (Object) null));
                    z12 = true;
                } else {
                    z12 = false;
                }
                c11 = 1;
            } else {
                if (c12 == 1) {
                    v(a(2, i11, i14, (Object) null));
                    z11 = true;
                } else {
                    z11 = false;
                }
                c11 = 0;
            }
            if (z11) {
                i13 -= i14;
                i12 -= i14;
                i14 = 1;
            } else {
                i14++;
            }
            i13++;
            c12 = c11;
        }
        if (i14 != bVar.f10813d) {
            b(bVar);
            bVar = a(2, i11, i14, (Object) null);
        }
        if (c12 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i11 = bVar.f10811b;
        int i12 = bVar.f10813d + i11;
        int i13 = 0;
        boolean z11 = true;
        int i14 = i11;
        while (i11 < i12) {
            if (this.f10805d.d(i11) != null || h(i11)) {
                if (!z11) {
                    k(a(4, i14, i13, bVar.f10812c));
                    i14 = i11;
                    i13 = 0;
                }
                z11 = true;
            } else {
                if (z11) {
                    v(a(4, i14, i13, bVar.f10812c));
                    i14 = i11;
                    i13 = 0;
                }
                z11 = false;
            }
            i13++;
            i11++;
        }
        if (i13 != bVar.f10813d) {
            Object obj = bVar.f10812c;
            b(bVar);
            bVar = a(4, i14, i13, obj);
        }
        if (!z11) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i11) {
        int size = this.f10804c.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = this.f10804c.get(i12);
            int i13 = bVar.f10810a;
            if (i13 == 8) {
                if (n(bVar.f10813d, i12 + 1) == i11) {
                    return true;
                }
            } else if (i13 == 1) {
                int i14 = bVar.f10811b;
                int i15 = bVar.f10813d + i14;
                while (i14 < i15) {
                    if (n(i14, i12 + 1) == i11) {
                        return true;
                    }
                    i14++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f10804c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f10805d.c(this.f10804c.get(i11));
        }
        x(this.f10804c);
        this.f10809h = 0;
    }

    public void j() {
        i();
        int size = this.f10803b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f10803b.get(i11);
            int i12 = bVar.f10810a;
            if (i12 == 1) {
                this.f10805d.c(bVar);
                this.f10805d.e(bVar.f10811b, bVar.f10813d);
            } else if (i12 == 2) {
                this.f10805d.c(bVar);
                this.f10805d.f(bVar.f10811b, bVar.f10813d);
            } else if (i12 == 4) {
                this.f10805d.c(bVar);
                this.f10805d.h(bVar.f10811b, bVar.f10813d, bVar.f10812c);
            } else if (i12 == 8) {
                this.f10805d.c(bVar);
                this.f10805d.a(bVar.f10811b, bVar.f10813d);
            }
            Runnable runnable = this.f10806e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f10803b);
        this.f10809h = 0;
    }

    public final void k(b bVar) {
        int i11;
        int i12 = bVar.f10810a;
        if (i12 == 1 || i12 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z11 = z(bVar.f10811b, i12);
        int i13 = bVar.f10811b;
        int i14 = bVar.f10810a;
        if (i14 == 2) {
            i11 = 0;
        } else if (i14 == 4) {
            i11 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i15 = 1;
        for (int i16 = 1; i16 < bVar.f10813d; i16++) {
            int z12 = z(bVar.f10811b + (i11 * i16), bVar.f10810a);
            int i17 = bVar.f10810a;
            if (i17 == 2 ? z12 == z11 : i17 == 4 && z12 == z11 + 1) {
                i15++;
            } else {
                b a11 = a(i17, z11, i15, bVar.f10812c);
                l(a11, i13);
                b(a11);
                if (bVar.f10810a == 4) {
                    i13 += i15;
                }
                i15 = 1;
                z11 = z12;
            }
        }
        Object obj = bVar.f10812c;
        b(bVar);
        if (i15 > 0) {
            b a12 = a(bVar.f10810a, z11, i15, obj);
            l(a12, i13);
            b(a12);
        }
    }

    public void l(b bVar, int i11) {
        this.f10805d.b(bVar);
        int i12 = bVar.f10810a;
        if (i12 == 2) {
            this.f10805d.f(i11, bVar.f10813d);
        } else if (i12 == 4) {
            this.f10805d.h(i11, bVar.f10813d, bVar.f10812c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int m(int i11) {
        return n(i11, 0);
    }

    public int n(int i11, int i12) {
        int size = this.f10804c.size();
        while (i12 < size) {
            b bVar = this.f10804c.get(i12);
            int i13 = bVar.f10810a;
            if (i13 == 8) {
                int i14 = bVar.f10811b;
                if (i14 == i11) {
                    i11 = bVar.f10813d;
                } else {
                    if (i14 < i11) {
                        i11--;
                    }
                    if (bVar.f10813d <= i11) {
                        i11++;
                    }
                }
            } else {
                int i15 = bVar.f10811b;
                if (i15 > i11) {
                    continue;
                } else if (i13 == 2) {
                    int i16 = bVar.f10813d;
                    if (i11 < i15 + i16) {
                        return -1;
                    }
                    i11 -= i16;
                } else if (i13 == 1) {
                    i11 += bVar.f10813d;
                }
            }
            i12++;
        }
        return i11;
    }

    public boolean o(int i11) {
        return (i11 & this.f10809h) != 0;
    }

    public boolean p() {
        return this.f10803b.size() > 0;
    }

    public boolean q() {
        return !this.f10804c.isEmpty() && !this.f10803b.isEmpty();
    }

    public boolean r(int i11, int i12, Object obj) {
        if (i12 < 1) {
            return false;
        }
        this.f10803b.add(a(4, i11, i12, obj));
        this.f10809h |= 4;
        if (this.f10803b.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean s(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f10803b.add(a(1, i11, i12, (Object) null));
        this.f10809h |= 1;
        if (this.f10803b.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean t(int i11, int i12, int i13) {
        if (i11 == i12) {
            return false;
        }
        if (i13 == 1) {
            this.f10803b.add(a(8, i11, i12, (Object) null));
            this.f10809h |= 8;
            if (this.f10803b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean u(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f10803b.add(a(2, i11, i12, (Object) null));
        this.f10809h |= 2;
        if (this.f10803b.size() == 1) {
            return true;
        }
        return false;
    }

    public final void v(b bVar) {
        this.f10804c.add(bVar);
        int i11 = bVar.f10810a;
        if (i11 == 1) {
            this.f10805d.e(bVar.f10811b, bVar.f10813d);
        } else if (i11 == 2) {
            this.f10805d.g(bVar.f10811b, bVar.f10813d);
        } else if (i11 == 4) {
            this.f10805d.h(bVar.f10811b, bVar.f10813d, bVar.f10812c);
        } else if (i11 == 8) {
            this.f10805d.a(bVar.f10811b, bVar.f10813d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void w() {
        this.f10808g.b(this.f10803b);
        int size = this.f10803b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f10803b.get(i11);
            int i12 = bVar.f10810a;
            if (i12 == 1) {
                c(bVar);
            } else if (i12 == 2) {
                f(bVar);
            } else if (i12 == 4) {
                g(bVar);
            } else if (i12 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f10806e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f10803b.clear();
    }

    public void x(List<b> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            b(list.get(i11));
        }
        list.clear();
    }

    public void y() {
        x(this.f10803b);
        x(this.f10804c);
        this.f10809h = 0;
    }

    public final int z(int i11, int i12) {
        int i13;
        int i14;
        for (int size = this.f10804c.size() - 1; size >= 0; size--) {
            b bVar = this.f10804c.get(size);
            int i15 = bVar.f10810a;
            if (i15 == 8) {
                int i16 = bVar.f10811b;
                int i17 = bVar.f10813d;
                if (i16 < i17) {
                    i14 = i16;
                    i13 = i17;
                } else {
                    i13 = i16;
                    i14 = i17;
                }
                if (i11 < i14 || i11 > i13) {
                    if (i11 < i16) {
                        if (i12 == 1) {
                            bVar.f10811b = i16 + 1;
                            bVar.f10813d = i17 + 1;
                        } else if (i12 == 2) {
                            bVar.f10811b = i16 - 1;
                            bVar.f10813d = i17 - 1;
                        }
                    }
                } else if (i14 == i16) {
                    if (i12 == 1) {
                        bVar.f10813d = i17 + 1;
                    } else if (i12 == 2) {
                        bVar.f10813d = i17 - 1;
                    }
                    i11++;
                } else {
                    if (i12 == 1) {
                        bVar.f10811b = i16 + 1;
                    } else if (i12 == 2) {
                        bVar.f10811b = i16 - 1;
                    }
                    i11--;
                }
            } else {
                int i18 = bVar.f10811b;
                if (i18 <= i11) {
                    if (i15 == 1) {
                        i11 -= bVar.f10813d;
                    } else if (i15 == 2) {
                        i11 += bVar.f10813d;
                    }
                } else if (i12 == 1) {
                    bVar.f10811b = i18 + 1;
                } else if (i12 == 2) {
                    bVar.f10811b = i18 - 1;
                }
            }
        }
        for (int size2 = this.f10804c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f10804c.get(size2);
            if (bVar2.f10810a == 8) {
                int i19 = bVar2.f10813d;
                if (i19 == bVar2.f10811b || i19 < 0) {
                    this.f10804c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f10813d <= 0) {
                this.f10804c.remove(size2);
                b(bVar2);
            }
        }
        return i11;
    }

    public a(C0054a aVar, boolean z11) {
        this.f10802a = new f(30);
        this.f10803b = new ArrayList<>();
        this.f10804c = new ArrayList<>();
        this.f10809h = 0;
        this.f10805d = aVar;
        this.f10807f = z11;
        this.f10808g = new q(this);
    }
}
