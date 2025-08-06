package bl;

import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.huobi.finance.viewhandler.AssetPositionOtcItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class l0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12654c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionOtcData f12655d;

    public /* synthetic */ l0(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData) {
        this.f12653b = motionLayout;
        this.f12654c = i11;
        this.f12655d = assetPositionOtcData;
    }

    public final void call(Object obj) {
        AssetPositionOtcItemViewHandler.k(this.f12653b, this.f12654c, this.f12655d, (Void) obj);
    }
}
