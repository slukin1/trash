package androidx.navigation;

import kotlin.jvm.internal.x;

public final class NavOptions {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10338a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10339b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10340c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f10341d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f10342e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10343f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10344g;

    /* renamed from: h  reason: collision with root package name */
    public final int f10345h;

    /* renamed from: i  reason: collision with root package name */
    public final int f10346i;

    /* renamed from: j  reason: collision with root package name */
    public String f10347j;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10348a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10349b;

        /* renamed from: c  reason: collision with root package name */
        public int f10350c = -1;

        /* renamed from: d  reason: collision with root package name */
        public String f10351d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10352e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10353f;

        /* renamed from: g  reason: collision with root package name */
        public int f10354g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f10355h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f10356i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f10357j = -1;

        public static /* synthetic */ Builder i(Builder builder, int i11, boolean z11, boolean z12, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                z12 = false;
            }
            return builder.g(i11, z11, z12);
        }

        public final NavOptions a() {
            String str = this.f10351d;
            if (str != null) {
                return new NavOptions(this.f10348a, this.f10349b, str, this.f10352e, this.f10353f, this.f10354g, this.f10355h, this.f10356i, this.f10357j);
            }
            return new NavOptions(this.f10348a, this.f10349b, this.f10350c, this.f10352e, this.f10353f, this.f10354g, this.f10355h, this.f10356i, this.f10357j);
        }

        public final Builder b(int i11) {
            this.f10354g = i11;
            return this;
        }

        public final Builder c(int i11) {
            this.f10355h = i11;
            return this;
        }

        public final Builder d(boolean z11) {
            this.f10348a = z11;
            return this;
        }

        public final Builder e(int i11) {
            this.f10356i = i11;
            return this;
        }

        public final Builder f(int i11) {
            this.f10357j = i11;
            return this;
        }

        public final Builder g(int i11, boolean z11, boolean z12) {
            this.f10350c = i11;
            this.f10351d = null;
            this.f10352e = z11;
            this.f10353f = z12;
            return this;
        }

        public final Builder h(String str, boolean z11, boolean z12) {
            this.f10351d = str;
            this.f10350c = -1;
            this.f10352e = z11;
            this.f10353f = z12;
            return this;
        }

        public final Builder j(boolean z11) {
            this.f10349b = z11;
            return this;
        }
    }

    public NavOptions(boolean z11, boolean z12, int i11, boolean z13, boolean z14, int i12, int i13, int i14, int i15) {
        this.f10338a = z11;
        this.f10339b = z12;
        this.f10340c = i11;
        this.f10341d = z13;
        this.f10342e = z14;
        this.f10343f = i12;
        this.f10344g = i13;
        this.f10345h = i14;
        this.f10346i = i15;
    }

    public final int a() {
        return this.f10343f;
    }

    public final int b() {
        return this.f10344g;
    }

    public final int c() {
        return this.f10345h;
    }

    public final int d() {
        return this.f10346i;
    }

    public final int e() {
        return this.f10340c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !x.b(NavOptions.class, obj.getClass())) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        if (this.f10338a == navOptions.f10338a && this.f10339b == navOptions.f10339b && this.f10340c == navOptions.f10340c && x.b(this.f10347j, navOptions.f10347j) && this.f10341d == navOptions.f10341d && this.f10342e == navOptions.f10342e && this.f10343f == navOptions.f10343f && this.f10344g == navOptions.f10344g && this.f10345h == navOptions.f10345h && this.f10346i == navOptions.f10346i) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f10341d;
    }

    public final boolean g() {
        return this.f10338a;
    }

    public final boolean h() {
        return this.f10342e;
    }

    public int hashCode() {
        int i11 = (((((g() ? 1 : 0) * true) + (i() ? 1 : 0)) * 31) + this.f10340c) * 31;
        String str = this.f10347j;
        return ((((((((((((i11 + (str != null ? str.hashCode() : 0)) * 31) + (f() ? 1 : 0)) * 31) + (h() ? 1 : 0)) * 31) + this.f10343f) * 31) + this.f10344g) * 31) + this.f10345h) * 31) + this.f10346i;
    }

    public final boolean i() {
        return this.f10339b;
    }

    public NavOptions(boolean z11, boolean z12, String str, boolean z13, boolean z14, int i11, int i12, int i13, int i14) {
        this(z11, z12, NavDestination.f10313k.a(str).hashCode(), z13, z14, i11, i12, i13, i14);
        this.f10347j = str;
    }
}
