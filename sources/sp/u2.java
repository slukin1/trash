package sp;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.ui.PublicAdsCoinFragment;

public final /* synthetic */ class u2 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublicAdsCoinFragment f26097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ads f26098b;

    public /* synthetic */ u2(PublicAdsCoinFragment publicAdsCoinFragment, Ads ads) {
        this.f26097a = publicAdsCoinFragment;
        this.f26098b = ads;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f26097a.Rh(this.f26098b, hBDialogFragment);
    }
}
