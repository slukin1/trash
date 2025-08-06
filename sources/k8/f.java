package k8;

import com.hbg.lib.network.linear.swap.core.response.LinearSwapStatusResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f56557b = new f();

    public final Object call(Object obj) {
        return Observable.create(new b((LinearSwapStatusResponse) obj));
    }
}
