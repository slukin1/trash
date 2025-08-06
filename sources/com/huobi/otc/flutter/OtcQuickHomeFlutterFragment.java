package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.StatusBarUtils;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import jp.b1;
import jp.c1;
import jp.q0;
import lp.e;
import op.a;
import pro.huobi.R;
import uf.d;
import up.g;
import up.h;

public class OtcQuickHomeFlutterFragment extends AbsGlobalFlutterFragment implements d, a.C0880a, q0.b {

    /* renamed from: k  reason: collision with root package name */
    public static String f78558k = "otc_quick_channel";

    /* renamed from: i  reason: collision with root package name */
    public c f78559i;

    /* renamed from: j  reason: collision with root package name */
    public MethodChannel f78560j;

    public class a implements MethodChannel.Result {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f78561a;

        /* renamed from: com.huobi.otc.flutter.OtcQuickHomeFlutterFragment$a$a  reason: collision with other inner class name */
        public class C0837a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Button f78563b;

            public C0837a(Button button) {
                this.f78563b = button;
            }

            public void run() {
                a.this.f78561a.a(this.f78563b);
            }
        }

        public a(d.a aVar) {
            this.f78561a = aVar;
        }

        public void error(String str, String str2, Object obj) {
        }

        public void notImplemented() {
        }

        public void success(Object obj) {
            Button button = (Button) OtcQuickHomeFlutterFragment.this.getActivity().findViewById(R.id.side_switch);
            if (obj instanceof Map) {
                Map map = (Map) obj;
                int[] iArr = {0, 0};
                OtcQuickHomeFlutterFragment.this.getActivity().findViewById(FlutterFragment.FLUTTER_VIEW_ID).getLocationInWindow(iArr);
                button.setText((String) map.get("title"));
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = PixelUtils.a(((Double) map.get("width")).floatValue());
                layoutParams.height = PixelUtils.a(((Double) map.get("height")).floatValue());
                button.setLayoutParams(layoutParams);
                button.setX((float) (PixelUtils.a(((Double) map.get("originX")).floatValue()) + iArr[0]));
                button.setY((float) ((((Double) map.get("originY")).intValue() + iArr[1]) - StatusBarUtils.a(OtcQuickHomeFlutterFragment.this.getContext())));
                button.setVisibility(0);
                button.requestLayout();
            }
            new Handler().postDelayed(new C0837a(button), 200);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f78565a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.otc.enums.OtcTradeAreaEnum[] r0 = com.huobi.otc.enums.OtcTradeAreaEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f78565a = r0
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.FAST_AREA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f78565a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.FREE_AREA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f78565a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.DEPOSIT_AREA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f78565a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.P2P_TRAD_AREA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f78565a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.ORDER_AREA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f78565a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.otc.enums.OtcTradeAreaEnum r1 = com.huobi.otc.enums.OtcTradeAreaEnum.AD_AREA     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcQuickHomeFlutterFragment.b.<clinit>():void");
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f78566a;

        /* renamed from: b  reason: collision with root package name */
        public String f78567b;

        /* renamed from: c  reason: collision with root package name */
        public String f78568c;

        public c() {
        }

        public /* synthetic */ c(OtcQuickHomeFlutterFragment otcQuickHomeFlutterFragment, a aVar) {
            this();
        }
    }

    public String Bh() {
        return "otc_quick_home";
    }

    public void D5(OtcTradeAreaEnum otcTradeAreaEnum) {
    }

    public void O9() {
    }

    public String Pg() {
        c cVar = this.f78559i;
        return cVar == null ? "" : cVar.f78567b;
    }

    public void Th(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("quickModel")) {
            HashMap hashMap = new HashMap();
            hashMap.put("isSell", Boolean.valueOf(this.f78559i.f78566a));
            hashMap.put("currencyName", this.f78559i.f78568c);
            hashMap.put("coinName", this.f78559i.f78567b);
            result.success(GsonHelper.a().toJson((Object) hashMap));
        } else if (methodCall.method.equals("setQuickModel")) {
            if (!(methodCall.arguments instanceof Map)) {
                result.notImplemented();
                return;
            }
            c cVar = new c(this, (a) null);
            cVar.f78566a = ((Boolean) methodCall.argument("isSell")).booleanValue();
            cVar.f78567b = (String) methodCall.argument("coinName");
            cVar.f78568c = (String) methodCall.argument("currencyName");
            this.f78559i = cVar;
            result.success((Object) null);
        } else if (methodCall.method.equals("toQuickQuoteList")) {
            if (!(methodCall.arguments instanceof Map)) {
                result.notImplemented();
                return;
            }
            Context context = getContext();
            if (context != null) {
                Intent intent = new Intent(context, OtcQuickTradeQuoteActivity.class);
                intent.putExtra("quoteParam", GsonHelper.a().toJson(methodCall.arguments));
                context.startActivity(intent);
            }
        } else if (methodCall.method.equals("toChooseCryptoCoin")) {
            Uh(4);
        } else if (methodCall.method.equals("toChooseLegalTender")) {
            Uh(3);
        } else if (methodCall.method.equals("showGuide")) {
            h.o((OtcTradeActivity) getActivity());
        } else {
            result.notImplemented();
        }
    }

    public void Ua(OtcTradeAreaEnum otcTradeAreaEnum) {
        String str;
        int i11 = b.f78565a[otcTradeAreaEnum.ordinal()];
        if (i11 != 1) {
            str = i11 != 2 ? i11 != 3 ? null : "deposit" : !b1.h().j() ? "c2c_trade" : "c2c_optional";
        } else {
            str = "fast";
        }
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("area", str);
            this.f78560j.invokeMethod("tradeAreaChange", hashMap);
        }
    }

    public final void Uh(int i11) {
        if (getActivity() != null && (getActivity() instanceof OtcTradeActivity)) {
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) getActivity();
            otcTradeActivity.xi(i11, otcTradeActivity.Rh(), !b1.h().j() ? 1 : 0, String.valueOf(va.b.e(Pg())), 1);
        }
    }

    public void bb(d.a aVar) {
        this.f78560j.invokeMethod("getTradeSwitchTarget", (Object) null, new a(aVar));
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), f78558k);
        this.f78560j = methodChannel;
        methodChannel.setMethodCallHandler(new g0(this));
    }

    public void j4(int i11, String str, boolean z11) {
        this.f78559i.f78568c = str;
        HashMap hashMap = new HashMap();
        hashMap.put("currencyName", str);
        v8(hashMap);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        op.a.r(0).B(this);
        c cVar = new c(this, (a) null);
        this.f78559i = cVar;
        cVar.f78568c = g.c("otc_select_trade_currency_quote_asset");
        this.f78559i.f78567b = OTCStatusExtendResponse.ExtendBean.KYC_STATUS_OF_T2_FAIL;
        c1 h11 = c1.h();
        TradeBusinessEnum tradeBusinessEnum = TradeBusinessEnum.ALL;
        if (h11.f(tradeBusinessEnum) == null || CollectionsUtils.b(c1.h().f(tradeBusinessEnum).getVirtualAsset())) {
            this.f78559i.f78567b = "USDT";
        } else {
            if (!(getActivity() == null || getActivity().getIntent() == null)) {
                String stringExtra = getActivity().getIntent().getStringExtra("tradeCurrency");
                if (c1.h().a(tradeBusinessEnum, stringExtra)) {
                    this.f78559i.f78567b = stringExtra.toUpperCase();
                }
            }
            if (this.f78559i.f78567b.equals(OTCStatusExtendResponse.ExtendBean.KYC_STATUS_OF_T2_FAIL)) {
                this.f78559i.f78567b = c1.h().f(tradeBusinessEnum).getVirtualAsset().get(0).getName();
            }
        }
        this.f78559i.f78566a = false;
        if (getActivity() instanceof e) {
            ((e) getActivity()).m5().a(this);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        op.a.r(0).P(this);
    }

    public void pc(HashMap<String, Object> hashMap) {
        this.f78560j.invokeMethod("onCryptoCoinPressed", hashMap);
    }

    public void rb(OtcTradeAreaEnum otcTradeAreaEnum) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sc(com.huobi.otc.enums.OtcTradeAreaEnum r3) {
        /*
            r2 = this;
            int[] r0 = com.huobi.otc.flutter.OtcQuickHomeFlutterFragment.b.f78565a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 4
            if (r3 == r0) goto L_0x0018
            r0 = 5
            if (r3 == r0) goto L_0x0015
            r0 = 6
            if (r3 == r0) goto L_0x0012
            goto L_0x0025
        L_0x0012:
            java.lang.String r3 = "c2c_advert"
            goto L_0x0026
        L_0x0015:
            java.lang.String r3 = "c2c_order"
            goto L_0x0026
        L_0x0018:
            jp.b1 r3 = jp.b1.h()
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x0025
            java.lang.String r3 = "c2c_optional"
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == 0) goto L_0x0039
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "area"
            r0.put(r1, r3)
            io.flutter.plugin.common.MethodChannel r3 = r2.f78560j
            java.lang.String r1 = "tradeAreaChange"
            r3.invokeMethod(r1, r0)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcQuickHomeFlutterFragment.sc(com.huobi.otc.enums.OtcTradeAreaEnum):void");
    }

    public void v8(HashMap<String, Object> hashMap) {
        this.f78560j.invokeMethod("onLegalTenderPressed", hashMap);
    }

    public boolean w2() {
        return !this.f78559i.f78566a;
    }
}
