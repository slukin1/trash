package yt;

import android.widget.Button;
import androidx.core.widget.NestedScrollView;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f61983b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Button f61984c;

    public /* synthetic */ g(NestedScrollView nestedScrollView, Button button) {
        this.f61983b = nestedScrollView;
        this.f61984c = button;
    }

    public final void run() {
        TradingBotNativeAbility.Y(this.f61983b, this.f61984c);
    }
}
