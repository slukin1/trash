package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class a1 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12401a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12402b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12403c;

    public /* synthetic */ a1(d1 d1Var, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12401a = d1Var;
        this.f12402b = contractOrderPlace;
        this.f12403c = contractCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12401a.B(this.f12402b, this.f12403c, hBDialogFragment);
    }
}
