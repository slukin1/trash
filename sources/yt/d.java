package yt;

import android.app.Dialog;
import android.view.View;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;
import rj.b;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f61979b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f61980c;

    public /* synthetic */ d(Dialog dialog, b bVar) {
        this.f61979b = dialog;
        this.f61980c = bVar;
    }

    public final void onClick(View view) {
        TradingBotNativeAbility.b0(this.f61979b, this.f61980c, view);
    }
}
