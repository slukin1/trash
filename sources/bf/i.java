package bf;

import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.module.livesquare.presenter.LiveSquareSubPresenter;
import rx.functions.Func1;

public final /* synthetic */ class i implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquareSubPresenter f12362b;

    public /* synthetic */ i(LiveSquareSubPresenter liveSquareSubPresenter) {
        this.f12362b = liveSquareSubPresenter;
    }

    public final Object call(Object obj) {
        return this.f12362b.p0((LiveSquareSubData) obj);
    }
}
