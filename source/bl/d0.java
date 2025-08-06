package bl;

import android.content.Context;
import com.huobi.finance.viewhandler.AssetPositionHeaderItemViewHandler;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionHeaderItemViewHandler f12560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f12561c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12562d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12563e;

    public /* synthetic */ d0(AssetPositionHeaderItemViewHandler assetPositionHeaderItemViewHandler, Context context, String str, String str2) {
        this.f12560b = assetPositionHeaderItemViewHandler;
        this.f12561c = context;
        this.f12562d = str;
        this.f12563e = str2;
    }

    public final void call(Object obj) {
        this.f12560b.f(this.f12561c, this.f12562d, this.f12563e, (Void) obj);
    }
}
