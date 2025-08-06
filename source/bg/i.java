package bg;

import com.hbg.module.swap.bean.SwapPositionItem;
import com.hbg.module.swap.viewhandler.SwapPositionViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionItem f12374b;

    public /* synthetic */ i(SwapPositionItem swapPositionItem) {
        this.f12374b = swapPositionItem;
    }

    public final void call(Object obj) {
        SwapPositionViewHandler.n(this.f12374b, (Void) obj);
    }
}
