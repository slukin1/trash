package iq;

import android.util.Pair;
import com.huobi.points.presenter.PointsBuyPresenter;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsBuyPresenter f55809b;

    public /* synthetic */ i(PointsBuyPresenter pointsBuyPresenter) {
        this.f55809b = pointsBuyPresenter;
    }

    public final void call(Object obj) {
        this.f55809b.i0((Pair) obj);
    }
}
