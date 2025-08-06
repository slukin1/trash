package xq;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.savings.mining.ui.MiningRedeemDialogFragment;

public final /* synthetic */ class b0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiningRedeemDialogFragment f61664a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61665b;

    public /* synthetic */ b0(MiningRedeemDialogFragment miningRedeemDialogFragment, String str) {
        this.f61664a = miningRedeemDialogFragment;
        this.f61665b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f61664a.Eh(this.f61665b, hBDialogFragment);
    }
}
