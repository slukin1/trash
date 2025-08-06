package bl;

import android.content.Context;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.viewhandler.AssetPositionHeaderItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12553b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetAccountType f12554c;

    public /* synthetic */ c0(Context context, AssetAccountType assetAccountType) {
        this.f12553b = context;
        this.f12554c = assetAccountType;
    }

    public final void call(Object obj) {
        AssetPositionHeaderItemViewHandler.g(this.f12553b, this.f12554c, (Void) obj);
    }
}
