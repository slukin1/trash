package sb;

import com.hbg.lib.network.otc.core.bean.OtcLiteCollection;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f53437b = new d();

    public final Object call(Object obj) {
        return Observable.from(((OtcLiteCollection) obj).getWallet());
    }
}
