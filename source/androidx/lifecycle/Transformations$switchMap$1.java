package androidx.lifecycle;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

final class Transformations$switchMap$1 extends Lambda implements l<Object, Unit> {
    public final /* synthetic */ Ref$ObjectRef<LiveData<Object>> $liveData;
    public final /* synthetic */ MediatorLiveData<Object> $result;
    public final /* synthetic */ l<Object, LiveData<Object>> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$1(l<Object, LiveData<Object>> lVar, Ref$ObjectRef<LiveData<Object>> ref$ObjectRef, MediatorLiveData<Object> mediatorLiveData) {
        super(1);
        this.$transform = lVar;
        this.$liveData = ref$ObjectRef;
        this.$result = mediatorLiveData;
    }

    public final void invoke(Object obj) {
        T t11 = (LiveData) this.$transform.invoke(obj);
        T t12 = this.$liveData.element;
        if (t12 != t11) {
            if (t12 != null) {
                this.$result.c((LiveData) t12);
            }
            this.$liveData.element = t11;
            if (t11 != null) {
                MediatorLiveData<Object> mediatorLiveData = this.$result;
                final MediatorLiveData<Object> mediatorLiveData2 = this.$result;
                mediatorLiveData.b(t11, new l0(new l<Object, Unit>() {
                    public final void invoke(Object obj) {
                        mediatorLiveData2.setValue(obj);
                    }
                }));
            }
        }
    }
}
