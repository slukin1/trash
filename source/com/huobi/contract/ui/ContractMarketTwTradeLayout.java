package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.view.UnderLineTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.z;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;

public class ContractMarketTwTradeLayout extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f43298b;

    /* renamed from: c  reason: collision with root package name */
    public UnderLineTextView f43299c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f43300d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43301e;

    /* renamed from: f  reason: collision with root package name */
    public b f43302f;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (z11 != qk.a.b().d()) {
                qk.a.b().g(z11);
                if (ContractMarketTwTradeLayout.this.f43302f != null) {
                    ContractMarketTwTradeLayout.this.f43302f.a(z11);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public interface b {
        void a(boolean z11);
    }

    public ContractMarketTwTradeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Void voidR) {
        if (this.f43301e) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            String string = getContext().getString(R.string.n_contract_market_tw_order_explain);
            new DialogUtils.b.d(fragmentActivity).C0(String.format(string, new Object[]{this.f43298b + "U"})).P0(getContext().getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public final void c() {
        this.f43299c = (UnderLineTextView) findViewById(R.id.contract_market_twtrade_tips);
        CheckBox checkBox = (CheckBox) findViewById(R.id.contract_market_twtrade_switch_iv);
        this.f43300d = checkBox;
        checkBox.setOnCheckedChangeListener(new a());
        dw.a.a((UnderLineTextView) findViewById(R.id.contract_market_twtrade_tips)).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new z(this));
    }

    public final void d() {
        RelativeLayout.inflate(getContext(), R.layout.layout_market_tw_trade, this);
    }

    public boolean e() {
        return this.f43300d.isChecked();
    }

    public void setCallBack(b bVar) {
        this.f43302f = bVar;
    }

    public void setChecked(boolean z11) {
        this.f43300d.setChecked(z11);
    }

    public void setDash(boolean z11) {
        this.f43301e = z11;
        this.f43299c.setDash(z11);
    }

    public void setMarketTwTradeAmountLimit(int i11) {
        this.f43298b = i11;
    }

    public ContractMarketTwTradeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43301e = true;
        d();
        c();
    }
}
