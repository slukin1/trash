package com.sumsub.sentry;

import com.sumsub.sentry.f;
import com.sumsub.sentry.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001e2\u00020\u0001:\u0002\b\u0012B#\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018B9\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001dJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\b\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/sumsub/sentry/g;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sentry/r;", "Lcom/sumsub/sentry/r;", "c", "()Lcom/sumsub/sentry/r;", "getSdkInfo$annotations", "()V", "sdkInfo", "", "Lcom/sumsub/sentry/f;", "b", "Ljava/util/List;", "()Ljava/util/List;", "getImages$annotations", "images", "<init>", "(Lcom/sumsub/sentry/r;Ljava/util/List;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sentry/r;Ljava/util/List;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class g {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final r f30346a;

    /* renamed from: b  reason: collision with root package name */
    public final List<f> f30347b;

    public static final class a implements d0<g> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30348a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30349b;

        static {
            a aVar = new a();
            f30348a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.DebugMeta", aVar, 2);
            pluginGeneratedSerialDescriptor.k("sdk_info", true);
            pluginGeneratedSerialDescriptor.k("images", true);
            f30349b = pluginGeneratedSerialDescriptor;
        }

        /* renamed from: a */
        public g deserialize(c cVar) {
            int i11;
            Object obj;
            Object obj2;
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
            if (b11.k()) {
                obj2 = b11.j(descriptor, 0, r.a.f30488a, null);
                obj = b11.p(descriptor, 1, new e(f.a.f30338a), null);
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
                        obj2 = b11.j(descriptor, 0, r.a.f30488a, obj2);
                        i12 |= 1;
                    } else if (w11 == 1) {
                        obj3 = b11.p(descriptor, 1, new e(f.a.f30338a), obj3);
                        i12 |= 2;
                    } else {
                        throw new UnknownFieldException(w11);
                    }
                }
                obj = obj3;
                i11 = i12;
            }
            b11.c(descriptor);
            return new g(i11, (r) obj2, (List) obj, (q1) null);
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(r.a.f30488a), new e(f.a.f30338a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30349b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, g gVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            g.a(gVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final kotlinx.serialization.b<g> serializer() {
            return a.f30348a;
        }

        public b() {
        }
    }

    public g() {
        this((r) null, (List) null, 3, (kotlin.jvm.internal.r) null);
    }

    public static final void a(g gVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || gVar.f30346a != null) {
            bVar.y(fVar, 0, r.a.f30488a, gVar.f30346a);
        }
        if (bVar.q(fVar, 1) || !x.b(gVar.f30347b, new ArrayList())) {
            z11 = true;
        }
        if (z11) {
            bVar.F(fVar, 1, new e(f.a.f30338a), gVar.f30347b);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public final r c() {
        return this.f30346a;
    }

    public /* synthetic */ g(int i11, r rVar, List list, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30348a.getDescriptor());
        }
        this.f30346a = (i11 & 1) == 0 ? null : rVar;
        if ((i11 & 2) == 0) {
            this.f30347b = new ArrayList();
        } else {
            this.f30347b = list;
        }
    }

    public final List<f> a() {
        return this.f30347b;
    }

    public g(r rVar, List<f> list) {
        this.f30346a = rVar;
        this.f30347b = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(r rVar, List list, int i11, kotlin.jvm.internal.r rVar2) {
        this((i11 & 1) != 0 ? null : rVar, (i11 & 2) != 0 ? new ArrayList() : list);
    }
}
