package og;

import android.widget.CompoundButton;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.huobi.account.adapter.NotificationSettingAdapter;

public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter f58826b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58827c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58828d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f58829e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.b f58830f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NoticeManageResp f58831g;

    public /* synthetic */ h(NotificationSettingAdapter notificationSettingAdapter, boolean z11, int i11, int i12, NotificationSettingAdapter.b bVar, NoticeManageResp noticeManageResp) {
        this.f58826b = notificationSettingAdapter;
        this.f58827c = z11;
        this.f58828d = i11;
        this.f58829e = i12;
        this.f58830f = bVar;
        this.f58831g = noticeManageResp;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f58826b.k(this.f58827c, this.f58828d, this.f58829e, this.f58830f, this.f58831g, compoundButton, z11);
    }
}
