package bf;

import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.module.livesquare.presenter.LiveSquarePresenter;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveSquarePresenter f12360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12361c;

    public /* synthetic */ h(LiveSquarePresenter liveSquarePresenter, String str) {
        this.f12360b = liveSquarePresenter;
        this.f12361c = str;
    }

    public final Object call(Object obj) {
        return this.f12360b.G0(this.f12361c, (LiveSquareContentData) obj);
    }
}
