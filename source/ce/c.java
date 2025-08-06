package ce;

import c6.b;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;

public final /* synthetic */ class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlinePresenter f13072b;

    public /* synthetic */ c(AbstractKlinePresenter abstractKlinePresenter) {
        this.f13072b = abstractKlinePresenter;
    }

    public final void onCallback(Object obj) {
        this.f13072b.Y((IndexDetail) obj);
    }
}
