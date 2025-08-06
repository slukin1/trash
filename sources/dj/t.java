package dj;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.ui.ContractHoldStopDialogFragment;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractHoldStopDialogFragment f53752b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f53753c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f53754d;

    public /* synthetic */ t(ContractHoldStopDialogFragment contractHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f53752b = contractHoldStopDialogFragment;
        this.f53753c = contractOrderPlace;
        this.f53754d = contractOrderPlace2;
    }

    public final void run() {
        this.f53752b.bi(this.f53753c, this.f53754d);
    }
}
