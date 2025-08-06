package wg;

import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.widget.BoxSignInView;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxSignInView f61268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask.CheckInBean f61269c;

    public /* synthetic */ t(BoxSignInView boxSignInView, AccountChallengeTask.CheckInBean checkInBean) {
        this.f61268b = boxSignInView;
        this.f61269c = checkInBean;
    }

    public final void call(Object obj) {
        this.f61268b.i(this.f61269c, (Void) obj);
    }
}
