package com.huobi.login.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.utils.i0;
import gs.e;
import i6.i;
import i6.k;
import java.util.Map;
import k20.h;
import nn.m;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import sn.f;
import sn.l;
import tg.r;
import u6.g;

public class FingerprintPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public kn.a f75455a;

    /* renamed from: b  reason: collision with root package name */
    public String f75456b;

    /* renamed from: c  reason: collision with root package name */
    public JumpTarget f75457c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f75458d;

    public class a extends EasySubscriber<UserInfoData> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            FingerprintPresenter.this.getActivity().finish();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            ((b) FingerprintPresenter.this.getUI()).dismissProgressDialog();
            if (r.x().X()) {
                c.i().A(FingerprintPresenter.this.getActivity(), FingerprintPresenter.this.f75455a);
            } else {
                f.e(FingerprintPresenter.this.getActivity(), FingerprintPresenter.this.f75455a);
            }
            i.b().g(new m(this), 500);
        }

        /* renamed from: e */
        public void onNext(UserInfoData userInfoData) {
            super.onNext(userInfoData);
            ConfigPreferences.k("user_config", FingerprintPresenter.this.f75456b + "_" + "config_gesture_error_num", 0);
            is.a.q("000002", (Map<String, Object>) null);
            i0.a(FingerprintPresenter.this.getActivity(), "FINGERPRINT");
            l.h(FingerprintPresenter.this.getActivity(), false, new nn.l(this));
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.g("LOGIN", "handlerPasswordRight has error", th2);
            ((b) FingerprintPresenter.this.getUI()).h6();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.g("LOGIN", "handlerPasswordRight failed", aPIStatusErrorException);
            ((b) FingerprintPresenter.this.getUI()).dismissProgressDialog();
            if (!"token_failure".equals(aPIStatusErrorException.getErrCode()) && !"512".equals(aPIStatusErrorException.getErrCode())) {
                ((b) FingerprintPresenter.this.getUI()).h6();
            } else if (FingerprintPresenter.this.f75458d) {
                boolean unused = FingerprintPresenter.this.f75458d = false;
                FingerprintPresenter.this.d0(ConfigPreferences.e("user_config", "config_email", ""));
            }
        }
    }

    public interface b extends g {
        void ga();

        void h6();
    }

    public void a0() {
        c.i().v(this.f75457c, getActivity());
    }

    public void b0() {
        i.b().g(new nn.k(this), 100);
    }

    /* renamed from: c0 */
    public void f0() {
        ((b) getUI()).showProgressDialog();
        r.x().e0();
        r.x().O(false).compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public void d0(String str) {
        Intent j11 = c.i().j(getActivity());
        j11.putExtra("login_name", str);
        f.c(j11, this.f75455a);
        getActivity().startActivity(j11);
        getActivity().finish();
    }

    /* renamed from: g0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        this.f75458d = true;
        EventBus.d().p(this);
        Intent intent = baseCoreActivity.getIntent();
        if (!(intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("target"))) {
            kn.a aVar = (kn.a) intent.getExtras().get("target");
            this.f75455a = aVar;
            if (aVar instanceof JumpTarget) {
                this.f75457c = (JumpTarget) aVar;
            }
        }
        this.f75456b = r.x().s();
        e.b().c("PM_LOGIN_SUCCESS");
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (this.f75458d) {
            this.f75458d = false;
            ((b) getUI()).ga();
            Intent j11 = c.i().j(getActivity());
            f.c(j11, this.f75455a);
            getActivity().startActivity(j11);
            getActivity().finish();
        }
    }
}
