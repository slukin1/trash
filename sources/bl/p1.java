package bl;

import android.content.Context;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class p1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12700c;

    public /* synthetic */ p1(Context context, String str) {
        this.f12699b = context;
        this.f12700c = str;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.p(this.f12699b, this.f12700c, (Void) obj);
    }
}
