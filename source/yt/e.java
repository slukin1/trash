package yt;

import android.widget.Button;
import androidx.core.widget.NestedScrollView;
import com.huobi.tradingbot.engine.TradingBotNativeAbility;

public final /* synthetic */ class e implements NestedScrollView.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Button f61981a;

    public /* synthetic */ e(Button button) {
        this.f61981a = button;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        TradingBotNativeAbility.X(this.f61981a, nestedScrollView, i11, i12, i13, i14);
    }
}
