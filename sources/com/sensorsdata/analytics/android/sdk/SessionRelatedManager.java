package com.sensorsdata.analytics.android.sdk;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionRelatedManager {
    private static volatile SessionRelatedManager mSessionRelatedManager;
    public final String EVENT_SESSION_ID = "$event_session_id";
    private final String KEY_LAST_EVENT_TIME = "lastEventTime";
    private final String KEY_SESSION_ID = "sessionID";
    private final String KEY_START_TIME = "startTime";
    private long SESSION_LAST_INTERVAL_TIME = 300000;
    private final long SESSION_START_INTERVAL_TIME = 43200000;
    private final String SHARED_PREF_SESSION_CUTDATA = "sensorsdata.session.cutdata";
    private long mLastEventTime;
    private String mSessionID;
    private long mStartTime;

    private SessionRelatedManager() {
        try {
            setSessionLastIntervalTime(AbstractSensorsDataAPI.getConfigOptions().getEventSessionTimeout());
            if (!AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                deleteSessionData();
            } else {
                readSessionData();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private synchronized void createSessionData(long j11, boolean z11) {
        this.mSessionID = UUID.randomUUID().toString();
        if (z11) {
            this.mStartTime = j11;
        }
        this.mLastEventTime = Math.max(j11, this.mLastEventTime);
        SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
    }

    private void deleteSessionData() {
        this.mSessionID = null;
        this.mStartTime = -1;
        this.mLastEventTime = -1;
        SAStoreManager.getInstance().remove("sensorsdata.session.cutdata");
    }

    public static SessionRelatedManager getInstance() {
        if (mSessionRelatedManager == null) {
            synchronized (SessionRelatedManager.class) {
                if (mSessionRelatedManager == null) {
                    mSessionRelatedManager = new SessionRelatedManager();
                }
            }
        }
        return mSessionRelatedManager;
    }

    private String getSessionDataPack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionID", this.mSessionID);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("lastEventTime", this.mLastEventTime);
            return jSONObject.toString();
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void handleSessionState(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.lang.String r0 = r4.mSessionID     // Catch:{ all -> 0x0031 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x002b
            long r0 = r4.mLastEventTime     // Catch:{ all -> 0x0031 }
            long r0 = r5 - r0
            long r2 = r4.SESSION_LAST_INTERVAL_TIME     // Catch:{ all -> 0x0031 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002b
            long r0 = r4.mStartTime     // Catch:{ all -> 0x0031 }
            long r0 = r5 - r0
            r2 = 43200000(0x2932e00, double:2.1343636E-316)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            r4.updateSessionLastTime(r5)     // Catch:{ all -> 0x0031 }
            goto L_0x002f
        L_0x002b:
            r0 = 1
            r4.createSessionData(r5, r0)     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r4)
            return
        L_0x0031:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SessionRelatedManager.handleSessionState(long):void");
    }

    private void readSessionData() {
        String string = SAStoreManager.getInstance().getString("sensorsdata.session.cutdata", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("sessionID")) {
                    this.mSessionID = jSONObject.optString("sessionID");
                }
                if (jSONObject.has("startTime")) {
                    this.mStartTime = jSONObject.optLong("startTime");
                }
                if (jSONObject.has("lastEventTime")) {
                    this.mLastEventTime = jSONObject.optLong("lastEventTime");
                }
            } catch (JSONException e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    private void setSessionLastIntervalTime(int i11) {
        if (i11 > 0) {
            this.SESSION_LAST_INTERVAL_TIME = ((long) i11) * 1000;
        }
    }

    private void updateSessionLastTime(long j11) {
        this.mLastEventTime = j11;
        SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
    }

    public String getSessionID() {
        return this.mSessionID;
    }

    public void handleEventOfSession(String str, JSONObject jSONObject, long j11) {
        if (AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
            try {
                if (!"$AppEnd".equals(str)) {
                    handleSessionState(j11);
                    jSONObject.put("$event_session_id", this.mSessionID);
                } else if (j11 > this.mLastEventTime) {
                    this.mLastEventTime = j11;
                }
            } catch (JSONException e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void refreshSessionByTimer(long j11) {
        if (j11 - this.mLastEventTime > this.SESSION_LAST_INTERVAL_TIME) {
            createSessionData(j11, TextUtils.isEmpty(this.mSessionID));
        }
    }
}
