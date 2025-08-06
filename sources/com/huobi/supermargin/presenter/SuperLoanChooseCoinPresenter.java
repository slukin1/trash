package com.huobi.supermargin.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.AccountType;
import com.huobi.supermargin.bean.LoanCurrency;
import dt.h2;
import java.util.List;
import k20.h;
import ks.d;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import rx.functions.Func1;
import u6.g;

public class SuperLoanChooseCoinPresenter extends ActivityPresenter<b> {

    public class a implements Func1<Long, Observable<List<LoanCurrency>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f81305b;

        public a(boolean z11) {
            this.f81305b = z11;
        }

        /* renamed from: a */
        public Observable<List<LoanCurrency>> call(Long l11) {
            return d.e(l11, this.f81305b);
        }
    }

    public interface b extends g {
    }

    public Observable<List<LoanCurrency>> Q(boolean z11) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new a(z11)).compose(RxJavaHelper.t((g) getUI()));
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
