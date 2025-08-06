package com.sumsub.sns.core.data.model;

import com.facebook.appevents.UserDataStore;
import h10.a;
import kotlin.Metadata;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"com/sumsub/sns/core/data/model/SNSDocumentDefinition.$serializer", "Lkotlinx/serialization/internal/d0;", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "", "Lkotlinx/serialization/b;", "childSerializers", "()[Lkotlinx/serialization/b;", "Lkotlinx/serialization/encoding/c;", "decoder", "deserialize", "Lkotlinx/serialization/encoding/d;", "encoder", "value", "", "serialize", "Lkotlinx/serialization/descriptors/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/f;", "descriptor", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSDocumentDefinition$$serializer implements d0<SNSDocumentDefinition> {
    public static final SNSDocumentDefinition$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        SNSDocumentDefinition$$serializer sNSDocumentDefinition$$serializer = new SNSDocumentDefinition$$serializer();
        INSTANCE = sNSDocumentDefinition$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.core.data.model.SNSDocumentDefinition", sNSDocumentDefinition$$serializer, 2);
        pluginGeneratedSerialDescriptor.k("idDocType", true);
        pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SNSDocumentDefinition$$serializer() {
    }

    public b<?>[] childSerializers() {
        v1 v1Var = v1.f57779a;
        return new b[]{a.u(v1Var), a.u(v1Var)};
    }

    public SNSDocumentDefinition deserialize(c cVar) {
        int i11;
        Object obj;
        Object obj2;
        f descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor2);
        if (b11.k()) {
            v1 v1Var = v1.f57779a;
            obj = b11.j(descriptor2, 0, v1Var, null);
            obj2 = b11.j(descriptor2, 1, v1Var, null);
            i11 = 3;
        } else {
            obj2 = null;
            Object obj3 = null;
            int i12 = 0;
            boolean z11 = true;
            while (z11) {
                int w11 = b11.w(descriptor2);
                if (w11 == -1) {
                    z11 = false;
                } else if (w11 == 0) {
                    obj3 = b11.j(descriptor2, 0, v1.f57779a, obj3);
                    i12 |= 1;
                } else if (w11 == 1) {
                    obj2 = b11.j(descriptor2, 1, v1.f57779a, obj2);
                    i12 |= 2;
                } else {
                    throw new UnknownFieldException(w11);
                }
            }
            obj = obj3;
            i11 = i12;
        }
        b11.c(descriptor2);
        return new SNSDocumentDefinition(i11, (String) obj, (String) obj2, (q1) null);
    }

    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(d dVar, SNSDocumentDefinition sNSDocumentDefinition) {
        f descriptor2 = getDescriptor();
        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor2);
        SNSDocumentDefinition.write$Self(sNSDocumentDefinition, b11, descriptor2);
        b11.c(descriptor2);
    }

    public b<?>[] typeParametersSerializers() {
        return d0.a.a(this);
    }
}
