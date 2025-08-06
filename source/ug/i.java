package ug;

import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.presenter.AccountPresenter;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask f60605b;

    public /* synthetic */ i(AccountChallengeTask accountChallengeTask) {
        this.f60605b = accountChallengeTask;
    }

    public final void call(Object obj) {
        AccountPresenter.Q0(this.f60605b, (Void) obj);
    }
}
