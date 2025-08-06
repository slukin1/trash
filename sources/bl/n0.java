package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.viewhandler.AssetPositionQuantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class n0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12673b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12674c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionQuantData f12675d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12676e;

    public /* synthetic */ n0(MotionLayout motionLayout, int i11, AssetPositionQuantData assetPositionQuantData, Context context) {
        this.f12673b = motionLayout;
        this.f12674c = i11;
        this.f12675d = assetPositionQuantData;
        this.f12676e = context;
    }

    public final void call(Object obj) {
        AssetPositionQuantItemViewHandler.i(this.f12673b, this.f12674c, this.f12675d, this.f12676e, (Void) obj);
    }
}
