package com.huobi.trade.ui;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.supermargin.ui.TradeVerticalSuperMarginFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import i6.r;
import java.util.concurrent.TimeUnit;
import ks.g;
import pro.huobi.R;
import rx.Observable;

public class MarginModeDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f82266b;

    /* renamed from: c  reason: collision with root package name */
    public View f82267c;

    /* renamed from: d  reason: collision with root package name */
    public View f82268d;

    /* renamed from: e  reason: collision with root package name */
    public View f82269e;

    /* renamed from: f  reason: collision with root package name */
    public View f82270f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82271g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82272h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82273i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f82274j = false;

    /* renamed from: k  reason: collision with root package name */
    public View f82275k;

    /* renamed from: l  reason: collision with root package name */
    public int f82276l;

    /* renamed from: m  reason: collision with root package name */
    public View f82277m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82278n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f82279o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f82280p;

    /* renamed from: q  reason: collision with root package name */
    public TradeFragment f82281q;

    /* renamed from: r  reason: collision with root package name */
    public int f82282r = 0;

    /* renamed from: s  reason: collision with root package name */
    public String f82283s;

    /* renamed from: t  reason: collision with root package name */
    public String f82284t;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(ImageView imageView, Void voidR) {
        if (this.f82274j) {
            imageView.setImageResource(R.drawable.common_check_new_unselected);
        } else {
            imageView.setImageResource(R.drawable.common_check_new_selected);
        }
        this.f82274j = !this.f82274j;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(Void voidR) {
        TradeFragment tradeFragment = this.f82281q;
        if (tradeFragment != null) {
            tradeFragment.Jh(this.f82276l == 2 ? TradeType.MARGIN : TradeType.SUPERMARGIN);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(Void voidR) {
        Ch();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(Void voidR) {
        Dh();
    }

    public final void Ch() {
        this.f82276l = 1;
        this.f82267c.setSelected(true);
        this.f82271g.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
        this.f82269e.setVisibility(0);
        this.f82278n.setVisibility(0);
        this.f82268d.setSelected(false);
        this.f82272h.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
        this.f82270f.setVisibility(8);
        this.f82279o.setVisibility(8);
    }

    public final void Dh() {
        this.f82276l = 2;
        this.f82267c.setSelected(false);
        this.f82271g.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
        this.f82269e.setVisibility(8);
        this.f82278n.setVisibility(8);
        this.f82268d.setSelected(true);
        this.f82272h.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
        this.f82270f.setVisibility(0);
        this.f82279o.setVisibility(0);
    }

    public void addEvent(r rVar) {
        this.f82266b.setOnClickListener(new a(this));
    }

    public void afterInit() {
        this.f82275k.setRotation(180.0f);
        Fragment parentFragment = getParentFragment();
        boolean z11 = parentFragment instanceof TradeVerticalSuperMarginFragment;
        if (parentFragment instanceof TradeBaseFragment) {
            Fragment parentFragment2 = parentFragment.getParentFragment();
            if (parentFragment2 instanceof TradeFragment) {
                this.f82281q = (TradeFragment) parentFragment2;
            }
            if (this.f82282r != 0) {
                this.f82277m.setVisibility(8);
                this.viewFinder.b(R.id.dialog_ll_content_open).setVisibility(0);
                if (this.f82282r == 1) {
                    Ch();
                    this.f82280p.setText(String.format(getString(R.string.n_trade_margin_symbol_only_support), new Object[]{getString(R.string.n_trade_margin_superMargin_mode)}));
                } else {
                    Dh();
                    this.f82280p.setText(String.format(getString(R.string.n_trade_margin_symbol_only_support), new Object[]{getString(R.string.n_trade_margin_margin_mode)}));
                }
            } else {
                if (!TextUtils.isEmpty(this.f82283s)) {
                    this.f82272h.setText(g.e(getContext().getString(R.string.n_contract_trade_margin), this.f82283s));
                }
                if (!TextUtils.isEmpty(this.f82284t)) {
                    this.f82271g.setText(g.e(getContext().getString(R.string.n_contract_super_margin), this.f82284t));
                }
            }
        }
        if (z11) {
            Ch();
        } else {
            Dh();
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_margin_mode;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        if (getArguments() != null) {
            this.f82282r = getArguments().getInt("KEY_SUPPORT_MARGIN_MODE");
            this.f82283s = getArguments().getString("KEY_SUPPORT_MARGIN_RATIO");
            this.f82284t = getArguments().getString("KEY_SUPPORT_SUPER_MARGIN_RATIO");
        }
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new b(this));
        this.f82266b = rVar.b(R.id.iv_close);
        this.f82267c = rVar.b(R.id.dialog_fl_cross);
        this.f82271g = (TextView) rVar.b(R.id.dialog_tv_cross);
        this.f82269e = rVar.b(R.id.dialog_iv_cross);
        this.f82268d = rVar.b(R.id.dialog_fl_isolated);
        this.f82272h = (TextView) rVar.b(R.id.dialog_tv_isolated);
        this.f82270f = rVar.b(R.id.dialog_iv_isolated);
        this.f82275k = rVar.b(R.id.dialog_iv_content_open);
        this.f82273i = (TextView) rVar.b(R.id.tv_content);
        this.f82277m = rVar.b(R.id.ll_mode_switch);
        this.f82280p = (TextView) rVar.b(R.id.tv_margin_mode_title);
        this.f82278n = (TextView) rVar.b(R.id.dialog_tv_content_cross);
        this.f82279o = (TextView) rVar.b(R.id.dialog_tv_content_isolated);
        Observable<Void> a11 = a.a(this.f82267c);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new c(this));
        a.a(this.f82268d).throttleFirst(1, timeUnit).subscribe(new d(this));
        a.a(rVar.b(R.id.dialog_ll_cb)).throttleFirst(1, timeUnit).subscribe(new f(this, (ImageView) rVar.b(R.id.dialog_iv_cb)));
        a.a(rVar.b(R.id.dialog_btn)).throttleFirst(1, timeUnit).subscribe(new e(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.n_contract_cross_leading));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(getString(R.string.n_contract_cross_description));
        this.f82278n.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getString(R.string.n_contract_isolate_leading));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(getString(R.string.n_contract_isolate_description));
        this.f82279o.setText(spannableStringBuilder2);
        this.f82280p.setText(String.format(getString(R.string.n_trade_margin_symbol_only_support), new Object[]{getString(R.string.n_trade_margin_superMargin_mode)}));
    }

    public boolean isTransparent() {
        return false;
    }
}
