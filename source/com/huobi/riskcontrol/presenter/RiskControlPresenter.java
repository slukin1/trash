package com.huobi.riskcontrol.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.lite.kyc.aliface.AbstractAliCertificateResult;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.lite.kyc.aliface.a;
import com.huobi.login.usercenter.data.source.bean.TsvTokenWrapper;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import jp.l;
import pro.huobi.R;
import q6.d;
import u6.g;

public class RiskControlPresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public SecurityVerifyParam f80669a;

    public class a extends d<TsvTokenWrapper> {
        public a(g gVar) {
            super(gVar);
        }

        public final boolean f(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException.getData() == null || !(aPIStatusErrorException.getData() instanceof p9.a)) {
                return false;
            }
            String tsvToken = ((p9.a) aPIStatusErrorException.getData()).getTsvToken();
            if (TextUtils.isEmpty(tsvToken) || !tsvToken.equals(RiskControlPresenter.this.f80669a.getTsvToken())) {
                return false;
            }
            HuobiToastUtil.j(R.string.don_not_finish_verify);
            return true;
        }

        /* renamed from: g */
        public void onNext(TsvTokenWrapper tsvTokenWrapper) {
            super.onNext(tsvTokenWrapper);
            ((c) RiskControlPresenter.this.getUI()).E4();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((c) RiskControlPresenter.this.getUI()).cc();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!f(aPIStatusErrorException)) {
                super.onFailed(aPIStatusErrorException);
                ((c) RiskControlPresenter.this.getUI()).cc();
            }
        }
    }

    public class b extends AbstractAliCertificateResult {
        public b() {
        }

        public void a() {
        }
    }

    public interface c extends g {
        void E4();

        void cc();

        SecurityVerifyParam kc();
    }

    public void S(String str) {
        l.D("coin", com.sumsub.sentry.a.f30241h, str).b().compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new vq.a(this)));
    }

    public final d<TsvTokenWrapper> T() {
        return new a((g) getUI());
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        this.f80669a = ((c) getUI()).kc();
    }

    public void V(Boolean bool) {
        UserCenterRemoteDataSource.A().z0(this.f80669a.getTsvToken(), bool).compose(RxJavaHelper.t((g) getUI())).subscribe(T());
    }

    public void W(Boolean bool) {
        if (this.f80669a.isResetPassword()) {
            V(bool);
        } else {
            X(bool);
        }
    }

    public void X(Boolean bool) {
        String str;
        String str2 = "";
        if (this.f80669a.getRiskOperate() == null) {
            str = str2;
        } else {
            str = this.f80669a.getRiskOperate().name();
        }
        if (this.f80669a.getScene() != null) {
            str2 = this.f80669a.getScene().name();
        }
        UserCenterRemoteDataSource.A().A0(this.f80669a.getTsvToken(), str, str2, bool).compose(RxJavaHelper.t((g) getUI())).subscribe(T());
    }

    public final void Y(FaceVerifyPortalBean faceVerifyPortalBean) {
        i6.d.j("QR-SCAN", "loadVerifyPortal success. faceVerifyPortalBean" + faceVerifyPortalBean.toString());
        new a.b(getActivity()).k(faceVerifyPortalBean.getBizId()).m(faceVerifyPortalBean.getVerifyToken()).j(new AliFaceCertificate()).l(new b()).e().a();
    }
}
