package ul;

import android.widget.CompoundButton;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import com.huobi.homemarket.ui.MarketCoinFragment;

public final /* synthetic */ class s0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketCoinFragment f60807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketCoinPresenter f60808c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Partitions f60809d;

    public /* synthetic */ s0(MarketCoinFragment marketCoinFragment, MarketCoinPresenter marketCoinPresenter, Partitions partitions) {
        this.f60807b = marketCoinFragment;
        this.f60808c = marketCoinPresenter;
        this.f60809d = partitions;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f60807b.Yh(this.f60808c, this.f60809d, compoundButton, z11);
    }
}
