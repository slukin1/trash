package com.huobi.otc.persenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserOtcCoupon;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.module.otc.OtcModuleConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import q6.d;
import u6.g;

public class OtcCertificationResultPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public UserOtcCoupon f79014a;

    public class a extends d<UserOtcCoupon> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(UserOtcCoupon userOtcCoupon) {
            super.onNext(userOtcCoupon);
            UserOtcCoupon unused = OtcCertificationResultPresenter.this.f79014a = userOtcCoupon;
        }

        public void onAfter() {
            super.onAfter();
            ((b) OtcCertificationResultPresenter.this.getUI()).l3();
        }
    }

    public interface b extends g {
        void l3();
    }

    public int R(long j11, long j12) {
        return (int) ((V(j11) - V(j12)) / Period.DAY_MILLS);
    }

    public void S() {
        if (OtcModuleConfig.a().e0()) {
            v7.b.a().getCouponUserOtc().b().timeout(2, TimeUnit.SECONDS).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
        }
    }

    public UserOtcCoupon T() {
        return this.f79014a;
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        S();
    }

    public long V(long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(new Date(j11))).getTime();
        } catch (ParseException e11) {
            e11.printStackTrace();
            return 0;
        }
    }
}
