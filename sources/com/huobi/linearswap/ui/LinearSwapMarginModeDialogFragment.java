package com.huobi.linearswap.ui;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import cn.s;
import cn.t;
import cn.u;
import cn.v;
import cn.w;
import cn.x;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import i6.r;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;

public class LinearSwapMarginModeDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f75211b;

    /* renamed from: c  reason: collision with root package name */
    public View f75212c;

    /* renamed from: d  reason: collision with root package name */
    public View f75213d;

    /* renamed from: e  reason: collision with root package name */
    public View f75214e;

    /* renamed from: f  reason: collision with root package name */
    public View f75215f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f75216g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f75217h;

    /* renamed from: i  reason: collision with root package name */
    public View f75218i;

    /* renamed from: j  reason: collision with root package name */
    public LinearSwapTradeBasePresenter f75219j;

    /* renamed from: k  reason: collision with root package name */
    public LinearSwapTradeBaseFragment f75220k;

    /* renamed from: l  reason: collision with root package name */
    public int f75221l;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(View view, Void voidR) {
        if (view.getVisibility() == 0) {
            view.setVisibility(8);
            this.f75218i.setRotation(180.0f);
            return;
        }
        view.setVisibility(0);
        this.f75218i.setRotation(0.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(Void voidR) {
        LinearSwapTradeBaseFragment linearSwapTradeBaseFragment = this.f75220k;
        if (linearSwapTradeBaseFragment != null) {
            linearSwapTradeBaseFragment.hc(this.f75221l);
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
        this.f75221l = 1;
        this.f75212c.setSelected(true);
        this.f75216g.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
        this.f75214e.setVisibility(0);
        this.f75213d.setSelected(false);
        this.f75217h.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
        this.f75215f.setVisibility(8);
    }

    public final void Dh() {
        this.f75221l = 2;
        this.f75212c.setSelected(false);
        this.f75216g.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
        this.f75214e.setVisibility(8);
        this.f75213d.setSelected(true);
        this.f75217h.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
        this.f75215f.setVisibility(0);
    }

    public void addEvent(r rVar) {
        this.f75211b.setOnClickListener(new t(this));
    }

    public void afterInit() {
        this.f75218i.setRotation(180.0f);
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof LinearSwapTradeBaseFragment) {
            LinearSwapTradeBaseFragment linearSwapTradeBaseFragment = (LinearSwapTradeBaseFragment) parentFragment;
            this.f75220k = linearSwapTradeBaseFragment;
            BaseFragmentPresenter yh2 = linearSwapTradeBaseFragment.yh();
            if (yh2 instanceof LinearSwapTradeBasePresenter) {
                this.f75219j = (LinearSwapTradeBasePresenter) yh2;
            }
        }
        LinearSwapTradeBasePresenter linearSwapTradeBasePresenter = this.f75219j;
        if (linearSwapTradeBasePresenter == null) {
            return;
        }
        if (linearSwapTradeBasePresenter.D2() == 2) {
            Dh();
        } else {
            Ch();
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_linear_swap_margin_mode;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new s(this));
        this.f75211b = rVar.b(R.id.iv_close);
        this.f75212c = rVar.b(R.id.dialog_fl_cross);
        this.f75216g = (TextView) rVar.b(R.id.dialog_tv_cross);
        this.f75214e = rVar.b(R.id.dialog_iv_cross);
        this.f75213d = rVar.b(R.id.dialog_fl_isolated);
        this.f75217h = (TextView) rVar.b(R.id.dialog_tv_isolated);
        this.f75215f = rVar.b(R.id.dialog_iv_isolated);
        this.f75218i = rVar.b(R.id.dialog_iv_content_open);
        View b11 = rVar.b(R.id.dialog_ll_content);
        Observable<Void> a11 = a.a(this.f75212c);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new v(this));
        a.a(this.f75213d).throttleFirst(1, timeUnit).subscribe(new w(this));
        a.a(rVar.b(R.id.dialog_ll_content_open)).throttleFirst(1, timeUnit).subscribe(new x(this, b11));
        a.a(rVar.b(R.id.dialog_btn)).throttleFirst(1, timeUnit).subscribe(new u(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.n_contract_cross_leading));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(getString(R.string.n_contract_cross_description));
        ((TextView) rVar.b(R.id.dialog_tv_content_cross)).setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getString(R.string.n_contract_isolate_leading));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append(getString(R.string.n_contract_isolate_description));
        ((TextView) rVar.b(R.id.dialog_tv_content_isolated)).setText(spannableStringBuilder2);
    }

    public boolean isTransparent() {
        return false;
    }
}
