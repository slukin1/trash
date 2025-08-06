package bf;

import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.module.livesquare.presenter.LiveSquarePresenter;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquarePresenter f12359b;

    public /* synthetic */ g(LiveSquarePresenter liveSquarePresenter) {
        this.f12359b = liveSquarePresenter;
    }

    public final Object call(Object obj) {
        return this.f12359b.H0((LiveSquareSubData) obj);
    }
}
