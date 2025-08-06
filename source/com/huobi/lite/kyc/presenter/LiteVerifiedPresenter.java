package com.huobi.lite.kyc.presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.network.LiteRequestCallback1;
import jp.l;
import u6.g;

public class LiteVerifiedPresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f75384a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f75385b = new Handler();

    public class a extends LiteRequestCallback1<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75386a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75387b;

        public a(String str, String str2) {
            this.f75386a = str;
            this.f75387b = str2;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException.getErrCode().equals(String.valueOf(1007))) {
                ((c) LiteVerifiedPresenter.this.getUI()).ma(Integer.parseInt(aPIStatusErrorException.getErrCode()), aPIStatusErrorException.getErrMsg());
            } else if (!aPIStatusErrorException.getErrCode().equals(String.valueOf(1009))) {
                super.onFailed(aPIStatusErrorException);
            } else if (!this.f75386a.isEmpty() && !this.f75387b.isEmpty()) {
                LiteVerifiedPresenter.this.U("", "");
            }
        }

        public void onRequestFailure(Throwable th2) {
            if (LiteVerifiedPresenter.this.getUI() != null && ((c) LiteVerifiedPresenter.this.getUI()).isAlive()) {
                ((c) LiteVerifiedPresenter.this.getUI()).dismissProgressDialog();
            }
            super.onRequestFailure(th2);
        }

        public void onRequestStart() {
            ((c) LiteVerifiedPresenter.this.getUI()).showProgressDialog();
        }

        public void onRequestSuccess(String str) {
            if (LiteVerifiedPresenter.this.getUI() != null && ((c) LiteVerifiedPresenter.this.getUI()).isAlive()) {
                ((c) LiteVerifiedPresenter.this.getUI()).dismissProgressDialog();
                if (!TextUtils.isEmpty(str)) {
                    ((c) LiteVerifiedPresenter.this.getUI()).Xc(str);
                } else {
                    HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
                }
            }
        }
    }

    public class b extends LiteRequestCallback1<FaceVerifyPortalBean> {
        public b() {
        }

        /* renamed from: b */
        public void onRequestSuccess(FaceVerifyPortalBean faceVerifyPortalBean) {
            if (LiteVerifiedPresenter.this.getUI() != null && ((c) LiteVerifiedPresenter.this.getUI()).isAlive()) {
                ((c) LiteVerifiedPresenter.this.getUI()).dismissProgressDialog();
                ((c) LiteVerifiedPresenter.this.getUI()).Kf(faceVerifyPortalBean.getBizId());
                ((c) LiteVerifiedPresenter.this.getUI()).Xc(faceVerifyPortalBean.getVerifyToken());
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            if (LiteVerifiedPresenter.this.getUI() != null && ((c) LiteVerifiedPresenter.this.getUI()).isAlive()) {
                ((c) LiteVerifiedPresenter.this.getUI()).dismissProgressDialog();
                LiteVerifiedPresenter.this.getActivity().finish();
            }
        }

        public void onRequestStart() {
            ((c) LiteVerifiedPresenter.this.getUI()).showProgressDialog();
        }
    }

    public interface c extends g {
        boolean Ha();

        void Kf(String str);

        void Xc(String str);

        void ma(int i11, String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String T(FaceVerifyPortalBean faceVerifyPortalBean) {
        if (faceVerifyPortalBean == null || TextUtils.isEmpty(faceVerifyPortalBean.getVerifyToken()) || TextUtils.isEmpty(faceVerifyPortalBean.getBizId())) {
            return "";
        }
        ((c) getUI()).Kf(faceVerifyPortalBean.getBizId());
        return faceVerifyPortalBean.getVerifyToken();
    }

    public final void S() {
        l.D(this.f75384a ? "risk" : "senior", com.sumsub.sentry.a.f30241h, "").d(new b());
    }

    public void U(String str, String str2) {
        s8.a.a().loadLiteVerifyPortal(str, str2).b().map(new hn.a(this)).compose(RxJavaHelper.t((g) getUI())).subscribe(BaseEasySubscriber.e(new a(str, str2)));
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        this.f75384a = getActivity().getIntent().getBooleanExtra("OtcAliCertificateActivity.isRisk", false);
        if (((c) getUI()).Ha()) {
            S();
        }
    }
}
