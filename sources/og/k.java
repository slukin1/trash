package og;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.adapter.NotificationSettingAdapter;
import java.util.HashMap;

public final /* synthetic */ class k implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.d f58839a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f58840b;

    public /* synthetic */ k(NotificationSettingAdapter.d dVar, HashMap hashMap) {
        this.f58839a = dVar;
        this.f58840b = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        NotificationSettingAdapter.m(this.f58839a, this.f58840b, hBDialogFragment);
    }
}
