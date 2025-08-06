package ql;

import android.view.View;
import android.widget.TextView;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.huobi.homemarket.handler.MarketOptionSettingItemHandler;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketOptionSettingBean f60043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f60044c;

    public /* synthetic */ m(MarketOptionSettingBean marketOptionSettingBean, TextView textView) {
        this.f60043b = marketOptionSettingBean;
        this.f60044c = textView;
    }

    public final void onClick(View view) {
        MarketOptionSettingItemHandler.d(this.f60043b, this.f60044c, view);
    }
}
