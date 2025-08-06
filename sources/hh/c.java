package hh;

import com.huobi.asset.page.event.AccountConfigChangedEvent;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f54937b = new c();

    public final void call(Object obj) {
        EventBus.d().k(new AccountConfigChangedEvent());
    }
}
