package wn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.telegram.Telegram;
import com.adjust.sdk.Constants;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.thirdlogin.ThirdLoginUtil;
import com.huobi.login.usercenter.data.source.bean.ThirdAuth;
import com.huobi.login.usercenter.data.source.bean.ThirdAuthUrl;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.usercenter.data.source.bean.ThirdInfo;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.v3.ui.UserBindTipsActivityV3;
import com.huobi.login.v3.ui.UserRegisterActivityV3;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.BaseConstants;
import gs.g;
import i6.k;
import i6.r;
import java.util.HashMap;
import java.util.List;
import on.c;
import on.d;
import on.e;
import on.f;
import pro.huobi.R;
import tq.p;

public class k0 implements View.OnClickListener, f {

    /* renamed from: u  reason: collision with root package name */
    public static String f76750u = "ThirdLoginHelper";

    /* renamed from: b  reason: collision with root package name */
    public final b f76751b;

    /* renamed from: c  reason: collision with root package name */
    public View f76752c;

    /* renamed from: d  reason: collision with root package name */
    public View f76753d;

    /* renamed from: e  reason: collision with root package name */
    public View f76754e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f76755f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f76756g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f76757h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f76758i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f76759j;

    /* renamed from: k  reason: collision with root package name */
    public d f76760k;

    /* renamed from: l  reason: collision with root package name */
    public d f76761l;

    /* renamed from: m  reason: collision with root package name */
    public d f76762m;

    /* renamed from: n  reason: collision with root package name */
    public d f76763n;

    /* renamed from: o  reason: collision with root package name */
    public String f76764o;

    /* renamed from: p  reason: collision with root package name */
    public final HashMap<String, ThirdInfo> f76765p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    public View f76766q;

    /* renamed from: r  reason: collision with root package name */
    public View f76767r;

    /* renamed from: s  reason: collision with root package name */
    public View f76768s;

    /* renamed from: t  reason: collision with root package name */
    public String f76769t;

    public class a extends EasySubscriber<List<ThirdInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76770b;

        public a(String str) {
            this.f76770b = str;
        }

        public void onError2(Throwable th2) {
            String h11 = k0.f76750u;
            k.o(h11, "Third login fetchThirdList  error " + th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String h11 = k0.f76750u;
            k.o(h11, "Third login fetchThirdList net error " + aPIStatusErrorException);
        }

        public void onNext(List<ThirdInfo> list) {
            super.onNext(list);
            for (ThirdInfo next : list) {
                String h11 = k0.f76750u;
                k.o(h11, "Third login fetchThirdList success  " + next);
                String lowerCase = next.d().toLowerCase();
                if (lowerCase.contains(LoginPresenter.f75468t.toLowerCase())) {
                    LoginPresenter.f75468t = lowerCase;
                    k0.this.f76765p.put(LoginPresenter.f75468t, next);
                } else if (lowerCase.contains(LoginPresenter.f75469u.toLowerCase())) {
                    if (!ThirdLoginUtil.a()) {
                        LoginPresenter.f75469u = lowerCase;
                        k0.this.f76765p.put(LoginPresenter.f75469u, next);
                    }
                } else if (lowerCase.contains(LoginPresenter.f75470v.toLowerCase())) {
                    LoginPresenter.f75470v = lowerCase;
                    k0.this.f76765p.put(LoginPresenter.f75470v, next);
                }
            }
            k0.this.l(this.f76770b);
        }
    }

    public interface b {
        void a(String str, String str2);

        JumpTarget b();

        BaseActivity getActivity();
    }

    public k0(b bVar, String str) {
        this.f76751b = bVar;
        this.f76769t = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(ThirdAuth thirdAuth) {
        String str = f76750u;
        k.o(str, "Third login getThirdAuth success  " + thirdAuth.toString());
        if (thirdAuth.b().booleanValue()) {
            this.f76751b.a(thirdAuth.e(), this.f76764o);
        } else if (TextUtils.isEmpty(thirdAuth.c())) {
            u(thirdAuth);
        } else if (thirdAuth.f()) {
            u(thirdAuth);
        } else {
            Intent intent = new Intent(this.f76751b.getActivity(), UserBindTipsActivityV3.class);
            intent.putExtra("bindType", this.f76764o);
            intent.putExtra("third_token", thirdAuth.e());
            intent.putExtra("auth_token", thirdAuth.a());
            intent.putExtra("bindEmail", thirdAuth.c());
            if (thirdAuth.d() != null) {
                intent.putExtra("login_name", thirdAuth.d());
            }
            if (this.f76751b.b() != null) {
                intent.putExtra("target", this.f76751b.b());
            }
            this.f76751b.getActivity().startActivity(intent);
        }
        this.f76751b.getActivity().dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(APIStatusErrorException aPIStatusErrorException) {
        String str = f76750u;
        k.o(str, "Third login getThirdAuth net error  " + aPIStatusErrorException);
        this.f76751b.getActivity().dismissProgressDialog();
        if ("11653".equals(aPIStatusErrorException.getErrCode())) {
            HuobiToastUtil.j(R.string.third_login_bind_error_rebind);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(Throwable th2) {
        String str = f76750u;
        k.o(str, "Third login getThirdAuth error  " + th2);
        this.f76751b.getActivity().dismissProgressDialog();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(ThirdData thirdData, ThirdState thirdState) {
        String str = f76750u;
        k.o(str, "Third login getThirdState success  " + thirdState.toString());
        j(thirdState.a(), thirdData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(APIStatusErrorException aPIStatusErrorException) {
        String str = f76750u;
        k.o(str, "Third login getThirdState net error " + aPIStatusErrorException);
        this.f76751b.getActivity().dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Throwable th2) {
        String str = f76750u;
        k.o(str, "Third login getThirdState  error " + th2);
        this.f76751b.getActivity().dismissProgressDialog();
        th2.printStackTrace();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(ThirdAuthUrl thirdAuthUrl) {
        String authUrl = thirdAuthUrl.getAuthUrl();
        ((e) this.f76762m).c(authUrl);
        k.o("TelegramLogin", "getThirdAuthUrl " + authUrl);
        this.f76762m.login();
    }

    public final void j(String str, ThirdData thirdData) {
        String str2;
        String str3 = f76750u;
        k.o(str3, "Third login fetchThirdInfo  " + str + " data: " + thirdData.toString());
        if (LoginPresenter.f75470v.equals(this.f76764o)) {
            ThirdInfo thirdInfo = this.f76765p.get(thirdData.f75671a);
            str2 = thirdInfo != null ? thirdInfo.b() : null;
        } else {
            str2 = thirdData.f75673c;
        }
        if (!TextUtils.isEmpty(str2)) {
            UserCenterRemoteDataSource.A().L(thirdData, str, str2).compose(p.c0()).compose(RxJavaHelper.t(this.f76751b.getActivity())).subscribe(EasySubscriber.create(new f0(this), new d0(this), new i0(this)));
        }
    }

    public void k(r rVar) {
        this.f76755f = (LinearLayout) rVar.b(R.id.third_login_layout_title);
        this.f76756g = (LinearLayout) rVar.b(R.id.third_login_layout);
        this.f76752c = rVar.b(R.id.third_login_image_google);
        this.f76753d = rVar.b(R.id.third_login_image_telegram);
        this.f76754e = rVar.b(R.id.third_login_image_facebook);
        this.f76757h = (TextView) rVar.b(R.id.tv_third_login_text_google);
        this.f76758i = (TextView) rVar.b(R.id.tv_third_login_text_facebook);
        this.f76759j = (TextView) rVar.b(R.id.tv_third_login_text_telegram);
        this.f76766q = rVar.b(R.id.third_login_google_tip);
        this.f76767r = rVar.b(R.id.third_login_facebook_tip);
        this.f76768s = rVar.b(R.id.third_login_telegram_tip);
        this.f76752c.setOnClickListener(this);
        this.f76753d.setOnClickListener(this);
        this.f76754e.setOnClickListener(this);
    }

    public void l(String str) {
        if (this.f76765p.isEmpty()) {
            LinearLayout linearLayout = this.f76755f;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            this.f76756g.setVisibility(4);
            return;
        }
        LinearLayout linearLayout2 = this.f76755f;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        this.f76756g.setVisibility(0);
        this.f76752c.setVisibility(8);
        this.f76754e.setVisibility(8);
        this.f76753d.setVisibility(8);
        for (ThirdInfo next : this.f76765p.values()) {
            String lowerCase = next.d().toLowerCase();
            if (lowerCase.contains(LoginPresenter.f75468t.toLowerCase())) {
                this.f76754e.setVisibility(0);
                this.f76758i.setText(next.a());
            } else if (lowerCase.contains(LoginPresenter.f75469u.toLowerCase())) {
                this.f76752c.setVisibility(0);
                this.f76757h.setText(next.a());
            } else if (lowerCase.contains(LoginPresenter.f75470v.toLowerCase())) {
                this.f76753d.setVisibility(0);
                this.f76759j.setText(next.a());
            }
        }
        String e11 = c0.e(str);
        String str2 = f76750u;
        k.o(str2, "initThirdBindView thirdType:" + e11 + " account:" + str);
        if (TextUtils.isEmpty(e11)) {
            this.f76766q.setVisibility(4);
            this.f76767r.setVisibility(4);
            this.f76768s.setVisibility(4);
        } else if (e11.contains(LoginPresenter.f75468t.toLowerCase()) || e11.equalsIgnoreCase(LoginPresenter.f75468t)) {
            this.f76766q.setVisibility(4);
            this.f76767r.setVisibility(0);
            this.f76768s.setVisibility(4);
        } else if (e11.contains(LoginPresenter.f75469u.toLowerCase()) || e11.equalsIgnoreCase(LoginPresenter.f75469u)) {
            this.f76766q.setVisibility(0);
            this.f76767r.setVisibility(4);
            this.f76768s.setVisibility(4);
        } else if (e11.contains(LoginPresenter.f75470v.toLowerCase()) || e11.equalsIgnoreCase(LoginPresenter.f75470v)) {
            this.f76766q.setVisibility(4);
            this.f76767r.setVisibility(4);
            this.f76768s.setVisibility(0);
        }
    }

    @SuppressLint({"NonConstantResourceId"})
    @SensorsDataInstrumented
    public void onClick(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        switch (view.getId()) {
            case R.id.third_login_image_facebook:
                HashMap hashMap = new HashMap(2);
                hashMap.put("sign_type", "facebook");
                hashMap.put("Page_name", this.f76769t);
                g.i("app_login_button_click", hashMap);
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("button_name", "Facebook");
                g.i("appClick_login", hashMap2);
                y(LoginPresenter.f75468t);
                break;
            case R.id.third_login_image_google:
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("sign_type", Constants.REFERRER_API_GOOGLE);
                hashMap3.put("Page_name", this.f76769t);
                g.i("app_login_button_click", hashMap3);
                HashMap hashMap4 = new HashMap(1);
                hashMap4.put("button_name", "Google");
                g.i("appClick_login", hashMap4);
                y(LoginPresenter.f75469u);
                break;
            case R.id.third_login_image_telegram:
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("sign_type", "telegram");
                hashMap5.put("Page_name", this.f76769t);
                g.i("app_login_button_click", hashMap5);
                HashMap hashMap6 = new HashMap(1);
                hashMap6.put("button_name", Telegram.NAME);
                g.i("appClick_login", hashMap6);
                y(LoginPresenter.f75470v);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onError(Exception exc) {
        String str = f76750u;
        k.o(str, "LoginPresenter onError: " + exc.getMessage());
    }

    public void p(String str) {
        k.o(f76750u, "LoginPresenter onCancel");
    }

    public final void u(ThirdAuth thirdAuth) {
        String str = f76750u;
        k.o(str, "loginAndBind thirdAuth: " + thirdAuth);
        Intent intent = new Intent(this.f76751b.getActivity(), UserRegisterActivityV3.class);
        intent.putExtra("bindType", this.f76764o);
        intent.putExtra("third_token", thirdAuth.e());
        intent.putExtra("bindEmail", thirdAuth.c());
        if (thirdAuth.d() != null) {
            intent.putExtra("login_name", thirdAuth.d());
        }
        if (this.f76751b.b() != null) {
            intent.putExtra("target", this.f76751b.b());
        }
        this.f76751b.getActivity().startActivityForResult(intent, BaseConstants.ERR_SVR_CONV_ACCOUNT_NOT_FOUND);
    }

    public void v(int i11, int i12, Intent intent) {
        k.o(f76750u, "onActivityResult");
        d dVar = this.f76763n;
        if (dVar != null) {
            dVar.onActivityResult(i11, i12, intent);
        }
    }

    public void w(String str) {
        UserCenterRemoteDataSource.A().N().compose(p.c0()).compose(RxJavaHelper.t(this.f76751b.getActivity())).subscribe(new a(str));
    }

    public void x(ThirdData thirdData) {
        String str = f76750u;
        k.o(str, "Third login onSuccess: " + this.f76764o + " type: " + thirdData);
        if (thirdData.f75671a.equals(this.f76764o)) {
            this.f76751b.getActivity().showProgressDialog(false);
            UserCenterRemoteDataSource.A().O().compose(p.c0()).compose(RxJavaHelper.t(this.f76751b.getActivity())).subscribe(EasySubscriber.create(new j0(this, thirdData), new e0(this), new h0(this)));
            HashMap hashMap = new HashMap(2);
            hashMap.put("sign_type", this.f76764o);
            hashMap.put("Page_name", this.f76769t);
            g.i("app_login_authorization_success", hashMap);
        }
    }

    public void y(String str) {
        this.f76764o = str;
        if (str.equals(LoginPresenter.f75468t)) {
            if (this.f76760k == null) {
                this.f76760k = new on.b(this.f76751b.getActivity(), this);
            }
            d dVar = this.f76760k;
            this.f76763n = dVar;
            dVar.login();
        } else if (str.equals(LoginPresenter.f75469u)) {
            if (this.f76761l == null) {
                this.f76761l = new c(this.f76751b.getActivity(), this);
            }
            d dVar2 = this.f76761l;
            this.f76763n = dVar2;
            dVar2.login();
        } else if (str.equals(LoginPresenter.f75470v)) {
            if (this.f76762m == null) {
                this.f76762m = new e(this.f76751b.getActivity(), this);
            }
            this.f76763n = this.f76762m;
            if (this.f76765p.get(str) != null) {
                UserCenterRemoteDataSource.A().M(this.f76765p.get(str)).compose(p.c0()).compose(RxJavaHelper.t(this.f76751b.getActivity())).subscribe(q6.d.c(this.f76751b.getActivity(), new g0(this)));
            }
        }
    }
}
