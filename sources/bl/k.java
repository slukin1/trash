package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12637b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12638c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12639d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12640e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12641f;

    public /* synthetic */ k(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str) {
        this.f12637b = motionLayout;
        this.f12638c = i11;
        this.f12639d = assetPositionCoinData;
        this.f12640e = context;
        this.f12641f = str;
    }

    public final void onClick(View view) {
        AssetPositionCoinItemViewHandler.o(this.f12637b, this.f12638c, this.f12639d, this.f12640e, this.f12641f, view);
    }
}
