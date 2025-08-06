package com.sumsub.sns.internal.core.data.model.remote.response;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/a;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "token", "userId", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getToken$annotations", "()V", "e", "getUserId$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32798a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32799b;

    /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.a$a  reason: collision with other inner class name */
    public static final class C0348a implements d0<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0348a f32800a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32801b;

        static {
            C0348a aVar = new C0348a();
            f32800a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.AccessTokenResponse", aVar, 2);
            pluginGeneratedSerialDescriptor.k("token", true);
            pluginGeneratedSerialDescriptor.k("userId", true);
            f32801b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public a deserialize(c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                v1 v1Var = v1.f57779a;
                obj = b11.j(descriptor, 0, v1Var, null);
                obj2 = b11.j(descriptor, 1, v1Var, null);
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
                        obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new a(i11, (String) obj, (String) obj2, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32801b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, a aVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            a.a(aVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<a> serializer() {
            return C0348a.f32800a;
        }

        public b() {
        }
    }

    public a() {
        this((String) null, (String) null, 3, (r) null);
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f32798a;
    }

    public final String b() {
        return this.f32799b;
    }

    public final String c() {
        return this.f32798a;
    }

    public final String e() {
        return this.f32799b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f32798a, aVar.f32798a) && x.b(this.f32799b, aVar.f32799b);
    }

    public int hashCode() {
        String str = this.f32798a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32799b;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "AccessTokenResponse(token=" + this.f32798a + ", userId=" + this.f32799b + ')';
    }

    public /* synthetic */ a(int i11, String str, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, C0348a.f32800a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32798a = null;
        } else {
            this.f32798a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32799b = null;
        } else {
            this.f32799b = str2;
        }
    }

    public final a a(String str, String str2) {
        return new a(str, str2);
    }

    public a(String str, String str2) {
        this.f32798a = str;
        this.f32799b = str2;
    }

    public static /* synthetic */ a a(a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = aVar.f32798a;
        }
        if ((i11 & 2) != 0) {
            str2 = aVar.f32799b;
        }
        return aVar.a(str, str2);
    }

    public static final void a(a aVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || aVar.f32798a != null) {
            bVar.y(fVar, 0, v1.f57779a, aVar.f32798a);
        }
        if (bVar.q(fVar, 1) || aVar.f32799b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, aVar.f32799b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
