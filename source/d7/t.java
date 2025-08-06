package d7;

import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExchangeSettingsController f53531b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53532c;

    public /* synthetic */ t(ExchangeSettingsController exchangeSettingsController, String str) {
        this.f53531b = exchangeSettingsController;
        this.f53532c = str;
    }

    public final void call(Object obj) {
        this.f53531b.e(this.f53532c, (ExchangeSettings) obj);
    }
}
