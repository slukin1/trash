package androidx.lifecycle;

import androidx.arch.core.util.Function;
import d10.l;
import kotlin.jvm.internal.Lambda;

final class Transformations$map$2 extends Lambda implements l {
    public final /* synthetic */ Function $mapFunction;
    public final /* synthetic */ MediatorLiveData $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$map$2(MediatorLiveData mediatorLiveData, Function function) {
        super(1);
        this.$result = mediatorLiveData;
        this.$mapFunction = function;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(this.$mapFunction.apply(obj));
    }
}
