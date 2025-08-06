package com.huobi.otc.helper;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import cp.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import jp.e1;
import jp.f1;
import jp.g1;
import jp.h1;
import jp.i1;
import rx.Observable;
import tq.p;
import u6.g;

public class OtcSecurityTokenFactory {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f78912a;

    /* renamed from: b  reason: collision with root package name */
    public g f78913b;

    /* renamed from: c  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f78914c;

    /* renamed from: d  reason: collision with root package name */
    public Params f78915d;

    /* renamed from: e  reason: collision with root package name */
    public d f78916e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f78917f;

    /* renamed from: g  reason: collision with root package name */
    public String f78918g;

    public static class Params implements Serializable {
        private boolean isNeedEmail;
        private boolean isNeedGa;
        private boolean isNeedPhone;
        private String userEmail;
        private String userPhone;

        public boolean canEqual(Object obj) {
            return obj instanceof Params;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (!params.canEqual(this) || isNeedPhone() != params.isNeedPhone() || isNeedEmail() != params.isNeedEmail() || isNeedGa() != params.isNeedGa()) {
                return false;
            }
            String userPhone2 = getUserPhone();
            String userPhone3 = params.getUserPhone();
            if (userPhone2 != null ? !userPhone2.equals(userPhone3) : userPhone3 != null) {
                return false;
            }
            String userEmail2 = getUserEmail();
            String userEmail3 = params.getUserEmail();
            return userEmail2 != null ? userEmail2.equals(userEmail3) : userEmail3 == null;
        }

        public String getUserEmail() {
            return this.userEmail;
        }

        public String getUserPhone() {
            return this.userPhone;
        }

        public int hashCode() {
            int i11 = 79;
            int i12 = ((((isNeedPhone() ? 79 : 97) + 59) * 59) + (isNeedEmail() ? 79 : 97)) * 59;
            if (!isNeedGa()) {
                i11 = 97;
            }
            int i13 = i12 + i11;
            String userPhone2 = getUserPhone();
            int i14 = 43;
            int hashCode = (i13 * 59) + (userPhone2 == null ? 43 : userPhone2.hashCode());
            String userEmail2 = getUserEmail();
            int i15 = hashCode * 59;
            if (userEmail2 != null) {
                i14 = userEmail2.hashCode();
            }
            return i15 + i14;
        }

        public boolean isNeedEmail() {
            return this.isNeedEmail;
        }

        public boolean isNeedGa() {
            return this.isNeedGa;
        }

        public boolean isNeedPhone() {
            return this.isNeedPhone;
        }

        public void setNeedEmail(boolean z11) {
            this.isNeedEmail = z11;
        }

        public void setNeedGa(boolean z11) {
            this.isNeedGa = z11;
        }

        public void setNeedPhone(boolean z11) {
            this.isNeedPhone = z11;
        }

        public void setUserEmail(String str) {
            this.userEmail = str;
        }

        public void setUserPhone(String str) {
            this.userPhone = str;
        }

        public String toString() {
            return "OtcSecurityTokenFactory.Params(isNeedPhone=" + isNeedPhone() + ", isNeedEmail=" + isNeedEmail() + ", isNeedGa=" + isNeedGa() + ", userPhone=" + getUserPhone() + ", userEmail=" + getUserEmail() + ")";
        }
    }

    public class a extends SecurityStrategyController {
        public a() {
        }

        public boolean C() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedPhone();
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            OtcSecurityTokenFactory.this.l().dismiss();
            OtcSecurityTokenFactory.this.x(str, str2, str3);
        }

        public Activity m() {
            return OtcSecurityTokenFactory.this.f78912a;
        }

        public String n() {
            return OtcSecurityTokenFactory.this.f78915d.getUserEmail();
        }

        public String o() {
            return OtcSecurityTokenFactory.this.f78915d.getUserPhone();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", OtcSecurityTokenFactory.this.f78918g).b();
        }

        public Map<String, Object> s() {
            return MapParamsBuilder.c().a("use_type", OtcSecurityTokenFactory.this.f78918g).a("voice", Boolean.FALSE).b();
        }

        public boolean x() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedEmail();
        }

        public boolean y() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedGa();
        }

        public boolean z() {
            return false;
        }
    }

    public class b extends SecurityStrategyController {
        public b() {
        }

        public boolean C() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedPhone();
        }

        public void Q() {
            super.Q();
            if (OtcSecurityTokenFactory.this.f78916e != null) {
                OtcSecurityTokenFactory.this.f78916e.a();
            }
        }

        public void i(String str, String str2, String str3, String str4) {
            OtcSecurityTokenFactory.this.l().dismiss();
            OtcSecurityTokenFactory.this.w(str, str2, str3);
        }

        public Activity m() {
            return OtcSecurityTokenFactory.this.f78912a;
        }

        public String n() {
            return OtcSecurityTokenFactory.this.f78915d.getUserEmail();
        }

        public String o() {
            return OtcSecurityTokenFactory.this.f78915d.getUserPhone();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD").b();
        }

        public Map<String, Object> s() {
            return MapParamsBuilder.c().a("use_type", "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD").a("voice", Boolean.FALSE).b();
        }

        public boolean x() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedEmail();
        }

        public boolean y() {
            return OtcSecurityTokenFactory.this.f78915d.isNeedGa();
        }

        public boolean z() {
            return false;
        }
    }

    public OtcSecurityTokenFactory(FragmentActivity fragmentActivity, g gVar) {
        this(fragmentActivity, gVar, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(boolean z11, boolean z12, boolean z13, boolean z14, UserSecurityInfoData userSecurityInfoData) {
        Params params = new Params();
        params.setNeedGa(z11);
        params.setNeedPhone(z12);
        params.setNeedEmail(z13);
        if (z12) {
            params.setUserPhone(userSecurityInfoData.getPhone());
        }
        if (z13) {
            params.setUserEmail(userSecurityInfoData.getEmail());
        }
        this.f78915d = params;
        u(z14);
    }

    public static /* synthetic */ Params p(UserSecurityInfoData userSecurityInfoData, SecurityStrategySet securityStrategySet) {
        Params params = new Params();
        params.setNeedEmail(securityStrategySet.getSetting().isVerify_email());
        params.setNeedPhone(securityStrategySet.getSetting().isVerify_phone());
        params.setNeedGa(securityStrategySet.getSetting().isVerify_ga());
        params.setUserPhone(userSecurityInfoData.getPhone());
        params.setUserEmail(userSecurityInfoData.getEmail());
        return params;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(Params params) {
        this.f78915d = params;
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(CodeVerifyData codeVerifyData) {
        d dVar = this.f78916e;
        if (dVar != null) {
            dVar.c(codeVerifyData.getToken());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(CodeVerifyData codeVerifyData) {
        d dVar = this.f78916e;
        if (dVar != null) {
            dVar.c(codeVerifyData.getToken());
        }
    }

    public SecurityStrategyBottomMenuFragment l() {
        if (this.f78914c == null) {
            this.f78914c = new SecurityStrategyBottomMenuFragment();
        }
        return this.f78914c;
    }

    public void m(boolean z11, boolean z12, boolean z13, boolean z14, d dVar) {
        this.f78916e = dVar;
        if (z12 || z13) {
            UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t(this.f78913b)).subscribe(q6.d.c(this.f78913b, new h1(this, z14, z12, z13, z11)));
            return;
        }
        Params params = new Params();
        params.setNeedGa(z14);
        this.f78915d = params;
        u(z11);
    }

    public void n(d dVar) {
        this.f78915d = null;
        this.f78916e = dVar;
        Observable.zip(UserCenterRemoteDataSource.A().T().compose(p.c0()).compose(RxJavaHelper.t(this.f78913b)), UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t(this.f78913b)), i1.f56029b).subscribe(q6.d.c(this.f78913b, new g1(this)));
    }

    public void t(View.OnClickListener onClickListener) {
        this.f78917f = onClickListener;
    }

    public final void u(boolean z11) {
        if (this.f78915d != null) {
            l().Ci(new b());
            this.f78916e.b();
            l().Ei(z11);
            l().Di(this.f78917f);
            l().show(this.f78912a.getSupportFragmentManager(), "BottomMenuFragment");
        }
    }

    public final void v() {
        if (this.f78915d != null) {
            l().Ci(new a());
            l().Ei(false);
            l().show(this.f78912a.getSupportFragmentManager(), "BottomMenuFragment");
        }
    }

    public final void w(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sms_code", str);
        }
        hashMap.put("use_type", "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
        UserCenterRemoteDataSource.A().getSecurityStrategySmartVerify(hashMap).compose(p.c0()).compose(RxJavaHelper.t(this.f78913b)).subscribe(q6.d.c(this.f78913b, new f1(this)));
    }

    public final void x(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("sms_code", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("ga_code", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("email_code", str);
        }
        hashMap.put("use_type", this.f78918g);
        UserCenterRemoteDataSource.A().getSecurityStrategyVerify(hashMap).compose(p.c0()).compose(RxJavaHelper.t(this.f78913b)).subscribe(q6.d.c(this.f78913b, new e1(this)));
    }

    public OtcSecurityTokenFactory(FragmentActivity fragmentActivity, g gVar, boolean z11) {
        this.f78912a = fragmentActivity;
        this.f78913b = gVar;
        if (z11) {
            this.f78918g = "SHOW_USER_SELF_KYC_INFO";
        } else {
            this.f78918g = "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD";
        }
    }
}
