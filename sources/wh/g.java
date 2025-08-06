package wh;

import android.view.View;
import com.huobi.asset2.index.AssetIndexFragment;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragment f61299b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61300c;

    public /* synthetic */ g(AssetIndexFragment assetIndexFragment, View view) {
        this.f61299b = assetIndexFragment;
        this.f61300c = view;
    }

    public final void call(Object obj) {
        this.f61299b.ji(this.f61300c, (Void) obj);
    }
}
