package com.huobi.otc.persenter;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import java.util.ArrayList;
import java.util.List;
import jp.l;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.functions.Func1;

public class OtcCancelReasonPresenter extends ActivityPresenter<h> {

    /* renamed from: a  reason: collision with root package name */
    public String f78991a;

    /* renamed from: b  reason: collision with root package name */
    public OtcCancelReasonBean f78992b;

    /* renamed from: c  reason: collision with root package name */
    public OtcCancelReasonBean f78993c;

    /* renamed from: d  reason: collision with root package name */
    public String f78994d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f78995e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f78996f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public boolean f78997g;

    /* renamed from: h  reason: collision with root package name */
    public int f78998h;

    /* renamed from: i  reason: collision with root package name */
    public OtcOrderUnReadNumP f78999i;

    public class a extends OtcOrderUnReadNumP {
        public a() {
        }

        public String r() {
            return ((h) OtcCancelReasonPresenter.this.getUI()).R0();
        }

        public u6.g s() {
            return (u6.g) OtcCancelReasonPresenter.this.getUI();
        }

        public void v(int i11) {
            ((h) OtcCancelReasonPresenter.this.getUI()).o2(i11);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (OtcCancelReasonPresenter.this.getUI() != null && ((h) OtcCancelReasonPresenter.this.getUI()).isAlive()) {
                OtcCancelReasonPresenter.this.k0();
            }
        }
    }

    public class c extends EasySubscriber<OtcOrderDetailBean> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(OtcOrderDetailBean otcOrderDetailBean) {
            super.onNext(otcOrderDetailBean);
            OtcOrderDetailInfo coverData = OtcOrderDetailInfo.coverData(otcOrderDetailBean);
            if (coverData.getOrder() == null) {
                boolean unused = OtcCancelReasonPresenter.this.f78997g = false;
                OtcCancelReasonPresenter.this.j0();
                return;
            }
            int status = coverData.getOrder().getStatus();
            if (status == 0 || status == 1) {
                boolean unused2 = OtcCancelReasonPresenter.this.f78997g = false;
                OtcCancelReasonPresenter.this.j0();
                return;
            }
            if (OtcCancelReasonPresenter.this.getUI() != null && ((h) OtcCancelReasonPresenter.this.getUI()).isAlive()) {
                ((h) OtcCancelReasonPresenter.this.getUI()).finishActivity();
            }
            OtcCancelReasonPresenter.this.l0();
        }

        public void onError2(Throwable th2) {
            boolean unused = OtcCancelReasonPresenter.this.f78997g = false;
            OtcCancelReasonPresenter.this.j0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            boolean unused = OtcCancelReasonPresenter.this.f78997g = false;
            OtcCancelReasonPresenter.this.j0();
        }
    }

    public class d extends q6.d<List<s9.a>> {
        public d(u6.g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).ef(th2.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).ef(aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(List<s9.a> list) {
            super.onNext(list);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Tc(list);
            }
        }
    }

    public class e implements Func1<OTCStatusExtendResponse<List<OtcCancelReasonBean>>, List<s9.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f79004b;

        public e(String str) {
            this.f79004b = str;
        }

        /* renamed from: a */
        public List<s9.a> call(OTCStatusExtendResponse<List<OtcCancelReasonBean>> oTCStatusExtendResponse) {
            ArrayList arrayList = new ArrayList();
            OtcCancelReasonPresenter.this.V(arrayList, this.f79004b);
            if (oTCStatusExtendResponse != null) {
                OTCStatusExtendResponse.ExtendBean extend = oTCStatusExtendResponse.getExtend();
                int unused = OtcCancelReasonPresenter.this.f78998h = extend != null ? extend.getOrderCancelConsult() : 0;
                List<OtcCancelReasonBean> data = oTCStatusExtendResponse.getData();
                if (data != null && !data.isEmpty()) {
                    for (OtcCancelReasonBean otcCancelReasonBean : data) {
                        if (otcCancelReasonBean != null) {
                            OtcCancelReasonDataType otcCancelReasonDataType = new OtcCancelReasonDataType();
                            otcCancelReasonDataType.setDataBean(otcCancelReasonBean);
                            otcCancelReasonDataType.setOnReasonClickListener((OtcCancelReasonDataType.OnReasonClickListener) OtcCancelReasonPresenter.this.getUI());
                            arrayList.add(otcCancelReasonDataType);
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    public class f extends q6.d<Boolean> {
        public f(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Y1();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Xa(th2.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Xa(aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public class g extends q6.d<Boolean> {
        public g(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).j5();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Od(th2.getMessage());
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (OtcCancelReasonPresenter.this.getUI() != null) {
                ((h) OtcCancelReasonPresenter.this.getUI()).Od(aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public interface h extends u6.g, OtcCancelReasonDataType.OnReasonClickListener {
        void Dd(boolean z11);

        void Od(String str);

        String R0();

        void Tc(List<s9.a> list);

        void Va(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean);

        void Xa(String str);

        void Y1();

        void ef(String str);

        void finishActivity();

        void j5();

        void o2(int i11);

        void tb(OtcCancelReasonDataType otcCancelReasonDataType);
    }

    public OtcCancelReasonPresenter(String str) {
        this.f78991a = str;
    }

    public final void V(List<s9.a> list, String str) {
        OtcCancelReasonBean otcCancelReasonBean = new OtcCancelReasonBean();
        otcCancelReasonBean.setLocalHeader(true);
        otcCancelReasonBean.setTitle(str);
        OtcCancelReasonDataType otcCancelReasonDataType = new OtcCancelReasonDataType();
        otcCancelReasonDataType.setDataBean(otcCancelReasonBean);
        list.add(otcCancelReasonDataType);
    }

    public void W() {
        MapParamsBuilder b02 = b0();
        if (this.f78992b.getProofNeed() == 1 && !TextUtils.isEmpty(this.f78994d)) {
            b02.a("description", this.f78994d);
        }
        s8.a.a().cancelConsultCommit(b02.b()).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g((u6.g) getUI()));
    }

    public void X() {
        s8.a.a().h(b0().b()).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f((u6.g) getUI()));
    }

    public void Y(String str, String str2) {
        s8.a.a().getCancelReason(str).b().map(new e(str2)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d((u6.g) getUI()));
    }

    public String Z() {
        OtcCancelReasonBean otcCancelReasonBean = this.f78993c;
        if (otcCancelReasonBean == null) {
            otcCancelReasonBean = this.f78992b;
        }
        return otcCancelReasonBean.getTitle();
    }

    public String a0() {
        OtcCancelReasonBean otcCancelReasonBean = this.f78992b;
        if (otcCancelReasonBean == null) {
            return "";
        }
        if (otcCancelReasonBean.getProofNeed() == 1) {
            return "其他";
        }
        return this.f78992b.getCode();
    }

    public final MapParamsBuilder b0() {
        MapParamsBuilder c11 = MapParamsBuilder.c();
        c11.a("orderId", this.f78991a);
        c11.a("typeCode", this.f78992b.getCode());
        OtcCancelReasonBean otcCancelReasonBean = this.f78993c;
        if (otcCancelReasonBean != null) {
            c11.a("typeCodeSecond", otcCancelReasonBean.getCode());
        }
        return c11;
    }

    public boolean c0() {
        if (this.f78998h <= 0) {
            return false;
        }
        OtcCancelReasonBean otcCancelReasonBean = this.f78993c;
        if (otcCancelReasonBean == null) {
            OtcCancelReasonBean otcCancelReasonBean2 = this.f78992b;
            if (otcCancelReasonBean2 == null || otcCancelReasonBean2.getNegotiable() != 1) {
                return false;
            }
            return true;
        } else if (otcCancelReasonBean.getNegotiable() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public final void d0(List<s9.a> list, OtcCancelReasonDataType otcCancelReasonDataType) {
        OtcCancelReasonDataType otcCancelReasonDataType2;
        OtcCancelReasonBean dataBean;
        OtcCancelReasonBean dataBean2 = otcCancelReasonDataType.getDataBean();
        boolean z11 = true;
        dataBean2.setChecked(!dataBean2.isChecked());
        dataBean2.resetSecondReasonChecked();
        ((h) getUI()).tb(otcCancelReasonDataType);
        for (s9.a next : list) {
            if ((next instanceof OtcCancelReasonDataType) && (dataBean = otcCancelReasonDataType2.getDataBean()) != dataBean2 && dataBean.isChecked()) {
                dataBean.setChecked(false);
                ((h) getUI()).tb((otcCancelReasonDataType2 = (OtcCancelReasonDataType) next));
            }
        }
        if (dataBean2.isChecked()) {
            this.f78992b = dataBean2;
        }
        if (!dataBean2.isChecked()) {
            dataBean2 = null;
        }
        this.f78992b = dataBean2;
        this.f78993c = null;
        if (dataBean2 == null || !dataBean2.isChecked() || this.f78992b.hasSubset()) {
            z11 = false;
        }
        ((h) getUI()).Dd(z11);
    }

    public final void f0(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
        this.f78993c = otcCancelReasonBean;
        otcCancelReasonDataType.getDataBean().resetSecondReasonChecked();
        otcCancelReasonBean.setChecked(true);
        ((h) getUI()).Va(otcCancelReasonDataType, otcCancelReasonBean);
        ((h) getUI()).Dd(true);
    }

    public void g0(List<s9.a> list, OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
        if (otcCancelReasonBean == null) {
            d0(list, otcCancelReasonDataType);
        } else if (!otcCancelReasonBean.isChecked()) {
            f0(otcCancelReasonDataType, otcCancelReasonBean);
        }
    }

    public void h0(String str) {
        this.f78994d = str;
    }

    /* renamed from: i0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, h hVar) {
        super.onUIReady(baseCoreActivity, hVar);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        a aVar = new a();
        this.f78999i = aVar;
        aVar.k();
        Y(this.f78991a, baseCoreActivity.getResources().getString(R$string.n_otc_order_detail_ask_about_question));
        k0();
    }

    public final void j0() {
        if (!this.f78997g && getUI() != null && ((h) getUI()).isAlive()) {
            if (this.f78995e == null) {
                this.f78995e = new b();
            }
            l0();
            this.f78996f.postDelayed(this.f78995e, 5000);
        }
    }

    public void k0() {
        if (!this.f78997g) {
            this.f78997g = true;
            l.m(this.f78991a).retry(2).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
        }
    }

    public final void l0() {
        this.f78997g = false;
        this.f78996f.removeCallbacks(this.f78995e);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.f78999i.h();
    }

    public void onPause() {
        super.onPause();
        this.f78999i.i();
        l0();
    }

    public void onResume() {
        super.onResume();
        OtcOrderUnReadNumP otcOrderUnReadNumP = this.f78999i;
        if (otcOrderUnReadNumP != null) {
            otcOrderUnReadNumP.j();
        }
        j0();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((h) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            ((h) getUI()).finishActivity();
        }
    }
}
