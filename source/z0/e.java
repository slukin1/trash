package z0;

import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f16898a = new C0118e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f16899b = new C0118e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final d f16900c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f16901d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f16902e = new C0118e(a.f16904b, false);

    /* renamed from: f  reason: collision with root package name */
    public static final d f16903f = f.f16909b;

    public static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        public static final a f16904b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f16905a;

        public a(boolean z11) {
            this.f16905a = z11;
        }

        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            boolean z11 = false;
            while (i11 < i13) {
                int a11 = e.a(Character.getDirectionality(charSequence.charAt(i11)));
                if (a11 != 0) {
                    if (a11 != 1) {
                        continue;
                        i11++;
                    } else if (!this.f16905a) {
                        return 1;
                    }
                } else if (this.f16905a) {
                    return 0;
                }
                z11 = true;
                i11++;
            }
            if (z11) {
                return this.f16905a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public static final b f16906a = new b();

        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            int i14 = 2;
            while (i11 < i13 && i14 == 2) {
                i14 = e.b(Character.getDirectionality(charSequence.charAt(i11)));
                i11++;
            }
            return i14;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i11, int i12);
    }

    public static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        public final c f16907a;

        public d(c cVar) {
            this.f16907a = cVar;
        }

        public boolean a(CharSequence charSequence, int i11, int i12) {
            if (charSequence == null || i11 < 0 || i12 < 0 || charSequence.length() - i12 < i11) {
                throw new IllegalArgumentException();
            } else if (this.f16907a == null) {
                return b();
            } else {
                return c(charSequence, i11, i12);
            }
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i11, int i12) {
            int a11 = this.f16907a.a(charSequence, i11, i12);
            if (a11 == 0) {
                return true;
            }
            if (a11 != 1) {
                return b();
            }
            return false;
        }
    }

    /* renamed from: z0.e$e  reason: collision with other inner class name */
    public static class C0118e extends d {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16908b;

        public C0118e(c cVar, boolean z11) {
            super(cVar);
            this.f16908b = z11;
        }

        public boolean b() {
            return this.f16908b;
        }
    }

    public static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        public static final f f16909b = new f();

        public f() {
            super((c) null);
        }

        public boolean b() {
            return f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f16906a;
        f16900c = new C0118e(bVar, false);
        f16901d = new C0118e(bVar, true);
    }

    public static int a(int i11) {
        if (i11 != 0) {
            return (i11 == 1 || i11 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i11) {
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                return 0;
            }
            switch (i11) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
