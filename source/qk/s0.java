package qk;

import android.content.Context;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;

public final /* synthetic */ class s0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.f f59995a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f59996b;

    public /* synthetic */ s0(DialogUtils.b.f fVar, Context context) {
        this.f59995a = fVar;
        this.f59996b = context;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        KycAndHasTradeDialogUtils.j(this.f59995a, this.f59996b, hBDialogFragment);
    }
}
