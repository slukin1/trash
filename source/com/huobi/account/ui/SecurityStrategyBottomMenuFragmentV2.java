package com.huobi.account.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.login.v2.ui.ForgetPasswordActivityV2;
import com.huobi.otc.flutter.OtcFlutterOrderDetailActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import sn.f;
import u6.g;

public class SecurityStrategyBottomMenuFragmentV2 extends BaseDialogFragment {
    public RelativeLayout A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public boolean G;
    public List<String> H = new ArrayList();
    public int I;
    public boolean J;
    public boolean K = false;
    public TextView L;
    public String M;
    public String N;
    public int O;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41471b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41472c;

    /* renamed from: d  reason: collision with root package name */
    public int f41473d;

    /* renamed from: e  reason: collision with root package name */
    public int f41474e;

    /* renamed from: f  reason: collision with root package name */
    public int f41475f;

    /* renamed from: g  reason: collision with root package name */
    public int f41476g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressButton f41477h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41478i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41479j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f41480k;

    /* renamed from: l  reason: collision with root package name */
    public SecurityStrategyControllerV2 f41481l;

    /* renamed from: m  reason: collision with root package name */
    public g f41482m;

    /* renamed from: n  reason: collision with root package name */
    public EditText f41483n;

    /* renamed from: o  reason: collision with root package name */
    public EditText f41484o;

    /* renamed from: p  reason: collision with root package name */
    public EditText f41485p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f41486q;

    /* renamed from: r  reason: collision with root package name */
    public EditText f41487r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f41488s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f41489t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f41490u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f41491v;

    /* renamed from: w  reason: collision with root package name */
    public View f41492w;

    /* renamed from: x  reason: collision with root package name */
    public RelativeLayout f41493x;

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f41494y;

    /* renamed from: z  reason: collision with root package name */
    public RelativeLayout f41495z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SoftInputUtils.f(SecurityStrategyBottomMenuFragmentV2.this.getActivity());
            SecurityStrategyBottomMenuFragmentV2.this.startActivity(new Intent(SecurityStrategyBottomMenuFragmentV2.this.getActivity(), ForgetPasswordActivityV2.class));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragmentV2.this.f41473d = editable.length();
            SecurityStrategyBottomMenuFragmentV2.this.Th();
            if (SecurityStrategyBottomMenuFragmentV2.this.f41473d > 0 && !SecurityStrategyBottomMenuFragmentV2.this.f41483n.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragmentV2.this.f41483n.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41483n.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragmentV2.this.f41473d == 0) {
                SecurityStrategyBottomMenuFragmentV2.this.f41483n.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41483n.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragmentV2.this.f41474e = editable.length();
            SecurityStrategyBottomMenuFragmentV2.this.Th();
            if (SecurityStrategyBottomMenuFragmentV2.this.f41474e > 0 && !SecurityStrategyBottomMenuFragmentV2.this.f41484o.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragmentV2.this.f41484o.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41484o.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragmentV2.this.f41474e == 0) {
                SecurityStrategyBottomMenuFragmentV2.this.f41484o.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41484o.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragmentV2.this.f41475f = editable.length();
            SecurityStrategyBottomMenuFragmentV2.this.Th();
            if (SecurityStrategyBottomMenuFragmentV2.this.f41475f > 0 && !SecurityStrategyBottomMenuFragmentV2.this.f41485p.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragmentV2.this.f41485p.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41485p.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragmentV2.this.f41475f == 0) {
                SecurityStrategyBottomMenuFragmentV2.this.f41485p.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41485p.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragmentV2.this.f41476g = editable.length();
            SecurityStrategyBottomMenuFragmentV2.this.Th();
            TextPaint paint = SecurityStrategyBottomMenuFragmentV2.this.f41487r.getPaint();
            if (editable.length() > 0) {
                paint.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41487r.getContext(), R.font.roboto_medium));
            } else {
                paint.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragmentV2.this.f41487r.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xh(View view) {
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        startActivity(f.e0(getActivity(), (securityStrategyControllerV2 == null || !(securityStrategyControllerV2 instanceof SecurityStrategyControllerAdapterV2)) ? "" : ((SecurityStrategyControllerAdapterV2) securityStrategyControllerV2).J()));
        SecurityStrategyControllerV2 securityStrategyControllerV22 = this.f41481l;
        if (securityStrategyControllerV22 != null) {
            securityStrategyControllerV22.E();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Yh(View view, boolean z11) {
    }

    public static /* synthetic */ void Zh(View view, boolean z11) {
    }

    public static /* synthetic */ void ai(View view, boolean z11) {
    }

    public static /* synthetic */ void bi(View view, boolean z11) {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        this.f41490u = true;
        this.G = false;
        Th();
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null) {
            securityStrategyControllerV2.H(this, this.f41482m, this.G);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(View view) {
        this.O++;
        this.f41491v = true;
        Th();
        if (this.f41481l != null) {
            if (TextUtils.isEmpty(this.N) || this.O != 2) {
                this.f41481l.G(this, this.f41482m);
            } else {
                this.f41481l.n(this.N, this, this.f41482m);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ei(View view) {
        SoftInputUtils.f(getActivity());
        String trim = this.f41483n.getText().toString().trim();
        String trim2 = this.f41484o.getText().toString().trim();
        String trim3 = this.f41485p.getText().toString().trim();
        String trim4 = this.f41487r.getText().toString().trim();
        if (Uh(trim, trim2, trim3, trim4)) {
            this.f41481l.f(trim, trim2, trim3, trim4);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fi(View view) {
        if (this.f41488s) {
            this.f41489t.setImageResource(R.drawable.icon_eye_close);
            this.f41488s = false;
            this.f41487r.setTransformationMethod(PasswordTransformationMethod.getInstance());
            EditText editText = this.f41487r;
            editText.setSelection(editText.getText().toString().length());
        } else {
            this.f41489t.setImageResource(R.drawable.icon_eye_open);
            this.f41488s = true;
            this.f41487r.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            EditText editText2 = this.f41487r;
            editText2.setSelection(editText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void gi() {
        /*
            r4 = this;
            android.view.View r0 = r4.getView()
            if (r0 == 0) goto L_0x0015
            android.view.View r0 = r4.getView()
            android.view.View r0 = r0.findFocus()
            boolean r1 = r0 instanceof android.widget.EditText
            if (r1 == 0) goto L_0x0015
            android.widget.EditText r0 = (android.widget.EditText) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x0047
            android.content.Context r1 = r0.getContext()
            java.lang.String r1 = r4.Wh(r1)
            if (r1 == 0) goto L_0x0047
            int r2 = r1.length()
            r3 = 6
            if (r2 != r3) goto L_0x0047
            boolean r2 = android.text.TextUtils.isDigitsOnly(r1)
            if (r2 == 0) goto L_0x0047
            android.text.Editable r2 = r0.getText()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0047
            r0.setText(r1)
            android.text.Editable r1 = r0.getText()
            int r1 = r1.length()
            r0.setSelection(r1)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.SecurityStrategyBottomMenuFragmentV2.gi():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hi() {
        this.f41490u = true;
        this.f41481l.I(this, this.f41482m);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii() {
        this.f41491v = true;
        this.f41481l.i(this, this.f41482m);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        ClipData primaryClip = ((ClipboardManager) this.f41472c.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null || itemAt.getText() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String charSequence = itemAt.getText().toString();
        if (charSequence != null && TextUtils.isDigitsOnly(charSequence)) {
            this.f41485p.setText(charSequence);
            EditText editText = this.f41485p;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null) {
            securityStrategyControllerV2.D();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Sh(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null && securityStrategyControllerV2.y() && onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            i.b().f(new o4(this));
        }
    }

    public final void Th() {
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null) {
            boolean z11 = false;
            boolean z12 = !securityStrategyControllerV2.r() || this.f41473d > 0;
            boolean z13 = !this.f41481l.r() || this.f41491v;
            boolean z14 = !this.f41481l.s() || this.f41475f > 0;
            boolean z15 = !this.f41481l.t() || this.f41476g > 0;
            boolean z16 = !this.f41481l.w() || this.f41474e > 0;
            boolean z17 = !this.f41481l.w() || this.f41490u;
            if ((this.f41481l.j() instanceof OtcFlutterOrderDetailActivity) && this.f41481l.w() && this.f41481l.s()) {
                z16 = true;
                z17 = true;
            }
            if (z12 && z13 && z16 && z17 && z14 && z15) {
                z11 = true;
            }
            mi(z11);
        }
    }

    public final boolean Uh(String str, String str2, String str3, String str4) {
        if (this.f41481l.r() && !TextUtils.isEmpty(str) && str.length() != 6) {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_email)));
            return false;
        } else if (this.f41481l.w() && !TextUtils.isEmpty(str2) && str2.length() != 6) {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_sms)));
            return false;
        } else if (!this.f41481l.s() || TextUtils.isEmpty(str3) || str3.length() == 6) {
            return true;
        } else {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_ga)));
            return false;
        }
    }

    public final void Vh() {
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null && this.f41492w != null) {
            int i11 = 8;
            this.f41493x.setVisibility(securityStrategyControllerV2.r() ? 0 : 8);
            if (!(this.f41481l.j() instanceof OtcFlutterOrderDetailActivity)) {
                this.f41494y.setVisibility(this.f41481l.w() ? 0 : 8);
            } else if (!this.f41481l.w() || !this.f41481l.s()) {
                this.f41494y.setVisibility(this.f41481l.w() ? 0 : 8);
            } else {
                this.f41494y.setVisibility(8);
            }
            this.f41495z.setVisibility(this.f41481l.s() ? 0 : 8);
            this.A.setVisibility(this.f41481l.t() ? 0 : 8);
            String str = "";
            this.C.setText(this.f41481l.r() ? this.f41481l.k() : str);
            TextView textView = this.D;
            if (this.f41481l.w()) {
                str = this.f41481l.l();
            }
            textView.setText(str);
            if (isAdded()) {
                if (this.f41481l.p()) {
                    this.F.setVisibility(0);
                } else if (this.f41481l.x() && this.f41481l.r()) {
                    oi();
                } else if (this.f41481l.r()) {
                    oi();
                } else if (this.f41481l.x()) {
                    oi();
                } else if (this.f41481l.s()) {
                    this.F.setVisibility(0);
                }
                LinearLayout linearLayout = this.F;
                if (this.f41481l.u()) {
                    i11 = 0;
                }
                linearLayout.setVisibility(i11);
            }
            if (this.f41481l.v()) {
                this.f41478i.post(new n4(this));
            }
            if (this.f41481l.q()) {
                this.f41486q.post(new m4(this));
            }
            if (!TextUtils.isEmpty(this.M)) {
                this.L.setText(this.M);
            }
        }
    }

    public String Wh(Context context) {
        ClipData.Item itemAt;
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || itemAt.getText() == null) {
            return null;
        }
        return itemAt.getText().toString();
    }

    public void addEvent(r rVar) {
        this.f41472c.setOnClickListener(new k4(this));
        this.f41483n.addTextChangedListener(new b());
        this.f41484o.addTextChangedListener(new c());
        this.f41485p.addTextChangedListener(new d());
        this.f41483n.setOnFocusChangeListener(l4.f41744b);
        this.f41484o.setOnFocusChangeListener(w4.f41844b);
        this.f41485p.setOnFocusChangeListener(x4.f41853b);
        this.f41487r.setOnFocusChangeListener(v4.f41835b);
        this.f41478i.setOnClickListener(new p4(this));
        this.f41486q.setOnClickListener(new u4(this));
        this.f41477h.setOnClickListener(new t4(this));
        this.f41489t.setOnClickListener(new q4(this));
        this.f41487r.addTextChangedListener(new e());
        this.F.setOnClickListener(new s4(this));
    }

    public void afterInit() {
        Vh();
    }

    public void e2(boolean z11, String str) {
        int i11;
        this.f41486q.setEnabled(z11);
        TextView textView = this.f41486q;
        if (z11) {
            i11 = getResources().getColor(R.color.security_copy_link);
        } else {
            i11 = getResources().getColor(R.color.baseColorSecondaryText);
        }
        textView.setTextColor(i11);
        if (!TextUtils.isEmpty(str)) {
            this.f41486q.setText(str);
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.fragment_security_bottom_menu_v2;
    }

    public int getGravity() {
        return 48;
    }

    public void h3(boolean z11, String str) {
        if (z11) {
            this.f41480k.setVisibility(0);
            this.f41479j.setVisibility(8);
            return;
        }
        this.f41480k.setVisibility(8);
        this.f41479j.setVisibility(0);
        this.f41479j.setText(str);
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(false);
        setCanceledOnTouchOutside(false);
        this.f41492w = rVar.b(R.id.rootView);
        this.f41472c = (TextView) rVar.b(R.id.paste_tv);
        ImageView imageView = (ImageView) rVar.b(R.id.tv_cancel);
        this.f41471b = imageView;
        imageView.setOnClickListener(new r4(this));
        this.f41493x = (RelativeLayout) rVar.b(R.id.rl_email_area);
        this.f41494y = (RelativeLayout) rVar.b(R.id.rl_sms_area);
        this.f41495z = (RelativeLayout) rVar.b(R.id.rl_ga_area);
        this.A = (RelativeLayout) rVar.b(R.id.rl_pw_area);
        this.C = (TextView) rVar.b(R.id.tv_email_input_title);
        this.D = (TextView) rVar.b(R.id.tv_sms_input_title);
        this.B = (TextView) rVar.b(R.id.tv_pw_input_title);
        this.f41483n = (EditText) rVar.b(R.id.et_email_input);
        this.f41484o = (EditText) rVar.b(R.id.et_sms_input);
        this.f41485p = (EditText) rVar.b(R.id.et_ga_input);
        this.f41477h = (ProgressButton) rVar.b(R.id.btn_action);
        this.f41478i = (TextView) rVar.b(R.id.tv_sms_send);
        this.f41479j = (TextView) rVar.b(R.id.sms_count_down_tv);
        this.f41480k = (LinearLayout) rVar.b(R.id.sms_send_ll);
        this.f41486q = (TextView) rVar.b(R.id.tv_email_send);
        this.f41487r = (EditText) rVar.b(R.id.login_psw_edit);
        this.f41489t = (ImageView) rVar.b(R.id.login_psw_img);
        this.E = (TextView) rVar.b(R.id.tv_ga_tips);
        this.F = (LinearLayout) rVar.b(R.id.ll_ga_tips);
        ViewUtil.d(this.f41487r);
        this.L = (TextView) rVar.b(R.id.tv_verify_top_title);
        rVar.b(R.id.login_forgot_psw).setOnClickListener(new a());
    }

    public boolean isTransparent() {
        return false;
    }

    public void ji() {
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null) {
            securityStrategyControllerV2.G(this, this.f41482m);
        }
    }

    public void ki(String str) {
        this.N = str;
    }

    public void li(boolean z11) {
        this.K = z11;
    }

    public void mi(boolean z11) {
        ProgressButton progressButton = this.f41477h;
        if (progressButton != null) {
            progressButton.setEnabled(z11);
        }
    }

    public void ni(SecurityStrategyControllerV2 securityStrategyControllerV2) {
        this.f41481l = securityStrategyControllerV2;
        Vh();
    }

    public final void oi() {
        this.F.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.setMargins(0, PixelUtils.a(8.0f), 0, 0);
        this.F.setLayoutParams(layoutParams);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof g) {
            this.f41482m = (g) context;
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        Sh(onBackgroundStatusChangedEvent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f41490u = false;
        this.f41491v = false;
        this.I = 0;
        this.J = false;
        EditText editText = this.f41483n;
        if (editText != null) {
            editText.setText("");
            this.f41484o.setText("");
            this.f41485p.setText("");
            this.f41487r.setText("");
        }
        SecurityStrategyControllerV2 securityStrategyControllerV2 = this.f41481l;
        if (securityStrategyControllerV2 != null) {
            securityStrategyControllerV2.e();
            this.f41481l.F();
        }
        this.O = 0;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
