package com.huobi.otc.flutter;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.coupon.bean.Coupon;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.bean.Ads;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import up.w;

public class OtcMerchantProfileActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78508k;

    /* renamed from: l  reason: collision with root package name */
    public long f78509l = 0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f78510m = false;

    public class a implements w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f78511a;

        public a(Ads ads) {
            this.f78511a = ads;
        }

        public void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list) {
            OtcModuleConfig.b().T(OtcMerchantProfileActivity.this, this.f78511a, false, (String) null, (String) null);
        }

        public void b() {
            boolean unused = OtcMerchantProfileActivity.this.f78510m = true;
        }
    }

    public final void Ei(Ads ads) {
        ads.getTradeType();
        w.n(this, ads, this, Boolean.FALSE, new a(ads), (String) null);
    }

    public void Fi() {
        Fragment m02 = getSupportFragmentManager().m0("OtcStrictSelectionFragment");
        if (m02 != null) {
            getSupportFragmentManager().q().s(m02).k();
        }
        findViewById(R.id.ad_quick_edit_container).setVisibility(8);
    }

    public void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1386732499:
                    if (str.equals("getCurrentUId")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -786306802:
                    if (str.equals("showStrictDialog")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -556320519:
                    if (str.equals("getMerchantId")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 453670092:
                    if (str.equals("openTagManagerPage")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1437708888:
                    if (str.equals("tradeAdvert")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            if (c11 == 0) {
                result.success(String.valueOf(this.f78509l));
            } else if (c11 == 1) {
                result.success(OtcModuleConfig.a().getUid());
            } else if (c11 != 2) {
                if (c11 == 3) {
                    OtcModuleConfig.b().G(this);
                } else if (c11 != 4) {
                    result.notImplemented();
                } else {
                    ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                    FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.ad_quick_edit_container);
                    if (frameLayout == null) {
                        frameLayout = new FrameLayout(this);
                        frameLayout.setId(R.id.ad_quick_edit_container);
                        viewGroup.addView(frameLayout);
                    }
                    OtcModuleConfig.b().A(this, R.id.ad_quick_edit_container, "OtcStrictSelectionFragment");
                    frameLayout.setVisibility(0);
                }
            } else if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l(this, (Intent) null, (Intent) null);
                result.success(Boolean.FALSE);
            } else {
                Object obj = methodCall.arguments;
                if (obj instanceof Map) {
                    Ads ads = (Ads) new Gson().fromJson(JSON.toJSONString(obj), Ads.class);
                    if (ads != null) {
                        if (ads.hasEnablePay()) {
                            Ei(ads);
                        } else {
                            HuobiToastUtil.g(R.string.otc_order_detail_pay_method_not_support);
                        }
                        result.success(Boolean.TRUE);
                        return;
                    }
                }
                result.success((Object) null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_merchant_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_merchant_channel");
        this.f78508k = methodChannel;
        methodChannel.setMethodCallHandler(new y(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f78509l = intent.getLongExtra("merchant_id", 0);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f78510m) {
            this.f78510m = false;
            OtcModuleConfig.a().e("");
        }
    }
}
