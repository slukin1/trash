package com.sumsub.sns.internal.core.data.model.remote;

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

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u001b\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/e;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "key", "value", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getKey$annotations", "()V", "e", "getValue$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class e {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32715a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32716b;

    public static final class a implements d0<e> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32717a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32718b;

        static {
            a aVar = new a();
            f32717a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.Metavalue", aVar, 2);
            pluginGeneratedSerialDescriptor.k("key", false);
            pluginGeneratedSerialDescriptor.k("value", true);
            f32718b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public e deserialize(c cVar) {
            int i11;
            Object obj;
            String str;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                str = b11.i(descriptor, 0);
                obj = b11.j(descriptor, 1, v1.f57779a, null);
                i11 = 3;
            } else {
                str = null;
                Object obj2 = null;
                int i12 = 0;
                boolean z11 = true;
                while (z11) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        z11 = false;
                    } else if (w11 == 0) {
                        str = b11.i(descriptor, 0);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj2;
                i11 = i12;
            }
            b11.c(descriptor);
            return new e(i11, str, (String) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32718b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, e eVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            e.a(eVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<e> serializer() {
            return a.f32717a;
        }

        public b() {
        }
    }

    public /* synthetic */ e(int i11, String str, String str2, q1 q1Var) {
        if (1 != (i11 & 1)) {
            h1.a(i11, 1, a.f32717a.getDescriptor());
        }
        this.f32715a = str;
        if ((i11 & 2) == 0) {
            this.f32716b = null;
        } else {
            this.f32716b = str2;
        }
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String a() {
        return this.f32715a;
    }

    public final String b() {
        return this.f32716b;
    }

    public final String c() {
        return this.f32715a;
    }

    public final String e() {
        return this.f32716b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f32715a, eVar.f32715a) && x.b(this.f32716b, eVar.f32716b);
    }

    public int hashCode() {
        int hashCode = this.f32715a.hashCode() * 31;
        String str = this.f32716b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Metavalue(key=" + this.f32715a + ", value=" + this.f32716b + ')';
    }

    public e(String str, String str2) {
        this.f32715a = str;
        this.f32716b = str2;
    }

    public final e a(String str, String str2) {
        return new e(str, str2);
    }

    public static /* synthetic */ e a(e eVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = eVar.f32715a;
        }
        if ((i11 & 2) != 0) {
            str2 = eVar.f32716b;
        }
        return eVar.a(str, str2);
    }

    public static final void a(e eVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        bVar.p(fVar, 0, eVar.f32715a);
        if (bVar.q(fVar, 1) || eVar.f32716b != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 1, v1.f57779a, eVar.f32716b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, String str2, int i11, r rVar) {
        this(str, (i11 & 2) != 0 ? null : str2);
    }
}
