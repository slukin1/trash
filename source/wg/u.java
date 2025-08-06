package wg;

import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.widget.BoxSignInView;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxSignInView f61270b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask.CheckInBean f61271c;

    public /* synthetic */ u(BoxSignInView boxSignInView, AccountChallengeTask.CheckInBean checkInBean) {
        this.f61270b = boxSignInView;
        this.f61271c = checkInBean;
    }

    public final void call(Object obj) {
        this.f61270b.h(this.f61271c, (Void) obj);
    }
}
