package og;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.account.adapter.NotificationSettingAdapter;
import java.util.HashMap;

public final /* synthetic */ class j implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationSettingAdapter.b f58837a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f58838b;

    public /* synthetic */ j(NotificationSettingAdapter.b bVar, HashMap hashMap) {
        this.f58837a = bVar;
        this.f58838b = hashMap;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        NotificationSettingAdapter.j(this.f58837a, this.f58838b, hBDialogFragment);
    }
}
