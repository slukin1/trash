package bl;

import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.huobi.finance.viewhandler.AssetPositionLevelItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class h0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12600b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12601c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionLevelData f12602d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12603e;

    public /* synthetic */ h0(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, String str) {
        this.f12600b = motionLayout;
        this.f12601c = i11;
        this.f12602d = assetPositionLevelData;
        this.f12603e = str;
    }

    public final void call(Object obj) {
        AssetPositionLevelItemViewHandler.m(this.f12600b, this.f12601c, this.f12602d, this.f12603e, (Void) obj);
    }
}
