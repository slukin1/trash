package com.huobi.webview2.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.annotation.ActionAnnotation;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.entity.AssetHidden;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.ui.CurrencyFromCCDetailActivity;
import com.huobi.finance.ui.FiatResultFromCoinActivity;
import com.huobi.flutter.bean.H5FiatChannelBindInfo;
import com.huobi.flutter.bean.H5FiatChannelDepositInfo;
import com.huobi.flutter.bean.H5FiatChannelTransferInfo;
import d7.k;
import java.util.List;
import java.util.Map;
import q6.d;
import rx.Observable;
import tg.r;
import v6.u;
import x6.b;

public final class JsFinanceActionHelper {
    public static final String ACTION_CHOOSE_ACCOUNT_BIND_CONFIRM = "20010055";
    public static final String ACTION_CHOOSE_ACCOUNT_GET_BIND_INFO = "20010054";
    public static final String ACTION_DEPOSIT_GET_DEPOSIT_DETAIL = "20010051";
    public static final String ACTION_DEPOSIT_TRANSFER_CONFIRM = "20010053";
    public static final String ACTION_DEPOSIT_TRANSFER_INFO = "20010052";
    public static final String ACTION_FIAT_DEPOSIT_COMPLETED = "20010056";
    public static final String ACTION_FIAT_NEW_WEBVIEW = "20010086";
    public static final String ACTION_FIAT_TO_RECORD = "20010075";
    public static final String ACTION_HIDE_ASSET = "20010023";
    public static final String ACTION_HIDE_ASSET_GET = "20010024";
    public static final int CODE_OK = 200;

    private JsFinanceActionHelper() {
    }

    @ActionAnnotation("20010055")
    public static void chooseAccountBindConfirm(JsMessage jsMessage, u uVar) {
        Activity activity = uVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @ActionAnnotation("20010056")
    public static void fiatDepositCompleted(JsMessage jsMessage, u uVar) {
        Activity activity = uVar.getActivity();
        if (activity != null && (jsMessage.getData() instanceof Map)) {
            Map map = (Map) jsMessage.getData();
            String valueOf = String.valueOf(map.get("orderCode"));
            String valueOf2 = String.valueOf(map.get(FirebaseAnalytics.Param.CURRENCY));
            if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                FiatResultFromCoinActivity.nj(activity, valueOf, 0, valueOf2);
            }
        }
    }

    @ActionAnnotation("20010086")
    public static void fiatDepositNewPage(JsMessage jsMessage, u uVar) {
        Activity activity = uVar.getActivity();
        if (activity != null && (jsMessage.getData() instanceof Map)) {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.valueOf(((Map) jsMessage.getData()).get("settlepayUrl")))));
            activity.finish();
        }
    }

    @ActionAnnotation("20010075")
    public static void fiatTpRecord(JsMessage jsMessage, u uVar) {
        uVar.getActivity();
        String valueOf = String.valueOf(((Map) jsMessage.getData()).get(FirebaseAnalytics.Param.CURRENCY));
        if (!TextUtils.isEmpty(valueOf) && k.C().L(valueOf)) {
            AssetDataCacheManager.k0().S().flatMap(l0.f20844b).filter(n0.f20852b).map(m0.f20848b).filter(new k0(valueOf)).compose(RxJavaHelper.t(uVar)).first().subscribe(d.c(uVar, new j0(uVar)));
        }
    }

    @ActionAnnotation("20010054")
    public static void getDepositGetBindInfo(JsMessage jsMessage, u uVar) {
        Intent intent;
        Activity activity = uVar.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            String callback = jsMessage.getCallback();
            JsMessage jsMessage2 = new JsMessage();
            H5FiatChannelBindInfo h5FiatChannelBindInfo = new H5FiatChannelBindInfo();
            h5FiatChannelBindInfo.setChannel(intent.getStringExtra(AppsFlyerProperties.CHANNEL));
            h5FiatChannelBindInfo.setPaymentMethodCode(intent.getStringExtra("paymentMethodCode"));
            h5FiatChannelBindInfo.setDeviceFingerprint(intent.getStringExtra("deviceFingerprint"));
            jsMessage2.setData(h5FiatChannelBindInfo);
            jsMessage2.setCode(200);
            jsMessage2.setAction(callback);
            b.e(jsMessage2, uVar, false);
        }
    }

    @ActionAnnotation("20010051")
    public static void getDepositGetDepositDetail(JsMessage jsMessage, u uVar) {
        Intent intent;
        Activity activity = uVar.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            String callback = jsMessage.getCallback();
            JsMessage jsMessage2 = new JsMessage();
            H5FiatChannelDepositInfo h5FiatChannelDepositInfo = new H5FiatChannelDepositInfo();
            h5FiatChannelDepositInfo.setOrderCode(intent.getStringExtra("orderCode"));
            h5FiatChannelDepositInfo.setCurrency(intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY));
            h5FiatChannelDepositInfo.setAccountNumber(intent.getStringExtra("accountNumber"));
            jsMessage2.setData(h5FiatChannelDepositInfo);
            jsMessage2.setCode(200);
            jsMessage2.setAction(callback);
            b.e(jsMessage2, uVar, false);
        }
    }

    @ActionAnnotation("20010053")
    public static void getDepositTransferConfirm(JsMessage jsMessage, u uVar) {
        Activity activity = uVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @ActionAnnotation("20010052")
    public static void getDepositTransferInfo(JsMessage jsMessage, u uVar) {
        Intent intent;
        Activity activity = uVar.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            String callback = jsMessage.getCallback();
            JsMessage jsMessage2 = new JsMessage();
            H5FiatChannelTransferInfo h5FiatChannelTransferInfo = new H5FiatChannelTransferInfo();
            h5FiatChannelTransferInfo.setCurrency(intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY));
            h5FiatChannelTransferInfo.setChannel(intent.getStringExtra(AppsFlyerProperties.CHANNEL));
            h5FiatChannelTransferInfo.setPaymentMethodCode(intent.getStringExtra("paymentMethodCode"));
            h5FiatChannelTransferInfo.setAmount(intent.getStringExtra("amount"));
            h5FiatChannelTransferInfo.setDeviceFingerprint(intent.getStringExtra("deviceFingerprint"));
            h5FiatChannelTransferInfo.setLimitMax(intent.getStringExtra("limitMax"));
            h5FiatChannelTransferInfo.setLimitMin(intent.getStringExtra("limitMin"));
            jsMessage2.setData(h5FiatChannelTransferInfo);
            jsMessage2.setCode(200);
            jsMessage2.setAction(callback);
            b.e(jsMessage2, uVar, false);
        }
    }

    @ActionAnnotation("20010024")
    public static void getHideAssetStatus(JsMessage jsMessage, u uVar) {
        String callback = jsMessage.getCallback();
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setData(new AssetHidden(com.hbg.lib.core.util.b.c().b(r.x().s()) ^ true ? 1 : 0));
        jsMessage2.setCode(200);
        jsMessage2.setAction(callback);
        b.e(jsMessage2, uVar, false);
    }

    @ActionAnnotation("20010023")
    public static void hideAsset(JsMessage jsMessage, u uVar) {
        try {
            if (jsMessage.getData() != null) {
                com.hbg.lib.core.util.b.c().h(((int) ((Double) ((Map) jsMessage.getData()).get("isHidden")).doubleValue()) == 0, r.x().s());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void jumpToAssetRecordPage(Activity activity, BalanceDetailInfo balanceDetailInfo) {
        Intent intent = new Intent(activity, CurrencyFromCCDetailActivity.class);
        intent.putExtra("currency_detail_info", balanceDetailInfo);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Observable lambda$fiatTpRecord$0(BalanceDataTotal balanceDataTotal) {
        List<? extends BaseAssetInfo> detailInfos = balanceDataTotal != null ? balanceDataTotal.getDetailInfos() : null;
        if (detailInfos != null && !detailInfos.isEmpty()) {
            return Observable.from(detailInfos);
        }
        throw new NullPointerException("Get balance data is null.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ BalanceDetailInfo lambda$fiatTpRecord$2(BaseAssetInfo baseAssetInfo) {
        return (BalanceDetailInfo) baseAssetInfo;
    }
}
