package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinItemViewHandler f12668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12669c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12670d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12671e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12672f;

    public /* synthetic */ n(AssetPositionCoinItemViewHandler assetPositionCoinItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context) {
        this.f12668b = assetPositionCoinItemViewHandler;
        this.f12669c = motionLayout;
        this.f12670d = i11;
        this.f12671e = assetPositionCoinData;
        this.f12672f = context;
    }

    public final void onClick(View view) {
        this.f12668b.q(this.f12669c, this.f12670d, this.f12671e, this.f12672f, view);
    }
}
