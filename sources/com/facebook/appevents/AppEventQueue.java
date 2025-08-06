package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s1.a;

class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG = "com.facebook.appevents.AppEventQueue";
    /* access modifiers changed from: private */
    public static volatile AppEventCollection appEventCollection = new AppEventCollection();
    /* access modifiers changed from: private */
    public static final Runnable flushRunnable = new Runnable() {
        public void run() {
            ScheduledFuture unused = AppEventQueue.scheduledFuture = null;
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flushAndWait(FlushReason.TIMER);
            }
        }
    };
    /* access modifiers changed from: private */
    public static ScheduledFuture scheduledFuture;
    /* access modifiers changed from: private */
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    public static void add(final AccessTokenAppIdPair accessTokenAppIdPair, final AppEvent appEvent) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair, appEvent);
                if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && AppEventQueue.appEventCollection.getEventCount() > 100) {
                    AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                } else if (AppEventQueue.scheduledFuture == null) {
                    ScheduledFuture unused = AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15, TimeUnit.SECONDS);
                }
            }
        });
    }

    private static GraphRequest buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, boolean z11, final FlushStatistics flushStatistics) {
        String applicationId = accessTokenAppIdPair.getApplicationId();
        boolean z12 = false;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        final GraphRequest newPostRequest = GraphRequest.newPostRequest((AccessToken) null, String.format("%s/activities", new Object[]{applicationId}), (JSONObject) null, (GraphRequest.Callback) null);
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessTokenString());
        String pushNotificationsRegistrationId = InternalAppEventsLogger.getPushNotificationsRegistrationId();
        if (pushNotificationsRegistrationId != null) {
            parameters.putString(RemoteMessageConst.DEVICE_TOKEN, pushNotificationsRegistrationId);
        }
        String installReferrer = AppEventsLoggerImpl.getInstallReferrer();
        if (installReferrer != null) {
            parameters.putString(Constants.INSTALL_REFERRER, installReferrer);
        }
        newPostRequest.setParameters(parameters);
        if (queryAppSettings != null) {
            z12 = queryAppSettings.supportsImplicitLogging();
        }
        int populateRequest = sessionEventsState.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), z12, z11);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents += populateRequest;
        newPostRequest.setCallback(new GraphRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                AppEventQueue.handleResponse(accessTokenAppIdPair, newPostRequest, graphResponse, sessionEventsState, flushStatistics);
            }
        });
        return newPostRequest;
    }

    public static void flush(final FlushReason flushReason) {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                AppEventQueue.flushAndWait(flushReason);
            }
        });
    }

    public static void flushAndWait(FlushReason flushReason) {
        appEventCollection.addPersistedEvents(AppEventStore.readAndClearStore());
        try {
            FlushStatistics sendEventsToServer = sendEventsToServer(flushReason, appEventCollection);
            if (sendEventsToServer != null) {
                Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.numEvents);
                intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.result);
                a.b(FacebookSdk.getApplicationContext()).d(intent);
            }
        } catch (Exception e11) {
            Log.w(TAG, "Caught unexpected exception while flushing app events: ", e11);
        }
    }

    public static Set<AccessTokenAppIdPair> getKeySet() {
        return appEventCollection.keySet();
    }

    /* access modifiers changed from: private */
    public static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, GraphResponse graphResponse, final SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        String str;
        String str2;
        FacebookRequestError error = graphResponse.getError();
        FlushResult flushResult = FlushResult.SUCCESS;
        boolean z11 = true;
        if (error == null) {
            str = "Success";
        } else if (error.getErrorCode() == -1) {
            flushResult = FlushResult.NO_CONNECTIVITY;
            str = "Failed: No Connectivity";
        } else {
            str = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{graphResponse.toString(), error.toString()});
            flushResult = FlushResult.SERVER_ERROR;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
            try {
                str2 = new JSONArray((String) graphRequest.getTag()).toString(2);
            } catch (JSONException unused) {
                str2 = "<Can't encode events for debug logging>";
            }
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", graphRequest.getGraphObject().toString(), str, str2);
        }
        if (error == null) {
            z11 = false;
        }
        sessionEventsState.clearInFlightAndStats(z11);
        FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
        if (flushResult == flushResult2) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    AppEventStore.persistEvents(accessTokenAppIdPair, sessionEventsState);
                }
            });
        }
        if (flushResult != FlushResult.SUCCESS && flushStatistics.result != flushResult2) {
            flushStatistics.result = flushResult;
        }
    }

    public static void persistToDisk() {
        singleThreadExecutor.execute(new Runnable() {
            public void run() {
                AppEventStore.persistEvents(AppEventQueue.appEventCollection);
                AppEventCollection unused = AppEventQueue.appEventCollection = new AppEventCollection();
            }
        });
    }

    private static FlushStatistics sendEventsToServer(FlushReason flushReason, AppEventCollection appEventCollection2) {
        FlushStatistics flushStatistics = new FlushStatistics();
        boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
        ArrayList<GraphRequest> arrayList = new ArrayList<>();
        for (AccessTokenAppIdPair next : appEventCollection2.keySet()) {
            GraphRequest buildRequestForSession = buildRequestForSession(next, appEventCollection2.get(next), limitEventAndDataUsage, flushStatistics);
            if (buildRequestForSession != null) {
                arrayList.add(buildRequestForSession);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.numEvents), flushReason.toString());
        for (GraphRequest executeAndWait : arrayList) {
            executeAndWait.executeAndWait();
        }
        return flushStatistics;
    }
}
