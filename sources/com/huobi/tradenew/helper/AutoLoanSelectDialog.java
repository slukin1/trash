package com.huobi.tradenew.helper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.utils.j0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import ks.g;
import pro.huobi.R;
import qt.b;
import qt.c;
import qt.d;

public class AutoLoanSelectDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f82854b;

    /* renamed from: c  reason: collision with root package name */
    public SafeLottieView f82855c;

    /* renamed from: d  reason: collision with root package name */
    public View f82856d;

    /* renamed from: e  reason: collision with root package name */
    public View f82857e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82858f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82860h;

    /* renamed from: i  reason: collision with root package name */
    public a f82861i;

    /* renamed from: j  reason: collision with root package name */
    public int f82862j = 1;

    public interface a {
        void a(int i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        g.q(this.f82862j);
        g.p(true);
        a aVar = this.f82861i;
        if (aVar != null) {
            aVar.a(this.f82862j);
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (!this.f82854b.isSelected()) {
            this.f82854b.playAnimation();
            this.f82854b.setSelected(true);
            this.f82855c.cancelAnimation();
            this.f82855c.setProgress(0.0f);
            this.f82855c.setSelected(false);
            this.f82862j = 1;
            this.f82858f.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f82859g.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (!this.f82855c.isSelected()) {
            this.f82855c.playAnimation();
            this.f82855c.setSelected(true);
            this.f82854b.cancelAnimation();
            this.f82854b.setProgress(0.0f);
            this.f82854b.setSelected(false);
            this.f82862j = 2;
            this.f82858f.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText));
            this.f82859g.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        SafeLottieView safeLottieView = this.f82854b;
        if (safeLottieView != null) {
            ViewGroup.LayoutParams layoutParams = safeLottieView.getLayoutParams();
            layoutParams.height = (this.f82854b.getWidth() * 380) / 280;
            this.f82854b.setLayoutParams(layoutParams);
        }
        SafeLottieView safeLottieView2 = this.f82855c;
        if (safeLottieView2 != null) {
            ViewGroup.LayoutParams layoutParams2 = safeLottieView2.getLayoutParams();
            layoutParams2.height = (this.f82855c.getWidth() * 380) / 280;
            this.f82855c.setLayoutParams(layoutParams2);
        }
        SafeLottieView safeLottieView3 = this.f82854b;
        if (safeLottieView3 != null) {
            safeLottieView3.playAnimation();
            this.f82854b.setSelected(true);
        }
    }

    public void addEvent(r rVar) {
        this.f82860h.setOnClickListener(new c(this));
        this.f82854b.setOnClickListener(new qt.a(this));
        this.f82855c.setOnClickListener(new b(this));
    }

    public void afterInit() {
        setCanDismissOnBackPress(false);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void dismiss() {
        super.dismiss();
        SafeLottieView safeLottieView = this.f82854b;
        if (safeLottieView != null) {
            safeLottieView.cancelAnimation();
        }
        SafeLottieView safeLottieView2 = this.f82855c;
        if (safeLottieView2 != null) {
            safeLottieView2.cancelAnimation();
        }
    }

    public int getContentViewResId() {
        return R.layout.dialog_auto_loan_select;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f82854b = (SafeLottieView) rVar.b(R.id.left_anim);
        this.f82855c = (SafeLottieView) rVar.b(R.id.right_anim);
        this.f82856d = rVar.b(R.id.left_container);
        this.f82857e = rVar.b(R.id.right_container);
        this.f82858f = (TextView) rVar.b(R.id.auto_loan_tv);
        this.f82859g = (TextView) rVar.b(R.id.manual_loan_tv);
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            this.f82854b.setAnimation(j0.k());
            this.f82855c.setAnimation(j0.m());
        } else {
            this.f82854b.setAnimation(j0.l());
            this.f82855c.setAnimation(j0.n());
        }
        this.f82860h = (TextView) rVar.b(R.id.confirm_btn);
        this.f82854b.post(new d(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public void wh(a aVar) {
        this.f82861i = aVar;
    }
}
