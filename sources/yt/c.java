package yt;

import android.app.Dialog;
import android.view.View;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f61978b;

    public /* synthetic */ c(Dialog dialog) {
        this.f61978b = dialog;
    }

    public final void onClick(View view) {
        TradingBotNativeAbility.a0(this.f61978b, view);
    }
}
