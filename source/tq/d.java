package tq;

import com.hbg.lib.core.network.response.RiskIntCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f37342b = new d();

    public final Object call(Object obj) {
        return Observable.create(new h((RiskIntCodeResponse) obj));
    }
}
