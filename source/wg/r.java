package wg;

import com.hbg.lib.network.hbg.core.bean.AccountNewComerTask;
import com.huobi.account.widget.BoxNewcomerView;
import rx.functions.Action1;

public final /* synthetic */ class r implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxNewcomerView f61264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountNewComerTask f61265c;

    public /* synthetic */ r(BoxNewcomerView boxNewcomerView, AccountNewComerTask accountNewComerTask) {
        this.f61264b = boxNewcomerView;
        this.f61265c = accountNewComerTask;
    }

    public final void call(Object obj) {
        this.f61264b.i(this.f61265c, (Void) obj);
    }
}
