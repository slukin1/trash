package en;

import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.linearswap.viewhandler.LinearSwapLeftDrawerItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f54356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearSwapCurrencyInfoDrawerItem f54357c;

    public /* synthetic */ a(FutureContractInfo futureContractInfo, LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem) {
        this.f54356b = futureContractInfo;
        this.f54357c = linearSwapCurrencyInfoDrawerItem;
    }

    public final void onClick(View view) {
        LinearSwapLeftDrawerItemHandler.g(this.f54356b, this.f54357c, view);
    }
}
