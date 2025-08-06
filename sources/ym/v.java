package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class v implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61893c;

    public /* synthetic */ v(z zVar, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61891a = zVar;
        this.f61892b = contractOrderPlace;
        this.f61893c = futureContractInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61891a.l0(this.f61892b, this.f61893c, hBDialogFragment);
    }
}
