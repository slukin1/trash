package com.huobi.webview2.action;

import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.x;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.annotation.ActionAnnotation;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.otc.event.OtcEditAdResultEvent;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.jumio.sdk.reject.JumioRejectReason;
import i6.d;
import i6.k;
import i6.m;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import jp.k0;
import jp.l;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import tg.r;
import tq.p;
import u6.g;
import v6.t;
import v6.u;
import x6.b;

public final class JsOtcActionHelper {
    public static final String ACTION_FIAT_DEPOSIT_KYC_CODE = "20010093";
    public static final String ACTION_GET_OTC_TOKEN = "20010068";
    public static final String ACTION_GET_PRO_TOKEN = "20010070";
    public static final String ACTION_GET_UC_TOKEN = "20010069";
    public static final String ACTION_OTC_ADS_OPEN_NATIVE_PAGE = "20010073";
    public static final String ACTION_OTC_ADS_RESPONSE = "20010072";
    public static final String ACTION_OTC_CLIENT_TYPE = "20010071";
    public static final String ACTION_OTC_FIAT_DEPOSIT_OPEN_NATIVE_PAGE = "20010091";
    public static final String ACTION_VISIBLE_WEB_TOOLBAR = "20010092";
    public static final int CODE_OK = 200;
    private static final String LOG_KEY = "JsOtcActionHelper_Log:";

    private JsOtcActionHelper() {
    }

    @ActionAnnotation("20010073")
    public static void adsH5OpenNativePage(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f(LOG_KEY, "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                k.f(LOG_KEY, "jsMsg ====== adsH5OpenNativePage" + jsMessage.getData());
                Map map = (Map) jsMessage.getData();
                if (map.containsKey("target") && map.get("target") != null) {
                    String obj = map.get("target").toString();
                    if (TextUtils.equals("openPaymentList", obj)) {
                        k0.d().g(uVar.getActivity(), uVar);
                    } else if (TextUtils.equals(obj, "openTransfer") && map.containsKey(FirebaseAnalytics.Param.CURRENCY) && map.containsKey("type")) {
                        uVar.setHBWebViewLifecycleCallback(new u0(jsMessage, uVar));
                        UnifyTransferActivity.Uh(uVar.getActivity(), (String) map.get(FirebaseAnalytics.Param.CURRENCY), "1", false, (String) null, false);
                    }
                }
            }
        }
    }

    @ActionAnnotation("20010093")
    public static void depositKycCode(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f(LOG_KEY, "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                k.f(LOG_KEY, "jsMsg ====== fiatDepositOpenNativePage" + jsMessage.getData());
                Map map = (Map) jsMessage.getData();
                if (map.containsKey("code") && map.get("code") != null) {
                    try {
                        List asList = Arrays.asList(new String[]{"300029", "300030", "300031", "300032", "300033", "300017"});
                        String str = (String) map.get("code");
                        if (asList.contains(str)) {
                            ThreadUtils.h(new q0(str, uVar));
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }

    @ActionAnnotation("20010091")
    public static void fiatDepositOpenNativePage(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f(LOG_KEY, "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                k.f(LOG_KEY, "jsMsg ====== fiatDepositOpenNativePage" + jsMessage.getData());
                Map map = (Map) jsMessage.getData();
                if (map.containsKey("coinName") && map.get("coinName") != null) {
                    String obj = map.get("coinName").toString();
                    new OtcFaitDWJumpHelper((FragmentActivity) uVar.getActivity(), uVar, obj).t(OtcFaitDWJumpHelper.f78855g, obj);
                }
            }
        }
    }

    private static boolean forbidCall(u uVar) {
        if (!(uVar instanceof HBBaseWebActivity)) {
            return true;
        }
        String host = Uri.parse(OtcModuleConfig.a().t()).getHost();
        HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
        String host2 = Uri.parse(hBBaseWebActivity.getIntent() != null ? hBBaseWebActivity.getIntent().getStringExtra("url") : "").getHost();
        return TextUtils.isEmpty(host2) || !host2.equals(host);
    }

    @ActionAnnotation("20010072")
    public static void getOtcAdsResponse(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f(LOG_KEY, "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                k.f(LOG_KEY, "jsMsg ====== getOtcAdsResponse" + jsMessage.getData());
                Map map = (Map) jsMessage.getData();
                if (map.containsKey("code") && map.get("code") != null && m.a(map.get("code").toString()).compareTo(m.a(JumioRejectReason.NOT_READABLE)) == 0) {
                    uVar.getActivity().finish();
                    EventBus.d().k(new OtcEditAdResultEvent());
                }
            }
        }
    }

    @ActionAnnotation("20010071")
    public static void getOtcDeviceInfoJsonStr(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientName", (Object) "android_global");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        String json = jSONObject.toString();
        String str = "WebViewJsCallback-->dealWithSession--> action:" + callback + " OtcDeviceInfoJsonStr:" + json;
        d.b(str);
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setData(json);
        jsMessage2.setAction(callback);
        b.d(jsMessage2, uVar);
        k.f(LOG_KEY, str);
    }

    @ActionAnnotation("20010068")
    public static void getOtcTokenFromH5(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        String E = r.x().E();
        String str = "WebViewJsCallback-->getOtcTokenFromH5--> action:" + callback + " otcToken11:" + E;
        d.b(str);
        if (!r.x().F0() || !TextUtils.isEmpty(E)) {
            JsMessage jsMessage2 = new JsMessage();
            jsMessage2.setCode(200);
            jsMessage2.setData(E);
            jsMessage2.setAction(callback);
            b.d(jsMessage2, uVar);
            k.f(LOG_KEY, str);
            return;
        }
        l.q(false).subscribe(new r0(uVar, callback));
    }

    @ActionAnnotation("20010070")
    public static void getProTokenFromH5(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        String H = r.x().H();
        String str = "WebViewJsCallback-->getProTokenFromH5--> action:" + callback + " proToken11:" + H;
        d.b(str);
        if (!r.x().F0() || !TextUtils.isEmpty(H)) {
            JsMessage jsMessage2 = new JsMessage();
            jsMessage2.setCode(200);
            jsMessage2.setData(H);
            jsMessage2.setAction(callback);
            b.d(jsMessage2, uVar);
            k.f(LOG_KEY, str);
            return;
        }
        UserCenterRemoteDataSource.A().P().compose(p.c0()).flatMap(t0.f20876b).compose(RxJavaHelper.t((g) null)).subscribe(new s0(uVar, callback));
    }

    @ActionAnnotation("20010069")
    public static void getUcTokenFromH5(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        String I = r.x().I();
        String str = "WebViewJsCallback-->dealWithSession--> action:" + callback + " ucToken:" + I;
        d.b(str);
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setData(I);
        jsMessage2.setAction(callback);
        b.d(jsMessage2, uVar);
        k.f(LOG_KEY, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$adsH5OpenNativePage$3(JsMessage jsMessage, u uVar) {
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setData("");
        jsMessage2.setAction(jsMessage.getCallback());
        b.d(jsMessage2, uVar);
        uVar.setHBWebViewLifecycleCallback((t) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$depositKycCode$4(u uVar, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        uVar.getActivity().finish();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$depositKycCode$5(u uVar, HBDialogFragment hBDialogFragment) {
        OtcModuleConfig.b().L();
        hBDialogFragment.dismiss();
        uVar.getActivity().finish();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$depositKycCode$6(String str, u uVar) {
        if (TextUtils.equals("300033", str)) {
            DialogUtils.X((FragmentActivity) uVar.getActivity(), x.b(R.string.n_kyc_authentication_fail), x.b(R.string.n_otc_kyc_id_expired), "", x.b(R.string.n_known), new o0(uVar));
        } else {
            DialogUtils.c0((FragmentActivity) uVar.getActivity(), x.b(R.string.n_otc_high_level_kyc), "", x.b(R.string.n_cancel), x.b(R.string.n_otc_go_verification), o0.f12469a, new p0(uVar));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getOtcTokenFromH5$0(u uVar, String str, UserVO userVO) {
        if (uVar != null && uVar.isAlive()) {
            String q11 = r.x().q();
            String str2 = "WebViewJsCallback-->getOtcTokenFromH5--> action:" + str + " otcToken22:" + q11;
            d.b(str2);
            JsMessage jsMessage = new JsMessage();
            jsMessage.setCode(200);
            jsMessage.setData(q11);
            jsMessage.setAction(str);
            b.d(jsMessage, uVar);
            k.f(LOG_KEY, str2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getProTokenFromH5$2(u uVar, String str, ProUserToken proUserToken) {
        r.x().v0(proUserToken.getToken());
        if (uVar != null && uVar.isAlive()) {
            String token = proUserToken.getToken();
            String str2 = "WebViewJsCallback-->getOtcTokenFromH5--> action:" + str + " otcToken22:" + token;
            d.b(str2);
            JsMessage jsMessage = new JsMessage();
            jsMessage.setCode(200);
            jsMessage.setData(token);
            jsMessage.setAction(str);
            b.d(jsMessage, uVar);
            k.f(LOG_KEY, str2);
        }
    }

    @ActionAnnotation("20010092")
    public static void visibleWebToolbar(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f(LOG_KEY, "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                k.f(LOG_KEY, "jsMsg ====== fiatDepositOpenNativePage" + jsMessage.getData());
                Map map = (Map) jsMessage.getData();
                if (map.containsKey(MessengerShareContentUtility.SHARE_BUTTON_HIDE) && map.get(MessengerShareContentUtility.SHARE_BUTTON_HIDE) != null) {
                    try {
                        boolean booleanValue = ((Boolean) map.get(MessengerShareContentUtility.SHARE_BUTTON_HIDE)).booleanValue();
                        if (uVar.getActivity() instanceof HBBaseWebActivity) {
                            ((HBBaseWebActivity) uVar.getActivity()).visibleToolbar(booleanValue);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }
}
