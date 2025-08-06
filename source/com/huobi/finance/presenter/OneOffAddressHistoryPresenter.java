package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.OneOffAddress;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.utils.k0;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;
import tq.p;

public class OneOffAddressHistoryPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<OneOffAddress> f45606a;

    /* renamed from: b  reason: collision with root package name */
    public String f45607b;

    /* renamed from: c  reason: collision with root package name */
    public String f45608c;

    /* renamed from: d  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<OneOffAddress> f45609d = new a();

    public class a implements SmartRefreshPageSplitter.c<OneOffAddress> {
        public a() {
        }

        public Func1<? super OneOffAddress, ? extends Long> a() {
            return f5.f45877b;
        }

        public Observable<List<OneOffAddress>> c() {
            MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, OneOffAddressHistoryPresenter.this.f45607b).a("size", 10);
            if (OneOffAddressHistoryPresenter.this.f45608c != null) {
                a11.a("chain", OneOffAddressHistoryPresenter.this.f45608c);
            }
            return ((FinanceService) p.W(FinanceService.class)).oneOffAddressQuery(a11.b()).compose(p.a0());
        }

        /* renamed from: f */
        public Observable<List<OneOffAddress>> b(OneOffAddress oneOffAddress) {
            MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, OneOffAddressHistoryPresenter.this.f45607b).a("size", 10).a(DevicePublicKeyStringDef.DIRECT, "next").a("from", Long.valueOf(oneOffAddress.getId()));
            if (OneOffAddressHistoryPresenter.this.f45608c != null) {
                a11.a("chain", OneOffAddressHistoryPresenter.this.f45608c);
            }
            return ((FinanceService) p.W(FinanceService.class)).oneOffAddressQuery(a11.b()).compose(p.a0());
        }
    }

    public interface b extends SmartRefreshPageSplitter.d {
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f45607b = intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY);
            this.f45608c = intent.getStringExtra("chain");
        }
        SmartRefreshPageSplitter<OneOffAddress> k11 = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(10).r(bVar).q(this.f45609d).k();
        this.f45606a = k11;
        k11.F();
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }
}
