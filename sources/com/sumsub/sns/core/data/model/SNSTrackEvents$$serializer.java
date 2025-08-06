package com.sumsub.sns.core.data.model;

import com.twitter.sdk.android.core.identity.AuthHandler;
import h10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"com/sumsub/sns/core/data/model/SNSTrackEvents.$serializer", "Lkotlinx/serialization/internal/d0;", "Lcom/sumsub/sns/core/data/model/SNSTrackEvents;", "", "Lkotlinx/serialization/b;", "childSerializers", "()[Lkotlinx/serialization/b;", "Lkotlinx/serialization/encoding/c;", "decoder", "deserialize", "Lkotlinx/serialization/encoding/d;", "encoder", "value", "", "serialize", "Lkotlinx/serialization/descriptors/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/f;", "descriptor", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSTrackEvents$$serializer implements d0<SNSTrackEvents> {
    public static final SNSTrackEvents$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        SNSTrackEvents$$serializer sNSTrackEvents$$serializer = new SNSTrackEvents$$serializer();
        INSTANCE = sNSTrackEvents$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.core.data.model.SNSTrackEvents", sNSTrackEvents$$serializer, 3);
        pluginGeneratedSerialDescriptor.k("activity", false);
        pluginGeneratedSerialDescriptor.k(AuthHandler.EXTRA_TOKEN_SECRET, true);
        pluginGeneratedSerialDescriptor.k("payload", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SNSTrackEvents$$serializer() {
    }

    public b<?>[] childSerializers() {
        v1 v1Var = v1.f57779a;
        return new b[]{v1Var, a.u(v1Var), a.u(new r0(v1Var, new ContextualSerializer(Reflection.b(Object.class), (b) null, new b[0])))};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sumsub.sns.core.data.model.SNSTrackEvents deserialize(kotlinx.serialization.encoding.c r17) {
        /*
            r16 = this;
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            kotlinx.serialization.descriptors.f r1 = r16.getDescriptor()
            r2 = r17
            kotlinx.serialization.encoding.a r2 = r2.b(r1)
            boolean r3 = r2.k()
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = r2.i(r1, r7)
            kotlinx.serialization.internal.v1 r8 = kotlinx.serialization.internal.v1.f57779a
            java.lang.Object r6 = r2.j(r1, r6, r8, r5)
            kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
            kotlinx.serialization.ContextualSerializer r10 = new kotlinx.serialization.ContextualSerializer
            kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
            kotlinx.serialization.b[] r7 = new kotlinx.serialization.b[r7]
            r10.<init>(r0, r5, r7)
            r9.<init>(r8, r10)
            java.lang.Object r0 = r2.j(r1, r4, r9, r5)
            r4 = 7
            r5 = r3
            goto L_0x0084
        L_0x0037:
            r3 = r5
            r8 = r3
            r10 = r8
            r11 = r6
            r9 = r7
        L_0x003c:
            if (r11 == 0) goto L_0x0080
            int r12 = r2.w(r1)
            r13 = -1
            if (r12 == r13) goto L_0x007e
            if (r12 == 0) goto L_0x0076
            if (r12 == r6) goto L_0x006b
            if (r12 != r4) goto L_0x0065
            kotlinx.serialization.internal.r0 r12 = new kotlinx.serialization.internal.r0
            kotlinx.serialization.internal.v1 r13 = kotlinx.serialization.internal.v1.f57779a
            kotlinx.serialization.ContextualSerializer r14 = new kotlinx.serialization.ContextualSerializer
            kotlin.reflect.c r15 = kotlin.jvm.internal.Reflection.b(r0)
            kotlinx.serialization.b[] r6 = new kotlinx.serialization.b[r7]
            r14.<init>(r15, r5, r6)
            r12.<init>(r13, r14)
            java.lang.Object r3 = r2.j(r1, r4, r12, r3)
            r9 = r9 | 4
            r6 = 1
            goto L_0x003c
        L_0x0065:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r12)
            throw r0
        L_0x006b:
            kotlinx.serialization.internal.v1 r6 = kotlinx.serialization.internal.v1.f57779a
            r12 = 1
            java.lang.Object r10 = r2.j(r1, r12, r6, r10)
            r9 = r9 | 2
            r6 = r12
            goto L_0x003c
        L_0x0076:
            r12 = r6
            java.lang.String r8 = r2.i(r1, r7)
            r9 = r9 | 1
            goto L_0x003c
        L_0x007e:
            r11 = r7
            goto L_0x003c
        L_0x0080:
            r0 = r3
            r5 = r8
            r4 = r9
            r6 = r10
        L_0x0084:
            r2.c(r1)
            com.sumsub.sns.core.data.model.SNSTrackEvents r1 = new com.sumsub.sns.core.data.model.SNSTrackEvents
            java.lang.String r6 = (java.lang.String) r6
            r7 = r0
            java.util.Map r7 = (java.util.Map) r7
            r8 = 0
            r3 = r1
            r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.util.Map) r7, (kotlinx.serialization.internal.q1) r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.SNSTrackEvents$$serializer.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.core.data.model.SNSTrackEvents");
    }

    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(d dVar, SNSTrackEvents sNSTrackEvents) {
        f descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor2);
        SNSTrackEvents.write$Self(sNSTrackEvents, b11, descriptor2);
        b11.c(descriptor2);
    }

    public b<?>[] typeParametersSerializers() {
        return d0.a.a(this);
    }
}
