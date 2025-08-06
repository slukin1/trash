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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentTransaction;
import bj.o0;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.account.ui.SecurityStrategyControllerAdapter;
import com.huobi.login.presenter.LoginPresenter;
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
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import tn.a0;
import tn.b0;
import tn.c0;
import tn.d0;
import tn.e0;
import tn.f0;
import tn.g0;
import tn.h0;
import tn.i0;
import tn.j0;
import tn.k0;
import tn.l0;
import tn.m0;

public class SubAccountLoginActivityV2 extends BaseActivity<LoginPresenter, LoginPresenter.d> implements LoginPresenter.d, View.OnClickListener {
    public static final int I = PixelUtils.a(20.0f);
    public TextView A;
    public View B;
    public View C;
    public View D;
    public View E;
    public LinearLayout F;
    public boolean G = false;
    public ScrollView H;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75850b;

    /* renamed from: c  reason: collision with root package name */
    public View f75851c;

    /* renamed from: d  reason: collision with root package name */
    public View f75852d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f75853e;

    /* renamed from: f  reason: collision with root package name */
    public ClearEditText f75854f;

    /* renamed from: g  reason: collision with root package name */
    public StatusButton f75855g;

    /* renamed from: h  reason: collision with root package name */
    public Button f75856h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f75857i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f75858j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f75859k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f75860l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f75861m = false;

    /* renamed from: n  reason: collision with root package name */
    public CommonCaptchaDialog f75862n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f75863o = false;

    /* renamed from: p  reason: collision with root package name */
    public TextView f75864p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f75865q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f75866r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f75867s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f75868t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f75869u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f75870v;

    /* renamed from: w  reason: collision with root package name */
    public ImageView f75871w;

    /* renamed from: x  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f75872x = new SecurityStrategyBottomMenuFragment();

    /* renamed from: y  reason: collision with root package name */
    public l f75873y;

    /* renamed from: z  reason: collision with root package name */
    public VerifyHelper f75874z;

    public class a extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75875g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f75876h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f75877i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f75878j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f75879k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f75880l;

        public a(String str, List list, SecurityStrategyBottomMenuFragment.h hVar, String str2, Map map) {
            this.f75876h = str;
            this.f75877i = list;
            this.f75878j = hVar;
            this.f75879k = str2;
            this.f75880l = map;
        }

        public boolean A() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).Y0();
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
            SubAccountLoginActivityV2.this.f75872x.Ji();
            if (this.f75880l != null) {
                hashMap = new HashMap(this.f75880l);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75879k);
                return;
            }
            SubAccountLoginActivityV2.this.f75872x.dismiss();
            SubAccountLoginActivityV2.this.showProgressDialog();
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75875g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75875g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String o() {
            return this.f75876h;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75876h);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", this.f75879k);
            Map map = this.f75880l;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75880l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75880l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f75878j;
        }

        public List<String> u() {
            return this.f75877i;
        }
    }

    public class b extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75882g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f75883h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f75884i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SecurityStrategyBottomMenuFragment.h f75885j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Map f75886k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ String f75887l;

        public b(String str, List list, SecurityStrategyBottomMenuFragment.h hVar, Map map, String str2) {
            this.f75883h = str;
            this.f75884i = list;
            this.f75885j = hVar;
            this.f75886k = map;
            this.f75887l = str2;
        }

        public boolean A() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).Y0();
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
            SubAccountLoginActivityV2.this.f75872x.Ji();
            if (this.f75886k != null) {
                hashMap = new HashMap(this.f75886k);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75887l);
                return;
            }
            SubAccountLoginActivityV2.this.f75872x.dismiss();
            SubAccountLoginActivityV2.this.showProgressDialog();
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75882g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75882g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75883h;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75883h);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f75886k;
            if (map != null) {
                String str = (String) map.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75886k.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75886k.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f75887l);
            return hashMap;
        }

        public SecurityStrategyBottomMenuFragment.h t() {
            return this.f75885j;
        }

        public List<String> u() {
            return this.f75884i;
        }

        public boolean x() {
            return true;
        }
    }

    public class c implements ClearEditText.b {
        public c() {
        }

        public void a(CharSequence charSequence, int i11, int i12, int i13) {
            CharSequence unused = SubAccountLoginActivityV2.this.f75858j = charSequence;
            if (charSequence.length() > 0) {
                SubAccountLoginActivityV2.this.f75853e.setTypeface(ResourcesCompat.h(SubAccountLoginActivityV2.this.f75853e.getContext(), R.font.roboto_medium));
            } else {
                SubAccountLoginActivityV2.this.f75853e.setTypeface(ResourcesCompat.h(SubAccountLoginActivityV2.this.f75853e.getContext(), R.font.roboto_regular));
            }
            SubAccountLoginActivityV2.this.qi();
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z11) {
            SubAccountLoginActivityV2.this.f75853e.onFocusChange(view, z11);
            SubAccountLoginActivityV2.this.f75851c.setSelected(z11);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        public void onFocusChange(View view, boolean z11) {
            SubAccountLoginActivityV2.this.f75854f.onFocusChange(view, z11);
            SubAccountLoginActivityV2.this.f75852d.setSelected(z11);
        }
    }

    public class f implements ClearEditText.b {
        public f() {
        }

        public void a(CharSequence charSequence, int i11, int i12, int i13) {
            if (!TextUtils.isEmpty(charSequence)) {
                SubAccountLoginActivityV2.this.C.setVisibility(0);
            } else {
                SubAccountLoginActivityV2.this.C.setVisibility(4);
            }
            CharSequence unused = SubAccountLoginActivityV2.this.f75859k = charSequence;
            if (charSequence.length() > 0) {
                SubAccountLoginActivityV2.this.f75854f.setTypeface(ResourcesCompat.h(SubAccountLoginActivityV2.this.f75854f.getContext(), R.font.roboto_medium));
            } else {
                SubAccountLoginActivityV2.this.f75854f.setTypeface(ResourcesCompat.h(SubAccountLoginActivityV2.this.f75854f.getContext(), R.font.roboto_regular));
            }
            SubAccountLoginActivityV2.this.qi();
        }
    }

    public class g implements BaseDialogFragment.c {
        public g() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SubAccountLoginActivityV2.this.G0();
        }

        public void onDialogFragmentResume() {
        }
    }

    public class h implements ln.a {
        public h() {
        }

        public void a(boolean z11, int i11) {
            boolean unused = SubAccountLoginActivityV2.this.G = z11;
            if (z11) {
                SubAccountLoginActivityV2.this.H.smoothScrollTo(0, PixelUtils.a(75.0f));
                SubAccountLoginActivityV2.this.F.setVisibility(4);
                return;
            }
            SubAccountLoginActivityV2.this.H.scrollTo(0, 0);
            SubAccountLoginActivityV2 subAccountLoginActivityV2 = SubAccountLoginActivityV2.this;
            subAccountLoginActivityV2.He(((LoginPresenter) subAccountLoginActivityV2.getPresenter()).T0());
        }
    }

    public class i extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75895g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f75896h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f75897i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f75898j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f75899k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f75900l;

        public i(int i11, String str, String str2, String str3, Map map) {
            this.f75896h = i11;
            this.f75897i = str;
            this.f75898j = str2;
            this.f75899k = str3;
            this.f75900l = map;
        }

        public boolean A() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean B() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null && C();
        }

        public boolean C() {
            return this.f75896h == 2;
        }

        public boolean F() {
            return true;
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
            SubAccountLoginActivityV2.this.f75872x.Ji();
            if (this.f75900l != null) {
                hashMap = new HashMap(this.f75900l);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null || !TextUtils.isEmpty(str3)) {
                ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75899k);
                return;
            }
            SubAccountLoginActivityV2.this.f75872x.dismiss();
            SubAccountLoginActivityV2.this.showProgressDialog();
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).H0(hashMap);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75895g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75895g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75895g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75895g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75898j;
        }

        public String o() {
            return this.f75897i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75898j);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            Map map = this.f75900l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75900l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75900l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75900l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f75899k);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75897i);
            if (((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                hashMap.put("use_type", "LOGIN");
            } else {
                hashMap.put("use_type", "THIRD_BIND");
            }
            hashMap.put("token", this.f75899k);
            Map map = this.f75900l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75900l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75900l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75900l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f75896h == 1;
        }

        public boolean w() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null && x();
        }

        public boolean x() {
            return this.f75896h == 3;
        }

        public boolean y() {
            return this.f75896h == 1;
        }
    }

    public class j extends SecurityStrategyControllerAdapter {

        /* renamed from: g  reason: collision with root package name */
        public boolean f75902g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f75903h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f75904i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f75905j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f75906k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ Map f75907l;

        public j(boolean z11, String str, String str2, String str3, Map map) {
            this.f75903h = z11;
            this.f75904i = str;
            this.f75905j = str2;
            this.f75906k = str3;
            this.f75907l = map;
        }

        public boolean A() {
            return ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).Y0();
        }

        public boolean C() {
            return !TextUtils.isEmpty(this.f75904i);
        }

        public boolean F() {
            return true;
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
            SubAccountLoginActivityV2.this.f75872x.Ji();
            if (this.f75907l != null) {
                hashMap = new HashMap(this.f75907l);
            } else {
                hashMap = new HashMap();
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("ga_code", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("sms_code", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("email_code", str);
            }
            hashMap.put("login_version", 3);
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).I1(hashMap, this.f75906k);
        }

        public void j(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar) {
            if (!this.f75902g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75902g = true;
                super.j(securityStrategyBottomMenuFragment, gVar);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public void k(SecurityStrategyBottomMenuFragment securityStrategyBottomMenuFragment, u6.g gVar, boolean z11) {
            if (!this.f75902g || ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).P0() == null) {
                this.f75902g = true;
                super.k(securityStrategyBottomMenuFragment, gVar, z11);
                return;
            }
            ((LoginPresenter) SubAccountLoginActivityV2.this.getPresenter()).L1(SubAccountLoginActivityV2.this.f75853e.getText().toString(), SubAccountLoginActivityV2.this.f75854f.getText().toString());
            SubAccountLoginActivityV2.this.f75855g.showAnim();
            securityStrategyBottomMenuFragment.dismiss();
        }

        public String n() {
            return this.f75905j;
        }

        public String o() {
            return this.f75904i;
        }

        public Map<String, Object> p() {
            HashMap hashMap = new HashMap();
            hashMap.put("email", this.f75905j);
            hashMap.put("use_type", "LOGIN");
            Map map = this.f75907l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75907l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75907l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75907l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("token", this.f75906k);
            return hashMap;
        }

        public Map<String, Object> s() {
            HashMap hashMap = new HashMap();
            hashMap.put(PlaceFields.PHONE, this.f75904i);
            hashMap.put("use_type", "LOGIN");
            hashMap.put("token", this.f75906k);
            Map map = this.f75907l;
            if (map != null) {
                Object obj = map.get("captcha_param");
                if (obj != null) {
                    hashMap.put("captcha_param", obj);
                }
                String str = (String) this.f75907l.get("captcha_key");
                if (str != null) {
                    hashMap.put("captcha_key", str);
                }
                String str2 = (String) this.f75907l.get("captcha_code");
                if (str2 != null) {
                    hashMap.put("captcha_code", str2);
                }
                Map map2 = (Map) this.f75907l.get("afs");
                if (map2 != null) {
                    hashMap.put("afs", map2);
                }
            }
            hashMap.put("voice", Boolean.FALSE);
            return hashMap;
        }

        public boolean v() {
            return this.f75903h;
        }

        public boolean x() {
            return !TextUtils.isEmpty(this.f75905j);
        }

        public boolean y() {
            return this.f75903h;
        }
    }

    public class k implements TextWatcher {
        public k() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                SubAccountLoginActivityV2.this.f75862n.getRightBtn().setEnabled(false);
            } else {
                SubAccountLoginActivityV2.this.f75862n.getRightBtn().setEnabled(true);
            }
        }
    }

    public static class l implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SubAccountLoginActivityV2> f75910a;

        /* renamed from: b  reason: collision with root package name */
        public String f75911b;

        /* renamed from: c  reason: collision with root package name */
        public String f75912c;

        public l(SubAccountLoginActivityV2 subAccountLoginActivityV2) {
            this.f75910a = new WeakReference<>(subAccountLoginActivityV2);
        }

        public void a(int i11, int i12, Intent intent) {
            ((SubAccountLoginActivityV2) this.f75910a.get()).onActivityResult(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            SubAccountLoginActivityV2 subAccountLoginActivityV2 = (SubAccountLoginActivityV2) this.f75910a.get();
            if (subAccountLoginActivityV2 != null) {
                subAccountLoginActivityV2.Ji(this.f75911b, this.f75912c, i11, hashMap);
            }
        }

        public void c(String str, String str2) {
            this.f75911b = str;
            this.f75912c = str2;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ai(View view) {
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bi() {
        if (this.F.getHeight() > getResources().getDimensionPixelOffset(R.dimen.dimen_162)) {
            this.F.setGravity(80);
            this.F.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dimen_50));
            return;
        }
        this.F.setPadding(0, 0, 0, 0);
        this.F.setGravity(17);
    }

    public static /* synthetic */ CharSequence Ci(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        while (i11 < i12) {
            if (Character.isWhitespace(charSequence.charAt(i11))) {
                return charSequence.toString().replaceAll(" ", "");
            }
            i11++;
        }
        return null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Di(View view) {
        ((LoginPresenter) getPresenter()).N1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ei(Dialog dialog, int i11) {
        this.f75862n.dismiss();
        this.f75855g.dismissAnim();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fi(Dialog dialog, int i11) {
        String obj = this.f75853e.getText().toString();
        String obj2 = this.f75854f.getText().toString();
        String obj3 = this.f75862n.getCaptchaEdit().getText().toString();
        if (!TextUtils.isEmpty(obj3) && obj3.length() >= 5) {
            showProgressDialog();
            ((LoginPresenter) getPresenter()).G1(obj, obj2, obj3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(List list, int i11) {
        this.f75872x.Ci((SecurityStrategyController) list.get(i11));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(List list, int i11) {
        this.f75872x.Ci((SecurityStrategyController) list.get(i11));
    }

    public static /* synthetic */ void Ii(View view, String str) {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
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
        startActivity(intent);
        finish();
        Ki("4835");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xi(View view) {
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yi(View view, ln.a aVar) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i11 = rect.bottom - rect.top;
        int height = view.getHeight();
        int i12 = height - i11;
        boolean z11 = ((double) i11) / ((double) height) < 0.8d;
        if (z11 != this.f75863o) {
            aVar.a(z11, i12);
        }
        this.f75863o = z11;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zi(View view) {
        if (((LoginPresenter) getPresenter()).Y0()) {
            Intent intent = new Intent(this, SubAccountLoginActivityV2.class);
            intent.putExtra("USER_LOGIN_TYPE", 2);
            if (((LoginPresenter) getPresenter()).Q0() != null) {
                intent.putExtra("target", ((LoginPresenter) getPresenter()).Q0());
            }
            startActivity(intent);
            Ki("4833");
        } else {
            finish();
            Ki("4841");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void G0() {
        this.f75855g.dismissAnim();
        this.f75872x.G0();
    }

    public void He(HashMap<String, ThirdInfo> hashMap) {
        if (hashMap == null || hashMap.isEmpty() || !((LoginPresenter) getPresenter()).Y0() || ((LoginPresenter) getPresenter()).P0() != null) {
            this.F.setVisibility(4);
            return;
        }
        boolean z11 = false;
        this.F.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        for (ThirdInfo d11 : hashMap.values()) {
            String lowerCase = d11.d().toLowerCase();
            if (lowerCase.contains(LoginPresenter.f75468t.toLowerCase())) {
                this.E.setVisibility(0);
            } else if (lowerCase.contains(LoginPresenter.f75469u.toLowerCase())) {
                this.D.setVisibility(0);
            }
        }
        boolean z12 = this.D.getVisibility() == 0;
        boolean z13 = this.E.getVisibility() == 0;
        View view = this.B;
        if (z12 && z13) {
            z11 = true;
        }
        ViewUtil.m(view, z11);
        this.F.post(new d0(this));
    }

    public void Ji(String str, String str2, int i11, HashMap<String, Object> hashMap) {
        if (i11 != 0) {
            ((LoginPresenter) getPresenter()).J1(str, str2, hashMap);
        } else {
            this.f75855g.dismissAnim();
        }
        GrowingIOStatics.b(i11, hashMap);
    }

    public void K0() {
        CommonCaptchaDialog commonCaptchaDialog = this.f75862n;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    public final void Ki(String str) {
        if (((LoginPresenter) getPresenter()).Y0()) {
            is.a.j(str, (Map<String, Object>) null, "1005271");
        } else {
            is.a.j(str, (Map<String, Object>) null, "1005253");
        }
    }

    public void L5() {
        if (((LoginPresenter) getPresenter()).Y0()) {
            HistoryAccountDataManager.a().b();
        } else {
            HistoryAccountDataManager.a().c();
        }
    }

    public final void Li(Map<String, Object> map) {
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
            this.f75872x.Gi(str);
        }
    }

    public void N(String str) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this);
        this.f75862n = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(getResources().getString(R.string.login_dialog_captcha_title));
        this.f75862n.setCancelText(getResources().getString(R.string.login_dialog_cancel));
        this.f75862n.setConfirmText(getResources().getString(R.string.login_dialog_confirm));
        this.f75862n.setCaptchaImage(str);
        this.f75862n.show();
        this.f75862n.getImageView().setOnClickListener(new g0(this));
        this.f75862n.setCancelListener(new b0(this));
        this.f75862n.setConfirmListner(new c0(this));
        this.f75862n.getCaptchaEdit().addTextChangedListener(new k());
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f75862n;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f75862n.getCaptchaEdit().setText("");
        }
    }

    public void Q4(boolean z11, String str, String str2, String str3, Map<String, Object> map) {
        if (!this.f75872x.isAdded()) {
            this.f75872x.Ci(new j(z11, str, str2, str3, map));
            Li(map);
            FragmentTransaction q11 = getSupportFragmentManager().q();
            q11.e(this.f75872x, "BottomMenuFragment");
            q11.k();
        }
    }

    public void Ve(String str, String str2, RiskControl riskControl) {
        if (!isCanBeSeen()) {
            G0();
            return;
        }
        if (this.f75873y == null) {
            this.f75873y = new l(this);
        }
        this.f75873y.c(str, str2);
        this.f75874z.m(this, str, FirebaseAnalytics.Event.LOGIN, riskControl, this.f75873y);
    }

    public void a9(int i11) {
        pi();
    }

    public void ac() {
        this.f75872x.dismiss();
        SoftInputUtils.f(this);
    }

    public void addEvent() {
        this.f75857i.setOnClickListener(this);
        this.f75855g.setOnClickListener(this);
        this.f75860l.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.f75856h.setOnClickListener(this);
        this.f75853e.setOnTextChangedListener(new c());
        this.f75871w.setOnClickListener(new f0(this));
        this.f75853e.setOnFocusChangeListener(new d());
        this.f75854f.setOnFocusChangeListener(new e());
        this.f75854f.setOnTextChangedListener(new f());
        this.f75850b.setOnClickListener(new h0(this));
        oi();
        this.f75872x.setDialogFragmentListener(new g());
    }

    public void b2() {
        getString(R.string.login_sign_up_tips);
        String P0 = ((LoginPresenter) getPresenter()).P0();
        if (P0 != null) {
            getWindow().setSoftInputMode(48);
            this.f75869u.setVisibility(0);
            this.f75868t.setVisibility(0);
            this.f75865q.setVisibility(8);
            this.f75866r.setVisibility(8);
            this.A.setVisibility(8);
            this.f75855g.setButtonText((int) R.string.third_login_bind);
            String M0 = ((LoginPresenter) getPresenter()).M0();
            if (M0 != null) {
                this.f75853e.setText(M0);
                this.f75851c.setVisibility(8);
                this.f75852d.setVisibility(8);
                this.f75870v.setVisibility(0);
                this.f75856h.setVisibility(0);
                ViewUtil.l(this.f75867s, getString(R.string.third_login_bind_describe_two) + " " + M0, M0, getResources().getColor(R.color.global_small_area_bg_color), k0.f37284a);
                this.f75869u.setText(String.format(Locale.US, getString(R.string.third_login_bind_describe_three), new Object[]{P0}));
                return;
            }
            this.f75870v.setVisibility(8);
            this.f75851c.setVisibility(0);
            this.f75852d.setVisibility(0);
            this.f75856h.setVisibility(8);
            this.f75869u.setText(String.format(Locale.US, getString(R.string.third_login_bind_describe_one), new Object[]{P0}));
            return;
        }
        this.f75856h.setVisibility(8);
        this.f75855g.setButtonText((int) R.string.login_button);
        this.A.setVisibility(0);
        this.f75866r.setVisibility(0);
        this.f75865q.setVisibility(0);
        this.f75869u.setVisibility(8);
        this.f75868t.setVisibility(8);
        this.f75870v.setVisibility(8);
        L5();
        String e11 = ConfigPreferences.e("user_config", "config_email", "");
        if (!TextUtils.isEmpty(e11) && ((LoginPresenter) getPresenter()).Y0() && !wi(e11)) {
            this.f75858j = e11;
            this.f75853e.setText(e11);
            ClearEditText clearEditText = this.f75853e;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
            this.f75854f.requestFocus();
            this.f75854f.setFocusableInTouchMode(true);
            this.f75854f.setFocusable(true);
        }
        ni(this, new h());
    }

    public boolean canFullScreen() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g2(List<LoginInfoData.Login2FAOption> list, String str, Map<String, Object> map) {
        if (!this.f75872x.isAdded()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                LoginInfoData.Login2FAOption login2FAOption = list.get(i11);
                int type = login2FAOption.getType();
                if (type == 1) {
                    arrayList.add(getResources().getString(R.string.security_ga_title));
                } else if (type == 2) {
                    String tag = login2FAOption.getTag();
                    arrayList.add(getResources().getString(R.string.security_input_sms_hint));
                    arrayList2.add(ti(arrayList, tag, str, map, new l0(this, arrayList2)));
                } else if (type == 3) {
                    String tag2 = login2FAOption.getTag();
                    arrayList.add(getResources().getString(R.string.security_input_email_hint));
                    arrayList2.add(si(arrayList, tag2, str, map, new m0(this, arrayList2)));
                }
            }
            this.f75872x.Ci((SecurityStrategyController) arrayList2.get(0));
            FragmentTransaction q11 = getSupportFragmentManager().q();
            q11.e(this.f75872x, "BottomMenuFragment");
            q11.k();
        }
    }

    public int getContentView() {
        getWindow().setFlags(8192, 8192);
        return R.layout.activity_sub_account_login_v2;
    }

    public void initView() {
        this.f75853e = (ClearEditText) this.viewFinder.b(R.id.login_account_edit);
        this.f75851c = this.viewFinder.b(R.id.accountLayout);
        this.f75852d = this.viewFinder.b(R.id.pswLayout);
        this.f75854f = (ClearEditText) this.viewFinder.b(R.id.login_psw_edit);
        this.C = this.viewFinder.b(R.id.divider);
        this.f75850b = (TextView) this.viewFinder.b(R.id.login_sign_up);
        this.f75855g = (StatusButton) this.viewFinder.b(R.id.login_btn);
        this.f75857i = (TextView) this.viewFinder.b(R.id.login_forgot_psw);
        this.f75860l = (ImageView) this.viewFinder.b(R.id.login_psw_img);
        this.f75864p = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f75865q = (TextView) this.viewFinder.b(R.id.login_title);
        this.f75866r = (TextView) this.viewFinder.b(R.id.login_top_tips);
        this.f75867s = (TextView) this.viewFinder.b(R.id.bind_top_info_tips);
        this.f75868t = (TextView) this.viewFinder.b(R.id.bind_top_title);
        this.f75869u = (TextView) this.viewFinder.b(R.id.bind_top_tips);
        this.f75870v = (TextView) this.viewFinder.b(R.id.bind_top_info_tips);
        this.F = (LinearLayout) this.viewFinder.b(R.id.third_login_layout);
        this.f75856h = (Button) this.viewFinder.b(R.id.bind_other_account_btn);
        this.f75871w = (ImageView) this.viewFinder.b(R.id.login_close_btn);
        this.B = this.viewFinder.b(R.id.third_login_image_divider);
        this.D = this.viewFinder.b(R.id.third_login_image_google);
        this.E = this.viewFinder.b(R.id.third_login_image_facebook);
        this.H = (ScrollView) this.viewFinder.b(R.id.scrollContent);
        this.A = (TextView) this.viewFinder.b(R.id.tv_type_switch);
        ViewUtil.d(this.f75854f);
        this.f75854f.setTypeface(ResourcesCompat.h(this, R.font.roboto_medium));
        a0 a0Var = a0.f37245b;
        this.f75853e.setFilters(new InputFilter[]{a0Var});
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f75853e.setImportantForAutofill(2);
                this.f75854f.setImportantForAutofill(2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        vi();
        this.f75855g.setEnabled(false);
        this.f75855g.setButtonText(getString(R.string.login_button));
        this.f75855g.setBackgroundResource(R.drawable.login_v2_btn_bg);
    }

    public void n3() {
        this.f75855g.showAnim();
    }

    public void ni(Activity activity, ln.a aVar) {
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new j0(this, decorView, aVar));
    }

    public final void oi() {
        this.A.setOnClickListener(new e0(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f75874z.y(i11, i12, intent)) {
            G0();
        }
        if (LoginPresenter.f75469u.equals(((LoginPresenter) getPresenter()).f75484o) && ((LoginPresenter) getPresenter()).U0(LoginPresenter.f75469u) != null) {
            ((LoginPresenter) getPresenter()).U0(LoginPresenter.f75469u).onActivityResult(i11, i12, intent);
        }
        if (LoginPresenter.f75468t.equals(((LoginPresenter) getPresenter()).f75484o) && ((LoginPresenter) getPresenter()).U0(LoginPresenter.f75468t) != null) {
            ((LoginPresenter) getPresenter()).U0(LoginPresenter.f75468t).onActivityResult(i11, i12, intent);
        }
    }

    public void onBackPressed() {
        SoftInputUtils.f(this);
        if (!gj.e.b().f()) {
            finish();
        } else if (((LoginPresenter) getPresenter()).Y0()) {
            ((LoginPresenter) getPresenter()).G0();
        } else {
            finish();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind_other_account_btn:
                Intent intent = new Intent(this, SubAccountLoginActivityV2.class);
                intent.putExtra("bindType", ((LoginPresenter) getPresenter()).P0());
                intent.putExtra("third_token", ((LoginPresenter) getPresenter()).O0());
                if (((LoginPresenter) getPresenter()).Q0() != null) {
                    intent.putExtra("target", ((LoginPresenter) getPresenter()).Q0());
                }
                startActivity(intent);
                break;
            case R.id.login_btn:
                ((LoginPresenter) getPresenter()).L1(this.f75853e.getText().toString(), this.f75854f.getText().toString());
                this.f75855g.showAnim();
                Ki("4836");
                break;
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
                Ki("4834");
                break;
            case R.id.login_psw_img:
                if (!this.f75861m) {
                    this.f75860l.setImageResource(R.drawable.icon_eye_open);
                    this.f75861m = true;
                    this.f75854f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ClearEditText clearEditText = this.f75854f;
                    clearEditText.setSelection(clearEditText.getText().toString().length());
                    break;
                } else {
                    this.f75860l.setImageResource(R.drawable.icon_eye_close);
                    this.f75861m = false;
                    this.f75854f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ClearEditText clearEditText2 = this.f75854f;
                    clearEditText2.setSelection(clearEditText2.getText().toString().length());
                    break;
                }
            case R.id.third_login_image_facebook:
                ((LoginPresenter) getPresenter()).Q1(LoginPresenter.f75468t);
                break;
            case R.id.third_login_image_google:
                ((LoginPresenter) getPresenter()).Q1(LoginPresenter.f75469u);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtils.e(this, 0);
        changeStatusBarTextColor(!isLightStatusBar());
        this.f75874z = new VerifyHelper();
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
        if (!TextUtils.isEmpty(stringExtra) && ((LoginPresenter) getPresenter()).Y0() && !wi(stringExtra)) {
            this.f75853e.setText(stringExtra);
            this.f75854f.requestFocus();
            this.f75854f.setFocusableInTouchMode(true);
            this.f75854f.setFocusable(true);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void p2(int i11, String str, String str2, String str3, Map<String, Object> map) {
        this.f75872x.Ci(new i(i11, str, str2, str3, map));
        FragmentTransaction q11 = getSupportFragmentManager().q();
        q11.e(this.f75872x, "BottomMenuFragment");
        q11.k();
    }

    public final void pi() {
        L5();
        He(((LoginPresenter) getPresenter()).T0());
        b2();
        if (((LoginPresenter) getPresenter()).Y0()) {
            this.A.setText(getString(R.string.n_login_child_account_login));
            this.f75866r.setText(getString(R.string.n_login_account_input_title));
            this.f75850b.setVisibility(0);
            this.f75853e.setHint(R.string.n_login_account_input_placeholder);
            this.f75871w.setImageResource(R.drawable.login_close);
            this.f75865q.setText(getString(R.string.n_login_welcome_login));
            String e11 = ConfigPreferences.e("user_config", "config_email", "");
            if (TextUtils.isEmpty(e11) || !((LoginPresenter) getPresenter()).Y0() || wi(e11)) {
                this.f75853e.setText("");
                this.f75854f.setText("");
                return;
            }
            this.f75858j = e11;
            this.f75853e.setText(e11);
            ClearEditText clearEditText = this.f75853e;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
            this.f75854f.setText("");
            this.f75854f.requestFocus();
            this.f75854f.setFocusableInTouchMode(true);
            this.f75854f.setFocusable(true);
            return;
        }
        this.A.setText(getString(R.string.n_login_parent_account_login));
        this.f75866r.setText(getString(R.string.n_login_child_account));
        this.f75850b.setVisibility(8);
        this.f75853e.setHint(R.string.n_login_child_account_login_placeholder);
        this.f75865q.setText(getString(R.string.n_login_child_account_login));
        this.f75853e.setText("");
        this.f75853e.requestFocus();
        this.f75854f.setText("");
        this.f75871w.setImageResource(R.drawable.edge_engine_top_bar_back_normal);
    }

    public void qi() {
        if (TextUtils.isEmpty(this.f75858j) || TextUtils.isEmpty(this.f75859k)) {
            this.f75855g.setEnabled(false);
        } else if (!((LoginPresenter) getPresenter()).Y0()) {
            int length = this.f75858j.toString().length();
            if (length < 6 || length > 20 || StringUtils.o(this.f75858j.toString()) || m.Y(this.f75858j.toString())) {
                this.f75855g.setEnabled(false);
            } else {
                this.f75855g.setEnabled(true);
            }
        } else if (StringUtils.o(this.f75858j.toString()) || (m.Y(this.f75858j.toString()) && this.f75858j.toString().length() >= 5)) {
            this.f75855g.setEnabled(true);
        } else {
            this.f75855g.setEnabled(false);
        }
    }

    /* renamed from: ri */
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    public final SecurityStrategyControllerAdapter si(List<String> list, String str, String str2, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        return new b(str, list, hVar, map, str2);
    }

    public final SecurityStrategyControllerAdapter ti(List<String> list, String str, String str2, Map<String, Object> map, SecurityStrategyBottomMenuFragment.h hVar) {
        return new a(str, list, hVar, str2, map);
    }

    /* renamed from: ui */
    public LoginPresenter.d getUI() {
        return this;
    }

    public final void vi() {
        String string = getString(R.string.n_login_login_agree);
        String string2 = getString(R.string.privacy_agreement_url2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, new Object[]{string2}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new i0(this));
        this.f75864p.setMovementMethod(LinkMovementMethod.getInstance());
        this.f75864p.setText(spannableStringBuilder);
    }

    public final boolean wi(String str) {
        if (!StringUtils.o(str) && !m.Y(str)) {
            return true;
        }
        return false;
    }
}
