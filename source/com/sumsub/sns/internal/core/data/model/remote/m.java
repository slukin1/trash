package com.sumsub.sns.internal.core.data.model.remote;

import com.facebook.appevents.UserDataStore;
import com.sumsub.sns.internal.core.data.model.ReviewAnswerType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 52\u00020\u0001:\u0003\b\u000b\fBU\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010¢\u0006\u0004\b/\u00100Bi\b\u0017\u0012\u0006\u00101\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0001\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b/\u00104J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010HÆ\u0003JW\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010HÆ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\t\u0010\u0018\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010!\u0012\u0004\b$\u0010 \u001a\u0004\b\"\u0010#R\"\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010!\u0012\u0004\b&\u0010 \u001a\u0004\b%\u0010#R(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010'\u0012\u0004\b*\u0010 \u001a\u0004\b(\u0010)R.\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010+\u0012\u0004\b.\u0010 \u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/m;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/remote/m$c;", "", "b", "c", "", "", "d", "", "e", "reviewResult", "country", "identity", "imageIds", "imageReviewResults", "toString", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/model/remote/m$c;", "n", "()Lcom/sumsub/sns/internal/core/data/model/remote/m$c;", "getReviewResult$annotations", "()V", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "getCountry$annotations", "h", "getIdentity$annotations", "Ljava/util/List;", "j", "()Ljava/util/List;", "getImageIds$annotations", "Ljava/util/Map;", "l", "()Ljava/util/Map;", "getImageReviewResults$annotations", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/remote/m$c;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/remote/m$c;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class m {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final c f32783a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32784b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32785c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Integer> f32786d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, c> f32787e;

    public static final class a implements d0<m> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32788a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32789b;

        static {
            a aVar = new a();
            f32788a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteRequiredDoc", aVar, 5);
            pluginGeneratedSerialDescriptor.k("reviewResult", true);
            pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, true);
            pluginGeneratedSerialDescriptor.k("idDocType", true);
            pluginGeneratedSerialDescriptor.k("imageIds", true);
            pluginGeneratedSerialDescriptor.k("imageReviewResults", true);
            f32789b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.m deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 3
                r4 = 4
                r5 = 2
                r6 = 0
                r7 = 0
                r8 = 1
                if (r2 == 0) goto L_0x0040
                com.sumsub.sns.internal.core.data.model.remote.m$c$a r2 = com.sumsub.sns.internal.core.data.model.remote.m.c.a.f32794a
                java.lang.Object r6 = r1.j(r0, r6, r2, r7)
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r9, r7)
                java.lang.Object r5 = r1.j(r0, r5, r9, r7)
                kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.m0 r10 = kotlinx.serialization.internal.m0.f57742a
                r9.<init>(r10)
                java.lang.Object r3 = r1.j(r0, r3, r9, r7)
                kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
                r9.<init>(r10, r2)
                java.lang.Object r2 = r1.j(r0, r4, r9, r7)
                r4 = 31
                r10 = r5
                r5 = r4
                goto L_0x00a3
            L_0x0040:
                r2 = r6
                r9 = r7
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r8
            L_0x0046:
                if (r13 == 0) goto L_0x009e
                int r14 = r1.w(r0)
                r15 = -1
                if (r14 == r15) goto L_0x009b
                if (r14 == 0) goto L_0x0090
                if (r14 == r8) goto L_0x0086
                if (r14 == r5) goto L_0x007d
                if (r14 == r3) goto L_0x006f
                if (r14 != r4) goto L_0x0069
                kotlinx.serialization.internal.r0 r14 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.m0 r15 = kotlinx.serialization.internal.m0.f57742a
                com.sumsub.sns.internal.core.data.model.remote.m$c$a r6 = com.sumsub.sns.internal.core.data.model.remote.m.c.a.f32794a
                r14.<init>(r15, r6)
                java.lang.Object r12 = r1.j(r0, r4, r14, r12)
                r2 = r2 | 16
                goto L_0x008e
            L_0x0069:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r14)
                throw r0
            L_0x006f:
                kotlinx.serialization.internal.e r6 = new kotlinx.serialization.internal.e
                kotlinx.serialization.internal.m0 r14 = kotlinx.serialization.internal.m0.f57742a
                r6.<init>(r14)
                java.lang.Object r11 = r1.j(r0, r3, r6, r11)
                r2 = r2 | 8
                goto L_0x008e
            L_0x007d:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r5, r6, r10)
                r2 = r2 | 4
                goto L_0x008e
            L_0x0086:
                kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r1.j(r0, r8, r6, r9)
                r2 = r2 | 2
            L_0x008e:
                r6 = 0
                goto L_0x0046
            L_0x0090:
                com.sumsub.sns.internal.core.data.model.remote.m$c$a r6 = com.sumsub.sns.internal.core.data.model.remote.m.c.a.f32794a
                r14 = 0
                java.lang.Object r7 = r1.j(r0, r14, r6, r7)
                r2 = r2 | 1
                r6 = r14
                goto L_0x0046
            L_0x009b:
                r14 = r6
                r13 = r6
                goto L_0x0046
            L_0x009e:
                r5 = r2
                r6 = r7
                r8 = r9
                r3 = r11
                r2 = r12
            L_0x00a3:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.m r0 = new com.sumsub.sns.internal.core.data.model.remote.m
                com.sumsub.sns.internal.core.data.model.remote.m$c r6 = (com.sumsub.sns.internal.core.data.model.remote.m.c) r6
                r7 = r8
                java.lang.String r7 = (java.lang.String) r7
                r8 = r10
                java.lang.String r8 = (java.lang.String) r8
                r9 = r3
                java.util.List r9 = (java.util.List) r9
                r10 = r2
                java.util.Map r10 = (java.util.Map) r10
                r11 = 0
                r4 = r0
                r4.<init>((int) r5, (com.sumsub.sns.internal.core.data.model.remote.m.c) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List) r9, (java.util.Map) r10, (kotlinx.serialization.internal.q1) r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.m.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.m");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            c.a aVar = c.a.f32794a;
            v1 v1Var = v1.f57779a;
            m0 m0Var = m0.f57742a;
            return new kotlinx.serialization.b[]{h10.a.u(aVar), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(m0Var)), h10.a.u(new r0(m0Var, aVar))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32789b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, m mVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            m.a(mVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<m> serializer() {
            return a.f32788a;
        }

        public b() {
        }
    }

    @f
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 .2\u00020\u0001:\u0002\b\u000bB=\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r¢\u0006\u0004\b(\u0010)BQ\b\u0017\u0012\u0006\u0010*\u001a\u00020\u0014\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b(\u0010-J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rHÆ\u0003J?\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rHÆ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001e\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010 R\"\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u0012\u0004\b#\u0010\u001d\u001a\u0004\b\"\u0010 R(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010$\u0012\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/m$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "", "b", "c", "", "d", "answer", "moderationComment", "clientComment", "rejectLabels", "toString", "", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "e", "()Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "getAnswer$annotations", "()V", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "getModerationComment$annotations", "g", "getClientComment$annotations", "Ljava/util/List;", "k", "()Ljava/util/List;", "getRejectLabels$annotations", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final ReviewAnswerType f32790a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32791b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32792c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f32793d;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32794a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32795b;

            static {
                a aVar = new a();
                f32794a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteRequiredDoc.ReviewResult", aVar, 4);
                pluginGeneratedSerialDescriptor.k("reviewAnswer", true);
                pluginGeneratedSerialDescriptor.k("moderationComment", true);
                pluginGeneratedSerialDescriptor.k("clientComment", true);
                pluginGeneratedSerialDescriptor.k("rejectLabels", true);
                f32795b = pluginGeneratedSerialDescriptor;
            }

            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.sumsub.sns.internal.core.data.model.remote.m.c deserialize(kotlinx.serialization.encoding.c r14) {
                /*
                    r13 = this;
                    kotlinx.serialization.descriptors.f r0 = r13.getDescriptor()
                    kotlinx.serialization.encoding.a r14 = r14.b(r0)
                    boolean r1 = r14.k()
                    r2 = 3
                    r3 = 2
                    r4 = 0
                    r5 = 0
                    r6 = 1
                    if (r1 == 0) goto L_0x0030
                    com.sumsub.sns.internal.core.data.model.ReviewAnswerType$a r1 = com.sumsub.sns.internal.core.data.model.ReviewAnswerType.a.f32369a
                    java.lang.Object r1 = r14.j(r0, r5, r1, r4)
                    kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r6 = r14.j(r0, r6, r5, r4)
                    java.lang.Object r3 = r14.j(r0, r3, r5, r4)
                    kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                    r7.<init>(r5)
                    java.lang.Object r2 = r14.j(r0, r2, r7, r4)
                    r4 = 15
                    r5 = r4
                    goto L_0x007c
                L_0x0030:
                    r1 = r4
                    r7 = r1
                    r8 = r7
                    r9 = r8
                    r4 = r5
                    r10 = r6
                L_0x0036:
                    if (r10 == 0) goto L_0x0078
                    int r11 = r14.w(r0)
                    r12 = -1
                    if (r11 == r12) goto L_0x0076
                    if (r11 == 0) goto L_0x006d
                    if (r11 == r6) goto L_0x0064
                    if (r11 == r3) goto L_0x005b
                    if (r11 != r2) goto L_0x0055
                    kotlinx.serialization.internal.e r11 = new kotlinx.serialization.internal.e
                    kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                    r11.<init>(r12)
                    java.lang.Object r9 = r14.j(r0, r2, r11, r9)
                    r4 = r4 | 8
                    goto L_0x0036
                L_0x0055:
                    kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                    r14.<init>((int) r11)
                    throw r14
                L_0x005b:
                    kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r8 = r14.j(r0, r3, r11, r8)
                    r4 = r4 | 4
                    goto L_0x0036
                L_0x0064:
                    kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r7 = r14.j(r0, r6, r11, r7)
                    r4 = r4 | 2
                    goto L_0x0036
                L_0x006d:
                    com.sumsub.sns.internal.core.data.model.ReviewAnswerType$a r11 = com.sumsub.sns.internal.core.data.model.ReviewAnswerType.a.f32369a
                    java.lang.Object r1 = r14.j(r0, r5, r11, r1)
                    r4 = r4 | 1
                    goto L_0x0036
                L_0x0076:
                    r10 = r5
                    goto L_0x0036
                L_0x0078:
                    r5 = r4
                    r6 = r7
                    r3 = r8
                    r2 = r9
                L_0x007c:
                    r14.c(r0)
                    com.sumsub.sns.internal.core.data.model.remote.m$c r14 = new com.sumsub.sns.internal.core.data.model.remote.m$c
                    r0 = r1
                    com.sumsub.sns.internal.core.data.model.ReviewAnswerType r0 = (com.sumsub.sns.internal.core.data.model.ReviewAnswerType) r0
                    r7 = r6
                    java.lang.String r7 = (java.lang.String) r7
                    r8 = r3
                    java.lang.String r8 = (java.lang.String) r8
                    r9 = r2
                    java.util.List r9 = (java.util.List) r9
                    r10 = 0
                    r4 = r14
                    r6 = r0
                    r4.<init>((int) r5, (com.sumsub.sns.internal.core.data.model.ReviewAnswerType) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List) r9, (kotlinx.serialization.internal.q1) r10)
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.m.c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.m$c");
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{h10.a.u(ReviewAnswerType.a.f32369a), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new e(v1Var))};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32795b;
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
                return a.f32794a;
            }

            public b() {
            }
        }

        public c() {
            this((ReviewAnswerType) null, (String) null, (String) null, (List) null, 15, (r) null);
        }

        public static /* synthetic */ void f() {
        }

        public static /* synthetic */ void h() {
        }

        public static /* synthetic */ void j() {
        }

        public static /* synthetic */ void l() {
        }

        public final ReviewAnswerType a() {
            return this.f32790a;
        }

        public final String b() {
            return this.f32791b;
        }

        public final String c() {
            return this.f32792c;
        }

        public final List<String> d() {
            return this.f32793d;
        }

        public final ReviewAnswerType e() {
            return this.f32790a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f32790a == cVar.f32790a && x.b(this.f32791b, cVar.f32791b) && x.b(this.f32792c, cVar.f32792c) && x.b(this.f32793d, cVar.f32793d);
        }

        public final String g() {
            return this.f32792c;
        }

        public int hashCode() {
            ReviewAnswerType reviewAnswerType = this.f32790a;
            int i11 = 0;
            int hashCode = (reviewAnswerType == null ? 0 : reviewAnswerType.hashCode()) * 31;
            String str = this.f32791b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f32792c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<String> list = this.f32793d;
            if (list != null) {
                i11 = list.hashCode();
            }
            return hashCode3 + i11;
        }

        public final String i() {
            return this.f32791b;
        }

        public final List<String> k() {
            return this.f32793d;
        }

        public String toString() {
            return "ReviewResult(answer=" + this.f32790a + ", moderationComment=" + this.f32791b + ", clientComment=" + this.f32792c + ", rejectLabels=" + this.f32793d + ')';
        }

        public /* synthetic */ c(int i11, ReviewAnswerType reviewAnswerType, String str, String str2, List list, q1 q1Var) {
            if ((i11 & 0) != 0) {
                h1.a(i11, 0, a.f32794a.getDescriptor());
            }
            if ((i11 & 1) == 0) {
                this.f32790a = null;
            } else {
                this.f32790a = reviewAnswerType;
            }
            if ((i11 & 2) == 0) {
                this.f32791b = null;
            } else {
                this.f32791b = str;
            }
            if ((i11 & 4) == 0) {
                this.f32792c = null;
            } else {
                this.f32792c = str2;
            }
            if ((i11 & 8) == 0) {
                this.f32793d = null;
            } else {
                this.f32793d = list;
            }
        }

        public final c a(ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list) {
            return new c(reviewAnswerType, str, str2, list);
        }

        public c(ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list) {
            this.f32790a = reviewAnswerType;
            this.f32791b = str;
            this.f32792c = str2;
            this.f32793d = list;
        }

        public static /* synthetic */ c a(c cVar, ReviewAnswerType reviewAnswerType, String str, String str2, List<String> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                reviewAnswerType = cVar.f32790a;
            }
            if ((i11 & 2) != 0) {
                str = cVar.f32791b;
            }
            if ((i11 & 4) != 0) {
                str2 = cVar.f32792c;
            }
            if ((i11 & 8) != 0) {
                list = cVar.f32793d;
            }
            return cVar.a(reviewAnswerType, str, str2, list);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            boolean z11 = false;
            if (bVar.q(fVar, 0) || cVar.f32790a != null) {
                bVar.y(fVar, 0, ReviewAnswerType.a.f32369a, cVar.f32790a);
            }
            if (bVar.q(fVar, 1) || cVar.f32791b != null) {
                bVar.y(fVar, 1, v1.f57779a, cVar.f32791b);
            }
            if (bVar.q(fVar, 2) || cVar.f32792c != null) {
                bVar.y(fVar, 2, v1.f57779a, cVar.f32792c);
            }
            if (bVar.q(fVar, 3) || cVar.f32793d != null) {
                z11 = true;
            }
            if (z11) {
                bVar.y(fVar, 3, new e(v1.f57779a), cVar.f32793d);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(ReviewAnswerType reviewAnswerType, String str, String str2, List list, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : reviewAnswerType, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : list);
        }
    }

    public m() {
        this((c) null, (String) null, (String) null, (List) null, (Map) null, 31, (r) null);
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public final c a() {
        return this.f32783a;
    }

    public final String b() {
        return this.f32784b;
    }

    public final String c() {
        return this.f32785c;
    }

    public final List<Integer> d() {
        return this.f32786d;
    }

    public final Map<Integer, c> e() {
        return this.f32787e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return x.b(this.f32783a, mVar.f32783a) && x.b(this.f32784b, mVar.f32784b) && x.b(this.f32785c, mVar.f32785c) && x.b(this.f32786d, mVar.f32786d) && x.b(this.f32787e, mVar.f32787e);
    }

    public final String f() {
        return this.f32784b;
    }

    public final String h() {
        return this.f32785c;
    }

    public int hashCode() {
        c cVar = this.f32783a;
        int i11 = 0;
        int hashCode = (cVar == null ? 0 : cVar.hashCode()) * 31;
        String str = this.f32784b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f32785c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Integer> list = this.f32786d;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Map<Integer, c> map = this.f32787e;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode4 + i11;
    }

    public final List<Integer> j() {
        return this.f32786d;
    }

    public final Map<Integer, c> l() {
        return this.f32787e;
    }

    public final c n() {
        return this.f32783a;
    }

    public String toString() {
        return "RemoteRequiredDoc(reviewResult=" + this.f32783a + ", country=" + this.f32784b + ", identity=" + this.f32785c + ", imageIds=" + this.f32786d + ", imageReviewResults=" + this.f32787e + ')';
    }

    public /* synthetic */ m(int i11, c cVar, String str, String str2, List list, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32788a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32783a = null;
        } else {
            this.f32783a = cVar;
        }
        if ((i11 & 2) == 0) {
            this.f32784b = null;
        } else {
            this.f32784b = str;
        }
        if ((i11 & 4) == 0) {
            this.f32785c = null;
        } else {
            this.f32785c = str2;
        }
        if ((i11 & 8) == 0) {
            this.f32786d = null;
        } else {
            this.f32786d = list;
        }
        if ((i11 & 16) == 0) {
            this.f32787e = null;
        } else {
            this.f32787e = map;
        }
    }

    public final m a(c cVar, String str, String str2, List<Integer> list, Map<Integer, c> map) {
        return new m(cVar, str, str2, list, map);
    }

    public m(c cVar, String str, String str2, List<Integer> list, Map<Integer, c> map) {
        this.f32783a = cVar;
        this.f32784b = str;
        this.f32785c = str2;
        this.f32786d = list;
        this.f32787e = map;
    }

    public static /* synthetic */ m a(m mVar, c cVar, String str, String str2, List<Integer> list, Map<Integer, c> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = mVar.f32783a;
        }
        if ((i11 & 2) != 0) {
            str = mVar.f32784b;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = mVar.f32785c;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            list = mVar.f32786d;
        }
        List<Integer> list2 = list;
        if ((i11 & 16) != 0) {
            map = mVar.f32787e;
        }
        return mVar.a(cVar, str3, str4, list2, map);
    }

    public static final void a(m mVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || mVar.f32783a != null) {
            bVar.y(fVar, 0, c.a.f32794a, mVar.f32783a);
        }
        if (bVar.q(fVar, 1) || mVar.f32784b != null) {
            bVar.y(fVar, 1, v1.f57779a, mVar.f32784b);
        }
        if (bVar.q(fVar, 2) || mVar.f32785c != null) {
            bVar.y(fVar, 2, v1.f57779a, mVar.f32785c);
        }
        if (bVar.q(fVar, 3) || mVar.f32786d != null) {
            bVar.y(fVar, 3, new e(m0.f57742a), mVar.f32786d);
        }
        if (bVar.q(fVar, 4) || mVar.f32787e != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 4, new r0(m0.f57742a, c.a.f32794a), mVar.f32787e);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ m(com.sumsub.sns.internal.core.data.model.remote.m.c r5, java.lang.String r6, java.lang.String r7, java.util.List r8, java.util.Map r9, int r10, kotlin.jvm.internal.r r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.m.<init>(com.sumsub.sns.internal.core.data.model.remote.m$c, java.lang.String, java.lang.String, java.util.List, java.util.Map, int, kotlin.jvm.internal.r):void");
    }
}
