package bl;

import android.view.View;
import com.huobi.finance.viewhandler.AssetSpotItemViewAdapter;
import rx.functions.Action1;

public final /* synthetic */ class t1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotItemViewAdapter f12743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f12744c;

    public /* synthetic */ t1(AssetSpotItemViewAdapter assetSpotItemViewAdapter, View view) {
        this.f12743b = assetSpotItemViewAdapter;
        this.f12744c = view;
    }

    public final void call(Object obj) {
        this.f12743b.l(this.f12744c, (Void) obj);
    }
}
