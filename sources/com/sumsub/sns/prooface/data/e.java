package com.sumsub.sns.prooface.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0003\b\u0010\u000bB1\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u001bBE\b\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010 J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\b\u0010\fR(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/sumsub/sns/prooface/data/e;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getClientErrorName$annotations", "()V", "clientErrorName", "b", "getClientErrorMessage$annotations", "clientErrorMessage", "", "Lcom/sumsub/sns/prooface/data/e$c;", "Ljava/util/List;", "e", "()Ljava/util/List;", "getVideoDevices$annotations", "videoDevices", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class e {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f40186a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40187b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c> f40188c;

    public static final class a implements d0<e> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f40189a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f40190b;

        static {
            a aVar = new a();
            f40189a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.prooface.data.LivenessClientError", aVar, 3);
            pluginGeneratedSerialDescriptor.k("clientErrorName", true);
            pluginGeneratedSerialDescriptor.k("clientErrorMessage", true);
            pluginGeneratedSerialDescriptor.k("videoDevices", true);
            f40190b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.prooface.data.e deserialize(kotlinx.serialization.encoding.c r13) {
            /*
                r12 = this;
                kotlinx.serialization.descriptors.f r0 = r12.getDescriptor()
                kotlinx.serialization.encoding.a r13 = r13.b(r0)
                boolean r1 = r13.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x002c
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r13.j(r0, r4, r1, r2)
                java.lang.Object r1 = r13.j(r0, r5, r1, r2)
                kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                com.sumsub.sns.prooface.data.e$c$a r6 = com.sumsub.sns.prooface.data.e.c.a.f40192a
                r5.<init>(r6)
                java.lang.Object r2 = r13.j(r0, r3, r5, r2)
                r3 = 7
                r11 = r4
                r4 = r3
                r3 = r11
                goto L_0x006a
            L_0x002c:
                r1 = r2
                r6 = r1
                r7 = r4
                r8 = r5
            L_0x0030:
                if (r8 == 0) goto L_0x0067
                int r9 = r13.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0065
                if (r9 == 0) goto L_0x005c
                if (r9 == r5) goto L_0x0053
                if (r9 != r3) goto L_0x004d
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                com.sumsub.sns.prooface.data.e$c$a r10 = com.sumsub.sns.prooface.data.e.c.a.f40192a
                r9.<init>(r10)
                java.lang.Object r6 = r13.j(r0, r3, r9, r6)
                r7 = r7 | 4
                goto L_0x0030
            L_0x004d:
                kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
                r13.<init>((int) r9)
                throw r13
            L_0x0053:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r13.j(r0, r5, r9, r1)
                r7 = r7 | 2
                goto L_0x0030
            L_0x005c:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r2 = r13.j(r0, r4, r9, r2)
                r7 = r7 | 1
                goto L_0x0030
            L_0x0065:
                r8 = r4
                goto L_0x0030
            L_0x0067:
                r3 = r2
                r2 = r6
                r4 = r7
            L_0x006a:
                r13.c(r0)
                com.sumsub.sns.prooface.data.e r13 = new com.sumsub.sns.prooface.data.e
                r5 = r3
                java.lang.String r5 = (java.lang.String) r5
                r6 = r1
                java.lang.String r6 = (java.lang.String) r6
                r7 = r2
                java.util.List r7 = (java.util.List) r7
                r8 = 0
                r3 = r13
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.util.List) r7, (kotlinx.serialization.internal.q1) r8)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.prooface.data.e.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.prooface.data.e");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(c.a.f40192a))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f40190b;
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
            return a.f40189a;
        }

        public b() {
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\b\u0017B\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010B'\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/prooface/data/e$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getLabel$annotations", "()V", "label", "<init>", "(Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f40191a;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f40192a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f40193b;

            static {
                a aVar = new a();
                f40192a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.prooface.data.LivenessClientError.VideoDevice", aVar, 1);
                pluginGeneratedSerialDescriptor.k("label", true);
                f40193b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public c deserialize(kotlinx.serialization.encoding.c cVar) {
                Object obj;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                int i11 = 1;
                if (b11.k()) {
                    obj = b11.j(descriptor, 0, v1.f57779a, null);
                } else {
                    obj = null;
                    int i12 = 0;
                    while (i11 != 0) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            i11 = 0;
                        } else if (w11 == 0) {
                            obj = b11.j(descriptor, 0, v1.f57779a, obj);
                            i12 |= 1;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor);
                return new c(i11, (String) obj, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f40193b;
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

            public final kotlinx.serialization.b<c> serializer() {
                return a.f40192a;
            }

            public b() {
            }
        }

        public c() {
            this((String) null, 1, (r) null);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            if (bVar.q(fVar, 0) || cVar.f40191a != null) {
                bVar.y(fVar, 0, v1.f57779a, cVar.f40191a);
            }
        }

        public static /* synthetic */ void b() {
        }

        public /* synthetic */ c(int i11, String str, q1 q1Var) {
            if ((i11 & 0) != 0) {
                h1.a(i11, 0, a.f40192a.getDescriptor());
            }
            if ((i11 & 1) == 0) {
                this.f40191a = null;
            } else {
                this.f40191a = str;
            }
        }

        public final String a() {
            return this.f40191a;
        }

        public c(String str) {
            this.f40191a = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(String str, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : str);
        }
    }

    public e() {
        this((String) null, (String) null, (List) null, 7, (r) null);
    }

    public static final void a(e eVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || eVar.f40186a != null) {
            bVar.y(fVar, 0, v1.f57779a, eVar.f40186a);
        }
        if (bVar.q(fVar, 1) || eVar.f40187b != null) {
            bVar.y(fVar, 1, v1.f57779a, eVar.f40187b);
        }
        if (bVar.q(fVar, 2) || eVar.f40188c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, new kotlinx.serialization.internal.e(c.a.f40192a), eVar.f40188c);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String c() {
        return this.f40186a;
    }

    public final List<c> e() {
        return this.f40188c;
    }

    public /* synthetic */ e(int i11, String str, String str2, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f40189a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f40186a = null;
        } else {
            this.f40186a = str;
        }
        if ((i11 & 2) == 0) {
            this.f40187b = null;
        } else {
            this.f40187b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f40188c = null;
        } else {
            this.f40188c = list;
        }
    }

    public final String a() {
        return this.f40187b;
    }

    public e(String str, String str2, List<c> list) {
        this.f40186a = str;
        this.f40187b = str2;
        this.f40188c = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, String str2, List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list);
    }
}
