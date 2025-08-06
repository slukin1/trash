package ds;

import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.staring.bean.ProRemindListItem;
import com.huobi.staring.ui.ProRemindFragment;

public final /* synthetic */ class t0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProRemindFragment f53966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProRemindListItem f53967b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f53968c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommonSwitchButton f53969d;

    public /* synthetic */ t0(ProRemindFragment proRemindFragment, ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton) {
        this.f53966a = proRemindFragment;
        this.f53967b = proRemindListItem;
        this.f53968c = i11;
        this.f53969d = commonSwitchButton;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f53966a.hj(this.f53967b, this.f53968c, this.f53969d, hBDialogFragment);
    }
}
