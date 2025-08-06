package com.huobi.tradingbot.vm;

import androidx.lifecycle.LifecycleOwner;
import com.huobi.edgeengine.viewmodel.EdgeEngineContainerViewModel;
import rj.b;

public final class TradingBotViewModel extends EdgeEngineContainerViewModel {
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        o0(i0() + " ------> onDestroy");
        b h02 = h0();
        h02.I(i0() + ".onDestroy()");
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
        h0().I("moduleAppear()");
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
        h0().I("moduleDisappear()");
    }
}
