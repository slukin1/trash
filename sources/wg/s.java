package wg;

import com.hbg.lib.network.hbg.core.bean.AccountNewComerTask;
import com.huobi.account.widget.BoxNewcomerView;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxNewcomerView f61266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountNewComerTask f61267c;

    public /* synthetic */ s(BoxNewcomerView boxNewcomerView, AccountNewComerTask accountNewComerTask) {
        this.f61266b = boxNewcomerView;
        this.f61267c = accountNewComerTask;
    }

    public final void call(Object obj) {
        this.f61266b.h(this.f61267c, (Void) obj);
    }
}
