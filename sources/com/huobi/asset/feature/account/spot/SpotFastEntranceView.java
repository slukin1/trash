package com.huobi.asset.feature.account.spot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import oh.j;
import oh.l;
import q6.d;
import u6.g;

public class SpotFastEntranceView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f42293b;

    /* renamed from: c  reason: collision with root package name */
    public View f42294c;

    /* renamed from: d  reason: collision with root package name */
    public View f42295d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            String W = BaseModuleConfig.a().W();
            if (!SpotFastEntranceView.this.h()) {
                k.d("SpotFastEntranceView", "onClick: isSupportCurrLang = false");
                W = BaseModuleConfig.a().u();
            }
            String str = W + "one-click-exchange/exchange?refresh=2";
            k.d("SpotFastEntranceView", "onClick: pathUrl = " + str);
            BaseModuleConfig.a().k0(str);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42297e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, View view) {
            super(gVar);
            this.f42297e = view;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.j(R$string.ht_exchange_please_wait);
            } else {
                AssetModuleConfig.a().B0(this.f42297e.getContext());
            }
        }

        public void onError2(Throwable th2) {
            AssetModuleConfig.a().B0(this.f42297e.getContext());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetModuleConfig.a().B0(this.f42297e.getContext());
        }
    }

    public class c extends d<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f42299e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar, View view) {
            super(gVar);
            this.f42299e = view;
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                HuobiToastUtil.j(R$string.ht_exchange_please_wait);
            } else {
                AssetModuleConfig.a().e1(this.f42299e.getContext());
            }
        }

        public void onError2(Throwable th2) {
            AssetModuleConfig.a().e1(this.f42299e.getContext());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetModuleConfig.a().e1(this.f42299e.getContext());
        }
    }

    public SpotFastEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        AssetModuleConfig.a().L0("3560", (Map<String, Object>) null);
        BaseModuleConfig.a().w("app_assets_Exchange_for_HT_click", (HashMap) null);
        e(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(View view) {
        DialogUtils.X((FragmentActivity) view.getContext(), getResources().getString(R$string.n_usdt_exchange_entrance_tips_title), getResources().getString(R$string.n_usdt_exchange_entrance_tips), (String) null, getResources().getString(R$string.n_otc_optional_process_know), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void e(View view) {
        v7.b.a().getHtExchangeSubmitStatus().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) view.getContext())).subscribe(new b((g) view.getContext(), view));
    }

    @SensorsDataInstrumented
    public final void f(View view) {
        v7.b.a().getUsdtExchangeSubmitStatus().b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) view.getContext())).subscribe(new c((g) view.getContext(), view));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void g(Context context) {
        View.inflate(context, R$layout.layout_spot_fast_entrance, this);
        View findViewById = findViewById(R$id.exchange_ht_entrance);
        this.f42293b = findViewById;
        findViewById.setOnClickListener(new j(this));
        View findViewById2 = findViewById(R$id.exchange_usdt_entrance);
        this.f42294c = findViewById2;
        findViewById2.setOnClickListener(new oh.k(this));
        findViewById(R$id.iv_question).setOnClickListener(new l(this));
        View findViewById3 = findViewById(R$id.exchange_entrance);
        this.f42295d = findViewById3;
        findViewById3.setOnClickListener(new a());
    }

    public final boolean h() {
        Locale a11 = m6.a.a();
        return Locale.ENGLISH.equals(a11) || AppLanguageHelper.TRADITIONAL_CHINESE_LOCALE.equals(a11) || Locale.SIMPLIFIED_CHINESE.equals(a11);
    }

    public void setTag(int i11) {
        k.n("setTag: tag = " + i11);
        if (i11 == 3) {
            ViewUtil.m(this.f42295d, true);
            ViewUtil.m(this.f42294c, false);
        }
    }

    public void setUserClear(boolean z11) {
        ViewUtil.m(this.f42294c, z11);
        ViewUtil.m(this.f42293b, !z11);
    }

    public SpotFastEntranceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        g(context);
    }
}
