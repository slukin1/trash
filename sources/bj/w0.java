package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class w0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12517b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12518c;

    public /* synthetic */ w0(d1 d1Var, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12516a = d1Var;
        this.f12517b = contractOrderPlace;
        this.f12518c = contractCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12516a.H(this.f12517b, this.f12518c, hBDialogFragment);
    }
}
