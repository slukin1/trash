package cj;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.presenter.ContractTradeBasePresenter;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractTradeBasePresenter.o f13105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractPosition f13106c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f13107d;

    public /* synthetic */ r(ContractTradeBasePresenter.o oVar, ContractPosition contractPosition, DialogUtils.b bVar) {
        this.f13105b = oVar;
        this.f13106c = contractPosition;
        this.f13107d = bVar;
    }

    public final void run() {
        this.f13105b.p(this.f13106c, this.f13107d);
    }
}
