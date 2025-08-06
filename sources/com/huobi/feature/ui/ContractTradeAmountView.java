package com.huobi.feature.ui;

import a7.e;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.feature.ui.dialog.ContractTradeAmountUnitDialogFragment;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pk.f;
import pro.huobi.R;

public class ContractTradeAmountView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TradeType f44687b;

    /* renamed from: c  reason: collision with root package name */
    public a f44688c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f44689d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f44690e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44691f;

    public interface a {
        String o0();
    }

    public ContractTradeAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(Void voidR) {
        ContractTradeAmountUnitDialogFragment contractTradeAmountUnitDialogFragment = new ContractTradeAmountUnitDialogFragment();
        contractTradeAmountUnitDialogFragment.Ah(this.f44687b, this.f44688c.o0(), this.f44691f);
        Activity b11 = oa.a.g().b();
        if (b11 instanceof FragmentActivity) {
            contractTradeAmountUnitDialogFragment.show(((FragmentActivity) b11).getSupportFragmentManager(), "amount_unit");
        }
    }

    public final void b(Context context) {
        setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        LayoutInflater.from(context).inflate(R.layout.contract_trade_amount_view, this);
        this.f44689d = (TextView) findViewById(R.id.contract_trade_amount_view_tv);
        this.f44690e = (EditText) findViewById(R.id.contract_trade_amount_view_et);
        dw.a.a(findViewById(R.id.contract_trade_amount_view_right)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new f(this));
    }

    public void c(TradeType tradeType, a aVar) {
        this.f44687b = tradeType;
        this.f44688c = aVar;
    }

    public EditText getEditText() {
        return this.f44690e;
    }

    public void setData(boolean z11) {
        this.f44691f = z11;
        boolean E = e.E(this.f44687b);
        boolean G = e.G(this.f44687b);
        if (this.f44687b == TradeType.LINEAR_SWAP) {
            if (G) {
                this.f44689d.setText("usdt".toUpperCase(Locale.US));
            } else {
                this.f44689d.setText(this.f44688c.o0());
            }
        } else if (E) {
            this.f44689d.setText(this.f44688c.o0());
        } else {
            this.f44689d.setText(getResources().getString(R.string.contract_market_vol_sheet));
        }
    }

    public ContractTradeAmountView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
