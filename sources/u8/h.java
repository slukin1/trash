package u8;

import com.hbg.lib.network.otc.core.OTCStatusResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f60555b = new h();

    public final Object call(Object obj) {
        return Observable.create(new d((OTCStatusResponse) obj));
    }
}
