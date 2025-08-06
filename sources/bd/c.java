package bd;

import com.hbg.module.exchange.grid.presenter.GridTradePresenter;
import com.hbg.module.exchange.grid.ui.GridConfirmStrategyFragment;

public final /* synthetic */ class c implements GridConfirmStrategyFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GridTradePresenter f12341a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12343c;

    public /* synthetic */ c(GridTradePresenter gridTradePresenter, int i11, String str) {
        this.f12341a = gridTradePresenter;
        this.f12342b = i11;
        this.f12343c = str;
    }

    public final void onConfirm() {
        this.f12341a.A0(this.f12342b, this.f12343c);
    }
}
