package wg;

import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.huobi.account.widget.BoxChallengeTaskView;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BoxChallengeTaskView f61261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask.ChallengeChildTask f61262c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AccountChallengeTask.TaskStageInfoResp f61263d;

    public /* synthetic */ q(BoxChallengeTaskView boxChallengeTaskView, AccountChallengeTask.ChallengeChildTask challengeChildTask, AccountChallengeTask.TaskStageInfoResp taskStageInfoResp) {
        this.f61261b = boxChallengeTaskView;
        this.f61262c = challengeChildTask;
        this.f61263d = taskStageInfoResp;
    }

    public final void call(Object obj) {
        this.f61261b.j(this.f61262c, this.f61263d, (Void) obj);
    }
}
