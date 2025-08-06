package qp;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.otc.persenter.PublicAdsFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PublicAdsFragmentPresenter f60105b;

    public /* synthetic */ w(PublicAdsFragmentPresenter publicAdsFragmentPresenter) {
        this.f60105b = publicAdsFragmentPresenter;
    }

    public final void call(Object obj) {
        this.f60105b.v0((APIStatusErrorException) obj);
    }
}
