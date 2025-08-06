package og;

import android.widget.CompoundButton;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.huobi.account.adapter.NotificationSettingAdapter;

public final /* synthetic */ class i implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter f58832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58833c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58834d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.d f58835e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ NoticeManageResp f58836f;

    public /* synthetic */ i(NotificationSettingAdapter notificationSettingAdapter, boolean z11, int i11, NotificationSettingAdapter.d dVar, NoticeManageResp noticeManageResp) {
        this.f58832b = notificationSettingAdapter;
        this.f58833c = z11;
        this.f58834d = i11;
        this.f58835e = dVar;
        this.f58836f = noticeManageResp;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f58832b.n(this.f58833c, this.f58834d, this.f58835e, this.f58836f, compoundButton, z11);
    }
}
