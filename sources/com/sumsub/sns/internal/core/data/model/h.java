package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.p;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00152\u00020\u0001:\u0004\u000b\n\u0016\u0017B\t\b\u0004¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/h;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "c", "b", "()Ljava/lang/String;", "formItemId", "<init>", "()V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILkotlinx/serialization/internal/q1;)V", "Companion", "d", "e", "Lcom/sumsub/sns/internal/core/data/model/h$c;", "Lcom/sumsub/sns/internal/core/data/model/h$d;", "Lcom/sumsub/sns/internal/core/data/model/h$e;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public abstract class h {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public static final i<kotlinx.serialization.b<Object>> f32612a = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.PUBLICATION, a.f32613a);

    public static final class a extends Lambda implements d10.a<kotlinx.serialization.b<Object>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32613a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final kotlinx.serialization.b<Object> invoke() {
            return new SealedClassSerializer("com.sumsub.sns.internal.core.data.model.ApplicantDataField", Reflection.b(h.class), new kotlin.reflect.c[]{Reflection.b(c.class), Reflection.b(d.class)}, new kotlinx.serialization.b[]{c.a.f32617a, d.a.f32626a}, new Annotation[0]);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        private final /* synthetic */ i a() {
            return h.f32612a;
        }

        public final kotlinx.serialization.b<h> serializer() {
            return (kotlinx.serialization.b) a().getValue();
        }

        public b() {
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0002\t\u001fB%\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b,\u0010-B?\b\u0017\u0012\u0006\u0010.\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b,\u00101J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006HÇ\u0001J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\t\u0010\u0013J\t\u0010\u0014\u001a\u00020\nHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0015HÖ\u0001R\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\"\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b%\u0010 \u0012\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\"\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010(\u0012\u0004\b*\u0010$\u001a\u0004\b)\u0010\u000fR\u0014\u0010+\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\"¨\u00063"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/h$c;", "Lcom/sumsub/sns/internal/core/data/model/h;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "d", "e", "", "f", "()Ljava/lang/Boolean;", "name", "displayName", "isRequired", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sumsub/sns/internal/core/data/model/h$c;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "getName$annotations", "()V", "c", "g", "getDisplayName$annotations", "Ljava/lang/Boolean;", "k", "isRequired$annotations", "formItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c extends h implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new C0339c();
        public static final b Companion = new b((r) null);

        /* renamed from: b  reason: collision with root package name */
        public final String f32614b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32615c;

        /* renamed from: d  reason: collision with root package name */
        public final Boolean f32616d;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32617a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32618b;

            static {
                a aVar = new a();
                f32617a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.ApplicantDataField.CustomField", aVar, 3);
                pluginGeneratedSerialDescriptor.k("name", false);
                pluginGeneratedSerialDescriptor.k("displayName", false);
                pluginGeneratedSerialDescriptor.k("required", false);
                f32618b = pluginGeneratedSerialDescriptor;
            }

            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.sumsub.sns.internal.core.data.model.h.c deserialize(kotlinx.serialization.encoding.c r13) {
                /*
                    r12 = this;
                    kotlinx.serialization.descriptors.f r0 = r12.getDescriptor()
                    kotlinx.serialization.encoding.a r13 = r13.b(r0)
                    boolean r1 = r13.k()
                    r2 = 0
                    r3 = 2
                    r4 = 0
                    r5 = 1
                    if (r1 == 0) goto L_0x0027
                    kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r4 = r13.j(r0, r4, r1, r2)
                    java.lang.Object r1 = r13.j(r0, r5, r1, r2)
                    kotlinx.serialization.internal.h r5 = kotlinx.serialization.internal.h.f57720a
                    java.lang.Object r2 = r13.j(r0, r3, r5, r2)
                    r3 = 7
                    r11 = r4
                    r4 = r3
                    r3 = r11
                    goto L_0x0060
                L_0x0027:
                    r1 = r2
                    r6 = r1
                    r7 = r4
                    r8 = r5
                L_0x002b:
                    if (r8 == 0) goto L_0x005d
                    int r9 = r13.w(r0)
                    r10 = -1
                    if (r9 == r10) goto L_0x005b
                    if (r9 == 0) goto L_0x0052
                    if (r9 == r5) goto L_0x0049
                    if (r9 != r3) goto L_0x0043
                    kotlinx.serialization.internal.h r9 = kotlinx.serialization.internal.h.f57720a
                    java.lang.Object r6 = r13.j(r0, r3, r9, r6)
                    r7 = r7 | 4
                    goto L_0x002b
                L_0x0043:
                    kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
                    r13.<init>((int) r9)
                    throw r13
                L_0x0049:
                    kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r1 = r13.j(r0, r5, r9, r1)
                    r7 = r7 | 2
                    goto L_0x002b
                L_0x0052:
                    kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r2 = r13.j(r0, r4, r9, r2)
                    r7 = r7 | 1
                    goto L_0x002b
                L_0x005b:
                    r8 = r4
                    goto L_0x002b
                L_0x005d:
                    r3 = r2
                    r2 = r6
                    r4 = r7
                L_0x0060:
                    r13.c(r0)
                    com.sumsub.sns.internal.core.data.model.h$c r13 = new com.sumsub.sns.internal.core.data.model.h$c
                    r5 = r3
                    java.lang.String r5 = (java.lang.String) r5
                    r6 = r1
                    java.lang.String r6 = (java.lang.String) r6
                    r7 = r2
                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                    r8 = 0
                    r3 = r13
                    r3.<init>(r4, r5, r6, r7, r8)
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.h.c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.h$c");
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(kotlinx.serialization.internal.h.f57720a)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32618b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                c.a(cVar, b11, descriptor);
                b11.c(descriptor);
            }
        }

        public static final class b {
            public /* synthetic */ b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<c> serializer() {
                return a.f32617a;
            }

            public b() {
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.data.model.h$c$c  reason: collision with other inner class name */
        public static final class C0339c implements Parcelable.Creator<c> {
            /* renamed from: a */
            public final c createFromParcel(Parcel parcel) {
                Boolean bool;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new c(readString, readString2, bool);
            }

            /* renamed from: a */
            public final c[] newArray(int i11) {
                return new c[i11];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(int i11, String str, String str2, Boolean bool, q1 q1Var) {
            super(i11, q1Var);
            if (7 != (i11 & 7)) {
                h1.a(i11, 7, a.f32617a.getDescriptor());
            }
            this.f32614b = str;
            this.f32615c = str2;
            this.f32616d = bool;
        }

        public static /* synthetic */ void h() {
        }

        public static /* synthetic */ void j() {
        }

        public static /* synthetic */ void l() {
        }

        public final c a(String str, String str2, Boolean bool) {
            return new c(str, str2, bool);
        }

        public String b() {
            String str = this.f32614b;
            return str == null ? "" : str;
        }

        public final String d() {
            return this.f32614b;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f32615c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f32614b, cVar.f32614b) && x.b(this.f32615c, cVar.f32615c) && x.b(this.f32616d, cVar.f32616d);
        }

        public final Boolean f() {
            return this.f32616d;
        }

        public final String g() {
            return this.f32615c;
        }

        public int hashCode() {
            String str = this.f32614b;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f32615c;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.f32616d;
            if (bool != null) {
                i11 = bool.hashCode();
            }
            return hashCode2 + i11;
        }

        public final String i() {
            return this.f32614b;
        }

        public final Boolean k() {
            return this.f32616d;
        }

        public String toString() {
            return "CustomField(name=" + this.f32614b + ", displayName=" + this.f32615c + ", isRequired=" + this.f32616d + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            boolean z11;
            parcel.writeString(this.f32614b);
            parcel.writeString(this.f32615c);
            Boolean bool = this.f32616d;
            if (bool == null) {
                z11 = false;
            } else {
                parcel.writeInt(1);
                z11 = bool.booleanValue();
            }
            parcel.writeInt(z11 ? 1 : 0);
        }

        public c(String str, String str2, Boolean bool) {
            super((r) null);
            this.f32614b = str;
            this.f32615c = str2;
            this.f32616d = bool;
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, Boolean bool, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f32614b;
            }
            if ((i11 & 2) != 0) {
                str2 = cVar.f32615c;
            }
            if ((i11 & 4) != 0) {
                bool = cVar.f32616d;
            }
            return cVar.a(str, str2, bool);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            h.a(cVar, bVar, fVar);
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 0, v1Var, cVar.f32614b);
            bVar.y(fVar, 1, v1Var, cVar.f32615c);
            bVar.y(fVar, 2, kotlinx.serialization.internal.h.f57720a, cVar.f32616d);
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002\t*B[\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bO\u0010PBs\b\u0017\u0012\u0006\u0010Q\u001a\u00020 \u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\b\u0010S\u001a\u0004\u0018\u00010R¢\u0006\u0004\bO\u0010TJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006HÇ\u0001J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003Ja\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020 HÖ\u0001J\u0013\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010%\u001a\u00020 HÖ\u0001J\u0019\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020 HÖ\u0001R\"\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R \u0010\u0019\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u00100\u0012\u0004\b3\u0010/\u001a\u0004\b1\u00102R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u00104\u0012\u0004\b7\u0010/\u001a\u0004\b5\u00106R\"\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u00108\u0012\u0004\b;\u0010/\u001a\u0004\b9\u0010:R(\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010<\u0012\u0004\b?\u0010/\u001a\u0004\b=\u0010>R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010@\u0012\u0004\bC\u0010/\u001a\u0004\bA\u0010BR\"\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u00108\u0012\u0004\bE\u0010/\u001a\u0004\bD\u0010:R\u0011\u0010G\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bF\u00102R\u0011\u0010I\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bH\u00102R\u0011\u0010K\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bJ\u00102R\u0011\u0010M\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bL\u00102R\u0014\u0010N\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010:¨\u0006V"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/h$d;", "Lcom/sumsub/sns/internal/core/data/model/h;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "c", "Lcom/sumsub/sns/internal/core/data/model/FieldName;", "d", "", "e", "Lcom/sumsub/sns/internal/core/data/model/FieldType;", "f", "g", "", "h", "Lcom/sumsub/sns/internal/core/data/model/p;", "i", "j", "name", "isRequired", "type", "mask", "masks", "format", "placeholder", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "b", "Lcom/sumsub/sns/internal/core/data/model/FieldName;", "q", "()Lcom/sumsub/sns/internal/core/data/model/FieldName;", "getName$annotations", "()V", "Z", "A", "()Z", "isRequired$annotations", "Lcom/sumsub/sns/internal/core/data/model/FieldType;", "u", "()Lcom/sumsub/sns/internal/core/data/model/FieldType;", "getType$annotations", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "getMask$annotations", "Ljava/util/List;", "o", "()Ljava/util/List;", "getMasks$annotations", "Lcom/sumsub/sns/internal/core/data/model/p;", "k", "()Lcom/sumsub/sns/internal/core/data/model/p;", "getFormat$annotations", "s", "getPlaceholder$annotations", "x", "isCoreRelated", "w", "isAddressRelated", "z", "isInfoRelated", "y", "isDateRelated", "formItemId", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/FieldName;ZLcom/sumsub/sns/internal/core/data/model/FieldType;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/internal/core/data/model/p;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/FieldName;ZLcom/sumsub/sns/internal/core/data/model/FieldType;Ljava/lang/String;Ljava/util/List;Lcom/sumsub/sns/internal/core/data/model/p;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class d extends h implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new c();
        public static final b Companion = new b((r) null);

        /* renamed from: b  reason: collision with root package name */
        public final FieldName f32619b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32620c;

        /* renamed from: d  reason: collision with root package name */
        public final FieldType f32621d;

        /* renamed from: e  reason: collision with root package name */
        public final String f32622e;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f32623f;

        /* renamed from: g  reason: collision with root package name */
        public final p f32624g;

        /* renamed from: h  reason: collision with root package name */
        public final String f32625h;

        public static final class a implements d0<d> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32626a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32627b;

            static {
                a aVar = new a();
                f32626a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.ApplicantDataField.Field", aVar, 7);
                pluginGeneratedSerialDescriptor.k("name", false);
                pluginGeneratedSerialDescriptor.k("required", false);
                pluginGeneratedSerialDescriptor.k("type", true);
                pluginGeneratedSerialDescriptor.k("mask", true);
                pluginGeneratedSerialDescriptor.k("masks", true);
                pluginGeneratedSerialDescriptor.k(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, true);
                pluginGeneratedSerialDescriptor.k("placeholder", true);
                f32627b = pluginGeneratedSerialDescriptor;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0091, code lost:
                r3 = 6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
                r3 = 6;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bf, code lost:
                r4 = 5;
             */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.sumsub.sns.internal.core.data.model.h.d deserialize(kotlinx.serialization.encoding.c r19) {
                /*
                    r18 = this;
                    kotlinx.serialization.descriptors.f r0 = r18.getDescriptor()
                    r1 = r19
                    kotlinx.serialization.encoding.a r1 = r1.b(r0)
                    boolean r2 = r1.k()
                    r3 = 6
                    r4 = 5
                    r5 = 3
                    java.lang.String r6 = "com.sumsub.sns.internal.core.data.model.FieldType"
                    r7 = 4
                    r8 = 2
                    r9 = 1
                    r10 = 0
                    r11 = 0
                    if (r2 == 0) goto L_0x0050
                    com.sumsub.sns.internal.core.data.model.FieldName$a$a r2 = com.sumsub.sns.internal.core.data.model.FieldName.a.C0331a.f32361a
                    java.lang.Object r2 = r1.j(r0, r10, r2, r11)
                    boolean r9 = r1.C(r0, r9)
                    kotlinx.serialization.internal.EnumSerializer r10 = new kotlinx.serialization.internal.EnumSerializer
                    com.sumsub.sns.internal.core.data.model.FieldType[] r12 = com.sumsub.sns.internal.core.data.model.FieldType.values()
                    r10.<init>(r6, r12)
                    java.lang.Object r6 = r1.j(r0, r8, r10, r11)
                    kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r5 = r1.j(r0, r5, r8, r11)
                    kotlinx.serialization.internal.e r10 = new kotlinx.serialization.internal.e
                    r10.<init>(r8)
                    java.lang.Object r7 = r1.j(r0, r7, r10, r11)
                    com.sumsub.sns.internal.core.data.model.p$e$a r10 = com.sumsub.sns.internal.core.data.model.p.e.a.f32673a
                    java.lang.Object r4 = r1.j(r0, r4, r10, r11)
                    java.lang.Object r3 = r1.j(r0, r3, r8, r11)
                    r8 = 127(0x7f, float:1.78E-43)
                    r11 = r9
                    r9 = r8
                    goto L_0x00c8
                L_0x0050:
                    r17 = r9
                    r2 = r10
                    r9 = r11
                    r12 = r9
                    r13 = r12
                    r14 = r13
                    r15 = r14
                    r10 = r15
                    r11 = r2
                L_0x005a:
                    if (r17 == 0) goto L_0x00c1
                    int r8 = r1.w(r0)
                    switch(r8) {
                        case -1: goto L_0x00bb;
                        case 0: goto L_0x00af;
                        case 1: goto L_0x00a5;
                        case 2: goto L_0x0094;
                        case 3: goto L_0x0089;
                        case 4: goto L_0x007b;
                        case 5: goto L_0x0072;
                        case 6: goto L_0x0069;
                        default: goto L_0x0063;
                    }
                L_0x0063:
                    kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                    r0.<init>((int) r8)
                    throw r0
                L_0x0069:
                    kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r9 = r1.j(r0, r3, r8, r9)
                    r2 = r2 | 64
                    goto L_0x0092
                L_0x0072:
                    com.sumsub.sns.internal.core.data.model.p$e$a r8 = com.sumsub.sns.internal.core.data.model.p.e.a.f32673a
                    java.lang.Object r10 = r1.j(r0, r4, r8, r10)
                    r2 = r2 | 32
                    goto L_0x0092
                L_0x007b:
                    kotlinx.serialization.internal.e r8 = new kotlinx.serialization.internal.e
                    kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                    r8.<init>(r3)
                    java.lang.Object r15 = r1.j(r0, r7, r8, r15)
                    r2 = r2 | 16
                    goto L_0x0091
                L_0x0089:
                    kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r14 = r1.j(r0, r5, r3, r14)
                    r2 = r2 | 8
                L_0x0091:
                    r3 = 6
                L_0x0092:
                    r8 = 2
                    goto L_0x005a
                L_0x0094:
                    kotlinx.serialization.internal.EnumSerializer r3 = new kotlinx.serialization.internal.EnumSerializer
                    com.sumsub.sns.internal.core.data.model.FieldType[] r8 = com.sumsub.sns.internal.core.data.model.FieldType.values()
                    r3.<init>(r6, r8)
                    r8 = 2
                    java.lang.Object r13 = r1.j(r0, r8, r3, r13)
                    r2 = r2 | 4
                    goto L_0x00ad
                L_0x00a5:
                    r3 = 1
                    r8 = 2
                    boolean r11 = r1.C(r0, r3)
                    r2 = r2 | 2
                L_0x00ad:
                    r3 = 6
                    goto L_0x005a
                L_0x00af:
                    r8 = 2
                    com.sumsub.sns.internal.core.data.model.FieldName$a$a r3 = com.sumsub.sns.internal.core.data.model.FieldName.a.C0331a.f32361a
                    r4 = 0
                    java.lang.Object r12 = r1.j(r0, r4, r3, r12)
                    r2 = r2 | 1
                    r3 = 6
                    goto L_0x00bf
                L_0x00bb:
                    r4 = 0
                    r8 = 2
                    r17 = r4
                L_0x00bf:
                    r4 = 5
                    goto L_0x005a
                L_0x00c1:
                    r3 = r9
                    r4 = r10
                    r6 = r13
                    r5 = r14
                    r7 = r15
                    r9 = r2
                    r2 = r12
                L_0x00c8:
                    r1.c(r0)
                    com.sumsub.sns.internal.core.data.model.h$d r0 = new com.sumsub.sns.internal.core.data.model.h$d
                    r10 = r2
                    com.sumsub.sns.internal.core.data.model.FieldName r10 = (com.sumsub.sns.internal.core.data.model.FieldName) r10
                    r12 = r6
                    com.sumsub.sns.internal.core.data.model.FieldType r12 = (com.sumsub.sns.internal.core.data.model.FieldType) r12
                    r13 = r5
                    java.lang.String r13 = (java.lang.String) r13
                    r14 = r7
                    java.util.List r14 = (java.util.List) r14
                    r15 = r4
                    com.sumsub.sns.internal.core.data.model.p r15 = (com.sumsub.sns.internal.core.data.model.p) r15
                    r16 = r3
                    java.lang.String r16 = (java.lang.String) r16
                    r17 = 0
                    r8 = r0
                    r8.<init>((int) r9, (com.sumsub.sns.internal.core.data.model.FieldName) r10, (boolean) r11, (com.sumsub.sns.internal.core.data.model.FieldType) r12, (java.lang.String) r13, (java.util.List) r14, (com.sumsub.sns.internal.core.data.model.p) r15, (java.lang.String) r16, (kotlinx.serialization.internal.q1) r17)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.h.d.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.h$d");
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{h10.a.u(FieldName.a.C0331a.f32361a), kotlinx.serialization.internal.h.f57720a, h10.a.u(new EnumSerializer("com.sumsub.sns.internal.core.data.model.FieldType", FieldType.values())), h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(p.e.a.f32673a), h10.a.u(v1Var)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32627b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, d dVar2) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                d.a(dVar2, b11, descriptor);
                b11.c(descriptor);
            }
        }

        public static final class b {
            public /* synthetic */ b(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<d> serializer() {
                return a.f32626a;
            }

            public b() {
            }
        }

        public static final class c implements Parcelable.Creator<d> {
            /* renamed from: a */
            public final d createFromParcel(Parcel parcel) {
                return new d(parcel.readInt() == 0 ? null : FieldName.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() == 0 ? null : FieldType.valueOf(parcel.readString()), parcel.readString(), parcel.createStringArrayList(), (p) parcel.readParcelable(d.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: a */
            public final d[] newArray(int i11) {
                return new d[i11];
            }
        }

        /* renamed from: com.sumsub.sns.internal.core.data.model.h$d$d  reason: collision with other inner class name */
        public /* synthetic */ class C0340d {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f32628a;

            static {
                int[] iArr = new int[FieldName.values().length];
                iArr[FieldName.country.ordinal()] = 1;
                iArr[FieldName.street.ordinal()] = 2;
                iArr[FieldName.subStreet.ordinal()] = 3;
                iArr[FieldName.buildingNumber.ordinal()] = 4;
                iArr[FieldName.flatNumber.ordinal()] = 5;
                iArr[FieldName.town.ordinal()] = 6;
                iArr[FieldName.state.ordinal()] = 7;
                iArr[FieldName.postCode.ordinal()] = 8;
                f32628a = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(int i11, FieldName fieldName, boolean z11, FieldType fieldType, String str, List list, p pVar, String str2, q1 q1Var) {
            super(i11, q1Var);
            if (3 != (i11 & 3)) {
                h1.a(i11, 3, a.f32626a.getDescriptor());
            }
            this.f32619b = fieldName;
            this.f32620c = z11;
            if ((i11 & 4) == 0) {
                this.f32621d = null;
            } else {
                this.f32621d = fieldType;
            }
            if ((i11 & 8) == 0) {
                this.f32622e = null;
            } else {
                this.f32622e = str;
            }
            if ((i11 & 16) == 0) {
                this.f32623f = null;
            } else {
                this.f32623f = list;
            }
            if ((i11 & 32) == 0) {
                this.f32624g = null;
            } else {
                this.f32624g = pVar;
            }
            if ((i11 & 64) == 0) {
                this.f32625h = null;
            } else {
                this.f32625h = str2;
            }
        }

        public static /* synthetic */ void B() {
        }

        public static /* synthetic */ void l() {
        }

        public static /* synthetic */ void n() {
        }

        public static /* synthetic */ void p() {
        }

        public static /* synthetic */ void r() {
        }

        public static /* synthetic */ void t() {
        }

        public static /* synthetic */ void v() {
        }

        public final boolean A() {
            return this.f32620c;
        }

        public final d a(FieldName fieldName, boolean z11, FieldType fieldType, String str, List<String> list, p pVar, String str2) {
            return new d(fieldName, z11, fieldType, str, list, pVar, str2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0 = r0.getValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String b() {
            /*
                r1 = this;
                com.sumsub.sns.internal.core.data.model.FieldName r0 = r1.f32619b
                if (r0 == 0) goto L_0x000a
                java.lang.String r0 = r0.getValue()
                if (r0 != 0) goto L_0x000c
            L_0x000a:
                java.lang.String r0 = ""
            L_0x000c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.h.d.b():java.lang.String");
        }

        public String c() {
            return com.sumsub.sns.internal.core.common.i.a((Object) this) + ", name=" + this.f32619b + ", type=" + this.f32621d;
        }

        public final FieldName d() {
            return this.f32619b;
        }

        public int describeContents() {
            return 0;
        }

        public final boolean e() {
            return this.f32620c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f32619b == dVar.f32619b && this.f32620c == dVar.f32620c && this.f32621d == dVar.f32621d && x.b(this.f32622e, dVar.f32622e) && x.b(this.f32623f, dVar.f32623f) && x.b(this.f32624g, dVar.f32624g) && x.b(this.f32625h, dVar.f32625h);
        }

        public final FieldType f() {
            return this.f32621d;
        }

        public final String g() {
            return this.f32622e;
        }

        public final List<String> h() {
            return this.f32623f;
        }

        public int hashCode() {
            FieldName fieldName = this.f32619b;
            int i11 = 0;
            int hashCode = (fieldName == null ? 0 : fieldName.hashCode()) * 31;
            boolean z11 = this.f32620c;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode + (z11 ? 1 : 0)) * 31;
            FieldType fieldType = this.f32621d;
            int hashCode2 = (i12 + (fieldType == null ? 0 : fieldType.hashCode())) * 31;
            String str = this.f32622e;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            List<String> list = this.f32623f;
            int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            p pVar = this.f32624g;
            int hashCode5 = (hashCode4 + (pVar == null ? 0 : pVar.hashCode())) * 31;
            String str2 = this.f32625h;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode5 + i11;
        }

        public final p i() {
            return this.f32624g;
        }

        public final String j() {
            return this.f32625h;
        }

        public final p k() {
            return this.f32624g;
        }

        public final String m() {
            return this.f32622e;
        }

        public final List<String> o() {
            return this.f32623f;
        }

        public final FieldName q() {
            return this.f32619b;
        }

        public final String s() {
            return this.f32625h;
        }

        public String toString() {
            return "Field(name=" + this.f32619b + ", isRequired=" + this.f32620c + ", type=" + this.f32621d + ", mask=" + this.f32622e + ", masks=" + this.f32623f + ", format=" + this.f32624g + ", placeholder=" + this.f32625h + ')';
        }

        public final FieldType u() {
            return this.f32621d;
        }

        public final boolean w() {
            FieldName fieldName = this.f32619b;
            switch (fieldName == null ? -1 : C0340d.f32628a[fieldName.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        }

        public void writeToParcel(Parcel parcel, int i11) {
            FieldName fieldName = this.f32619b;
            if (fieldName == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(fieldName.name());
            }
            parcel.writeInt(this.f32620c ? 1 : 0);
            FieldType fieldType = this.f32621d;
            if (fieldType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(fieldType.name());
            }
            parcel.writeString(this.f32622e);
            parcel.writeStringList(this.f32623f);
            parcel.writeParcelable(this.f32624g, i11);
            parcel.writeString(this.f32625h);
        }

        public final boolean x() {
            String value;
            FieldName fieldName = this.f32619b;
            if (fieldName == null || (value = fieldName.getValue()) == null) {
                return false;
            }
            return i.a(value);
        }

        public final boolean y() {
            FieldName fieldName = this.f32619b;
            return fieldName == FieldName.dob || fieldName == FieldName.issuedDate || this.f32621d == FieldType.date;
        }

        public final boolean z() {
            return !x() && !w();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(FieldName fieldName, boolean z11, FieldType fieldType, String str, List list, p pVar, String str2, int i11, r rVar) {
            this(fieldName, z11, (i11 & 4) != 0 ? null : fieldType, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : list, (i11 & 32) != 0 ? null : pVar, (i11 & 64) != 0 ? null : str2);
        }

        public static /* synthetic */ d a(d dVar, FieldName fieldName, boolean z11, FieldType fieldType, String str, List<String> list, p pVar, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                fieldName = dVar.f32619b;
            }
            if ((i11 & 2) != 0) {
                z11 = dVar.f32620c;
            }
            boolean z12 = z11;
            if ((i11 & 4) != 0) {
                fieldType = dVar.f32621d;
            }
            FieldType fieldType2 = fieldType;
            if ((i11 & 8) != 0) {
                str = dVar.f32622e;
            }
            String str3 = str;
            if ((i11 & 16) != 0) {
                list = dVar.f32623f;
            }
            List<String> list2 = list;
            if ((i11 & 32) != 0) {
                pVar = dVar.f32624g;
            }
            p pVar2 = pVar;
            if ((i11 & 64) != 0) {
                str2 = dVar.f32625h;
            }
            return dVar.a(fieldName, z12, fieldType2, str3, list2, pVar2, str2);
        }

        public d(FieldName fieldName, boolean z11, FieldType fieldType, String str, List<String> list, p pVar, String str2) {
            super((r) null);
            this.f32619b = fieldName;
            this.f32620c = z11;
            this.f32621d = fieldType;
            this.f32622e = str;
            this.f32623f = list;
            this.f32624g = pVar;
            this.f32625h = str2;
        }

        public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            h.a(dVar, bVar, fVar);
            boolean z11 = false;
            bVar.y(fVar, 0, FieldName.a.C0331a.f32361a, dVar.f32619b);
            bVar.o(fVar, 1, dVar.f32620c);
            if (bVar.q(fVar, 2) || dVar.f32621d != null) {
                bVar.y(fVar, 2, new EnumSerializer("com.sumsub.sns.internal.core.data.model.FieldType", FieldType.values()), dVar.f32621d);
            }
            if (bVar.q(fVar, 3) || dVar.f32622e != null) {
                bVar.y(fVar, 3, v1.f57779a, dVar.f32622e);
            }
            if (bVar.q(fVar, 4) || dVar.f32623f != null) {
                bVar.y(fVar, 4, new kotlinx.serialization.internal.e(v1.f57779a), dVar.f32623f);
            }
            if (bVar.q(fVar, 5) || dVar.f32624g != null) {
                bVar.y(fVar, 5, p.e.a.f32673a, dVar.f32624g);
            }
            if (bVar.q(fVar, 6) || dVar.f32625h != null) {
                z11 = true;
            }
            if (z11) {
                bVar.y(fVar, 6, v1.f57779a, dVar.f32625h);
            }
        }
    }

    public static abstract class e extends h {

        public static final class a extends e {

            /* renamed from: b  reason: collision with root package name */
            public final String f32629b;

            /* renamed from: c  reason: collision with root package name */
            public final int f32630c;

            /* renamed from: d  reason: collision with root package name */
            public final List<C0341a> f32631d;

            /* renamed from: com.sumsub.sns.internal.core.data.model.h$e$a$a  reason: collision with other inner class name */
            public static final class C0341a {

                /* renamed from: a  reason: collision with root package name */
                public final String f32632a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32633b;

                public C0341a(String str, String str2) {
                    this.f32632a = str;
                    this.f32633b = str2;
                }

                public final String a() {
                    return this.f32632a;
                }

                public final String b() {
                    return this.f32633b;
                }

                public final String c() {
                    return this.f32632a;
                }

                public final String d() {
                    return this.f32633b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0341a)) {
                        return false;
                    }
                    C0341a aVar = (C0341a) obj;
                    return x.b(this.f32632a, aVar.f32632a) && x.b(this.f32633b, aVar.f32633b);
                }

                public int hashCode() {
                    return (this.f32632a.hashCode() * 31) + this.f32633b.hashCode();
                }

                public String toString() {
                    return "DropDownItem(id=" + this.f32632a + ", label=" + this.f32633b + ')';
                }

                public final C0341a a(String str, String str2) {
                    return new C0341a(str, str2);
                }

                public static /* synthetic */ C0341a a(C0341a aVar, String str, String str2, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = aVar.f32632a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = aVar.f32633b;
                    }
                    return aVar.a(str, str2);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(String str, int i11, List list, int i12, r rVar) {
                this(str, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? CollectionsKt__CollectionsKt.k() : list);
            }

            public final a a(String str, int i11, List<C0341a> list) {
                return new a(str, i11, list);
            }

            public final String d() {
                return this.f32629b;
            }

            public final int e() {
                return this.f32630c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return x.b(this.f32629b, aVar.f32629b) && this.f32630c == aVar.f32630c && x.b(this.f32631d, aVar.f32631d);
            }

            public final List<C0341a> f() {
                return this.f32631d;
            }

            public final int g() {
                return this.f32630c;
            }

            public final List<C0341a> h() {
                return this.f32631d;
            }

            public int hashCode() {
                String str = this.f32629b;
                return ((((str == null ? 0 : str.hashCode()) * 31) + this.f32630c) * 31) + this.f32631d.hashCode();
            }

            public final String i() {
                return this.f32629b;
            }

            public String toString() {
                return "Dropdown(label=" + this.f32629b + ", currentSelectedItem=" + this.f32630c + ", items=" + this.f32631d + ')';
            }

            public static /* synthetic */ a a(a aVar, String str, int i11, List<C0341a> list, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    str = aVar.f32629b;
                }
                if ((i12 & 2) != 0) {
                    i11 = aVar.f32630c;
                }
                if ((i12 & 4) != 0) {
                    list = aVar.f32631d;
                }
                return aVar.a(str, i11, list);
            }

            public a(String str, int i11, List<C0341a> list) {
                super((r) null);
                this.f32629b = str;
                this.f32630c = i11;
                this.f32631d = list;
            }
        }

        public static final class b extends e {

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f32634b;

            public b(CharSequence charSequence) {
                super((r) null);
                this.f32634b = charSequence;
            }

            public final b a(CharSequence charSequence) {
                return new b(charSequence);
            }

            public final CharSequence d() {
                return this.f32634b;
            }

            public final CharSequence e() {
                return this.f32634b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && x.b(this.f32634b, ((b) obj).f32634b);
            }

            public int hashCode() {
                return this.f32634b.hashCode();
            }

            public String toString() {
                return "Text(text=" + this.f32634b + ')';
            }

            public static /* synthetic */ b a(b bVar, CharSequence charSequence, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    charSequence = bVar.f32634b;
                }
                return bVar.a(charSequence);
            }
        }

        public /* synthetic */ e(r rVar) {
            this();
        }

        public String b() {
            return c();
        }

        public e() {
            super((r) null);
        }
    }

    public /* synthetic */ h(r rVar) {
        this();
    }

    public static final void a(h hVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
    }

    public abstract String b();

    public String c() {
        return com.sumsub.sns.internal.core.common.i.a((Object) this);
    }

    public h() {
    }

    public /* synthetic */ h(int i11, q1 q1Var) {
    }
}
