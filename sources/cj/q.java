package cj;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.presenter.ContractTradeBasePresenter;

public final /* synthetic */ class q implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContractTradeBasePresenter.o f13103a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractPosition f13104b;

    public /* synthetic */ q(ContractTradeBasePresenter.o oVar, ContractPosition contractPosition) {
        this.f13103a = oVar;
        this.f13104b = contractPosition;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f13103a.n(this.f13104b, hBDialogFragment);
    }
}
