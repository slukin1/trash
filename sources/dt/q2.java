package dt;

import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class q2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q2 f54133b = new q2();

    public final Object call(Object obj) {
        return Observable.from(((DepthsInfo) obj).getDepthSteps().values());
    }
}
