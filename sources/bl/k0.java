package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.huobi.finance.viewhandler.AssetPositionOtcItemViewHandler;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12643c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionOtcData f12644d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12645e;

    public /* synthetic */ k0(MotionLayout motionLayout, int i11, AssetPositionOtcData assetPositionOtcData, Context context) {
        this.f12642b = motionLayout;
        this.f12643c = i11;
        this.f12644d = assetPositionOtcData;
        this.f12645e = context;
    }

    public final void onClick(View view) {
        AssetPositionOtcItemViewHandler.i(this.f12642b, this.f12643c, this.f12644d, this.f12645e, view);
    }
}
