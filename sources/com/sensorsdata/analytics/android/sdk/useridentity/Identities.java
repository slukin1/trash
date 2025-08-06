package com.sensorsdata.analytics.android.sdk.useridentity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId;
import com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Identities {
    public static final String ANDROID_ID = "$identity_android_id";
    public static final String ANDROID_UUID = "$identity_android_uuid";
    public static final String ANONYMOUS_ID = "$identity_anonymous_id";
    public static final String COOKIE_ID = "$identity_cookie_id";
    public static final String IDENTITIES_KEY = "identities";
    private static final String TAG = "SA.Identities";
    private JSONObject mIdentities;
    private final LoginIDAndKey mLoginIDAndKey = new LoginIDAndKey();
    private JSONObject mLoginIdentities;
    private JSONObject mUnbindIdentities;

    /* renamed from: com.sensorsdata.analytics.android.sdk.useridentity.Identities$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID;
        public static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$State[] r0 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State = r0
                r1 = 1
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$State r2 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.LOGIN_KEY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$State r3 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.REMOVE_KEYID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$State r4 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$SpecialID[] r3 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID = r3
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$SpecialID r4 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANONYMOUS_ID     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$SpecialID r3 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANDROID_ID     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID     // Catch:{ NoSuchFieldError -> 0x004d }
                com.sensorsdata.analytics.android.sdk.useridentity.Identities$SpecialID r1 = com.sensorsdata.analytics.android.sdk.useridentity.Identities.SpecialID.ANDROID_UUID     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.useridentity.Identities.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Local {
        public static String getIdentitiesFromLocal() {
            try {
                UserIdentityPersistent userIdentityPersistent = (UserIdentityPersistent) PersistentLoader.loadPersistent(DbParams.PersistentName.PERSISTENT_USER_ID);
                if (userIdentityPersistent != null) {
                    return DbAdapter.decodeIdentities((String) userIdentityPersistent.get());
                }
                return null;
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return null;
            }
        }

        public static String getLoginIdFromLocal() {
            try {
                PersistentLoginId persistentLoginId = (PersistentLoginId) PersistentLoader.loadPersistent(DbParams.PersistentName.LOGIN_ID);
                if (persistentLoginId == null) {
                    return "";
                }
                return (String) persistentLoginId.get();
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return "";
            }
        }

        public static String getLoginIdKeyFromLocal() {
            try {
                LoginIdKeyPersistent loginIdKeyPersistent = (LoginIdKeyPersistent) PersistentLoader.loadPersistent(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY);
                if (loginIdKeyPersistent == null) {
                    return "";
                }
                return (String) loginIdKeyPersistent.get();
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return "";
            }
        }
    }

    public enum SpecialID {
        ANONYMOUS_ID,
        ANDROID_ID,
        ANDROID_UUID
    }

    public enum State {
        LOGIN_KEY,
        REMOVE_KEYID,
        DEFAULT
    }

    private void clearIdentities(List<String> list, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (!list.contains(keys.next())) {
                    keys.remove();
                }
            }
        }
    }

    private JSONObject createIdentities(JSONObject jSONObject, String str, String str2, String str3) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            if (str != null) {
                jSONObject.put(ANONYMOUS_ID, str);
            }
            if (AbstractSensorsDataAPI.getConfigOptions().isDataCollect()) {
                if (SensorsDataUtils.isValidAndroidId(str2)) {
                    jSONObject.put(ANDROID_ID, str2);
                } else {
                    jSONObject.put(ANDROID_UUID, str3);
                }
            }
        } else if (jSONObject.has(ANONYMOUS_ID)) {
            jSONObject.put(ANONYMOUS_ID, str3);
        }
        return jSONObject;
    }

    private JSONObject getCacheIdentities() throws JSONException {
        String identities = DbAdapter.getInstance().getIdentities();
        if (!TextUtils.isEmpty(identities)) {
            return new JSONObject(identities);
        }
        return null;
    }

    private JSONObject getDefaultIdentities() {
        try {
            return getCacheIdentities();
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    private JSONObject getInitIdentities() throws JSONException {
        String identitiesFromLocal = Local.getIdentitiesFromLocal();
        if (identitiesFromLocal == null || TextUtils.isEmpty(identitiesFromLocal)) {
            return null;
        }
        return new JSONObject(identitiesFromLocal);
    }

    private void initLoginIDAndKeyIdentities(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            if (jSONObject.has(str)) {
                clearIdentities(Arrays.asList(new String[]{ANDROID_ID, ANDROID_UUID, ANONYMOUS_ID}), jSONObject);
                this.mLoginIDAndKey.setLoginIDKey("");
            }
        } else if (!jSONObject.has(str)) {
            jSONObject.put(Local.getLoginIdKeyFromLocal(), Local.getLoginIdFromLocal());
            clearIdentities(Arrays.asList(new String[]{ANDROID_ID, ANDROID_UUID, this.mLoginIDAndKey.getLoginIDKey()}), jSONObject);
        } else if (!jSONObject.getString(this.mLoginIDAndKey.getLoginIDKey()).equals(str2)) {
            jSONObject.put(Local.getLoginIdKeyFromLocal(), Local.getLoginIdFromLocal());
            clearIdentities(Arrays.asList(new String[]{ANDROID_ID, ANDROID_UUID, this.mLoginIDAndKey.getLoginIDKey()}), jSONObject);
        }
    }

    private boolean isInValid(String str, String str2, String str3) {
        return !this.mLoginIDAndKey.setLoginKeyAndID(str, str2, str3);
    }

    private boolean isInvalidBusinessID(String str, String str2, boolean z11) {
        boolean z12;
        if (z11) {
            if (!isRemoveKeyValid(str) || !SADataHelper.assertPropertyKey(str)) {
                SALog.i(TAG, "unbind key is invalid, key = " + str);
                z12 = true;
                SADataHelper.assertDistinctId(str2);
                return z12;
            }
        } else if (!isKeyValid(str) || !SADataHelper.assertPropertyKey(str)) {
            SALog.i(TAG, "bind key is invalid, key = " + str);
            z12 = true;
            SADataHelper.assertDistinctId(str2);
            return z12;
        }
        z12 = false;
        try {
            SADataHelper.assertDistinctId(str2);
            return z12;
        } catch (Exception e11) {
            SALog.i(TAG, (Throwable) e11);
            return true;
        }
    }

    private boolean isKeyValid(String str) {
        return !ANONYMOUS_ID.equals(str) && !ANDROID_UUID.equals(str) && !ANDROID_ID.equals(str) && !this.mLoginIDAndKey.getLoginIDKey().equals(str) && !LoginIDAndKey.LOGIN_ID_KEY_DEFAULT.equals(str);
    }

    private boolean isRemoveKeyValid(String str) {
        return !ANONYMOUS_ID.equals(str) && !LoginIDAndKey.LOGIN_ID_KEY_DEFAULT.equals(str);
    }

    private void saveIdentities() {
        DbAdapter.getInstance().commitIdentities(this.mIdentities.toString());
    }

    public JSONObject getIdentities(State state) {
        int i11 = AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$State[state.ordinal()];
        if (i11 == 1) {
            return this.mLoginIdentities;
        }
        if (i11 == 2) {
            JSONObject jSONObject = this.mUnbindIdentities;
            if (jSONObject != null) {
                return jSONObject;
            }
        } else if (i11 == 3) {
            JSONObject jSONObject2 = this.mIdentities;
            if (jSONObject2 == null) {
                return getDefaultIdentities();
            }
            return jSONObject2;
        }
        return null;
    }

    public String getJointLoginID() {
        return this.mLoginIDAndKey.getJointLoginID();
    }

    public String getLoginIDKey() {
        return this.mLoginIDAndKey.getLoginIDKey();
    }

    public String getLoginId() {
        return this.mLoginIDAndKey.getLoginId();
    }

    public void init(String str, String str2, String str3) throws JSONException {
        String loginIdKeyFromLocal = Local.getLoginIdKeyFromLocal();
        String loginIdFromLocal = Local.getLoginIdFromLocal();
        this.mLoginIDAndKey.init(loginIdKeyFromLocal);
        JSONObject createIdentities = createIdentities(getInitIdentities(), str, str2, str3);
        initLoginIDAndKeyIdentities(loginIdKeyFromLocal, loginIdFromLocal, createIdentities);
        this.mIdentities = createIdentities;
        saveIdentities();
    }

    public void mergeIdentities(JSONObject jSONObject) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!this.mIdentities.has(next)) {
                this.mIdentities.put(next, jSONObject.optString(next));
            }
        }
        saveIdentities();
    }

    public boolean remove(String str, String str2) throws JSONException {
        boolean z11 = false;
        if (isInvalidBusinessID(str, str2, true)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        this.mUnbindIdentities = jSONObject;
        jSONObject.put(str, str2);
        if (ANDROID_ID.equals(str) || ANDROID_UUID.equals(str)) {
            z11 = true;
        }
        if (!z11 && this.mIdentities.has(str) && this.mIdentities.getString(str).equals(str2)) {
            this.mIdentities.remove(str);
        }
        if ((str + "+" + str2).equals(getJointLoginID())) {
            this.mIdentities.remove(str);
            this.mLoginIDAndKey.removeLoginKeyAndID();
        }
        saveIdentities();
        return true;
    }

    public void removeLoginKeyAndID() {
        this.mLoginIDAndKey.removeLoginKeyAndID();
        this.mLoginIdentities = new JSONObject();
        clearIdentities(Arrays.asList(new String[]{ANDROID_ID, ANDROID_UUID}), this.mIdentities);
        saveIdentities();
    }

    public boolean update(String str, String str2) throws JSONException {
        if (isInvalidBusinessID(str, str2, false)) {
            return false;
        }
        this.mIdentities.put(str, str2);
        saveIdentities();
        return true;
    }

    public void updateIdentities() {
        try {
            this.mIdentities = getCacheIdentities();
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public boolean updateLoginKeyAndID(String str, String str2, String str3) throws Exception {
        if (isInValid(str, str2, str3)) {
            return false;
        }
        this.mIdentities.put(str, str2);
        this.mLoginIdentities = new JSONObject(this.mIdentities.toString());
        clearIdentities(Arrays.asList(new String[]{ANDROID_ID, ANDROID_UUID, str}), this.mIdentities);
        saveIdentities();
        return true;
    }

    public void updateSpecialIDKeyAndValue(SpecialID specialID, String str) throws JSONException {
        int i11 = AnonymousClass1.$SwitchMap$com$sensorsdata$analytics$android$sdk$useridentity$Identities$SpecialID[specialID.ordinal()];
        if (i11 == 1) {
            this.mIdentities.put(ANONYMOUS_ID, str);
        } else if (i11 == 2) {
            this.mIdentities.put(ANDROID_ID, str);
        } else if (i11 == 3) {
            this.mIdentities.put(ANDROID_UUID, str);
        }
        saveIdentities();
    }
}
