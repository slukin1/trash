package androidx.lifecycle;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.x;

final class Transformations$distinctUntilChanged$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ Ref$BooleanRef $firstTime;
    public final /* synthetic */ MediatorLiveData<Object> $outputLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$distinctUntilChanged$1(MediatorLiveData<Object> mediatorLiveData, Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$outputLiveData = mediatorLiveData;
        this.$firstTime = ref$BooleanRef;
    }

    public final void invoke(Object obj) {
        Object value = this.$outputLiveData.getValue();
        if (this.$firstTime.element || ((value == null && obj != null) || (value != null && !x.b(value, obj)))) {
            this.$firstTime.element = false;
            this.$outputLiveData.setValue(obj);
        }
    }
}
