package pv;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huochat.community.activity.CommunityDynamicDetailActivity;

public final /* synthetic */ class b implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f53251a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityDynamicDetailActivity f53252b;

    public /* synthetic */ b(String str, CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.f53251a = str;
        this.f53252b = communityDynamicDetailActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        CommunityDynamicDetailActivity.showOpenHuoChatDialog$lambda$5(this.f53251a, this.f53252b, hBDialogFragment);
    }
}
