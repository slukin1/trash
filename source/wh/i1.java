package wh;

import android.text.Editable;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import rx.functions.Action1;

public final /* synthetic */ class i1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetChildTabFragment.a f61308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Editable f61309c;

    public /* synthetic */ i1(BaseAssetChildTabFragment.a aVar, Editable editable) {
        this.f61308b = aVar;
        this.f61309c = editable;
    }

    public final void call(Object obj) {
        this.f61308b.d(this.f61309c, (Long) obj);
    }
}
