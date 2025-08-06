package com.huobi.homemarket.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.k;
import i6.m;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import org.json.JSONObject;
import ul.b1;

public class MarketSquareFlutterFragment extends FlutterFragment {

    /* renamed from: b  reason: collision with root package name */
    public FlutterEngine f72969b;

    /* renamed from: c  reason: collision with root package name */
    public MethodChannel f72970c;

    /* renamed from: d  reason: collision with root package name */
    public Context f72971d;

    /* renamed from: e  reason: collision with root package name */
    public FragmentActivity f72972e;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            MarketSquareFlutterFragment.this.th(methodCall, result);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "platform_message_channel");
        this.f72970c = methodChannel;
        methodChannel.setMethodCallHandler(new a());
        new MethodChannel(flutterEngine.getDartExecutor(), "market_square_channel").setMethodCallHandler(new b1(this));
    }

    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    public void onAttach(Context context) {
        this.f72972e = getActivity();
        this.f72971d = context;
        Context attachBaseContext = AppLanguageHelper.getInstance().attachBaseContext(context);
        this.f72971d = attachBaseContext;
        super.onAttach(attachBaseContext);
        if (BaseModuleConfig.a() != null) {
            BaseModuleConfig.a().o0("huobiapp_market_discover_end");
        }
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        Log.i("flutter", "provideFlutterEngine");
        String O = BaseModuleConfig.a().O(sh(), 0);
        Log.i("flutter", "provideFlutterEngine no cache");
        FlutterEngine flutterEngine = new FlutterEngine(this.f72971d);
        this.f72969b = flutterEngine;
        flutterEngine.getNavigationChannel().setInitialRoute(O);
        this.f72969b.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(O, this.f72969b);
        return this.f72969b;
    }

    public final String qh(MethodCall methodCall) {
        BigDecimal bigDecimal;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = (String) methodCall.argument("strVolume");
            int intValue = ((Integer) methodCall.argument("precision")).intValue();
            BigDecimal H = LegalCurrencyConfigUtil.H((String) methodCall.argument("baseCurrency"));
            String w11 = LegalCurrencyConfigUtil.w();
            String v11 = LegalCurrencyConfigUtil.v();
            if (TextUtils.isEmpty(v11)) {
                bigDecimal = BigDecimal.ONE;
            } else {
                bigDecimal = new BigDecimal(v11);
            }
            BigDecimal multiply = m.a(str2).multiply(H).multiply(bigDecimal);
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                str = w11 + m.g(multiply.toPlainString());
            } else {
                str = w11 + m.X(multiply.toPlainString());
            }
            jSONObject.put("originalStr", str2);
            jSONObject.put("unit", w11);
            jSONObject.put("rate", v11);
            jSONObject.put("unitStr", str);
            jSONObject.put("noUnitStr", m.s(multiply, intValue, false, multiply.toPlainString()));
            jSONObject.put("quotePrice", H.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void rh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("symbol")) {
                result.success(Integer.valueOf(PrecisionUtil.A((String) methodCall.argument("symbol"))));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public String sh() {
        return "market_square";
    }

    public final void uh(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        String str2 = (String) methodCall.argument("tag");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            result.success((Object) null);
            return;
        }
        k.o(str2, str);
        result.success((Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r15.error("-1", r14.method + " show fail", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0235 */
    /* renamed from: vh */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void th(io.flutter.plugin.common.MethodCall r14, io.flutter.plugin.common.MethodChannel.Result r15) {
        /*
            r13 = this;
            java.lang.String r0 = "hotCoinRadar"
            java.lang.String r1 = "clearTop"
            java.lang.String r2 = "huobiapp_market_discover_end"
            java.lang.String r3 = "jumpUrl"
            java.lang.String r4 = "flutter"
            java.lang.String r5 = r14.method
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0015
            r15.notImplemented()
        L_0x0015:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r5.<init>()     // Catch:{ all -> 0x024c }
            java.lang.String r6 = "onPlatformMessageChannelMethodCall method - "
            r5.append(r6)     // Catch:{ all -> 0x024c }
            java.lang.String r6 = r14.method     // Catch:{ all -> 0x024c }
            r5.append(r6)     // Catch:{ all -> 0x024c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x024c }
            i6.d.j(r4, r5)     // Catch:{ all -> 0x024c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r5.<init>()     // Catch:{ all -> 0x024c }
            java.lang.String r6 = "onPlatformMessageChannelMethodCall arguments - "
            r5.append(r6)     // Catch:{ all -> 0x024c }
            java.lang.Object r6 = r14.arguments     // Catch:{ all -> 0x024c }
            r5.append(r6)     // Catch:{ all -> 0x024c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x024c }
            i6.d.j(r4, r5)     // Catch:{ all -> 0x024c }
            java.lang.String r4 = r14.method     // Catch:{ all -> 0x024c }
            java.lang.String r5 = "jumpNativePage"
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x024c }
            r6 = 0
            java.lang.String r7 = ""
            if (r5 == 0) goto L_0x007e
            java.lang.String r5 = "201"
            java.lang.String r8 = "target"
            java.lang.Object r8 = r14.argument(r8)     // Catch:{ all -> 0x024c }
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x024c }
            if (r5 == 0) goto L_0x007e
            boolean r5 = r14.hasArgument(r3)     // Catch:{ all -> 0x024c }
            if (r5 == 0) goto L_0x007e
            java.lang.Object r14 = r14.argument(r3)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x024c }
            java.lang.String r0 = "jumpNative://"
            java.lang.String r14 = r14.replace(r0, r7)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r14.trim()     // Catch:{ all -> 0x024c }
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x024c }
            r0.k0(r14)     // Catch:{ all -> 0x024c }
            r15.success(r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x007e:
            java.lang.String r3 = "getOriginTradePricePrecision"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x024c }
            if (r3 == 0) goto L_0x008b
            r13.rh(r14, r15)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x008b:
            java.lang.String r3 = "localLog"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x024c }
            if (r3 == 0) goto L_0x0098
            r13.uh(r14, r15)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x0098:
            java.lang.String r3 = "getUnitVolume"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x024c }
            if (r3 == 0) goto L_0x00a9
            java.lang.String r14 = r13.qh(r14)     // Catch:{ all -> 0x024c }
            r15.success(r14)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x00a9:
            java.lang.String r3 = "MarketSquareHomeDataDidLoad"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x024c }
            r5 = 1
            if (r3 == 0) goto L_0x00c0
            com.hbg.lib.core.BaseModuleConfig$a r14 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x024c }
            java.lang.String r0 = "network"
            r14.z(r2, r2, r0, r5)     // Catch:{ all -> 0x024c }
            r15.success(r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x00c0:
            java.lang.String r2 = "getCurrencyIconUrl"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x024c }
            if (r2 == 0) goto L_0x0103
            java.lang.String r0 = "currency"
            java.lang.Object r14 = r14.argument(r0)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x024c }
            com.hbg.lib.core.BaseModuleConfig$a r0 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x024c }
            java.lang.String r0 = r0.j()     // Catch:{ all -> 0x024c }
            java.lang.String r1 = "getAssetCurrencyIcon_PngType"
            i6.d.c(r1, r0)     // Catch:{ all -> 0x024c }
            if (r0 != 0) goto L_0x00e0
            goto L_0x00e1
        L_0x00e0:
            r7 = r0
        L_0x00e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r0.<init>()     // Catch:{ all -> 0x024c }
            r0.append(r7)     // Catch:{ all -> 0x024c }
            java.lang.String r1 = "/-/x/hb/p/api/contents/currency/icon_png/"
            r0.append(r1)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r14.toLowerCase()     // Catch:{ all -> 0x024c }
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = ".png"
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x024c }
            r15.success(r14)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x0103:
            java.lang.String r2 = "openWebView"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x024c }
            java.lang.String r3 = "-1"
            r8 = 0
            if (r2 == 0) goto L_0x0156
            java.lang.String r0 = "url"
            java.lang.Object r0 = r14.argument(r0)     // Catch:{ all -> 0x024c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x024c }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x024c }
            if (r2 != 0) goto L_0x013e
            boolean r2 = r14.hasArgument(r1)     // Catch:{ all -> 0x024c }
            if (r2 == 0) goto L_0x012c
            java.lang.Object r14 = r14.argument(r1)     // Catch:{ all -> 0x024c }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x024c }
            boolean r5 = r14.booleanValue()     // Catch:{ all -> 0x024c }
        L_0x012c:
            if (r5 == 0) goto L_0x0134
            androidx.fragment.app.FragmentActivity r14 = r13.f72972e     // Catch:{ all -> 0x024c }
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r14, r0, r7, r7, r8)     // Catch:{ all -> 0x024c }
            goto L_0x0139
        L_0x0134:
            androidx.fragment.app.FragmentActivity r14 = r13.f72972e     // Catch:{ all -> 0x024c }
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebViewNoClear(r14, r0, r7, r7, r8)     // Catch:{ all -> 0x024c }
        L_0x0139:
            r15.success(r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x013e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r0.<init>()     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r14.method     // Catch:{ all -> 0x024c }
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = "method url is null"
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x024c }
            r15.error(r3, r14, r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x0156:
            java.lang.String r1 = "showAlert"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x024c }
            if (r1 == 0) goto L_0x0192
            java.lang.String r0 = "title"
            java.lang.Object r0 = r14.argument(r0)     // Catch:{ all -> 0x024c }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x024c }
            java.lang.String r0 = "content"
            java.lang.Object r0 = r14.argument(r0)     // Catch:{ all -> 0x024c }
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x024c }
            java.lang.String r0 = "type"
            java.lang.Object r14 = r14.argument(r0)     // Catch:{ all -> 0x024c }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x024c }
            int r14 = r14.intValue()     // Catch:{ all -> 0x024c }
            if (r14 != 0) goto L_0x018d
            androidx.fragment.app.FragmentActivity r7 = r13.f72972e     // Catch:{ all -> 0x024c }
            java.lang.String r10 = ""
            int r14 = com.hbg.module.market.R$string.n_known     // Catch:{ all -> 0x024c }
            java.lang.String r11 = r13.getString(r14)     // Catch:{ all -> 0x024c }
            bj.o0 r12 = bj.o0.f12469a     // Catch:{ all -> 0x024c }
            com.hbg.lib.widgets.dialog.DialogUtils.X(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x024c }
        L_0x018d:
            r15.success(r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x0192:
            java.lang.String r1 = "showRadarGuide"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x024c }
            if (r1 == 0) goto L_0x0253
            java.lang.String r1 = "hot_coin_guide_showed"
            boolean r1 = com.hbg.lib.network.retrofit.util.SPUtil.g(r1, r8)     // Catch:{ all -> 0x0235 }
            if (r1 == 0) goto L_0x01a8
            java.lang.String r0 = "showed"
            r15.success(r0)     // Catch:{ all -> 0x0235 }
            return
        L_0x01a8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0235 }
            r1.<init>()     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = "isResumed= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            boolean r2 = r13.isResumed()     // Catch:{ all -> 0x0235 }
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = " isVisible= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            boolean r2 = r13.isVisible()     // Catch:{ all -> 0x0235 }
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0235 }
            i6.d.c(r0, r1)     // Catch:{ all -> 0x0235 }
            boolean r1 = r13.isVisible()     // Catch:{ all -> 0x0235 }
            if (r1 != 0) goto L_0x01d8
            java.lang.String r0 = "show state is backgroud, no show"
            r15.success(r0)     // Catch:{ all -> 0x0235 }
            return
        L_0x01d8:
            java.lang.String r1 = "top"
            java.lang.Object r1 = r14.argument(r1)     // Catch:{ all -> 0x0235 }
            r9 = r1
            java.lang.Double r9 = (java.lang.Double) r9     // Catch:{ all -> 0x0235 }
            java.lang.String r1 = "left"
            java.lang.Object r1 = r14.argument(r1)     // Catch:{ all -> 0x0235 }
            r10 = r1
            java.lang.Double r10 = (java.lang.Double) r10     // Catch:{ all -> 0x0235 }
            java.lang.String r1 = "popWidth"
            java.lang.Object r1 = r14.argument(r1)     // Catch:{ all -> 0x0235 }
            r11 = r1
            java.lang.Double r11 = (java.lang.Double) r11     // Catch:{ all -> 0x0235 }
            java.lang.String r1 = "popHeight"
            java.lang.Object r1 = r14.argument(r1)     // Catch:{ all -> 0x0235 }
            r12 = r1
            java.lang.Double r12 = (java.lang.Double) r12     // Catch:{ all -> 0x0235 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0235 }
            r1.<init>()     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = "top= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            r1.append(r9)     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = " left= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            r1.append(r10)     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = " popWidth= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            r1.append(r11)     // Catch:{ all -> 0x0235 }
            java.lang.String r2 = " popHeight= "
            r1.append(r2)     // Catch:{ all -> 0x0235 }
            r1.append(r12)     // Catch:{ all -> 0x0235 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0235 }
            i6.d.c(r0, r1)     // Catch:{ all -> 0x0235 }
            com.huobi.homemarket.ui.HotCoinGuideActivity$a r7 = com.huobi.homemarket.ui.HotCoinGuideActivity.f72917h     // Catch:{ all -> 0x0235 }
            androidx.fragment.app.FragmentActivity r8 = r13.f72972e     // Catch:{ all -> 0x0235 }
            r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0235 }
            java.lang.String r0 = "showing"
            r15.success(r0)     // Catch:{ all -> 0x0235 }
            goto L_0x0253
        L_0x0235:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x024c }
            r0.<init>()     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r14.method     // Catch:{ all -> 0x024c }
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = " show fail"
            r0.append(r14)     // Catch:{ all -> 0x024c }
            java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x024c }
            r15.error(r3, r14, r6)     // Catch:{ all -> 0x024c }
            goto L_0x0253
        L_0x024c:
            r14 = move-exception
            r14.printStackTrace()
            r15.notImplemented()
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.ui.MarketSquareFlutterFragment.th(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
