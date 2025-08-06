package com.sumsub.sns.internal.core.data.model.remote;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 =2\u00020\u0001:\u0004\b\n\f\rB?\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b7\u00108Bo\b\u0017\u0012\u0006\u00109\u001a\u00020\u001b\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b7\u0010<J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\tHÆ\u0003J\t\u0010\u000e\u001a\u00020\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0011HÆ\u0003JO\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u0011HÆ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u0013\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010 \u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R \u0010\u0014\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010 \u0012\u0004\b&\u0010$\u001a\u0004\b%\u0010\"R \u0010\u0015\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010'\u0012\u0004\b*\u0010$\u001a\u0004\b(\u0010)R \u0010\u0016\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010 \u0012\u0004\b,\u0010$\u001a\u0004\b+\u0010\"R \u0010\u0017\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010 \u0012\u0004\b.\u0010$\u001a\u0004\b-\u0010\"R \u0010\u0018\u001a\u00020\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010/\u0012\u0004\b2\u0010$\u001a\u0004\b0\u00101R \u0010\u0019\u001a\u00020\u00118\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u00103\u0012\u0004\b6\u0010$\u001a\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/f;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "c", "d", "e", "Lcom/sumsub/sns/internal/core/data/model/remote/f$c;", "f", "Lcom/sumsub/sns/internal/core/data/model/remote/f$d;", "g", "id", "applicantId", "type", "createdAt", "externalActionId", "requiredIdDocs", "review", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "getId$annotations", "()V", "h", "getApplicantId$annotations", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "t", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "getType$annotations", "j", "getCreatedAt$annotations", "l", "getExternalActionId$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/f$c;", "p", "()Lcom/sumsub/sns/internal/core/data/model/remote/f$c;", "getRequiredIdDocs$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/f$d;", "r", "()Lcom/sumsub/sns/internal/core/data/model/remote/f$d;", "getReview$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/f$c;Lcom/sumsub/sns/internal/core/data/model/remote/f$d;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/f$c;Lcom/sumsub/sns/internal/core/data/model/remote/f$d;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f
public final class f {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32719a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32720b;

    /* renamed from: c  reason: collision with root package name */
    public final FlowActionType f32721c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32722d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32723e;

    /* renamed from: f  reason: collision with root package name */
    public final c f32724f;

    /* renamed from: g  reason: collision with root package name */
    public final d f32725g;

    public static final class a implements d0<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32726a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32727b;

        static {
            a aVar = new a();
            f32726a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteAction", aVar, 7);
            pluginGeneratedSerialDescriptor.k("id", false);
            pluginGeneratedSerialDescriptor.k("applicantId", false);
            pluginGeneratedSerialDescriptor.k("type", false);
            pluginGeneratedSerialDescriptor.k("createdAt", false);
            pluginGeneratedSerialDescriptor.k("externalActionId", false);
            pluginGeneratedSerialDescriptor.k("requiredIdDocs", false);
            pluginGeneratedSerialDescriptor.k("review", false);
            f32727b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.f deserialize(kotlinx.serialization.encoding.c r21) {
            /*
                r20 = this;
                kotlinx.serialization.descriptors.f r0 = r20.getDescriptor()
                r1 = r21
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
                if (r2 == 0) goto L_0x0044
                java.lang.String r2 = r1.i(r0, r8)
                java.lang.String r8 = r1.i(r0, r9)
                com.sumsub.sns.internal.core.data.serializer.b r9 = com.sumsub.sns.internal.core.data.serializer.b.f32958a
                java.lang.Object r7 = r1.p(r0, r7, r9, r10)
                java.lang.String r5 = r1.i(r0, r5)
                java.lang.String r6 = r1.i(r0, r6)
                com.sumsub.sns.internal.core.data.model.remote.f$c$a r9 = com.sumsub.sns.internal.core.data.model.remote.f.c.a.f32729a
                java.lang.Object r4 = r1.p(r0, r4, r9, r10)
                com.sumsub.sns.internal.core.data.model.remote.f$d$a r9 = com.sumsub.sns.internal.core.data.model.remote.f.d.a.f32740a
                java.lang.Object r3 = r1.p(r0, r3, r9, r10)
                r9 = 127(0x7f, float:1.78E-43)
                r12 = r2
                r15 = r5
                r16 = r6
                r13 = r8
                r11 = r9
                goto L_0x00a5
            L_0x0044:
                r2 = r8
                r16 = r9
                r8 = r10
                r11 = r8
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x004d:
                if (r16 == 0) goto L_0x009c
                int r9 = r1.w(r0)
                switch(r9) {
                    case -1: goto L_0x0098;
                    case 0: goto L_0x008d;
                    case 1: goto L_0x0085;
                    case 2: goto L_0x007c;
                    case 3: goto L_0x0075;
                    case 4: goto L_0x006e;
                    case 5: goto L_0x0065;
                    case 6: goto L_0x005c;
                    default: goto L_0x0056;
                }
            L_0x0056:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r9)
                throw r0
            L_0x005c:
                com.sumsub.sns.internal.core.data.model.remote.f$d$a r9 = com.sumsub.sns.internal.core.data.model.remote.f.d.a.f32740a
                java.lang.Object r8 = r1.p(r0, r3, r9, r8)
                r2 = r2 | 64
                goto L_0x009a
            L_0x0065:
                com.sumsub.sns.internal.core.data.model.remote.f$c$a r9 = com.sumsub.sns.internal.core.data.model.remote.f.c.a.f32729a
                java.lang.Object r15 = r1.p(r0, r4, r9, r15)
                r2 = r2 | 32
                goto L_0x009a
            L_0x006e:
                java.lang.String r14 = r1.i(r0, r6)
                r2 = r2 | 16
                goto L_0x009a
            L_0x0075:
                java.lang.String r13 = r1.i(r0, r5)
                r2 = r2 | 8
                goto L_0x009a
            L_0x007c:
                com.sumsub.sns.internal.core.data.serializer.b r9 = com.sumsub.sns.internal.core.data.serializer.b.f32958a
                java.lang.Object r12 = r1.p(r0, r7, r9, r12)
                r2 = r2 | 4
                goto L_0x009a
            L_0x0085:
                r9 = 1
                java.lang.String r11 = r1.i(r0, r9)
                r2 = r2 | 2
                goto L_0x004d
            L_0x008d:
                r9 = 1
                r10 = 0
                java.lang.String r17 = r1.i(r0, r10)
                r2 = r2 | 1
                r10 = r17
                goto L_0x004d
            L_0x0098:
                r16 = 0
            L_0x009a:
                r9 = 1
                goto L_0x004d
            L_0x009c:
                r3 = r8
                r7 = r12
                r16 = r14
                r4 = r15
                r12 = r10
                r15 = r13
                r13 = r11
                r11 = r2
            L_0x00a5:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.f r0 = new com.sumsub.sns.internal.core.data.model.remote.f
                r14 = r7
                com.sumsub.sns.core.data.model.FlowActionType r14 = (com.sumsub.sns.core.data.model.FlowActionType) r14
                r17 = r4
                com.sumsub.sns.internal.core.data.model.remote.f$c r17 = (com.sumsub.sns.internal.core.data.model.remote.f.c) r17
                r18 = r3
                com.sumsub.sns.internal.core.data.model.remote.f$d r18 = (com.sumsub.sns.internal.core.data.model.remote.f.d) r18
                r19 = 0
                r10 = r0
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.f.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.f");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{v1Var, v1Var, com.sumsub.sns.internal.core.data.serializer.b.f32958a, v1Var, v1Var, c.a.f32729a, d.a.f32740a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32727b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(kotlinx.serialization.encoding.d dVar, f fVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f.a(fVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f> serializer() {
            return a.f32726a;
        }

        public b() {
        }
    }

    @kotlinx.serialization.f
    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0003\b\u0014\u001fB\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0018\u0010\u0019B-\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0018\u0010\u001dJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/f$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/model/remote/f$c$c;", "docSets", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "b", "()Ljava/util/List;", "getDocSets$annotations", "()V", "<init>", "(Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "c", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final List<C0347c> f32728a;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32729a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32730b;

            static {
                a aVar = new a();
                f32729a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteAction.RequiredIdDocs", aVar, 1);
                pluginGeneratedSerialDescriptor.k("docSets", false);
                f32730b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public c deserialize(kotlinx.serialization.encoding.c cVar) {
                Object obj;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                int i11 = 1;
                if (b11.k()) {
                    obj = b11.p(descriptor, 0, new e(C0347c.a.f32733a), null);
                } else {
                    obj = null;
                    int i12 = 0;
                    while (i11 != 0) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            i11 = 0;
                        } else if (w11 == 0) {
                            obj = b11.p(descriptor, 0, new e(C0347c.a.f32733a), obj);
                            i12 |= 1;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor);
                return new c(i11, (List) obj, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[]{new e(C0347c.a.f32733a)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32730b;
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
                return a.f32729a;
            }

            public b() {
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0002\b\u000bB\u001b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001d\u0010\u001eB3\b\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001d\u0010\"J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/f$c$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "", "b", "idDocSetType", "questionnaireDefId", "toString", "", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "c", "()Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "getIdDocSetType$annotations", "()V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "getQuestionnaireDefId$annotations", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/DocumentType;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/DocumentType;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.sumsub.sns.internal.core.data.model.remote.f$c$c  reason: collision with other inner class name */
        public static final class C0347c {
            public static final b Companion = new b((r) null);

            /* renamed from: a  reason: collision with root package name */
            public final DocumentType f32731a;

            /* renamed from: b  reason: collision with root package name */
            public final String f32732b;

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.f$c$c$a */
            public static final class a implements d0<C0347c> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32733a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32734b;

                static {
                    a aVar = new a();
                    f32733a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteAction.RequiredIdDocs.DocSetsItem", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("idDocSetType", false);
                    pluginGeneratedSerialDescriptor.k("questionnaireDefId", true);
                    f32734b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public C0347c deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, DocumentType.a.C0330a.f32359a, null);
                        obj = b11.j(descriptor, 1, v1.f57779a, null);
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
                                obj2 = b11.p(descriptor, 0, DocumentType.a.C0330a.f32359a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, v1.f57779a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new C0347c(i11, (DocumentType) obj2, (String) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{DocumentType.a.C0330a.f32359a, h10.a.u(v1.f57779a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32734b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, C0347c cVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    C0347c.a(cVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.f$c$c$b */
            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<C0347c> serializer() {
                    return a.f32733a;
                }

                public b() {
                }
            }

            public /* synthetic */ C0347c(int i11, DocumentType documentType, String str, q1 q1Var) {
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32733a.getDescriptor());
                }
                this.f32731a = documentType;
                if ((i11 & 2) == 0) {
                    this.f32732b = null;
                } else {
                    this.f32732b = str;
                }
            }

            public static /* synthetic */ void d() {
            }

            public static /* synthetic */ void f() {
            }

            public final DocumentType a() {
                return this.f32731a;
            }

            public final String b() {
                return this.f32732b;
            }

            public final DocumentType c() {
                return this.f32731a;
            }

            public final String e() {
                return this.f32732b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0347c)) {
                    return false;
                }
                C0347c cVar = (C0347c) obj;
                return x.b(this.f32731a, cVar.f32731a) && x.b(this.f32732b, cVar.f32732b);
            }

            public int hashCode() {
                int hashCode = this.f32731a.hashCode() * 31;
                String str = this.f32732b;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "DocSetsItem(idDocSetType=" + this.f32731a + ", questionnaireDefId=" + this.f32732b + ')';
            }

            public C0347c(DocumentType documentType, String str) {
                this.f32731a = documentType;
                this.f32732b = str;
            }

            public final C0347c a(DocumentType documentType, String str) {
                return new C0347c(documentType, str);
            }

            public static /* synthetic */ C0347c a(C0347c cVar, DocumentType documentType, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    documentType = cVar.f32731a;
                }
                if ((i11 & 2) != 0) {
                    str = cVar.f32732b;
                }
                return cVar.a(documentType, str);
            }

            public static final void a(C0347c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                boolean z11 = false;
                bVar.F(fVar, 0, DocumentType.a.C0330a.f32359a, cVar.f32731a);
                if (bVar.q(fVar, 1) || cVar.f32732b != null) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar, 1, v1.f57779a, cVar.f32732b);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0347c(DocumentType documentType, String str, int i11, r rVar) {
                this(documentType, (i11 & 2) != 0 ? null : str);
            }
        }

        public /* synthetic */ c(int i11, List list, q1 q1Var) {
            if (1 != (i11 & 1)) {
                h1.a(i11, 1, a.f32729a.getDescriptor());
            }
            this.f32728a = list;
        }

        public static /* synthetic */ void c() {
        }

        public final List<C0347c> a() {
            return this.f32728a;
        }

        public final List<C0347c> b() {
            return this.f32728a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f32728a, ((c) obj).f32728a);
        }

        public int hashCode() {
            return this.f32728a.hashCode();
        }

        public String toString() {
            return "RequiredIdDocs(docSets=" + this.f32728a + ')';
        }

        public c(List<C0347c> list) {
            this.f32728a = list;
        }

        public final c a(List<C0347c> list) {
            return new c(list);
        }

        public static /* synthetic */ c a(c cVar, List<C0347c> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = cVar.f32728a;
            }
            return cVar.a(list);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            bVar.F(fVar, 0, new e(C0347c.a.f32733a), cVar.f32728a);
        }
    }

    @kotlinx.serialization.f
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 12\u00020\u0001:\u0002\b\fBC\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b+\u0010,BW\b\u0017\u0012\u0006\u0010-\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b+\u00100J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000eHÆ\u0003JL\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\b\u0010\u0017J\t\u0010\u0018\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0019\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001d\u0010\nR\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010 \u0012\u0004\b\"\u0010\u001f\u001a\u0004\b!\u0010\rR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010#\u0012\u0004\b&\u0010\u001f\u001a\u0004\b$\u0010%R\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u0012\u0004\b(\u0010\u001f\u001a\u0004\b'\u0010\nR\"\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010#\u0012\u0004\b*\u0010\u001f\u001a\u0004\b)\u0010%¨\u00062"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/f$d;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Boolean;", "", "b", "()Ljava/lang/Integer;", "", "c", "d", "e", "reprocessing", "notificationFailureCnt", "reviewStatus", "autoChecked", "createDate", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/sumsub/sns/internal/core/data/model/remote/f$d;", "toString", "hashCode", "other", "equals", "Ljava/lang/Boolean;", "l", "getReprocessing$annotations", "()V", "Ljava/lang/Integer;", "j", "getNotificationFailureCnt$annotations", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "getReviewStatus$annotations", "f", "getAutoChecked$annotations", "h", "getCreateDate$annotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class d {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final Boolean f32735a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f32736b;

        /* renamed from: c  reason: collision with root package name */
        public final String f32737c;

        /* renamed from: d  reason: collision with root package name */
        public final Boolean f32738d;

        /* renamed from: e  reason: collision with root package name */
        public final String f32739e;

        public static final class a implements d0<d> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32740a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32741b;

            static {
                a aVar = new a();
                f32740a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.RemoteAction.Review", aVar, 5);
                pluginGeneratedSerialDescriptor.k("reprocessing", true);
                pluginGeneratedSerialDescriptor.k("notificationFailureCnt", true);
                pluginGeneratedSerialDescriptor.k("reviewStatus", true);
                pluginGeneratedSerialDescriptor.k("autoChecked", true);
                pluginGeneratedSerialDescriptor.k("createDate", true);
                f32741b = pluginGeneratedSerialDescriptor;
            }

            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.sumsub.sns.internal.core.data.model.remote.f.d deserialize(kotlinx.serialization.encoding.c r17) {
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
                    if (r2 == 0) goto L_0x0036
                    kotlinx.serialization.internal.h r2 = kotlinx.serialization.internal.h.f57720a
                    java.lang.Object r6 = r1.j(r0, r6, r2, r7)
                    kotlinx.serialization.internal.m0 r9 = kotlinx.serialization.internal.m0.f57742a
                    java.lang.Object r8 = r1.j(r0, r8, r9, r7)
                    kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r5 = r1.j(r0, r5, r9, r7)
                    java.lang.Object r2 = r1.j(r0, r3, r2, r7)
                    java.lang.Object r3 = r1.j(r0, r4, r9, r7)
                    r4 = 31
                    r10 = r5
                    r5 = r4
                    goto L_0x0089
                L_0x0036:
                    r2 = r6
                    r9 = r7
                    r10 = r9
                    r11 = r10
                    r12 = r11
                    r13 = r8
                L_0x003c:
                    if (r13 == 0) goto L_0x0084
                    int r14 = r1.w(r0)
                    r15 = -1
                    if (r14 == r15) goto L_0x0082
                    if (r14 == 0) goto L_0x0079
                    if (r14 == r8) goto L_0x0070
                    if (r14 == r5) goto L_0x0067
                    if (r14 == r3) goto L_0x005e
                    if (r14 != r4) goto L_0x0058
                    kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r12 = r1.j(r0, r4, r14, r12)
                    r2 = r2 | 16
                    goto L_0x003c
                L_0x0058:
                    kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                    r0.<init>((int) r14)
                    throw r0
                L_0x005e:
                    kotlinx.serialization.internal.h r14 = kotlinx.serialization.internal.h.f57720a
                    java.lang.Object r11 = r1.j(r0, r3, r14, r11)
                    r2 = r2 | 8
                    goto L_0x003c
                L_0x0067:
                    kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                    java.lang.Object r10 = r1.j(r0, r5, r14, r10)
                    r2 = r2 | 4
                    goto L_0x003c
                L_0x0070:
                    kotlinx.serialization.internal.m0 r14 = kotlinx.serialization.internal.m0.f57742a
                    java.lang.Object r9 = r1.j(r0, r8, r14, r9)
                    r2 = r2 | 2
                    goto L_0x003c
                L_0x0079:
                    kotlinx.serialization.internal.h r14 = kotlinx.serialization.internal.h.f57720a
                    java.lang.Object r7 = r1.j(r0, r6, r14, r7)
                    r2 = r2 | 1
                    goto L_0x003c
                L_0x0082:
                    r13 = r6
                    goto L_0x003c
                L_0x0084:
                    r5 = r2
                    r6 = r7
                    r8 = r9
                    r2 = r11
                    r3 = r12
                L_0x0089:
                    r1.c(r0)
                    com.sumsub.sns.internal.core.data.model.remote.f$d r0 = new com.sumsub.sns.internal.core.data.model.remote.f$d
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    r7 = r8
                    java.lang.Integer r7 = (java.lang.Integer) r7
                    r8 = r10
                    java.lang.String r8 = (java.lang.String) r8
                    r9 = r2
                    java.lang.Boolean r9 = (java.lang.Boolean) r9
                    r10 = r3
                    java.lang.String r10 = (java.lang.String) r10
                    r11 = 0
                    r4 = r0
                    r4.<init>((int) r5, (java.lang.Boolean) r6, (java.lang.Integer) r7, (java.lang.String) r8, (java.lang.Boolean) r9, (java.lang.String) r10, (kotlinx.serialization.internal.q1) r11)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.f.d.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.f$d");
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                h hVar = h.f57720a;
                v1 v1Var = v1.f57779a;
                return new kotlinx.serialization.b[]{h10.a.u(hVar), h10.a.u(m0.f57742a), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(v1Var)};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32741b;
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
                return a.f32740a;
            }

            public b() {
            }
        }

        public d() {
            this((Boolean) null, (Integer) null, (String) null, (Boolean) null, (String) null, 31, (r) null);
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

        public final Boolean a() {
            return this.f32735a;
        }

        public final Integer b() {
            return this.f32736b;
        }

        public final String c() {
            return this.f32737c;
        }

        public final Boolean d() {
            return this.f32738d;
        }

        public final String e() {
            return this.f32739e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f32735a, dVar.f32735a) && x.b(this.f32736b, dVar.f32736b) && x.b(this.f32737c, dVar.f32737c) && x.b(this.f32738d, dVar.f32738d) && x.b(this.f32739e, dVar.f32739e);
        }

        public final Boolean f() {
            return this.f32738d;
        }

        public final String h() {
            return this.f32739e;
        }

        public int hashCode() {
            Boolean bool = this.f32735a;
            int i11 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Integer num = this.f32736b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.f32737c;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool2 = this.f32738d;
            int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str2 = this.f32739e;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode4 + i11;
        }

        public final Integer j() {
            return this.f32736b;
        }

        public final Boolean l() {
            return this.f32735a;
        }

        public final String n() {
            return this.f32737c;
        }

        public String toString() {
            return "Review(reprocessing=" + this.f32735a + ", notificationFailureCnt=" + this.f32736b + ", reviewStatus=" + this.f32737c + ", autoChecked=" + this.f32738d + ", createDate=" + this.f32739e + ')';
        }

        public /* synthetic */ d(int i11, Boolean bool, Integer num, String str, Boolean bool2, String str2, q1 q1Var) {
            if ((i11 & 0) != 0) {
                h1.a(i11, 0, a.f32740a.getDescriptor());
            }
            if ((i11 & 1) == 0) {
                this.f32735a = null;
            } else {
                this.f32735a = bool;
            }
            if ((i11 & 2) == 0) {
                this.f32736b = null;
            } else {
                this.f32736b = num;
            }
            if ((i11 & 4) == 0) {
                this.f32737c = null;
            } else {
                this.f32737c = str;
            }
            if ((i11 & 8) == 0) {
                this.f32738d = null;
            } else {
                this.f32738d = bool2;
            }
            if ((i11 & 16) == 0) {
                this.f32739e = null;
            } else {
                this.f32739e = str2;
            }
        }

        public final d a(Boolean bool, Integer num, String str, Boolean bool2, String str2) {
            return new d(bool, num, str, bool2, str2);
        }

        public d(Boolean bool, Integer num, String str, Boolean bool2, String str2) {
            this.f32735a = bool;
            this.f32736b = num;
            this.f32737c = str;
            this.f32738d = bool2;
            this.f32739e = str2;
        }

        public static /* synthetic */ d a(d dVar, Boolean bool, Integer num, String str, Boolean bool2, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bool = dVar.f32735a;
            }
            if ((i11 & 2) != 0) {
                num = dVar.f32736b;
            }
            Integer num2 = num;
            if ((i11 & 4) != 0) {
                str = dVar.f32737c;
            }
            String str3 = str;
            if ((i11 & 8) != 0) {
                bool2 = dVar.f32738d;
            }
            Boolean bool3 = bool2;
            if ((i11 & 16) != 0) {
                str2 = dVar.f32739e;
            }
            return dVar.a(bool, num2, str3, bool3, str2);
        }

        public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            boolean z11 = false;
            if (bVar.q(fVar, 0) || dVar.f32735a != null) {
                bVar.y(fVar, 0, h.f57720a, dVar.f32735a);
            }
            if (bVar.q(fVar, 1) || dVar.f32736b != null) {
                bVar.y(fVar, 1, m0.f57742a, dVar.f32736b);
            }
            if (bVar.q(fVar, 2) || dVar.f32737c != null) {
                bVar.y(fVar, 2, v1.f57779a, dVar.f32737c);
            }
            if (bVar.q(fVar, 3) || dVar.f32738d != null) {
                bVar.y(fVar, 3, h.f57720a, dVar.f32738d);
            }
            if (bVar.q(fVar, 4) || dVar.f32739e != null) {
                z11 = true;
            }
            if (z11) {
                bVar.y(fVar, 4, v1.f57779a, dVar.f32739e);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ d(java.lang.Boolean r5, java.lang.Integer r6, java.lang.String r7, java.lang.Boolean r8, java.lang.String r9, int r10, kotlin.jvm.internal.r r11) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.f.d.<init>(java.lang.Boolean, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.r):void");
        }
    }

    public /* synthetic */ f(int i11, String str, String str2, FlowActionType flowActionType, String str3, String str4, c cVar, d dVar, q1 q1Var) {
        if (127 != (i11 & 127)) {
            h1.a(i11, 127, a.f32726a.getDescriptor());
        }
        this.f32719a = str;
        this.f32720b = str2;
        this.f32721c = flowActionType;
        this.f32722d = str3;
        this.f32723e = str4;
        this.f32724f = cVar;
        this.f32725g = dVar;
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public static /* synthetic */ void q() {
    }

    public static /* synthetic */ void s() {
    }

    public static /* synthetic */ void u() {
    }

    public final String a() {
        return this.f32719a;
    }

    public final String b() {
        return this.f32720b;
    }

    public final FlowActionType c() {
        return this.f32721c;
    }

    public final String d() {
        return this.f32722d;
    }

    public final String e() {
        return this.f32723e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f32719a, fVar.f32719a) && x.b(this.f32720b, fVar.f32720b) && x.b(this.f32721c, fVar.f32721c) && x.b(this.f32722d, fVar.f32722d) && x.b(this.f32723e, fVar.f32723e) && x.b(this.f32724f, fVar.f32724f) && x.b(this.f32725g, fVar.f32725g);
    }

    public final c f() {
        return this.f32724f;
    }

    public final d g() {
        return this.f32725g;
    }

    public final String h() {
        return this.f32720b;
    }

    public int hashCode() {
        return (((((((((((this.f32719a.hashCode() * 31) + this.f32720b.hashCode()) * 31) + this.f32721c.hashCode()) * 31) + this.f32722d.hashCode()) * 31) + this.f32723e.hashCode()) * 31) + this.f32724f.hashCode()) * 31) + this.f32725g.hashCode();
    }

    public final String j() {
        return this.f32722d;
    }

    public final String l() {
        return this.f32723e;
    }

    public final String n() {
        return this.f32719a;
    }

    public final c p() {
        return this.f32724f;
    }

    public final d r() {
        return this.f32725g;
    }

    public final FlowActionType t() {
        return this.f32721c;
    }

    public String toString() {
        return "RemoteAction(id=" + this.f32719a + ", applicantId=" + this.f32720b + ", type=" + this.f32721c + ", createdAt=" + this.f32722d + ", externalActionId=" + this.f32723e + ", requiredIdDocs=" + this.f32724f + ", review=" + this.f32725g + ')';
    }

    public f(String str, String str2, FlowActionType flowActionType, String str3, String str4, c cVar, d dVar) {
        this.f32719a = str;
        this.f32720b = str2;
        this.f32721c = flowActionType;
        this.f32722d = str3;
        this.f32723e = str4;
        this.f32724f = cVar;
        this.f32725g = dVar;
    }

    public final f a(String str, String str2, FlowActionType flowActionType, String str3, String str4, c cVar, d dVar) {
        return new f(str, str2, flowActionType, str3, str4, cVar, dVar);
    }

    public static /* synthetic */ f a(f fVar, String str, String str2, FlowActionType flowActionType, String str3, String str4, c cVar, d dVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fVar.f32719a;
        }
        if ((i11 & 2) != 0) {
            str2 = fVar.f32720b;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            flowActionType = fVar.f32721c;
        }
        FlowActionType flowActionType2 = flowActionType;
        if ((i11 & 8) != 0) {
            str3 = fVar.f32722d;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = fVar.f32723e;
        }
        String str7 = str4;
        if ((i11 & 32) != 0) {
            cVar = fVar.f32724f;
        }
        c cVar2 = cVar;
        if ((i11 & 64) != 0) {
            dVar = fVar.f32725g;
        }
        return fVar.a(str, str5, flowActionType2, str6, str7, cVar2, dVar);
    }

    public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
        bVar.p(fVar2, 0, fVar.f32719a);
        bVar.p(fVar2, 1, fVar.f32720b);
        bVar.F(fVar2, 2, com.sumsub.sns.internal.core.data.serializer.b.f32958a, fVar.f32721c);
        bVar.p(fVar2, 3, fVar.f32722d);
        bVar.p(fVar2, 4, fVar.f32723e);
        bVar.F(fVar2, 5, c.a.f32729a, fVar.f32724f);
        bVar.F(fVar2, 6, d.a.f32740a, fVar.f32725g);
    }
}
