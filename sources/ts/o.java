package ts;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.swap.ui.SwapHoldStopDialogFragment;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapHoldStopDialogFragment f60400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f60401c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f60402d;

    public /* synthetic */ o(SwapHoldStopDialogFragment swapHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f60400b = swapHoldStopDialogFragment;
        this.f60401c = contractOrderPlace;
        this.f60402d = contractOrderPlace2;
    }

    public final void run() {
        this.f60400b.ci(this.f60401c, this.f60402d);
    }
}
