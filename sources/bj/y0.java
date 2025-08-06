package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class y0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f12527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f12528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractCurrencyInfo f12529c;

    public /* synthetic */ y0(d1 d1Var, ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        this.f12527a = d1Var;
        this.f12528b = contractOrderPlace;
        this.f12529c = contractCurrencyInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12527a.F(this.f12528b, this.f12529c, hBDialogFragment);
    }
}
