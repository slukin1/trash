package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.huobi.finance.viewhandler.AssetPositionOtcItemViewHandler;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12613c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionOtcData f12614d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12615e;

    public /* synthetic */ i0(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context) {
        this.f12612b = motionLayout;
        this.f12613c = i11;
        this.f12614d = assetPositionOtcData;
        this.f12615e = context;
    }

    public final void onClick(View view) {
        AssetPositionOtcItemViewHandler.j(this.f12612b, this.f12613c, this.f12614d, this.f12615e, view);
    }
}
