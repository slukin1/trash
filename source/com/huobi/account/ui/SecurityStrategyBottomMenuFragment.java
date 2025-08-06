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
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.bean.LoginVerifyChangeDialogHelper;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuTitleDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.widget.AnimationChangeGroupView;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.login.v2.ui.ForgetPasswordActivityV2;
import com.huobi.otc.flutter.OtcFlutterOrderDetailActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;

public class SecurityStrategyBottomMenuFragment extends BaseDialogFragment {
    public RelativeLayout A;
    public RelativeLayout B;
    public TextView C;
    public TextView D;
    public TextView E;
    public View F;
    public TextView G;
    public TextView H;
    public LinearLayout I;
    public View J;
    public View K;
    public View L;
    public View M;
    public boolean N;
    public MagicIndicator O;
    public List<String> P = new ArrayList();
    public CommonNavigator Q;
    public int R;
    public List<String> S;
    public h T;
    public TextView U;
    public TextView V;
    public boolean W;
    public boolean X;
    public boolean Y = false;
    public View Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f41428a0;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41429b;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f41430b0;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41431c;

    /* renamed from: c0  reason: collision with root package name */
    public String f41432c0;

    /* renamed from: d  reason: collision with root package name */
    public int f41433d;

    /* renamed from: d0  reason: collision with root package name */
    public View.OnClickListener f41434d0;

    /* renamed from: e  reason: collision with root package name */
    public int f41435e;

    /* renamed from: e0  reason: collision with root package name */
    public AnimationChangeGroupView f41436e0;

    /* renamed from: f  reason: collision with root package name */
    public int f41437f;

    /* renamed from: f0  reason: collision with root package name */
    public LoginVerifyChangeDialogHelper f41438f0 = new LoginVerifyChangeDialogHelper();

    /* renamed from: g  reason: collision with root package name */
    public int f41439g;

    /* renamed from: g0  reason: collision with root package name */
    public final BottomMenuTitleDialogFragment.a f41440g0 = new a();

    /* renamed from: h  reason: collision with root package name */
    public ProgressButton f41441h;

    /* renamed from: h0  reason: collision with root package name */
    public String f41442h0;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41443i;

    /* renamed from: i0  reason: collision with root package name */
    public int f41444i0;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41445j;

    /* renamed from: j0  reason: collision with root package name */
    public View.OnClickListener f41446j0;

    /* renamed from: k  reason: collision with root package name */
    public TextView f41447k;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f41448l;

    /* renamed from: m  reason: collision with root package name */
    public SecurityStrategyController f41449m;

    /* renamed from: n  reason: collision with root package name */
    public u6.g f41450n;

    /* renamed from: o  reason: collision with root package name */
    public EditText f41451o;

    /* renamed from: p  reason: collision with root package name */
    public EditText f41452p;

    /* renamed from: q  reason: collision with root package name */
    public EditText f41453q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f41454r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f41455s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f41456t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f41457u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f41458v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f41459w;

    /* renamed from: x  reason: collision with root package name */
    public View f41460x;

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f41461y;

    /* renamed from: z  reason: collision with root package name */
    public RelativeLayout f41462z;

    public class a implements BottomMenuTitleDialogFragment.a {
        public a() {
        }

        public void onBack() {
            SecurityStrategyBottomMenuFragment.this.f41436e0.c();
        }

        public void onDismiss() {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SoftInputUtils.f(SecurityStrategyBottomMenuFragment.this.getActivity());
            SecurityStrategyBottomMenuFragment.this.startActivity(new Intent(SecurityStrategyBottomMenuFragment.this.getActivity(), ForgetPasswordActivityV2.class));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragment.this.f41433d = editable.length();
            SecurityStrategyBottomMenuFragment.this.di();
            if (SecurityStrategyBottomMenuFragment.this.f41433d > 0 && !SecurityStrategyBottomMenuFragment.this.f41451o.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragment.this.f41451o.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41451o.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragment.this.f41433d == 0) {
                SecurityStrategyBottomMenuFragment.this.f41451o.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41451o.getContext(), R.font.roboto_regular));
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
            int unused = SecurityStrategyBottomMenuFragment.this.f41435e = editable.length();
            SecurityStrategyBottomMenuFragment.this.di();
            if (SecurityStrategyBottomMenuFragment.this.f41435e > 0 && !SecurityStrategyBottomMenuFragment.this.f41452p.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragment.this.f41452p.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41452p.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragment.this.f41435e == 0) {
                SecurityStrategyBottomMenuFragment.this.f41452p.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41452p.getContext(), R.font.roboto_regular));
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
            int unused = SecurityStrategyBottomMenuFragment.this.f41437f = editable.length();
            SecurityStrategyBottomMenuFragment.this.di();
            if (SecurityStrategyBottomMenuFragment.this.f41437f > 0 && !SecurityStrategyBottomMenuFragment.this.f41453q.getTypeface().isBold()) {
                SecurityStrategyBottomMenuFragment.this.f41453q.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41453q.getContext(), R.font.roboto_medium));
            } else if (SecurityStrategyBottomMenuFragment.this.f41437f == 0) {
                SecurityStrategyBottomMenuFragment.this.f41453q.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41453q.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
            int unused = SecurityStrategyBottomMenuFragment.this.f41439g = editable.length();
            SecurityStrategyBottomMenuFragment.this.di();
            TextPaint paint = SecurityStrategyBottomMenuFragment.this.f41455s.getPaint();
            if (editable.length() > 0) {
                paint.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41455s.getContext(), R.font.roboto_medium));
            } else {
                paint.setTypeface(ResourcesCompat.h(SecurityStrategyBottomMenuFragment.this.f41455s.getContext(), R.font.roboto_regular));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class g extends CommonNavigatorAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f41469a;

        public g(h hVar) {
            this.f41469a = hVar;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void b(int i11, h hVar, View view) {
            if (i11 == SecurityStrategyBottomMenuFragment.this.R) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SecurityStrategyBottomMenuFragment.this.f41451o.setText("");
            SecurityStrategyBottomMenuFragment.this.f41452p.setText("");
            SecurityStrategyBottomMenuFragment.this.f41453q.setText("");
            if (hVar != null) {
                hVar.a(i11);
            }
            int unused = SecurityStrategyBottomMenuFragment.this.R = i11;
            SecurityStrategyBottomMenuFragment.this.O.c(i11);
            SecurityStrategyBottomMenuFragment.this.O.b(i11, 0.0f, 0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (SecurityStrategyBottomMenuFragment.this.P == null) {
                return 0;
            }
            return SecurityStrategyBottomMenuFragment.this.P.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.global_jump_btn_color)));
            linePagerIndicator.setLineHeight((float) PixelUtils.a(2.0f));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText((CharSequence) SecurityStrategyBottomMenuFragment.this.P.get(i11));
            colorTransitionPagerTitleView.setTextSize(16.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryText));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.global_jump_btn_color));
            colorTransitionPagerTitleView.setOnClickListener(new j4(this, i11, this.f41469a));
            return colorTransitionPagerTitleView;
        }
    }

    public interface h {
        void a(int i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        SoftInputUtils.f(getActivity());
        String trim = this.f41451o.getText().toString().trim();
        String trim2 = this.f41452p.getText().toString().trim();
        String trim3 = this.f41453q.getText().toString().trim();
        String trim4 = this.f41455s.getText().toString().trim();
        if (ei(trim, trim2, trim3, trim4)) {
            this.f41449m.i(trim, trim2, trim3, trim4);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        if (this.f41456t) {
            this.f41457u.setImageResource(R.drawable.icon_eye_close);
            this.f41456t = false;
            this.f41455s.setTransformationMethod(PasswordTransformationMethod.getInstance());
            EditText editText = this.f41455s;
            editText.setSelection(editText.getText().toString().length());
        } else {
            this.f41457u.setImageResource(R.drawable.icon_eye_open);
            this.f41456t = true;
            this.f41455s.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            EditText editText2 = this.f41455s;
            editText2.setSelection(editText2.getText().toString().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ji(View view) {
        SecurityStrategyController securityStrategyController = this.f41449m;
        startActivity(sn.f.e0(getActivity(), (securityStrategyController == null || !(securityStrategyController instanceof SecurityStrategyControllerAdapter)) ? "" : ((SecurityStrategyControllerAdapter) securityStrategyController).Y()));
        SecurityStrategyController securityStrategyController2 = this.f41449m;
        if (securityStrategyController2 != null) {
            securityStrategyController2.P();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        this.f41446j0.onClick(view);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        this.f41449m.T();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ClipData primaryClip = ((ClipboardManager) this.f41431c.getContext().getSystemService("clipboard")).getPrimaryClip();
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
            this.f41453q.setText(charSequence);
            EditText editText = this.f41453q;
            editText.setSelection(editText.getText().length());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        View.OnClickListener onClickListener;
        dismiss();
        if (!(this.f41449m == null || (onClickListener = this.f41434d0) == null)) {
            onClickListener.onClick(view);
        }
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            securityStrategyController.O();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void li(View view) {
        this.f41436e0.g(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mi(View view, boolean z11) {
        this.J.setBackgroundResource(z11 ? R.color.global_button_end_color : R.color.global_divider_color);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, boolean z11) {
        this.L.setBackgroundResource(z11 ? R.color.global_button_end_color : R.color.global_divider_color);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oi(View view, boolean z11) {
        this.K.setBackgroundResource(z11 ? R.color.global_button_end_color : R.color.global_divider_color);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pi(View view, boolean z11) {
        this.M.setBackgroundResource(z11 ? R.color.global_button_end_color : R.color.global_divider_color);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qi(View view) {
        this.f41458v = true;
        this.N = false;
        di();
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            securityStrategyController.S(this, this.f41450n, this.N);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ri(View view) {
        this.f41458v = true;
        this.N = true;
        di();
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            securityStrategyController.S(this, this.f41450n, this.N);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void si(View view) {
        this.f41444i0++;
        this.f41459w = true;
        di();
        if (this.f41449m != null) {
            if (TextUtils.isEmpty(this.f41442h0) || this.f41444i0 != 2) {
                this.f41449m.R(this, this.f41450n);
            } else {
                this.f41449m.q(this.f41442h0, this, this.f41450n);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void ti() {
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
            java.lang.String r1 = r4.gi(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.SecurityStrategyBottomMenuFragment.ti():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ui() {
        this.f41458v = true;
        this.f41449m.U(this, this.f41450n);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vi() {
        this.f41459w = true;
        this.f41449m.l(this, this.f41450n);
    }

    public void Ai(List<TitleDialogMenuItemBean> list) {
        this.f41438f0.j(list);
    }

    public void Bi(boolean z11) {
        ProgressButton progressButton = this.f41441h;
        if (progressButton != null) {
            progressButton.setEnabled(z11);
        }
    }

    public void Ci(SecurityStrategyController securityStrategyController) {
        this.f41449m = securityStrategyController;
        fi();
    }

    public void Di(View.OnClickListener onClickListener) {
        this.f41446j0 = onClickListener;
    }

    public void Ei(boolean z11) {
        this.W = z11;
    }

    public void Fi(boolean z11) {
        this.X = z11;
        ViewUtil.m(this.V, z11);
    }

    public void G0() {
        ProgressButton progressButton = this.f41441h;
        if (progressButton != null) {
            progressButton.a();
        }
    }

    public void Gi(String str) {
        this.f41432c0 = str;
    }

    public void Hi(List<String> list, h hVar) {
        this.S = list;
        this.T = hVar;
        if (this.f41460x != null && this.O != null && list != null && list.size() != 0 && list.size() != 1) {
            ViewUtil.m(this.O, true);
            this.P.clear();
            this.P.addAll(list);
            CommonNavigator commonNavigator = new CommonNavigator(getActivity());
            this.Q = commonNavigator;
            commonNavigator.setAdjustMode(true);
            this.Q.setAdapter(new g(hVar));
            this.O.setNavigator(this.Q);
            this.O.c(this.R);
            this.O.b(this.R, 0.0f, 0);
        }
    }

    public final void Ii() {
        this.I.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.setMargins(0, PixelUtils.a(8.0f), 0, 0);
        this.I.setLayoutParams(layoutParams);
        TextView textView = this.G;
        textView.setText(String.format("·%s", new Object[]{textView.getText()}));
        String charSequence = this.H.getText().toString();
        if (!charSequence.startsWith("·")) {
            this.H.setText(String.format("·%s", new Object[]{charSequence}));
        }
    }

    public void Ji() {
        ProgressButton progressButton = this.f41441h;
        if (progressButton != null) {
            progressButton.c();
        }
    }

    public final void Ki() {
        ViewUtil.m(this.Z, this.Y);
        ViewUtil.m(this.F, !this.Y);
    }

    public void addEvent(r rVar) {
        this.V.setOnClickListener(new i4(this));
        this.f41431c.setOnClickListener(new f4(this));
        this.f41451o.addTextChangedListener(new c());
        this.f41452p.addTextChangedListener(new d());
        this.f41453q.addTextChangedListener(new e());
        this.f41451o.setOnFocusChangeListener(new w3(this));
        this.f41452p.setOnFocusChangeListener(new v3(this));
        this.f41453q.setOnFocusChangeListener(new u3(this));
        this.f41455s.setOnFocusChangeListener(new t3(this));
        this.f41443i.setOnClickListener(new h4(this));
        this.f41445j.setOnClickListener(new s3(this));
        this.f41454r.setOnClickListener(new c4(this));
        this.f41441h.setOnClickListener(new d4(this));
        this.f41457u.setOnClickListener(new b4(this));
        this.f41455s.addTextChangedListener(new f());
        this.I.setOnClickListener(new g4(this));
        if (this.f41446j0 != null) {
            this.U.setOnClickListener(new e4(this));
        }
        this.f41428a0.setOnClickListener(new a4(this));
        this.f41438f0.h(this.f41440g0);
    }

    public void afterInit() {
        fi();
    }

    public void bi() {
        this.f41436e0.c();
    }

    public final void ci(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null && securityStrategyController.G() && onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            i.b().f(new x3(this));
        }
    }

    public final void di() {
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            boolean z11 = false;
            boolean z12 = !securityStrategyController.x() || this.f41433d > 0;
            boolean z13 = !this.f41449m.x() || this.f41459w;
            boolean z14 = !this.f41449m.y() || this.f41437f > 0;
            boolean z15 = !this.f41449m.z() || this.f41439g > 0;
            boolean z16 = !this.f41449m.C() || this.f41435e > 0;
            boolean z17 = !this.f41449m.C() || this.f41458v;
            if ((this.f41449m.m() instanceof OtcFlutterOrderDetailActivity) && this.f41449m.C() && this.f41449m.y()) {
                z16 = true;
                z17 = true;
            }
            if (z12 && z13 && z16 && z17 && z14 && z15) {
                z11 = true;
            }
            Bi(z11);
        }
    }

    public void e2(boolean z11, String str) {
        int i11;
        this.f41454r.setEnabled(z11);
        TextView textView = this.f41454r;
        if (z11) {
            i11 = getResources().getColor(R.color.security_copy_link);
        } else {
            i11 = getResources().getColor(R.color.baseColorSecondaryText);
        }
        textView.setTextColor(i11);
        if (!TextUtils.isEmpty(str)) {
            this.f41454r.setText(str);
        }
    }

    public final boolean ei(String str, String str2, String str3, String str4) {
        if (this.f41449m.x() && !TextUtils.isEmpty(str) && str.length() != 6) {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_email)));
            return false;
        } else if (this.f41449m.C() && !TextUtils.isEmpty(str2) && str2.length() != 6) {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_sms)));
            return false;
        } else if (!this.f41449m.y() || TextUtils.isEmpty(str3) || str3.length() == 6) {
            return true;
        } else {
            HuobiToastUtil.m(getString(R.string.setting_check_code_error, getString(R.string.title_ga)));
            return false;
        }
    }

    public final void fi() {
        TextView textView;
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null && this.f41460x != null) {
            int i11 = 8;
            this.f41461y.setVisibility(securityStrategyController.x() ? 0 : 8);
            if (!(this.f41449m.m() instanceof OtcFlutterOrderDetailActivity)) {
                this.f41462z.setVisibility(this.f41449m.C() ? 0 : 8);
            } else if (!this.f41449m.C() || !this.f41449m.y()) {
                this.f41462z.setVisibility(this.f41449m.C() ? 0 : 8);
            } else {
                this.f41462z.setVisibility(8);
            }
            this.A.setVisibility(this.f41449m.y() ? 0 : 8);
            this.B.setVisibility(this.f41449m.z() ? 0 : 8);
            String str = "";
            this.D.setText(this.f41449m.x() ? this.f41449m.n() : str);
            TextView textView2 = this.E;
            if (this.f41449m.C()) {
                str = this.f41449m.o();
            }
            textView2.setText(str);
            if (isAdded()) {
                if (this.f41449m.v()) {
                    this.I.setVisibility(0);
                } else if (this.f41449m.E() && this.f41449m.x()) {
                    this.G.setVisibility(0);
                    this.G.setText(String.format("%s\n%s", new Object[]{this.f41449m.r(), getString(R.string.verification_email_tip)}));
                    Ii();
                } else if (this.f41449m.x()) {
                    this.G.setVisibility(0);
                    this.G.setText(getString(R.string.verification_email_tip));
                    Ii();
                } else if (this.f41449m.E()) {
                    this.G.setVisibility(0);
                    this.G.setText(this.f41449m.r());
                    Ii();
                } else {
                    this.G.setVisibility(8);
                    if (this.f41449m.y()) {
                        this.I.setVisibility(0);
                    }
                }
                LinearLayout linearLayout = this.I;
                if (this.f41449m.A()) {
                    i11 = 0;
                }
                linearLayout.setVisibility(i11);
            }
            if (this.f41449m.x() && (textView = this.G) != null) {
                try {
                    textView.setVisibility(0);
                    this.G.setText(getString(R.string.verification_email_tip));
                    Ii();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            if (this.f41449m.B()) {
                this.f41443i.post(new z3(this));
            }
            if (this.f41449m.w()) {
                this.f41454r.post(new y3(this));
            }
            Ki();
            if (!TextUtils.isEmpty(this.f41432c0)) {
                this.f41430b0.setText(this.f41432c0);
            }
            SecurityStrategyController securityStrategyController2 = this.f41449m;
            if (securityStrategyController2 != null && securityStrategyController2.F()) {
                ViewUtil.m(this.Z, false);
                ViewUtil.m(this.F, false);
            }
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.fragment_security_bottom_menu;
    }

    public int getGravity() {
        return 80;
    }

    public String gi(Context context) {
        ClipData.Item itemAt;
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || itemAt.getText() == null) {
            return null;
        }
        return itemAt.getText().toString();
    }

    public void h3(boolean z11, String str) {
        if (z11) {
            this.f41448l.setVisibility(0);
            this.f41447k.setVisibility(8);
            return;
        }
        this.f41448l.setVisibility(8);
        this.f41447k.setVisibility(0);
        this.f41447k.setText(str);
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(false);
        setCanceledOnTouchOutside(false);
        this.f41460x = rVar.b(R.id.rootView);
        this.f41431c = (TextView) rVar.b(R.id.paste_tv);
        ImageView imageView = (ImageView) rVar.b(R.id.tv_cancel);
        this.f41429b = imageView;
        imageView.setOnClickListener(new r3(this));
        this.f41461y = (RelativeLayout) rVar.b(R.id.rl_email_area);
        this.f41462z = (RelativeLayout) rVar.b(R.id.rl_sms_area);
        this.A = (RelativeLayout) rVar.b(R.id.rl_ga_area);
        this.B = (RelativeLayout) rVar.b(R.id.rl_pw_area);
        this.D = (TextView) rVar.b(R.id.tv_email_input_title);
        this.E = (TextView) rVar.b(R.id.tv_sms_input_title);
        this.C = (TextView) rVar.b(R.id.tv_pw_input_title);
        this.f41451o = (EditText) rVar.b(R.id.et_email_input);
        this.f41452p = (EditText) rVar.b(R.id.et_sms_input);
        this.f41453q = (EditText) rVar.b(R.id.et_ga_input);
        this.J = rVar.b(R.id.v_email_divider);
        this.L = rVar.b(R.id.v_sms_divider);
        this.K = rVar.b(R.id.v_ga_divider);
        this.M = rVar.b(R.id.v_pw_divider);
        this.f41441h = (ProgressButton) rVar.b(R.id.btn_action);
        this.f41443i = (TextView) rVar.b(R.id.tv_sms_send);
        this.f41445j = (TextView) rVar.b(R.id.tv_sms_voice_send);
        this.f41447k = (TextView) rVar.b(R.id.sms_count_down_tv);
        this.f41448l = (LinearLayout) rVar.b(R.id.sms_send_ll);
        this.f41454r = (TextView) rVar.b(R.id.tv_email_send);
        this.f41455s = (EditText) rVar.b(R.id.login_psw_edit);
        this.f41457u = (ImageView) rVar.b(R.id.login_psw_img);
        this.F = rVar.b(R.id.ll_email_tips);
        this.G = (TextView) rVar.b(R.id.tv_tips);
        this.H = (TextView) rVar.b(R.id.tv_ga_tips);
        this.I = (LinearLayout) rVar.b(R.id.ll_ga_tips);
        this.O = (MagicIndicator) rVar.b(R.id.magic_indicator_switch_verify);
        this.U = (TextView) rVar.b(R.id.id_otc_password_tv);
        this.V = (TextView) rVar.b(R.id.id_otc_passkey_tv);
        ViewUtil.m(this.U, this.W);
        ViewUtil.m(this.V, this.X);
        ViewUtil.d(this.f41455s);
        this.Z = rVar.b(R.id.login_verify_layout);
        this.f41428a0 = (TextView) rVar.b(R.id.login_verify_code_not_use);
        this.f41430b0 = (TextView) rVar.b(R.id.tv_verify_top_title);
        this.f41436e0 = (AnimationChangeGroupView) rVar.b(R.id.login_verify_layout_animation_view);
        this.f41438f0.e(rVar);
        rVar.b(R.id.login_forgot_psw).setOnClickListener(new b());
    }

    public boolean isTransparent() {
        return false;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof u6.g) {
            this.f41450n = (u6.g) context;
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        ci(onBackgroundStatusChangedEvent);
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
        this.f41458v = false;
        this.f41459w = false;
        this.R = 0;
        this.W = false;
        this.X = false;
        EditText editText = this.f41451o;
        if (editText != null) {
            editText.setText("");
            this.f41452p.setText("");
            this.f41453q.setText("");
            this.f41455s.setText("");
        }
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            securityStrategyController.h();
            this.f41449m.Q();
        }
        this.f41444i0 = 0;
    }

    public void onPause() {
        super.onPause();
        ViewUtil.m(this.O, false);
    }

    public void onResume() {
        super.onResume();
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null && securityStrategyController.D()) {
            Hi(this.f41449m.u(), this.f41449m.t());
        }
    }

    public void wi() {
        SecurityStrategyController securityStrategyController = this.f41449m;
        if (securityStrategyController != null) {
            securityStrategyController.R(this, this.f41450n);
        }
    }

    public void xi(String str) {
        this.f41442h0 = str;
    }

    public void yi(boolean z11) {
        this.Y = z11;
        Ki();
    }

    public void zi(View.OnClickListener onClickListener) {
        this.f41434d0 = onClickListener;
    }
}
