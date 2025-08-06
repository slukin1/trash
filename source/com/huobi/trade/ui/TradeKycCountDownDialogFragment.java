package com.huobi.trade.ui;

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
    public TextView f82425b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82426c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82427d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f82428e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f82429f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82430g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82431h;

    /* renamed from: i  reason: collision with root package name */
    public long f82432i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f82433j;

    /* renamed from: k  reason: collision with root package name */
    public Subscriber f82434k;

    /* renamed from: l  reason: collision with root package name */
    public String f82435l;

    /* renamed from: m  reason: collision with root package name */
    public String f82436m;

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
            if (TradeKycCountDownDialogFragment.this.f82433j != null) {
                TradeKycCountDownDialogFragment.this.f82433j.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends BaseSubscriber<Long> {
        public c() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            long th2 = TradeKycCountDownDialogFragment.this.f82432i - (l11.longValue() * 1000);
            if (th2 > 0) {
                String[] z11 = DateTimeUtils.z(th2);
                if (z11.length >= 2) {
                    TradeKycCountDownDialogFragment.this.f82426c.setText(z11[0]);
                    TradeKycCountDownDialogFragment.this.f82427d.setText(z11[1]);
                    TradeKycCountDownDialogFragment.this.f82428e.setText(z11[2]);
                    return;
                }
                return;
            }
            TradeKycCountDownDialogFragment.this.dismiss();
        }
    }

    public void addEvent(r rVar) {
        this.f82430g.setOnClickListener(new a());
        this.f82431h.setOnClickListener(new b());
    }

    public void afterInit() {
        Subscriber subscriber = this.f82434k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f82434k = new c();
        Observable.interval(0, 1, TimeUnit.SECONDS).compose(RxJavaHelper.t((g) null)).subscribe(this.f82434k);
    }

    public void dismiss() {
        super.dismiss();
        Subscriber subscriber = this.f82434k;
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
        this.f82425b = (TextView) rVar.b(R.id.dialog_title);
        this.f82426c = (TextView) rVar.b(R.id.dialog_hour_tv);
        this.f82427d = (TextView) rVar.b(R.id.dialog_minute_tv);
        this.f82428e = (TextView) rVar.b(R.id.dialog_second_tv);
        this.f82429f = (TextView) rVar.b(R.id.dialog_sub_title);
        this.f82430g = (TextView) rVar.b(R.id.dialog_cancel_btn);
        TextView textView = (TextView) rVar.b(R.id.dialog_confirm_btn);
        this.f82431h = textView;
        textView.setText(R.string.n_kyc_confirm);
        this.f82425b.setText(this.f82435l);
        this.f82429f.setText(this.f82436m);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onPause() {
        super.onPause();
        Subscriber subscriber = this.f82434k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void setTitle(String str) {
        this.f82435l = str;
    }

    public void xh(View.OnClickListener onClickListener) {
        this.f82433j = onClickListener;
    }

    public void yh(long j11) {
        this.f82432i = j11;
    }

    public void zh(String str) {
        this.f82436m = str;
    }
}
