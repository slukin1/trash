package bl;

import android.content.Context;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class o1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12688c;

    public /* synthetic */ o1(Context context, String str) {
        this.f12687b = context;
        this.f12688c = str;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.n(this.f12687b, this.f12688c, (Void) obj);
    }
}
