package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.core.data.model.SNSException;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class o implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final b f32656d = new b((r) null);
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f32657a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f32658b;

    /* renamed from: c  reason: collision with root package name */
    public final a f32659c;

    public static final class a implements Serializable {

        /* renamed from: d  reason: collision with root package name */
        public static final C0342a f32660d = new C0342a((r) null);
        private static final long serialVersionUID = 1;

        /* renamed from: a  reason: collision with root package name */
        public final String f32661a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32662b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32663c;

        /* renamed from: com.sumsub.sns.internal.core.data.model.o$a$a  reason: collision with other inner class name */
        public static final class C0342a {
            public /* synthetic */ C0342a(r rVar) {
                this();
            }

            public C0342a() {
            }
        }

        public a() {
            this((String) null, (String) null, (String) null, 7, (r) null);
        }

        public final String a() {
            return this.f32661a;
        }

        public final String b() {
            return this.f32662b;
        }

        public final String c() {
            return this.f32663c;
        }

        public final String d() {
            return this.f32663c;
        }

        public final String e() {
            return this.f32662b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f32661a, aVar.f32661a) && x.b(this.f32662b, aVar.f32662b) && x.b(this.f32663c, aVar.f32663c);
        }

        public final String f() {
            return this.f32661a;
        }

        public int hashCode() {
            String str = this.f32661a;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f32662b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f32663c;
            if (str3 != null) {
                i11 = str3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "Appearance(title=" + this.f32661a + ", text=" + this.f32662b + ", buttonText=" + this.f32663c + ')';
        }

        public a(String str, String str2, String str3) {
            this.f32661a = str;
            this.f32662b = str2;
            this.f32663c = str3;
        }

        public final a a(String str, String str2, String str3) {
            return new a(str, str2, str3);
        }

        public static /* synthetic */ a a(a aVar, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f32661a;
            }
            if ((i11 & 2) != 0) {
                str2 = aVar.f32662b;
            }
            if ((i11 & 4) != 0) {
                str3 = aVar.f32663c;
            }
            return aVar.a(str, str2, str3);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, String str2, String str3, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends o {
        public c() {
            this((Throwable) null, (Object) null, (a) null, 7, (r) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(Throwable th2, Object obj, a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? null : aVar);
        }

        public c(Throwable th2, Object obj, a aVar) {
            super(th2, obj, aVar, (r) null);
        }
    }

    public static final class d extends o {
        public d() {
            this((Throwable) null, (Object) null, (a) null, 7, (r) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(Throwable th2, Object obj, a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? null : aVar);
        }

        public d(Throwable th2, Object obj, a aVar) {
            super(th2, obj, aVar, (r) null);
        }
    }

    public static final class e extends o {
        public e() {
            this((Throwable) null, (Object) null, (a) null, 7, (r) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(Throwable th2, Object obj, a aVar, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : th2, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? null : aVar);
        }

        public e(Throwable th2, Object obj, a aVar) {
            super(th2, obj, aVar, (r) null);
        }
    }

    public static final class f extends o {

        /* renamed from: e  reason: collision with root package name */
        public final String f32664e;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ f(String str, SNSException.Api api, Object obj, a aVar, int i11, r rVar) {
            this(str, (i11 & 2) != 0 ? null : api, (i11 & 4) != 0 ? null : obj, (i11 & 8) != 0 ? null : aVar);
        }

        public final String d() {
            return this.f32664e;
        }

        public f(String str, SNSException.Api api, Object obj, a aVar) {
            super(api, obj, aVar, (r) null);
            this.f32664e = str;
        }
    }

    public /* synthetic */ o(Throwable th2, Object obj, a aVar, r rVar) {
        this(th2, obj, aVar);
    }

    public final a a() {
        return this.f32659c;
    }

    public final Throwable b() {
        return this.f32657a;
    }

    public final Object c() {
        return this.f32658b;
    }

    public o(Throwable th2, Object obj, a aVar) {
        this.f32657a = th2;
        this.f32658b = obj;
        this.f32659c = aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(Throwable th2, Object obj, a aVar, int i11, r rVar) {
        this(th2, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? null : aVar, (r) null);
    }
}
