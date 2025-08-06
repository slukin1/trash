package com.huobi.savings.mining.ui;

import android.content.res.Resources;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.MiningDetailBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.d1;
import com.huobi.view.InputView;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Map;
import pro.huobi.R;
import u6.g;
import xq.a0;
import xq.b0;
import xq.w;
import xq.x;
import xq.y;
import xq.z;

public class MiningRedeemDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public StatusButton f80729b;

    /* renamed from: c  reason: collision with root package name */
    public StatusButton f80730c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80731d;

    /* renamed from: e  reason: collision with root package name */
    public InputView f80732e;

    /* renamed from: f  reason: collision with root package name */
    public CommonCheckBox f80733f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80734g;

    /* renamed from: h  reason: collision with root package name */
    public MiningDetailBean f80735h;

    /* renamed from: i  reason: collision with root package name */
    public MiningDetailActivity f80736i;

    /* renamed from: j  reason: collision with root package name */
    public long f80737j;

    public class a extends ClickableSpan {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            MiningRedeemDialogFragment.this.f80733f.performClick();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(MiningRedeemDialogFragment.this.getResources().getColor(R.color.baseColorSecondaryText));
            textPaint.setUnderlineText(false);
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(MiningRedeemDialogFragment.this.getContext(), d1.k(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(MiningRedeemDialogFragment.this.getResources().getColor(R.color.baseColorMajorTheme100));
            textPaint.setUnderlineText(false);
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            MiningRedeemDialogFragment.this.Bh();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80741b;

        public d(String str) {
            this.f80741b = str;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MiningRedeemDialogFragment.this.f80730c.dismissAnim();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MiningRedeemDialogFragment.this.f80730c.dismissAnim();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.v(this.f80741b);
            FragmentActivity activity = MiningRedeemDialogFragment.this.getActivity();
            MiningRedeemDialogFragment.this.dismiss();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public MiningRedeemDialogFragment(MiningDetailActivity miningDetailActivity) {
        this.f80736i = miningDetailActivity;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        this.f80732e.setInputText(this.f80735h.getRedeemAmount());
        this.f80736i.ai("5175");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Eh(String str, HBDialogFragment hBDialogFragment) {
        Fh(str);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        this.f80736i.ai("5176");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        CommonCheckBox commonCheckBox = this.f80733f;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        Bh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.f80735h != null) {
            Gh();
            this.f80736i.ai("5177");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Bh() {
        BigDecimal a11 = m.a(this.f80732e.getEditTextInput().getText().toString());
        m.a(this.f80735h.getRedeemAmount());
        this.f80730c.setEnabled(this.f80733f.isChecked() && a11.compareTo(BigDecimal.ZERO) > 0);
    }

    public final void Ch() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.n_mining_agreement_label));
        spannableStringBuilder.append(" ");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(getResources().getString(R.string.n_mining_agreement_text));
        a aVar = new a();
        b bVar = new b();
        spannableStringBuilder.setSpan(aVar, 0, length, 17);
        spannableStringBuilder.setSpan(bVar, length, spannableStringBuilder.length(), 17);
        this.f80734g.setMovementMethod(LinkMovementMethod.getInstance());
        this.f80734g.setHighlightColor(0);
        this.f80734g.setText(spannableStringBuilder);
    }

    public final void Fh(String str) {
        String string = getActivity().getResources().getString(R.string.n_mining_redeem_success);
        this.f80730c.showAnim();
        v7.b.a().E0(this.f80735h.getOrderId(), str).b().compose(RxJavaHelper.t((g) null)).subscribe(new d(string));
    }

    public final void Gh() {
        String obj = this.f80732e.getEditTextInput().getText().toString();
        BigDecimal a11 = m.a(obj);
        BigDecimal a12 = m.a(this.f80735h.getRedeemAmount());
        if (a11.compareTo(a12) > 0) {
            HuobiToastUtil.m(getActivity().getResources().getString(R.string.n_mining_input_invalid));
        } else if (this.f80735h.getCouponStatus() == 1 && a11.compareTo(a12) == 0) {
            DialogUtils.c0(getActivity(), getString(R.string.n_balance_earn_redeem_hint), (String) null, getString(R.string.login_dialog_cancel), getString(R.string.login_dialog_confirm), ad.b.f3517a, new b0(this, obj));
        } else {
            Fh(obj);
        }
    }

    public void Hh(MiningDetailBean miningDetailBean) {
        this.f80735h = miningDetailBean;
    }

    public void addEvent(r rVar) {
        this.f80729b.setOnClickListener(new x(this));
        this.f80733f.setOnClickListener(new z(this));
        this.f80732e.getEditTextInput().addTextChangedListener(new c());
        this.f80730c.setOnClickListener(new y(this));
    }

    public void afterInit() {
    }

    public void dismiss() {
        super.dismiss();
        if (this.f80736i != null) {
            is.a.r("5193", this.f80736i.Fh(), String.valueOf(SystemClock.elapsedRealtime() - this.f80737j), (Map<String, Object>) null);
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_mining_redeem_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.dialog_bg).setOnClickListener(new a0(this));
        this.f80729b = (StatusButton) rVar.b(R.id.dialogCancel);
        this.f80730c = (StatusButton) rVar.b(R.id.dialogRedeem);
        this.f80731d = (TextView) rVar.b(R.id.dialogTitleText);
        this.f80732e = (InputView) rVar.b(R.id.inputView);
        this.f80733f = (CommonCheckBox) rVar.b(R.id.checkBox);
        this.f80734g = (TextView) rVar.b(R.id.agreementLabel);
        this.f80732e.setInputType(0, 0, 8, 1002);
        this.f80733f.setChecked(false);
        this.f80730c.setEnabled(false);
        Ch();
        MiningDetailBean miningDetailBean = this.f80735h;
        if (miningDetailBean != null && miningDetailBean.getCurrency() != null) {
            String upperCase = this.f80735h.getCurrency().toUpperCase();
            this.f80732e.setEndTextOperatorText(upperCase);
            this.f80732e.setTextViewInputOperationRightOnClickListener(new w(this));
            Resources resources = getActivity().getResources();
            TextView textView = this.f80731d;
            textView.setText(resources.getString(R.string.n_mining_redeem_text) + " " + upperCase);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(resources.getString(R.string.n_mining_available_redeem_amount));
            spannableStringBuilder.append(" ");
            int length = spannableStringBuilder.length();
            if (this.f80735h.getRedeemAmount() != null) {
                spannableStringBuilder.append(this.f80735h.getRedeemAmount());
            }
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(upperCase);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.baseColorPrimaryText)), length, spannableStringBuilder.length(), 17);
            this.f80732e.setLabelHelpText(spannableStringBuilder);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void onResume() {
        super.onResume();
        this.f80737j = SystemClock.elapsedRealtime();
    }
}
