package og;

import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.adapter.NotificationSettingAdapter;
import java.util.HashMap;

public final /* synthetic */ class m implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter f58847a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f58848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.d f58849c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NoticeManageResp f58850d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ HashMap f58851e;

    public /* synthetic */ m(NotificationSettingAdapter notificationSettingAdapter, int i11, NotificationSettingAdapter.d dVar, NoticeManageResp noticeManageResp, HashMap hashMap) {
        this.f58847a = notificationSettingAdapter;
        this.f58848b = i11;
        this.f58849c = dVar;
        this.f58850d = noticeManageResp;
        this.f58851e = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f58847a.l(this.f58848b, this.f58849c, this.f58850d, this.f58851e, hBDialogFragment);
    }
}
