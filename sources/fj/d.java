package fj;

import com.huobi.contract.entity.ContractCurrentOrderItem;
import com.huobi.contract.viewhandler.ContractCurrentOrderHandler;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCurrentOrderItem f54608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54609c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54610d;

    public /* synthetic */ d(ContractCurrentOrderItem contractCurrentOrderItem, String str, String str2) {
        this.f54608b = contractCurrentOrderItem;
        this.f54609c = str;
        this.f54610d = str2;
    }

    public final void call(Object obj) {
        ContractCurrentOrderHandler.f(this.f54608b, this.f54609c, this.f54610d, (Void) obj);
    }
}
