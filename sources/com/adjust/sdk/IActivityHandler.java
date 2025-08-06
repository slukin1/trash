package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.ActivityHandler;

public interface IActivityHandler {
    void addGlobalCallbackParameter(String str, String str2);

    void addGlobalPartnerParameter(String str, String str2);

    void finishedTrackingActivity(ResponseData responseData);

    void gdprForgetMe();

    ActivityState getActivityState();

    void getAdid(OnAdidReadListener onAdidReadListener);

    AdjustConfig getAdjustConfig();

    void getAttribution(OnAttributionReadListener onAttributionReadListener);

    Context getContext();

    DeviceInfo getDeviceInfo();

    GlobalParameters getGlobalParameters();

    ActivityHandler.InternalState getInternalState();

    void gotOptOutResponse();

    void init(AdjustConfig adjustConfig);

    void isEnabled(OnIsEnabledListener onIsEnabledListener);

    boolean isEnabled();

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchPurchaseVerificationResponseTasks(PurchaseVerificationResponseData purchaseVerificationResponseData);

    void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void onPause();

    void onResume();

    void processAndResolveDeeplink(Uri uri, long j11, OnDeeplinkResolvedListener onDeeplinkResolvedListener);

    void processDeeplink(Uri uri, long j11);

    void removeGlobalCallbackParameter(String str);

    void removeGlobalCallbackParameters();

    void removeGlobalPartnerParameter(String str);

    void removeGlobalPartnerParameters();

    void sendInstallReferrer(ReferrerDetails referrerDetails, String str);

    void sendPreinstallReferrer();

    void sendReftagReferrer();

    void setAskingAttribution(boolean z11);

    void setEnabled(boolean z11);

    void setOfflineMode(boolean z11);

    void setPushToken(String str, boolean z11);

    void teardown();

    void trackAdRevenue(AdjustAdRevenue adjustAdRevenue);

    void trackEvent(AdjustEvent adjustEvent);

    void trackMeasurementConsent(boolean z11);

    void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription);

    void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing);

    boolean updateAttributionI(AdjustAttribution adjustAttribution);

    void verifyAndTrackPlayStorePurchase(AdjustEvent adjustEvent, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener);

    void verifyPlayStorePurchase(AdjustPlayStorePurchase adjustPlayStorePurchase, OnPurchaseVerificationFinishedListener onPurchaseVerificationFinishedListener);
}
