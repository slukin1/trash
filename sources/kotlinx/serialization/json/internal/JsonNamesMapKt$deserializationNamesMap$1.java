package kotlinx.serialization.json.internal;

import d10.a;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.f;

public final class JsonNamesMapKt$deserializationNamesMap$1 extends Lambda implements a<Map<String, ? extends Integer>> {
    public final /* synthetic */ f $descriptor;
    public final /* synthetic */ kotlinx.serialization.json.a $this_deserializationNamesMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonNamesMapKt$deserializationNamesMap$1(f fVar, kotlinx.serialization.json.a aVar) {
        super(0);
        this.$descriptor = fVar;
        this.$this_deserializationNamesMap = aVar;
    }

    public final Map<String, Integer> invoke() {
        return JsonNamesMapKt.b(this.$descriptor, this.$this_deserializationNamesMap);
    }
}
