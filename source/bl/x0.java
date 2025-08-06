package bl;

import android.content.Context;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class x0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantItemViewHandler f12784b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12785c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionWarrantData f12786d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12787e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12788f;

    public /* synthetic */ x0(AssetPositionWarrantItemViewHandler assetPositionWarrantItemViewHandler, int i11, AssetPositionWarrantData assetPositionWarrantData, MotionLayout motionLayout, Context context) {
        this.f12784b = assetPositionWarrantItemViewHandler;
        this.f12785c = i11;
        this.f12786d = assetPositionWarrantData;
        this.f12787e = motionLayout;
        this.f12788f = context;
    }

    public final void call(Object obj) {
        this.f12784b.m(this.f12785c, this.f12786d, this.f12787e, this.f12788f, (Void) obj);
    }
}
