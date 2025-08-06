package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class u implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61888b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61889c;

    public /* synthetic */ u(z zVar, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61887a = zVar;
        this.f61888b = contractOrderPlace;
        this.f61889c = futureContractInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61887a.j0(this.f61888b, this.f61889c, hBDialogFragment);
    }
}
