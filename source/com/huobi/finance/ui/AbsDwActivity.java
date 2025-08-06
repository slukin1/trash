package com.huobi.finance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.core.content.FileProvider;
import bh.j;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.huobi.account.ui.HelpCenterActivity;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.kyc.util.KycProxy;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.otc.flutter.OtcDepositDetailFlutterActivity;
import com.huobi.share.fragment.ImageShareFragment;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.k0;
import com.luck.picture.lib.permissions.PermissionConfig;
import dt.h2;
import i6.d;
import i6.k;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import sn.f;
import sn.w;
import tg.r;

public abstract class AbsDwActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f46213k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f46214l;

    /* renamed from: m  reason: collision with root package name */
    public Security2FADialogHelper f46215m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f46216n = true;

    /* renamed from: o  reason: collision with root package name */
    public boolean f46217o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f46218p = true;

    /* renamed from: q  reason: collision with root package name */
    public ImageShareFragment f46219q;

    /* renamed from: r  reason: collision with root package name */
    public List<String> f46220r;

    /* renamed from: s  reason: collision with root package name */
    public int f46221s = 0;

    /* renamed from: t  reason: collision with root package name */
    public Map f46222t;

    /* renamed from: u  reason: collision with root package name */
    public Map f46223u;

    /* renamed from: v  reason: collision with root package name */
    public Map f46224v;

    public class a extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f46225a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46226b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Security2FADialogHelper f46227c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46228d;

        /* renamed from: com.huobi.finance.ui.AbsDwActivity$a$a  reason: collision with other inner class name */
        public class C0571a extends TypeToken<Map<String, Object>> {
            public C0571a() {
            }
        }

        public a(MethodCall methodCall, String str, Security2FADialogHelper security2FADialogHelper, String str2) {
            this.f46225a = methodCall;
            this.f46226b = str;
            this.f46227c = security2FADialogHelper;
            this.f46228d = str2;
        }

        public void onFailed(String str) {
            if (AbsDwActivity.this.f46220r == null) {
                List unused = AbsDwActivity.this.f46220r = new ArrayList();
            }
            if (!AbsDwActivity.this.f46220r.contains(this.f46228d)) {
                AbsDwActivity.this.f46220r.add(this.f46228d);
                return;
            }
            AbsDwActivity.this.f46220r.clear();
            this.f46227c.v();
            onManualDismiss();
        }

        public void onManualDismiss() {
            HashMap hashMap = new HashMap();
            if (this.f46225a.argument(ShareConstants.MEDIA_EXTENSION) != null) {
                hashMap.put(ShareConstants.MEDIA_EXTENSION, this.f46225a.argument(ShareConstants.MEDIA_EXTENSION));
            }
            AbsDwActivity.this.f46214l.invokeMethod("cancel2FACertification", hashMap);
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            String str;
            Gson gson = new Gson();
            Map map = (Map) gson.fromJson(gson.toJson((Object) authResult), new C0571a().getType());
            if (this.f46225a.argument(ShareConstants.MEDIA_EXTENSION) != null) {
                map.put(ShareConstants.MEDIA_EXTENSION, this.f46225a.argument(ShareConstants.MEDIA_EXTENSION));
            }
            if ("VERIFY_SETTING_POLICY_WITHDRAW_AUTH_CODE".equals(this.f46226b)) {
                str = "callback2FADialogResultWithConfirmWithdraw";
            } else {
                str = "VERIFY_SETTING_POLICY_TWO_STAGES_WITHDRAW_ADD_ADDRESS".equals(this.f46226b) ? "callback2FADialogResultWithAddAddress" : "open2FADialogResult";
            }
            AbsDwActivity.this.f46214l.invokeMethod(str, map);
            this.f46227c.v();
        }
    }

    public class b extends Security2FADialogHelper.Callback {
        public b() {
        }

        public void onFailed(String str) {
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            AbsDwActivity.this.f46214l.invokeMethod("openVerifyDialogResult", new Gson().toJson((Object) authResult));
        }
    }

    public class c implements Func1<Bitmap, Bitmap> {
        public c() {
        }

        /* renamed from: a */
        public Bitmap call(Bitmap bitmap) {
            AbsDwActivity.this.vj(bitmap);
            bitmap.recycle();
            return bitmap;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(MethodChannel.Result result, List list) {
        String Wi = Wi(list);
        d.i("getChainsList json=" + Wi);
        result.success(Wi);
    }

    /* JADX INFO: finally extract failed */
    public static /* synthetic */ androidx.core.util.c kj(Bitmap bitmap) {
        String str;
        float height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
            File f11 = FileUtil.f(compressFormat.name(), false);
            ImageUtils.h(bitmap, compressFormat, f11);
            if (Build.VERSION.SDK_INT >= 24) {
                str = FileProvider.getUriForFile(j.c(), "pro.huobi.fileprovider", f11).toString();
            } else {
                str = Uri.fromFile(f11).toString();
            }
            bitmap.recycle();
        } catch (Exception e11) {
            d.g(e11);
            bitmap.recycle();
            str = null;
        } catch (Throwable th2) {
            bitmap.recycle();
            throw th2;
        }
        return new androidx.core.util.c(str, Float.valueOf(height));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lj(MethodChannel.Result result, androidx.core.util.c cVar) {
        F f11;
        if (!(cVar == null || (f11 = cVar.f8468a) == null || cVar.f8469b == null)) {
            this.f46219q.ci((String) f11);
            this.f46219q.bi(((Float) cVar.f8469b).floatValue());
            this.f46219q.Qh("Deposit");
            this.f46219q.show(getSupportFragmentManager(), "deposit_share[31]");
        }
        result.success((Object) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oj(String[] strArr, int i11) {
        if (i11 == 0) {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, getString(R.string.scan_text_hint));
            startActivityForResult(intent, 200);
        } else if (i11 == 2) {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    private void ri(MethodCall methodCall, MethodChannel.Result result) {
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        flutterKycConfig.setPhone(r.x().F());
        flutterKycConfig.setEmail(r.x().u());
        String str = (String) methodCall.argument("authBizCode");
        if (!TextUtils.isEmpty(str)) {
            flutterKycConfig.setAuthBizCode(str);
        }
        k.o("withdrawKyc", "开启新Kyc页面 authBizCode:" + str);
        b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
        result.success((Object) null);
    }

    public final String Wi(List<ChainInfo> list) {
        JSONArray parseArray = JSON.parseArray(JSON.toJSONString(list));
        for (int i11 = 0; i11 < parseArray.size(); i11++) {
            JSONObject jSONObject = parseArray.getJSONObject(i11);
            jSONObject.put("addrDepositTag", jSONObject.get("addrdepositTag"));
            jSONObject.remove("addrdepositTag");
        }
        return parseArray.toJSONString();
    }

    public final void Xi(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        if (TextUtils.isEmpty(str)) {
            result.success((Object) null);
            return;
        }
        Observable<R> compose = h2.t1().v3(TradeType.PRO, false).map(new e(str)).compose(RxJavaHelper.t(this));
        Objects.requireNonNull(result);
        compose.subscribe((Subscriber<? super R>) SilentSubscriber.b(new p(result), new l(result), new b(result)));
    }

    public final void Yi(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(UnifyRiskActivity.Ch(this, Long.parseLong((String) methodCall.argument("transactionId")), 0));
        result.success((Object) null);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "dw_channel");
        this.f46214l = methodChannel;
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
                hashMap.put("showDisableDeposit", Boolean.valueOf(this.f46218p));
                hashMap.put("pageFrom", Integer.valueOf(this.f46221s));
                Map map = this.f46222t;
                if (map != null) {
                    hashMap.put(ShareConstants.MEDIA_EXTENSION, map);
                }
                this.f46214l.invokeMethod("changeCurrency", hashMap);
            }
        } else if (i11 == 200) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("result_string");
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put(InnerShareParams.ADDRESS, stringExtra2);
                Map map2 = this.f46223u;
                if (map2 != null) {
                    hashMap2.put(ShareConstants.MEDIA_EXTENSION, map2);
                }
                if (this.f46217o) {
                    this.f46214l.invokeMethod("didGetAddressScanAddAddress", hashMap2);
                } else {
                    this.f46214l.invokeMethod("didGetAddress", hashMap2);
                }
            }
        } else if (i11 == 100) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("area_code", intent.getStringExtra("phone_area_code"));
            hashMap3.put("name_cn", intent.getStringExtra("country_name_cn"));
            hashMap3.put("name_en", intent.getStringExtra("country_name_en"));
            hashMap3.put("country_id", intent.getStringExtra("country_area_code"));
            hashMap3.put("flagUrl", w.e(intent.getStringExtra("country_area_code")));
            Map map3 = this.f46224v;
            if (map3 != null) {
                hashMap3.put(ShareConstants.MEDIA_EXTENSION, map3);
            }
            this.f46214l.invokeMethod("countryCodeInfoCallback", hashMap3);
        }
    }

    public void onBackPressed() {
        if (this.f46216n) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable) null);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f46213k = "btc";
        if (intent != null) {
            this.f46213k = intent.getStringExtra("coin");
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            d.c("AbsDwActivity", "onMethodCall method=" + str);
            if ("initDepositChannel".equals(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(FirebaseAnalytics.Param.CURRENCY, this.f46213k);
                result.success(jSONObject.toString());
            } else if ("saveQrScreenshot".equals(str)) {
                tj(methodCall, result);
            } else if ("shareQrScreenshot".equals(str)) {
                uj(methodCall, result);
            } else if ("initWithdrawChannel".equals(str)) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(FirebaseAnalytics.Param.CURRENCY, this.f46213k);
                result.success(jSONObject2.toString());
            } else {
                boolean z11 = false;
                if ("toChangeCurrencyPage".equals(str)) {
                    boolean booleanValue = ((Boolean) methodCall.argument("isWithdraw")).booleanValue();
                    this.f46218p = ((Boolean) methodCall.argument("showDisableDeposit")).booleanValue();
                    this.f46222t = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                    this.f46221s = 0;
                    if (methodCall.argument("pageFrom") != null) {
                        this.f46221s = ((Integer) methodCall.argument("pageFrom")).intValue();
                    }
                    if (booleanValue) {
                        CurrencySearchActivity.jj(this, "2", this.f46221s, true);
                    } else {
                        boolean z12 = this.f46218p;
                        if (z12) {
                            CurrencySearchActivity.jj(this, "1", this.f46221s, true);
                        } else {
                            CurrencySearchActivity.kj(this, "1", this.f46221s, true, z12);
                        }
                    }
                    result.success((Object) null);
                } else if ("getChainsList".equals(str)) {
                    String str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                    if (!((Boolean) methodCall.argument("update")).booleanValue()) {
                        z11 = true;
                    }
                    pj(str2, z11).subscribe(EasySubscriber.create(new j(this, result), new m(result), new c(result)));
                } else if ("gotoDwRecordPage".equals(str)) {
                    DwRecordActivity.Ji(this, ((Integer) methodCall.argument("pageType")).intValue());
                    result.success((Object) null);
                } else if ("getCurrencyFiat".equals(str)) {
                    result.success(LegalCurrencyConfigUtil.E((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), "1"));
                } else {
                    String str3 = "";
                    if ("getFiatCurrencyPrice".equals(str)) {
                        String str4 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                        String str5 = (String) methodCall.argument("faitCurrency");
                        if (!TextUtils.isEmpty("faitCurrency")) {
                            str3 = str5;
                        }
                        result.success(LegalCurrencyConfigUtil.F(str4, str3, "1"));
                    } else if ("getUserRealNameState".equals(str)) {
                        int p11 = KycProxy.l().p();
                        if (p11 == 2) {
                            z11 = true;
                        } else if (p11 != 1) {
                            z11 = true;
                        }
                        result.success(Integer.valueOf(z11 ? 1 : 0));
                    } else if ("openAddressRisk".equals(str)) {
                        AddAddrRiskActivity.Gh(this, (String) methodCall.argument("id"));
                        result.success(str3);
                    } else if ("openOfficialVerify".equals(str)) {
                        f.Z(this);
                        result.success(str3);
                    } else if ("openHelpCenter".equals(str)) {
                        startActivity(new Intent(this, HelpCenterActivity.class));
                        result.success(str3);
                    } else if ("getCurrencyBalance".equals(str)) {
                        Xi(methodCall, result);
                    } else if ("openUserAsset".equals(str)) {
                        if (LiteReHelper.a().b()) {
                            ra.c.b().k(this);
                        } else {
                            rn.c.i().d(this, new JumpTarget(k0.c(this), k0.h(this)));
                        }
                        result.success(str3);
                    } else if ("openQR".equals(str)) {
                        String str6 = (String) methodCall.argument("addAddress");
                        this.f46223u = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                        if (TextUtils.isEmpty(str6) || !Boolean.parseBoolean(str6)) {
                            this.f46217o = false;
                        } else {
                            this.f46217o = true;
                        }
                        wj();
                        result.success((Object) null);
                    } else if ("goToVerify".equals(str)) {
                        Yi(methodCall, result);
                        finish();
                    } else if ("openVerifyDialog".equals(str)) {
                        rj(result);
                    } else if ("open2FADialog".equals(str)) {
                        qj(result, methodCall);
                    } else if ("closeVerifyDialog".equals(str)) {
                        Security2FADialogHelper security2FADialogHelper = this.f46215m;
                        if (security2FADialogHelper != null) {
                            security2FADialogHelper.v();
                        }
                        result.success((Object) null);
                    } else if ("setBackUnable".equals(str)) {
                        this.f46216n = false;
                        result.success((Object) null);
                    } else if ("openWithdrawProtocolRisk".equals(str)) {
                        f.j0(this);
                        result.success((Object) null);
                    } else if ("openWithdrawProtocolMore".equals(str)) {
                        f.k0(this);
                        result.success((Object) null);
                    } else if ("openKyc".equals(str)) {
                        ri(methodCall, result);
                        result.success((Object) null);
                    } else if ("getCountryCodeInfo".equals(str)) {
                        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
                        intent.putExtra("choose_type", "choose_type_code");
                        intent.putExtra("SHOW_COUNTRY_ICON", true);
                        intent.putExtra("SHOW_ALL_COUNTRY", true);
                        this.f46224v = (Map) methodCall.argument(ShareConstants.MEDIA_EXTENSION);
                        startActivityForResult(intent, 100);
                        result.success(str3);
                    } else if ("gotoRecordDetailPage".equals(str)) {
                        Map map = (Map) methodCall.arguments;
                        String str7 = (String) map.get("key_record_id");
                        boolean booleanValue2 = ((Boolean) map.get("key_is_withdraw")).booleanValue();
                        if (booleanValue2) {
                            oa.a.g().e(CurrencySearchActivity.class);
                        }
                        OtcDepositDetailFlutterActivity.Ti(this, Long.valueOf(str7).longValue(), booleanValue2, false);
                        result.success((Object) null);
                    } else {
                        super.onMethodCall(methodCall, result);
                    }
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
        Intent h11 = k0.h(this);
        rn.c.i().m(this, new JumpTarget(h11, h11));
    }

    public Observable<List<ChainInfo>> pj(String str, boolean z11) {
        return d7.k.C().r(str, z11, AppLanguageHelper.getInstance().getCurLanguageHeader(), "1").compose(RxJavaHelper.t(this));
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }

    public final void qj(MethodChannel.Result result, MethodCall methodCall) {
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

    public final void rj(MethodChannel.Result result) {
        Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, "VERIFY_SETTING_POLICY_WITHDRAW_ADD_ADDRESS");
        this.f46215m = security2FADialogHelper;
        security2FADialogHelper.L(true);
        this.f46215m.M(true);
        this.f46215m.R(new b());
        result.success((Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b A[SYNTHETIC, Splitter:B:26:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A[SYNTHETIC, Splitter:B:31:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sj(android.content.Context r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = android.os.Environment.DIRECTORY_DCIM
            java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r1 = "Camera"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x002a
            r1.mkdir()
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Huobi_Deposit_"
            r0.append(r2)
            d7.k r2 = d7.k.C()
            java.lang.String r3 = r4.f46213k
            java.lang.String r2 = r2.z(r3)
            r0.append(r2)
            java.lang.String r2 = "_"
            r0.append(r2)
            long r2 = com.hbg.lib.common.utils.DateTimeUtils.v()
            r0.append(r2)
            java.lang.String r2 = ".jpg"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1, r0)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0095 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0095 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r3 = 60
            boolean r6 = r6.compress(r0, r3, r1)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r1.flush()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r1.close()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            android.net.Uri r0 = android.net.Uri.fromFile(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            r5.sendBroadcast(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
            if (r6 == 0) goto L_0x0089
            r5 = 1
            r1.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0088:
            return r5
        L_0x0089:
            r1.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x008d:
            r5 = move-exception
            r0 = r1
            goto L_0x00a5
        L_0x0090:
            r5 = move-exception
            r0 = r1
            goto L_0x0096
        L_0x0093:
            r5 = move-exception
            goto L_0x00a5
        L_0x0095:
            r5 = move-exception
        L_0x0096:
            r5.printStackTrace()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x00a3
            r0.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a3:
            r5 = 0
            return r5
        L_0x00a5:
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00af:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.AbsDwActivity.sj(android.content.Context, android.graphics.Bitmap):boolean");
    }

    public final void tj(MethodCall methodCall, MethodChannel.Result result) {
        byte[] bArr = (byte[]) methodCall.argument("imgBytes");
        Observable.just(bArr).map(new g(bArr)).map(new c()).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(new k(result), new o(result), new q(result)));
    }

    public final void uj(MethodCall methodCall, MethodChannel.Result result) {
        if (this.f46219q == null) {
            this.f46219q = new ImageShareFragment();
        }
        if (this.f46219q.isVisible()) {
            this.f46219q.dismiss();
        }
        if (this.f46219q.Fh() != null && !this.f46219q.Fh().isUnsubscribed()) {
            this.f46219q.Fh().unsubscribe();
        }
        byte[] bArr = (byte[]) methodCall.argument("imgBytes");
        this.f46219q.Ph(Observable.just(bArr).map(new f(bArr)).map(h.f47145b).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(new i(this, result), new n(result), new d(result))));
    }

    @AfterPermissionGranted(126)
    public void vj(Bitmap bitmap) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            sj(this, bitmap);
            HuobiToastUtil.t(this, R.string.currency_deposit_saved);
            return;
        }
        EasyPermissions.requestPermissions(this, 126, str);
    }

    @AfterPermissionGranted(123)
    public void wj() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(this, new a(this, strArr));
    }
}
