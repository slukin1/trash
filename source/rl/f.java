package rl;

import android.content.DialogInterface;
import android.widget.PopupWindow;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class f implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f25736d;

    public /* synthetic */ f(MarketContentGuideHelper marketContentGuideHelper, String str, DialogInterface.OnDismissListener onDismissListener) {
        this.f25734b = marketContentGuideHelper;
        this.f25735c = str;
        this.f25736d = onDismissListener;
    }

    public final void onDismiss() {
        this.f25734b.lambda$showCollectionGuide$0(this.f25735c, this.f25736d);
    }
}
