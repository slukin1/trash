package k8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f56556b = new e();

    public final Object call(Object obj) {
        return Observable.create(new a((LinearSwapCancelAllResult) obj));
    }
}
