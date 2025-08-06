package wg;

import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.widget.BoxChallengeTaskView;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxChallengeTaskView f61259b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask.ChallengeChildTask f61260c;

    public /* synthetic */ p(BoxChallengeTaskView boxChallengeTaskView, AccountChallengeTask.ChallengeChildTask challengeChildTask) {
        this.f61259b = boxChallengeTaskView;
        this.f61260c = challengeChildTask;
    }

    public final void call(Object obj) {
        this.f61259b.k(this.f61260c, (Void) obj);
    }
}
