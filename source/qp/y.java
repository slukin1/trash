package qp;

import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.huobi.otc.persenter.PublicAdsFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class y implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PublicAdsFragmentPresenter f60107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60108c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60109d;

    public /* synthetic */ y(PublicAdsFragmentPresenter publicAdsFragmentPresenter, boolean z11, boolean z12) {
        this.f60107b = publicAdsFragmentPresenter;
        this.f60108c = z11;
        this.f60109d = z12;
    }

    public final void call(Object obj) {
        this.f60107b.u0(this.f60108c, this.f60109d, (OTCPageListExtendResponse) obj);
    }
}
