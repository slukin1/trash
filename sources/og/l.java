package og;

import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.adapter.NotificationSettingAdapter;
import java.util.HashMap;

public final /* synthetic */ class l implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter f58841a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f58842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58843c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.b f58844d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NoticeManageResp f58845e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ HashMap f58846f;

    public /* synthetic */ l(NotificationSettingAdapter notificationSettingAdapter, int i11, int i12, NotificationSettingAdapter.b bVar, NoticeManageResp noticeManageResp, HashMap hashMap) {
        this.f58841a = notificationSettingAdapter;
        this.f58842b = i11;
        this.f58843c = i12;
        this.f58844d = bVar;
        this.f58845e = noticeManageResp;
        this.f58846f = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f58841a.i(this.f58842b, this.f58843c, this.f58844d, this.f58845e, this.f58846f, hBDialogFragment);
    }
}
