package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class u0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantData f12750c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12751d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12752e;

    public /* synthetic */ u0(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context) {
        this.f12749b = i11;
        this.f12750c = assetPositionWarrantData;
        this.f12751d = motionLayout;
        this.f12752e = context;
    }

    public final void call(Object obj) {
        AssetPositionWarrantItemViewHandler.k(this.f12749b, this.f12750c, this.f12751d, this.f12752e, (Void) obj);
    }
}
