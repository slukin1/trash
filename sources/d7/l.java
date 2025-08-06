package d7;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import rx.functions.Func1;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ l f53515b = new l();

    public final Object call(Object obj) {
        return k.C().n(false, p.b(), "2").compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
    }
}
