package com.huobi.login.v2.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bj.o0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuTitleDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.login.holder.EmailAssociationAdapter;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.ThirdInfo;
import com.huobi.login.utils.HistoryAccountDataManager;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.utils.SpannableUtils;
import com.huobi.utils.StatusBarUtils;
import com.huobi.view.CommonCaptchaDialog;
import com.huobi.view.button.StatusButton;
import com.huobi.view.indexlist.EntityWrapper;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import sn.w;
import tn.a1;
import tn.b1;
import tn.c1;
import tn.d1;
import tn.e1;
import tn.f1;
import tn.g1;
import tn.h1;
import tn.i1;
import tn.j1;
import tn.k1;
import tn.p0;
import tn.q0;
import tn.r0;
import tn.s0;
import tn.t0;
import tn.u0;
import tn.v0;
import tn.w0;
import tn.x0;
import tn.y0;
import tn.z0;

@Route(path = "/login/index")
public class UserLoginActivityV2 extends BaseActivity<LoginPresenter, LoginPresenter.d> implements LoginPresenter.d, View.OnClickListener {

    /* renamed from: l0  reason: collision with root package name */
    public static final String f75917l0 = ("config_country_id" + UserLoginActivityV2.class.getName());

    /* renamed from: m0  reason: collision with root package name */
    public static final int f75918m0 = PixelUtils.a(20.0f);
    public LinearLayout A;
    public boolean B = false;
    public SecurityStrategyControllerAdapter C;
    public SecurityStrategyControllerAdapter D;
    public SecurityStrategyControllerAdapter E;
    public String F;
    public List<String> G;
    public List<SecurityStrategyControllerAdapter> H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public int M;
    public TextView N;
    public ViewGroup O;
    public TextView P;
    public View Q;
    public ClearEditText R;
    public CharSequence S;
    public CharSequence T;
    public String U;
    public List<LoginInfoData.Login2FAOption> V = new ArrayList();
    public LoginInfoData.Login2FAOption W;
    public RadioGroupContainer X;
    public ImageView Y;
    public ImageView Z;

    /* renamed from: a0  reason: collision with root package name */
    public ImageView f75919a0;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75920b;

    /* renamed from: b0  reason: collision with root package name */
    public View f75921b0;

    /* renamed from: c  reason: collision with root package name */
    public View f75922c;

    /* renamed from: c0  reason: collision with root package name */
    public String f75923c0;

    /* renamed from: d  reason: collision with root package name */
    public View f75924d;

    /* renamed from: d0  reason: collision with root package name */
    public PopupWindow f75925d0;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f75926e;

    /* renamed from: e0  reason: collision with root package name */
    public RecyclerView f75927e0;

    /* renamed from: f  reason: collision with root package name */
    public StatusButton f75928f;

    /* renamed from: f0  reason: collision with root package name */
    public EmailAssociationAdapter f75929f0;

    /* renamed from: g  reason: collision with root package name */
    public Button f75930g;

    /* renamed from: g0  reason: collision with root package name */
    public View f75931g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f75932h;

    /* renamed from: h0  reason: collision with root package name */
    public View f75933h0;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f75934i;

    /* renamed from: i0  reason: collision with root package name */
    public InputFilter[] f75935i0 = new InputFilter[2];

    /* renamed from: j  reason: collision with root package name */
    public ImageView f75936j;

    /* renamed from: j0  reason: collision with root package name */
    public final TitleDialogMenuItemBean.a<LoginInfoData.Login2FAOption> f75937j0 = new q0(this);

    /* renamed from: k  reason: collision with root package name */
    public boolean f75938k = false;

    /* renamed from: k0  reason: collision with root package name */
    public final BottomMenuTitleDialogFragment.a f75939k0 = new c();

    /* renamed from: l  reason: collision with root package name */
    public CommonCaptchaDialog f75940l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f75941m = false;

    /* renamed from: n  reason: collision with root package name */
    public TextView f75942n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f75943o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f75944p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f75945q;

    /* renamed from: r  reason: collision with root package name */
    public ImageView f75946r;

    /* renamed from: s  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f75947s = new SecurityStrategyBottomMenuFragment();

    /* renamed from: t  reason: collision with root package name */
    public n f75948t;

    /* renamed from: u  reason: collision with root package name */
    public VerifyHelper f75949u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f75950v;

    /* renamed from: w  reason: collision with root package name */
    public View f75951w;

    /* renamed from: x  reason: collision with root package name */
    public View f75952x;

    /* renamed from: y  reason: collision with root package name */
    public View f75953y;

    /* renamed from: z  reason: collision with root package name */
    public View f75954z;

    public class a extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f75955g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Map f75956h;

        public a(SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f75955g = hVar;
            this.f75956h = map;
        }

        public boolean A() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            UserLoginActivityV2.this.f75947s.Ji();
            if (this.f75956h != null) {
                hashMap = new HashMap(this.f75956h);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).I1(hashMap, UserLoginActivityV2.this.F);
                return;
            }
            UserLoginActivityV2.this.f75947s.dismiss();
            UserLoginActivityV2.this.showProgressDialog();
            if (UserLoginActivityV2.this.M == 1 && !TextUtils.isEmpty(UserLoginActivityV2.this.U)) {
                hashMap.put("country_code", UserLoginActivityV2.this.U);
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f75955g;
        }

        public List<String> u() {
            return UserLoginActivityV2.this.G;
        }

        public boolean v() {
            return true;
        }

        public boolean y() {
            return true;
        }
    }

    public class b extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75958g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f75959h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f75960i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Map f75961j;

        public b(String str, SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f75959h = str;
            this.f75960i = hVar;
            this.f75961j = map;
        }

        public boolean A() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            UserLoginActivityV2.this.f75947s.Ji();
            if (this.f75961j != null) {
                hashMap = new HashMap(this.f75961j);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).I1(hashMap, UserLoginActivityV2.this.F);
                return;
            }
            UserLoginActivityV2.this.f75947s.dismiss();
            UserLoginActivityV2.this.showProgressDialog();
            if (UserLoginActivityV2.this.M == 1 && !TextUtils.isEmpty(UserLoginActivityV2.this.U)) {
                hashMap.put("country_code", UserLoginActivityV2.this.U);
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75958g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75958g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75959h;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75959h);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f75961j;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75961j.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75961j.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", UserLoginActivityV2.this.F);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f75960i;
        }

        public List<String> u() {
            return UserLoginActivityV2.this.G;
        }

        public boolean x() {
            return true;
        }
    }

    public class c implements BottomMenuTitleDialogFragment.a {
        public c() {
        }

        public void onBack() {
            UserLoginActivityV2 userLoginActivityV2 = UserLoginActivityV2.this;
            userLoginActivityV2.uj(userLoginActivityV2.V, UserLoginActivityV2.this.F, (Map<String, Object>) null, (LoginInfoData.Login2FAOption) null);
        }

        public void onDismiss() {
        }
    }

    public class d extends BaseSubscriber<NewBannerBean> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(NewBannerBean newBannerBean) {
            List<NewBannerBean.BannerAdv> bannerAdvList;
            super.onNext(newBannerBean);
            if (newBannerBean != null && (bannerAdvList = newBannerBean.getBannerAdvList()) != null && !bannerAdvList.isEmpty() && !TextUtils.isEmpty(bannerAdvList.get(0).getImageUrl())) {
                UserLoginActivityV2.this.f75919a0.setVisibility(0);
                g6.b.c().h(UserLoginActivityV2.this.f75919a0, bannerAdvList.get(0).getImageUrl());
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        public void onFocusChange(View view, boolean z11) {
            UserLoginActivityV2.this.f75926e.onFocusChange(view, z11);
            UserLoginActivityV2.this.f75924d.setSelected(z11);
            if (z11) {
                UserLoginActivityV2.this.Y.setImageResource(R.drawable.register_title_img_close_eyes);
            } else {
                UserLoginActivityV2.this.Y.setImageResource(R.drawable.register_title_img_open_eyes);
            }
        }
    }

    public class f implements ClearEditText.b {
        public f() {
        }

        public void a(CharSequence charSequence, int i11, int i12, int i13) {
            if (!TextUtils.isEmpty(charSequence)) {
                UserLoginActivityV2.this.f75951w.setVisibility(0);
            } else {
                UserLoginActivityV2.this.f75951w.setVisibility(4);
            }
            if (charSequence.length() > 0) {
                UserLoginActivityV2.this.f75926e.setTypeface(ResourcesCompat.h(UserLoginActivityV2.this.f75926e.getContext(), R.font.roboto_medium));
            } else {
                UserLoginActivityV2.this.f75926e.setTypeface(ResourcesCompat.h(UserLoginActivityV2.this.f75926e.getContext(), R.font.roboto_regular));
            }
            CharSequence unused = UserLoginActivityV2.this.f75934i = charSequence;
            UserLoginActivityV2.this.Ii();
        }
    }

    public class g implements BaseDialogFragment.c {
        public g() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            UserLoginActivityV2.this.G0();
        }

        public void onDialogFragmentResume() {
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (UserLoginActivityV2.this.f75925d0 == null || !UserLoginActivityV2.this.f75925d0.isShowing()) {
                SoftInputUtils.f(UserLoginActivityV2.this);
            } else {
                UserLoginActivityV2.this.f75925d0.dismiss();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class i implements ln.a {
        public i() {
        }

        public void a(boolean z11, int i11) {
            boolean unused = UserLoginActivityV2.this.B = z11;
            if (z11) {
                UserLoginActivityV2.this.A.setVisibility(4);
                return;
            }
            UserLoginActivityV2 userLoginActivityV2 = UserLoginActivityV2.this;
            userLoginActivityV2.He(((LoginPresenter) userLoginActivityV2.getPresenter()).T0());
        }
    }

    public class j extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75970g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f75971h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f75972i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f75973j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f75974k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f75975l;

        public j(int i11, String str, String str2, String str3, Map map) {
            this.f75971h = i11;
            this.f75972i = str;
            this.f75973j = str2;
            this.f75974k = str3;
            this.f75975l = map;
        }

        public boolean A() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean B() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null && C();
        }

        public boolean C() {
            return this.f75971h == 2;
        }

        public boolean G() {
            return true;
        }

        public void P() {
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            UserLoginActivityV2.this.f75947s.Ji();
            if (this.f75975l != null) {
                hashMap = new HashMap(this.f75975l);
            } else {
                hashMap = new HashMap();
            }
            if (str == null || str.isEmpty()) {
                str = str2;
            }
            hashMap.put(SaveAccountLinkingTokenRequest.TOKEN_TYPE_AUTH_CODE, str);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75974k);
                return;
            }
            UserLoginActivityV2.this.f75947s.dismiss();
            UserLoginActivityV2.this.showProgressDialog();
            if (UserLoginActivityV2.this.M == 1 && !TextUtils.isEmpty(UserLoginActivityV2.this.U)) {
                hashMap.put("country_code", UserLoginActivityV2.this.U);
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75970g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75970g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75970g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75970g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75973j;
        }

        public String o() {
            return this.f75972i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75973j);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f75975l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75975l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75975l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75975l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f75974k);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75972i);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", this.f75974k);
            Map map = this.f75975l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75975l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75975l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75975l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f75971h == 1;
        }

        public boolean w() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null && x();
        }

        public boolean x() {
            return this.f75971h == 3;
        }

        public boolean y() {
            return this.f75971h == 1;
        }
    }

    public class k extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75977g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f75978h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f75979i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f75980j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f75981k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f75982l;

        public k(boolean z11, String str, String str2, String str3, Map map) {
            this.f75978h = z11;
            this.f75979i = str;
            this.f75980j = str2;
            this.f75981k = str3;
            this.f75982l = map;
        }

        public boolean A() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean C() {
            return !TextUtils.isEmpty(this.f75979i);
        }

        public boolean G() {
            return true;
        }

        public void P() {
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            UserLoginActivityV2.this.f75947s.Ji();
            if (this.f75982l != null) {
                hashMap = new HashMap(this.f75982l);
            } else {
                hashMap = new HashMap();
            }
            if (y()) {
                hashMap.put("ga_code", str3);
            }
            if (C()) {
                hashMap.put("sms_code", str2);
            }
            if (x()) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75981k);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75977g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75977g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75977g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75977g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75980j;
        }

        public String o() {
            return this.f75979i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75980j);
            hashMap.put("use_type", "LOGIN");
            Map map = this.f75982l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75982l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75982l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75982l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f75981k);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75979i);
            hashMap.put("use_type", "LOGIN");
            hashMap.put("token", this.f75981k);
            Map map = this.f75982l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75982l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75982l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75982l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f75978h;
        }

        public boolean x() {
            return !TextUtils.isEmpty(this.f75980j);
        }

        public boolean y() {
            return this.f75978h;
        }
    }

    public class l implements TextWatcher {
        public l() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                UserLoginActivityV2.this.f75940l.getRightBtn().setEnabled(false);
            } else {
                UserLoginActivityV2.this.f75940l.getRightBtn().setEnabled(true);
            }
        }
    }

    public class m extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f75986h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f75987i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Map f75988j;

        public m(String str, SecurityStrategyBottomMenuFragment.h hVar, Map map) {
            this.f75986h = str;
            this.f75987i = hVar;
            this.f75988j = map;
        }

        public boolean A() {
            return ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean C() {
            return true;
        }

        public boolean D() {
            return true;
        }

        public boolean G() {
            return true;
        }

        public void Q() {
            super.Q();
        }

        public void i(String str, String str2, String str3, String str4) {
            HashMap hashMap;
            super.i(str, str2, str3, str4);
            UserLoginActivityV2.this.f75947s.Ji();
            if (this.f75988j != null) {
                hashMap = new HashMap(this.f75988j);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).I1(hashMap, UserLoginActivityV2.this.F);
                return;
            }
            UserLoginActivityV2.this.f75947s.dismiss();
            UserLoginActivityV2.this.showProgressDialog();
            if (UserLoginActivityV2.this.M == 1 && !TextUtils.isEmpty(UserLoginActivityV2.this.U)) {
                hashMap.put("country_code", UserLoginActivityV2.this.U);
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75985g || ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75985g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) UserLoginActivityV2.this.getPresenter()).L1(UserLoginActivityV2.this.R.getText().toString(), UserLoginActivityV2.this.f75926e.getText().toString());
            UserLoginActivityV2.this.f75928f.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String o() {
            return this.f75986h;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75986h);
            if (((LoginPresenter) UserLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", UserLoginActivityV2.this.F);
            Map map = this.f75988j;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75988j.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75988j.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f75987i;
        }

        public List<String> u() {
            return UserLoginActivityV2.this.G;
        }
    }

    public static class n implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<UserLoginActivityV2> f75990a;

        /* renamed from: b  reason: collision with root package name */
        public String f75991b;

        /* renamed from: c  reason: collision with root package name */
        public String f75992c;

        public n(UserLoginActivityV2 userLoginActivityV2) {
            this.f75990a = new WeakReference<>(userLoginActivityV2);
        }

        public void a(int i11, int i12, Intent intent) {
            ((UserLoginActivityV2) this.f75990a.get()).onActivityResult(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            UserLoginActivityV2 userLoginActivityV2 = (UserLoginActivityV2) this.f75990a.get();
            if (userLoginActivityV2 != null) {
                userLoginActivityV2.qj(this.f75991b, this.f75992c, i11, hashMap);
            }
        }

        public void c(String str, String str2) {
            this.f75991b = str;
            this.f75992c = str2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ui(String str) {
        this.R.setText(str);
        this.R.setSelection(str.length());
        this.f75925d0.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vi(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.M == 1) {
            this.T = charSequence;
            PopupWindow popupWindow = this.f75925d0;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f75925d0.dismiss();
            }
        } else {
            this.S = charSequence;
            if (hasWindowFocus()) {
                if (this.f75925d0 == null) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.register_email_association, (ViewGroup) null);
                    PopupWindow popupWindow2 = new PopupWindow(inflate);
                    this.f75925d0 = popupWindow2;
                    popupWindow2.setWidth(-1);
                    this.f75925d0.setHeight(getResources().getDimensionPixelSize(R.dimen.dimen_160));
                    this.f75927e0 = (RecyclerView) inflate.findViewById(R.id.recyclerView);
                    EmailAssociationAdapter emailAssociationAdapter = new EmailAssociationAdapter();
                    this.f75929f0 = emailAssociationAdapter;
                    emailAssociationAdapter.h(new v0(this));
                    this.f75927e0.setLayoutManager(new LinearLayoutManager(this));
                    this.f75927e0.setAdapter(this.f75929f0);
                }
                this.f75929f0.g(charSequence.toString());
                if (charSequence.length() <= 0 || this.f75929f0.getItemCount() <= 0) {
                    this.f75925d0.dismiss();
                } else {
                    if (!this.f75925d0.isShowing()) {
                        int[] iArr = new int[2];
                        this.R.getLocationInWindow(iArr);
                        PopupWindow popupWindow3 = this.f75925d0;
                        ClearEditText clearEditText = this.R;
                        popupWindow3.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + getResources().getDimensionPixelSize(R.dimen.dimen_4));
                    }
                    this.f75925d0.update(-1, getResources().getDimensionPixelSize(R.dimen.dimen_40) * Math.min(this.f75929f0.getItemCount(), 3));
                    this.f75929f0.notifyDataSetChanged();
                }
            }
        }
        Ii();
        if (charSequence.length() > 0) {
            ClearEditText clearEditText2 = this.R;
            clearEditText2.setTypeface(ResourcesCompat.h(clearEditText2.getContext(), R.font.roboto_medium));
            return;
        }
        ClearEditText clearEditText3 = this.R;
        clearEditText3.setTypeface(ResourcesCompat.h(clearEditText3.getContext(), R.font.roboto_regular));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wi(View view, boolean z11) {
        PopupWindow popupWindow;
        this.R.onFocusChange(view, z11);
        this.f75922c.setSelected(z11);
        if (!z11 && (popupWindow = this.f75925d0) != null && popupWindow.isShowing()) {
            this.f75925d0.dismiss();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xi(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yi(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("register_type", "register_email");
        if (((LoginPresenter) getPresenter()).P0() != null) {
            bundle.putString("third_token", ((LoginPresenter) getPresenter()).O0());
            if (((LoginPresenter) getPresenter()).L0() != null) {
                bundle.putString("bindEmail", ((LoginPresenter) getPresenter()).L0());
                bundle.putString("register_type", "register_email");
            } else if (((LoginPresenter) getPresenter()).N0() != null) {
                bundle.putString("bindPhone", ((LoginPresenter) getPresenter()).N0());
                bundle.putString("register_type", "register_mobile");
            }
        }
        Intent intent = new Intent(this, UserRegisterActivityV2.class);
        intent.putExtras(bundle);
        intent.putExtra("login_multiple_account", ((LoginPresenter) getPresenter()).X0());
        intent.putExtra("param_back_target", ((LoginPresenter) getPresenter()).Q0());
        startActivity(intent);
        if (((LoginPresenter) getPresenter()).P0() == null) {
            overridePendingTransition(0, 0);
            finish();
        }
        rj("4835");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void aj(View view) {
        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        intent.putExtra("SHOW_ALL_COUNTRY", true);
        startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.M = i12;
        this.f75935i0[1] = new InputFilter.LengthFilter(this.M == 1 ? 15 : EntityWrapper.TYPE_TITLE);
        this.R.setFilters(this.f75935i0);
        wj();
        Ii();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(View view, ln.a aVar) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i11 = rect.bottom - rect.top;
        int height = view.getHeight();
        int i12 = height - i11;
        boolean z11 = ((double) i11) / ((double) height) < 0.8d;
        if (z11 != this.f75941m) {
            aVar.a(z11, i12);
        }
        this.f75941m = z11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void dj(View view) {
        if (((LoginPresenter) getPresenter()).Y0()) {
            Intent intent = new Intent(this, SubAccountLoginActivityV2.class);
            intent.putExtra("USER_LOGIN_TYPE", 2);
            if (((LoginPresenter) getPresenter()).Q0() != null) {
                intent.putExtra("target", ((LoginPresenter) getPresenter()).Q0());
            }
            startActivity(intent);
            rj("4833");
        } else {
            finish();
            rj("4841");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ej(View view) {
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ CharSequence fj(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        while (i11 < i12) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return charSequence.toString().replaceAll(" ", "");
            }
            i11++;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gj(View view, TitleDialogMenuItemBean titleDialogMenuItemBean, int i11) {
        LoginInfoData.Login2FAOption login2FAOption = (LoginInfoData.Login2FAOption) titleDialogMenuItemBean.getData();
        if (login2FAOption == null) {
            startActivity(sn.f.e0(this, (String) null));
            return;
        }
        uj(this.V, this.F, (Map<String, Object>) null, login2FAOption);
        this.W = login2FAOption;
        this.f75947s.bi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hj(CountryListData countryListData) {
        this.U = countryListData.a();
        this.f75923c0 = String.valueOf(countryListData.c());
        this.P.setText(String.valueOf(this.U.replace("00", "+")));
        tj(this.f75923c0);
        ConfigPreferences.m("user_config", "config_area_code", this.U);
        ConfigPreferences.m("user_config", f75917l0, this.f75923c0);
        if (getPresenter() != null) {
            ((LoginPresenter) getPresenter()).P1(this.M);
            ((LoginPresenter) getPresenter()).O1(this.U);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ij(View view) {
        ((LoginPresenter) getPresenter()).N1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void jj(Dialog dialog, int i11) {
        this.f75940l.dismiss();
        this.f75928f.dismissAnim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void kj(Dialog dialog, int i11) {
        String obj = this.R.getText().toString();
        String obj2 = this.f75926e.getText().toString();
        String obj3 = this.f75940l.getCaptchaEdit().getText().toString();
        if (!TextUtils.isEmpty(obj3) && obj3.length() >= 5) {
            showProgressDialog();
            ((LoginPresenter) getPresenter()).G1(obj, obj2, obj3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mj(int i11) {
        this.f75947s.Ci(this.H.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void nj(int i11) {
        this.f75947s.Ci(this.H.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oj(int i11) {
        this.f75947s.Ci(this.H.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pj(CountryListData countryListData) {
        this.U = countryListData.a();
        this.f75923c0 = String.valueOf(countryListData.c());
        this.P.setText(String.valueOf(this.U.replace("00", "+")));
        tj(this.f75923c0);
        ConfigPreferences.m("user_config", "config_area_code", this.U);
        ConfigPreferences.m("user_config", f75917l0, this.f75923c0);
        if (getPresenter() != null) {
            ((LoginPresenter) getPresenter()).P1(this.M);
            ((LoginPresenter) getPresenter()).O1(this.U);
        }
    }

    public void Fi(Activity activity, ln.a aVar) {
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new j1(this, decorView, aVar));
    }

    public void G0() {
        this.f75928f.dismissAnim();
        this.f75947s.G0();
    }

    public final void Gi() {
        this.f75950v.setOnClickListener(new e1(this));
    }

    public void He(HashMap<String, ThirdInfo> hashMap) {
        if (hashMap == null || hashMap.isEmpty() || !((LoginPresenter) getPresenter()).Y0() || ((LoginPresenter) getPresenter()).P0() != null) {
            this.A.setVisibility(4);
            return;
        }
        this.A.setVisibility(0);
        this.f75952x.setVisibility(8);
        this.f75954z.setVisibility(8);
        this.f75953y.setVisibility(8);
        for (ThirdInfo next : hashMap.values()) {
            String lowerCase = next.d().toLowerCase();
            if (lowerCase.contains(LoginPresenter.f75468t.toLowerCase())) {
                this.f75954z.setVisibility(0);
                this.K.setText(next.a());
            } else if (lowerCase.contains(LoginPresenter.f75469u.toLowerCase())) {
                this.f75952x.setVisibility(0);
                this.J.setText(next.a());
            } else if (lowerCase.contains(LoginPresenter.f75470v.toLowerCase())) {
                this.f75953y.setVisibility(0);
                this.L.setText(next.a());
            }
        }
    }

    public final void Hi() {
        L5();
        He(((LoginPresenter) getPresenter()).T0());
        b2();
        if (((LoginPresenter) getPresenter()).Y0()) {
            this.f75950v.setText(getString(R.string.n_login_child_account_login));
            this.f75920b.setVisibility(0);
            this.f75943o.setText(getString(R.string.n_login_welcome_login));
            String e11 = ConfigPreferences.e("user_config", "config_email", "");
            if (TextUtils.isEmpty(e11) || !((LoginPresenter) getPresenter()).Y0() || Si(e11)) {
                this.R.setText("");
                this.f75926e.setText("");
            } else {
                Ti(e11);
                this.R.setText(e11);
                ClearEditText clearEditText = this.R;
                clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
                this.f75926e.setText("");
                this.f75926e.requestFocus();
                this.f75926e.setFocusableInTouchMode(true);
                this.f75926e.setFocusable(true);
            }
            wj();
            return;
        }
        this.f75950v.setText(getString(R.string.n_login_parent_account_login));
        this.N.setText(getString(R.string.n_login_child_account));
        this.R.setHint(R.string.n_login_child_account_login_placeholder);
        this.f75920b.setVisibility(8);
        this.f75943o.setText(getString(R.string.n_login_child_account_login));
        this.R.setText("");
        this.R.requestFocus();
        this.f75926e.setText("");
    }

    public void Ii() {
        if (this.M == 1) {
            if (TextUtils.isEmpty(this.T) || TextUtils.isEmpty(this.f75934i)) {
                this.f75928f.setEnabled(false);
            } else if (!((LoginPresenter) getPresenter()).Y0()) {
                int length = this.T.toString().length();
                if (length < 6 || length > 20 || StringUtils.o(this.T.toString()) || i6.m.Y(this.T.toString())) {
                    this.f75928f.setEnabled(false);
                } else {
                    this.f75928f.setEnabled(true);
                }
            } else if (StringUtils.o(this.T.toString()) || (i6.m.Y(this.T.toString()) && this.T.toString().length() >= 5)) {
                this.f75928f.setEnabled(true);
            } else {
                this.f75928f.setEnabled(false);
            }
        } else if (TextUtils.isEmpty(this.S) || TextUtils.isEmpty(this.f75934i)) {
            this.f75928f.setEnabled(false);
        } else if (!((LoginPresenter) getPresenter()).Y0()) {
            int length2 = this.S.toString().length();
            if (length2 < 6 || length2 > 20 || StringUtils.o(this.S.toString()) || i6.m.Y(this.S.toString())) {
                this.f75928f.setEnabled(false);
            } else {
                this.f75928f.setEnabled(true);
            }
        } else if (StringUtils.o(this.S.toString()) || (i6.m.Y(this.S.toString()) && this.S.toString().length() >= 5)) {
            this.f75928f.setEnabled(true);
        } else {
            this.f75928f.setEnabled(false);
        }
    }

    public final void Ji(Intent intent) {
        String stringExtra = intent.getStringExtra("login_name");
        ((LoginPresenter) getPresenter()).S0(intent);
        if (!TextUtils.isEmpty(stringExtra) && ((LoginPresenter) getPresenter()).Y0() && !Si(stringExtra)) {
            Ti(stringExtra);
            this.R.setText(stringExtra);
            this.f75926e.requestFocus();
            this.f75926e.setFocusableInTouchMode(true);
            this.f75926e.setFocusable(true);
        }
    }

    public void K0() {
        CommonCaptchaDialog commonCaptchaDialog = this.f75940l;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    /* renamed from: Ki */
    public LoginPresenter createPresenter() {
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.P1(this.M);
        loginPresenter.O1(this.U);
        return loginPresenter;
    }

    public void L5() {
        if (((LoginPresenter) getPresenter()).Y0()) {
            HistoryAccountDataManager.a().b();
        } else {
            HistoryAccountDataManager.a().c();
        }
    }

    public final String Li(String str) {
        return TextUtils.equals(str, LoginPresenter.f75469u) ? "Google" : str;
    }

    public final SecurityStrategyControllerAdapter Mi(String str, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.C == null) {
            this.C = new b(str, hVar, map);
        }
        return this.C;
    }

    public void N(String str) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this);
        this.f75940l = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(getResources().getString(R.string.login_dialog_captcha_title));
        this.f75940l.setCancelText(getResources().getString(R.string.login_dialog_cancel));
        this.f75940l.setConfirmText(getResources().getString(R.string.login_dialog_confirm));
        this.f75940l.setCaptchaImage(str);
        this.f75940l.show();
        this.f75940l.getImageView().setOnClickListener(new d1(this));
        this.f75940l.setCancelListener(new x0(this));
        this.f75940l.setConfirmListner(new w0(this));
        this.f75940l.getCaptchaEdit().addTextChangedListener(new l());
    }

    public final SecurityStrategyControllerAdapter Ni(Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.D == null) {
            this.D = new a(hVar, map);
        }
        return this.D;
    }

    public final SecurityStrategyControllerAdapter Oi(String str, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        if (this.E == null) {
            this.E = new m(str, hVar, map);
        }
        return this.E;
    }

    /* renamed from: Pi */
    public LoginPresenter.d getUI() {
        return this;
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f75940l;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f75940l.getCaptchaEdit().setText("");
        }
    }

    public void Q4(boolean z11, String str, String str2, String str3, Map<String, Object> map) {
        sj(map);
        if (!this.f75947s.isAdded()) {
            this.f75947s.yi(false);
            this.f75947s.Ci(new k(z11, str, str2, str3, map));
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f75947s;
            ClearEditText clearEditText = this.R;
            securityStrategyBottomMenuFragment.xi((clearEditText == null || clearEditText.getText() == null) ? "" : this.R.getText().toString());
            FragmentTransaction q11 = getSupportFragmentManager().q();
            q11.e(this.f75947s, "BottomMenuFragment");
            q11.k();
        }
    }

    public final void Qi() {
        String string = getString(R.string.n_login_login_agree);
        String string2 = getString(R.string.privacy_agreement_url2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, new Object[]{string2}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new h1(this));
        this.f75942n.setMovementMethod(LinkMovementMethod.getInstance());
        this.f75942n.setText(spannableStringBuilder);
    }

    public void Ri(List<LoginInfoData.Login2FAOption> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (LoginInfoData.Login2FAOption next : list) {
            int type = next.getType();
            if (type == 2) {
                str = getString(R.string.n_switch_to_the_sms_verification_code);
            } else if (type != 3) {
                str = getString(R.string.n_switch_to_the_google_captcha);
            } else {
                str = getString(R.string.n_switch_to_the_email_verification_code);
            }
            arrayList.add(new TitleDialogMenuItemBean(str, TitleDialogMenuItemBean.MenuItemStyle.COMMON, next, this.f75937j0));
        }
        arrayList.add(new TitleDialogMenuItemBean(getString(R.string.n_security_reset), TitleDialogMenuItemBean.MenuItemStyle.COMMON, null, this.f75937j0));
        this.f75947s.Ai(arrayList);
    }

    public final boolean Si(String str) {
        if (!StringUtils.o(str) && !i6.m.Y(str)) {
            return true;
        }
        return false;
    }

    public final void Ti(String str) {
        if (i6.m.Y(str)) {
            this.M = 1;
            this.T = str;
            return;
        }
        this.M = 0;
        this.S = str;
    }

    public void Ve(String str, String str2, RiskControl riskControl) {
        if (!isCanBeSeen()) {
            G0();
            return;
        }
        if (this.f75948t == null) {
            this.f75948t = new n(this);
        }
        this.f75948t.c(str, str2);
        this.f75949u.m(this, str, FirebaseAnalytics.Event.LOGIN, riskControl, this.f75948t);
    }

    public void a9(int i11) {
        Hi();
        try {
            vj();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void ac() {
        this.f75947s.dismiss();
        SoftInputUtils.f(this);
    }

    public void addEvent() {
        this.f75932h.setOnClickListener(this);
        this.f75928f.setOnClickListener(this);
        this.f75936j.setOnClickListener(this);
        this.f75952x.setOnClickListener(this);
        this.f75953y.setOnClickListener(this);
        this.f75954z.setOnClickListener(this);
        this.f75930g.setOnClickListener(this);
        this.R.setOnTextChangedListener(new r0(this));
        this.R.setOnFocusChangeListener(new i1(this));
        this.f75946r.setOnClickListener(new f1(this));
        this.f75926e.setOnFocusChangeListener(new e());
        this.f75926e.setOnTextChangedListener(new f());
        g1 g1Var = new g1(this);
        this.f75920b.setOnClickListener(g1Var);
        String string = getString(R.string.login_sign_up_tips);
        String string2 = getString(R.string.third_login_register_bind);
        TextView textView = this.I;
        ViewUtil.l(textView, string + " " + string2, string2, getResources().getColor(R.color.global_small_area_bg_color), new k1(g1Var));
        Gi();
        this.f75947s.setDialogFragmentListener(new g());
        this.O.setOnClickListener(new a1(this));
        this.X.setOnSelelctChangeListner(new y0(this));
        this.f75921b0.setOnClickListener(new h());
    }

    public void b2() {
        getString(R.string.login_sign_up_tips);
        String P0 = ((LoginPresenter) getPresenter()).P0();
        if (P0 != null) {
            getWindow().setSoftInputMode(48);
            this.f75945q.setVisibility(0);
            this.f75944p.setVisibility(0);
            this.f75931g0.setVisibility(8);
            this.f75933h0.setVisibility(8);
            this.f75920b.setVisibility(8);
            this.I.setVisibility(0);
            this.f75942n.setVisibility(8);
            this.f75943o.setVisibility(8);
            this.f75950v.setVisibility(8);
            this.f75928f.setButtonText((int) R.string.third_login_bind);
            String M0 = ((LoginPresenter) getPresenter()).M0();
            if (M0 != null) {
                Ti(M0);
                this.R.setText(M0);
                this.f75922c.setVisibility(8);
                this.f75924d.setVisibility(8);
                this.f75930g.setVisibility(0);
                this.f75945q.setText(String.format(Locale.US, getString(R.string.third_login_bind_describe_three), new Object[]{Li(P0)}));
                this.R.setText(M0);
                wj();
                return;
            }
            this.f75922c.setVisibility(0);
            this.f75924d.setVisibility(0);
            this.f75930g.setVisibility(8);
            this.f75945q.setText(String.format(Locale.US, getString(R.string.third_login_bind_describe_one), new Object[]{Li(P0)}));
            return;
        }
        this.f75930g.setVisibility(8);
        this.f75928f.setButtonText((int) R.string.login_button);
        this.f75950v.setVisibility(0);
        this.f75920b.setVisibility(0);
        this.I.setVisibility(8);
        this.f75942n.setVisibility(0);
        this.f75943o.setVisibility(8);
        this.f75945q.setVisibility(8);
        this.f75944p.setVisibility(8);
        this.f75931g0.setVisibility(0);
        this.f75933h0.setVisibility(0);
        L5();
        String e11 = ConfigPreferences.e("user_config", "config_email", "");
        if (!TextUtils.isEmpty(e11) && ((LoginPresenter) getPresenter()).Y0() && !Si(e11)) {
            Ti(e11);
            this.R.setText(e11);
            ClearEditText clearEditText = this.R;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
            this.f75926e.requestFocus();
            this.f75926e.setFocusableInTouchMode(true);
            this.f75926e.setFocusable(true);
            wj();
        }
        Fi(this, new i());
    }

    public boolean canFullScreen() {
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map) {
        sj(map);
        uj(list, str, map, (LoginInfoData.Login2FAOption) null);
    }

    public int getContentView() {
        getWindow().setFlags(8192, 8192);
        return R.layout.activity_login_v2;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public void initView() {
        this.f75922c = this.viewFinder.b(R.id.accountLayout);
        this.f75924d = this.viewFinder.b(R.id.pswLayout);
        this.f75926e = (ClearEditText) this.viewFinder.b(R.id.login_psw_edit);
        this.f75951w = this.viewFinder.b(R.id.divider);
        this.f75920b = (TextView) this.viewFinder.b(R.id.login_sign_up);
        this.f75928f = (StatusButton) this.viewFinder.b(R.id.login_btn);
        this.f75932h = (TextView) this.viewFinder.b(R.id.login_forgot_psw);
        this.f75936j = (ImageView) this.viewFinder.b(R.id.login_psw_img);
        this.f75942n = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f75943o = (TextView) this.viewFinder.b(R.id.login_title);
        this.I = (TextView) this.viewFinder.b(R.id.tv_bind_sign_up);
        this.f75944p = (TextView) this.viewFinder.b(R.id.bind_top_title);
        this.f75945q = (TextView) this.viewFinder.b(R.id.bind_top_tips);
        this.A = (LinearLayout) this.viewFinder.b(R.id.third_login_layout);
        this.f75930g = (Button) this.viewFinder.b(R.id.bind_other_account_btn);
        this.f75946r = (ImageView) this.viewFinder.b(R.id.login_close_btn);
        this.f75952x = this.viewFinder.b(R.id.third_login_image_google);
        this.f75953y = this.viewFinder.b(R.id.third_login_image_telegram);
        this.f75954z = this.viewFinder.b(R.id.third_login_image_facebook);
        this.J = (TextView) this.viewFinder.b(R.id.tv_third_login_text_google);
        this.K = (TextView) this.viewFinder.b(R.id.tv_third_login_text_facebook);
        this.L = (TextView) this.viewFinder.b(R.id.tv_third_login_text_telegram);
        this.f75950v = (TextView) this.viewFinder.b(R.id.tv_type_switch);
        this.R = (ClearEditText) this.viewFinder.b(R.id.login_account_edit);
        this.N = (TextView) this.viewFinder.b(R.id.login_top_tips);
        this.O = (ViewGroup) this.viewFinder.b(R.id.llyt_select_country_code);
        this.Q = this.viewFinder.b(R.id.space_divider);
        this.P = (TextView) this.viewFinder.b(R.id.tv_login_country_code);
        this.X = (RadioGroupContainer) this.viewFinder.b(R.id.type_tab);
        this.Y = (ImageView) this.viewFinder.b(R.id.title_img);
        this.f75921b0 = this.viewFinder.b(R.id.scrollContent);
        this.Z = (ImageView) this.viewFinder.b(R.id.ivCountryIcon);
        this.f75919a0 = (ImageView) this.viewFinder.b(R.id.bottom_banner_img);
        this.f75931g0 = this.viewFinder.b(R.id.loginTopIcon);
        this.f75933h0 = this.viewFinder.b(R.id.loginTopTitle);
        wj();
        ViewUtil.d(this.f75926e);
        this.f75926e.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        p0 p0Var = p0.f37300b;
        InputFilter[] inputFilterArr = this.f75935i0;
        inputFilterArr[0] = p0Var;
        inputFilterArr[1] = new InputFilter.LengthFilter(EntityWrapper.TYPE_TITLE);
        this.R.setFilters(this.f75935i0);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.R.setImportantForAutofill(2);
                this.f75926e.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        Qi();
        this.f75928f.setEnabled(false);
        this.f75928f.setButtonText(getString(R.string.login_button));
        this.f75928f.setBackgroundResource(R.drawable.register_v2_btn_bg);
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", "登录页");
        gs.g.i("App_Register_PageView", hashMap);
    }

    public void n3() {
        this.f75928f.showAnim();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f75949u.y(i11, i12, intent)) {
            G0();
        }
        if (i11 != 1001) {
            return;
        }
        if (intent != null) {
            this.U = intent.getStringExtra("phone_area_code");
            String stringExtra = intent.getStringExtra("country_area_code");
            this.f75923c0 = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                tj(this.f75923c0);
            }
            String str = this.U;
            if (str != null) {
                this.P.setText(String.valueOf(str.replace("00", "+")));
            }
            ConfigPreferences.m("user_config", "config_area_code", this.U);
            ConfigPreferences.m("user_config", f75917l0, this.f75923c0);
            if (getPresenter() != null) {
                ((LoginPresenter) getPresenter()).P1(this.M);
                ((LoginPresenter) getPresenter()).O1(this.U);
            }
        } else if (i11 == 1002) {
            this.U = intent.getStringExtra("phone_area_code");
            String stringExtra2 = intent.getStringExtra("country_area_code");
            this.f75923c0 = stringExtra2;
            if (!TextUtils.isEmpty(stringExtra2)) {
                tj(this.f75923c0);
            }
            String str2 = this.U;
            if (str2 != null) {
                this.P.setText(String.valueOf(str2.replace("00", "+")));
            }
            ConfigPreferences.m("user_config", "config_area_code", this.U);
            ConfigPreferences.m("user_config", f75917l0, this.f75923c0);
            if (getPresenter() != null) {
                ((LoginPresenter) getPresenter()).P1(this.M);
                ((LoginPresenter) getPresenter()).O1(this.U);
            }
        }
    }

    public void onBackPressed() {
        SoftInputUtils.f(this);
        if (getPresenter() == null || !((LoginPresenter) getPresenter()).Y0()) {
            finish();
        } else {
            ((LoginPresenter) getPresenter()).G0();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (ViewUtil.c(1000)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        switch (view.getId()) {
            case R.id.bind_other_account_btn:
                Intent intent = new Intent(this, UserLoginActivityV2.class);
                intent.putExtra("bindType", ((LoginPresenter) getPresenter()).P0());
                intent.putExtra("third_token", ((LoginPresenter) getPresenter()).O0());
                if (((LoginPresenter) getPresenter()).Q0() != null) {
                    intent.putExtra("target", ((LoginPresenter) getPresenter()).Q0());
                }
                startActivity(intent);
                break;
            case R.id.login_btn:
                String obj = this.R.getText().toString();
                if (this.M != 0 || StringUtils.o(obj)) {
                    ((LoginPresenter) getPresenter()).L1(obj, this.f75926e.getText().toString());
                    this.f75928f.showAnim();
                    rj("4836");
                    break;
                } else {
                    HuobiToastUtil.m(getResources().getString(R.string.n_account_password_error));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
            case R.id.login_forgot_psw:
                if (((LoginPresenter) getPresenter()).Y0()) {
                    Intent intent2 = new Intent(this, ForgetPasswordActivityV2.class);
                    if (((LoginPresenter) getPresenter()).Q0() != null) {
                        intent2.putExtra("target", ((LoginPresenter) getPresenter()).Q0());
                    }
                    startActivity(intent2);
                } else {
                    DialogUtils.X(this, getString(R.string.dialog_minamount_hint_title), getString(R.string.sub_account_forget_pw), (String) null, getString(R.string.dialog_minamount_hint_confrm_btn), o0.f12469a);
                }
                rj("4834");
                break;
            case R.id.login_psw_img:
                if (!this.f75938k) {
                    this.f75936j.setImageResource(R.drawable.icon_eye_open);
                    this.f75938k = true;
                    this.f75926e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ClearEditText clearEditText = this.f75926e;
                    clearEditText.setSelection(clearEditText.getText().toString().length());
                    break;
                } else {
                    this.f75936j.setImageResource(R.drawable.icon_eye_close);
                    this.f75938k = false;
                    this.f75926e.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ClearEditText clearEditText2 = this.f75926e;
                    clearEditText2.setSelection(clearEditText2.getText().toString().length());
                    break;
                }
            case R.id.third_login_image_facebook:
                HashMap hashMap = new HashMap();
                hashMap.put("sign_type", "FacebookSign");
                gs.g.i("sub_sign", hashMap);
                ((LoginPresenter) getPresenter()).Q1(LoginPresenter.f75468t);
                break;
            case R.id.third_login_image_google:
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sign_type", "GoogleSign");
                gs.g.i("sub_sign", hashMap2);
                ((LoginPresenter) getPresenter()).Q1(LoginPresenter.f75469u);
                break;
            case R.id.third_login_image_telegram:
                HashMap hashMap3 = new HashMap();
                hashMap3.put("sign_type", "TelegramSign");
                gs.g.i("sub_sign", hashMap3);
                ((LoginPresenter) getPresenter()).Q1(LoginPresenter.f75470v);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        StatusBarUtils.e(this, 0);
        changeStatusBarTextColor(!isLightStatusBar());
        super.onCreate(bundle);
        this.f75949u = new VerifyHelper();
        Ji(getIntent());
    }

    public void onDestroy() {
        super.onDestroy();
        VerifyActivity.finishVerifyUI();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("login_name");
        ((LoginPresenter) getPresenter()).S0(intent);
        String stringExtra2 = intent.getStringExtra("login_flag");
        if (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equals("register_success")) {
            HuobiToastUtil.r(getResources().getString(R.string.register_success));
        }
        if (!TextUtils.isEmpty(stringExtra) && ((LoginPresenter) getPresenter()).Y0() && !Si(stringExtra)) {
            Ti(stringExtra);
            this.R.setText(stringExtra);
            this.f75926e.requestFocus();
            this.f75926e.setFocusableInTouchMode(true);
            this.f75926e.setFocusable(true);
            wj();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.M == 1) {
            String e11 = ConfigPreferences.e("user_config", "config_area_code", "");
            String e12 = ConfigPreferences.e("user_config", f75917l0, "");
            String str = this.U;
            if (str == null || !str.equals(e11)) {
                this.U = e11;
                this.f75923c0 = e12;
                if (!TextUtils.isEmpty(e11)) {
                    this.P.setText(String.valueOf(this.U.replace("00", "+")));
                    tj(this.f75923c0);
                    if (getPresenter() != null) {
                        ((LoginPresenter) getPresenter()).P1(this.M);
                        ((LoginPresenter) getPresenter()).O1(this.U);
                        return;
                    }
                    return;
                }
                w.j().i(this).subscribe(q6.d.c(this, new b1(this)));
                return;
            }
            this.P.setText(String.valueOf(this.U.replace("00", "+")));
            tj(e12);
        } else if (getPresenter() != null) {
            ((LoginPresenter) getPresenter()).P1(this.M);
            ((LoginPresenter) getPresenter()).O1(this.U);
        }
    }

    public void p2(int i11, String str, String str2, String str3, Map<String, Object> map) {
        if (!this.f75947s.isAdded()) {
            this.f75947s.Ci(new j(i11, str, str2, str3, map));
            SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f75947s;
            ClearEditText clearEditText = this.R;
            securityStrategyBottomMenuFragment.xi((clearEditText == null || clearEditText.getText() == null) ? "" : this.R.getText().toString());
            FragmentTransaction q11 = getSupportFragmentManager().q();
            q11.e(this.f75947s, "BottomMenuFragment");
            q11.k();
        }
    }

    public void qj(String str, String str2, int i11, HashMap<String, Object> hashMap) {
        if (i11 != 0) {
            ((LoginPresenter) getPresenter()).J1(str, str2, hashMap);
        } else {
            this.f75928f.dismissAnim();
        }
        GrowingIOStatics.b(i11, hashMap);
    }

    public final void rj(String str) {
        if (((LoginPresenter) getPresenter()).Y0()) {
            is.a.j(str, (Map<String, Object>) null, "1005271");
        } else {
            is.a.j(str, (Map<String, Object>) null, "1005253");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sign_type", "AccountSign");
        gs.g.i("sub_sign", hashMap);
    }

    public final void sj(Map<String, Object> map) {
        Object obj;
        boolean z11;
        String str;
        if (map != null && (obj = map.get("isKnowDevice")) != null) {
            try {
                z11 = ((Boolean) obj).booleanValue();
            } catch (Exception e11) {
                i6.k.f("isKnowDevice to knowDevice", e11.toString());
                z11 = false;
            }
            if (z11) {
                str = getString(R.string.security_google_verification);
            } else {
                str = getString(R.string.n_verify_new_device_login);
            }
            this.f75947s.Gi(str);
        }
    }

    public final void tj(String str) {
        f6.c.a().l(this, w.e(str), this.Z, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public void uj(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map, LoginInfoData.Login2FAOption login2FAOption) {
        this.F = str;
        if ((!this.f75947s.isAdded() || login2FAOption != null) && !mz.a.g(list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<LoginInfoData.Login2FAOption> arrayList3 = new ArrayList<>();
            arrayList3.addAll(list);
            boolean z11 = login2FAOption != null;
            if (login2FAOption == null) {
                this.V.clear();
                this.V.addAll(arrayList3);
                login2FAOption = this.W;
                if (login2FAOption == null) {
                    login2FAOption = (LoginInfoData.Login2FAOption) arrayList3.get(0);
                }
            }
            arrayList.add(login2FAOption);
            Collections.sort(arrayList3, z0.f37330b);
            for (LoginInfoData.Login2FAOption login2FAOption2 : arrayList3) {
                if (login2FAOption2.getType() != login2FAOption.getType()) {
                    arrayList2.add(login2FAOption2);
                }
            }
            this.f75947s.yi(true);
            Ri(arrayList2);
            this.G = new ArrayList();
            this.H = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                LoginInfoData.Login2FAOption login2FAOption3 = (LoginInfoData.Login2FAOption) arrayList.get(i11);
                int type = login2FAOption3.getType();
                if (type == 1) {
                    this.G.add(getResources().getString(R.string.n_new_user_login_verify_ga));
                    this.H.add(Ni(map, new s0(this)));
                } else if (type == 2) {
                    String tag = login2FAOption3.getTag();
                    this.G.add(getResources().getString(R.string.n_new_user_login_verify_phone));
                    this.H.add(Oi(tag, map, new t0(this)));
                } else if (type == 3) {
                    String tag2 = login2FAOption3.getTag();
                    this.G.add(getResources().getString(R.string.n_new_user_login_verify_email));
                    this.H.add(Mi(tag2, map, new u0(this)));
                }
            }
            this.f75947s.Ci(this.H.get(0));
            if (!z11) {
                SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment = this.f75947s;
                ClearEditText clearEditText = this.R;
                securityStrategyBottomMenuFragment.xi((clearEditText == null || clearEditText.getText() == null) ? "" : this.R.getText().toString());
                FragmentTransaction q11 = getSupportFragmentManager().q();
                q11.e(this.f75947s, "BottomMenuFragment");
                q11.k();
            }
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void vj() {
        if (i6.n.f(this) >= 1920 && ((LoginPresenter) getPresenter()).P0() == null) {
            v7.b.a().requestNewBanner(23, 6, (String) null).b().compose(RxJavaHelper.t(getUI())).subscribe(new d());
        }
    }

    public final void wj() {
        int checkedPosition = this.X.getCheckedPosition();
        int i11 = this.M;
        if (checkedPosition != i11) {
            this.X.setCheckedPosition(i11);
        }
        if (this.M == 1) {
            this.N.setText(getResources().getString(R.string.sign_up_phone_hint));
            this.O.setVisibility(0);
            this.Q.setVisibility(0);
            this.R.setText(this.T);
            this.R.setHint(getResources().getString(R.string.n_login_phone_input_placeholder));
            this.R.setInputType(3);
            String str = this.U;
            if (str == null || this.f75923c0 == null) {
                this.U = ConfigPreferences.e("user_config", "config_area_code", "");
                this.f75923c0 = ConfigPreferences.e("user_config", f75917l0, "");
                if (TextUtils.isEmpty(this.U) || TextUtils.isEmpty(this.f75923c0)) {
                    w.j().i(this).subscribe(q6.d.c(this, new c1(this)));
                } else {
                    this.P.setText(String.valueOf(this.U.replace("00", "+")));
                    tj(this.f75923c0);
                    if (getPresenter() != null) {
                        ((LoginPresenter) getPresenter()).P1(this.M);
                        ((LoginPresenter) getPresenter()).O1(this.U);
                    }
                }
            } else {
                this.P.setText(String.valueOf(str.replace("00", "+")));
                tj(this.f75923c0);
            }
        } else {
            this.N.setText(getResources().getString(R.string.sign_up_email_hint));
            this.O.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setText(this.S);
            this.R.setHint(getResources().getString(R.string.n_login_email_input_placeholder));
            this.R.setInputType(33);
            if (getPresenter() != null) {
                ((LoginPresenter) getPresenter()).P1(this.M);
                ((LoginPresenter) getPresenter()).O1(this.U);
            }
        }
        if (this.R.getText() != null && !TextUtils.isEmpty(this.R.getText().toString())) {
            ClearEditText clearEditText = this.R;
            clearEditText.setSelection(clearEditText.getText().toString().length());
        }
    }
}
