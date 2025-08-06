package com.huobi.savings.mining.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.MiningDetailBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import u6.g;

public class MiningDetailPresenter extends ActivityPresenter<e> {

    /* renamed from: a  reason: collision with root package name */
    public String f80688a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f80689b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80690c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f80691d = false;

    public class a extends EasySubscriber<MiningDetailBean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(MiningDetailBean miningDetailBean) {
            super.onNext(miningDetailBean);
            ((e) MiningDetailPresenter.this.getUI()).ne(miningDetailBean);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((e) MiningDetailPresenter.this.getUI()).ne((MiningDetailBean) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((e) MiningDetailPresenter.this.getUI()).ne((MiningDetailBean) null);
        }
    }

    public class b extends EasySubscriber<Object> {
        public b() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MiningDetailPresenter.this.X(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MiningDetailPresenter.this.X(false);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            MiningDetailPresenter.this.X(true);
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f80694b;

        public c(int i11) {
            this.f80694b = i11;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MiningDetailPresenter.this.Y(false, this.f80694b);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MiningDetailPresenter.this.Y(false, this.f80694b);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            MiningDetailPresenter.this.Y(true, this.f80694b);
        }
    }

    public class d extends EasySubscriber<String> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            MiningDetailPresenter.this.W(true, str);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MiningDetailPresenter.this.W(false, (String) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MiningDetailPresenter.this.W(false, (String) null);
        }
    }

    public interface e extends g {
        void Fg(boolean z11, String str);

        void T1();

        void ib(boolean z11, int i11);

        void ne(MiningDetailBean miningDetailBean);

        void ue(boolean z11);
    }

    public void T(String str, boolean z11) {
        if (!this.f80689b) {
            this.f80689b = true;
            v7.b.a().V(str, z11 ? 1 : 0).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        }
    }

    public void U(String str) {
        if (!this.f80691d) {
            this.f80691d = true;
            v7.b.a().H0(str).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
        }
    }

    public void V(String str, int i11) {
        if (!this.f80690c) {
            this.f80690c = true;
            v7.b.a().Y(str, i11).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new c(i11));
        }
    }

    public final void W(boolean z11, String str) {
        this.f80691d = false;
        ((e) getUI()).Fg(z11, str);
    }

    public final void X(boolean z11) {
        this.f80689b = false;
        ((e) getUI()).ue(z11);
    }

    public final void Y(boolean z11, int i11) {
        this.f80690c = false;
        ((e) getUI()).ib(z11, i11);
    }

    /* renamed from: Z */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        this.f80688a = baseCoreActivity.getIntent().getStringExtra("orderId");
        eVar.T1();
    }

    public void a0() {
        v7.b.a().getMiningDetailInfo(this.f80688a).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }
}
