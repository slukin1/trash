package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class HeartBeatInfoStorage {
    private static final String GLOBAL = "fire-global";
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String LAST_STORED_DATE = "last-used-date";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseSharedPreferences = context.getSharedPreferences(HEARTBEAT_PREFERENCES_NAME + str, 0);
    }

    private synchronized void cleanUpStoredHeartBeats() {
        long j11 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0);
        String str = null;
        String str2 = "";
        for (Map.Entry next : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String str3 : (Set) next.getValue()) {
                    if (str == null || str.compareTo(str3) > 0) {
                        str2 = (String) next.getKey();
                        str = str3;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str2, new HashSet()));
        hashSet.remove(str);
        this.firebaseSharedPreferences.edit().putStringSet(str2, hashSet).putLong(HEART_BEAT_COUNT_TAG, j11 - 1).commit();
    }

    private synchronized String getFormattedDate(long j11) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j11).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j11));
    }

    private synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry next : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return (String) next.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void removeStoredDate(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.getStoredUserAgentString(r5)     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences r2 = r4.firebaseSharedPreferences     // Catch:{ all -> 0x003f }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x003f }
            r3.<init>()     // Catch:{ all -> 0x003f }
            java.util.Set r2 = r2.getStringSet(r0, r3)     // Catch:{ all -> 0x003f }
            r1.<init>(r2)     // Catch:{ all -> 0x003f }
            r1.remove(r5)     // Catch:{ all -> 0x003f }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x0030
            android.content.SharedPreferences r5 = r4.firebaseSharedPreferences     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences$Editor r5 = r5.remove(r0)     // Catch:{ all -> 0x003f }
            r5.commit()     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0030:
            android.content.SharedPreferences r5 = r4.firebaseSharedPreferences     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x003f }
            android.content.SharedPreferences$Editor r5 = r5.putStringSet(r0, r1)     // Catch:{ all -> 0x003f }
            r5.commit()     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r4)
            return
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.HeartBeatInfoStorage.removeStoredDate(java.lang.String):void");
    }

    private synchronized void updateStoredUserAgent(String str, String str2) {
        removeStoredDate(str2);
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).commit();
    }

    public synchronized void deleteAllHeartBeats() {
        SharedPreferences.Editor edit = this.firebaseSharedPreferences.edit();
        int i11 = 0;
        for (Map.Entry next : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                String formattedDate = getFormattedDate(System.currentTimeMillis());
                String str = (String) next.getKey();
                if (((Set) next.getValue()).contains(formattedDate)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(formattedDate);
                    i11++;
                    edit.putStringSet(str, hashSet);
                } else {
                    edit.remove(str);
                }
            }
        }
        if (i11 == 0) {
            edit.remove(HEART_BEAT_COUNT_TAG);
        } else {
            edit.putLong(HEART_BEAT_COUNT_TAG, (long) i11);
        }
        edit.commit();
    }

    public synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry next : this.firebaseSharedPreferences.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) next.getValue());
                hashSet.remove(getFormattedDate(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(HeartBeatResult.create((String) next.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        updateGlobalHeartBeat(System.currentTimeMillis());
        return arrayList;
    }

    public int getHeartBeatCount() {
        return (int) this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0);
    }

    public synchronized long getLastGlobalHeartBeat() {
        return this.firebaseSharedPreferences.getLong(GLOBAL, -1);
    }

    public synchronized boolean isSameDateUtc(long j11, long j12) {
        return getFormattedDate(j11).equals(getFormattedDate(j12));
    }

    public synchronized void postHeartBeatCleanUp() {
        String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseSharedPreferences.edit().putString(LAST_STORED_DATE, formattedDate).commit();
        removeStoredDate(formattedDate);
    }

    public synchronized boolean shouldSendGlobalHeartBeat(long j11) {
        return shouldSendSdkHeartBeat(GLOBAL, j11);
    }

    public synchronized boolean shouldSendSdkHeartBeat(String str, long j11) {
        if (!this.firebaseSharedPreferences.contains(str)) {
            this.firebaseSharedPreferences.edit().putLong(str, j11).commit();
            return true;
        } else if (isSameDateUtc(this.firebaseSharedPreferences.getLong(str, -1), j11)) {
            return false;
        } else {
            this.firebaseSharedPreferences.edit().putLong(str, j11).commit();
            return true;
        }
    }

    public synchronized void storeHeartBeat(long j11, String str) {
        String formattedDate = getFormattedDate(j11);
        if (this.firebaseSharedPreferences.getString(LAST_STORED_DATE, "").equals(formattedDate)) {
            String storedUserAgentString = getStoredUserAgentString(formattedDate);
            if (storedUserAgentString != null) {
                if (!storedUserAgentString.equals(str)) {
                    updateStoredUserAgent(str, formattedDate);
                    return;
                }
                return;
            }
            return;
        }
        long j12 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0);
        if (j12 + 1 == 30) {
            cleanUpStoredHeartBeats();
            j12 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0);
        }
        HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
        hashSet.add(formattedDate);
        this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong(HEART_BEAT_COUNT_TAG, j12 + 1).putString(LAST_STORED_DATE, formattedDate).commit();
    }

    public synchronized void updateGlobalHeartBeat(long j11) {
        this.firebaseSharedPreferences.edit().putLong(GLOBAL, j11).commit();
    }

    public HeartBeatInfoStorage(SharedPreferences sharedPreferences) {
        this.firebaseSharedPreferences = sharedPreferences;
    }
}
