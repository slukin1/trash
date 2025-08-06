package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class w implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61895a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61897c;

    public /* synthetic */ w(z zVar, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61895a = zVar;
        this.f61896b = contractOrderPlace;
        this.f61897c = futureContractInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61895a.d0(this.f61896b, this.f61897c, hBDialogFragment);
    }
}
