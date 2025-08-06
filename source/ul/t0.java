package ul;

import android.widget.RadioGroup;
import com.huobi.homemarket.ui.MarketCoinFragment;

public final /* synthetic */ class t0 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketCoinFragment f60811b;

    public /* synthetic */ t0(MarketCoinFragment marketCoinFragment) {
        this.f60811b = marketCoinFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        this.f60811b.Th(radioGroup, i11);
    }
}
