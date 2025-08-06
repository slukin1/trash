package com.huobi.supermargin.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.AccountType;
import com.huobi.supermargin.bean.LoanRepay;
import com.huobi.supermargin.service.SuperMarginService;
import dt.h2;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import rx.functions.Func1;
import tq.p;
import u6.g;

public class SuperLoanDetailPresenter extends ActivityPresenter<b> {

    public class a implements Func1<Long, Observable<LoanRepay>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f81307b;

        public a(long j11) {
            this.f81307b = j11;
        }

        /* renamed from: a */
        public Observable<LoanRepay> call(Long l11) {
            HashMap hashMap = new HashMap();
            hashMap.put("loan-id", Long.valueOf(this.f81307b));
            if (l11 != null) {
                hashMap.put("account-id", String.valueOf(l11));
            }
            return ((SuperMarginService) p.W(SuperMarginService.class)).loanRepayDetail(hashMap).compose(p.a0());
        }
    }

    public interface b extends g {
    }

    public Observable<LoanRepay> Q(long j11) {
        return h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).switchIfEmpty(Observable.just(null)).flatMap(new a(j11));
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
