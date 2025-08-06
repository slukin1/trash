package ul;

import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.homemarket.ui.HomeMarketNewFragment;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StableLinearLayoutManager f60815b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60816c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f60817d;

    public /* synthetic */ v(StableLinearLayoutManager stableLinearLayoutManager, int i11, RecyclerView recyclerView) {
        this.f60815b = stableLinearLayoutManager;
        this.f60816c = i11;
        this.f60817d = recyclerView;
    }

    public final void run() {
        HomeMarketNewFragment.Nj(this.f60815b, this.f60816c, this.f60817d);
    }
}
