package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class t0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantData f12740c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12741d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12742e;

    public /* synthetic */ t0(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context) {
        this.f12739b = i11;
        this.f12740c = assetPositionWarrantData;
        this.f12741d = motionLayout;
        this.f12742e = context;
    }

    public final void call(Object obj) {
        AssetPositionWarrantItemViewHandler.j(this.f12739b, this.f12740c, this.f12741d, this.f12742e, (Void) obj);
    }
}
