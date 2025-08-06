package com.sumsub.sns.internal.core.theme;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class b {

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f34035a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f34036b;

        public a(Integer num, Integer num2) {
            super((r) null);
            this.f34035a = num;
            this.f34036b = num2;
        }

        public final Integer a() {
            return this.f34035a;
        }

        public final Integer b() {
            return this.f34036b;
        }

        public final Integer c() {
            return this.f34035a;
        }

        public final Integer d() {
            return this.f34036b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f34035a, aVar.f34035a) && x.b(this.f34036b, aVar.f34036b);
        }

        public int hashCode() {
            Integer num = this.f34035a;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.f34036b;
            if (num2 != null) {
                i11 = num2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "Color(dark=" + this.f34035a + ", light=" + this.f34036b + ')';
        }

        public final a a(Integer num, Integer num2) {
            return new a(num, num2);
        }

        public static /* synthetic */ a a(a aVar, Integer num, Integer num2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                num = aVar.f34035a;
            }
            if ((i11 & 2) != 0) {
                num2 = aVar.f34036b;
            }
            return aVar.a(num, num2);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.theme.b$b  reason: collision with other inner class name */
    public static final class C0385b extends b {

        /* renamed from: a  reason: collision with root package name */
        public final Float f34037a;

        public C0385b(Float f11) {
            super((r) null);
            this.f34037a = f11;
        }

        public final Float a() {
            return this.f34037a;
        }

        public final Float b() {
            return this.f34037a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0385b) && x.b(this.f34037a, ((C0385b) obj).f34037a);
        }

        public int hashCode() {
            Float f11 = this.f34037a;
            if (f11 == null) {
                return 0;
            }
            return f11.hashCode();
        }

        public String toString() {
            return "Dimension(value=" + this.f34037a + ')';
        }

        public final C0385b a(Float f11) {
            return new C0385b(f11);
        }

        public static /* synthetic */ C0385b a(C0385b bVar, Float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = bVar.f34037a;
            }
            return bVar.a(f11);
        }
    }

    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34038a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f34039b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34040c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f34041d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(String str, Integer num, String str2, Bitmap bitmap, int i11, r rVar) {
            this(str, num, str2, (i11 & 8) != 0 ? null : bitmap);
        }

        public final String a() {
            return this.f34038a;
        }

        public final Integer b() {
            return this.f34039b;
        }

        public final String c() {
            return this.f34040c;
        }

        public final Bitmap d() {
            return this.f34041d;
        }

        public final Bitmap e() {
            return this.f34041d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f34038a, cVar.f34038a) && x.b(this.f34039b, cVar.f34039b) && x.b(this.f34040c, cVar.f34040c) && x.b(this.f34041d, cVar.f34041d);
        }

        public final String f() {
            return this.f34038a;
        }

        public final String g() {
            return this.f34040c;
        }

        public final Integer h() {
            return this.f34039b;
        }

        public int hashCode() {
            String str = this.f34038a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.f34039b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.f34040c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Bitmap bitmap = this.f34041d;
            if (bitmap != null) {
                i11 = bitmap.hashCode();
            }
            return hashCode3 + i11;
        }

        public String toString() {
            return "Image(image=" + this.f34038a + ", scale=" + this.f34039b + ", rendering=" + this.f34040c + ", bitmap=" + this.f34041d + ')';
        }

        public c(String str, Integer num, String str2, Bitmap bitmap) {
            super((r) null);
            this.f34038a = str;
            this.f34039b = num;
            this.f34040c = str2;
            this.f34041d = bitmap;
        }

        public final c a(String str, Integer num, String str2, Bitmap bitmap) {
            return new c(str, num, str2, bitmap);
        }

        public static /* synthetic */ c a(c cVar, String str, Integer num, String str2, Bitmap bitmap, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f34038a;
            }
            if ((i11 & 2) != 0) {
                num = cVar.f34039b;
            }
            if ((i11 & 4) != 0) {
                str2 = cVar.f34040c;
            }
            if ((i11 & 8) != 0) {
                bitmap = cVar.f34041d;
            }
            return cVar.a(str, num, str2, bitmap);
        }

        public final void a(Bitmap bitmap) {
            this.f34041d = bitmap;
        }
    }

    public static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, c> f34042a;

        public d(Map<String, c> map) {
            super((r) null);
            this.f34042a = map;
        }

        public final Map<String, c> a() {
            return this.f34042a;
        }

        public final Map<String, c> b() {
            return this.f34042a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && x.b(this.f34042a, ((d) obj).f34042a);
        }

        public int hashCode() {
            return this.f34042a.hashCode();
        }

        public String toString() {
            return "ImageList(images=" + this.f34042a + ')';
        }

        public final d a(Map<String, c> map) {
            return new d(map);
        }

        public static /* synthetic */ d a(d dVar, Map<String, c> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                map = dVar.f34042a;
            }
            return dVar.a(map);
        }
    }

    public static final class e extends b {

        /* renamed from: a  reason: collision with root package name */
        public final Float f34043a;

        /* renamed from: b  reason: collision with root package name */
        public final Float f34044b;

        public e(Float f11, Float f12) {
            super((r) null);
            this.f34043a = f11;
            this.f34044b = f12;
        }

        public final Float a() {
            return this.f34043a;
        }

        public final Float b() {
            return this.f34044b;
        }

        public final Float c() {
            return this.f34044b;
        }

        public final Float d() {
            return this.f34043a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f34043a, eVar.f34043a) && x.b(this.f34044b, eVar.f34044b);
        }

        public int hashCode() {
            Float f11 = this.f34043a;
            int i11 = 0;
            int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
            Float f12 = this.f34044b;
            if (f12 != null) {
                i11 = f12.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "Size(width=" + this.f34043a + ", height=" + this.f34044b + ')';
        }

        public final e a(Float f11, Float f12) {
            return new e(f11, f12);
        }

        public static /* synthetic */ e a(e eVar, Float f11, Float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = eVar.f34043a;
            }
            if ((i11 & 2) != 0) {
                f12 = eVar.f34044b;
            }
            return eVar.a(f11, f12);
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34045a;

        public f(String str) {
            super((r) null);
            this.f34045a = str;
        }

        public final String a() {
            return this.f34045a;
        }

        public final String b() {
            return this.f34045a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && x.b(this.f34045a, ((f) obj).f34045a);
        }

        public int hashCode() {
            return this.f34045a.hashCode();
        }

        public String toString() {
            return "Style(value=" + this.f34045a + ')';
        }

        public final f a(String str) {
            return new f(str);
        }

        public static /* synthetic */ f a(f fVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = fVar.f34045a;
            }
            return fVar.a(str);
        }
    }

    public static final class g extends b {

        /* renamed from: a  reason: collision with root package name */
        public final String f34046a;

        /* renamed from: b  reason: collision with root package name */
        public final int f34047b;

        /* renamed from: c  reason: collision with root package name */
        public final String f34048c;

        /* renamed from: d  reason: collision with root package name */
        public Typeface f34049d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ g(String str, int i11, String str2, Typeface typeface, int i12, r rVar) {
            this(str, i11, str2, (i12 & 8) != 0 ? null : typeface);
        }

        public final String a() {
            return this.f34046a;
        }

        public final int b() {
            return this.f34047b;
        }

        public final String c() {
            return this.f34048c;
        }

        public final Typeface d() {
            return this.f34049d;
        }

        public final String e() {
            return this.f34046a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return x.b(this.f34046a, gVar.f34046a) && this.f34047b == gVar.f34047b && x.b(this.f34048c, gVar.f34048c) && x.b(this.f34049d, gVar.f34049d);
        }

        public final String f() {
            return this.f34048c;
        }

        public final int g() {
            return this.f34047b;
        }

        public final Typeface h() {
            return this.f34049d;
        }

        public int hashCode() {
            int hashCode = ((((this.f34046a.hashCode() * 31) + this.f34047b) * 31) + this.f34048c.hashCode()) * 31;
            Typeface typeface = this.f34049d;
            return hashCode + (typeface == null ? 0 : typeface.hashCode());
        }

        public String toString() {
            return "Typography(face=" + this.f34046a + ", size=" + this.f34047b + ", filename=" + this.f34048c + ", typeface=" + this.f34049d + ')';
        }

        public g(String str, int i11, String str2, Typeface typeface) {
            super((r) null);
            this.f34046a = str;
            this.f34047b = i11;
            this.f34048c = str2;
            this.f34049d = typeface;
        }

        public final g a(String str, int i11, String str2, Typeface typeface) {
            return new g(str, i11, str2, typeface);
        }

        public static /* synthetic */ g a(g gVar, String str, int i11, String str2, Typeface typeface, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = gVar.f34046a;
            }
            if ((i12 & 2) != 0) {
                i11 = gVar.f34047b;
            }
            if ((i12 & 4) != 0) {
                str2 = gVar.f34048c;
            }
            if ((i12 & 8) != 0) {
                typeface = gVar.f34049d;
            }
            return gVar.a(str, i11, str2, typeface);
        }

        public final void a(Typeface typeface) {
            this.f34049d = typeface;
        }
    }

    public /* synthetic */ b(r rVar) {
        this();
    }

    public b() {
    }
}
