package bl;

import android.content.Context;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class q1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12709c;

    public /* synthetic */ q1(Context context, String str) {
        this.f12708b = context;
        this.f12709c = str;
    }

    public final void call(Object obj) {
        AssetSpotItemViewAdapter.o(this.f12708b, this.f12709c, (Void) obj);
    }
}
