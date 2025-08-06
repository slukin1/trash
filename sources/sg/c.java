package sg;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.account.handler.PersonalMarketHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SymbolBean f66613b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v9.c f66614c;

    public /* synthetic */ c(SymbolBean symbolBean, v9.c cVar) {
        this.f66613b = symbolBean;
        this.f66614c = cVar;
    }

    public final void onClick(View view) {
        PersonalMarketHandler.f(this.f66613b, this.f66614c, view);
    }
}
