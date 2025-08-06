package com.sensorsdata.analytics.android.sdk;

import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;

abstract class AbstractSAConfigOptions {
    public String[] channelSourceKeys;
    public boolean isAutoAddChannelCallbackEvent;
    public boolean isAutoTrackWebView;
    public boolean isDataCollectEnable = true;
    public boolean isDisableSDK = false;
    public boolean isSubProcessFlushData = false;
    public boolean isWebViewSupportJellyBean;
    public int mAutoTrackEventType;
    public String mCustomADChannelUrl;
    public boolean mDisableDebugAssistant;
    public boolean mDisableDeviceId = false;
    public boolean mDisableRandomTimeRequestRemoteConfig;
    public boolean mEnableEncrypt = false;
    public boolean mEnableSaveDeepLinkInfo = false;
    public boolean mEnableSession = false;
    public boolean mEnableTrackAppCrash;
    public boolean mEnableTrackPush;
    public List<SAEncryptListener> mEncryptListeners;
    public List<SAEncryptListener> mEncryptors = new ArrayList();
    public int mEventSessionTimeout;
    public int mFlushBulkSize;
    public int mFlushInterval;
    public boolean mHeatMapEnabled;
    public List<Class<?>> mIgnorePageLeave;
    public boolean mIsTrackFragmentPageLeave = false;
    public boolean mIsTrackPageLeave = false;
    public boolean mLogEnabled;
    public long mMaxCacheSize = 33554432;
    public int mMaxRequestInterval = 48;
    public int mMinRequestInterval = 24;
    public int mNetworkTypePolicy = 30;
    public IPersistentSecretKey mPersistentSecretKey;
    public String mRemoteConfigUrl;
    public SSLSocketFactory mSSLSocketFactory;
    public String mServerUrl;
    public List<StorePlugin> mStorePlugins;
    public boolean mTrackScreenOrientationEnabled;
    public boolean mVisualizedEnabled;
    public boolean mVisualizedPropertiesEnabled;

    public String getCustomADChannelUrl() {
        return this.mCustomADChannelUrl;
    }

    public List<SAEncryptListener> getEncryptors() {
        return this.mEncryptors;
    }

    public int getEventSessionTimeout() {
        return this.mEventSessionTimeout;
    }

    public List<StorePlugin> getStorePlugins() {
        return this.mStorePlugins;
    }

    public boolean isAutoAddChannelCallbackEvent() {
        return this.isAutoAddChannelCallbackEvent;
    }

    public boolean isDataCollectEnable() {
        return this.isDataCollectEnable;
    }

    public boolean isDisableDeviceId() {
        return this.mDisableDeviceId;
    }

    public boolean isDisableSDK() {
        return this.isDisableSDK;
    }

    public boolean isEnableSession() {
        return this.mEnableSession;
    }

    public boolean isEnableTrackPush() {
        return this.mEnableTrackPush;
    }

    public boolean isMultiProcessFlush() {
        return this.isSubProcessFlushData;
    }

    public boolean isSaveDeepLinkInfo() {
        return this.mEnableSaveDeepLinkInfo;
    }

    public boolean isTrackFragmentPageLeave() {
        return this.mIsTrackPageLeave && this.mIsTrackFragmentPageLeave;
    }

    public boolean isTrackPageLeave() {
        return this.mIsTrackPageLeave;
    }

    public boolean isVisualizedPropertiesEnabled() {
        return this.mVisualizedPropertiesEnabled;
    }
}
