package cn;

import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.linearswap.ui.LinearSwapHoldStopDialogFragment;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapHoldStopDialogFragment f13178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f13179c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ContractOrderPlace f13180d;

    public /* synthetic */ p(LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment, ContractOrderPlace contractOrderPlace, ContractOrderPlace contractOrderPlace2) {
        this.f13178b = linearSwapHoldStopDialogFragment;
        this.f13179c = contractOrderPlace;
        this.f13180d = contractOrderPlace2;
    }

    public final void run() {
        this.f13178b.ei(this.f13179c, this.f13180d);
    }
}
