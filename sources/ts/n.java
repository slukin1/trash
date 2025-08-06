package ts;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.swap.ui.SwapHoldStopDialogFragment;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapHoldStopDialogFragment f60393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f60394c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f60395d;

    public /* synthetic */ n(SwapHoldStopDialogFragment swapHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f60393b = swapHoldStopDialogFragment;
        this.f60394c = contractOrderPlace;
        this.f60395d = contractOrderPlace2;
    }

    public final void run() {
        this.f60393b.bi(this.f60394c, this.f60395d);
    }
}
