package bl;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huobi.finance.bean.ChainItem;
import com.huobi.finance.viewhandler.WithdrawChainViewHandler;

public final /* synthetic */ class i3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12620b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ChainItem f12621c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12622d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ChainInfo f12623e;

    public /* synthetic */ i3(boolean z11, ChainItem chainItem, int i11, ChainInfo chainInfo) {
        this.f12620b = z11;
        this.f12621c = chainItem;
        this.f12622d = i11;
        this.f12623e = chainInfo;
    }

    public final void onClick(View view) {
        WithdrawChainViewHandler.d(this.f12620b, this.f12621c, this.f12622d, this.f12623e, view);
    }
}
