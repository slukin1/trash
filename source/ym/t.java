package ym;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.contract.entity.ContractOrderPlace;

public final /* synthetic */ class t implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f61883a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f61884b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f61885c;

    public /* synthetic */ t(z zVar, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        this.f61883a = zVar;
        this.f61884b = contractOrderPlace;
        this.f61885c = futureContractInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61883a.h0(this.f61884b, this.f61885c, hBDialogFragment);
    }
}
