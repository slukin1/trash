package com.huobi.flutter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.AppSettingsDialog;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.ImageUtils;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.android.tpush.common.Constants;
import i6.l;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.FlutterView;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import pa.d;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import tg.r;
import tq.p;
import u6.g;

@Deprecated
public abstract class BaseFlutterActivity extends EmptyMVPActivity implements MethodChannel.MethodCallHandler, EasyPermissions.PermissionCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public FlutterView f67663b;

    /* renamed from: c  reason: collision with root package name */
    public MethodChannel.Result f67664c;

    public class a implements pa.a {

        /* renamed from: com.huobi.flutter.BaseFlutterActivity$a$a  reason: collision with other inner class name */
        public class C0735a extends EasySubscriber<File> {
            public C0735a() {
            }

            /* renamed from: a */
            public void onNext(File file) {
                super.onNext(file);
                BaseFlutterActivity.this.f67664c.success(file.getAbsolutePath());
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
                BaseFlutterActivity.this.f67664c.success("");
            }
        }

        public class b implements Func1<String, File> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Uri f67667b;

            public b(Uri uri) {
                this.f67667b = uri;
            }

            /* renamed from: a */
            public File call(String str) {
                return ImageUtils.f(BaseFlutterActivity.this, this.f67667b.getPath(), 5.0d);
            }
        }

        public a() {
        }

        public void a(Uri uri, String str, boolean z11) {
            if (BaseFlutterActivity.this.f67664c != null) {
                Observable.just("").map(new b(uri)).compose(RxJavaHelper.t(BaseFlutterActivity.this.getUI())).subscribe(new C0735a());
            }
        }

        public void b(String str) {
            if (BaseFlutterActivity.this.f67664c != null) {
                BaseFlutterActivity.this.f67664c.success("");
            }
        }

        public void c(LinkedHashMap<String, Boolean> linkedHashMap, String[] strArr) {
        }

        public void onCancel() {
            if (BaseFlutterActivity.this.f67664c != null) {
                BaseFlutterActivity.this.f67664c.success("");
            }
        }
    }

    public class b extends EasySubscriber<ProUserToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67669b;

        public b(MethodChannel.Result result) {
            this.f67669b = result;
        }

        /* renamed from: a */
        public void onNext(ProUserToken proUserToken) {
            super.onNext(proUserToken);
            r.x().v0(proUserToken.getToken());
            this.f67669b.success(proUserToken.getToken());
        }

        public void onError2(Throwable th2) {
            th2.printStackTrace();
            try {
                this.f67669b.error("512", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            try {
                this.f67669b.error("512", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class c extends BaseSubscriber<ContractUserInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67671b;

        public c(MethodChannel.Result result) {
            this.f67671b = result;
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo contractUserInfo) {
            super.onNext(contractUserInfo);
            if (contractUserInfo == null || contractUserInfo.getUser() == null) {
                this.f67671b.error("flutter get dm token error ", "", "");
                return;
            }
            ContractUserInfoProvider.i().z(contractUserInfo.getUser());
            r.x().k0(contractUserInfo.getHbsession());
            this.f67671b.success("flutter get dm token success ");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            try {
                this.f67671b.error("flutter get dm token error 2", "", "");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Observable oh(LoginInfoData loginInfoData) {
        if (loginInfoData == null || TextUtils.isEmpty(loginInfoData.getTicket())) {
            return Observable.error(new RuntimeException("flutter get dm token error 1"));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FLAG_TICKET, loginInfoData.getTicket());
        return ((ContractService) p.p(ContractService.class)).login(hashMap).compose(ContractRetrofit.h());
    }

    public final void Og(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(cl.a.f13110b).compose(RxJavaHelper.t((g) null)).subscribe(new c(result));
    }

    public void Pg(MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().Q("flutter pro").compose(p.c0()).flatMap(cl.b.f13111b).compose(RxJavaHelper.t((g) null)).subscribe(new b(result));
    }

    public abstract String Qg();

    public int getContentView() {
        return R.layout.activity_flutter_base;
    }

    @AfterPermissionGranted(123)
    public void gg() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(this, strArr)) {
            d.o().B(false).q(this);
        } else {
            EasyPermissions.requestPermissions(this, 123, strArr);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            d.o().C(new a()).x(this, i11, i12, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cl.c.a(Qg(), BaseActivity.getStatusBarHeight(this));
        this.f67663b.setZOrderOnTop(true);
        this.f67663b.getHolder().setFormat(-3);
        ((RelativeLayout) this.viewFinder.b(R.id.rl_flutter_area)).addView(this.f67663b);
        new MethodChannel(this.f67663b, Constants.MessageTypes.SEND_EVENT).setMethodCallHandler(this);
        new MethodChannel(this.f67663b, "request_token").setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("reportFlutterError".equals(str)) {
                rh(methodCall);
            } else if ("platformToast".equals(str)) {
                String str2 = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
                String str3 = (String) methodCall.argument("position");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(str3)) {
                    HuobiToastUtil.v(str2);
                } else {
                    HuobiToastUtil.m(str2);
                }
            } else if ("platformOpenWebView".equals(str)) {
                String str4 = (String) methodCall.argument("url");
                if (!TextUtils.isEmpty(str4)) {
                    HBBaseWebActivity.showWebView(this, str4, "", "", false);
                }
            } else if ("requestToken".equals(str)) {
                String str5 = (String) methodCall.arguments();
                if ("PRO".equals(str5)) {
                    Pg(result);
                }
                if ("CONTRACT".equals(str5)) {
                    Og(result);
                }
            } else if ("popPage".equals(str)) {
                finish();
            } else if ("imagePicker".equals(str)) {
                sh(methodCall, result);
            } else if ("platformShowHUD".equals(str)) {
                Boolean bool = (Boolean) methodCall.argument("show");
                if (bool == null || !bool.booleanValue()) {
                    getUI().dismissProgressDialog();
                } else {
                    getUI().showProgressDialog(true);
                }
            } else if ("getNetworkState".equals(str)) {
                Boolean bool2 = (Boolean) methodCall.argument("needToast");
                boolean h11 = l.h(this);
                result.success(Boolean.valueOf(h11));
                if (bool2 != null && bool2.booleanValue() && !h11) {
                    HuobiToastUtil.j(R.string.string_network_disconnect);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder((Activity) this, getString(R.string.permission_camera_write_external_storage_apply)).setTitle(getString(R.string.permission_apply)).setPositiveButton(getString(R.string.go_to_settings)).setNegativeButton(getString(R.string.global_string_cancel), (DialogInterface.OnClickListener) null).setRequestCode(125).build().show();
        }
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        if (i11 == 123) {
            d.o().B(false).q(this);
        } else if (i11 == 124) {
            d.o().B(false).t(this);
        }
    }

    @AfterPermissionGranted(124)
    public void qh() {
        String str = Build.VERSION.SDK_INT >= 33 ? PermissionConfig.READ_MEDIA_IMAGES : PermissionConfig.WRITE_EXTERNAL_STORAGE;
        if (EasyPermissions.hasPermissions(this, str)) {
            d.o().B(false).w(this);
        } else {
            EasyPermissions.requestPermissions(this, 124, str);
        }
    }

    public final boolean rh(MethodCall methodCall) {
        String str = (String) methodCall.argument(RemoteMessageConst.MessageBody.MSG);
        if (!TextUtils.isEmpty(str)) {
            l6.a a11 = l6.a.a();
            RuntimeException runtimeException = new RuntimeException(str);
            a11.b(runtimeException, this, "page:" + Qg(), methodCall.method, methodCall.arguments);
        }
        return false;
    }

    public final void sh(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("type");
        this.f67664c = result;
        if ("0".equals(str)) {
            qh();
        } else if ("1".equals(str)) {
            gg();
        } else {
            qh();
        }
    }
}
