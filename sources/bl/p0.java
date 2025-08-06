package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.viewhandler.AssetPositionQuantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class p0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionQuantItemViewHandler f12694b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12695c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12696d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionQuantData f12697e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12698f;

    public /* synthetic */ p0(AssetPositionQuantItemViewHandler assetPositionQuantItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context) {
        this.f12694b = assetPositionQuantItemViewHandler;
        this.f12695c = motionLayout;
        this.f12696d = i11;
        this.f12697e = assetPositionQuantData;
        this.f12698f = context;
    }

    public final void call(Object obj) {
        this.f12694b.j(this.f12695c, this.f12696d, this.f12697e, this.f12698f, (Void) obj);
    }
}
