package m9;

import com.hbg.lib.network.swap.core.bean.SwapOpenRight;
import com.hbg.lib.network.swap.core.controller.SwapOpenCloseController;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58134b;

    public /* synthetic */ p(String str) {
        this.f58134b = str;
    }

    public final void call(Object obj) {
        SwapOpenCloseController.f70765a.put(this.f58134b, (SwapOpenRight) obj);
    }
}
