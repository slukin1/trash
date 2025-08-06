package com.huobi.account.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.FaceVerifyPortalBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.lite.kyc.aliface.AbstractAliCertificateResult;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.lite.kyc.aliface.a;
import i6.d;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import u6.g;
import ug.g2;
import ug.h2;

public class VerificationStartPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f41107a;

    public class a extends AbstractAliCertificateResult {
        public a() {
        }

        public void a() {
        }
    }

    public interface b extends g {
        void c6(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(UserVO userVO) {
        d.j("QR-SCAN", "OTCHelper.getUser success.");
        if (userVO.getRealBind() > 0) {
            T();
        } else {
            HuobiToastUtil.j(R.string.network_busy);
        }
    }

    public final void T() {
        d.j("QR-SCAN", "loadVerifyPortal");
        l.D("coin", com.sumsub.sentry.a.f30241h, this.f41107a).b().compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new g2(this)));
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        this.f41107a = baseCoreActivity.getIntent().getStringExtra("tsvToken");
        ((b) getUI()).c6(baseCoreActivity.getIntent().getStringExtra("tsvMsg"));
    }

    public final void V(FaceVerifyPortalBean faceVerifyPortalBean) {
        d.j("QR-SCAN", "loadVerifyPortal success. faceVerifyPortalBean" + faceVerifyPortalBean.toString());
        getActivity().finish();
        new a.b(getActivity()).k(faceVerifyPortalBean.getBizId()).m(faceVerifyPortalBean.getVerifyToken()).j(new AliFaceCertificate()).l(new a()).e().a();
    }

    public void W() {
        l.q(false).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new h2(this)));
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        c.i().f(getActivity());
        getActivity().finish();
    }
}
