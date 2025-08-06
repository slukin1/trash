package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.huobi.finance.controller.VirtualAddressProvider;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import u6.g;

public class CurrencyOrderDetailPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public FinanceRecordItem f45556a;

    /* renamed from: b  reason: collision with root package name */
    public VirtualAddressInfo f45557b;

    public class a extends BaseSubscriber<List<VirtualAddressInfo>> {
        public a() {
        }

        public void onError(Throwable th2) {
            ((b) CurrencyOrderDetailPresenter.this.getUI()).e8(false, (String) null);
        }

        public void onNext(List<VirtualAddressInfo> list) {
            boolean z11;
            String str;
            super.onNext(list);
            Iterator<VirtualAddressInfo> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z11 = false;
                    str = null;
                    break;
                }
                VirtualAddressInfo next = it2.next();
                if (CurrencyOrderDetailPresenter.this.f45556a.getToAddress().equals(next.getAddress())) {
                    str = next.getAlias();
                    VirtualAddressInfo unused = CurrencyOrderDetailPresenter.this.f45557b = next;
                    z11 = true;
                    break;
                }
            }
            ((b) CurrencyOrderDetailPresenter.this.getUI()).e8(z11, str);
        }
    }

    public interface b extends g {
        void Y9(FinanceRecordItem financeRecordItem);

        void e8(boolean z11, String str);
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("finance_record_item");
        if (serializableExtra instanceof FinanceRecordItem) {
            this.f45556a = (FinanceRecordItem) serializableExtra;
            ((b) getUI()).Y9(this.f45556a);
            T();
        }
    }

    public final void T() {
        VirtualAddressProvider.f().e(this.f45556a.getCurrency(), this.f45556a.getChain(), true).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
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
