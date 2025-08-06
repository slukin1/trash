package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12659c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinData f12660d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12661e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12662f;

    public /* synthetic */ m(MotionLayout motionLayout, int i11, AssetPositionCoinData assetPositionCoinData, Context context, String str) {
        this.f12658b = motionLayout;
        this.f12659c = i11;
        this.f12660d = assetPositionCoinData;
        this.f12661e = context;
        this.f12662f = str;
    }

    public final void onClick(View view) {
        AssetPositionCoinItemViewHandler.m(this.f12658b, this.f12659c, this.f12660d, this.f12661e, this.f12662f, view);
    }
}
