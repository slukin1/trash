package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import org.json.JSONException;
import org.json.JSONObject;

public class DbAdapter {
    private static DbAdapter instance;
    private final DbParams mDbParams;
    private DataOperation mPersistentOperation;
    private DataOperation mTrackEventOperation;

    private DbAdapter(Context context, String str, SensorsDataEncrypt sensorsDataEncrypt) {
        this.mDbParams = DbParams.getInstance(str);
        if (sensorsDataEncrypt != null) {
            this.mTrackEventOperation = new EncryptDataOperation(context.getApplicationContext(), sensorsDataEncrypt);
        } else {
            this.mTrackEventOperation = new EventDataOperation(context.getApplicationContext());
        }
        this.mPersistentOperation = new PersistentDataOperation(context.getApplicationContext());
    }

    public static String decodeIdentities(String str) {
        if (str == null) {
            return null;
        }
        return Base64Coder.decodeString(str.substring(str.indexOf(":") + 1));
    }

    public static DbAdapter getInstance(Context context, String str, SensorsDataEncrypt sensorsDataEncrypt) {
        if (instance == null) {
            instance = new DbAdapter(context, str, sensorsDataEncrypt);
        }
        return instance;
    }

    public void addChannelEvent(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_name", str);
            this.mTrackEventOperation.insertData(this.mDbParams.getChannelPersistentUri(), contentValues);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public int addJSON(JSONObject jSONObject) {
        int insertData = this.mTrackEventOperation.insertData(this.mDbParams.getEventUri(), jSONObject);
        return insertData == 0 ? this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri()) : insertData;
    }

    public int cleanupEvents(String str) {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), str);
        return this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri());
    }

    public void commitActivityCount(int i11) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getActivityStartCountUri(), new JSONObject().put("value", i11));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitAppExitData(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppExitDataUri(), new JSONObject().put("value", str));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitAppStartTime(long j11) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppStartTimeUri(), new JSONObject().put("value", j11));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitIdentities(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getUserIdentities(), new JSONObject().put("value", "Base64:" + Base64Coder.encodeString(str)));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitLoginId(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdUri(), new JSONObject().put("value", str));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitLoginIdKey(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdKeyUri(), new JSONObject().put("value", str));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitPushID(String str, String str2) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getPushIdUri(), new JSONObject().put(DbParams.PUSH_ID_KEY, str).put(DbParams.PUSH_ID_VALUE, str2));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitRemoteConfig(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getRemoteConfigUri(), new JSONObject().put("value", str));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitSessionIntervalTime(int i11) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSessionTimeUri(), new JSONObject().put("value", i11));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void commitSubProcessFlushState(boolean z11) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSubProcessUri(), new JSONObject().put("value", z11));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void deleteAllEvents() {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), DbParams.DB_DELETE_ALL);
    }

    public String[] generateDataString(String str, int i11) {
        try {
            return this.mTrackEventOperation.queryData(this.mDbParams.getEventUri(), i11);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public int getActivityCount() {
        String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getActivityStartCountUri(), 1);
        if (queryData == null || queryData.length <= 0) {
            return 0;
        }
        return Integer.parseInt(queryData[0]);
    }

    public String getAppExitData() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppExitDataUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public long getAppStartTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppStartTimeUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return 0;
            }
            return Long.parseLong(queryData[0]);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return 0;
        }
    }

    public String getIdentities() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getUserIdentities(), 1);
            if (queryData == null || queryData.length <= 0) {
                return null;
            }
            return decodeIdentities(queryData[0]);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public String getLoginId() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public String getLoginIdKey() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdKeyUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public String getPushId(String str) {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getPushIdUri().buildUpon().appendQueryParameter(DbParams.PUSH_ID_KEY, str).build(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public String getRemoteConfig() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getRemoteConfigUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public String getRemoteConfigFromLocal() {
        try {
            PersistentRemoteSDKConfig persistentRemoteSDKConfig = (PersistentRemoteSDKConfig) PersistentLoader.loadPersistent(DbParams.PersistentName.REMOTE_CONFIG);
            if (persistentRemoteSDKConfig == null) {
                return "";
            }
            return (String) persistentRemoteSDKConfig.get();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public int getSessionIntervalTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSessionTimeUri(), 1);
            if (queryData != null && queryData.length > 0) {
                return Integer.parseInt(queryData[0]);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return 0;
    }

    public boolean isFirstChannelEvent(String[] strArr) {
        try {
            return this.mTrackEventOperation.queryDataCount(this.mDbParams.getChannelPersistentUri(), (String[]) null, "event_name = ? or event_name = ? ", strArr, (String) null) <= 0;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public boolean isSubProcessFlushing() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSubProcessUri(), 1);
            if (queryData == null || queryData.length <= 0 || Integer.parseInt(queryData[0]) == 1) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return true;
    }

    public void removePushId(String str) {
        this.mPersistentOperation.deleteData(this.mDbParams.getPushIdUri(), str);
    }

    public static DbAdapter getInstance() {
        DbAdapter dbAdapter = instance;
        if (dbAdapter != null) {
            return dbAdapter;
        }
        throw new IllegalStateException("The static method getInstance(Context context, String packageName) should be called before calling getInstance()");
    }
}
