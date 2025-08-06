package com.sumsub.sns.internal.ff.model;

import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0002\b\nB'\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!B;\b\u0017\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b \u0010%J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J)\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\r\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/sumsub/sns/internal/ff/model/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "", "c", "experiment", "enabled", "value", "toString", "", "hashCode", "other", "equals", "Z", "f", "()Z", "getExperiment$annotations", "()V", "d", "getEnabled$annotations", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getValue$annotations", "<init>", "(ZZLjava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(IZZLjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0388b Companion = new C0388b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f34257a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f34258b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34259c;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f34260a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f34261b;

        static {
            a aVar = new a();
            f34260a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.ff.model.RemoteFeatureFlag", aVar, 3);
            pluginGeneratedSerialDescriptor.k("experiment", true);
            pluginGeneratedSerialDescriptor.k(Constants.ENABLED, true);
            pluginGeneratedSerialDescriptor.k("value", true);
            f34261b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.ff.model.b deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 2
                r4 = 1
                r5 = 0
                r6 = 0
                if (r2 == 0) goto L_0x0027
                boolean r2 = r1.C(r0, r5)
                boolean r4 = r1.C(r0, r4)
                kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r3 = r1.j(r0, r3, r5, r6)
                r5 = 7
                r12 = r2
                r13 = r4
                r11 = r5
                goto L_0x005e
            L_0x0027:
                r9 = r4
                r2 = r5
                r7 = r2
                r8 = r6
                r6 = r7
            L_0x002c:
                if (r9 == 0) goto L_0x005a
                int r10 = r1.w(r0)
                r11 = -1
                if (r10 == r11) goto L_0x0058
                if (r10 == 0) goto L_0x0051
                if (r10 == r4) goto L_0x004a
                if (r10 != r3) goto L_0x0044
                kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r3, r10, r8)
                r7 = r7 | 4
                goto L_0x002c
            L_0x0044:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r10)
                throw r0
            L_0x004a:
                boolean r6 = r1.C(r0, r4)
                r7 = r7 | 2
                goto L_0x002c
            L_0x0051:
                boolean r2 = r1.C(r0, r5)
                r7 = r7 | 1
                goto L_0x002c
            L_0x0058:
                r9 = r5
                goto L_0x002c
            L_0x005a:
                r12 = r2
                r13 = r6
                r11 = r7
                r3 = r8
            L_0x005e:
                r1.c(r0)
                com.sumsub.sns.internal.ff.model.b r0 = new com.sumsub.sns.internal.ff.model.b
                r14 = r3
                java.lang.String r14 = (java.lang.String) r14
                r15 = 0
                r10 = r0
                r10.<init>((int) r11, (boolean) r12, (boolean) r13, (java.lang.String) r14, (kotlinx.serialization.internal.q1) r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ff.model.b.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.ff.model.b");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            h hVar = h.f57720a;
            return new kotlinx.serialization.b[]{hVar, hVar, h10.a.u(v1.f57779a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f34261b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, b bVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            b.a(bVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    /* renamed from: com.sumsub.sns.internal.ff.model.b$b  reason: collision with other inner class name */
    public static final class C0388b {
        public /* synthetic */ C0388b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f34260a;
        }

        public C0388b() {
        }
    }

    public b() {
        this(false, false, (String) null, 7, (r) null);
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final boolean a() {
        return this.f34257a;
    }

    public final boolean b() {
        return this.f34258b;
    }

    public final String c() {
        return this.f34259c;
    }

    public final boolean d() {
        return this.f34258b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f34257a == bVar.f34257a && this.f34258b == bVar.f34258b && x.b(this.f34259c, bVar.f34259c);
    }

    public final boolean f() {
        return this.f34257a;
    }

    public final String h() {
        return this.f34259c;
    }

    public int hashCode() {
        boolean z11 = this.f34257a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.f34258b;
        if (!z13) {
            z12 = z13;
        }
        int i12 = (i11 + (z12 ? 1 : 0)) * 31;
        String str = this.f34259c;
        return i12 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RemoteFeatureFlag(experiment=" + this.f34257a + ", enabled=" + this.f34258b + ", value=" + this.f34259c + ')';
    }

    public /* synthetic */ b(int i11, boolean z11, boolean z12, String str, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f34260a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f34257a = false;
        } else {
            this.f34257a = z11;
        }
        if ((i11 & 2) == 0) {
            this.f34258b = false;
        } else {
            this.f34258b = z12;
        }
        if ((i11 & 4) == 0) {
            this.f34259c = null;
        } else {
            this.f34259c = str;
        }
    }

    public final b a(boolean z11, boolean z12, String str) {
        return new b(z11, z12, str);
    }

    public b(boolean z11, boolean z12, String str) {
        this.f34257a = z11;
        this.f34258b = z12;
        this.f34259c = str;
    }

    public static /* synthetic */ b a(b bVar, boolean z11, boolean z12, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = bVar.f34257a;
        }
        if ((i11 & 2) != 0) {
            z12 = bVar.f34258b;
        }
        if ((i11 & 4) != 0) {
            str = bVar.f34259c;
        }
        return bVar.a(z11, z12, str);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar2.q(fVar, 0) || bVar.f34257a) {
            bVar2.o(fVar, 0, bVar.f34257a);
        }
        if (bVar2.q(fVar, 1) || bVar.f34258b) {
            bVar2.o(fVar, 1, bVar.f34258b);
        }
        if (bVar2.q(fVar, 2) || bVar.f34259c != null) {
            z11 = true;
        }
        if (z11) {
            bVar2.y(fVar, 2, v1.f57779a, bVar.f34259c);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(boolean z11, boolean z12, String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12, (i11 & 4) != 0 ? null : str);
    }
}
