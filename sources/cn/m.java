package cn;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.feature.util.FutureTpSlHelper;
import com.huobi.linearswap.ui.LinearSwapHoldStopDialogFragment;

public final /* synthetic */ class m implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapHoldStopDialogFragment f13166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTpSlHelper f13167b;

    public /* synthetic */ m(LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment, FutureTpSlHelper futureTpSlHelper) {
        this.f13166a = linearSwapHoldStopDialogFragment;
        this.f13167b = futureTpSlHelper;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f13166a.ci(this.f13167b, hBDialogFragment);
    }
}
