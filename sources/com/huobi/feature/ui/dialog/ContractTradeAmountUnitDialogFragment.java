package com.huobi.feature.ui.dialog;

import a7.e;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.contract.ContractModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;

public class ContractTradeAmountUnitDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f45031b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f45032c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f45033d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45034e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45035f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45036g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f45037h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f45038i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f45039j;

    /* renamed from: k  reason: collision with root package name */
    public TradeType f45040k;

    /* renamed from: l  reason: collision with root package name */
    public String f45041l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f45042m;

    public class a extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45043b;

        public a(int i11) {
            this.f45043b = i11;
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            e.M(this.f45043b, ContractTradeAmountUnitDialogFragment.this.f45040k);
            EventBus.d().k(new mk.a(ContractTradeAmountUnitDialogFragment.this.f45040k, this.f45043b));
            ContractTradeAmountUnitDialogFragment.this.dismiss();
        }
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
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.f45037h.getVisibility() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.f45040k == TradeType.LINEAR_SWAP) {
            yh(1);
        } else {
            yh(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (this.f45038i.getVisibility() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.f45040k == TradeType.LINEAR_SWAP) {
            yh(2);
        } else {
            yh(1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.f45039j.getVisibility() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        yh(3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah(TradeType tradeType, String str, boolean z11) {
        this.f45040k = tradeType;
        this.f45041l = str;
        this.f45042m = z11;
    }

    public final void Bh() {
        boolean E = e.E(this.f45040k);
        boolean H = e.H(this.f45040k);
        if (this.f45040k == TradeType.LINEAR_SWAP) {
            if (E) {
                this.f45031b.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
                this.f45032c.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45033d.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45037h.setVisibility(0);
                this.f45038i.setVisibility(8);
                this.f45039j.setVisibility(8);
            } else if (!this.f45042m || !H) {
                this.f45031b.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45032c.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
                this.f45033d.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45037h.setVisibility(8);
                this.f45038i.setVisibility(0);
                this.f45039j.setVisibility(8);
            } else {
                this.f45031b.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45032c.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
                this.f45033d.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
                this.f45037h.setVisibility(8);
                this.f45038i.setVisibility(8);
                this.f45039j.setVisibility(0);
            }
        } else if (!E) {
            this.f45031b.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
            this.f45032c.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45033d.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45037h.setVisibility(0);
            this.f45038i.setVisibility(8);
            this.f45039j.setVisibility(8);
        } else if (!this.f45042m || !H) {
            this.f45031b.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45032c.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
            this.f45033d.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45037h.setVisibility(8);
            this.f45038i.setVisibility(0);
            this.f45039j.setVisibility(8);
        } else {
            this.f45031b.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45032c.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45033d.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
            this.f45037h.setVisibility(8);
            this.f45038i.setVisibility(8);
            this.f45039j.setVisibility(0);
        }
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.dialog_contract_bg).setOnClickListener(new c(this));
        rVar.b(R.id.dialog_cancel_iv).setOnClickListener(new e(this));
        this.f45031b.setOnClickListener(new d(this));
        this.f45032c.setOnClickListener(new b(this));
        this.f45033d.setOnClickListener(new f(this));
    }

    public void afterInit() {
        if (this.f45040k == TradeType.LINEAR_SWAP) {
            this.f45034e.setText(AppUtil.b(getResources().getString(R.string.n_contract_trade_input_amount), " ", this.f45041l));
            TextView textView = this.f45035f;
            Locale locale = Locale.US;
            textView.setText(AppUtil.b(getResources().getString(R.string.n_contract_unit_amount), " ", "usdt".toUpperCase(locale)));
            this.f45036g.setText(AppUtil.b(getResources().getString(R.string.n_contract_unit_principal), " ", "usdt".toUpperCase(locale)));
        } else {
            this.f45034e.setText(AppUtil.b(getResources().getString(R.string.n_contract_trade_input_amount), " ", getResources().getString(R.string.contract_market_vol_sheet)));
            this.f45035f.setText(AppUtil.b(getResources().getString(R.string.n_contract_unit_amount), " ", this.f45041l));
            this.f45036g.setText(AppUtil.b(getResources().getString(R.string.n_contract_unit_principal), " ", this.f45041l));
        }
        Bh();
    }

    public void dismiss() {
        zh();
        super.dismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_trade_amount_unit;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f45031b = (ViewGroup) rVar.b(R.id.amount_unit_coin_container);
        this.f45034e = (TextView) rVar.b(R.id.amount_unit_coin_tv);
        this.f45037h = (ImageView) rVar.b(R.id.amount_unit_coin_iv);
        this.f45032c = (ViewGroup) rVar.b(R.id.amount_unit_u_container);
        this.f45035f = (TextView) rVar.b(R.id.amount_unit_u_tv);
        this.f45038i = (ImageView) rVar.b(R.id.amount_unit_u_iv);
        this.f45033d = (ViewGroup) rVar.b(R.id.amount_unit_u_principal_container);
        this.f45036g = (TextView) rVar.b(R.id.amount_unit_u_principal_tv);
        this.f45039j = (ImageView) rVar.b(R.id.amount_unit_u_principal_iv);
        if (!this.f45042m) {
            this.f45033d.setVisibility(8);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setSoftInputMode(16);
        return onCreateDialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public final void yh(int i11) {
        if (ContractModuleConfig.a().a()) {
            e.L(i11, this.f45040k).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new a(i11));
            return;
        }
        e.M(i11, this.f45040k);
        EventBus.d().k(new mk.a(this.f45040k, i11));
        dismiss();
    }

    public final void zh() {
        View findFocus;
        if (getView() != null && (findFocus = getView().findFocus()) != null) {
            SoftInputUtils.g(getActivity(), findFocus);
        }
    }
}
