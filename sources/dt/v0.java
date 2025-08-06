package dt;

import com.huobi.account.entity.BalanceQueryData;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class v0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v0 f54174b = new v0();

    public final Object call(Object obj) {
        return Observable.from(((BalanceQueryData) obj).getList());
    }
}
