package com.hbg.module.exchange.grid.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.i;
import i6.r;
import java.util.Map;
import vc.b;

public class GridConfirmStrategyFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public String f19464b;

    /* renamed from: c  reason: collision with root package name */
    public String f19465c;

    /* renamed from: d  reason: collision with root package name */
    public String f19466d;

    /* renamed from: e  reason: collision with root package name */
    public String f19467e;

    /* renamed from: f  reason: collision with root package name */
    public String f19468f;

    /* renamed from: g  reason: collision with root package name */
    public String f19469g;

    /* renamed from: h  reason: collision with root package name */
    public String f19470h;

    /* renamed from: i  reason: collision with root package name */
    public String f19471i;

    /* renamed from: j  reason: collision with root package name */
    public String f19472j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19473k;

    /* renamed from: l  reason: collision with root package name */
    public a f19474l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f19475m = false;

    /* renamed from: n  reason: collision with root package name */
    public final Runnable f19476n = new cd.a(this);

    public interface a {
        void onConfirm();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh() {
        th(2);
    }

    public void Ah(a aVar) {
        this.f19474l = aVar;
    }

    public void Bh(String str) {
        this.f19465c = str;
    }

    public void Ch(String str) {
        this.f19468f = str;
    }

    public void Dh(String str) {
        this.f19470h = str;
    }

    public void Eh(String str) {
        this.f19469g = str;
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.tv_close).setOnClickListener(this);
        rVar.b(R$id.btn_confirm).setOnClickListener(this);
        i.b().g(this.f19476n, 600000);
    }

    public void afterInit() {
        setCanDismissOnBackPress(false);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        b.a().l("5919", "1005373", (Map<String, Object>) null);
    }

    public void bc(String str) {
        this.f19464b = str;
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_grid_confirm_strategy;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        a1 v11 = a1.v();
        String W = v11.W(this.f19464b);
        String p11 = v11.p(this.f19464b);
        String F = v11.F(this.f19464b);
        rVar.e(R$id.tv_title).setText(getString(R$string.n_grid_strategy_creat_strategy, W));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R$string.n_grid_strategy_second_confirmation_tip, W, p11));
        if (!this.f19473k) {
            sb2.append("\n");
            sb2.append(getString(R$string.n_grid_strategy_second_confirmation_tip_ai));
        }
        rVar.e(R$id.tv_tips).setText(sb2.toString());
        rVar.e(R$id.tv_price_range_key).setText(getString(R$string.n_grid_trade_price_range_with_quote, F));
        rVar.e(R$id.tv_price_range_value).setText(this.f19465c);
        rVar.e(R$id.tv_grid_number_value).setText(this.f19466d);
        rVar.e(R$id.tv_grid_pending_order_mode_value).setText(this.f19467e);
        rVar.e(R$id.tv_profit_rate_per_grid_value).setText(this.f19468f);
        if (TextUtils.isEmpty(this.f19469g)) {
            rVar.b(R$id.line_take_profit_price).setVisibility(8);
            rVar.b(R$id.container_take_profit_price).setVisibility(8);
        } else {
            rVar.b(R$id.line_take_profit_price).setVisibility(0);
            rVar.b(R$id.container_take_profit_price).setVisibility(0);
            rVar.e(R$id.tv_take_profit_price_key).setText(getString(R$string.n_grid_trade_take_profit_with_quote, F));
            rVar.e(R$id.tv_take_profit_price_value).setText(this.f19469g);
        }
        if (TextUtils.isEmpty(this.f19470h)) {
            rVar.b(R$id.line_stop_loss_price).setVisibility(8);
            rVar.b(R$id.container_stop_loss_price).setVisibility(8);
        } else {
            rVar.b(R$id.line_stop_loss_price).setVisibility(0);
            rVar.b(R$id.container_stop_loss_price).setVisibility(0);
            rVar.e(R$id.tv_stop_loss_price_key).setText(getString(R$string.n_grid_trade_stop_loss_with_quote, F));
            rVar.e(R$id.tv_stop_loss_price_value).setText(this.f19470h);
        }
        TextView e11 = rVar.e(R$id.id_total_title_quote);
        int i11 = R$string.n_grid_strategy_investment;
        e11.setText(getString(i11, F));
        rVar.e(R$id.id_total_title_base).setText(getString(i11, p11));
        if (TextUtils.isEmpty(this.f19471i)) {
            rVar.b(R$id.line_investment1).setVisibility(8);
            rVar.b(R$id.container_investment1).setVisibility(8);
        } else {
            rVar.b(R$id.line_investment1).setVisibility(0);
            rVar.b(R$id.container_investment1).setVisibility(0);
            rVar.e(R$id.tv_amount_value1).setText(this.f19471i);
        }
        if (TextUtils.isEmpty(this.f19472j)) {
            rVar.b(R$id.line_investment2).setVisibility(8);
            rVar.b(R$id.container_investment2).setVisibility(8);
            return;
        }
        rVar.b(R$id.line_investment2).setVisibility(0);
        rVar.b(R$id.container_investment2).setVisibility(0);
        rVar.e(R$id.tv_amount_value2).setText(this.f19472j);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.tv_close) {
            th(0);
            b.a().d("5920", (Map<String, Object>) null, "1005373");
        } else if (id2 == R$id.btn_confirm) {
            th(1);
            b.a().d("5921", (Map<String, Object>) null, "1005373");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        this.f19475m = false;
    }

    public final void th(int i11) {
        a aVar;
        i.b().h(this.f19476n);
        if (!this.f19475m) {
            this.f19475m = true;
            if (i11 == 1 && (aVar = this.f19474l) != null) {
                aVar.onConfirm();
            } else if (i11 == 2) {
                HuobiToastUtil.m(BaseApplication.b().getString(R$string.n_grid_trade_create_failed));
            }
            doDismiss();
        }
    }

    public void vh(String str) {
        this.f19472j = str;
    }

    public void wh(String str) {
        this.f19471i = str;
    }

    public void xh(String str) {
        this.f19466d = str;
    }

    public void yh(String str) {
        this.f19467e = str;
    }

    public void zh(boolean z11) {
        this.f19473k = z11;
    }
}
