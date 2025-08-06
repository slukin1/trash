package com.huobi.otc.helper;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.otc.core.bean.UserVerifyWaysBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.otc.retrofit.service.OtcService;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.ui.SecurityLinkActivity;
import com.huobi.account.ui.SecurityLinkStatusActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.otc.flutter.OtcTradeLeadingFlutterActivity;
import com.huobi.otc.flutter.OtcTradeSettingFlutterActivity;
import com.huobi.otc.helper.OtcDialogUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cp.c;
import cp.d;
import dp.t;
import jp.j1;
import jp.k1;
import jp.l;
import jp.l1;
import jp.m1;
import jp.n1;
import jp.o1;
import jp.p1;
import jp.q1;
import jp.r1;
import jp.s1;
import jp.t1;
import jp.u1;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import tq.p;
import u6.g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f78944a;

    /* renamed from: b  reason: collision with root package name */
    public g f78945b;

    /* renamed from: c  reason: collision with root package name */
    public OtcSecurityTokenFactory f78946c;

    /* renamed from: d  reason: collision with root package name */
    public c f78947d;

    /* renamed from: e  reason: collision with root package name */
    public t f78948e;

    /* renamed from: f  reason: collision with root package name */
    public UserVerifyWaysBean f78949f;

    /* renamed from: g  reason: collision with root package name */
    public UserSecurityInfoData f78950g;

    /* renamed from: h  reason: collision with root package name */
    public jp.c f78951h;

    /* renamed from: com.huobi.otc.helper.a$a  reason: collision with other inner class name */
    public class C0843a extends EasySubscriber<Pair<UserVerifyWaysBean, UserSecurityInfoData>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ jp.c f78952b;

        public C0843a(jp.c cVar) {
            this.f78952b = cVar;
        }

        /* renamed from: a */
        public void onNext(Pair<UserVerifyWaysBean, UserSecurityInfoData> pair) {
            super.onNext(pair);
            UserVerifyWaysBean unused = a.this.f78949f = (UserVerifyWaysBean) pair.first;
            UserSecurityInfoData unused2 = a.this.f78950g = (UserSecurityInfoData) pair.second;
            if (!a.this.f78949f.isTradeBind()) {
                jp.c cVar = this.f78952b;
                if (cVar != null) {
                    cVar.call();
                } else {
                    a.this.I();
                }
            } else if (a.this.f78947d == null || !a.this.f78947d.g()) {
                a.this.q().s(true);
                a.this.K();
            } else {
                a.this.f78947d.b();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class b implements d {
        public b() {
        }

        public void a() {
            if (a.this.f78947d != null) {
                a.this.f78947d.a();
            }
        }

        public void b() {
            if (a.this.f78947d != null) {
                a.this.f78947d.e();
            }
        }

        public void c(String str) {
            if (a.this.f78947d != null) {
                a.this.f78947d.c(str);
            }
        }
    }

    public a(FragmentActivity fragmentActivity, g gVar) {
        this.f78944a = fragmentActivity;
        this.f78945b = gVar;
        this.f78946c = new OtcSecurityTokenFactory(fragmentActivity, gVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Dialog dialog) {
        dialog.dismiss();
        G(this.f78949f.getUcPhoneStatus());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(Dialog dialog) {
        dialog.dismiss();
        F(this.f78949f.getUcGaStatus());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(Dialog dialog) {
        dialog.dismiss();
        N();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(String str) {
        c cVar = this.f78947d;
        if (cVar != null) {
            cVar.h(MD5Utils.d(str));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(UserVO userVO) {
        if (userVO.isVerifyWayHaveSet()) {
            OtcTradeSettingFlutterActivity.Hi(this.f78944a);
        } else {
            this.f78944a.startActivity(new Intent(this.f78944a, OtcTradeLeadingFlutterActivity.class));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        this.f78948e.dismiss();
        jp.c cVar = this.f78951h;
        if (cVar != null) {
            cVar.call();
        } else {
            I();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface) {
        try {
            SoftInputUtils.f(this.f78944a);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(int i11, UserSecurityInfoData userSecurityInfoData) {
        if (i11 > 1) {
            Intent intent = new Intent(this.f78944a, SecurityLinkStatusActivity.class);
            intent.putExtra("LINK_TYPE_KEY", 1);
            intent.putExtra("VERIFY_STATUS_KEY", 2);
            intent.putExtra("from_otc_trade_set", true);
            intent.putExtra("BIND_PHONE_KEY", userSecurityInfoData.getPhone());
            this.f78944a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f78944a, SecurityLinkActivity.class);
        intent2.putExtra("LINK_TYPE_KEY", 1);
        intent2.putExtra("from_otc_trade_set", true);
        this.f78944a.startActivity(intent2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        c cVar = this.f78947d;
        if (cVar != null) {
            if (cVar.g()) {
                this.f78947d.b();
            } else {
                K();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(Dialog dialog) {
        dialog.dismiss();
        H();
    }

    public final void F(int i11) {
        if (i11 > 1) {
            Intent intent = new Intent(this.f78944a, SecurityLinkStatusActivity.class);
            intent.putExtra("LINK_TYPE_KEY", 3);
            intent.putExtra("from_otc_trade_set", true);
            intent.putExtra("VERIFY_STATUS_KEY", 2);
            this.f78944a.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this.f78944a, SecurityLinkActivity.class);
        intent2.putExtra("LINK_TYPE_KEY", 3);
        intent2.putExtra("from_otc_trade_set", true);
        this.f78944a.startActivity(intent2);
    }

    public final void G(int i11) {
        r().subscribe(q6.d.c(this.f78945b, new k1(this, i11)));
    }

    public final void H() {
        this.f78944a.startActivity(new Intent(this.f78944a, SecuritySetActivity.class));
    }

    public void I() {
        UserVerifyWaysBean userVerifyWaysBean;
        if (this.f78944a != null && (userVerifyWaysBean = this.f78949f) != null && this.f78946c != null) {
            if (!t(userVerifyWaysBean, this.f78950g)) {
                L(this.f78944a.getString(R.string.n_otc_use_verification_code_tip), new r1(this));
            } else if (u(this.f78949f, this.f78950g)) {
                this.f78946c.t(new n1(this));
                this.f78947d.d(this.f78946c.l());
                this.f78946c.m(this.f78949f.isTradeBind(), this.f78949f.isPhoneOpened() && this.f78949f.getUcPhoneStatus() == 3, false, this.f78949f.isGaOpened() && this.f78949f.getUcGaStatus() == 3, new b());
            } else if (this.f78949f.isPhoneOpened() && this.f78949f.getUcPhoneStatus() != 3 && this.f78949f.isGaOpened() && this.f78949f.getUcGaStatus() != 3) {
                L(this.f78944a.getString(R.string.n_otc_mobilephone_google) + this.f78944a.getString(R.string.n_otc_security_verify_close_tip), new o1(this));
            } else if (this.f78949f.isPhoneOpened() && this.f78949f.getUcPhoneStatus() != 3) {
                L(this.f78944a.getString(R.string.n_otc_mobilephone) + this.f78944a.getString(R.string.n_otc_security_verify_close_tip), new p1(this));
            } else if (this.f78949f.isGaOpened() && this.f78949f.getUcGaStatus() != 3) {
                L(this.f78944a.getString(R.string.n_otc_google) + this.f78944a.getString(R.string.n_otc_security_verify_close_tip), new q1(this));
            }
        }
    }

    public void J(c cVar) {
        this.f78947d = cVar;
    }

    public final void K() {
        c cVar = this.f78947d;
        if (cVar != null) {
            cVar.f(q());
        }
        q().r(new t1(this));
        q().show();
    }

    public final void L(String str, OtcDialogUtils.b.d dVar) {
        FragmentActivity fragmentActivity = this.f78944a;
        OtcDialogUtils.a(fragmentActivity, "", str, "", fragmentActivity.getString(R.string.n_cancel), this.f78944a.getString(R.string.n_otc_confirm_open), s1.f56059a, dVar).show();
    }

    public void M(jp.c cVar) {
        this.f78951h = cVar;
        Observable.zip(((OtcService) OtcRetrofit.request(OtcService.class)).userVerifyWays().compose(OtcRetrofit.o()), UserCenterRemoteDataSource.A().T().subscribeOn(Schedulers.io()).compose(p.c0()), l1.f56036b).compose(RxJavaHelper.t((g) null)).subscribe(new C0843a(cVar));
    }

    public final void N() {
        l.q(l.r() != null && l.r().isVerifyWayHaveSet()).compose(RxJavaHelper.t(this.f78945b)).subscribe(q6.d.c(this.f78945b, new u1(this)));
    }

    public final t q() {
        if (this.f78948e == null) {
            t tVar = new t(this.f78944a);
            this.f78948e = tVar;
            tVar.t(new m1(this));
            this.f78948e.setOnDismissListener(new j1(this));
        }
        return this.f78948e;
    }

    public final Observable<UserSecurityInfoData> r() {
        return UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t(this.f78945b));
    }

    public c s() {
        return this.f78947d;
    }

    public final boolean t(UserVerifyWaysBean userVerifyWaysBean, UserSecurityInfoData userSecurityInfoData) {
        if (userVerifyWaysBean == null || userSecurityInfoData == null) {
            return false;
        }
        return userVerifyWaysBean.isGaOpened() || userVerifyWaysBean.isPhoneOpened() || userSecurityInfoData.getPasskey() == 1;
    }

    public final boolean u(UserVerifyWaysBean userVerifyWaysBean, UserSecurityInfoData userSecurityInfoData) {
        if (!userVerifyWaysBean.isPhoneOpened() || userVerifyWaysBean.getUcPhoneStatus() != 3) {
            return (userVerifyWaysBean.isGaOpened() && userVerifyWaysBean.getUcGaStatus() == 3) || userSecurityInfoData.getPasskey() == 1;
        }
        return true;
    }
}
