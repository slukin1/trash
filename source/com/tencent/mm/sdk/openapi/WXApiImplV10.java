package com.tencent.mm.sdk.openapi;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.a.a;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.d;
import com.tencent.wxop.stat.e;

final class WXApiImplV10 implements IWXAPI {
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    /* access modifiers changed from: private */
    public static ActivityLifecycleCb activityCb;
    private static String wxappPayEntryClassname;
    private String appId;
    private boolean checkSignature = false;
    private Context context;
    private boolean detached = false;

    public static final class ActivityLifecycleCb implements Application.ActivityLifecycleCallbacks {
        private static final int DELAYED = 800;
        private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
        /* access modifiers changed from: private */
        public Context context;
        private Handler handler;
        /* access modifiers changed from: private */
        public boolean isForeground;
        private Runnable onPausedRunnable;
        private Runnable onResumedRunnable;

        private ActivityLifecycleCb(Context context2) {
            this.isForeground = false;
            this.handler = new Handler(Looper.getMainLooper());
            this.onPausedRunnable = new Runnable() {
                public void run() {
                    if (WXApiImplV10.activityCb != null && ActivityLifecycleCb.this.isForeground) {
                        Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onBackground");
                        e.d(ActivityLifecycleCb.this.context, "onBackground_WX");
                        boolean unused = ActivityLifecycleCb.this.isForeground = false;
                    }
                }
            };
            this.onResumedRunnable = new Runnable() {
                public void run() {
                    if (WXApiImplV10.activityCb != null && !ActivityLifecycleCb.this.isForeground) {
                        Log.v(ActivityLifecycleCb.TAG, "WXStat trigger onForeground");
                        e.d(ActivityLifecycleCb.this.context, "onForeground_WX");
                        boolean unused = ActivityLifecycleCb.this.isForeground = true;
                    }
                }
            };
            this.context = context2;
        }

        public final void detach() {
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.context = null;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityPaused");
            this.handler.removeCallbacks(this.onResumedRunnable);
            this.handler.postDelayed(this.onPausedRunnable, 800);
        }

        public final void onActivityResumed(Activity activity) {
            Log.v(TAG, activity.getComponentName().getClassName() + "  onActivityResumed");
            this.handler.removeCallbacks(this.onPausedRunnable);
            this.handler.postDelayed(this.onResumedRunnable, 800);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }
    }

    public WXApiImplV10(Context context2, String str, boolean z11) {
        a.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z11);
        this.context = context2;
        this.appId = str;
        this.checkSignature = z11;
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = "checkSumConsistent fail, length is different";
        } else {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
            }
            return true;
        }
        a.a(TAG, str);
        return false;
    }

    private void initMta(Context context2, String str) {
        String str2 = "AWXOP" + str;
        c.b(context2, str2);
        c.w();
        c.a(d.PERIOD);
        c.t();
        c.c(context2, "Wechat_Sdk");
        try {
            e.a(context2, str2, "2.0.3");
        } catch (com.tencent.wxop.stat.a e11) {
            e11.printStackTrace();
        }
    }

    private boolean sendAddCardToWX(Context context2, Bundle bundle) {
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizProfileReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), sb2.toString(), sb3.toString()}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToBizWebviewReq(Context context2, Bundle bundle) {
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
        Cursor query = contentResolver.query(parse, (String[]) null, (String) null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), sb2.toString()}, (String) null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", (String) null);
            a.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                a.a(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        a.C0179a aVar = new a.C0179a();
        aVar.f22726n = bundle;
        aVar.f22723k = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        aVar.f22724l = wxappPayEntryClassname;
        return com.tencent.mm.sdk.a.a.a(context2, aVar);
    }

    public final void detach() {
        Application application;
        com.tencent.mm.sdk.b.a.d(TAG, "detach");
        this.detached = true;
        if (activityCb != null && Build.VERSION.SDK_INT >= 14) {
            Context context2 = this.context;
            if (context2 instanceof Activity) {
                application = ((Activity) context2).getApplication();
            } else {
                if (context2 instanceof Service) {
                    application = ((Service) context2).getApplication();
                }
                activityCb.detach();
            }
            application.unregisterActivityLifecycleCallbacks(activityCb);
            activityCb.detach();
        }
        this.context = null;
    }

    public final int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (isWXAppInstalled()) {
            return new MMSharedPreferences(this.context).getInt("_build_info_sdk_int_", 0);
        } else {
            com.tencent.mm.sdk.b.a.a(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            com.tencent.mm.sdk.b.a.c(TAG, "handleIntent fail, intent not from weixin msg");
            return false;
        } else if (!this.detached) {
            String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                com.tencent.mm.sdk.b.a.a(TAG, "invalid argument");
                return false;
            } else if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), b.a(stringExtra, intExtra, stringExtra2))) {
                com.tencent.mm.sdk.b.a.a(TAG, "checksum fail");
                return false;
            } else {
                int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                if (intExtra2 != 9) {
                    switch (intExtra2) {
                        case 1:
                            iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                            return true;
                        case 2:
                            iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                            return true;
                        case 3:
                            iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                            return true;
                        case 4:
                            iWXAPIEventHandler.onReq(new ShowMessageFromWX.Req(intent.getExtras()));
                            return true;
                        case 5:
                            iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                            return true;
                        case 6:
                            iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                            return true;
                        default:
                            com.tencent.mm.sdk.b.a.a(TAG, "unknown cmd = " + intExtra2);
                            return false;
                    }
                } else {
                    iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                    return true;
                }
            }
        } else {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
    }

    public final boolean isWXAppInstalled() {
        if (!this.detached) {
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 64);
                if (packageInfo == null) {
                    return false;
                }
                return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
    }

    public final boolean isWXAppSupportAPI() {
        if (!this.detached) {
            return getWXAppSupportAPI() >= 570490883;
        }
        throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
    }

    public final boolean openWXApp() {
        String str;
        if (!this.detached) {
            if (!isWXAppInstalled()) {
                str = "open wx app failed, not installed or signature check failed";
            } else {
                try {
                    Context context2 = this.context;
                    context2.startActivity(context2.getPackageManager().getLaunchIntentForPackage(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME));
                    return true;
                } catch (Exception e11) {
                    str = "startActivity fail, exception = " + e11.getMessage();
                }
            }
            com.tencent.mm.sdk.b.a.a(TAG, str);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    public final boolean registerApp(String str) {
        Application application;
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "register app failed for wechat app signature check failed");
            return false;
        } else {
            if (activityCb == null && Build.VERSION.SDK_INT >= 14) {
                Context context2 = this.context;
                if (context2 instanceof Activity) {
                    initMta(context2, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Activity) this.context).getApplication();
                } else if (context2 instanceof Service) {
                    initMta(context2, str);
                    activityCb = new ActivityLifecycleCb(this.context);
                    application = ((Service) this.context).getApplication();
                } else {
                    com.tencent.mm.sdk.b.a.b(TAG, "context is not instanceof Activity or Service, disable WXStat");
                }
                application.registerActivityLifecycleCallbacks(activityCb);
            }
            com.tencent.mm.sdk.b.a.d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            com.tencent.mm.sdk.b.a.d(TAG, "register app " + this.context.getPackageName());
            a.C0180a aVar = new a.C0180a();
            aVar.f22729o = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
            aVar.f22730p = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            aVar.f22727m = "weixin://registerapp?appid=" + this.appId;
            return com.tencent.mm.sdk.a.a.a.a(this.context, aVar);
        }
    }

    public final boolean sendReq(BaseReq baseReq) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
                str = "sendReq failed for wechat app signature check failed";
            } else if (!baseReq.checkArgs()) {
                str = "sendReq checkArgs fail";
            } else {
                com.tencent.mm.sdk.b.a.d(TAG, "sendReq, req type = " + baseReq.getType());
                Bundle bundle = new Bundle();
                baseReq.toBundle(bundle);
                if (baseReq.getType() == 5) {
                    return sendPayReq(this.context, bundle);
                }
                if (baseReq.getType() == 7) {
                    return sendJumpToBizProfileReq(this.context, bundle);
                }
                if (baseReq.getType() == 8) {
                    return sendJumpToBizWebviewReq(this.context, bundle);
                }
                if (baseReq.getType() == 9) {
                    return sendAddCardToWX(this.context, bundle);
                }
                a.C0179a aVar = new a.C0179a();
                aVar.f22726n = bundle;
                aVar.f22725m = "weixin://sendreq?appid=" + this.appId;
                aVar.f22723k = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
                aVar.f22724l = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                return com.tencent.mm.sdk.a.a.a(this.context, aVar);
            }
            com.tencent.mm.sdk.b.a.a(TAG, str);
            return false;
        }
        throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }

    public final boolean sendResp(BaseResp baseResp) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (!baseResp.checkArgs()) {
                str = "sendResp checkArgs fail";
            } else {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                a.C0179a aVar = new a.C0179a();
                aVar.f22726n = bundle;
                aVar.f22725m = "weixin://sendresp?appid=" + this.appId;
                aVar.f22723k = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
                aVar.f22724l = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                return com.tencent.mm.sdk.a.a.a(this.context, aVar);
            }
            com.tencent.mm.sdk.b.a.a(TAG, str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    public final void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            com.tencent.mm.sdk.b.a.a(TAG, "unregister app failed for wechat app signature check failed");
        } else {
            com.tencent.mm.sdk.b.a.d(TAG, "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                com.tencent.mm.sdk.b.a.a(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            com.tencent.mm.sdk.b.a.d(TAG, "unregister app " + this.context.getPackageName());
            a.C0180a aVar = new a.C0180a();
            aVar.f22729o = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
            aVar.f22730p = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            aVar.f22727m = "weixin://unregisterapp?appid=" + this.appId;
            com.tencent.mm.sdk.a.a.a.a(this.context, aVar);
        }
    }
}
