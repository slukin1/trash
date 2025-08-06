package z6;

import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62004b;

    public /* synthetic */ a(int i11) {
        this.f62004b = i11;
    }

    public final Object call(Object obj) {
        return FutureClearDialogConfigController.f68833a.put(Integer.valueOf(this.f62004b), (ContractClearDialogConfig) obj);
    }
}
