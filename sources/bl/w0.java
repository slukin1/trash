package bl;

import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class w0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12776c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantData f12777d;

    public /* synthetic */ w0(MotionLayout motionLayout, int i11, AssetPositionWarrantData assetPositionWarrantData) {
        this.f12775b = motionLayout;
        this.f12776c = i11;
        this.f12777d = assetPositionWarrantData;
    }

    public final void call(Object obj) {
        AssetPositionWarrantItemViewHandler.n(this.f12775b, this.f12776c, this.f12777d, (Void) obj);
    }
}
