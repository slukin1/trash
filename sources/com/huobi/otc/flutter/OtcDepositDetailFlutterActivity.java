package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.huobi.finance.ui.AddAddrRiskActivity;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyRiskActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.utils.k0;
import com.luck.picture.lib.permissions.PermissionConfig;
import d7.k;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import ra.c;
import rx.Observable;
import sn.w;

public class OtcDepositDetailFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78453k;

    /* renamed from: l  reason: collision with root package name */
    public long f78454l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f78455m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f78456n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f78457o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f78458p = true;

    /* renamed from: q  reason: collision with root package name */
    public Map f78459q;

    /* renamed from: r  reason: collision with root package name */
    public int f78460r = 0;

    /* renamed from: s  reason: collision with root package name */
    public Map f78461s;

    /* renamed from: t  reason: collision with root package name */
    public Map f78462t;

    /* renamed from: u  reason: collision with root package name */
    public List<String> f78463u;

    public class a extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f78465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Security2FADialogHelper f78466c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f78467d;

        /* renamed from: com.huobi.otc.flutter.OtcDepositDetailFlutterActivity$a$a  reason: collision with other inner class name */
        public class C0836a extends TypeToken<Map<String, Object>> {
            public C0836a() {
            }
        }

        public a(MethodCall methodCall, String str, Security2FADialogHelper security2FADialogHelper, String str2) {
            this.f78464a = methodCall;
            this.f78465b = str;
            this.f78466c = security2FADialogHelper;
            this.f78467d = str2;
        }

        public void onFailed(String str) {
            if ("Dismiss".equals(str)) {
                this.f78466c.v();
            } else if ("VERIFY_SETTING_POLICY_WITHDRAW_AUTH_CODE".equals(this.f78465b)) {
                if (OtcDepositDetailFlutterActivity.this.f78463u == null) {
                    List unused = OtcDepositDetailFlutterActivity.this.f78463u = new ArrayList();
                }
                if (!OtcDepositDetailFlutterActivity.this.f78463u.contains(this.f78467d)) {
                    OtcDepositDetailFlutterActivity.this.f78463u.add(this.f78467d);
                    return;
                }
                OtcDepositDetailFlutterActivity.this.f78463u.clear();
                this.f78466c.v();
                HashMap hashMap = new HashMap();
                if (this.f78464a.argument(ShareConstants.MEDIA_EXTENSION) != null) {
                    hashMap.put(ShareConstants.MEDIA_EXTENSION, this.f78464a.argument(ShareConstants.MEDIA_EXTENSION));
                }
                OtcDepositDetailFlutterActivity.this.f78453k.invokeMethod("cancel2FACertification", hashMap);
            }
        }

        public void onManualDismiss() {
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            String str;
            Gson gson = new Gson();
            Map map = (Map) gson.fromJson(gson.toJson((Object) authResult), new C0836a().getType());
            if (this.f78464a.argument(ShareConstants.MEDIA_EXTENSION) != null) {
                map.put(ShareConstants.MEDIA_EXTENSION, this.f78464a.argument(ShareConstants.MEDIA_EXTENSION));
            }
            if ("VERIFY_SETTING_POLICY_WITHDRAW_AUTH_CODE".equals(this.f78465b)) {
                str = "callback2FADialogResultWithConfirmWithdraw";
            } else {
                str = "VERIFY_SETTING_POLICY_TWO_STAGES_WITHDRAW_ADD_ADDRESS".equals(this.f78465b) ? "callback2FADialogResultWithAddAddress" : "open2FADialogResult";
            }
            OtcDepositDetailFlutterActivity.this.f78453k.invokeMethod(str, map);
            this.f78466c.v();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oi(MethodChannel.Result result, List list) {
        String Ki = Ki(list);
        d.i("getChainsList json=" + Ki);
        result.success(Ki);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ri(String[] strArr, int i11) {
        if (i11 == 0) {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, getString(R.string.scan_text_hint));
            startActivityForResult(intent, 200);
        } else if (i11 == 2) {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public static void Ti(Context context, long j11, boolean z11, boolean z12) {
        Intent intent = new Intent(context, OtcDepositDetailFlutterActivity.class);
        intent.putExtra("key_record_id", j11);
        intent.putExtra("key_is_withdraw", z11);
        intent.putExtra("key_is_need_delete", z12);
        context.startActivity(intent);
    }

    public final String Ki(List<ChainInfo> list) {
        JSONArray parseArray = JSON.parseArray(JSON.toJSONString(list));
        for (int i11 = 0; i11 < parseArray.size(); i11++) {
            JSONObject jSONObject = parseArray.getJSONObject(i11);
            jSONObject.put("addrDepositTag", jSONObject.get("addrdepositTag"));
            jSONObject.remove("addrdepositTag");
        }
        return parseArray.toJSONString();
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        if (F == null) {
            result.success("");
        } else {
            result.success(F.getDisplayName());
        }
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        result.success(F != null ? String.valueOf(F.getSafeConfirms()) : "");
    }

    public String Nh() {
        return "dw_record_detail";
    }

    public final void Ni(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(UnifyRiskActivity.Ch(this, Long.parseLong((String) methodCall.argument("transactionId")), 1));
        result.success((Object) null);
    }

    public Observable<List<ChainInfo>> Si(String str, boolean z11) {
        return k.C().r(str, z11, AppLanguageHelper.getInstance().getCurLanguageHeader(), "1").compose(RxJavaHelper.t(this));
    }

    public final void Ui(MethodChannel.Result result, MethodCall methodCall) {
        String str = (String) methodCall.argument("type");
        String str2 = (String) methodCall.argument("withdraw_id");
        Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, str);
        security2FADialogHelper.L(true);
        security2FADialogHelper.M(true);
        HashMap hashMap = new HashMap();
        hashMap.put("use_type", str);
        HashMap hashMap2 = new HashMap();
        if (str2 != null) {
            hashMap2.put("withdraw_id", str2);
        }
        security2FADialogHelper.U(new a(methodCall, str, security2FADialogHelper, String.valueOf(System.currentTimeMillis())), hashMap2, hashMap);
        result.success((Object) null);
    }

    @AfterPermissionGranted(123)
    public void Vi() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(this, new p(this, strArr));
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "dw_record_detail_channel");
        this.f78453k = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 != -1) {
            return;
        }
        if (i11 == 1001) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("coin");
                if (stringExtra == null) {
                    stringExtra = "btc";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, stringExtra);
                hashMap.put("showDisableDeposit", Boolean.valueOf(this.f78458p));
                hashMap.put("pageFrom", Integer.valueOf(this.f78460r));
                Map map = this.f78459q;
                if (map != null) {
                    hashMap.put(ShareConstants.MEDIA_EXTENSION, map);
                }
                this.f78453k.invokeMethod("changeCurrency", hashMap);
            }
        } else if (i11 == 200) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("result_string");
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put(InnerShareParams.ADDRESS, stringExtra2);
                Map map2 = this.f78461s;
                if (map2 != null) {
                    hashMap2.put(ShareConstants.MEDIA_EXTENSION, map2);
                }
                if (this.f78457o) {
                    this.f78453k.invokeMethod("didGetAddressScanAddAddress", hashMap2);
                } else {
                    this.f78453k.invokeMethod("didGetAddress", hashMap2);
                }
            }
        } else if (i11 == 100) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("area_code", intent.getStringExtra("phone_area_code"));
            hashMap3.put("name_cn", intent.getStringExtra("country_name_cn"));
            hashMap3.put("name_en", intent.getStringExtra("country_name_en"));
            hashMap3.put("country_id", intent.getStringExtra("country_area_code"));
            hashMap3.put("flagUrl", w.e(intent.getStringExtra("country_area_code")));
            Map map3 = this.f78462t;
            if (map3 != null) {
                hashMap3.put(ShareConstants.MEDIA_EXTENSION, map3);
            }
            this.f78453k.invokeMethod("countryCodeInfoCallback", hashMap3);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78454l = getIntent().getLongExtra("key_record_id", 0);
        this.f78455m = getIntent().getBooleanExtra("key_is_withdraw", false);
        this.f78456n = getIntent().getBooleanExtra("key_is_need_delete", false);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if ("getInitData".equals(methodCall.method)) {
                HashMap hashMap = new HashMap();
                hashMap.put("key_record_id", String.valueOf(this.f78454l));
                hashMap.put("key_is_withdraw", Boolean.valueOf(this.f78455m));
                hashMap.put("key_is_need_delete", Boolean.valueOf(this.f78456n));
                result.success(hashMap);
            } else if ("openUserAsset".equals(methodCall.method)) {
                if (LiteReHelper.a().b()) {
                    c.b().k(this);
                } else {
                    rn.c.i().d(this, new JumpTarget(k0.c(this), k0.h(this)));
                }
                result.success("");
            } else if ("getSafeConfirmCount".equals(methodCall.method)) {
                Mi(methodCall, result);
            } else if ("getChainDisplayName".equals(methodCall.method)) {
                Li(methodCall, result);
            } else if ("goToVerify".equals(methodCall.method)) {
                Ni(methodCall, result);
            } else {
                boolean z11 = false;
                if ("toChangeCurrencyPage".equals(methodCall.method)) {
                    boolean booleanValue = ((Boolean) methodCall.argument("isWithdraw")).booleanValue();
                    this.f78458p = ((Boolean) methodCall.argument("showDisableDeposit")).booleanValue();
                    this.f78459q = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                    this.f78460r = 0;
                    if (methodCall.argument("pageFrom") != null) {
                        this.f78460r = ((Integer) methodCall.argument("pageFrom")).intValue();
                    }
                    if (booleanValue) {
                        CurrencySearchActivity.jj(this, "2", this.f78460r, true);
                    } else {
                        boolean z12 = this.f78458p;
                        if (z12) {
                            CurrencySearchActivity.jj(this, "1", this.f78460r, true);
                        } else {
                            CurrencySearchActivity.kj(this, "1", this.f78460r, true, z12);
                        }
                    }
                    result.success((Object) null);
                } else if ("openQR".equals(methodCall.method)) {
                    String str = (String) methodCall.argument("addAddress");
                    this.f78461s = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                    if (TextUtils.isEmpty(str) || !Boolean.parseBoolean(str)) {
                        this.f78457o = false;
                    } else {
                        this.f78457o = true;
                    }
                    Vi();
                    result.success((Object) null);
                } else if ("getChainsList".equals(methodCall.method)) {
                    String str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                    if (!((Boolean) methodCall.argument("update")).booleanValue()) {
                        z11 = true;
                    }
                    Si(str2, z11).subscribe(EasySubscriber.create(new q(this, result), new r(result), new s(result)));
                } else if ("openAddressRisk".equals(methodCall.method)) {
                    AddAddrRiskActivity.Gh(this, (String) methodCall.argument("id"));
                    result.success("");
                } else if ("open2FADialog".equals(methodCall.method)) {
                    Ui(result, methodCall);
                } else if ("getCountryCodeInfo".equals(methodCall.method)) {
                    Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
                    intent.putExtra("choose_type", "choose_type_code");
                    intent.putExtra("SHOW_COUNTRY_ICON", true);
                    intent.putExtra("SHOW_ALL_COUNTRY", true);
                    this.f78462t = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                    startActivityForResult(intent, 100);
                    result.success("");
                } else {
                    super.onMethodCall(methodCall, result);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Activity) this, getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
    }
}
