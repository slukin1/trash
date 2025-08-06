package tb;

import com.hbg.lite.wallet.bean.LegalDataTotal;
import com.hbg.lite.wallet.presenter.WalletPresenter;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletPresenter f29300b;

    public /* synthetic */ a(WalletPresenter walletPresenter) {
        this.f29300b = walletPresenter;
    }

    public final Object call(Object obj) {
        return this.f29300b.j0((LegalDataTotal) obj);
    }
}
