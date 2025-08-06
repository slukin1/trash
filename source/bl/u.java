package bl;

import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12746b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12747c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractData f12748d;

    public /* synthetic */ u(MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData) {
        this.f12746b = motionLayout;
        this.f12747c = i11;
        this.f12748d = assetPositionContractData;
    }

    public final void call(Object obj) {
        AssetPositionContractItemViewHandler.n(this.f12746b, this.f12747c, this.f12748d, (Void) obj);
    }
}
