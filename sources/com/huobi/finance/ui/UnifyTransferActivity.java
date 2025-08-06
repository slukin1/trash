package com.huobi.finance.ui;

import al.s0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.C2CTransferOutQuotaInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.PointLengthFilter;
import com.hbg.module.kline.ui.CurrencyIntroWebActivity;
import com.huobi.c2c.ui.C2CBorrowActivity;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.presenter.UnifyTransferPresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.MarginUtil;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.utils.EditTextUtil;
import com.huobi.view.AgreementTextView;
import com.huobi.view.ForeShapeRipple;
import com.huobi.view.UnifyTransferGuide;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import d7.a1;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import pro.huobi.R;
import tg.r;
import uh.i;

@Route(path = "/balance/transfer")
public class UnifyTransferActivity extends BaseActivity<UnifyTransferPresenter, UnifyTransferPresenter.m> implements UnifyTransferPresenter.m {
    public Drawable A;
    public MenuItemOnClickListener B = new u9(this);
    public boolean C;
    public AnimatorSet D;
    public ValueAnimator E;
    public final Pattern F = Pattern.compile("^[0-9]+([.]{1}[0-9]+){0,1}$");
    public boolean G = true;
    public HuobiKeyboardHelper H;
    public TextView I;
    public View J;
    public HbTitleBar K;
    public FrameLayout L;
    public UnifyTransferGuide M;
    public TextView N;

    /* renamed from: b  reason: collision with root package name */
    public CustomBoardView f46898b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f46899c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46900d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46901e;

    /* renamed from: f  reason: collision with root package name */
    public View f46902f;

    /* renamed from: g  reason: collision with root package name */
    public View f46903g;

    /* renamed from: h  reason: collision with root package name */
    public String f46904h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46905i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46906j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46907k;

    /* renamed from: l  reason: collision with root package name */
    public Button f46908l;

    /* renamed from: m  reason: collision with root package name */
    public View f46909m;

    /* renamed from: n  reason: collision with root package name */
    public PointLengthFilter f46910n;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout f46911o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f46912p;

    /* renamed from: q  reason: collision with root package name */
    public ForeShapeRipple f46913q;

    /* renamed from: r  reason: collision with root package name */
    public ForeShapeRipple f46914r;

    /* renamed from: s  reason: collision with root package name */
    public View f46915s;

    /* renamed from: t  reason: collision with root package name */
    public View f46916t;

    /* renamed from: u  reason: collision with root package name */
    public View f46917u;

    /* renamed from: v  reason: collision with root package name */
    public AgreementTextView f46918v;

    /* renamed from: w  reason: collision with root package name */
    public TransferAgreementBottomDialog f46919w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f46920x;

    /* renamed from: y  reason: collision with root package name */
    public BottomMenuFragment f46921y = new BottomMenuFragment();

    /* renamed from: z  reason: collision with root package name */
    public List<MenuItem> f46922z = new ArrayList();

    public class a extends ClickableSpan {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            UnifyTransferActivity.this.f46919w.show(UnifyTransferActivity.this.getSupportFragmentManager(), "agreementBottomDialog");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(UnifyTransferActivity.this.getResources().getColor(R.color.baseColorMajorTheme100));
            textPaint.setUnderlineText(false);
        }
    }

    public class b implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f46924b;

        public b(float f11) {
            this.f46924b = f11;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            UnifyTransferActivity.this.f46914r.setAlpha(1.0f);
            UnifyTransferActivity.this.f46914r.setRippleMaximumRadius(this.f46924b);
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            UnifyTransferActivity.this.f46913q.stopRipple();
            UnifyTransferActivity.this.f46913q.setRippleMaximumRadius(0.1f);
        }
    }

    public class d implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f46927b;

        public d(float f11) {
            this.f46927b = f11;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            UnifyTransferActivity.this.f46914r.stopRipple();
            UnifyTransferActivity.this.f46914r.setRippleMaximumRadius(0.1f);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            UnifyTransferActivity.this.f46913q.setRippleMaximumRadius(this.f46927b);
        }
    }

    public class e implements UnifyTransferGuide.onItemClickListener {
        public e() {
        }

        public void guideClick() {
            CurrencyIntroWebActivity.startWebView(UnifyTransferActivity.this, sn.f.l("84892510862515"), (String) null, false);
        }

        public void historyClick() {
            ((UnifyTransferPresenter) UnifyTransferActivity.this.getPresenter()).c2();
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
            EditTextUtil.a(UnifyTransferActivity.this.f46899c);
            String Q1 = ((UnifyTransferPresenter) UnifyTransferActivity.this.getPresenter()).Q1();
            String Y1 = ((UnifyTransferPresenter) UnifyTransferActivity.this.getPresenter()).Y1();
            String b11 = m.b(editable, 30, ((UnifyTransferPresenter) UnifyTransferActivity.this.getPresenter()).a2());
            if (b11 != null) {
                UnifyTransferActivity.this.f46899c.setText(b11);
                UnifyTransferActivity.this.f46899c.setSelection(UnifyTransferActivity.this.f46899c.getText().length());
                return;
            }
            String trim = UnifyTransferActivity.this.f46899c.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.endsWith(InstructionFileId.DOT)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            BigDecimal a11 = m.a(trim);
            boolean matches = UnifyTransferActivity.this.F.matcher(trim).matches();
            if (BigDecimal.ZERO.compareTo(a11) >= 0 || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(Q1) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equals(Y1) || TextUtils.isEmpty(trim) || !matches) {
                boolean unused = UnifyTransferActivity.this.f46920x = false;
            } else {
                boolean unused2 = UnifyTransferActivity.this.f46920x = true;
            }
            UnifyTransferActivity.this.xi();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class g implements Animator.AnimatorListener {
        public g() {
        }

        public void onAnimationCancel(Animator animator) {
            UnifyTransferActivity.this.f46905i.setTranslationY(0.0f);
            UnifyTransferActivity.this.f46906j.setTranslationY(0.0f);
        }

        public void onAnimationEnd(Animator animator) {
            UnifyTransferActivity.this.f46905i.setTranslationY(0.0f);
            UnifyTransferActivity.this.f46906j.setTranslationY(0.0f);
            ((UnifyTransferPresenter) UnifyTransferActivity.this.getPresenter()).p1();
            UnifyTransferActivity.this.Ph();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static void Th(Activity activity, String str, String str2) {
        Uh(activity, str, str2, false, (String) null, false);
    }

    public static void Uh(Activity activity, String str, String str2, boolean z11, String str3, boolean z12) {
        Vh(activity, str, str2, z11, str3, z12, -1);
    }

    public static void Vh(Activity activity, String str, String str2, boolean z11, String str3, boolean z12, int i11) {
        Wh(activity, str, str2, z11, str3, z12, i11, (String) null);
    }

    public static void Wh(Activity activity, String str, String str2, boolean z11, String str3, boolean z12, int i11, String str4) {
        i6.d.j("transfer", "goTransferActivity - " + str + " account:" + str2 + " reverse:" + z11 + " symbol:" + str3 + " isShowTip:" + z12 + " from:" + i11 + " bcurrency:" + str4);
        Intent intent = new Intent(activity, UnifyTransferActivity.class);
        if (str != null) {
            intent.putExtra("coin", str.toLowerCase(Locale.US));
        }
        if (str2 != null) {
            intent.putExtra(Constants.FLAG_ACCOUNT, str2);
        }
        if (str3 != null) {
            String D2 = a1.v().D(str3);
            String n11 = a1.v().n(str3);
            SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
            symbolCurrencyEntity.setName(str3);
            symbolCurrencyEntity.setQuoteCurrency(D2);
            symbolCurrencyEntity.setBaseCurrency(n11);
            intent.putExtra("JUMP_SYMBOL_PAIR", symbolCurrencyEntity);
        }
        if (str4 != null) {
            intent.putExtra("newb", str4);
        }
        intent.putExtra("JUMP_ACCOUNT_REVERSE", z11);
        intent.putExtra("JUMP_SHOWTIP", z12);
        intent.putExtra("KEY_JUMP_FROM", i11);
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            rn.c.i().d(activity, new JumpTarget(intent, (Intent) null));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ai(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() instanceof Float) {
            Float f11 = (Float) valueAnimator.getAnimatedValue();
            this.f46905i.setTranslationY(f11.floatValue());
            this.f46906j.setTranslationY(-f11.floatValue());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bi(View view) {
        if (!((UnifyTransferPresenter) getPresenter()).w2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int abs = Math.abs(this.f46913q.getTop() - this.f46914r.getTop());
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) abs});
            this.E = ofFloat;
            ofFloat.setDuration(500);
            this.E.addUpdateListener(new l9(this));
            this.E.addListener(new g());
        }
        this.E.start();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        this.f46899c.setText(TextUtils.isEmpty(this.f46904h) ? "0.000000" : this.f46904h);
        EditText editText = this.f46899c;
        editText.setSelection(editText.getText().length());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(View view) {
        if (((UnifyTransferPresenter) getPresenter()).t2()) {
            ((UnifyTransferPresenter) getPresenter()).o1(getSupportFragmentManager(), this.f46899c.getText().toString());
        } else {
            ((UnifyTransferPresenter) getPresenter()).E1(getSupportFragmentManager(), this.f46899c.getText().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fi(View view) {
        String N1;
        C2CTransferOutQuotaInfo c2CTransferOutQuotaInfo;
        String str = "2";
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(((UnifyTransferPresenter) getPresenter()).Q1())) {
            if (((UnifyTransferPresenter) getPresenter()).W1() != null) {
                str = ((UnifyTransferPresenter) getPresenter()).W1().getWithdrawRisk();
            }
        } else if ("3".equals(((UnifyTransferPresenter) getPresenter()).Q1())) {
            SymbolCurrencyEntity X1 = ((UnifyTransferPresenter) getPresenter()).X1();
            if (X1 != null) {
                str = a1.v().J(X1.getName(), TradeType.PRO).getWithdrawRisk();
            }
        } else if (!(!"8".equals(((UnifyTransferPresenter) getPresenter()).Q1()) || (N1 = ((UnifyTransferPresenter) getPresenter()).N1()) == null || (c2CTransferOutQuotaInfo = ((UnifyTransferPresenter) getPresenter()).K1().get(N1)) == null)) {
            str = c2CTransferOutQuotaInfo.getWithdrawRisk();
        }
        String N2 = m.N(str, 0, 1);
        DialogUtils.X(this, getString(R.string.transfer_explain_title), String.format(getString(R.string.transfer_explain_context), new Object[]{N2}), (String) null, getString(R.string.liquidation_instruction_dialog_ok), t9.f47339a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gi(View view) {
        A(true);
        ((UnifyTransferPresenter) getPresenter()).Q3(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        ((UnifyTransferPresenter) getPresenter()).b2(false);
        this.f46898b.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        ((UnifyTransferPresenter) getPresenter()).b2(true);
        this.f46898b.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ji(Void voidR) {
        vi();
    }

    public static /* synthetic */ void ki(View view, boolean z11) {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void li(CompoundButton compoundButton, boolean z11) {
        xi();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mi(HBDialogFragment hBDialogFragment) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, MenuItem menuItem, int i11) {
        this.f46921y.dismiss();
        ((UnifyTransferPresenter) getPresenter()).i4(menuItem.getItem_name());
        Ph();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oi(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        C2CBorrowActivity.Ii(this, str);
    }

    public static /* synthetic */ void pi(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        MarginUtil.c(str);
    }

    public static /* synthetic */ void qi(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        MarginUtil.a(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ri(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() instanceof Float) {
            Float f11 = (Float) valueAnimator.getAnimatedValue();
            this.f46914r.setScaleX(f11.floatValue());
            this.f46914r.setScaleY(f11.floatValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void si(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() instanceof Float) {
            Float f11 = (Float) valueAnimator.getAnimatedValue();
            this.f46906j.setAlpha(f11.floatValue());
            this.f46907k.setAlpha(f11.floatValue());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ti(ValueAnimator valueAnimator) {
        if (valueAnimator.getAnimatedValue() instanceof Float) {
            Float f11 = (Float) valueAnimator.getAnimatedValue();
            this.f46906j.setTranslationY(f11.floatValue());
            this.f46907k.setTranslationY(f11.floatValue());
        }
    }

    public final void A(boolean z11) {
        if (z11) {
            this.f46911o.setVisibility(0);
            this.f46911o.p();
            return;
        }
        this.f46911o.setVisibility(8);
    }

    public void Ge() {
        ViewUtil.m(this.f46918v, ((UnifyTransferPresenter) getPresenter()).t2());
    }

    public void If(String str) {
        String str2;
        SymbolBean J2 = a1.v().J(str, TradeType.PRO);
        if (J2 == null) {
            str2 = "";
        } else {
            str2 = J2.getSymbolName();
        }
        DialogUtils.c0(this, getString(R.string.trade_margin_transfer_dialog_content, new Object[]{str2}), "", getString(R.string.string_cancel), getString(R.string.go_to_loan_coin), ad.b.f3517a, new s9(str));
    }

    @SuppressLint({"SetTextI18n"})
    public final void Ph() {
        String str;
        String str2;
        MarketCoin.Coin T1;
        String N1 = ((UnifyTransferPresenter) getPresenter()).N1();
        String i11 = StringUtils.i(N1);
        if (s0.c(((UnifyTransferPresenter) getPresenter()).Q1(), ((UnifyTransferPresenter) getPresenter()).Y1())) {
            i11 = k.C().z(N1);
        } else if ("2".equals(((UnifyTransferPresenter) getPresenter()).V1()) && (T1 = ((UnifyTransferPresenter) getPresenter()).T1(N1)) != null) {
            i11 = T1.getShortName();
        }
        if (((UnifyTransferPresenter) getPresenter()).C1() || !i.d().e()) {
            this.f46912p.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            this.f46912p.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_asset_transfer_down, 0);
        }
        if (((UnifyTransferPresenter) getPresenter()).s2()) {
            this.M.setTransferGuideVisible(true);
            yi();
        } else {
            this.M.setTransferGuideVisible(false);
            zi();
        }
        ui(this.f46906j, ((UnifyTransferPresenter) getPresenter()).v2());
        ui(this.f46905i, ((UnifyTransferPresenter) getPresenter()).o2());
        if (((UnifyTransferPresenter) getPresenter()).m2()) {
            this.f46899c.setText("");
        }
        int a22 = ((UnifyTransferPresenter) getPresenter()).a2();
        this.f46910n.a(a22);
        String str3 = "0.000000";
        if (!TextUtils.isEmpty(i11)) {
            if (this.f46912p.getText() == null || !this.f46912p.getText().toString().equals(i11)) {
                this.f46912p.setText(i11);
            }
            if (this.f46901e.getText() == null || !this.f46901e.getText().toString().equals(i11)) {
                this.f46901e.setText(i11);
            }
            if (TextUtils.isEmpty(((UnifyTransferPresenter) getPresenter()).H1())) {
                str = str3;
            } else {
                str = ((UnifyTransferPresenter) getPresenter()).H1();
            }
            this.f46904h = m.s0(str, a22);
            TextView textView = this.f46900d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(R.string.n_transfer_can_transfer_amount));
            Object[] objArr = new Object[2];
            if (TextUtils.isEmpty(this.f46904h)) {
                str2 = str3;
            } else {
                str2 = this.f46904h;
            }
            objArr[0] = str2;
            objArr[1] = i11;
            sb2.append(String.format(" %s %s", objArr));
            textView.setText(sb2.toString());
        }
        A(false);
        if (((UnifyTransferPresenter) getPresenter()).q2()) {
            if (!TextUtils.isEmpty(((UnifyTransferPresenter) getPresenter()).M1())) {
                str3 = ((UnifyTransferPresenter) getPresenter()).M1();
            }
            String s02 = m.s0(str3, a22);
            ViewUtil.m(this.N, i11.equals("USDT") && !m.b0(s02));
            TextView textView2 = this.N;
            textView2.setText(getResources().getString(R.string.n_transfer_experience_balance) + String.format(" %s %s (%s)", new Object[]{s02, "usdt".toUpperCase(Locale.US), getResources().getString(R.string.n_transfer_can_not_be_transfer)}));
        } else if (((UnifyTransferPresenter) getPresenter()).r2()) {
            if (!TextUtils.isEmpty(((UnifyTransferPresenter) getPresenter()).P1())) {
                str3 = ((UnifyTransferPresenter) getPresenter()).P1();
            }
            String s03 = m.s0(str3, a22);
            ViewUtil.m(this.N, i11.equals("USDT") && !m.b0(s03));
            TextView textView3 = this.N;
            textView3.setText(getResources().getString(R.string.n_transfer_experience_balance) + String.format(" %s %s (%s)", new Object[]{s03, "usdt".toUpperCase(Locale.US), getResources().getString(R.string.n_transfer_can_not_be_transfer)}));
        } else if (((UnifyTransferPresenter) getPresenter()).p2()) {
            if (!TextUtils.isEmpty(((UnifyTransferPresenter) getPresenter()).L1())) {
                str3 = ((UnifyTransferPresenter) getPresenter()).L1();
            }
            String s04 = m.s0(str3, a22);
            ViewUtil.m(this.N, i11.equals("USDT") && !m.b0(s04));
            TextView textView4 = this.N;
            textView4.setText(getResources().getString(R.string.n_transfer_experience_balance) + String.format(" %s %s (%s)", new Object[]{s04, "usdt".toUpperCase(Locale.US), getResources().getString(R.string.n_transfer_can_not_be_transfer)}));
        } else {
            ViewUtil.m(this.N, false);
        }
        ViewUtil.m(this.f46918v, ((UnifyTransferPresenter) getPresenter()).t2());
        xi();
    }

    /* renamed from: Qh */
    public UnifyTransferPresenter createPresenter() {
        return new UnifyTransferPresenter();
    }

    public void R8() {
        Ph();
        if (!this.C) {
            wi();
            this.C = true;
        }
    }

    public final String Rh(SymbolCurrencyEntity symbolCurrencyEntity) {
        if (dn.d.f().m()) {
            return getString(R.string.n_transfer_account_usdt_m);
        }
        String str = getString(R.string.n_transfer_account_usdt_m) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (symbolCurrencyEntity == null) {
            return str;
        }
        String baseCurrency = symbolCurrencyEntity.getBaseCurrency();
        if ("usdt".equalsIgnoreCase(baseCurrency)) {
            return str + getString(R.string.n_linear_swap_cross_account);
        } else if (!"husd".equalsIgnoreCase(baseCurrency) || !"husd".equalsIgnoreCase(symbolCurrencyEntity.getQuoteCurrency())) {
            return str + baseCurrency + "/" + symbolCurrencyEntity.getQuoteCurrency();
        } else {
            return str + getString(R.string.n_linear_swap_cross_husd_account);
        }
    }

    /* renamed from: Sh */
    public UnifyTransferPresenter.m getUI() {
        return this;
    }

    public void W0() {
        this.f46911o.k();
    }

    public final void Xh() {
        String string = getResources().getString(R.string.n_asset_margin_protocol_read);
        String string2 = getResources().getString(R.string.n_asset_margin_protocol);
        String format = String.format(string, new Object[]{string2});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        a aVar = new a();
        int indexOf = format.indexOf(string2);
        int length = string2.length() + indexOf;
        if (length > format.length()) {
            length = format.length();
        }
        spannableStringBuilder.setSpan(aVar, indexOf, length, 34);
        this.f46918v.setBoxContent(spannableStringBuilder);
        this.f46918v.setOnCheckedChangeListener(new o9(this));
        this.f46918v.setLinkMovementMethod();
    }

    public final void Yh() {
        this.f46913q = (ForeShapeRipple) this.viewFinder.b(R.id.transfer_point_top);
        this.f46914r = (ForeShapeRipple) this.viewFinder.b(R.id.transfer_point_bottom);
        int color = ContextCompat.getColor(this, R.color.transfer_shape_ripple_color_blue);
        int color2 = ContextCompat.getColor(this, R.color.transfer_shape_ripple_color_red);
        this.f46913q.setForeColor(ContextCompat.getColor(this, R.color.baseColorMajorTheme100));
        this.f46913q.setRippleCount(1);
        this.f46913q.setEnableSingleRipple(true);
        this.f46913q.setRippleColor(color);
        this.f46913q.setRippleFromColor(color);
        this.f46913q.setRippleDuration(500);
        this.f46913q.setRippleMaximumRadius(0.1f);
        this.f46914r.setForeColor(ContextCompat.getColor(this, R.color.global_huobi_color));
        this.f46914r.setRippleCount(1);
        this.f46914r.setEnableSingleRipple(true);
        this.f46914r.setRippleColor(color2);
        this.f46914r.setRippleFromColor(color2);
        this.f46914r.setRippleDuration(500);
        this.f46913q.setRippleMaximumRadius(0.1f);
        this.f46913q.setForePointSize(getResources().getDimension(R.dimen.dimen_3));
        this.f46914r.setForePointSize(getResources().getDimension(R.dimen.dimen_3));
        this.f46915s = this.viewFinder.b(R.id.transfer_transfer_circle_middle);
        this.f46916t = this.viewFinder.b(R.id.transfer_transfer_circle_top);
        this.f46917u = this.viewFinder.b(R.id.transfer_transfer_circle_bottom);
    }

    public final boolean Zh() {
        if (((UnifyTransferPresenter) getPresenter()).t2()) {
            return this.f46918v.isChecked();
        }
        return true;
    }

    public void addEvent() {
        this.M.setOnItemClickListener(new e());
        if (this.G) {
            this.f46906j.setOnClickListener(new aa(this));
            this.f46905i.setOnClickListener(new ca(this));
            dw.a.a(this.f46912p).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(new v9(this));
            this.f46899c.setOnFocusChangeListener(n9.f47253b);
            this.f46899c.addTextChangedListener(new f());
            this.f46902f.setOnClickListener(new m9(this));
            this.f46903g.setOnClickListener(new da(this));
            this.f46908l.setOnClickListener(new ea(this));
            this.f46909m.setOnClickListener(new ba(this));
            this.f46911o.setOnRetryClickListener(new z9(this));
        }
    }

    public void b4(String str) {
        this.I.setText(str);
    }

    public void b9(String str) {
        String str2;
        SymbolBean J2 = a1.v().J(str, TradeType.PRO);
        if (J2 == null) {
            str2 = "";
        } else {
            str2 = J2.getSymbolName();
        }
        DialogUtils.c0(this, getString(R.string.trade_c2c_margin_transfer_dialog_content, new Object[]{str2}), "", getString(R.string.string_cancel), getString(R.string.go_to_loan_coin), ad.b.f3517a, new q9(this, str));
    }

    public int getContentView() {
        return R.layout.activity_transfer_unify_new;
    }

    public void gh(String str) {
        DialogUtils.c0(this, getString(R.string.super_margin_transfer_dialog_content), "", getString(R.string.string_cancel), getString(R.string.go_to_loan_coin), ad.b.f3517a, new r9(str));
    }

    public void initView() {
        if (r.x().X() && !gj.d.n().E() && !gj.d.n().G()) {
            this.G = false;
        }
        if (!this.G) {
            ViewUtil.m(this.viewFinder.b(R.id.transfer_scrollview), false);
            ViewUtil.m(this.viewFinder.b(R.id.btn_action), false);
            ViewUtil.m(this.viewFinder.b(R.id.loading_layout), false);
            DialogUtils.X(this, getString(R.string.dialog_minamount_hint_title), getString(R.string.transfer_unavailable_tips), (String) null, getString(R.string.dialog_minamount_hint_confrm_btn), new p9(this));
            return;
        }
        View b11 = this.viewFinder.b(R.id.tv_cloud_wallet_transfer);
        this.J = b11;
        ViewUtil.m(b11, ti.a.a());
        this.f46899c = (EditText) this.viewFinder.b(R.id.transfer_edit_amount);
        this.I = (TextView) this.viewFinder.b(R.id.tv_transfer_desc);
        this.f46898b = new CustomBoardView(this);
        this.f46898b.setGravity(80);
        this.f46898b.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        ((FrameLayout) findViewById(16908290)).addView(this.f46898b, layoutParams);
        this.f46900d = (TextView) this.viewFinder.b(R.id.transfer_available_text);
        this.f46901e = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f46905i = (TextView) this.viewFinder.b(R.id.tv_from_account);
        this.f46906j = (TextView) this.viewFinder.b(R.id.tv_to_account);
        this.f46907k = (TextView) this.viewFinder.b(R.id.tv_to);
        this.f46902f = this.viewFinder.b(R.id.transfer_exchange_layout);
        this.f46903g = this.viewFinder.b(R.id.tv_all);
        this.f46908l = (Button) this.viewFinder.b(R.id.btn_action);
        this.f46909m = this.viewFinder.b(R.id.transfer_icon_ask);
        PointLengthFilter pointLengthFilter = new PointLengthFilter();
        this.f46910n = pointLengthFilter;
        this.f46899c.setFilters(new InputFilter[]{pointLengthFilter});
        this.f46911o = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        A(true);
        this.f46912p = (TextView) this.viewFinder.b(R.id.currency_title);
        this.N = (TextView) this.viewFinder.b(R.id.transfer_experience_balance);
        HbTitleBar hbTitleBar = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.K = hbTitleBar;
        this.L = hbTitleBar.getRightContainer();
        this.M = new UnifyTransferGuide(this);
        this.L.addView(this.M, new FrameLayout.LayoutParams(-2, -1));
        this.f46918v = (AgreementTextView) findViewById(R.id.agreement_view);
        this.f46919w = new TransferAgreementBottomDialog();
        Yh();
        Xh();
        this.H = new HuobiKeyboardHelper().attach(this).registerInput(this.f46899c);
    }

    public boolean isAvailable() {
        return this.G;
    }

    public void onBackPressed() {
        if (this.H.getBoardView().keyboardVisible()) {
            this.H.hideKeyboard();
        } else {
            super.onBackPressed();
        }
    }

    public void onStop() {
        super.onStop();
        this.H.hideKeyboard();
    }

    public void q2() {
    }

    public final void ui(TextView textView, boolean z11) {
        if (z11) {
            if (this.A == null) {
                Drawable drawable = getResources().getDrawable(R.drawable.ic_asset_transfer_down);
                this.A = drawable;
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.A.getMinimumHeight());
            }
            textView.setCompoundDrawables((Drawable) null, (Drawable) null, this.A, (Drawable) null);
            return;
        }
        textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public final void vi() {
        String str;
        MenuItem.MenuItemStyle menuItemStyle;
        if (!((UnifyTransferPresenter) getPresenter()).h2() && !((UnifyTransferPresenter) getPresenter()).d2() && !((UnifyTransferPresenter) getPresenter()).k2() && !((UnifyTransferPresenter) getPresenter()).e2() && !((UnifyTransferPresenter) getPresenter()).g2() && !((UnifyTransferPresenter) getPresenter()).i2() && !((UnifyTransferPresenter) getPresenter()).j2() && !((UnifyTransferPresenter) getPresenter()).f2() && !((UnifyTransferPresenter) getPresenter()).C1()) {
            this.f46922z.clear();
            for (String next : ((UnifyTransferPresenter) getPresenter()).I1()) {
                if (next != null) {
                    if (s0.c(((UnifyTransferPresenter) getPresenter()).Q1(), ((UnifyTransferPresenter) getPresenter()).Y1())) {
                        str = k.C().z(next);
                    } else {
                        str = StringUtils.i(next);
                    }
                    if (next.equalsIgnoreCase(((UnifyTransferPresenter) getPresenter()).N1())) {
                        menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                    } else {
                        menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                    }
                    this.f46922z.add(new MenuItem(next, str, menuItemStyle, this.B));
                }
            }
            this.f46921y.setMenuItems(this.f46922z);
            this.f46921y.show(getFragmentManager(), "BottomMenuFragment");
        }
    }

    public final void wi() {
        AnimatorSet animatorSet = this.D;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        float dimension = getResources().getDimension(R.dimen.dimen_15);
        float dimension2 = getResources().getDimension(R.dimen.dimen_5);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        ofFloat.addUpdateListener(new y9(this));
        ofFloat.setDuration(500);
        ofFloat.setStartDelay(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f46914r, "translationY", new float[]{(float) (this.f46913q.getTop() - this.f46914r.getTop()), 0.0f});
        ofFloat2.setDuration(500);
        ofFloat2.setStartDelay(300);
        ofFloat2.addListener(new b(dimension));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f46915s, "alpha", new float[]{0.0f, 1.0f});
        ofFloat3.setStartDelay(400);
        ofFloat3.setDuration(100);
        ofFloat3.addListener(new c());
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f46916t, "alpha", new float[]{0.0f, 1.0f});
        ofFloat4.setStartDelay(300);
        ofFloat4.setDuration(100);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f46917u, "alpha", new float[]{0.0f, 1.0f});
        ofFloat5.setStartDelay(500);
        ofFloat5.setDuration(100);
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat6.addUpdateListener(new w9(this));
        ofFloat6.setDuration(300);
        ofFloat6.setStartDelay(400);
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(new float[]{-dimension2, 0.0f});
        ofFloat7.addUpdateListener(new x9(this));
        ofFloat7.setDuration(300);
        ofFloat7.setStartDelay(400);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.D = animatorSet2;
        animatorSet2.playTogether(new Animator[]{ofFloat2, ofFloat, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7});
        this.D.addListener(new d(dimension));
        this.D.start();
    }

    public final void xi() {
        this.f46908l.setEnabled(Zh() && this.f46920x);
    }

    public final void yi() {
        this.f46909m.setVisibility(8);
        this.f46905i.setText(Rh(((UnifyTransferPresenter) getPresenter()).R1()));
        this.f46906j.setText(Rh(((UnifyTransferPresenter) getPresenter()).Z1()));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r18 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zi() {
        /*
            r20 = this;
            r0 = r20
            com.hbg.lib.common.mvp.ActivityPresenter r1 = r20.getPresenter()
            com.huobi.finance.presenter.UnifyTransferPresenter r1 = (com.huobi.finance.presenter.UnifyTransferPresenter) r1
            com.huobi.finance.bean.SymbolCurrencyEntity r1 = r1.X1()
            com.hbg.lib.common.mvp.ActivityPresenter r2 = r20.getPresenter()
            com.huobi.finance.presenter.UnifyTransferPresenter r2 = (com.huobi.finance.presenter.UnifyTransferPresenter) r2
            java.lang.String r2 = r2.Q1()
            com.hbg.lib.common.mvp.ActivityPresenter r3 = r20.getPresenter()
            com.huobi.finance.presenter.UnifyTransferPresenter r3 = (com.huobi.finance.presenter.UnifyTransferPresenter) r3
            java.lang.String r3 = r3.Y1()
            r2.hashCode()
            int r4 = r2.hashCode()
            java.lang.String r5 = "12"
            java.lang.String r6 = "10"
            java.lang.String r7 = "9"
            java.lang.String r8 = "8"
            java.lang.String r9 = "7"
            java.lang.String r10 = "6"
            java.lang.String r11 = "4"
            java.lang.String r12 = "3"
            java.lang.String r13 = "2"
            java.lang.String r14 = "1"
            java.lang.String r15 = "13"
            r16 = r1
            java.lang.String r1 = "11"
            r17 = r3
            r3 = 8
            r18 = -1
            switch(r4) {
                case 49: goto L_0x00ba;
                case 50: goto L_0x00b0;
                case 51: goto L_0x00a5;
                case 52: goto L_0x009c;
                case 54: goto L_0x0093;
                case 55: goto L_0x008a;
                case 56: goto L_0x0081;
                case 57: goto L_0x0078;
                case 1567: goto L_0x006e;
                case 1568: goto L_0x0063;
                case 1569: goto L_0x0058;
                case 1570: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x00c3
        L_0x004c:
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0054
            goto L_0x00c3
        L_0x0054:
            r2 = 11
            goto L_0x00ad
        L_0x0058:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0060
            goto L_0x00c3
        L_0x0060:
            r2 = 10
            goto L_0x00ad
        L_0x0063:
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x006b
            goto L_0x00c3
        L_0x006b:
            r2 = 9
            goto L_0x00ad
        L_0x006e:
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0075
            goto L_0x00c3
        L_0x0075:
            r18 = r3
            goto L_0x00c3
        L_0x0078:
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x007f
            goto L_0x00c3
        L_0x007f:
            r2 = 7
            goto L_0x00ad
        L_0x0081:
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x0088
            goto L_0x00c3
        L_0x0088:
            r2 = 6
            goto L_0x00ad
        L_0x008a:
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x0091
            goto L_0x00c3
        L_0x0091:
            r2 = 5
            goto L_0x00ad
        L_0x0093:
            boolean r2 = r2.equals(r10)
            if (r2 != 0) goto L_0x009a
            goto L_0x00c3
        L_0x009a:
            r2 = 4
            goto L_0x00ad
        L_0x009c:
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x00a3
            goto L_0x00c3
        L_0x00a3:
            r2 = 3
            goto L_0x00ad
        L_0x00a5:
            boolean r2 = r2.equals(r12)
            if (r2 != 0) goto L_0x00ac
            goto L_0x00c3
        L_0x00ac:
            r2 = 2
        L_0x00ad:
            r18 = r2
            goto L_0x00c3
        L_0x00b0:
            boolean r2 = r2.equals(r13)
            if (r2 != 0) goto L_0x00b7
            goto L_0x00c3
        L_0x00b7:
            r18 = 1
            goto L_0x00c3
        L_0x00ba:
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r18 = 0
        L_0x00c3:
            r2 = 2132020076(0x7f140b6c, float:1.9678505E38)
            java.lang.String r19 = ""
            r4 = 2132020079(0x7f140b6f, float:1.967851E38)
            switch(r18) {
                case 0: goto L_0x028c;
                case 1: goto L_0x027b;
                case 2: goto L_0x0228;
                case 3: goto L_0x020e;
                case 4: goto L_0x01f9;
                case 5: goto L_0x01df;
                case 6: goto L_0x0198;
                case 7: goto L_0x0184;
                case 8: goto L_0x016a;
                case 9: goto L_0x0133;
                case 10: goto L_0x011f;
                case 11: goto L_0x00df;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r1.setText(r4)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r2)
            goto L_0x040b
        L_0x00df:
            android.widget.TextView r2 = r0.f46905i
            r5 = 2132025219(0x7f141f83, float:1.9688936E38)
            r2.setText(r5)
            r2 = r17
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0107
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            r14 = r16
            java.lang.String r1 = r0.Rh(r14)
            android.widget.TextView r2 = r0.f46906j
            r2.setText(r1)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r5 = 1
            r1.setTransferGuideVisible(r5)
            goto L_0x040b
        L_0x0107:
            r5 = 1
            boolean r1 = r14.equals(r2)
            if (r1 == 0) goto L_0x040b
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r1.setTransferGuideVisible(r5)
            goto L_0x040b
        L_0x011f:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r2 = 2132020078(0x7f140b6e, float:1.9678509E38)
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x0133:
            r14 = r16
            r2 = r17
            boolean r1 = r15.equals(r2)
            if (r1 == 0) goto L_0x014f
            java.lang.String r1 = r0.Rh(r14)
            android.widget.TextView r2 = r0.f46905i
            r2.setText(r1)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132025219(0x7f141f83, float:1.9688936E38)
            r1.setText(r2)
            goto L_0x015d
        L_0x014f:
            java.lang.String r1 = r0.Rh(r14)
            android.widget.TextView r2 = r0.f46905i
            r2.setText(r1)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
        L_0x015d:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r2 = 1
            r1.setTransferGuideVisible(r2)
            goto L_0x040b
        L_0x016a:
            r2 = 1
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r3 = 2132020171(0x7f140bcb, float:1.9678698E38)
            r1.setText(r3)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r1.setTransferGuideVisible(r2)
            goto L_0x040b
        L_0x0184:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r2 = 2132019593(0x7f140989, float:1.9677525E38)
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x0198:
            r14 = r16
            android.view.View r1 = r0.f46909m
            r2 = 0
            r1.setVisibility(r2)
            r1 = 2132017889(0x7f1402e1, float:1.967407E38)
            java.lang.String r1 = r0.getString(r1)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            if (r14 != 0) goto L_0x01ad
            goto L_0x01cc
        L_0x01ad:
            d7.a1 r3 = d7.a1.v()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r14.getBaseCurrency()
            r5.append(r6)
            java.lang.String r6 = r14.getQuoteCurrency()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r19 = r3.W(r5)
        L_0x01cc:
            r3 = 0
            r2[r3] = r19
            java.lang.String r1 = java.lang.String.format(r1, r2)
            android.widget.TextView r2 = r0.f46905i
            r2.setText(r1)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x01df:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r2 = 2132025218(0x7f141f82, float:1.9688934E38)
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r2 = 1
            r1.setTransferGuideVisible(r2)
            goto L_0x040b
        L_0x01f9:
            android.view.View r1 = r0.f46909m
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f46905i
            r2 = 2132025215(0x7f141f7f, float:1.9688928E38)
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x020e:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r2 = 2132025217(0x7f141f81, float:1.9688932E38)
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r2 = 1
            r1.setTransferGuideVisible(r2)
            goto L_0x040b
        L_0x0228:
            r14 = r16
            android.view.View r1 = r0.f46909m
            r2 = 0
            r1.setVisibility(r2)
            if (r14 != 0) goto L_0x0233
            goto L_0x0252
        L_0x0233:
            d7.a1 r1 = d7.a1.v()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r14.getBaseCurrency()
            r2.append(r3)
            java.lang.String r3 = r14.getQuoteCurrency()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r19 = r1.W(r2)
        L_0x0252:
            r1 = r19
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 2132025220(0x7f141f84, float:1.9688938E38)
            java.lang.String r3 = r0.getString(r3)
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.widget.TextView r2 = r0.f46905i
            r2.setText(r1)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x027b:
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46905i
            r1.setText(r2)
            android.widget.TextView r1 = r0.f46906j
            r1.setText(r4)
            goto L_0x040b
        L_0x028c:
            r14 = r16
            r2 = r17
            android.widget.TextView r3 = r0.f46905i
            r3.setText(r4)
            boolean r3 = r11.equals(r2)
            if (r3 == 0) goto L_0x02b2
            android.view.View r1 = r0.f46909m
            r3 = 8
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132025217(0x7f141f81, float:1.9688932E38)
            r1.setText(r2)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r4 = 1
            r1.setTransferGuideVisible(r4)
            goto L_0x040b
        L_0x02b2:
            r3 = 8
            r4 = 1
            boolean r9 = r9.equals(r2)
            if (r9 == 0) goto L_0x02cf
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132025218(0x7f141f82, float:1.9688934E38)
            r1.setText(r2)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r1.setTransferGuideVisible(r4)
            goto L_0x040b
        L_0x02cf:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x02ea
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            java.lang.String r1 = r0.Rh(r14)
            android.widget.TextView r2 = r0.f46906j
            r2.setText(r1)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r1.setTransferGuideVisible(r4)
            goto L_0x040b
        L_0x02ea:
            boolean r1 = r6.equals(r2)
            if (r1 == 0) goto L_0x0304
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132020171(0x7f140bcb, float:1.9678698E38)
            r1.setText(r2)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r1.setTransferGuideVisible(r4)
            goto L_0x040b
        L_0x0304:
            boolean r1 = r5.equals(r2)
            if (r1 == 0) goto L_0x0319
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132020078(0x7f140b6e, float:1.9678509E38)
            r1.setText(r2)
            goto L_0x040b
        L_0x0319:
            boolean r1 = r13.equals(r2)
            if (r1 == 0) goto L_0x032e
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132020076(0x7f140b6c, float:1.9678505E38)
            r1.setText(r2)
            goto L_0x040b
        L_0x032e:
            boolean r1 = r10.equals(r2)
            if (r1 == 0) goto L_0x0343
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132025215(0x7f141f7f, float:1.9688928E38)
            r1.setText(r2)
            goto L_0x040b
        L_0x0343:
            boolean r1 = r12.equals(r2)
            if (r1 == 0) goto L_0x0394
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            if (r14 != 0) goto L_0x0351
            goto L_0x0370
        L_0x0351:
            d7.a1 r1 = d7.a1.v()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r14.getBaseCurrency()
            r2.append(r3)
            java.lang.String r3 = r14.getQuoteCurrency()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r19 = r1.W(r2)
        L_0x0370:
            r1 = r19
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r1 = 2132025220(0x7f141f84, float:1.9688938E38)
            java.lang.String r1 = r0.getString(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.widget.TextView r2 = r0.f46906j
            r2.setText(r1)
            goto L_0x040b
        L_0x0394:
            boolean r1 = r7.equals(r2)
            if (r1 == 0) goto L_0x03aa
            android.view.View r1 = r0.f46909m
            r3 = 8
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132019593(0x7f140989, float:1.9677525E38)
            r1.setText(r2)
            goto L_0x040b
        L_0x03aa:
            r3 = 8
            boolean r1 = r8.equals(r2)
            if (r1 == 0) goto L_0x03f0
            android.view.View r1 = r0.f46909m
            r1.setVisibility(r3)
            r1 = 2132017889(0x7f1402e1, float:1.967407E38)
            java.lang.String r1 = r0.getString(r1)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            if (r14 != 0) goto L_0x03c4
            goto L_0x03e3
        L_0x03c4:
            d7.a1 r3 = d7.a1.v()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r14.getBaseCurrency()
            r4.append(r5)
            java.lang.String r5 = r14.getQuoteCurrency()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r19 = r3.W(r4)
        L_0x03e3:
            r3 = 0
            r2[r3] = r19
            java.lang.String r1 = java.lang.String.format(r1, r2)
            android.widget.TextView r2 = r0.f46906j
            r2.setText(r1)
            goto L_0x040b
        L_0x03f0:
            boolean r1 = r15.equals(r2)
            if (r1 == 0) goto L_0x040b
            android.view.View r1 = r0.f46909m
            r2 = 8
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f46906j
            r2 = 2132025219(0x7f141f83, float:1.9688936E38)
            r1.setText(r2)
            com.huobi.view.UnifyTransferGuide r1 = r0.M
            r2 = 1
            r1.setTransferGuideVisible(r2)
        L_0x040b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.UnifyTransferActivity.zi():void");
    }
}
