package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class w implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70456b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70457c;

    public /* synthetic */ w(d0 d0Var, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70455a = d0Var;
        this.f70456b = contractOrderPlace;
        this.f70457c = swapCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f70455a.M(this.f70456b, this.f70457c, hBDialogFragment);
    }
}
