package androidx.lifecycle;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class Transformations$switchMap$2$onChanged$1 extends Lambda implements l {
    public final /* synthetic */ MediatorLiveData $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$2$onChanged$1(MediatorLiveData mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(obj);
    }
}
