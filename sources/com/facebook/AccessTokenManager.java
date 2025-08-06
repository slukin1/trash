package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.points.entity.PointsPack;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import s1.a;

public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final a localBroadcastManager;
    /* access modifiers changed from: private */
    public AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    public static class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;
        public String graphDomain;

        private RefreshResult() {
        }
    }

    public AccessTokenManager(a aVar, AccessTokenCache accessTokenCache2) {
        Validate.notNull(aVar, "localBroadcastManager");
        Validate.notNull(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = aVar;
        this.accessTokenCache = accessTokenCache2;
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString(OAuthConstants.PARAM_GRANT_TYPE, "fb_extend_sso_token");
        bundle.putString("client_id", accessToken.getApplicationId());
        return new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, bundle, HttpMethod.GET, callback);
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
        return new GraphRequest(accessToken, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
    }

    public static AccessTokenManager getInstance() {
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                if (instance == null) {
                    instance = new AccessTokenManager(a.b(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
        AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback2 != null) {
                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            AnonymousClass2 r102 = r0;
            final HashSet hashSet4 = hashSet;
            final HashSet hashSet5 = hashSet2;
            HashSet hashSet6 = hashSet2;
            final HashSet hashSet7 = hashSet3;
            AnonymousClass2 r02 = new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                        atomicBoolean2.set(true);
                        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString(AttributionReporter.SYSTEM_PERMISSION);
                                String optString2 = optJSONObject.optString("status");
                                if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                    String lowerCase = optString2.toLowerCase(Locale.US);
                                    if (lowerCase.equals("granted")) {
                                        hashSet4.add(optString);
                                    } else if (lowerCase.equals("declined")) {
                                        hashSet5.add(optString);
                                    } else if (lowerCase.equals(PointsPack.STATE_EXPIRED)) {
                                        hashSet7.add(optString);
                                    } else {
                                        Log.w(AccessTokenManager.TAG, "Unexpected status: " + lowerCase);
                                    }
                                }
                            }
                        }
                    }
                }
            };
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, r102), createExtendAccessTokenRequest(accessToken, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null) {
                        refreshResult.accessToken = jSONObject.optString("access_token");
                        refreshResult.expiresAt = jSONObject.optInt(SettingsJsonConstants.EXPIRES_AT_KEY);
                        refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
                        refreshResult.graphDomain = jSONObject.optString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN, (String) null);
                    }
                }
            }));
            final AccessToken accessToken2 = accessToken;
            final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback3 = accessTokenRefreshCallback;
            final AtomicBoolean atomicBoolean3 = atomicBoolean;
            final RefreshResult refreshResult2 = refreshResult;
            final HashSet hashSet8 = hashSet;
            final HashSet hashSet9 = hashSet6;
            final HashSet hashSet10 = hashSet3;
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x0108=Splitter:B:50:0x0108, B:18:0x004d=Splitter:B:18:0x004d} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onBatchCompleted(com.facebook.GraphRequestBatch r19) {
                    /*
                        r18 = this;
                        r1 = r18
                        r2 = 0
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessToken r0 = r0.getCurrentAccessToken()     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0108
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessToken r0 = r0.getCurrentAccessToken()     // Catch:{ all -> 0x0120 }
                        java.lang.String r0 = r0.getUserId()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessToken r4 = r2     // Catch:{ all -> 0x0120 }
                        java.lang.String r4 = r4.getUserId()     // Catch:{ all -> 0x0120 }
                        if (r0 == r4) goto L_0x0023
                        goto L_0x0108
                    L_0x0023:
                        java.util.concurrent.atomic.AtomicBoolean r0 = r4     // Catch:{ all -> 0x0120 }
                        boolean r0 = r0.get()     // Catch:{ all -> 0x0120 }
                        if (r0 != 0) goto L_0x004d
                        com.facebook.AccessTokenManager$RefreshResult r0 = r5     // Catch:{ all -> 0x0120 }
                        java.lang.String r4 = r0.accessToken     // Catch:{ all -> 0x0120 }
                        if (r4 != 0) goto L_0x004d
                        int r0 = r0.expiresAt     // Catch:{ all -> 0x0120 }
                        if (r0 != 0) goto L_0x004d
                        com.facebook.AccessToken$AccessTokenRefreshCallback r0 = r3     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0043
                        com.facebook.FacebookException r4 = new com.facebook.FacebookException     // Catch:{ all -> 0x0120 }
                        java.lang.String r5 = "Failed to refresh access token"
                        r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x0120 }
                        r0.OnTokenRefreshFailed(r4)     // Catch:{ all -> 0x0120 }
                    L_0x0043:
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r2)
                        return
                    L_0x004d:
                        com.facebook.AccessToken r15 = new com.facebook.AccessToken     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager$RefreshResult r0 = r5     // Catch:{ all -> 0x0120 }
                        java.lang.String r0 = r0.accessToken     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0056
                        goto L_0x005c
                    L_0x0056:
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.lang.String r0 = r0.getToken()     // Catch:{ all -> 0x0120 }
                    L_0x005c:
                        r5 = r0
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.lang.String r6 = r0.getApplicationId()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.lang.String r7 = r0.getUserId()     // Catch:{ all -> 0x0120 }
                        java.util.concurrent.atomic.AtomicBoolean r0 = r4     // Catch:{ all -> 0x0120 }
                        boolean r0 = r0.get()     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0074
                        java.util.Set r0 = r6     // Catch:{ all -> 0x0120 }
                        goto L_0x007a
                    L_0x0074:
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.util.Set r0 = r0.getPermissions()     // Catch:{ all -> 0x0120 }
                    L_0x007a:
                        r8 = r0
                        java.util.concurrent.atomic.AtomicBoolean r0 = r4     // Catch:{ all -> 0x0120 }
                        boolean r0 = r0.get()     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0086
                        java.util.Set r0 = r7     // Catch:{ all -> 0x0120 }
                        goto L_0x008c
                    L_0x0086:
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.util.Set r0 = r0.getDeclinedPermissions()     // Catch:{ all -> 0x0120 }
                    L_0x008c:
                        r9 = r0
                        java.util.concurrent.atomic.AtomicBoolean r0 = r4     // Catch:{ all -> 0x0120 }
                        boolean r0 = r0.get()     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0098
                        java.util.Set r0 = r8     // Catch:{ all -> 0x0120 }
                        goto L_0x009e
                    L_0x0098:
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.util.Set r0 = r0.getExpiredPermissions()     // Catch:{ all -> 0x0120 }
                    L_0x009e:
                        r10 = r0
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenSource r11 = r0.getSource()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager$RefreshResult r0 = r5     // Catch:{ all -> 0x0120 }
                        int r0 = r0.expiresAt     // Catch:{ all -> 0x0120 }
                        r12 = 1000(0x3e8, double:4.94E-321)
                        if (r0 == 0) goto L_0x00b9
                        java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager$RefreshResult r4 = r5     // Catch:{ all -> 0x0120 }
                        int r4 = r4.expiresAt     // Catch:{ all -> 0x0120 }
                        long r3 = (long) r4     // Catch:{ all -> 0x0120 }
                        long r3 = r3 * r12
                        r0.<init>(r3)     // Catch:{ all -> 0x0120 }
                        goto L_0x00bf
                    L_0x00b9:
                        com.facebook.AccessToken r0 = r2     // Catch:{ all -> 0x0120 }
                        java.util.Date r0 = r0.getExpires()     // Catch:{ all -> 0x0120 }
                    L_0x00bf:
                        java.util.Date r3 = new java.util.Date     // Catch:{ all -> 0x0120 }
                        r3.<init>()     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager$RefreshResult r4 = r5     // Catch:{ all -> 0x0120 }
                        java.lang.Long r4 = r4.dataAccessExpirationTime     // Catch:{ all -> 0x0120 }
                        if (r4 == 0) goto L_0x00da
                        java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager$RefreshResult r14 = r5     // Catch:{ all -> 0x0120 }
                        java.lang.Long r14 = r14.dataAccessExpirationTime     // Catch:{ all -> 0x0120 }
                        long r16 = r14.longValue()     // Catch:{ all -> 0x0120 }
                        long r12 = r12 * r16
                        r4.<init>(r12)     // Catch:{ all -> 0x0120 }
                        goto L_0x00e0
                    L_0x00da:
                        com.facebook.AccessToken r4 = r2     // Catch:{ all -> 0x0120 }
                        java.util.Date r4 = r4.getDataAccessExpirationTime()     // Catch:{ all -> 0x0120 }
                    L_0x00e0:
                        r14 = r4
                        com.facebook.AccessTokenManager$RefreshResult r4 = r5     // Catch:{ all -> 0x0120 }
                        java.lang.String r13 = r4.graphDomain     // Catch:{ all -> 0x0120 }
                        r4 = r15
                        r12 = r0
                        r0 = r13
                        r13 = r3
                        r3 = r15
                        r15 = r0
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0120 }
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.getInstance()     // Catch:{ all -> 0x0106 }
                        r0.setCurrentAccessToken(r3)     // Catch:{ all -> 0x0106 }
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r2)
                        com.facebook.AccessToken$AccessTokenRefreshCallback r0 = r3
                        if (r0 == 0) goto L_0x0105
                        r0.OnTokenRefreshed(r3)
                    L_0x0105:
                        return
                    L_0x0106:
                        r0 = move-exception
                        goto L_0x0122
                    L_0x0108:
                        com.facebook.AccessToken$AccessTokenRefreshCallback r0 = r3     // Catch:{ all -> 0x0120 }
                        if (r0 == 0) goto L_0x0116
                        com.facebook.FacebookException r3 = new com.facebook.FacebookException     // Catch:{ all -> 0x0120 }
                        java.lang.String r4 = "No current access token to refresh"
                        r3.<init>((java.lang.String) r4)     // Catch:{ all -> 0x0120 }
                        r0.OnTokenRefreshFailed(r3)     // Catch:{ all -> 0x0120 }
                    L_0x0116:
                        com.facebook.AccessTokenManager r0 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r0 = r0.tokenRefreshInProgress
                        r0.set(r2)
                        return
                    L_0x0120:
                        r0 = move-exception
                        r3 = 0
                    L_0x0122:
                        com.facebook.AccessTokenManager r4 = com.facebook.AccessTokenManager.this
                        java.util.concurrent.atomic.AtomicBoolean r4 = r4.tokenRefreshInProgress
                        r4.set(r2)
                        com.facebook.AccessToken$AccessTokenRefreshCallback r2 = r3
                        if (r2 == 0) goto L_0x0134
                        if (r3 == 0) goto L_0x0134
                        r2.OnTokenRefreshed(r3)
                    L_0x0134:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenManager.AnonymousClass4.onBatchCompleted(com.facebook.GraphRequestBatch):void");
                }
            });
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback2 != null) {
            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.d(intent);
    }

    private void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken2 = AccessToken.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (AccessToken.isCurrentAccessTokenActive() && currentAccessToken2.getExpires() != null && alarmManager != null) {
            Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
            PushAutoTrackHelper.hookIntentGetBroadcast(applicationContext, 0, intent, 0);
            PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 0, intent, 0);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, applicationContext, 0, intent, 0);
            try {
                alarmManager.set(1, currentAccessToken2.getExpires().getTime(), broadcast);
            } catch (Exception unused) {
            }
        }
    }

    private boolean shouldExtendAccessToken() {
        if (this.currentAccessToken == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.currentAccessToken.getSource().canExtendToken() || valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() <= Period.MIN60_MILLS || valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() <= Period.DAY_MILLS) {
            return false;
        }
        return true;
    }

    public void currentAccessTokenChanged() {
        AccessToken accessToken = this.currentAccessToken;
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken, accessToken);
    }

    public void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken((AccessToken.AccessTokenRefreshCallback) null);
        }
    }

    public AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    public boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    AccessTokenManager.this.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
                }
            });
        }
    }

    public void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z11) {
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z11) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }
}
