package tq;

import com.hbg.lib.core.network.response.EtfCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f37340b = new b();

    public final Object call(Object obj) {
        return Observable.create(new a((EtfCodeResponse) obj));
    }
}
