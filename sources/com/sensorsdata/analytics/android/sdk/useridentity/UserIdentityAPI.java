package com.sensorsdata.analytics.android.sdk.useridentity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityStrategy;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SAContextManager;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.UUID;
import org.json.JSONObject;

public final class UserIdentityAPI implements IUserIdentityAPI {
    private static final String TAG = "SA.UserIdentityAPI";
    private boolean isResetAnonymousId = false;
    private final PersistentDistinctId mAnonymousId;
    private H5UserIdentityStrategy mH5UserIdentityStrategy;
    private final Identities mIdentitiesInstance;
    private String mLoginIdValue;
    private final SAContextManager mSAContextManager;

    public UserIdentityAPI(SAContextManager sAContextManager) {
        String str = null;
        this.mLoginIdValue = null;
        this.mSAContextManager = sAContextManager;
        PersistentDistinctId persistentDistinctId = (PersistentDistinctId) PersistentLoader.loadPersistent(DbParams.PersistentName.DISTINCT_ID);
        this.mAnonymousId = persistentDistinctId;
        Identities identities = new Identities();
        this.mIdentitiesInstance = identities;
        if (persistentDistinctId != null) {
            try {
                if (persistentDistinctId.isExists()) {
                    str = (String) persistentDistinctId.get();
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return;
            }
        }
        identities.init(str, sAContextManager.getAndroidId(), (String) persistentDistinctId.get());
        this.mLoginIdValue = identities.getJointLoginID();
    }

    public void bind(String str, String str2) {
        bindBack(str, str2);
    }

    public boolean bindBack(String str, String str2) {
        try {
            return this.mIdentitiesInstance.update(str, str2);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public void enableDataCollect(String str) {
        Identities.SpecialID specialID;
        try {
            if (SensorsDataUtils.isValidAndroidId(str)) {
                if (TextUtils.isEmpty((CharSequence) this.mAnonymousId.get()) || this.isResetAnonymousId) {
                    this.mAnonymousId.commit(str);
                }
                specialID = Identities.SpecialID.ANDROID_ID;
            } else {
                str = UUID.randomUUID().toString();
                if (TextUtils.isEmpty((CharSequence) this.mAnonymousId.get()) || this.isResetAnonymousId) {
                    this.mAnonymousId.commit(str);
                }
                specialID = Identities.SpecialID.ANDROID_UUID;
            }
            this.mIdentitiesInstance.updateSpecialIDKeyAndValue(specialID, str);
            if (this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT).has(Identities.ANONYMOUS_ID) && this.isResetAnonymousId) {
                this.mIdentitiesInstance.updateSpecialIDKeyAndValue(Identities.SpecialID.ANONYMOUS_ID, (String) this.mAnonymousId.get());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public String getAnonymousId() {
        try {
            synchronized (this.mAnonymousId) {
                if (!AbstractSensorsDataAPI.getConfigOptions().isDataCollect()) {
                    return "";
                }
                String str = (String) this.mAnonymousId.get();
                return str;
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public String getDistinctId() {
        try {
            String loginId = getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                return loginId;
            }
            return getAnonymousId();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public JSONObject getIdentities(EventType eventType) {
        if (EventType.TRACK_SIGNUP == eventType) {
            return this.mIdentitiesInstance.getIdentities(Identities.State.LOGIN_KEY);
        }
        if (EventType.TRACK_ID_UNBIND == eventType) {
            return this.mIdentitiesInstance.getIdentities(Identities.State.REMOVE_KEYID);
        }
        return this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT);
    }

    public Identities getIdentitiesInstance() {
        return this.mIdentitiesInstance;
    }

    public String getLoginId() {
        if (AppInfoUtils.isTaskExecuteThread()) {
            return this.mIdentitiesInstance.getJointLoginID();
        }
        return this.mLoginIdValue;
    }

    public void identify(String str) {
        try {
            SALog.i(TAG, "identify is called");
            synchronized (this.mAnonymousId) {
                if (!str.equals(this.mAnonymousId.get())) {
                    this.mAnonymousId.commit(str);
                    this.mIdentitiesInstance.updateSpecialIDKeyAndValue(Identities.SpecialID.ANONYMOUS_ID, str);
                    if (this.mSAContextManager.getEventListenerList() != null) {
                        for (SAEventListener identify : this.mSAContextManager.getEventListenerList()) {
                            try {
                                identify.identify();
                            } catch (Exception e11) {
                                SALog.printStackTrace(e11);
                            }
                        }
                    }
                    TrackMonitor.getInstance().callIdentify(str);
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public void login(String str) {
        loginWithKeyBack(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    public void loginWithKey(String str, String str2) {
        loginWithKeyBack(str, str2);
    }

    public boolean loginWithKeyBack(String str, String str2) {
        try {
            boolean updateLoginKeyAndID = this.mIdentitiesInstance.updateLoginKeyAndID(str, str2, getAnonymousId());
            if (!updateLoginKeyAndID) {
                return updateLoginKeyAndID;
            }
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener login : this.mSAContextManager.getEventListenerList()) {
                    try {
                        login.login();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
            TrackMonitor.getInstance().callLogin(this.mIdentitiesInstance.getJointLoginID());
            return updateLoginKeyAndID;
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
            return false;
        }
    }

    public void logout() {
        if (!TextUtils.isEmpty(this.mIdentitiesInstance.getLoginId())) {
            SALog.i(TAG, "logout is called");
            this.mIdentitiesInstance.removeLoginKeyAndID();
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener logout : this.mSAContextManager.getEventListenerList()) {
                    try {
                        logout.logout();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
            TrackMonitor.getInstance().callLogout();
            SALog.i(TAG, "Clean loginId");
        }
    }

    public boolean mergeH5Identities(EventType eventType, JSONObject jSONObject) {
        if (this.mH5UserIdentityStrategy == null) {
            this.mH5UserIdentityStrategy = new H5UserIdentityStrategy(this);
        }
        return this.mH5UserIdentityStrategy.processH5UserIdentity(eventType, jSONObject);
    }

    public void resetAnonymousId() {
        try {
            synchronized (this.mAnonymousId) {
                SALog.i(TAG, "resetAnonymousId is called");
                String androidId = this.mSAContextManager.getAndroidId();
                if (androidId.equals(this.mAnonymousId.get())) {
                    SALog.i(TAG, "DistinctId not change");
                    return;
                }
                this.isResetAnonymousId = true;
                if (AbstractSensorsDataAPI.getConfigOptions().isDataCollect()) {
                    if (!SensorsDataUtils.isValidAndroidId(androidId)) {
                        androidId = UUID.randomUUID().toString();
                    }
                    this.mAnonymousId.commit(androidId);
                    if (this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT).has(Identities.ANONYMOUS_ID)) {
                        this.mIdentitiesInstance.updateSpecialIDKeyAndValue(Identities.SpecialID.ANONYMOUS_ID, (String) this.mAnonymousId.get());
                    }
                    if (this.mSAContextManager.getEventListenerList() != null) {
                        for (SAEventListener resetAnonymousId : this.mSAContextManager.getEventListenerList()) {
                            try {
                                resetAnonymousId.resetAnonymousId();
                            } catch (Exception e11) {
                                SALog.printStackTrace(e11);
                            }
                        }
                    }
                    TrackMonitor.getInstance().callResetAnonymousId(androidId);
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public void trackH5Notify(JSONObject jSONObject) {
        try {
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener trackEvent : this.mSAContextManager.getEventListenerList()) {
                    try {
                        trackEvent.trackEvent(jSONObject);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
        TrackMonitor.getInstance().callTrack(jSONObject);
    }

    public void unbind(String str, String str2) {
        unbindBack(str, str2);
    }

    public boolean unbindBack(String str, String str2) {
        try {
            return this.mIdentitiesInstance.remove(str, str2);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public void updateIdentities(JSONObject jSONObject) {
        try {
            if (SensorsDataUtils.isValidAndroidId(this.mSAContextManager.getAndroidId())) {
                jSONObject.put(Identities.ANDROID_ID, this.mSAContextManager.getAndroidId());
            } else {
                jSONObject.put(Identities.ANDROID_UUID, this.mAnonymousId.get());
            }
            if (this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT).has(Identities.ANONYMOUS_ID) && this.isResetAnonymousId) {
                jSONObject.put(Identities.ANONYMOUS_ID, this.mAnonymousId.get());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void updateLoginId(String str, String str2) {
        this.mLoginIdValue = LoginIDAndKey.jointLoginID(str, str2);
    }

    public void login(String str, JSONObject jSONObject) {
        loginWithKeyBack(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    public void loginWithKey(String str, String str2, JSONObject jSONObject) {
        loginWithKeyBack(str, str2);
    }

    public JSONObject getIdentities() {
        return this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT);
    }
}
