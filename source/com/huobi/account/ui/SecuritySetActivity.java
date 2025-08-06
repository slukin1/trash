package com.huobi.account.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.biometric.BiometricPrompt;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.presenter.SecuritySetPresenter;
import com.huobi.account.widget.SettingItemView;
import com.huobi.finance.ui.AddressManageActivity;
import com.huobi.login.ui.NinePointSetActivity;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.bean.SecuritySetData;
import com.huobi.login.usercenter.data.source.bean.UserContacts;
import com.huobi.login.usercenter.data.source.bean.UserSecurityLoginListData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.utils.FingerprintHelper;
import com.huobi.utils.GestureUtil;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import sn.f;
import tg.h;
import tg.r;

@Route(path = "/account/security")
public class SecuritySetActivity extends BaseActivity<SecuritySetPresenter, SecuritySetPresenter.a> implements View.OnClickListener, SecuritySetPresenter.a, EasyPermissions.PermissionCallbacks {
    public TextView A;
    public TextView B;
    public int C;
    public ImageView D;
    public boolean E;
    public boolean F;
    public boolean G;
    public View H;
    public TextView I;
    public TextView J;
    public TextView K;
    public RelativeLayout L;
    public RelativeLayout M;
    public SettingItemView N;
    public View O;
    public boolean P;
    public LinearLayout Q;
    public HbTitleBar R;
    public TextView S;
    public TextView T;
    public CompoundButton.OnCheckedChangeListener U = new a();
    public CompoundButton.OnCheckedChangeListener V = new b();

    /* renamed from: b  reason: collision with root package name */
    public View f41397b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41398c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41399d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41400e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41401f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41402g;

    /* renamed from: h  reason: collision with root package name */
    public ImageButton f41403h;

    /* renamed from: i  reason: collision with root package name */
    public ImageButton f41404i;

    /* renamed from: j  reason: collision with root package name */
    public ImageButton f41405j;

    /* renamed from: k  reason: collision with root package name */
    public int f41406k;

    /* renamed from: l  reason: collision with root package name */
    public int f41407l;

    /* renamed from: m  reason: collision with root package name */
    public int f41408m;

    /* renamed from: n  reason: collision with root package name */
    public int f41409n;

    /* renamed from: o  reason: collision with root package name */
    public String f41410o;

    /* renamed from: p  reason: collision with root package name */
    public String f41411p;

    /* renamed from: q  reason: collision with root package name */
    public SwitchCompat f41412q;

    /* renamed from: r  reason: collision with root package name */
    public SwitchCompat f41413r;

    /* renamed from: s  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f41414s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f41415t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f41416u;

    /* renamed from: v  reason: collision with root package name */
    public int f41417v;

    /* renamed from: w  reason: collision with root package name */
    public RelativeLayout f41418w;

    /* renamed from: x  reason: collision with root package name */
    public FingerprintHelper f41419x;

    /* renamed from: y  reason: collision with root package name */
    public View f41420y;

    /* renamed from: z  reason: collision with root package name */
    public View f41421z;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (SecuritySetActivity.this.f41419x.d()) {
                SecuritySetActivity.this.Qh(false);
                HuobiToastUtil.g(R.string.security_pattern_login_error);
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
                return;
            }
            boolean unused = SecuritySetActivity.this.f41415t = true;
            SecuritySetActivity securitySetActivity = SecuritySetActivity.this;
            securitySetActivity.Qh(securitySetActivity.f41416u);
            SecuritySetActivity.this.f41414s.show(SecuritySetActivity.this.getSupportFragmentManager(), "BottomMenuFragment");
            VibrateManager.a(SecuritySetActivity.this.f41412q);
            g.i("Security_pattern_Me_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {

        public class a extends BiometricPrompt.AuthenticationCallback {
            public a() {
            }

            public void a(int i11, CharSequence charSequence) {
                super.a(i11, charSequence);
                k.e(AppUtil.b("fingerprintHelper onAuthenticationError ", Integer.valueOf(i11), " errString:", charSequence));
                if (i11 == 7) {
                    HuobiToastUtil.k(SecuritySetActivity.this, R.string.n_login_unlock_much_times);
                } else if (i11 != 5) {
                    HuobiToastUtil.k(SecuritySetActivity.this, R.string.n_login_finger_fail);
                    SecuritySetActivity.this.Th();
                }
            }

            public void b() {
                super.b();
                k.e("fingerprintHelper onAuthenticationFailed");
            }

            public void c(BiometricPrompt.a aVar) {
                super.c(aVar);
                k.e("fingerprintHelper onAuthenticationSucceeded");
                SecuritySetActivity.this.Th();
                SecuritySetActivity.this.bi();
            }
        }

        public b() {
        }

        @SensorsDataInstrumented
        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (GestureUtil.c()) {
                SecuritySetActivity.this.Ph(false);
                HuobiToastUtil.g(R.string.security_fingerprint_error);
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
                return;
            }
            boolean unused = SecuritySetActivity.this.f41415t = false;
            SecuritySetActivity securitySetActivity = SecuritySetActivity.this;
            securitySetActivity.Ph(securitySetActivity.f41419x.d());
            SecuritySetActivity.this.f41419x.i(SecuritySetActivity.this, "", new a());
            VibrateManager.a(SecuritySetActivity.this.f41413r);
            g.i("Security_Fingerprint_Me_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public class c extends SecurityStrategyController {
        public c() {
        }

        public boolean A() {
            return false;
        }

        public boolean C() {
            return false;
        }

        public void W(APIStatusErrorException aPIStatusErrorException) {
            super.M(aPIStatusErrorException);
        }

        public void X() {
            super.X();
            SecuritySetActivity.this.f41414s.dismiss();
            if (SecuritySetActivity.this.f41415t) {
                SecuritySetActivity.this.Eh();
            } else if (SecuritySetActivity.this.f41419x.e()) {
                SecuritySetActivity securitySetActivity = SecuritySetActivity.this;
                securitySetActivity.Ph(securitySetActivity.f41419x.d());
                String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
                ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
            }
        }

        public void i(String str, String str2, String str3, String str4) {
            V(SecuritySetActivity.this, str4);
        }

        public String n() {
            return null;
        }

        public String o() {
            return null;
        }

        public Map<String, Object> p() {
            return null;
        }

        public Map<String, Object> s() {
            return null;
        }

        public boolean x() {
            return false;
        }

        public boolean y() {
            return false;
        }

        public boolean z() {
            return true;
        }
    }

    public class d extends BaseSubscriber<List<UserContacts>> {
        public d() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            onNext((List<UserContacts>) null);
        }

        public void onNext(List<UserContacts> list) {
            super.onNext(list);
            if (list == null || list.isEmpty()) {
                SecuritySetActivity.this.S.setText(R.string.n_setting_emergency_contact_off);
                SecuritySetActivity.this.S.setTextColor(SecuritySetActivity.this.getResources().getColor(R.color.global_huobi_color));
                SecuritySetActivity.this.S.setTag(Boolean.FALSE);
                return;
            }
            SecuritySetActivity.this.S.setText(R.string.n_setting_emergency_contact_on);
            SecuritySetActivity.this.S.setTextColor(SecuritySetActivity.this.getResources().getColor(R.color.global_secondary_text_color));
            SecuritySetActivity.this.S.setTag(Boolean.TRUE);
        }
    }

    public class e extends BaseSubscriber<List<UserContacts>> {
        public e() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            onNext((List<UserContacts>) null);
        }

        public void onNext(List<UserContacts> list) {
            super.onNext(list);
            if (list == null || list.isEmpty()) {
                SecuritySetActivity.this.T.setText(R.string.n_setting_beneficiary_off);
                SecuritySetActivity.this.T.setTextColor(SecuritySetActivity.this.getResources().getColor(R.color.global_huobi_color));
                return;
            }
            SecuritySetActivity.this.T.setText(R.string.n_setting_beneficiary_on);
            SecuritySetActivity.this.T.setTextColor(SecuritySetActivity.this.getResources().getColor(R.color.global_secondary_text_color));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(KvStore kvStore) {
        Yh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(CompoundButton compoundButton, boolean z11) {
        UserCenterRemoteDataSource.A().putKvStore(MapParamsBuilder.c().a(PlaceFields.WEBSITE, "2").a("store_key", KvStore.QUICK_WITHDRAW).a("store_value", z11 ? KvStore.Y : KvStore.N).b()).flatMap(q3.f41794b).compose(RxJavaHelper.t(getUI())).subscribe(q6.d.c(getUI(), new p3(this)));
        VibrateManager.a(compoundButton);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lh(View view) {
        DialogUtils.X(this, getString(R.string.setting_quickly_withdraw_dialog_title), getString(R.string.setting_quickly_withdraw_dialog_message), (String) null, getString(R.string.setting_quickly_withdraw_dialog_know), o3.f41779a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        g.i("app_beneficiary_setting", (HashMap) null);
        String str = f.j() + "user_center/contact-h5/contact-list?contactType=2";
        i6.d.c("SecuritySetActivity", "beneficiaryState-click-url=" + str);
        HBBaseWebActivity.showWebView(this, str, "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(ValueAnimator valueAnimator) {
        this.D.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.D.requestLayout();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        setResult(1682782729);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        String str;
        g.i("app_contacts_setting", (HashMap) null);
        String j11 = f.j();
        if (!(this.S.getTag() instanceof Boolean) || !((Boolean) this.S.getTag()).booleanValue()) {
            str = j11 + "user_center/contact-h5/contact-edit?contactType=1";
        } else {
            str = j11 + "user_center/contact-h5/contact-list?contactType=1";
        }
        i6.d.c("SecuritySetActivity", "contactsState-click-url=" + str);
        HBBaseWebActivity.showWebView(this, str, "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Dh */
    public SecuritySetPresenter createPresenter() {
        return new SecuritySetPresenter();
    }

    public final void Eh() {
        if (this.f41416u) {
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
            GestureUtil.a();
            r.x().l();
            this.f41416u = false;
            Qh(false);
            HuobiToastUtil.v(getString(R.string.close_complete));
            return;
        }
        startActivity(new Intent(getApplicationContext(), NinePointSetActivity.class));
    }

    /* renamed from: Fh */
    public SecuritySetPresenter.a getUI() {
        return this;
    }

    public final void Gh() {
        this.f41414s.Ci(new c());
    }

    public final void Oh(TextView textView, boolean z11) {
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.attention_style_1, 0, 0, 0);
            textView.setCompoundDrawablePadding(PixelUtils.a(5.0f));
            textView.setTextColor(getResources().getColor(R.color.baseCoinDangerousTip));
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        textView.setCompoundDrawablePadding(0);
        textView.setTextColor(getResources().getColor(R.color.global_secondary_text_color));
    }

    public final void Ph(boolean z11) {
        this.f41413r.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41413r.setChecked(z11);
        this.f41413r.setOnCheckedChangeListener(this.V);
    }

    public final void Qh(boolean z11) {
        this.f41412q.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f41412q.setChecked(z11);
        this.f41412q.setOnCheckedChangeListener(this.U);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Rh(com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData r12, com.huobi.login.usercenter.data.source.bean.SecurityStrategy r13) {
        /*
            r11 = this;
            r0 = 8
            r1 = 3
            r2 = 2
            r3 = 2132026512(0x7f142490, float:1.9691559E38)
            r4 = 2132026509(0x7f14248d, float:1.9691553E38)
            r5 = 0
            r6 = 1
            if (r12 == 0) goto L_0x0046
            tg.h r7 = tg.h.c()
            boolean r7 = r7.i()
            if (r7 == 0) goto L_0x0046
            int r7 = r12.getPasskey()
            android.widget.TextView r8 = r11.f41399d
            if (r7 != r6) goto L_0x0022
            r9 = r3
            goto L_0x0023
        L_0x0022:
            r9 = r4
        L_0x0023:
            r8.setText(r9)
            android.widget.TextView r8 = r11.f41398c
            if (r7 != r6) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r0 = r5
        L_0x002c:
            r8.setVisibility(r0)
            if (r7 != r6) goto L_0x0033
            r0 = r1
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            r11.f41408m = r0
            if (r7 != r6) goto L_0x003a
            r0 = r6
            goto L_0x003b
        L_0x003a:
            r0 = r5
        L_0x003b:
            int r0 = r0 + r5
            android.widget.TextView r8 = r11.f41399d
            if (r7 == r6) goto L_0x0041
            r5 = r6
        L_0x0041:
            r11.Oh(r8, r5)
            r5 = r0
            goto L_0x0061
        L_0x0046:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "SecuritySetActivity: securityInfo "
            r7.append(r8)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "HBPasskey"
            i6.k.d(r8, r7)
            android.view.View r7 = r11.f41397b
            r7.setVisibility(r0)
        L_0x0061:
            r0 = 0
            r7 = 2132026540(0x7f1424ac, float:1.9691615E38)
            if (r12 == 0) goto L_0x0094
            java.lang.String r8 = r12.getEmail()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0094
            boolean r8 = r13.isVerify_email()
            android.widget.TextView r9 = r11.f41401f
            if (r8 == 0) goto L_0x007b
            r10 = r3
            goto L_0x007c
        L_0x007b:
            r10 = r4
        L_0x007c:
            r9.setText(r10)
            java.lang.String r9 = r12.getEmail()
            r11.f41410o = r9
            if (r8 == 0) goto L_0x0089
            r9 = r1
            goto L_0x008a
        L_0x0089:
            r9 = r2
        L_0x008a:
            r11.f41407l = r9
            int r5 = r5 + r8
            android.widget.TextView r9 = r11.f41401f
            r8 = r8 ^ r6
            r11.Oh(r9, r8)
            goto L_0x00a2
        L_0x0094:
            android.widget.TextView r8 = r11.f41401f
            r8.setText(r7)
            r11.f41410o = r0
            r11.f41407l = r6
            android.widget.TextView r8 = r11.f41401f
            r11.Oh(r8, r6)
        L_0x00a2:
            if (r12 == 0) goto L_0x00d1
            java.lang.String r8 = r12.getPhone()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x00d1
            boolean r0 = r13.isVerify_phone()
            android.widget.TextView r8 = r11.f41400e
            if (r0 == 0) goto L_0x00b8
            r9 = r3
            goto L_0x00b9
        L_0x00b8:
            r9 = r4
        L_0x00b9:
            r8.setText(r9)
            java.lang.String r8 = r12.getPhone()
            r11.f41411p = r8
            if (r0 == 0) goto L_0x00c6
            r8 = r1
            goto L_0x00c7
        L_0x00c6:
            r8 = r2
        L_0x00c7:
            r11.f41409n = r8
            int r5 = r5 + r0
            android.widget.TextView r8 = r11.f41400e
            r0 = r0 ^ r6
            r11.Oh(r8, r0)
            goto L_0x00df
        L_0x00d1:
            android.widget.TextView r8 = r11.f41400e
            r8.setText(r7)
            r11.f41411p = r0
            r11.f41409n = r6
            android.widget.TextView r0 = r11.f41400e
            r11.Oh(r0, r6)
        L_0x00df:
            if (r12 == 0) goto L_0x0111
            int r12 = r12.getAssetGa()
            if (r12 != r6) goto L_0x0111
            boolean r12 = r13.isVerify_ga()
            r11.P = r12
            if (r12 != 0) goto L_0x00f6
            r12 = 4
            tg.f.j(r12)
            r11.Xh()
        L_0x00f6:
            android.widget.TextView r12 = r11.f41402g
            boolean r13 = r11.P
            if (r13 == 0) goto L_0x00fd
            goto L_0x00fe
        L_0x00fd:
            r3 = r4
        L_0x00fe:
            r12.setText(r3)
            boolean r12 = r11.P
            if (r12 == 0) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r1 = r2
        L_0x0107:
            r11.f41406k = r1
            int r5 = r5 + r12
            android.widget.TextView r13 = r11.f41402g
            r12 = r12 ^ r6
            r11.Oh(r13, r12)
            goto L_0x011d
        L_0x0111:
            android.widget.TextView r12 = r11.f41402g
            r12.setText(r7)
            r11.f41406k = r6
            android.widget.TextView r12 = r11.f41402g
            r11.Oh(r12, r6)
        L_0x011d:
            tg.r r12 = tg.r.x()
            boolean r12 = r12.X()
            if (r12 != 0) goto L_0x012a
            r11.Zh(r5)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.SecuritySetActivity.Rh(com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData, com.huobi.login.usercenter.data.source.bean.SecurityStrategy):void");
    }

    public final void Sh(int i11, boolean z11) {
        if (z11) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, i11});
            ofInt.setDuration(350);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new i3(this));
            ofInt.start();
            this.E = false;
            return;
        }
        this.D.getLayoutParams().width = i11;
        this.D.requestLayout();
    }

    public final void Th() {
        this.f41419x.a();
        this.f41419x.j();
    }

    public final void Uh() {
        ((SecuritySetPresenter) getPresenter()).S(1).subscribe(new d());
        ((SecuritySetPresenter) getPresenter()).S(2).subscribe(new e());
    }

    @SuppressLint({"SetTextI18n"})
    public final void Vh(UserSecurityLoginListData userSecurityLoginListData) {
        if (userSecurityLoginListData != null) {
            TextView textView = this.J;
            textView.setText(getResources().getString(R.string.n_security_center_last_login_time) + DateTimeUtils.g(userSecurityLoginListData.getGmtCreated()));
            TextView textView2 = this.K;
            textView2.setText(getResources().getString(R.string.n_security_center_last_login_way) + userSecurityLoginListData.getWay());
            i6.d.j("updateDestroyLoginInfo: ", userSecurityLoginListData.toString());
            return;
        }
        TextView textView3 = this.J;
        textView3.setText(getResources().getString(R.string.n_security_center_last_login_time) + "--");
        TextView textView4 = this.K;
        textView4.setText(getResources().getString(R.string.n_security_center_last_login_way) + "--");
    }

    public final void Wh() {
        this.f41416u = GestureUtil.c();
        int c11 = this.f41419x.c();
        this.f41417v = c11;
        if (c11 == 0) {
            this.f41418w.setVisibility(8);
        } else if (c11 == 1) {
            this.f41418w.setVisibility(0);
            if (this.f41416u) {
                String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
                if (ConfigPreferences.e("user_config", e11 + "_" + "finger_state", "finger_state_close").equals("finger_state_open")) {
                    ConfigPreferences.m("user_config", e11 + "_" + "finger_state", "finger_state_close");
                }
                Ph(false);
                ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
            } else {
                Ph(true);
            }
        } else if (c11 == 2) {
            this.f41418w.setVisibility(0);
            Ph(false);
        }
        Qh(this.f41416u);
    }

    public final void Xh() {
        TextView textView = this.I;
        if (textView != null) {
            textView.setText(tg.f.c(this));
        }
    }

    public void Y(SecuritySetData securitySetData) {
        Rh(securitySetData.b(), securitySetData.a().getSetting());
        ai(securitySetData.d());
        Vh(securitySetData.c());
    }

    public final void Yh() {
        Map<String, String> B2 = UserCenterRemoteDataSource.A().B();
        this.N.setChecked(B2.get(KvStore.QUICK_WITHDRAW) != null && KvStore.Y.equals(B2.get(KvStore.QUICK_WITHDRAW)));
    }

    public final void Zh(int i11) {
        int i12;
        int i13;
        int i14 = 3;
        if (i11 >= 3) {
            this.f41420y.setVisibility(0);
            this.f41421z.setVisibility(0);
            this.A.setVisibility(8);
            this.B.setTextColor(getResources().getColor(R.color.kyc_auth_success));
            this.B.setText(R.string.highest);
            this.D.setBackground(getResources().getDrawable(R.drawable.bg_security_level3));
            i13 = this.C;
        } else {
            i14 = 2;
            if (i11 == 2) {
                this.f41420y.setVisibility(0);
                this.f41421z.setVisibility(0);
                this.A.setVisibility(8);
                this.B.setTextColor(getResources().getColor(R.color.otc_order_item_release_color));
                this.B.setText(R.string.middle);
                this.D.setBackground(getResources().getDrawable(R.drawable.bg_security_level2));
                i13 = this.C;
            } else {
                this.f41420y.setVisibility(0);
                this.f41421z.setVisibility(0);
                this.A.setVisibility(0);
                this.B.setTextColor(getResources().getColor(R.color.baseCoinDangerousTip));
                this.B.setText(R.string.lowest);
                this.D.setBackground(getResources().getDrawable(R.drawable.bg_security_level1));
                i12 = this.C;
                Sh(i12, this.E);
            }
        }
        i12 = i13 * i14;
        Sh(i12, this.E);
    }

    public void addEvent() {
        this.viewFinder.b(R.id.layout_first_item).setOnClickListener(this);
        this.viewFinder.b(R.id.layout_passkey_item).setOnClickListener(this);
        this.viewFinder.b(R.id.layout_binding_email).setOnClickListener(this);
        this.viewFinder.b(R.id.layout_binding_ga).setOnClickListener(this);
        this.viewFinder.b(R.id.security_login_constrain_layout).setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.f41412q.setOnCheckedChangeListener(this.U);
        this.f41413r.setOnCheckedChangeListener(this.V);
        this.f41414s = new SecurityStrategyBottomMenuFragment();
        Gh();
        this.N.setChangeListener(new n3(this));
        this.N.setTipsClickListener(new l3(this));
    }

    public final void ai(UserVO userVO) {
        boolean z11 = true;
        this.F = userVO != null && userVO.isIsTradeBind();
        if (userVO == null || !userVO.isVerifyWayHaveSet()) {
            z11 = false;
        }
        this.G = z11;
    }

    public final void bi() {
        if (this.f41415t) {
            Eh();
        } else if (this.f41419x.e()) {
            Ph(this.f41419x.d());
            String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
            ConfigPreferences.k("user_config", e11 + "_" + "config_gesture_switch", 3);
        }
    }

    public boolean canFullScreen() {
        return true;
    }

    public int getContentView() {
        return R.layout.activity_security_set;
    }

    public void initView() {
        removeWinBg();
        this.f41397b = this.viewFinder.b(R.id.layout_passkey_item);
        this.f41398c = (TextView) this.viewFinder.b(R.id.tv_passkey_recommend);
        this.f41399d = (TextView) this.viewFinder.b(R.id.tv_binding_passkey);
        this.f41400e = (TextView) this.viewFinder.b(R.id.tv_binding_mobile);
        this.f41401f = (TextView) this.viewFinder.b(R.id.tv_binding_email);
        this.f41402g = (TextView) this.viewFinder.b(R.id.tv_binding_ga);
        this.f41404i = (ImageButton) this.viewFinder.b(R.id.btn_binding_passkey);
        this.f41403h = (ImageButton) this.viewFinder.b(R.id.btn_binding_email);
        this.f41405j = (ImageButton) this.viewFinder.b(R.id.btn_binding_ga);
        this.f41412q = (SwitchCompat) this.viewFinder.b(R.id.cb_gesture_password_item_status);
        this.f41413r = (SwitchCompat) this.viewFinder.b(R.id.cb_fingerprint_unlock_item_status);
        this.f41418w = (RelativeLayout) this.viewFinder.b(R.id.layout_fingerprint_unlock_item);
        this.f41420y = this.viewFinder.b(R.id.ll_security_level_area);
        this.f41421z = this.viewFinder.b(R.id.rl_security_level_progress_area);
        this.A = (TextView) this.viewFinder.b(R.id.tv_security_level_tips);
        this.B = (TextView) this.viewFinder.b(R.id.tv_security_level_value);
        this.D = (ImageView) this.viewFinder.b(R.id.iv_security_level);
        this.C = (PixelUtils.g() - (PixelUtils.a(15.0f) * 2)) / 3;
        this.E = true;
        this.H = this.viewFinder.b(R.id.layout_security_keep_login_time);
        this.I = (TextView) this.viewFinder.b(R.id.tv_btn_keep_login_time);
        this.Q = (LinearLayout) this.viewFinder.b(R.id.ll_action_area);
        this.J = (TextView) this.viewFinder.b(R.id.security_some_login_time);
        this.K = (TextView) this.viewFinder.b(R.id.security_some_login_style);
        this.L = (RelativeLayout) this.viewFinder.b(R.id.security_login_pass_update);
        this.O = this.viewFinder.b(R.id.layout_out_other_layout);
        this.N = (SettingItemView) this.viewFinder.b(R.id.layout_quickly_withdraw);
        this.M = (RelativeLayout) this.viewFinder.b(R.id.layout_out_address_message);
        int i11 = 0;
        ViewUtil.m(this.N, r.x().F0() && !r.x().X());
        Yh();
        if (r.x().X()) {
            int childCount = this.Q.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                this.Q.getChildAt(i12).setVisibility(8);
            }
            this.viewFinder.b(R.id.ll_other_area).setVisibility(0);
            this.L.setVisibility(8);
            this.viewFinder.b(R.id.security_login_constrain_layout).setVisibility(0);
        }
        boolean i13 = h.c().i();
        k.d("HBPasskey", "SecuritySetActivity: show passkey " + i13);
        View view = this.f41397b;
        if (!i13) {
            i11 = 8;
        }
        view.setVisibility(i11);
        ViewUtil.m(this.O, true ^ r.x().X());
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.R = hbTitleBar;
        hbTitleBar.setOnClickBackListener(new k3(this));
        this.S = (TextView) this.viewFinder.b(R.id.contacts_state);
        this.T = (TextView) this.viewFinder.b(R.id.beneficiary_state);
        this.S.setOnClickListener(new j3(this));
        this.T.setOnClickListener(new m3(this));
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Intent intent;
        Class<SecurityLinkActivity> cls = SecurityLinkActivity.class;
        Class<SecurityLinkStatusActivity> cls2 = SecurityLinkStatusActivity.class;
        switch (view.getId()) {
            case R.id.layout_binding_email:
                int i11 = this.f41407l;
                if (i11 > 1) {
                    Intent intent2 = new Intent(this, cls2);
                    intent2.putExtra("LINK_TYPE_KEY", 2);
                    intent2.putExtra("VERIFY_STATUS_KEY", this.f41407l);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent2.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent2.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent2);
                } else if (i11 == 1) {
                    Intent intent3 = new Intent(this, cls);
                    intent3.putExtra("LINK_TYPE_KEY", 2);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent3.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent3.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent3);
                }
                g.i("Security_email_Me_click", (HashMap) null);
                g.i("APP_set_security_button_click", new HashMap<String, Object>() {
                    {
                        put("button_name", "2");
                    }
                });
                break;
            case R.id.layout_binding_ga:
                int i12 = this.f41406k;
                if (i12 > 1) {
                    Intent intent4 = new Intent(this, cls2);
                    intent4.putExtra("LINK_TYPE_KEY", 3);
                    intent4.putExtra("VERIFY_STATUS_KEY", this.f41406k);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent4.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent4.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent4);
                } else if (i12 == 1) {
                    Intent intent5 = new Intent(this, cls);
                    intent5.putExtra("LINK_TYPE_KEY", 3);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent5.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent5.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent5);
                }
                g.i("Security_authenticator_Me_click", (HashMap) null);
                g.i("APP_set_security_button_click", new HashMap<String, Object>() {
                    {
                        put("button_name", "3");
                    }
                });
                break;
            case R.id.layout_first_item:
                int i13 = this.f41409n;
                if (i13 > 1) {
                    Intent intent6 = new Intent(this, cls2);
                    intent6.putExtra("LINK_TYPE_KEY", 1);
                    intent6.putExtra("VERIFY_STATUS_KEY", this.f41409n);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent6.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent6.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent6);
                } else if (i13 == 1) {
                    Intent intent7 = new Intent(this, cls);
                    intent7.putExtra("LINK_TYPE_KEY", 1);
                    if (!TextUtils.isEmpty(this.f41410o)) {
                        intent7.putExtra("BIND_EMAIL_KEY", this.f41410o);
                    }
                    if (!TextUtils.isEmpty(this.f41411p)) {
                        intent7.putExtra("BIND_PHONE_KEY", this.f41411p);
                    }
                    startActivity(intent7);
                }
                g.i("Security_phone_Me_click", (HashMap) null);
                g.i("APP_set_security_button_click", new HashMap<String, Object>() {
                    {
                        put("button_name", "1");
                    }
                });
                break;
            case R.id.layout_out_address_message:
                AddressManageActivity.xj(this);
                g.i("Security_Withdrawal_address_Me_click", (HashMap) null);
                break;
            case R.id.layout_passkey_item:
                if (this.f41408m == 3) {
                    intent = new Intent(this, SecurityPasskeyListActivity.class);
                } else {
                    intent = new Intent(this, SecurityPasskeyActivity.class);
                }
                startActivity(intent);
                break;
            case R.id.security_login_constrain_layout:
                startActivity(new Intent(this, SecurityRecordActivity.class));
                break;
            case R.id.security_login_pass_update:
                PassUpdateActivity.Di(this);
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f41419x = new FingerprintHelper();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        i6.d.j("QR-SCAN", "onPermissionsGranted requestCode=" + i11 + " perms=" + list);
    }

    public void onResume() {
        super.onResume();
        Xh();
        Uh();
    }

    public void onStart() {
        super.onStart();
        Wh();
        ((SecuritySetPresenter) getPresenter()).W();
        g.i("Security_Me_view", (HashMap) null);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
