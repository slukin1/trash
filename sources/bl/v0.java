package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class v0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantData f12765c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12766d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OtcOptionsDetailInfo f12767e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12768f;

    public /* synthetic */ v0(int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, OtcOptionsDetailInfo otcOptionsDetailInfo, Context context) {
        this.f12764b = i11;
        this.f12765c = assetPositionWarrantData;
        this.f12766d = motionLayout;
        this.f12767e = otcOptionsDetailInfo;
        this.f12768f = context;
    }

    public final void call(Object obj) {
        AssetPositionWarrantItemViewHandler.l(this.f12764b, this.f12765c, this.f12766d, this.f12767e, this.f12768f, (Void) obj);
    }
}
