package com.huobi.otc.flutter;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.coupon.bean.Coupon;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.ui.OtcTradeActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import u6.g;
import up.w;

public class OtcMineFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78513i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f78514j = false;

    public class a implements w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f78515a;

        public a(Ads ads) {
            this.f78515a = ads;
        }

        public void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list) {
            OtcModuleConfig.b().T(OtcMineFragment.this.getActivity(), this.f78515a, false, (String) null, (String) null);
        }

        public void b() {
            boolean unused = OtcMineFragment.this.f78514j = true;
        }
    }

    public String Bh() {
        return "otc_merchant_page";
    }

    public final void Uh(Ads ads) {
        w.n(getActivity(), ads, (g) null, Boolean.FALSE, new a(ads), (String) null);
    }

    public void Vh(MethodCall methodCall, MethodChannel.Result result) {
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
                result.success(OtcModuleConfig.a().getUid());
            } else if (c11 == 1) {
                result.success(OtcModuleConfig.a().getUid());
            } else if (c11 != 2) {
                if (c11 == 3) {
                    OtcModuleConfig.b().G(this.f67730h);
                } else if (c11 != 4) {
                    result.notImplemented();
                } else {
                    FragmentActivity fragmentActivity = this.f67730h;
                    if (fragmentActivity instanceof OtcTradeActivity) {
                        ((OtcTradeActivity) fragmentActivity).zi();
                    }
                }
            } else if (!OtcModuleConfig.a().a()) {
                OtcModuleConfig.a().l(getActivity(), (Intent) null, (Intent) null);
                result.success(Boolean.FALSE);
            } else {
                Object obj = methodCall.arguments;
                if (obj instanceof Map) {
                    Ads ads = (Ads) new Gson().fromJson(JSON.toJSONString(obj), Ads.class);
                    if (ads != null) {
                        if (ads.hasEnablePay()) {
                            Uh(ads);
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

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_merchant_channel");
        this.f78513i = methodChannel;
        methodChannel.setMethodCallHandler(new z(this));
    }

    public void onResume() {
        super.onResume();
        if (this.f78514j) {
            this.f78514j = false;
            OtcModuleConfig.a().e("");
        }
    }
}
