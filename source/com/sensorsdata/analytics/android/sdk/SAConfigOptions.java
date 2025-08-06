package com.sensorsdata.analytics.android.sdk;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;

public final class SAConfigOptions extends AbstractSAConfigOptions implements Cloneable {
    public boolean mInvokeHeatMapEnabled;
    public boolean mInvokeLog;
    public boolean mInvokeVisualizedEnabled;

    private SAConfigOptions() {
    }

    @Deprecated
    public SAConfigOptions disableDataCollect() {
        this.isDataCollectEnable = false;
        return this;
    }

    public SAConfigOptions disableDebugAssistant() {
        this.mDisableDebugAssistant = true;
        return this;
    }

    public SAConfigOptions disableDeviceId() {
        this.mDisableDeviceId = true;
        return this;
    }

    public SAConfigOptions disableRandomTimeRequestRemoteConfig() {
        this.mDisableRandomTimeRequestRemoteConfig = true;
        return this;
    }

    public SAConfigOptions disableSDK(boolean z11) {
        this.isDisableSDK = z11;
        return this;
    }

    public SAConfigOptions enableAutoAddChannelCallbackEvent(boolean z11) {
        this.isAutoAddChannelCallbackEvent = z11;
        return this;
    }

    public SAConfigOptions enableEncrypt(boolean z11) {
        this.mEnableEncrypt = z11;
        return this;
    }

    public SAConfigOptions enableHeatMap(boolean z11) {
        this.mHeatMapEnabled = z11;
        this.mInvokeHeatMapEnabled = true;
        return this;
    }

    public SAConfigOptions enableJavaScriptBridge(boolean z11) {
        this.isAutoTrackWebView = true;
        this.isWebViewSupportJellyBean = z11;
        return this;
    }

    public SAConfigOptions enableLog(boolean z11) {
        this.mLogEnabled = z11;
        this.mInvokeLog = true;
        return this;
    }

    public SAConfigOptions enableSaveDeepLinkInfo(boolean z11) {
        this.mEnableSaveDeepLinkInfo = z11;
        return this;
    }

    public SAConfigOptions enableSession(boolean z11) {
        this.mEnableSession = z11;
        return this;
    }

    public SAConfigOptions enableSubProcessFlushData() {
        this.isSubProcessFlushData = true;
        return this;
    }

    public SAConfigOptions enableTrackAppCrash() {
        this.mEnableTrackAppCrash = true;
        return this;
    }

    @Deprecated
    public SAConfigOptions enableTrackPageLeave(boolean z11) {
        return enableTrackPageLeave(z11, false);
    }

    public SAConfigOptions enableTrackPush(boolean z11) {
        this.mEnableTrackPush = z11;
        return this;
    }

    public SAConfigOptions enableTrackScreenOrientation(boolean z11) {
        this.mTrackScreenOrientationEnabled = z11;
        return this;
    }

    public SAConfigOptions enableVisualizedAutoTrack(boolean z11) {
        this.mVisualizedEnabled = z11;
        this.mInvokeVisualizedEnabled = true;
        return this;
    }

    public SAConfigOptions enableVisualizedProperties(boolean z11) {
        this.mVisualizedPropertiesEnabled = z11;
        return this;
    }

    public /* bridge */ /* synthetic */ String getCustomADChannelUrl() {
        return super.getCustomADChannelUrl();
    }

    public /* bridge */ /* synthetic */ List getEncryptors() {
        return super.getEncryptors();
    }

    public /* bridge */ /* synthetic */ int getEventSessionTimeout() {
        return super.getEventSessionTimeout();
    }

    public /* bridge */ /* synthetic */ List getStorePlugins() {
        return super.getStorePlugins();
    }

    public SAConfigOptions ignorePageLeave(List<Class<?>> list) {
        this.mIgnorePageLeave = list;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isAutoAddChannelCallbackEvent() {
        return super.isAutoAddChannelCallbackEvent();
    }

    public boolean isDataCollect() {
        return this.isDataCollectEnable;
    }

    public /* bridge */ /* synthetic */ boolean isDataCollectEnable() {
        return super.isDataCollectEnable();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDeviceId() {
        return super.isDisableDeviceId();
    }

    public /* bridge */ /* synthetic */ boolean isDisableSDK() {
        return super.isDisableSDK();
    }

    public /* bridge */ /* synthetic */ boolean isEnableSession() {
        return super.isEnableSession();
    }

    public /* bridge */ /* synthetic */ boolean isEnableTrackPush() {
        return super.isEnableTrackPush();
    }

    public /* bridge */ /* synthetic */ boolean isMultiProcessFlush() {
        return super.isMultiProcessFlush();
    }

    public /* bridge */ /* synthetic */ boolean isSaveDeepLinkInfo() {
        return super.isSaveDeepLinkInfo();
    }

    public /* bridge */ /* synthetic */ boolean isTrackFragmentPageLeave() {
        return super.isTrackFragmentPageLeave();
    }

    public /* bridge */ /* synthetic */ boolean isTrackPageLeave() {
        return super.isTrackPageLeave();
    }

    public /* bridge */ /* synthetic */ boolean isVisualizedPropertiesEnabled() {
        return super.isVisualizedPropertiesEnabled();
    }

    public SAConfigOptions persistentSecretKey(IPersistentSecretKey iPersistentSecretKey) {
        this.mPersistentSecretKey = iPersistentSecretKey;
        return this;
    }

    public SAConfigOptions registerEncryptor(SAEncryptListener sAEncryptListener) {
        if (sAEncryptListener != null && !TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) && !TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType()) && !this.mEncryptors.contains(sAEncryptListener)) {
            this.mEncryptors.add(0, sAEncryptListener);
        }
        return this;
    }

    public SAConfigOptions registerStorePlugin(StorePlugin storePlugin) {
        if (this.mStorePlugins == null) {
            this.mStorePlugins = new ArrayList();
        }
        this.mStorePlugins.add(storePlugin);
        return this;
    }

    public SAConfigOptions setAutoTrackEventType(int i11) {
        this.mAutoTrackEventType = i11;
        return this;
    }

    public SAConfigOptions setCustomAdChannelUrl(String str) {
        this.mCustomADChannelUrl = str;
        return this;
    }

    public SAConfigOptions setEventSessionTimeout(int i11) {
        this.mEventSessionTimeout = i11;
        return this;
    }

    public SAConfigOptions setFlushBulkSize(int i11) {
        this.mFlushBulkSize = Math.max(50, i11);
        return this;
    }

    public SAConfigOptions setFlushInterval(int i11) {
        this.mFlushInterval = Math.max(5000, i11);
        return this;
    }

    public SAConfigOptions setMaxCacheSize(long j11) {
        this.mMaxCacheSize = Math.max(16777216, j11);
        return this;
    }

    public SAConfigOptions setMaxRequestInterval(int i11) {
        if (i11 > 0) {
            this.mMaxRequestInterval = Math.min(i11, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
        }
        return this;
    }

    public SAConfigOptions setMinRequestInterval(int i11) {
        if (i11 > 0) {
            this.mMinRequestInterval = Math.min(i11, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
        }
        return this;
    }

    public SAConfigOptions setNetworkTypePolicy(int i11) {
        this.mNetworkTypePolicy = i11;
        return this;
    }

    public SAConfigOptions setRemoteConfigUrl(String str) {
        this.mRemoteConfigUrl = str;
        return this;
    }

    public SAConfigOptions setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
        return this;
    }

    public SAConfigOptions setServerUrl(String str) {
        this.mServerUrl = str;
        return this;
    }

    public SAConfigOptions setSourceChannels(String... strArr) {
        this.channelSourceKeys = strArr;
        return this;
    }

    public SAConfigOptions(String str) {
        this.mServerUrl = str;
    }

    public SAConfigOptions clone() {
        try {
            return (SAConfigOptions) super.clone();
        } catch (CloneNotSupportedException e11) {
            SALog.printStackTrace(e11);
            return this;
        }
    }

    public SAConfigOptions enableTrackPageLeave(boolean z11, boolean z12) {
        this.mIsTrackPageLeave = z11;
        this.mIsTrackFragmentPageLeave = z12;
        return this;
    }
}
