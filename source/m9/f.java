package m9;

import com.hbg.lib.network.swap.core.controller.SwapAllowLevelController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58125b;

    public /* synthetic */ f(String str) {
        this.f58125b = str;
    }

    public final Object call(Object obj) {
        return SwapAllowLevelController.d(this.f58125b, (List) obj);
    }
}
