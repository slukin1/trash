package bl;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.finance.viewhandler.ActiveMiningViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiningItem f12545b;

    public /* synthetic */ b(MiningItem miningItem) {
        this.f12545b = miningItem;
    }

    public final void onClick(View view) {
        ActiveMiningViewHandler.f(this.f12545b, view);
    }
}
