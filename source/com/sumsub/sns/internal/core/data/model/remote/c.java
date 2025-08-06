package com.sumsub.sns.internal.core.data.model.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.sumsub.sns.internal.core.common.n0;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ,2\u00020\u0001:\u0002\b\u000fB!\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b&\u0010'B9\b\u0017\u0012\u0006\u0010(\u001a\u00020\n\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b&\u0010+J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000b\u0010\b\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J%\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0001J\t\u0010\u0012\u001a\u00020\fHÖ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nHÖ\u0001R\"\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\"\u0012\u0004\b%\u0010!\u001a\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/c;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "h", "", "g", "", "raw", "", "b", "countryCode", "masks", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getCountryCode$annotations", "()V", "Ljava/util/List;", "e", "()Ljava/util/List;", "getMasks$annotations", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new C0346c();
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32705a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f32706b;

    public static final class a implements d0<c> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32707a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32708b;

        static {
            a aVar = new a();
            f32707a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.Mask", aVar, 2);
            pluginGeneratedSerialDescriptor.k("countryCode", true);
            pluginGeneratedSerialDescriptor.k("masks", false);
            f32708b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public c deserialize(kotlinx.serialization.encoding.c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.p(descriptor, 1, new e(v1Var), null);
                i11 = 3;
            } else {
                obj2 = null;
                Object obj3 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj2 = b11.p(descriptor, 1, new e(v1.f57779a), obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new c(i11, (String) obj, (List) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), new e(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32708b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, c cVar) {
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

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
            if (r7 == null) goto L_0x0044;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.String r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r1 = r8.length()
                r2 = 0
                r3 = r2
            L_0x000b:
                if (r3 >= r1) goto L_0x001d
                char r4 = r8.charAt(r3)
                boolean r5 = java.lang.Character.isDigit(r4)
                if (r5 == 0) goto L_0x001a
                r0.append(r4)
            L_0x001a:
                int r3 = r3 + 1
                goto L_0x000b
            L_0x001d:
                java.lang.String r8 = r0.toString()
                if (r7 == 0) goto L_0x0044
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r1 = r7.length()
            L_0x002c:
                if (r2 >= r1) goto L_0x003e
                char r3 = r7.charAt(r2)
                boolean r4 = java.lang.Character.isDigit(r3)
                if (r4 == 0) goto L_0x003b
                r0.append(r3)
            L_0x003b:
                int r2 = r2 + 1
                goto L_0x002c
            L_0x003e:
                java.lang.String r7 = r0.toString()
                if (r7 != 0) goto L_0x0046
            L_0x0044:
                java.lang.String r7 = ""
            L_0x0046:
                java.lang.String r7 = kotlin.text.StringsKt__StringsKt.A0(r8, r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.c.b.a(java.lang.String, java.lang.String):java.lang.String");
        }

        public final kotlinx.serialization.b<c> serializer() {
            return a.f32707a;
        }

        public b() {
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.data.model.remote.c$c  reason: collision with other inner class name */
    public static final class C0346c implements Parcelable.Creator<c> {
        /* renamed from: a */
        public final c createFromParcel(Parcel parcel) {
            return new c(parcel.readString(), parcel.createStringArrayList());
        }

        /* renamed from: a */
        public final c[] newArray(int i11) {
            return new c[i11];
        }
    }

    public /* synthetic */ c(int i11, String str, List list, q1 q1Var) {
        if (2 != (i11 & 2)) {
            h1.a(i11, 2, a.f32707a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32705a = null;
        } else {
            this.f32705a = str;
        }
        this.f32706b = list;
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f32705a;
    }

    public final List<String> b() {
        return this.f32706b;
    }

    public final String c() {
        return this.f32705a;
    }

    public int describeContents() {
        return 0;
    }

    public final List<String> e() {
        return this.f32706b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f32705a, cVar.f32705a) && x.b(this.f32706b, cVar.f32706b);
    }

    public final int g() {
        T t11;
        Iterator<T> it2 = this.f32706b.iterator();
        if (!it2.hasNext()) {
            t11 = null;
        } else {
            T next = it2.next();
            if (!it2.hasNext()) {
                t11 = next;
            } else {
                int length = ((String) next).length();
                do {
                    T next2 = it2.next();
                    int length2 = ((String) next2).length();
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
            t11 = next;
        }
        String str = (String) t11;
        if (str == null) {
            str = n0.h.f32190m;
        }
        StringBuilder sb2 = new StringBuilder();
        int length3 = str.length();
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 < length3) {
                char charAt = str.charAt(i11);
                if (charAt != '#' && !Character.isDigit(charAt)) {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(charAt);
                }
                i11++;
            } else {
                return (str.length() - sb2.toString().length()) + 15 + 1 + 1;
            }
        }
    }

    public final c h() {
        List<String> list = this.f32706b;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (String G : list) {
            arrayList.add(StringsKt__StringsKt.i1(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(G, "[^0-9]", "#", false, 4, (Object) null), "(", " ", false, 4, (Object) null), ")", " ", false, 4, (Object) null), Constants.ACCEPT_TIME_SEPARATOR_SERVER, " ", false, 4, (Object) null), "+", " ", false, 4, (Object) null), "  ", " ", false, 4, (Object) null)).toString());
        }
        return a(this, (String) null, arrayList, 1, (Object) null);
    }

    public int hashCode() {
        String str = this.f32705a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f32706b.hashCode();
    }

    public String toString() {
        return "Mask(countryCode=" + this.f32705a + ", masks=" + this.f32706b + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f32705a);
        parcel.writeStringList(this.f32706b);
    }

    public c(String str, List<String> list) {
        this.f32705a = str;
        this.f32706b = list;
    }

    public final c a(String str, List<String> list) {
        return new c(str, list);
    }

    public static /* synthetic */ c a(c cVar, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cVar.f32705a;
        }
        if ((i11 & 2) != 0) {
            list = cVar.f32706b;
        }
        return cVar.a(str, list);
    }

    public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || cVar.f32705a != null) {
            bVar.y(fVar, 0, v1.f57779a, cVar.f32705a);
        }
        bVar.F(fVar, 1, new e(v1.f57779a), cVar.f32706b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, list);
    }

    public final String a(String str) {
        return Companion.a(this.f32705a, str);
    }
}
