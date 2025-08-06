package cn;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.linearswap.ui.LinearSwapHoldStopDialogFragment;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapHoldStopDialogFragment f13173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f13174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f13175d;

    public /* synthetic */ o(LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f13173b = linearSwapHoldStopDialogFragment;
        this.f13174c = contractOrderPlace;
        this.f13175d = contractOrderPlace2;
    }

    public final void run() {
        this.f13173b.di(this.f13174c, this.f13175d);
    }
}
