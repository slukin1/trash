package tv;

import com.huochat.community.viewholder.CommunityTopHolder;
import com.huochat.community.viewholder.CommunityTopHolder$scrollAppBarLayout$2;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityTopHolder f60520b;

    public /* synthetic */ w(CommunityTopHolder communityTopHolder) {
        this.f60520b = communityTopHolder;
    }

    public final void run() {
        CommunityTopHolder$scrollAppBarLayout$2.onAnimationEnd$lambda$0(this.f60520b);
    }
}
