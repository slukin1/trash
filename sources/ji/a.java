package ji;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.assetrecord.presenter.AppleOrderHistoryRecordListPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppleOrderHistoryRecordListPresenter f55944b;

    public /* synthetic */ a(AppleOrderHistoryRecordListPresenter appleOrderHistoryRecordListPresenter) {
        this.f55944b = appleOrderHistoryRecordListPresenter;
    }

    public final void call(Object obj) {
        this.f55944b.W((APIStatusErrorException) obj);
    }
}
