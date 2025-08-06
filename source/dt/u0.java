package dt;

import com.huobi.account.entity.BalanceQueryData;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class u0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u0 f54159b = new u0();

    public final Object call(Object obj) {
        return Observable.from(((BalanceQueryData) obj).getList());
    }
}
