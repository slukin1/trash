package qs;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class v implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f70451a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f70452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f70453c;

    public /* synthetic */ v(d0 d0Var, ContractOrderPlace contractOrderPlace, SwapCurrencyInfo swapCurrencyInfo) {
        this.f70451a = d0Var;
        this.f70452b = contractOrderPlace;
        this.f70453c = swapCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f70451a.I(this.f70452b, this.f70453c, hBDialogFragment);
    }
}
