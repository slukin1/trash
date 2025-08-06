package com.hbg.module.contract.util;

import a7.e;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.contract.R$style;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.CommonHorizontalSelectorView;
import com.hbg.lib.widgets.ProgressButton;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import uc.c;
import uc.d;
import uc.f;

public class FutureUnitDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public CommonHorizontalSelectorView f18978b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18979c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f18980d;

    /* renamed from: e  reason: collision with root package name */
    public int f18981e;

    /* renamed from: f  reason: collision with root package name */
    public int f18982f;

    /* renamed from: g  reason: collision with root package name */
    public String f18983g;

    /* renamed from: h  reason: collision with root package name */
    public String f18984h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressButton f18985i;

    /* renamed from: j  reason: collision with root package name */
    public b f18986j;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            FutureUnitDialogFragment.this.Ch();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            FutureUnitDialogFragment.this.Ah();
        }

        public void onStart() {
            super.onStart();
            FutureUnitDialogFragment.this.Bh();
        }
    }

    public interface b {
        void m(int i11, boolean z11);

        boolean n();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (this.f18981e != this.f18982f) {
            b bVar = this.f18986j;
            if (bVar == null || !bVar.n()) {
                Ah();
            } else {
                e.L(this.f18982f, this.f18980d).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a());
            }
        } else {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh(int i11, String str) {
        if (i11 == 0) {
            this.f18982f = 0;
        } else {
            this.f18982f = 1;
        }
    }

    public final void Ah() {
        e.M(this.f18982f, this.f18980d);
        b bVar = this.f18986j;
        if (bVar != null) {
            int i11 = this.f18982f;
            boolean z11 = true;
            if (i11 != 1) {
                z11 = false;
            }
            bVar.m(i11, z11);
        }
        dismiss();
    }

    public final void Bh() {
        this.f18985i.c();
    }

    public final void Ch() {
        this.f18985i.a();
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.id_future_unit_dialog_parent).setOnClickListener(new d(this));
        rVar.b(R$id.id_future_unit_dialog_close_btn).setOnClickListener(new uc.e(this));
        this.f18978b.setCallback(new f(this));
        this.f18985i.setOnClickListener(new c(this));
    }

    public void afterInit() {
        this.f18978b.setStringList(getResources().getString(R$string.contract_market_vol_sheet), this.f18983g);
        boolean E = e.E(this.f18980d);
        this.f18981e = E ? 1 : 0;
        this.f18978b.c(E, false);
        this.f18979c.setText(this.f18984h);
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.layout_future_unit_dialog;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f18978b = (CommonHorizontalSelectorView) rVar.b(R$id.id_future_unit_dialog_indicator);
        this.f18985i = (ProgressButton) rVar.b(R$id.id_future_unit_dialog_confirm_btn);
        this.f18979c = (TextView) rVar.b(R$id.id_future_unit_dialog_exchange_tv);
    }

    public boolean isTransparent() {
        return false;
    }
}
