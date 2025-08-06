package com.huobi.otc.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.SmallCoinReLockPriceBean;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.u;
import dp.v;
import dp.w;
import dp.x;
import i6.m;
import i6.r;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import va.b;

public class OtcSmallCoinDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public SmallCoinReLockPriceBean f78317b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f78318c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f78319d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78320e;

    /* renamed from: f  reason: collision with root package name */
    public a f78321f = null;

    /* renamed from: g  reason: collision with root package name */
    public Subscription f78322g;

    public interface a {
        void a(String str, int i11);
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
        SmallCoinReLockPriceBean smallCoinReLockPriceBean;
        dismiss();
        a aVar = this.f78321f;
        if (!(aVar == null || (smallCoinReLockPriceBean = this.f78317b) == null)) {
            aVar.a(smallCoinReLockPriceBean.getToken(), this.f78317b.getSmallCoinId());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(String str, Long l11) {
        if (getDialog() != null && getDialog().isShowing()) {
            this.f78320e.setText(String.format(str, new Object[]{l11 + ""}));
            if (l11.longValue() <= 0) {
                dismiss();
            }
        }
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.close_txt).setOnClickListener(new v(this));
        rVar.b(R$id.buy_rl).setOnClickListener(new u(this));
    }

    public void afterInit() {
        SmallCoinReLockPriceBean smallCoinReLockPriceBean = this.f78317b;
        if (smallCoinReLockPriceBean != null) {
            String m11 = b.m(smallCoinReLockPriceBean.getCurrencyId());
            this.f78318c.setText(String.format("%s %s", new Object[]{m11, OtcModuleConfig.a().v(this.f78317b.getPrice(), m.U(this.f78317b.getPrice()))}));
            String g11 = b.g(this.f78317b.getSmallCoinId());
            this.f78319d.setText(String.format("%s %s", new Object[]{this.f78317b.getQuantity(), g11}));
            long expireTime = this.f78317b.getExpireTime();
            if (expireTime > 0) {
                Subscription subscription = this.f78322g;
                if (subscription != null) {
                    subscription.unsubscribe();
                    this.f78322g = null;
                }
                this.f78322g = wh((int) expireTime, 0).subscribe(new w(this, getString(R$string.otc_lite_order_detail_samll_coin_countdown)));
            }
        }
    }

    public int getContentViewResId() {
        return R$layout.otc_small_coin_dialog;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f78318c = (TextView) rVar.b(R$id.newest_price_tv);
        this.f78319d = (TextView) rVar.b(R$id.buy_quantity_tv);
        this.f78320e = (TextView) rVar.b(R$id.confirm_tv);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Subscription subscription = this.f78322g;
        if (subscription != null && subscription.isUnsubscribed()) {
            this.f78322g.unsubscribe();
            this.f78322g = null;
        }
    }

    public final Observable<Long> wh(int i11, int i12) {
        return Observable.interval(0, 1, TimeUnit.SECONDS).take(i11 + 1).map(new x(i11, i12)).observeOn(AndroidSchedulers.mainThread());
    }
}
