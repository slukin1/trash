package com.huobi.webview2.action;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.places.model.PlaceFields;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.hbg.lib.common.utils.crypt.rsa.Base64Utils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.annotation.ActionAnnotation;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.core.webview.bean.JsStrMessage;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.newkyc.bean.KycSDKTokenInfo;
import com.hbg.lib.network.newkyc.bean.KycTicketInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import com.hbg.module.libkt.base.ext.f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.account.entity.ChooseListData;
import com.huobi.account.entity.H5SelectWidgetData;
import com.huobi.account.ui.ChooseCityFragment;
import com.huobi.account.ui.H5SelectDialogFragment;
import com.huobi.account.ui.SecurityLinkActivity;
import com.huobi.account.ui.SecurityLinkStatusActivity;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.WebSessionData;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.data.PassKeyAuthResultModel;
import com.huobi.data.PassKeyModel;
import com.huobi.data.Verify2FAModel;
import com.huobi.data.Verify2FATokenModel;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.engineutils.ability.AssetJumpAbility;
import com.huobi.entity.SelectData;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.utils.TokenErrorException;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.savings.ui.SavingsDataActivity;
import com.huobi.trade.prime.bean.PrimeHoldTokenCalendar;
import com.huobi.trade.prime.service.PrimeService;
import com.huobi.utils.k0;
import com.huobi.utils.s0;
import com.huobi.webview2.ui.JumioKycHelper;
import com.huobi.webview2.ui.SumsubKycHelper;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.util.ClipManager;
import com.huochat.community.util.ImageUtil;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.k;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import n8.a;
import org.bouncycastle.i18n.ErrorBundle;
import pa.d;
import pa.e;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import sm.a;
import tg.r;
import tq.p;
import u6.g;
import v6.u;
import v6.v;
import x6.b;

public final class JsBusinessActionHelper {
    private static final String ACTION_ALI_LIVENESS = "20010081";
    public static final String ACTION_C2C_LEND = "20010028";
    public static final String ACTION_C2C_TRADE = "20010027";
    private static final String ACTION_CACHE = "20010090";
    public static final String ACTION_CALL_KYC_LIVING_FACE = "20010109";
    public static final String ACTION_CHECK_EMAIL = "20010113";
    public static final String ACTION_CHECK_GA = "20010112";
    public static final String ACTION_CHECK_MOBILE = "20010114";
    public static final String ACTION_CONTRACT_TRADINGBOT_SHARE = "20010108";
    public static final String ACTION_COPY = "20010117";
    public static final String ACTION_GET_SESSION = "20010002";
    public static final String ACTION_GET_VIP_INFO = "10000010";
    public static final String ACTION_HOLD_TOKEN_CALENDAR = "20010010";
    public static final String ACTION_JUMIO = "20010059";
    public static final String ACTION_JUMIO_V2 = "20010087";
    private static final String ACTION_JUMP_2_COMMENT_DETAIL = "20010083";
    public static final String ACTION_JUMP_CONTRACT_PAGE = "20010015";
    private static final String ACTION_JUMP_DEFAULT_BROWSER = "20010082";
    public static final String ACTION_JUMP_DEPOSIT_ACTIVITY = "20010016";
    public static final String ACTION_JUMP_GRID_ACT = "20010050";
    public static final String ACTION_JUMP_OTC_PAGE = "20010014";
    public static final String ACTION_JUMP_PAGE = "20010003";
    public static final String ACTION_JUMP_POINT_CARD_LIST = "20010057";
    public static final String ACTION_JUMP_PURCHASE_POINT_CARD = "20010058";
    private static final String ACTION_JUMP_TO_KYC_PAGE = "20010061";
    public static final String ACTION_JUMP_TRADE_PAGE = "20010011";
    public static final String ACTION_JUMP_WITHDRAW_ACTIVITY = "20010017";
    public static final String ACTION_LOGIN = "20010013";
    private static final String ACTION_LOGIN_CHECK = "20010074";
    public static final String ACTION_NEED_TICKET = "10075944";
    public static final String ACTION_OPEN_TRONLINK_APP = "20010104";
    public static final String ACTION_PASS_KEY_VERIFY = "20010110";
    private static final String ACTION_PIC_CHOOSE = "20010080";
    public static final String ACTION_PLAY_MUSIC_TYPE = "20010042";
    public static final String ACTION_RED_PACKET = "20010116";
    public static final String ACTION_REGISTER = "20010030";
    public static final String ACTION_SAVINGS = "20010031";
    public static final String ACTION_SCAN_QR = "20010111";
    public static final String ACTION_SELECT_WIDGET = "20010033";
    private static final String ACTION_SEND_COMMENT = "20010084";
    public static final String ACTION_SET_REFRESH_TYPE = "20010039";
    public static final String ACTION_TRADINGBOT_FILTER_DIALOG = "20010107";
    public static final String ACTION_TRANSFER = "20010032";
    public static final String ACTION_TURKEY_KYC_DIALOG = "20010026";
    public static final String ACTION_VERIFY_2FA = "20010115";
    public static final String ACTION_WEBVIEWLIFECYCLE_TRACE = "20010105";
    public static final int CODE_OK = 200;
    public static final String LOG_TAG = "JS_ACTION";
    private static long lastKycClickTime = 0;
    public static String tradingBotFilterCallBack = "";

    private JsBusinessActionHelper() {
    }

    @ActionAnnotation("20010109")
    public static void actionCallKycLivingFace(final JsMessage jsMessage, final u uVar) {
        final Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            a.a().d().d(new q6.a<KycTicketInfo>(uVar) {
                public void onError2(Throwable th2) {
                    super.onError2(th2);
                    JsBusinessActionHelper.backToH5Error(jsMessage, uVar, th2.getMessage());
                }

                public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                    super.onFailed(aPIStatusErrorException);
                    JsBusinessActionHelper.backToH5Error(jsMessage, uVar, aPIStatusErrorException.getErrMsg());
                }

                public void onRequestSuccess(KycTicketInfo kycTicketInfo) {
                    k.o(JsBusinessActionHelper.LOG_TAG, "getTicket " + kycTicketInfo.toString());
                    String channel = kycTicketInfo.getChannel();
                    if (TextUtils.equals(channel, "HUAWEI")) {
                        JsBusinessActionHelper.jumpHuaWeiLiveness(jsMessage, (HBBaseWebActivity) activity, kycTicketInfo);
                    } else if (TextUtils.equals(channel, KycSDKTokenInfo.LIVING_API_JUMIO)) {
                        JsBusinessActionHelper.jumpJumioLiveness(jsMessage, kycTicketInfo, uVar);
                    } else if (TextUtils.equals(channel, KycSDKTokenInfo.LIVING_API_SUMSUB)) {
                        JsBusinessActionHelper.jumpSumsubLiveness(jsMessage, kycTicketInfo, uVar);
                    } else {
                        JsBusinessActionHelper.backToH5JumioFail(jsMessage, uVar);
                    }
                }
            });
        }
    }

    @ActionAnnotation("20010113")
    public static void actionCheckEmail(JsMessage<?> jsMessage, u uVar) {
        Object obj;
        Object obj2;
        Object obj3;
        Class<SecurityLinkStatusActivity> cls = SecurityLinkStatusActivity.class;
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
            try {
                Map map = (Map) jsMessage.getData();
                if (map != null && map.containsKey("type") && (obj = map.get("type")) != null) {
                    int intValue = new BigDecimal(obj.toString()).intValue();
                    if (intValue == 0) {
                        Intent intent = new Intent(hBBaseWebActivity, SecurityLinkActivity.class);
                        intent.putExtra("LINK_TYPE_KEY", 2);
                        intent.putExtra("from_otc_trade_set", true);
                        hBBaseWebActivity.startActivity(intent);
                        return;
                    }
                    String str = "";
                    if (1 == intValue) {
                        Intent intent2 = new Intent(hBBaseWebActivity, cls);
                        intent2.putExtra("LINK_TYPE_KEY", 2);
                        intent2.putExtra("from_otc_trade_set", true);
                        intent2.putExtra("VERIFY_STATUS_KEY", 2);
                        if (map.containsKey("email") && (obj3 = map.get("email")) != null) {
                            str = obj3.toString();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            intent2.putExtra("BIND_EMAIL_KEY", str);
                        }
                        hBBaseWebActivity.startActivity(intent2);
                    } else if (2 == intValue) {
                        Intent intent3 = new Intent(hBBaseWebActivity, cls);
                        intent3.putExtra("LINK_TYPE_KEY", 2);
                        intent3.putExtra("from_otc_trade_set", true);
                        intent3.putExtra("VERIFY_STATUS_KEY", 3);
                        if (map.containsKey("email") && (obj2 = map.get("email")) != null) {
                            str = obj2.toString();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            intent3.putExtra("BIND_EMAIL_KEY", str);
                        }
                        hBBaseWebActivity.startActivity(intent3);
                    }
                }
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionCheckEmail", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010112")
    public static void actionCheckGA(JsMessage<?> jsMessage, u uVar) {
        Object obj;
        Class<SecurityLinkStatusActivity> cls = SecurityLinkStatusActivity.class;
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
            try {
                Map map = (Map) jsMessage.getData();
                if (map != null && map.containsKey("type") && (obj = map.get("type")) != null) {
                    int intValue = new BigDecimal(obj.toString()).intValue();
                    if (intValue == 0) {
                        Intent intent = new Intent(hBBaseWebActivity, SecurityLinkActivity.class);
                        intent.putExtra("LINK_TYPE_KEY", 3);
                        intent.putExtra("from_otc_trade_set", true);
                        hBBaseWebActivity.startActivity(intent);
                    } else if (1 == intValue) {
                        Intent intent2 = new Intent(hBBaseWebActivity, cls);
                        intent2.putExtra("LINK_TYPE_KEY", 3);
                        intent2.putExtra("from_otc_trade_set", true);
                        intent2.putExtra("VERIFY_STATUS_KEY", 2);
                        hBBaseWebActivity.startActivity(intent2);
                    } else if (2 == intValue) {
                        Intent intent3 = new Intent(hBBaseWebActivity, cls);
                        intent3.putExtra("LINK_TYPE_KEY", 3);
                        intent3.putExtra("from_otc_trade_set", true);
                        intent3.putExtra("VERIFY_STATUS_KEY", 3);
                        hBBaseWebActivity.startActivity(intent3);
                    }
                }
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionCheckGA", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010114")
    public static void actionCheckPhone(JsMessage<?> jsMessage, u uVar) {
        Object obj;
        Object obj2;
        Object obj3;
        Class<SecurityLinkStatusActivity> cls = SecurityLinkStatusActivity.class;
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
            try {
                Map map = (Map) jsMessage.getData();
                if (map != null && map.containsKey("type") && (obj = map.get("type")) != null) {
                    int intValue = new BigDecimal(obj.toString()).intValue();
                    if (intValue == 0) {
                        Intent intent = new Intent(hBBaseWebActivity, SecurityLinkActivity.class);
                        intent.putExtra("LINK_TYPE_KEY", 1);
                        intent.putExtra("from_otc_trade_set", true);
                        hBBaseWebActivity.startActivity(intent);
                        return;
                    }
                    String str = "";
                    if (1 == intValue) {
                        Intent intent2 = new Intent(hBBaseWebActivity, cls);
                        intent2.putExtra("LINK_TYPE_KEY", 1);
                        intent2.putExtra("VERIFY_STATUS_KEY", 2);
                        intent2.putExtra("from_otc_trade_set", true);
                        if (map.containsKey(PlaceFields.PHONE) && (obj3 = map.get(PlaceFields.PHONE)) != null) {
                            str = obj3.toString();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            intent2.putExtra("BIND_PHONE_KEY", str);
                        }
                        hBBaseWebActivity.startActivity(intent2);
                    } else if (2 == intValue) {
                        Intent intent3 = new Intent(hBBaseWebActivity, cls);
                        intent3.putExtra("LINK_TYPE_KEY", 1);
                        intent3.putExtra("VERIFY_STATUS_KEY", 3);
                        intent3.putExtra("from_otc_trade_set", true);
                        if (map.containsKey(PlaceFields.PHONE) && (obj2 = map.get(PlaceFields.PHONE)) != null) {
                            str = obj2.toString();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            intent3.putExtra("BIND_PHONE_KEY", str);
                        }
                        hBBaseWebActivity.startActivity(intent3);
                    }
                }
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionCheckPhone", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010117")
    public static void actionCopy(JsMessage<?> jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            try {
                JsMessage jsMessage2 = new JsMessage();
                jsMessage2.setAction(callback);
                jsMessage2.setCode(200);
                jsMessage2.setMsg("");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content", (Object) ClipManager.getFirstClipboardText(activity));
                jsMessage2.setData(jSONObject);
                b.d(jsMessage2, uVar);
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionCopy", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation(actionName = "login", value = "20010013")
    public static void actionLogin(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010013 JsMessage - " + jsMessage);
        k.o(LOG_TAG, "action - 20010013 verifyUserIsLogin - " + r.x().F0());
        if (r.x().F0()) {
            h5LoginResult(true, jsMessage, uVar);
        } else {
            dealWithLogin(jsMessage, uVar);
        }
    }

    @ActionAnnotation("20010110")
    public static void actionPassKeyVerify(JsMessage jsMessage, final u uVar) {
        Object obj;
        Log.d("actionPassKeyVerify", new Gson().toJson((Object) jsMessage));
        final String callback = jsMessage.getCallback();
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
            try {
                Map map = (Map) jsMessage.getData();
                if (map != null && map.containsKey("type") && (obj = map.get("type")) != null) {
                    final Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(hBBaseWebActivity, hBBaseWebActivity, Security2FADialogHelper.u(new BigDecimal(obj.toString()).intValue()));
                    security2FADialogHelper.L(true);
                    security2FADialogHelper.M(false);
                    security2FADialogHelper.N(false);
                    security2FADialogHelper.V(new Security2FADialogHelper.Callback() {
                        public void onApiError(String str) {
                            super.onApiError(str);
                            LogAndWoodRecorder.a("actionPassKeyVerify", "onApiError-" + str);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg(str);
                            jsMessage.setData(new PassKeyModel(false, (PassKeyAuthResultModel) null));
                            b.d(jsMessage, uVar);
                        }

                        public void onFailed(String str) {
                            LogAndWoodRecorder.a("actionPassKeyVerify", "onFailed-" + str);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg(str);
                            jsMessage.setData(new PassKeyModel(false, (PassKeyAuthResultModel) null));
                            b.d(jsMessage, uVar);
                        }

                        public void onManualDismiss() {
                            super.onManualDismiss();
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg("");
                            jsMessage.setData(new PassKeyModel(false, (PassKeyAuthResultModel) null));
                            b.d(jsMessage, uVar);
                        }

                        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                            super.onSuccess(authResult);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg("");
                            PassKeyModel passKeyModel = new PassKeyModel(true, new PassKeyAuthResultModel(authResult.getPasskey().rawAuthData, authResult.getPasskey().signature, authResult.getPasskey().credentialId, authResult.getPasskey().clientData, authResult.getPasskey().userHandle));
                            jsMessage.setData(passKeyModel);
                            b.d(jsMessage, uVar);
                            security2FADialogHelper.v();
                            Log.d("actionPassKeyVerify", "onSuccess-" + passKeyModel);
                        }
                    });
                }
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionPassKeyVerify", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010116")
    public static void actionRedPacket(JsMessage<?> jsMessage, u uVar) {
        Object obj;
        Log.d("actionRedPacket", new Gson().toJson((Object) jsMessage));
        jsMessage.getCallback();
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            try {
                Map map = (Map) jsMessage.getData();
                String str = "";
                if (map.containsKey("codeWord") && (obj = map.get("codeWord")) != null) {
                    str = obj.toString();
                }
                BaseModuleConfig.a().v((FragmentActivity) activity, str);
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionRedPacket", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010111")
    public static void actionScanQR(JsMessage<?> jsMessage, u uVar) {
        Log.d("actionScanQR", new Gson().toJson((Object) jsMessage));
        jsMessage.getCallback();
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            try {
                final HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
                PermissionUtils.g(hBBaseWebActivity, new r(hBBaseWebActivity, hBBaseWebActivity.getResultLauncher(new v() {
                    public void launcherResult(ActivityResult activityResult) {
                        Intent data;
                        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
                            String stringExtra = data.getStringExtra("result_string");
                            Log.d("actionScanQR", "result : " + stringExtra);
                            HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            s0.c(hBBaseWebActivity, stringExtra);
                        }
                    }
                })));
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionScanQR", "onException-" + e11.getMessage());
            }
        }
    }

    @ActionAnnotation("20010115")
    public static void actionVerify2FA(JsMessage<?> jsMessage, final u uVar) {
        Object obj;
        Log.d("actionPassKeyVerify", new Gson().toJson((Object) jsMessage));
        final String callback = jsMessage.getCallback();
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
            try {
                Map map = (Map) jsMessage.getData();
                if (map != null && map.containsKey("type") && (obj = map.get("type")) != null) {
                    final Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(hBBaseWebActivity, hBBaseWebActivity, Security2FADialogHelper.u(new BigDecimal(obj.toString()).intValue()));
                    security2FADialogHelper.L(true);
                    security2FADialogHelper.M(true);
                    security2FADialogHelper.N(true);
                    security2FADialogHelper.R(new Security2FADialogHelper.Callback() {
                        public void onApiError(String str) {
                            super.onApiError(str);
                            LogAndWoodRecorder.a("actionVerify2FA", "onApiError-" + str);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg(str);
                            jsMessage.setData(new Verify2FAModel(false, (Verify2FATokenModel) null));
                            b.d(jsMessage, uVar);
                        }

                        public void onFailed(String str) {
                            LogAndWoodRecorder.a("actionVerify2FA", "onFailed-" + str);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg(str);
                            jsMessage.setData(new Verify2FAModel(false, (Verify2FATokenModel) null));
                            b.d(jsMessage, uVar);
                        }

                        public void onManualDismiss() {
                            super.onManualDismiss();
                            LogAndWoodRecorder.a("actionVerify2FA", "onManualDismiss");
                        }

                        public void onSuccess(String str) {
                            super.onSuccess(str);
                            Log.d("actionVerify2FA", "onSuccess - token: " + str);
                            JsMessage jsMessage = new JsMessage();
                            jsMessage.setAction(callback);
                            jsMessage.setCode(200);
                            jsMessage.setMsg("");
                            jsMessage.setData(new Verify2FAModel(true, new Verify2FATokenModel(str)));
                            b.d(jsMessage, uVar);
                            security2FADialogHelper.v();
                        }

                        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                            super.onSuccess(authResult);
                            Log.d("actionVerify2FA", "onSuccess - result: " + f.e().toJson((Object) authResult));
                        }
                    });
                }
            } catch (Exception e11) {
                LogAndWoodRecorder.a("actionVerify2FA", "onException-" + e11.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void backToH5(JsMessage jsMessage, u uVar) {
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setAction(jsMessage.getCallback());
        b.e(jsMessage2, uVar, false);
    }

    /* access modifiers changed from: private */
    public static void backToH5Error(JsMessage jsMessage, u uVar, String str) {
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(0);
        jsMessage2.setAction(jsMessage.getCallback());
        jsMessage2.setMsg(str);
        b.e(jsMessage2, uVar, false);
    }

    /* access modifiers changed from: private */
    public static void backToH5JumioFail(JsMessage jsMessage, u uVar) {
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(-1);
        jsMessage2.setAction(jsMessage.getCallback());
        b.e(jsMessage2, uVar, false);
    }

    @ActionAnnotation("20010082")
    public static void browserOpenUrl(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010082 jsMessage data:" + jsMessage.getData());
        try {
            oa.a.g().b().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) ((Map) jsMessage.getData()).get("url"))));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ all -> 0x00e4 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[Catch:{ all -> 0x00e4 }] */
    @com.hbg.lib.core.webview.annotation.ActionAnnotation("20010090")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cacheData(com.hbg.lib.core.webview.bean.JsMessage r6, v6.u r7) {
        /*
            java.lang.String r0 = "value"
            java.lang.String r1 = "key"
            java.lang.String r2 = "type"
            java.lang.String r3 = r6.getCallback()
            java.lang.Object r4 = r6.getData()     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4 instanceof java.util.Map     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x00e8
            java.lang.Object r6 = r6.getData()     // Catch:{ all -> 0x00e4 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x00e4 }
            if (r6 == 0) goto L_0x00e8
            boolean r4 = r6.isEmpty()     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x00e8
            java.lang.Object r4 = r6.get(r2)     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4 instanceof java.lang.String     // Catch:{ all -> 0x00e4 }
            r5 = 0
            if (r4 == 0) goto L_0x0036
            java.lang.Object r2 = r6.get(r2)     // Catch:{ all -> 0x00e4 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00e4 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r2 = r5
        L_0x0037:
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x003e
            return
        L_0x003e:
            java.lang.Object r4 = r6.get(r1)     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4 instanceof java.lang.String     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x0053
            java.lang.Object r1 = r6.get(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00e4 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00e4 }
            if (r4 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = r5
        L_0x0054:
            java.lang.Object r4 = r6.get(r0)     // Catch:{ all -> 0x00e4 }
            boolean r4 = r4 instanceof java.lang.String     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x0069
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00e4 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r6 = r5
        L_0x006a:
            java.lang.String r0 = "get"
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r4 = "HB_WebData"
            if (r0 == 0) goto L_0x0095
            if (r1 != 0) goto L_0x007a
            callbackGetCacheData(r7, r3, r5)     // Catch:{ all -> 0x00e4 }
            return
        L_0x007a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r6.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = getCacheDataKeyPrefix()     // Catch:{ all -> 0x00e4 }
            r6.append(r0)     // Catch:{ all -> 0x00e4 }
            r6.append(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = com.hbg.lib.common.utils.SP.j(r4, r6, r5)     // Catch:{ all -> 0x00e4 }
            callbackGetCacheData(r7, r3, r6)     // Catch:{ all -> 0x00e4 }
            goto L_0x00e8
        L_0x0095:
            java.lang.String r7 = "set"
            boolean r7 = r2.equals(r7)     // Catch:{ all -> 0x00e4 }
            if (r7 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00c1
            if (r6 == 0) goto L_0x00c1
            int r7 = r6.length()     // Catch:{ all -> 0x00e4 }
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r7 <= r0) goto L_0x00aa
            goto L_0x00c1
        L_0x00aa:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r7.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r0 = getCacheDataKeyPrefix()     // Catch:{ all -> 0x00e4 }
            r7.append(r0)     // Catch:{ all -> 0x00e4 }
            r7.append(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e4 }
            com.hbg.lib.common.utils.SP.w(r4, r7, r6)     // Catch:{ all -> 0x00e4 }
            goto L_0x00e8
        L_0x00c1:
            return
        L_0x00c2:
            java.lang.String r6 = "delete"
            boolean r6 = r2.equals(r6)     // Catch:{ all -> 0x00e4 }
            if (r6 == 0) goto L_0x00e8
            if (r1 != 0) goto L_0x00cd
            return
        L_0x00cd:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e4 }
            r6.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r7 = getCacheDataKeyPrefix()     // Catch:{ all -> 0x00e4 }
            r6.append(r7)     // Catch:{ all -> 0x00e4 }
            r6.append(r1)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00e4 }
            com.hbg.lib.common.utils.SP.o(r4, r6)     // Catch:{ all -> 0x00e4 }
            goto L_0x00e8
        L_0x00e4:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webview2.action.JsBusinessActionHelper.cacheData(com.hbg.lib.core.webview.bean.JsMessage, v6.u):void");
    }

    private static void callbackGetCacheData(u uVar, String str, String str2) {
        JsStrMessage jsStrMessage = new JsStrMessage();
        jsStrMessage.setAction(str);
        jsStrMessage.setCode(200);
        if (!TextUtils.isEmpty(str2)) {
            jsStrMessage.setData(str2);
        }
        k.f("huobiweb", "JsMessageHelper-->loginCheck onNext = " + jsStrMessage);
        b.d(jsStrMessage, uVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @com.hbg.lib.core.webview.annotation.ActionAnnotation("native_20010013")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void checkLoginStatus(com.hbg.lib.core.webview.bean.JsMessage r4, v6.u r5) {
        /*
            java.lang.Object r0 = r4.getData()
            boolean r0 = r0 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0022
            java.lang.Object r0 = r4.getData()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r2 = "forceLoginSuccess"
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x0022
            java.lang.Object r0 = r0.get(r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.lang.String r2 = "JsBusinessActionHelper"
            if (r0 == 0) goto L_0x004b
            tg.r r0 = tg.r.x()
            boolean r0 = r0.F0()
            if (r0 != 0) goto L_0x0041
            h5LoginResult(r1, r4, r5)
            android.app.Activity r4 = r5.getActivity()
            r4.finish()
            java.lang.String r4 = "checkLoginStatus, 1"
            android.util.Log.d(r2, r4)
            goto L_0x005b
        L_0x0041:
            r0 = 1
            h5LoginResult(r0, r4, r5)
            java.lang.String r4 = "checkLoginStatus, 2"
            android.util.Log.d(r2, r4)
            goto L_0x005b
        L_0x004b:
            tg.r r0 = tg.r.x()
            boolean r0 = r0.F0()
            h5LoginResult(r0, r4, r5)
            java.lang.String r4 = "checkLoginStatus, 3"
            android.util.Log.d(r2, r4)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webview2.action.JsBusinessActionHelper.checkLoginStatus(com.hbg.lib.core.webview.bean.JsMessage, v6.u):void");
    }

    private static void choosePic(String str, final JsMessage jsMessage, final u uVar) {
        d.o().g(uVar.getActivity(), str, 1, new e() {
            public void onCancel() {
            }

            public void onResult(List<LocalMedia> list) {
                JsMessage jsMessage = new JsMessage();
                jsMessage.setAction(JsMessage.this.getCallback());
                jsMessage.setCode(0);
                jsMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
                try {
                    String realPath = list.get(0).getRealPath();
                    File file = new File(realPath);
                    k.c("pre filePath: size = " + (file.length() / 1024));
                    File compressFileToSize = ImageUtil.getInstance().compressFileToSize(file, 512);
                    if (compressFileToSize != null) {
                        String str = "data:image/" + realPath.substring(realPath.lastIndexOf(InstructionFileId.DOT) + 1) + ";base64," + Base64Utils.d(compressFileToSize.getPath());
                        k.c("onResult: base64 size = " + (((long) str.length()) / 1024));
                        HashMap hashMap = new HashMap();
                        hashMap.put("picture", str);
                        jsMessage.setData(hashMap);
                        b.d(jsMessage, uVar);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        });
    }

    @ActionAnnotation("20010010")
    public static void dealWithHoldTokenCalendar(final JsMessage jsMessage, final u uVar) {
        Class cls = PrimeService.class;
        Observable.zip(((PrimeService) p.C(cls)).getAveragePositionStr().compose(RxJavaHelper.t(uVar)), ((PrimeService) p.C(cls)).getAveragePositionListStr().compose(RxJavaHelper.t(uVar)), k.f20841b).compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<PrimeHoldTokenCalendar>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                th2.printStackTrace();
            }

            public void onNext(PrimeHoldTokenCalendar primeHoldTokenCalendar) {
                super.onNext(primeHoldTokenCalendar);
                String callback = JsMessage.this.getCallback();
                JsMessage jsMessage = new JsMessage();
                jsMessage.setCode(200);
                jsMessage.setData(primeHoldTokenCalendar);
                jsMessage.setAction(callback);
                b.e(jsMessage, uVar, true);
            }
        });
    }

    @ActionAnnotation(actionName = "gotoTradePage", value = "20010011")
    public static void dealWithJumpTradePage(JsMessage jsMessage, u uVar) {
        ClosePathFloatView.f(TradeType.PRO.toString(), "/webView/index", uVar.getActivity().getIntent().getExtras());
        uVar.getActivity().startActivity(k0.s(uVar.getActivity(), (String) jsMessage.getData(), true));
    }

    private static void dealWithKyc(JsMessage jsMessage, u uVar) {
        if (uVar != null) {
            uVar.getWebView().post(new c(jsMessage, uVar));
        }
    }

    private static void dealWithLogin(JsMessage jsMessage, u uVar) {
        boolean z11;
        if (jsMessage.getData() instanceof Map) {
            Map map = (Map) jsMessage.getData();
            if (map.containsKey("forceLoginSuccess")) {
                z11 = ((Boolean) map.get("forceLoginSuccess")).booleanValue();
                uVar.setNeedLoginAction(true, z11, jsMessage);
                JumpTarget jumpTarget = new JumpTarget((Intent) null, (Intent) null);
                jumpTarget.setExpandData("SUB_ACCOUNT_ENTER_FLAG");
                c.i().d(uVar.getActivity(), jumpTarget);
            }
        }
        z11 = false;
        uVar.setNeedLoginAction(true, z11, jsMessage);
        JumpTarget jumpTarget2 = new JumpTarget((Intent) null, (Intent) null);
        jumpTarget2.setExpandData("SUB_ACCOUNT_ENTER_FLAG");
        c.i().d(uVar.getActivity(), jumpTarget2);
    }

    @ActionAnnotation("20010002")
    public static void dealWithSession(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        String q11 = r.x().q();
        i6.d.b("ContractWebViewJsCallback-->dealWithSession--> action:" + callback + " contractToken:" + q11);
        if (!r.x().F0() || !TextUtils.isEmpty(q11)) {
            JsMessage jsMessage2 = new JsMessage();
            jsMessage2.setCode(200);
            jsMessage2.setData(new WebSessionData(q11));
            jsMessage2.setAction(callback);
            b.d(jsMessage2, uVar);
            return;
        }
        ContractUserInfoProvider.i().p(false).subscribe(new j(uVar, callback));
    }

    @ActionAnnotation("20010026")
    public static void dealWithTurkeyKycDialog(JsMessage jsMessage, u uVar) {
        if (jsMessage.getData() instanceof Map) {
            try {
                uVar.getActivity().runOnUiThread(new e((ChooseListData) new Gson().fromJson(new JSONObject((Map<String, Object>) (Map) jsMessage.getData()).toString(), ChooseListData.class), jsMessage, uVar));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @ActionAnnotation("10000010")
    public static void dealWithVipInfo(JsMessage jsMessage, u uVar) {
    }

    private static String getCacheDataKeyPrefix() {
        return "HB_WebData_";
    }

    @ActionAnnotation(actionName = "needsTicket", value = "10075944")
    public static void getTicket(JsMessage jsMessage, u uVar) {
        if (r.x().F0()) {
            handleGetTicket(jsMessage, uVar);
            return;
        }
        JsStrMessage jsStrMessage = new JsStrMessage();
        jsStrMessage.setAction(jsMessage.getCallback());
        jsStrMessage.setCode(0);
        jsStrMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
        jsStrMessage.setData(null);
        b.d(jsStrMessage, uVar);
    }

    public static void h5LoginResult(boolean z11, JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "HBWebViewPool, h5LoginResult - isSuccess " + z11);
        k.o(LOG_TAG, "HBWebViewPool, h5LoginResult - jsMsg " + jsMessage);
        if (jsMessage != null) {
            if (z11) {
                String callback = jsMessage.getCallback();
                JsMessage jsMessage2 = new JsMessage();
                jsMessage2.setCode(200);
                jsMessage2.setData(1);
                jsMessage2.setAction(callback);
                b.d(jsMessage2, uVar);
            } else {
                String callback2 = jsMessage.getCallback();
                JsMessage jsMessage3 = new JsMessage();
                jsMessage3.setCode(200);
                jsMessage3.setData(0);
                jsMessage3.setAction(callback2);
                b.d(jsMessage3, uVar);
            }
            uVar.clearNeedLoginAction();
        }
    }

    private static void handleGetTicket(JsMessage jsMessage, final u uVar) {
        final String callback = jsMessage.getCallback();
        i6.d.i("HBWebViewPool, JsMessageHelper-->handleGetTicket-->action:" + callback);
        getTicket("js#handleGetTicket").compose(RxJavaHelper.t(uVar)).subscribe(new BaseSubscriber<LoginInfoData>() {
            public void onError(Throwable th2) {
                super.onError(th2);
                i6.d.j("huobiweb", "HBWebViewPool, JsMessageHelper-->handleGetTicket error = " + th2.getMessage());
                JsStrMessage jsStrMessage = new JsStrMessage();
                jsStrMessage.setAction(callback);
                jsStrMessage.setCode(0);
                jsStrMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
                jsStrMessage.setData(null);
                b.d(jsStrMessage, uVar);
            }

            public void onNext(LoginInfoData loginInfoData) {
                super.onNext(loginInfoData);
                i6.d.j("huobiweb", "JsMessageHelper-->handleGetTicket success = " + loginInfoData);
                JsStrMessage jsStrMessage = new JsStrMessage();
                jsStrMessage.setAction(callback);
                jsStrMessage.setCode(200);
                jsStrMessage.setMsg((String) null);
                jsStrMessage.setData(loginInfoData.getTicket());
                b.d(jsStrMessage, uVar);
            }
        });
    }

    @ActionAnnotation("20010083")
    public static void jump2CommentDetail(JsMessage jsMessage, u uVar) {
        Map map;
        try {
            if ((jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null && !map.isEmpty()) {
                Intent intent = new Intent(uVar.getActivity(), CommentDetailActivity.class);
                Object obj = map.get(CommunityConstants.TOPIC_ID);
                if (obj instanceof String) {
                    intent.putExtra(CommunityConstants.TOPIC_ID, (String) obj);
                }
                Object obj2 = map.get("topicType");
                if (obj2 instanceof String) {
                    intent.putExtra("topicType", (String) obj2);
                }
                Object obj3 = map.get("commentId");
                if (obj3 instanceof String) {
                    intent.putExtra("commentId", (String) obj3);
                }
                uVar.getActivity().startActivity(intent);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @ActionAnnotation("20010057")
    public static void jump2PointCardList(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010057 JsMessage - " + jsMessage);
        if (uVar.getActivity() != null) {
            b2.a.d().a("/point/card/list").navigation();
        }
    }

    @ActionAnnotation("20010058")
    public static void jump2PurchasePointCard(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010058 JsMessage - " + jsMessage);
        if (uVar.getActivity() != null) {
            Object data = jsMessage.getData();
            if (data instanceof String) {
                k.o(LOG_TAG, "action - 20010058 JsMessage Data- " + jsMessage.getData());
                String str = (String) data;
                if (!TextUtils.isEmpty(str)) {
                    b2.a.d().a("/point/card/purchase").withString("param_normal_data", str).navigation();
                }
            }
        }
    }

    @ActionAnnotation("20010028")
    public static void jumpC2CLendPage(JsMessage jsMessage, u uVar) {
        try {
            if (jsMessage.getData() != null) {
                ClosePathFloatView.f(TradeType.PRO.toString(), "/webView/index", uVar.getActivity().getIntent().getExtras());
                k0.K(uVar.getActivity(), (String) ((Map) jsMessage.getData()).get("coin"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @ActionAnnotation("20010027")
    public static void jumpC2CTradePage(JsMessage jsMessage, u uVar) {
        try {
            if (jsMessage.getData() != null) {
                ClosePathFloatView.f(TradeType.PRO.toString(), "/webView/index", uVar.getActivity().getIntent().getExtras());
                k0.J(uVar.getActivity(), (String) ((Map) jsMessage.getData()).get("symbol"), true);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007d  */
    @com.hbg.lib.core.webview.annotation.ActionAnnotation("20010015")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void jumpContractPage(com.hbg.lib.core.webview.bean.JsMessage r5, v6.u r6) {
        /*
            java.lang.Object r5 = r5.getData()
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r0 = "contractCode"
            java.lang.Object r0 = r5.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "isCross"
            java.lang.Object r5 = r5.get(r1)
            boolean r1 = r5 instanceof java.lang.String
            if (r1 == 0) goto L_0x001b
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x002c
        L_0x001b:
            boolean r1 = r5 instanceof java.lang.Double
            if (r1 == 0) goto L_0x002a
            java.lang.Double r5 = (java.lang.Double) r5
            double r1 = r5.doubleValue()
            java.lang.String r5 = java.lang.Double.toString(r1)
            goto L_0x002c
        L_0x002a:
            java.lang.String r5 = "1"
        L_0x002c:
            r1 = -1
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto L_0x0042
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x003e }
            r1 = 1
            if (r5 != r1) goto L_0x003b
            goto L_0x0042
        L_0x003b:
            r5 = 2
            r1 = r5
            goto L_0x0042
        L_0x003e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0042:
            com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController r5 = com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController.k()
            java.util.List r5 = r5.e()
            r2 = 0
            if (r5 == 0) goto L_0x006a
            java.util.Iterator r5 = r5.iterator()
        L_0x0051:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r5.next()
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r3 = (com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo) r3
            if (r3 == 0) goto L_0x0051
            java.lang.String r4 = r3.getContractCode()
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0051
            goto L_0x006b
        L_0x006a:
            r3 = r2
        L_0x006b:
            com.hbg.lib.data.future.controller.FutureContractInfoController r5 = com.hbg.lib.data.future.controller.FutureContractInfoController.n()
            com.hbg.lib.data.future.bean.FutureContractInfo r5 = r5.o(r0)
            if (r3 == 0) goto L_0x007d
            android.app.Activity r5 = r6.getActivity()
            com.huobi.swap.ui.SwapTradeBaseFragment.Qi(r5, r3)
            goto L_0x00b2
        L_0x007d:
            if (r5 == 0) goto L_0x0087
            android.app.Activity r0 = r6.getActivity()
            com.huobi.linearswap.ui.LinearSwapTradeBaseFragment.Lj(r0, r5, r1)
            goto L_0x00b2
        L_0x0087:
            java.util.List r5 = com.huobi.contract.helper.ContractCurrencyUtils.m()
            if (r5 == 0) goto L_0x00ab
            r1 = 0
        L_0x008e:
            int r3 = r5.size()
            if (r1 >= r3) goto L_0x00ab
            java.lang.Object r3 = r5.get(r1)
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r3 = (com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo) r3
            if (r3 == 0) goto L_0x00a8
            java.lang.String r4 = r3.getContractCode()
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00a8
            r2 = r3
            goto L_0x00ab
        L_0x00a8:
            int r1 = r1 + 1
            goto L_0x008e
        L_0x00ab:
            android.app.Activity r5 = r6.getActivity()
            com.huobi.contract.ui.ContractTradeBaseFragment.Ri(r5, r2)
        L_0x00b2:
            android.app.Activity r5 = r6.getActivity()
            android.content.Intent r5 = r5.getIntent()
            android.os.Bundle r5 = r5.getExtras()
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "/webView/index"
            com.hbg.lib.widgets.ClosePathFloatView.f(r0, r1, r5)
            android.app.Activity r5 = r6.getActivity()
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webview2.action.JsBusinessActionHelper.jumpContractPage(com.hbg.lib.core.webview.bean.JsMessage, v6.u):void");
    }

    @ActionAnnotation("20010016")
    public static void jumpDepositPage(JsMessage jsMessage, u uVar) {
        UnifyDepositActivity.wh(uVar.getActivity(), (String) ((Map) jsMessage.getData()).get("coin"));
    }

    @ActionAnnotation("20010050")
    public static void jumpGridAct(JsMessage jsMessage, u uVar) {
        Map map = (Map) jsMessage.getData();
        Activity activity = uVar.getActivity();
        Bundle bundle = new Bundle();
        bundle.putBoolean("EXTRA_FORCE_RESTART", true);
        bundle.putBoolean("EXTRA_ACT_ANIM", false);
        bundle.putBoolean("EXTRA_AI", "0".equals(map.get("type")));
        bundle.putString("EXTRA_SYMBOL", (String) map.get("symbol"));
        bundle.putString("EXTRA_MIN_PRICE", (String) map.get("minPrice"));
        bundle.putString("EXTRA_MAX_PRICE", (String) map.get("maxPrice"));
        bundle.putString("EXTRA_GRID_NUM", (String) map.get("gridNum"));
        HbgRouter.i(activity, "/trade/grid", bundle);
    }

    /* access modifiers changed from: private */
    public static void jumpHuaWeiLiveness(final JsMessage jsMessage, final HBBaseWebActivity hBBaseWebActivity, final KycTicketInfo kycTicketInfo) {
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_AUDIO, PermissionConfig.READ_MEDIA_IMAGES} : new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE, "android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        final String ticket = kycTicketInfo.getTicket();
        if (EasyPermissions.hasPermissions(hBBaseWebActivity, strArr)) {
            k.o(LOG_TAG, "jumpHuaWeiLiveness has permissions");
            openHuaweiLiveness(hBBaseWebActivity, jsMessage, kycTicketInfo);
            return;
        }
        hBBaseWebActivity.setPermissionCallback(new x6.f() {
            public void onPermissionsDenied(int i11, List<String> list) {
                k.o(JsBusinessActionHelper.LOG_TAG, "jumpHuaWeiLiveness permissions denied:" + list);
                HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
                JsBusinessActionHelper.postHuaweiLivenessResult(hBBaseWebActivity, jsMessage, ticket, false, (String) null, hBBaseWebActivity.getString(R.string.n_kyc_huawei_liveness_permission_hint));
            }

            public void onPermissionsGranted(int i11, List<String> list) {
                k.o(JsBusinessActionHelper.LOG_TAG, "jumpHuaWeiLiveness onPermissionsGranted");
                JsBusinessActionHelper.openHuaweiLiveness(HBBaseWebActivity.this, jsMessage, kycTicketInfo);
            }
        });
        EasyPermissions.requestPermissions(hBBaseWebActivity, 130, strArr);
    }

    /* access modifiers changed from: private */
    public static void jumpJumioLiveness(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar) {
        JumioKycHelper.f20896a.a().c(kycTicketInfo.getSdkToken(), new v(jsMessage, kycTicketInfo, uVar));
    }

    @ActionAnnotation("20010061")
    public static void jumpKycAuthPage(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010061 jsMessage data:" + jsMessage.getData());
        dealWithKyc(jsMessage, uVar);
    }

    @ActionAnnotation("20010014")
    public static void jumpOtcPage(JsMessage jsMessage, u uVar) {
        int i11;
        int i12;
        if (r.x().X()) {
            HuobiToastUtil.k(j.c(), R.string.sub_account_not_support_otc);
            return;
        }
        int i13 = 0;
        try {
            Map map = (Map) jsMessage.getData();
            if (map != null) {
                Object obj = map.get("coin_id");
                i11 = obj != null ? ((Integer) obj).intValue() : 0;
                try {
                    Object obj2 = map.get("area");
                    i12 = obj2 != null ? ((Integer) obj2).intValue() : 0;
                    i13 = i11;
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    jp.k0.n(uVar.getActivity(), OtcTradeAreaEnum.matchTradeArea(i13), va.b.g(i11));
                    uVar.getActivity().finish();
                }
            } else {
                i12 = 0;
            }
            i11 = i13;
            i13 = i12;
        } catch (Exception e12) {
            e = e12;
            i11 = 0;
            e.printStackTrace();
            jp.k0.n(uVar.getActivity(), OtcTradeAreaEnum.matchTradeArea(i13), va.b.g(i11));
            uVar.getActivity().finish();
        }
        jp.k0.n(uVar.getActivity(), OtcTradeAreaEnum.matchTradeArea(i13), va.b.g(i11));
        uVar.getActivity().finish();
    }

    @ActionAnnotation("20010003")
    public static void jumpPage(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010003 JsMessage - " + jsMessage);
        if (System.currentTimeMillis() - lastKycClickTime <= 100) {
            return;
        }
        if (jsMessage.getData() instanceof Map) {
            try {
                String str = (String) ((Map) jsMessage.getData()).get("app_page");
                if (str != null && str.endsWith("account/identity_verify")) {
                    dealWithKyc(jsMessage, uVar);
                    uVar.getActivity().finish();
                    lastKycClickTime = System.currentTimeMillis();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                k.j("action 20010003", e11);
            }
        } else if (((String) jsMessage.getData()).endsWith("account/identity_verify")) {
            dealWithKyc(jsMessage, uVar);
            uVar.getActivity().finish();
            lastKycClickTime = System.currentTimeMillis();
        }
    }

    @ActionAnnotation("20010030")
    public static void jumpRegister(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action 20010030");
        try {
            uVar.getActivity().runOnUiThread(new g(uVar));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @ActionAnnotation("20010031")
    public static void jumpSavings(JsMessage jsMessage, u uVar) {
        uVar.getActivity().startActivity(new Intent(uVar.getActivity(), SavingsDataActivity.class));
    }

    @ActionAnnotation(actionName = "listDialog", value = "20010033")
    public static void jumpSelectWidget(JsMessage jsMessage, u uVar) {
        k.o(LOG_TAG, "action - 20010033 JsMessage - " + jsMessage);
        if (jsMessage.getData() instanceof Map) {
            try {
                if (jsMessage.getData() != null) {
                    H5SelectWidgetData h5SelectWidgetData = (H5SelectWidgetData) new Gson().fromJson(new JSONObject((Map<String, Object>) (Map) jsMessage.getData()).toString(), H5SelectWidgetData.class);
                    k.o(LOG_TAG, "selectWidgetData " + h5SelectWidgetData);
                    uVar.getActivity().runOnUiThread(new f(h5SelectWidgetData, jsMessage, uVar));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void jumpSumsubLiveness(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar) {
        SumsubKycHelper.f20900a.a().c(kycTicketInfo.getSdkToken(), new w(jsMessage, kycTicketInfo, uVar));
    }

    @ActionAnnotation("20010032")
    public static void jumpTransfer(JsMessage jsMessage, u uVar) {
        try {
            if (jsMessage.getData() != null) {
                Map map = (Map) jsMessage.getData();
                String str = (String) map.get("coin");
                int doubleValue = (int) ((Double) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).doubleValue();
                if (doubleValue == 1) {
                    UnifyTransferActivity.Th(uVar.getActivity(), str, CouponReturn.TYPE_EXPERIENCE);
                } else if (doubleValue == 2) {
                    UnifyTransferActivity.Th(uVar.getActivity(), str, "4");
                } else if (doubleValue == 3) {
                    UnifyTransferActivity.Th(uVar.getActivity(), str, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP);
                } else if (doubleValue != 4) {
                    UnifyTransferActivity.Th(uVar.getActivity(), str, (String) null);
                } else {
                    UnifyTransferActivity.Th(uVar.getActivity(), str, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @ActionAnnotation("20010017")
    public static void jumpWithdrawPage(JsMessage jsMessage, u uVar) {
        UnifyWithdrawActivity.Di(uVar.getActivity(), (String) ((Map) jsMessage.getData()).get("coin"), TradeType.PRO);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$actionScanQR$22(HBBaseWebActivity hBBaseWebActivity, ActivityResultLauncher activityResultLauncher, int i11) {
        String[] strArr;
        if (i11 == 0) {
            LogAndWoodRecorder.a("actionScanQR", "HasPermissions start CaptureActivity.");
            Intent intent = new Intent(hBBaseWebActivity, CaptureActivity.class);
            intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, hBBaseWebActivity.getString(R.string.n_scan_automation_tips));
            activityResultLauncher.a(intent);
        } else if (i11 == 2) {
            if (Build.VERSION.SDK_INT >= 33) {
                strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
            } else {
                strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
            }
            LogAndWoodRecorder.a("actionScanQR", "Has not Permissions, start request permissions.");
            EasyPermissions.requestPermissions(hBBaseWebActivity, 123, strArr);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ PrimeHoldTokenCalendar lambda$dealWithHoldTokenCalendar$11(JsonObject jsonObject, JsonObject jsonObject2) {
        PrimeHoldTokenCalendar primeHoldTokenCalendar = new PrimeHoldTokenCalendar();
        primeHoldTokenCalendar.setPosition(jsonObject);
        primeHoldTokenCalendar.setPositionList(jsonObject2);
        return primeHoldTokenCalendar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dealWithKyc$14(JsMessage jsMessage, u uVar) {
        Map map;
        Object obj;
        k.o(LOG_TAG, "action - 20010003/20010061 isLogin:" + r.x().F0());
        if (r.x().F0()) {
            FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
            flutterKycConfig.setPhone(r.x().F());
            flutterKycConfig.setEmail(r.x().u());
            if ((jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null && !map.isEmpty() && (obj = map.get("authBizCode")) != null && (obj instanceof String)) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    flutterKycConfig.setAuthBizCode(str);
                }
            }
            b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
            return;
        }
        dealWithLogin(jsMessage, uVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dealWithSession$10(u uVar, String str, ContractUserInfo.UserBean userBean) {
        if (uVar != null && uVar.isAlive()) {
            String q11 = r.x().q();
            i6.d.b("ContractWebViewJsCallback-->dealWithSession--> action:" + str + " contractToken2:" + q11);
            JsMessage jsMessage = new JsMessage();
            jsMessage.setCode(200);
            jsMessage.setData(new WebSessionData(q11));
            jsMessage.setAction(str);
            b.d(jsMessage, uVar);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dealWithTurkeyKycDialog$2(JsMessage jsMessage, u uVar, ChooseCityEntity chooseCityEntity) {
        long j11;
        SelectData selectData = new SelectData();
        if (chooseCityEntity == null) {
            j11 = -1;
        } else {
            j11 = chooseCityEntity.getId();
        }
        selectData.setSelectId(j11);
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setData(selectData);
        jsMessage2.setCode(200);
        jsMessage2.setAction(jsMessage.getCallback());
        b.e(jsMessage2, uVar, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dealWithTurkeyKycDialog$3(ChooseListData chooseListData, JsMessage jsMessage, u uVar) {
        ChooseCityFragment Gh = ChooseCityFragment.Gh(chooseListData);
        Gh.Ih(new s(jsMessage, uVar));
        Gh.show(((FragmentActivity) uVar.getActivity()).getSupportFragmentManager(), (String) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$jumpJumioLiveness$5(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar, String str) {
        if (TextUtils.isEmpty(str)) {
            onLivenessSuccess(jsMessage, kycTicketInfo, uVar);
            return null;
        }
        onLivenessError(jsMessage, kycTicketInfo, uVar, str);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$jumpRegister$0(u uVar) {
        if (!r.x().F0()) {
            Bundle bundle = new Bundle();
            bundle.putString("register_type", "register_email");
            bundle.putBoolean("FROM_H5_PAGE", true);
            Intent h11 = k0.h(uVar.getActivity());
            bundle.putParcelable("target", new JumpTarget(h11, h11));
            String originalUrl = uVar.getWebView().getOriginalUrl();
            k.o(LOG_TAG, "originalUrl - " + originalUrl);
            if (!TextUtils.isEmpty(originalUrl)) {
                String queryParameter = Uri.parse(originalUrl).getQueryParameter("inviter_id");
                if (!TextUtils.isEmpty(queryParameter)) {
                    is.a.f84301d = queryParameter;
                }
            }
            if (gj.a.b().c()) {
                HbgRouter.i(uVar.getActivity(), "/login/register_v2", bundle);
            } else {
                HbgRouter.i(uVar.getActivity(), "/login/register", bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$jumpSelectWidget$1(H5SelectWidgetData h5SelectWidgetData, final JsMessage jsMessage, final u uVar) {
        H5SelectDialogFragment d11 = H5SelectDialogFragment.d(h5SelectWidgetData);
        d11.e(new H5SelectDialogFragment.a() {
            public void select(int i11) {
                SelectData selectData = new SelectData();
                selectData.setSelectId((long) i11);
                JsMessage jsMessage = new JsMessage();
                jsMessage.setData(selectData);
                jsMessage.setCode(200);
                jsMessage.setAction(JsMessage.this.getCallback());
                b.e(jsMessage, uVar, false);
            }
        });
        d11.show(uVar.getActivity().getFragmentManager(), "H5SelectDialogFragment");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$jumpSumsubLiveness$4(JsMessage jsMessage, KycTicketInfo kycTicketInfo, u uVar, String str) {
        if (TextUtils.isEmpty(str)) {
            onLivenessSuccess(jsMessage, kycTicketInfo, uVar);
            return null;
        }
        onLivenessError(jsMessage, kycTicketInfo, uVar, str);
        return null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$openTronLinkApp$20(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$picChoose$15(Dialog dialog, JsMessage jsMessage, u uVar, View view) {
        dialog.dismiss();
        choosePic("Album", jsMessage, uVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$picChoose$16(Dialog dialog, JsMessage jsMessage, u uVar, View view) {
        dialog.dismiss();
        choosePic(PictureMimeType.CAMERA, jsMessage, uVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$picChoose$17(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$realJumpJumioLiveness$8(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, u uVar, String str) {
        if (TextUtils.isEmpty(str)) {
            livenessSuccess(jsMessage, kycSDKTokenInfo, uVar);
            return null;
        }
        livenessError(jsMessage, kycSDKTokenInfo, uVar, str);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$realJumpSumsubLiveness$7(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, u uVar, String str) {
        if (TextUtils.isEmpty(str)) {
            livenessSuccess(jsMessage, kycSDKTokenInfo, uVar);
            return null;
        }
        livenessError(jsMessage, kycSDKTokenInfo, uVar, str);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendComment$18(String str, u uVar, String str2, String str3) {
        JsMessage jsMessage = new JsMessage();
        jsMessage.setAction(str);
        jsMessage.setCode(0);
        jsMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
        HashMap hashMap = new HashMap();
        hashMap.put("content", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(InnerShareParams.IMAGE_URL, str3);
        }
        jsMessage.setData(hashMap);
        b.d(jsMessage, uVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$tradingBotFilterDialog$12(JsMessage jsMessage, u uVar) {
        try {
            tradingBotFilterCallBack = jsMessage.getCallback();
            Activity activity = uVar.getActivity();
            EdgeEngineScene edgeEngineScene = EdgeEngineScene.TRADE_BOT;
            rj.b bVar = new rj.b(activity, edgeEngineScene.getScene());
            bVar.H();
            ek.b.f47515a.f(bVar, edgeEngineScene.getScene());
            yt.a.f85088a.a(bVar, "");
            uVar.getActivity().addContentView(bVar.D("trade_filter.xml", uVar.getActivity()), new ViewGroup.LayoutParams(0, 0));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showFromType", (Object) 1);
            if (jsMessage.getData() instanceof Map) {
                Map map = (Map) jsMessage.getData();
                if (!map.isEmpty()) {
                    jSONObject.putAll(map);
                }
            }
            bVar.I("showFilterMenuPop(" + jSONObject.toJSONString() + ")");
        } catch (Throwable th2) {
            i6.d.g(th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$tradingBotShare$13(JsMessage jsMessage) {
        Map map;
        try {
            if ((jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null && !map.isEmpty()) {
                AssetJumpAbility.C(oa.a.g().b(), (String) map.get("strategyId"), (String) map.get("symbol"));
            }
        } catch (Throwable th2) {
            i6.d.g(th2);
        }
    }

    private static void livenessError(final JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, final u uVar, final String str) {
        a.a().f(kycSDKTokenInfo.getTicket(), 500, str).d(new RequestCallback1<String>() {
            public void onRequestFailure(Throwable th2) {
                JsBusinessActionHelper.backToH5Error(JsMessage.this, uVar, str);
            }

            public void onRequestSuccess(String str) {
                JsBusinessActionHelper.backToH5Error(JsMessage.this, uVar, str);
            }
        });
    }

    private static void livenessSuccess(final JsMessage jsMessage, final KycSDKTokenInfo kycSDKTokenInfo, final u uVar) {
        a.a().f(kycSDKTokenInfo.getTicket(), 200, "").d(new q6.a<String>(uVar) {
            public void onError2(Throwable th2) {
                super.onError2(th2);
                if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_SUMSUB)) {
                    k.f("SumsubKycHelper", "submit is onError2:" + th2.getMessage());
                } else if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_JUMIO)) {
                    k.f("JumioKycHelper", "submit is onError2:" + th2.getMessage());
                }
                th2.printStackTrace();
                JsBusinessActionHelper.backToH5Error(jsMessage, uVar, th2.getMessage());
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_SUMSUB)) {
                    k.f("SumsubKycHelper", "submit is onFailed:" + aPIStatusErrorException.getMessage());
                } else if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_JUMIO)) {
                    k.f("JumioKycHelper", "submit is onFailed:" + aPIStatusErrorException.getMessage());
                }
                aPIStatusErrorException.printStackTrace();
                JsBusinessActionHelper.backToH5Error(jsMessage, uVar, aPIStatusErrorException.getErrMsg());
            }

            public void onRequestSuccess(String str) {
                if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_SUMSUB)) {
                    k.f("SumsubKycHelper", "submit is success");
                } else if (kycSDKTokenInfo.getLivingApi().equals(KycSDKTokenInfo.LIVING_API_JUMIO)) {
                    k.f("JumioKycHelper", "submit is success");
                }
                JsBusinessActionHelper.backToH5(jsMessage, uVar);
            }
        });
    }

    @ActionAnnotation(actionName = "loginCheck", value = "20010074")
    public static void loginCheck(JsMessage jsMessage, final u uVar) {
        if (r.x().F0()) {
            final String callback = jsMessage.getCallback();
            k.e("JsMessageHelper-->loginCheck-->action:" + callback);
            o9.a.a().checkLogin().b().compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber<Object>() {
                public void onError(Throwable th2) {
                    super.onError(th2);
                    k.g("huobiweb", "JsMessageHelper-->loginCheck error 1  ", th2);
                    JsStrMessage jsStrMessage = new JsStrMessage();
                    jsStrMessage.setAction(callback);
                    jsStrMessage.setCode(0);
                    jsStrMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
                    jsStrMessage.setData(null);
                    b.d(jsStrMessage, uVar);
                }

                public void onNext(Object obj) {
                    super.onNext(obj);
                    JsStrMessage jsStrMessage = new JsStrMessage();
                    jsStrMessage.setAction(callback);
                    jsStrMessage.setCode(200);
                    jsStrMessage.setMsg((String) null);
                    k.f("huobiweb", "JsMessageHelper-->loginCheck onNext = " + jsStrMessage);
                    b.d(jsStrMessage, uVar);
                }
            });
            return;
        }
        k.f("huobiweb", "JsMessageHelper-->loginCheck error 2  ");
        JsStrMessage jsStrMessage = new JsStrMessage();
        jsStrMessage.setAction(jsMessage.getCallback());
        jsStrMessage.setCode(0);
        jsStrMessage.setMsg(uVar.getActivity().getString(R.string.server_error));
        jsStrMessage.setData(null);
        b.d(jsStrMessage, uVar);
    }

    private static void onHuaweiError(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, String str, String str2, boolean z11) {
        final String str3 = str2;
        final boolean z12 = z11;
        final JsMessage jsMessage2 = jsMessage;
        final HBBaseWebActivity hBBaseWebActivity2 = hBBaseWebActivity;
        a.a().f(str, 500, str2).d(new q6.a<String>(hBBaseWebActivity) {
            public void onError2(Throwable th2) {
                super.onError2(th2);
                k.f("onHuaweiError", AppUtil.b("submit is onError2:", th2.getMessage()));
                th2.printStackTrace();
                JsBusinessActionHelper.backToH5Error(jsMessage2, hBBaseWebActivity2, th2.getMessage());
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
                k.f("onHuaweiError", AppUtil.b("submit is onFailed:", aPIStatusErrorException.getMessage()));
                aPIStatusErrorException.printStackTrace();
                JsBusinessActionHelper.backToH5Error(jsMessage2, hBBaseWebActivity2, aPIStatusErrorException.getErrMsg());
            }

            public void onRequestSuccess(String str) {
                k.f("onHuaweiError", AppUtil.b("submit is success message:", str3));
                if (z12) {
                    JsBusinessActionHelper.backToH5Error(jsMessage2, hBBaseWebActivity2, str3);
                } else {
                    JsBusinessActionHelper.backToH5JumioFail(jsMessage2, hBBaseWebActivity2);
                }
            }
        });
    }

    private static void onLivenessError(final JsMessage jsMessage, KycTicketInfo kycTicketInfo, final u uVar, final String str) {
        a.a().e(kycTicketInfo.getTicket(), 500, str).d(new RequestCallback1<String>() {
            public void onRequestFailure(Throwable th2) {
                JsBusinessActionHelper.backToH5Error(JsMessage.this, uVar, str);
            }

            public void onRequestSuccess(String str) {
                JsBusinessActionHelper.backToH5Error(JsMessage.this, uVar, str);
            }
        });
    }

    private static void onLivenessSuccess(final JsMessage jsMessage, KycTicketInfo kycTicketInfo, final u uVar) {
        a.a().e(kycTicketInfo.getTicket(), 200, "").d(new q6.a<String>(uVar) {
            public void onError2(Throwable th2) {
                k.f(JsBusinessActionHelper.LOG_TAG, "onError2:" + th2.getMessage());
                JsBusinessActionHelper.backToH5Error(jsMessage, uVar, th2.getMessage());
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                k.f(JsBusinessActionHelper.LOG_TAG, "onFailed:" + aPIStatusErrorException.getMessage());
                JsBusinessActionHelper.backToH5Error(jsMessage, uVar, aPIStatusErrorException.getErrMsg());
            }

            public void onRequestSuccess(String str) {
                JsBusinessActionHelper.backToH5(jsMessage, uVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void openHuaweiLiveness(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, KycTicketInfo kycTicketInfo) {
        String sdkToken = kycTicketInfo.getSdkToken();
        String sdkUrl = kycTicketInfo.getSdkUrl();
        String ticket = kycTicketInfo.getTicket();
        String liveThreshold = kycTicketInfo.getLiveThreshold();
        sm.a.c(new n(hBBaseWebActivity, jsMessage, ticket));
        sm.a.d(sdkToken, sdkUrl, liveThreshold, hBBaseWebActivity);
    }

    @ActionAnnotation("20010104")
    public static void openTronLinkApp(JsMessage jsMessage, u uVar) {
        String str;
        final boolean z11;
        Map map;
        Activity activity = uVar.getActivity();
        if (activity != null) {
            final boolean a11 = PackageManagerUtil.a(activity, "com.tronlinkpro.wallet");
            String str2 = "tronlinkoutside://pull.activity?param=";
            k.f("ACTION_OPEN_TRONLINK_APP", "jsMsg = " + jsMessage);
            if (jsMessage == null || jsMessage.getData() == null || !(jsMessage.getData() instanceof Map) || (map = (Map) jsMessage.getData()) == null) {
                str = "TronLink";
            } else {
                str = (String) map.get("appName");
                str2 = str2 + new Gson().toJson(map.get(RemoteMessageConst.MessageBody.PARAM));
            }
            final Intent intent = null;
            View inflate = LayoutInflater.from(uVar.getActivity()).inflate(R.layout.dialog_jump_tronlink_app, (ViewGroup) null);
            AlertDialog create = new AlertDialog.Builder(uVar.getActivity()).setView(inflate).create();
            create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            create.getWindow().setGravity(80);
            Window window = create.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.horizontalMargin = 0.0f;
            window.setAttributes(attributes);
            View findViewById = inflate.findViewById(R.id.bottomContainer);
            AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.jumpAppName);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.jumpActionStatus);
            ((AppCompatImageView) inflate.findViewById(R.id.closeButton)).setOnClickListener(new a(create));
            appCompatTextView.setText(str);
            if (a11) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.addFlags(268435456);
                intent2.setData(Uri.parse(str2));
                if (intent2.resolveActivity(activity.getPackageManager()) != null) {
                    appCompatTextView.setTextColor(ResourcesCompat.d(activity.getResources(), R.color.baseColorPrimaryText, (Resources.Theme) null));
                    appCompatTextView2.setText(activity.getString(R.string.n_go_jump));
                    appCompatTextView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, activity.getResources().getDrawable(R.drawable.jump_app_arrow, (Resources.Theme) null), (Drawable) null);
                    z11 = true;
                } else {
                    appCompatTextView.setTextColor(ResourcesCompat.d(activity.getResources(), R.color.baseColorSecondaryText, (Resources.Theme) null));
                    appCompatTextView2.setText(activity.getString(R.string.n_new_version_uninstalled));
                    appCompatTextView2.setTextColor(activity.getColor(R.color.baseColorShadeButtonRedStartNew));
                    z11 = false;
                }
                intent = intent2;
            } else {
                appCompatTextView.setTextColor(ResourcesCompat.d(activity.getResources(), R.color.baseColorSecondaryText, (Resources.Theme) null));
                appCompatTextView2.setText(activity.getString(R.string.n_uninstalled));
                appCompatTextView2.setTextColor(activity.getColor(R.color.baseColorShadeButtonRedStartNew));
                z11 = false;
            }
            final JsMessage jsMessage2 = jsMessage;
            final u uVar2 = uVar;
            final Activity activity2 = activity;
            final AlertDialog alertDialog = create;
            findViewById.setOnClickListener(new NoDoubleClickListener() {
                public void onViewClick(View view) {
                    if (a11) {
                        k.f("ACTION_OPEN_TRONLINK_APP", "jsMsg = " + jsMessage2);
                        if (z11) {
                            try {
                                uVar2.getActivity().startActivity(intent);
                            } catch (Exception e11) {
                                k.g("ACTION_OPEN_TRONLINK_APP", "has error", e11);
                                e11.printStackTrace();
                            }
                        } else {
                            Toast.makeText(uVar2.getActivity(), activity2.getString(R.string.n_connect_after_new_version_installation), 0).show();
                        }
                    } else {
                        Toast.makeText(uVar2.getActivity(), activity2.getString(R.string.n_connect_after_installation), 0).show();
                    }
                    alertDialog.dismiss();
                }
            });
            create.show();
            if (activity instanceof HBBaseWebActivity) {
                ((HBBaseWebActivity) activity).setHBWebViewLifecycleCallback(new o(jsMessage, uVar));
            }
        }
    }

    @ActionAnnotation("20010080")
    public static void picChoose(JsMessage jsMessage, u uVar) {
        Map map;
        View inflate = LayoutInflater.from(uVar.getActivity()).inflate(R.layout.dialog_pic_choose, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(uVar.getActivity()).setView(inflate).create();
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.getWindow().setGravity(80);
        Window window = create.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.horizontalMargin = 0.0f;
        window.setAttributes(attributes);
        TextView textView = (TextView) inflate.findViewById(R.id.tvPhoto);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tvCamera);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tvCancel);
        View findViewById = inflate.findViewById(R.id.vLine);
        try {
            if ((jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null && !map.isEmpty()) {
                Object obj = map.get("supportCamera");
                if ((obj instanceof Double) && ((Double) obj).doubleValue() == 1.0d) {
                    textView2.setVisibility(0);
                    findViewById.setVisibility(0);
                }
                Object obj2 = map.get("supportAlbum");
                if ((obj2 instanceof Double) && ((Double) obj2).doubleValue() == 1.0d) {
                    textView.setVisibility(0);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        textView.setOnClickListener(new q(create, jsMessage, uVar));
        textView2.setOnClickListener(new p(create, jsMessage, uVar));
        textView3.setOnClickListener(new l(create));
        create.show();
    }

    @ActionAnnotation("20010042")
    public static void playMusic(JsMessage jsMessage, u uVar) {
        Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            Map map = (Map) jsMessage.getData();
            if (map.containsKey("url")) {
                String str = (String) map.get("url");
                if (!TextUtils.isEmpty(str) && map.containsKey("operation")) {
                    String str2 = (String) map.get("operation");
                    HBBaseWebActivity hBBaseWebActivity = (HBBaseWebActivity) activity;
                    if ("play".equalsIgnoreCase(str2)) {
                        if (hBBaseWebActivity.isPaused()) {
                            hBBaseWebActivity.continueMusic();
                        } else if (!ErrorBundle.SUMMARY_ENTRY.equalsIgnoreCase(str)) {
                            hBBaseWebActivity.playMusic(str);
                        }
                    } else if ("mute".equalsIgnoreCase(str2)) {
                        hBBaseWebActivity.muteMusic();
                    } else if ("unmute".equalsIgnoreCase(str2)) {
                        hBBaseWebActivity.unMuteMusic();
                    } else if ("continue".equalsIgnoreCase(str2)) {
                        hBBaseWebActivity.continueMusic();
                    } else if ("pause".equalsIgnoreCase(str2)) {
                        hBBaseWebActivity.pauseMusic(true);
                    } else if ("stop".equalsIgnoreCase(str2)) {
                        hBBaseWebActivity.pauseMusic(true);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void postHuaweiLivenessResult(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, String str, boolean z11, String str2, String str3) {
        k.o("huawei_liveness", AppUtil.b("活体校验完成: ticket:", str, " huaweiSuccess:", Boolean.valueOf(z11), " message:", str3));
        sm.a.c((a.C0821a) null);
        if (!z11) {
            onHuaweiError(hBBaseWebActivity, jsMessage, str, str3, !TextUtils.isEmpty(str3));
            k.o("huawei_liveness", AppUtil.b("活体校验终止: 数据异常:", str3));
        } else if (!TextUtils.isEmpty(str2)) {
            String str4 = "data:image/jpg;base64," + str2;
            k.o("huawei_liveness", AppUtil.b("活体校验完成: data:", Integer.valueOf(str4.length())));
            JsStrMessage jsStrMessage = new JsStrMessage();
            jsStrMessage.setAction(jsMessage.getCallback());
            jsStrMessage.setCode(200);
            jsStrMessage.setMsg(str);
            jsStrMessage.setData(str4);
            b.d(jsStrMessage, hBBaseWebActivity);
        } else {
            k.o("huawei_liveness", "活体校验终止: 数据为空");
            onHuaweiError(hBBaseWebActivity, jsMessage, str, str3, false);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result", Boolean.valueOf(z11));
        gs.g.g("kyc_liveness_complete", hashMap);
    }

    public static void realJumpHuaWeiLiveness(final JsMessage jsMessage, final HBBaseWebActivity hBBaseWebActivity, final KycSDKTokenInfo kycSDKTokenInfo) {
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_AUDIO, PermissionConfig.READ_MEDIA_IMAGES} : new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE, "android.permission.CAMERA", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        final String ticket = kycSDKTokenInfo.getTicket();
        if (EasyPermissions.hasPermissions(hBBaseWebActivity, strArr)) {
            k.o("huawei_liveness", "has permissions");
            openHuaweiLiveness(hBBaseWebActivity, jsMessage, kycSDKTokenInfo);
            return;
        }
        hBBaseWebActivity.setPermissionCallback(new x6.f() {
            public void onPermissionsDenied(int i11, List<String> list) {
                k.o("huawei_liveness", "permissions denied:" + list);
                HBBaseWebActivity hBBaseWebActivity = HBBaseWebActivity.this;
                JsBusinessActionHelper.postHuaweiLivenessResult(hBBaseWebActivity, jsMessage, ticket, false, (String) null, hBBaseWebActivity.getString(R.string.n_kyc_huawei_liveness_permission_hint));
            }

            public void onPermissionsGranted(int i11, List<String> list) {
                k.o("huawei_liveness", "onPermissionsGranted");
                JsBusinessActionHelper.openHuaweiLiveness(HBBaseWebActivity.this, jsMessage, kycSDKTokenInfo);
            }
        });
        EasyPermissions.requestPermissions(hBBaseWebActivity, 130, strArr);
    }

    /* access modifiers changed from: private */
    public static void realJumpJumioLiveness(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, u uVar) {
        JumioKycHelper.f20896a.a().c(kycSDKTokenInfo.getSdkToken(), new u(jsMessage, kycSDKTokenInfo, uVar));
    }

    @ActionAnnotation("20010087")
    public static void realJumpJumioV2(final JsMessage jsMessage, final u uVar) {
        final Activity activity = uVar.getActivity();
        if (activity instanceof HBBaseWebActivity) {
            n8.a.a().c().d(new q6.a<KycSDKTokenInfo>(uVar) {
                public void onError2(Throwable th2) {
                    super.onError2(th2);
                    JsBusinessActionHelper.backToH5Error(jsMessage, uVar, th2.getMessage());
                }

                public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                    super.onFailed(aPIStatusErrorException);
                    JsBusinessActionHelper.backToH5Error(jsMessage, uVar, aPIStatusErrorException.getErrMsg());
                }

                public void onRequestSuccess(KycSDKTokenInfo kycSDKTokenInfo) {
                    String livingApi = kycSDKTokenInfo.getLivingApi();
                    if (TextUtils.equals(livingApi, "HUAWEI")) {
                        JsBusinessActionHelper.realJumpHuaWeiLiveness(jsMessage, (HBBaseWebActivity) activity, kycSDKTokenInfo);
                    } else if (TextUtils.equals(livingApi, KycSDKTokenInfo.LIVING_API_JUMIO)) {
                        JsBusinessActionHelper.realJumpJumioLiveness(jsMessage, kycSDKTokenInfo, uVar);
                    } else if (TextUtils.equals(livingApi, KycSDKTokenInfo.LIVING_API_SUMSUB)) {
                        JsBusinessActionHelper.realJumpSumsubLiveness(jsMessage, kycSDKTokenInfo, uVar);
                    } else {
                        JsBusinessActionHelper.backToH5JumioFail(jsMessage, uVar);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void realJumpSumsubLiveness(JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo, u uVar) {
        SumsubKycHelper.f20900a.a().c(kycSDKTokenInfo.getSdkToken(), new t(jsMessage, kycSDKTokenInfo, uVar));
    }

    @ActionAnnotation("20010084")
    public static void sendComment(JsMessage jsMessage, u uVar) {
        Map map;
        String str;
        String callback = jsMessage.getCallback();
        k.e("JsMessageHelper-->loginCheck-->action:" + callback);
        try {
            if ((jsMessage.getData() instanceof Map) && (map = (Map) jsMessage.getData()) != null && !map.isEmpty()) {
                Object obj = map.get("toNickName");
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        str = uVar.getActivity().getString(R.string.n_write_comment);
                    } else {
                        str = String.format(uVar.getActivity().getString(R.string.n_reply_to), new Object[]{str2});
                    }
                } else {
                    str = uVar.getActivity().getString(R.string.n_write_comment);
                }
                uVar.getActivity().runOnUiThread(new h(uVar, str, callback));
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @ActionAnnotation("20010039")
    public static void setRefreshType(JsMessage jsMessage, u uVar) {
        try {
            if (jsMessage.getData() != null) {
                uVar.setWebViewRefreshType(((Map) jsMessage.getData()).get("refreshType").toString());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.hbg.lib.core.webview.annotation.ActionAnnotation("20010105")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void traceWebViewLifeCycle(com.hbg.lib.core.webview.bean.JsMessage r5, v6.u r6) {
        /*
            java.lang.String r0 = "errorInfo"
            java.lang.String r1 = "errorCode"
            java.lang.String r2 = "step"
            android.app.Activity r6 = r6.getActivity()
            boolean r3 = r6 instanceof com.hbg.lib.core.webview.HBBaseWebActivity
            if (r3 == 0) goto L_0x0061
            com.hbg.lib.core.webview.HBBaseWebActivity r6 = (com.hbg.lib.core.webview.HBBaseWebActivity) r6
            java.lang.Object r5 = r5.getData()     // Catch:{ Exception -> 0x005d }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x005d }
            if (r5 == 0) goto L_0x0061
            boolean r3 = r5.containsKey(r2)     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r5.get(r2)     // Catch:{ Exception -> 0x005d }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0061
            java.lang.Object r2 = r5.get(r2)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x005d }
            boolean r3 = r5.containsKey(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r5.get(r1)     // Catch:{ Exception -> 0x005d }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0043
            java.lang.Object r1 = r5.get(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005d }
            goto L_0x0044
        L_0x0043:
            r1 = r4
        L_0x0044:
            boolean r3 = r5.containsKey(r0)     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r5.get(r0)     // Catch:{ Exception -> 0x005d }
            boolean r3 = r3 instanceof java.lang.String     // Catch:{ Exception -> 0x005d }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x005d }
            r4 = r5
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x005d }
        L_0x0059:
            r6.report(r2, r1, r4)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webview2.action.JsBusinessActionHelper.traceWebViewLifeCycle(com.hbg.lib.core.webview.bean.JsMessage, v6.u):void");
    }

    @ActionAnnotation("20010107")
    public static void tradingBotFilterDialog(JsMessage jsMessage, u uVar) {
        i.b().d(new d(jsMessage, uVar));
    }

    @ActionAnnotation("20010108")
    public static void tradingBotShare(JsMessage jsMessage, u uVar) {
        i.b().d(new b(jsMessage));
    }

    /* access modifiers changed from: private */
    public static void openHuaweiLiveness(HBBaseWebActivity hBBaseWebActivity, JsMessage jsMessage, KycSDKTokenInfo kycSDKTokenInfo) {
        String sdkToken = kycSDKTokenInfo.getSdkToken();
        String authUrl = kycSDKTokenInfo.getAuthUrl();
        String ticket = kycSDKTokenInfo.getTicket();
        String liveThreshold = kycSDKTokenInfo.getLiveThreshold();
        sm.a.c(new m(hBBaseWebActivity, jsMessage, ticket));
        sm.a.d(sdkToken, authUrl, liveThreshold, hBBaseWebActivity);
    }

    private static Observable<LoginInfoData> getTicket(String str) {
        k.f("LOGIN", "requestTicket- " + str + " - verifyUserIsLogin - " + r.x().F0());
        if (r.x().F0()) {
            return o9.a.a().requestTicket().b();
        }
        TokenErrorException tokenErrorException = new TokenErrorException(str);
        k.f("LOGIN", "requestTicket- not login" + str);
        k.f("LOGIN", "TokenErrorException 原逻辑会上传到FireBase 现在添加到日志");
        return Observable.error(tokenErrorException);
    }
}
