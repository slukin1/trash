package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.share.ImageUtil;
import com.huobi.sharev2.manager.ShareManager;
import com.tencent.android.tpush.common.MessageKey;
import cp.c;
import dp.t;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import pro.huobi.R;
import up.f;

public class OtcAdPublishEditActivity extends AbsGlobalFlutterActivity {

    /* renamed from: p  reason: collision with root package name */
    public static final String f78428p = "OtcAdPublishEditActivity";

    /* renamed from: k  reason: collision with root package name */
    public String f78429k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f78430l;

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel f78431m;

    /* renamed from: n  reason: collision with root package name */
    public com.huobi.otc.helper.a f78432n;

    /* renamed from: o  reason: collision with root package name */
    public t f78433o;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78434a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f78435b;

        public a(MethodCall methodCall, MethodChannel methodChannel) {
            this.f78434a = methodCall;
            this.f78435b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            String Hi = OtcAdPublishEditActivity.f78428p;
            d.c(Hi, "token=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78434a.argument("userPayMethodId"));
            hashMap.put("action", this.f78434a.argument("action"));
            hashMap.put(MessageKey.MSG_TRACE_ID, this.f78434a.argument(MessageKey.MSG_TRACE_ID));
            hashMap.put("securityToken", str);
            this.f78435b.invokeMethod("payMethodCode", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = OtcAdPublishEditActivity.this.f78433o = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            String Hi = OtcAdPublishEditActivity.f78428p;
            d.c(Hi, "password=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78434a.argument("userPayMethodId"));
            hashMap.put("action", this.f78434a.argument("action"));
            hashMap.put(MessageKey.MSG_TRACE_ID, this.f78434a.argument(MessageKey.MSG_TRACE_ID));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            this.f78435b.invokeMethod("payMethodCode", hashMap);
            if (OtcAdPublishEditActivity.this.f78433o != null && OtcAdPublishEditActivity.this.f78433o.isShowing()) {
                OtcAdPublishEditActivity.this.f78433o.dismiss();
            }
        }
    }

    public class b implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78438a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78438a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                OtcAdPublishEditActivity.this.f78432n.s().c(authResult.getToken());
                this.f78438a.v();
            }
        }

        /* renamed from: com.huobi.otc.flutter.OtcAdPublishEditActivity$b$b  reason: collision with other inner class name */
        public class C0834b implements jp.c {
            public C0834b() {
            }

            public void call() {
                OtcAdPublishEditActivity.this.f78432n.I();
            }
        }

        public b() {
        }

        public void call() {
            OtcAdPublishEditActivity otcAdPublishEditActivity = OtcAdPublishEditActivity.this;
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(otcAdPublishEditActivity, otcAdPublishEditActivity, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new C0834b());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Li(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == -1836262593) {
                if (str.equals("showFundPasswordAlert")) {
                    c11 = 0;
                }
            }
            if (c11 != 0) {
                result.notImplemented();
                return;
            }
            Oi(methodCall, this.f78431m);
            result.success((Object) null);
        } catch (Throwable th2) {
            th2.printStackTrace();
            result.notImplemented();
        }
    }

    public static void Pi(Context context, String str) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_ad_id", str);
        }
        intent.setClass(context, OtcAdPublishEditActivity.class);
        context.startActivity(intent);
    }

    public static void Qi(Context context, String str, int i11, boolean z11, String str2, String str3) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_ad_id", str);
        } else {
            intent.putExtra("key_trade_type", i11);
            intent.putExtra("key_is_privilege_on", z11);
            intent.putExtra("key_coin_name", str2);
            intent.putExtra("key_currency_name", str3);
        }
        intent.setClass(context, OtcAdPublishEditActivity.class);
        context.startActivity(intent);
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        String str = "";
        try {
            HashMap hashMap = new HashMap();
            boolean isEmpty = TextUtils.isEmpty(this.f78429k);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(isEmpty ? 0 : 1);
            hashMap.put("type", sb2.toString());
            if (!isEmpty) {
                str = this.f78429k;
            }
            hashMap.put("advertId", str);
            if (isEmpty) {
                hashMap.put("tradeType", Integer.valueOf(getIntent().getIntExtra("key_trade_type", 0)));
                hashMap.put("isPrivilegeOn", Boolean.valueOf(getIntent().getBooleanExtra("key_is_privilege_on", false)));
                hashMap.put("coinName", getIntent().getStringExtra("key_coin_name"));
                hashMap.put("currencyName", getIntent().getStringExtra("key_currency_name"));
            }
            JSONObject jSONObject = new JSONObject(hashMap);
            d.j("sfsfsfsdsdfsdf", jSONObject.toString());
            result.success(jSONObject.toString());
        } catch (Exception e11) {
            result.error("OtcAdPublishEditActivity error", e11.getMessage(), e11.getMessage());
        }
    }

    public View Mi(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i11) {
        String str12;
        String str13;
        String str14 = str3;
        String str15 = str5;
        String str16 = str7;
        String str17 = str10;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_otc_ad_share, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_time)).setText(DateTimeUtils.i(System.currentTimeMillis(), "MM/dd/yyyy HH:mm", (Locale) null));
        f6.c.a().f((ImageView) inflate.findViewById(R.id.iv_coin_icon), f.b().c(str16), R.drawable.coin_default_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_buy_or_sell);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_coin_name);
        if (i11 == 0) {
            textView.setText(getResources().getString(R.string.n_otc_buy));
        } else {
            textView.setText(getResources().getString(R.string.n_otc_sell));
        }
        String str18 = "";
        textView2.setText(str16 == null ? str18 : str16);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_price_num);
        if (TextUtils.equals("on", str9)) {
            if (str17 == null) {
                str13 = str18;
            } else {
                str13 = str17 + " " + str15;
            }
            textView3.setText(str13);
        } else {
            if (str14 == null) {
                str12 = str18;
            } else {
                str12 = str3 + " " + str15;
            }
            textView3.setText(str12);
        }
        ((TextView) inflate.findViewById(R.id.tv_count_num)).setText(str6 + " " + str16);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_rang_num);
        StringBuilder sb2 = new StringBuilder();
        String str19 = "--";
        sb2.append(str == null ? str19 : str);
        sb2.append(" - ");
        if (str2 != null) {
            str19 = str2;
        }
        sb2.append(str19);
        sb2.append(" ");
        sb2.append(str15);
        textView4.setText(sb2.toString());
        ((TextView) inflate.findViewById(R.id.tv_payment_value)).setText(str8 == null ? str18 : str8);
        ((TextView) inflate.findViewById(R.id.tv_ad_word_content)).setText(str4 == null ? str18 : str4);
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_invite);
        if (str11 != null) {
            str18 = str11;
        }
        textView5.setText(str18);
        ((TextView) inflate.findViewById(R.id.tv_tips)).setText("*" + context.getResources().getString(R.string.n_otc_advert_code_word_tip));
        return inflate;
    }

    public String Nh() {
        return "otc_advert_publish";
    }

    /* renamed from: Ni */
    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        try {
            String str = methodCall2.method;
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1949106608) {
                if (hashCode != -1836262593) {
                    if (hashCode == -465631085) {
                        if (str.equals("shareAdvert")) {
                            c11 = 2;
                        }
                    }
                } else if (str.equals("showFundPasswordAlert")) {
                    c11 = 1;
                }
            } else if (str.equals("getInitData")) {
                c11 = 0;
            }
            if (c11 == 0) {
                MethodChannel.Result result3 = result2;
                Ji(methodCall, result);
            } else if (c11 == 1) {
                Oi(methodCall2, this.f78430l);
                result2.success((Object) null);
            } else if (c11 != 2) {
                result2.success((Object) null);
            } else {
                try {
                    Bitmap a11 = ImageUtil.a(this, Mi(this, (String) methodCall2.argument("minTradeLimit"), (String) methodCall2.argument("maxTradeLimit"), (String) methodCall2.argument("floatPrice"), (String) methodCall2.argument("codeWord"), (String) methodCall2.argument("currencyName"), (String) methodCall2.argument("tradeCount"), (String) methodCall2.argument("coinName"), (String) methodCall2.argument("paymentsString"), (String) methodCall2.argument("isFixed"), (String) methodCall2.argument("fixedPrice"), (String) methodCall2.argument("shareContentTip"), ((Integer) methodCall2.argument("tradeType")).intValue()));
                    ArrayList arrayList = new ArrayList();
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                    ShareManager.getInstance().newShareWithImages((ArrayList<Bitmap>) arrayList, true, false, "");
                } catch (Exception e11) {
                    e = e11;
                    MethodChannel.Result result4 = result;
                    e.printStackTrace();
                    result.notImplemented();
                }
                try {
                    result.success((Object) null);
                } catch (Exception e12) {
                    e = e12;
                    e.printStackTrace();
                    result.notImplemented();
                }
            }
        } catch (Exception e13) {
            e = e13;
            MethodChannel.Result result5 = result2;
            e.printStackTrace();
            result.notImplemented();
        }
    }

    public void Oi(MethodCall methodCall, MethodChannel methodChannel) {
        if (this.f78432n == null) {
            this.f78432n = new com.huobi.otc.helper.a(this, this);
        }
        this.f78432n.J(new a(methodCall, methodChannel));
        this.f78432n.M(new b());
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_advert_publish_channel");
        this.f78430l = methodChannel;
        methodChannel.setMethodCallHandler(new k(this));
        MethodChannel methodChannel2 = new MethodChannel(flutterEngine.getDartExecutor(), "otc_payment_list_channel");
        this.f78431m = methodChannel2;
        methodChannel2.setMethodCallHandler(new l(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("key_ad_id")) {
            this.f78429k = getIntent().getStringExtra("key_ad_id");
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        finish();
    }
}
