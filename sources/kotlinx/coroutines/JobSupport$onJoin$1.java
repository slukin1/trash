package kotlinx.coroutines;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

final /* synthetic */ class JobSupport$onJoin$1 extends FunctionReferenceImpl implements q<JobSupport, k<?>, Object, Unit> {
    public static final JobSupport$onJoin$1 INSTANCE = new JobSupport$onJoin$1();

    public JobSupport$onJoin$1() {
        super(3, JobSupport.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((JobSupport) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(JobSupport jobSupport, k<?> kVar, Object obj) {
        jobSupport.O0(kVar, obj);
    }
}
