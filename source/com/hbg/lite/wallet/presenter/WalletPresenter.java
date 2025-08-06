package com.hbg.lite.wallet.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lite.wallet.bean.BaseAssetInfo;
import com.hbg.lite.wallet.bean.LegalDataTotal;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import ra.c;
import sb.f;
import u6.g;

public class WalletPresenter extends BaseFragmentPresenter<b> {

    /* renamed from: c  reason: collision with root package name */
    public v9.a<s9.a> f77621c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f77622d;

    /* renamed from: e  reason: collision with root package name */
    public LegalDetailInfo f77623e;

    /* renamed from: f  reason: collision with root package name */
    public LegalDataTotal f77624f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f77625g = true;

    public class a extends EasySubscriber<List<LegalDetailInfo>> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (WalletPresenter.this.f77625g) {
                ((b) WalletPresenter.this.getUI()).m0();
            }
            ((b) WalletPresenter.this.getUI()).n6(WalletPresenter.this.f77624f);
            ((b) WalletPresenter.this.getUI()).Z1(true);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (WalletPresenter.this.f77625g) {
                ((b) WalletPresenter.this.getUI()).m0();
            }
            ((b) WalletPresenter.this.getUI()).n6(WalletPresenter.this.f77624f);
            ((b) WalletPresenter.this.getUI()).Z1(true);
        }

        public void onStart() {
            super.onStart();
            if (WalletPresenter.this.f77625g) {
                ((b) WalletPresenter.this.getUI()).showLoading();
            }
        }

        public void onNext(List<LegalDetailInfo> list) {
            super.onNext(list);
            boolean unused = WalletPresenter.this.f77625g = false;
            WalletPresenter.this.f77622d.clear();
            if (WalletPresenter.this.f77623e != null) {
                WalletPresenter.this.f77622d.add(WalletPresenter.this.f77623e);
            }
            ((b) WalletPresenter.this.getUI()).n6(WalletPresenter.this.f77624f);
            WalletPresenter.this.f77622d.addAll(list);
            WalletPresenter.this.f77621c.notifyDataSetChanged();
            ((b) WalletPresenter.this.getUI()).F0();
            ((b) WalletPresenter.this.getUI()).Z1(true);
        }
    }

    public interface b extends g {
        void F0();

        boolean O6();

        void Z1(boolean z11);

        void b(v9.a<s9.a> aVar);

        void m0();

        void n6(LegalDataTotal legalDataTotal);

        void showLoading();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List j0(LegalDataTotal legalDataTotal) {
        LegalDetailInfo legalDetailInfo;
        List<? extends BaseAssetInfo> detailInfos = legalDataTotal.getDetailInfos();
        legalDataTotal.setShow(((b) getUI()).O6());
        ArrayList arrayList = new ArrayList();
        Iterator<? extends BaseAssetInfo> it2 = detailInfos.iterator();
        while (it2.hasNext()) {
            LegalDetailInfo legalDetailInfo2 = (LegalDetailInfo) it2.next();
            legalDetailInfo2.setShow(((b) getUI()).O6());
            if ("usdt".equalsIgnoreCase(legalDetailInfo2.getCurrency())) {
                this.f77623e = legalDetailInfo2;
                legalDetailInfo2.setFirst(true);
            } else {
                arrayList.add(legalDetailInfo2);
            }
        }
        if (!arrayList.isEmpty() && (legalDetailInfo = (LegalDetailInfo) arrayList.get(0)) != null) {
            legalDetailInfo.setSecond(true);
        }
        this.f77624f = legalDataTotal;
        return arrayList;
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
            m0();
        } else if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void k0(boolean z11) {
        LegalDataTotal legalDataTotal = this.f77624f;
        if (legalDataTotal != null) {
            legalDataTotal.setShow(z11);
        }
        ((b) getUI()).n6(this.f77624f);
        for (s9.a next : this.f77622d) {
            if (next instanceof LegalDetailInfo) {
                ((LegalDetailInfo) next).setShow(z11);
            }
        }
        this.f77621c.notifyDataSetChanged();
    }

    /* renamed from: l0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        ArrayList arrayList = new ArrayList();
        this.f77622d = arrayList;
        this.f77621c = new v9.a<>(arrayList);
        ((b) getUI()).b(this.f77621c);
    }

    public void m0() {
        f.h().i(false).map(new tb.a(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(p6.a aVar) {
        if (getUI() != null && getActivity() != null && ((b) getUI()).isCanBeSeen()) {
            c.b().e(getActivity(), (Intent) null, new Intent(db.a.b().a()));
        }
    }
}
