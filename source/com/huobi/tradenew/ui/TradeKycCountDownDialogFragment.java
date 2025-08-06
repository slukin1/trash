package com.huobi.tradenew.ui;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import u6.g;

public class TradeKycCountDownDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f83179b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83180c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83181d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f83182e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83183f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f83184g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f83185h;

    /* renamed from: i  reason: collision with root package name */
    public long f83186i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f83187j;

    /* renamed from: k  reason: collision with root package name */
    public Subscriber f83188k;

    /* renamed from: l  reason: collision with root package name */
    public String f83189l;

    /* renamed from: m  reason: collision with root package name */
    public String f83190m;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeKycCountDownDialogFragment.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeKycCountDownDialogFragment.this.dismiss();
            if (TradeKycCountDownDialogFragment.this.f83187j != null) {
                TradeKycCountDownDialogFragment.this.f83187j.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends BaseSubscriber<Long> {
        public c() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            long th2 = TradeKycCountDownDialogFragment.this.f83186i - (l11.longValue() * 1000);
            if (th2 > 0) {
                String[] z11 = DateTimeUtils.z(th2);
                if (z11.length >= 2) {
                    TradeKycCountDownDialogFragment.this.f83180c.setText(z11[0]);
                    TradeKycCountDownDialogFragment.this.f83181d.setText(z11[1]);
                    TradeKycCountDownDialogFragment.this.f83182e.setText(z11[2]);
                    return;
                }
                return;
            }
            TradeKycCountDownDialogFragment.this.dismiss();
        }
    }

    public void addEvent(r rVar) {
        this.f83184g.setOnClickListener(new a());
        this.f83185h.setOnClickListener(new b());
    }

    public void afterInit() {
        Subscriber subscriber = this.f83188k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f83188k = new c();
        Observable.interval(0, 1, TimeUnit.SECONDS).compose(RxJavaHelper.t((g) null)).subscribe(this.f83188k);
    }

    public void dismiss() {
        super.dismiss();
        Subscriber subscriber = this.f83188k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public int getContentViewResId() {
        return R.layout.dialog_trade_kyc_count_down;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f83179b = (TextView) rVar.b(R.id.dialog_title);
        this.f83180c = (TextView) rVar.b(R.id.dialog_hour_tv);
        this.f83181d = (TextView) rVar.b(R.id.dialog_minute_tv);
        this.f83182e = (TextView) rVar.b(R.id.dialog_second_tv);
        this.f83183f = (TextView) rVar.b(R.id.dialog_sub_title);
        this.f83184g = (TextView) rVar.b(R.id.dialog_cancel_btn);
        TextView textView = (TextView) rVar.b(R.id.dialog_confirm_btn);
        this.f83185h = textView;
        textView.setText(R.string.n_kyc_confirm);
        this.f83179b.setText(this.f83189l);
        this.f83183f.setText(this.f83190m);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onPause() {
        super.onPause();
        Subscriber subscriber = this.f83188k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void setTitle(String str) {
        this.f83189l = str;
    }

    public void xh(View.OnClickListener onClickListener) {
        this.f83187j = onClickListener;
    }

    public void yh(long j11) {
        this.f83186i = j11;
    }

    public void zh(String str) {
        this.f83190m = str;
    }
}
