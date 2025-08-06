package com.sumsub.sns.internal.core.data.model.remote.response;

import com.facebook.GraphRequest;
import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.ReviewAnswerType;
import com.sumsub.sns.internal.core.data.model.ReviewRejectType;
import com.sumsub.sns.internal.core.data.model.ReviewStatusType;
import com.sumsub.sns.internal.core.data.model.b;
import com.sumsub.sns.internal.core.data.model.h;
import com.sumsub.sns.internal.core.data.model.remote.e;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\b\u0013\u001eB\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018B'\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0017\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c;", "data", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c;", "b", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c;", "getData$annotations", "()V", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/remote/response/d$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "c", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class d {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final c f32812a;

    public static final class a implements d0<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32813a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32814b;

        static {
            a aVar = new a();
            f32813a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse", aVar, 1);
            pluginGeneratedSerialDescriptor.k("list", true);
            f32814b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public d deserialize(kotlinx.serialization.encoding.c cVar) {
            Object obj;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            int i11 = 1;
            if (b11.k()) {
                obj = b11.j(descriptor, 0, c.a.f32816a, null);
            } else {
                obj = null;
                int i12 = 0;
                while (i11 != 0) {
                    int w11 = b11.w(descriptor);
                    if (w11 == -1) {
                        i11 = 0;
                    } else if (w11 == 0) {
                        obj = b11.j(descriptor, 0, c.a.f32816a, obj);
                        i12 |= 1;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                i11 = i12;
            }
            b11.c(descriptor);
            return new d(i11, (c) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(c.a.f32816a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32814b;
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
            return a.f32813a;
        }

        public b() {
        }
    }

    @kotlinx.serialization.f
    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0006\b\u0014\u001f !\"B\u0019\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B-\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0010\b\u0001\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0018\u0010\u001dJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u001b\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R(\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$d;", "items", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "b", "()Ljava/util/List;", "getItems$annotations", "()V", "<init>", "(Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "c", "d", "e", "f", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {
        public static final b Companion = new b((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final List<C0351d> f32815a;

        public static final class a implements d0<c> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32816a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32817b;

            static {
                a aVar = new a();
                f32816a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data", aVar, 1);
                pluginGeneratedSerialDescriptor.k(FirebaseAnalytics.Param.ITEMS, true);
                f32817b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public c deserialize(kotlinx.serialization.encoding.c cVar) {
                Object obj;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                int i11 = 1;
                if (b11.k()) {
                    obj = b11.j(descriptor, 0, new kotlinx.serialization.internal.e(C0351d.a.f32855a), null);
                } else {
                    obj = null;
                    int i12 = 0;
                    while (i11 != 0) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            i11 = 0;
                        } else if (w11 == 0) {
                            obj = b11.j(descriptor, 0, new kotlinx.serialization.internal.e(C0351d.a.f32855a), obj);
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
                return new kotlinx.serialization.b[]{h10.a.u(new kotlinx.serialization.internal.e(C0351d.a.f32855a))};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32817b;
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
                return a.f32816a;
            }

            public b() {
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 P2\u00020\u0001:\u0002\b\u0012B·\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bJ\u0010KBË\u0001\b\u0017\u0012\u0006\u0010L\u001a\u00020&\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\t\u0012\u001e\b\u0001\u0010#\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0018\u00010\u0014\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\t\u0012\b\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bJ\u0010OJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J\u001f\u0010\u0016\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J¹\u0001\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020&HÖ\u0001J\u0013\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\"\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010+\u0012\u0004\b1\u0010/\u001a\u0004\b0\u0010-R\"\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010+\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010-R\"\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010+\u0012\u0004\b5\u0010/\u001a\u0004\b4\u0010-R\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010+\u0012\u0004\b7\u0010/\u001a\u0004\b6\u0010-R\"\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010+\u0012\u0004\b9\u0010/\u001a\u0004\b8\u0010-R\"\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010+\u0012\u0004\b;\u0010/\u001a\u0004\b:\u0010-R\"\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010+\u0012\u0004\b=\u0010/\u001a\u0004\b<\u0010-R\"\u0010 \u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010+\u0012\u0004\b?\u0010/\u001a\u0004\b>\u0010-R\"\u0010!\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010+\u0012\u0004\bA\u0010/\u001a\u0004\b@\u0010-R\"\u0010\"\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010+\u0012\u0004\bC\u0010/\u001a\u0004\bB\u0010-R6\u0010#\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015\u0018\u00010\u00148\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010D\u0012\u0004\bG\u0010/\u001a\u0004\bE\u0010FR\"\u0010$\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010+\u0012\u0004\bI\u0010/\u001a\u0004\bH\u0010-¨\u0006Q"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "f", "g", "h", "i", "j", "k", "l", "m", "b", "c", "", "", "d", "e", "country", "firstName", "lastName", "middleName", "legalName", "gender", "dob", "placeOfBirth", "countryOfBirth", "stateOfBirth", "nationality", "addresses", "tin", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "getCountry$annotations", "()V", "v", "getFirstName$annotations", "z", "getLastName$annotations", "D", "getMiddleName$annotations", "B", "getLegalName$annotations", "x", "getGender$annotations", "t", "getDob$annotations", "H", "getPlaceOfBirth$annotations", "r", "getCountryOfBirth$annotations", "J", "getStateOfBirth$annotations", "F", "getNationality$annotations", "Ljava/util/List;", "n", "()Ljava/util/List;", "getAddresses$annotations", "L", "getTin$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$c  reason: collision with other inner class name */
        public static final class C0350c {
            public static final b Companion = new b((r) null);

            /* renamed from: a  reason: collision with root package name */
            public final String f32818a;

            /* renamed from: b  reason: collision with root package name */
            public final String f32819b;

            /* renamed from: c  reason: collision with root package name */
            public final String f32820c;

            /* renamed from: d  reason: collision with root package name */
            public final String f32821d;

            /* renamed from: e  reason: collision with root package name */
            public final String f32822e;

            /* renamed from: f  reason: collision with root package name */
            public final String f32823f;

            /* renamed from: g  reason: collision with root package name */
            public final String f32824g;

            /* renamed from: h  reason: collision with root package name */
            public final String f32825h;

            /* renamed from: i  reason: collision with root package name */
            public final String f32826i;

            /* renamed from: j  reason: collision with root package name */
            public final String f32827j;

            /* renamed from: k  reason: collision with root package name */
            public final String f32828k;

            /* renamed from: l  reason: collision with root package name */
            public final List<Map<String, Object>> f32829l;

            /* renamed from: m  reason: collision with root package name */
            public final String f32830m;

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$c$a */
            public static final class a implements d0<C0350c> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32831a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32832b;

                static {
                    a aVar = new a();
                    f32831a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.Info", aVar, 13);
                    pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, true);
                    pluginGeneratedSerialDescriptor.k("firstName", true);
                    pluginGeneratedSerialDescriptor.k("lastName", true);
                    pluginGeneratedSerialDescriptor.k("middleName", true);
                    pluginGeneratedSerialDescriptor.k("legalName", true);
                    pluginGeneratedSerialDescriptor.k("gender", true);
                    pluginGeneratedSerialDescriptor.k("dob", true);
                    pluginGeneratedSerialDescriptor.k("placeOfBirth", true);
                    pluginGeneratedSerialDescriptor.k("countryOfBirth", true);
                    pluginGeneratedSerialDescriptor.k("stateOfBirth", true);
                    pluginGeneratedSerialDescriptor.k("nationality", true);
                    pluginGeneratedSerialDescriptor.k("addresses", true);
                    pluginGeneratedSerialDescriptor.k("tin", true);
                    f32832b = pluginGeneratedSerialDescriptor;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0170, code lost:
                    r12 = r10;
                    r5 = r29;
                    r0 = r30;
                    r10 = r31;
                    r4 = 12;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x021a, code lost:
                    r5 = r29;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x022d, code lost:
                    r0 = r30;
                    r10 = r31;
                    r4 = 12;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
                    r9 = r9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
                    r9 = r9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
                    r9 = r9;
                 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c deserialize(kotlinx.serialization.encoding.c r34) {
                    /*
                        r33 = this;
                        java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
                        kotlinx.serialization.descriptors.f r1 = r33.getDescriptor()
                        r2 = r34
                        kotlinx.serialization.encoding.a r2 = r2.b(r1)
                        boolean r3 = r2.k()
                        r6 = 10
                        r7 = 9
                        r8 = 7
                        r9 = 6
                        r10 = 5
                        r11 = 3
                        r12 = 8
                        r13 = 4
                        r14 = 2
                        r15 = 1
                        r4 = 0
                        r5 = 0
                        if (r3 == 0) goto L_0x0087
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r17 = r2.j(r1, r4, r3, r5)
                        java.lang.Object r15 = r2.j(r1, r15, r3, r5)
                        java.lang.Object r14 = r2.j(r1, r14, r3, r5)
                        java.lang.Object r11 = r2.j(r1, r11, r3, r5)
                        java.lang.Object r13 = r2.j(r1, r13, r3, r5)
                        java.lang.Object r10 = r2.j(r1, r10, r3, r5)
                        java.lang.Object r9 = r2.j(r1, r9, r3, r5)
                        java.lang.Object r8 = r2.j(r1, r8, r3, r5)
                        java.lang.Object r12 = r2.j(r1, r12, r3, r5)
                        java.lang.Object r7 = r2.j(r1, r7, r3, r5)
                        java.lang.Object r6 = r2.j(r1, r6, r3, r5)
                        kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                        r20 = r6
                        kotlinx.serialization.ContextualSerializer r6 = new kotlinx.serialization.ContextualSerializer
                        kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
                        r21 = r7
                        r7 = 0
                        kotlinx.serialization.b[] r7 = new kotlinx.serialization.b[r7]
                        r19 = r8
                        r8 = 0
                        r6.<init>(r0, r8, r7)
                        kotlinx.serialization.b r0 = h10.a.u(r6)
                        r4.<init>(r3, r0)
                        r5.<init>(r4)
                        r0 = 11
                        java.lang.Object r0 = r2.j(r1, r0, r5, r8)
                        r4 = 12
                        java.lang.Object r3 = r2.j(r1, r4, r3, r8)
                        r4 = 8191(0x1fff, float:1.1478E-41)
                        r5 = r4
                        r8 = r19
                        r6 = r20
                        r7 = r21
                        goto L_0x025a
                    L_0x0087:
                        r4 = 12
                        r5 = r15
                        r3 = 0
                        r8 = 0
                        r9 = 0
                        r10 = 0
                        r11 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r27 = 0
                        r28 = 0
                    L_0x009e:
                        if (r5 == 0) goto L_0x023b
                        int r12 = r2.w(r1)
                        switch(r12) {
                            case -1: goto L_0x021d;
                            case 0: goto L_0x01ff;
                            case 1: goto L_0x01e3;
                            case 2: goto L_0x01c7;
                            case 3: goto L_0x019f;
                            case 4: goto L_0x017b;
                            case 5: goto L_0x0159;
                            case 6: goto L_0x0143;
                            case 7: goto L_0x012e;
                            case 8: goto L_0x011a;
                            case 9: goto L_0x00ff;
                            case 10: goto L_0x00e4;
                            case 11: goto L_0x00b7;
                            case 12: goto L_0x00ad;
                            default: goto L_0x00a7;
                        }
                    L_0x00a7:
                        kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                        r0.<init>((int) r12)
                        throw r0
                    L_0x00ad:
                        kotlinx.serialization.internal.v1 r12 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r10 = r2.j(r1, r4, r12, r10)
                        r15 = r15 | 4096(0x1000, float:5.74E-42)
                        goto L_0x0237
                    L_0x00b7:
                        kotlinx.serialization.internal.e r12 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                        kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                        kotlinx.serialization.ContextualSerializer r6 = new kotlinx.serialization.ContextualSerializer
                        r29 = r5
                        kotlin.reflect.c r5 = kotlin.jvm.internal.Reflection.b(r0)
                        r30 = r0
                        r31 = r10
                        r0 = 0
                        kotlinx.serialization.b[] r10 = new kotlinx.serialization.b[r0]
                        r0 = 0
                        r6.<init>(r5, r0, r10)
                        kotlinx.serialization.b r5 = h10.a.u(r6)
                        r4.<init>(r7, r5)
                        r12.<init>(r4)
                        r4 = 11
                        java.lang.Object r13 = r2.j(r1, r4, r12, r13)
                        r15 = r15 | 2048(0x800, float:2.87E-42)
                        goto L_0x021a
                    L_0x00e4:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 0
                        r4 = 11
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r6 = 10
                        java.lang.Object r3 = r2.j(r1, r6, r5, r3)
                        r15 = r15 | 1024(0x400, float:1.435E-42)
                        r5 = r29
                        r0 = r30
                        r4 = 12
                        goto L_0x0235
                    L_0x00ff:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 0
                        r4 = 11
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r7 = 9
                        java.lang.Object r14 = r2.j(r1, r7, r5, r14)
                        r15 = r15 | 512(0x200, float:7.175E-43)
                        r5 = r29
                        r0 = r30
                        r4 = 12
                        goto L_0x0237
                    L_0x011a:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 0
                        r4 = 11
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r10 = 8
                        java.lang.Object r8 = r2.j(r1, r10, r5, r8)
                        r15 = r15 | 256(0x100, float:3.59E-43)
                        goto L_0x0170
                    L_0x012e:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 0
                        r4 = 11
                        r10 = 8
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r12 = 7
                        java.lang.Object r11 = r2.j(r1, r12, r5, r11)
                        r15 = r15 | 128(0x80, float:1.794E-43)
                        goto L_0x0170
                    L_0x0143:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 0
                        r4 = 11
                        r10 = 8
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r0 = 6
                        java.lang.Object r9 = r2.j(r1, r0, r5, r9)
                        r15 = r15 | 64
                        goto L_0x0170
                    L_0x0159:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = 6
                        r4 = 11
                        r10 = 8
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r0 = r23
                        r4 = 5
                        java.lang.Object r23 = r2.j(r1, r4, r5, r0)
                        r15 = r15 | 32
                    L_0x0170:
                        r12 = r10
                        r5 = r29
                        r0 = r30
                        r10 = r31
                        r4 = 12
                        goto L_0x009e
                    L_0x017b:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = r23
                        r4 = 5
                        r10 = 8
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r4 = r25
                        r6 = 4
                        java.lang.Object r25 = r2.j(r1, r6, r5, r4)
                        r15 = r15 | 16
                        r12 = r10
                        r5 = r29
                        r0 = r30
                        r10 = r31
                        r4 = 12
                        r6 = 10
                        goto L_0x009e
                    L_0x019f:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = r23
                        r4 = r25
                        r6 = 4
                        r10 = 8
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r6 = r24
                        r7 = 3
                        java.lang.Object r24 = r2.j(r1, r7, r5, r6)
                        r15 = r15 | 8
                        r12 = r10
                        r5 = r29
                        r0 = r30
                        r10 = r31
                        r4 = 12
                        r6 = 10
                        r7 = 9
                        goto L_0x009e
                    L_0x01c7:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = r23
                        r6 = r24
                        r4 = r25
                        r7 = 3
                        r10 = 8
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r7 = r26
                        r10 = 2
                        java.lang.Object r26 = r2.j(r1, r10, r5, r7)
                        r15 = r15 | 4
                        goto L_0x021a
                    L_0x01e3:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r0 = r23
                        r6 = r24
                        r4 = r25
                        r7 = r26
                        r10 = 2
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r10 = r27
                        r0 = 1
                        java.lang.Object r27 = r2.j(r1, r0, r5, r10)
                        r15 = r15 | 2
                        goto L_0x021a
                    L_0x01ff:
                        r30 = r0
                        r29 = r5
                        r31 = r10
                        r6 = r24
                        r4 = r25
                        r7 = r26
                        r10 = r27
                        r0 = 1
                        r12 = 7
                        kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                        r12 = r28
                        r0 = 0
                        java.lang.Object r28 = r2.j(r1, r0, r5, r12)
                        r15 = r15 | 1
                    L_0x021a:
                        r5 = r29
                        goto L_0x022d
                    L_0x021d:
                        r30 = r0
                        r31 = r10
                        r6 = r24
                        r4 = r25
                        r7 = r26
                        r10 = r27
                        r12 = r28
                        r0 = 0
                        r5 = r0
                    L_0x022d:
                        r0 = r30
                        r10 = r31
                        r4 = 12
                        r6 = 10
                    L_0x0235:
                        r7 = 9
                    L_0x0237:
                        r12 = 8
                        goto L_0x009e
                    L_0x023b:
                        r31 = r10
                        r6 = r24
                        r4 = r25
                        r7 = r26
                        r10 = r27
                        r12 = r28
                        r17 = r12
                        r0 = r13
                        r5 = r15
                        r13 = r4
                        r12 = r8
                        r15 = r10
                        r8 = r11
                        r10 = r23
                        r11 = r6
                        r6 = r3
                        r3 = r31
                        r32 = r14
                        r14 = r7
                        r7 = r32
                    L_0x025a:
                        r2.c(r1)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r1 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$c
                        r2 = r17
                        java.lang.String r2 = (java.lang.String) r2
                        java.lang.String r15 = (java.lang.String) r15
                        java.lang.String r14 = (java.lang.String) r14
                        java.lang.String r11 = (java.lang.String) r11
                        java.lang.String r13 = (java.lang.String) r13
                        r16 = r10
                        java.lang.String r16 = (java.lang.String) r16
                        r17 = r9
                        java.lang.String r17 = (java.lang.String) r17
                        r18 = r8
                        java.lang.String r18 = (java.lang.String) r18
                        r19 = r12
                        java.lang.String r19 = (java.lang.String) r19
                        r20 = r7
                        java.lang.String r20 = (java.lang.String) r20
                        r21 = r6
                        java.lang.String r21 = (java.lang.String) r21
                        java.util.List r0 = (java.util.List) r0
                        java.lang.String r3 = (java.lang.String) r3
                        r22 = 0
                        r4 = r1
                        r6 = r2
                        r7 = r15
                        r8 = r14
                        r9 = r11
                        r10 = r13
                        r11 = r16
                        r12 = r17
                        r13 = r18
                        r14 = r19
                        r15 = r20
                        r16 = r21
                        r17 = r0
                        r18 = r3
                        r19 = r22
                        r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.util.List) r17, (java.lang.String) r18, (kotlinx.serialization.internal.q1) r19)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$c");
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    v1 v1Var = v1.f57779a;
                    return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(new r0(v1Var, h10.a.u(new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0]))))), h10.a.u(v1Var)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32832b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, C0350c cVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    C0350c.a(cVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$c$b */
            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<C0350c> serializer() {
                    return a.f32831a;
                }

                public b() {
                }
            }

            public C0350c() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 8191, (r) null);
            }

            public static /* synthetic */ void A() {
            }

            public static /* synthetic */ void C() {
            }

            public static /* synthetic */ void E() {
            }

            public static /* synthetic */ void G() {
            }

            public static /* synthetic */ void I() {
            }

            public static /* synthetic */ void K() {
            }

            public static /* synthetic */ void M() {
            }

            public static /* synthetic */ void o() {
            }

            public static /* synthetic */ void q() {
            }

            public static /* synthetic */ void s() {
            }

            public static /* synthetic */ void u() {
            }

            public static /* synthetic */ void w() {
            }

            public static /* synthetic */ void y() {
            }

            public final String B() {
                return this.f32822e;
            }

            public final String D() {
                return this.f32821d;
            }

            public final String F() {
                return this.f32828k;
            }

            public final String H() {
                return this.f32825h;
            }

            public final String J() {
                return this.f32827j;
            }

            public final String L() {
                return this.f32830m;
            }

            public final String a() {
                return this.f32818a;
            }

            public final String b() {
                return this.f32827j;
            }

            public final String c() {
                return this.f32828k;
            }

            public final List<Map<String, Object>> d() {
                return this.f32829l;
            }

            public final String e() {
                return this.f32830m;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0350c)) {
                    return false;
                }
                C0350c cVar = (C0350c) obj;
                return x.b(this.f32818a, cVar.f32818a) && x.b(this.f32819b, cVar.f32819b) && x.b(this.f32820c, cVar.f32820c) && x.b(this.f32821d, cVar.f32821d) && x.b(this.f32822e, cVar.f32822e) && x.b(this.f32823f, cVar.f32823f) && x.b(this.f32824g, cVar.f32824g) && x.b(this.f32825h, cVar.f32825h) && x.b(this.f32826i, cVar.f32826i) && x.b(this.f32827j, cVar.f32827j) && x.b(this.f32828k, cVar.f32828k) && x.b(this.f32829l, cVar.f32829l) && x.b(this.f32830m, cVar.f32830m);
            }

            public final String f() {
                return this.f32819b;
            }

            public final String g() {
                return this.f32820c;
            }

            public final String h() {
                return this.f32821d;
            }

            public int hashCode() {
                String str = this.f32818a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f32819b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f32820c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f32821d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.f32822e;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.f32823f;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.f32824g;
                int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.f32825h;
                int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
                String str9 = this.f32826i;
                int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
                String str10 = this.f32827j;
                int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
                String str11 = this.f32828k;
                int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
                List<Map<String, Object>> list = this.f32829l;
                int hashCode12 = (hashCode11 + (list == null ? 0 : list.hashCode())) * 31;
                String str12 = this.f32830m;
                if (str12 != null) {
                    i11 = str12.hashCode();
                }
                return hashCode12 + i11;
            }

            public final String i() {
                return this.f32822e;
            }

            public final String j() {
                return this.f32823f;
            }

            public final String k() {
                return this.f32824g;
            }

            public final String l() {
                return this.f32825h;
            }

            public final String m() {
                return this.f32826i;
            }

            public final List<Map<String, Object>> n() {
                return this.f32829l;
            }

            public final String p() {
                return this.f32818a;
            }

            public final String r() {
                return this.f32826i;
            }

            public final String t() {
                return this.f32824g;
            }

            public String toString() {
                return "Info(country=" + this.f32818a + ", firstName=" + this.f32819b + ", lastName=" + this.f32820c + ", middleName=" + this.f32821d + ", legalName=" + this.f32822e + ", gender=" + this.f32823f + ", dob=" + this.f32824g + ", placeOfBirth=" + this.f32825h + ", countryOfBirth=" + this.f32826i + ", stateOfBirth=" + this.f32827j + ", nationality=" + this.f32828k + ", addresses=" + this.f32829l + ", tin=" + this.f32830m + ')';
            }

            public final String v() {
                return this.f32819b;
            }

            public final String x() {
                return this.f32823f;
            }

            public final String z() {
                return this.f32820c;
            }

            public /* synthetic */ C0350c(int i11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, q1 q1Var) {
                int i12 = i11;
                if ((i12 & 0) != 0) {
                    h1.a(i11, 0, a.f32831a.getDescriptor());
                }
                if ((i12 & 1) == 0) {
                    this.f32818a = null;
                } else {
                    this.f32818a = str;
                }
                if ((i12 & 2) == 0) {
                    this.f32819b = null;
                } else {
                    this.f32819b = str2;
                }
                if ((i12 & 4) == 0) {
                    this.f32820c = null;
                } else {
                    this.f32820c = str3;
                }
                if ((i12 & 8) == 0) {
                    this.f32821d = null;
                } else {
                    this.f32821d = str4;
                }
                if ((i12 & 16) == 0) {
                    this.f32822e = null;
                } else {
                    this.f32822e = str5;
                }
                if ((i12 & 32) == 0) {
                    this.f32823f = null;
                } else {
                    this.f32823f = str6;
                }
                if ((i12 & 64) == 0) {
                    this.f32824g = null;
                } else {
                    this.f32824g = str7;
                }
                if ((i12 & 128) == 0) {
                    this.f32825h = null;
                } else {
                    this.f32825h = str8;
                }
                if ((i12 & 256) == 0) {
                    this.f32826i = null;
                } else {
                    this.f32826i = str9;
                }
                if ((i12 & 512) == 0) {
                    this.f32827j = null;
                } else {
                    this.f32827j = str10;
                }
                if ((i12 & 1024) == 0) {
                    this.f32828k = null;
                } else {
                    this.f32828k = str11;
                }
                if ((i12 & 2048) == 0) {
                    this.f32829l = null;
                } else {
                    this.f32829l = list;
                }
                if ((i12 & 4096) == 0) {
                    this.f32830m = null;
                } else {
                    this.f32830m = str12;
                }
            }

            public final C0350c a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends Map<String, ? extends Object>> list, String str12) {
                return new C0350c(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, list, str12);
            }

            public C0350c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<? extends Map<String, ? extends Object>> list, String str12) {
                this.f32818a = str;
                this.f32819b = str2;
                this.f32820c = str3;
                this.f32821d = str4;
                this.f32822e = str5;
                this.f32823f = str6;
                this.f32824g = str7;
                this.f32825h = str8;
                this.f32826i = str9;
                this.f32827j = str10;
                this.f32828k = str11;
                this.f32829l = list;
                this.f32830m = str12;
            }

            public static /* synthetic */ C0350c a(C0350c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List list, String str12, int i11, Object obj) {
                C0350c cVar2 = cVar;
                int i12 = i11;
                return cVar.a((i12 & 1) != 0 ? cVar2.f32818a : str, (i12 & 2) != 0 ? cVar2.f32819b : str2, (i12 & 4) != 0 ? cVar2.f32820c : str3, (i12 & 8) != 0 ? cVar2.f32821d : str4, (i12 & 16) != 0 ? cVar2.f32822e : str5, (i12 & 32) != 0 ? cVar2.f32823f : str6, (i12 & 64) != 0 ? cVar2.f32824g : str7, (i12 & 128) != 0 ? cVar2.f32825h : str8, (i12 & 256) != 0 ? cVar2.f32826i : str9, (i12 & 512) != 0 ? cVar2.f32827j : str10, (i12 & 1024) != 0 ? cVar2.f32828k : str11, (i12 & 2048) != 0 ? cVar2.f32829l : list, (i12 & 4096) != 0 ? cVar2.f32830m : str12);
            }

            public static final void a(C0350c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                boolean z11 = false;
                if (bVar.q(fVar, 0) || cVar.f32818a != null) {
                    bVar.y(fVar, 0, v1.f57779a, cVar.f32818a);
                }
                if (bVar.q(fVar, 1) || cVar.f32819b != null) {
                    bVar.y(fVar, 1, v1.f57779a, cVar.f32819b);
                }
                if (bVar.q(fVar, 2) || cVar.f32820c != null) {
                    bVar.y(fVar, 2, v1.f57779a, cVar.f32820c);
                }
                if (bVar.q(fVar, 3) || cVar.f32821d != null) {
                    bVar.y(fVar, 3, v1.f57779a, cVar.f32821d);
                }
                if (bVar.q(fVar, 4) || cVar.f32822e != null) {
                    bVar.y(fVar, 4, v1.f57779a, cVar.f32822e);
                }
                if (bVar.q(fVar, 5) || cVar.f32823f != null) {
                    bVar.y(fVar, 5, v1.f57779a, cVar.f32823f);
                }
                if (bVar.q(fVar, 6) || cVar.f32824g != null) {
                    bVar.y(fVar, 6, v1.f57779a, cVar.f32824g);
                }
                if (bVar.q(fVar, 7) || cVar.f32825h != null) {
                    bVar.y(fVar, 7, v1.f57779a, cVar.f32825h);
                }
                if (bVar.q(fVar, 8) || cVar.f32826i != null) {
                    bVar.y(fVar, 8, v1.f57779a, cVar.f32826i);
                }
                if (bVar.q(fVar, 9) || cVar.f32827j != null) {
                    bVar.y(fVar, 9, v1.f57779a, cVar.f32827j);
                }
                if (bVar.q(fVar, 10) || cVar.f32828k != null) {
                    bVar.y(fVar, 10, v1.f57779a, cVar.f32828k);
                }
                if (bVar.q(fVar, 11) || cVar.f32829l != null) {
                    bVar.y(fVar, 11, new kotlinx.serialization.internal.e(new r0(v1.f57779a, h10.a.u(new ContextualSerializer(Reflection.b(Object.class), (kotlinx.serialization.b) null, new kotlinx.serialization.b[0])))), cVar.f32829l);
                }
                if (bVar.q(fVar, 12) || cVar.f32830m != null) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar, 12, v1.f57779a, cVar.f32830m);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ C0350c(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.util.List r26, java.lang.String r27, int r28, kotlin.jvm.internal.r r29) {
                /*
                    r14 = this;
                    r0 = r28
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r15
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0012
                L_0x0010:
                    r3 = r16
                L_0x0012:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0018
                    r4 = r2
                    goto L_0x001a
                L_0x0018:
                    r4 = r17
                L_0x001a:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x0020
                    r5 = r2
                    goto L_0x0022
                L_0x0020:
                    r5 = r18
                L_0x0022:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0028
                    r6 = r2
                    goto L_0x002a
                L_0x0028:
                    r6 = r19
                L_0x002a:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x0030
                    r7 = r2
                    goto L_0x0032
                L_0x0030:
                    r7 = r20
                L_0x0032:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0038
                    r8 = r2
                    goto L_0x003a
                L_0x0038:
                    r8 = r21
                L_0x003a:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x0040
                    r9 = r2
                    goto L_0x0042
                L_0x0040:
                    r9 = r22
                L_0x0042:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x0048
                    r10 = r2
                    goto L_0x004a
                L_0x0048:
                    r10 = r23
                L_0x004a:
                    r11 = r0 & 512(0x200, float:7.175E-43)
                    if (r11 == 0) goto L_0x0050
                    r11 = r2
                    goto L_0x0052
                L_0x0050:
                    r11 = r24
                L_0x0052:
                    r12 = r0 & 1024(0x400, float:1.435E-42)
                    if (r12 == 0) goto L_0x0058
                    r12 = r2
                    goto L_0x005a
                L_0x0058:
                    r12 = r25
                L_0x005a:
                    r13 = r0 & 2048(0x800, float:2.87E-42)
                    if (r13 == 0) goto L_0x0060
                    r13 = r2
                    goto L_0x0062
                L_0x0060:
                    r13 = r26
                L_0x0062:
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x0067
                    goto L_0x0069
                L_0x0067:
                    r2 = r27
                L_0x0069:
                    r15 = r14
                    r16 = r1
                    r17 = r3
                    r18 = r4
                    r19 = r5
                    r20 = r6
                    r21 = r7
                    r22 = r8
                    r23 = r9
                    r24 = r10
                    r25 = r11
                    r26 = r12
                    r27 = r13
                    r28 = r2
                    r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.r):void");
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\b\u0014B\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\b\b\u0002\u0010.\u001a\u00020\t\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$¢\u0006\u0004\b|\u0010}B±\u0002\b\u0017\u0012\u0006\u0010~\u001a\u00020>\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00101\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u00104\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\n\b\u0001\u00105\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00106\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00107\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00108\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u00109\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0001\u0010<\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010¢\u0006\u0005\b|\u0010\u0001J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$HÆ\u0003J\u0002\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010)\u001a\u00020\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\n\b\u0002\u00105\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$HÆ\u0001J\t\u0010=\u001a\u00020\tHÖ\u0001J\t\u0010?\u001a\u00020>HÖ\u0001J\u0013\u0010B\u001a\u00020A2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010'\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010C\u0012\u0004\bF\u0010G\u001a\u0004\bD\u0010ER\"\u0010(\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010C\u0012\u0004\bI\u0010G\u001a\u0004\bH\u0010ER \u0010)\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010J\u0012\u0004\bM\u0010G\u001a\u0004\bK\u0010LR\"\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010C\u0012\u0004\bO\u0010G\u001a\u0004\bN\u0010ER\"\u0010+\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010C\u0012\u0004\bQ\u0010G\u001a\u0004\bP\u0010ER \u0010,\u001a\u00020\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010R\u0012\u0004\bU\u0010G\u001a\u0004\bS\u0010TR \u0010-\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010C\u0012\u0004\bW\u0010G\u001a\u0004\bV\u0010ER \u0010.\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010C\u0012\u0004\bY\u0010G\u001a\u0004\bX\u0010ER\"\u0010/\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010C\u0012\u0004\b[\u0010G\u001a\u0004\bZ\u0010ER\"\u00100\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010C\u0012\u0004\b]\u0010G\u001a\u0004\b\\\u0010ER\"\u00101\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\u0012\n\u0004\b \u0010^\u0012\u0004\ba\u0010G\u001a\u0004\b_\u0010`R\"\u00102\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010^\u0012\u0004\bc\u0010G\u001a\u0004\bb\u0010`R\"\u00103\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b!\u0010C\u0012\u0004\be\u0010G\u001a\u0004\bd\u0010ER(\u00104\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0004¢\u0006\u0012\n\u0004\b#\u0010f\u0012\u0004\bi\u0010G\u001a\u0004\bg\u0010hR\"\u00105\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b&\u0010C\u0012\u0004\bk\u0010G\u001a\u0004\bj\u0010ER\"\u00106\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010C\u0012\u0004\bm\u0010G\u001a\u0004\bl\u0010ER\"\u00107\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010C\u0012\u0004\bo\u0010G\u001a\u0004\bn\u0010ER\"\u00108\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010C\u0012\u0004\bq\u0010G\u001a\u0004\bp\u0010ER\"\u00109\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010C\u0012\u0004\bs\u0010G\u001a\u0004\br\u0010ER\"\u0010:\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010C\u0012\u0004\bu\u0010G\u001a\u0004\bt\u0010ER\"\u0010;\u001a\u0004\u0018\u00010\"8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010v\u0012\u0004\by\u0010G\u001a\u0004\bw\u0010xR(\u0010<\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010f\u0012\u0004\b{\u0010G\u001a\u0004\bz\u0010h¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$d;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "l", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;", "p", "q", "r", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;", "s", "t", "u", "v", "b", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;", "c", "d", "e", "", "Lcom/sumsub/sns/internal/core/data/model/remote/e;", "f", "g", "h", "i", "j", "k", "m", "Lcom/sumsub/sns/internal/core/data/model/b;", "n", "", "Lcom/sumsub/sns/internal/core/data/source/applicant/remote/u;", "o", "createdAt", "inspectionId", "requiredIdDocs", "clientId", "externalUserId", "review", "id", "applicantId", "env", "type", "info", "fixedInfo", "lang", "metadata", "email", "tin", "phone", "key", "applicantPlatform", "ipCountry", "agreement", "questionnaires", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "E", "()Ljava/lang/String;", "getCreatedAt$annotations", "()V", "S", "getInspectionId$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;", "g0", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;", "getRequiredIdDocs$annotations", "C", "getClientId$annotations", "K", "getExternalUserId$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;", "i0", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;", "getReview$annotations", "O", "getId$annotations", "y", "getApplicantId$annotations", "I", "getEnv$annotations", "m0", "getType$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;", "Q", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;", "getInfo$annotations", "M", "getFixedInfo$annotations", "Y", "getLang$annotations", "Ljava/util/List;", "a0", "()Ljava/util/List;", "getMetadata$annotations", "G", "getEmail$annotations", "k0", "getTin$annotations", "c0", "getPhone$annotations", "W", "getKey$annotations", "A", "getApplicantPlatform$annotations", "U", "getIpCountry$annotations", "Lcom/sumsub/sns/internal/core/data/model/b;", "w", "()Lcom/sumsub/sns/internal/core/data/model/b;", "getAgreement$annotations", "e0", "getQuestionnaires$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/b;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$c;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/b;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$d  reason: collision with other inner class name */
        public static final class C0351d {
            public static final b Companion = new b((r) null);

            /* renamed from: a  reason: collision with root package name */
            public final String f32833a;

            /* renamed from: b  reason: collision with root package name */
            public final String f32834b;

            /* renamed from: c  reason: collision with root package name */
            public final e f32835c;

            /* renamed from: d  reason: collision with root package name */
            public final String f32836d;

            /* renamed from: e  reason: collision with root package name */
            public final String f32837e;

            /* renamed from: f  reason: collision with root package name */
            public final f f32838f;

            /* renamed from: g  reason: collision with root package name */
            public final String f32839g;

            /* renamed from: h  reason: collision with root package name */
            public final String f32840h;

            /* renamed from: i  reason: collision with root package name */
            public final String f32841i;

            /* renamed from: j  reason: collision with root package name */
            public final String f32842j;

            /* renamed from: k  reason: collision with root package name */
            public final C0350c f32843k;

            /* renamed from: l  reason: collision with root package name */
            public final C0350c f32844l;

            /* renamed from: m  reason: collision with root package name */
            public final String f32845m;

            /* renamed from: n  reason: collision with root package name */
            public final List<com.sumsub.sns.internal.core.data.model.remote.e> f32846n;

            /* renamed from: o  reason: collision with root package name */
            public final String f32847o;

            /* renamed from: p  reason: collision with root package name */
            public final String f32848p;

            /* renamed from: q  reason: collision with root package name */
            public final String f32849q;

            /* renamed from: r  reason: collision with root package name */
            public final String f32850r;

            /* renamed from: s  reason: collision with root package name */
            public final String f32851s;

            /* renamed from: t  reason: collision with root package name */
            public final String f32852t;

            /* renamed from: u  reason: collision with root package name */
            public final com.sumsub.sns.internal.core.data.model.b f32853u;

            /* renamed from: v  reason: collision with root package name */
            public final List<u> f32854v;

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$d$a */
            public static final class a implements d0<C0351d> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32855a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32856b;

                static {
                    a aVar = new a();
                    f32855a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.Item", aVar, 22);
                    pluginGeneratedSerialDescriptor.k("createdAt", true);
                    pluginGeneratedSerialDescriptor.k("inspectionId", true);
                    pluginGeneratedSerialDescriptor.k("requiredIdDocs", false);
                    pluginGeneratedSerialDescriptor.k("clientId", true);
                    pluginGeneratedSerialDescriptor.k("externalUserId", true);
                    pluginGeneratedSerialDescriptor.k("review", false);
                    pluginGeneratedSerialDescriptor.k("id", true);
                    pluginGeneratedSerialDescriptor.k("applicantId", true);
                    pluginGeneratedSerialDescriptor.k("env", true);
                    pluginGeneratedSerialDescriptor.k("type", true);
                    pluginGeneratedSerialDescriptor.k("info", true);
                    pluginGeneratedSerialDescriptor.k("fixedInfo", true);
                    pluginGeneratedSerialDescriptor.k("lang", true);
                    pluginGeneratedSerialDescriptor.k("metadata", true);
                    pluginGeneratedSerialDescriptor.k("email", true);
                    pluginGeneratedSerialDescriptor.k("tin", true);
                    pluginGeneratedSerialDescriptor.k(PlaceFields.PHONE, true);
                    pluginGeneratedSerialDescriptor.k("key", true);
                    pluginGeneratedSerialDescriptor.k("applicantPlatform", true);
                    pluginGeneratedSerialDescriptor.k("ipCountry", true);
                    pluginGeneratedSerialDescriptor.k("agreement", true);
                    pluginGeneratedSerialDescriptor.k("questionnaires", true);
                    f32856b = pluginGeneratedSerialDescriptor;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v1, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v2, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v3, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v2, resolved type: java.lang.Object} */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x02ef, code lost:
                    r3 = r56;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0369, code lost:
                    r24 = r39;
                    r25 = r40;
                    r26 = r41;
                    r27 = r42;
                    r30 = r43;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:0x039a, code lost:
                    r4 = r58;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x045c, code lost:
                    r37 = r37 | r3;
                    r39 = r24;
                    r40 = r25;
                    r41 = r26;
                    r42 = r27;
                    r43 = r30;
                    r5 = r31;
                    r3 = r34;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x0484, code lost:
                    r2 = r35;
                 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d deserialize(kotlinx.serialization.encoding.c r58) {
                    /*
                        r57 = this;
                        kotlinx.serialization.descriptors.f r0 = r57.getDescriptor()
                        r1 = r58
                        kotlinx.serialization.encoding.a r1 = r1.b(r0)
                        boolean r2 = r1.k()
                        r12 = 10
                        r13 = 9
                        r14 = 7
                        r15 = 6
                        r3 = 5
                        r4 = 3
                        r6 = 8
                        r5 = 4
                        r7 = 2
                        r8 = 0
                        r9 = 1
                        r10 = 0
                        if (r2 == 0) goto L_0x00cf
                        kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r8 = r1.j(r0, r8, r2, r10)
                        java.lang.Object r9 = r1.j(r0, r9, r2, r10)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$a r11 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.a.f32863a
                        java.lang.Object r7 = r1.p(r0, r7, r11, r10)
                        java.lang.Object r4 = r1.j(r0, r4, r2, r10)
                        java.lang.Object r5 = r1.j(r0, r5, r2, r10)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$a r11 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.a.f32887a
                        java.lang.Object r3 = r1.p(r0, r3, r11, r10)
                        java.lang.String r11 = r1.i(r0, r15)
                        java.lang.String r14 = r1.i(r0, r14)
                        java.lang.Object r6 = r1.j(r0, r6, r2, r10)
                        java.lang.Object r13 = r1.j(r0, r13, r2, r10)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c$a r15 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c.a.f32831a
                        java.lang.Object r12 = r1.j(r0, r12, r15, r10)
                        r24 = r3
                        r3 = 11
                        java.lang.Object r3 = r1.j(r0, r3, r15, r10)
                        r15 = 12
                        java.lang.Object r15 = r1.j(r0, r15, r2, r10)
                        kotlinx.serialization.internal.e r10 = new kotlinx.serialization.internal.e
                        r23 = r3
                        com.sumsub.sns.internal.core.data.model.remote.e$a r3 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                        r10.<init>(r3)
                        r22 = r8
                        r3 = 13
                        r8 = 0
                        java.lang.Object r3 = r1.j(r0, r3, r10, r8)
                        r10 = 14
                        java.lang.Object r10 = r1.j(r0, r10, r2, r8)
                        r21 = r3
                        r3 = 15
                        java.lang.Object r3 = r1.j(r0, r3, r2, r8)
                        r20 = r3
                        r3 = 16
                        java.lang.Object r3 = r1.j(r0, r3, r2, r8)
                        r19 = r3
                        r3 = 17
                        java.lang.Object r3 = r1.j(r0, r3, r2, r8)
                        r18 = r3
                        r3 = 18
                        java.lang.Object r3 = r1.j(r0, r3, r2, r8)
                        r17 = r3
                        r3 = 19
                        java.lang.Object r2 = r1.j(r0, r3, r2, r8)
                        com.sumsub.sns.internal.core.data.model.b$a r3 = com.sumsub.sns.internal.core.data.model.b.a.f32521a
                        r16 = r2
                        r2 = 20
                        java.lang.Object r2 = r1.j(r0, r2, r3, r8)
                        kotlinx.serialization.internal.e r3 = new kotlinx.serialization.internal.e
                        com.sumsub.sns.internal.core.data.source.applicant.remote.u$a r8 = com.sumsub.sns.internal.core.data.source.applicant.remote.u.a.f33217a
                        r3.<init>(r8)
                        r8 = 21
                        r58 = r9
                        r9 = 0
                        java.lang.Object r3 = r1.j(r0, r8, r3, r9)
                        r8 = 4194303(0x3fffff, float:5.87747E-39)
                        r9 = r58
                        r32 = r8
                        r39 = r11
                        r40 = r14
                        r11 = r15
                        r8 = r22
                        r15 = r23
                        r30 = r24
                        goto L_0x04c1
                    L_0x00cf:
                        r2 = r8
                        r8 = r9
                        r9 = r10
                        r37 = r2
                        r44 = r8
                        r2 = r9
                        r3 = r2
                        r4 = r3
                        r5 = r4
                        r6 = r5
                        r7 = r6
                        r8 = r7
                        r10 = r8
                        r11 = r10
                        r12 = r11
                        r13 = r12
                        r14 = r13
                        r15 = r14
                        r28 = r15
                        r29 = r28
                        r38 = r29
                        r39 = r38
                        r40 = r39
                        r41 = r40
                        r42 = r41
                        r43 = r42
                    L_0x00f3:
                        if (r44 == 0) goto L_0x0488
                        r45 = r5
                        int r5 = r1.w(r0)
                        switch(r5) {
                            case -1: goto L_0x046d;
                            case 0: goto L_0x0437;
                            case 1: goto L_0x0412;
                            case 2: goto L_0x03ed;
                            case 3: goto L_0x03c6;
                            case 4: goto L_0x039f;
                            case 5: goto L_0x0376;
                            case 6: goto L_0x0350;
                            case 7: goto L_0x0336;
                            case 8: goto L_0x031a;
                            case 9: goto L_0x02f3;
                            case 10: goto L_0x02c7;
                            case 11: goto L_0x029e;
                            case 12: goto L_0x0275;
                            case 13: goto L_0x0246;
                            case 14: goto L_0x021c;
                            case 15: goto L_0x01f1;
                            case 16: goto L_0x01c7;
                            case 17: goto L_0x019d;
                            case 18: goto L_0x0177;
                            case 19: goto L_0x014f;
                            case 20: goto L_0x012d;
                            case 21: goto L_0x0104;
                            default: goto L_0x00fe;
                        }
                    L_0x00fe:
                        kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                        r0.<init>((int) r5)
                        throw r0
                    L_0x0104:
                        kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                        r46 = r3
                        com.sumsub.sns.internal.core.data.source.applicant.remote.u$a r3 = com.sumsub.sns.internal.core.data.source.applicant.remote.u.a.f33217a
                        r5.<init>(r3)
                        r3 = 21
                        java.lang.Object r3 = r1.j(r0, r3, r5, r4)
                        r4 = 2097152(0x200000, float:2.938736E-39)
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r5 = 20
                        r56 = r4
                        r4 = r3
                        goto L_0x02ef
                    L_0x012d:
                        r46 = r3
                        com.sumsub.sns.internal.core.data.model.b$a r3 = com.sumsub.sns.internal.core.data.model.b.a.f32521a
                        r5 = 20
                        java.lang.Object r3 = r1.j(r0, r5, r3, r7)
                        r7 = 1048576(0x100000, float:1.469368E-39)
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r7
                        r7 = r3
                        goto L_0x02ef
                    L_0x014f:
                        r46 = r3
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r58 = r4
                        r4 = 19
                        java.lang.Object r3 = r1.j(r0, r4, r3, r8)
                        r8 = 524288(0x80000, float:7.34684E-40)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r8
                        r8 = r3
                        goto L_0x02ef
                    L_0x0177:
                        r46 = r3
                        r58 = r4
                        r4 = 19
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 18
                        java.lang.Object r2 = r1.j(r0, r4, r3, r2)
                        r3 = 262144(0x40000, float:3.67342E-40)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        goto L_0x0373
                    L_0x019d:
                        r46 = r3
                        r58 = r4
                        r4 = 18
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 17
                        java.lang.Object r3 = r1.j(r0, r4, r3, r11)
                        r11 = 131072(0x20000, float:1.83671E-40)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r11
                        r11 = r3
                        goto L_0x02ef
                    L_0x01c7:
                        r46 = r3
                        r58 = r4
                        r4 = 17
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 16
                        java.lang.Object r3 = r1.j(r0, r4, r3, r10)
                        r10 = 65536(0x10000, float:9.18355E-41)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r10
                        r10 = r3
                        goto L_0x02ef
                    L_0x01f1:
                        r46 = r3
                        r58 = r4
                        r4 = 16
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 15
                        java.lang.Object r3 = r1.j(r0, r4, r3, r9)
                        r9 = 32768(0x8000, float:4.5918E-41)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r9
                        r9 = r3
                        goto L_0x02ef
                    L_0x021c:
                        r46 = r3
                        r58 = r4
                        r4 = 15
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 14
                        java.lang.Object r3 = r1.j(r0, r4, r3, r12)
                        r12 = 16384(0x4000, float:2.2959E-41)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r12
                        r12 = r3
                        goto L_0x02ef
                    L_0x0246:
                        r46 = r3
                        r58 = r4
                        r4 = 14
                        r5 = 20
                        kotlinx.serialization.internal.e r3 = new kotlinx.serialization.internal.e
                        com.sumsub.sns.internal.core.data.model.remote.e$a r4 = com.sumsub.sns.internal.core.data.model.remote.e.a.f32717a
                        r3.<init>(r4)
                        r4 = 13
                        java.lang.Object r3 = r1.j(r0, r4, r3, r13)
                        r13 = 8192(0x2000, float:1.14794E-41)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r13
                        r13 = r3
                        goto L_0x02ef
                    L_0x0275:
                        r46 = r3
                        r58 = r4
                        r4 = 13
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r4 = 12
                        java.lang.Object r3 = r1.j(r0, r4, r3, r6)
                        r6 = 4096(0x1000, float:5.74E-42)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r6
                        r6 = r3
                        goto L_0x02ef
                    L_0x029e:
                        r46 = r3
                        r58 = r4
                        r4 = 12
                        r5 = 20
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c$a r3 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c.a.f32831a
                        r4 = 11
                        java.lang.Object r3 = r1.j(r0, r4, r3, r15)
                        r15 = 2048(0x800, float:2.87E-42)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r15
                        r15 = r3
                        goto L_0x02ef
                    L_0x02c7:
                        r46 = r3
                        r58 = r4
                        r4 = 11
                        r5 = 20
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c$a r3 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c.a.f32831a
                        r4 = 10
                        java.lang.Object r3 = r1.j(r0, r4, r3, r14)
                        r14 = 1024(0x400, float:1.435E-42)
                        r4 = r58
                        r35 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r34 = r46
                        r2 = 0
                        r56 = r14
                        r14 = r3
                    L_0x02ef:
                        r3 = r56
                        goto L_0x045c
                    L_0x02f3:
                        r46 = r3
                        r58 = r4
                        r4 = 10
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r35 = r2
                        r4 = r46
                        r2 = 9
                        java.lang.Object r3 = r1.j(r0, r2, r3, r4)
                        r4 = 512(0x200, float:7.175E-43)
                        r34 = r3
                        r3 = r4
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        goto L_0x039a
                    L_0x031a:
                        r35 = r2
                        r58 = r4
                        r2 = 9
                        r5 = 20
                        r4 = r3
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r34 = r4
                        r2 = r45
                        r4 = 8
                        java.lang.Object r2 = r1.j(r0, r4, r3, r2)
                        r3 = 256(0x100, float:3.59E-43)
                        r4 = r58
                        r31 = r2
                        goto L_0x0369
                    L_0x0336:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r2 = r45
                        r3 = 7
                        r4 = 8
                        r5 = 20
                        java.lang.String r29 = r1.i(r0, r3)
                        r33 = 128(0x80, float:1.794E-43)
                        r4 = r58
                        r31 = r2
                        r3 = r33
                        goto L_0x0369
                    L_0x0350:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r2 = r45
                        r3 = 6
                        r4 = 8
                        r5 = 20
                        java.lang.String r28 = r1.i(r0, r3)
                        r32 = 64
                        r4 = r58
                        r31 = r2
                        r3 = r32
                    L_0x0369:
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                    L_0x0373:
                        r2 = 0
                        goto L_0x045c
                    L_0x0376:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r2 = r45
                        r4 = 8
                        r5 = 20
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$a r3 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.a.f32887a
                        r31 = r2
                        r4 = r43
                        r2 = 5
                        java.lang.Object r3 = r1.p(r0, r2, r3, r4)
                        r4 = 32
                        r30 = r3
                        r3 = r4
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                    L_0x039a:
                        r2 = 0
                        r4 = r58
                        goto L_0x045c
                    L_0x039f:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r4 = r43
                        r31 = r45
                        r2 = 5
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r30 = r4
                        r2 = r42
                        r4 = 4
                        java.lang.Object r2 = r1.j(r0, r4, r3, r2)
                        r4 = r58
                        r27 = r2
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r2 = 0
                        r3 = 16
                        goto L_0x045c
                    L_0x03c6:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r2 = r42
                        r30 = r43
                        r31 = r45
                        r4 = 4
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r27 = r2
                        r4 = r41
                        r2 = 3
                        java.lang.Object r3 = r1.j(r0, r2, r3, r4)
                        r4 = r58
                        r26 = r3
                        r24 = r39
                        r25 = r40
                        r2 = 0
                        r3 = 8
                        goto L_0x045c
                    L_0x03ed:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r4 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r2 = 3
                        r5 = 20
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$a r3 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.a.f32863a
                        r26 = r4
                        r2 = r40
                        r4 = 2
                        java.lang.Object r2 = r1.p(r0, r4, r3, r2)
                        r4 = r58
                        r25 = r2
                        r24 = r39
                        r2 = 0
                        r3 = 4
                        goto L_0x045c
                    L_0x0412:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r2 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r4 = 2
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r25 = r2
                        r4 = r39
                        r2 = 1
                        java.lang.Object r3 = r1.j(r0, r2, r3, r4)
                        r4 = r58
                        r24 = r3
                        r2 = 0
                        r3 = 2
                        goto L_0x045c
                    L_0x0437:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r4 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r2 = 1
                        r5 = 20
                        kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                        r24 = r4
                        r4 = r38
                        r2 = 0
                        java.lang.Object r3 = r1.j(r0, r2, r3, r4)
                        r4 = r58
                        r38 = r3
                        r3 = 1
                    L_0x045c:
                        r37 = r37 | r3
                        r39 = r24
                        r40 = r25
                        r41 = r26
                        r42 = r27
                        r43 = r30
                        r5 = r31
                        r3 = r34
                        goto L_0x0484
                    L_0x046d:
                        r35 = r2
                        r58 = r4
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r31 = r45
                        r2 = 0
                        r5 = 20
                        r44 = r2
                        r5 = r31
                    L_0x0484:
                        r2 = r35
                        goto L_0x00f3
                    L_0x0488:
                        r35 = r2
                        r34 = r3
                        r58 = r4
                        r31 = r5
                        r4 = r38
                        r24 = r39
                        r25 = r40
                        r26 = r41
                        r27 = r42
                        r30 = r43
                        r3 = r58
                        r2 = r7
                        r16 = r8
                        r20 = r9
                        r19 = r10
                        r18 = r11
                        r10 = r12
                        r21 = r13
                        r12 = r14
                        r9 = r24
                        r7 = r25
                        r5 = r27
                        r39 = r28
                        r40 = r29
                        r13 = r34
                        r17 = r35
                        r32 = r37
                        r8 = r4
                        r11 = r6
                        r4 = r26
                        r6 = r31
                    L_0x04c1:
                        r1.c(r0)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r0 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$d
                        r31 = r0
                        r33 = r8
                        java.lang.String r33 = (java.lang.String) r33
                        r34 = r9
                        java.lang.String r34 = (java.lang.String) r34
                        r35 = r7
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e r35 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.e) r35
                        r36 = r4
                        java.lang.String r36 = (java.lang.String) r36
                        r37 = r5
                        java.lang.String r37 = (java.lang.String) r37
                        r38 = r30
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f r38 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.f) r38
                        r41 = r6
                        java.lang.String r41 = (java.lang.String) r41
                        r42 = r13
                        java.lang.String r42 = (java.lang.String) r42
                        r43 = r12
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r43 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c) r43
                        r44 = r15
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r44 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c) r44
                        r45 = r11
                        java.lang.String r45 = (java.lang.String) r45
                        r46 = r21
                        java.util.List r46 = (java.util.List) r46
                        r47 = r10
                        java.lang.String r47 = (java.lang.String) r47
                        r48 = r20
                        java.lang.String r48 = (java.lang.String) r48
                        r49 = r19
                        java.lang.String r49 = (java.lang.String) r49
                        r50 = r18
                        java.lang.String r50 = (java.lang.String) r50
                        r51 = r17
                        java.lang.String r51 = (java.lang.String) r51
                        r52 = r16
                        java.lang.String r52 = (java.lang.String) r52
                        r53 = r2
                        com.sumsub.sns.internal.core.data.model.b r53 = (com.sumsub.sns.internal.core.data.model.b) r53
                        r54 = r3
                        java.util.List r54 = (java.util.List) r54
                        r55 = 0
                        r31.<init>((int) r32, (java.lang.String) r33, (java.lang.String) r34, (com.sumsub.sns.internal.core.data.model.remote.response.d.c.e) r35, (java.lang.String) r36, (java.lang.String) r37, (com.sumsub.sns.internal.core.data.model.remote.response.d.c.f) r38, (java.lang.String) r39, (java.lang.String) r40, (java.lang.String) r41, (java.lang.String) r42, (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c) r43, (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c) r44, (java.lang.String) r45, (java.util.List) r46, (java.lang.String) r47, (java.lang.String) r48, (java.lang.String) r49, (java.lang.String) r50, (java.lang.String) r51, (java.lang.String) r52, (com.sumsub.sns.internal.core.data.model.b) r53, (java.util.List) r54, (kotlinx.serialization.internal.q1) r55)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$d");
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    v1 v1Var = v1.f57779a;
                    C0350c.a aVar = C0350c.a.f32831a;
                    return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), e.a.f32863a, h10.a.u(v1Var), h10.a.u(v1Var), f.a.f32887a, v1Var, v1Var, h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(aVar), h10.a.u(aVar), h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(e.a.f32717a)), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(b.a.f32521a), h10.a.u(new kotlinx.serialization.internal.e(u.a.f33217a))};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32856b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, C0351d dVar2) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    C0351d.a(dVar2, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$d$b */
            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<C0351d> serializer() {
                    return a.f32855a;
                }

                public b() {
                }
            }

            public /* synthetic */ C0351d(int i11, String str, String str2, e eVar, String str3, String str4, f fVar, String str5, String str6, String str7, String str8, C0350c cVar, C0350c cVar2, String str9, List list, String str10, String str11, String str12, String str13, String str14, String str15, com.sumsub.sns.internal.core.data.model.b bVar, List list2, q1 q1Var) {
                int i12 = i11;
                if (36 != (i12 & 36)) {
                    h1.a(i11, 36, a.f32855a.getDescriptor());
                }
                if ((i12 & 1) == 0) {
                    this.f32833a = null;
                } else {
                    this.f32833a = str;
                }
                if ((i12 & 2) == 0) {
                    this.f32834b = null;
                } else {
                    this.f32834b = str2;
                }
                this.f32835c = eVar;
                if ((i12 & 8) == 0) {
                    this.f32836d = null;
                } else {
                    this.f32836d = str3;
                }
                if ((i12 & 16) == 0) {
                    this.f32837e = null;
                } else {
                    this.f32837e = str4;
                }
                this.f32838f = fVar;
                if ((i12 & 64) == 0) {
                    this.f32839g = "";
                } else {
                    this.f32839g = str5;
                }
                if ((i12 & 128) == 0) {
                    this.f32840h = "";
                } else {
                    this.f32840h = str6;
                }
                if ((i12 & 256) == 0) {
                    this.f32841i = null;
                } else {
                    this.f32841i = str7;
                }
                if ((i12 & 512) == 0) {
                    this.f32842j = null;
                } else {
                    this.f32842j = str8;
                }
                if ((i12 & 1024) == 0) {
                    this.f32843k = null;
                } else {
                    this.f32843k = cVar;
                }
                if ((i12 & 2048) == 0) {
                    this.f32844l = null;
                } else {
                    this.f32844l = cVar2;
                }
                if ((i12 & 4096) == 0) {
                    this.f32845m = null;
                } else {
                    this.f32845m = str9;
                }
                if ((i12 & 8192) == 0) {
                    this.f32846n = null;
                } else {
                    this.f32846n = list;
                }
                if ((i12 & 16384) == 0) {
                    this.f32847o = null;
                } else {
                    this.f32847o = str10;
                }
                if ((32768 & i12) == 0) {
                    this.f32848p = null;
                } else {
                    this.f32848p = str11;
                }
                if ((65536 & i12) == 0) {
                    this.f32849q = null;
                } else {
                    this.f32849q = str12;
                }
                if ((131072 & i12) == 0) {
                    this.f32850r = null;
                } else {
                    this.f32850r = str13;
                }
                if ((262144 & i12) == 0) {
                    this.f32851s = null;
                } else {
                    this.f32851s = str14;
                }
                if ((524288 & i12) == 0) {
                    this.f32852t = null;
                } else {
                    this.f32852t = str15;
                }
                if ((1048576 & i12) == 0) {
                    this.f32853u = null;
                } else {
                    this.f32853u = bVar;
                }
                if ((i12 & 2097152) == 0) {
                    this.f32854v = null;
                } else {
                    this.f32854v = list2;
                }
            }

            public static /* synthetic */ void B() {
            }

            public static /* synthetic */ void D() {
            }

            public static /* synthetic */ void F() {
            }

            public static /* synthetic */ void H() {
            }

            public static /* synthetic */ void J() {
            }

            public static /* synthetic */ void L() {
            }

            public static /* synthetic */ void N() {
            }

            public static /* synthetic */ void P() {
            }

            public static /* synthetic */ void R() {
            }

            public static /* synthetic */ void T() {
            }

            public static /* synthetic */ void V() {
            }

            public static /* synthetic */ void X() {
            }

            public static /* synthetic */ void Z() {
            }

            public static /* synthetic */ void b0() {
            }

            public static /* synthetic */ void d0() {
            }

            public static /* synthetic */ void f0() {
            }

            public static /* synthetic */ void h0() {
            }

            public static /* synthetic */ void j0() {
            }

            public static /* synthetic */ void l0() {
            }

            public static /* synthetic */ void n0() {
            }

            public static /* synthetic */ void x() {
            }

            public static /* synthetic */ void z() {
            }

            public final String A() {
                return this.f32851s;
            }

            public final String C() {
                return this.f32836d;
            }

            public final String E() {
                return this.f32833a;
            }

            public final String G() {
                return this.f32847o;
            }

            public final String I() {
                return this.f32841i;
            }

            public final String K() {
                return this.f32837e;
            }

            public final C0350c M() {
                return this.f32844l;
            }

            public final String O() {
                return this.f32839g;
            }

            public final C0350c Q() {
                return this.f32843k;
            }

            public final String S() {
                return this.f32834b;
            }

            public final String U() {
                return this.f32852t;
            }

            public final String W() {
                return this.f32850r;
            }

            public final String Y() {
                return this.f32845m;
            }

            public final String a() {
                return this.f32833a;
            }

            public final List<com.sumsub.sns.internal.core.data.model.remote.e> a0() {
                return this.f32846n;
            }

            public final String b() {
                return this.f32842j;
            }

            public final C0350c c() {
                return this.f32843k;
            }

            public final String c0() {
                return this.f32849q;
            }

            public final C0350c d() {
                return this.f32844l;
            }

            public final String e() {
                return this.f32845m;
            }

            public final List<u> e0() {
                return this.f32854v;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0351d)) {
                    return false;
                }
                C0351d dVar = (C0351d) obj;
                return x.b(this.f32833a, dVar.f32833a) && x.b(this.f32834b, dVar.f32834b) && x.b(this.f32835c, dVar.f32835c) && x.b(this.f32836d, dVar.f32836d) && x.b(this.f32837e, dVar.f32837e) && x.b(this.f32838f, dVar.f32838f) && x.b(this.f32839g, dVar.f32839g) && x.b(this.f32840h, dVar.f32840h) && x.b(this.f32841i, dVar.f32841i) && x.b(this.f32842j, dVar.f32842j) && x.b(this.f32843k, dVar.f32843k) && x.b(this.f32844l, dVar.f32844l) && x.b(this.f32845m, dVar.f32845m) && x.b(this.f32846n, dVar.f32846n) && x.b(this.f32847o, dVar.f32847o) && x.b(this.f32848p, dVar.f32848p) && x.b(this.f32849q, dVar.f32849q) && x.b(this.f32850r, dVar.f32850r) && x.b(this.f32851s, dVar.f32851s) && x.b(this.f32852t, dVar.f32852t) && x.b(this.f32853u, dVar.f32853u) && x.b(this.f32854v, dVar.f32854v);
            }

            public final List<com.sumsub.sns.internal.core.data.model.remote.e> f() {
                return this.f32846n;
            }

            public final String g() {
                return this.f32847o;
            }

            public final e g0() {
                return this.f32835c;
            }

            public final String h() {
                return this.f32848p;
            }

            public int hashCode() {
                String str = this.f32833a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f32834b;
                int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f32835c.hashCode()) * 31;
                String str3 = this.f32836d;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f32837e;
                int hashCode4 = (((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f32838f.hashCode()) * 31) + this.f32839g.hashCode()) * 31) + this.f32840h.hashCode()) * 31;
                String str5 = this.f32841i;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.f32842j;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                C0350c cVar = this.f32843k;
                int hashCode7 = (hashCode6 + (cVar == null ? 0 : cVar.hashCode())) * 31;
                C0350c cVar2 = this.f32844l;
                int hashCode8 = (hashCode7 + (cVar2 == null ? 0 : cVar2.hashCode())) * 31;
                String str7 = this.f32845m;
                int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
                List<com.sumsub.sns.internal.core.data.model.remote.e> list = this.f32846n;
                int hashCode10 = (hashCode9 + (list == null ? 0 : list.hashCode())) * 31;
                String str8 = this.f32847o;
                int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
                String str9 = this.f32848p;
                int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
                String str10 = this.f32849q;
                int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
                String str11 = this.f32850r;
                int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
                String str12 = this.f32851s;
                int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
                String str13 = this.f32852t;
                int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
                com.sumsub.sns.internal.core.data.model.b bVar = this.f32853u;
                int hashCode17 = (hashCode16 + (bVar == null ? 0 : bVar.hashCode())) * 31;
                List<u> list2 = this.f32854v;
                if (list2 != null) {
                    i11 = list2.hashCode();
                }
                return hashCode17 + i11;
            }

            public final String i() {
                return this.f32849q;
            }

            public final f i0() {
                return this.f32838f;
            }

            public final String j() {
                return this.f32850r;
            }

            public final String k() {
                return this.f32851s;
            }

            public final String k0() {
                return this.f32848p;
            }

            public final String l() {
                return this.f32834b;
            }

            public final String m() {
                return this.f32852t;
            }

            public final String m0() {
                return this.f32842j;
            }

            public final com.sumsub.sns.internal.core.data.model.b n() {
                return this.f32853u;
            }

            public final List<u> o() {
                return this.f32854v;
            }

            public final e p() {
                return this.f32835c;
            }

            public final String q() {
                return this.f32836d;
            }

            public final String r() {
                return this.f32837e;
            }

            public final f s() {
                return this.f32838f;
            }

            public final String t() {
                return this.f32839g;
            }

            public String toString() {
                return "Item(createdAt=" + this.f32833a + ", inspectionId=" + this.f32834b + ", requiredIdDocs=" + this.f32835c + ", clientId=" + this.f32836d + ", externalUserId=" + this.f32837e + ", review=" + this.f32838f + ", id=" + this.f32839g + ", applicantId=" + this.f32840h + ", env=" + this.f32841i + ", type=" + this.f32842j + ", info=" + this.f32843k + ", fixedInfo=" + this.f32844l + ", lang=" + this.f32845m + ", metadata=" + this.f32846n + ", email=" + this.f32847o + ", tin=" + this.f32848p + ", phone=" + this.f32849q + ", key=" + this.f32850r + ", applicantPlatform=" + this.f32851s + ", ipCountry=" + this.f32852t + ", agreement=" + this.f32853u + ", questionnaires=" + this.f32854v + ')';
            }

            public final String u() {
                return this.f32840h;
            }

            public final String v() {
                return this.f32841i;
            }

            public final com.sumsub.sns.internal.core.data.model.b w() {
                return this.f32853u;
            }

            public final String y() {
                return this.f32840h;
            }

            public C0351d(String str, String str2, e eVar, String str3, String str4, f fVar, String str5, String str6, String str7, String str8, C0350c cVar, C0350c cVar2, String str9, List<com.sumsub.sns.internal.core.data.model.remote.e> list, String str10, String str11, String str12, String str13, String str14, String str15, com.sumsub.sns.internal.core.data.model.b bVar, List<u> list2) {
                this.f32833a = str;
                this.f32834b = str2;
                this.f32835c = eVar;
                this.f32836d = str3;
                this.f32837e = str4;
                this.f32838f = fVar;
                this.f32839g = str5;
                this.f32840h = str6;
                this.f32841i = str7;
                this.f32842j = str8;
                this.f32843k = cVar;
                this.f32844l = cVar2;
                this.f32845m = str9;
                this.f32846n = list;
                this.f32847o = str10;
                this.f32848p = str11;
                this.f32849q = str12;
                this.f32850r = str13;
                this.f32851s = str14;
                this.f32852t = str15;
                this.f32853u = bVar;
                this.f32854v = list2;
            }

            public final C0351d a(String str, String str2, e eVar, String str3, String str4, f fVar, String str5, String str6, String str7, String str8, C0350c cVar, C0350c cVar2, String str9, List<com.sumsub.sns.internal.core.data.model.remote.e> list, String str10, String str11, String str12, String str13, String str14, String str15, com.sumsub.sns.internal.core.data.model.b bVar, List<u> list2) {
                return new C0351d(str, str2, eVar, str3, str4, fVar, str5, str6, str7, str8, cVar, cVar2, str9, list, str10, str11, str12, str13, str14, str15, bVar, list2);
            }

            public static /* synthetic */ C0351d a(C0351d dVar, String str, String str2, e eVar, String str3, String str4, f fVar, String str5, String str6, String str7, String str8, C0350c cVar, C0350c cVar2, String str9, List list, String str10, String str11, String str12, String str13, String str14, String str15, com.sumsub.sns.internal.core.data.model.b bVar, List list2, int i11, Object obj) {
                C0351d dVar2 = dVar;
                int i12 = i11;
                return dVar.a((i12 & 1) != 0 ? dVar2.f32833a : str, (i12 & 2) != 0 ? dVar2.f32834b : str2, (i12 & 4) != 0 ? dVar2.f32835c : eVar, (i12 & 8) != 0 ? dVar2.f32836d : str3, (i12 & 16) != 0 ? dVar2.f32837e : str4, (i12 & 32) != 0 ? dVar2.f32838f : fVar, (i12 & 64) != 0 ? dVar2.f32839g : str5, (i12 & 128) != 0 ? dVar2.f32840h : str6, (i12 & 256) != 0 ? dVar2.f32841i : str7, (i12 & 512) != 0 ? dVar2.f32842j : str8, (i12 & 1024) != 0 ? dVar2.f32843k : cVar, (i12 & 2048) != 0 ? dVar2.f32844l : cVar2, (i12 & 4096) != 0 ? dVar2.f32845m : str9, (i12 & 8192) != 0 ? dVar2.f32846n : list, (i12 & 16384) != 0 ? dVar2.f32847o : str10, (i12 & 32768) != 0 ? dVar2.f32848p : str11, (i12 & 65536) != 0 ? dVar2.f32849q : str12, (i12 & 131072) != 0 ? dVar2.f32850r : str13, (i12 & 262144) != 0 ? dVar2.f32851s : str14, (i12 & 524288) != 0 ? dVar2.f32852t : str15, (i12 & 1048576) != 0 ? dVar2.f32853u : bVar, (i12 & 2097152) != 0 ? dVar2.f32854v : list2);
            }

            public static final void a(C0351d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                boolean z11 = false;
                if (bVar.q(fVar, 0) || dVar.f32833a != null) {
                    bVar.y(fVar, 0, v1.f57779a, dVar.f32833a);
                }
                if (bVar.q(fVar, 1) || dVar.f32834b != null) {
                    bVar.y(fVar, 1, v1.f57779a, dVar.f32834b);
                }
                bVar.F(fVar, 2, e.a.f32863a, dVar.f32835c);
                if (bVar.q(fVar, 3) || dVar.f32836d != null) {
                    bVar.y(fVar, 3, v1.f57779a, dVar.f32836d);
                }
                if (bVar.q(fVar, 4) || dVar.f32837e != null) {
                    bVar.y(fVar, 4, v1.f57779a, dVar.f32837e);
                }
                bVar.F(fVar, 5, f.a.f32887a, dVar.f32838f);
                if (bVar.q(fVar, 6) || !x.b(dVar.f32839g, "")) {
                    bVar.p(fVar, 6, dVar.f32839g);
                }
                if (bVar.q(fVar, 7) || !x.b(dVar.f32840h, "")) {
                    bVar.p(fVar, 7, dVar.f32840h);
                }
                if (bVar.q(fVar, 8) || dVar.f32841i != null) {
                    bVar.y(fVar, 8, v1.f57779a, dVar.f32841i);
                }
                if (bVar.q(fVar, 9) || dVar.f32842j != null) {
                    bVar.y(fVar, 9, v1.f57779a, dVar.f32842j);
                }
                if (bVar.q(fVar, 10) || dVar.f32843k != null) {
                    bVar.y(fVar, 10, C0350c.a.f32831a, dVar.f32843k);
                }
                if (bVar.q(fVar, 11) || dVar.f32844l != null) {
                    bVar.y(fVar, 11, C0350c.a.f32831a, dVar.f32844l);
                }
                if (bVar.q(fVar, 12) || dVar.f32845m != null) {
                    bVar.y(fVar, 12, v1.f57779a, dVar.f32845m);
                }
                if (bVar.q(fVar, 13) || dVar.f32846n != null) {
                    bVar.y(fVar, 13, new kotlinx.serialization.internal.e(e.a.f32717a), dVar.f32846n);
                }
                if (bVar.q(fVar, 14) || dVar.f32847o != null) {
                    bVar.y(fVar, 14, v1.f57779a, dVar.f32847o);
                }
                if (bVar.q(fVar, 15) || dVar.f32848p != null) {
                    bVar.y(fVar, 15, v1.f57779a, dVar.f32848p);
                }
                if (bVar.q(fVar, 16) || dVar.f32849q != null) {
                    bVar.y(fVar, 16, v1.f57779a, dVar.f32849q);
                }
                if (bVar.q(fVar, 17) || dVar.f32850r != null) {
                    bVar.y(fVar, 17, v1.f57779a, dVar.f32850r);
                }
                if (bVar.q(fVar, 18) || dVar.f32851s != null) {
                    bVar.y(fVar, 18, v1.f57779a, dVar.f32851s);
                }
                if (bVar.q(fVar, 19) || dVar.f32852t != null) {
                    bVar.y(fVar, 19, v1.f57779a, dVar.f32852t);
                }
                if (bVar.q(fVar, 20) || dVar.f32853u != null) {
                    bVar.y(fVar, 20, b.a.f32521a, dVar.f32853u);
                }
                if (bVar.q(fVar, 21) || dVar.f32854v != null) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar, 21, new kotlinx.serialization.internal.e(u.a.f33217a), dVar.f32854v);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ C0351d(java.lang.String r27, java.lang.String r28, com.sumsub.sns.internal.core.data.model.remote.response.d.c.e r29, java.lang.String r30, java.lang.String r31, com.sumsub.sns.internal.core.data.model.remote.response.d.c.f r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c r37, com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c r38, java.lang.String r39, java.util.List r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, com.sumsub.sns.internal.core.data.model.b r47, java.util.List r48, int r49, kotlin.jvm.internal.r r50) {
                /*
                    r26 = this;
                    r0 = r49
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r4 = r2
                    goto L_0x000b
                L_0x0009:
                    r4 = r27
                L_0x000b:
                    r1 = r0 & 2
                    if (r1 == 0) goto L_0x0011
                    r5 = r2
                    goto L_0x0013
                L_0x0011:
                    r5 = r28
                L_0x0013:
                    r1 = r0 & 8
                    if (r1 == 0) goto L_0x0019
                    r7 = r2
                    goto L_0x001b
                L_0x0019:
                    r7 = r30
                L_0x001b:
                    r1 = r0 & 16
                    if (r1 == 0) goto L_0x0021
                    r8 = r2
                    goto L_0x0023
                L_0x0021:
                    r8 = r31
                L_0x0023:
                    r1 = r0 & 64
                    java.lang.String r3 = ""
                    if (r1 == 0) goto L_0x002b
                    r10 = r3
                    goto L_0x002d
                L_0x002b:
                    r10 = r33
                L_0x002d:
                    r1 = r0 & 128(0x80, float:1.794E-43)
                    if (r1 == 0) goto L_0x0033
                    r11 = r3
                    goto L_0x0035
                L_0x0033:
                    r11 = r34
                L_0x0035:
                    r1 = r0 & 256(0x100, float:3.59E-43)
                    if (r1 == 0) goto L_0x003b
                    r12 = r2
                    goto L_0x003d
                L_0x003b:
                    r12 = r35
                L_0x003d:
                    r1 = r0 & 512(0x200, float:7.175E-43)
                    if (r1 == 0) goto L_0x0043
                    r13 = r2
                    goto L_0x0045
                L_0x0043:
                    r13 = r36
                L_0x0045:
                    r1 = r0 & 1024(0x400, float:1.435E-42)
                    if (r1 == 0) goto L_0x004b
                    r14 = r2
                    goto L_0x004d
                L_0x004b:
                    r14 = r37
                L_0x004d:
                    r1 = r0 & 2048(0x800, float:2.87E-42)
                    if (r1 == 0) goto L_0x0053
                    r15 = r2
                    goto L_0x0055
                L_0x0053:
                    r15 = r38
                L_0x0055:
                    r1 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x005c
                    r16 = r2
                    goto L_0x005e
                L_0x005c:
                    r16 = r39
                L_0x005e:
                    r1 = r0 & 8192(0x2000, float:1.14794E-41)
                    if (r1 == 0) goto L_0x0065
                    r17 = r2
                    goto L_0x0067
                L_0x0065:
                    r17 = r40
                L_0x0067:
                    r1 = r0 & 16384(0x4000, float:2.2959E-41)
                    if (r1 == 0) goto L_0x006e
                    r18 = r2
                    goto L_0x0070
                L_0x006e:
                    r18 = r41
                L_0x0070:
                    r1 = 32768(0x8000, float:4.5918E-41)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0079
                    r19 = r2
                    goto L_0x007b
                L_0x0079:
                    r19 = r42
                L_0x007b:
                    r1 = 65536(0x10000, float:9.18355E-41)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0083
                    r20 = r2
                    goto L_0x0085
                L_0x0083:
                    r20 = r43
                L_0x0085:
                    r1 = 131072(0x20000, float:1.83671E-40)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x008d
                    r21 = r2
                    goto L_0x008f
                L_0x008d:
                    r21 = r44
                L_0x008f:
                    r1 = 262144(0x40000, float:3.67342E-40)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x0097
                    r22 = r2
                    goto L_0x0099
                L_0x0097:
                    r22 = r45
                L_0x0099:
                    r1 = 524288(0x80000, float:7.34684E-40)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x00a1
                    r23 = r2
                    goto L_0x00a3
                L_0x00a1:
                    r23 = r46
                L_0x00a3:
                    r1 = 1048576(0x100000, float:1.469368E-39)
                    r1 = r1 & r0
                    if (r1 == 0) goto L_0x00ab
                    r24 = r2
                    goto L_0x00ad
                L_0x00ab:
                    r24 = r47
                L_0x00ad:
                    r1 = 2097152(0x200000, float:2.938736E-39)
                    r0 = r0 & r1
                    if (r0 == 0) goto L_0x00b5
                    r25 = r2
                    goto L_0x00b7
                L_0x00b5:
                    r25 = r48
                L_0x00b7:
                    r3 = r26
                    r6 = r29
                    r9 = r32
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d.<init>(java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.remote.response.d$c$e, java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.remote.response.d$c$f, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.remote.response.d$c$c, com.sumsub.sns.internal.core.data.model.remote.response.d$c$c, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.b, java.util.List, int, kotlin.jvm.internal.r):void");
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 52\u00020\u0001:\u0003\b\f\u000fBm\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0004\b/\u00100B\u0001\b\u0017\u0012\u0006\u00101\u001a\u00020\u001b\u0012\u0010\b\u0001\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b/\u00104J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0003Jv\u0010\b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\b\u0010\u0019J\t\u0010\u001a\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R(\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010$\u0012\u0004\b&\u0010#\u001a\u0004\b%\u0010\rR(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u0012\u0004\b(\u0010#\u001a\u0004\b'\u0010!R(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u0012\u0004\b*\u0010#\u001a\u0004\b)\u0010!R(\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u0012\u0004\b,\u0010#\u001a\u0004\b+\u0010!R(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u0012\u0004\b.\u0010#\u001a\u0004\b-\u0010!¨\u00066"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e$c;", "", "b", "()Ljava/lang/Boolean;", "", "c", "d", "e", "f", "docSets", "videoIdent", "videoIdentUploadTypes", "stepsOutsideVideoId", "includedCountries", "excludedCountries", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e;", "toString", "", "hashCode", "other", "equals", "Ljava/util/List;", "g", "()Ljava/util/List;", "getDocSets$annotations", "()V", "Ljava/lang/Boolean;", "o", "getVideoIdent$annotations", "q", "getVideoIdentUploadTypes$annotations", "m", "getStepsOutsideVideoId$annotations", "k", "getIncludedCountries$annotations", "i", "getExcludedCountries$annotations", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class e {
            public static final b Companion = new b((r) null);

            /* renamed from: a  reason: collision with root package name */
            public final List<C0352c> f32857a;

            /* renamed from: b  reason: collision with root package name */
            public final Boolean f32858b;

            /* renamed from: c  reason: collision with root package name */
            public final List<String> f32859c;

            /* renamed from: d  reason: collision with root package name */
            public final List<String> f32860d;

            /* renamed from: e  reason: collision with root package name */
            public final List<String> f32861e;

            /* renamed from: f  reason: collision with root package name */
            public final List<String> f32862f;

            public static final class a implements d0<e> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32863a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32864b;

                static {
                    a aVar = new a();
                    f32863a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.RequiredIdDocs", aVar, 6);
                    pluginGeneratedSerialDescriptor.k("docSets", true);
                    pluginGeneratedSerialDescriptor.k("videoIdent", true);
                    pluginGeneratedSerialDescriptor.k("videoIdentUploadTypes", true);
                    pluginGeneratedSerialDescriptor.k("stepsOutsideVideoId", true);
                    pluginGeneratedSerialDescriptor.k("includedCountries", true);
                    pluginGeneratedSerialDescriptor.k("excludedCountries", true);
                    f32864b = pluginGeneratedSerialDescriptor;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c1, code lost:
                    r3 = 5;
                 */
                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.sumsub.sns.internal.core.data.model.remote.response.d.c.e deserialize(kotlinx.serialization.encoding.c r19) {
                    /*
                        r18 = this;
                        kotlinx.serialization.descriptors.f r0 = r18.getDescriptor()
                        r1 = r19
                        kotlinx.serialization.encoding.a r1 = r1.b(r0)
                        boolean r2 = r1.k()
                        r3 = 5
                        r4 = 3
                        r5 = 4
                        r6 = 2
                        r7 = 0
                        r8 = 1
                        r9 = 0
                        if (r2 == 0) goto L_0x0053
                        kotlinx.serialization.internal.e r2 = new kotlinx.serialization.internal.e
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c$a r10 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.C0352c.a.f32874a
                        r2.<init>(r10)
                        java.lang.Object r2 = r1.j(r0, r7, r2, r9)
                        kotlinx.serialization.internal.h r7 = kotlinx.serialization.internal.h.f57720a
                        java.lang.Object r7 = r1.j(r0, r8, r7, r9)
                        kotlinx.serialization.internal.e r8 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.v1 r10 = kotlinx.serialization.internal.v1.f57779a
                        r8.<init>(r10)
                        java.lang.Object r6 = r1.j(r0, r6, r8, r9)
                        kotlinx.serialization.internal.e r8 = new kotlinx.serialization.internal.e
                        r8.<init>(r10)
                        java.lang.Object r4 = r1.j(r0, r4, r8, r9)
                        kotlinx.serialization.internal.e r8 = new kotlinx.serialization.internal.e
                        r8.<init>(r10)
                        java.lang.Object r5 = r1.j(r0, r5, r8, r9)
                        kotlinx.serialization.internal.e r8 = new kotlinx.serialization.internal.e
                        r8.<init>(r10)
                        java.lang.Object r3 = r1.j(r0, r3, r8, r9)
                        r8 = 63
                        r9 = r8
                        goto L_0x00cd
                    L_0x0053:
                        r2 = r7
                        r15 = r8
                        r10 = r9
                        r11 = r10
                        r12 = r11
                        r13 = r12
                        r14 = r13
                    L_0x005a:
                        if (r15 == 0) goto L_0x00c3
                        int r7 = r1.w(r0)
                        switch(r7) {
                            case -1: goto L_0x00be;
                            case 0: goto L_0x00ae;
                            case 1: goto L_0x00a3;
                            case 2: goto L_0x0093;
                            case 3: goto L_0x0085;
                            case 4: goto L_0x0077;
                            case 5: goto L_0x0069;
                            default: goto L_0x0063;
                        }
                    L_0x0063:
                        kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                        r0.<init>((int) r7)
                        throw r0
                    L_0x0069:
                        kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                        r7.<init>(r8)
                        java.lang.Object r14 = r1.j(r0, r3, r7, r14)
                        r2 = r2 | 32
                        goto L_0x00a0
                    L_0x0077:
                        kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                        r7.<init>(r8)
                        java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                        r2 = r2 | 16
                        goto L_0x00a0
                    L_0x0085:
                        kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                        r7.<init>(r8)
                        java.lang.Object r12 = r1.j(r0, r4, r7, r12)
                        r2 = r2 | 8
                        goto L_0x00a0
                    L_0x0093:
                        kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                        kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
                        r7.<init>(r8)
                        java.lang.Object r11 = r1.j(r0, r6, r7, r11)
                        r2 = r2 | 4
                    L_0x00a0:
                        r7 = 0
                        r8 = 1
                        goto L_0x005a
                    L_0x00a3:
                        kotlinx.serialization.internal.h r7 = kotlinx.serialization.internal.h.f57720a
                        r8 = 1
                        java.lang.Object r10 = r1.j(r0, r8, r7, r10)
                        r2 = r2 | 2
                        r7 = 0
                        goto L_0x005a
                    L_0x00ae:
                        kotlinx.serialization.internal.e r7 = new kotlinx.serialization.internal.e
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c$a r3 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.C0352c.a.f32874a
                        r7.<init>(r3)
                        r3 = 0
                        java.lang.Object r9 = r1.j(r0, r3, r7, r9)
                        r2 = r2 | 1
                        r7 = r3
                        goto L_0x00c1
                    L_0x00be:
                        r3 = 0
                        r7 = r3
                        r15 = r7
                    L_0x00c1:
                        r3 = 5
                        goto L_0x005a
                    L_0x00c3:
                        r7 = r10
                        r6 = r11
                        r4 = r12
                        r5 = r13
                        r3 = r14
                        r17 = r9
                        r9 = r2
                        r2 = r17
                    L_0x00cd:
                        r1.c(r0)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$e r0 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$e
                        r10 = r2
                        java.util.List r10 = (java.util.List) r10
                        r11 = r7
                        java.lang.Boolean r11 = (java.lang.Boolean) r11
                        r12 = r6
                        java.util.List r12 = (java.util.List) r12
                        r13 = r4
                        java.util.List r13 = (java.util.List) r13
                        r14 = r5
                        java.util.List r14 = (java.util.List) r14
                        r15 = r3
                        java.util.List r15 = (java.util.List) r15
                        r16 = 0
                        r8 = r0
                        r8.<init>((int) r9, (java.util.List) r10, (java.lang.Boolean) r11, (java.util.List) r12, (java.util.List) r13, (java.util.List) r14, (java.util.List) r15, (kotlinx.serialization.internal.q1) r16)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$e");
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    v1 v1Var = v1.f57779a;
                    return new kotlinx.serialization.b[]{h10.a.u(new kotlinx.serialization.internal.e(C0352c.a.f32874a)), h10.a.u(h.f57720a), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(new kotlinx.serialization.internal.e(v1Var))};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32864b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, e eVar) {
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
                    return a.f32863a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 B2\u00020\u0001:\u0002\b\u000bB\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b<\u0010=B\u0001\b\u0017\u0012\u0006\u0010>\u001a\u00020 \u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\u0010\b\u0001\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b<\u0010AJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\nHÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\nHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nHÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0001\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020 HÖ\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R(\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010*\u0012\u0004\b-\u0010)\u001a\u0004\b+\u0010,R(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010*\u0012\u0004\b/\u0010)\u001a\u0004\b.\u0010,R\"\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010%\u0012\u0004\b1\u0010)\u001a\u0004\b0\u0010'R(\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010*\u0012\u0004\b3\u0010)\u001a\u0004\b2\u0010,R(\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010*\u0012\u0004\b5\u0010)\u001a\u0004\b4\u0010,R\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010%\u0012\u0004\b7\u0010)\u001a\u0004\b6\u0010'R\"\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010%\u0012\u0004\b9\u0010)\u001a\u0004\b8\u0010'R\"\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010%\u0012\u0004\b;\u0010)\u001a\u0004\b:\u0010'¨\u0006C"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$e$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "b", "Lcom/sumsub/sns/internal/core/data/model/IdentitySide;", "c", "d", "Lcom/sumsub/sns/internal/core/data/model/h$d;", "e", "Lcom/sumsub/sns/internal/core/data/model/h$c;", "f", "g", "h", "i", "idDocSetType", "types", "sides", "videoRequired", "fields", "customFields", "questionnaireId", "questionnaireDefId", "captureMode", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "getIdDocSetType$annotations", "()V", "Ljava/util/List;", "x", "()Ljava/util/List;", "getTypes$annotations", "v", "getSides$annotations", "z", "getVideoRequired$annotations", "n", "getFields$annotations", "l", "getCustomFields$annotations", "t", "getQuestionnaireId$annotations", "r", "getQuestionnaireDefId$annotations", "j", "getCaptureMode$annotations", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c  reason: collision with other inner class name */
            public static final class C0352c {
                public static final b Companion = new b((r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32865a;

                /* renamed from: b  reason: collision with root package name */
                public final List<String> f32866b;

                /* renamed from: c  reason: collision with root package name */
                public final List<IdentitySide> f32867c;

                /* renamed from: d  reason: collision with root package name */
                public final String f32868d;

                /* renamed from: e  reason: collision with root package name */
                public final List<h.d> f32869e;

                /* renamed from: f  reason: collision with root package name */
                public final List<h.c> f32870f;

                /* renamed from: g  reason: collision with root package name */
                public final String f32871g;

                /* renamed from: h  reason: collision with root package name */
                public final String f32872h;

                /* renamed from: i  reason: collision with root package name */
                public final String f32873i;

                /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c$a */
                public static final class a implements d0<C0352c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32874a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32875b;

                    static {
                        a aVar = new a();
                        f32874a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.RequiredIdDocs.DocSetsItem", aVar, 9);
                        pluginGeneratedSerialDescriptor.k("idDocSetType", true);
                        pluginGeneratedSerialDescriptor.k("types", true);
                        pluginGeneratedSerialDescriptor.k("subTypes", true);
                        pluginGeneratedSerialDescriptor.k("videoRequired", true);
                        pluginGeneratedSerialDescriptor.k(GraphRequest.FIELDS_PARAM, true);
                        pluginGeneratedSerialDescriptor.k("customFields", true);
                        pluginGeneratedSerialDescriptor.k("questionnaireId", true);
                        pluginGeneratedSerialDescriptor.k("questionnaireDefId", true);
                        pluginGeneratedSerialDescriptor.k("captureMode", true);
                        f32875b = pluginGeneratedSerialDescriptor;
                    }

                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: a */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.C0352c deserialize(kotlinx.serialization.encoding.c r22) {
                        /*
                            r21 = this;
                            kotlinx.serialization.descriptors.f r0 = r21.getDescriptor()
                            r1 = r22
                            kotlinx.serialization.encoding.a r1 = r1.b(r0)
                            boolean r2 = r1.k()
                            r3 = 7
                            r4 = 6
                            r5 = 5
                            r6 = 3
                            r7 = 8
                            r8 = 4
                            r9 = 2
                            r10 = 0
                            r11 = 1
                            r12 = 0
                            if (r2 == 0) goto L_0x0062
                            kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r10 = r1.j(r0, r10, r2, r12)
                            kotlinx.serialization.internal.e r13 = new kotlinx.serialization.internal.e
                            r13.<init>(r2)
                            java.lang.Object r11 = r1.j(r0, r11, r13, r12)
                            kotlinx.serialization.internal.e r13 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.IdentitySide$a r14 = com.sumsub.sns.internal.core.data.model.IdentitySide.a.f32363a
                            r13.<init>(r14)
                            java.lang.Object r9 = r1.j(r0, r9, r13, r12)
                            java.lang.Object r6 = r1.j(r0, r6, r2, r12)
                            kotlinx.serialization.internal.e r13 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.h$d$a r14 = com.sumsub.sns.internal.core.data.model.h.d.a.f32626a
                            r13.<init>(r14)
                            java.lang.Object r8 = r1.j(r0, r8, r13, r12)
                            kotlinx.serialization.internal.e r13 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.h$c$a r14 = com.sumsub.sns.internal.core.data.model.h.c.a.f32617a
                            r13.<init>(r14)
                            java.lang.Object r5 = r1.j(r0, r5, r13, r12)
                            java.lang.Object r4 = r1.j(r0, r4, r2, r12)
                            java.lang.Object r3 = r1.j(r0, r3, r2, r12)
                            java.lang.Object r2 = r1.j(r0, r7, r2, r12)
                            r7 = 511(0x1ff, float:7.16E-43)
                            r12 = r10
                            r10 = r8
                            r8 = r7
                            goto L_0x0101
                        L_0x0062:
                            r2 = r10
                            r19 = r11
                            r6 = r12
                            r8 = r6
                            r9 = r8
                            r10 = r9
                            r11 = r10
                            r13 = r11
                            r14 = r13
                            r15 = r14
                        L_0x006d:
                            if (r19 == 0) goto L_0x00f6
                            int r5 = r1.w(r0)
                            switch(r5) {
                                case -1: goto L_0x00ef;
                                case 0: goto L_0x00e4;
                                case 1: goto L_0x00d4;
                                case 2: goto L_0x00c4;
                                case 3: goto L_0x00b9;
                                case 4: goto L_0x00a9;
                                case 5: goto L_0x0098;
                                case 6: goto L_0x008f;
                                case 7: goto L_0x0086;
                                case 8: goto L_0x007c;
                                default: goto L_0x0076;
                            }
                        L_0x0076:
                            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                            r0.<init>((int) r5)
                            throw r0
                        L_0x007c:
                            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r8 = r1.j(r0, r7, r5, r8)
                            r2 = r2 | 256(0x100, float:3.59E-43)
                            goto L_0x00f3
                        L_0x0086:
                            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r6 = r1.j(r0, r3, r5, r6)
                            r2 = r2 | 128(0x80, float:1.794E-43)
                            goto L_0x00f3
                        L_0x008f:
                            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r9 = r1.j(r0, r4, r5, r9)
                            r2 = r2 | 64
                            goto L_0x00f3
                        L_0x0098:
                            kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.h$c$a r3 = com.sumsub.sns.internal.core.data.model.h.c.a.f32617a
                            r5.<init>(r3)
                            r3 = 5
                            java.lang.Object r11 = r1.j(r0, r3, r5, r11)
                            r2 = r2 | 32
                            r5 = r3
                            r3 = 7
                            goto L_0x006d
                        L_0x00a9:
                            r3 = 5
                            kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.h$d$a r3 = com.sumsub.sns.internal.core.data.model.h.d.a.f32626a
                            r5.<init>(r3)
                            r3 = 4
                            java.lang.Object r10 = r1.j(r0, r3, r5, r10)
                            r2 = r2 | 16
                            goto L_0x00f2
                        L_0x00b9:
                            r3 = 4
                            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                            r3 = 3
                            java.lang.Object r15 = r1.j(r0, r3, r5, r15)
                            r2 = r2 | 8
                            goto L_0x00f2
                        L_0x00c4:
                            r3 = 3
                            kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                            com.sumsub.sns.internal.core.data.model.IdentitySide$a r3 = com.sumsub.sns.internal.core.data.model.IdentitySide.a.f32363a
                            r5.<init>(r3)
                            r3 = 2
                            java.lang.Object r14 = r1.j(r0, r3, r5, r14)
                            r2 = r2 | 4
                            goto L_0x00f2
                        L_0x00d4:
                            r3 = 2
                            kotlinx.serialization.internal.e r5 = new kotlinx.serialization.internal.e
                            kotlinx.serialization.internal.v1 r3 = kotlinx.serialization.internal.v1.f57779a
                            r5.<init>(r3)
                            r3 = 1
                            java.lang.Object r13 = r1.j(r0, r3, r5, r13)
                            r2 = r2 | 2
                            goto L_0x00f2
                        L_0x00e4:
                            r3 = 1
                            kotlinx.serialization.internal.v1 r5 = kotlinx.serialization.internal.v1.f57779a
                            r3 = 0
                            java.lang.Object r12 = r1.j(r0, r3, r5, r12)
                            r2 = r2 | 1
                            goto L_0x00f2
                        L_0x00ef:
                            r3 = 0
                            r19 = r3
                        L_0x00f2:
                            r3 = 7
                        L_0x00f3:
                            r5 = 5
                            goto L_0x006d
                        L_0x00f6:
                            r3 = r6
                            r4 = r9
                            r5 = r11
                            r11 = r13
                            r9 = r14
                            r6 = r15
                            r20 = r8
                            r8 = r2
                            r2 = r20
                        L_0x0101:
                            r1.c(r0)
                            com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c r0 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c
                            r1 = r12
                            java.lang.String r1 = (java.lang.String) r1
                            java.util.List r11 = (java.util.List) r11
                            r12 = r9
                            java.util.List r12 = (java.util.List) r12
                            java.lang.String r6 = (java.lang.String) r6
                            r13 = r10
                            java.util.List r13 = (java.util.List) r13
                            r14 = r5
                            java.util.List r14 = (java.util.List) r14
                            r15 = r4
                            java.lang.String r15 = (java.lang.String) r15
                            r16 = r3
                            java.lang.String r16 = (java.lang.String) r16
                            r17 = r2
                            java.lang.String r17 = (java.lang.String) r17
                            r18 = 0
                            r7 = r0
                            r9 = r1
                            r10 = r11
                            r11 = r12
                            r12 = r6
                            r7.<init>((int) r8, (java.lang.String) r9, (java.util.List) r10, (java.util.List) r11, (java.lang.String) r12, (java.util.List) r13, (java.util.List) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (kotlinx.serialization.internal.q1) r18)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.C0352c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c");
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(new kotlinx.serialization.internal.e(IdentitySide.a.f32363a)), h10.a.u(v1Var), h10.a.u(new kotlinx.serialization.internal.e(h.d.a.f32626a)), h10.a.u(new kotlinx.serialization.internal.e(h.c.a.f32617a)), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32875b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, C0352c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        C0352c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$e$c$b */
                public static final class b {
                    public /* synthetic */ b(r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<C0352c> serializer() {
                        return a.f32874a;
                    }

                    public b() {
                    }
                }

                public C0352c() {
                    this((String) null, (List) null, (List) null, (String) null, (List) null, (List) null, (String) null, (String) null, (String) null, 511, (r) null);
                }

                public static /* synthetic */ void A() {
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

                public static /* synthetic */ void w() {
                }

                public static /* synthetic */ void y() {
                }

                public final String a() {
                    return this.f32865a;
                }

                public final List<String> b() {
                    return this.f32866b;
                }

                public final List<IdentitySide> c() {
                    return this.f32867c;
                }

                public final String d() {
                    return this.f32868d;
                }

                public final List<h.d> e() {
                    return this.f32869e;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0352c)) {
                        return false;
                    }
                    C0352c cVar = (C0352c) obj;
                    return x.b(this.f32865a, cVar.f32865a) && x.b(this.f32866b, cVar.f32866b) && x.b(this.f32867c, cVar.f32867c) && x.b(this.f32868d, cVar.f32868d) && x.b(this.f32869e, cVar.f32869e) && x.b(this.f32870f, cVar.f32870f) && x.b(this.f32871g, cVar.f32871g) && x.b(this.f32872h, cVar.f32872h) && x.b(this.f32873i, cVar.f32873i);
                }

                public final List<h.c> f() {
                    return this.f32870f;
                }

                public final String g() {
                    return this.f32871g;
                }

                public final String h() {
                    return this.f32872h;
                }

                public int hashCode() {
                    String str = this.f32865a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    List<String> list = this.f32866b;
                    int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
                    List<IdentitySide> list2 = this.f32867c;
                    int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
                    String str2 = this.f32868d;
                    int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                    List<h.d> list3 = this.f32869e;
                    int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
                    List<h.c> list4 = this.f32870f;
                    int hashCode6 = (hashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
                    String str3 = this.f32871g;
                    int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    String str4 = this.f32872h;
                    int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
                    String str5 = this.f32873i;
                    if (str5 != null) {
                        i11 = str5.hashCode();
                    }
                    return hashCode8 + i11;
                }

                public final String i() {
                    return this.f32873i;
                }

                public final String j() {
                    return this.f32873i;
                }

                public final List<h.c> l() {
                    return this.f32870f;
                }

                public final List<h.d> n() {
                    return this.f32869e;
                }

                public final String p() {
                    return this.f32865a;
                }

                public final String r() {
                    return this.f32872h;
                }

                public final String t() {
                    return this.f32871g;
                }

                public String toString() {
                    return "DocSetsItem(idDocSetType=" + this.f32865a + ", types=" + this.f32866b + ", sides=" + this.f32867c + ", videoRequired=" + this.f32868d + ", fields=" + this.f32869e + ", customFields=" + this.f32870f + ", questionnaireId=" + this.f32871g + ", questionnaireDefId=" + this.f32872h + ", captureMode=" + this.f32873i + ')';
                }

                public final List<IdentitySide> v() {
                    return this.f32867c;
                }

                public final List<String> x() {
                    return this.f32866b;
                }

                public final String z() {
                    return this.f32868d;
                }

                public /* synthetic */ C0352c(int i11, String str, List list, List list2, String str2, List list3, List list4, String str3, String str4, String str5, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32874a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32865a = null;
                    } else {
                        this.f32865a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32866b = null;
                    } else {
                        this.f32866b = list;
                    }
                    if ((i11 & 4) == 0) {
                        this.f32867c = null;
                    } else {
                        this.f32867c = list2;
                    }
                    if ((i11 & 8) == 0) {
                        this.f32868d = null;
                    } else {
                        this.f32868d = str2;
                    }
                    if ((i11 & 16) == 0) {
                        this.f32869e = null;
                    } else {
                        this.f32869e = list3;
                    }
                    if ((i11 & 32) == 0) {
                        this.f32870f = null;
                    } else {
                        this.f32870f = list4;
                    }
                    if ((i11 & 64) == 0) {
                        this.f32871g = null;
                    } else {
                        this.f32871g = str3;
                    }
                    if ((i11 & 128) == 0) {
                        this.f32872h = null;
                    } else {
                        this.f32872h = str4;
                    }
                    if ((i11 & 256) == 0) {
                        this.f32873i = null;
                    } else {
                        this.f32873i = str5;
                    }
                }

                public final C0352c a(String str, List<String> list, List<? extends IdentitySide> list2, String str2, List<h.d> list3, List<h.c> list4, String str3, String str4, String str5) {
                    return new C0352c(str, list, list2, str2, list3, list4, str3, str4, str5);
                }

                public C0352c(String str, List<String> list, List<? extends IdentitySide> list2, String str2, List<h.d> list3, List<h.c> list4, String str3, String str4, String str5) {
                    this.f32865a = str;
                    this.f32866b = list;
                    this.f32867c = list2;
                    this.f32868d = str2;
                    this.f32869e = list3;
                    this.f32870f = list4;
                    this.f32871g = str3;
                    this.f32872h = str4;
                    this.f32873i = str5;
                }

                public static /* synthetic */ C0352c a(C0352c cVar, String str, List list, List list2, String str2, List list3, List list4, String str3, String str4, String str5, int i11, Object obj) {
                    C0352c cVar2 = cVar;
                    int i12 = i11;
                    return cVar.a((i12 & 1) != 0 ? cVar2.f32865a : str, (i12 & 2) != 0 ? cVar2.f32866b : list, (i12 & 4) != 0 ? cVar2.f32867c : list2, (i12 & 8) != 0 ? cVar2.f32868d : str2, (i12 & 16) != 0 ? cVar2.f32869e : list3, (i12 & 32) != 0 ? cVar2.f32870f : list4, (i12 & 64) != 0 ? cVar2.f32871g : str3, (i12 & 128) != 0 ? cVar2.f32872h : str4, (i12 & 256) != 0 ? cVar2.f32873i : str5);
                }

                public static final void a(C0352c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32865a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32865a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32866b != null) {
                        bVar.y(fVar, 1, new kotlinx.serialization.internal.e(v1.f57779a), cVar.f32866b);
                    }
                    if (bVar.q(fVar, 2) || cVar.f32867c != null) {
                        bVar.y(fVar, 2, new kotlinx.serialization.internal.e(IdentitySide.a.f32363a), cVar.f32867c);
                    }
                    if (bVar.q(fVar, 3) || cVar.f32868d != null) {
                        bVar.y(fVar, 3, v1.f57779a, cVar.f32868d);
                    }
                    if (bVar.q(fVar, 4) || cVar.f32869e != null) {
                        bVar.y(fVar, 4, new kotlinx.serialization.internal.e(h.d.a.f32626a), cVar.f32869e);
                    }
                    if (bVar.q(fVar, 5) || cVar.f32870f != null) {
                        bVar.y(fVar, 5, new kotlinx.serialization.internal.e(h.c.a.f32617a), cVar.f32870f);
                    }
                    if (bVar.q(fVar, 6) || cVar.f32871g != null) {
                        bVar.y(fVar, 6, v1.f57779a, cVar.f32871g);
                    }
                    if (bVar.q(fVar, 7) || cVar.f32872h != null) {
                        bVar.y(fVar, 7, v1.f57779a, cVar.f32872h);
                    }
                    if (bVar.q(fVar, 8) || cVar.f32873i != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 8, v1.f57779a, cVar.f32873i);
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public /* synthetic */ C0352c(java.lang.String r11, java.util.List r12, java.util.List r13, java.lang.String r14, java.util.List r15, java.util.List r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.r r21) {
                    /*
                        r10 = this;
                        r0 = r20
                        r1 = r0 & 1
                        r2 = 0
                        if (r1 == 0) goto L_0x0009
                        r1 = r2
                        goto L_0x000a
                    L_0x0009:
                        r1 = r11
                    L_0x000a:
                        r3 = r0 & 2
                        if (r3 == 0) goto L_0x0010
                        r3 = r2
                        goto L_0x0011
                    L_0x0010:
                        r3 = r12
                    L_0x0011:
                        r4 = r0 & 4
                        if (r4 == 0) goto L_0x0017
                        r4 = r2
                        goto L_0x0018
                    L_0x0017:
                        r4 = r13
                    L_0x0018:
                        r5 = r0 & 8
                        if (r5 == 0) goto L_0x001e
                        r5 = r2
                        goto L_0x001f
                    L_0x001e:
                        r5 = r14
                    L_0x001f:
                        r6 = r0 & 16
                        if (r6 == 0) goto L_0x0025
                        r6 = r2
                        goto L_0x0026
                    L_0x0025:
                        r6 = r15
                    L_0x0026:
                        r7 = r0 & 32
                        if (r7 == 0) goto L_0x002c
                        r7 = r2
                        goto L_0x002e
                    L_0x002c:
                        r7 = r16
                    L_0x002e:
                        r8 = r0 & 64
                        if (r8 == 0) goto L_0x0034
                        r8 = r2
                        goto L_0x0036
                    L_0x0034:
                        r8 = r17
                    L_0x0036:
                        r9 = r0 & 128(0x80, float:1.794E-43)
                        if (r9 == 0) goto L_0x003c
                        r9 = r2
                        goto L_0x003e
                    L_0x003c:
                        r9 = r18
                    L_0x003e:
                        r0 = r0 & 256(0x100, float:3.59E-43)
                        if (r0 == 0) goto L_0x0043
                        goto L_0x0045
                    L_0x0043:
                        r2 = r19
                    L_0x0045:
                        r11 = r10
                        r12 = r1
                        r13 = r3
                        r14 = r4
                        r15 = r5
                        r16 = r6
                        r17 = r7
                        r18 = r8
                        r19 = r9
                        r20 = r2
                        r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.C0352c.<init>(java.lang.String, java.util.List, java.util.List, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
                }
            }

            public e() {
                this((List) null, (Boolean) null, (List) null, (List) null, (List) null, (List) null, 63, (r) null);
            }

            public static /* synthetic */ void h() {
            }

            public static /* synthetic */ void j() {
            }

            public static /* synthetic */ void l() {
            }

            public static /* synthetic */ void n() {
            }

            public static /* synthetic */ void p() {
            }

            public static /* synthetic */ void r() {
            }

            public final List<C0352c> a() {
                return this.f32857a;
            }

            public final Boolean b() {
                return this.f32858b;
            }

            public final List<String> c() {
                return this.f32859c;
            }

            public final List<String> d() {
                return this.f32860d;
            }

            public final List<String> e() {
                return this.f32861e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                return x.b(this.f32857a, eVar.f32857a) && x.b(this.f32858b, eVar.f32858b) && x.b(this.f32859c, eVar.f32859c) && x.b(this.f32860d, eVar.f32860d) && x.b(this.f32861e, eVar.f32861e) && x.b(this.f32862f, eVar.f32862f);
            }

            public final List<String> f() {
                return this.f32862f;
            }

            public final List<C0352c> g() {
                return this.f32857a;
            }

            public int hashCode() {
                List<C0352c> list = this.f32857a;
                int i11 = 0;
                int hashCode = (list == null ? 0 : list.hashCode()) * 31;
                Boolean bool = this.f32858b;
                int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                List<String> list2 = this.f32859c;
                int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
                List<String> list3 = this.f32860d;
                int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
                List<String> list4 = this.f32861e;
                int hashCode5 = (hashCode4 + (list4 == null ? 0 : list4.hashCode())) * 31;
                List<String> list5 = this.f32862f;
                if (list5 != null) {
                    i11 = list5.hashCode();
                }
                return hashCode5 + i11;
            }

            public final List<String> i() {
                return this.f32862f;
            }

            public final List<String> k() {
                return this.f32861e;
            }

            public final List<String> m() {
                return this.f32860d;
            }

            public final Boolean o() {
                return this.f32858b;
            }

            public final List<String> q() {
                return this.f32859c;
            }

            public String toString() {
                return "RequiredIdDocs(docSets=" + this.f32857a + ", videoIdent=" + this.f32858b + ", videoIdentUploadTypes=" + this.f32859c + ", stepsOutsideVideoId=" + this.f32860d + ", includedCountries=" + this.f32861e + ", excludedCountries=" + this.f32862f + ')';
            }

            public /* synthetic */ e(int i11, List list, Boolean bool, List list2, List list3, List list4, List list5, q1 q1Var) {
                if ((i11 & 0) != 0) {
                    h1.a(i11, 0, a.f32863a.getDescriptor());
                }
                if ((i11 & 1) == 0) {
                    this.f32857a = null;
                } else {
                    this.f32857a = list;
                }
                if ((i11 & 2) == 0) {
                    this.f32858b = Boolean.FALSE;
                } else {
                    this.f32858b = bool;
                }
                if ((i11 & 4) == 0) {
                    this.f32859c = null;
                } else {
                    this.f32859c = list2;
                }
                if ((i11 & 8) == 0) {
                    this.f32860d = null;
                } else {
                    this.f32860d = list3;
                }
                if ((i11 & 16) == 0) {
                    this.f32861e = null;
                } else {
                    this.f32861e = list4;
                }
                if ((i11 & 32) == 0) {
                    this.f32862f = null;
                } else {
                    this.f32862f = list5;
                }
            }

            public final e a(List<C0352c> list, Boolean bool, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
                return new e(list, bool, list2, list3, list4, list5);
            }

            public static /* synthetic */ e a(e eVar, List<C0352c> list, Boolean bool, List<String> list2, List<String> list3, List<String> list4, List<String> list5, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    list = eVar.f32857a;
                }
                if ((i11 & 2) != 0) {
                    bool = eVar.f32858b;
                }
                Boolean bool2 = bool;
                if ((i11 & 4) != 0) {
                    list2 = eVar.f32859c;
                }
                List<String> list6 = list2;
                if ((i11 & 8) != 0) {
                    list3 = eVar.f32860d;
                }
                List<String> list7 = list3;
                if ((i11 & 16) != 0) {
                    list4 = eVar.f32861e;
                }
                List<String> list8 = list4;
                if ((i11 & 32) != 0) {
                    list5 = eVar.f32862f;
                }
                return eVar.a(list, bool2, list6, list7, list8, list5);
            }

            public static final void a(e eVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                boolean z11 = false;
                if (bVar.q(fVar, 0) || eVar.f32857a != null) {
                    bVar.y(fVar, 0, new kotlinx.serialization.internal.e(C0352c.a.f32874a), eVar.f32857a);
                }
                if (bVar.q(fVar, 1) || !x.b(eVar.f32858b, Boolean.FALSE)) {
                    bVar.y(fVar, 1, kotlinx.serialization.internal.h.f57720a, eVar.f32858b);
                }
                if (bVar.q(fVar, 2) || eVar.f32859c != null) {
                    bVar.y(fVar, 2, new kotlinx.serialization.internal.e(v1.f57779a), eVar.f32859c);
                }
                if (bVar.q(fVar, 3) || eVar.f32860d != null) {
                    bVar.y(fVar, 3, new kotlinx.serialization.internal.e(v1.f57779a), eVar.f32860d);
                }
                if (bVar.q(fVar, 4) || eVar.f32861e != null) {
                    bVar.y(fVar, 4, new kotlinx.serialization.internal.e(v1.f57779a), eVar.f32861e);
                }
                if (bVar.q(fVar, 5) || eVar.f32862f != null) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar, 5, new kotlinx.serialization.internal.e(v1.f57779a), eVar.f32862f);
                }
            }

            public e(List<C0352c> list, Boolean bool, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
                this.f32857a = list;
                this.f32858b = bool;
                this.f32859c = list2;
                this.f32860d = list3;
                this.f32861e = list4;
                this.f32862f = list5;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ e(java.util.List r6, java.lang.Boolean r7, java.util.List r8, java.util.List r9, java.util.List r10, java.util.List r11, int r12, kotlin.jvm.internal.r r13) {
                /*
                    r5 = this;
                    r13 = r12 & 1
                    r0 = 0
                    if (r13 == 0) goto L_0x0007
                    r13 = r0
                    goto L_0x0008
                L_0x0007:
                    r13 = r6
                L_0x0008:
                    r6 = r12 & 2
                    if (r6 == 0) goto L_0x000e
                    java.lang.Boolean r7 = java.lang.Boolean.FALSE
                L_0x000e:
                    r1 = r7
                    r6 = r12 & 4
                    if (r6 == 0) goto L_0x0015
                    r2 = r0
                    goto L_0x0016
                L_0x0015:
                    r2 = r8
                L_0x0016:
                    r6 = r12 & 8
                    if (r6 == 0) goto L_0x001c
                    r3 = r0
                    goto L_0x001d
                L_0x001c:
                    r3 = r9
                L_0x001d:
                    r6 = r12 & 16
                    if (r6 == 0) goto L_0x0023
                    r4 = r0
                    goto L_0x0024
                L_0x0023:
                    r4 = r10
                L_0x0024:
                    r6 = r12 & 32
                    if (r6 == 0) goto L_0x002a
                    r12 = r0
                    goto L_0x002b
                L_0x002a:
                    r12 = r11
                L_0x002b:
                    r6 = r5
                    r7 = r13
                    r8 = r1
                    r9 = r2
                    r10 = r3
                    r11 = r4
                    r6.<init>(r7, r8, r9, r10, r11, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.e.<init>(java.util.List, java.lang.Boolean, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.r):void");
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 R2\u00020\u0001:\u0003\b\u0019\u001bB\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bL\u0010MB\u0001\b\u0017\u0012\u0006\u0010N\u001a\u00020\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bL\u0010QJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0001\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b\b\u0010'J\t\u0010(\u001a\u00020\u000eHÖ\u0001J\t\u0010)\u001a\u00020\tHÖ\u0001J\u0013\u0010+\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010,\u0012\u0004\b.\u0010/\u001a\u0004\b-\u0010\nR\"\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u00100\u0012\u0004\b3\u0010/\u001a\u0004\b1\u00102R\"\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010,\u0012\u0004\b5\u0010/\u001a\u0004\b4\u0010\nR\"\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u00106\u0012\u0004\b9\u0010/\u001a\u0004\b7\u00108R\"\u0010 \u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010:\u0012\u0004\b=\u0010/\u001a\u0004\b;\u0010<R\"\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u00106\u0012\u0004\b?\u0010/\u001a\u0004\b>\u00108R\"\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010@\u0012\u0004\bB\u0010/\u001a\u0004\bA\u0010\u0015R\"\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u00106\u0012\u0004\bD\u0010/\u001a\u0004\bC\u00108R\"\u0010$\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010@\u0012\u0004\bF\u0010/\u001a\u0004\bE\u0010\u0015R\"\u0010%\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010G\u0012\u0004\bI\u0010/\u001a\u0004\bH\u0010\u001aR\"\u0010&\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010G\u0012\u0004\bK\u0010/\u001a\u0004\bJ\u0010\u001a¨\u0006S"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Integer;", "Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;", "d", "e", "", "f", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;", "g", "h", "", "i", "()Ljava/lang/Boolean;", "j", "k", "", "b", "()Ljava/lang/Long;", "c", "notificationFailureCnt", "reviewStatus", "priority", "createDate", "result", "reviewId", "reprocessing", "levelName", "autoChecked", "elapsedSinceQueuedMs", "elapsedSincePendingMs", "(Ljava/lang/Integer;Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;)Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f;", "toString", "hashCode", "other", "equals", "Ljava/lang/Integer;", "v", "getNotificationFailureCnt$annotations", "()V", "Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;", "F", "()Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;", "getReviewStatus$annotations", "x", "getPriority$annotations", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "getCreateDate$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;", "B", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;", "getResult$annotations", "D", "getReviewId$annotations", "Ljava/lang/Boolean;", "z", "getReprocessing$annotations", "t", "getLevelName$annotations", "l", "getAutoChecked$annotations", "Ljava/lang/Long;", "r", "getElapsedSinceQueuedMs$annotations", "p", "getElapsedSincePendingMs$annotations", "<init>", "(Ljava/lang/Integer;Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Integer;Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class f {
            public static final b Companion = new b((r) null);

            /* renamed from: a  reason: collision with root package name */
            public final Integer f32876a;

            /* renamed from: b  reason: collision with root package name */
            public final ReviewStatusType f32877b;

            /* renamed from: c  reason: collision with root package name */
            public final Integer f32878c;

            /* renamed from: d  reason: collision with root package name */
            public final String f32879d;

            /* renamed from: e  reason: collision with root package name */
            public final C0353c f32880e;

            /* renamed from: f  reason: collision with root package name */
            public final String f32881f;

            /* renamed from: g  reason: collision with root package name */
            public final Boolean f32882g;

            /* renamed from: h  reason: collision with root package name */
            public final String f32883h;

            /* renamed from: i  reason: collision with root package name */
            public final Boolean f32884i;

            /* renamed from: j  reason: collision with root package name */
            public final Long f32885j;

            /* renamed from: k  reason: collision with root package name */
            public final Long f32886k;

            public static final class a implements d0<f> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32887a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32888b;

                static {
                    a aVar = new a();
                    f32887a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.Review", aVar, 11);
                    pluginGeneratedSerialDescriptor.k("notificationFailureCnt", true);
                    pluginGeneratedSerialDescriptor.k("reviewStatus", true);
                    pluginGeneratedSerialDescriptor.k("priority", true);
                    pluginGeneratedSerialDescriptor.k("createDate", true);
                    pluginGeneratedSerialDescriptor.k("reviewResult", true);
                    pluginGeneratedSerialDescriptor.k("reviewId", true);
                    pluginGeneratedSerialDescriptor.k("reprocessing", true);
                    pluginGeneratedSerialDescriptor.k("levelName", true);
                    pluginGeneratedSerialDescriptor.k("autoChecked", true);
                    pluginGeneratedSerialDescriptor.k("elapsedSinceQueuedMs", true);
                    pluginGeneratedSerialDescriptor.k("elapsedSincePendingMs", true);
                    f32888b = pluginGeneratedSerialDescriptor;
                }

                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.sumsub.sns.internal.core.data.model.remote.response.d.c.f deserialize(kotlinx.serialization.encoding.c r27) {
                    /*
                        r26 = this;
                        kotlinx.serialization.descriptors.f r0 = r26.getDescriptor()
                        r1 = r27
                        kotlinx.serialization.encoding.a r1 = r1.b(r0)
                        boolean r2 = r1.k()
                        r3 = 10
                        r4 = 9
                        r5 = 7
                        r6 = 6
                        r7 = 5
                        r8 = 3
                        r9 = 8
                        r10 = 4
                        r11 = 2
                        r12 = 0
                        r13 = 1
                        r14 = 0
                        if (r2 == 0) goto L_0x005d
                        kotlinx.serialization.internal.m0 r2 = kotlinx.serialization.internal.m0.f57742a
                        java.lang.Object r12 = r1.j(r0, r12, r2, r14)
                        com.sumsub.sns.internal.core.data.model.ReviewStatusType$a r15 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.a.f32373a
                        java.lang.Object r13 = r1.j(r0, r13, r15, r14)
                        java.lang.Object r2 = r1.j(r0, r11, r2, r14)
                        kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r8 = r1.j(r0, r8, r11, r14)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c$a r15 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c.a.f32894a
                        java.lang.Object r10 = r1.j(r0, r10, r15, r14)
                        java.lang.Object r7 = r1.j(r0, r7, r11, r14)
                        kotlinx.serialization.internal.h r15 = kotlinx.serialization.internal.h.f57720a
                        java.lang.Object r6 = r1.j(r0, r6, r15, r14)
                        java.lang.Object r5 = r1.j(r0, r5, r11, r14)
                        java.lang.Object r9 = r1.j(r0, r9, r15, r14)
                        kotlinx.serialization.internal.x0 r11 = kotlinx.serialization.internal.x0.f57786a
                        java.lang.Object r4 = r1.j(r0, r4, r11, r14)
                        java.lang.Object r3 = r1.j(r0, r3, r11, r14)
                        r11 = 2047(0x7ff, float:2.868E-42)
                        r14 = r12
                        r12 = r11
                        goto L_0x010e
                    L_0x005d:
                        r2 = r12
                        r24 = r13
                        r5 = r14
                        r6 = r5
                        r7 = r6
                        r8 = r7
                        r9 = r8
                        r10 = r9
                        r11 = r10
                        r12 = r11
                        r13 = r12
                        r15 = r13
                    L_0x006a:
                        if (r24 == 0) goto L_0x0100
                        int r4 = r1.w(r0)
                        switch(r4) {
                            case -1: goto L_0x00f7;
                            case 0: goto L_0x00ec;
                            case 1: goto L_0x00e1;
                            case 2: goto L_0x00d6;
                            case 3: goto L_0x00cb;
                            case 4: goto L_0x00c0;
                            case 5: goto L_0x00b5;
                            case 6: goto L_0x00aa;
                            case 7: goto L_0x009e;
                            case 8: goto L_0x0091;
                            case 9: goto L_0x0083;
                            case 10: goto L_0x0079;
                            default: goto L_0x0073;
                        }
                    L_0x0073:
                        kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                        r0.<init>((int) r4)
                        throw r0
                    L_0x0079:
                        kotlinx.serialization.internal.x0 r4 = kotlinx.serialization.internal.x0.f57786a
                        java.lang.Object r9 = r1.j(r0, r3, r4, r9)
                        r2 = r2 | 1024(0x400, float:1.435E-42)
                        goto L_0x00fc
                    L_0x0083:
                        kotlinx.serialization.internal.x0 r4 = kotlinx.serialization.internal.x0.f57786a
                        r3 = 9
                        java.lang.Object r5 = r1.j(r0, r3, r4, r5)
                        r2 = r2 | 512(0x200, float:7.175E-43)
                        r4 = r3
                        r3 = 10
                        goto L_0x006a
                    L_0x0091:
                        r3 = 9
                        kotlinx.serialization.internal.h r4 = kotlinx.serialization.internal.h.f57720a
                        r3 = 8
                        java.lang.Object r6 = r1.j(r0, r3, r4, r6)
                        r2 = r2 | 256(0x100, float:3.59E-43)
                        goto L_0x00fa
                    L_0x009e:
                        r3 = 8
                        kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                        r3 = 7
                        java.lang.Object r7 = r1.j(r0, r3, r4, r7)
                        r2 = r2 | 128(0x80, float:1.794E-43)
                        goto L_0x00fa
                    L_0x00aa:
                        r3 = 7
                        kotlinx.serialization.internal.h r4 = kotlinx.serialization.internal.h.f57720a
                        r3 = 6
                        java.lang.Object r10 = r1.j(r0, r3, r4, r10)
                        r2 = r2 | 64
                        goto L_0x00fa
                    L_0x00b5:
                        r3 = 6
                        kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                        r3 = 5
                        java.lang.Object r8 = r1.j(r0, r3, r4, r8)
                        r2 = r2 | 32
                        goto L_0x00fa
                    L_0x00c0:
                        r3 = 5
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c$a r4 = com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c.a.f32894a
                        r3 = 4
                        java.lang.Object r11 = r1.j(r0, r3, r4, r11)
                        r2 = r2 | 16
                        goto L_0x00fa
                    L_0x00cb:
                        r3 = 4
                        kotlinx.serialization.internal.v1 r4 = kotlinx.serialization.internal.v1.f57779a
                        r3 = 3
                        java.lang.Object r13 = r1.j(r0, r3, r4, r13)
                        r2 = r2 | 8
                        goto L_0x00fa
                    L_0x00d6:
                        r3 = 3
                        kotlinx.serialization.internal.m0 r4 = kotlinx.serialization.internal.m0.f57742a
                        r3 = 2
                        java.lang.Object r12 = r1.j(r0, r3, r4, r12)
                        r2 = r2 | 4
                        goto L_0x00fa
                    L_0x00e1:
                        r3 = 2
                        com.sumsub.sns.internal.core.data.model.ReviewStatusType$a r4 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.a.f32373a
                        r3 = 1
                        java.lang.Object r15 = r1.j(r0, r3, r4, r15)
                        r2 = r2 | 2
                        goto L_0x00fa
                    L_0x00ec:
                        r3 = 1
                        kotlinx.serialization.internal.m0 r4 = kotlinx.serialization.internal.m0.f57742a
                        r3 = 0
                        java.lang.Object r14 = r1.j(r0, r3, r4, r14)
                        r2 = r2 | 1
                        goto L_0x00fa
                    L_0x00f7:
                        r3 = 0
                        r24 = r3
                    L_0x00fa:
                        r3 = 10
                    L_0x00fc:
                        r4 = 9
                        goto L_0x006a
                    L_0x0100:
                        r4 = r5
                        r5 = r7
                        r7 = r8
                        r3 = r9
                        r8 = r13
                        r13 = r15
                        r9 = r6
                        r6 = r10
                        r10 = r11
                        r25 = r12
                        r12 = r2
                        r2 = r25
                    L_0x010e:
                        r1.c(r0)
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f r0 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$f
                        r1 = r14
                        java.lang.Integer r1 = (java.lang.Integer) r1
                        r14 = r13
                        com.sumsub.sns.internal.core.data.model.ReviewStatusType r14 = (com.sumsub.sns.internal.core.data.model.ReviewStatusType) r14
                        r15 = r2
                        java.lang.Integer r15 = (java.lang.Integer) r15
                        r16 = r8
                        java.lang.String r16 = (java.lang.String) r16
                        r17 = r10
                        com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c r17 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c) r17
                        r18 = r7
                        java.lang.String r18 = (java.lang.String) r18
                        r19 = r6
                        java.lang.Boolean r19 = (java.lang.Boolean) r19
                        r20 = r5
                        java.lang.String r20 = (java.lang.String) r20
                        r21 = r9
                        java.lang.Boolean r21 = (java.lang.Boolean) r21
                        r22 = r4
                        java.lang.Long r22 = (java.lang.Long) r22
                        r23 = r3
                        java.lang.Long r23 = (java.lang.Long) r23
                        r24 = 0
                        r11 = r0
                        r13 = r1
                        r11.<init>((int) r12, (java.lang.Integer) r13, (com.sumsub.sns.internal.core.data.model.ReviewStatusType) r14, (java.lang.Integer) r15, (java.lang.String) r16, (com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c) r17, (java.lang.String) r18, (java.lang.Boolean) r19, (java.lang.String) r20, (java.lang.Boolean) r21, (java.lang.Long) r22, (java.lang.Long) r23, (kotlinx.serialization.internal.q1) r24)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$f");
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    m0 m0Var = m0.f57742a;
                    v1 v1Var = v1.f57779a;
                    kotlinx.serialization.internal.h hVar = kotlinx.serialization.internal.h.f57720a;
                    x0 x0Var = x0.f57786a;
                    return new kotlinx.serialization.b[]{h10.a.u(m0Var), h10.a.u(ReviewStatusType.a.f32373a), h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(C0353c.a.f32894a), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(v1Var), h10.a.u(hVar), h10.a.u(x0Var), h10.a.u(x0Var)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32888b;
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
                    return a.f32887a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 52\u00020\u0001:\u0002\b\nBI\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b/\u00100B]\b\u0017\u0012\u0006\u00101\u001a\u00020\u0017\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b/\u00104J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003JK\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u0012\u0004\b\"\u0010 \u001a\u0004\b!\u0010\u001eR\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010#\u0012\u0004\b&\u0010 \u001a\u0004\b$\u0010%R(\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010'\u0012\u0004\b*\u0010 \u001a\u0004\b(\u0010)R\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010+\u0012\u0004\b.\u0010 \u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/d$c$f$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "c", "", "d", "Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;", "e", "moderationComment", "clientComment", "reviewAnswer", "rejectLabels", "reviewRejectType", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "getModerationComment$annotations", "()V", "f", "getClientComment$annotations", "Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "l", "()Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "getReviewAnswer$annotations", "Ljava/util/List;", "j", "()Ljava/util/List;", "getRejectLabels$annotations", "Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;", "n", "()Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;", "getReviewRejectType$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c  reason: collision with other inner class name */
            public static final class C0353c {
                public static final b Companion = new b((r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32889a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32890b;

                /* renamed from: c  reason: collision with root package name */
                public final ReviewAnswerType f32891c;

                /* renamed from: d  reason: collision with root package name */
                public final List<String> f32892d;

                /* renamed from: e  reason: collision with root package name */
                public final ReviewRejectType f32893e;

                /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c$a */
                public static final class a implements d0<C0353c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32894a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32895b;

                    static {
                        a aVar = new a();
                        f32894a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ListApplicantsResponse.Data.Review.Result", aVar, 5);
                        pluginGeneratedSerialDescriptor.k("moderationComment", true);
                        pluginGeneratedSerialDescriptor.k("clientComment", true);
                        pluginGeneratedSerialDescriptor.k("reviewAnswer", true);
                        pluginGeneratedSerialDescriptor.k("rejectLabels", true);
                        pluginGeneratedSerialDescriptor.k("reviewRejectType", true);
                        f32895b = pluginGeneratedSerialDescriptor;
                    }

                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: a */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c deserialize(kotlinx.serialization.encoding.c r17) {
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
                            if (r2 == 0) goto L_0x003b
                            kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r6 = r1.j(r0, r6, r2, r7)
                            java.lang.Object r8 = r1.j(r0, r8, r2, r7)
                            com.sumsub.sns.internal.core.data.model.ReviewAnswerType$a r9 = com.sumsub.sns.internal.core.data.model.ReviewAnswerType.a.f32369a
                            java.lang.Object r5 = r1.j(r0, r5, r9, r7)
                            kotlinx.serialization.internal.e r9 = new kotlinx.serialization.internal.e
                            r9.<init>(r2)
                            java.lang.Object r2 = r1.j(r0, r3, r9, r7)
                            com.sumsub.sns.internal.core.data.model.ReviewRejectType$a r3 = com.sumsub.sns.internal.core.data.model.ReviewRejectType.a.f32371a
                            java.lang.Object r3 = r1.j(r0, r4, r3, r7)
                            r4 = 31
                            r10 = r5
                            r5 = r4
                            goto L_0x0093
                        L_0x003b:
                            r2 = r6
                            r9 = r7
                            r10 = r9
                            r11 = r10
                            r12 = r11
                            r13 = r8
                        L_0x0041:
                            if (r13 == 0) goto L_0x008e
                            int r14 = r1.w(r0)
                            r15 = -1
                            if (r14 == r15) goto L_0x008c
                            if (r14 == 0) goto L_0x0083
                            if (r14 == r8) goto L_0x007a
                            if (r14 == r5) goto L_0x0071
                            if (r14 == r3) goto L_0x0063
                            if (r14 != r4) goto L_0x005d
                            com.sumsub.sns.internal.core.data.model.ReviewRejectType$a r14 = com.sumsub.sns.internal.core.data.model.ReviewRejectType.a.f32371a
                            java.lang.Object r12 = r1.j(r0, r4, r14, r12)
                            r2 = r2 | 16
                            goto L_0x0041
                        L_0x005d:
                            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                            r0.<init>((int) r14)
                            throw r0
                        L_0x0063:
                            kotlinx.serialization.internal.e r14 = new kotlinx.serialization.internal.e
                            kotlinx.serialization.internal.v1 r15 = kotlinx.serialization.internal.v1.f57779a
                            r14.<init>(r15)
                            java.lang.Object r11 = r1.j(r0, r3, r14, r11)
                            r2 = r2 | 8
                            goto L_0x0041
                        L_0x0071:
                            com.sumsub.sns.internal.core.data.model.ReviewAnswerType$a r14 = com.sumsub.sns.internal.core.data.model.ReviewAnswerType.a.f32369a
                            java.lang.Object r10 = r1.j(r0, r5, r14, r10)
                            r2 = r2 | 4
                            goto L_0x0041
                        L_0x007a:
                            kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r9 = r1.j(r0, r8, r14, r9)
                            r2 = r2 | 2
                            goto L_0x0041
                        L_0x0083:
                            kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r7 = r1.j(r0, r6, r14, r7)
                            r2 = r2 | 1
                            goto L_0x0041
                        L_0x008c:
                            r13 = r6
                            goto L_0x0041
                        L_0x008e:
                            r5 = r2
                            r6 = r7
                            r8 = r9
                            r2 = r11
                            r3 = r12
                        L_0x0093:
                            r1.c(r0)
                            com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c r0 = new com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c
                            java.lang.String r6 = (java.lang.String) r6
                            r7 = r8
                            java.lang.String r7 = (java.lang.String) r7
                            r8 = r10
                            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r8 = (com.sumsub.sns.internal.core.data.model.ReviewAnswerType) r8
                            r9 = r2
                            java.util.List r9 = (java.util.List) r9
                            r10 = r3
                            com.sumsub.sns.internal.core.data.model.ReviewRejectType r10 = (com.sumsub.sns.internal.core.data.model.ReviewRejectType) r10
                            r11 = 0
                            r4 = r0
                            r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (com.sumsub.sns.internal.core.data.model.ReviewAnswerType) r8, (java.util.List) r9, (com.sumsub.sns.internal.core.data.model.ReviewRejectType) r10, (kotlinx.serialization.internal.q1) r11)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c");
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(ReviewAnswerType.a.f32369a), h10.a.u(new kotlinx.serialization.internal.e(v1Var)), h10.a.u(ReviewRejectType.a.f32371a)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32895b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, C0353c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        C0353c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c$b */
                public static final class b {
                    public /* synthetic */ b(r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<C0353c> serializer() {
                        return a.f32894a;
                    }

                    public b() {
                    }
                }

                public C0353c() {
                    this((String) null, (String) null, (ReviewAnswerType) null, (List) null, (ReviewRejectType) null, 31, (r) null);
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

                public final String a() {
                    return this.f32889a;
                }

                public final String b() {
                    return this.f32890b;
                }

                public final ReviewAnswerType c() {
                    return this.f32891c;
                }

                public final List<String> d() {
                    return this.f32892d;
                }

                public final ReviewRejectType e() {
                    return this.f32893e;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0353c)) {
                        return false;
                    }
                    C0353c cVar = (C0353c) obj;
                    return x.b(this.f32889a, cVar.f32889a) && x.b(this.f32890b, cVar.f32890b) && this.f32891c == cVar.f32891c && x.b(this.f32892d, cVar.f32892d) && this.f32893e == cVar.f32893e;
                }

                public final String f() {
                    return this.f32890b;
                }

                public final String h() {
                    return this.f32889a;
                }

                public int hashCode() {
                    String str = this.f32889a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32890b;
                    int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    ReviewAnswerType reviewAnswerType = this.f32891c;
                    int hashCode3 = (hashCode2 + (reviewAnswerType == null ? 0 : reviewAnswerType.hashCode())) * 31;
                    List<String> list = this.f32892d;
                    int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
                    ReviewRejectType reviewRejectType = this.f32893e;
                    if (reviewRejectType != null) {
                        i11 = reviewRejectType.hashCode();
                    }
                    return hashCode4 + i11;
                }

                public final List<String> j() {
                    return this.f32892d;
                }

                public final ReviewAnswerType l() {
                    return this.f32891c;
                }

                public final ReviewRejectType n() {
                    return this.f32893e;
                }

                public String toString() {
                    return "Result(moderationComment=" + this.f32889a + ", clientComment=" + this.f32890b + ", reviewAnswer=" + this.f32891c + ", rejectLabels=" + this.f32892d + ", reviewRejectType=" + this.f32893e + ')';
                }

                public /* synthetic */ C0353c(int i11, String str, String str2, ReviewAnswerType reviewAnswerType, List list, ReviewRejectType reviewRejectType, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32894a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32889a = null;
                    } else {
                        this.f32889a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32890b = null;
                    } else {
                        this.f32890b = str2;
                    }
                    if ((i11 & 4) == 0) {
                        this.f32891c = null;
                    } else {
                        this.f32891c = reviewAnswerType;
                    }
                    if ((i11 & 8) == 0) {
                        this.f32892d = null;
                    } else {
                        this.f32892d = list;
                    }
                    if ((i11 & 16) == 0) {
                        this.f32893e = null;
                    } else {
                        this.f32893e = reviewRejectType;
                    }
                }

                public final C0353c a(String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType) {
                    return new C0353c(str, str2, reviewAnswerType, list, reviewRejectType);
                }

                public C0353c(String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType) {
                    this.f32889a = str;
                    this.f32890b = str2;
                    this.f32891c = reviewAnswerType;
                    this.f32892d = list;
                    this.f32893e = reviewRejectType;
                }

                public static /* synthetic */ C0353c a(C0353c cVar, String str, String str2, ReviewAnswerType reviewAnswerType, List<String> list, ReviewRejectType reviewRejectType, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32889a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32890b;
                    }
                    String str3 = str2;
                    if ((i11 & 4) != 0) {
                        reviewAnswerType = cVar.f32891c;
                    }
                    ReviewAnswerType reviewAnswerType2 = reviewAnswerType;
                    if ((i11 & 8) != 0) {
                        list = cVar.f32892d;
                    }
                    List<String> list2 = list;
                    if ((i11 & 16) != 0) {
                        reviewRejectType = cVar.f32893e;
                    }
                    return cVar.a(str, str3, reviewAnswerType2, list2, reviewRejectType);
                }

                public static final void a(C0353c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32889a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32889a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32890b != null) {
                        bVar.y(fVar, 1, v1.f57779a, cVar.f32890b);
                    }
                    if (bVar.q(fVar, 2) || cVar.f32891c != null) {
                        bVar.y(fVar, 2, ReviewAnswerType.a.f32369a, cVar.f32891c);
                    }
                    if (bVar.q(fVar, 3) || cVar.f32892d != null) {
                        bVar.y(fVar, 3, new kotlinx.serialization.internal.e(v1.f57779a), cVar.f32892d);
                    }
                    if (bVar.q(fVar, 4) || cVar.f32893e != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 4, ReviewRejectType.a.f32371a, cVar.f32893e);
                    }
                }

                /* JADX WARNING: Illegal instructions before constructor call */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public /* synthetic */ C0353c(java.lang.String r5, java.lang.String r6, com.sumsub.sns.internal.core.data.model.ReviewAnswerType r7, java.util.List r8, com.sumsub.sns.internal.core.data.model.ReviewRejectType r9, int r10, kotlin.jvm.internal.r r11) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c.<init>(java.lang.String, java.lang.String, com.sumsub.sns.internal.core.data.model.ReviewAnswerType, java.util.List, com.sumsub.sns.internal.core.data.model.ReviewRejectType, int, kotlin.jvm.internal.r):void");
                }
            }

            public f() {
                this((Integer) null, (ReviewStatusType) null, (Integer) null, (String) null, (C0353c) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (Long) null, (Long) null, 2047, (r) null);
            }

            public static /* synthetic */ void A() {
            }

            public static /* synthetic */ void C() {
            }

            public static /* synthetic */ void E() {
            }

            public static /* synthetic */ void G() {
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

            public static /* synthetic */ void w() {
            }

            public static /* synthetic */ void y() {
            }

            public final C0353c B() {
                return this.f32880e;
            }

            public final String D() {
                return this.f32881f;
            }

            public final ReviewStatusType F() {
                return this.f32877b;
            }

            public final Integer a() {
                return this.f32876a;
            }

            public final Long b() {
                return this.f32885j;
            }

            public final Long c() {
                return this.f32886k;
            }

            public final ReviewStatusType d() {
                return this.f32877b;
            }

            public final Integer e() {
                return this.f32878c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                return x.b(this.f32876a, fVar.f32876a) && this.f32877b == fVar.f32877b && x.b(this.f32878c, fVar.f32878c) && x.b(this.f32879d, fVar.f32879d) && x.b(this.f32880e, fVar.f32880e) && x.b(this.f32881f, fVar.f32881f) && x.b(this.f32882g, fVar.f32882g) && x.b(this.f32883h, fVar.f32883h) && x.b(this.f32884i, fVar.f32884i) && x.b(this.f32885j, fVar.f32885j) && x.b(this.f32886k, fVar.f32886k);
            }

            public final String f() {
                return this.f32879d;
            }

            public final C0353c g() {
                return this.f32880e;
            }

            public final String h() {
                return this.f32881f;
            }

            public int hashCode() {
                Integer num = this.f32876a;
                int i11 = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                ReviewStatusType reviewStatusType = this.f32877b;
                int hashCode2 = (hashCode + (reviewStatusType == null ? 0 : reviewStatusType.hashCode())) * 31;
                Integer num2 = this.f32878c;
                int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
                String str = this.f32879d;
                int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                C0353c cVar = this.f32880e;
                int hashCode5 = (hashCode4 + (cVar == null ? 0 : cVar.hashCode())) * 31;
                String str2 = this.f32881f;
                int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Boolean bool = this.f32882g;
                int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
                String str3 = this.f32883h;
                int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
                Boolean bool2 = this.f32884i;
                int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                Long l11 = this.f32885j;
                int hashCode10 = (hashCode9 + (l11 == null ? 0 : l11.hashCode())) * 31;
                Long l12 = this.f32886k;
                if (l12 != null) {
                    i11 = l12.hashCode();
                }
                return hashCode10 + i11;
            }

            public final Boolean i() {
                return this.f32882g;
            }

            public final String j() {
                return this.f32883h;
            }

            public final Boolean k() {
                return this.f32884i;
            }

            public final Boolean l() {
                return this.f32884i;
            }

            public final String n() {
                return this.f32879d;
            }

            public final Long p() {
                return this.f32886k;
            }

            public final Long r() {
                return this.f32885j;
            }

            public final String t() {
                return this.f32883h;
            }

            public String toString() {
                return "Review(notificationFailureCnt=" + this.f32876a + ", reviewStatus=" + this.f32877b + ", priority=" + this.f32878c + ", createDate=" + this.f32879d + ", result=" + this.f32880e + ", reviewId=" + this.f32881f + ", reprocessing=" + this.f32882g + ", levelName=" + this.f32883h + ", autoChecked=" + this.f32884i + ", elapsedSinceQueuedMs=" + this.f32885j + ", elapsedSincePendingMs=" + this.f32886k + ')';
            }

            public final Integer v() {
                return this.f32876a;
            }

            public final Integer x() {
                return this.f32878c;
            }

            public final Boolean z() {
                return this.f32882g;
            }

            public /* synthetic */ f(int i11, Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, C0353c cVar, String str2, Boolean bool, String str3, Boolean bool2, Long l11, Long l12, q1 q1Var) {
                if ((i11 & 0) != 0) {
                    h1.a(i11, 0, a.f32887a.getDescriptor());
                }
                if ((i11 & 1) == 0) {
                    this.f32876a = null;
                } else {
                    this.f32876a = num;
                }
                if ((i11 & 2) == 0) {
                    this.f32877b = null;
                } else {
                    this.f32877b = reviewStatusType;
                }
                if ((i11 & 4) == 0) {
                    this.f32878c = null;
                } else {
                    this.f32878c = num2;
                }
                if ((i11 & 8) == 0) {
                    this.f32879d = null;
                } else {
                    this.f32879d = str;
                }
                if ((i11 & 16) == 0) {
                    this.f32880e = null;
                } else {
                    this.f32880e = cVar;
                }
                if ((i11 & 32) == 0) {
                    this.f32881f = null;
                } else {
                    this.f32881f = str2;
                }
                if ((i11 & 64) == 0) {
                    this.f32882g = null;
                } else {
                    this.f32882g = bool;
                }
                if ((i11 & 128) == 0) {
                    this.f32883h = null;
                } else {
                    this.f32883h = str3;
                }
                if ((i11 & 256) == 0) {
                    this.f32884i = null;
                } else {
                    this.f32884i = bool2;
                }
                if ((i11 & 512) == 0) {
                    this.f32885j = null;
                } else {
                    this.f32885j = l11;
                }
                if ((i11 & 1024) == 0) {
                    this.f32886k = null;
                } else {
                    this.f32886k = l12;
                }
            }

            public final f a(Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, C0353c cVar, String str2, Boolean bool, String str3, Boolean bool2, Long l11, Long l12) {
                return new f(num, reviewStatusType, num2, str, cVar, str2, bool, str3, bool2, l11, l12);
            }

            public f(Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, C0353c cVar, String str2, Boolean bool, String str3, Boolean bool2, Long l11, Long l12) {
                this.f32876a = num;
                this.f32877b = reviewStatusType;
                this.f32878c = num2;
                this.f32879d = str;
                this.f32880e = cVar;
                this.f32881f = str2;
                this.f32882g = bool;
                this.f32883h = str3;
                this.f32884i = bool2;
                this.f32885j = l11;
                this.f32886k = l12;
            }

            public static /* synthetic */ f a(f fVar, Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, C0353c cVar, String str2, Boolean bool, String str3, Boolean bool2, Long l11, Long l12, int i11, Object obj) {
                f fVar2 = fVar;
                int i12 = i11;
                return fVar.a((i12 & 1) != 0 ? fVar2.f32876a : num, (i12 & 2) != 0 ? fVar2.f32877b : reviewStatusType, (i12 & 4) != 0 ? fVar2.f32878c : num2, (i12 & 8) != 0 ? fVar2.f32879d : str, (i12 & 16) != 0 ? fVar2.f32880e : cVar, (i12 & 32) != 0 ? fVar2.f32881f : str2, (i12 & 64) != 0 ? fVar2.f32882g : bool, (i12 & 128) != 0 ? fVar2.f32883h : str3, (i12 & 256) != 0 ? fVar2.f32884i : bool2, (i12 & 512) != 0 ? fVar2.f32885j : l11, (i12 & 1024) != 0 ? fVar2.f32886k : l12);
            }

            public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
                boolean z11 = false;
                if (bVar.q(fVar2, 0) || fVar.f32876a != null) {
                    bVar.y(fVar2, 0, m0.f57742a, fVar.f32876a);
                }
                if (bVar.q(fVar2, 1) || fVar.f32877b != null) {
                    bVar.y(fVar2, 1, ReviewStatusType.a.f32373a, fVar.f32877b);
                }
                if (bVar.q(fVar2, 2) || fVar.f32878c != null) {
                    bVar.y(fVar2, 2, m0.f57742a, fVar.f32878c);
                }
                if (bVar.q(fVar2, 3) || fVar.f32879d != null) {
                    bVar.y(fVar2, 3, v1.f57779a, fVar.f32879d);
                }
                if (bVar.q(fVar2, 4) || fVar.f32880e != null) {
                    bVar.y(fVar2, 4, C0353c.a.f32894a, fVar.f32880e);
                }
                if (bVar.q(fVar2, 5) || fVar.f32881f != null) {
                    bVar.y(fVar2, 5, v1.f57779a, fVar.f32881f);
                }
                if (bVar.q(fVar2, 6) || fVar.f32882g != null) {
                    bVar.y(fVar2, 6, kotlinx.serialization.internal.h.f57720a, fVar.f32882g);
                }
                if (bVar.q(fVar2, 7) || fVar.f32883h != null) {
                    bVar.y(fVar2, 7, v1.f57779a, fVar.f32883h);
                }
                if (bVar.q(fVar2, 8) || fVar.f32884i != null) {
                    bVar.y(fVar2, 8, kotlinx.serialization.internal.h.f57720a, fVar.f32884i);
                }
                if (bVar.q(fVar2, 9) || fVar.f32885j != null) {
                    bVar.y(fVar2, 9, x0.f57786a, fVar.f32885j);
                }
                if (bVar.q(fVar2, 10) || fVar.f32886k != null) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar2, 10, x0.f57786a, fVar.f32886k);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ f(java.lang.Integer r13, com.sumsub.sns.internal.core.data.model.ReviewStatusType r14, java.lang.Integer r15, java.lang.String r16, com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.C0353c r17, java.lang.String r18, java.lang.Boolean r19, java.lang.String r20, java.lang.Boolean r21, java.lang.Long r22, java.lang.Long r23, int r24, kotlin.jvm.internal.r r25) {
                /*
                    r12 = this;
                    r0 = r24
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r13
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r14
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r15
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x0020
                L_0x001e:
                    r5 = r16
                L_0x0020:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0026
                    r6 = r2
                    goto L_0x0028
                L_0x0026:
                    r6 = r17
                L_0x0028:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002e
                    r7 = r2
                    goto L_0x0030
                L_0x002e:
                    r7 = r18
                L_0x0030:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0036
                    r8 = r2
                    goto L_0x0038
                L_0x0036:
                    r8 = r19
                L_0x0038:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003e
                    r9 = r2
                    goto L_0x0040
                L_0x003e:
                    r9 = r20
                L_0x0040:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x0046
                    r10 = r2
                    goto L_0x0048
                L_0x0046:
                    r10 = r21
                L_0x0048:
                    r11 = r0 & 512(0x200, float:7.175E-43)
                    if (r11 == 0) goto L_0x004e
                    r11 = r2
                    goto L_0x0050
                L_0x004e:
                    r11 = r22
                L_0x0050:
                    r0 = r0 & 1024(0x400, float:1.435E-42)
                    if (r0 == 0) goto L_0x0055
                    goto L_0x0057
                L_0x0055:
                    r2 = r23
                L_0x0057:
                    r13 = r12
                    r14 = r1
                    r15 = r3
                    r16 = r4
                    r17 = r5
                    r18 = r6
                    r19 = r7
                    r20 = r8
                    r21 = r9
                    r22 = r10
                    r23 = r11
                    r24 = r2
                    r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.d.c.f.<init>(java.lang.Integer, com.sumsub.sns.internal.core.data.model.ReviewStatusType, java.lang.Integer, java.lang.String, com.sumsub.sns.internal.core.data.model.remote.response.d$c$f$c, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Long, java.lang.Long, int, kotlin.jvm.internal.r):void");
            }
        }

        public c() {
            this((List) null, 1, (r) null);
        }

        public static /* synthetic */ void c() {
        }

        public final List<C0351d> a() {
            return this.f32815a;
        }

        public final List<C0351d> b() {
            return this.f32815a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && x.b(this.f32815a, ((c) obj).f32815a);
        }

        public int hashCode() {
            List<C0351d> list = this.f32815a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "Data(items=" + this.f32815a + ')';
        }

        public /* synthetic */ c(int i11, List list, q1 q1Var) {
            if ((i11 & 0) != 0) {
                h1.a(i11, 0, a.f32816a.getDescriptor());
            }
            if ((i11 & 1) == 0) {
                this.f32815a = null;
            } else {
                this.f32815a = list;
            }
        }

        public final c a(List<C0351d> list) {
            return new c(list);
        }

        public c(List<C0351d> list) {
            this.f32815a = list;
        }

        public static /* synthetic */ c a(c cVar, List<C0351d> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = cVar.f32815a;
            }
            return cVar.a(list);
        }

        public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            if (bVar.q(fVar, 0) || cVar.f32815a != null) {
                bVar.y(fVar, 0, new kotlinx.serialization.internal.e(C0351d.a.f32855a), cVar.f32815a);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(List list, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : list);
        }
    }

    public d() {
        this((c) null, 1, (r) null);
    }

    public static /* synthetic */ void c() {
    }

    public final c a() {
        return this.f32812a;
    }

    public final c b() {
        return this.f32812a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && x.b(this.f32812a, ((d) obj).f32812a);
    }

    public int hashCode() {
        c cVar = this.f32812a;
        if (cVar == null) {
            return 0;
        }
        return cVar.hashCode();
    }

    public String toString() {
        return "ListApplicantsResponse(data=" + this.f32812a + ')';
    }

    public /* synthetic */ d(int i11, c cVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32813a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32812a = null;
        } else {
            this.f32812a = cVar;
        }
    }

    public final d a(c cVar) {
        return new d(cVar);
    }

    public d(c cVar) {
        this.f32812a = cVar;
    }

    public static /* synthetic */ d a(d dVar, c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = dVar.f32812a;
        }
        return dVar.a(cVar);
    }

    public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        if (bVar.q(fVar, 0) || dVar.f32812a != null) {
            bVar.y(fVar, 0, c.a.f32816a, dVar.f32812a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(c cVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : cVar);
    }
}
