package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;

class SessionInfo {
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    public SessionInfo(Long l11, Long l12) {
        this(l11, l12, UUID.randomUUID());
    }

    public static void clearSavedSessionFromDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove(LAST_SESSION_INFO_START_KEY);
        edit.remove(LAST_SESSION_INFO_END_KEY);
        edit.remove(INTERRUPTION_COUNT_KEY);
        edit.remove(SESSION_ID_KEY);
        edit.apply();
        SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
    }

    public static SessionInfo getStoredSessionInfo() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        long j11 = defaultSharedPreferences.getLong(LAST_SESSION_INFO_START_KEY, 0);
        long j12 = defaultSharedPreferences.getLong(LAST_SESSION_INFO_END_KEY, 0);
        String string = defaultSharedPreferences.getString(SESSION_ID_KEY, (String) null);
        if (j11 == 0 || j12 == 0 || string == null) {
            return null;
        }
        SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j11), Long.valueOf(j12));
        sessionInfo.interruptionCount = defaultSharedPreferences.getInt(INTERRUPTION_COUNT_KEY, 0);
        sessionInfo.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
        sessionInfo.diskRestoreTime = Long.valueOf(System.currentTimeMillis());
        sessionInfo.sessionId = UUID.fromString(string);
        return sessionInfo;
    }

    public long getDiskRestoreTime() {
        Long l11 = this.diskRestoreTime;
        if (l11 == null) {
            return 0;
        }
        return l11.longValue();
    }

    public int getInterruptionCount() {
        return this.interruptionCount;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public long getSessionLength() {
        Long l11;
        if (this.sessionStartTime == null || (l11 = this.sessionLastEventTime) == null) {
            return 0;
        }
        return l11.longValue() - this.sessionStartTime.longValue();
    }

    public Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public void setSessionLastEventTime(Long l11) {
        this.sessionLastEventTime = l11;
    }

    public void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo2) {
        this.sourceApplicationInfo = sourceApplicationInfo2;
    }

    public void writeSessionToDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putLong(LAST_SESSION_INFO_START_KEY, this.sessionStartTime.longValue());
        edit.putLong(LAST_SESSION_INFO_END_KEY, this.sessionLastEventTime.longValue());
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo2 = this.sourceApplicationInfo;
        if (sourceApplicationInfo2 != null) {
            sourceApplicationInfo2.writeSourceApplicationInfoToDisk();
        }
    }

    public SessionInfo(Long l11, Long l12, UUID uuid) {
        this.sessionStartTime = l11;
        this.sessionLastEventTime = l12;
        this.sessionId = uuid;
    }
}
