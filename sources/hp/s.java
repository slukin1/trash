package hp;

import android.view.View;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.huobi.otc.handler.OtcNewCurrencySelectHandler;
import ip.b;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f54974b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuickTradeConfigBean.Asset f54975c;

    public /* synthetic */ s(b bVar, QuickTradeConfigBean.Asset asset) {
        this.f54974b = bVar;
        this.f54975c = asset;
    }

    public final void onClick(View view) {
        OtcNewCurrencySelectHandler.d(this.f54974b, this.f54975c, view);
    }
}
