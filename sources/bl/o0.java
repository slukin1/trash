package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.viewhandler.AssetPositionQuantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class o0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12684c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionQuantData f12685d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12686e;

    public /* synthetic */ o0(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context) {
        this.f12683b = motionLayout;
        this.f12684c = i11;
        this.f12685d = assetPositionQuantData;
        this.f12686e = context;
    }

    public final void call(Object obj) {
        AssetPositionQuantItemViewHandler.h(this.f12683b, this.f12684c, this.f12685d, this.f12686e, (Void) obj);
    }
}
