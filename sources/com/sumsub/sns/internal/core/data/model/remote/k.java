package com.sumsub.sns.internal.core.data.model.remote;

import com.facebook.appevents.UserDataStore;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.remote.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 A2\u00020\u0001:\u0002\b\nBm\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b;\u0010<B\u0001\b\u0017\u0012\u0006\u0010=\u001a\u00020\u001b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b;\u0010@J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003Jo\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\"\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010 \u0012\u0004\b&\u0010$\u001a\u0004\b%\u0010\"R\"\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010'\u0012\u0004\b*\u0010$\u001a\u0004\b(\u0010)R(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010+\u0012\u0004\b.\u0010$\u001a\u0004\b,\u0010-R(\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010+\u0012\u0004\b0\u0010$\u001a\u0004\b/\u0010-R(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010+\u0012\u0004\b2\u0010$\u001a\u0004\b1\u0010-R*\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0012\u0010 \u0012\u0004\b5\u0010$\u001a\u0004\b3\u0010\"\"\u0004\b\b\u00104R\u0011\u00108\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006B"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/k;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", "c", "", "d", "e", "Lcom/sumsub/sns/internal/core/data/model/remote/e;", "f", "g", "idDocType", "country", "idDocSubType", "warnings", "errors", "metadata", "imageId", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "getIdDocType$annotations", "()V", "h", "getCountry$annotations", "Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", "m", "()Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", "getIdDocSubType$annotations", "Ljava/util/List;", "u", "()Ljava/util/List;", "getWarnings$annotations", "j", "getErrors$annotations", "s", "getMetadata$annotations", "q", "(Ljava/lang/String;)V", "getImageId$annotations", "w", "()Z", "isFatal", "l", "hasErrors", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/IdentitySide;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/IdentitySide;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class k {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32767a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32768b;

    /* renamed from: c  reason: collision with root package name */
    public final IdentitySide f32769c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f32770d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f32771e;

    /* renamed from: f  reason: collision with root package name */
    public final List<e> f32772f;

    /* renamed from: g  reason: collision with root package name */
    public String f32773g;

    public static final class a implements d0<k> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32774a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32775b;

        static {
            a aVar = new a();
            f32774a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteIdDoc", aVar, 7);
            pluginGeneratedSerialDescriptor.k("idDocType", true);
            pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, true);
            pluginGeneratedSerialDescriptor.k("idDocSubType", true);
            pluginGeneratedSerialDescriptor.k("warnings", true);
            pluginGeneratedSerialDescriptor.k("errors", true);
            pluginGeneratedSerialDescriptor.k("metadata", true);
            pluginGeneratedSerialDescriptor.k("imageId", true);
            f32775b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a2, code lost:
            r3 = 6;
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c0, code lost:
            r4 = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.k deserialize(kotlinx.serialization.encoding.c r18) {
            /*
                r17 = this;
                kotlinx.serialization.descriptors.f r0 = r17.getDescriptor()
                r1 = r18
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 6
                r4 = 5
                r5 = 3
                r6 = 4
                r7 = 2
                r8 = 0
                r9 = 1
                r10 = 0
                if (r2 == 0) goto L_0x004f
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r2, r10)
                java.lang.Object r9 = r1.j(r0, r9, r2, r10)
                com.sumsub.sns.internal.core.data.model.IdentitySide$a r11 = com.sumsub.sns.internal.core.data.model.IdentitySide.a.f32363a
                java.lang.Object r7 = r1.j(r0, r7, r11, r10)
                kotlinx.serialization.internal.e r11 = new kotlinx.serialization.internal.e
                r11.<init>(r2)
                java.lang.Object r5 = r1.j(r0, r5, r11, r10)
                kotlinx.serialization.internal.e r11 = new kotlinx.serialization.internal.e
                r11.<init>(r2)
                java.lang.Object r6 = r1.j(r0, r6, r11, r10)
                kotlinx.serialization.internal.e r11 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.remote.e$a r12 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                r11.<init>(r12)
                java.lang.Object r4 = r1.j(r0, r4, r11, r10)
                java.lang.Object r2 = r1.j(r0, r3, r2, r10)
                r3 = 127(0x7f, float:1.78E-43)
                r15 = r4
                r4 = r3
                goto L_0x00c9
            L_0x004f:
                r2 = r8
                r16 = r9
                r8 = r10
                r11 = r8
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x0058:
                if (r16 == 0) goto L_0x00c2
                int r9 = r1.w(r0)
                switch(r9) {
                    case -1: goto L_0x00bc;
                    case 0: goto L_0x00b0;
                    case 1: goto L_0x00a5;
                    case 2: goto L_0x009a;
                    case 3: goto L_0x008c;
                    case 4: goto L_0x007e;
                    case 5: goto L_0x0070;
                    case 6: goto L_0x0067;
                    default: goto L_0x0061;
                }
            L_0x0061:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r9)
                throw r0
            L_0x0067:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r3, r9, r8)
                r2 = r2 | 64
                goto L_0x00a3
            L_0x0070:
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                com.sumsub.sns.internal.core.data.model.remote.e$a r3 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                r9.<init>(r3)
                java.lang.Object r15 = r1.j(r0, r4, r9, r15)
                r2 = r2 | 32
                goto L_0x00a2
            L_0x007e:
                kotlinx.serialization.internal.e r3 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                r3.<init>(r9)
                java.lang.Object r14 = r1.j(r0, r6, r3, r14)
                r2 = r2 | 16
                goto L_0x00a2
            L_0x008c:
                kotlinx.serialization.internal.e r3 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                r3.<init>(r9)
                java.lang.Object r13 = r1.j(r0, r5, r3, r13)
                r2 = r2 | 8
                goto L_0x00a2
            L_0x009a:
                com.sumsub.sns.internal.core.data.model.IdentitySide$a r3 = com.sumsub.sns.internal.core.data.model.IdentitySide.a.f32363a
                java.lang.Object r12 = r1.j(r0, r7, r3, r12)
                r2 = r2 | 4
            L_0x00a2:
                r3 = 6
            L_0x00a3:
                r9 = 1
                goto L_0x0058
            L_0x00a5:
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                r9 = 1
                java.lang.Object r11 = r1.j(r0, r9, r3, r11)
                r2 = r2 | 2
                r3 = 6
                goto L_0x0058
            L_0x00b0:
                r9 = 1
                kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                r4 = 0
                java.lang.Object r10 = r1.j(r0, r4, r3, r10)
                r2 = r2 | 1
                r3 = 6
                goto L_0x00c0
            L_0x00bc:
                r4 = 0
                r9 = 1
                r16 = r4
            L_0x00c0:
                r4 = 5
                goto L_0x0058
            L_0x00c2:
                r4 = r2
                r2 = r8
                r8 = r10
                r9 = r11
                r7 = r12
                r5 = r13
                r6 = r14
            L_0x00c9:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.k r0 = new com.sumsub.sns.internal.core.data.model.remote.k
                r1 = r8
                java.lang.String r1 = (java.lang.String) r1
                r8 = r9
                java.lang.String r8 = (java.lang.String) r8
                com.sumsub.sns.internal.core.data.model.IdentitySide r7 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r7
                r9 = r5
                java.util.List r9 = (java.util.List) r9
                r10 = r6
                java.util.List r10 = (java.util.List) r10
                r11 = r15
                java.util.List r11 = (java.util.List) r11
                java.lang.String r2 = (java.lang.String) r2
                r12 = 0
                r3 = r0
                r5 = r1
                r6 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r2
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (com.sumsub.sns.internal.core.data.model.IdentitySide) r7, (java.util.List) r8, (java.util.List) r9, (java.util.List) r10, (java.lang.String) r11, (kotlinx.serialization.internal.q1) r12)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.k.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.k");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(IdentitySide.a.f32363a), h10.a.u(new e(v1Var)), h10.a.u(new e(v1Var)), h10.a.u(new e(e.a.f32717a)), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32775b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, k kVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            k.a(kVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<k> serializer() {
            return a.f32774a;
        }

        public b() {
        }
    }

    public k() {
        this((String) null, (String) null, (IdentitySide) null, (List) null, (List) null, (List) null, (String) null, 127, (r) null);
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
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

    public final String a() {
        return this.f32767a;
    }

    public final String b() {
        return this.f32768b;
    }

    public final IdentitySide c() {
        return this.f32769c;
    }

    public final List<String> d() {
        return this.f32770d;
    }

    public final List<String> e() {
        return this.f32771e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return x.b(this.f32767a, kVar.f32767a) && x.b(this.f32768b, kVar.f32768b) && this.f32769c == kVar.f32769c && x.b(this.f32770d, kVar.f32770d) && x.b(this.f32771e, kVar.f32771e) && x.b(this.f32772f, kVar.f32772f) && x.b(this.f32773g, kVar.f32773g);
    }

    public final List<e> f() {
        return this.f32772f;
    }

    public final String g() {
        return this.f32773g;
    }

    public final String h() {
        return this.f32768b;
    }

    public int hashCode() {
        String str = this.f32767a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32768b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        IdentitySide identitySide = this.f32769c;
        int hashCode3 = (hashCode2 + (identitySide == null ? 0 : identitySide.hashCode())) * 31;
        List<String> list = this.f32770d;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.f32771e;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<e> list3 = this.f32772f;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str3 = this.f32773g;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode6 + i11;
    }

    public final List<String> j() {
        return this.f32771e;
    }

    public final boolean l() {
        List<String> list = this.f32771e;
        boolean z11 = false;
        boolean z12 = list == null || list.isEmpty();
        List<String> list2 = this.f32770d;
        if (list2 == null || list2.isEmpty()) {
            z11 = true;
        }
        return !(z12 & z11);
    }

    public final IdentitySide m() {
        return this.f32769c;
    }

    public final String o() {
        return this.f32767a;
    }

    public final String q() {
        return this.f32773g;
    }

    public final List<e> s() {
        return this.f32772f;
    }

    public String toString() {
        return "RemoteIdDoc(idDocType=" + this.f32767a + ", country=" + this.f32768b + ", idDocSubType=" + this.f32769c + ", warnings=" + this.f32770d + ", errors=" + this.f32771e + ", metadata=" + this.f32772f + ", imageId=" + this.f32773g + ')';
    }

    public final List<String> u() {
        return this.f32770d;
    }

    public final boolean w() {
        List<String> list = this.f32771e;
        return !(list == null || list.isEmpty());
    }

    public /* synthetic */ k(int i11, String str, String str2, IdentitySide identitySide, List list, List list2, List list3, String str3, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32774a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32767a = null;
        } else {
            this.f32767a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32768b = null;
        } else {
            this.f32768b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f32769c = null;
        } else {
            this.f32769c = identitySide;
        }
        if ((i11 & 8) == 0) {
            this.f32770d = null;
        } else {
            this.f32770d = list;
        }
        if ((i11 & 16) == 0) {
            this.f32771e = null;
        } else {
            this.f32771e = list2;
        }
        if ((i11 & 32) == 0) {
            this.f32772f = null;
        } else {
            this.f32772f = list3;
        }
        if ((i11 & 64) == 0) {
            this.f32773g = null;
        } else {
            this.f32773g = str3;
        }
    }

    public final k a(String str, String str2, IdentitySide identitySide, List<String> list, List<String> list2, List<e> list3, String str3) {
        return new k(str, str2, identitySide, list, list2, list3, str3);
    }

    public k(String str, String str2, IdentitySide identitySide, List<String> list, List<String> list2, List<e> list3, String str3) {
        this.f32767a = str;
        this.f32768b = str2;
        this.f32769c = identitySide;
        this.f32770d = list;
        this.f32771e = list2;
        this.f32772f = list3;
        this.f32773g = str3;
    }

    public static /* synthetic */ k a(k kVar, String str, String str2, IdentitySide identitySide, List<String> list, List<String> list2, List<e> list3, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = kVar.f32767a;
        }
        if ((i11 & 2) != 0) {
            str2 = kVar.f32768b;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            identitySide = kVar.f32769c;
        }
        IdentitySide identitySide2 = identitySide;
        if ((i11 & 8) != 0) {
            list = kVar.f32770d;
        }
        List<String> list4 = list;
        if ((i11 & 16) != 0) {
            list2 = kVar.f32771e;
        }
        List<String> list5 = list2;
        if ((i11 & 32) != 0) {
            list3 = kVar.f32772f;
        }
        List<e> list6 = list3;
        if ((i11 & 64) != 0) {
            str3 = kVar.f32773g;
        }
        return kVar.a(str, str4, identitySide2, list4, list5, list6, str3);
    }

    public static final void a(k kVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || kVar.f32767a != null) {
            bVar.y(fVar, 0, v1.f57779a, kVar.f32767a);
        }
        if (bVar.q(fVar, 1) || kVar.f32768b != null) {
            bVar.y(fVar, 1, v1.f57779a, kVar.f32768b);
        }
        if (bVar.q(fVar, 2) || kVar.f32769c != null) {
            bVar.y(fVar, 2, IdentitySide.a.f32363a, kVar.f32769c);
        }
        if (bVar.q(fVar, 3) || kVar.f32770d != null) {
            bVar.y(fVar, 3, new kotlinx.serialization.internal.e(v1.f57779a), kVar.f32770d);
        }
        if (bVar.q(fVar, 4) || kVar.f32771e != null) {
            bVar.y(fVar, 4, new kotlinx.serialization.internal.e(v1.f57779a), kVar.f32771e);
        }
        if (bVar.q(fVar, 5) || kVar.f32772f != null) {
            bVar.y(fVar, 5, new kotlinx.serialization.internal.e(e.a.f32717a), kVar.f32772f);
        }
        if (bVar.q(fVar, 6) || kVar.f32773g != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 6, v1.f57779a, kVar.f32773g);
        }
    }

    public final void a(String str) {
        this.f32773g = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ k(java.lang.String r7, java.lang.String r8, com.sumsub.sns.internal.core.data.model.IdentitySide r9, java.util.List r10, java.util.List r11, java.util.List r12, java.lang.String r13, int r14, kotlin.jvm.internal.r r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.k.<init>(java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.List, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
