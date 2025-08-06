package com.huobi.contract.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.ContractHeartBeat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.presentation.screen.d;
import dj.b;
import dj.c;
import dj.e;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import u6.g;

public abstract class AbstractMaintenanceView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f43187b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f43188c;

    /* renamed from: d  reason: collision with root package name */
    public a f43189d;

    /* renamed from: e  reason: collision with root package name */
    public g f43190e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43191f;

    public interface a {
        void a();
    }

    public AbstractMaintenanceView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(View view) {
        r();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f43190e.showProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ContractHeartBeat contractHeartBeat) {
        this.f43190e.dismissProgressDialog();
        q(contractHeartBeat);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(APIStatusErrorException aPIStatusErrorException) {
        this.f43190e.dismissProgressDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(Throwable th2) {
        this.f43190e.dismissProgressDialog();
    }

    public static AbstractMaintenanceView o(Context context, int i11) {
        if (i11 == 6) {
            return new SwapMaintenanceView(context);
        }
        if (i11 == 10) {
            return new OptionMaintenanceView(context);
        }
        if (i11 != 11) {
            return new ContractMaintenanceView(context);
        }
        return new LinearSwapMaintenanceView(context);
    }

    public static AbstractMaintenanceView p(Context context, TradeType tradeType) {
        if (tradeType == TradeType.SWAP) {
            return new SwapMaintenanceView(context);
        }
        if (tradeType == TradeType.OPTION) {
            return new OptionMaintenanceView(context);
        }
        return new ContractMaintenanceView(context);
    }

    public void f(boolean z11) {
        int i11;
        Context context = getContext();
        if (z11) {
            i11 = R$color.trade_liquidating_bg_color;
        } else {
            i11 = R$color.baseColorContentBackground;
        }
        setBackgroundColor(ContextCompat.getColor(context, i11));
    }

    public abstract long g(ContractHeartBeat contractHeartBeat);

    public void h() {
        this.f43191f.setVisibility(8);
    }

    public boolean i(ContractHeartBeat contractHeartBeat) {
        return contractHeartBeat.isSysSafeguard();
    }

    public final void q(ContractHeartBeat contractHeartBeat) {
        a aVar;
        if (contractHeartBeat != null) {
            setCountDownTime(g(contractHeartBeat));
            if (!i(contractHeartBeat) && (aVar = this.f43189d) != null) {
                aVar.a();
            }
        }
    }

    public final void r() {
        AssetModuleConfig.a().X().timeout((long) d.N, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(this.f43190e)).onErrorResumeNext(Observable.just(null)).subscribe(EasySubscriber.create(new b(this), new dj.d(this), new c(this), new e(this)));
    }

    public void setCountDownTime(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        ViewUtil.m(this.f43187b, i11 != 0);
        if (i11 != 0) {
            String h11 = DateTimeUtils.h(j11, "yyyy/MM/dd HH:mm");
            this.f43187b.setText(String.format(getResources().getString(R$string.maintenance_count_down_time), new Object[]{h11}));
        }
    }

    public void setOnMaintenanceEndListener(a aVar) {
        this.f43189d = aVar;
    }

    public void setRetryText(int i11) {
        this.f43191f.setText(i11);
    }

    public void setTopMargin(int i11) {
        ImageView imageView = (ImageView) findViewById(R$id.iv_maintenance);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = PixelUtils.a((float) i11);
        imageView.setLayoutParams(layoutParams);
    }

    public void setTradeSafeguardHint(String str) {
        this.f43188c.setText(str);
    }

    public void setUI(g gVar) {
        this.f43190e = gVar;
    }

    public AbstractMaintenanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractMaintenanceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.maintenance_view, this);
        this.f43187b = (TextView) findViewById(R$id.tv_count_down);
        this.f43188c = (TextView) findViewById(R$id.trade_safeguard_tv);
        TextView textView = (TextView) findViewById(R$id.tv_retry);
        this.f43191f = textView;
        textView.setOnClickListener(new dj.a(this));
    }
}
