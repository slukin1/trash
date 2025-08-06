package com.hbg.module.community.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class AchievementFragment$getDynamicListInfo$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ AchievementFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AchievementFragment$getDynamicListInfo$2(AchievementFragment achievementFragment) {
        super(2);
        this.this$0 = achievementFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.sh();
        AchievementFragment.Th(this.this$0).F.finishRefresh();
        AchievementFragment.Th(this.this$0).F.w();
        AchievementFragment.Th(this.this$0).D.i();
    }
}
