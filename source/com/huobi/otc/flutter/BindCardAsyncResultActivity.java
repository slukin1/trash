package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.event.CloseFastTradeDialogEvent;
import com.huobi.otc.ui.OtcBindBankCardActivity;
import com.huobi.otc.ui.OtcCardManagerActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.zopim.android.sdk.api.ZopimChat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import jp.k0;
import org.greenrobot.eventbus.EventBus;
import qiu.niorgai.StatusBarCompat;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sn.f;
import tg.r;
import uf.c;

public class BindCardAsyncResultActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f78408k;

    /* renamed from: l  reason: collision with root package name */
    public String f78409l;

    /* renamed from: m  reason: collision with root package name */
    public String f78410m;

    /* renamed from: n  reason: collision with root package name */
    public String f78411n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f78412o = false;

    /* renamed from: p  reason: collision with root package name */
    public String f78413p = "1";

    /* renamed from: q  reason: collision with root package name */
    public String f78414q = "2";

    /* renamed from: r  reason: collision with root package name */
    public String f78415r = "3";

    /* renamed from: s  reason: collision with root package name */
    public String f78416s = "4";

    /* renamed from: t  reason: collision with root package name */
    public MethodChannel f78417t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f78418u;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            BindCardAsyncResultActivity.this.Hi(methodCall, result);
        }
    }

    public class b extends RequestCallback1<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f78420a;

        public class a implements Observer<String> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Map f78422b;

            public a(Map map) {
                this.f78422b = map;
            }

            /* renamed from: a */
            public void onNext(String str) {
                this.f78422b.put("content", str);
                b.this.f78420a.success(this.f78422b);
            }

            public void onCompleted() {
            }

            public void onError(Throwable th2) {
                b.this.f78420a.success(this.f78422b);
            }
        }

        public b(MethodChannel.Result result) {
            this.f78420a = result;
        }

        /* renamed from: c */
        public void onRequestSuccess(Map<String, String> map) {
            String str = map.get("code");
            BindCardAsyncResultActivity bindCardAsyncResultActivity = BindCardAsyncResultActivity.this;
            String unused = bindCardAsyncResultActivity.f78408k = bindCardAsyncResultActivity.Gi(map.get("cardState"));
            if (!TextUtils.isEmpty(map.get("content"))) {
                this.f78420a.success(map);
            } else if (!TextUtils.isEmpty(str)) {
                Observable.just(str).subscribeOn(Schedulers.newThread()).map(new b(str)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(map));
            } else {
                this.f78420a.success(map);
            }
        }

        public void onRequestFailure(Throwable th2) {
            HashMap hashMap = new HashMap();
            hashMap.put("cardState", "4");
            hashMap.put("content", "");
            this.f78420a.success(hashMap);
        }
    }

    public static void Ji(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent();
        intent.setClass(context, BindCardAsyncResultActivity.class);
        intent.putExtra("bind_card_init_state", str);
        intent.putExtra("bind_card_from", str2);
        intent.putExtra("bind_card_number", str3);
        intent.putExtra("bind_card_content", str4);
        context.startActivity(intent);
    }

    public final void Fi() {
        Activity f11 = oa.a.g().f(OtcBindBankCardActivity.class);
        if (f11 != null) {
            oa.a.g().d(f11);
        }
        Activity f12 = oa.a.g().f(OtcCardManagerActivity.class);
        if (f12 != null) {
            oa.a.g().d(f12);
        }
    }

    public final String Gi(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return this.f78416s;
            case 1:
            case 2:
                return this.f78414q;
            case 3:
                return this.f78413p;
            case 4:
                return this.f78415r;
            default:
                return this.f78415r;
        }
    }

    public void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -2029414643:
                    if (str.equals("openZopimChat")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1432438668:
                    if (str.equals("initBindCardState")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -622538820:
                    if (str.equals("queryBindCardState")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 393046149:
                    if (str.equals("asyncBindBtnClick")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1353095890:
                    if (str.equals("closeBindResult")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            if (c11 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("cardState", this.f78408k);
                hashMap.put("content", this.f78410m);
                hashMap.put("accountNumber", this.f78409l);
                result.success(hashMap);
            } else if (c11 == 1) {
                Ii(methodCall, result);
            } else if (c11 == 2) {
                f.y(this, (ZopimChat.SessionConfig) null);
            } else if (c11 == 3) {
                Activity f11 = oa.a.g().f(OtcBindBankCardActivity.class);
                if (f11 != null) {
                    oa.a.g().d(f11);
                }
                finish();
            } else if (c11 != 4) {
                result.notImplemented();
            } else {
                if (this.f78412o) {
                    finish();
                    Fi();
                    if (!this.f78408k.equals(this.f78414q)) {
                        if (!this.f78408k.equals(this.f78413p)) {
                            if (!LiteReHelper.a().b() && !(oa.a.g().b() instanceof OtcTradeActivity)) {
                                k0.m(this, OtcTradeAreaEnum.FAST_AREA);
                            }
                        }
                    }
                    if (!LiteReHelper.a().b()) {
                        k0.m(this, OtcTradeAreaEnum.FAST_AREA);
                    } else {
                        EventBus.d().k(new CloseFastTradeDialogEvent());
                    }
                } else if (TextUtils.equals(this.f78411n, "cardManager")) {
                    Fi();
                    finish();
                } else if (TextUtils.equals(this.f78411n, TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER)) {
                    finish();
                    Fi();
                    if (this.f78408k.equals(this.f78414q) || this.f78408k.equals(this.f78413p)) {
                        if (!LiteReHelper.a().b()) {
                            k0.m(this, OtcTradeAreaEnum.FAST_AREA);
                        } else {
                            EventBus.d().k(new CloseFastTradeDialogEvent());
                        }
                    }
                }
                HashMap hashMap2 = new HashMap();
                if (this.f78416s.equals(this.f78408k)) {
                    hashMap2.put("otc_step", "click_buy");
                } else {
                    hashMap2.put("otc_step", "click_quote_again");
                }
                c.b().h("hbg_fiat_bind_card", hashMap2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void Ii(MethodCall methodCall, MethodChannel.Result result) {
        v7.b.a().requestCardState().d(new b(result));
    }

    public String Nh() {
        return "bind_card_async_result_route";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "bind_card_async_result_channel");
        this.f78417t = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean F0 = r.x().F0();
        this.f78418u = F0;
        if (!F0) {
            finish();
            OtcModuleConfig.a().l(this, new Intent(this, BindCardAsyncResultActivity.class), (Intent) null);
            return;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            StatusBarCompat.d(this, true);
            if (NightHelper.e().g()) {
                StatusBarCompat.a(this);
            } else {
                StatusBarCompat.b(this);
            }
            this.f78411n = getIntent().getStringExtra("bind_card_from");
            this.f78408k = getIntent().getStringExtra("bind_card_init_state");
            this.f78409l = getIntent().getStringExtra("bind_card_number");
            this.f78410m = getIntent().getStringExtra("bind_card_content");
        } else if (data.toString().contains("huobi3ds")) {
            this.f78412o = true;
            this.f78408k = this.f78415r;
            this.f78409l = "";
            this.f78410m = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", "view_result_page");
        c.b().h("hbg_fiat_bind_card", hashMap);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onResume() {
        super.onResume();
    }
}
