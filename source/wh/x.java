package wh;

import android.view.View;
import com.huobi.asset2.index.AssetIndexFragmentNew;
import rx.functions.Action1;

public final /* synthetic */ class x implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentNew f61350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61351c;

    public /* synthetic */ x(AssetIndexFragmentNew assetIndexFragmentNew, View view) {
        this.f61350b = assetIndexFragmentNew;
        this.f61351c = view;
    }

    public final void call(Object obj) {
        this.f61350b.ni(this.f61351c, (Void) obj);
    }
}
