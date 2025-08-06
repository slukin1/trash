package pv;

import androidx.core.widget.NestedScrollView;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.huochat.community.activity.CommunityDynamicDetailActivity;

public final /* synthetic */ class k implements MyNestedScrollView.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityDynamicDetailActivity f53261a;

    public /* synthetic */ k(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.f53261a = communityDynamicDetailActivity;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        CommunityDynamicDetailActivity.initView$lambda$3(this.f53261a, nestedScrollView, i11, i12, i13, i14);
    }
}
