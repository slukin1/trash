package qp;

import com.hbg.lib.network.otc.core.OTCPageListExtendResponse;
import com.huobi.otc.persenter.PublicAdsFragmentPresenter;
import rx.functions.Func2;

public final /* synthetic */ class z implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PublicAdsFragmentPresenter f60110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60111c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60112d;

    public /* synthetic */ z(PublicAdsFragmentPresenter publicAdsFragmentPresenter, int i11, boolean z11) {
        this.f60110b = publicAdsFragmentPresenter;
        this.f60111c = i11;
        this.f60112d = z11;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f60110b.x0(this.f60111c, this.f60112d, (OTCPageListExtendResponse) obj, (OTCPageListExtendResponse) obj2);
    }
}
