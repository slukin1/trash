package pv;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huochat.community.activity.CommunityDynamicDetailActivity;

public final /* synthetic */ class l implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityDynamicDetailActivity f53262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53263b;

    public /* synthetic */ l(CommunityDynamicDetailActivity communityDynamicDetailActivity, String str) {
        this.f53262a = communityDynamicDetailActivity;
        this.f53263b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        CommunityDynamicDetailActivity.showOpenHuoChatDialog$lambda$7(this.f53262a, this.f53263b, hBDialogFragment);
    }
}
