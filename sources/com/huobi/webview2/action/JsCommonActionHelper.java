package com.huobi.webview2.action;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.alibaba.fastjson.JSON;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.annotation.ActionAnnotation;
import com.hbg.lib.core.webview.bean.AlertInfo;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.core.webview.bean.JsStrMessage;
import com.hbg.lib.imsdk.HbgDialogJsWidthHeight;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.helper.UserLoginHelper;
import com.huobi.contract.entity.WebLanguageData;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.entity.CloudWalletInfo;
import com.huobi.entity.PlatformInfo;
import com.huobi.finance.bean.FiatDWEntrance;
import com.huobi.finance.ui.DepositFiatFromCoinActivity;
import com.huobi.finance.ui.WithdrawFiatFromCoinActivity;
import com.huobi.invite.ui.g;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.otc.event.CloseFastTradeDialogEvent;
import com.huobi.otc.ui.OtcCardManagerActivity;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.manager.ShareManager;
import com.huobi.utils.k0;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.webview2.ui.IndexWebActivity;
import com.huobi.webview2.ui.LoginWebActivity;
import com.huochat.community.network.domain.DomainTool;
import com.huochat.community.util.EncryptTool;
import com.iproov.sdk.bridge.OptionsBridge;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import i6.d;
import i6.i;
import i6.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
import pr.a;
import pro.huobi.R;
import rx.Observable;
import tg.h;
import tg.r;
import v6.u;
import x6.b;

public final class JsCommonActionHelper {
    public static final String ACTION_APPBAR = "20010025";
    public static final String ACTION_BACK_DIALOG = "20010019";
    public static final String ACTION_BASE_INFO = "00000000";
    public static final String ACTION_CLEAR_HISTORY = "20010044";
    public static final String ACTION_CLOSE_HBG_DIALOG = "20010098";
    public static final String ACTION_CLOSE_PRE_WEB_ACTIVITY = "20010045";
    public static final String ACTION_CLOUD_WALLET_COMMUNICATE_SDK = "20010076";
    public static final String ACTION_CLOUD_WALLET_H5_SDK_DATA = "20010064";
    public static final String ACTION_CLOUD_WALLET_INFO = "20010065";
    public static final String ACTION_CLOUD_WALLET_TRANSFER = "20010067";
    public static final String ACTION_COMMON_JUMP_NATIVE = "20010038";
    public static final String ACTION_CONTRACT_CALCULATE = "20010005";
    public static final String ACTION_CONTRACT_OPEN_SUCC = "20010004";
    public static final String ACTION_CONTRACT_SYMBOL = "20010007";
    public static final String ACTION_FIAT_DEPOSIT = "20010047";
    public static final String ACTION_FIAT_WITHDRAW = "20010048";
    public static final String ACTION_FINISH = "20010006";
    public static final String ACTION_GET_BOTTOM_HEIGHT = "20010077";
    public static final String ACTION_GET_H5_URL = "20010079";
    public static final String ACTION_GET_LANGUAGE = "20010001";
    public static final String ACTION_GET_TOP_HEIGHT = "20010078";
    public static final String ACTION_H5_LOGIN_SUCCESS = "20010009";
    public static final String ACTION_H5_POST_URL = "20010106";
    public static final String ACTION_INVITE_SHARE = "20010046";
    public static final String ACTION_JUMP_DAPP = "20010066";
    public static final String ACTION_JUMP_POOL_INDEX = "20010041";
    public static final String ACTION_NOTIFY_EXIT = "20010102";
    public static final String ACTION_NOTIFY_INTERCEPT_EXIT = "20010101";
    public static final String ACTION_OPEN_NEW_WEB_ACTIVITY = "20010043";
    public static final String ACTION_OPEN_WALLET_APP = "20010062";
    public static final String ACTION_OTC_BIND_CARD = "20010060";
    public static final String ACTION_POTENTIALS = "20010029";
    public static final String ACTION_PREVIEW_IMAGE = "20010085";
    public static final String ACTION_PULL_TO_REFRESH_FINISH = "20010022";
    public static final String ACTION_RELOAD_META = "20010040";
    public static final String ACTION_SET_TOP_BAR_COLOR = "20010037";
    public static final String ACTION_SHARE_BASE64_IMAGE = "20010018";
    public static final String ACTION_SHARE_IMAGE = "20010008";
    public static final String ACTION_SHOW_CLOSE_BUTTON = "20010034";
    public static final String ACTION_SHOW_HBG_DIALOG = "20010099";
    public static final String ACTION_SHOW_RIGHT_BUTTON = "20010035";
    public static final String ACTION_SHOW_TOP_BAR = "20010036";
    public static final String ACTION_SHOW_TOP_ICON = "20010049";
    public static final String ACTION_TOAST = "20010012";
    public static final String ACTION_VERIFY_CODE = "10075945";
    public static final String ACTION_VERIFY_SUCCESS = "10075946";
    public static final int CODE_OK = 200;
    public static final int REQUEST_CODE_CLOUD_WALLET_REFRESH_PAGE = 1002;
    private static final String TAG = "JsCommonActionHelper";
    private static String deviceFingerprint = "";

    private JsCommonActionHelper() {
    }

    /* access modifiers changed from: private */
    public static void callBackActionResult(int i11, String str, JsMessage jsMessage, u uVar) {
        if (jsMessage == null || TextUtils.isEmpty(jsMessage.getCallback()) || jsMessage.getCallback().equals(OptionsBridge.NULL_VALUE)) {
            Log.e(TAG, "callBackActionResult: 没有callback的值,不用回调了");
            return;
        }
        JsStrMessage jsStrMessage = new JsStrMessage();
        jsStrMessage.setCode(i11);
        jsStrMessage.setMsg(str);
        jsStrMessage.setAction(jsMessage.getCallback());
        b.d(jsStrMessage, uVar);
    }

    private static boolean canUseNewShare(Map<String, Object> map) {
        boolean z11 = map.containsKey("useNewShare") && (map.get("useNewShare") instanceof Boolean) && ((Boolean) map.get("useNewShare")).booleanValue();
        Log.d(TAG, "useNewShare -入口- :" + z11);
        return z11;
    }

    @ActionAnnotation("20010044")
    public static void clearHistory(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getWebView() != null) {
            uVar.getWebView().clearHistory();
        }
    }

    @ActionAnnotation(actionName = "actionAdsClose", value = "20010098")
    public static void closeHbgDialog(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            Activity activity = uVar.getActivity();
            if (!NetworkStatus.c(activity)) {
                HuobiToastUtil.k(activity, R.string.string_network_disconnect);
                return;
            }
            Object data = jsMessage.getData();
            if (data instanceof Map) {
                long j11 = 0;
                try {
                    j11 = ((Double) ((Map) data).get("dialogId")).longValue();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                HbgDialogManager.A().w(j11);
                HbgDialogManager.A().W(j11);
            }
        }
    }

    @ActionAnnotation(actionName = "closePreWebView", value = "20010045")
    public static void closePreWebViewActivity(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            uVar.getActivity().setResult(1001);
        }
    }

    @ActionAnnotation(actionName = "customTopBar", value = "20010095")
    public static void customTopBar(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
            hBBaseWebActivity.runOnUiThread(new b0(hBBaseWebActivity, jsMessage));
        }
    }

    @ActionAnnotation(actionName = "showToast", value = "20010012")
    public static void dealToast(JsMessage jsMessage) {
        if (jsMessage.getData() instanceof Map) {
            Map map = (Map) jsMessage.getData();
            if (map.containsKey("position") && map.containsKey("text")) {
                String str = (String) map.get("text");
                if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals((String) map.get("position"))) {
                    HuobiToastUtil.v(str);
                } else {
                    HuobiToastUtil.m(str);
                }
            }
        } else if (jsMessage.getData() instanceof String) {
            String str2 = (String) jsMessage.getData();
            if (!TextUtils.isEmpty(str2)) {
                HuobiToastUtil.m(str2);
            }
        }
    }

    @ActionAnnotation("20010025")
    public static void dealWithActionBar(JsMessage jsMessage, u uVar) {
        if (jsMessage.getData() instanceof Map) {
            Map map = (Map) jsMessage.getData();
            boolean z11 = false;
            if (map.containsKey("canShare")) {
                z11 = ((Boolean) map.get("canShare")).booleanValue();
            }
            uVar.showActionBarShare(z11);
        }
    }

    @ActionAnnotation(actionName = "commonData", value = "00000000")
    public static void dealWithBasePlatformInfo(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        JsMessage jsMessage2 = new JsMessage();
        PlatformInfo platformInfo = new PlatformInfo();
        platformInfo.setTheme(NightHelper.e().g() ? "1" : "0");
        if (r.x().F0()) {
            platformInfo.setUid(r.x().J());
        }
        platformInfo.setUuid(r.x().Q());
        platformInfo.setGlobalApi(DomainSwitcher.O().replace("/-/x/pro/", ""));
        platformInfo.setOtcApi(DomainSwitcher.M());
        platformInfo.setHbdmApi(DomainSwitcher.x());
        platformInfo.setIsLogin(r.x().F0() ? 1 : 0);
        platformInfo.setQuotedCurrency(StringUtils.i(LegalCurrencyConfigUtil.y()));
        if (w.l()) {
            platformInfo.setColorRise(0);
        } else {
            platformInfo.setColorRise(1);
        }
        platformInfo.f44608fp = m0.a();
        platformInfo.fpmd5 = EncryptTool.md5(m0.a());
        if (TextUtils.isEmpty(deviceFingerprint)) {
            ku.b.e().b(j.c().getApplicationContext());
            deviceFingerprint = ku.b.e().h(j.c().getApplicationContext());
        }
        platformInfo.setVtoken(deviceFingerprint);
        platformInfo.setLanguage(AppLanguageHelper.getInstance().getCurLanguageHeader());
        platformInfo.setPhone(r.x().F());
        platformInfo.setEmail(r.x().u());
        if (r.x().M() != null) {
            platformInfo.setAccountName(r.x().o(r.x().M()));
            platformInfo.setFullname(r.x().M().f());
            platformInfo.setUserType(r.x().M().j());
            platformInfo.setCountryCode(r.x().M().c());
        }
        platformInfo.setDid(r.x().t());
        platformInfo.setUserName(r.x().N());
        platformInfo.setNftInfo(r.x().D());
        platformInfo.setAvatar(r.x().p());
        platformInfo.setKycCountry(r.x().A());
        platformInfo.setIpCountry(r.x().y());
        platformInfo.setPasskeyUsable(h.c().i());
        if (uVar instanceof HBBaseWebActivity) {
            try {
                ((HBBaseWebActivity) uVar).runOnUiThread(new h0(uVar, platformInfo, jsMessage2, callback));
            } catch (Exception unused) {
                jsMessage2.setData(platformInfo);
                jsMessage2.setCode(200);
                jsMessage2.setAction(callback);
                b.e(jsMessage2, uVar, false);
            }
        } else {
            jsMessage2.setData(platformInfo);
            jsMessage2.setCode(200);
            jsMessage2.setAction(callback);
            b.e(jsMessage2, uVar, false);
        }
    }

    @ActionAnnotation("20010064")
    public static void dealWithCloudWalletSdkData(JsMessage jsMessage, u uVar) {
    }

    @ActionAnnotation("20010001")
    public static void dealWithLanguage(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        d.b("JsMessageHelper-->dealWithLanguage-->action:" + callback);
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setData(new WebLanguageData(AppLanguageHelper.getInstance().getCurLanguageHeader()));
        jsMessage2.setAction(callback);
        b.d(jsMessage2, uVar);
    }

    @ActionAnnotation("20010065")
    public static void dealWithWalletInfo(JsMessage jsMessage, u uVar) {
        k.f("CLOUD_WALLET_H5", "ACTION_CLOUD_WALLET_INFO jsMsg = " + jsMessage);
        String callback = jsMessage.getCallback();
        JsMessage jsMessage2 = new JsMessage();
        CloudWalletInfo cloudWalletInfo = new CloudWalletInfo();
        cloudWalletInfo.setCurrencyUnit(LegalCurrencyConfigUtil.y().toUpperCase());
        cloudWalletInfo.setCurrencyCharacter(LegalCurrencyConfigUtil.w());
        cloudWalletInfo.setCurrencyRate(LegalCurrencyConfigUtil.v());
        jsMessage2.setData(cloudWalletInfo);
        jsMessage2.setCode(200);
        jsMessage2.setAction(callback);
        k.f("CLOUD_WALLET_H5", "ACTION_CLOUD_WALLET_INFO jsMessage = " + jsMessage2);
        b.e(jsMessage2, uVar, false);
    }

    @ActionAnnotation(actionName = "closeWebView", value = "20010006")
    public static void doFinish(u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            uVar.getActivity().finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012c A[SYNTHETIC, Splitter:B:43:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021f A[Catch:{ all -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0251  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huobi.sharev2.bean.ShareInfo doGenerateShareInfo(java.util.Map<java.lang.String, java.lang.Object> r27) {
        /*
            r1 = r27
            java.lang.String r0 = "shareChannel"
            java.lang.String r2 = "defaultTab"
            java.lang.String r3 = "showNativeQr"
            java.lang.Object r4 = r1.get(r3)
            if (r4 == 0) goto L_0x0019
            java.lang.Object r3 = r1.get(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            java.lang.String r4 = "condition"
            java.lang.Object r6 = r1.get(r4)
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x002b
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x002c
        L_0x002b:
            r4 = r7
        L_0x002c:
            java.lang.String r6 = "source"
            java.lang.Object r8 = r1.get(r6)
            if (r8 == 0) goto L_0x003b
            java.lang.Object r8 = r1.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x003c
        L_0x003b:
            r8 = r7
        L_0x003c:
            java.lang.String r9 = "inviteCode"
            java.lang.Object r9 = r1.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = "inviteUrl"
            java.lang.Object r10 = r1.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 == 0) goto L_0x0056
            java.lang.String r10 = com.huobi.sharev2.helper.NewShareHelper.k(r9)
        L_0x0056:
            java.lang.String r11 = "qrUrl"
            java.lang.Object r11 = r1.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "shareUrl"
            java.lang.Object r12 = r1.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "copyURL"
            java.lang.Object r13 = r1.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "parseUrl"
            java.lang.Object r14 = r1.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = "shareText"
            java.lang.Object r16 = r1.get(r15)
            r5 = r16
            java.lang.String r5 = (java.lang.String) r5
            r16 = r7
            java.lang.String r7 = "pageId"
            boolean r18 = r1.containsKey(r7)
            if (r18 == 0) goto L_0x009b
            r18 = r5
            java.lang.Object r5 = r1.get(r7)
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r1.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x009f
        L_0x009b:
            r18 = r5
        L_0x009d:
            r5 = r16
        L_0x009f:
            java.lang.String r7 = "buttonId"
            boolean r19 = r1.containsKey(r7)
            if (r19 == 0) goto L_0x00b9
            r19 = r5
            java.lang.Object r5 = r1.get(r7)
            boolean r5 = r5 instanceof java.lang.String
            if (r5 == 0) goto L_0x00bb
            java.lang.Object r5 = r1.get(r7)
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00bd
        L_0x00b9:
            r19 = r5
        L_0x00bb:
            r7 = r16
        L_0x00bd:
            java.lang.String r5 = "floatContent"
            java.lang.Object r5 = r1.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r16 = r5
            java.lang.String r5 = "shareContent"
            java.lang.Object r5 = r1.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r20 = r7
            java.lang.String r7 = "posterTitle"
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            r21 = r7
            java.lang.String r7 = "posterSubTitle"
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            java.util.ArrayList r22 = new java.util.ArrayList
            r22.<init>()
            r23 = r7
            java.lang.String r7 = "channelList"
            boolean r24 = r1.containsKey(r7)
            if (r24 == 0) goto L_0x0100
            java.lang.Object r24 = r1.get(r7)
            if (r24 == 0) goto L_0x0100
            java.lang.Object r7 = r1.get(r7)
            r22 = r7
            java.util.ArrayList r22 = (java.util.ArrayList) r22
        L_0x0100:
            java.lang.String r7 = "imageStyle"
            boolean r24 = r1.containsKey(r7)
            if (r24 == 0) goto L_0x011d
            r24 = r5
            java.lang.Object r5 = r1.get(r7)
            boolean r5 = r5 instanceof java.lang.Integer
            if (r5 == 0) goto L_0x011f
            java.lang.Object r5 = r1.get(r7)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x0120
        L_0x011d:
            r24 = r5
        L_0x011f:
            r5 = 0
        L_0x0120:
            r7 = 0
            is.a.y(r7)
            java.lang.String r7 = "extend"
            java.lang.Object r25 = r1.get(r7)
            if (r25 == 0) goto L_0x01ce
            java.lang.Object r7 = r1.get(r7)     // Catch:{ Exception -> 0x01c3 }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x01c3 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ Exception -> 0x01bc }
            if (r6 == 0) goto L_0x01b3
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x01bc }
            r6.<init>()     // Catch:{ Exception -> 0x01bc }
            java.lang.Object r17 = r7.get(r0)     // Catch:{ Exception -> 0x01ad }
            java.lang.String r17 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x01ad }
            r25 = r13
            r26 = r14
            double r13 = java.lang.Double.parseDouble(r17)     // Catch:{ Exception -> 0x01ab }
            int r13 = (int) r13     // Catch:{ Exception -> 0x01ab }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x01ab }
            r6.put(r0, r13)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = "shareSource"
            java.lang.String r13 = "cardChannel"
            java.lang.Object r13 = r7.get(r13)     // Catch:{ Exception -> 0x01ab }
            r6.put(r0, r13)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = "shareBase64Image"
            java.lang.String r13 = "cardImage"
            java.lang.Object r13 = r7.get(r13)     // Catch:{ Exception -> 0x01ab }
            r6.put(r0, r13)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = "cardTitle"
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x01ab }
            r6.put(r15, r0)     // Catch:{ Exception -> 0x01ab }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01ab }
            if (r0 != 0) goto L_0x01a8
            java.lang.String r0 = "https://"
            boolean r0 = r12.startsWith(r0)     // Catch:{ Exception -> 0x01ab }
            if (r0 == 0) goto L_0x01a8
            java.net.URI r0 = new java.net.URI     // Catch:{ Exception -> 0x01ab }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01ab }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ab }
            r13.<init>()     // Catch:{ Exception -> 0x01ab }
            java.lang.String r14 = r0.getPath()     // Catch:{ Exception -> 0x01ab }
            r13.append(r14)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r14 = "?"
            r13.append(r14)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = r0.getQuery()     // Catch:{ Exception -> 0x01ab }
            r13.append(r0)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x01ab }
            java.lang.String r13 = "sharePath"
            r6.put(r13, r0)     // Catch:{ Exception -> 0x01ab }
        L_0x01a8:
            r17 = r6
            goto L_0x01b9
        L_0x01ab:
            r0 = move-exception
            goto L_0x01ca
        L_0x01ad:
            r0 = move-exception
            r25 = r13
            r26 = r14
            goto L_0x01ca
        L_0x01b3:
            r25 = r13
            r26 = r14
            r17 = 0
        L_0x01b9:
            r6 = r17
            goto L_0x01d4
        L_0x01bc:
            r0 = move-exception
            r25 = r13
            r26 = r14
            r6 = 0
            goto L_0x01ca
        L_0x01c3:
            r0 = move-exception
            r25 = r13
            r26 = r14
            r6 = 0
            r7 = 0
        L_0x01ca:
            r0.printStackTrace()
            goto L_0x01d4
        L_0x01ce:
            r25 = r13
            r26 = r14
            r6 = 0
            r7 = 0
        L_0x01d4:
            com.huobi.sharev2.bean.ShareInfo r13 = new com.huobi.sharev2.bean.ShareInfo
            r13.<init>()
            r13.setCondition(r4)
            r13.setInviteCode(r9)
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x01f5
            java.lang.String r0 = "null"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x01f5
            java.lang.String r0 = r12.trim()
            r13.setShareUrl(r0)
            goto L_0x01fe
        L_0x01f5:
            if (r10 == 0) goto L_0x01fb
            java.lang.String r10 = r10.trim()
        L_0x01fb:
            r13.setShareUrl(r10)
        L_0x01fe:
            java.lang.String r0 = "showTail"
            boolean r4 = r1.containsKey(r0)
            if (r4 == 0) goto L_0x0219
            java.lang.Object r4 = r1.get(r0)
            if (r4 == 0) goto L_0x0219
            java.lang.Object r0 = r1.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r13.setShowTail(r0)
        L_0x0219:
            boolean r0 = r1.containsKey(r2)     // Catch:{ all -> 0x0234 }
            if (r0 == 0) goto L_0x023e
            java.lang.Object r0 = r1.get(r2)     // Catch:{ all -> 0x0234 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0234 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ all -> 0x0234 }
            double r0 = java.lang.Math.floor(r0)     // Catch:{ all -> 0x0234 }
            int r0 = (int) r0     // Catch:{ all -> 0x0234 }
            r13.setDefaultTab(r0)     // Catch:{ all -> 0x0234 }
            goto L_0x023e
        L_0x0234:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.String r0 = r0.getMessage()
            r1.println(r0)
        L_0x023e:
            r13.setSource(r8)
            r13.setQrUrl(r11)
            r13.setShowNativeQr(r3)
            r1 = r25
            r13.setCopyText(r1)
            r13.setExtend(r7)
            if (r6 == 0) goto L_0x025e
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "community"
            r0.put(r1, r6)
            r13.setExtendMap(r0)
        L_0x025e:
            r14 = r26
            r13.setParseUrl(r14)
            r1 = r18
            r13.setShareText(r1)
            r1 = r24
            r13.setShareContent(r1)
            r1 = r19
            r13.setPageId(r1)
            r7 = r20
            r13.setButtonId(r7)
            r1 = r16
            r13.setFloatContent(r1)
            r7 = r21
            r13.setPosterTitle(r7)
            r7 = r23
            r13.setPosterSubtitle(r7)
            r13.setImageStyle(r5)
            r1 = r22
            r13.setChannelList(r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webview2.action.JsCommonActionHelper.doGenerateShareInfo(java.util.Map):com.huobi.sharev2.bean.ShareInfo");
    }

    @ActionAnnotation(actionName = "doImageCreate", value = "20010088")
    public static void doImageCreate(final JsMessage jsMessage, final u uVar) {
        a.f84573a.a(jsMessage.toString(), new qr.a() {
            public void result(int i11, String str) {
                JsMessage jsMessage = new JsMessage();
                if (i11 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i11);
                        jSONObject.put("data", str);
                        jsMessage.setData(jSONObject.toString());
                        jsMessage.setCode(200);
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                } else {
                    jsMessage.setCode(i11);
                    jsMessage.setMsg(str);
                }
                jsMessage.setAction(JsMessage.this.getCallback());
                b.d(jsMessage, uVar);
            }
        });
    }

    @ActionAnnotation(actionName = "doShare", value = "20010089")
    public static void doShare(JsMessage jsMessage, u uVar) {
        ShareManager.getInstance().doShare(jsMessage.toString());
    }

    @ActionAnnotation(actionName = "doShareBase64Image", value = "20010018")
    public static void doShareBase64Image(JsMessage jsMessage, u uVar) {
        Map map;
        if ((jsMessage.getData() instanceof Map) && !tu.a.f(uVar) && (map = (Map) jsMessage.getData()) != null) {
            String str = (String) map.get("image");
            if (!TextUtils.isEmpty(str)) {
                ShareInfo doGenerateShareInfo = doGenerateShareInfo(map);
                doGenerateShareInfo.setBase64Image(str);
                doGenerateShareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BASE64);
                if (!canUseNewShare(map)) {
                    i.b().f(new i0(uVar, str, new tu.a(uVar, doGenerateShareInfo)));
                } else if (uVar instanceof HBBaseWebActivity) {
                    ShareManager.getInstance().share((HBBaseWebActivity) uVar, doGenerateShareInfo);
                }
            } else {
                ShareInfo doGenerateShareInfo2 = doGenerateShareInfo(map);
                String pageId = doGenerateShareInfo2.getPageId();
                if (!canUseNewShare(map) || TextUtils.isEmpty(pageId)) {
                    Log.e(TAG, "20010018 share params is error");
                    return;
                }
                doGenerateShareInfo2.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
                if (uVar instanceof HBBaseWebActivity) {
                    ShareManager.getInstance().share((HBBaseWebActivity) uVar, doGenerateShareInfo2);
                }
            }
        }
    }

    @ActionAnnotation(actionName = "doShareImage", value = "20010008")
    public static void doShareImage(JsMessage jsMessage, u uVar) {
        Map map;
        if ((jsMessage.getData() instanceof Map) && !tu.a.f(uVar) && (map = (Map) jsMessage.getData()) != null) {
            String str = (String) map.get("imageURL");
            d.b("JsMessageHelper-->doShareImage-->imageURL:" + str);
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                ShareInfo doGenerateShareInfo = doGenerateShareInfo(map);
                doGenerateShareInfo.setImageUrls(arrayList);
                doGenerateShareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
                if (!canUseNewShare(map)) {
                    i.b().f(new f0(str, new DisplayImageOptions.Builder().v(false).w(false).u(), new tu.a(uVar, doGenerateShareInfo)));
                } else if (uVar instanceof HBBaseWebActivity) {
                    ShareManager.getInstance().share((HBBaseWebActivity) uVar, doGenerateShareInfo);
                }
            } else {
                ShareInfo doGenerateShareInfo2 = doGenerateShareInfo(map);
                String pageId = doGenerateShareInfo2.getPageId();
                if (!canUseNewShare(map) || TextUtils.isEmpty(pageId)) {
                    Log.e(TAG, "20010008 share params is error");
                    return;
                }
                doGenerateShareInfo2.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
                if (uVar instanceof HBBaseWebActivity) {
                    ShareManager.getInstance().share((HBBaseWebActivity) uVar, doGenerateShareInfo2);
                }
            }
        }
    }

    @ActionAnnotation("20010047")
    public static void fiatDeposit(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null && jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
            String str = (String) ((Map) jsMessage.getData()).get(FirebaseAnalytics.Param.CURRENCY);
            if (!TextUtils.isEmpty(str)) {
                DepositFiatFromCoinActivity.nj(uVar.getActivity(), str, FiatDWEntrance.unknown);
            }
        }
    }

    @ActionAnnotation("20010048")
    public static void fiatWithdraw(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null && jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
            String str = (String) ((Map) jsMessage.getData()).get(FirebaseAnalytics.Param.CURRENCY);
            if (!TextUtils.isEmpty(str)) {
                WithdrawFiatFromCoinActivity.nj(uVar.getActivity(), str, FiatDWEntrance.unknown);
            }
        }
    }

    @ActionAnnotation("20010077")
    public static void getBottomHeight(JsMessage jsMessage, u uVar) {
        k.f("ImSDk", "ACTION_GET_BOTTOM_HEIGHT jsMsg = " + jsMessage);
        if (uVar != null) {
            try {
                if (uVar.getActivity() != null && jsMessage != null && jsMessage.getData() != null) {
                    HbgDialogJsWidthHeight hbgDialogJsWidthHeight = new HbgDialogJsWidthHeight();
                    hbgDialogJsWidthHeight.setDisplayHeight(uVar.getDisplayHeight());
                    hbgDialogJsWidthHeight.setDisplayWidth(uVar.getDisplayWidth());
                    hbgDialogJsWidthHeight.setNavigatorHeight(uVar.getNavigatorHeight());
                    hbgDialogJsWidthHeight.setAvailableLocationY(uVar.getAvailableLocationY());
                    String callback = jsMessage.getCallback();
                    JsMessage jsMessage2 = new JsMessage();
                    jsMessage2.setData(hbgDialogJsWidthHeight);
                    jsMessage2.setCode(200);
                    jsMessage2.setAction(callback);
                    k.f("ImSDk", "ACTION_GET_BOTTOM_HEIGHT jsMessage = " + jsMessage2);
                    b.e(jsMessage2, uVar, false);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                k.g("ImSDk", "ACTION_GET_BOTTOM_HEIGHT has error ", e11);
            }
        }
    }

    @ActionAnnotation(actionName = "httpRequest", value = "20010079")
    public static void getH5Url(JsMessage jsMessage, u uVar) {
        try {
            k.f("getH5Url", "jsMsg = " + jsMessage);
            if (uVar == null || uVar.getActivity() == null) {
                callBackActionResult(0, "webivew is null or activity is null", jsMessage, uVar);
            } else if (jsMessage.getData() == null || !(jsMessage.getData() instanceof Map)) {
                callBackActionResult(1, "The request parameter is illegal, please check the data in data ", jsMessage, uVar);
            } else {
                Map map = (Map) jsMessage.getData();
                String str = (String) map.get("path");
                String str2 = (String) map.get("type");
                String str3 = (String) map.get("method");
                Map map2 = (Map) map.get("params");
                Map map3 = (Map) map.get("headers");
                Map map4 = (Map) map.get(TtmlNode.TAG_BODY);
                if (map2 == null) {
                    map2 = new HashMap();
                }
                Map map5 = map2;
                HashMap hashMap = map3 == null ? new HashMap() : map3;
                if (map4 == null) {
                    map4 = new HashMap();
                }
                Map map6 = map4;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "POST";
                }
                String upperCase = str3.toUpperCase();
                if (!"GET".equals(upperCase) && !"POST".equals(upperCase)) {
                    callBackActionResult(4, "The value of request method only supports 'GET' or 'POST', the default is 'POST'", jsMessage, uVar);
                } else if (!TextUtils.isEmpty(str)) {
                    String str4 = wi.b.f48040d + str;
                    String substring = str4.endsWith("/") ? str4.substring(0, str4.length() - 1) : str4;
                    if (str.contains("-/x/hbg/")) {
                        hbgUrlRequest(jsMessage, uVar, substring, upperCase, map5, hashMap, map6);
                    } else if (str.contains("-/x/uc/")) {
                        ucUrlRequest(jsMessage, uVar, substring, upperCase, map5, hashMap, map6);
                    } else if (str.contains("-/x/pro/")) {
                        proUrlRequest(jsMessage, uVar, substring, upperCase, map5, hashMap, map6);
                    } else if (str.contains("-/x/hb/")) {
                        phpUrlRequest(jsMessage, uVar, substring, upperCase, map5, hashMap, map6);
                    } else if (str2.equals("otc")) {
                        otcUrlRequest(jsMessage, uVar, str, upperCase, map5, hashMap, map6);
                    } else {
                        callBackActionResult(5, "The requested path must contain '-/x/hbg/', '-/x/uc/', '-/x/pro/', '-/x/hb/' or the value of the type field is 'otc'", jsMessage, uVar);
                    }
                } else {
                    callBackActionResult(2, "request path is empty, please check the data in data ", jsMessage, uVar);
                }
            }
        } catch (Throwable th2) {
            callBackActionResult(3, "request Exception: " + th2.getMessage(), jsMessage, uVar);
            th2.printStackTrace();
        }
    }

    @ActionAnnotation("20010078")
    public static void getTopHeight(JsMessage jsMessage, u uVar) {
        k.f("ImSDk", "ACTION_GET_TOP_HEIGHT jsMsg = " + jsMessage);
        if (uVar != null) {
            try {
                if (uVar.getActivity() != null && jsMessage != null && jsMessage.getData() != null) {
                    String topHeight = uVar.getTopHeight();
                    String callback = jsMessage.getCallback();
                    JsMessage jsMessage2 = new JsMessage();
                    jsMessage2.setData(topHeight);
                    jsMessage2.setCode(200);
                    jsMessage2.setAction(callback);
                    k.f("ImSDk", "ACTION_GET_TOP_HEIGHT jsMessage = " + jsMessage2);
                    b.e(jsMessage2, uVar, false);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                k.g("ImSDk", "ACTION_GET_TOP_HEIGHT has error ", e11);
            }
        }
    }

    @ActionAnnotation("20010029")
    public static void goMarketPotentials(u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            Intent l11 = k0.l(uVar.getActivity());
            l11.putExtra("MARKET_GO_POTENTIALS", true);
            uVar.getActivity().startActivity(l11);
        }
    }

    @ActionAnnotation("20010009")
    public static void h5LoginSuccess(JsMessage jsMessage, final u uVar) {
        Map map = (Map) jsMessage.getData();
        String str = (String) map.get("uc_token");
        final String str2 = (String) map.get("login_name");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            HuobiToastUtil.k(uVar.getActivity(), R.string.re_login);
            return;
        }
        r.x().x0(str);
        UserCenterRemoteDataSource.A().W(str).compose(RxJavaHelper.t(uVar)).subscribe(new EasySubscriber<UserToken>() {
            public void onError2(Throwable th2) {
                super.onError2(th2);
                th2.printStackTrace();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                aPIStatusErrorException.printStackTrace();
            }

            public void onNext(UserToken userToken) {
                super.onNext(userToken);
                JsCommonActionHelper.handleUserLoginSuccess(u.this, userToken, str2);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void handleUserLoginSuccess(u uVar, UserToken userToken, String str) {
        SoftInputUtils.f(uVar.getActivity());
        UserLoginHelper.e().h(uVar, userToken.d(), uVar.getActivity(), uVar instanceof LoginWebActivity ? ((LoginWebActivity) uVar).xh() : null, new y(userToken, str, uVar));
    }

    private static void hbgUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().H())) {
            map2.put("HB-PRO-TOKEN", r.x().H());
        }
        if (str2.equals("GET")) {
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v7.b.a().getH5UrlRequest(str, map2, map).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "hbgUrlRequest get request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v7.b.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "hbgUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    @ActionAnnotation(actionName = "doInviteShare", value = "20010046")
    public static void inviteShare(JsMessage jsMessage, u uVar) {
        Map map;
        if (uVar != null) {
            Activity activity = uVar.getActivity();
            if ((activity instanceof FragmentActivity) && jsMessage.getData() != null && (jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null) {
                ShareInfo doGenerateShareInfo = doGenerateShareInfo(map);
                doGenerateShareInfo.setIsInvite(1);
                doGenerateShareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_URLS);
                if (canUseNewShare(map)) {
                    ShareManager.getInstance().share((FragmentActivity) activity, doGenerateShareInfo);
                } else {
                    g.c().g((FragmentActivity) activity, doGenerateShareInfo.getShareUrl(), doGenerateShareInfo.getInviteCode(), doGenerateShareInfo.getShareText(), doGenerateShareInfo.getParseUrl());
                }
            }
        }
    }

    @ActionAnnotation("20010076")
    public static void jumpCloudWalletCommunicateSdk(JsMessage jsMessage, u uVar) {
    }

    @ActionAnnotation("20010067")
    public static void jumpCloudWalletTransfer(JsMessage jsMessage, u uVar) {
    }

    @ActionAnnotation("20010066")
    public static void jumpDApp(JsMessage jsMessage, u uVar) {
    }

    @ActionAnnotation(actionName = "gotoPage", value = "20010038")
    public static void jumpToNative(JsMessage jsMessage, u uVar) {
        Object data = jsMessage.getData();
        if (data != null && (data instanceof Map)) {
            Map map = (Map) data;
            if (map.containsKey("url")) {
                BaseModuleConfig.a().k0((String) map.get("url"));
                return;
            }
            k.c("jumpToNative: 没有获取到url  " + map);
        } else if (data instanceof String) {
            BaseModuleConfig.a().k0((String) data);
        } else {
            k.c("jumpToNative: 没有获取到url  object=" + data);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dealWithBasePlatformInfo$3(u uVar, PlatformInfo platformInfo, JsMessage jsMessage, String str) {
        int statusBarHeight = BaseActivity.getStatusBarHeight(((HBBaseWebActivity) uVar).getActivity());
        platformInfo.setStatusBarHeightPx(statusBarHeight);
        float f11 = (float) statusBarHeight;
        platformInfo.setNavigationBarHeightPx(PixelUtils.a((float) (PixelUtils.h(f11) + 44)));
        platformInfo.setNavigationbarHeight(PixelUtils.h(f11) + 44);
        jsMessage.setData(platformInfo);
        jsMessage.setCode(200);
        jsMessage.setAction(str);
        b.e(jsMessage, uVar, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Observable lambda$loadBase64Image$2(String str) {
        byte[] decode = Base64.decode(str, 0);
        if (decode == null || decode.length <= 0) {
            return Observable.empty();
        }
        return Observable.just(BitmapFactory.decodeByteArray(decode, 0, decode.length));
    }

    public static void loadBase64Image(u6.g gVar, String str, final tx.a aVar) {
        Observable.just(str).flatMap(z.f20892b).compose(RxJavaHelper.t(gVar)).subscribe(new BaseSubscriber<Bitmap>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                tx.a.this.b("base64", (View) null, (FailReason) null);
            }

            public void onStart() {
                tx.a.this.a("base64", (View) null);
            }

            public void onNext(Bitmap bitmap) {
                super.onNext(bitmap);
                tx.a.this.c("base64", (View) null, bitmap);
            }
        });
    }

    @ActionAnnotation("20010102")
    public static void notifyWebExit(JsMessage jsMessage, u uVar) {
        if (jsMessage.getData() instanceof Map) {
            Map map = (Map) jsMessage.getData();
            boolean z11 = false;
            if (map.containsKey("needClose")) {
                z11 = ((Boolean) map.get("needClose")).booleanValue();
            }
            if (z11 && (uVar instanceof HBBaseWebActivity)) {
                ((HBBaseWebActivity) uVar).notifyFinish(z11);
            }
        }
    }

    @ActionAnnotation("20010101")
    public static void notifyWebInterceptExit(JsMessage jsMessage, u uVar) {
        if (jsMessage.getData() instanceof Map) {
            Map map = (Map) jsMessage.getData();
            Log.d(TAG, "notifyWebInterceptExit() called with: jsMsg = [" + jsMessage + "]");
            if (map != null && map.containsKey("needIntercept") && (uVar instanceof HBBaseWebActivity)) {
                HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
                hBBaseWebActivity.setInterceptCallback(jsMessage.getCallback());
                hBBaseWebActivity.setNeedIntercept(((Boolean) map.get("needIntercept")).booleanValue());
                if (map.containsKey("interceptSecond")) {
                    hBBaseWebActivity.setInterceptSecond(((Integer) map.get("interceptSecond")).intValue());
                }
            }
        }
    }

    @ActionAnnotation(actionName = "openNewWebView", value = "20010043")
    public static void openNewWebActivity(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            Activity activity = uVar.getActivity();
            if (!NetworkStatus.c(activity)) {
                HuobiToastUtil.k(activity, R.string.string_network_disconnect);
                return;
            }
            Map map = (Map) jsMessage.getData();
            Intent intent = new Intent(activity, IndexWebActivity.class);
            intent.putExtra("url", (String) map.get("url"));
            if (!TextUtils.isEmpty((CharSequence) map.get("title"))) {
                intent.putExtra("title", (String) map.get("title"));
            }
            intent.putExtra("title_back", (String) map.get("titleBack"));
            intent.putExtra("isauth", (String) map.get("isAuth"));
            activity.startActivityForResult(intent, 1);
        }
    }

    @ActionAnnotation("20010085")
    public static void openPreviewImage(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            try {
                if (jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                    Map map = (Map) jsMessage.getData();
                    List list = (List) map.get("list");
                    int i11 = 0;
                    Object obj = map.get("current");
                    if (obj instanceof Integer) {
                        i11 = ((Integer) obj).intValue();
                    } else if (obj instanceof Double) {
                        i11 = ((Double) obj).intValue();
                    }
                    PhotoViewerUtils.a(uVar.getActivity(), PhotoViewerUtils.b(list), i11);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                k.g("photoviewer", "Preview Image has error ", e11);
            }
        }
    }

    @ActionAnnotation(actionName = "openUniAppPage")
    public static void openUniAppPage(JsMessage jsMessage, u uVar) {
        if (jsMessage != null && uVar != null) {
            uVar.getActivity();
        }
    }

    @ActionAnnotation("20010062")
    public static void openWalletApp(JsMessage jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            k.f("ACTION_OPEN_WALLET_APP", "jsMsg = " + jsMessage);
            if (jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
                Map map = (Map) jsMessage.getData();
                String str = (String) map.get("downloadH5Url");
                String str2 = (String) map.get("hswapDeepLinkUrl");
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str2));
                    uVar.getActivity().startActivity(intent);
                } catch (Exception e11) {
                    k.g("ACTION_OPEN_WALLET_APP", "has error", e11);
                    e11.printStackTrace();
                    HBBaseWebActivity.showWebViewNoClear(uVar.getActivity(), str, "", "", false);
                }
            }
        }
    }

    @ActionAnnotation("20010060")
    public static void otcBinCardResult(JsMessage jsMessage, u uVar) {
        Activity f11;
        if (uVar != null && uVar.getActivity() != null && jsMessage != null && jsMessage.getData() != null && (jsMessage.getData() instanceof Map)) {
            Map map = (Map) jsMessage.getData();
            String str = (String) map.get("path");
            String str2 = (String) map.get("form");
            String str3 = (String) map.get("status");
            if (!TextUtils.equals((String) map.get("code"), "otc_bind_card")) {
                return;
            }
            if (TextUtils.equals(str, "check")) {
                if (TextUtils.equals(str2, TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER) && (TextUtils.equals(str3, "fail") || TextUtils.equals(str3, "success"))) {
                    EventBus.d().k(new CloseFastTradeDialogEvent());
                } else if (TextUtils.equals(str2, "cardManager") && ((TextUtils.equals(str3, "finish") || TextUtils.equals(str3, "success")) && (f11 = oa.a.g().f(OtcCardManagerActivity.class)) != null)) {
                    f11.finish();
                }
                uVar.getActivity().finish();
            } else if (TextUtils.equals(str, "customer")) {
                OtcModuleConfig.b().l(uVar.getActivity(), "");
                uVar.getActivity().finish();
            }
        }
    }

    private static void otcUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().E())) {
            map2.put("token", r.x().E());
        }
        if (str2.equals("GET")) {
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            s8.a.a().getH5UrlRequest(str, map2, map).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "otcUrlRequest get request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            s8.a.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "otcUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    private static void phpUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().G())) {
            map2.put("HB-OLD-TOKEN", r.x().G());
        }
        if (str2.equals("GET")) {
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v8.a.a().getH5UrlRequest(str, map2, map).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "phpUrlRequest get request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v8.a.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "phpUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    @ActionAnnotation(actionName = "proxyRequest", value = "20010106")
    public static void postH5Url(JsMessage jsMessage, u uVar) {
        Map map;
        try {
            k.f("postH5Url", "jsMsg = " + jsMessage);
            if (uVar == null || uVar.getActivity() == null) {
                callBackActionResult(0, "webivew is null or activity is null", jsMessage, uVar);
            } else if (jsMessage.getData() == null || !(jsMessage.getData() instanceof Map)) {
                callBackActionResult(1, "The request parameter is illegal, please check the data in data ", jsMessage, uVar);
            } else {
                Map map2 = (Map) jsMessage.getData();
                String str = (String) map2.get("path");
                String str2 = (String) map2.get("type");
                String str3 = (String) map2.get("method");
                Map map3 = null;
                try {
                    map = (Map) map2.get("params");
                } catch (Throwable unused) {
                    map = null;
                }
                try {
                    map3 = (Map) map2.get("headers");
                } catch (Throwable unused2) {
                }
                Map map4 = (Map) map2.get(TtmlNode.TAG_BODY);
                if (map == null) {
                    map = new HashMap();
                }
                if (map3 == null) {
                    map3 = new HashMap();
                }
                Map map5 = map3;
                if (map4 == null) {
                    map4 = new HashMap();
                }
                Map map6 = map4;
                if (TextUtils.isEmpty(str3)) {
                    str3 = "POST";
                }
                String upperCase = str3.toUpperCase();
                if (!"POST".equals(upperCase) && !"PUT".equals(upperCase)) {
                    callBackActionResult(4, "The value of request method only supports 'POST' or 'PUT', the default is 'POST'", jsMessage, uVar);
                } else if (!TextUtils.isEmpty(str)) {
                    String r11 = DomainSwitcher.r();
                    if (!TextUtils.isEmpty(r11)) {
                        if (!r11.endsWith("/")) {
                            r11 = r11 + "/";
                        }
                    }
                    String str4 = DomainTool.DOMAIN_PREFIX + r11 + str;
                    postUrlRequest(jsMessage, uVar, str4.endsWith("/") ? str4.substring(0, str4.length() - 1) : str4, upperCase, map, map5, map6);
                } else {
                    callBackActionResult(2, "request path is empty, please check the data in data ", jsMessage, uVar);
                }
            }
        } catch (Throwable th2) {
            callBackActionResult(3, "request Exception: " + th2.getMessage(), jsMessage, uVar);
            th2.printStackTrace();
        }
    }

    private static void postUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().H())) {
            map2.put("HB-PRO-TOKEN", r.x().H());
        }
        if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v7.a.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "hbgUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5PostRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("PUT")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            v7.a.a().putH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "hbgUrlRequest put request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5PostRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    private static void proUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().H())) {
            map2.put("HB-PRO-TOKEN", r.x().H());
        }
        if (str2.equals("GET")) {
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            x8.a.a().getH5UrlRequest(str, map2, map).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "proUrlRequest get request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            x8.a.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "proUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    @ActionAnnotation(actionName = "refreshFinish", value = "20010022")
    public static void refreshFinish(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            ((HBBaseWebActivity) uVar).finishRefresh();
        }
    }

    @ActionAnnotation("20010040")
    public static void reloadMeta(JsMessage jsMessage, final u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            try {
                ((HBBaseWebActivity) uVar).runOnUiThread(new Runnable() {
                    public void run() {
                        ((HBBaseWebActivity) u.this).readTopBarThemeConfig();
                    }
                });
            } catch (Exception e11) {
                k.k(e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void sendH5PostRequestResult(ResponseBody responseBody, JsMessage jsMessage, u uVar) {
        JsMessage jsMessage2 = new JsMessage();
        try {
            String string = responseBody.string();
            Object obj = null;
            try {
                obj = JSON.parse(string);
            } catch (Throwable unused) {
            }
            if (obj != null) {
                jsMessage2.setData(obj);
            } else {
                jsMessage2.setData(string);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        jsMessage2.setMsg("");
        jsMessage2.setCode(200);
        jsMessage2.setAction(jsMessage.getCallback());
        b.d(jsMessage2, uVar);
    }

    /* access modifiers changed from: private */
    public static void sendH5UrlRequestResult(ResponseBody responseBody, JsMessage jsMessage, u uVar) {
        JsStrMessage jsStrMessage = new JsStrMessage();
        try {
            jsStrMessage.setData(responseBody.string());
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        jsStrMessage.setMsg("");
        jsStrMessage.setCode(200);
        jsStrMessage.setAction(jsMessage.getCallback());
        b.d(jsStrMessage, uVar);
    }

    @ActionAnnotation(actionName = "setTopBarColor", value = "20010037")
    public static void setTopBarColor(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
            hBBaseWebActivity.runOnUiThread(new c0(hBBaseWebActivity, jsMessage));
        }
    }

    @ActionAnnotation("20010034")
    public static void showCloseButton(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
            hBBaseWebActivity.runOnUiThread(new a0(hBBaseWebActivity));
        }
    }

    @ActionAnnotation(actionName = "actionAdsShow", value = "20010099")
    public static void showHbgDialog(JsMessage jsMessage, u uVar) {
        int i11;
        if (uVar != null && uVar.getActivity() != null) {
            Activity activity = uVar.getActivity();
            if (!NetworkStatus.c(activity)) {
                HuobiToastUtil.k(activity, R.string.string_network_disconnect);
                return;
            }
            Object data = jsMessage.getData();
            if (data instanceof Map) {
                Map map = (Map) data;
                long j11 = 0;
                try {
                    j11 = ((Double) map.get("dialogId")).longValue();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                long j12 = j11;
                int i12 = 0;
                try {
                    i11 = ((Double) map.get("positionType")).intValue();
                } catch (Exception e12) {
                    e12.printStackTrace();
                    i11 = 0;
                }
                try {
                    i12 = ((Double) map.get("alphaValue")).intValue();
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                HbgDialogManager A = HbgDialogManager.A();
                String str = "" + map.get("url");
                A.j0(j12, i11, str, i12, "" + map.get("icon"), "" + map.get("showTitle"), "" + map.get("showText"), "" + map.get("buttonText"), "" + map.get("showCloseButton"));
            }
        }
    }

    @ActionAnnotation(actionName = "showRightButton", value = "20010035")
    public static void showRightButton(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
            hBBaseWebActivity.runOnUiThread(new d0(hBBaseWebActivity, jsMessage));
        }
    }

    @ActionAnnotation("20010036")
    public static void showTopBar(JsMessage jsMessage, u uVar) {
        if (uVar instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) uVar;
            hBBaseWebActivity.runOnUiThread(new e0(hBBaseWebActivity, jsMessage));
        }
    }

    @ActionAnnotation("20010049")
    public static void showTopIcon(JsMessage<List<Map<String, String>>> jsMessage, u uVar) {
        if (uVar != null && uVar.getActivity() != null) {
            List list = null;
            try {
                list = jsMessage.getData();
            } catch (Throwable unused) {
            }
            uVar.showTopIcon(list);
        }
    }

    private static void ucUrlRequest(final JsMessage jsMessage, final u uVar, String str, String str2, Map<String, Object> map, Map<String, String> map2, Map<String, Object> map3) {
        if (!TextUtils.isEmpty(r.x().I())) {
            map2.put("HB-UC-TOKEN", r.x().I());
        }
        if (str2.equals("GET")) {
            map.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            o9.a.a().getH5UrlRequest(str, map2, map).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "ucUrlRequest get request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        } else if (str2.equals("POST")) {
            map3.put(VulcanInfo.VTOKEN, ku.b.e().h(uVar.getActivity()));
            o9.a.a().postH5UrlRequest(str, map2, map3).b().compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<ResponseBody>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    JsCommonActionHelper.callBackActionResult(6, "ucUrlRequest post request Exception: " + th2.getMessage(), JsMessage.this, uVar);
                }

                public void onNext(ResponseBody responseBody) {
                    super.onNext(responseBody);
                    JsCommonActionHelper.sendH5UrlRequestResult(responseBody, JsMessage.this, uVar);
                }
            });
        }
    }

    @ActionAnnotation("20010019")
    public static void updateBackDialog(JsMessage jsMessage, u uVar) {
        AlertInfo alertInfo = new AlertInfo();
        try {
            Map map = (Map) jsMessage.getData();
            Boolean bool = (Boolean) map.get("isShowAlert");
            if (bool != null && bool.booleanValue()) {
                alertInfo.setShowAlert(bool.booleanValue());
            }
            alertInfo.setTitle((String) map.get("title"));
            alertInfo.setContent((String) map.get("content"));
            alertInfo.setCancel((String) map.get("cancel"));
            alertInfo.setConfirm((String) map.get("confirm"));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        uVar.setAlertDialogInfo(alertInfo);
    }
}
