package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class x implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70460b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70461c;

    public /* synthetic */ x(d0 d0Var, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70459a = d0Var;
        this.f70460b = contractOrderPlace;
        this.f70461c = swapCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f70459a.K(this.f70460b, this.f70461c, hBDialogFragment);
    }
}
