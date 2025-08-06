package com.sumsub.sns.core.data.model;

import kotlin.Metadata;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"com/sumsub/sns/core/data/model/FlowType.$serializer", "Lkotlinx/serialization/internal/d0;", "Lcom/sumsub/sns/core/data/model/FlowType;", "", "Lkotlinx/serialization/b;", "childSerializers", "()[Lkotlinx/serialization/b;", "Lkotlinx/serialization/encoding/c;", "decoder", "deserialize", "Lkotlinx/serialization/encoding/d;", "encoder", "value", "", "serialize", "Lkotlinx/serialization/descriptors/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/f;", "descriptor", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class FlowType$$serializer implements d0<FlowType> {
    public static final FlowType$$serializer INSTANCE = new FlowType$$serializer();
    public static final /* synthetic */ f descriptor;

    static {
        EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.core.data.model.FlowType", 3);
        enumDescriptor.k("actions", false);
        enumDescriptor.k("standalone", false);
        enumDescriptor.k("module", false);
        descriptor = enumDescriptor;
    }

    private FlowType$$serializer() {
    }

    public b<?>[] childSerializers() {
        return new b[]{v1.f57779a};
    }

    public FlowType deserialize(c cVar) {
        return FlowType.values()[cVar.s(getDescriptor())];
    }

    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(d dVar, FlowType flowType) {
        dVar.g(getDescriptor(), flowType.ordinal());
    }

    public b<?>[] typeParametersSerializers() {
        return d0.a.a(this);
    }
}
