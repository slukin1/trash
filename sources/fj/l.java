package fj;

import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.viewhandler.ContractPositionViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractPosition f54622b;

    public /* synthetic */ l(ContractPosition contractPosition) {
        this.f54622b = contractPosition;
    }

    public final void call(Object obj) {
        ContractPositionViewHandler.j(this.f54622b, (Void) obj);
    }
}
