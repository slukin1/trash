package r7;

import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import com.hbg.lib.network.contract.core.controller.ContractOpenCloseController;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70518b;

    public /* synthetic */ d(String str) {
        this.f70518b = str;
    }

    public final void call(Object obj) {
        ContractOpenCloseController.f69232a.put(this.f70518b, (ContractOpenRight) obj);
    }
}
