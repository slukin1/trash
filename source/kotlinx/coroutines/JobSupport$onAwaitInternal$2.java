package kotlinx.coroutines;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class JobSupport$onAwaitInternal$2 extends FunctionReferenceImpl implements q<JobSupport, Object, Object, Object> {
    public static final JobSupport$onAwaitInternal$2 INSTANCE = new JobSupport$onAwaitInternal$2();

    public JobSupport$onAwaitInternal$2() {
        super(3, JobSupport.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(JobSupport jobSupport, Object obj, Object obj2) {
        return jobSupport.H0(obj, obj2);
    }
}
