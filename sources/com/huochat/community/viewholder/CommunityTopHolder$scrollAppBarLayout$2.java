package com.huochat.community.viewholder;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import i6.i;
import tv.w;

public final class CommunityTopHolder$scrollAppBarLayout$2 extends AnimatorListenerAdapter {
    public final /* synthetic */ CommunityTopHolder this$0;

    public CommunityTopHolder$scrollAppBarLayout$2(CommunityTopHolder communityTopHolder) {
        this.this$0 = communityTopHolder;
    }

    /* access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$0(CommunityTopHolder communityTopHolder) {
        communityTopHolder.openMenu();
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        i.b().g(new w(this.this$0), 50);
    }
}
