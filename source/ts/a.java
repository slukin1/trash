package ts;

import com.huobi.swap.ui.SuperMarginBalanceDialog;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuperMarginBalanceDialog f60323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60324c;

    public /* synthetic */ a(SuperMarginBalanceDialog superMarginBalanceDialog, String str) {
        this.f60323b = superMarginBalanceDialog;
        this.f60324c = str;
    }

    public final void run() {
        this.f60323b.Dh(this.f60324c);
    }
}
