package a9;

import com.hbg.lib.network.pro.core.response.IntCodeResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f3505b = new h();

    public final Object call(Object obj) {
        return Observable.create(new d((IntCodeResponse) obj));
    }
}
