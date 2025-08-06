package i8;

import com.hbg.lib.network.linear.swap.controller.LinearSwapOpenCloseController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenRight;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f55022b;

    public /* synthetic */ i(String str) {
        this.f55022b = str;
    }

    public final void call(Object obj) {
        LinearSwapOpenCloseController.f70325a.put(this.f55022b, (LinearSwapOpenRight) obj);
    }
}
