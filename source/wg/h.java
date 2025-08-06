package wg;

import com.airbnb.lottie.LottieListener;
import com.huobi.account.widget.AccountInfoView;

public final /* synthetic */ class h implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountInfoView f61248a;

    public /* synthetic */ h(AccountInfoView accountInfoView) {
        this.f61248a = accountInfoView;
    }

    public final void onResult(Object obj) {
        this.f61248a.F((Throwable) obj);
    }
}
