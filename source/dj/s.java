package dj;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.ui.ContractHoldStopDialogFragment;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractHoldStopDialogFragment f53745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f53746c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f53747d;

    public /* synthetic */ s(ContractHoldStopDialogFragment contractHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f53745b = contractHoldStopDialogFragment;
        this.f53746c = contractOrderPlace;
        this.f53747d = contractOrderPlace2;
    }

    public final void run() {
        this.f53745b.ai(this.f53746c, this.f53747d);
    }
}
