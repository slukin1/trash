package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.z0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

public abstract class q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f32683c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f32684d = "OTHER";

    /* renamed from: e  reason: collision with root package name */
    public static final String f32685e = "FILE_ATTACHMENT";

    /* renamed from: a  reason: collision with root package name */
    public final String f32686a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32687b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final q a(String str) {
            switch (str.hashCode()) {
                case -1895130188:
                    if (str.equals("ID_CARD")) {
                        return c.f32689f;
                    }
                    break;
                case -1852691096:
                    if (str.equals(DocumentType.f32348c)) {
                        return g.f32693f;
                    }
                    break;
                case -1656620757:
                    if (str.equals("DRIVERS")) {
                        return b.f32688f;
                    }
                    break;
                case -790387854:
                    if (str.equals("INSURANCE_CERTIFICATE")) {
                        return d.f32690f;
                    }
                    break;
                case 2634817:
                    if (str.equals("VISA")) {
                        return j.f32695f;
                    }
                    break;
                case 79048533:
                    if (str.equals("SNILS")) {
                        return h.f32694f;
                    }
                    break;
                case 1305942932:
                    if (str.equals("RESIDENCE_PERMIT")) {
                        return f.f32692f;
                    }
                    break;
                case 1999404050:
                    if (str.equals("PASSPORT")) {
                        return e.f32691f;
                    }
                    break;
            }
            return new i(str, z0.a((List<String>) StringsKt__StringsKt.K0(str, new char[]{'_'}, false, 0, 6, (Object) null)));
        }

        public a() {
        }
    }

    public static final class b extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final b f32688f = new b();

        public b() {
            super("DRIVERS", "drivers", (r) null);
        }
    }

    public static final class c extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final c f32689f = new c();

        public c() {
            super("ID_CARD", "idCard", (r) null);
        }
    }

    public static final class d extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final d f32690f = new d();

        public d() {
            super("INSURANCE_CERTIFICATE", "insuranceCertificate", (r) null);
        }
    }

    public static final class e extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final e f32691f = new e();

        public e() {
            super("PASSPORT", "passport", (r) null);
        }
    }

    public static final class f extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final f f32692f = new f();

        public f() {
            super("RESIDENCE_PERMIT", "residencePermit", (r) null);
        }
    }

    public static final class g extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final g f32693f = new g();

        public g() {
            super(DocumentType.f32348c, "selfie", (r) null);
        }
    }

    public static final class h extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final h f32694f = new h();

        public h() {
            super("SNILS", "snils", (r) null);
        }
    }

    public static final class i extends q {
        public i(String str, String str2) {
            super(str, str2, (r) null);
        }
    }

    public static final class j extends q {

        /* renamed from: f  reason: collision with root package name */
        public static final j f32695f = new j();

        public j() {
            super("VISA", "visa", (r) null);
        }
    }

    public /* synthetic */ q(String str, String str2, r rVar) {
        this(str, str2);
    }

    public final String a() {
        return this.f32687b;
    }

    public final String b() {
        return this.f32686a;
    }

    public q(String str, String str2) {
        this.f32686a = str;
        this.f32687b = str2;
    }

    public static /* synthetic */ CharSequence a(q qVar, b.c cVar, CharSequence charSequence, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                charSequence = null;
            }
            return qVar.a(cVar, charSequence);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTitle");
    }

    public final CharSequence a(b.c cVar, CharSequence charSequence) {
        d0 d0Var = d0.f56774a;
        String a11 = cVar.a(String.format(n0.j.a.f32221b, Arrays.copyOf(new Object[]{this.f32686a}, 1)));
        if (a11 != null) {
            return a11;
        }
        return charSequence == null ? this.f32686a : charSequence;
    }
}
