package r7;

import com.hbg.lib.network.contract.core.controller.ContractSettlementController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70519b;

    public /* synthetic */ e(String str) {
        this.f70519b = str;
    }

    public final Object call(Object obj) {
        return ContractSettlementController.d(this.f70519b, (List) obj);
    }
}
