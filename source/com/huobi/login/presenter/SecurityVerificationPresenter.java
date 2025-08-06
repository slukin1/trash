package com.huobi.login.presenter;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.controller.AuthUIBackPressProxy;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.utils.GestureUtil;
import com.huobi.utils.i0;
import com.huobi.utils.k0;
import gs.e;
import i6.i;
import i6.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import k20.h;
import nn.i1;
import nn.j1;
import nn.k1;
import nn.l1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import sn.f;
import sn.l;
import tg.r;
import u6.g;

public class SecurityVerificationPresenter extends ActivityPresenter<c> {

    /* renamed from: a  reason: collision with root package name */
    public kn.a f75497a;

    /* renamed from: b  reason: collision with root package name */
    public int f75498b;

    /* renamed from: c  reason: collision with root package name */
    public String f75499c;

    /* renamed from: d  reason: collision with root package name */
    public String f75500d;

    /* renamed from: e  reason: collision with root package name */
    public String f75501e;

    /* renamed from: f  reason: collision with root package name */
    public AuthUIBackPressProxy f75502f = new AuthUIBackPressProxy();

    /* renamed from: g  reason: collision with root package name */
    public JumpTarget f75503g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f75504h;

    public class a extends EasySubscriber<UserInfoData> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            SecurityVerificationPresenter.this.getActivity().finish();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            ((c) SecurityVerificationPresenter.this.getUI()).dismissProgressDialog();
            if (r.x().X()) {
                rn.c.i().A(SecurityVerificationPresenter.this.getActivity(), SecurityVerificationPresenter.this.f75497a);
            } else {
                f.e(SecurityVerificationPresenter.this.getActivity(), SecurityVerificationPresenter.this.f75497a);
            }
            i.b().g(new l1(this), 500);
        }

        /* renamed from: e */
        public void onNext(UserInfoData userInfoData) {
            super.onNext(userInfoData);
            ConfigPreferences.k("user_config", SecurityVerificationPresenter.this.f75499c + "_" + "config_gesture_error_num", 0);
            is.a.q("000001", (Map<String, Object>) null);
            i0.a(SecurityVerificationPresenter.this.getActivity(), "GESTURE");
            l.h(SecurityVerificationPresenter.this.getActivity(), false, new k1(this));
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            k.g("LOGIN", "handlerPasswordRight has error", th2);
            ((c) SecurityVerificationPresenter.this.getUI()).a6();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            k.g("LOGIN", "handlerPasswordRight failed", aPIStatusErrorException);
            if ("token_failure".equals(aPIStatusErrorException.getErrCode()) || "512".equals(aPIStatusErrorException.getErrCode())) {
                ((c) SecurityVerificationPresenter.this.getUI()).dismissProgressDialog();
                if (SecurityVerificationPresenter.this.f75504h) {
                    boolean unused = SecurityVerificationPresenter.this.f75504h = false;
                    SecurityVerificationPresenter.this.j0();
                    return;
                }
                return;
            }
            ((c) SecurityVerificationPresenter.this.getUI()).a6();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            SecurityVerificationPresenter.this.d0();
        }
    }

    public interface c extends g {
        void Ga(String str);

        void N8(boolean z11);

        boolean Wa();

        void a6();

        void ja(String str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0() {
        ((c) getUI()).a6();
    }

    public void b0() {
        if (!this.f75502f.a(getActivity())) {
            rn.c.i().v(this.f75503g, getActivity());
        }
    }

    public void c0(String str) {
        if (!TextUtils.isEmpty(this.f75500d)) {
            g0(this.f75500d, str);
        }
    }

    public void d0() {
        GestureUtil.a();
        ConfigPreferences.k("user_config", this.f75499c + "_" + "config_gesture_error_num", 0);
        r x11 = r.x();
        x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", false);
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }

    /* renamed from: f0 */
    public void h0() {
        ((c) getUI()).showProgressDialog();
        r.x().e0();
        r.x().O(false).compose(RxJavaHelper.t((g) getUI())).retry(1).subscribe(new a());
    }

    public final void g0(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (GestureUtil.d(str, str2)) {
            if (((c) getUI()).Wa()) {
                getActivity().setResult(-1);
                getActivity().finish();
            } else {
                i.b().g(new i1(this), 100);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("unlock_type", "Gesture");
            hashMap.put("is_success", Boolean.TRUE);
            gs.g.i("unlock_result", hashMap);
            return;
        }
        l0();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("unlock_type", "Gesture");
        hashMap2.put("is_success", Boolean.FALSE);
        gs.g.i("unlock_result", hashMap2);
    }

    public void j0() {
        r x11 = r.x();
        x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", false);
        Intent j11 = rn.c.i().j(getActivity());
        kn.a aVar = this.f75497a;
        if (aVar != null) {
            f.c(j11, aVar);
        }
        getActivity().startActivity(j11);
        getActivity().finish();
    }

    /* renamed from: k0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        this.f75504h = true;
        EventBus.d().p(this);
        Intent intent = baseCoreActivity.getIntent();
        if (!(intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("target"))) {
            kn.a aVar = (kn.a) intent.getExtras().get("target");
            this.f75497a = aVar;
            if (aVar instanceof JumpTarget) {
                this.f75503g = (JumpTarget) aVar;
            }
        }
        this.f75499c = r.x().s();
        this.f75498b = ConfigPreferences.g("user_config", this.f75499c + "_" + "config_gesture_error_num", 0);
        this.f75500d = ConfigPreferences.e("user_config", this.f75499c + "_" + "config_gesture", "");
        this.f75501e = ConfigPreferences.e("user_config", "config_email", "");
        ((c) getUI()).ja(StringUtils.u(this.f75501e));
        ((c) getUI()).N8(this.f75502f.b());
        e.b().c("PM_LOGIN_SUCCESS");
    }

    public void l0() {
        int i11 = this.f75498b + 1;
        this.f75498b = i11;
        if (i11 >= 5) {
            new Handler().postDelayed(new b(), 1000);
            ((c) getUI()).Ga(getResources().getString(R.string.draw_gesture_error_clear_login));
            return;
        }
        ConfigPreferences.k("user_config", this.f75499c + "_" + "config_gesture_error_num", this.f75498b);
        Locale locale = Locale.US;
        String string = getResources().getString(R.string.draw_gesture_left_chances);
        ((c) getUI()).Ga(String.format(locale, string, new Object[]{(5 - this.f75498b) + ""}));
        new Handler().postDelayed(new j1(this), 1000);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (this.f75504h) {
            this.f75504h = false;
            Intent j11 = rn.c.i().j(getActivity());
            f.c(j11, this.f75497a);
            getActivity().startActivity(j11);
            getActivity().finish();
        }
    }
}
