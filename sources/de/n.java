package de;

import com.huobi.contract.entity.ContractCurrentTriggerOrderResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ n f53610b = new n();

    public final Object call(Object obj) {
        return Observable.from(((ContractCurrentTriggerOrderResult) obj).getOrders());
    }
}
