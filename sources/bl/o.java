package bl;

import android.content.Context;
import android.view.View;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionCoinItemViewHandler f12680b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12681c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12682d;

    public /* synthetic */ o(AssetPositionCoinItemViewHandler assetPositionCoinItemViewHandler, String str, Context context) {
        this.f12680b = assetPositionCoinItemViewHandler;
        this.f12681c = str;
        this.f12682d = context;
    }

    public final void onClick(View view) {
        this.f12680b.l(this.f12681c, this.f12682d, view);
    }
}
