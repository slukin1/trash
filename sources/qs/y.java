package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class y implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70463a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70464b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70465c;

    public /* synthetic */ y(d0 d0Var, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70463a = d0Var;
        this.f70464b = contractOrderPlace;
        this.f70465c = swapCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f70463a.Q(this.f70464b, this.f70465c, hBDialogFragment);
    }
}
