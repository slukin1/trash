package com.huobi.flutter.base;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.Constants;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.NullResponseException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.coupon.bean.Coupon;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.flutter.Flutter2FAVerifyTool;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.kyc.bean.PhpLogin;
import com.huobi.kyc.service.KycService;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.otc.helper.OtcImageVideoInfo;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import com.huochat.community.util.ImageUtil;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.android.tpush.common.Constants;
import d7.a1;
import i6.m;
import io.flutter.embedding.android.FlutterFragmentActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import pro.huobi.R;
import qiu.niorgai.StatusBarCompat;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;
import tg.r;
import tq.p;
import z9.g1;

public abstract class AbsGlobalFlutterActivity extends FlutterFragmentActivity implements u6.g, EasyPermissions.PermissionCallbacks, MethodChannel.MethodCallHandler {

    /* renamed from: b  reason: collision with root package name */
    public BehaviorSubject<Integer> f67685b = BehaviorSubject.create();

    /* renamed from: c  reason: collision with root package name */
    public g1 f67686c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67687d;

    /* renamed from: e  reason: collision with root package name */
    public FlutterEngine f67688e;

    /* renamed from: f  reason: collision with root package name */
    public MethodChannel.Result f67689f;

    /* renamed from: g  reason: collision with root package name */
    public MethodCall f67690g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67691h;

    /* renamed from: i  reason: collision with root package name */
    public Flutter2FAVerifyTool f67692i = new Flutter2FAVerifyTool();

    /* renamed from: j  reason: collision with root package name */
    public MethodChannel f67693j;

    public class a extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67694b;

        public a(MethodChannel.Result result) {
            this.f67694b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            this.f67694b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67694b.error("flutter get otc token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class b extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67696b;

        public b(MethodChannel.Result result) {
            this.f67696b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            r.x().r0(str);
            this.f67696b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67696b.error("flutter get kyc token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class c extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67698b;

        public c(MethodChannel.Result result) {
            this.f67698b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            r.x().o0(str);
            this.f67698b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67698b.error("flutter get inst token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class d implements MethodChannel.MethodCallHandler {
        public d() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            AbsGlobalFlutterActivity.this.qi(methodCall, result);
        }
    }

    public class e extends BaseSubscriber<Map<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67701b;

        public e(MethodChannel.Result result) {
            this.f67701b = result;
        }

        /* renamed from: a */
        public void onNext(Map<String, String> map) {
            super.onNext(map);
            this.f67701b.success(map);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f67701b.success((Object) null);
        }
    }

    public class f extends CustomTarget<File> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f67703b = false;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67704c;

        public f(MethodChannel.Result result) {
            this.f67704c = result;
        }

        /* renamed from: a */
        public void onResourceReady(File file, com.bumptech.glide.request.transition.a<? super File> aVar) {
            if (!this.f67703b) {
                this.f67703b = true;
                if (file == null || !file.exists()) {
                    this.f67704c.success((Object) null);
                } else {
                    this.f67704c.success(file.getAbsolutePath());
                }
            }
        }

        public void onLoadCleared(Drawable drawable) {
        }

        public void onLoadFailed(Drawable drawable) {
            if (!this.f67703b) {
                this.f67703b = true;
                this.f67704c.success((Object) null);
            }
        }
    }

    public class g implements com.bumptech.glide.request.e<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f67706c;

        public g(MethodChannel.Result result, String str) {
            this.f67705b = result;
            this.f67706c = str;
        }

        /* renamed from: a */
        public boolean onResourceReady(Bitmap bitmap, Object obj, c4.g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            i6.d.j("getVideoCoverImagePath", "onResourceReady----onResourceReady>");
            if (bitmap != null) {
                StringBuilder sb2 = new StringBuilder();
                String str = this.f67706c;
                sb2.append(str.substring(str.lastIndexOf("/") + 1, this.f67706c.lastIndexOf(InstructionFileId.DOT)));
                sb2.append(PictureMimeType.JPG);
                String savePicturetoLocal = ImageUtil.savePicturetoLocal(bitmap, pa.d.o().j(AbsGlobalFlutterActivity.this, sb2.toString()).getPath());
                i6.d.j("getVideoCoverImagePath", "onResourceReady---->" + savePicturetoLocal);
                this.f67705b.success(savePicturetoLocal);
                return false;
            }
            this.f67705b.success((Object) null);
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, c4.g<Bitmap> gVar, boolean z11) {
            i6.d.j("getVideoCoverImagePath", "onLoadFailed---->" + glideException.getMessage());
            this.f67705b.success((Object) null);
            return false;
        }
    }

    public class h implements pa.a {

        public class a extends EasySubscriber<LinkedHashMap<File, Boolean>> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(LinkedHashMap<File, Boolean> linkedHashMap) {
                super.onNext(linkedHashMap);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry next : linkedHashMap.entrySet()) {
                    OtcImageVideoInfo otcImageVideoInfo = new OtcImageVideoInfo();
                    arrayList.add(otcImageVideoInfo);
                    otcImageVideoInfo.setFilePath(((File) next.getKey()).getPath());
                    otcImageVideoInfo.setImage(((Boolean) next.getValue()).booleanValue());
                }
                String json = GsonHelper.a().toJson((Object) arrayList);
                if (AbsGlobalFlutterActivity.this.f67689f != null && AbsGlobalFlutterActivity.this.f67690g != null && "pickImageAndVideo".equals(AbsGlobalFlutterActivity.this.f67690g.method)) {
                    AbsGlobalFlutterActivity.this.f67689f.success(json);
                }
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                AbsGlobalFlutterActivity.this.f67689f.success((Object) null);
            }
        }

        public class b implements Func1<Pair<LinkedHashMap<String, Boolean>, String[]>, LinkedHashMap<File, Boolean>> {
            public b() {
            }

            /* renamed from: a */
            public LinkedHashMap<File, Boolean> call(Pair<LinkedHashMap<String, Boolean>, String[]> pair) {
                File file;
                Set<Map.Entry> entrySet = ((LinkedHashMap) pair.first).entrySet();
                String[] strArr = (String[]) pair.second;
                LinkedHashMap<File, Boolean> linkedHashMap = new LinkedHashMap<>();
                int i11 = 0;
                for (Map.Entry entry : entrySet) {
                    Boolean bool = (Boolean) entry.getValue();
                    Uri parse = Uri.parse((String) entry.getKey());
                    String str = strArr[i11];
                    if (!bool.booleanValue()) {
                        pa.d.o().i(AbsGlobalFlutterActivity.this, parse, pa.d.o().j(AbsGlobalFlutterActivity.this, str));
                    } else if (!"file".equals(parse.getScheme())) {
                        pa.d.o().i(AbsGlobalFlutterActivity.this, parse, pa.d.o().j(AbsGlobalFlutterActivity.this, str));
                    }
                    if (!bool.booleanValue()) {
                        file = new File(Uri.fromFile(pa.d.o().j(AbsGlobalFlutterActivity.this, str)).getPath());
                    } else if (!"file".equals(parse.getScheme())) {
                        file = ImageUtils.f(AbsGlobalFlutterActivity.this, Uri.fromFile(pa.d.o().j(AbsGlobalFlutterActivity.this, str)).getPath(), 1.0d);
                    } else {
                        file = ImageUtils.f(AbsGlobalFlutterActivity.this, Uri.fromFile(new File(parse.getPath())).getPath(), 1.0d);
                    }
                    linkedHashMap.put(file, bool);
                    i11++;
                }
                return linkedHashMap;
            }
        }

        public class c extends EasySubscriber<File> {
            public c() {
            }

            /* renamed from: a */
            public void onNext(File file) {
                super.onNext(file);
                ArrayList arrayList = new ArrayList();
                OtcImageVideoInfo otcImageVideoInfo = new OtcImageVideoInfo();
                arrayList.add(otcImageVideoInfo);
                otcImageVideoInfo.setFilePath(file.getPath());
                otcImageVideoInfo.setImage(true);
                String json = GsonHelper.a().toJson((Object) arrayList);
                if (AbsGlobalFlutterActivity.this.f67689f != null && AbsGlobalFlutterActivity.this.f67690g != null && "pickImageAndVideo".equals(AbsGlobalFlutterActivity.this.f67690g.method)) {
                    AbsGlobalFlutterActivity.this.f67689f.success(json);
                }
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                AbsGlobalFlutterActivity.this.f67689f.success("");
            }
        }

        public class d implements Func1<String, File> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Uri f67712b;

            public d(Uri uri) {
                this.f67712b = uri;
            }

            /* renamed from: a */
            public File call(String str) {
                return ImageUtils.f(AbsGlobalFlutterActivity.this, this.f67712b.getPath(), 5.0d);
            }
        }

        public h() {
        }

        public void a(Uri uri, String str, boolean z11) {
            Observable.just("").map(new d(uri)).compose(RxJavaHelper.t(AbsGlobalFlutterActivity.this)).subscribe(new c());
        }

        public void b(String str) {
            if (AbsGlobalFlutterActivity.this.f67689f != null) {
                AbsGlobalFlutterActivity.this.f67689f.success((Object) null);
            }
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
            Observable.just(new Pair(linkedHashMap, strArr)).map(new b()).compose(RxJavaHelper.t(AbsGlobalFlutterActivity.this)).subscribe(new a());
        }

        public void onCancel() {
            if (AbsGlobalFlutterActivity.this.f67689f != null) {
                AbsGlobalFlutterActivity.this.f67689f.success((Object) null);
            }
        }
    }

    public class i implements pa.a {

        public class a extends EasySubscriber<File> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(File file) {
                super.onNext(file);
                AbsGlobalFlutterActivity.this.f67689f.success(file.getAbsolutePath());
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                AbsGlobalFlutterActivity.this.f67689f.success("");
            }
        }

        public class b implements Func1<String, File> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Uri f67716b;

            public b(Uri uri) {
                this.f67716b = uri;
            }

            /* renamed from: a */
            public File call(String str) {
                return ImageUtils.f(AbsGlobalFlutterActivity.this, this.f67716b.getPath(), 5.0d);
            }
        }

        public i() {
        }

        public void a(Uri uri, String str, boolean z11) {
            if (AbsGlobalFlutterActivity.this.f67689f != null) {
                Observable.just("").map(new b(uri)).compose(RxJavaHelper.t(AbsGlobalFlutterActivity.this)).subscribe(new a());
            }
        }

        public void b(String str) {
            if (AbsGlobalFlutterActivity.this.f67689f != null) {
                AbsGlobalFlutterActivity.this.f67689f.success("");
            }
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
        }

        public void onCancel() {
            if (AbsGlobalFlutterActivity.this.f67689f != null) {
                AbsGlobalFlutterActivity.this.f67689f.success("");
            }
        }
    }

    public class j extends BaseSubscriber<ProUserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67718b;

        public j(MethodChannel.Result result) {
            this.f67718b = result;
        }

        /* renamed from: a */
        public void onNext(ProUserToken proUserToken) {
            super.onNext(proUserToken);
            r.x().v0(proUserToken.getToken());
            this.f67718b.success(proUserToken.getToken());
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
            try {
                this.f67718b.error("512", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class k extends BaseSubscriber<ContractUserInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67720b;

        public k(MethodChannel.Result result) {
            this.f67720b = result;
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo contractUserInfo) {
            super.onNext(contractUserInfo);
            if (contractUserInfo == null || contractUserInfo.getUser() == null) {
                this.f67720b.error("flutter get dm token error 1", "", "");
                return;
            }
            ContractUserInfoProvider.i().z(contractUserInfo.getUser());
            r.x().k0(contractUserInfo.getHbsession());
            this.f67720b.success(contractUserInfo.getHbsession());
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67720b.error("flutter get dm token error 2", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class l extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67722b;

        public l(MethodChannel.Result result) {
            this.f67722b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            this.f67722b.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67722b.error("flutter get php token error", th2.getMessage(), th2.getMessage());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Observable Vh(LoginInfoData loginInfoData) {
        if (loginInfoData == null || TextUtils.isEmpty(loginInfoData.getTicket())) {
            return Observable.error(new RuntimeException("flutter get dm token error 1"));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((ContractService) p.p(ContractService.class)).login(hashMap).compose(ContractRetrofit.h());
    }

    public static /* synthetic */ Observable Yh(LoginInfoData loginInfoData) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("type", "PRO_APP");
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return s8.a.a().getTicket(hashMap).b();
    }

    public static /* synthetic */ Observable Zh(String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.error(new NullResponseException());
        }
        r.x().t0(str);
        return Observable.just(str);
    }

    public static /* synthetic */ Observable ai(LoginInfoData loginInfoData) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("method", FirebaseAnalytics.Event.LOGIN);
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((KycService) p.V(KycService.class)).ucLogin(hashMap).compose(p.a0());
    }

    public static /* synthetic */ Observable bi(PhpLogin phpLogin) {
        if (phpLogin == null || TextUtils.isEmpty(phpLogin.getToken())) {
            return Observable.error(new NullResponseException());
        }
        r.x().u0(phpLogin.getToken());
        return Observable.just(phpLogin.getToken());
    }

    public static /* synthetic */ Map di(Integer num, UserVO userVO) {
        HashMap hashMap = new HashMap();
        hashMap.put("identityLevel", String.valueOf(userVO.getRealBind()));
        hashMap.put(UserDataStore.COUNTRY, String.valueOf(num));
        hashMap.put("registerTime", String.valueOf(userVO.getGmtRegister()));
        return hashMap;
    }

    public static /* synthetic */ void ei(MethodCall methodCall, MethodChannel.Result result, Map map) {
        String G = LegalCurrencyConfigUtil.G((String) methodCall.argument("amount"), (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), TradeType.PRO);
        i6.d.d("currencyEquivalent" + G);
        result.success(G);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(Intent intent) {
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ii(MethodChannel.Result result, Object obj) {
        result.success(Boolean.TRUE);
        HuobiToastUtil.v(getString(R.string.market_add_collection_success));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(MethodChannel.Result result, Object obj) {
        result.success(Boolean.TRUE);
        HuobiToastUtil.v(getString(R.string.market_delete_collection_success));
    }

    public static /* synthetic */ void oi(FragmentActivity fragmentActivity, String str, HBDialogFragment hBDialogFragment) {
        ((ClipboardManager) fragmentActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
        HuobiToastUtil.t(fragmentActivity, R.string.currency_deposit_copied);
    }

    public static void xi(Context context, MethodCall methodCall, MethodChannel.Result result) {
        com.bumptech.glide.a.v(context).h().M0((String) methodCall.argument("url")).A0(new f(result));
    }

    public static void zi(FragmentActivity fragmentActivity) {
        String e11 = o.e();
        new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getResources().getString(R.string.advance_identification_to_pc)).C0(e11).D0(Integer.valueOf(ContextCompat.getColor(fragmentActivity, R.color.global_jump_btn_color))).i1(1).M0(Integer.valueOf(R.drawable.otc_tips_toweb)).P0(fragmentActivity.getResources().getString(R.string.advance_identification_to_pc_url_copy)).Q0(new dl.a(fragmentActivity, e11)).N0(ad.b.f3517a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    @AfterPermissionGranted(123)
    public void Ah() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(this, strArr)) {
            pa.d.o().B(false).q(this);
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public final void Ai(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("type");
        this.f67689f = result;
        if ("0".equals(str)) {
            vi();
        } else if ("1".equals(str)) {
            Ah();
        } else {
            vi();
        }
    }

    public final String Bh(MethodCall methodCall) {
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

    public final void Bi(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
        if (methodCall.hasArgument("symbol")) {
            String str = (String) methodCall.argument("symbol");
            if (!TextUtils.isEmpty(str)) {
                k0.O(this, str, true);
            } else {
                startActivity(k0.t(this, false));
            }
        }
    }

    public final void Ch(MethodCall methodCall, MethodChannel.Result result) {
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

    public void Ci(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        r.x().m("Flutter UCToken Interceptor#tokenFailed - ", false);
        EventBus.d().k(new mo.a("512", "Flutter UcToken Error"));
        EventBus.d().k(new p6.a("512", "Flutter UcToken Error"));
        i6.k.f("LOGIN", "UC-TOKEN token Failed ");
        if (methodCall.hasArgument("message") && (str = (String) methodCall.argument("message")) != null && !TextUtils.isEmpty(str)) {
            HuobiToastUtil.l(bh.j.c(), str);
        }
        result.success((Object) null);
    }

    public final void Dh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.b((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY))));
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Eh(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(dl.i.f53812b).compose(RxJavaHelper.t((u6.g) null)).subscribe(new k(result));
    }

    public final void Fh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.B((String) methodCall.argument("symbol"), true)));
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Gh(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getInstTicket").compose(p.c0()).flatMap(dl.d.f53807b).retry(3).compose(RxJavaHelper.t((u6.g) null)).subscribe(new c(result));
    }

    public final void Hh(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getKycTicket").compose(p.c0()).flatMap(dl.e.f53808b).retry(3).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b(result));
    }

    public final void Ih(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getOTCTicket").compose(p.c0()).flatMap(dl.f.f53809b).flatMap(dl.j.f53813b).retry(3).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(result));
    }

    public final void Jh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("symbol")) {
                String str = (String) methodCall.argument("symbol");
                if (a1.v().J(str, TradeType.PRO) == null) {
                    int i11 = 2;
                    TradeType a11 = FutureTypeUtil.a("", str, "");
                    if (a11 == TradeType.CONTRACT) {
                        i11 = ej.f.q(str);
                    } else if (a11 == TradeType.SWAP) {
                        i11 = us.i.w(str);
                    } else if (a11 == TradeType.LINEAR_SWAP) {
                        i11 = FuturePrecisionUtil.A("", str, "");
                    }
                    result.success(Integer.valueOf(i11));
                    return;
                }
                result.success(Integer.valueOf(PrecisionUtil.A(str)));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Kh(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("AbsGlobalFlutterActivity#getPHPTicket").compose(p.c0()).flatMap(dl.g.f53810b).flatMap(dl.c.f53806b).retry(3).compose(RxJavaHelper.t((u6.g) null)).subscribe(new l(result));
    }

    public final void Lh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("num")) {
                result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.c((String) null)));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public void Mh(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(dl.h.f53811b).compose(RxJavaHelper.t(this)).subscribe(new j(result));
    }

    public abstract String Nh();

    public final void Oh(MethodCall methodCall, MethodChannel.Result result) {
        result.success(a1.v().I(StringUtils.i((String) methodCall.arguments), TradeType.PRO));
    }

    public final void Ph(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.z((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Qh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.A((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Rh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("num") || !methodCall.hasArgument("symbol")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            result.success(m.m((String) methodCall.argument("num"), PrecisionUtil.y((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Sh(String str, MethodChannel.Result result) {
        if (!TextUtils.isEmpty(str)) {
            ((com.bumptech.glide.c) ((com.bumptech.glide.c) com.bumptech.glide.a.y(this).v((RequestOptions) ((RequestOptions) new RequestOptions().p(1000000)).d()).b().J0(new File(str)).d()).h(DiskCacheStrategy.f63712d)).G0(new g(result, str)).P0();
        }
    }

    public final void Th(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("num")) {
                result.success(LegalCurrencyConfigUtil.L(m.a((String) methodCall.argument("num"))));
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public void Uh() {
        if (BaseModuleConfig.a().n()) {
            BaseModuleConfig.a().G(this, "total_balance_type_balance");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("total_balance_type", "total_balance_type_balance");
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ra.c.b().b(this, intent, "balance", false);
    }

    public boolean altFocusableIM() {
        return false;
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i11 = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i11;
        }
        super.applyOverrideConfiguration(configuration);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public boolean canFullScreen() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public void changeStatusBarTextColor(boolean z11) {
        if (Build.VERSION.SDK_INT <= 23) {
            return;
        }
        if (z11) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        i6.d.j("flutter", "configureFlutterEngine");
        new MethodChannel(flutterEngine.getDartExecutor(), Constants.MessageTypes.SEND_EVENT).setMethodCallHandler(this);
        new MethodChannel(flutterEngine.getDartExecutor(), "request_token").setMethodCallHandler(this);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "platform_message_channel");
        this.f67693j = methodChannel;
        methodChannel.setMethodCallHandler(new d());
    }

    public void dismissProgressDialog() {
        g1 g1Var = this.f67686c;
        if (g1Var != null) {
            g1Var.dismiss();
        }
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.f67685b;
    }

    public void initStatus() {
        if (!canFullScreen()) {
            return;
        }
        if (useNewStatusBarFunc()) {
            StatusBarCompat.d(this, true);
            StatusBarCompat.a(this);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            if (isLightStatusBar()) {
                StatusBarCompat.a(this);
            } else {
                StatusBarCompat.b(this);
            }
        } else {
            getWindow().addFlags(67108864);
            changeStatusBarTextColor(!isLightStatusBar());
        }
    }

    public boolean isAlive() {
        return this.f67687d && !isFinishing();
    }

    @Deprecated
    public boolean isCanBeSeen() {
        return false;
    }

    public boolean isLightStatusBar() {
        return NightHelper.e().g();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        try {
            super.onActivityResult(i11, i12, intent);
            if (this.f67691h) {
                this.f67691h = false;
                if (i12 != -1) {
                    this.f67689f.success((Object) null);
                } else {
                    pa.d.o().C(new h()).y(this, i11, i12, intent, true);
                }
            } else if (i12 == -1) {
                pa.d.o().C(new i()).x(this, i11, i12, intent);
            }
        } catch (Exception unused) {
            HuobiToastUtil.m(getString(R.string.n_data_error));
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initStatus();
    }

    public void onDestroy() {
        this.f67685b.onNext(5);
        super.onDestroy();
        this.f67687d = false;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("reportFlutterError".equals(str)) {
                wi(methodCall);
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
                    HBBaseWebActivity.showWebView(this, str4, "", "", false);
                }
                result.success((Object) null);
            } else if ("requestToken".equals(str)) {
                yi(methodCall, result);
            } else if ("popPage".equals(str)) {
                finish();
                result.success((Object) null);
            } else if ("imagePicker".equals(str)) {
                Ai(methodCall, result);
            } else if ("platformShowHUD".equals(str)) {
                Boolean bool = (Boolean) methodCall.argument("show");
                if (bool == null || !bool.booleanValue()) {
                    dismissProgressDialog();
                } else {
                    showProgressDialog(true);
                }
            } else if ("getNetworkState".equals(str)) {
                Boolean bool2 = (Boolean) methodCall.argument("needToast");
                boolean h11 = i6.l.h(this);
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
        this.f67685b.onNext(3);
        super.onPause();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Activity) this, getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        if (i11 == 123) {
            pa.d.o().B(false).q(this);
        } else if (i11 == 124) {
            pa.d.o().B(false).t(this);
        }
    }

    public void onResume() {
        MethodCall methodCall;
        super.onResume();
        this.f67685b.onNext(2);
        this.f67687d = true;
        String str = null;
        if (!(this.f67689f == null || (methodCall = this.f67690g) == null || !"showVerify".equals(methodCall.method))) {
            this.f67689f.success(Boolean.valueOf(r.x().F0()));
            this.f67689f = null;
            this.f67690g = null;
        }
        String str2 = getClass().getSimpleName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + Nh();
        if (getIntent().getExtras() != null) {
            str = getIntent().getExtras().toString();
        }
        OpPathMonitor.c().a(str2, str);
        FirebaseCrashlytics.getInstance().setCustomKey("lastPagePath", str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str);
    }

    public void onUserLeaveHint() {
        try {
            super.onUserLeaveHint();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void pi(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        String str2 = (String) methodCall.argument("tag");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            result.success((Object) null);
            return;
        }
        i6.k.o(str2, str);
        result.success((Object) null);
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        i6.d.j("flutter", "provideFlutterEngine");
        String a11 = cl.c.a(Nh(), PixelUtils.a(24.0f));
        i6.d.j("flutter", "provideFlutterEngine no cache");
        FlutterEngine flutterEngine = new FlutterEngine(this);
        this.f67688e = flutterEngine;
        flutterEngine.getNavigationChannel().setInitialRoute(a11);
        this.f67688e.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(a11, this.f67688e);
        return this.f67688e;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void qi(io.flutter.plugin.common.MethodCall r26, io.flutter.plugin.common.MethodChannel.Result r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = "imageUrl"
            java.lang.Class<com.huobi.account.ui.SecurityLinkActivity> r5 = com.huobi.account.ui.SecurityLinkActivity.class
            java.lang.Class<com.huobi.account.ui.SecurityLinkStatusActivity> r6 = com.huobi.account.ui.SecurityLinkStatusActivity.class
            java.lang.String r7 = r2.method
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0017
            r27.notImplemented()
        L_0x0017:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "onPlatformMessageChannelMethodCall method - "
            r7.append(r8)
            java.lang.String r8 = r2.method
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "flutter"
            i6.d.j(r8, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "onPlatformMessageChannelMethodCall arguments - "
            r7.append(r9)
            java.lang.Object r9 = r2.arguments
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            i6.d.j(r8, r7)
            java.lang.String r7 = r2.method     // Catch:{ Exception -> 0x107c }
            int r8 = r7.hashCode()     // Catch:{ Exception -> 0x107c }
            java.lang.String r9 = "currencyEquivalent"
            switch(r8) {
                case -2132765784: goto L_0x04a7;
                case -2129410265: goto L_0x049c;
                case -2056464738: goto L_0x0492;
                case -2028594808: goto L_0x0487;
                case -2005297104: goto L_0x047c;
                case -1913642710: goto L_0x0472;
                case -1869909171: goto L_0x0467;
                case -1869775525: goto L_0x045e;
                case -1867690178: goto L_0x0453;
                case -1810821955: goto L_0x0448;
                case -1695924908: goto L_0x043c;
                case -1642957613: goto L_0x0430;
                case -1628378977: goto L_0x0424;
                case -1617379345: goto L_0x0418;
                case -1598537077: goto L_0x040c;
                case -1597243401: goto L_0x0400;
                case -1587220023: goto L_0x03f4;
                case -1561506719: goto L_0x03e8;
                case -1438015354: goto L_0x03dd;
                case -1418837333: goto L_0x03d1;
                case -1411698151: goto L_0x03c5;
                case -1388965385: goto L_0x03b9;
                case -1263213045: goto L_0x03ad;
                case -1249348326: goto L_0x03a1;
                case -1235619314: goto L_0x0395;
                case -1231576958: goto L_0x0389;
                case -1211505886: goto L_0x037d;
                case -1136021560: goto L_0x0371;
                case -1089884828: goto L_0x0365;
                case -1010580284: goto L_0x0359;
                case -954247841: goto L_0x034d;
                case -944224463: goto L_0x0341;
                case -816632225: goto L_0x0335;
                case -810046467: goto L_0x0329;
                case -797116285: goto L_0x031d;
                case -697876248: goto L_0x0311;
                case -508568865: goto L_0x0305;
                case -505960894: goto L_0x02f9;
                case -395052928: goto L_0x02ee;
                case -282921467: goto L_0x02e2;
                case -279936800: goto L_0x02d6;
                case -246745736: goto L_0x02ca;
                case -192955658: goto L_0x02be;
                case -79410336: goto L_0x02b2;
                case -19659958: goto L_0x02a6;
                case 1779572: goto L_0x029a;
                case 138822264: goto L_0x028e;
                case 243522097: goto L_0x0282;
                case 307534671: goto L_0x0276;
                case 323730026: goto L_0x026b;
                case 425603150: goto L_0x025f;
                case 429875484: goto L_0x0253;
                case 482854007: goto L_0x0247;
                case 555472544: goto L_0x023c;
                case 574566932: goto L_0x0230;
                case 580390365: goto L_0x0224;
                case 582345553: goto L_0x0218;
                case 591662532: goto L_0x020c;
                case 804029191: goto L_0x0200;
                case 855137750: goto L_0x01f4;
                case 860276249: goto L_0x01e8;
                case 977300788: goto L_0x01dc;
                case 1026644591: goto L_0x01d1;
                case 1033644375: goto L_0x01c5;
                case 1048060840: goto L_0x01b9;
                case 1049782462: goto L_0x01ad;
                case 1069956078: goto L_0x01a1;
                case 1081042534: goto L_0x0195;
                case 1100898435: goto L_0x0189;
                case 1125301051: goto L_0x017d;
                case 1227377485: goto L_0x0171;
                case 1267804147: goto L_0x0165;
                case 1282738188: goto L_0x0159;
                case 1292966058: goto L_0x014d;
                case 1408147659: goto L_0x0141;
                case 1461200028: goto L_0x0135;
                case 1512022271: goto L_0x0129;
                case 1522111346: goto L_0x011d;
                case 1532134724: goto L_0x0111;
                case 1595947385: goto L_0x0105;
                case 1603547744: goto L_0x00f9;
                case 1630368510: goto L_0x00ed;
                case 1696494512: goto L_0x00e1;
                case 1776415716: goto L_0x00d5;
                case 1822557871: goto L_0x00c9;
                case 1848374997: goto L_0x00bd;
                case 1900777433: goto L_0x00b1;
                case 1930886910: goto L_0x00a5;
                case 1955774368: goto L_0x0099;
                case 1966366787: goto L_0x008d;
                case 1979134388: goto L_0x0081;
                case 2027765560: goto L_0x0075;
                case 2067267770: goto L_0x006a;
                case 2092624351: goto L_0x005e;
                case 2104386445: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x04b2
        L_0x0052:
            java.lang.String r8 = "getUserHitUnifiedCrossAccount"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 8
            goto L_0x04b3
        L_0x005e:
            java.lang.String r8 = "isShowAppStoreReview"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 92
            goto L_0x04b3
        L_0x006a:
            java.lang.String r8 = "showHUD"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 2
            goto L_0x04b3
        L_0x0075:
            java.lang.String r8 = "getMgtSwitch"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 80
            goto L_0x04b3
        L_0x0081:
            java.lang.String r8 = "getUnitVolume"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 62
            goto L_0x04b3
        L_0x008d:
            java.lang.String r8 = "getToken"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 30
            goto L_0x04b3
        L_0x0099:
            java.lang.String r8 = "handleFiatPrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 44
            goto L_0x04b3
        L_0x00a5:
            java.lang.String r8 = "reportData"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 10
            goto L_0x04b3
        L_0x00b1:
            java.lang.String r8 = "localLog"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 13
            goto L_0x04b3
        L_0x00bd:
            java.lang.String r8 = "getBaseCurrencyDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 18
            goto L_0x04b3
        L_0x00c9:
            java.lang.String r8 = "getCurrencyIconUrl"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 81
            goto L_0x04b3
        L_0x00d5:
            java.lang.String r8 = "handleFavorite"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 56
            goto L_0x04b3
        L_0x00e1:
            java.lang.String r8 = "getAuthStatus"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 26
            goto L_0x04b3
        L_0x00ed:
            java.lang.String r8 = "showDatePickerView"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 83
            goto L_0x04b3
        L_0x00f9:
            java.lang.String r8 = "pushToAllOrdersPage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 89
            goto L_0x04b3
        L_0x0105:
            java.lang.String r8 = "getNetworkState"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 32
            goto L_0x04b3
        L_0x0111:
            java.lang.String r8 = "openPhone"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 70
            goto L_0x04b3
        L_0x011d:
            java.lang.String r8 = "openEmail"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 72
            goto L_0x04b3
        L_0x0129:
            java.lang.String r8 = "getSymbolDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 16
            goto L_0x04b3
        L_0x0135:
            java.lang.String r8 = "openProKline"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 54
            goto L_0x04b3
        L_0x0141:
            java.lang.String r8 = "accessSecureKeySupport"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 91
            goto L_0x04b3
        L_0x014d:
            java.lang.String r8 = "requestToken"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 12
            goto L_0x04b3
        L_0x0159:
            java.lang.String r8 = "requestImage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 87
            goto L_0x04b3
        L_0x0165:
            java.lang.String r8 = "getBuildId"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 66
            goto L_0x04b3
        L_0x0171:
            java.lang.String r8 = "jumpToExternalApp"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 77
            goto L_0x04b3
        L_0x017d:
            java.lang.String r8 = "advancedVerify"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 28
            goto L_0x04b3
        L_0x0189:
            java.lang.String r8 = "getTradePricePrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 36
            goto L_0x04b3
        L_0x0195:
            java.lang.String r8 = "getCurrencyDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 15
            goto L_0x04b3
        L_0x01a1:
            java.lang.String r8 = "saveString"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 22
            goto L_0x04b3
        L_0x01ad:
            java.lang.String r8 = "pickImageAndVideo"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 78
            goto L_0x04b3
        L_0x01b9:
            java.lang.String r8 = "openUniversalRoute"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 58
            goto L_0x04b3
        L_0x01c5:
            java.lang.String r8 = "gotoChatController"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 61
            goto L_0x04b3
        L_0x01d1:
            java.lang.String r8 = "openWebView"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 4
            goto L_0x04b3
        L_0x01dc:
            java.lang.String r8 = "toOtcScaleImage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 60
            goto L_0x04b3
        L_0x01e8:
            java.lang.String r8 = "getVToken"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 29
            goto L_0x04b3
        L_0x01f4:
            java.lang.String r8 = "showVerify"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 25
            goto L_0x04b3
        L_0x0200:
            java.lang.String r8 = "getString"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 23
            goto L_0x04b3
        L_0x020c:
            java.lang.String r8 = "getPointPrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 38
            goto L_0x04b3
        L_0x0218:
            java.lang.String r8 = "getOtcBooleanString"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 24
            goto L_0x04b3
        L_0x0224:
            java.lang.String r8 = "getCurrencyBlackWhiteListInfo"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 51
            goto L_0x04b3
        L_0x0230:
            java.lang.String r8 = "jumpNativePage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 46
            goto L_0x04b3
        L_0x023c:
            java.lang.String r8 = "reportFlutterError"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 1
            goto L_0x04b3
        L_0x0247:
            java.lang.String r8 = "getDeviceAbis"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 65
            goto L_0x04b3
        L_0x0253:
            java.lang.String r8 = "toTransPage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 86
            goto L_0x04b3
        L_0x025f:
            java.lang.String r8 = "getVideoCoverImagePath"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 79
            goto L_0x04b3
        L_0x026b:
            java.lang.String r8 = "getUnionMarginMode"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 7
            goto L_0x04b3
        L_0x0276:
            java.lang.String r8 = "getCurrencyByDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 17
            goto L_0x04b3
        L_0x0282:
            java.lang.String r8 = "isCurrencyFiat"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 49
            goto L_0x04b3
        L_0x028e:
            java.lang.String r8 = "nativeRequest"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 82
            goto L_0x04b3
        L_0x029a:
            java.lang.String r8 = "openOutsideUrl"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 64
            goto L_0x04b3
        L_0x02a6:
            java.lang.String r8 = "getCurrencyState"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 21
            goto L_0x04b3
        L_0x02b2:
            java.lang.String r8 = "toSpotExchange"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 33
            goto L_0x04b3
        L_0x02be:
            java.lang.String r8 = "getQuoteCurrencyDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 20
            goto L_0x04b3
        L_0x02ca:
            java.lang.String r8 = "getTradeAmountPrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 35
            goto L_0x04b3
        L_0x02d6:
            java.lang.String r8 = "openHelpCenter"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 76
            goto L_0x04b3
        L_0x02e2:
            java.lang.String r8 = "getAssetsPrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 41
            goto L_0x04b3
        L_0x02ee:
            java.lang.String r8 = "popPage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 3
            goto L_0x04b3
        L_0x02f9:
            java.lang.String r8 = "copyText"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 59
            goto L_0x04b3
        L_0x0305:
            java.lang.String r8 = "getCurrencyWeight"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 50
            goto L_0x04b3
        L_0x0311:
            java.lang.String r8 = "getTradeTotalPrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 40
            goto L_0x04b3
        L_0x031d:
            java.lang.String r8 = "getVulcanMap"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 47
            goto L_0x04b3
        L_0x0329:
            java.lang.String r8 = "getOriginTradePricePrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 37
            goto L_0x04b3
        L_0x0335:
            java.lang.String r8 = "viewGa"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 74
            goto L_0x04b3
        L_0x0341:
            java.lang.String r8 = "bindPhone"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 67
            goto L_0x04b3
        L_0x034d:
            java.lang.String r8 = "bindEmail"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 69
            goto L_0x04b3
        L_0x0359:
            java.lang.String r8 = "openGa"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 71
            goto L_0x04b3
        L_0x0365:
            java.lang.String r8 = "getNativeTranslation"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 63
            goto L_0x04b3
        L_0x0371:
            java.lang.String r8 = "sensorsDataTrack"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 11
            goto L_0x04b3
        L_0x037d:
            java.lang.String r8 = "realNameVerify"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 27
            goto L_0x04b3
        L_0x0389:
            java.lang.String r8 = "goOtcTradeSetting"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 94
            goto L_0x04b3
        L_0x0395:
            java.lang.String r8 = "getFeePrecision"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 39
            goto L_0x04b3
        L_0x03a1:
            java.lang.String r8 = "getUid"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 9
            goto L_0x04b3
        L_0x03ad:
            java.lang.String r8 = "openKyc"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 53
            goto L_0x04b3
        L_0x03b9:
            java.lang.String r8 = "bindGa"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 68
            goto L_0x04b3
        L_0x03c5:
            java.lang.String r8 = "sendBroadcast"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 84
            goto L_0x04b3
        L_0x03d1:
            java.lang.String r8 = "isInFavorite"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 57
            goto L_0x04b3
        L_0x03dd:
            java.lang.String r8 = "openBindCardPage"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 5
            goto L_0x04b3
        L_0x03e8:
            java.lang.String r8 = "getCurrencyFullName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 45
            goto L_0x04b3
        L_0x03f4:
            java.lang.String r8 = "viewPhone"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 73
            goto L_0x04b3
        L_0x0400:
            java.lang.String r8 = "viewEmail"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 75
            goto L_0x04b3
        L_0x040c:
            java.lang.String r8 = "getPlatformConfig"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 52
            goto L_0x04b3
        L_0x0418:
            java.lang.String r8 = "otc_helper"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 88
            goto L_0x04b3
        L_0x0424:
            java.lang.String r8 = "openSecurityCenter"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 90
            goto L_0x04b3
        L_0x0430:
            java.lang.String r8 = "openSupportDoc"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 43
            goto L_0x04b3
        L_0x043c:
            java.lang.String r8 = "verify2FA"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 85
            goto L_0x04b3
        L_0x0448:
            java.lang.String r8 = "ucTokenError"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 42
            goto L_0x04b3
        L_0x0453:
            java.lang.String r8 = "toPoints"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 34
            goto L_0x04b3
        L_0x045e:
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 48
            goto L_0x04b3
        L_0x0467:
            java.lang.String r8 = "doMainActBackPressed"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 55
            goto L_0x04b3
        L_0x0472:
            java.lang.String r8 = "showToast"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 0
            goto L_0x04b3
        L_0x047c:
            java.lang.String r8 = "aliyunLog"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 14
            goto L_0x04b3
        L_0x0487:
            java.lang.String r8 = "getOldToken"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 31
            goto L_0x04b3
        L_0x0492:
            java.lang.String r8 = "getLoginState"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 6
            goto L_0x04b3
        L_0x049c:
            java.lang.String r8 = "requestAppStoreReview"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 93
            goto L_0x04b3
        L_0x04a7:
            java.lang.String r8 = "getSymbolByDisplayName"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x04b2
            r7 = 19
            goto L_0x04b3
        L_0x04b2:
            r7 = -1
        L_0x04b3:
            java.lang.String r8 = "url"
            java.lang.String r12 = "currency"
            java.lang.String r11 = "key"
            java.lang.String r14 = "VERIFY_STATUS_KEY"
            java.lang.String r13 = "symbol"
            java.lang.String r15 = "from_otc_trade_set"
            java.lang.String r10 = "LINK_TYPE_KEY"
            r23 = r9
            java.lang.String r9 = ""
            r24 = r4
            r4 = 0
            switch(r7) {
                case 0: goto L_0x103a;
                case 1: goto L_0x1033;
                case 2: goto L_0x100c;
                case 3: goto L_0x1007;
                case 4: goto L_0x0fba;
                case 5: goto L_0x0fb1;
                case 6: goto L_0x0fa0;
                case 7: goto L_0x0f90;
                case 8: goto L_0x0f7c;
                case 9: goto L_0x0f5f;
                case 10: goto L_0x0f5a;
                case 11: goto L_0x0f26;
                case 12: goto L_0x0f21;
                case 13: goto L_0x0f1c;
                case 14: goto L_0x0f17;
                case 15: goto L_0x0f06;
                case 16: goto L_0x0ef5;
                case 17: goto L_0x0edd;
                case 18: goto L_0x0ecc;
                case 19: goto L_0x0ec7;
                case 20: goto L_0x0eb6;
                case 21: goto L_0x0e98;
                case 22: goto L_0x0e80;
                case 23: goto L_0x0e6f;
                case 24: goto L_0x0e41;
                case 25: goto L_0x0e1e;
                case 26: goto L_0x0de3;
                case 27: goto L_0x0ddc;
                case 28: goto L_0x0dd5;
                case 29: goto L_0x0db9;
                case 30: goto L_0x0d08;
                case 31: goto L_0x0cfe;
                case 32: goto L_0x0cd9;
                case 33: goto L_0x0cd4;
                case 34: goto L_0x0cc5;
                case 35: goto L_0x0cc0;
                case 36: goto L_0x0cbb;
                case 37: goto L_0x0cb6;
                case 38: goto L_0x0cb1;
                case 39: goto L_0x0cac;
                case 40: goto L_0x0ca7;
                case 41: goto L_0x0ca2;
                case 42: goto L_0x0c9d;
                case 43: goto L_0x0c98;
                case 44: goto L_0x0c93;
                case 45: goto L_0x0c7b;
                case 46: goto L_0x0b66;
                case 47: goto L_0x0b42;
                case 48: goto L_0x0adc;
                case 49: goto L_0x0ac5;
                case 50: goto L_0x0aa4;
                case 51: goto L_0x0a4e;
                case 52: goto L_0x0a3b;
                case 53: goto L_0x0a33;
                case 54: goto L_0x0a22;
                case 55: goto L_0x0a10;
                case 56: goto L_0x0986;
                case 57: goto L_0x0968;
                case 58: goto L_0x0936;
                case 59: goto L_0x0922;
                case 60: goto L_0x0906;
                case 61: goto L_0x08e3;
                case 62: goto L_0x08da;
                case 63: goto L_0x08bd;
                case 64: goto L_0x08a4;
                case 65: goto L_0x0881;
                case 66: goto L_0x0877;
                case 67: goto L_0x0863;
                case 68: goto L_0x084e;
                case 69: goto L_0x0839;
                case 70: goto L_0x0812;
                case 71: goto L_0x07f9;
                case 72: goto L_0x07d2;
                case 73: goto L_0x07ab;
                case 74: goto L_0x0793;
                case 75: goto L_0x076b;
                case 76: goto L_0x075f;
                case 77: goto L_0x0678;
                case 78: goto L_0x064d;
                case 79: goto L_0x0640;
                case 80: goto L_0x0619;
                case 81: goto L_0x060a;
                case 82: goto L_0x0605;
                case 83: goto L_0x0600;
                case 84: goto L_0x05ae;
                case 85: goto L_0x058d;
                case 86: goto L_0x0564;
                case 87: goto L_0x055f;
                case 88: goto L_0x0545;
                case 89: goto L_0x0523;
                case 90: goto L_0x050e;
                case 91: goto L_0x04fd;
                case 92: goto L_0x04dd;
                case 93: goto L_0x04d5;
                case 94: goto L_0x04d0;
                default: goto L_0x04cb;
            }
        L_0x04cb:
            r27.notImplemented()     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x04d0:
            com.huobi.otc.flutter.OtcTradeSettingFlutterActivity.Hi(r25)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x04d5:
            com.hbg.module.libkt.utils.l.c(r25)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x04dd:
            ej.d r2 = ej.d.a()     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.network.hbg.core.util.MgtConfigNumber r4 = com.hbg.lib.network.hbg.core.util.MgtConfigNumber.REVIEW_SWAP     // Catch:{ Exception -> 0x107c }
            int r4 = r4.number     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.c(r4)     // Catch:{ Exception -> 0x107c }
            boolean r4 = com.hbg.lib.core.util.ChannelUtils.d()     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x04f3
            if (r4 == 0) goto L_0x04f3
            r15 = 1
            goto L_0x04f4
        L_0x04f3:
            r15 = 0
        L_0x04f4:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x04fd:
            tg.h r2 = tg.h.c()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.i()     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x050e:
            rn.c r2 = rn.c.i()     // Catch:{ Exception -> 0x107c }
            com.huobi.login.bean.JumpTarget r5 = new com.huobi.login.bean.JumpTarget     // Catch:{ Exception -> 0x107c }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            java.lang.Class<com.huobi.account.ui.SecuritySetActivity> r7 = com.huobi.account.ui.SecuritySetActivity.class
            r6.<init>(r1, r7)     // Catch:{ Exception -> 0x107c }
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x107c }
            r2.d(r1, r5)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0523:
            java.lang.String r5 = "orderStatus"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x107c }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x107c }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r5.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "orderStatus"
            r5.putExtra(r6, r2)     // Catch:{ Exception -> 0x107c }
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x107c }
            r2.U(r1, r5)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0545:
            uf.a r2 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.a()     // Catch:{ Exception -> 0x107c }
            if (r2 != 0) goto L_0x0557
            uf.a r2 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x107c }
            r2.l(r1, r4, r4)     // Catch:{ Exception -> 0x107c }
            return
        L_0x0557:
            com.huobi.otc.ui.OtcFAQActivity.zh(r25)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x055f:
            xi(r25, r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0564:
            java.lang.String r4 = "coinName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "from"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x107c }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "account"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            int r4 = va.b.e(r4)     // Catch:{ Exception -> 0x107c }
            uf.b r6 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x107c }
            r6.S(r1, r4, r2, r5)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x058d:
            java.lang.String r4 = "action"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            if (r4 == 0) goto L_0x05aa
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x107c }
            if (r4 == 0) goto L_0x059e
            goto L_0x05aa
        L_0x059e:
            com.huobi.flutter.Flutter2FAVerifyTool r4 = r1.f67692i     // Catch:{ Exception -> 0x107c }
            io.flutter.plugin.common.MethodChannel r5 = r1.f67693j     // Catch:{ Exception -> 0x107c }
            r4.d(r2, r5, r1, r1)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x05aa:
            r27.notImplemented()     // Catch:{ Exception -> 0x107c }
            return
        L_0x05ae:
            java.lang.String r4 = "broadcastName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "NOTIFICATION_OTC_P2P_MERCHANT_ATTENTIONS_STATUS_CHANGE"
            boolean r5 = r5.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x05d8
            java.lang.String r4 = "params"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x107c }
            com.huobi.otc.event.OtcFollowEvent r4 = new com.huobi.otc.event.OtcFollowEvent     // Catch:{ Exception -> 0x107c }
            r4.<init>()     // Catch:{ Exception -> 0x107c }
            r4.params = r2     // Catch:{ Exception -> 0x107c }
            r4.object = r1     // Catch:{ Exception -> 0x107c }
            org.greenrobot.eventbus.EventBus r2 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ Exception -> 0x107c }
            r2.k(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x05d8:
            java.lang.String r5 = "NOTIFICATION_OTC_P2P_ORDER_HINT_CHANGE"
            boolean r4 = r5.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x107c }
            if (r4 == 0) goto L_0x1084
            java.lang.String r4 = "params"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x107c }
            com.huobi.otc.event.OtcNewOrderTipOpenEvent r4 = new com.huobi.otc.event.OtcNewOrderTipOpenEvent     // Catch:{ Exception -> 0x107c }
            r4.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "status"
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r4.status = r2     // Catch:{ Exception -> 0x107c }
            org.greenrobot.eventbus.EventBus r2 = org.greenrobot.eventbus.EventBus.d()     // Catch:{ Exception -> 0x107c }
            r2.k(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0600:
            cl.d.d(r25, r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0605:
            com.huobi.flutter.FlutterNetworkUtil.d(r25, r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x060a:
            java.lang.Object r2 = r2.argument(r12)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = al.p.l(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0619:
            java.lang.Object r4 = r2.argument(r11)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x107c }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "default"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
            jp.s0 r5 = jp.s0.b()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r5.a(r4, r2)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0640:
            java.lang.String r4 = "videoPath"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r1.Sh(r2, r3)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x064d:
            r1.f67689f = r3     // Catch:{ Exception -> 0x107c }
            r1.f67690g = r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "type"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x107c }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "maxNum"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x107c }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x107c }
            r5 = 1
            r1.f67691h = r5     // Catch:{ Exception -> 0x107c }
            if (r4 != 0) goto L_0x0673
            r25.ti()     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0673:
            r1.ui(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0678:
            java.lang.Object r4 = r2.argument(r13)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "appName"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "appUrl"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x06ab
            java.lang.String r5 = "holigeit://"
            boolean r5 = r2.startsWith(r5)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x06ab
            b2.a r4 = b2.a.d()     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "/webView/index"
            com.alibaba.android.arouter.facade.Postcard r4 = r4.a(r5)     // Catch:{ Exception -> 0x107c }
            com.alibaba.android.arouter.facade.Postcard r2 = r4.withString(r8, r2)     // Catch:{ Exception -> 0x107c }
            r2.navigation(r1)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x06ab:
            java.lang.String r5 = "com.plunien.poloniex"
            boolean r5 = com.hbg.lib.common.utils.PackageManagerUtil.a(r1, r5)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x0730
            boolean r5 = com.hbg.module.libkt.base.ext.b.x(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x0730
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "android.intent.action.VIEW"
            r5.<init>(r6)     // Catch:{ Exception -> 0x107c }
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r5.addFlags(r6)     // Catch:{ Exception -> 0x107c }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x107c }
            r5.setData(r2)     // Catch:{ Exception -> 0x107c }
            android.content.pm.PackageManager r2 = r25.getPackageManager()     // Catch:{ Exception -> 0x107c }
            android.content.ComponentName r2 = r5.resolveActivity(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x070b
            android.content.res.Resources r2 = r25.getResources()     // Catch:{ Exception -> 0x107c }
            r6 = 2132017660(0x7f1401fc, float:1.9673605E38)
            java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x107c }
            r6 = 1
            java.lang.CharSequence[] r6 = new java.lang.CharSequence[r6]     // Catch:{ Exception -> 0x107c }
            r7 = 0
            r6[r7] = r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r10 = com.hbg.lib.common.utils.StringUtils.d(r2, r6)     // Catch:{ Exception -> 0x107c }
            com.hbg.module.libkt.custom.ButtonDialog$a r8 = com.hbg.module.libkt.custom.ButtonDialog.f24637i     // Catch:{ Exception -> 0x107c }
            androidx.fragment.app.FragmentManager r9 = r25.getSupportFragmentManager()     // Catch:{ Exception -> 0x107c }
            r11 = 2
            r2 = 2132020548(0x7f140d44, float:1.9679462E38)
            java.lang.String r12 = r1.getString(r2)     // Catch:{ Exception -> 0x107c }
            r2 = 2132020382(0x7f140c9e, float:1.9679126E38)
            java.lang.String r13 = r1.getString(r2)     // Catch:{ Exception -> 0x107c }
            dl.l r14 = new dl.l     // Catch:{ Exception -> 0x107c }
            r14.<init>(r1, r5)     // Catch:{ Exception -> 0x107c }
            r15 = 0
            r8.a(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x070b:
            com.hbg.module.libkt.custom.ButtonDialog$a r16 = com.hbg.module.libkt.custom.ButtonDialog.f24637i     // Catch:{ Exception -> 0x107c }
            androidx.fragment.app.FragmentManager r17 = r25.getSupportFragmentManager()     // Catch:{ Exception -> 0x107c }
            r2 = 2132023304(0x7f141808, float:1.9685052E38)
            java.lang.String r18 = r1.getString(r2)     // Catch:{ Exception -> 0x107c }
            r19 = 1
            android.content.res.Resources r2 = r25.getResources()     // Catch:{ Exception -> 0x107c }
            r4 = 2132021351(0x7f141067, float:1.968109E38)
            java.lang.String r20 = r2.getString(r4)     // Catch:{ Exception -> 0x107c }
            r21 = 0
            r22 = 0
            r23 = 0
            r16.a(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0730:
            android.content.res.Resources r2 = r25.getResources()     // Catch:{ Exception -> 0x107c }
            r5 = 2132017661(0x7f1401fd, float:1.9673607E38)
            java.lang.String r2 = r2.getString(r5)     // Catch:{ Exception -> 0x107c }
            r5 = 1
            java.lang.CharSequence[] r5 = new java.lang.CharSequence[r5]     // Catch:{ Exception -> 0x107c }
            r6 = 0
            r5[r6] = r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r9 = com.hbg.lib.common.utils.StringUtils.d(r2, r5)     // Catch:{ Exception -> 0x107c }
            com.hbg.module.libkt.custom.ButtonDialog$a r7 = com.hbg.module.libkt.custom.ButtonDialog.f24637i     // Catch:{ Exception -> 0x107c }
            androidx.fragment.app.FragmentManager r8 = r25.getSupportFragmentManager()     // Catch:{ Exception -> 0x107c }
            r10 = 1
            android.content.res.Resources r2 = r25.getResources()     // Catch:{ Exception -> 0x107c }
            r4 = 2132021351(0x7f141067, float:1.968109E38)
            java.lang.String r11 = r2.getString(r4)     // Catch:{ Exception -> 0x107c }
            r12 = 0
            r13 = 0
            r14 = 0
            r7.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x075f:
            android.content.Intent r2 = sn.f.h(r25)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x076b:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r5 = 2
            r4.putExtra(r10, r5)     // Catch:{ Exception -> 0x107c }
            r5 = 1
            r4.putExtra(r15, r5)     // Catch:{ Exception -> 0x107c }
            r5 = 3
            r4.putExtra(r14, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x078b
            java.lang.String r5 = "BIND_EMAIL_KEY"
            r4.putExtra(r5, r2)     // Catch:{ Exception -> 0x107c }
        L_0x078b:
            r1.startActivity(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0793:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r2.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r4 = 3
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x107c }
            r5 = 1
            r2.putExtra(r15, r5)     // Catch:{ Exception -> 0x107c }
            r2.putExtra(r14, r4)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x07ab:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r5 = 1
            r4.putExtra(r10, r5)     // Catch:{ Exception -> 0x107c }
            r6 = 3
            r4.putExtra(r14, r6)     // Catch:{ Exception -> 0x107c }
            r4.putExtra(r15, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x07ca
            java.lang.String r5 = "BIND_PHONE_KEY"
            r4.putExtra(r5, r2)     // Catch:{ Exception -> 0x107c }
        L_0x07ca:
            r1.startActivity(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x07d2:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r5 = 2
            r4.putExtra(r10, r5)     // Catch:{ Exception -> 0x107c }
            r6 = 1
            r4.putExtra(r15, r6)     // Catch:{ Exception -> 0x107c }
            r4.putExtra(r14, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x07f1
            java.lang.String r5 = "BIND_EMAIL_KEY"
            r4.putExtra(r5, r2)     // Catch:{ Exception -> 0x107c }
        L_0x07f1:
            r1.startActivity(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x07f9:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r2.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r4 = 3
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x107c }
            r4 = 1
            r2.putExtra(r15, r4)     // Catch:{ Exception -> 0x107c }
            r4 = 2
            r2.putExtra(r14, r4)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0812:
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r6)     // Catch:{ Exception -> 0x107c }
            r5 = 1
            r4.putExtra(r10, r5)     // Catch:{ Exception -> 0x107c }
            r6 = 2
            r4.putExtra(r14, r6)     // Catch:{ Exception -> 0x107c }
            r4.putExtra(r15, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x0831
            java.lang.String r5 = "BIND_PHONE_KEY"
            r4.putExtra(r5, r2)     // Catch:{ Exception -> 0x107c }
        L_0x0831:
            r1.startActivity(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0839:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x107c }
            r4 = 2
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x107c }
            r4 = 1
            r2.putExtra(r15, r4)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x084e:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x107c }
            r4 = 3
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x107c }
            r4 = 1
            r2.putExtra(r15, r4)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0863:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x107c }
            r4 = 1
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x107c }
            r2.putExtra(r15, r4)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0877:
            java.lang.Integer r2 = com.huobi.BuildConfig.f40904a     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0881:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r2.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String[] r4 = com.blankj.utilcode.util.j.a()     // Catch:{ Exception -> 0x107c }
            int r5 = r4.length     // Catch:{ Exception -> 0x107c }
            r15 = 0
        L_0x088c:
            if (r15 >= r5) goto L_0x089b
            r6 = r4[r15]     // Catch:{ Exception -> 0x107c }
            r2.append(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = ","
            r2.append(r6)     // Catch:{ Exception -> 0x107c }
            int r15 = r15 + 1
            goto L_0x088c
        L_0x089b:
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x08a4:
            java.lang.Object r2 = r2.argument(r8)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "android.intent.action.VIEW"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x107c }
            r5.<init>(r6, r2)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r5)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x08bd:
            java.lang.Object r2 = r2.argument(r11)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            android.content.res.Resources r4 = r25.getResources()     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "string"
            java.lang.String r6 = r25.getPackageName()     // Catch:{ Exception -> 0x107c }
            int r2 = r4.getIdentifier(r2, r5, r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x08da:
            java.lang.String r2 = r25.Bh(r26)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x08e3:
            java.lang.String r4 = "orderId"
            java.lang.Object r4 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "needBackToDetailPage"
            boolean r5 = r2.hasArgument(r5)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x0900
            java.lang.String r5 = "needBackToDetailPage"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            boolean r15 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
            goto L_0x0901
        L_0x0900:
            r15 = 0
        L_0x0901:
            jp.l0.b(r1, r4, r15)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0906:
            r5 = r24
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            r6.<init>()     // Catch:{ Exception -> 0x107c }
            r6.putExtra(r5, r2)     // Catch:{ Exception -> 0x107c }
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x107c }
            r2.a(r1, r6)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0922:
            java.lang.String r5 = "text"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            uf.a r5 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x107c }
            r5.h(r2, r1)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0936:
            java.lang.Object r2 = r2.argument(r8)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x0963
            java.lang.String r5 = java.net.URLDecoder.decode(r2)     // Catch:{ Exception -> 0x095e }
            java.lang.String r6 = "/account/kyc"
            boolean r5 = r5.contains(r6)     // Catch:{ Exception -> 0x095e }
            if (r5 == 0) goto L_0x0956
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x095e }
            r2.L()     // Catch:{ Exception -> 0x095e }
            goto L_0x0963
        L_0x0956:
            com.hbg.lib.core.BaseModuleConfig$a r5 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ Exception -> 0x095e }
            r5.k0(r2)     // Catch:{ Exception -> 0x095e }
            goto L_0x0963
        L_0x095e:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()     // Catch:{ Exception -> 0x107c }
        L_0x0963:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0968:
            boolean r5 = r2.hasArgument(r13)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x0981
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r2 = sn.t.w(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0981:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0986:
            boolean r5 = r2.hasArgument(r13)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x0a0b
            java.lang.String r5 = "isAdd"
            boolean r5 = r2.hasArgument(r5)     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x0a0b
            java.lang.Object r5 = r2.argument(r13)     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "isAdd"
            java.lang.Object r2 = r2.argument(r7)     // Catch:{ Exception -> 0x107c }
            boolean r2 = r6.equals(r2)     // Catch:{ Exception -> 0x107c }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x107c }
            if (r6 != 0) goto L_0x0a06
            if (r2 == 0) goto L_0x09da
            android.content.Context r2 = r25.getApplicationContext()     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = sn.t.v(r5)     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = sn.t.i(r5, r2, r6)     // Catch:{ Exception -> 0x107c }
            rx.Observable$Transformer r4 = com.hbg.lib.core.util.RxJavaHelper.t(r4)     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = r2.compose(r4)     // Catch:{ Exception -> 0x107c }
            dl.m r4 = new dl.m     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r3)     // Catch:{ Exception -> 0x107c }
            dl.q r5 = new dl.q     // Catch:{ Exception -> 0x107c }
            r5.<init>(r3)     // Catch:{ Exception -> 0x107c }
            dl.t r6 = new dl.t     // Catch:{ Exception -> 0x107c }
            r6.<init>(r3)     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.core.network.rx.EasySubscriber r4 = com.hbg.lib.core.network.rx.EasySubscriber.create(r4, r5, r6)     // Catch:{ Exception -> 0x107c }
            r2.subscribe(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x09da:
            android.content.Context r2 = r25.getApplicationContext()     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = sn.t.v(r5)     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = sn.t.l(r5, r2, r6)     // Catch:{ Exception -> 0x107c }
            rx.Observable$Transformer r4 = com.hbg.lib.core.util.RxJavaHelper.t(r4)     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = r2.compose(r4)     // Catch:{ Exception -> 0x107c }
            dl.n r4 = new dl.n     // Catch:{ Exception -> 0x107c }
            r4.<init>(r1, r3)     // Catch:{ Exception -> 0x107c }
            dl.p r5 = new dl.p     // Catch:{ Exception -> 0x107c }
            r5.<init>(r3)     // Catch:{ Exception -> 0x107c }
            dl.s r6 = new dl.s     // Catch:{ Exception -> 0x107c }
            r6.<init>(r3)     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.core.network.rx.EasySubscriber r4 = com.hbg.lib.core.network.rx.EasySubscriber.create(r4, r5, r6)     // Catch:{ Exception -> 0x107c }
            r2.subscribe(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a06:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a0b:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a10:
            ra.d r2 = ra.c.c()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.h(r1)     // Catch:{ Exception -> 0x107c }
            if (r2 != 0) goto L_0x0a1d
            super.onBackPressed()     // Catch:{ Exception -> 0x107c }
        L_0x0a1d:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a22:
            java.lang.Object r2 = r2.argument(r13)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x107c }
            r5 = 0
            sn.f.C(r1, r2, r5, r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a33:
            r25.ri(r26, r27)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a3b:
            java.lang.String r2 = r25.Nh()     // Catch:{ Exception -> 0x107c }
            r4 = 1103101952(0x41c00000, float:24.0)
            int r4 = com.hbg.lib.common.utils.PixelUtils.a(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = cl.c.a(r2, r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a4e:
            java.lang.Object r2 = r2.argument(r12)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            d7.k r5 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r5 = r5.s(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x0a63
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0a63:
            boolean r4 = r5.isCountryDisabled()     // Catch:{ Exception -> 0x107c }
            if (r4 != 0) goto L_0x0a76
            java.lang.String r2 = com.hbg.lib.common.utils.StringUtils.g(r2)     // Catch:{ Exception -> 0x107c }
            boolean r2 = x7.f.c(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0a74
            goto L_0x0a76
        L_0x0a74:
            r15 = 0
            goto L_0x0a77
        L_0x0a76:
            r15 = 1
        L_0x0a77:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x107c }
            r2.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "countryDisabled"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x107c }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "whiteEnabled"
            boolean r6 = r5.isWhiteEnabled()     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x107c }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "isVisible"
            boolean r5 = r5.isVisible()     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x107c }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0aa4:
            java.lang.Object r2 = r2.argument(r12)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r4.I(r2, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ac5:
            java.lang.Object r2 = r2.argument(r12)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r4.L(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0adc:
            java.util.Map r4 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.T()     // Catch:{ Exception -> 0x107c }
            if (r4 == 0) goto L_0x0b16
            int r4 = r4.size()     // Catch:{ Exception -> 0x107c }
            if (r4 != 0) goto L_0x0ae9
            goto L_0x0b16
        L_0x0ae9:
            java.lang.Object r4 = r2.argument(r12)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = "amount"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.G(r2, r4, r5)     // Catch:{ Exception -> 0x107c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r4.<init>()     // Catch:{ Exception -> 0x107c }
            r5 = r23
            r4.append(r5)     // Catch:{ Exception -> 0x107c }
            r4.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x107c }
            i6.d.d(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0b16:
            rx.Observable r4 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.e()     // Catch:{ Exception -> 0x107c }
            rx.Observable$Transformer r5 = com.hbg.lib.core.util.RxJavaHelper.t(r25)     // Catch:{ Exception -> 0x107c }
            rx.Observable r4 = r4.compose(r5)     // Catch:{ Exception -> 0x107c }
            rx.Scheduler r5 = rx.android.schedulers.AndroidSchedulers.mainThread()     // Catch:{ Exception -> 0x107c }
            rx.Observable r4 = r4.subscribeOn(r5)     // Catch:{ Exception -> 0x107c }
            dl.o r5 = new dl.o     // Catch:{ Exception -> 0x107c }
            r5.<init>(r2, r3)     // Catch:{ Exception -> 0x107c }
            dl.r r2 = new dl.r     // Catch:{ Exception -> 0x107c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x107c }
            dl.b r6 = new dl.b     // Catch:{ Exception -> 0x107c }
            r6.<init>(r3)     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.core.network.rx.EasySubscriber r2 = com.hbg.lib.core.network.rx.EasySubscriber.create(r5, r2, r6)     // Catch:{ Exception -> 0x107c }
            r4.subscribe(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0b42:
            java.lang.String r5 = "sceneCode"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r5 != 0) goto L_0x0b61
            iu.a r4 = iu.a.f()     // Catch:{ Exception -> 0x107c }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x107c }
            java.util.Map r2 = r4.d(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0b61:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0b66:
            java.lang.String r5 = "target"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x107c }
            com.huobi.index.bean.IndexFeatureItem r6 = new com.huobi.index.bean.IndexFeatureItem     // Catch:{ Exception -> 0x107c }
            r6.<init>()     // Catch:{ Exception -> 0x107c }
            r7 = 1
            r6.setNeedLogin(r7)     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "param"
            boolean r7 = r2.hasArgument(r7)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0b8a
            java.lang.String r7 = "param"
            java.lang.Object r7 = r2.argument(r7)     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x107c }
            r6.setJumpSymbol(r7)     // Catch:{ Exception -> 0x107c }
        L_0x0b8a:
            java.lang.String r7 = "jumpUrl"
            boolean r7 = r2.hasArgument(r7)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0c6c
            java.lang.String r7 = "jumpUrl"
            java.lang.Object r2 = r2.argument(r7)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "jumpNative://"
            java.lang.String r2 = r2.replace(r7, r9)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "&"
            java.lang.String[] r7 = r2.split(r7)     // Catch:{ Exception -> 0x107c }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x107c }
            r8.<init>()     // Catch:{ Exception -> 0x107c }
            int r9 = r7.length     // Catch:{ Exception -> 0x107c }
            r10 = 0
        L_0x0bb1:
            if (r10 >= r9) goto L_0x0bca
            r11 = r7[r10]     // Catch:{ Exception -> 0x107c }
            java.lang.String r12 = "="
            java.lang.String[] r11 = r11.split(r12)     // Catch:{ Exception -> 0x107c }
            int r12 = r11.length     // Catch:{ Exception -> 0x107c }
            r13 = 1
            if (r12 <= r13) goto L_0x0bc7
            r12 = 0
            r14 = r11[r12]     // Catch:{ Exception -> 0x107c }
            r11 = r11[r13]     // Catch:{ Exception -> 0x107c }
            r8.put(r14, r11)     // Catch:{ Exception -> 0x107c }
        L_0x0bc7:
            int r10 = r10 + 1
            goto L_0x0bb1
        L_0x0bca:
            java.lang.String r7 = "1004"
            boolean r7 = r7.equals(r5)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0c16
            java.lang.String r2 = "topicId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0be5
            java.lang.String r2 = "topicId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setTopicId(r2)     // Catch:{ Exception -> 0x107c }
        L_0x0be5:
            java.lang.String r2 = "topicType"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0bf8
            java.lang.String r2 = "topicType"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setTopicType(r2)     // Catch:{ Exception -> 0x107c }
        L_0x0bf8:
            java.lang.String r2 = "commentId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0c0b
            java.lang.String r2 = "commentId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setCommentId(r2)     // Catch:{ Exception -> 0x107c }
        L_0x0c0b:
            java.lang.String r2 = "app_community_xxzxdzlb"
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = "app_community_xxzxhflb"
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x0c6c
        L_0x0c16:
            java.lang.String r7 = "1008"
            boolean r7 = r7.equals(r5)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0c32
            java.lang.String r2 = "dynamicId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0c6c
            java.lang.String r2 = "dynamicId"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setDynamicId(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x0c6c
        L_0x0c32:
            java.lang.String r7 = "1007"
            boolean r7 = r7.equals(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r9 = "uidUnique"
            if (r7 == 0) goto L_0x0c51
            java.lang.Object r2 = r8.get(r9)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0c4b
            java.lang.Object r2 = r8.get(r9)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setUidUnique(r2)     // Catch:{ Exception -> 0x107c }
        L_0x0c4b:
            java.lang.String r2 = "app_community_xxzxgzlb"
            gs.g.i(r2, r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x0c6c
        L_0x0c51:
            java.lang.String r7 = "1009"
            boolean r7 = r7.equals(r5)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0c69
            java.lang.Object r2 = r8.get(r9)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0c6c
            java.lang.Object r2 = r8.get(r9)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            r6.setUidUnique(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x0c6c
        L_0x0c69:
            r6.setJumpUrl(r2)     // Catch:{ Exception -> 0x107c }
        L_0x0c6c:
            int r2 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x107c }
            r6.setJumpMode(r2)     // Catch:{ Exception -> 0x107c }
            yl.o.p(r1, r6)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0c7b:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r2 = r4.v(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 != 0) goto L_0x0c8a
            goto L_0x0c8e
        L_0x0c8a:
            java.lang.String r9 = r2.getFullName()     // Catch:{ Exception -> 0x107c }
        L_0x0c8e:
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0c93:
            r25.Th(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0c98:
            r25.si(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0c9d:
            r25.Ci(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ca2:
            r25.Dh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ca7:
            r25.Rh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cac:
            r25.Fh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cb1:
            r25.Lh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cb6:
            r25.Jh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cbb:
            r25.Qh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cc0:
            r25.Ph(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cc5:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x107c }
            java.lang.Class<com.huobi.points.activity.MyPointsNewActivity> r5 = com.huobi.points.activity.MyPointsNewActivity.class
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x107c }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cd4:
            r25.Bi(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cd9:
            java.lang.String r4 = "needToast"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            boolean r4 = com.hbg.lib.common.network.NetworkStatus.c(r25)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x107c }
            r3.success(r5)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x1084
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x1084
            if (r4 != 0) goto L_0x1084
            r2 = 2132026992(0x7f142670, float:1.9692532E38)
            com.hbg.lib.widgets.utils.HuobiToastUtil.j(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0cfe:
            r2 = 1
            java.lang.String r2 = com.hbg.lib.network.uc.core.utils.UcHelper.b(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d08:
            java.lang.String r4 = "site"
            java.lang.Object r2 = r2.argument(r4)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x107c }
            switch(r4) {
                case 2702: goto L_0x0d4a;
                case 68983: goto L_0x0d40;
                case 78590: goto L_0x0d36;
                case 79192: goto L_0x0d2c;
                case 79501: goto L_0x0d22;
                case 215679250: goto L_0x0d18;
                default: goto L_0x0d17;
            }     // Catch:{ Exception -> 0x107c }
        L_0x0d17:
            goto L_0x0d54
        L_0x0d18:
            java.lang.String r4 = "CONTRACT"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 2
            goto L_0x0d55
        L_0x0d22:
            java.lang.String r4 = "PRO"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 0
            goto L_0x0d55
        L_0x0d2c:
            java.lang.String r4 = "PHP"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 3
            goto L_0x0d55
        L_0x0d36:
            java.lang.String r4 = "OTC"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 1
            goto L_0x0d55
        L_0x0d40:
            java.lang.String r4 = "ETF"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 5
            goto L_0x0d55
        L_0x0d4a:
            java.lang.String r4 = "UC"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0d54
            r10 = 4
            goto L_0x0d55
        L_0x0d54:
            r10 = -1
        L_0x0d55:
            if (r10 == 0) goto L_0x0dac
            r2 = 1
            if (r10 == r2) goto L_0x0d9f
            r2 = 2
            if (r10 == r2) goto L_0x0d92
            r2 = 3
            if (r10 == r2) goto L_0x0d85
            r2 = 4
            if (r10 == r2) goto L_0x0d78
            r2 = 5
            if (r10 == r2) goto L_0x0d6b
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d6b:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.v()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d78:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.I()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d85:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.G()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d92:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.q()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0d9f:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.E()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0dac:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.H()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0db9:
            iu.a r2 = iu.a.f()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.k()     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0dd0
            ku.b r2 = ku.b.e()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.h(r1)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0dd0:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0dd5:
            r2 = 0
            r5 = 1
            nb.c.h(r1, r5, r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ddc:
            java.lang.String r2 = "FROM_SAVINGS"
            com.huobi.kyc.ui.KycProBaseInformationActivity.Vh(r1, r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0de3:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            com.huobi.login.usercenter.data.source.bean.UserInfoData r2 = r2.M()     // Catch:{ Exception -> 0x107c }
            java.util.List r2 = r2.d()     // Catch:{ Exception -> 0x107c }
            r5 = 0
            java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = rx.Observable.just(r2)     // Catch:{ Exception -> 0x107c }
            rx.Observable r5 = jp.l.q(r5)     // Catch:{ Exception -> 0x107c }
            rx.Observable$Transformer r6 = com.hbg.lib.core.util.RxJavaHelper.t(r4)     // Catch:{ Exception -> 0x107c }
            rx.Observable r5 = r5.compose(r6)     // Catch:{ Exception -> 0x107c }
            dl.k r6 = dl.k.f53814b     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = rx.Observable.zip(r2, r5, r6)     // Catch:{ Exception -> 0x107c }
            rx.Observable$Transformer r4 = com.hbg.lib.core.util.RxJavaHelper.t(r4)     // Catch:{ Exception -> 0x107c }
            rx.Observable r2 = r2.compose(r4)     // Catch:{ Exception -> 0x107c }
            com.huobi.flutter.base.AbsGlobalFlutterActivity$e r4 = new com.huobi.flutter.base.AbsGlobalFlutterActivity$e     // Catch:{ Exception -> 0x107c }
            r4.<init>(r3)     // Catch:{ Exception -> 0x107c }
            r2.subscribe(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0e1e:
            r5 = 1
            r1.f67689f = r3     // Catch:{ Exception -> 0x107c }
            r1.f67690g = r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "unspecified"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            rn.c r6 = rn.c.i()     // Catch:{ Exception -> 0x107c }
            com.huobi.login.bean.JumpTarget r7 = new com.huobi.login.bean.JumpTarget     // Catch:{ Exception -> 0x107c }
            r7.<init>(r4, r4)     // Catch:{ Exception -> 0x107c }
            if (r2 != 0) goto L_0x0e38
            r10 = r5
            goto L_0x0e3c
        L_0x0e38:
            boolean r10 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
        L_0x0e3c:
            r6.e(r1, r7, r10)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0e41:
            java.lang.Object r2 = r2.argument(r11)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "otc_config"
            boolean r2 = com.hbg.lib.core.util.ConfigPreferences.b(r4, r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "AppLifecycleStatesf"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r5.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "AppLifecycleStatesf---isCloseisClose--native->"
            r5.append(r6)     // Catch:{ Exception -> 0x107c }
            r5.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x107c }
            i6.d.j(r4, r5)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0e68
            java.lang.String r2 = "true"
            goto L_0x0e6a
        L_0x0e68:
            java.lang.String r2 = "false"
        L_0x0e6a:
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0e6f:
            java.lang.Object r2 = r2.argument(r11)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r4 = "user_config"
            java.lang.String r2 = com.hbg.lib.core.util.ConfigPreferences.d(r4, r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0e80:
            java.lang.Object r5 = r2.argument(r11)     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "value"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "user_config"
            com.hbg.lib.core.util.ConfigPreferences.m(r6, r5, r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0e98:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.network.pro.core.bean.SymbolBean r2 = r4.J(r2, r5)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0eb1
            java.lang.String r2 = r2.getState()     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0eb1:
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0eb6:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r4.F(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ec7:
            r25.Oh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ecc:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r4.p(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0edd:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            com.hbg.lib.network.pro.core.bean.CurrencyBean r2 = r4.v(r2)     // Catch:{ Exception -> 0x107c }
            if (r2 != 0) goto L_0x0eec
            goto L_0x0ef0
        L_0x0eec:
            java.lang.String r9 = r2.getName()     // Catch:{ Exception -> 0x107c }
        L_0x0ef0:
            r3.success(r9)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0ef5:
            d7.a1 r4 = d7.a1.v()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r4.W(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f06:
            d7.k r4 = d7.k.C()     // Catch:{ Exception -> 0x107c }
            java.lang.Object r2 = r2.arguments     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r4.z(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f17:
            r25.zh(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f1c:
            r25.pi(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f21:
            r25.yi(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f26:
            java.lang.String r5 = "data"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.util.HashMap r5 = (java.util.HashMap) r5     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "eventName"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x107c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r6.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "sensorsDataTrack-native : ["
            r6.append(r7)     // Catch:{ Exception -> 0x107c }
            r6.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r7 = "] "
            r6.append(r7)     // Catch:{ Exception -> 0x107c }
            r6.append(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x107c }
            i6.d.b(r6)     // Catch:{ Exception -> 0x107c }
            gs.g.i(r2, r5)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f5a:
            r25.Ch(r26, r27)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f5f:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.J()     // Catch:{ Exception -> 0x107c }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x107c }
            if (r4 != 0) goto L_0x0f72
            int r15 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x0f73
        L_0x0f72:
            r15 = 0
        L_0x0f73:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f7c:
            sc.a r2 = com.hbg.module.contract.ContractModuleConfig.a()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.b()     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0f89
            java.lang.String r2 = "1"
            goto L_0x0f8b
        L_0x0f89:
            java.lang.String r2 = "0"
        L_0x0f8b:
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0f90:
            boolean r2 = com.hbg.lib.network.retrofit.util.SPUtil.j()     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x0f99
            java.lang.String r2 = "1"
            goto L_0x0f9b
        L_0x0f99:
            java.lang.String r2 = "0"
        L_0x0f9b:
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0fa0:
            tg.r r2 = tg.r.x()     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.F0()     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x107c }
            r3.success(r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0fb1:
            uf.b r2 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x107c }
            r2.i(r1)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0fba:
            r5 = 1
            java.lang.Object r6 = r2.argument(r8)     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x107c }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x107c }
            if (r7 != 0) goto L_0x0fed
            java.lang.String r7 = "clearTop"
            boolean r7 = r2.hasArgument(r7)     // Catch:{ Exception -> 0x107c }
            if (r7 == 0) goto L_0x0fdc
            java.lang.String r5 = "clearTop"
            java.lang.Object r2 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            boolean r10 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
            goto L_0x0fdd
        L_0x0fdc:
            r10 = r5
        L_0x0fdd:
            if (r10 == 0) goto L_0x0fe4
            r2 = 0
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r1, r6, r9, r9, r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x0fe8
        L_0x0fe4:
            r2 = 0
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebViewNoClear(r1, r6, r9, r9, r2)     // Catch:{ Exception -> 0x107c }
        L_0x0fe8:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x0fed:
            java.lang.String r5 = "-1"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r6.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.method     // Catch:{ Exception -> 0x107c }
            r6.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = "method url is null"
            r6.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x107c }
            r3.error(r5, r2, r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x1007:
            r25.finish()     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x100c:
            java.lang.String r5 = "show"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "dismissable"
            java.lang.Object r2 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x107c }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x102c
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x107c }
            if (r5 == 0) goto L_0x102c
            r1.showProgressDialog((boolean) r2)     // Catch:{ Exception -> 0x107c }
            goto L_0x102f
        L_0x102c:
            r25.dismissProgressDialog()     // Catch:{ Exception -> 0x107c }
        L_0x102f:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x1033:
            r25.wi(r26)     // Catch:{ Exception -> 0x107c }
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x103a:
            java.lang.String r5 = "msg"
            java.lang.Object r5 = r2.argument(r5)     // Catch:{ Exception -> 0x107c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = "position"
            java.lang.Object r6 = r2.argument(r6)     // Catch:{ Exception -> 0x107c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x107c }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x107c }
            if (r7 != 0) goto L_0x1063
            java.lang.String r2 = "top"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x107c }
            if (r2 == 0) goto L_0x105c
            com.hbg.lib.widgets.utils.HuobiToastUtil.v(r5)     // Catch:{ Exception -> 0x107c }
            goto L_0x105f
        L_0x105c:
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r5)     // Catch:{ Exception -> 0x107c }
        L_0x105f:
            r3.success(r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x1063:
            java.lang.String r5 = "-1"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x107c }
            r6.<init>()     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r2.method     // Catch:{ Exception -> 0x107c }
            r6.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = "method  msg is null"
            r6.append(r2)     // Catch:{ Exception -> 0x107c }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x107c }
            r3.error(r5, r2, r4)     // Catch:{ Exception -> 0x107c }
            goto L_0x1084
        L_0x107c:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            r27.notImplemented()
        L_0x1084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.flutter.base.AbsGlobalFlutterActivity.qi(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void ri(MethodCall methodCall, MethodChannel.Result result) {
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        flutterKycConfig.setPhone(r.x().F());
        flutterKycConfig.setEmail(r.x().u());
        String str = (String) methodCall.argument("authBizCode");
        if (!TextUtils.isEmpty(str)) {
            flutterKycConfig.setAuthBizCode(str);
        } else {
            flutterKycConfig.setAuthBizCode(Coupon.SPOT);
        }
        i6.k.o("withdrawKyc", "开启新Kyc页面 authBizCode:" + str);
        b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
    }

    public void showProgressDialog(boolean z11) {
        showProgressDialog((String) null, z11);
    }

    public final void si(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("id")) {
                v0.e(this, (String) methodCall.argument("id"));
                result.success("");
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    @AfterPermissionGranted(123)
    public void ti() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(this, strArr)) {
            pa.d.o().B(false).q(this);
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    @AfterPermissionGranted(124)
    public void ui(int i11) {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            pa.d.o().B(false).v(this, i11);
        } else {
            EasyPermissions.requestPermissions(this, 124, str);
        }
    }

    public boolean useNewStatusBarFunc() {
        return false;
    }

    @AfterPermissionGranted(124)
    public void vi() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.READ_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            pa.d.o().B(false).w(this);
        } else {
            EasyPermissions.requestPermissions(this, 124, str);
        }
    }

    public final boolean wi(MethodCall methodCall) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        if (!TextUtils.isEmpty(str)) {
            l6.a a11 = l6.a.a();
            RuntimeException runtimeException = new RuntimeException(str);
            a11.b(runtimeException, this, "page:" + Nh(), methodCall.method, methodCall.arguments);
        }
        return false;
    }

    public final void yi(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments();
        if ("PRO".equals(str)) {
            Mh(result);
        } else if ("CONTRACT".equals(str)) {
            Eh(result);
        } else if (Coupon.OTC.equals(str)) {
            Ih(result);
        } else if ("PHP".equals(str)) {
            Kh(result);
        } else if ("KYC".equals(str)) {
            Hh(result);
        } else if ("INST".equals(str)) {
            Gh(result);
        } else {
            result.error("-1", "not found " + str + " get token method", (Object) null);
        }
    }

    public final void zh(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments();
        if (map == null) {
            result.error("-1", "methodCall.arguments is null", "");
            return;
        }
        i6.d.j("flutter", "aliyunLog params - " + map);
        result.success((Object) null);
    }

    public void showProgressDialog(String str, boolean z11) {
        if (this.f67686c == null) {
            this.f67686c = new g1(this);
            if (altFocusableIM()) {
                Window window = this.f67686c.getWindow();
                if (window != null) {
                    window.setFlags(131072, 131072);
                } else {
                    return;
                }
            }
        }
        this.f67686c.show();
        this.f67686c.setCanceledOnTouchOutside(z11);
        this.f67686c.setCancelable(z11);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, false);
    }

    public void showProgressDialog() {
        showProgressDialog((String) null);
    }
}
