package vv;

import com.huochat.community.widget.skeleton.CommunityListSkeletonView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityListSkeletonView f61216b;

    public /* synthetic */ a(CommunityListSkeletonView communityListSkeletonView) {
        this.f61216b = communityListSkeletonView;
    }

    public final void run() {
        CommunityListSkeletonView.showSkeleton$lambda$0(this.f61216b);
    }
}
