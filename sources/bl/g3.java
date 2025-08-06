package bl;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.viewhandler.VirtualAddressViewHander;

public final /* synthetic */ class g3 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VirtualAddressInfo f12598a;

    public /* synthetic */ g3(VirtualAddressInfo virtualAddressInfo) {
        this.f12598a = virtualAddressInfo;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        VirtualAddressViewHander.h(this.f12598a, hBDialogFragment);
    }
}
