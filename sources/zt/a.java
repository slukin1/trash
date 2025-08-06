package zt;

import com.hbg.lib.network.hbg.grid.bean.GridLeverageRange;
import com.huobi.tradingbot.manager.GridLeverageRangeController;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f63115b;

    public /* synthetic */ a(String str) {
        this.f63115b = str;
    }

    public final Object call(Object obj) {
        return GridLeverageRangeController.d(this.f63115b, (GridLeverageRange) obj);
    }
}
