package yt;

import android.app.Dialog;
import android.view.View;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f61977b;

    public /* synthetic */ b(Dialog dialog) {
        this.f61977b = dialog;
    }

    public final void onClick(View view) {
        TradingBotNativeAbility.Z(this.f61977b, view);
    }
}
