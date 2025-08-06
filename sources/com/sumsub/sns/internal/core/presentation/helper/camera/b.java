package com.sumsub.sns.internal.core.presentation.helper.camera;

import com.sumsub.sns.internal.core.presentation.intro.f;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class b {

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f33851a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f33852b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f33853c;

        /* renamed from: d  reason: collision with root package name */
        public final f f33854d;

        /* renamed from: e  reason: collision with root package name */
        public final String f33855e;

        public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, f fVar, String str) {
            super((r) null);
            this.f33851a = charSequence;
            this.f33852b = charSequence2;
            this.f33853c = charSequence3;
            this.f33854d = fVar;
            this.f33855e = str;
        }

        public final CharSequence a() {
            return this.f33851a;
        }

        public final CharSequence b() {
            return this.f33852b;
        }

        public final CharSequence c() {
            return this.f33853c;
        }

        public final f d() {
            return this.f33854d;
        }

        public final String e() {
            return this.f33855e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f33851a, aVar.f33851a) && x.b(this.f33852b, aVar.f33852b) && x.b(this.f33853c, aVar.f33853c) && x.b(this.f33854d, aVar.f33854d) && x.b(this.f33855e, aVar.f33855e);
        }

        public final CharSequence f() {
            return this.f33852b;
        }

        public final String g() {
            return this.f33855e;
        }

        public final CharSequence h() {
            return this.f33853c;
        }

        public int hashCode() {
            int hashCode = ((((((this.f33851a.hashCode() * 31) + this.f33852b.hashCode()) * 31) + this.f33853c.hashCode()) * 31) + this.f33854d.hashCode()) * 31;
            String str = this.f33855e;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public final f i() {
            return this.f33854d;
        }

        public final CharSequence j() {
            return this.f33851a;
        }

        public String toString() {
            return "BriefDetails(title=" + this.f33851a + ", brief=" + this.f33852b + ", details=" + this.f33853c + ", stepInfo=" + this.f33854d + ", countryCode=" + this.f33855e + ')';
        }

        public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, f fVar, String str) {
            return new a(charSequence, charSequence2, charSequence3, fVar, str);
        }

        public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, f fVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charSequence = aVar.f33851a;
            }
            if ((i11 & 2) != 0) {
                charSequence2 = aVar.f33852b;
            }
            CharSequence charSequence4 = charSequence2;
            if ((i11 & 4) != 0) {
                charSequence3 = aVar.f33853c;
            }
            CharSequence charSequence5 = charSequence3;
            if ((i11 & 8) != 0) {
                fVar = aVar.f33854d;
            }
            f fVar2 = fVar;
            if ((i11 & 16) != 0) {
                str = aVar.f33855e;
            }
            return aVar.a(charSequence, charSequence4, charSequence5, fVar2, str);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.presentation.helper.camera.b$b  reason: collision with other inner class name */
    public static final class C0380b extends b {

        /* renamed from: a  reason: collision with root package name */
        public final f f33856a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, Object> f33857b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33858c;

        public C0380b(f fVar, Map<String, ? extends Object> map, String str) {
            super((r) null);
            this.f33856a = fVar;
            this.f33857b = map;
            this.f33858c = str;
        }

        public final f a() {
            return this.f33856a;
        }

        public final Map<String, Object> b() {
            return this.f33857b;
        }

        public final String c() {
            return this.f33858c;
        }

        public final String d() {
            return this.f33858c;
        }

        public final Map<String, Object> e() {
            return this.f33857b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0380b)) {
                return false;
            }
            C0380b bVar = (C0380b) obj;
            return x.b(this.f33856a, bVar.f33856a) && x.b(this.f33857b, bVar.f33857b) && x.b(this.f33858c, bVar.f33858c);
        }

        public final f f() {
            return this.f33856a;
        }

        public int hashCode() {
            int hashCode = ((this.f33856a.hashCode() * 31) + this.f33857b.hashCode()) * 31;
            String str = this.f33858c;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Intro(stepInfo=" + this.f33856a + ", instuctionsData=" + this.f33857b + ", countryCode=" + this.f33858c + ')';
        }

        public final C0380b a(f fVar, Map<String, ? extends Object> map, String str) {
            return new C0380b(fVar, map, str);
        }

        public static /* synthetic */ C0380b a(C0380b bVar, f fVar, Map<String, Object> map, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                fVar = bVar.f33856a;
            }
            if ((i11 & 2) != 0) {
                map = bVar.f33857b;
            }
            if ((i11 & 4) != 0) {
                str = bVar.f33858c;
            }
            return bVar.a(fVar, map, str);
        }
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f33859a = new c();

        public c() {
            super((r) null);
        }
    }

    public /* synthetic */ b(r rVar) {
        this();
    }

    public b() {
    }
}
