package com.huobi.tradenew.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import i6.i;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import st.b1;
import st.c1;
import tg.r;
import tq.p;
import u6.g;

public class ZoneReminderPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public String f82999a;

    public interface a extends g {
        void Z(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(Object obj) {
        i.b().g(new b1(this), 50);
    }

    public void S() {
        if (r.x().F0()) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.f82999a);
            UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new c1(this)));
            return;
        }
        getActivity().finish();
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f82999a = intent.getStringExtra("zone_reminder_type");
            ((a) getUI()).Z(this.f82999a);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        getActivity().finish();
    }
}
