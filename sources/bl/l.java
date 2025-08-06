package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12650d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12651e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12652f;

    public /* synthetic */ l(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str) {
        this.f12648b = motionLayout;
        this.f12649c = i11;
        this.f12650d = assetPositionCoinData;
        this.f12651e = context;
        this.f12652f = str;
    }

    public final void onClick(View view) {
        AssetPositionCoinItemViewHandler.n(this.f12648b, this.f12649c, this.f12650d, this.f12651e, this.f12652f, view);
    }
}
