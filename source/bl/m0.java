package bl;

import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.viewhandler.AssetPositionQuantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class m0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12664c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionQuantData f12665d;

    public /* synthetic */ m0(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData) {
        this.f12663b = motionLayout;
        this.f12664c = i11;
        this.f12665d = assetPositionQuantData;
    }

    public final void call(Object obj) {
        AssetPositionQuantItemViewHandler.k(this.f12663b, this.f12664c, this.f12665d, (Void) obj);
    }
}
