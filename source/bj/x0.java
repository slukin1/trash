package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class x0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12522a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12523b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12524c;

    public /* synthetic */ x0(d1 d1Var, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12522a = d1Var;
        this.f12523b = contractOrderPlace;
        this.f12524c = contractCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12522a.L(this.f12523b, this.f12524c, hBDialogFragment);
    }
}
