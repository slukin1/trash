package com.huobi.flutter.base;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import cl.c;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.Constants;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.coupon.bean.Coupon;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.permissions.PermissionConfig;
import el.i;
import i6.d;
import i6.k;
import i6.l;
import i6.m;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.subjects.BehaviorSubject;
import tg.r;
import u6.g;

public abstract class AbsGlobalFlutterFragment extends FlutterFragment implements g, EasyPermissions.PermissionCallbacks, MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public BehaviorSubject<Integer> f67724b = BehaviorSubject.create();

    /* renamed from: c  reason: collision with root package name */
    public boolean f67725c;

    /* renamed from: d  reason: collision with root package name */
    public FlutterEngine f67726d;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel.Result f67727e;

    /* renamed from: f  reason: collision with root package name */
    public MethodCall f67728f;

    /* renamed from: g  reason: collision with root package name */
    public Context f67729g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentActivity f67730h;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            AbsGlobalFlutterFragment.this.Lh(methodCall, result);
        }
    }

    public class b extends BaseSubscriber<Map<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67732b;

        public b(MethodChannel.Result result) {
            this.f67732b = result;
        }

        /* renamed from: a */
        public void onNext(Map<String, String> map) {
            super.onNext(map);
            this.f67732b.success(map);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f67732b.success((Object) null);
        }
    }

    private void Ah(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("num")) {
                result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.c((String) null)));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void Ch(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.z((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void Dh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.A((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void Eh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.y((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void Fh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("num")) {
                result.success(LegalCurrencyConfigUtil.L(m.a((String) methodCall.argument("num"))));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public static /* synthetic */ Map Gh(Integer num, UserVO userVO) {
        HashMap hashMap = new HashMap();
        hashMap.put("identityLevel", String.valueOf(userVO.getRealBind()));
        hashMap.put(UserDataStore.COUNTRY, String.valueOf(num));
        hashMap.put("registerTime", String.valueOf(userVO.getGmtRegister()));
        return hashMap;
    }

    public static /* synthetic */ void Hh(MethodCall methodCall, MethodChannel.Result result, Map map) {
        String G = LegalCurrencyConfigUtil.G((String) methodCall.argument("amount"), (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), TradeType.PRO);
        d.d("currencyEquivalent" + G);
        result.success(G);
    }

    private void Kh(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        String str2 = (String) methodCall.argument("tag");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            result.success((Object) null);
            return;
        }
        k.o(str2, str);
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Lh(io.flutter.plugin.common.MethodCall r24, io.flutter.plugin.common.MethodChannel.Result r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "commentId"
            java.lang.String r5 = "topicType"
            java.lang.String r6 = "dynamicId"
            java.lang.String r7 = "topicId"
            java.lang.String r8 = "jumpUrl"
            java.lang.String r9 = "param"
            java.lang.String r10 = "clearTop"
            java.lang.String r11 = "orderStatus"
            java.lang.String r12 = r2.method
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0021
            r25.notImplemented()
        L_0x0021:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "onPlatformMessageChannelMethodCall method - "
            r12.append(r13)
            java.lang.String r13 = r2.method
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = "flutter"
            i6.d.j(r13, r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "onPlatformMessageChannelMethodCall arguments - "
            r12.append(r14)
            java.lang.Object r14 = r2.arguments
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            i6.d.j(r13, r12)
            java.lang.String r12 = r2.method     // Catch:{ Exception -> 0x0a95 }
            int r14 = r12.hashCode()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r15 = "currencyEquivalent"
            switch(r14) {
                case -2129410265: goto L_0x036d;
                case -2056464738: goto L_0x0363;
                case -2028594808: goto L_0x0358;
                case -2005297104: goto L_0x034d;
                case -1913642710: goto L_0x0343;
                case -1869909171: goto L_0x0338;
                case -1869775525: goto L_0x032f;
                case -1867690178: goto L_0x0324;
                case -1810821955: goto L_0x0319;
                case -1642957613: goto L_0x030e;
                case -1628378977: goto L_0x0302;
                case -1617379345: goto L_0x02f6;
                case -1598537077: goto L_0x02ea;
                case -1561506719: goto L_0x02de;
                case -1263213045: goto L_0x02d2;
                case -1249348326: goto L_0x02c6;
                case -1235619314: goto L_0x02ba;
                case -1231576958: goto L_0x02ae;
                case -1211505886: goto L_0x02a2;
                case -1136021560: goto L_0x0296;
                case -1089884828: goto L_0x028a;
                case -810046467: goto L_0x027e;
                case -797116285: goto L_0x0272;
                case -697876248: goto L_0x0266;
                case -508568865: goto L_0x025a;
                case -505960894: goto L_0x024f;
                case -395052928: goto L_0x0244;
                case -282921467: goto L_0x0238;
                case -279936800: goto L_0x022c;
                case -246745736: goto L_0x0220;
                case -192955658: goto L_0x0214;
                case -79410336: goto L_0x0208;
                case -19659958: goto L_0x01fc;
                case 1779572: goto L_0x01f0;
                case 138822264: goto L_0x01e4;
                case 243522097: goto L_0x01d8;
                case 307534671: goto L_0x01cc;
                case 323730026: goto L_0x01c1;
                case 429875484: goto L_0x01b5;
                case 555472544: goto L_0x01aa;
                case 574566932: goto L_0x019e;
                case 580390365: goto L_0x0192;
                case 591662532: goto L_0x0186;
                case 804029191: goto L_0x017a;
                case 855137750: goto L_0x016e;
                case 860276249: goto L_0x0162;
                case 1026644591: goto L_0x0157;
                case 1048060840: goto L_0x014b;
                case 1069956078: goto L_0x013f;
                case 1081042534: goto L_0x0133;
                case 1100898435: goto L_0x0127;
                case 1125301051: goto L_0x011b;
                case 1282738188: goto L_0x010f;
                case 1292966058: goto L_0x0103;
                case 1408147659: goto L_0x00f7;
                case 1512022271: goto L_0x00eb;
                case 1595947385: goto L_0x00df;
                case 1603547744: goto L_0x00d3;
                case 1630368510: goto L_0x00c7;
                case 1696494512: goto L_0x00bb;
                case 1822557871: goto L_0x00af;
                case 1848374997: goto L_0x00a3;
                case 1900777433: goto L_0x0097;
                case 1930886910: goto L_0x008b;
                case 1955774368: goto L_0x007f;
                case 2067267770: goto L_0x0074;
                case 2092624351: goto L_0x0068;
                case 2104386445: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x0378
        L_0x005c:
            java.lang.String r14 = "getUserHitUnifiedCrossAccount"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 8
            goto L_0x0379
        L_0x0068:
            java.lang.String r14 = "isShowAppStoreReview"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 64
            goto L_0x0379
        L_0x0074:
            java.lang.String r14 = "showHUD"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 3
            goto L_0x0379
        L_0x007f:
            java.lang.String r14 = "handleFiatPrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 40
            goto L_0x0379
        L_0x008b:
            java.lang.String r14 = "reportData"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 9
            goto L_0x0379
        L_0x0097:
            java.lang.String r14 = "localLog"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 12
            goto L_0x0379
        L_0x00a3:
            java.lang.String r14 = "getBaseCurrencyDisplayName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 17
            goto L_0x0379
        L_0x00af:
            java.lang.String r14 = "getCurrencyIconUrl"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 56
            goto L_0x0379
        L_0x00bb:
            java.lang.String r14 = "getAuthStatus"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 23
            goto L_0x0379
        L_0x00c7:
            java.lang.String r14 = "showDatePickerView"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 57
            goto L_0x0379
        L_0x00d3:
            java.lang.String r14 = "pushToAllOrdersPage"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 60
            goto L_0x0379
        L_0x00df:
            java.lang.String r14 = "getNetworkState"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 28
            goto L_0x0379
        L_0x00eb:
            java.lang.String r14 = "getSymbolDisplayName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 15
            goto L_0x0379
        L_0x00f7:
            java.lang.String r14 = "accessSecureKeySupport"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 63
            goto L_0x0379
        L_0x0103:
            java.lang.String r14 = "requestToken"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 11
            goto L_0x0379
        L_0x010f:
            java.lang.String r14 = "requestImage"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 58
            goto L_0x0379
        L_0x011b:
            java.lang.String r14 = "advancedVerify"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 25
            goto L_0x0379
        L_0x0127:
            java.lang.String r14 = "getTradePricePrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 32
            goto L_0x0379
        L_0x0133:
            java.lang.String r14 = "getCurrencyDisplayName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 14
            goto L_0x0379
        L_0x013f:
            java.lang.String r14 = "saveString"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 20
            goto L_0x0379
        L_0x014b:
            java.lang.String r14 = "openUniversalRoute"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 52
            goto L_0x0379
        L_0x0157:
            java.lang.String r14 = "openWebView"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 5
            goto L_0x0379
        L_0x0162:
            java.lang.String r14 = "getVToken"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 26
            goto L_0x0379
        L_0x016e:
            java.lang.String r14 = "showVerify"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 22
            goto L_0x0379
        L_0x017a:
            java.lang.String r14 = "getString"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 21
            goto L_0x0379
        L_0x0186:
            java.lang.String r14 = "getPointPrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 34
            goto L_0x0379
        L_0x0192:
            java.lang.String r14 = "getCurrencyBlackWhiteListInfo"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 47
            goto L_0x0379
        L_0x019e:
            java.lang.String r14 = "jumpNativePage"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 42
            goto L_0x0379
        L_0x01aa:
            java.lang.String r14 = "reportFlutterError"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 2
            goto L_0x0379
        L_0x01b5:
            java.lang.String r14 = "toTransPage"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 54
            goto L_0x0379
        L_0x01c1:
            java.lang.String r14 = "getUnionMarginMode"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 7
            goto L_0x0379
        L_0x01cc:
            java.lang.String r14 = "getCurrencyByDisplayName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 16
            goto L_0x0379
        L_0x01d8:
            java.lang.String r14 = "isCurrencyFiat"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 45
            goto L_0x0379
        L_0x01e4:
            java.lang.String r14 = "nativeRequest"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 55
            goto L_0x0379
        L_0x01f0:
            java.lang.String r14 = "openOutsideUrl"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 67
            goto L_0x0379
        L_0x01fc:
            java.lang.String r14 = "getCurrencyState"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 19
            goto L_0x0379
        L_0x0208:
            java.lang.String r14 = "toSpotExchange"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 29
            goto L_0x0379
        L_0x0214:
            java.lang.String r14 = "getQuoteCurrencyDisplayName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 18
            goto L_0x0379
        L_0x0220:
            java.lang.String r14 = "getTradeAmountPrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 31
            goto L_0x0379
        L_0x022c:
            java.lang.String r14 = "openHelpCenter"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 53
            goto L_0x0379
        L_0x0238:
            java.lang.String r14 = "getAssetsPrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 37
            goto L_0x0379
        L_0x0244:
            java.lang.String r14 = "popPage"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 4
            goto L_0x0379
        L_0x024f:
            java.lang.String r14 = "copyText"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 0
            goto L_0x0379
        L_0x025a:
            java.lang.String r14 = "getCurrencyWeight"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 46
            goto L_0x0379
        L_0x0266:
            java.lang.String r14 = "getTradeTotalPrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 36
            goto L_0x0379
        L_0x0272:
            java.lang.String r14 = "getVulcanMap"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 43
            goto L_0x0379
        L_0x027e:
            java.lang.String r14 = "getOriginTradePricePrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 33
            goto L_0x0379
        L_0x028a:
            java.lang.String r14 = "getNativeTranslation"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 51
            goto L_0x0379
        L_0x0296:
            java.lang.String r14 = "sensorsDataTrack"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 10
            goto L_0x0379
        L_0x02a2:
            java.lang.String r14 = "realNameVerify"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 24
            goto L_0x0379
        L_0x02ae:
            java.lang.String r14 = "goOtcTradeSetting"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 66
            goto L_0x0379
        L_0x02ba:
            java.lang.String r14 = "getFeePrecision"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 35
            goto L_0x0379
        L_0x02c6:
            java.lang.String r14 = "getUid"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 62
            goto L_0x0379
        L_0x02d2:
            java.lang.String r14 = "openKyc"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 49
            goto L_0x0379
        L_0x02de:
            java.lang.String r14 = "getCurrencyFullName"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 41
            goto L_0x0379
        L_0x02ea:
            java.lang.String r14 = "getPlatformConfig"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 48
            goto L_0x0379
        L_0x02f6:
            java.lang.String r14 = "otc_helper"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 59
            goto L_0x0379
        L_0x0302:
            java.lang.String r14 = "openSecurityCenter"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 61
            goto L_0x0379
        L_0x030e:
            java.lang.String r14 = "openSupportDoc"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 39
            goto L_0x0379
        L_0x0319:
            java.lang.String r14 = "ucTokenError"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 38
            goto L_0x0379
        L_0x0324:
            java.lang.String r14 = "toPoints"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 30
            goto L_0x0379
        L_0x032f:
            boolean r12 = r12.equals(r15)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 44
            goto L_0x0379
        L_0x0338:
            java.lang.String r14 = "doMainActBackPressed"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 50
            goto L_0x0379
        L_0x0343:
            java.lang.String r14 = "showToast"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 1
            goto L_0x0379
        L_0x034d:
            java.lang.String r14 = "aliyunLog"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 13
            goto L_0x0379
        L_0x0358:
            java.lang.String r14 = "getOldToken"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 27
            goto L_0x0379
        L_0x0363:
            java.lang.String r14 = "getLoginState"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 6
            goto L_0x0379
        L_0x036d:
            java.lang.String r14 = "requestAppStoreReview"
            boolean r12 = r12.equals(r14)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x0378
            r12 = 65
            goto L_0x0379
        L_0x0378:
            r12 = -1
        L_0x0379:
            java.lang.String r14 = "-1"
            java.lang.String r13 = "user_config"
            java.lang.String r16 = "1"
            java.lang.String r17 = "0"
            r18 = r14
            java.lang.String r14 = "key"
            r19 = r10
            java.lang.String r10 = "url"
            r20 = r13
            java.lang.String r13 = "currency"
            r21 = r6
            java.lang.String r6 = ""
            r22 = r4
            r4 = 0
            switch(r12) {
                case 0: goto L_0x0a7f;
                case 1: goto L_0x0a3b;
                case 2: goto L_0x0a33;
                case 3: goto L_0x0a0b;
                case 4: goto L_0x09fe;
                case 5: goto L_0x09ad;
                case 6: goto L_0x099c;
                case 7: goto L_0x098c;
                case 8: goto L_0x0978;
                case 9: goto L_0x0973;
                case 10: goto L_0x093e;
                case 11: goto L_0x0935;
                case 12: goto L_0x0930;
                case 13: goto L_0x092b;
                case 14: goto L_0x091a;
                case 15: goto L_0x0909;
                case 16: goto L_0x08f1;
                case 17: goto L_0x08e0;
                case 18: goto L_0x08cf;
                case 19: goto L_0x08b1;
                case 20: goto L_0x0898;
                case 21: goto L_0x0887;
                case 22: goto L_0x0872;
                case 23: goto L_0x0836;
                case 24: goto L_0x082d;
                case 25: goto L_0x0824;
                case 26: goto L_0x0805;
                case 27: goto L_0x07fb;
                case 28: goto L_0x07d4;
                case 29: goto L_0x07cf;
                case 30: goto L_0x07bd;
                case 31: goto L_0x07b8;
                case 32: goto L_0x07b3;
                case 33: goto L_0x07ae;
                case 34: goto L_0x07a9;
                case 35: goto L_0x07a4;
                case 36: goto L_0x079f;
                case 37: goto L_0x079a;
                case 38: goto L_0x0795;
                case 39: goto L_0x0790;
                case 40: goto L_0x078b;
                case 41: goto L_0x0773;
                case 42: goto L_0x066c;
                case 43: goto L_0x0648;
                case 44: goto L_0x05e4;
                case 45: goto L_0x05cd;
                case 46: goto L_0x05ac;
                case 47: goto L_0x0556;
                case 48: goto L_0x0543;
                case 49: goto L_0x053b;
                case 50: goto L_0x0527;
                case 51: goto L_0x0506;
                case 52: goto L_0x04d4;
                case 53: goto L_0x04c4;
                case 54: goto L_0x0497;
                case 55: goto L_0x0492;
                case 56: goto L_0x0483;
                case 57: goto L_0x047c;
                case 58: goto L_0x0475;
                case 59: goto L_0x0453;
                case 60: goto L_0x0433;
                case 61: goto L_0x0416;
                case 62: goto L_0x03f9;
                case 63: goto L_0x03e8;
                case 64: goto L_0x03c8;
                case 65: goto L_0x03bc;
                case 66: goto L_0x03b5;
                case 67: goto L_0x039c;
                default: goto L_0x0397;
            }
        L_0x0397:
            r25.notImplemented()     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x039c:
            java.lang.Object r2 = r2.argument(r10)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "android.intent.action.VIEW"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0a95 }
            r5.<init>(r6, r2)     // Catch:{ Exception -> 0x0a95 }
            r1.startActivity(r5)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x03b5:
            android.content.Context r2 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            com.huobi.otc.flutter.OtcTradeSettingFlutterActivity.Hi(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x03bc:
            androidx.fragment.app.FragmentActivity r2 = r23.requireActivity()     // Catch:{ Exception -> 0x0a95 }
            com.hbg.module.libkt.utils.l.c(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x03c8:
            ej.d r2 = ej.d.a()     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.network.hbg.core.util.MgtConfigNumber r4 = com.hbg.lib.network.hbg.core.util.MgtConfigNumber.REVIEW_SWAP     // Catch:{ Exception -> 0x0a95 }
            int r4 = r4.number     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.c(r4)     // Catch:{ Exception -> 0x0a95 }
            boolean r4 = com.hbg.lib.core.util.ChannelUtils.d()     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x03de
            if (r4 == 0) goto L_0x03de
            r13 = 1
            goto L_0x03df
        L_0x03de:
            r13 = 0
        L_0x03df:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r13)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x03e8:
            tg.h r2 = tg.h.c()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.i()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x03f9:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r2.J()     // Catch:{ Exception -> 0x0a95 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r4 != 0) goto L_0x040c
            int r13 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x040d
        L_0x040c:
            r13 = 0
        L_0x040d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0416:
            rn.c r2 = rn.c.i()     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r5 = r23.getActivity()     // Catch:{ Exception -> 0x0a95 }
            com.huobi.login.bean.JumpTarget r6 = new com.huobi.login.bean.JumpTarget     // Catch:{ Exception -> 0x0a95 }
            android.content.Intent r7 = new android.content.Intent     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r8 = r23.getActivity()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Class<com.huobi.account.ui.SecuritySetActivity> r9 = com.huobi.account.ui.SecuritySetActivity.class
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x0a95 }
            r6.<init>(r7, r4)     // Catch:{ Exception -> 0x0a95 }
            r2.d(r5, r6)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0433:
            java.lang.Object r2 = r2.argument(r11)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0a95 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0a95 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x0a95 }
            r5.<init>()     // Catch:{ Exception -> 0x0a95 }
            r5.putExtra(r11, r2)     // Catch:{ Exception -> 0x0a95 }
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r6 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            r2.U(r6, r5)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0453:
            uf.a r2 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.a()     // Catch:{ Exception -> 0x0a95 }
            if (r2 != 0) goto L_0x0469
            uf.a r2 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r5 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0a95 }
            r2.l(r5, r4, r4)     // Catch:{ Exception -> 0x0a95 }
            return
        L_0x0469:
            android.content.Context r2 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ Exception -> 0x0a95 }
            com.huobi.otc.ui.OtcFAQActivity.zh(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0475:
            android.content.Context r4 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            com.huobi.flutter.base.AbsGlobalFlutterActivity.xi(r4, r2, r3)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x047c:
            androidx.fragment.app.FragmentActivity r4 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            cl.d.d(r4, r2, r3)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0483:
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = al.p.l(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0492:
            com.huobi.flutter.FlutterNetworkUtil.d(r23, r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0497:
            java.lang.String r4 = "coinName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "from"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0a95 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "account"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            int r4 = va.b.e(r4)     // Catch:{ Exception -> 0x0a95 }
            uf.b r6 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r7 = r23.getActivity()     // Catch:{ Exception -> 0x0a95 }
            r6.S(r7, r4, r2, r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x04c4:
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            android.content.Intent r2 = sn.f.h(r2)     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r4 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            r4.startActivity(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r6)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x04d4:
            java.lang.Object r2 = r2.argument(r10)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r5 != 0) goto L_0x0501
            java.lang.String r5 = java.net.URLDecoder.decode(r2)     // Catch:{ Exception -> 0x04fc }
            java.lang.String r6 = "/account/kyc"
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x04fc }
            if (r5 == 0) goto L_0x04f4
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x04fc }
            r2.L()     // Catch:{ Exception -> 0x04fc }
            goto L_0x0501
        L_0x04f4:
            com.hbg.lib.core.BaseModuleConfig$a r5 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ Exception -> 0x04fc }
            r5.k0(r2)     // Catch:{ Exception -> 0x04fc }
            goto L_0x0501
        L_0x04fc:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ Exception -> 0x0a95 }
        L_0x0501:
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0506:
            java.lang.Object r2 = r2.argument(r14)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            android.content.res.Resources r4 = r23.getResources()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "string"
            androidx.fragment.app.FragmentActivity r6 = r23.getActivity()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0a95 }
            int r2 = r4.getIdentifier(r2, r5, r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0527:
            ra.d r2 = ra.c.c()     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r5 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.h(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 != 0) goto L_0x0536
            super.onBackPressed()     // Catch:{ Exception -> 0x0a95 }
        L_0x0536:
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x053b:
            r23.Mh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0543:
            java.lang.String r2 = r23.Bh()     // Catch:{ Exception -> 0x0a95 }
            r4 = 1103101952(0x41c00000, float:24.0)
            int r4 = com.hbg.lib.common.utils.PixelUtils.a(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = cl.c.a(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0556:
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            d7.k r5 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r5 = r5.s(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r5 != 0) goto L_0x056b
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x056b:
            boolean r4 = r5.isCountryDisabled()     // Catch:{ Exception -> 0x0a95 }
            if (r4 != 0) goto L_0x057e
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.g(r2)     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = x7.f.c(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x057c
            goto L_0x057e
        L_0x057c:
            r13 = 0
            goto L_0x057f
        L_0x057e:
            r13 = 1
        L_0x057f:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0a95 }
            r2.<init>()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = "countryDisabled"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r13)     // Catch:{ Exception -> 0x0a95 }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = "whiteEnabled"
            boolean r6 = r5.isWhiteEnabled()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0a95 }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = "isVisible"
            boolean r5 = r5.isVisible()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0a95 }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x05ac:
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.I(r2, r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0a95 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x05cd:
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r4.L(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x05e4:
            java.util.Map r4 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.T()     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x061c
            int r4 = r4.size()     // Catch:{ Exception -> 0x0a95 }
            if (r4 != 0) goto L_0x05f1
            goto L_0x061c
        L_0x05f1:
            java.lang.Object r4 = r2.argument(r13)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "amount"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.G(r2, r4, r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0a95 }
            r4.<init>()     // Catch:{ Exception -> 0x0a95 }
            r4.append(r15)     // Catch:{ Exception -> 0x0a95 }
            r4.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0a95 }
            i6.d.d(r4)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x061c:
            rx.Observable r4 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.e()     // Catch:{ Exception -> 0x0a95 }
            rx.Observable$Transformer r5 = com.hbg.lib.core.util.RxJavaHelper.t(r23)     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r4 = r4.compose(r5)     // Catch:{ Exception -> 0x0a95 }
            rx.Scheduler r5 = rx.android.schedulers.AndroidSchedulers.mainThread()     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r4 = r4.subscribeOn(r5)     // Catch:{ Exception -> 0x0a95 }
            dl.u r5 = new dl.u     // Catch:{ Exception -> 0x0a95 }
            r5.<init>(r2, r3)     // Catch:{ Exception -> 0x0a95 }
            dl.v r2 = new dl.v     // Catch:{ Exception -> 0x0a95 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0a95 }
            dl.w r6 = new dl.w     // Catch:{ Exception -> 0x0a95 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.core.network.rx.EasySubscriber r2 = com.hbg.lib.core.network.rx.EasySubscriber.create(r5, r2, r6)     // Catch:{ Exception -> 0x0a95 }
            r4.subscribe(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0648:
            java.lang.String r5 = "sceneCode"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r5 != 0) goto L_0x0667
            iu.a r4 = iu.a.f()     // Catch:{ Exception -> 0x0a95 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0a95 }
            java.util.Map r2 = r4.d(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0667:
            r3.success(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x066c:
            java.lang.String r10 = "target"
            java.lang.Object r10 = r2.argument(r10)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0a95 }
            com.huobi.index.bean.IndexFeatureItem r11 = new com.huobi.index.bean.IndexFeatureItem     // Catch:{ Exception -> 0x0a95 }
            r11.<init>()     // Catch:{ Exception -> 0x0a95 }
            r12 = 1
            r11.setNeedLogin(r12)     // Catch:{ Exception -> 0x0a95 }
            boolean r12 = r2.hasArgument(r9)     // Catch:{ Exception -> 0x0a95 }
            if (r12 == 0) goto L_0x068c
            java.lang.Object r9 = r2.argument(r9)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0a95 }
            r11.setJumpSymbol(r9)     // Catch:{ Exception -> 0x0a95 }
        L_0x068c:
            boolean r9 = r2.hasArgument(r8)     // Catch:{ Exception -> 0x0a95 }
            if (r9 == 0) goto L_0x0761
            java.lang.Object r2 = r2.argument(r8)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r8 = "jumpNative://"
            java.lang.String r2 = r2.replace(r8, r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "&"
            java.lang.String[] r6 = r2.split(r6)     // Catch:{ Exception -> 0x0a95 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x0a95 }
            r8.<init>()     // Catch:{ Exception -> 0x0a95 }
            int r9 = r6.length     // Catch:{ Exception -> 0x0a95 }
            r12 = 0
        L_0x06af:
            if (r12 >= r9) goto L_0x06c9
            r13 = r6[r12]     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r14 = "="
            java.lang.String[] r13 = r13.split(r14)     // Catch:{ Exception -> 0x0a95 }
            int r14 = r13.length     // Catch:{ Exception -> 0x0a95 }
            r15 = 1
            if (r14 <= r15) goto L_0x06c5
            r14 = 0
            r4 = r13[r14]     // Catch:{ Exception -> 0x0a95 }
            r13 = r13[r15]     // Catch:{ Exception -> 0x0a95 }
            r8.put(r4, r13)     // Catch:{ Exception -> 0x0a95 }
        L_0x06c5:
            int r12 = r12 + 1
            r4 = 0
            goto L_0x06af
        L_0x06c9:
            java.lang.String r4 = "1004"
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x070c
            java.lang.Object r2 = r8.get(r7)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x06e0
            java.lang.Object r2 = r8.get(r7)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setTopicId(r2)     // Catch:{ Exception -> 0x0a95 }
        L_0x06e0:
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x06ef
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setTopicType(r2)     // Catch:{ Exception -> 0x0a95 }
        L_0x06ef:
            r2 = r22
            java.lang.Object r4 = r8.get(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x0700
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setCommentId(r2)     // Catch:{ Exception -> 0x0a95 }
        L_0x0700:
            java.lang.String r2 = "app_community_xxzxdzlb"
            r4 = 0
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = "app_community_xxzxhflb"
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0761
        L_0x070c:
            java.lang.String r4 = "1008"
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x0726
            r2 = r21
            java.lang.Object r4 = r8.get(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x0761
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setDynamicId(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0761
        L_0x0726:
            java.lang.String r4 = "1007"
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "uidUnique"
            if (r4 == 0) goto L_0x0746
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x073f
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setUidUnique(r2)     // Catch:{ Exception -> 0x0a95 }
        L_0x073f:
            java.lang.String r2 = "app_community_xxzxgzlb"
            r4 = 0
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0761
        L_0x0746:
            java.lang.String r4 = "1009"
            boolean r4 = r4.equals(r10)     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x075e
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0761
            java.lang.Object r2 = r8.get(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r11.setUidUnique(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0761
        L_0x075e:
            r11.setJumpUrl(r2)     // Catch:{ Exception -> 0x0a95 }
        L_0x0761:
            int r2 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x0a95 }
            r11.setJumpMode(r2)     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            yl.o.p(r2, r11)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0773:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r2 = r4.v(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r2 != 0) goto L_0x0782
            goto L_0x0786
        L_0x0782:
            java.lang.String r6 = r2.getFullName()     // Catch:{ Exception -> 0x0a95 }
        L_0x0786:
            r3.success(r6)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x078b:
            r23.Fh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0790:
            r23.Nh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0795:
            r23.Sh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x079a:
            r23.xh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x079f:
            r23.Eh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07a4:
            r23.yh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07a9:
            r23.Ah(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07ae:
            r23.zh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07b3:
            r23.Dh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07b8:
            r23.Ch(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07bd:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r4 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            java.lang.Class<com.huobi.points.activity.MyPointsNewActivity> r5 = com.huobi.points.activity.MyPointsNewActivity.class
            r2.<init>(r4, r5)     // Catch:{ Exception -> 0x0a95 }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07cf:
            r23.Rh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07d4:
            java.lang.String r4 = "needToast"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r4 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            boolean r4 = com.hbg.lib.common.network.NetworkStatus.c(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0a9d
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0a9d
            if (r4 != 0) goto L_0x0a9d
            r2 = 2132026992(0x7f142670, float:1.9692532E38)
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x07fb:
            r2 = 1
            java.lang.String r2 = com.hbg.lib.network.uc.core.utils.UcHelper.b(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0805:
            iu.a r2 = iu.a.f()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.k()     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x081e
            ku.b r2 = ku.b.e()     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r4 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r2.h(r4)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x081e:
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0824:
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            r4 = 1
            r5 = 0
            nb.c.h(r2, r4, r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x082d:
            android.content.Context r2 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r4 = "FROM_SAVINGS"
            com.huobi.kyc.ui.KycProBaseInformationActivity.Vh(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0836:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x0a95 }
            com.huobi.login.usercenter.data.source.bean.UserInfoData r2 = r2.M()     // Catch:{ Exception -> 0x0a95 }
            java.util.List r2 = r2.d()     // Catch:{ Exception -> 0x0a95 }
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r2 = rx.Observable.just(r2)     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r4 = jp.l.q(r4)     // Catch:{ Exception -> 0x0a95 }
            r5 = 0
            rx.Observable$Transformer r6 = com.hbg.lib.core.util.RxJavaHelper.t(r5)     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r4 = r4.compose(r6)     // Catch:{ Exception -> 0x0a95 }
            dl.x r6 = dl.x.f53832b     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r2 = rx.Observable.zip(r2, r4, r6)     // Catch:{ Exception -> 0x0a95 }
            rx.Observable$Transformer r4 = com.hbg.lib.core.util.RxJavaHelper.t(r5)     // Catch:{ Exception -> 0x0a95 }
            rx.Observable r2 = r2.compose(r4)     // Catch:{ Exception -> 0x0a95 }
            com.huobi.flutter.base.AbsGlobalFlutterFragment$b r4 = new com.huobi.flutter.base.AbsGlobalFlutterFragment$b     // Catch:{ Exception -> 0x0a95 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0a95 }
            r2.subscribe(r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0872:
            r1.f67727e = r3     // Catch:{ Exception -> 0x0a95 }
            r1.f67728f = r2     // Catch:{ Exception -> 0x0a95 }
            rn.c r2 = rn.c.i()     // Catch:{ Exception -> 0x0a95 }
            androidx.fragment.app.FragmentActivity r4 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            com.huobi.login.bean.JumpTarget r5 = new com.huobi.login.bean.JumpTarget     // Catch:{ Exception -> 0x0a95 }
            r6 = 0
            r5.<init>(r6, r6)     // Catch:{ Exception -> 0x0a95 }
            r2.d(r4, r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0887:
            java.lang.Object r2 = r2.argument(r14)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            r4 = r20
            java.lang.String r2 = com.hbg.lib.core.util.ConfigPreferences.d(r4, r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0898:
            r4 = r20
            java.lang.Object r5 = r2.argument(r14)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "value"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.core.util.ConfigPreferences.m(r4, r5, r2)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x08b1:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r2 = r4.J(r2, r5)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x08ca
            java.lang.String r2 = r2.getState()     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x08ca:
            r3.success(r6)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x08cf:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.F(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x08e0:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.p(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x08f1:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r2 = r4.v(r2)     // Catch:{ Exception -> 0x0a95 }
            if (r2 != 0) goto L_0x0900
            goto L_0x0904
        L_0x0900:
            java.lang.String r6 = r2.getName()     // Catch:{ Exception -> 0x0a95 }
        L_0x0904:
            r3.success(r6)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0909:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.W(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x091a:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.z(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x092b:
            r23.uh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0930:
            r23.Kh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0935:
            el.i r4 = el.i.k()     // Catch:{ Exception -> 0x0a95 }
            r4.x(r2, r3)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x093e:
            java.lang.String r4 = "data"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0a95 }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "eventName"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0a95 }
            r5.<init>()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "sensorsDataTrack-native : ["
            r5.append(r6)     // Catch:{ Exception -> 0x0a95 }
            r5.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "] "
            r5.append(r6)     // Catch:{ Exception -> 0x0a95 }
            r5.append(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0a95 }
            i6.d.b(r5)     // Catch:{ Exception -> 0x0a95 }
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0973:
            r23.wh(r24, r25)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0978:
            sc.a r2 = com.hbg.module.contract.ContractModuleConfig.a()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.b()     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0985
            r2 = r16
            goto L_0x0987
        L_0x0985:
            r2 = r17
        L_0x0987:
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x098c:
            boolean r2 = com.hbg.lib.network.retrofit.util.SPUtil.j()     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0995
            r2 = r16
            goto L_0x0997
        L_0x0995:
            r2 = r17
        L_0x0997:
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x099c:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.F0()     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0a95 }
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x09ad:
            r4 = 1
            java.lang.Object r5 = r2.argument(r10)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0a95 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r7 != 0) goto L_0x09e3
            r7 = r19
            boolean r8 = r2.hasArgument(r7)     // Catch:{ Exception -> 0x0a95 }
            if (r8 == 0) goto L_0x09cd
            java.lang.Object r2 = r2.argument(r7)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0a95 }
            boolean r13 = r2.booleanValue()     // Catch:{ Exception -> 0x0a95 }
            goto L_0x09ce
        L_0x09cd:
            r13 = r4
        L_0x09ce:
            if (r13 == 0) goto L_0x09d7
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            r4 = 0
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r2, r5, r6, r6, r4)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x09dd
        L_0x09d7:
            r4 = 0
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebViewNoClear(r2, r5, r6, r6, r4)     // Catch:{ Exception -> 0x0a95 }
        L_0x09dd:
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x09e3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0a95 }
            r4.<init>()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r2.method     // Catch:{ Exception -> 0x0a95 }
            r4.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = "method url is null"
            r4.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0a95 }
            r4 = r18
            r5 = 0
            r3.error(r4, r2, r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x09fe:
            androidx.fragment.app.FragmentActivity r2 = r1.f67730h     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0a05
            r2.finish()     // Catch:{ Exception -> 0x0a95 }
        L_0x0a05:
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a0b:
            java.lang.String r4 = "show"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = "dismissable"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0a95 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x0a2b
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x0a95 }
            if (r4 == 0) goto L_0x0a2b
            r1.showProgressDialog((boolean) r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a2e
        L_0x0a2b:
            r23.dismissProgressDialog()     // Catch:{ Exception -> 0x0a95 }
        L_0x0a2e:
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a33:
            r23.Ph(r24)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a3b:
            r4 = r18
            java.lang.String r5 = "msg"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = "position"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0a95 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0a95 }
            if (r7 != 0) goto L_0x0a67
            java.lang.String r2 = "top"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0a95 }
            if (r2 == 0) goto L_0x0a5f
            com.hbg.lib.widgets.utils.HuobiToastUtil.v(r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a62
        L_0x0a5f:
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r5)     // Catch:{ Exception -> 0x0a95 }
        L_0x0a62:
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a67:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0a95 }
            r5.<init>()     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r2.method     // Catch:{ Exception -> 0x0a95 }
            r5.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = "method  msg is null"
            r5.append(r2)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x0a95 }
            r5 = 0
            r3.error(r4, r2, r5)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a7f:
            java.lang.String r4 = "text"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x0a95 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0a95 }
            uf.a r4 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x0a95 }
            android.content.Context r5 = r1.f67729g     // Catch:{ Exception -> 0x0a95 }
            r4.h(r2, r5)     // Catch:{ Exception -> 0x0a95 }
            r2 = 0
            r3.success(r2)     // Catch:{ Exception -> 0x0a95 }
            goto L_0x0a9d
        L_0x0a95:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            r25.notImplemented()
        L_0x0a9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.flutter.base.AbsGlobalFlutterFragment.Lh(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private void Mh(MethodCall methodCall, MethodChannel.Result result) {
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        flutterKycConfig.setPhone(r.x().F());
        flutterKycConfig.setEmail(r.x().u());
        String str = (String) methodCall.argument("authBizCode");
        if (!TextUtils.isEmpty(str)) {
            flutterKycConfig.setAuthBizCode(str);
        } else {
            flutterKycConfig.setAuthBizCode(Coupon.SPOT);
        }
        k.o("withdrawKyc", "开启新Kyc页面 authBizCode:" + str);
        b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
    }

    private void Nh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("id")) {
                v0.e(this.f67729g, (String) methodCall.argument("id"));
                result.success("");
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private boolean Ph(MethodCall methodCall) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        if (!TextUtils.isEmpty(str)) {
            l6.a a11 = l6.a.a();
            RuntimeException runtimeException = new RuntimeException(str);
            a11.b(runtimeException, this, "page:" + Bh(), methodCall.method, methodCall.arguments);
        }
        return false;
    }

    private void Qh(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("type");
        this.f67727e = result;
        if ("0".equals(str)) {
            Oh();
        } else if ("1".equals(str)) {
            vh();
        } else {
            Oh();
        }
    }

    private void Rh(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
        if (methodCall.hasArgument("symbol")) {
            String str = (String) methodCall.argument("symbol");
            if (!TextUtils.isEmpty(str)) {
                k0.O(this.f67729g, str, true);
            } else {
                startActivity(k0.t(this.f67729g, false));
            }
        }
    }

    private void uh(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments();
        if (map == null) {
            result.error("-1", "methodCall.arguments is null", "");
            return;
        }
        d.j("flutter", "aliyunLog params - " + map);
        result.success((Object) null);
    }

    private void wh(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("eventAction");
        String str2 = (String) methodCall.argument("eventId");
        String str3 = (String) methodCall.argument("pageId");
        Map map = (Map) methodCall.argument("extend");
        String str4 = (String) methodCall.argument(IBridgeMediaLoader.COLUMN_DURATION);
        if ("click".equals(str)) {
            is.a.j(str2, map, str3);
            result.success((Object) null);
        } else if ("expose".equals(str)) {
            is.a.n(str2, str3, str4, map);
            result.success((Object) null);
        } else if ("popexpose".equals(str)) {
            is.a.s(str2, str3, false, str4, map);
            result.success((Object) null);
        } else {
            result.error("-1", "eventAction 类型不支持", "");
        }
    }

    private void xh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.b((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY))));
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void yh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.B((String) methodCall.argument("symbol"), true)));
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    private void zh(MethodCall methodCall, MethodChannel.Result result) {
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

    public abstract String Bh();

    @AfterPermissionGranted(124)
    public void Oh() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this.f67729g, str)) {
            pa.d.o().B(false).w(this.f67730h);
        } else {
            EasyPermissions.requestPermissions(this, 124, str);
        }
    }

    public void Sh(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        r.x().m("Flutter UCToken Interceptor#tokenFailed - ", false);
        EventBus.d().k(new mo.a("512", "Flutter UcToken Error"));
        EventBus.d().k(new p6.a("512", "Flutter UcToken Error"));
        k.f("LOGIN", "UC-TOKEN token Failed ");
        if (methodCall.hasArgument("message") && (str = (String) methodCall.argument("message")) != null && !TextUtils.isEmpty(str)) {
            HuobiToastUtil.l(j.c(), str);
        }
        result.success((Object) null);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        Log.i("flutter", "configureFlutterEngine");
        new MethodChannel(flutterEngine.getDartExecutor(), Constants.MessageTypes.SEND_EVENT).setMethodCallHandler(this);
        new MethodChannel(flutterEngine.getDartExecutor(), "request_token").setMethodCallHandler(this);
        new MethodChannel(flutterEngine.getDartExecutor(), "platform_message_channel").setMethodCallHandler(new a());
    }

    public void dismissProgressDialog() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).dismissProgressDialog();
        }
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.f67724b;
    }

    public boolean isAlive() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseCoreActivity) {
            return this.f67725c && ((BaseCoreActivity) activity).isAlive();
        }
        return this.f67725c;
    }

    public boolean isCanBeSeen() {
        return false;
    }

    public void onAttach(Context context) {
        this.f67730h = getActivity();
        this.f67729g = context;
        Context attachBaseContext = AppLanguageHelper.getInstance().attachBaseContext(context);
        this.f67729g = attachBaseContext;
        super.onAttach(attachBaseContext);
    }

    public void onDestroy() {
        this.f67724b.onNext(5);
        super.onDestroy();
        this.f67725c = false;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("reportFlutterError".equals(str)) {
                Ph(methodCall);
                result.success((Object) null);
            } else if ("platformToast".equals(str)) {
                String str2 = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
                String str3 = (String) methodCall.argument("position");
                if (!TextUtils.isEmpty(str2)) {
                    if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(str3)) {
                        HuobiToastUtil.v(str2);
                    } else {
                        HuobiToastUtil.m(str2);
                    }
                }
                result.success((Object) null);
            } else if ("platformOpenWebView".equals(str)) {
                String str4 = (String) methodCall.argument("url");
                if (!TextUtils.isEmpty(str4)) {
                    HBBaseWebActivity.showWebView(this.f67729g, str4, "", "", false);
                }
                result.success((Object) null);
            } else if ("requestToken".equals(str)) {
                i.k().x(methodCall, result);
            } else if ("popPage".equals(str)) {
                FragmentActivity fragmentActivity = this.f67730h;
                if (fragmentActivity != null) {
                    fragmentActivity.finish();
                }
                result.success((Object) null);
            } else if ("imagePicker".equals(str)) {
                Qh(methodCall, result);
            } else if ("platformShowHUD".equals(str)) {
                Boolean bool = (Boolean) methodCall.argument("show");
                if (bool == null || !bool.booleanValue()) {
                    dismissProgressDialog();
                } else {
                    showProgressDialog(true);
                }
            } else if ("getNetworkState".equals(str)) {
                Boolean bool2 = (Boolean) methodCall.argument("needToast");
                boolean h11 = l.h(this.f67729g);
                result.success(Boolean.valueOf(h11));
                if (bool2 != null && bool2.booleanValue() && !h11) {
                    HuobiToastUtil.j(R.string.string_network_disconnect);
                }
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void onPause() {
        this.f67724b.onNext(3);
        super.onPause();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Fragment) this, getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        if (i11 == 123) {
            pa.d.o().B(false).r(this);
        } else if (i11 == 124) {
            pa.d.o().B(false).u(this);
        }
    }

    public void onResume() {
        MethodCall methodCall;
        super.onResume();
        this.f67724b.onNext(2);
        this.f67725c = true;
        String str = null;
        if (!(this.f67727e == null || (methodCall = this.f67728f) == null || !"showVerify".equals(methodCall.method))) {
            this.f67727e.success(Boolean.valueOf(r.x().F0()));
            this.f67727e = null;
            this.f67728f = null;
        }
        String str2 = getClass().getSimpleName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Bh();
        String simpleName = getActivity().getClass().getSimpleName();
        if (getArguments() != null) {
            str = getArguments().toString();
        }
        OpPathMonitor.c().b(str2, simpleName, str);
        FirebaseCrashlytics.getInstance().setCustomKey("lastPagePath", str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + simpleName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str);
        if (getView() != null && isHidden() && getView().getVisibility() == 0) {
            getView().setVisibility(8);
        }
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        Log.i("flutter", "provideFlutterEngine");
        String a11 = c.a(Bh(), PixelUtils.a(24.0f));
        Log.i("flutter", "provideFlutterEngine no cache");
        FlutterEngine flutterEngine = new FlutterEngine(this.f67729g);
        this.f67726d = flutterEngine;
        flutterEngine.getNavigationChannel().setInitialRoute(a11);
        this.f67726d.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(a11, this.f67726d);
        return this.f67726d;
    }

    public void showProgressDialog(boolean z11) {
        showProgressDialog((String) null, z11);
    }

    @AfterPermissionGranted(123)
    public void vh() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(this.f67729g, strArr)) {
            pa.d.o().B(false).r(this);
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public void showProgressDialog(String str, boolean z11) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog(str, z11);
        }
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, false);
    }

    public void showProgressDialog() {
        showProgressDialog((String) null);
    }
}
