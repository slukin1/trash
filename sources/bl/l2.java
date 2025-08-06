package bl;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.finance.viewhandler.FixedMiningViewHandler;

public final /* synthetic */ class l2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiningItem f12657b;

    public /* synthetic */ l2(MiningItem miningItem) {
        this.f12657b = miningItem;
    }

    public final void onClick(View view) {
        FixedMiningViewHandler.f(this.f12657b, view);
    }
}
