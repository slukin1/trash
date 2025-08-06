package zm;

import android.view.View;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.linearswap.ordertutorial.ui.OrderTutorialStep2Fragment;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderTutorialStep2Fragment.e f63097b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f63098c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f63099d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment f63100e;

    public /* synthetic */ s(OrderTutorialStep2Fragment.e eVar, String str, String str2, LeverSelectDialogFragment leverSelectDialogFragment) {
        this.f63097b = eVar;
        this.f63098c = str;
        this.f63099d = str2;
        this.f63100e = leverSelectDialogFragment;
    }

    public final void onClick(View view) {
        this.f63097b.f(this.f63098c, this.f63099d, this.f63100e, view);
    }
}
