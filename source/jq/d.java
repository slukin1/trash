package jq;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class d extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public TextView f84399b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f84400c;

    /* renamed from: d  reason: collision with root package name */
    public Button f84401d;

    /* renamed from: e  reason: collision with root package name */
    public Button f84402e;

    /* renamed from: f  reason: collision with root package name */
    public Subscription f84403f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f84404g;

    public class a implements Observer<Long> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Long l11) {
            if (l11.longValue() == 0) {
                d.this.dismiss();
            }
            d.this.f84401d.setText(d.this.getContext().getString(R.string.points_buy_confirm_dialog_cancel_text, new Object[]{String.valueOf(l11)}));
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }
    }

    public d(Context context) {
        this(context, R.style.OrderDialog);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        View.OnClickListener onClickListener = this.f84404g;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void dismiss() {
        Subscription subscription = this.f84403f;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.dismiss();
    }

    public final void e() {
        this.f84401d.setOnClickListener(new b(this));
        this.f84402e.setOnClickListener(new a(this));
    }

    public final void f() {
        this.f84399b = (TextView) findViewById(R.id.amount_value_tv);
        this.f84400c = (TextView) findViewById(R.id.pay_value_tv);
        this.f84401d = (Button) findViewById(R.id.dialog_cancel_btn);
        this.f84402e = (Button) findViewById(R.id.dialog_confirm_btn);
    }

    public void j(String str) {
        this.f84399b.setText(str);
    }

    public void k(View.OnClickListener onClickListener) {
        this.f84404g = onClickListener;
    }

    public void l(String str, String str2) {
        TextView textView = this.f84400c;
        StringBuilder sb2 = new StringBuilder();
        TradeType tradeType = TradeType.PRO;
        Locale locale = Locale.US;
        sb2.append(m.m(str, PrecisionUtil.a(tradeType, str2.toLowerCase(locale))));
        sb2.append(str2.toUpperCase(locale));
        textView.setText(sb2.toString());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_points_buy_confirm_dialog);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        f();
        e();
    }

    public void show() {
        super.show();
        this.f84403f = Observable.interval(0, 1, TimeUnit.SECONDS).map(new c(180)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public d(Context context, int i11) {
        super(context, i11);
    }
}
