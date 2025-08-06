package r7;

import com.hbg.lib.network.contract.core.controller.ContractAllowLevelController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70515b;

    public /* synthetic */ a(String str) {
        this.f70515b = str;
    }

    public final Object call(Object obj) {
        return ContractAllowLevelController.d(this.f70515b, (List) obj);
    }
}
