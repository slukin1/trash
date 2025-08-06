package rt;

import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f25837b = new h();

    public final Object call(Object obj) {
        return Observable.from(((DepthsInfo) obj).getDepthSteps().values());
    }
}
