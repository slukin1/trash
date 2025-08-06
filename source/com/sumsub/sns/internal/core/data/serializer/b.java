package com.sumsub.sns.internal.core.data.serializer;

import com.sumsub.sns.core.data.model.FlowActionType;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class b implements kotlinx.serialization.b<FlowActionType> {

    /* renamed from: a  reason: collision with root package name */
    public static final b f32958a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final f f32959b = SerialDescriptorsKt.a("com.sumsub.sns.internal.core.data.serializer.FlowActionTypeSerializer", e.i.f57638a);

    /* renamed from: a */
    public FlowActionType deserialize(c cVar) {
        return FlowActionType.Companion.get(cVar.q());
    }

    public f getDescriptor() {
        return f32959b;
    }

    /* renamed from: a */
    public void serialize(d dVar, FlowActionType flowActionType) {
        dVar.v(flowActionType.getValue());
    }
}
