package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00042\u00020\u0001:\r\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/p;", "Landroid/os/Parcelable;", "<init>", "()V", "Companion", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "Lcom/sumsub/sns/internal/core/data/model/p$a;", "Lcom/sumsub/sns/internal/core/data/model/p$b;", "Lcom/sumsub/sns/internal/core/data/model/p$c;", "Lcom/sumsub/sns/internal/core/data/model/p$d;", "Lcom/sumsub/sns/internal/core/data/model/p$f;", "Lcom/sumsub/sns/internal/core/data/model/p$g;", "Lcom/sumsub/sns/internal/core/data/model/p$h;", "Lcom/sumsub/sns/internal/core/data/model/p$i;", "Lcom/sumsub/sns/internal/core/data/model/p$j;", "Lcom/sumsub/sns/internal/core/data/model/p$k;", "Lcom/sumsub/sns/internal/core/data/model/p$l;", "Lcom/sumsub/sns/internal/core/data/model/p$m;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f(with = e.a.class)
public abstract class p implements Parcelable {
    public static final e Companion = new e((r) null);

    /* renamed from: a  reason: collision with root package name */
    public static final String f32665a = ":";

    /* renamed from: b  reason: collision with root package name */
    public static final String f32666b = "min_value";

    /* renamed from: c  reason: collision with root package name */
    public static final String f32667c = "android_tetxt_cap_words";

    /* renamed from: d  reason: collision with root package name */
    public static final String f32668d = "email";

    public static final class a extends p {
        public static final Parcelable.Creator<a> CREATOR = new C0343a();

        /* renamed from: e  reason: collision with root package name */
        public static final a f32669e = new a();

        /* renamed from: com.sumsub.sns.internal.core.data.model.p$a$a  reason: collision with other inner class name */
        public static final class C0343a implements Parcelable.Creator<a> {
            /* renamed from: a */
            public final a createFromParcel(Parcel parcel) {
                parcel.readInt();
                return a.f32669e;
            }

            /* renamed from: a */
            public final a[] newArray(int i11) {
                return new a[i11];
            }
        }

        public a() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class b extends p {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public static final b f32670e = new b();

        public static final class a implements Parcelable.Creator<b> {
            /* renamed from: a */
            public final b createFromParcel(Parcel parcel) {
                parcel.readInt();
                return b.f32670e;
            }

            /* renamed from: a */
            public final b[] newArray(int i11) {
                return new b[i11];
            }
        }

        public b() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class c extends p {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public static final c f32671e = new c();

        public static final class a implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                parcel.readInt();
                return c.f32671e;
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        public c() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class d extends p {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.h f32672e;

        public static final class a implements Parcelable.Creator<d> {
            /* renamed from: a */
            public final d createFromParcel(Parcel parcel) {
                return new d(com.sumsub.sns.internal.core.data.source.applicant.remote.h.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: a */
            public final d[] newArray(int i11) {
                return new d[i11];
            }
        }

        public d(com.sumsub.sns.internal.core.data.source.applicant.remote.h hVar) {
            super((r) null);
            this.f32672e = hVar;
        }

        public final com.sumsub.sns.internal.core.data.source.applicant.remote.h a() {
            return this.f32672e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            this.f32672e.writeToParcel(parcel, i11);
        }
    }

    public static final class e {

        public static final class a implements kotlinx.serialization.b<p> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32673a = new a();

            /* renamed from: b  reason: collision with root package name */
            public static final kotlinx.serialization.descriptors.f f32674b = SerialDescriptorsKt.a("FieldFormat", e.i.f57638a);

            /* renamed from: a */
            public p deserialize(kotlinx.serialization.encoding.c cVar) {
                return p.Companion.a(cVar.q());
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, p pVar) {
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32674b;
            }
        }

        public /* synthetic */ e(r rVar) {
            this();
        }

        public final p a(String str) {
            List L0;
            if (str == null || (L0 = StringsKt__StringsKt.L0(str, new String[]{":"}, false, 0, 6, (Object) null)) == null) {
                return null;
            }
            if (L0.size() == 1) {
                String str2 = (String) L0.get(0);
                switch (str2.hashCode()) {
                    case -2000413939:
                        if (!str2.equals("numeric")) {
                            return null;
                        }
                        return k.f32680e;
                    case -1626286546:
                        if (!str2.equals("alpha_spaces")) {
                            return null;
                        }
                        return a.f32669e;
                    case -59614510:
                        if (!str2.equals("validPhone")) {
                            return null;
                        }
                        return m.f32682e;
                    case 96619420:
                        if (!str2.equals("email")) {
                            return null;
                        }
                        return b.f32670e;
                    case 572016716:
                        if (!str2.equals(p.f32667c)) {
                            return null;
                        }
                        return c.f32671e;
                    default:
                        return null;
                }
            } else if (L0.size() != 2) {
                return null;
            } else {
                String str3 = (String) L0.get(0);
                String str4 = (String) L0.get(1);
                double d11 = Double.MIN_VALUE;
                double d12 = Double.MAX_VALUE;
                switch (str3.hashCode()) {
                    case -232128810:
                        if (!str3.equals("max_value")) {
                            return null;
                        }
                        Double j11 = StringsKt__StringNumberConversionsJVMKt.j(str4);
                        if (j11 != null) {
                            d12 = j11.doubleValue();
                        }
                        return new h(d12);
                    case -216634360:
                        if (!str3.equals("between")) {
                            return null;
                        }
                        List L02 = StringsKt__StringsKt.L0(str4, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
                        Double j12 = StringsKt__StringNumberConversionsJVMKt.j((String) L02.get(0));
                        if (j12 != null) {
                            d11 = j12.doubleValue();
                        }
                        Double j13 = StringsKt__StringNumberConversionsJVMKt.j((String) L02.get(1));
                        if (j13 != null) {
                            d12 = j13.doubleValue();
                        }
                        return new d(new com.sumsub.sns.internal.core.data.source.applicant.remote.h(d11, d12));
                    case 107876:
                        if (!str3.equals("max")) {
                            return null;
                        }
                        Integer m11 = StringsKt__StringNumberConversionsKt.m(str4);
                        return new g(m11 != null ? m11.intValue() : Integer.MAX_VALUE);
                    case 108114:
                        if (!str3.equals(MessageKey.MSG_ACCEPT_TIME_MIN)) {
                            return null;
                        }
                        Integer m12 = StringsKt__StringNumberConversionsKt.m(str4);
                        return new i(m12 != null ? m12.intValue() : Integer.MIN_VALUE);
                    case 108392519:
                        if (!str3.equals("regex")) {
                            return null;
                        }
                        return new l(str4);
                    case 540349764:
                        if (!str3.equals(p.f32666b)) {
                            return null;
                        }
                        Double j14 = StringsKt__StringNumberConversionsJVMKt.j(str4);
                        if (j14 != null) {
                            d11 = j14.doubleValue();
                        }
                        return new j(d11);
                    default:
                        return null;
                }
            }
        }

        public final kotlinx.serialization.b<p> serializer() {
            return a.f32673a;
        }

        public e() {
        }
    }

    public static final class f extends p {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public static final f f32675e = new f();

        public static final class a implements Parcelable.Creator<f> {
            /* renamed from: a */
            public final f createFromParcel(Parcel parcel) {
                parcel.readInt();
                return f.f32675e;
            }

            /* renamed from: a */
            public final f[] newArray(int i11) {
                return new f[i11];
            }
        }

        public f() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class g extends p {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final int f32676e;

        public static final class a implements Parcelable.Creator<g> {
            /* renamed from: a */
            public final g createFromParcel(Parcel parcel) {
                return new g(parcel.readInt());
            }

            /* renamed from: a */
            public final g[] newArray(int i11) {
                return new g[i11];
            }
        }

        public g(int i11) {
            super((r) null);
            this.f32676e = i11;
        }

        public final int a() {
            return this.f32676e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f32676e);
        }
    }

    public static final class h extends p {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final double f32677e;

        public static final class a implements Parcelable.Creator<h> {
            /* renamed from: a */
            public final h createFromParcel(Parcel parcel) {
                return new h(parcel.readDouble());
            }

            /* renamed from: a */
            public final h[] newArray(int i11) {
                return new h[i11];
            }
        }

        public h(double d11) {
            super((r) null);
            this.f32677e = d11;
        }

        public final double a() {
            return this.f32677e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeDouble(this.f32677e);
        }
    }

    public static final class i extends p {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final int f32678e;

        public static final class a implements Parcelable.Creator<i> {
            /* renamed from: a */
            public final i createFromParcel(Parcel parcel) {
                return new i(parcel.readInt());
            }

            /* renamed from: a */
            public final i[] newArray(int i11) {
                return new i[i11];
            }
        }

        public i(int i11) {
            super((r) null);
            this.f32678e = i11;
        }

        public final int a() {
            return this.f32678e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.f32678e);
        }
    }

    public static final class j extends p {
        public static final Parcelable.Creator<j> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final double f32679e;

        public static final class a implements Parcelable.Creator<j> {
            /* renamed from: a */
            public final j createFromParcel(Parcel parcel) {
                return new j(parcel.readDouble());
            }

            /* renamed from: a */
            public final j[] newArray(int i11) {
                return new j[i11];
            }
        }

        public j(double d11) {
            super((r) null);
            this.f32679e = d11;
        }

        public final double a() {
            return this.f32679e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeDouble(this.f32679e);
        }
    }

    public static final class k extends p {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public static final k f32680e = new k();

        public static final class a implements Parcelable.Creator<k> {
            /* renamed from: a */
            public final k createFromParcel(Parcel parcel) {
                parcel.readInt();
                return k.f32680e;
            }

            /* renamed from: a */
            public final k[] newArray(int i11) {
                return new k[i11];
            }
        }

        public k() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public static final class l extends p {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public final String f32681e;

        public static final class a implements Parcelable.Creator<l> {
            /* renamed from: a */
            public final l createFromParcel(Parcel parcel) {
                return new l(parcel.readString());
            }

            /* renamed from: a */
            public final l[] newArray(int i11) {
                return new l[i11];
            }
        }

        public l(String str) {
            super((r) null);
            this.f32681e = str;
        }

        public final String a() {
            return this.f32681e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f32681e);
        }
    }

    public static final class m extends p {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public static final m f32682e = new m();

        public static final class a implements Parcelable.Creator<m> {
            /* renamed from: a */
            public final m createFromParcel(Parcel parcel) {
                parcel.readInt();
                return m.f32682e;
            }

            /* renamed from: a */
            public final m[] newArray(int i11) {
                return new m[i11];
            }
        }

        public m() {
            super((r) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(1);
        }
    }

    public /* synthetic */ p(r rVar) {
        this();
    }

    public p() {
    }
}
