package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12624b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12625c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12626d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12627e;

    public /* synthetic */ j(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context) {
        this.f12624b = motionLayout;
        this.f12625c = i11;
        this.f12626d = assetPositionCoinData;
        this.f12627e = context;
    }

    public final void onClick(View view) {
        AssetPositionCoinItemViewHandler.p(this.f12624b, this.f12625c, this.f12626d, this.f12627e, view);
    }
}
