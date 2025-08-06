package bl;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12609b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12610c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12611d;

    public /* synthetic */ i(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData) {
        this.f12609b = motionLayout;
        this.f12610c = i11;
        this.f12611d = assetPositionCoinData;
    }

    public final void onClick(View view) {
        AssetPositionCoinItemViewHandler.r(this.f12609b, this.f12610c, this.f12611d, view);
    }
}
