package r7;

import com.hbg.lib.network.contract.core.controller.ContractAllowMaxLevelController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70516b;

    public /* synthetic */ b(String str) {
        this.f70516b = str;
    }

    public final Object call(Object obj) {
        return ContractAllowMaxLevelController.d(this.f70516b, (List) obj);
    }
}
