package com.huobi.otc.flutter;

import android.content.Intent;
import android.net.Uri;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.lib.network.otc.core.bean.ThirdOrderId;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.otc.event.JumpOtcTradeAreaEvent;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import com.huobi.otc.ui.HBSupportFormWebActivity;
import com.huobi.otc.ui.OtcBindBankCardActivity;
import com.huobi.otc.ui.OtcTradeSettingActivity;
import com.huobi.utils.GsonHelper;
import dp.t;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.c1;
import jp.k0;
import jp.v1;
import org.greenrobot.eventbus.EventBus;

public class OtcQuickTradeQuoteActivity extends AbsGlobalFlutterActivity {

    /* renamed from: p  reason: collision with root package name */
    public static final String f78570p = "OtcQuickTradeQuoteActivity";

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78571k;

    /* renamed from: l  reason: collision with root package name */
    public com.huobi.otc.helper.a f78572l;

    /* renamed from: m  reason: collision with root package name */
    public t f78573m;

    /* renamed from: n  reason: collision with root package name */
    public OtcSecurityTokenFactory f78574n;

    /* renamed from: o  reason: collision with root package name */
    public MethodChannel f78575o;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public class c extends TypeToken<List<Map<String, Object>>> {
        public c() {
        }
    }

    public class d implements cp.d {
        public d() {
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            OtcQuickTradeQuoteActivity.this.f78575o.invokeMethod("ucTokenSuccess", str);
        }
    }

    public class e implements cp.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78580a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f78581b;

        public e(MethodCall methodCall, MethodChannel methodChannel) {
            this.f78580a = methodCall;
            this.f78581b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            String Gi = OtcQuickTradeQuoteActivity.f78570p;
            i6.d.c(Gi, "token=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78580a.argument("action"));
            hashMap.put("securityToken", str);
            this.f78581b.invokeMethod("payMethodCode", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = OtcQuickTradeQuoteActivity.this.f78573m = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            String Gi = OtcQuickTradeQuoteActivity.f78570p;
            i6.d.c(Gi, "password=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78580a.argument("action"));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            this.f78581b.invokeMethod("payMethodCode", hashMap);
            if (OtcQuickTradeQuoteActivity.this.f78573m != null && OtcQuickTradeQuoteActivity.this.f78573m.isShowing()) {
                OtcQuickTradeQuoteActivity.this.f78573m.dismiss();
            }
        }
    }

    public class f implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78584a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78584a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                OtcQuickTradeQuoteActivity.this.f78572l.s().c(authResult.getToken());
                this.f78584a.v();
            }
        }

        public class b implements jp.c {
            public b() {
            }

            public void call() {
                OtcQuickTradeQuoteActivity.this.f78572l.I();
            }
        }

        public f() {
        }

        public void call() {
            OtcQuickTradeQuoteActivity otcQuickTradeQuoteActivity = OtcQuickTradeQuoteActivity.this;
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(otcQuickTradeQuoteActivity, otcQuickTradeQuoteActivity, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new b());
        }
    }

    public final void Ii() {
        if (!isFinishing()) {
            finish();
        }
    }

    public void Ji(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        char c11 = 65535;
        try {
            int i11 = 1;
            switch (str.hashCode()) {
                case -1836262593:
                    if (str.equals("showFundPasswordAlert")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case -1743138048:
                    if (str.equals("openBillingPage")) {
                        c11 = 15;
                        break;
                    }
                    break;
                case -1603692764:
                    if (str.equals("requestOtcOnlineConfig")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1568976300:
                    if (str.equals("switchToRechargeList")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -1338196836:
                    if (str.equals("openLandingPage")) {
                        c11 = 16;
                        break;
                    }
                    break;
                case -1266553392:
                    if (str.equals("openAddPaymentMethod")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -1263238685:
                    if (str.equals("open2FA")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1263210460:
                    if (str.equals("openP2P")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -1232222409:
                    if (str.equals("toBindCardPage")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -951855281:
                    if (str.equals("openUserPaymentList")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -647960427:
                    if (str.equals("openOrderDetail")) {
                        c11 = 14;
                        break;
                    }
                    break;
                case -69163490:
                    if (str.equals("native_start_verify")) {
                        c11 = 22;
                        break;
                    }
                    break;
                case -67805570:
                    if (str.equals("goBrokerage")) {
                        c11 = 19;
                        break;
                    }
                    break;
                case 375121689:
                    if (str.equals("requestPayMethodBaseInfo")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 865387575:
                    if (str.equals("goFundPasswordPage")) {
                        c11 = 21;
                        break;
                    }
                    break;
                case 871591172:
                    if (str.equals("goOrderList")) {
                        c11 = 13;
                        break;
                    }
                    break;
                case 1084969282:
                    if (str.equals("openRechargeCoin")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1098444083:
                    if (str.equals("removePage")) {
                        c11 = 18;
                        break;
                    }
                    break;
                case 1183703285:
                    if (str.equals("pageParams")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1386621579:
                    if (str.equals("isDowngradeFundPassword")) {
                        c11 = 20;
                        break;
                    }
                    break;
                case 1497951768:
                    if (str.equals("openRechargeFiatCoin")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1544862116:
                    if (str.equals("requestFiatBaseInfo")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 1835406936:
                    if (str.equals("openSimplexWeb")) {
                        c11 = 17;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    result.success((Map) GsonHelper.a().fromJson(getIntent().getStringExtra("quoteParam"), new a().getType()));
                    return;
                case 1:
                    BaseSettingBean g11 = qu.d.i().g();
                    if (g11 != null) {
                        result.success((Map) GsonHelper.a().fromJson(GsonHelper.a().toJson((Object) g11), new b().getType()));
                        return;
                    } else {
                        result.success(new HashMap());
                        return;
                    }
                case 2:
                    String str2 = (String) methodCall.argument("currencyName");
                    OtcBindBankCardActivity.Rh(this, true, OtcTradeAreaEnum.FAST_AREA.getCode());
                    result.success(Boolean.TRUE);
                    return;
                case 3:
                    OtcModuleConfig.b().R(this);
                    result.success((Object) null);
                    return;
                case 4:
                    String str3 = (String) methodCall.argument("coinName");
                    Boolean bool = (Boolean) methodCall.argument("popFirst");
                    new OtcFaitDWJumpHelper(this, this, str3).t(OtcFaitDWJumpHelper.f78855g, str3);
                    result.success((Object) null);
                    if (bool != null && bool.booleanValue()) {
                        Ii();
                        return;
                    }
                    return;
                case 5:
                    Boolean bool2 = (Boolean) methodCall.argument("isSell");
                    Boolean bool3 = (Boolean) methodCall.argument("popFirst");
                    String str4 = (String) methodCall.argument("fiatName");
                    String str5 = (String) methodCall.argument("coinName");
                    String encode = Uri.encode("ihuobiglobal://m.hbg.com/otc/index?tradeArea=p2p&tradeSide=" + ((bool2 == null || !bool2.booleanValue()) ? "buy" : "sell") + "&tradeCurrency=" + str5 + "&fiatName=" + str4 + "&siteType=" + 1);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("holigeit://open/v1?login=1&url=");
                    sb2.append(encode);
                    zn.a.d().v(Uri.parse(sb2.toString())).a().c();
                    result.success((Object) null);
                    if (bool3 != null && bool3.booleanValue()) {
                        Ii();
                        return;
                    }
                    return;
                case 6:
                    UnifyDepositActivity.wh(this, (String) methodCall.argument("coinName"));
                    result.success((Object) null);
                    return;
                case 7:
                    JumpOtcTradeAreaEvent jumpOtcTradeAreaEvent = new JumpOtcTradeAreaEvent();
                    jumpOtcTradeAreaEvent.setTradeAreaEnum(OtcTradeAreaEnum.DEPOSIT_AREA);
                    EventBus.d().k(jumpOtcTradeAreaEvent);
                    result.success((Object) null);
                    Ii();
                    return;
                case 8:
                    Integer num = (Integer) methodCall.argument("payMethodId");
                    String j11 = c1.h().j(TradeBusinessEnum.ALL, (String) methodCall.argument("payMethodCode"));
                    if (num != null) {
                        i11 = num.intValue();
                    }
                    P2PPayMethodRootFlutterActivity.Ji(this, i11, j11, 0);
                    result.success((Object) null);
                    return;
                case 9:
                    k0.d().g(this, this);
                    result.success((Object) null);
                    return;
                case 10:
                    List<QuickTradeConfigBean.Payment> c12 = c1.h().c(TradeBusinessEnum.ALL);
                    if (c12 != null) {
                        result.success((List) GsonHelper.a().fromJson(GsonHelper.a().toJson((Object) c12), new c().getType()));
                        return;
                    } else {
                        result.success((Object) null);
                        return;
                    }
                case 11:
                    List<OtcConfigItem.CurrencyBean> currencyBeans = va.b.o().r().getCurrencyBeans();
                    ArrayList arrayList = new ArrayList();
                    if (currencyBeans != null) {
                        for (OtcConfigItem.CurrencyBean next : currencyBeans) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("nameShort", next.getNameShort());
                            hashMap.put("whetherGib", Integer.valueOf(next.getWhetherGib()));
                            arrayList.add(hashMap);
                        }
                    }
                    result.success(arrayList);
                    return;
                case 12:
                    Ki(methodCall, this.f78571k);
                    result.success((Object) null);
                    return;
                case 13:
                    k0.d().h(this, (Intent) null);
                    result.success((Object) null);
                    return;
                case 14:
                    v1.a().f(this, (String) methodCall.argument("orderId"));
                    result.success((Object) null);
                    return;
                case 15:
                    OtcModuleConfig.a().d0(this, (String) methodCall.argument("orderId"), "", "");
                    result.success((Object) null);
                    return;
                case 16:
                    OtcTradePayingAndSuccessActivity.Pi(this, (String) methodCall.argument("orderId"));
                    result.success((Object) null);
                    return;
                case 17:
                    Object obj = methodCall.arguments;
                    if (obj != null) {
                        Li((ThirdOrderId) GsonHelper.a().fromJson(GsonHelper.a().toJson(obj), ThirdOrderId.class));
                    }
                    result.success((Object) null);
                    return;
                case 18:
                    Ii();
                    result.success((Object) null);
                    return;
                case 19:
                    result.success((Object) null);
                    return;
                case 20:
                    if (qu.d.i().g() == null || !qu.d.i().g().getDowngradeFundPassword().booleanValue()) {
                        result.success(Boolean.FALSE);
                        return;
                    } else {
                        result.success(Boolean.TRUE);
                        return;
                    }
                case 21:
                    startActivity(new Intent(this, OtcTradeSettingActivity.class));
                    result.success("");
                    return;
                case 22:
                    if (this.f78574n == null) {
                        this.f78574n = new OtcSecurityTokenFactory(this, this);
                    }
                    this.f78574n.n(new d());
                    result.success("");
                    return;
                default:
                    result.success((Object) null);
                    return;
            }
        } catch (Exception e11) {
            result.success((Object) null);
            e11.printStackTrace();
        }
        result.success((Object) null);
        e11.printStackTrace();
    }

    public void Ki(MethodCall methodCall, MethodChannel methodChannel) {
        if (this.f78572l == null) {
            this.f78572l = new com.huobi.otc.helper.a(this, this);
        }
        this.f78572l.J(new e(methodCall, methodChannel));
        this.f78572l.M(new f());
    }

    public final void Li(ThirdOrderId thirdOrderId) throws UnsupportedEncodingException {
        String str;
        String str2;
        String submitUrl = thirdOrderId.getSubmitUrl();
        String versionId = thirdOrderId.getVersionId();
        String paymentId = thirdOrderId.getPaymentId();
        String providerName = thirdOrderId.getProviderName();
        String callBackUrl = thirdOrderId.getCallBackUrl();
        String uid = thirdOrderId.getUid();
        String liquidityToken = thirdOrderId.getLiquidityToken();
        String walletAddress = thirdOrderId.getWalletAddress();
        String walletType = thirdOrderId.getWalletType();
        String amount = thirdOrderId.getAmount();
        String quantity = thirdOrderId.getQuantity();
        String callBackUrl2 = thirdOrderId.getCallBackUrl();
        String cryptoAsset = thirdOrderId.getCryptoAsset();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("version=");
        sb2.append(URLEncoder.encode(versionId, "UTF-8"));
        sb2.append("&payment_flow_type=wallet&payment_id=");
        if (paymentId == null) {
            paymentId = "";
        }
        sb2.append(URLEncoder.encode(paymentId, "UTF-8"));
        sb2.append("&partner=");
        if (providerName == null) {
            providerName = "";
        }
        sb2.append(URLEncoder.encode(providerName, "UTF-8"));
        sb2.append("&user_id=");
        if (uid == null) {
            uid = "";
        }
        sb2.append(URLEncoder.encode(uid, "UTF-8"));
        sb2.append("&quote_id=");
        if (liquidityToken == null) {
            liquidityToken = "";
        }
        sb2.append(URLEncoder.encode(liquidityToken, "UTF-8"));
        sb2.append("&destination_wallet[address]=");
        if (walletAddress == null) {
            walletAddress = "";
        }
        sb2.append(URLEncoder.encode(walletAddress, "UTF-8"));
        sb2.append("&destination_wallet[currency]=");
        if (walletType == null) {
            walletType = "";
        }
        sb2.append(URLEncoder.encode(walletType, "UTF-8"));
        sb2.append("&fiat_total_amount[amount]=");
        if (amount != null) {
            str = amount;
        } else {
            str = "";
        }
        sb2.append(URLEncoder.encode(str, "UTF-8"));
        sb2.append("&fiat_total_amount[currency]=");
        if (quantity == null) {
            quantity = "";
        }
        sb2.append(URLEncoder.encode(quantity, "UTF-8"));
        sb2.append("&fiat_total_amount[amount]=");
        if (amount == null) {
            amount = "";
        }
        sb2.append(URLEncoder.encode(amount, "UTF-8"));
        sb2.append("&digital_total_amount[amount]=");
        if (callBackUrl2 == null) {
            callBackUrl2 = "";
        }
        sb2.append(URLEncoder.encode(callBackUrl2, "UTF-8"));
        sb2.append("&digital_total_amount[currency]=");
        if (cryptoAsset == null) {
            cryptoAsset = "";
        }
        sb2.append(URLEncoder.encode(cryptoAsset, "UTF-8"));
        sb2.append("&return_url_fail=");
        if (callBackUrl != null) {
            str2 = callBackUrl;
        } else {
            str2 = "";
        }
        sb2.append(URLEncoder.encode(str2, "UTF-8"));
        sb2.append("&return_url_success=");
        if (callBackUrl == null) {
            callBackUrl = "";
        }
        sb2.append(URLEncoder.encode(callBackUrl, "UTF-8"));
        HBSupportFormWebActivity.Bh(this, submitUrl, "", "", false, sb2.toString());
    }

    public String Nh() {
        return "quick_quote_pay_list";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_quick_quote_channel");
        this.f78571k = methodChannel;
        methodChannel.setMethodCallHandler(new h0(this));
        MethodChannel methodChannel2 = new MethodChannel(flutterEngine.getDartExecutor(), "trade_setting_channel");
        this.f78575o = methodChannel2;
        methodChannel2.setMethodCallHandler(new h0(this));
    }
}
