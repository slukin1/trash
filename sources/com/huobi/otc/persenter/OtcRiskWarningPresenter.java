package com.huobi.otc.persenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.OtcTermsUrlBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.otc.OtcModuleConfig;
import java.text.MessageFormat;
import u6.g;

public class OtcRiskWarningPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f79123a = "https://c2c.huobi.so/app/agreement/{0}/index.html";

    public class a extends EasySubscriber<OtcTermsUrlBean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(OtcTermsUrlBean otcTermsUrlBean) {
            super.onNext(otcTermsUrlBean);
            String unused = OtcRiskWarningPresenter.this.f79123a = (otcTermsUrlBean == null || TextUtils.isEmpty(otcTermsUrlBean.getOtcTermsUrl())) ? "https://c2c.huobi.so/app/agreement/{0}/index.html" : otcTermsUrlBean.getOtcTermsUrl();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public interface b extends g {
    }

    public final void R() {
        s8.a.a().getOtcTermsUrl().b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public String S() {
        return MessageFormat.format(this.f79123a, new Object[]{OtcModuleConfig.a().b0()});
    }

    /* renamed from: T */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        R();
    }
}
