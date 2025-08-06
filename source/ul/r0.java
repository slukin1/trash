package ul;

import android.widget.CompoundButton;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import com.huobi.homemarket.ui.MarketCoinFragment;

public final /* synthetic */ class r0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketCoinFragment f60804b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketCoinPresenter f60805c;

    public /* synthetic */ r0(MarketCoinFragment marketCoinFragment, MarketCoinPresenter marketCoinPresenter) {
        this.f60804b = marketCoinFragment;
        this.f60805c = marketCoinPresenter;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f60804b.Xh(this.f60805c, compoundButton, z11);
    }
}
