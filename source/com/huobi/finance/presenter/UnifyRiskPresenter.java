package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.api.RiskService;
import com.huobi.finance.bean.ExamInfo;
import com.huobi.lite.kyc.aliface.AbstractAliCertificateResult;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.lite.kyc.aliface.a;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;
import u6.g;

public class UnifyRiskPresenter extends ActivityPresenter<f> {

    /* renamed from: a  reason: collision with root package name */
    public long f45677a;

    /* renamed from: b  reason: collision with root package name */
    public int f45678b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f45679c;

    /* renamed from: d  reason: collision with root package name */
    public RiskActionData f45680d = new RiskActionData();

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f45681e = new ArrayList();

    public class a extends EasySubscriber<RiskActionData> {

        /* renamed from: com.huobi.finance.presenter.UnifyRiskPresenter$a$a  reason: collision with other inner class name */
        public class C0570a implements Comparator<RiskActionData.ActionsBean> {
            public C0570a() {
            }

            /* renamed from: a */
            public int compare(RiskActionData.ActionsBean actionsBean, RiskActionData.ActionsBean actionsBean2) {
                return actionsBean2.getActionstate() - actionsBean.getActionstate();
            }
        }

        public a() {
        }

        /* renamed from: a */
        public void onNext(RiskActionData riskActionData) {
            super.onNext(riskActionData);
            if (!CollectionsUtils.b(riskActionData.getActions())) {
                Collections.sort(riskActionData.getActions(), new C0570a());
            }
            RiskActionData unused = UnifyRiskPresenter.this.f45680d = riskActionData;
            ((f) UnifyRiskPresenter.this.getUI()).F0();
            UnifyRiskPresenter unifyRiskPresenter = UnifyRiskPresenter.this;
            List unused2 = unifyRiskPresenter.f45681e = unifyRiskPresenter.a0(unifyRiskPresenter.f45680d.getActions());
            ((f) UnifyRiskPresenter.this.getUI()).l6(UnifyRiskPresenter.this.f45680d);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((f) UnifyRiskPresenter.this.getUI()).m0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((f) UnifyRiskPresenter.this.getUI()).m0();
        }

        public void onStart() {
            super.onStart();
            ((f) UnifyRiskPresenter.this.getUI()).showLoading();
        }
    }

    public class b implements Func1<Boolean, Observable<StringStatusResponse<RiskActionData>>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<StringStatusResponse<RiskActionData>> call(Boolean bool) {
            return UnifyRiskPresenter.this.c0();
        }
    }

    public class c implements Func1<Boolean, Observable<Boolean>> {
        public c() {
        }

        /* renamed from: a */
        public Observable<Boolean> call(Boolean bool) {
            if (bool.booleanValue()) {
                return Observable.just(Boolean.TRUE).delay((long) com.sumsub.sns.internal.ml.autocapture.a.f34923p, TimeUnit.MILLISECONDS);
            }
            return Observable.just(Boolean.FALSE);
        }
    }

    public class d extends RequestCallback1<FaceVerifyPortalBean> {

        public class a extends AbstractAliCertificateResult {
            public a() {
            }

            public void a() {
            }
        }

        public d() {
        }

        /* renamed from: a */
        public void onRequestSuccess(FaceVerifyPortalBean faceVerifyPortalBean) {
            new a.b(UnifyRiskPresenter.this.getActivity()).k(faceVerifyPortalBean.getBizId()).m(faceVerifyPortalBean.getVerifyToken()).j(new AliFaceCertificate()).l(new a()).e().a();
        }

        public void onRequestFailure(Throwable th2) {
            ((f) UnifyRiskPresenter.this.getUI()).b7(false, th2.toString());
        }
    }

    public class e extends EasySubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExamInfo f45688b;

        public e(ExamInfo examInfo) {
            this.f45688b = examInfo;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (l11.longValue() < 0 || !((f) UnifyRiskPresenter.this.getUI()).isAlive()) {
                unsubscribe();
                return;
            }
            this.f45688b.setCountDown(l11.longValue());
            ((f) UnifyRiskPresenter.this.getUI()).rd(this.f45688b);
        }
    }

    public interface f extends g {
        void F0();

        void b7(boolean z11, String str);

        void l6(RiskActionData riskActionData);

        void m0();

        void rd(ExamInfo examInfo);

        void showLoading();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(APIStatusErrorException aPIStatusErrorException) {
        ((f) getUI()).m0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(Throwable th2) {
        ((f) getUI()).m0();
    }

    public final List<Integer> a0(List<RiskActionData.ActionsBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            arrayList.add(0);
            return arrayList;
        }
        for (RiskActionData.ActionsBean next : list) {
            if (next.getActiontype() == 3) {
                arrayList.add(3);
            } else if (next.getActiontype() == 4 || next.getActiontype() == 5 || next.getActiontype() == 8) {
                String[] split = next.getActionway().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if ("1".equals(split[0])) {
                    arrayList.add(1);
                } else if ("2".equals(split[0])) {
                    arrayList.add(2);
                }
            } else if (next.getActiontype() == 10) {
                arrayList.add(4);
            } else {
                arrayList.add(-1);
            }
        }
        arrayList.add(0);
        return arrayList;
    }

    public void b0() {
        HashMap hashMap = new HashMap();
        hashMap.put("tsvToken", this.f45680d.getActiontoken());
        hashMap.put("uid", r.x().s());
        ((RiskService) p.Y(RiskService.class)).getTsvExamMsg(hashMap).compose(p.Z()).map(t7.f46121b).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new q7(this), new p7(this), new r7(this)));
    }

    public Observable<StringStatusResponse<RiskActionData>> c0() {
        return ((FinanceService) p.W(FinanceService.class)).getRiskActions(this.f45677a, this.f45678b);
    }

    public Observable<RiskActionData> d0(boolean z11) {
        return Observable.just(Boolean.valueOf(z11)).flatMap(new c()).flatMap(new b()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI()));
    }

    public Subscription f0() {
        return c0().compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public List<Integer> g0() {
        return this.f45681e;
    }

    /* renamed from: m0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        q0(baseCoreActivity);
        this.f45679c = f0();
    }

    /* renamed from: n0 */
    public void i0(ExamInfo examInfo) {
        Observable.interval(0, 1, TimeUnit.SECONDS).map(new s7(examInfo)).compose(RxJavaHelper.u((g) getUI(), Schedulers.computation())).subscribe(new e(examInfo));
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.f45679c;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f45679c.unsubscribe();
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((f) getUI()).isAlive()) {
            rn.c.i().m(getActivity(), new JumpTarget(k0.c(getActivity()), k0.h(getActivity())));
            getActivity().finish();
        }
    }

    public Observable<Object> p0() {
        HashMap hashMap = new HashMap();
        hashMap.put("tsvToken", this.f45680d.getActiontoken());
        return ((RiskService) p.Y(RiskService.class)).resendTsvMessage(hashMap).compose(p.Z()).compose(RxJavaHelper.t((g) getUI()));
    }

    public void q0(BaseCoreActivity baseCoreActivity) {
        this.f45677a = baseCoreActivity.getIntent().getLongExtra("ORDER_ID", -1);
        this.f45678b = baseCoreActivity.getIntent().getIntExtra("ORDER_TYPE", 0);
        if (this.f45677a == -1) {
            baseCoreActivity.finish();
        }
    }

    public void r0() {
        l.D("coin", com.sumsub.sentry.a.f30241h, this.f45680d.getActiontoken()).d(new d());
    }

    public Observable<StringStatusResponse<Object>> s0() {
        return ((FinanceService) p.W(FinanceService.class)).syncStateAfterRiskAction(this.f45680d.getOrderid()).compose(RxJavaHelper.t((g) getUI()));
    }
}
