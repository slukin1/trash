package pv;

import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.activity.CommunityDynamicDetailActivity;

public final /* synthetic */ class j implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityDynamicDetailActivity f53260b;

    public /* synthetic */ j(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.f53260b = communityDynamicDetailActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        CommunityDynamicDetailActivity.initView$lambda$1(this.f53260b, appBarLayout, i11);
    }
}
