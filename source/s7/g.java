package s7;

import com.huobi.contract.entity.ContractCancelResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g f53433b = new g();

    public final Object call(Object obj) {
        return Observable.create(new c((ContractCancelResult) obj));
    }
}
