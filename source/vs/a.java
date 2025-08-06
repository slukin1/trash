package vs;

import android.view.View;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.swap.viewhandler.SwapLeftDrawerItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfo f61203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwapCurrencyInfoDrawerItem f61204c;

    public /* synthetic */ a(SwapCurrencyInfo swapCurrencyInfo, SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem) {
        this.f61203b = swapCurrencyInfo;
        this.f61204c = swapCurrencyInfoDrawerItem;
    }

    public final void onClick(View view) {
        SwapLeftDrawerItemHandler.g(this.f61203b, this.f61204c, view);
    }
}
