package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class dp {

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private int f51594a = 0;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f2678a = Collections.emptyList();

        /* renamed from: a  reason: collision with other field name */
        private boolean f2679a;

        /* renamed from: b  reason: collision with root package name */
        private int f51595b = 0;

        /* renamed from: b  reason: collision with other field name */
        private boolean f2680b;

        /* renamed from: c  reason: collision with root package name */
        private int f51596c = -1;

        /* renamed from: c  reason: collision with other field name */
        private boolean f2681c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f51597d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f51598e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f51599f = false;

        /* renamed from: b  reason: collision with other method in class */
        public boolean m2530b() {
            return this.f2681c;
        }

        public int c() {
            return this.f51594a;
        }

        public int d() {
            return this.f51595b;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m2533e() {
            return this.f51599f;
        }

        public boolean f() {
            return this.f51598e;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2529a() {
            return this.f2679a;
        }

        public a b(int i11) {
            this.f51597d = true;
            this.f51595b = i11;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m2531c() {
            return this.f2680b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m2532d() {
            return this.f51597d;
        }

        public int e() {
            return this.f2678a.size();
        }

        public a a(int i11) {
            this.f2679a = true;
            this.f51594a = i11;
            return this;
        }

        public a b(boolean z11) {
            this.f51598e = true;
            this.f51599f = z11;
            return this;
        }

        public a a(boolean z11) {
            this.f2680b = true;
            this.f2681c = z11;
            return this;
        }

        public int b() {
            int i11 = 0;
            int b11 = a() ? c.b(1, c()) + 0 : 0;
            if (c()) {
                b11 += c.a(2, b());
            }
            if (d()) {
                b11 += c.a(3, d());
            }
            if (f()) {
                b11 += c.a(4, e());
            }
            for (String a11 : a()) {
                i11 += c.a(a11);
            }
            int size = b11 + i11 + (a().size() * 1);
            this.f51596c = size;
            return size;
        }

        /* renamed from: a  reason: collision with other method in class */
        public List<String> m2528a() {
            return this.f2678a;
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.f2678a.isEmpty()) {
                this.f2678a = new ArrayList();
            }
            this.f2678a.add(str);
            return this;
        }

        public void a(c cVar) {
            if (a()) {
                cVar.b(1, c());
            }
            if (c()) {
                cVar.a(2, b());
            }
            if (d()) {
                cVar.a(3, d());
            }
            if (f()) {
                cVar.a(4, e());
            }
            for (String a11 : a()) {
                cVar.a(5, a11);
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        public int a() {
            if (this.f51596c < 0) {
                b();
            }
            return this.f51596c;
        }

        public a a(b bVar) {
            while (true) {
                int a11 = bVar.a();
                if (a11 == 0) {
                    return this;
                }
                if (a11 == 8) {
                    a(bVar.c());
                } else if (a11 == 16) {
                    a(bVar.a());
                } else if (a11 == 24) {
                    b(bVar.b());
                } else if (a11 == 32) {
                    b(bVar.a());
                } else if (a11 == 42) {
                    a(bVar.a());
                } else if (!a(bVar, a11)) {
                    return this;
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
