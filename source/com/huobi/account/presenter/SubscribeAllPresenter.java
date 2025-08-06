package com.huobi.account.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.SubscribeAll;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.util.ArrayList;
import java.util.List;
import pg.c;
import pro.huobi.R;
import u6.g;

public class SubscribeAllPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public final List<c> f41097a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f41098b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f41099c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final String f41100d = "All";

    public class a extends BaseSubscriber<SubscribeAll> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(SubscribeAll subscribeAll) {
            super.onNext(subscribeAll);
            SubscribeAllPresenter.this.f41097a.clear();
            SubscribeAllPresenter.this.f41099c.clear();
            SubscribeAllPresenter.this.f41099c.add("All");
            SubscribeAllPresenter.this.a0(subscribeAll);
            ((b) SubscribeAllPresenter.this.getUI()).Ke(SubscribeAllPresenter.this.f41099c, SubscribeAllPresenter.this.f41098b);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            SubscribeAllPresenter.this.f41097a.clear();
            SubscribeAllPresenter.this.f41099c.clear();
            SubscribeAllPresenter.this.f41098b.clear();
            ((b) SubscribeAllPresenter.this.getUI()).Ke(SubscribeAllPresenter.this.f41099c, SubscribeAllPresenter.this.f41098b);
        }
    }

    public interface b extends g {
        void Ke(List<String> list, List<c> list2);

        void W7(List<c> list);
    }

    public static String U(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    public final String V(long j11, long j12, boolean z11) {
        boolean X = X(j11 + Period.DAY_MILLS, j12);
        if (z11) {
            return getString(R.string.n_im_time_today);
        }
        if (X) {
            return getString(R.string.n_im_time_tomorrow);
        }
        return DateTimeUtils.h(j12, "M-d");
    }

    public List<String> W() {
        return this.f41099c;
    }

    public final boolean X(long j11, long j12) {
        return U(j11).equals(U(j12));
    }

    public void Y() {
        v7.b.a().h0(1).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public final c Z(long j11, long j12, long j13) {
        c cVar = new c((SubscribeAll.ListBean) null);
        boolean X = X(j11, j13);
        cVar.q(V(j11, j13, X));
        cVar.p(DateTimeUtils.A(j13));
        cVar.s(X);
        cVar.o(j12 == 0);
        return cVar;
    }

    public final void a0(SubscribeAll subscribeAll) {
        this.f41098b.clear();
        long currentTimeMillis = System.currentTimeMillis() + 5000;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = 0;
        for (int i11 = 0; i11 < subscribeAll.getList().size(); i11++) {
            SubscribeAll.ListBean listBean = subscribeAll.getList().get(i11);
            String title = listBean.getTitle();
            if (!TextUtils.isEmpty(title) && !this.f41099c.contains(title)) {
                this.f41099c.add(title);
            }
            long countDown = listBean.getCountDown() + currentTimeMillis;
            if (!X(j11, countDown)) {
                if (this.f41098b.size() > 0) {
                    List<c> list = this.f41098b;
                    list.get(list.size() - 1).r(true);
                }
                this.f41098b.add(Z(currentTimeMillis, j11, countDown));
                j11 = countDown;
            }
            c cVar = new c(listBean);
            cVar.r(false);
            this.f41098b.add(cVar);
            this.f41097a.add(cVar);
            cVar.n(elapsedRealtime);
        }
        if (this.f41098b.size() > 0) {
            List<c> list2 = this.f41098b;
            list2.get(list2.size() - 1).r(true);
        }
    }

    public final void b0(String str) {
        this.f41098b.clear();
        long currentTimeMillis = System.currentTimeMillis() + 5000;
        long j11 = 0;
        for (int i11 = 0; i11 < this.f41097a.size(); i11++) {
            c cVar = this.f41097a.get(i11);
            String i12 = cVar.i();
            if ("All".equals(str) || str.equals(i12)) {
                long d11 = cVar.d() + currentTimeMillis;
                if (!X(j11, d11)) {
                    if (this.f41098b.size() > 0) {
                        List<c> list = this.f41098b;
                        list.get(list.size() - 1).r(true);
                    }
                    this.f41098b.add(Z(currentTimeMillis, j11, d11));
                    j11 = d11;
                }
                cVar.r(false);
                this.f41098b.add(cVar);
            }
        }
        if (this.f41098b.size() > 0) {
            List<c> list2 = this.f41098b;
            list2.get(list2.size() - 1).r(true);
        }
    }

    public void c0(int i11) {
        b0(W().get(i11));
        ((b) getUI()).W7(this.f41098b);
    }

    /* renamed from: d0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }
}
