package com.huobi.login.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.bean.SecurityVerifyBean;
import com.huobi.login.ui.SetForgetPswActivity;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.ImageUtils;
import i6.m;
import java.util.HashMap;
import java.util.Map;
import nn.n;
import nn.o;
import nn.q;
import nn.r;
import nn.s;
import nn.t;
import nn.u;
import nn.v;
import nn.w;
import pro.huobi.R;
import tq.p;
import u6.g;

public class ForgetPasswordPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f75460a;

    /* renamed from: b  reason: collision with root package name */
    public kn.a f75461b;

    /* renamed from: c  reason: collision with root package name */
    public JumpTarget f75462c;

    /* renamed from: d  reason: collision with root package name */
    public int f75463d;

    /* renamed from: e  reason: collision with root package name */
    public String f75464e;

    /* renamed from: f  reason: collision with root package name */
    public String f75465f;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            ((b) ForgetPasswordPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((b) ForgetPasswordPresenter.this.getUI()).G0();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((b) ForgetPasswordPresenter.this.getUI()).G0();
            try {
                m.k0(aPIStatusErrorException.getErrCode());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            ((b) ForgetPasswordPresenter.this.getUI()).q1(aPIStatusErrorException.getErrMsg());
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((b) ForgetPasswordPresenter.this.getUI()).r2();
            ((b) ForgetPasswordPresenter.this.getUI()).G0();
            ((b) ForgetPasswordPresenter.this.getUI()).K0();
        }

        public void onStart() {
            super.onStart();
        }
    }

    public interface b extends g {
        void G0();

        void K0();

        void Lg(String str, String str2);

        void Q0(Bitmap bitmap);

        void S5(String str);

        void Sg(String str, RiskControl riskControl);

        void h4();

        void q1(String str);

        void r2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(ImgCaptchaData imgCaptchaData) {
        this.f75460a = imgCaptchaData.getKey();
        ((b) getUI()).Q0(ImageUtils.i(imgCaptchaData.getImage()));
    }

    public static /* synthetic */ void c0() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(String str, ImgCaptchaData imgCaptchaData) {
        this.f75460a = imgCaptchaData.getKey();
        ((b) getUI()).Lg(imgCaptchaData.getImage(), str);
    }

    public static /* synthetic */ void f0(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void g0(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0() {
        ((b) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(String str, RiskControl riskControl) {
        if (riskControl.getRisk() <= 0) {
            ((b) getUI()).S5(str);
        } else if (riskControl.getRisk() == 1) {
            HuobiToastUtil.m(getResources().getString(R.string.n_user_center_risk_tips));
            ((b) getUI()).G0();
        } else {
            ((b) getUI()).Sg(str, riskControl);
            if (riskControl.getItems() == null || riskControl.getItems().isEmpty() || riskControl.getItems().get(0).getType() != 0) {
                ((b) getUI()).Sg(str, riskControl);
            } else {
                UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(o.f58637b, new t(this, str), v.f58668b, w.f58672b, new n(this)));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(APIStatusErrorException aPIStatusErrorException) {
        ((b) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(Throwable th2) {
        ((b) getUI()).G0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(String str, SecurityVerifyBean securityVerifyBean) {
        ((b) getUI()).h4();
        t0(securityVerifyBean.getReset_token(), str);
    }

    public final EasySubscriber<Object> a0() {
        return new a();
    }

    /* renamed from: m0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            kn.a aVar = (kn.a) intent.getExtras().get("target");
            this.f75461b = aVar;
            if (aVar instanceof JumpTarget) {
                this.f75462c = (JumpTarget) aVar;
            }
        }
    }

    public void n0() {
        UserCenterRemoteDataSource.A().z().compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new q(this)));
    }

    public void p0(String str, HashMap<String, Object> hashMap, String str2) {
        UserCenterRemoteDataSource.A().x(str, "RESET_PASSWORD_V2", hashMap, this.f75460a, str2).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(a0());
    }

    public void q0(String str, String str2, HashMap<String, Object> hashMap, String str3, boolean z11) {
        UserCenterRemoteDataSource.A().J(str, str2, "RESET_PASSWORD_V2", hashMap, this.f75460a, str3, z11).compose(RxJavaHelper.t((g) getUI())).compose(p.c0()).subscribe(a0());
    }

    public void r0(String str) {
        UserCenterRemoteDataSource.A().t0(str, 3, this.f75463d == 1 ? this.f75464e : null).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new u(this, str), new nn.p(this), new r(this)));
    }

    public void s0(int i11, String str, String str2) {
        this.f75463d = i11;
        this.f75464e = str;
        this.f75465f = str2;
    }

    public void t0(String str, String str2) {
        Intent intent = new Intent(getActivity(), SetForgetPswActivity.class);
        intent.putExtra("reset_token", str);
        intent.putExtra("login_name", str2);
        intent.putExtra("country_id", this.f75465f);
        intent.putExtra("country_code", this.f75464e);
        intent.putExtra("login_type", this.f75463d);
        JumpTarget jumpTarget = this.f75462c;
        if (jumpTarget != null) {
            intent.putExtra("target", jumpTarget);
        }
        getActivity().startActivity(intent);
    }

    public void u0(Map<String, Object> map, String str) {
        UserCenterRemoteDataSource.A().securityVerify(map).compose(p.c0()).compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new s(this, str)));
    }
}
