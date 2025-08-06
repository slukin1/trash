package com.huobi.otc.flutter;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.ui.OtcSeaViewRoomActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import i6.d;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class OtcP2pAdShareFragment extends AbsGlobalFlutterFragment {

    /* renamed from: q  reason: collision with root package name */
    public static final String f78530q = OtcP2pAdShareFragment.class.getSimpleName();

    /* renamed from: r  reason: collision with root package name */
    public static final Map<String, Map<String, Object>> f78531r = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78532i;

    /* renamed from: j  reason: collision with root package name */
    public String f78533j;

    /* renamed from: k  reason: collision with root package name */
    public int f78534k;

    /* renamed from: l  reason: collision with root package name */
    public String f78535l;

    /* renamed from: m  reason: collision with root package name */
    public String f78536m;

    /* renamed from: n  reason: collision with root package name */
    public String f78537n;

    /* renamed from: o  reason: collision with root package name */
    public Context f78538o;

    /* renamed from: p  reason: collision with root package name */
    public o f78539p = new b(true);

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcP2pAdShareFragment.this.Wh(methodCall, result);
        }
    }

    public class b extends o {
        public b(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            d.c(OtcP2pAdShareFragment.f78530q, " OnBackPressedDispatcher handleOnBackPressed");
            OtcP2pAdShareFragment.this.Vh();
        }
    }

    public static OtcP2pAdShareFragment Uh(String str, int i11, String str2, String str3, String str4) {
        OtcP2pAdShareFragment otcP2pAdShareFragment = new OtcP2pAdShareFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.texture.name());
        bundle.putString("param_type_ad_id", str);
        bundle.putInt("param_is_trade_with_buy", i11);
        bundle.putString("param_price", str2);
        bundle.putString("param_quote_asset_name", str3);
        bundle.putString("param_crypto_asset_name", str4);
        otcP2pAdShareFragment.setArguments(bundle);
        return otcP2pAdShareFragment;
    }

    public String Bh() {
        return "otc_advert_share_dialog";
    }

    public final void Vh() {
        Context context = this.f78538o;
        if (context instanceof OtcTradeActivity) {
            ((OtcTradeActivity) context).Yh();
        } else if (context instanceof OtcSeaViewRoomActivity) {
            ((OtcSeaViewRoomActivity) context).Pg();
        }
    }

    public void Wh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1671672458) {
                if (hashCode == 2145698996) {
                    if (str.equals("callbackAdvertShareInfo")) {
                        c11 = 0;
                    }
                }
            } else if (str.equals("dismiss")) {
                c11 = 1;
            }
            if (c11 == 0) {
                HashMap hashMap = (HashMap) new Gson().fromJson((String) methodCall.arguments, HashMap.class);
                f78531r.put(hashMap.get("advertId").toString(), hashMap);
                result.success((Object) null);
            } else if (c11 != 1) {
                result.notImplemented();
            } else {
                Vh();
                result.success((Object) null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public final void Xh() {
        Map<String, Map<String, Object>> map = f78531r;
        if (map.get(this.f78533j) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("advertId", this.f78533j);
            hashMap.put("isTradeWithBuy", Integer.valueOf(this.f78534k));
            hashMap.put(FirebaseAnalytics.Param.PRICE, this.f78535l);
            hashMap.put("quoteAssetName", this.f78536m);
            hashMap.put("cryptoAssetName", this.f78537n);
            this.f78532i.invokeMethod("showAdvertShareDialog", hashMap);
            return;
        }
        this.f78532i.invokeMethod("showAdvertShareDialog", map.get(this.f78533j));
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_advert_share_channel");
        this.f78532i = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f78538o = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f78533j = arguments.getString("param_type_ad_id", "");
            this.f78534k = arguments.getInt("param_is_trade_with_buy", 0);
            this.f78535l = arguments.getString(this.f78535l, "");
            this.f78536m = arguments.getString("param_quote_asset_name", "");
            this.f78537n = arguments.getString("param_crypto_asset_name", "");
        }
        getActivity().getOnBackPressedDispatcher().h(this.f78539p);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f78539p.remove();
        this.f78539p.setEnabled(false);
        this.f78539p = null;
    }

    public void onResume() {
        super.onResume();
        Xh();
    }
}
