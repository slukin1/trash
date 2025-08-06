package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class s implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61881c;

    public /* synthetic */ s(z zVar, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61879a = zVar;
        this.f61880b = contractOrderPlace;
        this.f61881c = futureContractInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61879a.n0(this.f61880b, this.f61881c, hBDialogFragment);
    }
}
