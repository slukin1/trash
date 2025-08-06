package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12691c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12692d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12693e;

    public /* synthetic */ p(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context) {
        this.f12690b = motionLayout;
        this.f12691c = i11;
        this.f12692d = assetPositionCoinData;
        this.f12693e = context;
    }

    public final void call(Object obj) {
        AssetPositionCoinItemViewHandler.s(this.f12690b, this.f12691c, this.f12692d, this.f12693e, (Void) obj);
    }
}
