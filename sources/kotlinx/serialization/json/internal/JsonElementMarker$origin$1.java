package kotlinx.serialization.json.internal;

import d10.p;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.serialization.descriptors.f;

public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements p<f, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(f fVar, int i11) {
        return Boolean.valueOf(((JsonElementMarker) this.receiver).e(fVar, i11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((f) obj, ((Number) obj2).intValue());
    }
}
