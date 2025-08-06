package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class z0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12534b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12535c;

    public /* synthetic */ z0(d1 d1Var, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12533a = d1Var;
        this.f12534b = contractOrderPlace;
        this.f12535c = contractCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12533a.J(this.f12534b, this.f12535c, hBDialogFragment);
    }
}
