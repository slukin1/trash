package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class a0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70375c;

    public /* synthetic */ a0(d0 d0Var, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70373a = d0Var;
        this.f70374b = contractOrderPlace;
        this.f70375c = swapCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f70373a.G(this.f70374b, this.f70375c, hBDialogFragment);
    }
}
