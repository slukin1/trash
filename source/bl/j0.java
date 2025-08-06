package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.huobi.finance.viewhandler.AssetPositionOtcItemViewHandler;

public final /* synthetic */ class j0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12629c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionOtcData f12630d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12631e;

    public /* synthetic */ j0(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context) {
        this.f12628b = motionLayout;
        this.f12629c = i11;
        this.f12630d = assetPositionOtcData;
        this.f12631e = context;
    }

    public final void onClick(View view) {
        AssetPositionOtcItemViewHandler.h(this.f12628b, this.f12629c, this.f12630d, this.f12631e, view);
    }
}
