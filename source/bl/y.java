package bl;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import vk.e;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiningItem f12792b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12793c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12794d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f12795e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12796f;

    public /* synthetic */ y(MiningItem miningItem, MotionLayout motionLayout, int i11, e eVar, String str) {
        this.f12792b = miningItem;
        this.f12793c = motionLayout;
        this.f12794d = i11;
        this.f12795e = eVar;
        this.f12796f = str;
    }

    public final void onClick(View view) {
        AssetPositionEarnItemViewHandler.m(this.f12792b, this.f12793c, this.f12794d, this.f12795e, this.f12796f, view);
    }
}
