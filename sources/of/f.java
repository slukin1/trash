package of;

import com.hbg.module.market.widget.view.MarketWidgetView;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetView f58819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f58820c;

    public /* synthetic */ f(MarketWidgetView marketWidgetView, List list) {
        this.f58819b = marketWidgetView;
        this.f58820c = list;
    }

    public final void run() {
        this.f58819b.h(this.f58820c);
    }
}
