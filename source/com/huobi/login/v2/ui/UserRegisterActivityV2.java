package com.huobi.login.v2.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.MarqueeView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.login.bean.AccountVerifyBean;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.holder.EmailAssociationAdapter;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.bean.RegisterCheckIpData;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.usercenter.data.source.bean.VerifyAuthCodeData;
import com.huobi.login.utils.VerifyHelper;
import com.huobi.utils.SpannableUtils;
import com.huobi.utils.k0;
import com.huobi.view.CommonCaptchaDialog;
import com.huobi.view.button.StatusButton;
import com.huobi.view.radiogroup.RadioGroupContainer;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.MiPushClient;
import gs.g;
import i6.m;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import sn.w;
import tn.a2;
import tn.b2;
import tn.c2;
import tn.d2;
import tn.e2;
import tn.l1;
import tn.m1;
import tn.n1;
import tn.o1;
import tn.p1;
import tn.q1;
import tn.r1;
import tn.s1;
import tn.t1;
import tn.u1;
import tn.v1;
import tn.w1;
import tn.x1;
import tn.y1;
import tn.z1;
import z9.g1;

public class UserRegisterActivityV2 extends BaseActivity<UserRegisterV2Presenter, UserRegisterV2Presenter.j> implements UserRegisterV2Presenter.j, View.OnClickListener {
    public static final String F = ("REGISTER_CHECK_IP_AREA" + UserRegisterActivityV2.class.getName());
    public View A;
    public MarqueeView B;
    public RegisterCheckIpData C;
    public View D;
    public boolean E = false;

    /* renamed from: b  reason: collision with root package name */
    public String f75993b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75994c;

    /* renamed from: d  reason: collision with root package name */
    public ClearEditText f75995d;

    /* renamed from: e  reason: collision with root package name */
    public ClearEditText f75996e;

    /* renamed from: f  reason: collision with root package name */
    public View f75997f;

    /* renamed from: g  reason: collision with root package name */
    public View f75998g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f75999h;

    /* renamed from: i  reason: collision with root package name */
    public StatusButton f76000i;

    /* renamed from: j  reason: collision with root package name */
    public String f76001j;

    /* renamed from: k  reason: collision with root package name */
    public String f76002k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f76003l;

    /* renamed from: m  reason: collision with root package name */
    public CommonCaptchaDialog f76004m;

    /* renamed from: n  reason: collision with root package name */
    public VerifyHelper f76005n;

    /* renamed from: o  reason: collision with root package name */
    public Parcelable f76006o;

    /* renamed from: p  reason: collision with root package name */
    public View f76007p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f76008q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f76009r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f76010s;

    /* renamed from: t  reason: collision with root package name */
    public RadioGroupContainer f76011t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f76012u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f76013v;

    /* renamed from: w  reason: collision with root package name */
    public PopupWindow f76014w;

    /* renamed from: x  reason: collision with root package name */
    public RecyclerView f76015x;

    /* renamed from: y  reason: collision with root package name */
    public EmailAssociationAdapter f76016y;

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f76017z;

    public class a extends BaseSubscriber<RegisterCheckIpData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g1 f76018b;

        public a(g1 g1Var) {
            this.f76018b = g1Var;
        }

        /* renamed from: a */
        public void onNext(RegisterCheckIpData registerCheckIpData) {
            super.onNext(registerCheckIpData);
            UserRegisterActivityV2.this.mi(registerCheckIpData);
        }

        public void onAfter() {
            super.onAfter();
            this.f76018b.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (UserRegisterActivityV2.this.f76014w == null || !UserRegisterActivityV2.this.f76014w.isShowing()) {
                SoftInputUtils.f(UserRegisterActivityV2.this);
            } else {
                UserRegisterActivityV2.this.Oh(false);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements VerifyHelper.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f76021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76023c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f76024d;

        public c(String str, String str2, String str3, boolean z11) {
            this.f76021a = str;
            this.f76022b = str2;
            this.f76023c = str3;
            this.f76024d = z11;
        }

        public void a(int i11, int i12, Intent intent) {
            UserRegisterActivityV2.this.onActivityResult(i11, i12, intent);
        }

        public void b(int i11, HashMap<String, Object> hashMap) {
            if (i11 == 0) {
                UserRegisterActivityV2.this.f76000i.dismissAnim();
            } else if (!TextUtils.isEmpty(this.f76021a)) {
                ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).A1(this.f76021a, hashMap, (String) null, (String) null, "REGISTER");
            } else {
                ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).D1(this.f76022b, this.f76023c, hashMap, (String) null, (String) null, this.f76024d, "REGISTER");
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).w1();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements CommonCaptchaDialog.CommonDialogClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f76027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f76028b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76029c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f76030d;

        public e(String str, String str2, String str3, boolean z11) {
            this.f76027a = str;
            this.f76028b = str2;
            this.f76029c = str3;
            this.f76030d = z11;
        }

        public void onCommonDialogClick(Dialog dialog, int i11) {
            String obj = UserRegisterActivityV2.this.f76004m.getCaptchaEdit().getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() >= 5) {
                UserRegisterActivityV2.this.showProgressDialog();
                if (!TextUtils.isEmpty(this.f76027a)) {
                    ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).A1(this.f76027a, (HashMap<String, Object>) null, ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).G0(), obj, "REGISTER");
                } else {
                    ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).D1(this.f76028b, this.f76029c, (HashMap<String, Object>) null, ((UserRegisterV2Presenter) UserRegisterActivityV2.this.getPresenter()).G0(), obj, this.f76030d, "REGISTER");
                }
            }
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence.length() < 5) {
                UserRegisterActivityV2.this.f76004m.getRightBtn().setEnabled(false);
            } else {
                UserRegisterActivityV2.this.f76004m.getRightBtn().setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sh(CharSequence charSequence, int i11, int i12, int i13) {
        if (charSequence.length() > 0) {
            ClearEditText clearEditText = this.f75995d;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        } else {
            ClearEditText clearEditText2 = this.f75995d;
            clearEditText2.setTypeface(ResourcesCompat.h(clearEditText2.getContext(), R.font.roboto_regular));
        }
        Mh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Th(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_关闭按钮");
        g.i("app_RegisterProcess_button_click", hashMap);
        g.i("App_register_shut_click", (HashMap) null);
        onBackPressed();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(View view, boolean z11) {
        this.f75998g.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(View view, boolean z11) {
        this.f75997f.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        if (i11 == R.id.type_email_tab) {
            this.f75993b = "register_email";
        } else {
            this.f75993b = "register_mobile";
        }
        RegisterCheckIpData registerCheckIpData = this.C;
        if (registerCheckIpData == null || !"STRENGTHENING_AREA".equalsIgnoreCase(registerCheckIpData.getLimitType())) {
            ri(false);
        } else {
            ri(true);
        }
        if (i11 == R.id.type_email_tab) {
            PopupWindow popupWindow = this.f76014w;
            if (popupWindow != null && !popupWindow.isShowing() && this.E) {
                int[] iArr = new int[2];
                this.f75996e.getLocationInWindow(iArr);
                PopupWindow popupWindow2 = this.f76014w;
                ClearEditText clearEditText = this.f75996e;
                popupWindow2.showAtLocation(clearEditText, 48, 0, iArr[1] + clearEditText.getHeight() + getResources().getDimensionPixelSize(R.dimen.dimen_4));
                return;
            }
            return;
        }
        Oh(true);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Xh(View view) {
        HuobiToastUtil.j(R.string.n_regist_coutry_ban);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yh(View view) {
        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_code");
        intent.putExtra("SHOW_COUNTRY_ICON", true);
        startActivityForResult(intent, 1001);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zh(String str) {
        this.f75996e.setText(str);
        this.f75996e.setSelection(str.length());
        Oh(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(CharSequence charSequence, int i11, int i12, int i13) {
        if (charSequence.length() > 0) {
            ClearEditText clearEditText = this.f75996e;
            clearEditText.setTypeface(ResourcesCompat.h(clearEditText.getContext(), R.font.roboto_medium));
        } else {
            ClearEditText clearEditText2 = this.f75996e;
            clearEditText2.setTypeface(ResourcesCompat.h(clearEditText2.getContext(), R.font.roboto_regular));
        }
        Mh();
        if (this.f76014w == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.register_email_association, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(inflate);
            this.f76014w = popupWindow;
            popupWindow.setWidth(-1);
            this.f76014w.setHeight(getResources().getDimensionPixelSize(R.dimen.dimen_160));
            this.f76015x = (RecyclerView) inflate.findViewById(R.id.recyclerView);
            EmailAssociationAdapter emailAssociationAdapter = new EmailAssociationAdapter();
            this.f76016y = emailAssociationAdapter;
            emailAssociationAdapter.h(new s1(this));
            this.f76015x.setLayoutManager(new LinearLayoutManager(this));
            this.f76015x.setAdapter(this.f76016y);
        }
        this.f76016y.g(charSequence.toString());
        if (charSequence.length() <= 0 || this.f76016y.getItemCount() <= 0) {
            Oh(false);
            return;
        }
        if (!this.f76014w.isShowing()) {
            int[] iArr = new int[2];
            this.f75996e.getLocationInWindow(iArr);
            PopupWindow popupWindow2 = this.f76014w;
            ClearEditText clearEditText3 = this.f75996e;
            popupWindow2.showAtLocation(clearEditText3, 48, 0, iArr[1] + clearEditText3.getHeight() + getResources().getDimensionPixelSize(R.dimen.dimen_4));
        }
        this.f76014w.update(-1, getResources().getDimensionPixelSize(R.dimen.dimen_40) * Math.min(this.f76016y.getItemCount(), 3));
        this.f76016y.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bi(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_用户协议");
        g.i("app_RegisterProcess_button_click", hashMap);
        sn.f.g0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_隐私条款");
        g.i("app_RegisterProcess_button_click", hashMap);
        sn.f.b0(this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void di(CountryListData countryListData) {
        this.f76001j = countryListData.a();
        this.f76002k = String.valueOf(countryListData.c());
        this.f76008q.setText(String.valueOf(this.f76001j.replace("00", "+")));
        qi(this.f76002k);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "注册页_登录按钮");
        g.i("app_RegisterProcess_button_click", hashMap);
        Intent intent = new Intent(this, UserLoginActivityV2.class);
        intent.addFlags(67108864);
        Parcelable parcelable = this.f76006o;
        if (parcelable != null) {
            intent.putExtra("target", parcelable);
        } else {
            Intent h11 = k0.h(this);
            intent.putExtra("target", new JumpTarget(h11, h11));
        }
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
        ni("4809");
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void fi(HBDialogFragment hBDialogFragment, View view) {
        hBDialogFragment.dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void gi(HBDialogFragment hBDialogFragment, View view) {
        hBDialogFragment.dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void hi(RegisterCheckIpData registerCheckIpData, View view, HBDialogFragment hBDialogFragment) {
        ((TextView) view.findViewById(R.id.content)).setText(registerCheckIpData.getAlterMsg());
        view.findViewById(R.id.close).setOnClickListener(new x1(hBDialogFragment));
        view.findViewById(R.id.confirm).setOnClickListener(new w1(hBDialogFragment));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(HBDialogFragment hBDialogFragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "1");
        g.i("app_RegisterProcess_button_click", hashMap);
        hBDialogFragment.dismissAllowingStateLoss();
        oi();
    }

    public static /* synthetic */ void ji(HBDialogFragment hBDialogFragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "2");
        g.i("app_RegisterProcess_button_click", hashMap);
        hBDialogFragment.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void ki(DialogInterface dialogInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", "2");
        g.i("app_RegisterProcess_button_click", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(Dialog dialog, int i11) {
        this.f76004m.dismiss();
        this.f76000i.dismissAnim();
    }

    public void B4() {
        finish();
    }

    public void B9() {
    }

    public void G0() {
        this.f76000i.dismissAnim();
    }

    public void J8(AccountVerifyBean accountVerifyBean) {
    }

    public void K0() {
        CommonCaptchaDialog commonCaptchaDialog = this.f76004m;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.dismiss();
        }
    }

    public void Me(VerifyAuthCodeData verifyAuthCodeData) {
    }

    public final void Mh() {
        RegisterCheckIpData registerCheckIpData = this.C;
        if (registerCheckIpData != null && "STRENGTHENING_AREA".equalsIgnoreCase(registerCheckIpData.getLimitType())) {
            this.f76000i.setEnabled(false);
        } else if (Rh()) {
            String obj = this.f75996e.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                this.f76000i.setEnabled(false);
            } else if (StringUtils.o(obj)) {
                this.f76000i.setEnabled(true);
            } else {
                this.f76000i.setEnabled(false);
            }
        } else {
            String obj2 = this.f75995d.getText().toString();
            if (TextUtils.isEmpty(obj2)) {
                this.f76000i.setEnabled(false);
            } else if (!m.Y(obj2) || obj2.length() < 5) {
                this.f76000i.setEnabled(false);
            } else {
                this.f76000i.setEnabled(true);
            }
        }
    }

    /* renamed from: Nh */
    public UserRegisterV2Presenter createPresenter() {
        return new UserRegisterV2Presenter();
    }

    public final void Oh(boolean z11) {
        PopupWindow popupWindow = this.f76014w;
        if (popupWindow == null || !popupWindow.isShowing()) {
            this.E = false;
            return;
        }
        this.f76014w.dismiss();
        this.E = z11;
    }

    /* renamed from: Ph */
    public UserRegisterV2Presenter.j getUI() {
        return this;
    }

    public void Q0(Bitmap bitmap) {
        CommonCaptchaDialog commonCaptchaDialog = this.f76004m;
        if (commonCaptchaDialog != null) {
            commonCaptchaDialog.getImageView().setImageBitmap(bitmap);
            this.f76004m.getCaptchaEdit().setText("");
        }
    }

    public final void Qh() {
        String string = getString(R.string.n_login_simple_register_agree_new);
        String string2 = getString(R.string.privacy_agreement_url2);
        String string3 = getString(R.string.n_me_about_user_privacy_policy);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(Locale.US, string, new Object[]{string2, string3}));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.baseColorThreeLevelText)), 0, spannableStringBuilder.length(), 17);
        SpannableUtils.d(this, spannableStringBuilder, string2, new y1(this));
        SpannableUtils.d(this, spannableStringBuilder, string3, new a2(this));
        this.f76009r.setMovementMethod(LinkMovementMethod.getInstance());
        this.f76009r.setText(spannableStringBuilder);
    }

    public final boolean Rh() {
        return "register_email".equalsIgnoreCase(this.f75993b);
    }

    public void U8(HomeActivityEntityResponse homeActivityEntityResponse) {
        List<HomeActivityEntity> list;
        if (homeActivityEntityResponse != null && (list = homeActivityEntityResponse.adList) != null && !list.isEmpty()) {
            String str = null;
            if (NightHelper.e().g()) {
                str = homeActivityEntityResponse.adList.get(0).getUrl();
            }
            if (TextUtils.isEmpty(str)) {
                str = homeActivityEntityResponse.adList.get(0).getImg();
            }
            g6.b.c().h(this.f76013v, str);
        }
    }

    public void V8(String str) {
    }

    public void Vc() {
        if (this.f75993b.equals("register_email")) {
            CaptchaCodeActivityV2.Th(this, this.f75993b, this.f75996e.getText().toString(), this.f76001j, this.f76002k, (String) null, (String) null, ((UserRegisterV2Presenter) getPresenter()).E0(), false, "REGISTER");
            return;
        }
        CaptchaCodeActivityV2.Th(this, this.f75993b, this.f75995d.getText().toString(), this.f76001j.replace("+", "00"), this.f76002k, (String) null, (String) null, ((UserRegisterV2Presenter) getPresenter()).E0(), false, "REGISTER");
    }

    public void addEvent() {
        this.f76007p.setOnClickListener(new z1(this));
        this.f76000i.setOnClickListener(this);
        this.f75996e.setOnTextChangedListener(new r1(this));
        this.f75995d.setOnTextChangedListener(new q1(this));
        this.f76003l.setOnClickListener(new b2(this));
        this.f75995d.setClearEditTextOnFocusChangeListener(new o1(this));
        this.f75996e.setClearEditTextOnFocusChangeListener(new p1(this));
        this.f76011t.setOnSelelctChangeListner(new u1(this));
        this.f76017z.setOnClickListener(new b());
        this.D.setOnClickListener(c2.f37255b);
    }

    public void c5(String str, String str2, String str3, String str4, boolean z11) {
        CommonCaptchaDialog commonCaptchaDialog = new CommonCaptchaDialog(this);
        this.f76004m = commonCaptchaDialog;
        commonCaptchaDialog.setTitle(getResources().getString(R.string.login_dialog_captcha_title));
        this.f76004m.setCancelText(getResources().getString(R.string.login_dialog_cancel));
        this.f76004m.setConfirmText(getResources().getString(R.string.login_dialog_confirm));
        this.f76004m.setCaptchaImage(str);
        this.f76004m.show();
        this.f76004m.getImageView().setOnClickListener(new d());
        this.f76004m.setCancelListener(new t1(this));
        this.f76004m.setConfirmListner(new e(str2, str3, str4, z11));
        this.f76004m.getCaptchaEdit().addTextChangedListener(new f());
    }

    public boolean canFullScreen() {
        return true;
    }

    public void e7(String str) {
        this.f75993b = str;
        ri(true);
    }

    public void g6() {
        Intent j11 = rn.c.i().j(this);
        if (Rh()) {
            j11.putExtra("login_name", this.f75996e.getText().toString());
        } else {
            j11.putExtra("login_name", this.f75995d.getText().toString());
        }
        startActivity(j11);
        finish();
    }

    public int getContentView() {
        return R.layout.activity_user_register_v2;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorContentBackground);
    }

    public final void initData() {
        Intent intent = getIntent();
        this.f76010s = intent.getBooleanExtra("login_multiple_account", false);
        if (intent.getExtras() != null && intent.getExtras().containsKey("target")) {
            this.f76006o = intent.getExtras().getParcelable("target");
        }
        w.j().h(this).subscribe(q6.d.c(this, new v1(this)));
        g1 g1Var = new g1(this);
        g1Var.show();
        g1Var.setCanceledOnTouchOutside(false);
        g1Var.setCancelable(false);
        o9.a.a().registerCheckIp().b().compose(RxJavaHelper.t(getUI())).subscribe(new a(g1Var));
    }

    public void initView() {
        this.f75994c = (TextView) this.viewFinder.b(R.id.register_cancel_text);
        this.f76009r = (TextView) this.viewFinder.b(R.id.agreementText);
        this.f76007p = this.viewFinder.b(R.id.registerCountryCodeLayout);
        this.f76008q = (TextView) this.viewFinder.b(R.id.registerCountryCodeTextView);
        this.f75995d = (ClearEditText) this.viewFinder.b(R.id.registerAccountPhoneEdit);
        this.f75996e = (ClearEditText) this.viewFinder.b(R.id.registerAccountEmailEdit);
        this.f75997f = this.viewFinder.b(R.id.accountEmailLayout);
        this.f75998g = this.viewFinder.b(R.id.accountPhoneLayout);
        this.f75999h = (RelativeLayout) this.viewFinder.b(R.id.phoneLayout);
        this.f76000i = (StatusButton) this.viewFinder.b(R.id.register_btn_next);
        this.f76003l = (ImageView) this.viewFinder.b(R.id.close_btn);
        this.f76011t = (RadioGroupContainer) this.viewFinder.b(R.id.type_tab);
        this.f76012u = (ImageView) this.viewFinder.b(R.id.ivCountryIcon);
        this.f76013v = (ImageView) this.viewFinder.b(R.id.bottom_banner_img);
        this.f76017z = (LinearLayout) this.viewFinder.b(R.id.scrollContent);
        this.A = this.viewFinder.b(R.id.ipRestrictionsTipsContainer);
        this.B = (MarqueeView) this.viewFinder.b(R.id.ipRestrictionsTips);
        this.D = this.viewFinder.b(R.id.clickTipsView);
        String str = " " + getString(R.string.n_register_go_login);
        ViewUtil.l(this.f75994c, getString(R.string.sign_up_login_tips) + str, str, getResources().getColor(R.color.global_jump_btn_color), new d2(this));
        this.f76005n = new VerifyHelper();
        initData();
        Qh();
        this.f76000i.setEnabled(false);
        this.f76000i.setButtonText(getString(R.string.n_login_retrieve_code));
        this.f76000i.setTextSize(getResources().getDimension(R.dimen.global_text_size_14));
        this.f76000i.setBackgroundResource(R.drawable.register_v2_btn_bg);
        this.B.setRate(getResources().getDimension(R.dimen.dimen_15));
        this.B.setTextSpace(getResources().getDimension(R.dimen.dimen_170));
        this.B.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.global_text_size_12));
        this.B.setTextColor(ContextCompat.getColor(this, R.color.baseColorPrimaryText));
        this.B.setPaintAntiAlias(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", "注册页");
        g.i("App_PageView", hashMap);
    }

    public void lg() {
        if (this.f75993b.equals("register_email")) {
            ((UserRegisterV2Presenter) getPresenter()).C1(this.f75996e.getText().toString(), false, 1);
        } else if ("--".equals(this.f76001j)) {
            HuobiToastUtil.j(R.string.register_country_code_empty_tips);
            return;
        } else {
            ((UserRegisterV2Presenter) getPresenter()).F1(this.f76008q.getText().toString().replace("+", "00"), this.f75995d.getText().toString(), false, 1);
        }
        this.f76000i.showAnim();
        ni("4811");
    }

    public final void mi(RegisterCheckIpData registerCheckIpData) {
        this.C = registerCheckIpData;
        if (registerCheckIpData != null) {
            if ("STRENGTHENING_AREA".equalsIgnoreCase(registerCheckIpData.getLimitType())) {
                HashMap hashMap = new HashMap();
                hashMap.put("message_type", "注册禁止");
                g.i("App_register_message_expose", hashMap);
                this.D.setVisibility(0);
                if (!TextUtils.isEmpty(registerCheckIpData.getAlterMsg())) {
                    this.A.setVisibility(0);
                    this.B.setText(registerCheckIpData.getAlterMsg());
                }
            } else {
                this.D.setVisibility(8);
                String i11 = SP.i(F, "");
                if (!"BLACKLIST_AREA".equalsIgnoreCase(i11) && !"BLACKLIST_AREA_NO_OPEN_KYC".equalsIgnoreCase(i11) && ("BLACKLIST_AREA".equalsIgnoreCase(registerCheckIpData.getLimitType()) || "BLACKLIST_AREA_NO_OPEN_KYC".equalsIgnoreCase(registerCheckIpData.getLimitType()))) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("message_type", "注册提醒");
                    g.i("App_register_message_expose", hashMap2);
                    HBDialogFragment uh2 = HBDialogFragment.uh(R.layout.register_blacklist_area_dialog, new n1(registerCheckIpData));
                    uh2.setStyle(0, R.style.CommonDialogStyle);
                    uh2.show(getSupportFragmentManager(), "register_blacklist_area_dialog");
                }
            }
            SP.s(F, registerCheckIpData.getLimitType());
        }
    }

    public final void ni(String str) {
        HashMap hashMap = new HashMap();
        if (Rh()) {
            hashMap.put("value", "email");
        } else {
            hashMap.put("value", PlaceFields.PHONE);
        }
        is.a.j(str, hashMap, "1005246");
    }

    public void ob(String str, HashMap<String, Object> hashMap, String str2, String str3) {
    }

    public final void oi() {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("param_back_target");
        if (parcelableExtra == null || !(parcelableExtra instanceof JumpTarget)) {
            finish();
        } else {
            rn.c.i().w((JumpTarget) parcelableExtra, this, this.f76010s);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (!this.f76005n.y(i11, i12, intent)) {
            G0();
        }
        if (i11 == 1001) {
            if (intent != null) {
                this.f76001j = intent.getStringExtra("phone_area_code");
                if (!TextUtils.isEmpty(intent.getStringExtra("country_area_code"))) {
                    qi(intent.getStringExtra("country_area_code"));
                }
                this.f76008q.setText(String.valueOf(this.f76001j.replace("00", "+")));
                CountryListData d11 = w.j().d();
                if (d11 != null && !TextUtils.isEmpty(this.f76001j)) {
                    d11.h(this.f76001j);
                }
            }
        } else if (i11 == 1002 && intent != null) {
            this.f76001j = intent.getStringExtra("phone_area_code");
            String stringExtra = intent.getStringExtra("country_area_code");
            this.f76002k = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                qi(this.f76002k);
            }
            this.f76008q.setText(String.valueOf(this.f76001j.replace("00", "+")));
            CountryListData d12 = w.j().d();
            if (d12 != null) {
                String stringExtra2 = intent.getStringExtra("country_name_cn");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    d12.j(stringExtra2);
                }
                String stringExtra3 = intent.getStringExtra("country_name_en");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    d12.k(stringExtra3);
                }
                String str = this.f76002k;
                if (str != null) {
                    try {
                        d12.i(Integer.parseInt(str));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.f76001j)) {
                    d12.h(this.f76001j);
                }
            }
            Qh();
        }
    }

    public void onBackPressed() {
        Oh(false);
        SoftInputUtils.f(this);
        pi();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r9) {
        /*
            r8 = this;
            int r0 = r9.getId()
            r1 = 2131433914(0x7f0b19ba, float:1.8489627E38)
            if (r0 == r1) goto L_0x000b
            goto L_0x00ba
        L_0x000b:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "button_name"
            java.lang.String r2 = "注册页_获取验证码"
            r0.put(r1, r2)
            java.lang.String r1 = "app_RegisterProcess_button_click"
            gs.g.i(r1, r0)
            java.lang.String r0 = "app_register_home_send_code_click"
            r1 = 0
            gs.g.i(r0, r1)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "way"
            java.lang.String r3 = "WEB"
            r0.put(r2, r3)
            java.lang.String r2 = r8.f75993b
            java.lang.String r3 = "register_email"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00ab
            com.hbg.lib.widgets.input.ClearEditText r2 = r8.f75996e
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.String r2 = r2.toLowerCase()
        L_0x0050:
            java.lang.String r3 = "email"
            r0.put(r3, r2)
            com.hbg.lib.common.mvp.ActivityPresenter r3 = r8.getPresenter()
            if (r3 == 0) goto L_0x00ab
            com.hbg.lib.common.mvp.ActivityPresenter r3 = r8.getPresenter()
            com.huobi.login.presenter.UserRegisterV2Presenter r3 = (com.huobi.login.presenter.UserRegisterV2Presenter) r3
            java.util.List r3 = r3.I0()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x008e
            boolean r6 = r3.isEmpty()
            if (r6 != 0) goto L_0x008e
            java.util.Iterator r3 = r3.iterator()
        L_0x0073:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x008e
            java.lang.Object r6 = r3.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x0073
            boolean r7 = r2.contains(r6)
            if (r7 == 0) goto L_0x0073
            r2 = r4
            r1 = r6
            goto L_0x008f
        L_0x008e:
            r2 = r5
        L_0x008f:
            if (r2 == 0) goto L_0x00ab
            android.content.res.Resources r0 = r8.getResources()
            r2 = 2132022985(0x7f1416c9, float:1.9684405E38)
            java.lang.String r0 = r0.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r5] = r1
            java.lang.String r0 = java.lang.String.format(r0, r2)
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r0)
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r9)
            return
        L_0x00ab:
            com.hbg.lib.common.mvp.ActivityPresenter r1 = r8.getPresenter()
            if (r1 == 0) goto L_0x00ba
            com.hbg.lib.common.mvp.ActivityPresenter r1 = r8.getPresenter()
            com.huobi.login.presenter.UserRegisterV2Presenter r1 = (com.huobi.login.presenter.UserRegisterV2Presenter) r1
            r1.t1(r0)
        L_0x00ba:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.login.v2.ui.UserRegisterActivityV2.onClick(android.view.View):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((UserRegisterV2Presenter) getPresenter()).z1();
    }

    public final boolean pi() {
        RegisterCheckIpData registerCheckIpData = this.C;
        if (registerCheckIpData == null || "STRENGTHENING_AREA".equalsIgnoreCase(registerCheckIpData.getLimitType()) || TextUtils.isEmpty(this.C.getDetentionMsg())) {
            oi();
            return false;
        }
        HBDialogFragment b02 = DialogUtils.b0(this, getString(R.string.n_register_back_tips), this.C.getDetentionMsg(), "", getString(R.string.n_register_back_ok), getString(R.string.n_register_back_cancel), new e2(this), m1.f37293a);
        b02.setCanceledOnTouchOutside(true);
        b02.vh(l1.f37289b);
        g.i("app_register_shut_pop", (HashMap) null);
        return true;
    }

    public void q1(String str) {
        HuobiToastUtil.m(str);
    }

    public void q4(String str, String str2, String str3, boolean z11, RiskControl riskControl) {
        this.f76005n.m(this, !TextUtils.isEmpty(str) ? str : str3, MiPushClient.COMMAND_REGISTER, riskControl, new c(str, str2, str3, z11));
    }

    public final void qi(String str) {
        f6.c.a().l(this, w.e(str), this.f76012u, NightHelper.e().g() ? R.drawable.flag_default_night : R.drawable.flag_default);
    }

    public void ri(boolean z11) {
        if ("register_email".equals(this.f75993b)) {
            this.f75996e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(64)});
            if (((UserRegisterV2Presenter) getPresenter()).C0() != null) {
                this.f75996e.setText(((UserRegisterV2Presenter) getPresenter()).C0());
            }
            this.f75999h.setVisibility(8);
            this.f75997f.setVisibility(0);
            if (!z11) {
                this.f75996e.requestFocus();
            }
        } else {
            this.f75999h.setVisibility(0);
            this.f75997f.setVisibility(8);
            this.f75995d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
            if (((UserRegisterV2Presenter) getPresenter()).D0() != null) {
                this.f75995d.setText(((UserRegisterV2Presenter) getPresenter()).D0());
            }
            if (!z11) {
                this.f75995d.requestFocus();
            }
        }
        Mh();
        if (((UserRegisterV2Presenter) getPresenter()).E0() != null) {
            this.f76003l.setImageResource(R.drawable.selector_top_bar_back);
        }
        ViewUtil.m(this.f75994c, !((UserRegisterV2Presenter) getPresenter()).J0());
    }

    public void se(String str) {
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
