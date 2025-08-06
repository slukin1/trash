package kotlinx.serialization.json.internal;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.q;

public final class JsonNamesMapKt$serializationNamesIndices$1 extends Lambda implements a<String[]> {
    public final /* synthetic */ q $strategy;
    public final /* synthetic */ f $this_serializationNamesIndices;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonNamesMapKt$serializationNamesIndices$1(f fVar, q qVar) {
        super(0);
        this.$this_serializationNamesIndices = fVar;
        this.$strategy = qVar;
    }

    public final String[] invoke() {
        int e11 = this.$this_serializationNamesIndices.e();
        String[] strArr = new String[e11];
        for (int i11 = 0; i11 < e11; i11++) {
            strArr[i11] = this.$strategy.a(this.$this_serializationNamesIndices, i11, this.$this_serializationNamesIndices.f(i11));
        }
        return strArr;
    }
}
