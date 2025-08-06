package androidx.lifecycle;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class Transformations$map$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ MediatorLiveData<Object> $result;
    public final /* synthetic */ l<Object, Object> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$map$1(MediatorLiveData<Object> mediatorLiveData, l<Object, Object> lVar) {
        super(1);
        this.$result = mediatorLiveData;
        this.$transform = lVar;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(this.$transform.invoke(obj));
    }
}
