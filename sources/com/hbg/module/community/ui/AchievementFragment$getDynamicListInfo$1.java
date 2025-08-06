package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.MedalHomePageShare;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class AchievementFragment$getDynamicListInfo$1 extends Lambda implements l<MedalHomePageShare, Unit> {
    public final /* synthetic */ AchievementFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AchievementFragment$getDynamicListInfo$1(AchievementFragment achievementFragment) {
        super(1);
        this.this$0 = achievementFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MedalHomePageShare) obj);
        return Unit.f56620a;
    }

    public final void invoke(MedalHomePageShare medalHomePageShare) {
        AchievementFragment achievementFragment = this.this$0;
        AchievementFragment.Th(achievementFragment).F.finishRefresh();
        AchievementFragment.Th(achievementFragment).F.w();
        if (medalHomePageShare == null || medalHomePageShare.getShowMedals() == null || !(!medalHomePageShare.getShowMedals().isEmpty())) {
            AchievementFragment.Th(achievementFragment).D.i();
        } else {
            AchievementFragment.Th(achievementFragment).D.g();
            achievementFragment.f17252p.clear();
            achievementFragment.f17252p.addAll(medalHomePageShare.getShowMedals());
            MultiTypeAdapter Sh = achievementFragment.f17253q;
            MultiTypeAdapter multiTypeAdapter = null;
            if (Sh == null) {
                Sh = null;
            }
            Sh.setItems(achievementFragment.f17252p);
            MultiTypeAdapter Sh2 = achievementFragment.f17253q;
            if (Sh2 != null) {
                multiTypeAdapter = Sh2;
            }
            multiTypeAdapter.notifyDataSetChanged();
            achievementFragment.Zh(medalHomePageShare.getLightUpNum());
        }
        achievementFragment.sh();
    }
}
